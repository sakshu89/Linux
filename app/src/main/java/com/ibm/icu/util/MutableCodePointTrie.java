package com.ibm.icu.util;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.breakiter.DictionaryData;
import com.ibm.icu.text.DateTimePatternGenerator;
import defpackage.dk0;
import defpackage.og;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class MutableCodePointTrie extends CodePointMap implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte ALL_SAME = 0;
    private static final int ASCII_I_LIMIT = 8;
    private static final int ASCII_LIMIT = 128;
    private static final int BMP_I_LIMIT = 4096;
    private static final int BMP_LIMIT = 65536;
    private static final byte I3_16 = 2;
    private static final byte I3_18 = 3;
    private static final byte I3_BMP = 1;
    private static final byte I3_NULL = 0;
    private static final int INDEX_3_18BIT_BLOCK_LENGTH = 36;
    private static final int INITIAL_DATA_LENGTH = 16384;
    private static final int I_LIMIT = 69632;
    private static final int MAX_DATA_LENGTH = 1114112;
    private static final int MAX_UNICODE = 1114111;
    private static final int MEDIUM_DATA_LENGTH = 131072;
    private static final byte MIXED = 1;
    private static final byte SAME_AS = 2;
    private static final int SMALL_DATA_BLOCKS_PER_BMP_BLOCK = 4;
    private static final int UNICODE_LIMIT = 1114112;
    private int dataLength;
    private int errorValue;
    private int highStart;
    private int highValue;
    private char[] index16;
    private int initialValue;
    private int origInitialValue;
    private byte[] flags = new byte[I_LIMIT];
    private int[] index = new int[4096];
    private int index3NullOffset = -1;
    private int[] data = new int[16384];
    private int dataNullOffset = -1;

    /* JADX INFO: renamed from: com.ibm.icu.util.MutableCodePointTrie$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth;

        static {
            int[] iArr = new int[CodePointTrie.ValueWidth.values().length];
            $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth = iArr;
            try {
                iArr[CodePointTrie.ValueWidth.BITS_32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[CodePointTrie.ValueWidth.BITS_16.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[CodePointTrie.ValueWidth.BITS_8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AllSameBlocks {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CAPACITY = 32;
        static final int NEW_UNIQUE = -1;
        static final int OVERFLOW = -2;
        private int length;
        private int[] indexes = new int[32];
        private int[] values = new int[32];
        private int[] refCounts = new int[32];
        private int mostRecent = -1;

        public void add(int i, int i2, int i3) {
            int i4 = -1;
            int i5 = MutableCodePointTrie.I_LIMIT;
            for (int i6 = 0; i6 < this.length; i6++) {
                int i7 = this.refCounts[i6];
                if (i7 < i5) {
                    i4 = i6;
                    i5 = i7;
                }
            }
            this.mostRecent = i4;
            this.indexes[i4] = i;
            this.values[i4] = i3;
            this.refCounts[i4] = i2;
        }

        public int findMostUsed() {
            if (this.length == 0) {
                return -1;
            }
            int i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < this.length; i3++) {
                int i4 = this.refCounts[i3];
                if (i4 > i2) {
                    i = i3;
                    i2 = i4;
                }
            }
            return this.indexes[i];
        }

        public int findOrAdd(int i, int i2, int i3) {
            int i4 = this.mostRecent;
            if (i4 >= 0 && this.values[i4] == i3) {
                int[] iArr = this.refCounts;
                iArr[i4] = iArr[i4] + i2;
                return this.indexes[i4];
            }
            int i5 = 0;
            while (true) {
                int i6 = this.length;
                if (i5 >= i6) {
                    if (i6 == 32) {
                        return -2;
                    }
                    this.mostRecent = i6;
                    this.indexes[i6] = i;
                    this.values[i6] = i3;
                    int[] iArr2 = this.refCounts;
                    this.length = i6 + 1;
                    iArr2[i6] = i2;
                    return -1;
                }
                if (this.values[i5] == i3) {
                    this.mostRecent = i5;
                    int[] iArr3 = this.refCounts;
                    iArr3[i5] = iArr3[i5] + i2;
                    return this.indexes[i5];
                }
                i5++;
            }
        }
    }

    public MutableCodePointTrie(int i, int i2) {
        this.origInitialValue = i;
        this.initialValue = i;
        this.errorValue = i2;
        this.highValue = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean allValuesSameAs(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        while (i < i4 && iArr[i] == i3) {
            i++;
        }
        return i == i4;
    }

    private int allocDataBlock(int i) {
        int i2 = this.dataLength;
        int i3 = i + i2;
        int[] iArr = this.data;
        if (i3 > iArr.length) {
            int i4 = 131072;
            if (iArr.length >= 131072) {
                i4 = 1114112;
                if (iArr.length >= 1114112) {
                    throw new AssertionError();
                }
            }
            int[] iArr2 = new int[i4];
            for (int i5 = 0; i5 < this.dataLength; i5++) {
                iArr2[i5] = this.data[i5];
            }
            this.data = iArr2;
        }
        this.dataLength = i3;
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2 A[LOOP:3: B:49:0x00de->B:51:0x00e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x00f0 A[EDGE_INSN: B:98:0x00f0->B:52:0x00f0 BREAK  A[LOOP:3: B:49:0x00de->B:51:0x00e2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[SYNTHETIC] */
    private CodePointTrie build(CodePointTrie.Type type, CodePointTrie.ValueWidth valueWidth) {
        int[] iArr;
        int[] iArr2;
        char[] cArrCopyOf;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[valueWidth.ordinal()];
        if (i != 1) {
            if (i == 2) {
                maskValues(DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
            } else {
                if (i != 3) {
                    dk0.v();
                    return null;
                }
                maskValues(255);
            }
        }
        int i2 = type == CodePointTrie.Type.FAST ? 65536 : 4096;
        int iCompactTrie = compactTrie(i2 >> 4);
        CodePointTrie.ValueWidth valueWidth2 = CodePointTrie.ValueWidth.BITS_32;
        if (valueWidth == valueWidth2 && (iCompactTrie & 1) != 0) {
            this.index16[iCompactTrie] = 65518;
            iCompactTrie++;
        }
        int i3 = iCompactTrie * 2;
        if (valueWidth == CodePointTrie.ValueWidth.BITS_16) {
            int i4 = this.dataLength;
            if (((iCompactTrie ^ i4) & 1) != 0) {
                int[] iArr3 = this.data;
                this.dataLength = i4 + 1;
                iArr3[i4] = this.errorValue;
            }
            int[] iArr4 = this.data;
            int i5 = this.dataLength;
            int i6 = iArr4[i5 - 1];
            int i7 = this.errorValue;
            if (i6 != i7 || iArr4[i5 - 2] != this.highValue) {
                int i8 = i5 + 1;
                this.dataLength = i8;
                iArr4[i5] = this.highValue;
                this.dataLength = i5 + 2;
                iArr4[i8] = i7;
            }
        } else if (valueWidth == valueWidth2) {
            int[] iArr5 = this.data;
            int i9 = this.dataLength;
            int i10 = iArr5[i9 - 1];
            int i11 = this.errorValue;
            if (i10 != i11 || iArr5[i9 - 2] != this.highValue) {
                int i12 = iArr5[i9 - 1];
                int i13 = this.highValue;
                if (i12 != i13) {
                    this.dataLength = i9 + 1;
                    iArr5[i9] = i13;
                }
                int i14 = this.dataLength;
                this.dataLength = i14 + 1;
                iArr5[i14] = i11;
            }
        } else {
            int i15 = this.dataLength;
            int i16 = (i3 + i15) & 3;
            if (i16 == 0) {
                int[] iArr6 = this.data;
                if (iArr6[i15 - 1] != this.errorValue || iArr6[i15 - 2] != this.highValue) {
                    if (i16 == 3) {
                        iArr2 = this.data;
                        if (iArr2[i15 - 1] == this.highValue) {
                            this.dataLength = i15 + 1;
                            iArr2[i15] = this.errorValue;
                        } else {
                            while (true) {
                                iArr = this.data;
                                if (i16 != 2) {
                                    break;
                                }
                                int i17 = this.dataLength;
                                this.dataLength = i17 + 1;
                                iArr[i17] = this.highValue;
                                i16 = (i16 + 1) & 3;
                            }
                            int i18 = this.dataLength;
                            int i19 = i18 + 1;
                            this.dataLength = i19;
                            iArr[i18] = this.highValue;
                            this.dataLength = i18 + 2;
                            iArr[i19] = this.errorValue;
                        }
                    } else {
                        while (true) {
                            iArr = this.data;
                            if (i16 != 2) {
                                break;
                                break;
                            }
                            int i110 = this.dataLength;
                            this.dataLength = i110 + 1;
                            iArr[i110] = this.highValue;
                            i16 = (i16 + 1) & 3;
                        }
                        int i111 = this.dataLength;
                        int i112 = i111 + 1;
                        this.dataLength = i112;
                        iArr[i111] = this.highValue;
                        this.dataLength = i111 + 2;
                        iArr[i112] = this.errorValue;
                    }
                }
            } else if (i16 == 3) {
                iArr2 = this.data;
                if (iArr2[i15 - 1] == this.highValue) {
                    this.dataLength = i15 + 1;
                    iArr2[i15] = this.errorValue;
                } else {
                    while (true) {
                        iArr = this.data;
                        if (i16 != 2) {
                            break;
                            break;
                        }
                        int i113 = this.dataLength;
                        this.dataLength = i113 + 1;
                        iArr[i113] = this.highValue;
                        i16 = (i16 + 1) & 3;
                    }
                    int i114 = this.dataLength;
                    int i115 = i114 + 1;
                    this.dataLength = i115;
                    iArr[i114] = this.highValue;
                    this.dataLength = i114 + 2;
                    iArr[i115] = this.errorValue;
                }
            } else {
                while (true) {
                    iArr = this.data;
                    if (i16 != 2) {
                        break;
                        break;
                    }
                    int i116 = this.dataLength;
                    this.dataLength = i116 + 1;
                    iArr[i116] = this.highValue;
                    i16 = (i16 + 1) & 3;
                }
                int i117 = this.dataLength;
                int i118 = i117 + 1;
                this.dataLength = i118;
                iArr[i117] = this.highValue;
                this.dataLength = i117 + 2;
                iArr[i118] = this.errorValue;
            }
        }
        int i20 = 0;
        if (this.highStart <= i2) {
            cArrCopyOf = new char[iCompactTrie];
            int i21 = 0;
            for (int i22 = 0; i22 < iCompactTrie; i22++) {
                cArrCopyOf[i22] = (char) this.index[i21];
                i21 += 4;
            }
        } else {
            cArrCopyOf = this.index16;
            if (iCompactTrie == cArrCopyOf.length) {
                this.index16 = null;
            } else {
                cArrCopyOf = Arrays.copyOf(cArrCopyOf, iCompactTrie);
            }
        }
        char[] cArr = cArrCopyOf;
        int i23 = AnonymousClass1.$SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[valueWidth.ordinal()];
        if (i23 == 1) {
            int[] iArrCopyOf = Arrays.copyOf(this.data, this.dataLength);
            CodePointTrie.Type type2 = CodePointTrie.Type.FAST;
            int i24 = this.highStart;
            return type == type2 ? new CodePointTrie.Fast32(cArr, iArrCopyOf, i24, this.index3NullOffset, this.dataNullOffset) : new CodePointTrie.Small32(cArr, iArrCopyOf, i24, this.index3NullOffset, this.dataNullOffset);
        }
        if (i23 == 2) {
            char[] cArr2 = new char[this.dataLength];
            while (i20 < this.dataLength) {
                cArr2[i20] = (char) this.data[i20];
                i20++;
            }
            CodePointTrie.Type type3 = CodePointTrie.Type.FAST;
            int i25 = this.highStart;
            return type == type3 ? new CodePointTrie.Fast16(cArr, cArr2, i25, this.index3NullOffset, this.dataNullOffset) : new CodePointTrie.Small16(cArr, cArr2, i25, this.index3NullOffset, this.dataNullOffset);
        }
        if (i23 != 3) {
            dk0.v();
            return null;
        }
        byte[] bArr = new byte[this.dataLength];
        while (i20 < this.dataLength) {
            bArr[i20] = (byte) this.data[i20];
            i20++;
        }
        CodePointTrie.Type type4 = CodePointTrie.Type.FAST;
        int i26 = this.highStart;
        return type == type4 ? new CodePointTrie.Fast8(cArr, bArr, i26, this.index3NullOffset, this.dataNullOffset) : new CodePointTrie.Small8(cArr, bArr, i26, this.index3NullOffset, this.dataNullOffset);
    }

    private void clear() {
        this.dataNullOffset = -1;
        this.index3NullOffset = -1;
        this.dataLength = 0;
        int i = this.origInitialValue;
        this.initialValue = i;
        this.highValue = i;
        this.highStart = 0;
        this.index16 = null;
    }

    private int compactData(int i, int[] iArr, int i2, MixedBlocks mixedBlocks) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i3 = 4;
            if (i6 >= 128) {
                break;
            }
            this.index[i7] = i6;
            i6 += 64;
            i7 += 4;
        }
        int i8 = 64;
        mixedBlocks.init(iArr.length, 64);
        mixedBlocks.extend(iArr, 0, 0, i6);
        int i9 = this.highStart >> 4;
        int i10 = 0;
        for (int i11 = 8; i11 < i9; i11 += i3) {
            if (i11 == i) {
                mixedBlocks.init(iArr.length, 16);
                mixedBlocks.extend(iArr, i5, i5, i6);
                i10 = i6;
                i8 = 16;
                i3 = 1;
            }
            byte b = this.flags[i11];
            if (b == 0) {
                int i12 = this.index[i11];
                int iFindAllSameBlock = mixedBlocks.findAllSameBlock(iArr, i12);
                while (iFindAllSameBlock >= 0 && i11 == i2 && i11 >= i && iFindAllSameBlock < i10 && isStartOfSomeFastBlock(iFindAllSameBlock, this.index, i)) {
                    iFindAllSameBlock = findAllSameBlock(iArr, iFindAllSameBlock + 1, i6, i12, i8);
                }
                if (iFindAllSameBlock >= 0) {
                    this.index[i11] = iFindAllSameBlock;
                } else {
                    int allSameOverlap = getAllSameOverlap(iArr, i6, i12, i8);
                    this.index[i11] = i6 - allSameOverlap;
                    i4 = i6;
                    while (allSameOverlap < i8) {
                        iArr[i4] = i12;
                        allSameOverlap++;
                        i4++;
                    }
                    mixedBlocks.extend(iArr, i5, i6, i4);
                    i6 = i4;
                }
            } else {
                int[] iArr2 = this.index;
                if (b == 1) {
                    int i13 = iArr2[i11];
                    int iFindBlock = mixedBlocks.findBlock(iArr, this.data, i13);
                    if (iFindBlock >= 0) {
                        this.index[i11] = iFindBlock;
                    } else {
                        int overlap = getOverlap(iArr, i6, this.data, i13, i8);
                        this.index[i11] = i6 - overlap;
                        i4 = i6;
                        while (overlap < i8) {
                            iArr[i4] = this.data[overlap + i13];
                            i4++;
                            overlap++;
                            i5 = 0;
                        }
                        mixedBlocks.extend(iArr, i5, i6, i4);
                        i6 = i4;
                    }
                } else {
                    iArr2[i11] = iArr2[iArr2[i11]];
                }
            }
        }
        return i6;
    }

    private int compactIndex(int i, MixedBlocks mixedBlocks) {
        byte b;
        int i2;
        MixedBlocks mixedBlocks2;
        int iFindSameBlock;
        int i3;
        int i4;
        int i5;
        char[] cArr;
        int i6;
        char[] cArr2;
        int i7;
        int overlap;
        int iFindBlock;
        int i8;
        int i9;
        int overlap2;
        char[] cArr3;
        int[] iArr;
        byte b2;
        byte b3;
        int i10;
        int i11;
        int i12 = i >> 2;
        if ((this.highStart >> 6) <= i12) {
            this.index3NullOffset = 32767;
            return i12;
        }
        char[] cArr4 = new char[i12];
        byte b4 = 0;
        int i13 = -1;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            b = 1;
            if (i14 >= i) {
                break;
            }
            int i16 = this.index[i14];
            cArr4[i15] = (char) i16;
            if (i16 != this.dataNullOffset) {
                i13 = -1;
            } else if (i13 < 0) {
                i13 = i15;
            } else if (this.index3NullOffset < 0 && (i15 - i13) + 1 == 32) {
                this.index3NullOffset = i13;
            }
            int i17 = i14 + 4;
            while (true) {
                i14++;
                if (i14 < i17) {
                    i16 += 16;
                    this.index[i14] = i16;
                }
            }
            i15++;
        }
        mixedBlocks.init(i12, 32);
        mixedBlocks.extend(cArr4, 0, 0, i12);
        int i18 = this.index3NullOffset;
        int i19 = i < 4096 ? 0 : 4096;
        int i20 = this.highStart >> 4;
        int i21 = 0;
        byte b5 = 0;
        int i22 = i19;
        while (true) {
            i2 = DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
            if (i22 >= i20) {
                break;
            }
            int i23 = i22 + 32;
            int i24 = b4;
            int i25 = i22;
            byte b6 = b;
            while (true) {
                iArr = this.index;
                b2 = b;
                int i26 = iArr[i25];
                b3 = b4;
                i10 = i24 | i26;
                if (i26 != this.dataNullOffset) {
                    b6 = b3;
                }
                i11 = i25 + 1;
                if (i11 >= i23) {
                    break;
                }
                i24 = i10;
                i25 = i11;
                b = b2;
                b4 = b3;
            }
            if (b6 != 0) {
                this.flags[i22] = b3;
                if (i18 < 0) {
                    if (i10 <= 65535) {
                        i21 += 32;
                    } else {
                        i21 += 36;
                        b5 = b2;
                    }
                    i18 = b3;
                }
            } else if (i10 <= 65535) {
                int iFindBlock2 = mixedBlocks.findBlock(cArr4, iArr, i22);
                byte[] bArr = this.flags;
                if (iFindBlock2 >= 0) {
                    bArr[i22] = b2;
                    this.index[i22] = iFindBlock2;
                } else {
                    bArr[i22] = 2;
                    i21 += 32;
                }
            } else {
                this.flags[i22] = 3;
                i21 += 36;
                b5 = b2;
            }
            i22 = i11;
            b = b2;
            b4 = b3;
        }
        byte b7 = b4;
        byte b8 = b;
        byte b9 = 2;
        int i27 = (i20 - i19) >> 5;
        int i28 = ((i27 + 31) >> 5) + i12;
        int i29 = i21 + i28 + i27 + 1;
        this.index16 = Arrays.copyOf(cArr4, i29);
        mixedBlocks.init(i29, 32);
        if (b5 != 0) {
            mixedBlocks2 = new MixedBlocks(b7);
            mixedBlocks2.init(i29, 36);
        } else {
            mixedBlocks2 = null;
        }
        char[] cArr5 = new char[i27];
        int i30 = i28;
        int i31 = this.index3NullOffset;
        int i32 = 0;
        while (i19 < i20) {
            byte b10 = this.flags[i19];
            if (b10 == 0 && i31 < 0) {
                b10 = this.dataNullOffset <= i2 ? b9 : (byte) 3;
                i31 = 0;
            }
            if (b10 == 0) {
                iFindBlock = this.index3NullOffset;
            } else {
                if (b10 == b8) {
                    iFindBlock = this.index[i19];
                } else if (b10 == b9) {
                    iFindBlock = mixedBlocks.findBlock(this.index16, this.index, i19);
                    if (iFindBlock < 0) {
                        if (i30 == i28) {
                            overlap2 = 0;
                            i9 = 32;
                        } else {
                            i9 = 32;
                            overlap2 = getOverlap(this.index16, i30, this.index, i19, 32);
                        }
                        int i33 = i30 - overlap2;
                        int i34 = i30;
                        while (true) {
                            cArr3 = this.index16;
                            if (overlap2 >= i9) {
                                break;
                            }
                            cArr3[i34] = (char) this.index[overlap2 + i19];
                            i34++;
                            overlap2++;
                            i9 = 32;
                        }
                        mixedBlocks.extend(cArr3, i28, i30, i34);
                        if (b5 != 0) {
                            mixedBlocks2.extend(this.index16, i28, i30, i34);
                        }
                        i30 = i34;
                        iFindBlock = i33;
                    }
                    i6 = i12;
                    b9 = 2;
                } else {
                    i20 = i20;
                    int i35 = i19 + 32;
                    int i36 = i19;
                    int i37 = i30;
                    while (true) {
                        int i38 = i37 + 1;
                        int[] iArr2 = this.index;
                        i6 = i12;
                        int i39 = iArr2[i36];
                        b9 = 2;
                        int i40 = i37;
                        cArr2 = this.index16;
                        cArr2[i38] = (char) i39;
                        int i41 = iArr2[i36 + 1];
                        int i42 = ((i39 & 196608) >> 2) | ((i41 & 196608) >> 4);
                        cArr2[i40 + 2] = (char) i41;
                        int i43 = iArr2[i36 + 2];
                        cArr2[i40 + 3] = (char) i43;
                        int i44 = iArr2[i36 + 3];
                        int i45 = i42 | ((i43 & 196608) >> 6) | ((i44 & 196608) >> 8);
                        cArr2[i40 + 4] = (char) i44;
                        int i46 = iArr2[i36 + 4];
                        cArr2[i40 + 5] = (char) i46;
                        int i47 = iArr2[i36 + 5];
                        int i48 = i45 | ((i46 & 196608) >> 10) | ((i47 & 196608) >> 12);
                        cArr2[i40 + 6] = (char) i47;
                        int i49 = i36 + 7;
                        int i50 = iArr2[i36 + 6];
                        int i51 = i48 | ((i50 & 196608) >> 14);
                        cArr2[i40 + 7] = (char) i50;
                        i36 += 8;
                        int i52 = iArr2[i49];
                        int i53 = i40 + 9;
                        cArr2[i40 + 8] = (char) i52;
                        cArr2[i40] = (char) (i51 | ((i52 & 196608) >> 16));
                        if (i36 >= i35) {
                            break;
                        }
                        i37 = i53;
                        i12 = i6;
                    }
                    int iFindBlock3 = mixedBlocks2.findBlock(cArr2, cArr2, i30);
                    if (iFindBlock3 >= 0) {
                        iFindBlock = iFindBlock3 | 32768;
                    } else {
                        if (i30 == i28) {
                            overlap = 0;
                            i7 = 36;
                        } else {
                            char[] cArr6 = this.index16;
                            i7 = 36;
                            overlap = getOverlap(cArr6, i30, cArr6, i30, 36);
                        }
                        iFindBlock = (i30 - overlap) | 32768;
                        if (overlap > 0) {
                            i8 = i30;
                            while (overlap < i7) {
                                char[] cArr7 = this.index16;
                                cArr7[i8] = cArr7[overlap + i30];
                                i8++;
                                overlap++;
                            }
                        } else {
                            i8 = i30 + 36;
                        }
                        mixedBlocks.extend(this.index16, i28, i30, i8);
                        if (b5 != 0) {
                            mixedBlocks2.extend(this.index16, i28, i30, i8);
                        }
                        i30 = i8;
                    }
                }
                if (this.index3NullOffset >= 0 && i31 >= 0) {
                    this.index3NullOffset = iFindBlock;
                }
                cArr5[i32] = (char) iFindBlock;
                i19 += 32;
                i32++;
                i20 = i20;
                i12 = i6;
                i2 = DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
                b8 = 1;
            }
            i20 = i20;
            i6 = i12;
            if (this.index3NullOffset >= 0) {
            }
            cArr5[i32] = (char) iFindBlock;
            i19 += 32;
            i32++;
            i20 = i20;
            i12 = i6;
            i2 = DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
            b8 = 1;
        }
        int i54 = i12;
        if (this.index3NullOffset < 0) {
            this.index3NullOffset = 32767;
        }
        if (i30 >= 32799) {
            og.o("The trie data exceeds limitations of the data structure.");
            return 0;
        }
        int i55 = i54;
        int i56 = 0;
        int i57 = i30;
        int i58 = 32;
        while (i56 < i32) {
            int i59 = i32 - i56;
            char[] cArr8 = this.index16;
            if (i59 >= i58) {
                iFindSameBlock = mixedBlocks.findBlock(cArr8, cArr5, i56);
                int i60 = i28;
                i4 = i56;
                i3 = i60;
                i5 = i58;
            } else {
                int i61 = i56;
                int i62 = i28;
                iFindSameBlock = findSameBlock(cArr8, i62, i57, cArr5, i61, i59);
                i3 = i62;
                i4 = i61;
                i5 = i59;
            }
            int i63 = i57;
            if (iFindSameBlock >= 0) {
                i57 = i63;
            } else {
                int overlap3 = i63 == i3 ? 0 : getOverlap(this.index16, i63, cArr5, i4, i5);
                int i64 = i63 - overlap3;
                int i65 = i63;
                while (true) {
                    cArr = this.index16;
                    if (overlap3 >= i5) {
                        break;
                    }
                    cArr[i65] = cArr5[overlap3 + i4];
                    overlap3++;
                    i65++;
                }
                mixedBlocks.extend(cArr, i3, i63, i65);
                iFindSameBlock = i64;
                i57 = i65;
            }
            int i66 = i55 + 1;
            this.index16[i55] = (char) iFindSameBlock;
            int i67 = i4 + i5;
            i28 = i3;
            i56 = i67;
            i58 = i5;
            i55 = i66;
        }
        return i57;
    }

    private int compactTrie(int i) {
        this.highValue = get(1114111);
        int iFindHighStart = (findHighStart() + 511) & (-512);
        if (iFindHighStart == 1114112) {
            this.highValue = this.initialValue;
        }
        int i2 = i << 4;
        int i3 = 0;
        if (iFindHighStart < i2) {
            for (int i4 = iFindHighStart >> 4; i4 < i; i4++) {
                this.flags[i4] = 0;
                this.index[i4] = this.highValue;
            }
            this.highStart = i2;
        } else {
            this.highStart = iFindHighStart;
        }
        int[] iArr = new int[128];
        for (int i5 = 0; i5 < 128; i5++) {
            iArr[i5] = get(i5);
        }
        AllSameBlocks allSameBlocks = new AllSameBlocks();
        int[] iArrCopyOf = Arrays.copyOf(iArr, compactWholeDataBlocks(i, allSameBlocks));
        int iFindMostUsed = allSameBlocks.findMostUsed();
        MixedBlocks mixedBlocks = new MixedBlocks(i3);
        int iCompactData = compactData(i, iArrCopyOf, iFindMostUsed, mixedBlocks);
        this.data = iArrCopyOf;
        this.dataLength = iCompactData;
        if (iCompactData > 262159) {
            og.o("The trie data exceeds limitations of the data structure.");
            return 0;
        }
        if (iFindMostUsed >= 0) {
            int i6 = this.index[iFindMostUsed];
            this.dataNullOffset = i6;
            this.initialValue = iArrCopyOf[i6];
        } else {
            this.dataNullOffset = 1048575;
        }
        int iCompactIndex = compactIndex(i, mixedBlocks);
        this.highStart = iFindHighStart;
        return iCompactIndex;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0074 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private int compactWholeDataBlocks(int i, AllSameBlocks allSameBlocks) {
        int iFindOrAdd;
        int i2;
        int i3;
        int i4 = this.highStart >> 4;
        int i5 = 148;
        int i6 = 64;
        int i7 = 4;
        for (int i8 = 0; i8 < i4; i8 += i7) {
            if (i8 == i) {
                i6 = 16;
                i7 = 1;
            }
            int i9 = this.index[i8];
            if (this.flags[i8] == 1) {
                int[] iArr = this.data;
                int i10 = iArr[i9];
                if (allValuesSameAs(iArr, i9 + 1, i6 - 1, i10)) {
                    this.flags[i8] = 0;
                    this.index[i8] = i10;
                    i9 = i10;
                    iFindOrAdd = allSameBlocks.findOrAdd(i8, i7, i9);
                    if (iFindOrAdd == -2) {
                        i2 = 4;
                        i3 = 0;
                        while (true) {
                            if (i3 == i8) {
                                allSameBlocks.add(i8, i7, i9);
                                break;
                            }
                            if (i3 == i) {
                                i2 = 1;
                            }
                            if (this.flags[i3] != 0 && this.index[i3] == i9) {
                                allSameBlocks.add(i3, i2 + i7, i9);
                                iFindOrAdd = i3;
                                break;
                            }
                            i3 += i2;
                        }
                    }
                    if (iFindOrAdd >= 0) {
                        this.flags[i8] = 2;
                        this.index[i8] = iFindOrAdd;
                    }
                }
            } else {
                if (i7 > 1) {
                    int i11 = i8 + i7;
                    int i12 = i8 + 1;
                    while (true) {
                        if (i12 >= i11) {
                            iFindOrAdd = allSameBlocks.findOrAdd(i8, i7, i9);
                            if (iFindOrAdd == -2) {
                                i2 = 4;
                                i3 = 0;
                                while (true) {
                                    if (i3 == i8) {
                                        allSameBlocks.add(i8, i7, i9);
                                        break;
                                    }
                                    if (i3 == i) {
                                        i2 = 1;
                                    }
                                    if (this.flags[i3] != 0) {
                                    }
                                    i3 += i2;
                                }
                            }
                            if (iFindOrAdd >= 0) {
                                this.flags[i8] = 2;
                                this.index[i8] = iFindOrAdd;
                            }
                        } else if (this.index[i12] == i9) {
                            i12++;
                        } else if (getDataBlock(i8) < 0) {
                            return -1;
                        }
                    }
                } else {
                    iFindOrAdd = allSameBlocks.findOrAdd(i8, i7, i9);
                    if (iFindOrAdd == -2) {
                        i2 = 4;
                        i3 = 0;
                        while (true) {
                            if (i3 == i8) {
                                allSameBlocks.add(i8, i7, i9);
                                break;
                            }
                            if (i3 == i) {
                                i2 = 1;
                            }
                            if (this.flags[i3] != 0) {
                            }
                            i3 += i2;
                        }
                    }
                    if (iFindOrAdd >= 0) {
                        this.flags[i8] = 2;
                        this.index[i8] = iFindOrAdd;
                    }
                }
            }
            i5 += i6;
        }
        return i5;
    }

    private void ensureHighStart(int i) {
        int i2 = this.highStart;
        if (i >= i2) {
            int i3 = (i + 512) & (-512);
            int i4 = i2 >> 4;
            int i5 = i3 >> 4;
            if (i5 > this.index.length) {
                int[] iArr = new int[I_LIMIT];
                for (int i6 = 0; i6 < i4; i6++) {
                    iArr[i6] = this.index[i6];
                }
                this.index = iArr;
            }
            do {
                this.flags[i4] = 0;
                this.index[i4] = this.initialValue;
                i4++;
            } while (i4 < i5);
            this.highStart = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalBlocks(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        while (i3 > 0 && iArr[i] == iArr2[i2]) {
            i++;
            i2++;
            i3--;
        }
        return i3 == 0;
    }

    private void fillBlock(int i, int i2, int i3, int i4) {
        Arrays.fill(this.data, i2 + i, i + i3, i4);
    }

    private static int findAllSameBlock(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i2 - i4;
        while (i <= i5) {
            if (iArr[i] == i3) {
                for (int i6 = 1; i6 != i4; i6++) {
                    int i7 = i + i6;
                    if (iArr[i7] != i3) {
                        i = i7;
                    }
                }
                return i;
            }
            i++;
        }
        return -1;
    }

    private int findHighStart() {
        int i = this.highStart >> 4;
        while (true) {
            if (i <= 0) {
                return 0;
            }
            int i2 = i - 1;
            byte b = this.flags[i2];
            int[] iArr = this.index;
            if (b != 0) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 != 16; i4++) {
                    if (this.data[i3 + i4] != this.highValue) {
                        return i << 4;
                    }
                }
                i = i2;
            } else {
                if (iArr[i2] != this.highValue) {
                    return i << 4;
                }
                i = i2;
            }
        }
    }

    private static int findSameBlock(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
        int i5 = i2 - i4;
        while (i <= i5) {
            if (equalBlocks(cArr, i, cArr2, i3, i4)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static MutableCodePointTrie fromCodePointMap(CodePointMap codePointMap) {
        int i = codePointMap.get(-1);
        int i2 = codePointMap.get(1114111);
        MutableCodePointTrie mutableCodePointTrie = new MutableCodePointTrie(i2, i);
        CodePointMap.Range range = new CodePointMap.Range();
        int i3 = 0;
        while (codePointMap.getRange(i3, null, range)) {
            int end = range.getEnd();
            int value = range.getValue();
            if (value != i2) {
                if (i3 == end) {
                    mutableCodePointTrie.set(i3, value);
                } else {
                    mutableCodePointTrie.setRange(i3, end, value);
                }
            }
            i3 = end + 1;
        }
        return mutableCodePointTrie;
    }

    private static int getAllSameOverlap(int[] iArr, int i, int i2, int i3) {
        int i4 = i - (i3 - 1);
        int i5 = i;
        while (i4 < i5 && iArr[i5 - 1] == i2) {
            i5--;
        }
        return i - i5;
    }

    private int getDataBlock(int i) {
        if (this.flags[i] == 1) {
            return this.index[i];
        }
        if (i >= 4096) {
            int iAllocDataBlock = allocDataBlock(16);
            if (iAllocDataBlock < 0) {
                return iAllocDataBlock;
            }
            writeBlock(iAllocDataBlock, this.index[i]);
            this.flags[i] = 1;
            this.index[i] = iAllocDataBlock;
            return iAllocDataBlock;
        }
        int iAllocDataBlock2 = allocDataBlock(64);
        int i2 = i & (-4);
        int i3 = i2 + 4;
        while (true) {
            writeBlock(iAllocDataBlock2, this.index[i2]);
            this.flags[i2] = 1;
            int[] iArr = this.index;
            int i4 = i2 + 1;
            iArr[i2] = iAllocDataBlock2;
            iAllocDataBlock2 += 16;
            if (i4 >= i3) {
                return iArr[i];
            }
            i2 = i4;
        }
    }

    private static int getOverlap(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i3 - 1;
        while (i4 > 0 && !equalBlocks(iArr, i - i4, iArr2, i2, i4)) {
            i4--;
        }
        return i4;
    }

    private static boolean isStartOfSomeFastBlock(int i, int[] iArr, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 4) {
            if (iArr[i3] == i) {
                return true;
            }
        }
        return false;
    }

    private void maskValues(int i) {
        this.initialValue &= i;
        this.errorValue &= i;
        this.highValue &= i;
        int i2 = this.highStart >> 4;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.flags[i3] == 0) {
                int[] iArr = this.index;
                iArr[i3] = iArr[i3] & i;
            }
        }
        for (int i4 = 0; i4 < this.dataLength; i4++) {
            int[] iArr2 = this.data;
            iArr2[i4] = iArr2[i4] & i;
        }
    }

    private static final int maybeFilterValue(int i, int i2, int i3, CodePointMap.ValueFilter valueFilter) {
        if (i == i2) {
            return i3;
        }
        return valueFilter != null ? valueFilter.apply(i) : i;
    }

    private void writeBlock(int i, int i2) {
        Arrays.fill(this.data, i, i + 16, i2);
    }

    public CodePointTrie buildImmutable(CodePointTrie.Type type, CodePointTrie.ValueWidth valueWidth) {
        if (type == null || valueWidth == null) {
            og.i("The type and valueWidth must be specified.");
            return null;
        }
        try {
            return build(type, valueWidth);
        } finally {
            clear();
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MutableCodePointTrie m26clone() {
        try {
            MutableCodePointTrie mutableCodePointTrie = (MutableCodePointTrie) super.clone();
            int i = this.highStart;
            mutableCodePointTrie.index = new int[i <= 65536 ? 4096 : I_LIMIT];
            mutableCodePointTrie.flags = new byte[I_LIMIT];
            int i2 = i >> 4;
            for (int i3 = 0; i3 < i2; i3++) {
                mutableCodePointTrie.index[i3] = this.index[i3];
                mutableCodePointTrie.flags[i3] = this.flags[i3];
            }
            mutableCodePointTrie.index3NullOffset = this.index3NullOffset;
            mutableCodePointTrie.data = (int[]) this.data.clone();
            mutableCodePointTrie.dataLength = this.dataLength;
            mutableCodePointTrie.dataNullOffset = this.dataNullOffset;
            mutableCodePointTrie.origInitialValue = this.origInitialValue;
            mutableCodePointTrie.initialValue = this.initialValue;
            mutableCodePointTrie.errorValue = this.errorValue;
            mutableCodePointTrie.highStart = this.highStart;
            mutableCodePointTrie.highValue = this.highValue;
            return mutableCodePointTrie;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.ibm.icu.util.CodePointMap
    public int get(int i) {
        if (i < 0 || 1114111 < i) {
            return this.errorValue;
        }
        if (i >= this.highStart) {
            return this.highValue;
        }
        int i2 = i >> 4;
        return this.flags[i2] == 0 ? this.index[i2] : this.data[this.index[i2] + (i & 15)];
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:72:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x008a A[SYNTHETIC] */
    @Override // com.ibm.icu.util.CodePointMap
    public boolean getRange(int i, CodePointMap.ValueFilter valueFilter, CodePointMap.Range range) {
        int i2;
        boolean z = false;
        if (i < 0 || 1114111 < i) {
            return false;
        }
        if (i >= this.highStart) {
            int iApply = this.highValue;
            if (valueFilter != null) {
                iApply = valueFilter.apply(iApply);
            }
            range.set(i, 1114111, iApply);
            return true;
        }
        int iApply2 = this.initialValue;
        if (valueFilter != null) {
            iApply2 = valueFilter.apply(iApply2);
        }
        int i3 = i;
        int iMaybeFilterValue = 0;
        int i4 = i >> 4;
        int i5 = 0;
        do {
            byte b = this.flags[i4];
            int[] iArr = this.index;
            if (b != 0) {
                int i6 = iArr[i4] + (i3 & 15);
                int i7 = this.data[i6];
                if (z) {
                    if (i7 != i5) {
                        if (valueFilter == null || maybeFilterValue(i7, this.initialValue, iApply2, valueFilter) != iMaybeFilterValue) {
                            range.set(i, i3 - 1, iMaybeFilterValue);
                            return true;
                        }
                    }
                    while (true) {
                        i3++;
                        if ((i3 & 15) != 0) {
                            i3 = i3;
                            break;
                        }
                        i6++;
                        i2 = this.data[i6];
                        if (i2 == i5) {
                            if (valueFilter != null || maybeFilterValue(i2, this.initialValue, iApply2, valueFilter) != iMaybeFilterValue) {
                                range.set(i, i3, iMaybeFilterValue);
                                return true;
                            }
                            i5 = i2;
                        }
                    }
                } else {
                    iMaybeFilterValue = maybeFilterValue(i7, this.initialValue, iApply2, valueFilter);
                    z = true;
                }
                i5 = i7;
                while (true) {
                    i3++;
                    if ((i3 & 15) != 0) {
                        i3 = i3;
                        break;
                    }
                    i6++;
                    i2 = this.data[i6];
                    if (i2 == i5) {
                        if (valueFilter != null) {
                        }
                        range.set(i, i3, iMaybeFilterValue);
                        return true;
                    }
                }
            } else {
                int i8 = iArr[i4];
                if (z) {
                    if (i8 != i5) {
                        if (valueFilter == null || maybeFilterValue(i8, this.initialValue, iApply2, valueFilter) != iMaybeFilterValue) {
                            range.set(i, i3 - 1, iMaybeFilterValue);
                            return true;
                        }
                    }
                    i3 = (i3 + 16) & (-16);
                } else {
                    iMaybeFilterValue = maybeFilterValue(i8, this.initialValue, iApply2, valueFilter);
                    z = true;
                }
                i5 = i8;
                i3 = (i3 + 16) & (-16);
            }
            i4++;
        } while (i3 < this.highStart);
        if (maybeFilterValue(this.highValue, this.initialValue, iApply2, valueFilter) != iMaybeFilterValue) {
            range.set(i, i3 - 1, iMaybeFilterValue);
        } else {
            range.set(i, 1114111, iMaybeFilterValue);
        }
        return true;
    }

    public void set(int i, int i2) {
        if (i < 0 || 1114111 < i) {
            og.i("invalid code point");
            return;
        }
        ensureHighStart(i);
        this.data[getDataBlock(i >> 4) + (i & 15)] = i2;
    }

    public void setRange(int i, int i2, int i3) {
        if (i < 0 || 1114111 < i || i2 < 0 || 1114111 < i2 || i > i2) {
            og.i("invalid code point range");
            return;
        }
        ensureHighStart(i2);
        int i4 = i2 + 1;
        int i5 = i & 15;
        if (i5 != 0) {
            int dataBlock = getDataBlock(i >> 4);
            i = (i + 15) & (-16);
            if (i > i4) {
                fillBlock(dataBlock, i5, i4 & 15, i3);
                return;
            }
            fillBlock(dataBlock, i5, 16, i3);
        }
        int i6 = i4 & 15;
        int i7 = i4 & (-16);
        while (i < i7) {
            int i8 = i >> 4;
            byte b = this.flags[i8];
            int[] iArr = this.index;
            if (b == 0) {
                iArr[i8] = i3;
            } else {
                fillBlock(iArr[i8], 0, 16, i3);
            }
            i += 16;
        }
        if (i6 > 0) {
            fillBlock(getDataBlock(i >> 4), 0, i6, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class MixedBlocks {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int blockLength;
        private int length;
        private int mask;
        private int shift;
        private int[] table;

        public /* synthetic */ MixedBlocks(int i) {
            this();
        }

        private void addEntry(int[] iArr, char[] cArr, int i, int i2, int i3) {
            int iFindEntry = findEntry(iArr, cArr, iArr, cArr, i, i2);
            if (iFindEntry < 0) {
                this.table[~iFindEntry] = (i2 << this.shift) | (i3 + 1);
            }
        }

        private int findEntry(int[] iArr, char[] cArr, int[] iArr2, char[] cArr2, int i, int i2) {
            int i3 = i2 << this.shift;
            int iModulo = modulo(i2, this.length - 1) + 1;
            int iNextIndex = iModulo;
            while (true) {
                int i4 = this.table[iNextIndex];
                if (i4 == 0) {
                    return ~iNextIndex;
                }
                int i5 = this.mask;
                if (((~i5) & i4) == i3) {
                    int i6 = (i4 & i5) - 1;
                    int i7 = this.blockLength;
                    if (iArr != null) {
                        if (MutableCodePointTrie.equalBlocks(iArr, i6, iArr2, i, i7)) {
                            return iNextIndex;
                        }
                    } else if (iArr2 != null) {
                        if (MutableCodePointTrie.equalBlocks(cArr, i6, iArr2, i, i7)) {
                            return iNextIndex;
                        }
                    } else if (MutableCodePointTrie.equalBlocks(cArr, i6, cArr2, i, i7)) {
                        return iNextIndex;
                    }
                }
                iNextIndex = nextIndex(iModulo, iNextIndex);
            }
        }

        private int makeHashCode(int[] iArr, int i) {
            int i2 = this.blockLength + i;
            int i3 = i + 1;
            int i4 = iArr[i];
            while (true) {
                int i5 = i3 + 1;
                i4 = (i4 * 37) + iArr[i3];
                if (i5 >= i2) {
                    return i4;
                }
                i3 = i5;
            }
        }

        private int modulo(int i, int i2) {
            int i3 = i % i2;
            return i3 < 0 ? i3 + i2 : i3;
        }

        private int nextIndex(int i, int i2) {
            return (i2 + i) % this.length;
        }

        public void extend(int[] iArr, int i, int i2, int i3) {
            int i4 = this.blockLength;
            int i5 = i2 - i4;
            if (i5 >= i) {
                i = i5 + 1;
            }
            int i6 = i3 - i4;
            for (int i7 = i; i7 <= i6; i7++) {
                addEntry(iArr, null, i7, makeHashCode(iArr, i7), i7);
            }
        }

        public int findAllSameBlock(int[] iArr, int i) {
            int iFindEntry = findEntry(iArr, i, makeHashCode(i));
            if (iFindEntry < 0) {
                return -1;
            }
            return (this.mask & this.table[iFindEntry]) - 1;
        }

        public int findBlock(int[] iArr, int[] iArr2, int i) {
            int iFindEntry = findEntry(iArr, null, iArr2, null, i, makeHashCode(iArr2, i));
            if (iFindEntry >= 0) {
                return (this.table[iFindEntry] & this.mask) - 1;
            }
            return -1;
        }

        public void init(int i, int i2) {
            int i3;
            int i4 = (i - i2) + 1;
            if (i4 <= 4095) {
                this.shift = 12;
                this.mask = UCharacterProperty.SCRIPT_X_MASK;
                i3 = 6007;
            } else if (i4 <= 32767) {
                this.shift = 15;
                this.mask = 32767;
                i3 = 50021;
            } else if (i4 <= 131071) {
                this.shift = 17;
                this.mask = 131071;
                i3 = 200003;
            } else {
                this.shift = 21;
                this.mask = DictionaryData.TRANSFORM_OFFSET_MASK;
                i3 = 1500007;
            }
            int[] iArr = this.table;
            if (iArr == null || i3 > iArr.length) {
                this.table = new int[i3];
            } else {
                Arrays.fill(iArr, 0, i3, 0);
            }
            this.length = i3;
            this.blockLength = i2;
        }

        private MixedBlocks() {
        }

        private int makeHashCode(char[] cArr, int i) {
            int i2 = this.blockLength + i;
            int i3 = i + 1;
            int i4 = cArr[i];
            while (true) {
                int i5 = i3 + 1;
                int i6 = (i4 * 37) + cArr[i3];
                if (i5 >= i2) {
                    return i6;
                }
                i3 = i5;
                i4 = i6;
            }
        }

        private int makeHashCode(int i) {
            int i2 = i;
            for (int i3 = 1; i3 < this.blockLength; i3++) {
                i2 = (i2 * 37) + i;
            }
            return i2;
        }

        public void extend(char[] cArr, int i, int i2, int i3) {
            int i4 = this.blockLength;
            int i5 = i2 - i4;
            if (i5 >= i) {
                i = i5 + 1;
            }
            int i6 = i3 - i4;
            for (int i7 = i; i7 <= i6; i7++) {
                addEntry(null, cArr, i7, makeHashCode(cArr, i7), i7);
            }
        }

        public int findBlock(char[] cArr, int[] iArr, int i) {
            int iFindEntry = findEntry(null, cArr, iArr, null, i, makeHashCode(iArr, i));
            if (iFindEntry >= 0) {
                return (this.table[iFindEntry] & this.mask) - 1;
            }
            return -1;
        }

        public int findBlock(char[] cArr, char[] cArr2, int i) {
            int iFindEntry = findEntry(null, cArr, null, cArr2, i, makeHashCode(cArr2, i));
            if (iFindEntry >= 0) {
                return (this.table[iFindEntry] & this.mask) - 1;
            }
            return -1;
        }

        private int findEntry(int[] iArr, int i, int i2) {
            int i3 = i2 << this.shift;
            int iModulo = modulo(i2, this.length - 1) + 1;
            int iNextIndex = iModulo;
            while (true) {
                int i4 = this.table[iNextIndex];
                if (i4 == 0) {
                    return ~iNextIndex;
                }
                int i5 = this.mask;
                if (((~i5) & i4) == i3 && MutableCodePointTrie.allValuesSameAs(iArr, (i4 & i5) - 1, this.blockLength, i)) {
                    return iNextIndex;
                }
                iNextIndex = nextIndex(iModulo, iNextIndex);
            }
        }
    }

    private static int getOverlap(char[] cArr, int i, int[] iArr, int i2, int i3) {
        int i4 = i3 - 1;
        while (i4 > 0 && !equalBlocks(cArr, i - i4, iArr, i2, i4)) {
            i4--;
        }
        return i4;
    }

    private static int getOverlap(char[] cArr, int i, char[] cArr2, int i2, int i3) {
        int i4 = i3 - 1;
        while (i4 > 0 && !equalBlocks(cArr, i - i4, cArr2, i2, i4)) {
            i4--;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalBlocks(char[] cArr, int i, int[] iArr, int i2, int i3) {
        while (i3 > 0 && cArr[i] == iArr[i2]) {
            i++;
            i2++;
            i3--;
        }
        return i3 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalBlocks(char[] cArr, int i, char[] cArr2, int i2, int i3) {
        while (i3 > 0 && cArr[i] == cArr2[i2]) {
            i++;
            i2++;
            i3--;
        }
        return i3 == 0;
    }
}
