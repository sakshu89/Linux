package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j62 {
    public final oj a;
    public final lv2 b;
    public final wp c;
    public final wp d;
    public final tp e;
    public final tp f;
    public boolean g = false;
    public boolean h = false;
    public xw i;

    public j62(oj ojVar, lv2 lv2Var) {
        this.a = ojVar;
        this.b = lv2Var;
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        try {
            this.e = tpVar;
            tpVar.a = "CaptureCompleteFuture";
        } catch (Exception e) {
            wpVar.b(e);
        }
        this.c = wpVar;
        tp tpVar2 = new tp();
        tpVar2.c = new o62();
        wp wpVar2 = new wp(tpVar2);
        tpVar2.b = wpVar2;
        try {
            this.f = tpVar2;
            tpVar2.a = "RequestCompleteFuture";
        } catch (Exception e2) {
            wpVar2.b(e2);
        }
        this.d = wpVar2;
    }

    public final void a() {
        hh1.e("The callback can only complete once.", !this.d.b.isDone());
        this.f.a(null);
    }
}
