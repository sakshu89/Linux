package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q92 implements x50, u70 {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(q92.class, Object.class, "result");
    public final x50 a;
    private volatile Object result;

    public q92(x50 x50Var, t70 t70Var) {
        this.a = x50Var;
        this.result = t70Var;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        t70 t70Var = t70.b;
        if (obj == t70Var) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            t70 t70Var2 = t70.a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, t70Var, t70Var2)) {
                if (atomicReferenceFieldUpdater.get(this) != t70Var) {
                    obj = this.result;
                }
            }
            return t70.a;
        }
        if (obj == t70.c) {
            return t70.a;
        }
        if (obj instanceof h72) {
            throw ((h72) obj).a;
        }
        return obj;
    }

    @Override // defpackage.u70
    public final u70 d() {
        x50 x50Var = this.a;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.a.f();
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        while (true) {
            Object obj2 = this.result;
            t70 t70Var = t70.b;
            if (obj2 == t70Var) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, t70Var, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != t70Var) {
                    }
                }
                return;
            }
            t70 t70Var2 = t70.a;
            if (obj2 != t70Var2) {
                og.n("Already resumed");
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = b;
            t70 t70Var3 = t70.c;
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(this, t70Var2, t70Var3)) {
                    this.a.h(obj);
                    return;
                }
            } while (atomicReferenceFieldUpdater2.get(this) == t70Var2);
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.a;
    }
}
