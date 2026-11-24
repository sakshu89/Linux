package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.impl.locale.BaseLocale;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Utils {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ChineseDigits {
        final char[] digits;
        final boolean ko;
        final char[] levels;
        final char liang;
        final char[] units;
        public static final ChineseDigits DEBUG = new ChineseDigits("0123456789s", "sbq", "WYZ", 'L', false);
        public static final ChineseDigits TRADITIONAL = new ChineseDigits("零一二三四五六七八九十", "十百千", "萬億兆", 20841, false);
        public static final ChineseDigits SIMPLIFIED = new ChineseDigits("零一二三四五六七八九十", "十百千", "万亿兆", 20004, false);
        public static final ChineseDigits KOREAN = new ChineseDigits("영일이삼사오육칠팔구십", "십백천", "만억?", 51060, true);

        public ChineseDigits(String str, String str2, String str3, char c, boolean z) {
            this.digits = str.toCharArray();
            this.units = str2.toCharArray();
            this.levels = str3.toCharArray();
            this.liang = c;
            this.ko = z;
        }
    }

    public static String chineseNumber(long j, ChineseDigits chineseDigits) {
        char c;
        char c2;
        char c3;
        long j2 = j;
        if (j2 < 0) {
            j2 = -j2;
        }
        if (j2 <= 10) {
            return j2 == 2 ? String.valueOf(chineseDigits.liang) : String.valueOf(chineseDigits.digits[(int) j2]);
        }
        char[] cArr = new char[40];
        char[] charArray = String.valueOf(j2).toCharArray();
        int length = charArray.length;
        int i = -1;
        int i2 = 40;
        int i3 = -1;
        int i4 = -1;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            length += i;
            if (length < 0) {
                break;
            }
            if (i3 == i) {
                if (i4 != i) {
                    i2--;
                    cArr[i2] = chineseDigits.levels[i4];
                    z2 = false;
                    z = true;
                }
                i3++;
                c3 = '*';
            } else {
                i2--;
                c3 = '*';
                int i5 = i3 + 1;
                cArr[i2] = chineseDigits.units[i3];
                if (i5 == 3) {
                    i4++;
                    i3 = -1;
                } else {
                    i3 = i5;
                }
            }
            int i6 = charArray[length] - '0';
            if (i6 == 0) {
                if (i2 < 39 && i3 != 0) {
                    cArr[i2] = c3;
                }
                if (z || z2) {
                    i2--;
                    cArr[i2] = c3;
                } else {
                    i2--;
                    cArr[i2] = chineseDigits.digits[0];
                    z2 = i3 == 1;
                    z = true;
                }
            } else {
                i2--;
                cArr[i2] = chineseDigits.digits[i6];
                z = false;
            }
            i = -1;
        }
        char c4 = '*';
        if (j2 > 1000000) {
            int i7 = 37;
            boolean z3 = true;
            while (cArr[i7] != '0') {
                i7 -= 8;
                z3 = !z3;
                if (i7 <= i2) {
                    break;
                }
                c4 = '*';
            }
            int i8 = 33;
            while (true) {
                if (cArr[i8] == chineseDigits.digits[0] && !z3) {
                    cArr[i8] = c4;
                }
                i8 -= 8;
                z3 = !z3;
                if (i8 <= i2) {
                    break;
                }
                c4 = '*';
            }
            if (j2 >= 100000000) {
                int i9 = 32;
                while (true) {
                    int i10 = i9 - 1;
                    int iMax = Math.max(i2 - 1, i9 - 8);
                    while (true) {
                        if (i10 <= iMax) {
                            char c5 = c4;
                            char c6 = cArr[i9 + 1];
                            if (c6 != c5 && c6 != (c2 = chineseDigits.digits[0])) {
                                cArr[i9] = c2;
                                break;
                            }
                            cArr[i9] = c5;
                            break;
                        }
                        char c7 = c4;
                        if (cArr[i10] != c7) {
                            break;
                        }
                        i10--;
                        c4 = c7;
                    }
                    i9 -= 8;
                    if (i9 <= i2) {
                        break;
                    }
                    c4 = '*';
                }
            }
        }
        for (int i11 = i2; i11 < 40; i11++) {
            char c8 = cArr[i11];
            char[] cArr2 = chineseDigits.digits;
            if (c8 == cArr2[2] && ((i11 >= 39 || cArr[i11 + 1] != chineseDigits.units[0]) && (i11 <= i2 || ((c = cArr[i11 - 1]) != chineseDigits.units[0] && c != cArr2[0] && c != '*')))) {
                cArr[i11] = chineseDigits.liang;
            }
        }
        if (cArr[i2] == chineseDigits.digits[1] && (chineseDigits.ko || cArr[i2 + 1] == chineseDigits.units[0])) {
            i2++;
        }
        int i12 = i2;
        int i13 = i12;
        while (i12 < 40) {
            char c9 = cArr[i12];
            if (c9 != '*') {
                cArr[i13] = c9;
                i13++;
            }
            i12++;
        }
        return new String(cArr, i2, i13 - i2);
    }

    public static final Locale localeFromString(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(BaseLocale.SEP);
        String strSubstring2 = "";
        if (iIndexOf != -1) {
            strSubstring = str.substring(iIndexOf + 1);
            str = str.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        int iIndexOf2 = strSubstring.indexOf(BaseLocale.SEP);
        if (iIndexOf2 != -1) {
            strSubstring2 = strSubstring.substring(iIndexOf2 + 1);
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        return new Locale(str, strSubstring, strSubstring2);
    }
}
