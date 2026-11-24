package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationData {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    static final int JAMO_CE32S_LENGTH = 67;
    static final int MAX_NUM_SPECIAL_REORDER_CODES = 8;
    static final int REORDER_RESERVED_AFTER_LATIN = 4111;
    static final int REORDER_RESERVED_BEFORE_LATIN = 4110;
    public CollationData base;
    int[] ce32s;
    long[] ces;
    public boolean[] compressibleBytes;
    String contexts;
    public char[] fastLatinTable;
    char[] fastLatinTableHeader;
    public Normalizer2Impl nfcImpl;
    int numScripts;
    public long[] rootElements;
    char[] scriptStarts;
    char[] scriptsIndex;
    Trie2_32 trie;
    UnicodeSet unsafeBackwardSet;
    int[] jamoCE32s = new int[67];
    long numericPrimary = 301989888;

    public CollationData(Normalizer2Impl normalizer2Impl) {
        this.nfcImpl = normalizer2Impl;
    }

    private int addHighScriptRange(short[] sArr, int i, int i2) {
        char[] cArr = this.scriptStarts;
        char c = cArr[i + 1];
        if ((c & 255) > (i2 & 255)) {
            i2 -= 256;
        }
        char c2 = cArr[i];
        int i3 = (c2 & 255) | ((i2 & 65280) - ((c & 65280) - (65280 & c2)));
        sArr[i] = (short) (i3 >> 8);
        return i3;
    }

    private int addLowScriptRange(short[] sArr, int i, int i2) {
        char[] cArr = this.scriptStarts;
        char c = cArr[i];
        if ((c & 255) < (i2 & 255)) {
            i2 += 256;
        }
        sArr[i] = (short) (i2 >> 8);
        char c2 = cArr[i + 1];
        return (c2 & 255) | (((c2 & 65280) - (65280 & c)) + (i2 & 65280));
    }

    private int getScriptIndex(int i) {
        int i2;
        if (i < 0) {
            return 0;
        }
        int i3 = this.numScripts;
        if (i < i3) {
            return this.scriptsIndex[i];
        }
        if (i >= 4096 && (i2 = i - 4096) < 8) {
            return this.scriptsIndex[i3 + i2];
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void makeReorderRanges(int[] iArr, boolean z, UVector32 uVector32) {
        int i;
        int i2;
        boolean z2;
        int i3;
        char[] cArr;
        short s;
        uVector32.removeAllElements();
        int length = iArr.length;
        if (length == 0) {
            return;
        }
        int i4 = 103;
        if (length == 1 && iArr[0] == 103) {
            return;
        }
        char[] cArr2 = this.scriptStarts;
        short[] sArr = new short[cArr2.length - 1];
        char[] cArr3 = this.scriptsIndex;
        int i5 = this.numScripts;
        char c = cArr3[i5 + 14];
        if (c != 0) {
            sArr[c] = 255;
        }
        char c2 = cArr3[i5 + 15];
        if (c2 != 0) {
            sArr[c2] = 255;
        }
        char c3 = cArr2[1];
        char cAddHighScriptRange = cArr2[cArr2.length - 1];
        int i6 = 0;
        for (int i7 : iArr) {
            int i8 = i7 - 4096;
            if (i8 >= 0 && i8 < 8) {
                i6 |= 1 << i8;
            }
        }
        int i9 = 0;
        int iAddLowScriptRange = c3;
        while (i9 < 8) {
            char c4 = this.scriptsIndex[this.numScripts + i9];
            if (c4 != 0 && ((1 << i9) & i6) == 0) {
                iAddLowScriptRange = addLowScriptRange(sArr, c4, iAddLowScriptRange);
            }
            i9++;
            iAddLowScriptRange = iAddLowScriptRange;
        }
        if (i6 == 0 && iArr[0] == 25 && !z) {
            char c5 = this.scriptStarts[this.scriptsIndex[25]];
            i = c5 - iAddLowScriptRange;
            i2 = c5;
        } else {
            i = 0;
            i2 = iAddLowScriptRange;
        }
        int i10 = 0;
        int iAddLowScriptRange2 = i2;
        while (true) {
            if (i10 >= length) {
                z2 = false;
                i3 = cAddHighScriptRange;
                break;
            }
            int i11 = i10 + 1;
            int i12 = iArr[i10];
            if (i12 == i4) {
                while (i11 < length) {
                    length--;
                    int i13 = iArr[length];
                    if (i13 == i4) {
                        og.i("setReorderCodes(): duplicate UScript.UNKNOWN");
                        return;
                    }
                    if (i13 == -1) {
                        og.i("setReorderCodes(): UScript.DEFAULT together with other scripts");
                        return;
                    }
                    int scriptIndex = getScriptIndex(i13);
                    if (scriptIndex != 0) {
                        if (sArr[scriptIndex] != 0) {
                            og.i(cq.j("setReorderCodes(): duplicate or equivalent script ", scriptCodeString(i13)));
                            return;
                        }
                        cAddHighScriptRange = addHighScriptRange(sArr, scriptIndex, cAddHighScriptRange);
                    }
                    i4 = 103;
                }
                z2 = true;
                i3 = cAddHighScriptRange;
                break;
            }
            if (i12 == -1) {
                og.i("setReorderCodes(): UScript.DEFAULT together with other scripts");
                return;
            }
            int scriptIndex2 = getScriptIndex(i12);
            if (scriptIndex2 != 0) {
                if (sArr[scriptIndex2] != 0) {
                    og.i(cq.j("setReorderCodes(): duplicate or equivalent script ", scriptCodeString(i12)));
                    return;
                }
                iAddLowScriptRange2 = addLowScriptRange(sArr, scriptIndex2, iAddLowScriptRange2);
            }
            i10 = i11;
            i4 = 103;
            iAddLowScriptRange2 = iAddLowScriptRange2;
        }
        int i14 = 1;
        int iAddLowScriptRange3 = iAddLowScriptRange2;
        while (true) {
            char[] cArr4 = this.scriptStarts;
            if (i14 >= cArr4.length - 1) {
                break;
            }
            if (sArr[i14] == 0) {
                char c6 = cArr4[i14];
                int i15 = iAddLowScriptRange3;
                i15 = iAddLowScriptRange3;
                if (!z2 && c6 > iAddLowScriptRange3) {
                    i15 = c6;
                }
                iAddLowScriptRange3 = addLowScriptRange(sArr, i14, i15);
            }
            i14++;
            iAddLowScriptRange3 = iAddLowScriptRange3;
        }
        if (iAddLowScriptRange3 > i3) {
            if ((iAddLowScriptRange3 == true ? 1 : 0) - (65280 & i) <= i3) {
                makeReorderRanges(iArr, true, uVector32);
                return;
            } else {
                og.q("setReorderCodes(): reordering too many partial-primary-lead-byte scripts");
                return;
            }
        }
        int i16 = 1;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            while (true) {
                cArr = this.scriptStarts;
                if (i16 >= cArr.length - 1 || !((s = sArr[i16]) == 255 || (i18 = s - (cArr[i16] >> '\b')) == i17)) {
                    break;
                } else {
                    i16++;
                }
            }
            if (i17 != 0 || i16 < cArr.length - 1) {
                uVector32.addElement((cArr[i16] << 16) | (i17 & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH));
            }
            if (i16 == this.scriptStarts.length - 1) {
                return;
            }
            i16++;
            i17 = i18;
        }
    }

    private static String scriptCodeString(int i) {
        return i < 4096 ? Integer.toString(i) : cq.j("0x", Integer.toHexString(i));
    }

    public int getCE32(int i) {
        return this.trie.get(i);
    }

    public int getCE32FromContexts(int i) {
        return this.contexts.charAt(i + 1) | (this.contexts.charAt(i) << 16);
    }

    public int getCE32FromSupplementary(int i) {
        return this.trie.get(i);
    }

    public long getCEFromOffsetCE32(int i, int i2) {
        return Collation.makeCE(Collation.getThreeBytePrimaryForOffsetData(i, this.ces[Collation.indexFromCE32(i2)]));
    }

    public int[] getEquivalentScripts(int i) {
        int scriptIndex = getScriptIndex(i);
        if (scriptIndex == 0) {
            return EMPTY_INT_ARRAY;
        }
        if (i >= 4096) {
            return new int[]{i};
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.numScripts; i3++) {
            if (this.scriptsIndex[i3] == scriptIndex) {
                i2++;
            }
        }
        int[] iArr = new int[i2];
        if (i2 == 1) {
            iArr[0] = i;
            return iArr;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.numScripts; i5++) {
            if (this.scriptsIndex[i5] == scriptIndex) {
                iArr[i4] = i5;
                i4++;
            }
        }
        return iArr;
    }

    public int getFCD16(int i) {
        return this.nfcImpl.getFCD16(i);
    }

    public int getFinalCE32(int i) {
        return Collation.isSpecialCE32(i) ? getIndirectCE32(i) : i;
    }

    public long getFirstPrimaryForGroup(int i) {
        int scriptIndex = getScriptIndex(i);
        if (scriptIndex == 0) {
            return 0L;
        }
        return ((long) this.scriptStarts[scriptIndex]) << 16;
    }

    public int getGroupForPrimary(long j) {
        long j2 = j >> 16;
        char[] cArr = this.scriptStarts;
        int i = 1;
        if (j2 >= cArr[1] && cArr[cArr.length - 1] > j2) {
            while (true) {
                int i2 = i + 1;
                if (j2 < this.scriptStarts[i2]) {
                    break;
                }
                i = i2;
            }
            for (int i3 = 0; i3 < this.numScripts; i3++) {
                if (this.scriptsIndex[i3] == i) {
                    return i3;
                }
            }
            for (int i4 = 0; i4 < 8; i4++) {
                if (this.scriptsIndex[this.numScripts + i4] == i) {
                    return i4 + 4096;
                }
            }
        }
        return -1;
    }

    public int getIndirectCE32(int i) {
        int iTagFromCE32 = Collation.tagFromCE32(i);
        if (iTagFromCE32 == 10) {
            return this.ce32s[Collation.indexFromCE32(i)];
        }
        if (iTagFromCE32 == 13) {
            return -1;
        }
        return iTagFromCE32 == 11 ? this.ce32s[0] : i;
    }

    public long getLastPrimaryForGroup(int i) {
        int scriptIndex = getScriptIndex(i);
        if (scriptIndex == 0) {
            return 0L;
        }
        return (((long) this.scriptStarts[scriptIndex + 1]) << 16) - 1;
    }

    public long getSingleCE(int i) {
        int ce32 = getCE32(i);
        if (ce32 == 192) {
            this = this.base;
            ce32 = this.getCE32(i);
        }
        while (Collation.isSpecialCE32(ce32)) {
            switch (Collation.tagFromCE32(ce32)) {
                case 0:
                case 3:
                    throw new AssertionError(String.format("unexpected CE32 tag for U+%04X (CE32 0x%08x)", Integer.valueOf(i), Integer.valueOf(ce32)));
                case 1:
                    return Collation.ceFromLongPrimaryCE32(ce32);
                case 2:
                    return Collation.ceFromLongSecondaryCE32(ce32);
                case 4:
                case 7:
                case 8:
                case 9:
                case 12:
                case 13:
                    throw new UnsupportedOperationException(String.format("there is not exactly one collation element for U+%04X (CE32 0x%08x)", Integer.valueOf(i), Integer.valueOf(ce32)));
                case 5:
                    if (Collation.lengthFromCE32(ce32) != 1) {
                        throw new UnsupportedOperationException(String.format("there is not exactly one collation element for U+%04X (CE32 0x%08x)", Integer.valueOf(i), Integer.valueOf(ce32)));
                    }
                    ce32 = this.ce32s[Collation.indexFromCE32(ce32)];
                    break;
                    break;
                case 6:
                    if (Collation.lengthFromCE32(ce32) == 1) {
                        return this.ces[Collation.indexFromCE32(ce32)];
                    }
                    throw new UnsupportedOperationException(String.format("there is not exactly one collation element for U+%04X (CE32 0x%08x)", Integer.valueOf(i), Integer.valueOf(ce32)));
                case 10:
                    ce32 = this.ce32s[Collation.indexFromCE32(ce32)];
                    break;
                case 11:
                    ce32 = this.ce32s[0];
                    break;
                case 14:
                    return this.getCEFromOffsetCE32(i, ce32);
                case 15:
                    return Collation.unassignedCEFromCodePoint(i);
            }
        }
        return Collation.ceFromSimpleCE32(ce32);
    }

    public boolean isCompressibleLeadByte(int i) {
        return this.compressibleBytes[i];
    }

    public boolean isCompressiblePrimary(long j) {
        return isCompressibleLeadByte(((int) j) >>> 24);
    }

    public boolean isDigit(int i) {
        if (i < 1632) {
            return i <= 57 && 48 <= i;
        }
        return Collation.hasCE32Tag(getCE32(i), 10);
    }

    public boolean isUnsafeBackward(int i, boolean z) {
        if (this.unsafeBackwardSet.contains(i)) {
            return true;
        }
        return z && isDigit(i);
    }

    public void makeReorderRanges(int[] iArr, UVector32 uVector32) {
        makeReorderRanges(iArr, false, uVector32);
    }
}
