package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gq4 {
    public static final void a(w10 w10Var, x20 x20Var, int i) {
        x20Var.X(-709502251);
        if (x20Var.O(i & 1, (i & 3) != 2)) {
            z12 z12Var = da2.a;
            Object obj = (ba2) x20Var.j(z12Var);
            x20Var.W(1967007413);
            Object[] objArr = new Object[0];
            Object objL = x20Var.L();
            Object obj2 = r20.a;
            if (objL == obj2) {
                objL = new tv1(5);
                x20Var.g0(objL);
            }
            aa2 aa2Var = (aa2) yy3.d(objArr, aa2.f, (fq0) objL, x20Var, CollationFastLatin.LATIN_LIMIT);
            aa2Var.c = (ba2) x20Var.j(z12Var);
            x20Var.p(false);
            Object[] objArr2 = {obj};
            q91 q91Var = new q91(26, new ag(8), new o0(12, obj, aa2Var));
            boolean zH = x20Var.h(obj) | x20Var.h(aa2Var);
            Object objL2 = x20Var.L();
            if (zH || objL2 == obj2) {
                objL2 = new zb(9, obj, aa2Var);
                x20Var.g0(objL2);
            }
            Object obj3 = (ha1) yy3.d(objArr2, q91Var, (fq0) objL2, x20Var, 0);
            kj4.a(z12Var.a(obj3), yi4.b(-412824043, new km(8, w10Var, obj3), x20Var), x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gn0(w10Var, i, 1);
        }
    }
}
