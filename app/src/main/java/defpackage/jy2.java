package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jy2 implements wx2 {
    public final /* synthetic */ ny2 a;

    public jy2(ny2 ny2Var) {
        this.a = ny2Var;
    }

    @Override // defpackage.wx2
    public final void a() {
        ny2 ny2Var = this.a;
        ny2Var.r.setValue(null);
        ny2Var.s.setValue(null);
    }

    @Override // defpackage.wx2
    public final void b(long j, lf2 lf2Var) {
        hz2 hz2VarD;
        ny2 ny2Var = this.a;
        long jA = wf2.a(ny2Var.l(true));
        ua1 ua1Var = ny2Var.d;
        if (ua1Var == null || (hz2VarD = ua1Var.d()) == null) {
            return;
        }
        long jE = hz2VarD.e(jA);
        ny2Var.o = jE;
        ny2Var.s.setValue(new jp1(jE));
        ny2Var.q = 0L;
        ny2Var.r.setValue(pv0.a);
        ny2Var.t(false);
    }

    @Override // defpackage.wx2
    public final void c() {
        ny2 ny2Var = this.a;
        ny2Var.r.setValue(null);
        ny2Var.s.setValue(null);
    }

    @Override // defpackage.wx2
    public final void e(long j) {
        hz2 hz2VarD;
        bw0 bw0Var;
        ny2 ny2Var = this.a;
        ny2Var.q = jp1.e(ny2Var.q, j);
        ua1 ua1Var = ny2Var.d;
        if (ua1Var == null || (hz2VarD = ua1Var.d()) == null) {
            return;
        }
        ny2Var.s.setValue(new jp1(jp1.e(ny2Var.o, ny2Var.q)));
        mp1 mp1Var = ny2Var.b;
        jp1 jp1VarI = ny2Var.i();
        jp1VarI.getClass();
        int iK = mp1Var.k(hz2VarD.b(jp1VarI.a, true));
        long jA = hc4.a(iK, iK);
        if (oz2.b(jA, ny2Var.n().b)) {
            return;
        }
        ua1 ua1Var2 = ny2Var.d;
        if ((ua1Var2 == null || ((Boolean) ua1Var2.q.getValue()).booleanValue()) && (bw0Var = ny2Var.k) != null) {
            bw0Var.a();
        }
        ny2Var.c.j(ny2.e(ny2Var.n().a, jA));
        ny2Var.w = new oz2(jA);
    }

    @Override // defpackage.wx2
    public final void d() {
    }

    @Override // defpackage.wx2
    public final void onCancel() {
    }
}
