package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tl4 {
    public static final w50 a(j70 j70Var) {
        if (j70Var.v(nr4.k) == null) {
            j70Var = j70Var.r(new h41(null));
        }
        return new w50(j70Var);
    }

    public static final void b(s70 s70Var, hk1 hk1Var) {
        f41 f41Var = (f41) s70Var.o().v(nr4.k);
        if (f41Var != null) {
            f41Var.e(hk1Var);
        } else {
            og.h(s70Var, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final Object c(vq0 vq0Var, x50 x50Var) {
        hb2 hb2Var = new hb2(x50Var, x50Var.f());
        return ee4.b(hb2Var, true, hb2Var, vq0Var);
    }

    public static final boolean d(s70 s70Var) {
        f41 f41Var = (f41) s70Var.o().v(nr4.k);
        if (f41Var != null) {
            return f41Var.c();
        }
        return true;
    }
}
