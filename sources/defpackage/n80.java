package defpackage;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class n80 {
    public static final x50[] a = new x50[0];

    public static String a(String str, String str2) {
        int length;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt) && !cs2.o("+ -().", cCharAt)) {
                return null;
            }
        }
        StringBuilder sb = new StringBuilder();
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char cCharAt2 = str.charAt(i2);
            if (Character.isDigit(cCharAt2) || cCharAt2 == '+') {
                sb.append(cCharAt2);
            }
        }
        String string = sb.toString();
        if (cs2.A(string)) {
            return null;
        }
        if (cs2.Q(string, '+')) {
            String strP = cs2.p(1, string);
            for (int i3 = 0; i3 < strP.length(); i3++) {
                if (!Character.isDigit(strP.charAt(i3))) {
                    return null;
                }
            }
            int length3 = strP.length();
            if (8 > length3 || length3 >= 16 || cs2.Q(strP, '0')) {
                return null;
            }
            return strP;
        }
        if (js2.k(string, "00", false)) {
            return a("+".concat(cs2.p(2, string)), str2);
        }
        for (int i4 = 0; i4 < string.length(); i4++) {
            if (!Character.isDigit(string.charAt(i4))) {
                return null;
            }
        }
        Map map = vw1.b;
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str2.toLowerCase(locale);
        lowerCase.getClass();
        String str3 = (String) map.get(lowerCase);
        if (str3 == null) {
            return null;
        }
        if (!str3.equals("39")) {
            string = cs2.G(string, "0");
        }
        if (str3.equals("91")) {
            if (string.length() != 12 || !js2.k(string, "91", false)) {
                if (string.length() == 10) {
                    return "91".concat(string);
                }
                return null;
            }
        } else if (!str3.equals("1") || string.length() != 11 || !cs2.Q(string, '1')) {
            String strConcat = str3.concat(string);
            if (string.length() < 7 || 8 > (length = strConcat.length()) || length >= 16) {
                return null;
            }
            return strConcat;
        }
        return string;
    }
}
