package defpackage;

import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qt implements Executor {
    public static final pt c = new pt(0);
    public final Object a = new Object();
    public ThreadPoolExecutor b;

    public qt() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), c);
        threadPoolExecutor.setRejectedExecutionHandler(new ot());
        this.b = threadPoolExecutor;
    }

    public final void a(mq mqVar) {
        ThreadPoolExecutor threadPoolExecutor;
        mqVar.getClass();
        synchronized (this.a) {
            try {
                if (this.b.isShutdown()) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), c);
                    threadPoolExecutor2.setRejectedExecutionHandler(new ot());
                    this.b = threadPoolExecutor2;
                }
                threadPoolExecutor = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        int iMax = Math.max(1, new LinkedHashSet(mqVar.f).size());
        threadPoolExecutor.setMaximumPoolSize(iMax);
        threadPoolExecutor.setCorePoolSize(iMax);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.a) {
            this.b.execute(runnable);
        }
    }
}
