package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import defpackage.dk0;
import defpackage.og;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IntTrie extends Trie {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int[] m_data_;
    private int m_initialValue_;

    public IntTrie(int i, int i2, Trie.DataManipulate dataManipulate) {
        super(new char[2080], 512, dataManipulate);
        int i3 = i2 != i ? 288 : 256;
        this.m_data_ = new int[i3];
        this.m_dataLength_ = i3;
        this.m_initialValue_ = i;
        for (int i4 = 0; i4 < 256; i4++) {
            this.m_data_[i4] = i;
        }
        if (i2 != i) {
            for (int i5 = 1728; i5 < 1760; i5++) {
                this.m_index_[i5] = '@';
            }
            for (int i6 = 256; i6 < 288; i6++) {
                this.m_data_[i6] = i2;
            }
        }
    }

    @Override // com.ibm.icu.impl.Trie
    public boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof IntTrie)) {
            IntTrie intTrie = (IntTrie) obj;
            if (this.m_initialValue_ == intTrie.m_initialValue_ && Arrays.equals(this.m_data_, intTrie.m_data_)) {
                return true;
            }
        }
        return false;
    }

    public final int getBMPValue(char c) {
        return this.m_data_[getBMPOffset(c)];
    }

    public final int getCodePointValue(int i) {
        if (i >= 0 && i < 55296) {
            return this.m_data_[(this.m_index_[i >> 5] << 2) + (i & 31)];
        }
        int codePointOffset = getCodePointOffset(i);
        return codePointOffset >= 0 ? this.m_data_[codePointOffset] : this.m_initialValue_;
    }

    @Override // com.ibm.icu.impl.Trie
    public final int getInitialValue() {
        return this.m_initialValue_;
    }

    public final int getLatin1LinearValue(char c) {
        return this.m_data_[c + ' '];
    }

    public final int getLeadValue(char c) {
        return this.m_data_[getLeadOffset(c)];
    }

    @Override // com.ibm.icu.impl.Trie
    public final int getSurrogateOffset(char c, char c2) {
        Trie.DataManipulate dataManipulate = this.m_dataManipulate_;
        if (dataManipulate == null) {
            dk0.n("The field DataManipulate in this Trie is null");
            return 0;
        }
        int foldingOffset = dataManipulate.getFoldingOffset(getLeadValue(c));
        if (foldingOffset > 0) {
            return getRawOffset(foldingOffset, (char) (c2 & 1023));
        }
        return -1;
    }

    public final int getSurrogateValue(char c, char c2) {
        if (UTF16.isLeadSurrogate(c) && UTF16.isTrailSurrogate(c2)) {
            int surrogateOffset = getSurrogateOffset(c, c2);
            return surrogateOffset > 0 ? this.m_data_[surrogateOffset] : this.m_initialValue_;
        }
        og.i("Argument characters do not form a supplementary character");
        return 0;
    }

    public final int getTrailValue(int i, char c) {
        Trie.DataManipulate dataManipulate = this.m_dataManipulate_;
        if (dataManipulate != null) {
            int foldingOffset = dataManipulate.getFoldingOffset(i);
            return foldingOffset > 0 ? this.m_data_[getRawOffset(foldingOffset, (char) (c & 1023))] : this.m_initialValue_;
        }
        dk0.n("The field DataManipulate in this Trie is null");
        return 0;
    }

    @Override // com.ibm.icu.impl.Trie
    public final int getValue(int i) {
        return this.m_data_[i];
    }

    @Override // com.ibm.icu.impl.Trie
    public int hashCode() {
        return 42;
    }

    @Override // com.ibm.icu.impl.Trie
    public final void unserialize(ByteBuffer byteBuffer) {
        super.unserialize(byteBuffer);
        int[] ints = ICUBinary.getInts(byteBuffer, this.m_dataLength_, 0);
        this.m_data_ = ints;
        this.m_initialValue_ = ints[0];
    }

    public IntTrie(ByteBuffer byteBuffer, Trie.DataManipulate dataManipulate) {
        super(byteBuffer, dataManipulate);
        if (isIntTrie()) {
            return;
        }
        og.i("Data given does not belong to a int trie.");
        throw null;
    }

    public IntTrie(char[] cArr, int[] iArr, int i, int i2, Trie.DataManipulate dataManipulate) {
        super(cArr, i2, dataManipulate);
        this.m_data_ = iArr;
        this.m_dataLength_ = iArr.length;
        this.m_initialValue_ = i;
    }
}
