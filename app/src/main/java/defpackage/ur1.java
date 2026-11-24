package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ur1 extends zr1 {
    public static final ur1 c = new ur1(1, 0, 2);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        int iD = izVar.d(0);
        int i = rl2Var.v;
        int iN = rl2Var.N(rl2Var.r(i), rl2Var.b);
        int iG = rl2Var.g(rl2Var.r(i + 1), rl2Var.b);
        for (int iMax = Math.max(iN, iG - iD); iMax < iG; iMax++) {
            Object obj = rl2Var.c[rl2Var.h(iMax)];
            if (obj instanceof k52) {
                i52Var.e((k52) obj);
            } else if (obj instanceof a42) {
                ((a42) obj).c();
            }
        }
        if (iD <= 0) {
            y20.a("Check failed");
        }
        int i2 = rl2Var.v;
        int iN2 = rl2Var.N(rl2Var.r(i2), rl2Var.b);
        int iG2 = rl2Var.g(rl2Var.r(i2 + 1), rl2Var.b) - iD;
        if (iG2 < iN2) {
            y20.a("Check failed");
        }
        rl2Var.J(iG2, iD, i2);
        int i3 = rl2Var.i;
        if (i3 >= iN2) {
            rl2Var.i = i3 - iD;
        }
    }
}
