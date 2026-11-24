package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class uf4 {
    public static rb0 a(s70 s70Var, vq0 vq0Var, int i) {
        v70 v70Var = (i & 2) != 0 ? v70.a : v70.e;
        j70 j70VarB = ql4.b(s70Var, gi0.a);
        rb0 i81Var = v70Var == v70.b ? new i81(j70VarB, vq0Var) : new rb0(j70VarB, true);
        i81Var.u0(v70Var, i81Var, vq0Var);
        return i81Var;
    }

    public static yq2 b(s70 s70Var, j70 j70Var, vq0 vq0Var, int i) {
        if ((i & 1) != 0) {
            j70Var = gi0.a;
        }
        v70 v70Var = (i & 2) != 0 ? v70.a : v70.e;
        j70 j70VarB = ql4.b(s70Var, j70Var);
        yq2 ja1Var = v70Var == v70.b ? new ja1(j70VarB, vq0Var) : new yq2(j70VarB, true);
        ja1Var.u0(v70Var, ja1Var, vq0Var);
        return ja1Var;
    }

    public static final v11 c(q11 q11Var) {
        return new v11(q11Var.a, q11Var.b, q11Var.c, q11Var.d);
    }

    public static final Object d(j70 j70Var, vq0 vq0Var, x50 x50Var) throws Throwable {
        j70 j70VarF = x50Var.f();
        j70 j70VarR = !((Boolean) j70Var.y(new ag(5), Boolean.FALSE)).booleanValue() ? j70VarF.r(j70Var) : ql4.a(j70VarF, j70Var, false);
        hp4.b(j70VarR);
        if (j70VarR == j70VarF) {
            hb2 hb2Var = new hb2(x50Var, j70VarR);
            return ee4.b(hb2Var, true, hb2Var, vq0Var);
        }
        qs4 qs4Var = qs4.c;
        if (g31.a(j70VarR.v(qs4Var), j70VarF.v(qs4Var))) {
            l43 l43Var = new l43(x50Var, j70VarR);
            j70 j70Var2 = l43Var.f;
            Object objE = ab4.e(j70Var2, null);
            try {
                return ee4.b(l43Var, true, l43Var, vq0Var);
            } finally {
                ab4.a(j70Var2, objE);
            }
        }
        id0 id0Var = new id0(x50Var, j70VarR);
        try {
            ry3.b(fp4.b(fp4.a(id0Var, id0Var, vq0Var)), q43.a);
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = id0.j;
            do {
                int i = atomicIntegerFieldUpdater.get(id0Var);
                if (i != 0) {
                    if (i != 2) {
                        og.n("Already suspended");
                        return null;
                    }
                    Object objE2 = tz3.e(id0Var.U());
                    if (objE2 instanceof a10) {
                        throw ((a10) objE2).a;
                    }
                    return objE2;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(id0Var, 0, 1));
            return t70.a;
        } catch (Throwable th) {
            th = th;
            if (th instanceof gd0) {
                th = ((gd0) th).a;
            }
            id0Var.h(bz3.f(th));
            throw th;
        }
    }
}
