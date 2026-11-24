package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ky2 implements wx2 {
    public final /* synthetic */ ny2 a;
    public final /* synthetic */ boolean b;

    public ky2(ny2 ny2Var, boolean z) {
        this.a = ny2Var;
        this.b = z;
    }

    @Override // defpackage.wx2
    public final void a() {
        ny2 ny2Var = this.a;
        ny2Var.r.setValue(null);
        ny2Var.s.setValue(null);
        ny2Var.t(true);
    }

    @Override // defpackage.wx2
    public final void c() {
        ny2 ny2Var = this.a;
        ny2Var.r.setValue(null);
        ny2Var.s.setValue(null);
        ny2Var.t(true);
    }

    @Override // defpackage.wx2
    public final void d() {
        hz2 hz2VarD;
        boolean z = this.b;
        pv0 pv0Var = z ? pv0.b : pv0.c;
        ny2 ny2Var = this.a;
        ny2Var.r.setValue(pv0Var);
        long jA = wf2.a(ny2Var.l(z));
        ua1 ua1Var = ny2Var.d;
        if (ua1Var == null || (hz2VarD = ua1Var.d()) == null) {
            return;
        }
        long jE = hz2VarD.e(jA);
        ny2Var.o = jE;
        ny2Var.s.setValue(new jp1(jE));
        ny2Var.q = 0L;
        ny2Var.t = -1;
        ua1 ua1Var2 = ny2Var.d;
        if (ua1Var2 != null) {
            ua1Var2.q.setValue(Boolean.TRUE);
        }
        ny2Var.t(false);
    }

    @Override // defpackage.wx2
    public final void e(long j) {
        ny2 ny2Var = this.a;
        long jE = jp1.e(ny2Var.q, j);
        ny2Var.q = jE;
        ny2Var.s.setValue(new jp1(jp1.e(ny2Var.o, jE)));
        ty2 ty2VarN = ny2Var.n();
        jp1 jp1VarI = ny2Var.i();
        jp1VarI.getClass();
        ny2.c(ny2Var, ty2VarN, jp1VarI.a, false, this.b, xy.d0, true);
        ny2Var.t(false);
    }

    @Override // defpackage.wx2
    public final void onCancel() {
    }

    @Override // defpackage.wx2
    public final void b(long j, lf2 lf2Var) {
    }
}
