package com.ibm.icu.impl;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocaleUtility {
    public static Locale fallback(Locale locale) {
        String[] strArr = new String[3];
        strArr[0] = locale.getLanguage();
        strArr[1] = locale.getCountry();
        strArr[2] = locale.getVariant();
        int i = 2;
        while (i >= 0) {
            if (strArr[i].length() != 0) {
                strArr[i] = "";
                break;
            }
            i--;
        }
        if (i < 0) {
            return null;
        }
        return new Locale(strArr[0], strArr[1], strArr[2]);
    }

    public static Locale getLocaleFromName(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(95);
        String strSubstring2 = "";
        if (iIndexOf < 0) {
            strSubstring = "";
        } else {
            String strSubstring3 = str.substring(0, iIndexOf);
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(95, i);
            if (iIndexOf2 < 0) {
                strSubstring = "";
                strSubstring2 = str.substring(i);
            } else {
                strSubstring2 = str.substring(i, iIndexOf2);
                strSubstring = str.substring(iIndexOf2 + 1);
            }
            str = strSubstring3;
        }
        return new Locale(str, strSubstring2, strSubstring);
    }

    public static boolean isFallbackOf(String str, String str2) {
        if (!str2.startsWith(str)) {
            return false;
        }
        int length = str.length();
        return length == str2.length() || str2.charAt(length) == '_';
    }

    public static boolean isFallbackOf(Locale locale, Locale locale2) {
        return isFallbackOf(locale.toString(), locale2.toString());
    }
}
