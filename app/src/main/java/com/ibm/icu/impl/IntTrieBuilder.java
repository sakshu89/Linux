package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.UTF16;
import defpackage.og;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IntTrieBuilder extends TrieBuilder {
    protected int[] m_data_;
    protected int m_initialValue_;
    private int m_leadUnitValue_;

    public IntTrieBuilder(int[] iArr, int i, int i2, int i3, boolean z) {
        int i4 = 32;
        if (i < 32 || (z && i < 1024)) {
            og.i("Argument maxdatalength is too small");
            throw null;
        }
        if (iArr != null) {
            this.m_data_ = iArr;
        } else {
            this.m_data_ = new int[i];
        }
        if (z) {
            int i5 = 0;
            int i6 = 32;
            while (true) {
                int i7 = i5 + 1;
                this.m_index_[i5] = i6;
                i6 += 32;
                if (i7 >= 8) {
                    break;
                } else {
                    i5 = i7;
                }
            }
            i4 = i6;
        }
        this.m_dataLength_ = i4;
        Arrays.fill(this.m_data_, 0, i4, i2);
        this.m_initialValue_ = i2;
        this.m_leadUnitValue_ = i3;
        this.m_dataCapacity_ = i;
        this.m_isLatin1Linear_ = z;
        this.m_isCompacted_ = false;
    }

    private int allocDataBlock() {
        int i = this.m_dataLength_;
        int i2 = i + 32;
        if (i2 > this.m_dataCapacity_) {
            return -1;
        }
        this.m_dataLength_ = i2;
        return i;
    }

    private void compact(boolean z) {
        int i;
        if (this.m_isCompacted_) {
            return;
        }
        findUnusedBlocks();
        int i2 = this.m_isLatin1Linear_ ? UCharacter.UnicodeBlock.MAYAN_NUMERALS_ID : 32;
        int i3 = 32;
        int i4 = 32;
        while (true) {
            i = 0;
            if (i3 >= this.m_dataLength_) {
                break;
            }
            int i5 = i3 >>> 5;
            if (this.m_map_[i5] >= 0) {
                if (i3 >= i2) {
                    int iFindSameDataBlock = findSameDataBlock(this.m_data_, i4, i3, z ? 4 : 32);
                    if (iFindSameDataBlock >= 0) {
                        this.m_map_[i5] = iFindSameDataBlock;
                    }
                }
                if (z && i3 >= i2) {
                    i = 28;
                    while (i > 0 && !TrieBuilder.equal_int(this.m_data_, i4 - i, i3, i)) {
                        i -= 4;
                    }
                }
                if (i > 0) {
                    this.m_map_[i5] = i4 - i;
                    i3 += i;
                    int i6 = 32 - i;
                    while (i6 > 0) {
                        int[] iArr = this.m_data_;
                        iArr[i4] = iArr[i3];
                        i6--;
                        i4++;
                        i3++;
                    }
                } else {
                    int[] iArr2 = this.m_map_;
                    if (i4 < i3) {
                        iArr2[i5] = i4;
                        int i7 = 32;
                        while (i7 > 0) {
                            int[] iArr3 = this.m_data_;
                            iArr3[i4] = iArr3[i3];
                            i7--;
                            i4++;
                            i3++;
                        }
                    } else {
                        iArr2[i5] = i3;
                        i4 += 32;
                        i3 = i4;
                    }
                }
            }
            i3 += 32;
        }
        while (i < this.m_indexLength_) {
            int[] iArr4 = this.m_index_;
            iArr4[i] = this.m_map_[Math.abs(iArr4[i]) >>> 5];
            i++;
        }
        this.m_dataLength_ = i4;
    }

    private void fillBlock(int i, int i2, int i3, int i4, boolean z) {
        int i5 = i3 + i;
        int i6 = i + i2;
        if (z) {
            while (i6 < i5) {
                this.m_data_[i6] = i4;
                i6++;
            }
        } else {
            while (i6 < i5) {
                int[] iArr = this.m_data_;
                if (iArr[i6] == this.m_initialValue_) {
                    iArr[i6] = i4;
                }
                i6++;
            }
        }
    }

    private static final int findSameDataBlock(int[] iArr, int i, int i2, int i3) {
        int i4 = i - 32;
        int i5 = 0;
        while (i5 <= i4) {
            if (TrieBuilder.equal_int(iArr, i5, i2, 32)) {
                return i5;
            }
            i5 += i3;
        }
        return -1;
    }

    private final void fold(TrieBuilder.DataManipulate dataManipulate) {
        IntTrieBuilder intTrieBuilder;
        int i;
        int[] iArr = new int[32];
        int[] iArr2 = this.m_index_;
        System.arraycopy(iArr2, 1728, iArr, 0, 32);
        if (this.m_leadUnitValue_ == this.m_initialValue_) {
            intTrieBuilder = this;
            i = 0;
        } else {
            int iAllocDataBlock = allocDataBlock();
            if (iAllocDataBlock < 0) {
                og.n("Internal error: Out of memory space");
                return;
            } else {
                intTrieBuilder = this;
                intTrieBuilder.fillBlock(iAllocDataBlock, 0, 32, this.m_leadUnitValue_, true);
                i = -iAllocDataBlock;
            }
        }
        for (int i2 = 1728; i2 < 1760; i2++) {
            intTrieBuilder.m_index_[i2] = i;
        }
        int i3 = 65536;
        int i4 = 2048;
        while (i3 < 1114112) {
            if (iArr2[i3 >> 5] != 0) {
                int i5 = i3 & (-1024);
                int i6 = i5 >> 5;
                int iFindSameIndexBlock = TrieBuilder.findSameIndexBlock(iArr2, i4, i6);
                int foldedValue = dataManipulate.getFoldedValue(i5, iFindSameIndexBlock + 32);
                if (foldedValue != intTrieBuilder.getValue(UTF16.getLeadSurrogate(i5))) {
                    if (!intTrieBuilder.setValue(UTF16.getLeadSurrogate(i5), foldedValue)) {
                        throw new ArrayIndexOutOfBoundsException("Data table overflow");
                    }
                    if (iFindSameIndexBlock == i4) {
                        System.arraycopy(iArr2, i6, iArr2, i4, 32);
                        i4 += 32;
                    }
                }
                i3 = i5 + 1024;
            } else {
                i3 += 32;
            }
        }
        if (i4 >= 34816) {
            throw new ArrayIndexOutOfBoundsException("Index table overflow");
        }
        System.arraycopy(iArr2, 2048, iArr2, 2080, i4 - 2048);
        System.arraycopy(iArr, 0, iArr2, 2048, 32);
        intTrieBuilder.m_indexLength_ = i4 + 32;
    }

    private int getDataBlock(int i) {
        int i2 = i >> 5;
        int i3 = this.m_index_[i2];
        if (i3 > 0) {
            return i3;
        }
        int iAllocDataBlock = allocDataBlock();
        if (iAllocDataBlock < 0) {
            return -1;
        }
        this.m_index_[i2] = iAllocDataBlock;
        System.arraycopy(this.m_data_, Math.abs(i3), this.m_data_, iAllocDataBlock, 128);
        return iAllocDataBlock;
    }

    public int getValue(int i, boolean[] zArr) {
        if (this.m_isCompacted_ || i > 1114111 || i < 0) {
            if (zArr != null) {
                zArr[0] = true;
            }
            return 0;
        }
        int i2 = this.m_index_[i >> 5];
        if (zArr != null) {
            zArr[0] = i2 == 0;
        }
        return this.m_data_[Math.abs(i2) + (i & 31)];
    }

    public int serialize(OutputStream outputStream, boolean z, TrieBuilder.DataManipulate dataManipulate) throws IOException {
        int i = 0;
        if (dataManipulate == null) {
            og.i("Parameters can not be null");
            return 0;
        }
        if (!this.m_isCompacted_) {
            compact(false);
            fold(dataManipulate);
            compact(true);
            this.m_isCompacted_ = true;
        }
        int i2 = this.m_dataLength_;
        if (z) {
            i2 += this.m_indexLength_;
        }
        if (i2 >= 262144) {
            throw new ArrayIndexOutOfBoundsException("Data length too small");
        }
        int i3 = (this.m_indexLength_ * 2) + 16;
        int i4 = this.m_dataLength_;
        int i5 = (z ? i4 * 2 : i4 * 4) + i3;
        if (outputStream != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(1416784229);
            int i6 = !z ? UCharacter.UnicodeBlock.ELYMAIC_ID : 37;
            if (this.m_isLatin1Linear_) {
                i6 |= 512;
            }
            dataOutputStream.writeInt(i6);
            dataOutputStream.writeInt(this.m_indexLength_);
            dataOutputStream.writeInt(this.m_dataLength_);
            if (z) {
                int i7 = 0;
                while (true) {
                    int i8 = this.m_indexLength_;
                    if (i7 >= i8) {
                        break;
                    }
                    dataOutputStream.writeChar((this.m_index_[i7] + i8) >>> 2);
                    i7++;
                }
                while (i < this.m_dataLength_) {
                    dataOutputStream.writeChar(this.m_data_[i] & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
                    i++;
                }
            } else {
                for (int i9 = 0; i9 < this.m_indexLength_; i9++) {
                    dataOutputStream.writeChar(this.m_index_[i9] >>> 2);
                }
                while (i < this.m_dataLength_) {
                    dataOutputStream.writeInt(this.m_data_[i]);
                    i++;
                }
            }
        }
        return i5;
    }

    public boolean setRange(int i, int i2, int i3, boolean z) {
        if (this.m_isCompacted_ || i < 0 || i > 1114111 || i2 < 0 || i2 > 1114112 || i > i2) {
            return false;
        }
        if (i == i2) {
            return true;
        }
        int i4 = i & 31;
        if (i4 != 0) {
            int dataBlock = getDataBlock(i);
            if (dataBlock < 0) {
                return false;
            }
            i = (i + 32) & (-32);
            if (i > i2) {
                fillBlock(dataBlock, i4, i2 & 31, i3, z);
                return true;
            }
            fillBlock(dataBlock, i4, 32, i3, z);
        }
        int i5 = i2 & 31;
        int i6 = i2 & (-32);
        int i7 = i3 == this.m_initialValue_ ? 0 : -1;
        while (i < i6) {
            int[] iArr = this.m_index_;
            int i8 = i >> 5;
            int i9 = iArr[i8];
            if (i9 > 0) {
                fillBlock(i9, 0, 32, i3, z);
            } else if (this.m_data_[-i9] != i3 && (i9 == 0 || z)) {
                if (i7 >= 0) {
                    iArr[i8] = -i7;
                } else {
                    int dataBlock2 = getDataBlock(i);
                    if (dataBlock2 < 0) {
                        return false;
                    }
                    this.m_index_[i8] = -dataBlock2;
                    fillBlock(dataBlock2, 0, 32, i3, true);
                    i7 = dataBlock2;
                }
            }
            i += 32;
        }
        if (i5 > 0) {
            int dataBlock3 = getDataBlock(i);
            if (dataBlock3 < 0) {
                return false;
            }
            fillBlock(dataBlock3, 0, i5, i3, z);
        }
        return true;
    }

    public boolean setValue(int i, int i2) {
        int dataBlock;
        if (this.m_isCompacted_ || i > 1114111 || i < 0 || (dataBlock = getDataBlock(i)) < 0) {
            return false;
        }
        this.m_data_[dataBlock + (i & 31)] = i2;
        return true;
    }

    public int getValue(int i) {
        if (this.m_isCompacted_ || i > 1114111 || i < 0) {
            return 0;
        }
        return this.m_data_[Math.abs(this.m_index_[i >> 5]) + (i & 31)];
    }

    public IntTrieBuilder(IntTrieBuilder intTrieBuilder) {
        super(intTrieBuilder);
        int[] iArr = new int[this.m_dataCapacity_];
        this.m_data_ = iArr;
        System.arraycopy(intTrieBuilder.m_data_, 0, iArr, 0, this.m_dataLength_);
        this.m_initialValue_ = intTrieBuilder.m_initialValue_;
        this.m_leadUnitValue_ = intTrieBuilder.m_leadUnitValue_;
    }

    public IntTrie serialize(TrieBuilder.DataManipulate dataManipulate, Trie.DataManipulate dataManipulate2) {
        if (dataManipulate != null) {
            if (!this.m_isCompacted_) {
                compact(false);
                fold(dataManipulate);
                compact(true);
                this.m_isCompacted_ = true;
            }
            int i = this.m_dataLength_;
            if (i < 262144) {
                char[] cArr = new char[this.m_indexLength_];
                int[] iArr = new int[i];
                for (int i2 = 0; i2 < this.m_indexLength_; i2++) {
                    cArr[i2] = (char) (this.m_index_[i2] >>> 2);
                }
                System.arraycopy(this.m_data_, 0, iArr, 0, this.m_dataLength_);
                return new IntTrie(cArr, iArr, this.m_initialValue_, this.m_isLatin1Linear_ ? 805 : UCharacter.UnicodeBlock.ELYMAIC_ID, dataManipulate2);
            }
            throw new ArrayIndexOutOfBoundsException("Data length too small");
        }
        og.i("Parameters can not be null");
        return null;
    }
}
