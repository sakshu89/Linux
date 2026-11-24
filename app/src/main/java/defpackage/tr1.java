package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tr1 extends zr1 {
    public static final tr1 c = new tr1(0, 1, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        a42 a42Var = (a42) izVar.e(0);
        gm1 gm1Var = (gm1) i52Var.j;
        lv1 lv1Var = gm1Var != null ? (lv1) gm1Var.g(a42Var) : null;
        if (lv1Var != null) {
            ArrayList arrayList = (ArrayList) i52Var.k;
            if (arrayList == null) {
                arrayList = new ArrayList();
                i52Var.k = arrayList;
            }
            arrayList.add((pm1) i52Var.d);
            i52Var.d = lv1Var.b;
        }
    }
}
