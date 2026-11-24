package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i24 {
    public static final void a(gg2 gg2Var, int i, fg1 fg1Var) {
        pm1 pm1Var = new pm1(new gg2[16]);
        List listI = gg2Var.i(false, false);
        while (true) {
            pm1Var.e(pm1Var.c, listI);
            while (true) {
                int i2 = pm1Var.c;
                if (i2 == 0) {
                    return;
                }
                gg2 gg2Var2 = (gg2) pm1Var.l(i2 - 1);
                boolean zE = o44.e(gg2Var2);
                cg2 cg2Var = gg2Var2.d;
                gm1 gm1Var = cg2Var.a;
                if (!zE && !gm1Var.c(kg2.i)) {
                    co1 co1VarD = gg2Var2.d();
                    if (co1VarD == null) {
                        throw cq.e("Expected semantics node to have a coordinator.");
                    }
                    i21 i21VarA = bp4.a(pp4.b(co1VarD, true));
                    if (i21VarA.a < i21VarA.c && i21VarA.b < i21VarA.d) {
                        Object objG = cg2Var.a.g(bg2.e);
                        if (objG == null) {
                            objG = null;
                        }
                        vq0 vq0Var = (vq0) objG;
                        Object objG2 = gm1Var.g(kg2.v);
                        ed2 ed2Var = (ed2) (objG2 != null ? objG2 : null);
                        if (vq0Var == null || ed2Var == null || ((Number) ed2Var.b.a()).floatValue() <= 0.0f) {
                            listI = gg2Var2.i(false, false);
                        } else {
                            int i3 = 1 + i;
                            fg1Var.j(new fd2(gg2Var2, i3, i21VarA, co1VarD));
                            a(gg2Var2, i3, fg1Var);
                        }
                    }
                }
            }
        }
    }
}
