package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class w44 {
    public static final rl0 a = new rl0(ed0.b, 1.0f);
    public static final rl0 b = new rl0(ed0.c, 1.0f);
    public static final /* synthetic */ int c = 0;

    public static final ek1 a(ek1 ek1Var, float f, float f2) {
        return ek1Var.c(new d53(f, f2));
    }

    public static final ek1 b(ek1 ek1Var, float f) {
        return ek1Var.c(f == 1.0f ? a : new rl0(ed0.b, f));
    }

    public static final ek1 c(ek1 ek1Var, float f) {
        return ek1Var.c(new yk2(f, f, 5));
    }

    public static final ek1 d(ek1 ek1Var, float f, float f2) {
        return ek1Var.c(new yk2(f, f2, 5));
    }

    public static /* synthetic */ ek1 e(ek1 ek1Var, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = Float.NaN;
        }
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return d(ek1Var, f, f2);
    }

    public static ek1 f(ek1 ek1Var, float f, float f2, float f3, float f4, int i) {
        return ek1Var.c(new yk2(f, (i & 2) != 0 ? Float.NaN : f2, (i & 4) != 0 ? Float.NaN : f3, (i & 8) != 0 ? Float.NaN : f4, false));
    }

    public static final ek1 g(ek1 ek1Var, float f) {
        return ek1Var.c(new yk2(f, f, f, f, true));
    }

    public static final ek1 h(ek1 ek1Var, float f, float f2) {
        return ek1Var.c(new yk2(f, f2, f, f2, true));
    }

    public static final ek1 i() {
        return new yk2(0.0f, 0.0f, 10);
    }
}
