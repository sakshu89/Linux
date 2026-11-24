package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class aj4 {
    public static final v20 a(x20 x20Var) {
        x20 x20Var2;
        x20Var.U(206, y20.e);
        if (x20Var.S) {
            rl2.z(x20Var.I);
        }
        Object objD = x20Var.D();
        k52 s72Var = objD instanceof k52 ? (k52) objD : null;
        if (s72Var == null) {
            x20Var2 = x20Var;
            s72Var = new s72(new u20(new v20(x20Var2, x20Var.T, x20Var.q, x20Var.C, x20Var.h.c0)), -1);
            x20Var2.h0(s72Var);
        } else {
            x20Var2 = x20Var;
        }
        j52 j52Var = s72Var.a;
        j52Var.getClass();
        v20 v20Var = ((u20) j52Var).a;
        v20Var.f.setValue(x20Var2.l());
        x20Var2.p(false);
        return v20Var;
    }
}
