package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class y44 {
    public static final Object a = new Object();

    public static final void a(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i2 + ')');
        }
    }

    public static final boolean b(mr2 mr2Var, int i, n1 n1Var, boolean z) {
        boolean z2;
        synchronized (a) {
            try {
                int i2 = mr2Var.d;
                if (i2 == i) {
                    mr2Var.c = n1Var;
                    z2 = true;
                    if (z) {
                        mr2Var.e++;
                    }
                    mr2Var.d = i2 + 1;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public static final mr2 c(um2 um2Var) {
        mr2 mr2Var = um2Var.a;
        mr2Var.getClass();
        return (mr2) im2.t(mr2Var, um2Var);
    }

    public static final int d(um2 um2Var) {
        mr2 mr2Var = um2Var.a;
        mr2Var.getClass();
        return ((mr2) im2.h(mr2Var)).e;
    }

    public static final boolean e(um2 um2Var, hq0 hq0Var) {
        int i;
        n1 n1Var;
        Object objJ;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (a) {
                mr2 mr2Var = um2Var.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            rw1 rw1VarG = n1Var.g();
            objJ = hq0Var.j(rw1VarG);
            n1 n1VarD = rw1VarG.d();
            if (g31.a(n1VarD, n1Var)) {
                break;
            }
            mr2 mr2Var3 = um2Var.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = b((mr2) im2.w(mr2Var3, um2Var, bm2VarJ), i, n1VarD, true);
            }
            im2.n(bm2VarJ, um2Var);
        } while (!zB);
        return ((Boolean) objJ).booleanValue();
    }
}
