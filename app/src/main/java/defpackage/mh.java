package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mh implements vo1 {
    public static final mh a = new mh();
    public static final fl0 b = fl0.b("requestTimeMs");
    public static final fl0 c = fl0.b("requestUptimeMs");
    public static final fl0 d = fl0.b("clientInfo");
    public static final fl0 e = fl0.b("logSource");
    public static final fl0 f = fl0.b("logSourceName");
    public static final fl0 g = fl0.b("logEvent");
    public static final fl0 h = fl0.b("qosTier");

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        xe1 xe1Var = (xe1) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.d(b, ((ri) xe1Var).a);
        ri riVar = (ri) xe1Var;
        wo1Var.d(c, riVar.b);
        wo1Var.a(d, riVar.c);
        wo1Var.a(e, riVar.d);
        wo1Var.a(f, riVar.e);
        wo1Var.a(g, riVar.f);
        wo1Var.a(h, g22.a);
    }
}
