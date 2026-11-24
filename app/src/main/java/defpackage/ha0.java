package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ha0 extends oj0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final ha0 u;
    public static final long v;

    static {
        Long l;
        ha0 ha0Var = new ha0();
        u = ha0Var;
        ha0Var.R(false);
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        v = TimeUnit.MILLISECONDS.toNanos(l.longValue());
    }

    @Override // defpackage.oj0, defpackage.vb0
    public final rd0 A(long j, Runnable runnable, j70 j70Var) {
        long j2 = 0;
        if (j > 0) {
            j2 = j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j;
        }
        if (j2 >= 4611686018427387903L) {
            return jo1.a;
        }
        long jNanoTime = System.nanoTime();
        lj0 lj0Var = new lj0(j2 + jNanoTime, runnable);
        f0(jNanoTime, lj0Var);
        return lj0Var;
    }

    @Override // defpackage.oj0
    public final void W(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.W(runnable);
    }

    @Override // defpackage.oj0
    public final Thread a0() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(u.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // defpackage.oj0
    public final void c0(long j, mj0 mj0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void i0() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            e0();
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        i03.a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    _thread = null;
                    i0();
                    if (b0()) {
                        return;
                    }
                    a0();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jS = S();
                    if (jS == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = v + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            i0();
                            if (b0()) {
                                return;
                            }
                            a0();
                            return;
                        }
                        if (jS > j2) {
                            jS = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jS > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            i0();
                            if (b0()) {
                                return;
                            }
                            a0();
                            return;
                        }
                        LockSupport.parkNanos(this, jS);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            i0();
            if (!b0()) {
                a0();
            }
            throw th;
        }
    }

    @Override // defpackage.oj0, defpackage.jj0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // defpackage.l70
    public final String toString() {
        return "DefaultExecutor";
    }
}
