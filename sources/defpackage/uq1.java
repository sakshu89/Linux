package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uq1 extends zr1 {
    public static final uq1 c = new uq1(0, 2, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        j6 j6Var = (j6) izVar.e(0);
        Object objE = izVar.e(1);
        if (objE instanceof k52) {
            k52 k52Var = (k52) objE;
            ((pm1) i52Var.d).b(k52Var);
            ((hm1) i52Var.g).a(k52Var);
        }
        if (rl2Var.n != 0) {
            y20.a("Can only append a slot if not current inserting");
        }
        int i = rl2Var.i;
        int i2 = rl2Var.j;
        int iC = rl2Var.c(j6Var);
        int iG = rl2Var.g(rl2Var.r(iC + 1), rl2Var.b);
        rl2Var.i = iG;
        rl2Var.j = iG;
        rl2Var.x(1, iC);
        if (i >= iG) {
            i++;
            i2++;
        }
        rl2Var.c[iG] = objE;
        rl2Var.i = i;
        rl2Var.j = i2;
    }
}
