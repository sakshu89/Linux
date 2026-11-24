package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class y34 {
    public static final vw0 a = new vw0(2);

    public static final void a(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        x20Var.X(-1854833411);
        int i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            Object objL = x20Var.L();
            if (objL == r20.a) {
                objL = eb.f;
                x20Var.g0(objL);
            }
            oh1 oh1Var = (oh1) objL;
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1Var);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1Var);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            w10Var.e(x20Var, 6);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 13, ek1Var, w10Var);
        }
    }
}
