package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class b1 extends p41 implements x50, s70 {
    public final j70 f;

    public b1(j70 j70Var, boolean z) {
        super(z);
        X((f41) j70Var.v(nr4.k));
        this.f = j70Var.r(this);
    }

    @Override // defpackage.p41
    public final String G() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // defpackage.p41
    public final void W(b10 b10Var) {
        sl4.a(this.f, b10Var);
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.f;
    }

    @Override // defpackage.p41
    public final void g0(Object obj) {
        if (!(obj instanceof a10)) {
            t0(obj);
        } else {
            a10 a10Var = (a10) obj;
            s0(a10Var.a, a10.b.get(a10Var) == 1);
        }
    }

    @Override // defpackage.x50
    public final void h(Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thA = i72.a(obj);
        if (thA != null) {
            obj = new a10(thA, false);
        }
        Object objC0 = c0(obj);
        if (objC0 == tz3.b) {
            return;
        }
        z(objC0);
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.f;
    }

    public final void u0(v70 v70Var, b1 b1Var, vq0 vq0Var) {
        Object objE;
        int iOrdinal = v70Var.ordinal();
        q43 q43Var = q43.a;
        if (iOrdinal == 0) {
            try {
                ry3.b(fp4.b(fp4.a(b1Var, this, vq0Var)), q43Var);
                return;
            } catch (Throwable th) {
                th = th;
                if (th instanceof gd0) {
                    th = ((gd0) th).a;
                }
                h(bz3.f(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                vq0Var.getClass();
                fp4.b(fp4.a(b1Var, this, vq0Var)).h(q43Var);
                return;
            }
            if (iOrdinal != 3) {
                dk0.l();
                return;
            }
            try {
                j70 j70Var = this.f;
                Object objE2 = ab4.e(j70Var, null);
                try {
                    if (vq0Var instanceof pk) {
                        h33.c(2, vq0Var);
                        objE = vq0Var.e(b1Var, this);
                    } else {
                        objE = fp4.c(vq0Var, b1Var, this);
                    }
                    ab4.a(j70Var, objE2);
                    if (objE != t70.a) {
                        h(objE);
                    }
                } catch (Throwable th2) {
                    ab4.a(j70Var, objE2);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                if (th instanceof gd0) {
                    th = ((gd0) th).a;
                }
                h(bz3.f(th));
            }
        }
    }

    public void t0(Object obj) {
    }

    public void s0(Throwable th, boolean z) {
    }
}
