package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ql extends b1 {
    public final Thread i;
    public final jj0 j;

    public ql(j70 j70Var, Thread thread, jj0 jj0Var) {
        super(j70Var, true);
        this.i = thread;
        this.j = jj0Var;
    }

    @Override // defpackage.p41
    public final void t(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.i;
        if (g31.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
