package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fp4 {
    /* JADX WARN: Multi-variable type inference failed */
    public static x50 a(x50 x50Var, x50 x50Var2, vq0 vq0Var) {
        vq0Var.getClass();
        if (vq0Var instanceof pk) {
            return ((pk) vq0Var).q(x50Var2, x50Var);
        }
        j70 j70VarF = x50Var2.f();
        return j70VarF == gi0.a ? new h31(x50Var2, x50Var, vq0Var) : new i31(x50Var2, j70VarF, vq0Var, x50Var);
    }

    public static x50 b(x50 x50Var) {
        x50Var.getClass();
        y50 y50Var = x50Var instanceof y50 ? (y50) x50Var : null;
        if (y50Var == null || (x50Var = y50Var.c) != null) {
            return x50Var;
        }
        l70 l70Var = (l70) y50Var.f().v(qs4.c);
        x50 hd0Var = l70Var != null ? new hd0(l70Var, y50Var) : y50Var;
        y50Var.c = hd0Var;
        return hd0Var;
    }

    public static Object c(vq0 vq0Var, Object obj, x50 x50Var) {
        vq0Var.getClass();
        j70 j70VarF = x50Var.f();
        Object j31Var = j70VarF == gi0.a ? new j31(x50Var) : new k31(x50Var, j70VarF);
        h33.c(2, vq0Var);
        return vq0Var.e(obj, j31Var);
    }
}
