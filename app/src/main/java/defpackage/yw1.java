package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yw1 implements jc0 {
    public boolean a;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(yw1 yw1Var, zw1 zw1Var) {
        yw1Var.getClass();
        if (zw1Var instanceof sk1) {
            ((sk1) zw1Var).o(yw1Var.a);
        }
    }

    public static void h(yw1 yw1Var, zw1 zw1Var, int i, int i2) {
        yw1Var.getClass();
        a(yw1Var, zw1Var);
        zw1Var.n0(e21.c((((long) i2) & 4294967295L) | (((long) i) << 32), zw1Var.f), 0.0f, null);
    }

    public static void i(yw1 yw1Var, zw1 zw1Var, long j) {
        yw1Var.getClass();
        a(yw1Var, zw1Var);
        zw1Var.n0(e21.c(j, zw1Var.f), 0.0f, null);
    }

    public static void k(yw1 yw1Var, zw1 zw1Var, int i, int i2) {
        long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
        if (yw1Var.e() == z61.a || yw1Var.f() == 0) {
            a(yw1Var, zw1Var);
            zw1Var.n0(e21.c(j, zw1Var.f), 0.0f, null);
        } else {
            int iF = (yw1Var.f() - zw1Var.a) - ((int) (j >> 32));
            a(yw1Var, zw1Var);
            zw1Var.n0(e21.c((((long) iF) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), zw1Var.f), 0.0f, null);
        }
    }

    public static void m(yw1 yw1Var, zw1 zw1Var, int i, int i2) {
        int i3 = ax1.b;
        kt1 kt1Var = kt1.n;
        long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
        if (yw1Var.e() == z61.a || yw1Var.f() == 0) {
            a(yw1Var, zw1Var);
            zw1Var.n0(e21.c(j, zw1Var.f), 0.0f, kt1Var);
        } else {
            int iF = (yw1Var.f() - zw1Var.a) - ((int) (j >> 32));
            a(yw1Var, zw1Var);
            zw1Var.n0(e21.c((((long) iF) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), zw1Var.f), 0.0f, kt1Var);
        }
    }

    public static void n(yw1 yw1Var, zw1 zw1Var, hq0 hq0Var) {
        yw1Var.getClass();
        a(yw1Var, zw1Var);
        zw1Var.n0(e21.c(0L, zw1Var.f), 0.0f, hq0Var);
    }

    public float d(tw0 tw0Var) {
        return Float.NaN;
    }

    public abstract z61 e();

    public abstract int f();
}
