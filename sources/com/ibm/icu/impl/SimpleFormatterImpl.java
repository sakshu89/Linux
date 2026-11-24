package com.ibm.icu.impl;

import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.text.Format;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleFormatterImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARG_NUM_LIMIT = 256;
    private static final String[][] COMMON_PATTERNS = {new String[]{"{0} {1}", "\u0002\u0000ā \u0001"}, new String[]{"{0} ({1})", "\u0002\u0000Ă (\u0001ā)"}, new String[]{"{0}, {1}", "\u0002\u0000Ă, \u0001"}, new String[]{"{0} – {1}", "\u0002\u0000ă – \u0001"}};
    private static final char LEN1_CHAR = 257;
    private static final char LEN2_CHAR = 258;
    private static final char LEN3_CHAR = 259;
    private static final int MAX_SEGMENT_LENGTH = 65279;
    private static final char SEGMENT_LENGTH_ARGUMENT_CHAR = 65535;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class IterInternal {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final long DONE = -1;

        public static int getArgIndex(long j) {
            return (int) j;
        }

        public static long step(long j, CharSequence charSequence, Appendable appendable) {
            int i = ((int) (j >>> 32)) + 1;
            while (i < charSequence.length() && charSequence.charAt(i) > 256) {
                int iCharAt = (charSequence.charAt(i) + i) - 255;
                try {
                    appendable.append(charSequence, i + 1, iCharAt);
                    i = iCharAt;
                } catch (IOException e) {
                    kf2.h(e);
                    return 0L;
                }
            }
            if (i == charSequence.length()) {
                return -1L;
            }
            return ((long) charSequence.charAt(i)) | (((long) i) << 32);
        }
    }

    private SimpleFormatterImpl() {
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:71:0x0114  */
    public static String compileToStringMinMaxArguments(CharSequence charSequence, StringBuilder sb, int i, int i2) {
        int iCharAt;
        int i3 = 0;
        int i4 = 1;
        if (i <= 2 && 2 <= i2) {
            for (String[] strArr : COMMON_PATTERNS) {
                if (strArr[0].contentEquals(charSequence)) {
                    return strArr[1];
                }
            }
        }
        int length = charSequence.length();
        sb.ensureCapacity(length);
        sb.setLength(1);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        while (i5 < length) {
            int i9 = i5 + 1;
            char cCharAt = charSequence.charAt(i5);
            i4 = i4;
            if (cCharAt == '\'') {
                if (i9 < length && (cCharAt = charSequence.charAt(i9)) == '\'') {
                    i5 += 2;
                } else if (i7 != 0) {
                    i7 = i3;
                    i5 = i9;
                } else if (cCharAt == '{' || cCharAt == '}') {
                    i5 += 2;
                    i7 = i4;
                } else {
                    cCharAt = '\'';
                }
                if (i6 == 0) {
                    sb.append((char) 65535);
                }
                sb.append(cCharAt);
                i6++;
                if (i6 == MAX_SEGMENT_LENGTH) {
                    i6 = 0;
                }
                i3 = 0;
            } else {
                if (i7 == 0 && cCharAt == '{') {
                    if (i6 > 0) {
                        sb.setCharAt((sb.length() - i6) - 1, (char) (i6 + 256));
                        i6 = i3;
                    }
                    int i10 = i5 + 2;
                    if (i10 >= length || (iCharAt = charSequence.charAt(i9) - '0') < 0 || iCharAt > 9 || charSequence.charAt(i10) != '}') {
                        if (i9 >= length) {
                            iCharAt = -1;
                        } else {
                            cCharAt = charSequence.charAt(i9);
                            if ('1' > cCharAt || cCharAt > '9') {
                                i9 = i10;
                                iCharAt = -1;
                            } else {
                                int i11 = cCharAt - 48;
                                while (true) {
                                    i9 = i10;
                                    if (i9 >= length) {
                                        break;
                                    }
                                    i10 = i9 + 1;
                                    cCharAt = charSequence.charAt(i9);
                                    if ('0' > cCharAt || cCharAt > '9' || (i11 = (i11 * 10) + (cCharAt - 48)) >= 256) {
                                        i9 = i10;
                                        break;
                                    }
                                }
                                iCharAt = i11;
                            }
                        }
                        if (iCharAt < 0 || cCharAt != '}') {
                            throw new IllegalArgumentException("Argument syntax error in pattern \"" + String.valueOf(charSequence) + "\" at index " + i5 + ": " + String.valueOf(charSequence.subSequence(i5, i9)));
                        }
                        i5 = i9;
                    } else {
                        i5 += 3;
                    }
                    if (iCharAt > i8) {
                        i8 = iCharAt;
                    }
                    sb.append((char) iCharAt);
                }
                i3 = 0;
            }
            i5 = i9;
            if (i6 == 0) {
                sb.append((char) 65535);
            }
            sb.append(cCharAt);
            i6++;
            if (i6 == MAX_SEGMENT_LENGTH) {
                i6 = 0;
            }
            i3 = 0;
        }
        if (i6 > 0) {
            sb.setCharAt((sb.length() - i6) - 1, (char) (i6 + 256));
        }
        int i12 = i8 + 1;
        if (i12 < i) {
            throw new IllegalArgumentException("Fewer than minimum " + i + " arguments in pattern \"" + String.valueOf(charSequence) + "\"");
        }
        if (i12 <= i2) {
            sb.setCharAt(0, (char) i12);
            return sb.toString();
        }
        throw new IllegalArgumentException("More than maximum " + i2 + " arguments in pattern \"" + String.valueOf(charSequence) + "\"");
    }

    private static StringBuilder format(String str, CharSequence[] charSequenceArr, StringBuilder sb, String str2, boolean z, int[] iArr) {
        int length;
        if (iArr == null) {
            length = 0;
        } else {
            length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = -1;
            }
        }
        int i2 = 1;
        while (i2 < str.length()) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 256) {
                CharSequence charSequence = charSequenceArr[cCharAt];
                if (charSequence != sb) {
                    if (cCharAt < length) {
                        iArr[cCharAt] = sb.length();
                    }
                    sb.append(charSequence);
                } else {
                    if (z) {
                        og.i("Value must not be same object as result");
                        return null;
                    }
                    if (i3 != 2) {
                        if (cCharAt < length) {
                            iArr[cCharAt] = sb.length();
                        }
                        sb.append(str2);
                    } else if (cCharAt < length) {
                        iArr[cCharAt] = 0;
                    }
                }
                i2 = i3;
            } else {
                i2 = (cCharAt - 256) + i3;
                sb.append((CharSequence) str, i3, i2);
            }
        }
        return sb;
    }

    public static StringBuilder formatAndAppend(String str, StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        if ((charSequenceArr != null ? charSequenceArr.length : 0) >= getArgumentLimit(str)) {
            return format(str, charSequenceArr, sb, null, true, iArr);
        }
        og.i("Too few values.");
        return null;
    }

    public static StringBuilder formatAndReplace(String str, StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        String string = null;
        if ((charSequenceArr != null ? charSequenceArr.length : 0) < getArgumentLimit(str)) {
            og.i("Too few values.");
            return null;
        }
        int i = -1;
        if (getArgumentLimit(str) > 0) {
            int i2 = 1;
            while (i2 < str.length()) {
                int i3 = i2 + 1;
                char cCharAt = str.charAt(i2);
                if (cCharAt < 256) {
                    if (charSequenceArr[cCharAt] == sb) {
                        if (i3 == 2) {
                            i = cCharAt;
                        } else if (string == null) {
                            string = sb.toString();
                        }
                    }
                    i2 = i3;
                } else {
                    i2 = (cCharAt - 256) + i3;
                }
            }
        }
        String str2 = string;
        if (i < 0) {
            sb.setLength(0);
        }
        return format(str, charSequenceArr, sb, str2, false, iArr);
    }

    public static String formatCompiledPattern(String str, CharSequence... charSequenceArr) {
        return formatAndAppend(str, new StringBuilder(), null, charSequenceArr).toString();
    }

    public static int formatPrefixSuffix(String str, Format.Field field, int i, int i2, FormattedStringBuilder formattedStringBuilder) {
        int iInsert;
        int i3;
        if (getArgumentLimit(str) == 0) {
            return formattedStringBuilder.splice(i, i2, str, 2, str.length(), field);
        }
        if (str.charAt(1) != 0) {
            char cCharAt = str.charAt(1);
            iInsert = formattedStringBuilder.insert(i, str, 2, cCharAt - 254, field);
            i3 = cCharAt - 253;
        } else {
            iInsert = 0;
            i3 = 2;
        }
        if (i3 >= str.length()) {
            return iInsert;
        }
        int i4 = i3 + 1;
        return iInsert + formattedStringBuilder.insert(i2 + iInsert, str, i4, i4 + (str.charAt(i3) - 256), field);
    }

    public static String formatRawPattern(String str, int i, int i2, CharSequence... charSequenceArr) {
        StringBuilder sb = new StringBuilder();
        String strCompileToStringMinMaxArguments = compileToStringMinMaxArguments(str, sb, i, i2);
        sb.setLength(0);
        return formatAndAppend(strCompileToStringMinMaxArguments, sb, null, charSequenceArr).toString();
    }

    public static int getArgumentLimit(String str) {
        return str.charAt(0);
    }

    public static int getLength(String str, boolean z) {
        int iCodePointCount = 0;
        int i = 1;
        while (i < str.length()) {
            int i2 = i + 1;
            int iCharAt = str.charAt(i) - 256;
            if (iCharAt > 0) {
                i = iCharAt + i2;
                iCodePointCount = (z ? Character.codePointCount(str, i2, i) : i - i2) + iCodePointCount;
            } else {
                i = i2;
            }
        }
        return iCodePointCount;
    }

    public static int getPrefixLength(String str) {
        if (str.length() == 1) {
            return 0;
        }
        if (str.charAt(0) == 0) {
            return str.length() - 2;
        }
        if (str.charAt(1) <= 256) {
            return 0;
        }
        return str.charAt(1) - 256;
    }

    public static String getTextWithNoArguments(String str) {
        int i = 1;
        StringBuilder sb = new StringBuilder((str.length() - 1) - getArgumentLimit(str));
        while (i < str.length()) {
            int i2 = i + 1;
            int iCharAt = str.charAt(i) - 256;
            if (iCharAt > 0) {
                i = iCharAt + i2;
                sb.append((CharSequence) str, i2, i);
            } else {
                i = i2;
            }
        }
        return sb.toString();
    }
}
