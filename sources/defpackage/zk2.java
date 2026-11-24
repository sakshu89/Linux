package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zk2 extends dk1 implements f71 {
    public float H;
    public float X;
    public float Y;
    public boolean Z;
    public float x;

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        long jI0 = I0(mf1Var);
        if (q40.e(jI0)) {
            return q40.g(jI0);
        }
        if (!this.Z) {
            i = r40.g(i, jI0);
        }
        return r40.f(jh1Var.e0(i), jI0);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    public final long I0(qh1 qh1Var) {
        int iR;
        int iR2;
        int iR3;
        int i = 0;
        if (Float.isNaN(this.X)) {
            iR = Integer.MAX_VALUE;
        } else {
            iR = qh1Var.R(this.X);
            if (iR < 0) {
                iR = 0;
            }
        }
        if (Float.isNaN(this.Y)) {
            iR2 = Integer.MAX_VALUE;
        } else {
            iR2 = qh1Var.R(this.Y);
            if (iR2 < 0) {
                iR2 = 0;
            }
        }
        if (Float.isNaN(this.x)) {
            iR3 = 0;
        } else {
            iR3 = qh1Var.R(this.x);
            if (iR3 < 0) {
                iR3 = 0;
            }
            if (iR3 > iR) {
                iR3 = iR;
            }
            if (iR3 == Integer.MAX_VALUE) {
                iR3 = 0;
            }
        }
        if (!Float.isNaN(this.H)) {
            int iR4 = qh1Var.R(this.H);
            if (iR4 < 0) {
                iR4 = 0;
            }
            if (iR4 > iR2) {
                iR4 = iR2;
            }
            if (iR4 != Integer.MAX_VALUE) {
                i = iR4;
            }
        }
        return r40.a(iR3, iR, i, iR2);
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        long jI0 = I0(mf1Var);
        if (q40.f(jI0)) {
            return q40.h(jI0);
        }
        if (!this.Z) {
            i = r40.f(i, jI0);
        }
        return r40.g(jh1Var.V(i), jI0);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iJ;
        int iH;
        int i;
        int iG;
        long jA;
        long jI0 = I0(qh1Var);
        if (this.Z) {
            jA = r40.e(j, jI0);
        } else {
            if (Float.isNaN(this.x)) {
                iJ = q40.j(j);
                int iH2 = q40.h(jI0);
                if (iJ > iH2) {
                    iJ = iH2;
                }
            } else {
                iJ = q40.j(jI0);
            }
            if (Float.isNaN(this.X)) {
                iH = q40.h(j);
                int iJ2 = q40.j(jI0);
                if (iH < iJ2) {
                    iH = iJ2;
                }
            } else {
                iH = q40.h(jI0);
            }
            if (Float.isNaN(this.H)) {
                i = q40.i(j);
                int iG2 = q40.g(jI0);
                if (i > iG2) {
                    i = iG2;
                }
            } else {
                i = q40.i(jI0);
            }
            if (Float.isNaN(this.Y)) {
                iG = q40.g(j);
                int i2 = q40.i(jI0);
                if (iG < i2) {
                    iG = i2;
                }
            } else {
                iG = q40.g(jI0);
            }
            jA = r40.a(iJ, iH, i, iG);
        }
        zw1 zw1VarE = jh1Var.e(jA);
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 3));
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        long jI0 = I0(mf1Var);
        if (q40.f(jI0)) {
            return q40.h(jI0);
        }
        if (!this.Z) {
            i = r40.f(i, jI0);
        }
        return r40.g(jh1Var.c0(i), jI0);
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        long jI0 = I0(mf1Var);
        if (q40.e(jI0)) {
            return q40.g(jI0);
        }
        if (!this.Z) {
            i = r40.g(i, jI0);
        }
        return r40.f(jh1Var.f(i), jI0);
    }
}
