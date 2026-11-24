package defpackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xw extends jr0 implements Runnable {
    public ch c;
    public final LinkedBlockingQueue e = new LinkedBlockingQueue(1);
    public final CountDownLatch f = new CountDownLatch(1);
    public wc1 i;
    public volatile wc1 j;

    public xw(ch chVar, wc1 wc1Var) {
        this.c = chVar;
        wc1Var.getClass();
        this.i = wc1Var;
    }

    public static Object c(LinkedBlockingQueue linkedBlockingQueue) {
        Object objTake;
        boolean z = false;
        while (true) {
            try {
                objTake = linkedBlockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return objTake;
    }

    @Override // defpackage.jr0, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z2 = false;
        if (!this.a.cancel(z)) {
            return false;
        }
        while (true) {
            try {
                this.e.put(Boolean.valueOf(z));
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        wc1 wc1Var = this.i;
        if (wc1Var != null) {
            wc1Var.cancel(z);
        }
        wc1 wc1Var2 = this.j;
        if (wc1Var2 != null) {
            wc1Var2.cancel(z);
        }
        return true;
    }

    @Override // defpackage.jr0, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!this.a.isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            wc1 wc1Var = this.i;
            if (wc1Var != null) {
                long jNanoTime = System.nanoTime();
                wc1Var.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (!this.f.await(j, timeUnit)) {
                throw new TimeoutException();
            }
            j -= Math.max(0L, System.nanoTime() - jNanoTime2);
            wc1 wc1Var2 = this.j;
            if (wc1Var2 != null) {
                wc1Var2.get(j, timeUnit);
            }
        }
        return this.a.get(j, timeUnit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007f, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, jr0, xw] */
    /* JADX WARN: Type inference failed for: r5v1, types: [xw] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3, types: [jr0] */
    /* JADX WARN: Type inference failed for: r5v4, types: [xw] */
    /* JADX WARN: Type inference failed for: r5v6, types: [jr0] */
    /* JADX WARN: Type inference failed for: r5v7, types: [jr0] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            wc1 r2 = r5.i     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39 java.util.concurrent.ExecutionException -> L49 java.util.concurrent.CancellationException -> L56
            java.lang.Object r2 = defpackage.oz3.c(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39 java.util.concurrent.ExecutionException -> L49 java.util.concurrent.CancellationException -> L56
            ch r3 = r5.c     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            wc1 r2 = r3.mo28apply(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            r5.j = r2     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            wc1 r3 = r5.a     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            boolean r3 = r3.isCancelled()     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            if (r3 == 0) goto L3b
            java.util.concurrent.LinkedBlockingQueue r0 = r5.e     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            java.lang.Object r0 = c(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            r2.cancel(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            r5.j = r1     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
        L29:
            r5.c = r1
            r5.i = r1
            java.util.concurrent.CountDownLatch r5 = r5.f
            r5.countDown()
            return
        L33:
            r0 = move-exception
            goto L80
        L35:
            r0 = move-exception
            goto L5a
        L37:
            r0 = move-exception
            goto L6b
        L39:
            r0 = move-exception
            goto L73
        L3b:
            or0 r3 = new or0     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            r4 = 3
            r3.<init>(r4, r5, r2, r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            dd0 r0 = defpackage.xg4.a()     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            r2.a(r3, r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            goto L29
        L49:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            tp r2 = r5.b     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            if (r2 == 0) goto L29
            r2.b(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            goto L29
        L56:
            r5.cancel(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Error -> L35 java.lang.Exception -> L37 java.lang.reflect.UndeclaredThrowableException -> L39
            goto L29
        L5a:
            tp r2 = r5.b     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L61
            r2.b(r0)     // Catch: java.lang.Throwable -> L33
        L61:
            r5.c = r1
            r5.i = r1
            java.util.concurrent.CountDownLatch r5 = r5.f
            r5.countDown()
            goto L7f
        L6b:
            tp r2 = r5.b     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L61
            r2.b(r0)     // Catch: java.lang.Throwable -> L33
            goto L61
        L73:
            java.lang.Throwable r0 = r0.getCause()     // Catch: java.lang.Throwable -> L33
            tp r2 = r5.b     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L61
            r2.b(r0)     // Catch: java.lang.Throwable -> L33
            goto L61
        L7f:
            return
        L80:
            r5.c = r1
            r5.i = r1
            java.util.concurrent.CountDownLatch r5 = r5.f
            r5.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xw.run():void");
    }

    @Override // defpackage.jr0, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        if (!this.a.isDone()) {
            wc1 wc1Var = this.i;
            if (wc1Var != null) {
                wc1Var.get();
            }
            this.f.await();
            wc1 wc1Var2 = this.j;
            if (wc1Var2 != null) {
                wc1Var2.get();
            }
        }
        return this.a.get();
    }
}
