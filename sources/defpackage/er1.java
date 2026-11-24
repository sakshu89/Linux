package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class er1 extends zr1 {
    public static final er1 c = new er1(0, 1, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        pm1 pm1Var;
        a42 a42Var = (a42) izVar.e(0);
        gm1 gm1Var = (gm1) i52Var.j;
        if (gm1Var == null || ((lv1) gm1Var.g(a42Var)) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) i52Var.k;
        if (arrayList != null && (pm1Var = (pm1) arrayList.remove(arrayList.size() - 1)) != null) {
            i52Var.d = pm1Var;
        }
        gm1Var.k(a42Var);
    }
}
