package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zp1 implements lb1, vv {
    public final qb1 a;
    public final vp1 b;
    public aq1 c;
    public final /* synthetic */ bq1 e;

    public zp1(bq1 bq1Var, qb1 qb1Var, vp1 vp1Var) {
        vp1Var.getClass();
        this.e = bq1Var;
        this.a = qb1Var;
        this.b = vp1Var;
        qb1Var.a(this);
    }

    @Override // defpackage.vv
    public final void cancel() {
        this.a.f(this);
        vp1 vp1Var = this.b;
        vp1Var.getClass();
        vp1Var.b.remove(this);
        aq1 aq1Var = this.c;
        if (aq1Var != null) {
            aq1Var.cancel();
        }
        this.c = null;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        if (db1Var != db1.ON_START) {
            if (db1Var != db1.ON_STOP) {
                if (db1Var == db1.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                aq1 aq1Var = this.c;
                if (aq1Var != null) {
                    aq1Var.cancel();
                    return;
                }
                return;
            }
        }
        bq1 bq1Var = this.e;
        bq1Var.getClass();
        vp1 vp1Var = this.b;
        vp1Var.getClass();
        bq1Var.b.addLast(vp1Var);
        aq1 aq1Var2 = new aq1(bq1Var, vp1Var);
        vp1Var.b.add(aq1Var2);
        bq1Var.d();
        vp1Var.c = new g7(0, bq1Var, bq1.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 16);
        this.c = aq1Var2;
    }
}
