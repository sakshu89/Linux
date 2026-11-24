package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rt1 extends dk1 implements f71 {
    public qt1 x;

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        qt1 qt1Var = this.x;
        z61 layoutDirection = qh1Var.getLayoutDirection();
        z61 z61Var = z61.a;
        float f = layoutDirection == z61Var ? qt1Var.a : qt1Var.c;
        qt1 qt1Var2 = this.x;
        float f2 = qt1Var2.b;
        float f3 = qh1Var.getLayoutDirection() == z61Var ? qt1Var2.c : qt1Var2.a;
        float f4 = this.x.d;
        if (!((de0.a(f, 0.0f) >= 0) & (de0.a(f2, 0.0f) >= 0) & (de0.a(f3, 0.0f) >= 0) & (de0.a(f4, 0.0f) >= 0))) {
            x01.a("Padding must be non-negative");
        }
        int iR = qh1Var.R(f);
        int iR2 = qh1Var.R(f3) + iR;
        int iR3 = qh1Var.R(f2);
        int iR4 = qh1Var.R(f4) + iR3;
        zw1 zw1VarE = jh1Var.e(r40.i(-iR2, -iR4, j));
        return qh1Var.j0(r40.g(zw1VarE.a + iR2, j), r40.f(zw1VarE.b + iR4, j), ji0.a, new u11(zw1VarE, iR, iR3, 2));
    }
}
