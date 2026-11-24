package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lb4 implements vo1 {
    public static final lb4 a = new lb4();
    public static final fl0 b = new fl0("maxMs", ky0.r(w14.b(t14.class, new l14(1))));
    public static final fl0 c = new fl0("minMs", ky0.r(w14.b(t14.class, new l14(2))));
    public static final fl0 d = new fl0("avgMs", ky0.r(w14.b(t14.class, new l14(3))));
    public static final fl0 e = new fl0("firstQuartileMs", ky0.r(w14.b(t14.class, new l14(4))));
    public static final fl0 f = new fl0("medianMs", ky0.r(w14.b(t14.class, new l14(5))));
    public static final fl0 g = new fl0("thirdQuartileMs", ky0.r(w14.b(t14.class, new l14(6))));

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        jm4 jm4Var = (jm4) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.a(b, jm4Var.a);
        wo1Var.a(c, jm4Var.b);
        wo1Var.a(d, jm4Var.c);
        wo1Var.a(e, jm4Var.d);
        wo1Var.a(f, jm4Var.e);
        wo1Var.a(g, jm4Var.f);
    }
}
