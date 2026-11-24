package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zm1 implements wv, j93 {
    public final yv a;
    public final /* synthetic */ an1 b;

    public zm1(an1 an1Var, yv yvVar) {
        this.b = an1Var;
        this.a = yvVar;
    }

    @Override // defpackage.j93
    public final void a(af2 af2Var, int i) {
        this.a.a(af2Var, i);
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.a.f;
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        this.a.h(obj);
    }

    @Override // defpackage.wv
    public final void i(Object obj, wq0 wq0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = an1.i;
        an1 an1Var = this.b;
        atomicReferenceFieldUpdater.set(an1Var, null);
        x0 x0Var = new x0(19, an1Var, this);
        yv yvVar = this.a;
        yvVar.G((q43) obj, yvVar.c, new xv(0, x0Var));
    }

    @Override // defpackage.wv
    public final py0 k(Object obj, wq0 wq0Var) {
        an1 an1Var = this.b;
        xv xvVar = new xv(an1Var, this);
        py0 py0VarJ = this.a.J((q43) obj, xvVar);
        if (py0VarJ != null) {
            an1.i.set(an1Var, null);
        }
        return py0VarJ;
    }

    @Override // defpackage.wv
    public final boolean m(Throwable th) {
        return this.a.m(th);
    }

    @Override // defpackage.wv
    public final void u(Object obj) {
        this.a.u(obj);
    }
}
