package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pl4 {
    public static h70 a(h70 h70Var, i70 i70Var) {
        i70Var.getClass();
        if (g31.a(h70Var.getKey(), i70Var)) {
            return h70Var;
        }
        return null;
    }

    public static j70 b(h70 h70Var, i70 i70Var) {
        i70Var.getClass();
        return g31.a(h70Var.getKey(), i70Var) ? gi0.a : h70Var;
    }

    public static j70 c(h70 h70Var, j70 j70Var) {
        j70Var.getClass();
        return j70Var == gi0.a ? h70Var : (j70) j70Var.y(new ag(2), h70Var);
    }
}
