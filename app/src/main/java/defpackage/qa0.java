package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qa0 extends vj0 implements Executor {
    public static final qa0 c = new qa0();
    public static final l70 e;

    static {
        t43 t43Var = t43.c;
        int i = hv2.a;
        if (64 >= i) {
            i = 64;
        }
        e = t43Var.O(ab4.c(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        e.L(j70Var, runnable);
    }

    @Override // defpackage.l70
    public final void M(j70 j70Var, Runnable runnable) {
        e.M(j70Var, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        L(gi0.a, runnable);
    }

    @Override // defpackage.l70
    public final String toString() {
        return "Dispatchers.IO";
    }
}
