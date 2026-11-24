package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class do1 {
    public static final ul1 a;

    static {
        ul1 ul1Var = xo1.a;
        a = new ul1();
    }

    public static final void a(dk1 dk1Var, int i, int i2) {
        if (!(dk1Var instanceof zb0)) {
            b(dk1Var, i & dk1Var.c, i2);
            return;
        }
        zb0 zb0Var = (zb0) dk1Var;
        int i3 = zb0Var.x;
        b(dk1Var, i3 & i, i2);
        int i4 = (~i3) & i;
        for (dk1 dk1Var2 = zb0Var.H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
            a(dk1Var2, i4, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(dk1 dk1Var, int i, int i2) {
        if (i2 != 0 || dk1Var.x0()) {
            if ((i & 2) != 0 && (dk1Var instanceof f71)) {
                up4.a((f71) dk1Var);
                if (i2 == 2) {
                    cm4.e(dk1Var, 2).h1();
                }
            }
            if ((i & 128) != 0 && i2 != 2) {
                cm4.g(dk1Var).E();
            }
            if ((4194304 & i) != 0 && i2 != 2) {
                cm4.g(dk1Var).U(false);
            }
            if ((i & 256) != 0 && (dk1Var instanceof du0)) {
                if (i2 == 1) {
                    n71 n71VarG = cm4.g(dk1Var);
                    n71VarG.a0(n71VarG.w0 + 1);
                } else if (i2 == 2) {
                    n71 n71VarG2 = cm4.g(dk1Var);
                    n71VarG2.a0(n71VarG2.w0 - 1);
                }
                if (i2 != 2) {
                    n71 n71VarG3 = cm4.g(dk1Var);
                    if (n71VarG3.w0 != 0 && !n71VarG3.p() && !n71VarG3.q() && !n71VarG3.v0) {
                        r7 r7Var = (r7) q71.a(n71VarG3);
                        q91 q91Var = r7Var.F0.e;
                        q91Var.getClass();
                        if (n71VarG3.w0 > 0) {
                            ((pm1) q91Var.b).b(n71VarG3);
                            n71VarG3.v0 = true;
                        }
                        r7Var.A(null);
                    }
                }
            }
            if ((i & 4) != 0 && (dk1Var instanceof qf0)) {
                vm4.a((qf0) dk1Var);
            }
            if ((i & 8) != 0 && (dk1Var instanceof eg2)) {
                cm4.g(dk1Var).Y = true;
            }
            if ((i & 64) != 0 && (dk1Var instanceof lu1)) {
                r71 r71Var = cm4.g((lu1) dk1Var).p0;
                r71Var.p.H = true;
                sf1 sf1Var = r71Var.q;
                if (sf1Var != null) {
                    sf1Var.e0 = true;
                }
            }
            if ((i & 2048) != 0 && (dk1Var instanceof ok)) {
                ck1 ck1Var = ((ok) dk1Var).x;
                z01.b("applyFocusProperties called on wrong node");
                ck1Var.getClass();
                dk0.t();
                return;
            }
            if ((i & 4096) == 0 || !(dk1Var instanceof rn0)) {
                return;
            }
            rn0 rn0Var = (rn0) dk1Var;
            vn0 vn0Var = ((do0) ((r7) cm4.h(rn0Var)).getFocusOwner()).d;
            if (vn0Var.d.a(rn0Var)) {
                vn0Var.a();
            }
        }
    }

    public static final void c(dk1 dk1Var) {
        if (!dk1Var.w) {
            z01.b("autoInvalidateUpdatedNode called on unattached node");
        }
        a(dk1Var, -1, 0);
    }

    public static final int d(ck1 ck1Var) {
        int i = ck1Var instanceof d71 ? 3 : 1;
        if (ck1Var instanceof pf0) {
            i |= 4;
        }
        if (ck1Var instanceof uf) {
            i |= 8;
        }
        return ck1Var instanceof sm ? 524288 | i : i;
    }

    public static final int e(dk1 dk1Var) {
        int i = dk1Var.c;
        if (i != 0) {
            return i;
        }
        Class<?> cls = dk1Var.getClass();
        ul1 ul1Var = a;
        int iD = ul1Var.d(cls);
        if (iD >= 0) {
            return ul1Var.c[iD];
        }
        int i2 = dk1Var instanceof f71 ? 3 : 1;
        if (dk1Var instanceof qf0) {
            i2 |= 4;
        }
        if (dk1Var instanceof eg2) {
            i2 |= 8;
        }
        if (dk1Var instanceof qy1) {
            i2 |= 16;
        }
        if (dk1Var instanceof gk1) {
            i2 |= 32;
        }
        if (dk1Var instanceof lu1) {
            i2 |= 64;
        }
        if (dk1Var instanceof jq1) {
            i2 |= 128;
        } else if (dk1Var instanceof w61) {
            i2 |= 4194432;
        }
        if (dk1Var instanceof du0) {
            i2 |= 256;
        }
        if (dk1Var instanceof ko0) {
            i2 |= 1024;
        }
        if (dk1Var instanceof ok) {
            i2 |= 2048;
        }
        if (dk1Var instanceof rn0) {
            i2 |= 4096;
        }
        if (dk1Var instanceof k51) {
            i2 |= 8192;
        }
        if (dk1Var instanceof e7) {
            i2 |= 16384;
        }
        if (dk1Var instanceof h30) {
            i2 |= 32768;
        }
        if (dk1Var instanceof t23) {
            i2 |= ArabicShaping.TASHKEEL_BEGIN;
        }
        if (dk1Var instanceof sm) {
            i2 |= ArabicShaping.TASHKEEL_RESIZE;
        }
        if (dk1Var instanceof n01) {
            i2 |= ArabicShaping.SEEN_TWOCELL_NEAR;
        }
        if (dk1Var instanceof p81) {
            i2 |= 8388608;
        }
        ul1Var.g(i2, cls);
        return i2;
    }

    public static final int f(dk1 dk1Var) {
        if (!(dk1Var instanceof zb0)) {
            return e(dk1Var);
        }
        zb0 zb0Var = (zb0) dk1Var;
        int iF = zb0Var.x;
        for (dk1 dk1Var2 = zb0Var.H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
            iF |= f(dk1Var2);
        }
        return iF;
    }

    public static final boolean g(int i) {
        return ((i & 128) != 0) | ((i & 4194304) != 0);
    }
}
