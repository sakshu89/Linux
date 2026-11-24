package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ch2 implements Executor {
    public final Executor b;
    public final ArrayDeque a = new ArrayDeque();
    public final o7 c = new o7(7, this);
    public int e = 1;
    public long f = 0;

    public ch2(Executor executor) {
        executor.getClass();
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.a) {
            int i = this.e;
            if (i != 4 && i != 3) {
                long j = this.f;
                boolean z = true;
                w92 w92Var = new w92(runnable, 1);
                this.a.add(w92Var);
                this.e = 2;
                try {
                    this.b.execute(this.c);
                    if (this.e != 2) {
                        return;
                    }
                    synchronized (this.a) {
                        try {
                            if (this.f == j && this.e == 2) {
                                this.e = 3;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.a) {
                        try {
                            int i2 = this.e;
                            if ((i2 != 1 && i2 != 2) || !this.a.removeLastOccurrence(w92Var)) {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
            }
            this.a.add(runnable);
        }
    }
}
