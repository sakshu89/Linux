package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ry3 {
    public static final py0 a;
    public static final py0 b;

    static {
        int i = 16;
        a = new py0(i, "UNDEFINED");
        b = new py0(i, "REUSABLE_CLAIMED");
    }

    public static final l42 a(long j, long j2) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new l42(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i2));
    }

    public static final void b(x50 x50Var, Object obj) {
        if (!(x50Var instanceof hd0)) {
            x50Var.h(obj);
            return;
        }
        hd0 hd0Var = (hd0) x50Var;
        l70 l70Var = hd0Var.e;
        y50 y50Var = hd0Var.f;
        Throwable thA = i72.a(obj);
        Object a10Var = thA == null ? obj : new a10(thA, false);
        if (d(l70Var, y50Var.f())) {
            hd0Var.i = a10Var;
            hd0Var.c = 1;
            c(l70Var, y50Var.f(), hd0Var);
            return;
        }
        jj0 jj0VarA = i03.a();
        if (jj0VarA.c >= 4294967296L) {
            hd0Var.i = a10Var;
            hd0Var.c = 1;
            jj0VarA.Q(hd0Var);
            return;
        }
        jj0VarA.R(true);
        try {
            f41 f41Var = (f41) y50Var.f().v(nr4.k);
            if (f41Var == null || f41Var.c()) {
                Object obj2 = hd0Var.j;
                j70 j70VarF = y50Var.f();
                Object objE = ab4.e(j70VarF, obj2);
                l43 l43VarC = objE != ab4.a ? ql4.c(y50Var, j70VarF, objE) : null;
                try {
                    y50Var.h(obj);
                    if (l43VarC == null || l43VarC.w0()) {
                        ab4.a(j70VarF, objE);
                    }
                } catch (Throwable th) {
                    if (l43VarC == null || l43VarC.w0()) {
                        ab4.a(j70VarF, objE);
                    }
                    throw th;
                }
            } else {
                hd0Var.h(bz3.f(f41Var.x()));
            }
            while (jj0VarA.T()) {
            }
        } catch (Throwable th2) {
            try {
                hd0Var.j(th2);
            } finally {
                jj0VarA.P(true);
            }
        }
    }

    public static final void c(l70 l70Var, j70 j70Var, Runnable runnable) {
        try {
            l70Var.L(j70Var, runnable);
        } catch (Throwable th) {
            throw new gd0(th, l70Var, j70Var);
        }
    }

    public static final boolean d(l70 l70Var, j70 j70Var) throws gd0 {
        try {
            return l70Var.N(j70Var);
        } catch (Throwable th) {
            throw new gd0(th, l70Var, j70Var);
        }
    }
}
