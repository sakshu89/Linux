package com.ibm.icu.impl;

import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.CodePointMap;
import com.ibm.icu.util.CodePointTrie;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.MutableCodePointTrie;
import com.ibm.icu.util.VersionInfo;
import defpackage.kf2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Normalizer2Impl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CANON_HAS_COMPOSITIONS = 1073741824;
    private static final int CANON_HAS_SET = 2097152;
    private static final int CANON_NOT_SEGMENT_STARTER = Integer.MIN_VALUE;
    private static final int CANON_VALUE_MASK = 2097151;
    public static final int COMP_1_LAST_TUPLE = 32768;
    public static final int COMP_1_TRAIL_LIMIT = 13312;
    public static final int COMP_1_TRAIL_MASK = 32766;
    public static final int COMP_1_TRAIL_SHIFT = 9;
    public static final int COMP_1_TRIPLE = 1;
    public static final int COMP_2_TRAIL_MASK = 65472;
    public static final int COMP_2_TRAIL_SHIFT = 6;
    private static final int DATA_FORMAT = 1316121906;
    public static final int DELTA_SHIFT = 3;
    public static final int DELTA_TCCC_0 = 0;
    public static final int DELTA_TCCC_1 = 2;
    public static final int DELTA_TCCC_GT_1 = 4;
    public static final int DELTA_TCCC_MASK = 6;
    public static final int HAS_COMP_BOUNDARY_AFTER = 1;
    public static final int INERT = 1;
    public static final int IX_EXTRA_DATA_OFFSET = 1;
    public static final int IX_LIMIT_NO_NO = 12;
    public static final int IX_MIN_COMP_NO_MAYBE_CP = 9;
    public static final int IX_MIN_DECOMP_NO_CP = 8;
    public static final int IX_MIN_LCCC_CP = 18;
    public static final int IX_MIN_MAYBE_NO = 20;
    public static final int IX_MIN_MAYBE_NO_COMBINES_FWD = 21;
    public static final int IX_MIN_MAYBE_YES = 13;
    public static final int IX_MIN_NO_NO = 11;
    public static final int IX_MIN_NO_NO_COMP_BOUNDARY_BEFORE = 15;
    public static final int IX_MIN_NO_NO_COMP_NO_MAYBE_CC = 16;
    public static final int IX_MIN_NO_NO_EMPTY = 17;
    public static final int IX_MIN_YES_NO = 10;
    public static final int IX_MIN_YES_NO_MAPPINGS_ONLY = 14;
    public static final int IX_NORM_TRIE_OFFSET = 0;
    public static final int IX_RESERVED3_OFFSET = 3;
    public static final int IX_SMALL_FCD_OFFSET = 2;
    public static final int IX_TOTAL_SIZE = 7;
    public static final int JAMO_L = 2;
    public static final int JAMO_VT = 65024;
    public static final int MAPPING_HAS_CCC_LCCC_WORD = 128;
    public static final int MAPPING_HAS_RAW_MAPPING = 64;
    public static final int MAPPING_LENGTH_MASK = 31;
    public static final int MAX_DELTA = 64;
    public static final int MIN_NORMAL_MAYBE_YES = 64512;
    public static final int MIN_YES_YES_WITH_CC = 65026;
    public static final int OFFSET_SHIFT = 1;
    private CodePointTrie canonIterData;
    private ArrayList<UnicodeSet> canonStartSets;
    private int centerNoNoDelta;
    private VersionInfo dataVersion;
    private String extraData;
    private int limitNoNo;
    private int minCompNoMaybeCP;
    private int minDecompNoCP;
    private int minLcccCP;
    private int minMaybeNo;
    private int minMaybeNoCombinesFwd;
    private int minMaybeYes;
    private int minNoNo;
    private int minNoNoCompBoundaryBefore;
    private int minNoNoCompNoMaybeCC;
    private int minNoNoEmpty;
    private int minYesNo;
    private int minYesNoMappingsOnly;
    private CodePointTrie.Fast16 normTrie;
    private byte[] smallFCD;
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
    private static final CodePointMap.ValueFilter segmentStarterMapper = new CodePointMap.ValueFilter() { // from class: com.ibm.icu.impl.Normalizer2Impl.1
        @Override // com.ibm.icu.util.CodePointMap.ValueFilter
        public int apply(int i) {
            return Normalizer2Impl.CANON_NOT_SEGMENT_STARTER & i;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Hangul {
        public static final int HANGUL_BASE = 44032;
        public static final int HANGUL_COUNT = 11172;
        public static final int HANGUL_END = 55203;
        public static final int HANGUL_LIMIT = 55204;
        public static final int JAMO_L_BASE = 4352;
        public static final int JAMO_L_COUNT = 19;
        public static final int JAMO_L_END = 4370;
        public static final int JAMO_L_LIMIT = 4371;
        public static final int JAMO_T_BASE = 4519;
        public static final int JAMO_T_COUNT = 28;
        public static final int JAMO_T_END = 4546;
        public static final int JAMO_VT_COUNT = 588;
        public static final int JAMO_V_BASE = 4449;
        public static final int JAMO_V_COUNT = 21;
        public static final int JAMO_V_END = 4469;
        public static final int JAMO_V_LIMIT = 4470;

        public static int decompose(int i, Appendable appendable) {
            int i2 = i - HANGUL_BASE;
            try {
                int i3 = i2 % 28;
                int i4 = i2 / 28;
                appendable.append((char) ((i4 / 21) + JAMO_L_BASE));
                appendable.append((char) ((i4 % 21) + JAMO_V_BASE));
                if (i3 == 0) {
                    return 2;
                }
                appendable.append((char) (i3 + JAMO_T_BASE));
                return 3;
            } catch (IOException e) {
                kf2.h(e);
                return 0;
            }
        }

        public static void getRawDecomposition(int i, Appendable appendable) {
            int i2 = i - HANGUL_BASE;
            try {
                int i3 = i2 % 28;
                if (i3 != 0) {
                    appendable.append((char) (i - i3));
                    appendable.append((char) (i3 + JAMO_T_BASE));
                } else {
                    int i4 = i2 / 28;
                    appendable.append((char) ((i4 / 21) + JAMO_L_BASE));
                    appendable.append((char) ((i4 % 21) + JAMO_V_BASE));
                }
            } catch (IOException e) {
                kf2.h(e);
            }
        }

        public static boolean isHangul(int i) {
            return 44032 <= i && i < 55204;
        }

        public static boolean isHangulLV(int i) {
            int i2 = i - HANGUL_BASE;
            return i2 >= 0 && i2 < 11172 && i2 % 28 == 0;
        }

        public static boolean isJamo(int i) {
            if (4352 > i || i > 4546) {
                return false;
            }
            if (i > 4370) {
                return (4449 <= i && i <= 4469) || 4519 < i;
            }
            return true;
        }

        public static boolean isJamoL(int i) {
            return 4352 <= i && i < 4371;
        }

        public static boolean isJamoT(int i) {
            int i2 = i - 4519;
            return i2 > 0 && i2 < 28;
        }

        public static boolean isJamoV(int i) {
            return 4449 <= i && i < 4470;
        }
    }

    private void addComposites(int i, UnicodeSet unicodeSet) {
        char cCharAt;
        int iCharAt;
        do {
            cCharAt = this.extraData.charAt(i);
            int i2 = cCharAt & 1;
            String str = this.extraData;
            if (i2 == 0) {
                iCharAt = str.charAt(i + 1);
                i += 2;
            } else {
                iCharAt = ((str.charAt(i + 1) & '?') << 16) | this.extraData.charAt(i + 2);
                i += 3;
            }
            int i3 = iCharAt >> 1;
            if ((iCharAt & 1) != 0) {
                addComposites(getCompositionsListForComposite(getRawNorm16(i3)), unicodeSet);
            }
            unicodeSet.add(i3);
        } while ((cCharAt & 32768) == 0);
    }

    private void addToStartSet(MutableCodePointTrie mutableCodePointTrie, int i, int i2) {
        UnicodeSet unicodeSet;
        int i3 = mutableCodePointTrie.get(i2);
        if ((4194303 & i3) == 0 && i != 0) {
            mutableCodePointTrie.set(i2, i3 | i);
            return;
        }
        int i4 = i3 & 2097152;
        ArrayList<UnicodeSet> arrayList = this.canonStartSets;
        if (i4 == 0) {
            int i5 = i3 & 2097151;
            mutableCodePointTrie.set(i2, (i3 & (-2097152)) | 2097152 | arrayList.size());
            ArrayList<UnicodeSet> arrayList2 = this.canonStartSets;
            unicodeSet = new UnicodeSet();
            arrayList2.add(unicodeSet);
            if (i5 != 0) {
                unicodeSet.add(i5);
            }
        } else {
            unicodeSet = arrayList.get(i3 & 2097151);
        }
        unicodeSet.add(i);
    }

    private int combine(int i, int i2) {
        char cCharAt;
        if (i2 < 13312) {
            int i3 = i2 << 1;
            while (true) {
                cCharAt = this.extraData.charAt(i);
                if (i3 <= cCharAt) {
                    break;
                }
                i += (cCharAt & 1) + 2;
            }
            if (i3 != (cCharAt & 32766)) {
                return -1;
            }
            int i4 = cCharAt & 1;
            String str = this.extraData;
            if (i4 == 0) {
                return str.charAt(i + 1);
            }
            return this.extraData.charAt(i + 2) | (str.charAt(i + 1) << 16);
        }
        int i5 = ((i2 >> 9) & (-2)) + COMP_1_TRAIL_LIMIT;
        int i6 = (i2 << 6) & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
        while (true) {
            char cCharAt2 = this.extraData.charAt(i);
            if (i5 > cCharAt2) {
                i += (cCharAt2 & 1) + 2;
            } else {
                if (i5 != (cCharAt2 & 32766)) {
                    return -1;
                }
                char cCharAt3 = this.extraData.charAt(i + 1);
                if (i6 <= cCharAt3) {
                    if (i6 != (65472 & cCharAt3)) {
                        return -1;
                    }
                    return this.extraData.charAt(i + 2) | (('?' & cCharAt3) << 16);
                }
                if ((cCharAt2 & 32768) != 0) {
                    return -1;
                }
                i += 3;
            }
        }
    }

    private int decomposeShort(CharSequence charSequence, int i, int i2, boolean z, boolean z2, ReorderingBuffer reorderingBuffer) {
        while (i < i2) {
            int iCodePointAt = Character.codePointAt(charSequence, i);
            if (z && iCodePointAt < this.minCompNoMaybeCP) {
                break;
            }
            int norm16 = getNorm16(iCodePointAt);
            if (!z || !norm16HasCompBoundaryBefore(norm16)) {
                i += Character.charCount(iCodePointAt);
                decompose(iCodePointAt, norm16, reorderingBuffer);
                if (z && norm16HasCompBoundaryAfter(norm16, z2)) {
                    break;
                }
            } else {
                break;
            }
        }
        return i;
    }

    private int findNextCompBoundary(CharSequence charSequence, int i, int i2, boolean z) {
        while (i < i2) {
            int iCodePointAt = Character.codePointAt(charSequence, i);
            int i3 = this.normTrie.get(iCodePointAt);
            if (hasCompBoundaryBefore(iCodePointAt, i3)) {
                break;
            }
            i += Character.charCount(iCodePointAt);
            if (norm16HasCompBoundaryAfter(i3, z)) {
                break;
            }
        }
        return i;
    }

    private int findNextFCDBoundary(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int iCodePointAt = Character.codePointAt(charSequence, i);
            if (iCodePointAt < this.minLcccCP) {
                break;
            }
            int norm16 = getNorm16(iCodePointAt);
            if (norm16HasDecompBoundaryBefore(norm16)) {
                break;
            }
            i += Character.charCount(iCodePointAt);
            if (norm16HasDecompBoundaryAfter(norm16)) {
                break;
            }
        }
        return i;
    }

    private int findPreviousCompBoundary(CharSequence charSequence, int i, boolean z) {
        while (i > 0) {
            int iCodePointBefore = Character.codePointBefore(charSequence, i);
            int norm16 = getNorm16(iCodePointBefore);
            if (norm16HasCompBoundaryAfter(norm16, z)) {
                break;
            }
            i -= Character.charCount(iCodePointBefore);
            if (hasCompBoundaryBefore(iCodePointBefore, norm16)) {
                break;
            }
        }
        return i;
    }

    private int findPreviousFCDBoundary(CharSequence charSequence, int i) {
        while (i > 0) {
            int iCodePointBefore = Character.codePointBefore(charSequence, i);
            if (iCodePointBefore < this.minDecompNoCP) {
                break;
            }
            int norm16 = getNorm16(iCodePointBefore);
            if (norm16HasDecompBoundaryAfter(norm16)) {
                break;
            }
            i -= Character.charCount(iCodePointBefore);
            if (norm16HasDecompBoundaryBefore(norm16)) {
                break;
            }
        }
        return i;
    }

    private int getCCFromNoNo(int i) {
        int dataForYesOrNo = getDataForYesOrNo(i);
        if ((this.extraData.charAt(dataForYesOrNo) & 128) != 0) {
            return this.extraData.charAt(dataForYesOrNo - 1) & 255;
        }
        return 0;
    }

    public static int getCCFromNormalYesOrMaybe(int i) {
        return (i >> 1) & 255;
    }

    public static int getCCFromYesOrMaybeYes(int i) {
        if (i >= 64512) {
            return getCCFromNormalYesOrMaybe(i);
        }
        return 0;
    }

    private int getCompositionsList(int i) {
        return isDecompYes(i) ? getCompositionsListForDecompYes(i) : getCompositionsListForComposite(i);
    }

    private int getCompositionsListForComposite(int i) {
        int data = getData(i);
        return data + 1 + (this.extraData.charAt(data) & 31);
    }

    private int getCompositionsListForDecompYes(int i) {
        if (i < 2 || 64512 <= i) {
            return -1;
        }
        return getData(i);
    }

    private int getData(int i) {
        int i2 = this.minMaybeNo;
        if (i >= i2) {
            i = (i - i2) + this.limitNoNo;
        }
        return i >> 1;
    }

    private int getDataForMaybe(int i) {
        return ((i - this.minMaybeNo) + this.limitNoNo) >> 1;
    }

    private int getDataForYesOrNo(int i) {
        return i >> 1;
    }

    private int getFCD16FromMaybeOrNonZeroCC(int i) {
        if (i >= 64512) {
            int cCFromNormalYesOrMaybe = getCCFromNormalYesOrMaybe(i);
            return cCFromNormalYesOrMaybe | (cCFromNormalYesOrMaybe << 8);
        }
        if (i >= this.minMaybeYes) {
            return 0;
        }
        return this.extraData.charAt(getDataForMaybe(i)) >> '\b';
    }

    private int getPreviousTrailCC(CharSequence charSequence, int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return getFCD16(Character.codePointBefore(charSequence, i2));
    }

    private int hangulLVT() {
        return this.minYesNoMappingsOnly | 1;
    }

    private boolean hasCompBoundaryAfter(CharSequence charSequence, int i, int i2, boolean z) {
        return i == i2 || hasCompBoundaryAfter(Character.codePointBefore(charSequence, i2), z);
    }

    private boolean isCompYesAndZeroCC(int i) {
        return i < this.minNoNo;
    }

    private boolean isDecompNoAlgorithmic(int i) {
        return this.limitNoNo <= i && i < this.minMaybeNo;
    }

    private boolean isDecompYesAndZeroCC(int i) {
        if (i < this.minYesNo || i == 65024) {
            return true;
        }
        return this.minMaybeYes <= i && i <= 64512;
    }

    private boolean isHangulLV(int i) {
        return i == this.minYesNo;
    }

    private boolean isHangulLVT(int i) {
        return i == hangulLVT();
    }

    private static boolean isInert(int i) {
        return i == 1;
    }

    private static boolean isJamoL(int i) {
        return i == 2;
    }

    private static boolean isJamoVT(int i) {
        return i == 65024;
    }

    private boolean isMaybe(int i) {
        return this.minMaybeNo <= i && i <= 65024;
    }

    private boolean isMaybeYesOrNonZeroCC(int i) {
        return i >= this.minMaybeYes;
    }

    private boolean isMostDecompYesAndZeroCC(int i) {
        return i < this.minYesNo || i == 64512 || i == 65024;
    }

    private boolean isTrailCC01ForCompBoundaryAfter(int i) {
        if (isInert(i)) {
            return true;
        }
        if (isDecompNoAlgorithmic(i)) {
            return (i & 6) <= 2;
        }
        return this.extraData.charAt(getDataForYesOrNo(i)) <= 511;
    }

    private int mapAlgorithmic(int i, int i2) {
        return (i + (i2 >> 3)) - this.centerNoNoDelta;
    }

    private boolean norm16HasCompBoundaryAfter(int i, boolean z) {
        if ((i & 1) != 0) {
            return !z || isTrailCC01ForCompBoundaryAfter(i);
        }
        return false;
    }

    private boolean norm16HasCompBoundaryBefore(int i) {
        return i < this.minNoNoCompNoMaybeCC || isAlgorithmicNoNo(i);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e6 A[EDGE_INSN: B:62:0x00e6->B:46:0x00e6 BREAK  A[LOOP:0: B:6:0x0013->B:72:0x0013], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0079 A[SYNTHETIC] */
    private void recompose(ReorderingBuffer reorderingBuffer, int i, boolean z) {
        char cCharAt;
        char cCharAt2;
        StringBuilder stringBuilder = reorderingBuffer.getStringBuilder();
        int iCharCount = i;
        if (iCharCount == stringBuilder.length()) {
            return;
        }
        int i2 = 0;
        boolean z2 = false;
        int compositionsListForDecompYes = -1;
        int i3 = -1;
        while (true) {
            int iCodePointAt = stringBuilder.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            int norm16 = getNorm16(iCodePointAt);
            int cCFromYesOrMaybeYes = getCCFromYesOrMaybeYes(norm16);
            if (isMaybe(norm16) && compositionsListForDecompYes >= 0 && (i2 < cCFromYesOrMaybeYes || i2 == 0)) {
                if (isJamoVT(norm16)) {
                    if (iCodePointAt < 4519 && (cCharAt = (char) (stringBuilder.charAt(i3) - 4352)) < 19) {
                        int i4 = iCharCount - 1;
                        char c = (char) ((((iCodePointAt - 4449) + (cCharAt * 21)) * 28) + Hangul.HANGUL_BASE);
                        if (iCharCount != stringBuilder.length() && (cCharAt2 = (char) (stringBuilder.charAt(iCharCount) - Hangul.JAMO_T_BASE)) < 28) {
                            iCharCount++;
                            c = (char) (c + cCharAt2);
                        }
                        stringBuilder.setCharAt(i3, c);
                        stringBuilder.delete(i4, iCharCount);
                        iCharCount = i4;
                    }
                    if (iCharCount == stringBuilder.length()) {
                        break;
                    }
                } else {
                    int iCombine = combine(compositionsListForDecompYes, iCodePointAt);
                    if (iCombine >= 0) {
                        int i5 = iCombine >> 1;
                        int iCharCount2 = iCharCount - Character.charCount(iCodePointAt);
                        stringBuilder.delete(iCharCount2, iCharCount);
                        if (!z2) {
                            if (i5 > 65535) {
                                stringBuilder.setCharAt(i3, UTF16.getLeadSurrogate(i5));
                                stringBuilder.insert(i3 + 1, UTF16.getTrailSurrogate(i5));
                                iCharCount = iCharCount2 + 1;
                                z2 = true;
                            } else {
                                stringBuilder.setCharAt(i3, (char) i5);
                            }
                            if (iCharCount == stringBuilder.length()) {
                                break;
                            } else {
                                compositionsListForDecompYes = (iCombine & 1) != 0 ? getCompositionsListForComposite(getRawNorm16(i5)) : -1;
                            }
                        } else if (i5 > 65535) {
                            stringBuilder.setCharAt(i3, UTF16.getLeadSurrogate(i5));
                            stringBuilder.setCharAt(i3 + 1, UTF16.getTrailSurrogate(i5));
                        } else {
                            stringBuilder.setCharAt(i3, (char) iCodePointAt);
                            stringBuilder.deleteCharAt(i3 + 1);
                            iCharCount2--;
                            z2 = false;
                        }
                        iCharCount = iCharCount2;
                        if (iCharCount == stringBuilder.length()) {
                            break;
                            break;
                        } else if ((iCombine & 1) != 0) {
                        }
                    }
                }
            }
            if (iCharCount == stringBuilder.length()) {
                break;
            }
            if (cCFromYesOrMaybeYes == 0) {
                compositionsListForDecompYes = getCompositionsListForDecompYes(norm16);
                if (compositionsListForDecompYes >= 0) {
                    if (iCodePointAt <= 65535) {
                        i3 = iCharCount - 1;
                        z2 = false;
                    } else {
                        i3 = iCharCount - 2;
                        i2 = cCFromYesOrMaybeYes;
                        z2 = true;
                    }
                }
            } else if (z) {
                compositionsListForDecompYes = -1;
            }
            i2 = cCFromYesOrMaybeYes;
        }
        reorderingBuffer.flush();
    }

    public void addCanonIterPropertyStarts(UnicodeSet unicodeSet) {
        ensureCanonIterData();
        CodePointMap.Range range = new CodePointMap.Range();
        for (int end = 0; this.canonIterData.getRange(end, segmentStarterMapper, range); end = range.getEnd() + 1) {
            unicodeSet.add(end);
        }
    }

    public void addLcccChars(UnicodeSet unicodeSet) {
        CodePointMap.Range range = new CodePointMap.Range();
        int i = 0;
        while (this.normTrie.getRange(i, CodePointMap.RangeOption.FIXED_LEAD_SURROGATES, 1, null, range)) {
            int end = range.getEnd();
            int value = range.getValue();
            if (value > 64512 && value != 65024) {
                unicodeSet.add(i, end);
            } else if (this.minNoNoCompNoMaybeCC <= value && value < this.limitNoNo && getFCD16(i) > 255) {
                unicodeSet.add(i, end);
            }
            i = end + 1;
        }
    }

    public void addPropertyStarts(UnicodeSet unicodeSet) {
        CodePointMap.Range range = new CodePointMap.Range();
        int i = 0;
        while (this.normTrie.getRange(i, CodePointMap.RangeOption.FIXED_LEAD_SURROGATES, 1, null, range)) {
            int end = range.getEnd();
            int value = range.getValue();
            unicodeSet.add(i);
            if (i != end && isAlgorithmicNoNo(value) && (value & 6) > 2) {
                int fcd16 = getFCD16(i);
                while (true) {
                    i++;
                    if (i <= end) {
                        int fcd17 = getFCD16(i);
                        if (fcd17 != fcd16) {
                            unicodeSet.add(i);
                            fcd16 = fcd17;
                        }
                    }
                }
            }
            i = end + 1;
        }
        for (int i2 = Hangul.HANGUL_BASE; i2 < 55204; i2 += 28) {
            unicodeSet.add(i2);
            unicodeSet.add(i2 + 1);
        }
        unicodeSet.add(Hangul.HANGUL_LIMIT);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0178  */
    /* JADX WARN: Code duplicated, block: B:116:0x018e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0195 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:125:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:144:0x01be A[SYNTHETIC] */
    public boolean compose(CharSequence charSequence, int i, int i2, boolean z, boolean z2, ReorderingBuffer reorderingBuffer) {
        int i3;
        int iCodePointBefore;
        int iCodePointAt;
        int i4;
        int iCharAt;
        Normalizer2Impl normalizer2Impl = this;
        CharSequence charSequence2 = charSequence;
        int i5 = i2;
        boolean z3 = z;
        ReorderingBuffer reorderingBuffer2 = reorderingBuffer;
        int i6 = normalizer2Impl.minCompNoMaybeCP;
        int iDecomposeShort = i;
        while (true) {
            int i7 = iDecomposeShort;
            while (true) {
                if (iDecomposeShort == i5) {
                    if (i7 != i5 && z2) {
                        reorderingBuffer2.append(charSequence2, i7, i5);
                    }
                    return true;
                }
                int iCharAt2 = charSequence2.charAt(iDecomposeShort);
                if (iCharAt2 >= i6) {
                    int iBmpGet = normalizer2Impl.normTrie.bmpGet(iCharAt2);
                    if (!normalizer2Impl.isCompYesAndZeroCC(iBmpGet)) {
                        int iCharCount = iDecomposeShort + 1;
                        if (UTF16Plus.isLeadSurrogate(iCharAt2)) {
                            if (iCharCount != i5) {
                                char cCharAt = charSequence2.charAt(iCharCount);
                                if (Character.isLowSurrogate(cCharAt)) {
                                    iCharCount = iDecomposeShort + 2;
                                    iCharAt2 = Character.toCodePoint((char) iCharAt2, cCharAt);
                                    iBmpGet = normalizer2Impl.normTrie.suppGet(iCharAt2);
                                    if (!normalizer2Impl.isCompYesAndZeroCC(iBmpGet)) {
                                    }
                                }
                            }
                            iDecomposeShort = iCharCount;
                            i5 = i2;
                        }
                        if (iBmpGet >= normalizer2Impl.minMaybeNo) {
                            if (isJamoVT(iBmpGet) && i7 != iDecomposeShort) {
                                char cCharAt2 = charSequence2.charAt(iDecomposeShort - 1);
                                if (iCharAt2 < 4519) {
                                    char c = (char) (cCharAt2 - 4352);
                                    if (c < 19) {
                                        if (!z2) {
                                            return false;
                                        }
                                        if (iCharCount == i5 || (iCharAt = charSequence2.charAt(iCharCount) - Hangul.JAMO_T_BASE) <= 0 || iCharAt >= 28) {
                                            iCharAt = normalizer2Impl.hasCompBoundaryBefore(charSequence2, iCharCount, i5) ? 0 : -1;
                                        } else {
                                            iCharCount++;
                                        }
                                        if (iCharAt >= 0) {
                                            int i8 = (((iCharAt2 - 4449) + (c * 21)) * 28) + Hangul.HANGUL_BASE + iCharAt;
                                            int i9 = iDecomposeShort - 1;
                                            if (i7 != i9) {
                                                reorderingBuffer2.append(charSequence2, i7, i9);
                                            }
                                            reorderingBuffer2.append((char) i8);
                                            iDecomposeShort = iCharCount;
                                        }
                                    }
                                } else if (Hangul.isHangulLV(cCharAt2)) {
                                    if (!z2) {
                                        return false;
                                    }
                                    int i10 = (cCharAt2 + iCharAt2) - Hangul.JAMO_T_BASE;
                                    int i11 = iDecomposeShort - 1;
                                    if (i7 != i11) {
                                        reorderingBuffer2.append(charSequence2, i7, i11);
                                    }
                                    reorderingBuffer2.append((char) i10);
                                    iDecomposeShort = iCharCount;
                                }
                            } else if (iBmpGet > 65024) {
                                int cCFromNormalYesOrMaybe = getCCFromNormalYesOrMaybe(iBmpGet);
                                if (!z3 || normalizer2Impl.getPreviousTrailCC(charSequence2, i7, iDecomposeShort) <= cCFromNormalYesOrMaybe) {
                                    while (true) {
                                        if (iCharCount == i5) {
                                            if (z2) {
                                                reorderingBuffer2.append(charSequence2, i7, i5);
                                            }
                                            return true;
                                        }
                                        iCodePointAt = Character.codePointAt(charSequence2, iCharCount);
                                        i4 = normalizer2Impl.normTrie.get(iCodePointAt);
                                        if (i4 < 65026) {
                                            break;
                                        }
                                        int cCFromNormalYesOrMaybe2 = getCCFromNormalYesOrMaybe(i4);
                                        if (cCFromNormalYesOrMaybe > cCFromNormalYesOrMaybe2) {
                                            if (z2) {
                                                break;
                                            }
                                            return false;
                                        }
                                        iCharCount += Character.charCount(iCodePointAt);
                                        cCFromNormalYesOrMaybe = cCFromNormalYesOrMaybe2;
                                    }
                                    if (normalizer2Impl.norm16HasCompBoundaryBefore(i4)) {
                                        iDecomposeShort = normalizer2Impl.isCompYesAndZeroCC(i4) ? Character.charCount(iCodePointAt) + iCharCount : iCharCount;
                                    }
                                } else if (!z2) {
                                    return false;
                                }
                            }
                            if (i7 != iDecomposeShort) {
                                iCodePointBefore = Character.codePointBefore(charSequence2, iDecomposeShort);
                                if (!normalizer2Impl.norm16HasCompBoundaryAfter(normalizer2Impl.normTrie.get(iCodePointBefore), z3)) {
                                    iDecomposeShort -= Character.charCount(iCodePointBefore);
                                }
                            }
                            if (z2) {
                                reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                            }
                            int length = reorderingBuffer2.length();
                            int i12 = iCharCount;
                            normalizer2Impl.decomposeShort(charSequence2, iDecomposeShort, i12, false, z3, reorderingBuffer2);
                            i3 = iDecomposeShort;
                            normalizer2Impl = this;
                            charSequence2 = charSequence;
                            z3 = z;
                            reorderingBuffer2 = reorderingBuffer;
                            iDecomposeShort = normalizer2Impl.decomposeShort(charSequence2, i12, i5, true, z3, reorderingBuffer2);
                            normalizer2Impl.recompose(reorderingBuffer2, length, z3);
                            if (!z2) {
                                if (!reorderingBuffer2.equals(charSequence2, i3, iDecomposeShort)) {
                                    return false;
                                }
                                reorderingBuffer2.remove();
                            }
                            i5 = i2;
                        } else {
                            if (!z2) {
                                return false;
                            }
                            if (normalizer2Impl.isDecompNoAlgorithmic(iBmpGet)) {
                                if (normalizer2Impl.norm16HasCompBoundaryAfter(iBmpGet, z3) || normalizer2Impl.hasCompBoundaryBefore(charSequence2, iCharCount, i5)) {
                                    if (i7 != iDecomposeShort) {
                                        reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                    }
                                    reorderingBuffer2.append(normalizer2Impl.mapAlgorithmic(iCharAt2, iBmpGet), 0);
                                    iDecomposeShort = iCharCount;
                                } else {
                                    if (i7 != iDecomposeShort && !normalizer2Impl.norm16HasCompBoundaryBefore(iBmpGet)) {
                                        iCodePointBefore = Character.codePointBefore(charSequence2, iDecomposeShort);
                                        if (!normalizer2Impl.norm16HasCompBoundaryAfter(normalizer2Impl.normTrie.get(iCodePointBefore), z3)) {
                                            iDecomposeShort -= Character.charCount(iCodePointBefore);
                                        }
                                    }
                                    if (z2 && i7 != iDecomposeShort) {
                                        reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                    }
                                    int length2 = reorderingBuffer2.length();
                                    int i13 = iCharCount;
                                    normalizer2Impl.decomposeShort(charSequence2, iDecomposeShort, i13, false, z3, reorderingBuffer2);
                                    i3 = iDecomposeShort;
                                    normalizer2Impl = this;
                                    charSequence2 = charSequence;
                                    z3 = z;
                                    reorderingBuffer2 = reorderingBuffer;
                                    iDecomposeShort = normalizer2Impl.decomposeShort(charSequence2, i13, i5, true, z3, reorderingBuffer2);
                                    normalizer2Impl.recompose(reorderingBuffer2, length2, z3);
                                    if (!z2) {
                                        if (!reorderingBuffer2.equals(charSequence2, i3, iDecomposeShort)) {
                                            return false;
                                        }
                                        reorderingBuffer2.remove();
                                    }
                                    i5 = i2;
                                }
                            } else if (iBmpGet < normalizer2Impl.minNoNoCompBoundaryBefore) {
                                if (normalizer2Impl.norm16HasCompBoundaryAfter(iBmpGet, z3) || normalizer2Impl.hasCompBoundaryBefore(charSequence2, iCharCount, i5)) {
                                    if (i7 != iDecomposeShort) {
                                        reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                    }
                                    int dataForYesOrNo = normalizer2Impl.getDataForYesOrNo(iBmpGet);
                                    int i14 = dataForYesOrNo + 1;
                                    reorderingBuffer2.append((CharSequence) normalizer2Impl.extraData, i14, (normalizer2Impl.extraData.charAt(dataForYesOrNo) & 31) + i14);
                                    iDecomposeShort = iCharCount;
                                } else {
                                    if (i7 != iDecomposeShort) {
                                        iCodePointBefore = Character.codePointBefore(charSequence2, iDecomposeShort);
                                        if (!normalizer2Impl.norm16HasCompBoundaryAfter(normalizer2Impl.normTrie.get(iCodePointBefore), z3)) {
                                            iDecomposeShort -= Character.charCount(iCodePointBefore);
                                        }
                                    }
                                    if (z2) {
                                        reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                    }
                                    int length3 = reorderingBuffer2.length();
                                    int i15 = iCharCount;
                                    normalizer2Impl.decomposeShort(charSequence2, iDecomposeShort, i15, false, z3, reorderingBuffer2);
                                    i3 = iDecomposeShort;
                                    normalizer2Impl = this;
                                    charSequence2 = charSequence;
                                    z3 = z;
                                    reorderingBuffer2 = reorderingBuffer;
                                    iDecomposeShort = normalizer2Impl.decomposeShort(charSequence2, i15, i5, true, z3, reorderingBuffer2);
                                    normalizer2Impl.recompose(reorderingBuffer2, length3, z3);
                                    if (!z2) {
                                        if (!reorderingBuffer2.equals(charSequence2, i3, iDecomposeShort)) {
                                            return false;
                                        }
                                        reorderingBuffer2.remove();
                                    }
                                    i5 = i2;
                                }
                            } else if (iBmpGet < normalizer2Impl.minNoNoEmpty || !(normalizer2Impl.hasCompBoundaryBefore(charSequence2, iCharCount, i5) || normalizer2Impl.hasCompBoundaryAfter(charSequence2, i7, iDecomposeShort, z3))) {
                                if (i7 != iDecomposeShort) {
                                    iCodePointBefore = Character.codePointBefore(charSequence2, iDecomposeShort);
                                    if (!normalizer2Impl.norm16HasCompBoundaryAfter(normalizer2Impl.normTrie.get(iCodePointBefore), z3)) {
                                        iDecomposeShort -= Character.charCount(iCodePointBefore);
                                    }
                                }
                                if (z2) {
                                    reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                }
                                int length4 = reorderingBuffer2.length();
                                int i16 = iCharCount;
                                normalizer2Impl.decomposeShort(charSequence2, iDecomposeShort, i16, false, z3, reorderingBuffer2);
                                i3 = iDecomposeShort;
                                normalizer2Impl = this;
                                charSequence2 = charSequence;
                                z3 = z;
                                reorderingBuffer2 = reorderingBuffer;
                                iDecomposeShort = normalizer2Impl.decomposeShort(charSequence2, i16, i5, true, z3, reorderingBuffer2);
                                normalizer2Impl.recompose(reorderingBuffer2, length4, z3);
                                if (!z2) {
                                    if (!reorderingBuffer2.equals(charSequence2, i3, iDecomposeShort)) {
                                        return false;
                                    }
                                    reorderingBuffer2.remove();
                                }
                                i5 = i2;
                            } else {
                                if (i7 != iDecomposeShort) {
                                    reorderingBuffer2.append(charSequence2, i7, iDecomposeShort);
                                }
                                iDecomposeShort = iCharCount;
                            }
                        }
                    }
                }
                iDecomposeShort++;
                i5 = i2;
            }
        }
    }

    public void composeAndAppend(CharSequence charSequence, boolean z, boolean z2, ReorderingBuffer reorderingBuffer) {
        Normalizer2Impl normalizer2Impl;
        boolean z3;
        ReorderingBuffer reorderingBuffer2;
        int i;
        int iFindNextCompBoundary;
        int length = charSequence.length();
        if (reorderingBuffer.isEmpty() || (iFindNextCompBoundary = findNextCompBoundary(charSequence, 0, length, z2)) == 0) {
            normalizer2Impl = this;
            z3 = z2;
            reorderingBuffer2 = reorderingBuffer;
            i = 0;
        } else {
            int iFindPreviousCompBoundary = findPreviousCompBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length(), z2);
            StringBuilder sb = new StringBuilder((reorderingBuffer.length() - iFindPreviousCompBoundary) + iFindNextCompBoundary + 16);
            sb.append((CharSequence) reorderingBuffer.getStringBuilder(), iFindPreviousCompBoundary, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - iFindPreviousCompBoundary);
            sb.append(charSequence, 0, iFindNextCompBoundary);
            normalizer2Impl = this;
            z3 = z2;
            normalizer2Impl.compose(sb, 0, sb.length(), z3, true, reorderingBuffer);
            reorderingBuffer2 = reorderingBuffer;
            i = iFindNextCompBoundary;
        }
        if (z) {
            normalizer2Impl.compose(charSequence, i, length, z3, true, reorderingBuffer2);
        } else {
            reorderingBuffer2.append(charSequence, i, length);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0067 A[DONT_INVERT, PHI: r5
      0x0067: PHI (r5v4 int) = (r5v3 int), (r5v6 int), (r5v7 int) binds: [B:34:0x005e, B:27:0x0048, B:25:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    public int composePair(int i, int i2) {
        int dataForMaybe;
        char cCharAt;
        int norm16 = getNorm16(i);
        if (isInert(norm16)) {
            return -1;
        }
        if (norm16 < this.minYesNoMappingsOnly) {
            if (isJamoL(norm16)) {
                int i3 = i2 - 4449;
                if (i3 < 0 || i3 >= 21) {
                    return -1;
                }
                return ((((i - 4352) * 21) + i3) * 28) + Hangul.HANGUL_BASE;
            }
            if (isHangulLV(norm16)) {
                int i4 = i2 - 4519;
                if (i4 <= 0 || i4 >= 28) {
                    return -1;
                }
                return i + i4;
            }
            dataForMaybe = getDataForYesOrNo(norm16);
            if (norm16 > this.minYesNo) {
                cCharAt = this.extraData.charAt(dataForMaybe);
                dataForMaybe += (cCharAt & 31) + 1;
                if (i2 >= 0 && 1114111 >= i2) {
                    return combine(dataForMaybe, i2) >> 1;
                }
            } else if (i2 >= 0) {
                return combine(dataForMaybe, i2) >> 1;
            }
        } else if (norm16 >= this.minMaybeNoCombinesFwd && 64512 > norm16) {
            dataForMaybe = getDataForMaybe(norm16);
            if (norm16 < this.minMaybeYes) {
                cCharAt = this.extraData.charAt(dataForMaybe);
                dataForMaybe += (cCharAt & 31) + 1;
                if (i2 >= 0) {
                    return combine(dataForMaybe, i2) >> 1;
                }
            } else if (i2 >= 0) {
                return combine(dataForMaybe, i2) >> 1;
            }
        }
        return -1;
    }

    public int composeQuickCheck(CharSequence charSequence, int i, int i2, boolean z, boolean z2) {
        int i3;
        int norm16;
        int iCodePointAt;
        int i4 = this.minCompNoMaybeCP;
        int i5 = 0;
        int iCharCount = i;
        while (i != i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= i4) {
                int iBmpGet = this.normTrie.bmpGet(cCharAt);
                if (!isCompYesAndZeroCC(iBmpGet)) {
                    int iCharCount2 = i + 1;
                    if (UTF16Plus.isLeadSurrogate(cCharAt)) {
                        if (iCharCount2 != i2) {
                            char cCharAt2 = charSequence.charAt(iCharCount2);
                            if (Character.isLowSurrogate(cCharAt2)) {
                                iCharCount2 = i + 2;
                                iBmpGet = this.normTrie.suppGet(Character.toCodePoint(cCharAt, cCharAt2));
                                if (!isCompYesAndZeroCC(iBmpGet)) {
                                }
                            }
                        }
                        i = iCharCount2;
                    }
                    if (iCharCount == i) {
                        norm16 = 1;
                    } else {
                        if (!norm16HasCompBoundaryBefore(iBmpGet)) {
                            int iCodePointBefore = Character.codePointBefore(charSequence, i);
                            norm16 = getNorm16(iCodePointBefore);
                            if (!norm16HasCompBoundaryAfter(norm16, z)) {
                                iCharCount = i - Character.charCount(iCodePointBefore);
                            }
                        }
                        iCharCount = i;
                        norm16 = 1;
                    }
                    if (iBmpGet >= this.minMaybeNo) {
                        int fCD16FromMaybeOrNonZeroCC = getFCD16FromMaybeOrNonZeroCC(iBmpGet);
                        int i6 = (fCD16FromMaybeOrNonZeroCC >> 8) & 255;
                        if (!z || i6 == 0 || getTrailCCFromCompYesAndZeroCC(norm16) <= i6) {
                            while (true) {
                                if (iBmpGet < 65026) {
                                    if (z2) {
                                        return iCharCount << 1;
                                    }
                                    i5 = 1;
                                }
                                if (iCharCount2 != i2) {
                                    int i7 = fCD16FromMaybeOrNonZeroCC & 255;
                                    iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                                    iBmpGet = getNorm16(iCodePointAt);
                                    if (iBmpGet < this.minMaybeNo) {
                                        break;
                                    }
                                    int fCD16FromMaybeOrNonZeroCC2 = getFCD16FromMaybeOrNonZeroCC(iBmpGet);
                                    int i8 = (fCD16FromMaybeOrNonZeroCC2 >> 8) & 255;
                                    if (i7 > i8 && i8 != 0) {
                                        break;
                                    }
                                    iCharCount2 += Character.charCount(iCodePointAt);
                                    fCD16FromMaybeOrNonZeroCC = fCD16FromMaybeOrNonZeroCC2;
                                } else {
                                    i3 = iCharCount2 << 1;
                                    return i3 | i5;
                                }
                            }
                            if (isCompYesAndZeroCC(iBmpGet)) {
                                i = Character.charCount(iCodePointAt) + iCharCount2;
                                iCharCount = iCharCount2;
                            }
                        }
                    }
                    return iCharCount << 1;
                }
            }
            i++;
        }
        i3 = i << 1;
        return i3 | i5;
    }

    public int decompose(CharSequence charSequence, int i, int i2, ReorderingBuffer reorderingBuffer) {
        int cCFromYesOrMaybeYes;
        int i3 = this.minDecompNoCP;
        int i4 = i;
        int iCharAt = 0;
        int iBmpGet = 0;
        int i5 = 0;
        while (true) {
            int i6 = i;
            while (i6 != i2) {
                iCharAt = charSequence.charAt(i6);
                if (iCharAt >= i3) {
                    iBmpGet = this.normTrie.bmpGet(iCharAt);
                    if (!isMostDecompYesAndZeroCC(iBmpGet)) {
                        if (!UTF16Plus.isLeadSurrogate(iCharAt)) {
                            break;
                        }
                        int i7 = i6 + 1;
                        if (i7 != i2) {
                            char cCharAt = charSequence.charAt(i7);
                            if (Character.isLowSurrogate(cCharAt)) {
                                iCharAt = Character.toCodePoint((char) iCharAt, cCharAt);
                                iBmpGet = this.normTrie.suppGet(iCharAt);
                                if (!isMostDecompYesAndZeroCC(iBmpGet)) {
                                    break;
                                }
                                i6 += 2;
                            }
                        }
                        i6 = i7;
                    }
                }
                i6++;
            }
            if (i6 != i) {
                if (reorderingBuffer != null) {
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, i, i6);
                } else {
                    i5 = 0;
                    i4 = i6;
                }
            }
            if (i6 == i2) {
                return i6;
            }
            i = Character.charCount(iCharAt) + i6;
            if (reorderingBuffer != null) {
                decompose(iCharAt, iBmpGet, reorderingBuffer);
            } else {
                if (!isDecompYes(iBmpGet) || (i5 > (cCFromYesOrMaybeYes = getCCFromYesOrMaybeYes(iBmpGet)) && cCFromYesOrMaybeYes != 0)) {
                    return i4;
                }
                if (cCFromYesOrMaybeYes <= 1) {
                    i4 = i;
                }
                i5 = cCFromYesOrMaybeYes;
            }
        }
    }

    public void decomposeAndAppend(CharSequence charSequence, boolean z, ReorderingBuffer reorderingBuffer) {
        int i;
        int length = charSequence.length();
        if (length == 0) {
            return;
        }
        int iCharCount = 0;
        if (z) {
            decompose(charSequence, 0, length, reorderingBuffer);
            return;
        }
        int iCodePointAt = Character.codePointAt(charSequence, 0);
        int cc = getCC(getNorm16(iCodePointAt));
        int cc2 = cc;
        int i2 = cc2;
        while (true) {
            if (cc2 == 0) {
                i = i2;
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
            if (iCharCount >= length) {
                i = cc2;
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            i2 = cc2;
            cc2 = getCC(getNorm16(iCodePointAt));
        }
        int i3 = iCharCount;
        reorderingBuffer.append(charSequence, 0, i3, false, cc, i);
        reorderingBuffer.append(charSequence, i3, length);
    }

    public synchronized Normalizer2Impl ensureCanonIterData() {
        int rawNorm16;
        int iMapAlgorithmic;
        int i;
        int i2;
        try {
            if (this.canonIterData == null) {
                MutableCodePointTrie mutableCodePointTrie = new MutableCodePointTrie(0, 0);
                this.canonStartSets = new ArrayList<>();
                CodePointMap.Range range = new CodePointMap.Range();
                int i3 = 0;
                while (this.normTrie.getRange(i3, CodePointMap.RangeOption.FIXED_LEAD_SURROGATES, 1, null, range)) {
                    int end = range.getEnd();
                    int value = range.getValue();
                    if (!isInert(value) && (this.minYesNo > value || value >= this.minNoNo)) {
                        if (this.minMaybeNo > value || value >= this.minMaybeYes) {
                            while (i3 <= end) {
                                int i4 = mutableCodePointTrie.get(i3);
                                if (isMaybeYesOrNonZeroCC(value)) {
                                    i = i4 | CANON_NOT_SEGMENT_STARTER;
                                    if (value < 64512) {
                                        i2 = -1073741824;
                                        i = i2 | i4;
                                    }
                                } else if (value < this.minYesNo) {
                                    i2 = CANON_HAS_COMPOSITIONS;
                                    i = i2 | i4;
                                } else {
                                    if (isDecompNoAlgorithmic(value)) {
                                        iMapAlgorithmic = mapAlgorithmic(i3, value);
                                        rawNorm16 = getRawNorm16(iMapAlgorithmic);
                                    } else {
                                        rawNorm16 = value;
                                        iMapAlgorithmic = i3;
                                    }
                                    if (rawNorm16 > this.minYesNo) {
                                        int dataForYesOrNo = getDataForYesOrNo(rawNorm16);
                                        char cCharAt = this.extraData.charAt(dataForYesOrNo);
                                        int i5 = cCharAt & 31;
                                        i = ((cCharAt & 128) == 0 || i3 != iMapAlgorithmic || (this.extraData.charAt(dataForYesOrNo + (-1)) & 255) == 0) ? i4 : i4 | CANON_NOT_SEGMENT_STARTER;
                                        if (i5 != 0) {
                                            int iCharCount = dataForYesOrNo + 1;
                                            int i6 = i5 + iCharCount;
                                            int iCodePointAt = this.extraData.codePointAt(iCharCount);
                                            addToStartSet(mutableCodePointTrie, i3, iCodePointAt);
                                            if (rawNorm16 >= this.minNoNo) {
                                                while (true) {
                                                    iCharCount += Character.charCount(iCodePointAt);
                                                    if (iCharCount >= i6) {
                                                        break;
                                                    }
                                                    iCodePointAt = this.extraData.codePointAt(iCharCount);
                                                    int i7 = mutableCodePointTrie.get(iCodePointAt);
                                                    if ((i7 & CANON_NOT_SEGMENT_STARTER) == 0) {
                                                        mutableCodePointTrie.set(iCodePointAt, i7 | CANON_NOT_SEGMENT_STARTER);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        addToStartSet(mutableCodePointTrie, i3, iMapAlgorithmic);
                                        i = i4;
                                    }
                                }
                                if (i != i4) {
                                    mutableCodePointTrie.set(i3, i);
                                }
                                i3++;
                            }
                        }
                    }
                    i3 = end + 1;
                }
                this.canonIterData = mutableCodePointTrie.buildImmutable(CodePointTrie.Type.SMALL, CodePointTrie.ValueWidth.BITS_32);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public int getCC(int i) {
        if (i >= 64512) {
            return getCCFromNormalYesOrMaybe(i);
        }
        if (i < this.minNoNo || this.limitNoNo <= i) {
            return 0;
        }
        return getCCFromNoNo(i);
    }

    public int getCCFromYesOrMaybeYesCP(int i) {
        if (i < this.minCompNoMaybeCP) {
            return 0;
        }
        return getCCFromYesOrMaybeYes(getNorm16(i));
    }

    public boolean getCanonStartSet(int i, UnicodeSet unicodeSet) {
        int i2 = this.canonIterData.get(i);
        if ((Integer.MAX_VALUE & i2) == 0) {
            return false;
        }
        unicodeSet.clear();
        int i3 = 2097151 & i2;
        if ((2097152 & i2) != 0) {
            unicodeSet.addAll(this.canonStartSets.get(i3));
        } else if (i3 != 0) {
            unicodeSet.add(i3);
        }
        if ((i2 & CANON_HAS_COMPOSITIONS) == 0) {
            return true;
        }
        int rawNorm16 = getRawNorm16(i);
        if (rawNorm16 != 2) {
            addComposites(getCompositionsList(rawNorm16), unicodeSet);
            return true;
        }
        int i4 = (i - 4352) * Hangul.JAMO_VT_COUNT;
        unicodeSet.add(Hangul.HANGUL_BASE + i4, i4 + 44619);
        return true;
    }

    public int getCompQuickCheck(int i) {
        if (i < this.minNoNo || 65026 <= i) {
            return 1;
        }
        return this.minMaybeNo <= i ? 2 : 0;
    }

    public String getDecomposition(int i) {
        int i2;
        int iMapAlgorithmic;
        int rawNorm16;
        if (i >= this.minDecompNoCP) {
            int norm16 = getNorm16(i);
            if (!isMaybeYesOrNonZeroCC(norm16)) {
                if (isDecompNoAlgorithmic(norm16)) {
                    iMapAlgorithmic = mapAlgorithmic(i, norm16);
                    rawNorm16 = getRawNorm16(iMapAlgorithmic);
                    i2 = iMapAlgorithmic;
                } else {
                    i2 = i;
                    iMapAlgorithmic = -1;
                    rawNorm16 = norm16;
                }
                if (rawNorm16 < this.minYesNo) {
                    if (iMapAlgorithmic < 0) {
                        return null;
                    }
                    return UTF16.valueOf(iMapAlgorithmic);
                }
                if (isHangulLV(rawNorm16) || isHangulLVT(rawNorm16)) {
                    StringBuilder sb = new StringBuilder();
                    Hangul.decompose(i2, sb);
                    return sb.toString();
                }
                int data = getData(rawNorm16);
                int i3 = data + 1;
                return this.extraData.substring(i3, (this.extraData.charAt(data) & 31) + i3);
            }
        }
        return null;
    }

    public int getFCD16(int i) {
        if (i < this.minDecompNoCP) {
            return 0;
        }
        if (i > 65535 || singleLeadMightHaveNonZeroFCD16(i)) {
            return getFCD16FromNormData(i);
        }
        return 0;
    }

    public int getFCD16FromNormData(int i) {
        int norm16 = getNorm16(i);
        if (norm16 >= this.limitNoNo) {
            if (norm16 >= 64512) {
                int cCFromNormalYesOrMaybe = getCCFromNormalYesOrMaybe(norm16);
                return cCFromNormalYesOrMaybe | (cCFromNormalYesOrMaybe << 8);
            }
            if (norm16 >= this.minMaybeYes) {
                return 0;
            }
            if (norm16 < this.minMaybeNo) {
                int i2 = norm16 & 6;
                if (i2 <= 2) {
                    return i2 >> 1;
                }
                norm16 = getRawNorm16(mapAlgorithmic(i, norm16));
            }
        }
        if (norm16 <= this.minYesNo || isHangulLVT(norm16)) {
            return 0;
        }
        int data = getData(norm16);
        char cCharAt = this.extraData.charAt(data);
        int i3 = cCharAt >> '\b';
        return (cCharAt & 128) != 0 ? (this.extraData.charAt(data - 1) & 65280) | i3 : i3;
    }

    public int getNorm16(int i) {
        if (UTF16Plus.isLeadSurrogate(i)) {
            return 1;
        }
        return this.normTrie.get(i);
    }

    public String getRawDecomposition(int i) {
        if (i < this.minDecompNoCP) {
            return null;
        }
        int norm16 = getNorm16(i);
        if (isDecompYes(norm16)) {
            return null;
        }
        if (isHangulLV(norm16) || isHangulLVT(norm16)) {
            StringBuilder sb = new StringBuilder();
            Hangul.getRawDecomposition(i, sb);
            return sb.toString();
        }
        if (isDecompNoAlgorithmic(norm16)) {
            return UTF16.valueOf(mapAlgorithmic(i, norm16));
        }
        int data = getData(norm16);
        char cCharAt = this.extraData.charAt(data);
        int i2 = cCharAt & 31;
        int i3 = cCharAt & '@';
        String str = this.extraData;
        if (i3 == 0) {
            int i4 = data + 1;
            return str.substring(i4, i2 + i4);
        }
        int i5 = (data - ((cCharAt >> 7) & 1)) - 1;
        char cCharAt2 = str.charAt(i5);
        if (cCharAt2 <= 31) {
            return this.extraData.substring(i5 - cCharAt2, i5);
        }
        StringBuilder sb2 = new StringBuilder(i2 - 1);
        sb2.append(cCharAt2);
        int i6 = data + 3;
        sb2.append((CharSequence) this.extraData, i6, (i2 + i6) - 2);
        return sb2.toString();
    }

    public int getRawNorm16(int i) {
        return this.normTrie.get(i);
    }

    public int getTrailCCFromCompYesAndZeroCC(int i) {
        if (i <= this.minYesNo) {
            return 0;
        }
        return this.extraData.charAt(getDataForYesOrNo(i)) >> '\b';
    }

    public boolean hasCompBoundaryBefore(int i) {
        return i < this.minCompNoMaybeCP || norm16HasCompBoundaryBefore(getNorm16(i));
    }

    public boolean hasDecompBoundaryAfter(int i) {
        if (i < this.minDecompNoCP) {
            return true;
        }
        if (i > 65535 || singleLeadMightHaveNonZeroFCD16(i)) {
            return norm16HasDecompBoundaryAfter(getNorm16(i));
        }
        return true;
    }

    public boolean hasDecompBoundaryBefore(int i) {
        if (i >= this.minLcccCP) {
            return (i <= 65535 && !singleLeadMightHaveNonZeroFCD16(i)) || norm16HasDecompBoundaryBefore(getNorm16(i));
        }
        return true;
    }

    public boolean hasFCDBoundaryAfter(int i) {
        return hasDecompBoundaryAfter(i);
    }

    public boolean hasFCDBoundaryBefore(int i) {
        return hasDecompBoundaryBefore(i);
    }

    public boolean isAlgorithmicNoNo(int i) {
        return this.limitNoNo <= i && i < this.minMaybeNo;
    }

    public boolean isCanonSegmentStarter(int i) {
        return this.canonIterData.get(i) >= 0;
    }

    public boolean isCompInert(int i, boolean z) {
        int norm16 = getNorm16(i);
        if (!isCompYesAndZeroCC(norm16) || (norm16 & 1) == 0) {
            return false;
        }
        return !z || isInert(norm16) || this.extraData.charAt(getDataForYesOrNo(norm16)) <= 511;
    }

    public boolean isCompNo(int i) {
        return this.minNoNo <= i && i < this.minMaybeNo;
    }

    public boolean isDecompInert(int i) {
        return isDecompYesAndZeroCC(getNorm16(i));
    }

    public boolean isDecompYes(int i) {
        return i < this.minYesNo || this.minMaybeYes <= i;
    }

    public boolean isFCDInert(int i) {
        return getFCD16(i) <= 1;
    }

    public Normalizer2Impl load(ByteBuffer byteBuffer) {
        try {
            this.dataVersion = ICUBinary.readHeaderAndDataVersion(byteBuffer, DATA_FORMAT, IS_ACCEPTABLE);
            int i = byteBuffer.getInt() / 4;
            if (i <= 18) {
                throw new ICUUncheckedIOException("Normalizer2 data: not enough indexes");
            }
            int[] iArr = new int[i];
            iArr[0] = i * 4;
            for (int i2 = 1; i2 < i; i2++) {
                iArr[i2] = byteBuffer.getInt();
            }
            this.minDecompNoCP = iArr[8];
            this.minCompNoMaybeCP = iArr[9];
            this.minLcccCP = iArr[18];
            this.minYesNo = iArr[10];
            this.minYesNoMappingsOnly = iArr[14];
            this.minNoNo = iArr[11];
            this.minNoNoCompBoundaryBefore = iArr[15];
            this.minNoNoCompNoMaybeCC = iArr[16];
            this.minNoNoEmpty = iArr[17];
            this.limitNoNo = iArr[12];
            int i3 = iArr[20];
            this.minMaybeNo = i3;
            this.minMaybeNoCombinesFwd = iArr[21];
            this.minMaybeYes = iArr[13];
            this.centerNoNoDelta = (i3 >> 3) - 65;
            int i4 = iArr[0];
            int i5 = iArr[1];
            int iPosition = byteBuffer.position();
            this.normTrie = CodePointTrie.Fast16.fromBinary(byteBuffer);
            int iPosition2 = byteBuffer.position() - iPosition;
            int i6 = i5 - i4;
            if (iPosition2 > i6) {
                throw new ICUUncheckedIOException("Normalizer2 data: not enough bytes for normTrie");
            }
            ICUBinary.skipBytes(byteBuffer, i6 - iPosition2);
            int i7 = (iArr[2] - i5) / 2;
            if (i7 != 0) {
                this.extraData = ICUBinary.getString(byteBuffer, i7, 0);
            }
            byte[] bArr = new byte[256];
            this.smallFCD = bArr;
            byteBuffer.get(bArr);
            return this;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca A[SYNTHETIC] */
    public int makeFCD(CharSequence charSequence, int i, int i2, ReorderingBuffer reorderingBuffer) {
        int iCharCount;
        int iCharCount2;
        int fCD16FromNormData;
        int i3;
        int i4;
        ReorderingBuffer reorderingBuffer2 = reorderingBuffer;
        int i5 = i;
        int i6 = i5;
        int fCD16FromNormData2 = 0;
        int iCharAt = 0;
        int fCD16FromNormData3 = 0;
        while (true) {
            iCharCount = i5;
            while (iCharCount != i2) {
                iCharAt = charSequence.charAt(iCharCount);
                if (iCharAt >= this.minLcccCP) {
                    if (singleLeadMightHaveNonZeroFCD16(iCharAt)) {
                        if (UTF16Plus.isLeadSurrogate(iCharAt) && (i4 = iCharCount + 1) != i2) {
                            char cCharAt = charSequence.charAt(i4);
                            if (Character.isLowSurrogate(cCharAt)) {
                                iCharAt = Character.toCodePoint((char) iCharAt, cCharAt);
                            }
                        }
                        fCD16FromNormData3 = getFCD16FromNormData(iCharAt);
                        if (fCD16FromNormData3 > 255) {
                            break;
                        }
                        iCharCount += Character.charCount(iCharAt);
                        fCD16FromNormData2 = fCD16FromNormData3;
                    } else {
                        iCharCount++;
                        fCD16FromNormData2 = 0;
                    }
                } else {
                    fCD16FromNormData2 = ~iCharAt;
                    iCharCount++;
                }
            }
            iCharAt = iCharAt;
            int i7 = fCD16FromNormData3;
            if (iCharCount == i5) {
                if (iCharCount == i2) {
                    break;
                }
                iCharCount2 = Character.charCount(iCharAt) + iCharCount;
                if ((fCD16FromNormData2 & 255) <= (i7 >> 8)) {
                    if ((i7 & 255) <= 1) {
                        i6 = iCharCount2;
                    }
                    if (reorderingBuffer2 != null) {
                        reorderingBuffer2.appendZeroCC(iCharAt);
                    }
                    i5 = iCharCount2;
                    fCD16FromNormData2 = i7;
                    fCD16FromNormData3 = fCD16FromNormData2;
                } else {
                    if (reorderingBuffer2 == null) {
                        return i6;
                    }
                    reorderingBuffer2.removeSuffix(i5 - i6);
                    int iFindNextFCDBoundary = findNextFCDBoundary(charSequence, iCharCount2, i2);
                    decomposeShort(charSequence, i6, iFindNextFCDBoundary, false, false, reorderingBuffer2);
                    reorderingBuffer2 = reorderingBuffer;
                    i5 = iFindNextFCDBoundary;
                    i6 = i5;
                    fCD16FromNormData2 = 0;
                    fCD16FromNormData3 = i7;
                }
            } else {
                if (iCharCount == i2) {
                    if (reorderingBuffer2 == null) {
                        break;
                    }
                    reorderingBuffer2.flushAndAppendZeroCC(charSequence, i5, iCharCount);
                    return iCharCount;
                }
                if (fCD16FromNormData2 < 0) {
                    int i8 = ~fCD16FromNormData2;
                    if (i8 < this.minDecompNoCP) {
                        fCD16FromNormData = 0;
                    } else {
                        fCD16FromNormData = getFCD16FromNormData(i8);
                        if (fCD16FromNormData > 1) {
                            i3 = iCharCount - 1;
                        }
                        int i9 = i3;
                        fCD16FromNormData2 = fCD16FromNormData;
                        i6 = i9;
                    }
                    i3 = iCharCount;
                    int i10 = i3;
                    fCD16FromNormData2 = fCD16FromNormData;
                    i6 = i10;
                } else {
                    i6 = iCharCount - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(i6)) && i5 < i6 && Character.isHighSurrogate(charSequence.charAt(iCharCount - 2))) {
                        i6 = iCharCount - 2;
                        fCD16FromNormData2 = getFCD16FromNormData(Character.toCodePoint(charSequence.charAt(i6), charSequence.charAt(iCharCount - 1)));
                    }
                    if (fCD16FromNormData2 <= 1) {
                        i6 = iCharCount;
                    }
                }
                if (reorderingBuffer2 != null) {
                    reorderingBuffer2.flushAndAppendZeroCC(charSequence, i5, i6);
                    reorderingBuffer2.append(charSequence, i6, iCharCount);
                }
                i5 = iCharCount;
                iCharCount2 = Character.charCount(iCharAt) + iCharCount;
                if ((fCD16FromNormData2 & 255) <= (i7 >> 8)) {
                    if ((i7 & 255) <= 1) {
                        i6 = iCharCount2;
                    }
                    if (reorderingBuffer2 != null) {
                        reorderingBuffer2.appendZeroCC(iCharAt);
                    }
                    i5 = iCharCount2;
                    fCD16FromNormData2 = i7;
                    fCD16FromNormData3 = fCD16FromNormData2;
                } else {
                    if (reorderingBuffer2 == null) {
                        return i6;
                    }
                    reorderingBuffer2.removeSuffix(i5 - i6);
                    int iFindNextFCDBoundary2 = findNextFCDBoundary(charSequence, iCharCount2, i2);
                    decomposeShort(charSequence, i6, iFindNextFCDBoundary2, false, false, reorderingBuffer2);
                    reorderingBuffer2 = reorderingBuffer;
                    i5 = iFindNextFCDBoundary2;
                    i6 = i5;
                    fCD16FromNormData2 = 0;
                    fCD16FromNormData3 = i7;
                }
            }
        }
        return iCharCount;
    }

    public void makeFCDAndAppend(CharSequence charSequence, boolean z, ReorderingBuffer reorderingBuffer) {
        int iFindNextFCDBoundary;
        int length = charSequence.length();
        int i = 0;
        if (!reorderingBuffer.isEmpty() && (iFindNextFCDBoundary = findNextFCDBoundary(charSequence, 0, length)) != 0) {
            int iFindPreviousFCDBoundary = findPreviousFCDBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length());
            StringBuilder sb = new StringBuilder((reorderingBuffer.length() - iFindPreviousFCDBoundary) + iFindNextFCDBoundary + 16);
            sb.append((CharSequence) reorderingBuffer.getStringBuilder(), iFindPreviousFCDBoundary, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - iFindPreviousFCDBoundary);
            sb.append(charSequence, 0, iFindNextFCDBoundary);
            makeFCD(sb, 0, sb.length(), reorderingBuffer);
            i = iFindNextFCDBoundary;
        }
        if (z) {
            makeFCD(charSequence, i, length, reorderingBuffer);
        } else {
            reorderingBuffer.append(charSequence, i, length);
        }
    }

    public boolean norm16HasDecompBoundaryAfter(int i) {
        if (i > this.minYesNo && !isHangulLVT(i)) {
            if (i >= this.limitNoNo) {
                if (isMaybeYesOrNonZeroCC(i)) {
                    return i <= 64512 || i == 65024;
                }
                if (i < this.minMaybeNo) {
                    return (i & 6) <= 2;
                }
            }
            int data = getData(i);
            char cCharAt = this.extraData.charAt(data);
            if (cCharAt > 511) {
                return false;
            }
            if (cCharAt > 255 && (cCharAt & 128) != 0 && (this.extraData.charAt(data - 1) & 65280) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean norm16HasDecompBoundaryBefore(int i) {
        if (i < this.minNoNoCompNoMaybeCC) {
            return true;
        }
        if (i >= this.limitNoNo) {
            return i <= 64512 || i == 65024;
        }
        int dataForYesOrNo = getDataForYesOrNo(i);
        return (this.extraData.charAt(dataForYesOrNo) & 128) == 0 || (this.extraData.charAt(dataForYesOrNo - 1) & 65280) == 0;
    }

    public boolean singleLeadMightHaveNonZeroFCD16(int i) {
        byte b = this.smallFCD[i >> 8];
        return (b == 0 || ((b >> ((i >> 5) & 7)) & 1) == 0) ? false : true;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 5;
        }

        private IsAcceptable() {
        }
    }

    public boolean hasCompBoundaryAfter(int i, boolean z) {
        return norm16HasCompBoundaryAfter(getNorm16(i), z);
    }

    private boolean hasCompBoundaryBefore(int i, int i2) {
        return i < this.minCompNoMaybeCP || norm16HasCompBoundaryBefore(i2);
    }

    private boolean hasCompBoundaryBefore(CharSequence charSequence, int i, int i2) {
        return i == i2 || hasCompBoundaryBefore(Character.codePointAt(charSequence, i));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class UTF16Plus {
        public static boolean equal(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == charSequence2) {
                return true;
            }
            int length = charSequence.length();
            if (length != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isLeadSurrogate(int i) {
            return (i & (-1024)) == 55296;
        }

        public static boolean isSurrogate(int i) {
            return (i & (-2048)) == 55296;
        }

        public static boolean isSurrogateLead(int i) {
            return (i & 1024) == 0;
        }

        public static boolean isTrailSurrogate(int i) {
            return (i & (-1024)) == 56320;
        }

        public static boolean equal(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, int i4) {
            if (i2 - i != i4 - i3) {
                return false;
            }
            if (charSequence == charSequence2 && i == i3) {
                return true;
            }
            while (i < i2) {
                int i5 = i + 1;
                int i6 = i3 + 1;
                if (charSequence.charAt(i) != charSequence2.charAt(i3)) {
                    return false;
                }
                i = i5;
                i3 = i6;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ReorderingBuffer implements Appendable {
        private final Appendable app;
        private final boolean appIsStringBuilder;
        private int codePointLimit;
        private int codePointStart;
        private final Normalizer2Impl impl;
        private int lastCC;
        private int reorderStart;
        private final StringBuilder str;

        public ReorderingBuffer(Normalizer2Impl normalizer2Impl, Appendable appendable, int i) {
            this.impl = normalizer2Impl;
            this.app = appendable;
            if (!(appendable instanceof StringBuilder)) {
                this.appIsStringBuilder = false;
                this.str = new StringBuilder();
                this.reorderStart = 0;
                this.lastCC = 0;
                return;
            }
            this.appIsStringBuilder = true;
            StringBuilder sb = (StringBuilder) appendable;
            this.str = sb;
            sb.ensureCapacity(i);
            this.reorderStart = 0;
            if (sb.length() == 0) {
                this.lastCC = 0;
                return;
            }
            setIterator();
            int iPreviousCC = previousCC();
            this.lastCC = iPreviousCC;
            if (iPreviousCC > 1) {
                while (previousCC() > 1) {
                }
            }
            this.reorderStart = this.codePointLimit;
        }

        private void insert(int i, int i2) {
            setIterator();
            skipPrevious();
            while (previousCC() > i2) {
            }
            StringBuilder sb = this.str;
            if (i <= 65535) {
                sb.insert(this.codePointLimit, (char) i);
                if (i2 <= 1) {
                    this.reorderStart = this.codePointLimit + 1;
                    return;
                }
                return;
            }
            sb.insert(this.codePointLimit, Character.toChars(i));
            if (i2 <= 1) {
                this.reorderStart = this.codePointLimit + 2;
            }
        }

        private int previousCC() {
            int i = this.codePointStart;
            this.codePointLimit = i;
            if (this.reorderStart >= i) {
                return 0;
            }
            int iCodePointBefore = this.str.codePointBefore(i);
            this.codePointStart -= Character.charCount(iCodePointBefore);
            return this.impl.getCCFromYesOrMaybeYesCP(iCodePointBefore);
        }

        private void setIterator() {
            this.codePointStart = this.str.length();
        }

        private void skipPrevious() {
            int i = this.codePointStart;
            this.codePointLimit = i;
            this.codePointStart = this.str.offsetByCodePoints(i, -1);
        }

        public void append(CharSequence charSequence, int i, int i2, boolean z, int i3, int i4) {
            int cCFromYesOrMaybeYes;
            if (i == i2) {
                return;
            }
            if (this.lastCC <= i3 || i3 == 0) {
                if (i4 <= 1) {
                    this.reorderStart = (i2 - i) + this.str.length();
                } else if (i3 <= 1) {
                    this.reorderStart = this.str.length() + 1;
                }
                this.str.append(charSequence, i, i2);
                this.lastCC = i4;
                return;
            }
            int iCodePointAt = Character.codePointAt(charSequence, i);
            int iCharCount = Character.charCount(iCodePointAt) + i;
            insert(iCodePointAt, i3);
            while (iCharCount < i2) {
                int iCodePointAt2 = Character.codePointAt(charSequence, iCharCount);
                iCharCount += Character.charCount(iCodePointAt2);
                if (iCharCount < i2) {
                    Normalizer2Impl normalizer2Impl = this.impl;
                    cCFromYesOrMaybeYes = z ? Normalizer2Impl.getCCFromYesOrMaybeYes(normalizer2Impl.getNorm16(iCodePointAt2)) : normalizer2Impl.getCC(normalizer2Impl.getNorm16(iCodePointAt2));
                } else {
                    cCFromYesOrMaybeYes = i4;
                }
                append(iCodePointAt2, cCFromYesOrMaybeYes);
            }
        }

        public void appendZeroCC(int i) {
            this.str.appendCodePoint(i);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        public boolean equals(CharSequence charSequence, int i, int i2) {
            StringBuilder sb = this.str;
            return UTF16Plus.equal(sb, 0, sb.length(), charSequence, i, i2);
        }

        public void flush() {
            if (this.appIsStringBuilder) {
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                } catch (IOException e) {
                    kf2.h(e);
                    return;
                }
            }
            this.lastCC = 0;
        }

        public ReorderingBuffer flushAndAppendZeroCC(CharSequence charSequence, int i, int i2) {
            if (this.appIsStringBuilder) {
                this.str.append(charSequence, i, i2);
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str).append(charSequence, i, i2);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                } catch (IOException e) {
                    kf2.h(e);
                    return null;
                }
            }
            this.lastCC = 0;
            return this;
        }

        public int getLastCC() {
            return this.lastCC;
        }

        public StringBuilder getStringBuilder() {
            return this.str;
        }

        public boolean isEmpty() {
            return this.str.length() == 0;
        }

        public int length() {
            return this.str.length();
        }

        public void remove() {
            this.str.setLength(0);
            this.lastCC = 0;
            this.reorderStart = 0;
        }

        public void removeSuffix(int i) {
            int length = this.str.length();
            this.str.delete(length - i, length);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        public void append(int i, int i2) {
            if (this.lastCC > i2 && i2 != 0) {
                insert(i, i2);
                return;
            }
            this.str.appendCodePoint(i);
            this.lastCC = i2;
            if (i2 <= 1) {
                this.reorderStart = this.str.length();
            }
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(char c) {
            this.str.append(c);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
            return this;
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(CharSequence charSequence) {
            if (charSequence.length() != 0) {
                this.str.append(charSequence);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(CharSequence charSequence, int i, int i2) {
            if (i != i2) {
                this.str.append(charSequence, i, i2);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }
    }

    public void decompose(CharSequence charSequence, int i, int i2, StringBuilder sb, int i3) {
        if (i3 < 0) {
            i3 = i2 - i;
        }
        sb.setLength(0);
        decompose(charSequence, i, i2, new ReorderingBuffer(this, sb, i3));
    }

    public Appendable decompose(CharSequence charSequence, StringBuilder sb) {
        decompose(charSequence, 0, charSequence.length(), sb, charSequence.length());
        return sb;
    }

    private void decompose(int i, int i2, ReorderingBuffer reorderingBuffer) {
        if (i2 >= this.limitNoNo) {
            if (isMaybeYesOrNonZeroCC(i2)) {
                reorderingBuffer.append(i, getCCFromYesOrMaybeYes(i2));
                return;
            } else if (i2 < this.minMaybeNo) {
                i = mapAlgorithmic(i, i2);
                i2 = getRawNorm16(i);
            }
        }
        if (i2 < this.minYesNo) {
            reorderingBuffer.append(i, 0);
            return;
        }
        if (!isHangulLV(i2) && !isHangulLVT(i2)) {
            int data = getData(i2);
            char cCharAt = this.extraData.charAt(data);
            int i3 = data + 1;
            reorderingBuffer.append(this.extraData, i3, i3 + (cCharAt & 31), true, (cCharAt & 128) != 0 ? this.extraData.charAt(data - 1) >> '\b' : 0, cCharAt >> '\b');
            return;
        }
        Hangul.decompose(i, reorderingBuffer);
    }

    public Normalizer2Impl load(String str) {
        return load(ICUBinary.getRequiredData(str));
    }
}
