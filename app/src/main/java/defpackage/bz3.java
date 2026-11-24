package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bz3 {
    public static final qd0 a = new qd0();

    public static final void a(Object obj, hq0 hq0Var, x20 x20Var) {
        boolean zF = x20Var.f(obj);
        Object objL = x20Var.L();
        if (zF || objL == r20.a) {
            objL = new od0(hq0Var);
            x20Var.g0(objL);
        }
    }

    public static final void b(Object obj, Object obj2, hq0 hq0Var, x20 x20Var) {
        boolean zF = x20Var.f(obj) | x20Var.f(obj2);
        Object objL = x20Var.L();
        if (zF || objL == r20.a) {
            objL = new od0(hq0Var);
            x20Var.g0(objL);
        }
    }

    public static final void c(x20 x20Var, vq0 vq0Var, Object obj) {
        j70 j70Var = x20Var.R;
        boolean zF = x20Var.f(obj);
        Object objL = x20Var.L();
        if (zF || objL == r20.a) {
            objL = new u61(j70Var, vq0Var);
            x20Var.g0(objL);
        }
    }

    public static final void d(fq0 fq0Var, x20 x20Var) {
        bs1 bs1Var = x20Var.M.b.a;
        bs1Var.e(rr1.c);
        yr4.a(bs1Var, 0, fq0Var);
    }

    public static final s70 e(x20 x20Var) {
        return new n52(x20Var.R);
    }

    public static final h72 f(Throwable th) {
        th.getClass();
        return new h72(th);
    }

    public static final void g(Object obj) {
        if (obj instanceof h72) {
            throw ((h72) obj).a;
        }
    }
}
