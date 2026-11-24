package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.StringPrepParseException;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.util.ICUInputTooLongException;
import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int CAPITAL_A = 65;
    private static final int CAPITAL_Z = 90;
    private static final int DAMP = 700;
    private static final int DECODE_MAX_CHARS = 2000;
    private static final char DELIMITER = '-';
    private static final int ENCODE_MAX_CODE_UNITS = 1000;
    private static final char HYPHEN = '-';
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int SKEW = 38;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    private static final int ZERO = 48;

    private static int adaptBias(int i, int i2, boolean z) {
        int i3 = z ? i / DAMP : i / 2;
        int i4 = (i3 / i2) + i3;
        int i5 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i5 += 36;
        }
        return ((i4 * 36) / (i4 + 38)) + i5;
    }

    private static char asciiCaseMap(char c, boolean z) {
        int i;
        if (z) {
            if ('a' <= c && c <= 'z') {
                i = c - ' ';
                return (char) i;
            }
            return c;
        }
        if ('A' <= c && c <= 'Z') {
            i = c + ' ';
            return (char) i;
        }
        return c;
    }

    public static StringBuilder decode(CharSequence charSequence, boolean[] zArr) throws StringPrepParseException {
        int i;
        boolean z;
        int i2;
        int i3;
        int iOffsetByCodePoints;
        int length = charSequence.length();
        if (length > DECODE_MAX_CHARS) {
            throw new ICUInputTooLongException(cq.h("input too long: ", length, " characters"));
        }
        StringBuilder sb = new StringBuilder(charSequence.length());
        int i4 = length;
        while (i4 > 0) {
            i4--;
            if (charSequence.charAt(i4) == '-') {
                break;
            }
        }
        boolean z2 = false;
        for (int i5 = 0; i5 < i4; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (!isBasic(cCharAt)) {
                throw new StringPrepParseException("Illegal char found", 0);
            }
            sb.append(cCharAt);
            if (zArr != null && i5 < zArr.length) {
                zArr[i5] = isBasicUpperCase(cCharAt);
            }
        }
        int i6 = i4 > 0 ? i4 + 1 : 0;
        int i7 = 128;
        int iAdaptBias = 72;
        int i8 = 1000000000;
        int i9 = 0;
        while (i6 < length) {
            int i10 = 36;
            int i11 = i9;
            int i12 = 1;
            while (true) {
                if (i6 >= length) {
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                i = i6 + 1;
                z = z2;
                int iDecodeDigit = decodeDigit(charSequence.charAt(i6));
                if (iDecodeDigit < 0) {
                    throw new StringPrepParseException("Invalid char found", z ? 1 : 0);
                }
                if (iDecodeDigit > (Integer.MAX_VALUE - i11) / i12) {
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                i11 += iDecodeDigit * i12;
                int i13 = i10 - iAdaptBias;
                i2 = i4;
                if (i13 < 1) {
                    i13 = 1;
                    i3 = 1;
                } else {
                    i3 = 1;
                    if (i10 >= iAdaptBias + 26) {
                        i13 = 26;
                    }
                }
                if (iDecodeDigit < i13) {
                    break;
                }
                int i14 = i3;
                int i15 = 36 - i13;
                if (i12 > Integer.MAX_VALUE / i15) {
                    throw new StringPrepParseException("Illegal char found", i14);
                }
                i12 *= i15;
                i10 += 36;
                i6 = i;
                z2 = z ? 1 : 0;
                i4 = i2;
            }
            i4 = i2 + 1;
            iAdaptBias = adaptBias(i11 - i9, i4, i9 == 0 ? true : z ? 1 : 0);
            int i16 = i11 / i4;
            if (i16 > Integer.MAX_VALUE - i7) {
                throw new StringPrepParseException("Illegal char found", 1);
            }
            i7 += i16;
            int i17 = i11 % i4;
            if (i7 > 1114111 || isSurrogate(i7)) {
                throw new StringPrepParseException("Illegal char found", 1);
            }
            int iCharCount = Character.charCount(i7);
            if (i17 > i8) {
                iOffsetByCodePoints = sb.offsetByCodePoints(i8, i17 - i8);
            } else if (iCharCount > 1) {
                i8 = i17;
                iOffsetByCodePoints = i8;
            } else {
                i8++;
                iOffsetByCodePoints = i17;
            }
            if (zArr != null && sb.length() + iCharCount <= zArr.length) {
                if (iOffsetByCodePoints < sb.length()) {
                    System.arraycopy(zArr, iOffsetByCodePoints, zArr, iOffsetByCodePoints + iCharCount, sb.length() - iOffsetByCodePoints);
                }
                zArr[iOffsetByCodePoints] = isBasicUpperCase(charSequence.charAt(i6));
                if (iCharCount == 2) {
                    zArr[iOffsetByCodePoints + 1] = z;
                }
            }
            if (iCharCount == 1) {
                sb.insert(iOffsetByCodePoints, (char) i7);
            } else {
                sb.insert(iOffsetByCodePoints, UTF16.getLeadSurrogate(i7));
                sb.insert(iOffsetByCodePoints + 1, UTF16.getTrailSurrogate(i7));
            }
            i9 = i17 + 1;
            i6 = i;
            z2 = z ? 1 : 0;
        }
        return sb;
    }

    private static final int decodeDigit(int i) {
        if (i > 90) {
            if (i <= 122) {
                return i - 97;
            }
            return -1;
        }
        if (i > 57) {
            return i - 65;
        }
        if (i < 48) {
            return -1;
        }
        return i - 22;
    }

    private static char digitToBasic(int i, boolean z) {
        int i2;
        if (i < 26) {
            i2 = z ? i + 65 : i + 97;
        } else {
            i2 = i + 22;
        }
        return (char) i2;
    }

    public static StringBuilder encode(CharSequence charSequence, boolean[] zArr) throws StringPrepParseException {
        int i;
        int length = charSequence.length();
        if (length > 1000) {
            throw new ICUInputTooLongException(cq.h("input too long: ", length, " UTF-16 code units"));
        }
        int[] iArr = new int[length];
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (isBasic(cCharAt)) {
                i = i3 + 1;
                iArr[i3] = 0;
                char cAsciiCaseMap = cCharAt;
                if (zArr != null) {
                    cAsciiCaseMap = asciiCaseMap(cCharAt, zArr[i2]);
                }
                sb.append(cAsciiCaseMap);
            } else {
                int i4 = ((zArr == null || !zArr[i2]) ? 0 : 1) << 31;
                boolean zIsSurrogate = UTF16.isSurrogate(cCharAt);
                int codePoint = cCharAt;
                if (zIsSurrogate) {
                    if (UTF16.isLeadSurrogate(cCharAt) && (i2 = i2 + 1) < length) {
                        char cCharAt2 = charSequence.charAt(i2);
                        if (UTF16.isTrailSurrogate(cCharAt2)) {
                            codePoint = UCharacter.getCodePoint(cCharAt, cCharAt2);
                        }
                    }
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                int i5 = codePoint | i4;
                i = i3 + 1;
                iArr[i3] = i5;
            }
            i3 = i;
            i2++;
        }
        int length2 = sb.length();
        if (length2 > 0) {
            sb.append('-');
        }
        int i6 = 128;
        int i7 = 72;
        int i8 = length2;
        int i9 = 0;
        while (i8 < i3) {
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < i3; i11++) {
                int i12 = iArr[i11] & Integer.MAX_VALUE;
                if (i6 <= i12 && i12 < i10) {
                    i10 = i12;
                }
            }
            int i13 = i10 - i6;
            int i14 = i8 + 1;
            if (i13 > ((Integer.MAX_VALUE - i8) - i9) / i14) {
                og.n("Internal program error");
                return null;
            }
            int i15 = (i13 * i14) + i9;
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = iArr[i16] & Integer.MAX_VALUE;
                if (i17 < i10) {
                    i15++;
                } else if (i17 == i10) {
                    int i18 = 36;
                    int i19 = i15;
                    while (true) {
                        int i20 = i18 - i7;
                        if (i20 < 1) {
                            i20 = 1;
                        } else if (i18 >= i7 + 26) {
                            i20 = 26;
                        }
                        if (i19 < i20) {
                            break;
                        }
                        int i21 = i19 - i20;
                        int i22 = 36 - i20;
                        sb.append(digitToBasic((i21 % i22) + i20, false));
                        i19 = i21 / i22;
                        i18 += 36;
                    }
                    sb.append(digitToBasic(i19, iArr[i16] < 0));
                    int i23 = i8 + 1;
                    int iAdaptBias = adaptBias(i15, i23, i8 == length2);
                    i8 = i23;
                    i7 = iAdaptBias;
                    i15 = 0;
                }
            }
            i9 = i15 + 1;
            i6 = i10 + 1;
        }
        return sb;
    }

    private static boolean isBasic(int i) {
        return i < 128;
    }

    private static boolean isBasicUpperCase(int i) {
        return 65 <= i && i >= 90;
    }

    private static boolean isSurrogate(int i) {
        return (i & (-2048)) == 55296;
    }
}
