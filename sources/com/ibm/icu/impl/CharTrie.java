package com.ibm.icu.impl;

import defpackage.dk0;
import defpackage.og;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CharTrie extends Trie {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private char[] m_data_;
    private char m_initialValue_;

    public CharTrie(int i, int i2, Trie.DataManipulate dataManipulate) {
        super(new char[2080], 512, dataManipulate);
        int i3 = i2 != i ? 288 : 256;
        this.m_data_ = new char[i3];
        this.m_dataLength_ = i3;
        char c = (char) i;
        this.m_initialValue_ = c;
        for (int i4 = 0; i4 < 256; i4++) {
            this.m_data_[i4] = c;
        }
        if (i2 != i) {
            for (int i5 = 1728; i5 < 1760; i5++) {
                this.m_index_[i5] = '@';
            }
            for (int i6 = 256; i6 < 288; i6++) {
                this.m_data_[i6] = (char) i2;
            }
        }
    }

    @Override // com.ibm.icu.impl.Trie
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof CharTrie) && this.m_initialValue_ == ((CharTrie) obj).m_initialValue_;
    }

    public final char getBMPValue(char c) {
        return this.m_data_[getBMPOffset(c)];
    }

    public final char getCodePointValue(int i) {
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

    public final char getLatin1LinearValue(char c) {
        return this.m_data_[this.m_dataOffset_ + 32 + c];
    }

    public final char getLeadValue(char c) {
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

    public final char getSurrogateValue(char c, char c2) {
        int surrogateOffset = getSurrogateOffset(c, c2);
        return surrogateOffset > 0 ? this.m_data_[surrogateOffset] : this.m_initialValue_;
    }

    public final char getTrailValue(int i, char c) {
        Trie.DataManipulate dataManipulate = this.m_dataManipulate_;
        if (dataManipulate != null) {
            int foldingOffset = dataManipulate.getFoldingOffset(i);
            return foldingOffset > 0 ? this.m_data_[getRawOffset(foldingOffset, (char) (c & 1023))] : this.m_initialValue_;
        }
        dk0.n("The field DataManipulate in this Trie is null");
        return (char) 0;
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
        char[] chars = ICUBinary.getChars(byteBuffer, this.m_dataOffset_ + this.m_dataLength_, 0);
        this.m_index_ = chars;
        this.m_data_ = chars;
        this.m_initialValue_ = chars[this.m_dataOffset_];
    }

    public CharTrie(ByteBuffer byteBuffer, Trie.DataManipulate dataManipulate) {
        super(byteBuffer, dataManipulate);
        if (isCharTrie()) {
            return;
        }
        og.i("Data given does not belong to a char trie.");
        throw null;
    }
}
