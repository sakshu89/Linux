package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l93 {
    public static x4 a(String str, boolean z) {
        str.getClass();
        String string = cs2.V(str).toString();
        if (string.length() != 0) {
            if (if4.b(string)) {
                return u4.a;
            }
            if (!z) {
                return new t4(string);
            }
            String strA = if4.a(string);
            if (strA != null && js2.k(strA, "sonic ", false) && xy.o(string)) {
                return new t4(string);
            }
        }
        return v4.a;
    }
}
