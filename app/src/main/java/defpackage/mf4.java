package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class mf4 {
    public static boolean a(String str, String str2) {
        str2.getClass();
        if (cs2.A(str) || cs2.A(str2)) {
            return false;
        }
        String strB = b(str2);
        if (strB != null) {
            return g31.a(b(str), strB);
        }
        x42 x42Var = b50.c;
        String strM = ak1.m(str2);
        return strM.length() > 0 && g31.a(ak1.m(str), strM);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.getType(cCharAt) != 16) {
                sb.append(cCharAt);
            }
        }
        String string = cs2.V(sb.toString()).toString();
        for (int i2 = 0; i2 < string.length(); i2++) {
            char cCharAt2 = string.charAt(i2);
            if (!Character.isDigit(cCharAt2) && !ph4.c(cCharAt2) && !cs2.o("+-()", cCharAt2)) {
                return null;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int length = string.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt3 = string.charAt(i3);
            if (Character.isDigit(cCharAt3)) {
                sb2.append(cCharAt3);
            }
        }
        String string2 = sb2.toString();
        if (string2.length() > 0) {
            return string2;
        }
        return null;
    }

    public static String c(int i) {
        if (i == 0) {
            return "Clear";
        }
        if (i == 1) {
            return "Src";
        }
        if (i == 2) {
            return "Dst";
        }
        if (i == 3) {
            return "SrcOver";
        }
        if (i == 4) {
            return "DstOver";
        }
        if (i == 5) {
            return "SrcIn";
        }
        if (i == 6) {
            return "DstIn";
        }
        if (i == 7) {
            return "SrcOut";
        }
        if (i == 8) {
            return "DstOut";
        }
        if (i == 9) {
            return "SrcAtop";
        }
        if (i == 10) {
            return "DstAtop";
        }
        if (i == 11) {
            return "Xor";
        }
        if (i == 12) {
            return "Plus";
        }
        if (i == 13) {
            return "Modulate";
        }
        if (i == 14) {
            return "Screen";
        }
        if (i == 15) {
            return "Overlay";
        }
        if (i == 16) {
            return "Darken";
        }
        if (i == 17) {
            return "Lighten";
        }
        if (i == 18) {
            return "ColorDodge";
        }
        if (i == 19) {
            return "ColorBurn";
        }
        if (i == 20) {
            return "HardLight";
        }
        if (i == 21) {
            return "Softlight";
        }
        if (i == 22) {
            return "Difference";
        }
        if (i == 23) {
            return "Exclusion";
        }
        if (i == 24) {
            return "Multiply";
        }
        if (i == 25) {
            return "Hue";
        }
        if (i == 26) {
            return "Saturation";
        }
        if (i == 27) {
            return "Color";
        }
        return i == 28 ? "Luminosity" : "Unknown";
    }
}
