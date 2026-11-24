package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nr0 implements up, ch {
    public final /* synthetic */ int a;
    public final /* synthetic */ wc1 b;

    public /* synthetic */ nr0(wc1 wc1Var, int i) {
        this.a = i;
        this.b = wc1Var;
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        int i = this.a;
        wc1 wc1Var = this.b;
        switch (i) {
            case 1:
                return ((ks) wc1Var.get()).b();
            default:
                return ((ks) wc1Var.get()).a();
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        cb0 cb0Var = new cb0(tpVar, 1);
        dd0 dd0VarA = xg4.a();
        wc1 wc1Var = this.b;
        wc1Var.a(cb0Var, dd0VarA);
        return "transformVoidFuture [" + wc1Var + "]";
    }
}
