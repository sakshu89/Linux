package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bq4 {
    public static final void a(fq0 fq0Var, ek1 ek1Var, f91 f91Var, w91 w91Var, x20 x20Var, int i) {
        w91 w91Var2;
        f91 f91Var2;
        ek1 ek1Var2;
        x20Var.X(1055276397);
        int i2 = (x20Var.h(fq0Var) ? 4 : 2) | i | (x20Var.f(ek1Var) ? 32 : 16) | (x20Var.f(f91Var) ? 256 : 128) | (x20Var.f(w91Var) ? 2048 : 1024);
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            w91Var2 = w91Var;
            x81 x81Var = new x81(f91Var, ek1Var, w91Var2, o44.h(fq0Var, x20Var), 0);
            f91Var2 = f91Var;
            ek1Var2 = ek1Var;
            gq4.a(yi4.b(-933153643, x81Var, x20Var), x20Var, 6);
        } else {
            w91Var2 = w91Var;
            f91Var2 = f91Var;
            ek1Var2 = ek1Var;
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new xk(fq0Var, ek1Var2, f91Var2, w91Var2, i);
        }
    }
}
