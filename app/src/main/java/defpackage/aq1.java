package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aq1 implements vv {
    public final vp1 a;
    public final /* synthetic */ bq1 b;

    public aq1(bq1 bq1Var, vp1 vp1Var) {
        vp1Var.getClass();
        this.b = bq1Var;
        this.a = vp1Var;
    }

    @Override // defpackage.vv
    public final void cancel() {
        bq1 bq1Var = this.b;
        hg hgVar = bq1Var.b;
        vp1 vp1Var = this.a;
        hgVar.remove(vp1Var);
        if (g31.a(bq1Var.c, vp1Var)) {
            vp1Var.getClass();
            bq1Var.c = null;
        }
        vp1Var.getClass();
        vp1Var.b.remove(this);
        fq0 fq0Var = vp1Var.c;
        if (fq0Var != null) {
            fq0Var.a();
        }
        vp1Var.c = null;
    }
}
