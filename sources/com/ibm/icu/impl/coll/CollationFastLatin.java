package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.DateTimePatternGenerator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationFastLatin {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BAIL_OUT = 1;
    public static final int BAIL_OUT_RESULT = -2;
    static final int CASE_AND_TERTIARY_MASK = 31;
    static final int CASE_MASK = 24;
    static final int COMMON_SEC = 160;
    static final int COMMON_SEC_PLUS_OFFSET = 192;
    static final int COMMON_TER = 0;
    static final int COMMON_TER_PLUS_OFFSET = 32;
    static final int CONTRACTION = 1024;
    static final int CONTR_CHAR_MASK = 511;
    static final int CONTR_LENGTH_SHIFT = 9;
    static final int EOS = 2;
    static final int EXPANSION = 2048;
    static final int INDEX_MASK = 1023;
    public static final int LATIN_LIMIT = 384;
    public static final int LATIN_MAX = 383;
    static final int LATIN_MAX_UTF8_LEAD = 197;
    static final int LONG_INC = 8;
    static final int LONG_PRIMARY_MASK = 65528;
    static final int LOWER_CASE = 8;
    static final int MAX_LONG = 4088;
    static final int MAX_SEC_AFTER = 352;
    static final int MAX_SEC_BEFORE = 128;
    static final int MAX_SEC_HIGH = 992;
    static final int MAX_SHORT = 64512;
    static final int MAX_TER_AFTER = 7;
    static final int MERGE_WEIGHT = 3;
    static final int MIN_LONG = 3072;
    static final int MIN_SEC_AFTER = 192;
    static final int MIN_SEC_BEFORE = 0;
    static final int MIN_SEC_HIGH = 384;
    static final int MIN_SHORT = 4096;
    static final int NUM_FAST_CHARS = 448;
    static final int PUNCT_LIMIT = 8256;
    static final int PUNCT_START = 8192;
    static final int SECONDARY_MASK = 992;
    static final int SEC_INC = 32;
    static final int SEC_OFFSET = 32;
    static final int SHORT_INC = 1024;
    static final int SHORT_PRIMARY_MASK = 64512;
    static final int TERTIARY_MASK = 7;
    static final int TER_OFFSET = 32;
    static final int TWO_CASES_MASK = 1572888;
    static final int TWO_COMMON_SEC_PLUS_OFFSET = 12583104;
    static final int TWO_COMMON_TER_PLUS_OFFSET = 2097184;
    static final int TWO_LONG_PRIMARIES_MASK = -458760;
    static final int TWO_LOWER_CASES = 524296;
    static final int TWO_SECONDARIES_MASK = 65012704;
    static final int TWO_SEC_OFFSETS = 2097184;
    static final int TWO_SHORT_PRIMARIES_MASK = -67044352;
    static final int TWO_TERTIARIES_MASK = 458759;
    static final int TWO_TER_OFFSETS = 2097184;
    public static final int VERSION = 2;

    private CollationFastLatin() {
    }

    /* JADX WARN: Code duplicated, block: B:313:0x0398  */
    /* JADX WARN: Code duplicated, block: B:317:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:0x0102 A[EDGE_INSN: B:320:0x0102->B:87:0x0102 BREAK  A[LOOP:0: B:3:0x0014->B:324:0x0014], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:323:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:330:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:331:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x009b  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00df A[LOOP:1: B:38:0x0089->B:72:0x00df, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x00fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x00ff  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v53, types: [int] */
    /* JADX WARN: Type inference failed for: r11v55, types: [char] */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r11v59 */
    /* JADX WARN: Type inference failed for: r11v60 */
    /* JADX WARN: Type inference failed for: r11v61 */
    public static int compareUTF16(char[] cArr, char[] cArr2, int i, CharSequence charSequence, CharSequence charSequence2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int tertiaries;
        int i8;
        int quaternaries;
        char c;
        int iLookup;
        int iLookup2;
        int i9;
        char cCharAt;
        int iLookup3;
        int i10;
        long jNextPair;
        int i11;
        int iLookup4;
        int i12;
        int i13 = i >> 16;
        int i14 = DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
        int i15 = i & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH;
        int i16 = i2;
        int i17 = i16;
        int primaries = 0;
        char primaries2 = 0;
        while (true) {
            i14 = i14;
            if (primaries != 0) {
                while (primaries2 == 0) {
                    if (i17 == charSequence2.length()) {
                        i9 = i17 + 1;
                        cCharAt = charSequence2.charAt(i17);
                        if (cCharAt <= 383) {
                            primaries2 = cArr2[cCharAt];
                            if (primaries2 != 0) {
                                i17 = i9;
                                break;
                            }
                            if (cCharAt > '9' && cCharAt >= '0' && (i & 2) != 0) {
                                return -2;
                            }
                            iLookup3 = cArr[cCharAt];
                        } else if (8192 <= cCharAt || cCharAt >= PUNCT_LIMIT) {
                            iLookup3 = lookup(cArr, cCharAt);
                        } else {
                            iLookup3 = cArr[cCharAt - 7808];
                        }
                        if (iLookup3 >= 4096) {
                            i10 = iLookup3 & Normalizer2Impl.MIN_NORMAL_MAYBE_YES;
                        } else if (iLookup3 > i13) {
                            i10 = iLookup3 & LONG_PRIMARY_MASK;
                        } else {
                            jNextPair = nextPair(cArr, cCharAt, iLookup3, charSequence2, i9);
                            if (jNextPair < 0) {
                                i17 += 2;
                                jNextPair = ~jNextPair;
                            } else {
                                i17 = i9;
                            }
                            i11 = (int) jNextPair;
                            if (i11 == 1) {
                                return -2;
                            }
                            primaries2 = getPrimaries(i13, i11);
                        }
                        i17 = i9;
                        primaries2 = i10;
                        break;
                    }
                    primaries2 = 2;
                    break;
                }
                i3 = -1;
                if (primaries == primaries2) {
                    i4 = primaries & i14;
                    i5 = primaries2 & i14;
                    if (i4 != i5) {
                        if (i4 < i5) {
                            return -1;
                        }
                        return 1;
                    }
                    i6 = 1;
                    if (primaries == 2) {
                        break;
                    }
                    primaries >>>= 16;
                    primaries2 >>>= 16;
                } else {
                    if (primaries == 2) {
                        i6 = 1;
                        break;
                    }
                    primaries = 0;
                    primaries2 = 0;
                }
            } else {
                if (i16 == charSequence.length()) {
                    primaries = 2;
                } else {
                    int i18 = i16 + 1;
                    char cCharAt2 = charSequence.charAt(i16);
                    if (cCharAt2 <= 383) {
                        char c2 = cArr2[cCharAt2];
                        if (c2 != 0) {
                            i16 = i18;
                            primaries = c2;
                        } else {
                            if (cCharAt2 <= '9' && cCharAt2 >= '0' && (i & 2) != 0) {
                                return -2;
                            }
                            iLookup4 = cArr[cCharAt2];
                        }
                    } else {
                        iLookup4 = (8192 > cCharAt2 || cCharAt2 >= PUNCT_LIMIT) ? lookup(cArr, cCharAt2) : cArr[cCharAt2 - 7808];
                    }
                    if (iLookup4 >= 4096) {
                        i12 = iLookup4 & Normalizer2Impl.MIN_NORMAL_MAYBE_YES;
                    } else if (iLookup4 > i13) {
                        i12 = iLookup4 & LONG_PRIMARY_MASK;
                    } else {
                        long jNextPair2 = nextPair(cArr, cCharAt2, iLookup4, charSequence, i18);
                        if (jNextPair2 < 0) {
                            i16 += 2;
                            jNextPair2 = ~jNextPair2;
                        } else {
                            i16 = i18;
                        }
                        int i19 = (int) jNextPair2;
                        if (i19 == 1) {
                            return -2;
                        }
                        primaries = getPrimaries(i13, i19);
                        primaries2 = primaries2;
                    }
                    i16 = i18;
                    primaries = i12;
                }
                while (primaries2 == 0) {
                    if (i17 == charSequence2.length()) {
                        i9 = i17 + 1;
                        cCharAt = charSequence2.charAt(i17);
                        if (cCharAt <= 383) {
                            primaries2 = cArr2[cCharAt];
                            if (primaries2 != 0) {
                                i17 = i9;
                                break;
                            }
                            if (cCharAt > '9') {
                            }
                            iLookup3 = cArr[cCharAt];
                        } else if (8192 <= cCharAt) {
                            iLookup3 = lookup(cArr, cCharAt);
                        } else {
                            iLookup3 = lookup(cArr, cCharAt);
                        }
                        if (iLookup3 >= 4096) {
                            i10 = iLookup3 & Normalizer2Impl.MIN_NORMAL_MAYBE_YES;
                        } else if (iLookup3 > i13) {
                            i10 = iLookup3 & LONG_PRIMARY_MASK;
                        } else {
                            jNextPair = nextPair(cArr, cCharAt, iLookup3, charSequence2, i9);
                            if (jNextPair < 0) {
                                i17 += 2;
                                jNextPair = ~jNextPair;
                            } else {
                                i17 = i9;
                            }
                            i11 = (int) jNextPair;
                            if (i11 == 1) {
                                return -2;
                            }
                            primaries2 = getPrimaries(i13, i11);
                        }
                        i17 = i9;
                        primaries2 = i10;
                        break;
                    }
                    primaries2 = 2;
                    break;
                }
                i3 = -1;
                if (primaries == primaries2) {
                    i4 = primaries & i14;
                    i5 = primaries2 & i14;
                    if (i4 != i5) {
                        if (i4 < i5) {
                            return -1;
                        }
                        return 1;
                    }
                    i6 = 1;
                    if (primaries == 2) {
                        break;
                        break;
                    }
                    primaries >>>= 16;
                    primaries2 >>>= 16;
                } else {
                    if (primaries == 2) {
                        i6 = 1;
                        break;
                    }
                    primaries = 0;
                    primaries2 = 0;
                }
            }
        }
        if (CollationSettings.getStrength(i15) >= i6) {
            int i20 = i2;
            int i21 = i20;
            int secondariesFromOneShortCE = 0;
            int secondariesFromOneShortCE2 = 0;
            while (true) {
                if (secondariesFromOneShortCE == 0) {
                    if (i20 == charSequence.length()) {
                        secondariesFromOneShortCE = 2;
                    } else {
                        int i22 = i20 + 1;
                        char cCharAt3 = charSequence.charAt(i20);
                        if (cCharAt3 <= 383) {
                            iLookup2 = cArr[cCharAt3];
                        } else {
                            iLookup2 = (8192 > cCharAt3 || cCharAt3 >= PUNCT_LIMIT) ? lookup(cArr, cCharAt3) : cArr[cCharAt3 - 7808];
                        }
                        if (iLookup2 >= 4096) {
                            i20 = i22;
                            secondariesFromOneShortCE = getSecondariesFromOneShortCE(iLookup2);
                        } else if (iLookup2 > i13) {
                            i20 = i22;
                            secondariesFromOneShortCE = 192;
                        } else {
                            long jNextPair3 = nextPair(cArr, cCharAt3, iLookup2, charSequence, i22);
                            if (jNextPair3 < 0) {
                                i20 += 2;
                                jNextPair3 = ~jNextPair3;
                            } else {
                                i20 = i22;
                            }
                            secondariesFromOneShortCE = getSecondaries(i13, (int) jNextPair3);
                        }
                    }
                }
                while (true) {
                    if (secondariesFromOneShortCE2 == 0) {
                        if (i21 == charSequence2.length()) {
                            secondariesFromOneShortCE2 = 2;
                        } else {
                            int i23 = i21 + 1;
                            char cCharAt4 = charSequence2.charAt(i21);
                            if (cCharAt4 <= 383) {
                                i3 = i3;
                                iLookup = cArr[cCharAt4];
                                c = 4096;
                            } else {
                                c = 4096;
                                iLookup = (8192 > cCharAt4 || cCharAt4 >= PUNCT_LIMIT) ? lookup(cArr, cCharAt4) : cArr[cCharAt4 - 7808];
                            }
                            if (iLookup >= c) {
                                i21 = i23;
                                secondariesFromOneShortCE2 = getSecondariesFromOneShortCE(iLookup);
                                break;
                            }
                            if (iLookup > i13) {
                                i21 = i23;
                                secondariesFromOneShortCE2 = 192;
                                break;
                            }
                            long jNextPair4 = nextPair(cArr, cCharAt4, iLookup, charSequence2, i23);
                            if (jNextPair4 < 0) {
                                i21 += 2;
                                jNextPair4 = ~jNextPair4;
                            } else {
                                i21 = i23;
                            }
                            secondariesFromOneShortCE2 = getSecondaries(i13, (int) jNextPair4);
                            i3 = i3;
                        }
                    }
                    break;
                }
                if (secondariesFromOneShortCE != secondariesFromOneShortCE2) {
                    int i24 = secondariesFromOneShortCE & i14;
                    int i25 = secondariesFromOneShortCE2 & i14;
                    if (i24 != i25) {
                        if ((i & 2048) != 0) {
                            return -2;
                        }
                        if (i24 < i25) {
                            return i3;
                        }
                        return 1;
                    }
                    if (secondariesFromOneShortCE == 2) {
                        break;
                    }
                    secondariesFromOneShortCE >>>= 16;
                    secondariesFromOneShortCE2 >>>= 16;
                    i3 = i3;
                } else {
                    if (secondariesFromOneShortCE == 2) {
                        break;
                    }
                    secondariesFromOneShortCE = 0;
                    secondariesFromOneShortCE2 = 0;
                    i3 = i3;
                }
            }
        } else {
            i3 = -1;
        }
        if ((i & 1024) == 0) {
            i7 = 1;
            break;
        }
        boolean z = CollationSettings.getStrength(i15) == 0;
        int i26 = i2;
        int i27 = i26;
        loop4: while (true) {
            int cases = 0;
            int cases2 = 0;
            while (true) {
                if (cases == 0) {
                    if (i26 == charSequence.length()) {
                        cases = 2;
                    } else {
                        int i28 = i26 + 1;
                        char cCharAt5 = charSequence.charAt(i26);
                        int iLookup5 = cCharAt5 <= 383 ? cArr[cCharAt5] : lookup(cArr, cCharAt5);
                        if (iLookup5 < 3072) {
                            long jNextPair5 = nextPair(cArr, cCharAt5, iLookup5, charSequence, i28);
                            if (jNextPair5 < 0) {
                                i28 = i26 + 2;
                                jNextPair5 = ~jNextPair5;
                            }
                            iLookup5 = (int) jNextPair5;
                        }
                        i26 = i28;
                        cases = getCases(i13, z, iLookup5);
                    }
                }
                while (cases2 == 0) {
                    if (i27 == charSequence2.length()) {
                        cases2 = 2;
                        break;
                    }
                    int i29 = i27 + 1;
                    char cCharAt6 = charSequence2.charAt(i27);
                    int iLookup6 = cCharAt6 <= 383 ? cArr[cCharAt6] : lookup(cArr, cCharAt6);
                    if (iLookup6 < 3072) {
                        long jNextPair6 = nextPair(cArr, cCharAt6, iLookup6, charSequence2, i29);
                        if (jNextPair6 < 0) {
                            i29 = i27 + 2;
                            jNextPair6 = ~jNextPair6;
                        }
                        iLookup6 = (int) jNextPair6;
                    }
                    i27 = i29;
                    cases2 = getCases(i13, z, iLookup6);
                }
                if (cases == cases2) {
                    break;
                }
                int i30 = cases & i14;
                int i31 = cases2 & i14;
                if (i30 != i31) {
                    if ((i & 256) == 0) {
                        if (i30 < i31) {
                            return i3;
                        }
                        return 1;
                    }
                    if (i30 < i31) {
                        return 1;
                    }
                    return i3;
                }
                i7 = 1;
                if (cases == 2) {
                    break loop4;
                }
                cases >>>= 16;
                cases2 >>>= 16;
            }
            if (cases == 2) {
                i7 = 1;
                break;
            }
        }
        if (CollationSettings.getStrength(i15) <= i7) {
            return 0;
        }
        boolean zIsTertiaryWithCaseBits = CollationSettings.isTertiaryWithCaseBits(i15);
        int i32 = i2;
        int i33 = i32;
        loop7: do {
            tertiaries = 0;
            int tertiaries2 = 0;
            while (true) {
                if (tertiaries == 0) {
                    if (i32 == charSequence.length()) {
                        tertiaries = 2;
                    } else {
                        int i34 = i32 + 1;
                        char cCharAt7 = charSequence.charAt(i32);
                        int iLookup7 = cCharAt7 <= 383 ? cArr[cCharAt7] : lookup(cArr, cCharAt7);
                        if (iLookup7 < 3072) {
                            long jNextPair7 = nextPair(cArr, cCharAt7, iLookup7, charSequence, i34);
                            if (jNextPair7 < 0) {
                                i34 = i32 + 2;
                                jNextPair7 = ~jNextPair7;
                            }
                            iLookup7 = (int) jNextPair7;
                        }
                        i32 = i34;
                        tertiaries = getTertiaries(i13, zIsTertiaryWithCaseBits, iLookup7);
                    }
                }
                while (tertiaries2 == 0) {
                    if (i33 == charSequence2.length()) {
                        tertiaries2 = 2;
                        break;
                    }
                    int i35 = i33 + 1;
                    char cCharAt8 = charSequence2.charAt(i33);
                    int iLookup8 = cCharAt8 <= 383 ? cArr[cCharAt8] : lookup(cArr, cCharAt8);
                    if (iLookup8 < 3072) {
                        long jNextPair8 = nextPair(cArr, cCharAt8, iLookup8, charSequence2, i35);
                        if (jNextPair8 < 0) {
                            i35 = i33 + 2;
                            jNextPair8 = ~jNextPair8;
                        }
                        iLookup8 = (int) jNextPair8;
                    }
                    i33 = i35;
                    tertiaries2 = getTertiaries(i13, zIsTertiaryWithCaseBits, iLookup8);
                }
                if (tertiaries == tertiaries2) {
                    break;
                }
                int i36 = tertiaries & i14;
                int i37 = tertiaries2 & i14;
                if (i36 != i37) {
                    if (CollationSettings.sortsTertiaryUpperCaseFirst(i15)) {
                        if (i36 > 3) {
                            i36 ^= 24;
                        }
                        if (i37 > 3) {
                            i37 ^= 24;
                        }
                    }
                    if (i36 < i37) {
                        return i3;
                    }
                    return 1;
                }
                i8 = 2;
                if (tertiaries == 2) {
                    break loop7;
                }
                tertiaries >>>= 16;
                tertiaries2 >>>= 16;
            }
            i8 = 2;
        } while (tertiaries != 2);
        if (CollationSettings.getStrength(i15) <= i8) {
            return 0;
        }
        int i38 = i2;
        int i39 = i38;
        loop10: do {
            quaternaries = 0;
            int quaternaries2 = 0;
            while (true) {
                if (quaternaries == 0) {
                    if (i38 == charSequence.length()) {
                        quaternaries = 2;
                    } else {
                        int i40 = i38 + 1;
                        char cCharAt9 = charSequence.charAt(i38);
                        int iLookup9 = cCharAt9 <= 383 ? cArr[cCharAt9] : lookup(cArr, cCharAt9);
                        if (iLookup9 < 3072) {
                            long jNextPair9 = nextPair(cArr, cCharAt9, iLookup9, charSequence, i40);
                            if (jNextPair9 < 0) {
                                i40 = i38 + 2;
                                jNextPair9 = ~jNextPair9;
                            }
                            iLookup9 = (int) jNextPair9;
                        }
                        i38 = i40;
                        quaternaries = getQuaternaries(i13, iLookup9);
                    }
                }
                while (quaternaries2 == 0) {
                    if (i39 == charSequence2.length()) {
                        quaternaries2 = 2;
                        break;
                    }
                    int i41 = i39 + 1;
                    char cCharAt10 = charSequence2.charAt(i39);
                    int iLookup10 = cCharAt10 <= 383 ? cArr[cCharAt10] : lookup(cArr, cCharAt10);
                    if (iLookup10 < 3072) {
                        long jNextPair10 = nextPair(cArr, cCharAt10, iLookup10, charSequence2, i41);
                        if (jNextPair10 < 0) {
                            i41 = i39 + 2;
                            jNextPair10 = ~jNextPair10;
                        }
                        iLookup10 = (int) jNextPair10;
                    }
                    i39 = i41;
                    quaternaries2 = getQuaternaries(i13, iLookup10);
                }
                if (quaternaries == quaternaries2) {
                    break;
                }
                int i42 = quaternaries & i14;
                int i43 = quaternaries2 & i14;
                if (i42 != i43) {
                    if (i42 < i43) {
                        return i3;
                    }
                    return 1;
                }
                if (quaternaries == 2) {
                    break loop10;
                }
                quaternaries >>>= 16;
                quaternaries2 >>>= 16;
            }
        } while (quaternaries != 2);
        return 0;
    }

    private static int getCases(int i, boolean z, int i2) {
        if (i2 > 65535) {
            int i3 = 65535 & i2;
            if (i3 >= 4096) {
                return (z && ((-67108864) & i2) == 0) ? i2 & 24 : TWO_CASES_MASK & i2;
            }
            if (i3 > i) {
                return TWO_LOWER_CASES;
            }
            return 0;
        }
        if (i2 >= 4096) {
            int i4 = i2 & 24;
            return (z || (i2 & 992) < 384) ? i4 : i4 | ArabicShaping.TASHKEEL_RESIZE;
        }
        if (i2 > i) {
            return 8;
        }
        if (i2 >= 3072) {
            return 0;
        }
        return i2;
    }

    public static int getCharIndex(char c) {
        if (c <= 383) {
            return c;
        }
        if (8192 > c || c >= PUNCT_LIMIT) {
            return -1;
        }
        return c - 7808;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c3 A[LOOP:2: B:64:0x00bf->B:66:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    public static int getOptions(CollationData collationData, CollationSettings collationSettings, char[] cArr) {
        int i;
        char c;
        char c2;
        char[] cArr2;
        int i2;
        int i3;
        int i4;
        char c3;
        int i5;
        char c4;
        char[] cArr3 = collationData.fastLatinTableHeader;
        if (cArr3 == null || cArr.length != 384) {
            return -1;
        }
        char c5 = 0;
        if ((collationSettings.options & 12) == 0) {
            i = 3071;
        } else {
            int i6 = cArr3[0] & 255;
            int maxVariable = collationSettings.getMaxVariable() + 1;
            if (maxVariable >= i6) {
                return -1;
            }
            i = cArr3[maxVariable] | 7;
        }
        if (collationSettings.hasReordering()) {
            int i7 = 4096;
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (i7 < 4104) {
                char c6 = c5;
                long jReorder = collationSettings.reorder(collationData.getFirstPrimaryForGroup(i7));
                if (i7 == 4100) {
                    j4 = jReorder;
                    j3 = j;
                } else if (jReorder == 0) {
                    continue;
                } else {
                    if (jReorder < j) {
                        return -1;
                    }
                    if (j4 != 0 && j2 == 0 && j == j3) {
                        j2 = jReorder;
                    }
                    j = jReorder;
                }
                i7++;
                c5 = c6;
            }
            c = c5;
            long jReorder2 = collationSettings.reorder(collationData.getFirstPrimaryForGroup(25));
            if (jReorder2 < j) {
                return -1;
            }
            if (j2 == 0) {
                j2 = jReorder2;
            }
            if (j3 >= j4 || j4 >= j2) {
                c2 = 1;
            }
            cArr2 = collationData.fastLatinTable;
            for (i2 = c; i2 < 384; i2++) {
                c3 = cArr2[i2];
                if (c3 >= 4096) {
                    c4 = 64512;
                } else {
                    if (c3 > i) {
                        c4 = 65528;
                    } else {
                        i5 = c;
                    }
                    cArr[i2] = (char) i5;
                }
                i5 = c3 & c4;
                cArr[i2] = (char) i5;
            }
            if (c2 == 0 || (collationSettings.options & 2) != 0) {
                for (i3 = 48; i3 <= 57; i3++) {
                    cArr[i3] = c;
                }
            }
            i4 = collationSettings.options;
            if (c2 != 0) {
                i4 |= 2;
            }
            return i4 | (i << 16);
        }
        c = 0;
        c2 = c;
        cArr2 = collationData.fastLatinTable;
        while (i2 < 384) {
            c3 = cArr2[i2];
            if (c3 >= 4096) {
                c4 = 64512;
            } else {
                if (c3 > i) {
                    c4 = 65528;
                } else {
                    i5 = c;
                }
                cArr[i2] = (char) i5;
            }
            i5 = c3 & c4;
            cArr[i2] = (char) i5;
        }
        if (c2 == 0) {
            while (i3 <= 57) {
                cArr[i3] = c;
            }
        } else {
            while (i3 <= 57) {
                cArr[i3] = c;
            }
        }
        i4 = collationSettings.options;
        if (c2 != 0) {
            i4 |= 2;
        }
        return i4 | (i << 16);
    }

    private static int getPrimaries(int i, int i2) {
        int i3;
        int i4 = 65535 & i2;
        if (i4 >= 4096) {
            i3 = TWO_SHORT_PRIMARIES_MASK;
        } else {
            if (i4 <= i) {
                if (i4 >= 3072) {
                    return 0;
                }
                return i2;
            }
            i3 = TWO_LONG_PRIMARIES_MASK;
        }
        return i3 & i2;
    }

    private static int getQuaternaries(int i, int i2) {
        int i3;
        if (i2 <= 65535) {
            if (i2 >= 4096) {
                return (i2 & 992) >= 384 ? TWO_SHORT_PRIMARIES_MASK : Normalizer2Impl.MIN_NORMAL_MAYBE_YES;
            }
            if (i2 > i) {
                return Normalizer2Impl.MIN_NORMAL_MAYBE_YES;
            }
            if (i2 < 3072) {
                return i2;
            }
            i3 = LONG_PRIMARY_MASK;
        } else {
            if ((65535 & i2) > i) {
                return TWO_SHORT_PRIMARIES_MASK;
            }
            i3 = TWO_LONG_PRIMARIES_MASK;
        }
        return i3 & i2;
    }

    private static int getSecondaries(int i, int i2) {
        if (i2 > 65535) {
            int i3 = 65535 & i2;
            if (i3 >= 4096) {
                return (TWO_SECONDARIES_MASK & i2) + 2097184;
            }
            if (i3 > i) {
                return TWO_COMMON_SEC_PLUS_OFFSET;
            }
            return 0;
        }
        if (i2 >= 4096) {
            return getSecondariesFromOneShortCE(i2);
        }
        if (i2 > i) {
            return 192;
        }
        if (i2 >= 3072) {
            return 0;
        }
        return i2;
    }

    private static int getSecondariesFromOneShortCE(int i) {
        int i2 = i & 992;
        return i2 < 384 ? i2 + 32 : ((i2 + 32) << 16) | 192;
    }

    private static int getTertiaries(int i, boolean z, int i2) {
        if (i2 > 65535) {
            int i3 = 65535 & i2;
            if (i3 >= 4096) {
                return (z ? 2031647 & i2 : i2 & TWO_TERTIARIES_MASK) + 2097184;
            }
            if (i3 <= i) {
                return 0;
            }
            int i4 = (i2 & TWO_TERTIARIES_MASK) + 2097184;
            return z ? i4 | TWO_LOWER_CASES : i4;
        }
        if (i2 >= 4096) {
            if (z) {
                int i5 = (i2 & 31) + 32;
                return (i2 & 992) >= 384 ? 2621440 | i5 : i5;
            }
            int i6 = (i2 & 7) + 32;
            return (i2 & 992) >= 384 ? 2097152 | i6 : i6;
        }
        if (i2 > i) {
            int i7 = (i2 & 7) + 32;
            return z ? i7 | 8 : i7;
        }
        if (i2 >= 3072) {
            return 0;
        }
        return i2;
    }

    private static int lookup(char[] cArr, int i) {
        if (8192 <= i && i < PUNCT_LIMIT) {
            return cArr[i - 7808];
        }
        if (i == 65534) {
            return 3;
        }
        return i == 65535 ? 64680 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    private static long nextPair(char[] cArr, int i, int i2, CharSequence charSequence, int i3) {
        boolean z;
        int i4;
        if (i2 >= 3072 || i2 < 1024) {
            return i2;
        }
        if (i2 >= 2048) {
            int i5 = i2 & 1023;
            return ((long) cArr[i5 + NUM_FAST_CHARS]) | (((long) cArr[i5 + 449]) << 16);
        }
        int i6 = (i2 & 1023) + NUM_FAST_CHARS;
        if (i3 == charSequence.length()) {
            z = false;
        } else {
            int iCharAt = charSequence.charAt(i3);
            if (iCharAt > 383) {
                if (8192 <= iCharAt && iCharAt < PUNCT_LIMIT) {
                    iCharAt -= 7808;
                } else {
                    if (iCharAt != 65534 && iCharAt != 65535) {
                        return 1L;
                    }
                    iCharAt = -1;
                }
            }
            char c = cArr[i6];
            int i7 = i6;
            do {
                i7 += c >> '\t';
                c = cArr[i7];
                i4 = c & 511;
            } while (i4 < iCharAt);
            if (i4 == iCharAt) {
                i6 = i7;
                z = true;
            } else {
                z = false;
            }
        }
        int i8 = cArr[i6] >> '\t';
        if (i8 == 1) {
            return 1L;
        }
        char c2 = cArr[i6 + 1];
        long j = i8 == 2 ? c2 : (((long) cArr[i6 + 2]) << 16) | ((long) c2);
        return z ? ~j : j;
    }
}
