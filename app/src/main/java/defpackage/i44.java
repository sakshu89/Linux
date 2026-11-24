package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i44 {
    public static bm2 a() {
        return (bm2) im2.b.l();
    }

    public static bm2 b(bm2 bm2Var) {
        if (bm2Var instanceof n23) {
            n23 n23Var = (n23) bm2Var;
            if (n23Var.t == tc4.a()) {
                n23Var.r = null;
                return bm2Var;
            }
        }
        if (bm2Var instanceof o23) {
            o23 o23Var = (o23) bm2Var;
            if (o23Var.i == tc4.a()) {
                o23Var.h = null;
                return bm2Var;
            }
        }
        bm2 bm2VarG = im2.g(bm2Var, null, false);
        bm2VarG.j();
        return bm2VarG;
    }

    public static Object c(h2 h2Var, fq0 fq0Var) {
        bm2 n23Var;
        bm2 bm2Var = (bm2) im2.b.l();
        if (bm2Var instanceof n23) {
            n23 n23Var2 = (n23) bm2Var;
            if (n23Var2.t == tc4.a()) {
                hq0 hq0Var = n23Var2.r;
                hq0 hq0Var2 = n23Var2.s;
                try {
                    ((n23) bm2Var).r = im2.k(h2Var, hq0Var, true);
                    ((n23) bm2Var).s = hq0Var2;
                    return fq0Var.a();
                } finally {
                    n23Var2.r = hq0Var;
                    n23Var2.s = hq0Var2;
                }
            }
        }
        if (bm2Var == null || (bm2Var instanceof lm1)) {
            n23Var = new n23(bm2Var instanceof lm1 ? (lm1) bm2Var : null, h2Var, null, true, false);
        } else {
            n23Var = bm2Var.u(h2Var);
        }
        try {
            bm2 bm2VarJ = n23Var.j();
            try {
                Object objA = fq0Var.a();
                bm2.q(bm2VarJ);
                n23Var.c();
                return objA;
            } catch (Throwable th) {
                bm2.q(bm2VarJ);
                throw th;
            }
        } catch (Throwable th2) {
            n23Var.c();
            throw th2;
        }
    }

    public static final md2 d(x20 x20Var) {
        Object[] objArr = new Object[0];
        boolean zD = x20Var.d(0);
        Object objL = x20Var.L();
        if (zD || objL == r20.a) {
            objL = new tv1(7);
            x20Var.g0(objL);
        }
        return (md2) yy3.d(objArr, md2.j, (fq0) objL, x20Var, 0);
    }

    public static void e(bm2 bm2Var, bm2 bm2Var2, hq0 hq0Var) {
        if (bm2Var != bm2Var2) {
            bm2Var2.getClass();
            bm2.q(bm2Var);
            bm2Var2.c();
        } else if (bm2Var instanceof n23) {
            ((n23) bm2Var).r = hq0Var;
        } else if (bm2Var instanceof o23) {
            ((o23) bm2Var).h = hq0Var;
        } else {
            og.h(bm2Var, "Non-transparent snapshot was reused: ");
        }
    }

    public static ek1 f(ek1 ek1Var, md2 md2Var) {
        return ek1Var.c(vh4.a(bk1.a, vw0.c)).c(new nd2(null, null, md2Var.d, js1.a, md2Var, true, true)).c(new ce2(md2Var));
    }
}
