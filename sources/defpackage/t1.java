package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends bc4 {
    public final AtomicReferenceFieldUpdater a;
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    public t1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.bc4
    public final boolean a(w1 w1Var, s1 s1Var, s1 s1Var2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.d;
            if (atomicReferenceFieldUpdater.compareAndSet(w1Var, s1Var, s1Var2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(w1Var) == s1Var);
        return false;
    }

    @Override // defpackage.bc4
    public final boolean b(w1 w1Var, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.e;
            if (atomicReferenceFieldUpdater.compareAndSet(w1Var, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(w1Var) == obj);
        return false;
    }

    @Override // defpackage.bc4
    public final boolean c(w1 w1Var, v1 v1Var, v1 v1Var2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.c;
            if (atomicReferenceFieldUpdater.compareAndSet(w1Var, v1Var, v1Var2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(w1Var) == v1Var);
        return false;
    }

    @Override // defpackage.bc4
    public final void g(v1 v1Var, v1 v1Var2) {
        this.b.lazySet(v1Var, v1Var2);
    }

    @Override // defpackage.bc4
    public final void h(v1 v1Var, Thread thread) {
        this.a.lazySet(v1Var, thread);
    }
}
