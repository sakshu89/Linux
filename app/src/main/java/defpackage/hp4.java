package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hp4 {
    public static final Object a(f41 f41Var, nu2 nu2Var) {
        f41Var.e(null);
        Object objH = f41Var.H(nu2Var);
        return objH == t70.a ? objH : q43.a;
    }

    public static final void b(j70 j70Var) {
        f41 f41Var = (f41) j70Var.v(nr4.k);
        if (f41Var != null && !f41Var.c()) {
            throw f41Var.x();
        }
    }

    public static final f41 c(j70 j70Var) {
        f41 f41Var = (f41) j70Var.v(nr4.k);
        if (f41Var != null) {
            return f41Var;
        }
        og.h(j70Var, "Current context doesn't contain Job in it: ");
        return null;
    }

    public static final rd0 d(f41 f41Var, boolean z, i41 i41Var) {
        if (f41Var instanceof p41) {
            return ((p41) f41Var).Y(z, i41Var);
        }
        return f41Var.K(i41Var.q(), z, new q0(1, i41Var, i41.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0, 1));
    }

    public static final boolean e(j70 j70Var) {
        f41 f41Var = (f41) j70Var.v(nr4.k);
        if (f41Var != null) {
            return f41Var.c();
        }
        return true;
    }
}
