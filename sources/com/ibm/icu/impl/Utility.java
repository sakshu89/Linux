package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeMatcher;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Utility {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char APOSTROPHE = '\'';
    private static final char BACKSLASH = '\\';
    private static final char ESCAPE = 42405;
    static final byte ESCAPE_BYTE = -91;
    private static final int MAGIC_UNSIGNED = Integer.MIN_VALUE;
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    static final char[] HEX_DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] UNESCAPE_MAP = {'a', 7, 'b', '\b', 'e', 27, 'f', '\f', 'n', '\n', 'r', '\r', 't', '\t', 'v', 11};
    static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static final byte[] RLEStringToByteArray(String str) {
        char c;
        int i;
        byte b;
        int iCharAt = (str.charAt(0) << 16) | str.charAt(1);
        byte[] bArr = new byte[iCharAt];
        int i2 = 0;
        char c2 = 0;
        char c3 = 0;
        int i3 = 0;
        boolean z = true;
        int i4 = 2;
        while (i2 < iCharAt) {
            if (z) {
                int i5 = i4 + 1;
                char cCharAt = str.charAt(i4);
                byte b2 = (byte) (cCharAt >> '\b');
                c = cCharAt;
                i = i5;
                z = false;
                b = b2;
            } else {
                byte b3 = (byte) (c3 & 255);
                c = c3;
                i = i4;
                b = b3;
                z = true;
            }
            int i6 = b;
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 == 2) {
                        int i7 = 0;
                        while (i7 < i3) {
                            bArr[i2] = b;
                            i7++;
                            i2++;
                        }
                        c2 = 0;
                    }
                } else if (b == -91) {
                    bArr[i2] = ESCAPE_BYTE;
                    i2++;
                    c2 = 0;
                } else {
                    if (b < 0) {
                        i6 = b + 256;
                    }
                    i3 = i6;
                    c2 = 2;
                }
            } else if (b == -91) {
                c2 = 1;
            } else {
                bArr[i2] = b;
                i2++;
            }
            i4 = i;
            c3 = c;
            i3 = i3;
        }
        if (c2 != 0) {
            og.n("Bad run-length encoded byte array");
            return null;
        }
        if (i4 == str.length()) {
            return bArr;
        }
        og.n("Excess data in RLE byte array string");
        return null;
    }

    public static final char[] RLEStringToCharArray(String str) {
        int iCharAt = (str.charAt(0) << 16) | str.charAt(1);
        char[] cArr = new char[iCharAt];
        int i = 2;
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 42405) {
                int i3 = i + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 == 42405) {
                    cArr[i2] = cCharAt2;
                    i2++;
                    i = i3;
                } else {
                    i += 2;
                    char cCharAt3 = str.charAt(i);
                    int i4 = 0;
                    while (i4 < cCharAt2) {
                        cArr[i2] = cCharAt3;
                        i4++;
                        i2++;
                    }
                }
            } else {
                cArr[i2] = cCharAt;
                i2++;
            }
            i++;
        }
        if (i2 == iCharAt) {
            return cArr;
        }
        og.n("Bad run-length encoded short array");
        return null;
    }

    public static final int[] RLEStringToIntArray(String str) {
        int i = getInt(str, 0);
        int[] iArr = new int[i];
        int length = str.length() / 2;
        int i2 = 1;
        int i3 = 0;
        while (i3 < i && i2 < length) {
            int i4 = i2 + 1;
            int i5 = getInt(str, i2);
            if (i5 == 42405) {
                int i6 = i2 + 2;
                int i7 = getInt(str, i4);
                if (i7 == 42405) {
                    iArr[i3] = i7;
                    i3++;
                    i2 = i6;
                } else {
                    i2 += 3;
                    int i8 = getInt(str, i6);
                    int i9 = 0;
                    while (i9 < i7) {
                        iArr[i3] = i8;
                        i9++;
                        i3++;
                    }
                }
            } else {
                iArr[i3] = i5;
                i3++;
                i2 = i4;
            }
        }
        if (i3 == i && i2 == length) {
            return iArr;
        }
        og.n("Bad run-length encoded int array");
        return null;
    }

    public static final short[] RLEStringToShortArray(String str) {
        int iCharAt = (str.charAt(0) << 16) | str.charAt(1);
        short[] sArr = new short[iCharAt];
        int i = 2;
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 42405) {
                int i3 = i + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 == 42405) {
                    sArr[i2] = (short) cCharAt2;
                    i2++;
                    i = i3;
                } else {
                    i += 2;
                    short sCharAt = (short) str.charAt(i);
                    int i4 = 0;
                    while (i4 < cCharAt2) {
                        sArr[i2] = sCharAt;
                        i4++;
                        i2++;
                    }
                }
            } else {
                sArr[i2] = (short) cCharAt;
                i2++;
            }
            i++;
        }
        if (i2 == iCharAt) {
            return sArr;
        }
        og.n("Bad run-length encoded short array");
        return null;
    }

    private static final int _digit16(int i) {
        if (i >= 48 && i <= 57) {
            return i - 48;
        }
        if (i >= 65 && i <= 70) {
            return i - 55;
        }
        if (i < 97 || i > 102) {
            return -1;
        }
        return i - 87;
    }

    private static final int _digit8(int i) {
        if (i < 48 || i > 55) {
            return -1;
        }
        return i - 48;
    }

    public static int addExact(int i, int i2) {
        int i3 = i + i2;
        if (((i ^ i3) & (i2 ^ i3)) >= 0) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static final <T extends Appendable> void appendEncodedByte(T t, byte b, byte[] bArr) {
        try {
            if (bArr[0] == 0) {
                bArr[0] = 1;
                bArr[1] = b;
            } else {
                t.append((char) ((b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | (bArr[1] << 8)));
                bArr[0] = 0;
            }
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    private static final <T extends Appendable> void appendInt(T t, int i) {
        try {
            t.append((char) (i >>> 16));
            t.append((char) (i & DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH));
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    public static <T extends Appendable> T appendNumber(T t, int i, int i2, int i3) {
        try {
            if (i2 < 2 || i2 > 36) {
                throw new IllegalArgumentException("Illegal radix " + i2);
            }
            if (i < 0) {
                i = -i;
                t.append(LanguageTag.SEP);
            }
            recursiveAppendNumber(t, i, i2, i3);
            return t;
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    public static <A extends Appendable> A appendTo(CharSequence charSequence, A a) {
        try {
            a.append(charSequence);
            return a;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    public static void appendToRule(StringBuilder sb, int i, boolean z, boolean z2, StringBuilder sb2) {
        if (!z && (!z2 || !isUnprintable(i))) {
            if (sb2.length() == 0 && (i == 39 || i == 92)) {
                sb.append('\\');
                sb.append((char) i);
                return;
            }
            if (sb2.length() <= 0 && ((i < 33 || i > 126 || ((i >= 48 && i <= 57) || ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)))) && !PatternProps.isWhiteSpace(i))) {
                sb.appendCodePoint(i);
                return;
            }
            sb2.appendCodePoint(i);
            if (i == 39) {
                sb2.append((char) i);
                return;
            }
            return;
        }
        if (sb2.length() > 0) {
            while (sb2.length() >= 2 && sb2.charAt(0) == '\'' && sb2.charAt(1) == '\'') {
                sb.append('\\');
                sb.append('\'');
                sb2.delete(0, 2);
            }
            int i2 = 0;
            while (sb2.length() >= 2 && sb2.charAt(sb2.length() - 2) == '\'' && sb2.charAt(sb2.length() - 1) == '\'') {
                sb2.setLength(sb2.length() - 2);
                i2++;
            }
            if (sb2.length() > 0) {
                sb.append('\'');
                sb.append((CharSequence) sb2);
                sb.append('\'');
                sb2.setLength(0);
            }
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                sb.append('\\');
                sb.append('\'');
                i2 = i3;
            }
        }
        if (i != -1) {
            if (i != 32) {
                if (z2 && escapeUnprintable(sb, i)) {
                    return;
                }
                sb.appendCodePoint(i);
                return;
            }
            int length = sb.length();
            if (length <= 0 || sb.charAt(length - 1) == ' ') {
                return;
            }
            sb.append(' ');
        }
    }

    public static final boolean arrayEquals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof Object[]) {
            return arrayEquals((Object[]) obj, obj2);
        }
        if (obj instanceof int[]) {
            return arrayEquals((int[]) obj, obj2);
        }
        if (obj instanceof double[]) {
            return arrayEquals((double[]) obj, obj2);
        }
        return obj instanceof byte[] ? arrayEquals((byte[]) obj, obj2) : obj.equals(obj2);
    }

    public static final boolean arrayRegionMatches(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (!arrayEquals(objArr[i], objArr2[i + i5])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final String arrayToRLEString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (bArr.length >> 16));
        sb.append((char) bArr.length);
        byte b = bArr[0];
        byte[] bArr2 = new byte[2];
        int i = 1;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            if (b2 != b || i >= 255) {
                encodeRun(sb, b, i, bArr2);
                i = 1;
                b = b2;
            } else {
                i++;
            }
        }
        encodeRun(sb, b, i, bArr2);
        if (bArr2[0] != 0) {
            appendEncodedByte(sb, (byte) 0, bArr2);
        }
        return sb.toString();
    }

    public static boolean charSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int charSequenceHashCode(CharSequence charSequence) {
        int iCharAt = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            iCharAt = (iCharAt * 31) + charSequence.charAt(i);
        }
        return iCharAt;
    }

    public static <T extends Comparable<T>> int checkCompare(T t, T t2) {
        if (t == null) {
            return t2 == null ? 0 : -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static int checkHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private static int codePointAndLength(int i, int i2, int i3) {
        return codePointAndLength(i, i3 - i2);
    }

    public static final int compareUnsigned(int i, int i2) {
        int i3 = i - MAGIC_UNSIGNED;
        int i4 = i2 - MAGIC_UNSIGNED;
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public static int cpFromCodePointAndLength(int i) {
        return i >> 8;
    }

    private static final <T extends Appendable> void encodeRun(T t, short s, int i) {
        char c = (char) s;
        try {
            if (i < 4) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (c == 42405) {
                        t.append(ESCAPE);
                    }
                    t.append(c);
                }
                return;
            }
            if (i == 42405) {
                if (c == 42405) {
                    t.append(ESCAPE);
                }
                t.append(c);
                i--;
            }
            t.append(ESCAPE);
            t.append((char) i);
            t.append(c);
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    public static <T extends Appendable> T escape(T t, int i) {
        try {
            t.append('\\');
            if (((-65536) & i) != 0) {
                t.append('U');
                char[] cArr = DIGITS;
                t.append(cArr[(i >> 28) & 15]);
                t.append(cArr[(i >> 24) & 15]);
                t.append(cArr[(i >> 20) & 15]);
                t.append(cArr[(i >> 16) & 15]);
            } else {
                t.append('u');
            }
            char[] cArr2 = DIGITS;
            t.append(cArr2[(i >> 12) & 15]);
            t.append(cArr2[(i >> 8) & 15]);
            t.append(cArr2[(i >> 4) & 15]);
            t.append(cArr2[i & 15]);
            return t;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    public static <T extends Appendable> boolean escapeUnprintable(T t, int i) {
        if (!isUnprintable(i)) {
            return false;
        }
        escape(t, i);
        return true;
    }

    public static final String format1ForSource(String str) {
        StringBuilder sb = new StringBuilder("\"");
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt == '\"' || cCharAt == '\\') {
                if (cCharAt == '\n') {
                    sb.append("\\n");
                } else if (cCharAt == '\t') {
                    sb.append("\\t");
                } else if (cCharAt == '\r') {
                    sb.append("\\r");
                } else {
                    sb.append('\\');
                    char[] cArr = HEX_DIGIT;
                    sb.append(cArr[(cCharAt & 448) >> 6]);
                    sb.append(cArr[(cCharAt & '8') >> 3]);
                    sb.append(cArr[cCharAt & 7]);
                }
            } else if (cCharAt <= '~') {
                sb.append(cCharAt);
            } else {
                sb.append("\\u");
                char[] cArr2 = HEX_DIGIT;
                sb.append(cArr2[(61440 & cCharAt) >> 12]);
                sb.append(cArr2[(cCharAt & 3840) >> 8]);
                sb.append(cArr2[(cCharAt & 240) >> 4]);
                sb.append(cArr2[cCharAt & 15]);
            }
            i = i2;
        }
        sb.append('\"');
        return sb.toString();
    }

    public static final String formatForSource(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (i > 0) {
                sb.append('+');
                sb.append(LINE_SEPARATOR);
            }
            sb.append("        \"");
            int i2 = 11;
            while (i < str.length() && i2 < 80) {
                int i3 = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt < ' ' || cCharAt == '\"' || cCharAt == '\\') {
                    if (cCharAt == '\n') {
                        sb.append("\\n");
                    } else if (cCharAt == '\t') {
                        sb.append("\\t");
                    } else if (cCharAt == '\r') {
                        sb.append("\\r");
                    } else {
                        sb.append('\\');
                        char[] cArr = HEX_DIGIT;
                        sb.append(cArr[(cCharAt & 448) >> 6]);
                        sb.append(cArr[(cCharAt & '8') >> 3]);
                        sb.append(cArr[cCharAt & 7]);
                        i2 += 4;
                    }
                    i2 += 2;
                } else if (cCharAt <= '~') {
                    sb.append(cCharAt);
                    i2++;
                } else {
                    sb.append("\\u");
                    char[] cArr2 = HEX_DIGIT;
                    sb.append(cArr2[(61440 & cCharAt) >> 12]);
                    sb.append(cArr2[(cCharAt & 3840) >> 8]);
                    sb.append(cArr2[(cCharAt & 240) >> 4]);
                    sb.append(cArr2[cCharAt & 15]);
                    i2 += 6;
                }
                i = i3;
            }
            sb.append('\"');
        }
        return sb.toString();
    }

    public static String fromHex(String str, int i, Pattern pattern) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : pattern.split(str)) {
            if (str2.length() < i) {
                og.i("code point too short: ".concat(str2));
                return null;
            }
            sb.appendCodePoint(Integer.parseInt(str2, 16));
        }
        return sb.toString();
    }

    public static final int getInt(String str, int i) {
        int i2 = i * 2;
        return str.charAt(i2 + 1) | (str.charAt(i2) << 16);
    }

    public static <S extends CharSequence, U extends CharSequence, T extends Appendable> T hex(S s, int i, U u, boolean z, T t) {
        int charCount = 0;
        try {
            if (z) {
                while (charCount < s.length()) {
                    int iCodePointAt = Character.codePointAt(s, charCount);
                    if (charCount != 0) {
                        t.append(u);
                    }
                    t.append(hex(iCodePointAt, i));
                    charCount += UTF16.getCharCount(iCodePointAt);
                }
            } else {
                while (charCount < s.length()) {
                    if (charCount != 0) {
                        t.append(u);
                    }
                    t.append(hex(s.charAt(charCount), i));
                    charCount++;
                }
            }
            return t;
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    public static final byte highBit(int i) {
        byte b;
        if (i <= 0) {
            return (byte) -1;
        }
        if (i >= 65536) {
            i >>= 16;
            b = 16;
        } else {
            b = 0;
        }
        if (i >= 256) {
            i >>= 8;
            b = (byte) (b + 8);
        }
        if (i >= 16) {
            i >>= 4;
            b = (byte) (b + 4);
        }
        if (i >= 4) {
            i >>= 2;
            b = (byte) (b + 2);
        }
        return i >= 2 ? (byte) (b + 1) : b;
    }

    public static boolean isUnprintable(int i) {
        return i < 32 || i > 126;
    }

    public static String joinStrings(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        if (charSequence == null || iterable == null) {
            dk0.n("Delimiter or elements is null");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (CharSequence charSequence2 : iterable) {
            if (charSequence2 != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(charSequence);
                }
                sb.append(charSequence2);
            }
        }
        return sb.toString();
    }

    public static int lengthFromCodePointAndLength(int i) {
        return i & 255;
    }

    public static int lookup(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static boolean parseChar(String str, int[] iArr, char c) {
        int i = iArr[0];
        int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str, i);
        iArr[0] = iSkipWhiteSpace;
        if (iSkipWhiteSpace == str.length() || str.charAt(iArr[0]) != c) {
            iArr[0] = i;
            return false;
        }
        iArr[0] = iArr[0] + 1;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0044 A[LOOP:0: B:11:0x002d->B:18:0x0044, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0047 A[EDGE_INSN: B:24:0x0047->B:19:0x0047 BREAK  A[LOOP:0: B:11:0x002d->B:18:0x0044], SYNTHETIC] */
    public static int parseInteger(String str, int[] iArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int iDigit;
        int i6;
        int i7 = iArr[0];
        if (!str.regionMatches(true, i7, "0x", 0, 2)) {
            if (i7 >= i || str.charAt(i7) != '0') {
                i2 = 10;
            } else {
                i7++;
                i3 = 1;
                i2 = 8;
                i4 = 0;
            }
            while (i7 < i) {
                i5 = i7 + 1;
                iDigit = UCharacter.digit(str.charAt(i7), i2);
                if (iDigit < 0) {
                    break;
                }
                i3++;
                i6 = (i4 * i2) + iDigit;
                if (i6 <= i4) {
                    return 0;
                }
                i4 = i6;
                i7 = i5;
            }
            if (i3 > 0) {
                iArr[0] = i7;
            }
            return i4;
        }
        i7 += 2;
        i2 = 16;
        i3 = 0;
        i4 = 0;
        while (i7 < i) {
            i5 = i7 + 1;
            iDigit = UCharacter.digit(str.charAt(i7), i2);
            if (iDigit < 0) {
                break;
                break;
            }
            i3++;
            i6 = (i4 * i2) + iDigit;
            if (i6 <= i4) {
                return 0;
            }
            i4 = i6;
            i7 = i5;
        }
        if (i3 > 0) {
            iArr[0] = i7;
        }
        return i4;
    }

    public static int parseNumber(String str, int[] iArr, int i) {
        int iDigit;
        int i2 = iArr[0];
        int i3 = 0;
        while (i2 < str.length() && (iDigit = UCharacter.digit(Character.codePointAt(str, i2), i)) >= 0) {
            i3 = (i3 * i) + iDigit;
            if (i3 < 0) {
                return -1;
            }
            i2++;
        }
        if (i2 == iArr[0]) {
            return -1;
        }
        iArr[0] = i2;
        return i3;
    }

    public static int parsePattern(String str, int i, int i2, String str2, int[] iArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < str2.length(); i4++) {
            char cCharAt = str2.charAt(i4);
            if (cCharAt != ' ') {
                if (cCharAt == '#') {
                    int[] iArr2 = {i};
                    int i5 = i3 + 1;
                    iArr[i3] = parseInteger(str, iArr2, i2);
                    int i6 = iArr2[0];
                    if (i6 == i) {
                        return -1;
                    }
                    i = i6;
                    i3 = i5;
                } else if (cCharAt != '~') {
                    if (i >= i2) {
                        return -1;
                    }
                    int i7 = i + 1;
                    if (((char) UCharacter.toLowerCase(str.charAt(i))) != cCharAt) {
                        return -1;
                    }
                    i = i7;
                }
            } else {
                if (i >= i2) {
                    return -1;
                }
                int i8 = i + 1;
                if (!PatternProps.isWhiteSpace(str.charAt(i))) {
                    return -1;
                }
                i = i8;
            }
            i = PatternProps.skipWhiteSpace(str, i);
        }
        return i;
    }

    public static String parseUnicodeIdentifier(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int charCount = iArr[0];
        while (charCount < str.length()) {
            int iCodePointAt = Character.codePointAt(str, charCount);
            if (sb.length() != 0) {
                if (!UCharacter.isUnicodeIdentifierPart(iCodePointAt)) {
                    break;
                }
                sb.appendCodePoint(iCodePointAt);
            } else {
                if (!UCharacter.isUnicodeIdentifierStart(iCodePointAt)) {
                    return null;
                }
                sb.appendCodePoint(iCodePointAt);
            }
            charCount += UTF16.getCharCount(iCodePointAt);
        }
        iArr[0] = charCount;
        return sb.toString();
    }

    public static int quotedIndexOf(String str, int i, int i2, String str2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                i++;
            } else if (cCharAt == '\'') {
                do {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                } while (str.charAt(i) != '\'');
            } else if (str2.indexOf(cCharAt) >= 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static <T extends Appendable> void recursiveAppendNumber(T t, int i, int i2, int i3) {
        try {
            int i4 = i % i2;
            if (i >= i2 || i3 > 1) {
                recursiveAppendNumber(t, i / i2, i2, i3 - 1);
            }
            t.append(DIGITS[i4]);
        } catch (IOException e) {
            throw new IllegalIcuArgumentException(e);
        }
    }

    public static String repeat(String str, int i) {
        if (i <= 0) {
            return "";
        }
        if (i == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static final boolean sameObjects(Object obj, Object obj2) {
        return obj == obj2;
    }

    public static boolean shouldAlwaysBeEscaped(int i) {
        if (i < 32) {
            return true;
        }
        if (i <= 126) {
            return false;
        }
        if (i <= 159) {
            return true;
        }
        if (i < 55296) {
            return false;
        }
        return i <= 57343 || (64976 <= i && i <= 65007) || (i & 65534) == 65534 || i > 1114111;
    }

    public static String[] split(String str, char c) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == c) {
                arrayList.add(str.substring(i2, i));
                i2 = i + 1;
            }
            i++;
        }
        arrayList.add(str.substring(i2, i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitString(String str, String str2) {
        return str.split("\\Q" + str2 + "\\E");
    }

    public static String[] splitWhitespace(String str) {
        return str.split("\\s+");
    }

    public static String unescape(CharSequence charSequence) {
        StringBuilder sb = null;
        int i = 0;
        while (i < charSequence.length()) {
            int i2 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(charSequence.length());
                    sb.append(charSequence, 0, i);
                }
                int iUnescapeAndLengthAt = unescapeAndLengthAt(charSequence, i2);
                if (iUnescapeAndLengthAt < 0) {
                    og.i("Invalid escape sequence ".concat(String.valueOf(charSequence.subSequence(i, Math.min(i + 10, charSequence.length())))));
                    return null;
                }
                sb.appendCodePoint(iUnescapeAndLengthAt >> 8);
                i2 += iUnescapeAndLengthAt & 255;
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i = i2;
        }
        return sb == null ? charSequence.toString() : sb.toString();
    }

    private static int unescapeAndLengthAt(CharSequence charSequence, int i, int i2) {
        int codePoint;
        int i3;
        boolean z;
        int i4;
        if (i < 0 || i >= i2) {
            return -1;
        }
        int i5 = i + 1;
        int iCharAt = charSequence.charAt(i);
        int i6 = 8;
        int i7 = 0;
        int i8 = 4;
        if (iCharAt == 85) {
            codePoint = 0;
            i3 = 0;
            z = false;
            i4 = 4;
            i8 = 8;
        } else if (iCharAt == 117) {
            codePoint = 0;
            i3 = 0;
            z = false;
            i6 = 4;
            i4 = 4;
        } else if (iCharAt != 120) {
            codePoint = _digit8(iCharAt);
            if (codePoint >= 0) {
                i8 = 3;
                i4 = 3;
                i6 = 1;
                i3 = 1;
                z = false;
            } else {
                codePoint = 0;
                i6 = 0;
                i3 = 0;
                z = false;
                i4 = 4;
                i8 = 0;
            }
        } else if (i5 >= i2 || charSequence.charAt(i5) != '{') {
            codePoint = 0;
            i3 = 0;
            z = false;
            i4 = 4;
            i8 = 2;
            i6 = 1;
        } else {
            i5 = i + 2;
            z = true;
            codePoint = 0;
            i3 = 0;
            i4 = 4;
            i8 = 8;
            i6 = 1;
        }
        if (i6 == 0) {
            while (true) {
                char[] cArr = UNESCAPE_MAP;
                if (i7 >= cArr.length) {
                    break;
                }
                char c = cArr[i7];
                if (iCharAt == c) {
                    return codePointAndLength(cArr[i7 + 1], i, i5);
                }
                if (iCharAt < c) {
                    break;
                }
                i7 += 2;
            }
            if (iCharAt == 99 && i5 < i2) {
                int iCodePointAt = Character.codePointAt(charSequence, i5);
                return codePointAndLength(iCodePointAt & 31, i, Character.charCount(iCodePointAt) + i5);
            }
            if (UTF16.isLeadSurrogate(iCharAt) && i5 < i2) {
                char cCharAt = charSequence.charAt(i5);
                if (UTF16.isTrailSurrogate(cCharAt)) {
                    i5++;
                    iCharAt = UCharacter.toCodePoint(iCharAt, cCharAt);
                }
            }
            return codePointAndLength(iCharAt, i, i5);
        }
        while (i5 < i2 && i3 < i8) {
            iCharAt = charSequence.charAt(i5);
            int i_digit8 = i4 == 3 ? _digit8(iCharAt) : _digit16(iCharAt);
            if (i_digit8 < 0) {
                break;
            }
            codePoint = (codePoint << i4) | i_digit8;
            i5++;
            i3++;
        }
        if (i3 < i6) {
            return -1;
        }
        if (z) {
            if (iCharAt != 125) {
                return -1;
            }
            i5++;
        }
        if (codePoint < 0 || codePoint >= 1114112) {
            return -1;
        }
        if (i5 < i2 && UTF16.isLeadSurrogate(codePoint)) {
            int i9 = i5 + 1;
            int iCharAt2 = charSequence.charAt(i5);
            if (iCharAt2 == 92 && i9 < i2) {
                int i10 = i5 + 12;
                if (i10 <= i2) {
                    i2 = i10;
                }
                int iUnescapeAndLengthAt = unescapeAndLengthAt(charSequence, i9, i2);
                if (iUnescapeAndLengthAt >= 0) {
                    iCharAt2 = iUnescapeAndLengthAt >> 8;
                    i9 += iUnescapeAndLengthAt & 255;
                }
            }
            if (UTF16.isTrailSurrogate(iCharAt2)) {
                codePoint = UCharacter.toCodePoint(codePoint, iCharAt2);
                i5 = i9;
            }
        }
        return codePointAndLength(codePoint, i, i5);
    }

    public static String unescapeLeniently(CharSequence charSequence) {
        StringBuilder sb = null;
        int i = 0;
        while (i < charSequence.length()) {
            int i2 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(charSequence.length());
                    sb.append(charSequence, 0, i);
                }
                int iUnescapeAndLengthAt = unescapeAndLengthAt(charSequence, i2);
                if (iUnescapeAndLengthAt < 0) {
                    sb.append(cCharAt);
                } else {
                    sb.appendCodePoint(iUnescapeAndLengthAt >> 8);
                    i2 += iUnescapeAndLengthAt & 255;
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i = i2;
        }
        return sb == null ? charSequence.toString() : sb.toString();
    }

    public static String valueOf(int[] iArr) {
        StringBuilder sb = new StringBuilder(iArr.length);
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        return sb.toString();
    }

    private static int codePointAndLength(int i, int i2) {
        return (i << 8) | i2;
    }

    public static final boolean arrayRegionMatches(char[] cArr, int i, char[] cArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (cArr[i] != cArr2[i + i5]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final boolean arrayRegionMatches(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (iArr[i] != iArr2[i + i5]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final boolean arrayRegionMatches(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (dArr[i] != dArr2[i + i5]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final boolean arrayRegionMatches(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = i2 - i;
        while (i < i4) {
            if (bArr[i] != bArr2[i + i5]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static String fromHex(String str, int i, String str2) {
        if (str2 == null) {
            str2 = "\\s+";
        }
        return fromHex(str, i, Pattern.compile(str2));
    }

    public static void split(String str, char c, String[] strArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == c) {
                strArr[i2] = str.substring(i3, i);
                i3 = i + 1;
                i2++;
            }
            i++;
        }
        strArr[i2] = str.substring(i3, i);
        for (int i4 = i2 + 1; i4 < strArr.length; i4++) {
            strArr[i4] = "";
        }
    }

    private static final <T extends Appendable> void encodeRun(T t, int i, int i2) {
        if (i2 < 4) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (i == 42405) {
                    appendInt(t, i);
                }
                appendInt(t, i);
            }
            return;
        }
        if (i2 == 42405) {
            if (i == 42405) {
                appendInt(t, 42405);
            }
            appendInt(t, i);
            i2--;
        }
        appendInt(t, 42405);
        appendInt(t, i2);
        appendInt(t, i);
    }

    public static final boolean arrayEquals(int[] iArr, Object obj) {
        if (iArr == null) {
            return obj == null;
        }
        if (!(obj instanceof int[])) {
            return false;
        }
        int[] iArr2 = (int[]) obj;
        return iArr.length == iArr2.length && arrayRegionMatches(iArr, 0, iArr2, 0, iArr.length);
    }

    private static final <T extends Appendable> void encodeRun(T t, byte b, int i, byte[] bArr) {
        if (i < 4) {
            for (int i2 = 0; i2 < i; i2++) {
                if (b == -91) {
                    appendEncodedByte(t, ESCAPE_BYTE, bArr);
                }
                appendEncodedByte(t, b, bArr);
            }
            return;
        }
        if (((byte) i) == -91) {
            if (b == -91) {
                appendEncodedByte(t, ESCAPE_BYTE, bArr);
            }
            appendEncodedByte(t, b, bArr);
            i--;
        }
        appendEncodedByte(t, ESCAPE_BYTE, bArr);
        appendEncodedByte(t, (byte) i, bArr);
        appendEncodedByte(t, b, bArr);
    }

    public static final boolean arrayEquals(double[] dArr, Object obj) {
        if (dArr == null) {
            return obj == null;
        }
        if (!(obj instanceof double[])) {
            return false;
        }
        double[] dArr2 = (double[]) obj;
        return dArr.length == dArr2.length && arrayRegionMatches(dArr, 0, dArr2, 0, dArr.length);
    }

    public static final String arrayToRLEString(short[] sArr) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (sArr.length >> 16));
        sb.append((char) sArr.length);
        short s = sArr[0];
        int i = 1;
        for (int i2 = 1; i2 < sArr.length; i2++) {
            short s2 = sArr[i2];
            if (s2 != s || i >= 65535) {
                encodeRun(sb, s, i);
                i = 1;
                s = s2;
            } else {
                i++;
            }
        }
        encodeRun(sb, s, i);
        return sb.toString();
    }

    public static final boolean arrayEquals(byte[] bArr, Object obj) {
        if (bArr == null) {
            return obj == null;
        }
        if (!(obj instanceof byte[])) {
            return false;
        }
        byte[] bArr2 = (byte[]) obj;
        return bArr.length == bArr2.length && arrayRegionMatches(bArr, 0, bArr2, 0, bArr.length);
    }

    public static String hex(long j, int i) {
        if (j == Long.MIN_VALUE) {
            return "-8000000000000000";
        }
        boolean z = j < 0;
        if (z) {
            j = -j;
        }
        String upperCase = Long.toString(j, 16).toUpperCase(Locale.ENGLISH);
        if (upperCase.length() < i) {
            upperCase = "0000000000000000".substring(upperCase.length(), i).concat(upperCase);
        }
        return z ? LanguageTag.SEP.concat(upperCase) : upperCase;
    }

    public static final boolean arrayEquals(Object[] objArr, Object obj) {
        if (objArr == null) {
            return obj == null;
        }
        if (!(obj instanceof Object[])) {
            return false;
        }
        Object[] objArr2 = (Object[]) obj;
        return objArr.length == objArr2.length && arrayRegionMatches(objArr, 0, objArr2, 0, objArr.length);
    }

    public static String hex(CharSequence charSequence) {
        return ((StringBuilder) hex(charSequence, 4, ",", true, new StringBuilder())).toString();
    }

    public static final String arrayToRLEString(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (cArr.length >> 16));
        sb.append((char) cArr.length);
        char c = cArr[0];
        int i = 1;
        for (int i2 = 1; i2 < cArr.length; i2++) {
            char c2 = cArr[i2];
            if (c2 != c || i >= 65535) {
                encodeRun(sb, (short) c, i);
                i = 1;
                c = c2;
            } else {
                i++;
            }
        }
        encodeRun(sb, (short) c, i);
        return sb.toString();
    }

    public static String hex(long j) {
        return hex(j, 4);
    }

    public static String hex(byte[] bArr, int i, int i2, String str) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            if (i != 0) {
                sb.append(str);
            }
            sb.append(hex(bArr[i]));
            i++;
        }
        return sb.toString();
    }

    public static <S extends CharSequence> String hex(S s, int i, S s2) {
        return ((StringBuilder) hex(s, i, s2, true, new StringBuilder())).toString();
    }

    public static final String arrayToRLEString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        appendInt(sb, iArr.length);
        int i = iArr[0];
        int i2 = 1;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 != i || i2 >= 65535) {
                encodeRun(sb, i, i2);
                i2 = 1;
                i = i4;
            } else {
                i2++;
            }
        }
        encodeRun(sb, i, i2);
        return sb.toString();
    }

    public static int parsePattern(String str, Replaceable replaceable, int i, int i2) {
        if (str.length() == 0) {
            return i;
        }
        int i3 = 0;
        int iCodePointAt = Character.codePointAt(str, 0);
        while (i < i2) {
            int iChar32At = replaceable.char32At(i);
            if (iCodePointAt != 126) {
                if (iChar32At != iCodePointAt) {
                    break;
                }
                int charCount = UTF16.getCharCount(iChar32At);
                i += charCount;
                i3 += charCount;
                if (i3 == str.length()) {
                    return i;
                }
            } else if (PatternProps.isWhiteSpace(iChar32At)) {
                i += UTF16.getCharCount(iChar32At);
            } else {
                i3++;
                if (i3 == str.length()) {
                    return i;
                }
            }
            iCodePointAt = UTF16.charAt(str, i3);
        }
        return -1;
    }

    public static final String escape(String str) {
        StringBuilder sb = new StringBuilder();
        int charCount = 0;
        while (charCount < str.length()) {
            int iCodePointAt = Character.codePointAt(str, charCount);
            charCount += UTF16.getCharCount(iCodePointAt);
            if (iCodePointAt < 32 || iCodePointAt > 127) {
                boolean z = iCodePointAt <= 65535;
                sb.append(z ? "\\u" : "\\U");
                sb.append(hex(iCodePointAt, z ? 4 : 8));
            } else if (iCodePointAt == 92) {
                sb.append("\\\\");
            } else {
                sb.append((char) iCodePointAt);
            }
        }
        return sb.toString();
    }

    public static void appendToRule(StringBuilder sb, String str, boolean z, boolean z2, StringBuilder sb2) {
        for (int i = 0; i < str.length(); i++) {
            appendToRule(sb, str.charAt(i), z, z2, sb2);
        }
    }

    public static void appendToRule(StringBuilder sb, UnicodeMatcher unicodeMatcher, boolean z, StringBuilder sb2) {
        if (unicodeMatcher != null) {
            appendToRule(sb, unicodeMatcher.toPattern(z), true, z, sb2);
        }
    }

    public static int unescapeAndLengthAt(CharSequence charSequence, int i) {
        return unescapeAndLengthAt(charSequence, i, charSequence.length());
    }
}
