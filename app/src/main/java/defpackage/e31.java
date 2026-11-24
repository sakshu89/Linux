package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e31 extends dk1 implements f71 {
    public boolean H;
    public b31 x;

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.e0(i);
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        return this.x == b31.a ? jh1Var.V(i) : jh1Var.c0(i);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iV = this.x == b31.a ? jh1Var.V(q40.g(j)) : jh1Var.c0(q40.g(j));
        if (iV < 0) {
            iV = 0;
        }
        if (iV < 0) {
            b11.a("width must be >= 0");
        }
        long jH = r40.h(iV, iV, 0, Integer.MAX_VALUE);
        if (this.H) {
            jH = r40.e(j, jH);
        }
        zw1 zw1VarE = jh1Var.e(jH);
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 1));
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        return this.x == b31.a ? jh1Var.V(i) : jh1Var.c0(i);
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.f(i);
    }
}
