package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class g44 {
    public static final q91 a;
    public static final q91 b;
    public static final q91 c;
    public static final q91 d;
    public static final q91 e;

    static {
        int i = 26;
        a = new q91(i, new ra2(13), new sa2(13));
        b = new q91(i, new ra2(14), new sa2(14));
        c = new q91(i, new ra2(15), new sa2(15));
        d = new q91(i, new ra2(16), new sa2(16));
        e = new q91(i, new ra2(17), new sa2(17));
    }

    public static String a(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.getType(cCharAt) != 16) {
                sb.append(cCharAt);
            }
        }
        String string = cs2.V(sb.toString()).toString();
        if (cs2.A(string)) {
            return null;
        }
        for (int i2 = 0; i2 < string.length(); i2++) {
            char cCharAt2 = string.charAt(i2);
            if (!Character.isDigit(cCharAt2) && !ph4.c(cCharAt2) && !cs2.o("+-().", cCharAt2)) {
                return null;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < string.length(); i4++) {
            if (string.charAt(i4) == '+') {
                i3++;
            }
        }
        if (i3 > 1) {
            return null;
        }
        if (cs2.o(string, '+') && !cs2.Q(string, '+')) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = string.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt3 = string.charAt(i5);
            if (Character.isDigit(cCharAt3)) {
                sb2.append(cCharAt3);
            }
        }
        String string2 = sb2.toString();
        int length2 = string2.length();
        if (3 > length2 || length2 >= 16) {
            return null;
        }
        return string2;
    }
}
