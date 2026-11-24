package defpackage;

import android.os.Handler;
import android.view.MotionEvent;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o7 implements Runnable {
    public final /* synthetic */ int a;
    public final Object b;

    public o7(td3 td3Var, c10 c10Var) {
        this.a = 13;
        this.b = c10Var;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r4.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        defpackage.xq4.b("SequentialExecutor", "Exception while executing runnable " + r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.b     // Catch: java.lang.Throwable -> L4f
            ch2 r2 = (defpackage.ch2) r2     // Catch: java.lang.Throwable -> L4f
            java.util.ArrayDeque r2 = r2.a     // Catch: java.lang.Throwable -> L4f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.b     // Catch: java.lang.Throwable -> L20
            ch2 r0 = (defpackage.ch2) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.e     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
        L18:
            java.lang.Thread r10 = java.lang.Thread.currentThread()
            r10.interrupt()
            goto L44
        L20:
            r10 = move-exception
            goto L69
        L22:
            long r6 = r0.f     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f = r6     // Catch: java.lang.Throwable -> L20
            r0.e = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.b     // Catch: java.lang.Throwable -> L20
            ch2 r4 = (defpackage.ch2) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.a     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L45
            java.lang.Object r10 = r10.b     // Catch: java.lang.Throwable -> L20
            ch2 r10 = (defpackage.ch2) r10     // Catch: java.lang.Throwable -> L20
            r10.e = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
            goto L18
        L44:
            return
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L4f
            r1 = r1 | r2
            r4.run()     // Catch: java.lang.Throwable -> L4f java.lang.RuntimeException -> L51
            goto L2
        L4f:
            r10 = move-exception
            goto L6b
        L51:
            r2 = move-exception
            java.lang.String r3 = "SequentialExecutor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r5.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r6 = "Exception while executing runnable "
            r5.append(r6)     // Catch: java.lang.Throwable -> L4f
            r5.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L4f
            defpackage.xq4.b(r3, r4, r2)     // Catch: java.lang.Throwable -> L4f
            goto L2
        L69:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r10     // Catch: java.lang.Throwable -> L4f
        L6b:
            if (r1 == 0) goto L74
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L74:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o7.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        gw2 gw2VarC;
        long jNanoTime;
        switch (this.a) {
            case 0:
                r7 r7Var = (r7) this.b;
                r7Var.removeCallbacks(this);
                MotionEvent motionEvent = r7Var.c1;
                if (motionEvent != null) {
                    boolean z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i = 2;
                    }
                    r7Var.D(motionEvent, i, r7Var.d1, false);
                    return;
                }
                return;
            case 1:
                ((cd0) this.b).s.onDismiss(null);
                return;
            case 2:
                ((lq) this.b).l();
                throw null;
            case 3:
                ((wc1) this.b).cancel(true);
                return;
            case 4:
                kf kfVar = (kf) this.b;
                wv0 wv0Var = (wv0) kfVar.e;
                if (wv0Var.a.getAndSet(null) != null) {
                    ((Handler) kfVar.b).removeCallbacks(wv0Var);
                    return;
                }
                return;
            case 5:
                uc1 uc1Var = (uc1) this.b;
                uc1Var.b = null;
                uc1Var.a = null;
                return;
            case 6:
                synchronized (((jd1) this.b).a) {
                    obj = ((jd1) this.b).f;
                    ((jd1) this.b).f = jd1.k;
                    break;
                }
                ((jd1) this.b).h(obj);
                return;
            case 7:
                try {
                    a();
                    return;
                } catch (Error e) {
                    synchronized (((ch2) this.b).a) {
                        ((ch2) this.b).e = 1;
                        throw e;
                    }
                }
            case 8:
                break;
            case 9:
                p6 p6Var = (p6) this.b;
                ((l92) p6Var.e).o(new wj1(20, p6Var));
                return;
            case 10:
                ((wd3) this.b).h();
                return;
            case 11:
                je jeVar = ((wd3) ((wj1) this.b).b).b;
                jeVar.b(jeVar.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 12:
                ((ge3) this.b).h.b(new x30(4));
                return;
            default:
                throw null;
        }
        while (true) {
            mw2 mw2Var = (mw2) this.b;
            synchronized (mw2Var) {
                gw2VarC = mw2Var.c();
            }
            if (gw2VarC == null) {
                return;
            }
            lw2 lw2Var = gw2VarC.c;
            lw2Var.getClass();
            mw2 mw2Var2 = (mw2) this.b;
            boolean zIsLoggable = mw2.i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = System.nanoTime();
                gb4.a(gw2VarC, lw2Var, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                mw2.a(mw2Var2, gw2VarC);
                if (zIsLoggable) {
                    gb4.a(gw2VarC, lw2Var, "finished run in ".concat(gb4.b(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th) {
                try {
                    ((ThreadPoolExecutor) mw2Var2.a.b).execute(this);
                    throw th;
                } catch (Throwable th2) {
                    if (!zIsLoggable) {
                        throw th2;
                    }
                    gb4.a(gw2VarC, lw2Var, "failed a run in ".concat(gb4.b(System.nanoTime() - jNanoTime)));
                    throw th2;
                }
            }
        }
    }

    public /* synthetic */ o7(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
