package com.ibm.icu.lang;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.text.UTF16;
import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CharSequences {
    private CharSequences() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    @Deprecated
    public static int[] codePoints(CharSequence charSequence) {
        int length = charSequence.length();
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 56320 || cCharAt > 57343 || i2 == 0) {
                iArr[i] = cCharAt;
                i++;
            } else {
                int i3 = i - 1;
                char c = (char) iArr[i3];
                if (c < 55296 || c > 56319) {
                    iArr[i] = cCharAt;
                    i++;
                } else {
                    iArr[i3] = Character.toCodePoint(c, cCharAt);
                }
            }
        }
        if (i == length) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    @Deprecated
    public static int compare(CharSequence charSequence, int i) {
        if (i < 0 || i > 1114111) {
            dk0.v();
            return 0;
        }
        int length = charSequence.length();
        if (length == 0) {
            return -1;
        }
        char cCharAt = charSequence.charAt(0);
        int i2 = i - 65536;
        if (i2 < 0) {
            int i3 = cCharAt - i;
            return i3 != 0 ? i3 : length - 1;
        }
        int i4 = cCharAt - ((char) ((i2 >>> 10) + 55296));
        if (i4 != 0) {
            return i4;
        }
        if (length > 1) {
            int iCharAt = charSequence.charAt(1) - ((char) ((i2 & UCharacterProperty.MAX_SCRIPT) + UTF16.TRAIL_SURROGATE_MIN_VALUE));
            if (iCharAt != 0) {
                return iCharAt;
            }
        }
        return length - 2;
    }

    @Deprecated
    public static final boolean equals(int i, CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != 1) {
            return length == 2 && i > 65535 && i == Character.codePointAt(charSequence, 0);
        }
        return i == charSequence.charAt(0);
    }

    @Deprecated
    public static boolean equalsChars(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() == charSequence2.length() && compare(charSequence, charSequence2) == 0;
    }

    @Deprecated
    public static int getSingleCodePoint(CharSequence charSequence) {
        int length = charSequence.length();
        if (length >= 1 && length <= 2) {
            int iCodePointAt = Character.codePointAt(charSequence, 0);
            if ((iCodePointAt < 65536) == (length == 1)) {
                return iCodePointAt;
            }
        }
        return Integer.MAX_VALUE;
    }

    @Deprecated
    public static int indexOf(CharSequence charSequence, int i) {
        int iCharCount = 0;
        while (iCharCount < charSequence.length()) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            if (iCodePointAt == i) {
                return iCharCount;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return -1;
    }

    @Deprecated
    public static int matchAfter(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i3 = i;
        while (i3 < length && i2 < length2 && charSequence.charAt(i3) == charSequence2.charAt(i2)) {
            i3++;
            i2++;
        }
        int i4 = i3 - i;
        return (i4 == 0 || onCharacterBoundary(charSequence, i3) || onCharacterBoundary(charSequence2, i2)) ? i4 : i4 - 1;
    }

    @Deprecated
    public static boolean onCharacterBoundary(CharSequence charSequence, int i) {
        return i <= 0 || i >= charSequence.length() || !Character.isHighSurrogate(charSequence.charAt(i + (-1))) || !Character.isLowSurrogate(charSequence.charAt(i));
    }

    @Deprecated
    public int codePointLength(CharSequence charSequence) {
        return Character.codePointCount(charSequence, 0, charSequence.length());
    }

    @Deprecated
    public static final boolean equals(CharSequence charSequence, int i) {
        return equals(i, charSequence);
    }

    @Deprecated
    public static final <T> boolean equals(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        if (t2 == null) {
            return false;
        }
        return t.equals(t2);
    }

    @Deprecated
    public static int compare(int i, CharSequence charSequence) {
        int iCompare = compare(charSequence, i);
        if (iCompare > 0) {
            return -1;
        }
        return iCompare < 0 ? 1 : 0;
    }

    @Deprecated
    public static int compare(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i = length <= length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            int iCharAt = charSequence.charAt(i2) - charSequence2.charAt(i2);
            if (iCharAt != 0) {
                return iCharAt;
            }
        }
        return length - length2;
    }
}
