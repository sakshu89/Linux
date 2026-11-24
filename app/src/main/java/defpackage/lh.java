package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lh implements vo1 {
    public static final lh a = new lh();
    public static final fl0 b = fl0.b("eventTimeMs");
    public static final fl0 c = fl0.b("eventCode");
    public static final fl0 d = fl0.b("eventUptimeMs");
    public static final fl0 e = fl0.b("sourceExtension");
    public static final fl0 f = fl0.b("sourceExtensionJsonProto3");
    public static final fl0 g = fl0.b("timezoneOffsetSeconds");
    public static final fl0 h = fl0.b("networkConnectionInfo");

    @Override // defpackage.oi0
    public final void a(Object obj, Object obj2) {
        we1 we1Var = (we1) obj;
        wo1 wo1Var = (wo1) obj2;
        wo1Var.d(b, ((qi) we1Var).a);
        qi qiVar = (qi) we1Var;
        wo1Var.a(c, qiVar.b);
        wo1Var.d(d, qiVar.c);
        wo1Var.a(e, qiVar.d);
        wo1Var.a(f, qiVar.e);
        wo1Var.d(g, qiVar.f);
        wo1Var.a(h, qiVar.g);
    }
}
