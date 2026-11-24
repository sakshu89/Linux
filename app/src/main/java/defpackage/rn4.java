package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rn4 {
    public static mm0 a(mm0 mm0Var, int i) {
        nn nnVar;
        if (i < 0 && i != -2 && i != -1) {
            og.g(ky0.h(i, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was "));
            return null;
        }
        if (i == -1) {
            i = 0;
            nnVar = nn.b;
        } else {
            nnVar = nn.a;
        }
        boolean z = mm0Var instanceof hr0;
        gi0 gi0Var = gi0.a;
        return z ? ((hr0) mm0Var).b(gi0Var, i, nnVar) : new fx(mm0Var, gi0Var, i, nnVar);
    }

    public static final mm0 b(mm0 mm0Var) {
        return ((mm0Var instanceof hr2) || (mm0Var instanceof xd0)) ? mm0Var : new xd0(mm0Var);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(mm0 mm0Var, x50 x50Var) {
        bn0 bn0Var;
        t42 t42Var;
        i0 e;
        x9 x9Var;
        if (x50Var instanceof bn0) {
            bn0Var = (bn0) x50Var;
            int i = bn0Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                bn0Var.j = i - Integer.MIN_VALUE;
            } else {
                bn0Var = new bn0(x50Var);
            }
        } else {
            bn0Var = new bn0(x50Var);
        }
        Object obj = bn0Var.i;
        int i2 = bn0Var.j;
        py0 py0Var = s24.a;
        if (i2 == 0) {
            bz3.g(obj);
            t42Var = new t42();
            t42Var.a = py0Var;
            x9 x9Var2 = new x9(3, t42Var);
            try {
                bn0Var.e = t42Var;
                bn0Var.f = x9Var2;
                bn0Var.j = 1;
                Object objA = mm0Var.a(x9Var2, bn0Var);
                Object obj2 = t70.a;
                if (objA == obj2) {
                    return obj2;
                }
            } catch (i0 e2) {
                e = e2;
                x9Var = x9Var2;
                if (e.a == x9Var) {
                    throw e;
                }
                j70 j70Var = bn0Var.b;
                j70Var.getClass();
                hp4.b(j70Var);
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            x9Var = bn0Var.f;
            t42Var = bn0Var.e;
            try {
                bz3.g(obj);
            } catch (i0 e3) {
                e = e3;
                if (e.a == x9Var) {
                    throw e;
                }
                j70 j70Var2 = bn0Var.b;
                j70Var2.getClass();
                hp4.b(j70Var2);
            }
        }
        Object obj3 = t42Var.a;
        if (obj3 != py0Var) {
            return obj3;
        }
        kf2.g("Expected at least one element");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x006f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(mm0 mm0Var, vq0 vq0Var, y50 y50Var) {
        cn0 cn0Var;
        t42 t42Var;
        i0 e;
        wd0 wd0Var;
        if (y50Var instanceof cn0) {
            cn0Var = (cn0) y50Var;
            int i = cn0Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                cn0Var.j = i - Integer.MIN_VALUE;
            } else {
                cn0Var = new cn0(y50Var);
            }
        } else {
            cn0Var = new cn0(y50Var);
        }
        Object obj = cn0Var.i;
        int i2 = cn0Var.j;
        py0 py0Var = s24.a;
        if (i2 == 0) {
            bz3.g(obj);
            t42 t42Var2 = new t42();
            t42Var2.a = py0Var;
            wd0 wd0Var2 = new wd0(vq0Var, t42Var2);
            try {
                cn0Var.e = t42Var2;
                cn0Var.f = wd0Var2;
                cn0Var.j = 1;
                Object objA = mm0Var.a(wd0Var2, cn0Var);
                Object obj2 = t70.a;
                if (objA == obj2) {
                    return obj2;
                }
                t42Var = t42Var2;
            } catch (i0 e2) {
                t42Var = t42Var2;
                e = e2;
                wd0Var = wd0Var2;
                if (e.a == wd0Var) {
                    throw e;
                }
                j70 j70Var = cn0Var.b;
                j70Var.getClass();
                hp4.b(j70Var);
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            wd0Var = cn0Var.f;
            t42Var = cn0Var.e;
            try {
                bz3.g(obj);
            } catch (i0 e3) {
                e = e3;
                if (e.a == wd0Var) {
                    throw e;
                }
                j70 j70Var2 = cn0Var.b;
                j70Var2.getClass();
                hp4.b(j70Var2);
            }
        }
        Object obj3 = t42Var.a;
        if (obj3 != py0Var) {
            return obj3;
        }
        kf2.g("Expected at least one element matching the predicate");
        return null;
    }

    public static final g32 e(l90 l90Var, w50 w50Var, er2 er2Var, Float f) {
        bx.o.getClass();
        ax axVar = ax.a;
        q91 q91Var = new q91(27, l90Var, gi0.a);
        jr2 jr2VarA = o54.a(f);
        j70 j70Var = (j70) q91Var.c;
        mm0 mm0Var = (mm0) q91Var.b;
        v70 v70Var = er2Var.equals(lk2.a) ? v70.a : v70.e;
        aa aaVar = new aa(er2Var, mm0Var, jr2VarA, f, null, 4);
        j70 j70VarB = ql4.b(w50Var, j70Var);
        b1 ja1Var = v70Var == v70.b ? new ja1(j70VarB, aaVar) : new yq2(j70VarB, true);
        ja1Var.u0(v70Var, ja1Var, aaVar);
        return new g32(jr2VarA);
    }
}
