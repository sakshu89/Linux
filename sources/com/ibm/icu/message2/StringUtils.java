package com.ibm.icu.message2;

import com.ibm.icu.text.Normalizer2;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class StringUtils {
    private static final Normalizer2 NFC_NORMALIZER = Normalizer2.getNFCInstance();

    public static boolean isAlpha(int i) {
        if (i < 97 || i > 122) {
            return i >= 65 && i <= 90;
        }
        return true;
    }

    public static boolean isBackslash(int i) {
        return i == 92;
    }

    public static boolean isBidi(int i) {
        if (i == 1564 || i == 8206 || i == 8207) {
            return true;
        }
        return i >= 8294 && i <= 8297;
    }

    public static boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    public static boolean isFunctionSigil(int i) {
        return i == 58;
    }

    public static boolean isNameChar(int i) {
        return isNameStart(i) || isDigit(i) || i == 45 || i == 46;
    }

    public static boolean isNameStart(int i) {
        if (isAlpha(i) || i == 43 || i == 95) {
            return true;
        }
        if (i >= 161 && i <= 1563) {
            return true;
        }
        if (i >= 1565 && i <= 5759) {
            return true;
        }
        if (i >= 5761 && i <= 8191) {
            return true;
        }
        if (i >= 8203 && i <= 8205) {
            return true;
        }
        if (i >= 8208 && i <= 8231) {
            return true;
        }
        if (i >= 8240 && i <= 8286) {
            return true;
        }
        if (i >= 8288 && i <= 8293) {
            return true;
        }
        if (i >= 8298 && i <= 12287) {
            return true;
        }
        if (i >= 12289 && i <= 55295) {
            return true;
        }
        if (i >= 57344 && i <= 64975) {
            return true;
        }
        if (i >= 65008 && i <= 65533) {
            return true;
        }
        if (i >= 65536 && i <= 131069) {
            return true;
        }
        if (i >= 131072 && i <= 196605) {
            return true;
        }
        if (i >= 196608 && i <= 262141) {
            return true;
        }
        if (i >= 262144 && i <= 327677) {
            return true;
        }
        if (i >= 327680 && i <= 393213) {
            return true;
        }
        if (i >= 393216 && i <= 458749) {
            return true;
        }
        if (i >= 458752 && i <= 524285) {
            return true;
        }
        if (i >= 524288 && i <= 589821) {
            return true;
        }
        if (i >= 589824 && i <= 655357) {
            return true;
        }
        if (i >= 655360 && i <= 720893) {
            return true;
        }
        if (i >= 720896 && i <= 786429) {
            return true;
        }
        if (i >= 786432 && i <= 851965) {
            return true;
        }
        if (i >= 851968 && i <= 917501) {
            return true;
        }
        if (i >= 917504 && i <= 983037) {
            return true;
        }
        if (i < 983040 || i > 1048573) {
            return i >= 1048576 && i <= 1114109;
        }
        return true;
    }

    public static boolean isQuotedChar(int i) {
        return (i >= 1 && i <= 91) || (i >= 93 && i <= 123) || (i >= 125 && i <= 1114111);
    }

    public static boolean isSimpleStartChar(int i) {
        return (i >= 1 && i <= 8) || (i >= 11 && i <= 12) || ((i >= 14 && i <= 31) || ((i >= 33 && i <= 45) || ((i >= 47 && i <= 91) || ((i >= 93 && i <= 122) || i == 124 || ((i >= 126 && i <= 12287) || (i >= 12289 && i <= 1114111))))));
    }

    public static boolean isTextChar(int i) {
        return (i >= 1 && i <= 91) || (i >= 93 && i <= 122) || i == 124 || (i >= 126 && i <= 1114111);
    }

    public static boolean isWhitespace(int i) {
        return i == 32 || i == 9 || i == 13 || i == 10 || i == 12288;
    }

    public static String toNfc(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return NFC_NORMALIZER.normalize(charSequence);
    }
}
