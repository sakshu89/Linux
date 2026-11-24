package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class l23 {
    public static final /* synthetic */ int a = 0;

    static {
        yp4.a(new tv1(17));
    }

    public static final f23 a(j23 j23Var, g33 g33Var, String str, x20 x20Var) {
        e23 e23Var;
        boolean zF = x20Var.f(j23Var);
        Object objL = x20Var.L();
        Object obj = r20.a;
        if (zF || objL == obj) {
            objL = new f23(j23Var, g33Var, str);
            x20Var.g0(objL);
        }
        f23 f23Var = (f23) objL;
        boolean zF2 = x20Var.f(j23Var) | x20Var.h(f23Var);
        Object objL2 = x20Var.L();
        if (zF2 || objL2 == obj) {
            objL2 = new o0(22, j23Var, f23Var);
            x20Var.g0(objL2);
        }
        bz3.a(f23Var, (hq0) objL2, x20Var);
        if (j23Var.g() && (e23Var = (e23) f23Var.b.getValue()) != null) {
            j23 j23Var2 = f23Var.c;
            e23Var.a.f(e23Var.c.j(j23Var2.f().a), e23Var.c.j(j23Var2.f().b), (yl0) e23Var.b.j(j23Var2.f()));
        }
        return f23Var;
    }
}
