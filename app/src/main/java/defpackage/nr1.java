package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nr1 extends zr1 {
    public static final nr1 c = new nr1(0, 1, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        a42 a42Var = (a42) izVar.e(0);
        Set set = (Set) i52Var.a;
        if (set == null) {
            return;
        }
        lv1 lv1Var = new lv1(set);
        gm1 gm1Var = (gm1) i52Var.j;
        if (gm1Var == null) {
            long[] jArr = ya2.a;
            gm1Var = new gm1();
            i52Var.j = gm1Var;
        }
        gm1Var.m(a42Var, lv1Var);
        ((pm1) i52Var.d).b(new k52(lv1Var, -1));
    }
}
