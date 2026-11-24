package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd0 extends hw2 {
    public int c;

    public jd0(int i) {
        super(0L, false);
        this.c = i;
    }

    public abstract x50 c();

    public Throwable e(Object obj) {
        a10 a10Var = obj instanceof a10 ? (a10) obj : null;
        if (a10Var != null) {
            return a10Var.a;
        }
        return null;
    }

    public final void j(Throwable th) {
        sl4.a(c().f(), new w70("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            x50 x50VarC = c();
            x50VarC.getClass();
            hd0 hd0Var = (hd0) x50VarC;
            y50 y50Var = hd0Var.f;
            Object obj = hd0Var.j;
            j70 j70VarF = y50Var.f();
            Object objE = ab4.e(j70VarF, obj);
            f41 f41Var = null;
            l43 l43VarC = objE != ab4.a ? ql4.c(y50Var, j70VarF, objE) : null;
            try {
                j70 j70VarF2 = y50Var.f();
                Object objL = l();
                Throwable thE = e(objL);
                if (thE == null) {
                    int i = this.c;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        f41Var = (f41) j70VarF2.v(nr4.k);
                    }
                }
                if (f41Var != null && !f41Var.c()) {
                    CancellationException cancellationExceptionX = f41Var.x();
                    b(cancellationExceptionX);
                    y50Var.h(bz3.f(cancellationExceptionX));
                } else if (thE != null) {
                    y50Var.h(new h72(thE));
                } else {
                    y50Var.h(g(objL));
                }
            } finally {
                if (l43VarC == null || l43VarC.w0()) {
                    ab4.a(j70VarF, objE);
                }
            }
        } catch (gd0 e) {
            sl4.a(c().f(), e.a);
        } catch (Throwable th) {
            j(th);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object g(Object obj) {
        return obj;
    }
}
