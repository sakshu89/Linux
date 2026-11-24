package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cm4 {
    public static final void a(pm1 pm1Var, dk1 dk1Var) {
        pm1 pm1VarZ = g(dk1Var).z();
        int i = pm1VarZ.c - 1;
        Object[] objArr = pm1VarZ.a;
        if (i < objArr.length) {
            while (i >= 0) {
                pm1Var.b(((n71) objArr[i]).o0.f);
                i--;
            }
        }
    }

    public static final dk1 b(pm1 pm1Var) {
        int i;
        if (pm1Var == null || (i = pm1Var.c) == 0) {
            return null;
        }
        return (dk1) pm1Var.l(i - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final f71 c(dk1 dk1Var) {
        if ((dk1Var.c & 2) != 0) {
            if (dk1Var instanceof f71) {
                return (f71) dk1Var;
            }
            if (dk1Var instanceof zb0) {
                dk1 dk1Var2 = ((zb0) dk1Var).H;
                while (dk1Var2 != 0) {
                    if (dk1Var2 instanceof f71) {
                        return (f71) dk1Var2;
                    }
                    dk1Var2 = (!(dk1Var2 instanceof zb0) || (dk1Var2.c & 2) == 0) ? dk1Var2.i : ((zb0) dk1Var2).H;
                }
            }
        }
        return null;
    }

    public static final void d(xb0 xb0Var) {
        s6 s6Var;
        n71 n71VarG = g(xb0Var);
        if (n71VarG.c0 || (s6Var = ((r7) q71.a(n71VarG)).w0) == null) {
            return;
        }
        s6Var.e.a.h(n71VarG.b, new r6(s6Var, n71VarG));
    }

    public static final co1 e(xb0 xb0Var, int i) {
        co1 co1Var = ((dk1) xb0Var).a.k;
        co1Var.getClass();
        if (co1Var.V0() != xb0Var || !do1.g(i)) {
            return co1Var;
        }
        co1 co1Var2 = co1Var.H;
        co1Var2.getClass();
        return co1Var2;
    }

    public static final co1 f(xb0 xb0Var) {
        if (!((dk1) xb0Var).a.w) {
            z01.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        co1 co1VarE = e(xb0Var, 2);
        if (!co1VarE.V0().w) {
            z01.b("LayoutCoordinates is not attached.");
        }
        return co1VarE;
    }

    public static final n71 g(xb0 xb0Var) {
        co1 co1Var = ((dk1) xb0Var).a.k;
        if (co1Var != null) {
            return co1Var.x;
        }
        throw cq.e("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final it1 h(xb0 xb0Var) {
        it1 it1Var = g(xb0Var).x;
        if (it1Var != null) {
            return it1Var;
        }
        throw cq.e("This node does not have an owner.");
    }
}
