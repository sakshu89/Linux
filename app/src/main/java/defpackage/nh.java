package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nh implements vo1 {
    public static final nh a = new nh();
    public static final fl0 b = fl0.b("networkType");
    public static final fl0 c = fl0.b("mobileSubtype");

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        mn1 mn1Var = (mn1) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.a(b, ((ti) mn1Var).a);
        wo1Var.a(c, ((ti) mn1Var).b);
    }
}
