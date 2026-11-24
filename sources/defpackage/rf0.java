package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface rf0 extends jc0 {
    static /* synthetic */ void E(rf0 rf0Var, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = v0(rf0Var.c(), 0L);
        }
        rf0Var.M(j, 0L, j2, ql0.a, (i & 64) != 0 ? 3 : 0);
    }

    static void K(p71 p71Var, hn hnVar, long j, long j2, long j3, wm4 wm4Var, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j4 = j;
        p71Var.e(hnVar, j4, (i & 4) != 0 ? v0(p71Var.a.c(), j4) : j2, j3, 1.0f, (i & 32) != 0 ? ql0.a : wm4Var);
    }

    static /* synthetic */ void P(rf0 rf0Var, long j, float f, long j2, float f2, int i) {
        if ((i & 4) != 0) {
            j2 = rf0Var.X();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            f2 = 1.0f;
        }
        rf0Var.L(j, f, j3, f2);
    }

    static void T(rf0 rf0Var, p9 p9Var, long j, long j2, float f, nl nlVar, int i, int i2) {
        rf0Var.Q(p9Var, 0L, j, (i2 & 16) != 0 ? j : j2, (i2 & 32) != 0 ? 1.0f : f, nlVar, (i2 & 512) != 0 ? 1 : i);
    }

    static /* synthetic */ void W(rf0 rf0Var, hn hnVar, long j, long j2, float f, wm4 wm4Var, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = v0(rf0Var.c(), j3);
        }
        rf0Var.z(hnVar, j3, j2, (i & 8) != 0 ? 1.0f : f, (i & 16) != 0 ? ql0.a : wm4Var);
    }

    static /* synthetic */ void Z(rf0 rf0Var, o22 o22Var, float f, long j, float f2, int i) {
        if ((i & 8) != 0) {
            f2 = 1.0f;
        }
        rf0Var.G(o22Var, f, j, f2);
    }

    static /* synthetic */ void g0(rf0 rf0Var, na naVar, long j, float f, ks2 ks2Var, int i) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        wm4 wm4Var = ks2Var;
        if ((i & 8) != 0) {
            wm4Var = ql0.a;
        }
        rf0Var.m0(naVar, j, f2, wm4Var);
    }

    static /* synthetic */ void t(rf0 rf0Var, na naVar, hn hnVar, float f, ks2 ks2Var, int i) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        wm4 wm4Var = ks2Var;
        if ((i & 8) != 0) {
            wm4Var = ql0.a;
        }
        rf0Var.g(naVar, hnVar, f2, wm4Var, (i & 32) != 0 ? 3 : 0);
    }

    static long v0(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    kf C();

    void G(hn hnVar, float f, long j, float f2);

    void L(long j, float f, long j2, float f2);

    void M(long j, long j2, long j3, wm4 wm4Var, int i);

    void Q(p9 p9Var, long j, long j2, long j3, float f, nl nlVar, int i);

    default long X() {
        return a44.a(C().r());
    }

    default long c() {
        return C().r();
    }

    void f0(long j, long j2, long j3, float f);

    void g(na naVar, hn hnVar, float f, wm4 wm4Var, int i);

    z61 getLayoutDirection();

    void j(long j, float f, float f2, long j2, long j3, ks2 ks2Var);

    void m0(na naVar, long j, float f, wm4 wm4Var);

    void p0(long j, long j2, long j3, float f, wm4 wm4Var);

    void z(hn hnVar, long j, long j2, float f, wm4 wm4Var);
}
