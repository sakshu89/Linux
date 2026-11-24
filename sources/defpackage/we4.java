package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class we4 implements v73 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(bq2 bq2Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        boolean zIsTerminated;
        if (th != null) {
            try {
                cq.u(bq2Var);
                return;
            } catch (Throwable th2) {
                gn4.a(th, th2);
                return;
            }
        }
        if (bq2Var instanceof AutoCloseable) {
            bq2Var.close();
            return;
        }
        if (!(bq2Var instanceof ExecutorService)) {
            dk0.v();
            return;
        }
        ExecutorService executorService = (ExecutorService) bq2Var;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }
}
