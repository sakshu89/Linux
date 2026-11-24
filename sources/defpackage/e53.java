package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e53 extends dk1 implements f71 {
    public float H;
    public float x;

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        int iE0 = jh1Var.e0(i);
        int iR = !Float.isNaN(this.H) ? mf1Var.R(this.H) : 0;
        return iE0 < iR ? iR : iE0;
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        int iV = jh1Var.V(i);
        int iR = !Float.isNaN(this.x) ? mf1Var.R(this.x) : 0;
        return iV < iR ? iR : iV;
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        int iJ;
        int i;
        if (Float.isNaN(this.x) || q40.j(j) != 0) {
            iJ = q40.j(j);
        } else {
            int iR = qh1Var.R(this.x);
            iJ = q40.h(j);
            if (iR < 0) {
                iR = 0;
            }
            if (iR <= iJ) {
                iJ = iR;
            }
        }
        int iH = q40.h(j);
        if (Float.isNaN(this.H) || q40.i(j) != 0) {
            i = q40.i(j);
        } else {
            int iR2 = qh1Var.R(this.H);
            i = q40.g(j);
            int i2 = iR2 >= 0 ? iR2 : 0;
            if (i2 <= i) {
                i = i2;
            }
        }
        zw1 zw1VarE = jh1Var.e(r40.a(iJ, iH, i, q40.g(j)));
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 6));
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        int iC0 = jh1Var.c0(i);
        int iR = !Float.isNaN(this.x) ? mf1Var.R(this.x) : 0;
        return iC0 < iR ? iR : iC0;
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        int iF = jh1Var.f(i);
        int iR = !Float.isNaN(this.H) ? mf1Var.R(this.H) : 0;
        return iF < iR ? iR : iF;
    }
}
