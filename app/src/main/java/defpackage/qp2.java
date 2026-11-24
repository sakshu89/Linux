package defpackage;

import com.ibm.icu.impl.number.Padder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qp2 {
    public static final x42 a = new x42("\\s+");

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!ph4.c(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        if (string.length() == 10) {
            for (int i2 = 0; i2 < string.length(); i2++) {
                if (Character.isDigit(string.charAt(i2))) {
                }
            }
            return cq.k(cs2.T(5, string), Padder.FALLBACK_PADDING_STRING, cs2.p(5, string));
        }
        return cs2.V(str).toString();
    }

    public static String b(String str) {
        str.getClass();
        String string = cs2.V(a.f(str, Padder.FALLBACK_PADDING_STRING)).toString();
        if (string.length() <= 80) {
            return string;
        }
        String strT = cs2.T(80, string);
        int iC = cs2.C(strT, ' ', 0, 6);
        if (iC > 0 && iC >= 68) {
            strT = cs2.T(iC, strT);
        }
        return ky0.j(cs2.Y(strT, ',', ';', ':', ' '), "…");
    }
}
