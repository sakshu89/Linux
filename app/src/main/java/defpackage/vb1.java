package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vb1 extends l70 implements vb0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(vb1.class, "runningWorkers$volatile");
    public final /* synthetic */ vb0 c;
    public final l70 e;
    public final int f;
    public final se1 i;
    public final Object j;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public vb1(l70 l70Var, int i) {
        vb0 vb0Var = l70Var instanceof vb0 ? (vb0) l70Var : null;
        this.c = vb0Var == null ? ia0.a : vb0Var;
        this.e = l70Var;
        this.f = i;
        this.i = new se1();
        this.j = new Object();
    }

    @Override // defpackage.vb0
    public final rd0 A(long j, Runnable runnable, j70 j70Var) {
        return this.c.A(j, runnable, j70Var);
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        Runnable runnableP;
        this.i.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
        if (atomicIntegerFieldUpdater.get(this) >= this.f || !Q() || (runnableP = P()) == null) {
            return;
        }
        try {
            ry3.c(this.e, this, new or0(7, this, runnableP, false));
        } catch (Throwable th) {
            atomicIntegerFieldUpdater.decrementAndGet(this);
            throw th;
        }
    }

    @Override // defpackage.l70
    public final void M(j70 j70Var, Runnable runnable) {
        Runnable runnableP;
        this.i.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
        if (atomicIntegerFieldUpdater.get(this) >= this.f || !Q() || (runnableP = P()) == null) {
            return;
        }
        try {
            this.e.M(this, new or0(7, this, runnableP, false));
        } catch (Throwable th) {
            atomicIntegerFieldUpdater.decrementAndGet(this);
            throw th;
        }
    }

    public final Runnable P() {
        while (true) {
            Runnable runnable = (Runnable) this.i.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.j) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.i.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean Q() {
        synchronized (this.j) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = k;
            if (atomicIntegerFieldUpdater.get(this) >= this.f) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // defpackage.vb0
    public final void o(long j, yv yvVar) {
        this.c.o(j, yvVar);
    }

    @Override // defpackage.l70
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append(".limitedParallelism(");
        return ky0.m(sb, this.f, ')');
    }
}
