package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vq1 extends zr1 {
    public static final vq1 c = new vq1(0, 2, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) throws IllegalAccessException, InvocationTargetException {
        j21 j21Var = (j21) izVar.e(1);
        int i = j21Var != null ? j21Var.a : 0;
        yw ywVar = (yw) izVar.e(0);
        if (i > 0) {
            xfVar = new gy0(xfVar, i);
        }
        ywVar.a(xfVar, rl2Var, i52Var, as1Var != null ? new q91(17, as1Var, rl2Var) : null);
    }
}
