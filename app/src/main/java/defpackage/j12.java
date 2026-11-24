package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j12 extends b1 implements bx, vg2 {
    public final un i;

    public j12(j70 j70Var, un unVar) {
        super(j70Var, true);
        this.i = unVar;
    }

    @Override // defpackage.p41
    public final void B(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        this.i.i(cancellationException, true);
        A(cancellationException);
    }

    @Override // defpackage.vg2
    public final Object a(x50 x50Var, Object obj) {
        return this.i.a(x50Var, obj);
    }

    @Override // defpackage.vg2
    public final boolean b(Throwable th) {
        return this.i.i(th, false);
    }

    @Override // defpackage.p41, defpackage.f41
    public final void e(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        Object objU = U();
        if (objU instanceof a10) {
            return;
        }
        if ((objU instanceof l41) && ((l41) objU).e()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new g41(G(), null, this);
        }
        B(cancellationException);
    }

    @Override // defpackage.bx
    public final Object g(y50 y50Var) {
        un unVar = this.i;
        unVar.getClass();
        return un.J(unVar, y50Var);
    }

    @Override // defpackage.bx
    public final pn iterator() {
        un unVar = this.i;
        unVar.getClass();
        return new pn(unVar);
    }

    @Override // defpackage.bx
    public final p6 l() {
        return this.i.l();
    }

    @Override // defpackage.bx
    public final Object n(nu2 nu2Var) {
        un unVar = this.i;
        unVar.getClass();
        return un.I(unVar, nu2Var);
    }

    @Override // defpackage.bx
    public final Object p() {
        return this.i.p();
    }

    @Override // defpackage.vg2
    public final Object s(Object obj) {
        return this.i.s(obj);
    }

    @Override // defpackage.b1
    public final void s0(Throwable th, boolean z) {
        if (this.i.i(th, false) || z) {
            return;
        }
        sl4.a(this.f, th);
    }

    @Override // defpackage.b1
    public final void t0(Object obj) {
        this.i.b(null);
    }
}
