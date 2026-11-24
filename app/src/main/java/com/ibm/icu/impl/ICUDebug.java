package com.ibm.icu.impl;

import defpackage.ky0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ICUDebug {
    private static boolean debug;
    private static boolean help;
    private static String params;

    static {
        try {
            params = System.getProperty("ICUDebug");
        } catch (SecurityException unused) {
        }
        String str = params;
        boolean z = false;
        boolean z2 = str != null;
        debug = z2;
        if (z2 && (str.equals("") || params.indexOf("help") != -1)) {
            z = true;
        }
        help = z;
        if (debug) {
            ky0.y("\nICUDebug=", params, System.out);
        }
    }

    public static boolean enabled(String str) {
        boolean z = false;
        if (debug) {
            z = params.indexOf(str) != -1;
            if (help) {
                System.out.println("\nICUDebug.enabled(" + str + ") = " + z);
            }
        }
        return z;
    }

    public static String value(String str) {
        String strSubstring = "false";
        if (debug) {
            int iIndexOf = params.indexOf(str);
            if (iIndexOf != -1) {
                int length = str.length() + iIndexOf;
                if (params.length() <= length || params.charAt(length) != '=') {
                    strSubstring = "true";
                } else {
                    int i = length + 1;
                    int iIndexOf2 = params.indexOf(",", i);
                    String str2 = params;
                    if (iIndexOf2 == -1) {
                        iIndexOf2 = str2.length();
                    }
                    strSubstring = str2.substring(i, iIndexOf2);
                }
            }
            if (help) {
                System.out.println("\nICUDebug.value(" + str + ") = " + strSubstring);
            }
        }
        return strSubstring;
    }

    public static boolean enabled() {
        return debug;
    }
}
