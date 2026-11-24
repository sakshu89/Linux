package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r84 implements vo1 {
    public static final r84 a = new r84();
    public static final fl0 b = new fl0("logEventKey", ky0.r(w14.b(t14.class, new l14(1))));
    public static final fl0 c = new fl0("eventCount", ky0.r(w14.b(t14.class, new l14(2))));
    public static final fl0 d = new fl0("inferenceDurationStats", ky0.r(w14.b(t14.class, new l14(3))));

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        i54 i54Var = (i54) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.a(b, i54Var.a);
        wo1Var.a(c, i54Var.b);
        wo1Var.a(d, i54Var.c);
    }
}
