package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p70 extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(p70.class, "workerCtl$volatile");
    public final mc3 a;
    public final t42 b;
    public q70 c;
    public long e;
    public long f;
    public int i;
    private volatile int indexInArray;
    public boolean j;
    public final /* synthetic */ r70 k;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public p70(r70 r70Var, int i) {
        this.k = r70Var;
        setDaemon(true);
        setContextClassLoader(r70.class.getClassLoader());
        this.a = new mc3();
        this.b = new t42();
        this.c = q70.e;
        this.nextParkedWorker = r70.t;
        int iNanoTime = (int) System.nanoTime();
        this.i = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    public final hw2 a(boolean z) {
        hw2 hw2VarE;
        hw2 hw2VarE2;
        long j;
        q70 q70Var = this.c;
        r70 r70Var = this.k;
        mc3 mc3Var = this.a;
        q70 q70Var2 = q70.a;
        if (q70Var != q70Var2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = r70.n;
            do {
                j = atomicLongFieldUpdater.get(r70Var);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    hw2 hw2VarG = mc3Var.g();
                    return (hw2VarG == null && (hw2VarG = (hw2) r70Var.i.d()) == null) ? i(1) : hw2VarG;
                }
            } while (!r70.n.compareAndSet(r70Var, j, j - 4398046511104L));
            this.c = q70Var2;
        }
        if (z) {
            boolean z2 = d(r70Var.a * 2) == 0;
            if (z2 && (hw2VarE2 = e()) != null) {
                return hw2VarE2;
            }
            hw2 hw2VarE3 = mc3Var.e();
            if (hw2VarE3 != null) {
                return hw2VarE3;
            }
            if (!z2 && (hw2VarE = e()) != null) {
                return hw2VarE;
            }
        } else {
            hw2 hw2VarE4 = e();
            if (hw2VarE4 != null) {
                return hw2VarE4;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.i;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.i = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
    }

    public final hw2 e() {
        int iD = d(2);
        r70 r70Var = this.k;
        eu0 eu0Var = r70Var.i;
        eu0 eu0Var2 = r70Var.f;
        if (iD == 0) {
            hw2 hw2Var = (hw2) eu0Var2.d();
            return hw2Var != null ? hw2Var : (hw2) eu0Var.d();
        }
        hw2 hw2Var2 = (hw2) eu0Var.d();
        return hw2Var2 != null ? hw2Var2 : (hw2) eu0Var2.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.k.e);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(q70 q70Var) {
        q70 q70Var2 = this.c;
        boolean z = q70Var2 == q70.a;
        if (z) {
            r70.n.addAndGet(this.k, 4398046511104L);
        }
        if (q70Var2 != q70Var) {
            this.c = q70Var;
        }
        return z;
    }

    public final hw2 i(int i) {
        hw2 hw2VarH;
        long jI;
        AtomicLongFieldUpdater atomicLongFieldUpdater = r70.n;
        r70 r70Var = this.k;
        int i2 = (int) (atomicLongFieldUpdater.get(r70Var) & 2097151);
        if (i2 < 2) {
            return null;
        }
        int iD = d(i2);
        long jMin = Long.MAX_VALUE;
        for (int i3 = 0; i3 < i2; i3++) {
            iD++;
            if (iD > i2) {
                iD = 1;
            }
            p70 p70Var = (p70) r70Var.j.b(iD);
            if (p70Var != null && p70Var != this) {
                mc3 mc3Var = p70Var.a;
                if (i != 3) {
                    mc3Var.getClass();
                    int i4 = mc3.d.get(mc3Var);
                    int i5 = mc3.c.get(mc3Var);
                    boolean z = i == 1;
                    while (true) {
                        if (i4 == i5 || (z && mc3.e.get(mc3Var) == 0)) {
                            hw2VarH = null;
                            break;
                        }
                        int i6 = i4 + 1;
                        hw2VarH = mc3Var.h(i4, z);
                        if (hw2VarH != null) {
                            break;
                        }
                        i4 = i6;
                    }
                } else {
                    hw2VarH = mc3Var.f();
                }
                t42 t42Var = this.b;
                if (hw2VarH != null) {
                    t42Var.a = hw2VarH;
                    jI = -1;
                } else {
                    jI = mc3Var.i(i, t42Var);
                }
                if (jI == -1) {
                    hw2 hw2Var = (hw2) t42Var.a;
                    t42Var.a = null;
                    return hw2Var;
                }
                if (jI > 0) {
                    jMin = Math.min(jMin, jI);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long j;
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (r70.s.get(this.k) != 1) {
                    q70 q70Var = this.c;
                    q70 q70Var2 = q70.f;
                    if (q70Var == q70Var2) {
                        break loop0;
                    }
                    hw2 hw2VarA = a(this.j);
                    if (hw2VarA != null) {
                        this.f = 0L;
                        r70 r70Var = this.k;
                        this.e = 0L;
                        if (this.c == q70.c) {
                            this.c = q70.b;
                        }
                        if (!hw2VarA.b) {
                            try {
                                hw2VarA.run();
                                break;
                            } catch (Throwable th) {
                                Thread threadCurrentThread = Thread.currentThread();
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                                break;
                            }
                        }
                        if (h(q70.b) && !r70Var.r() && !r70Var.q(r70.n.get(r70Var))) {
                            r70Var.r();
                        }
                        try {
                            hw2VarA.run();
                        } catch (Throwable th2) {
                            Thread threadCurrentThread2 = Thread.currentThread();
                            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                        }
                        r70.n.addAndGet(r70Var, -2097152L);
                        if (this.c == q70Var2) {
                            break;
                        }
                        this.c = q70.e;
                        break;
                    }
                    this.j = false;
                    if (this.f == 0) {
                        Object obj = this.nextParkedWorker;
                        py0 py0Var = r70.t;
                        if (obj != py0Var) {
                            n.set(this, -1);
                            while (this.nextParkedWorker != r70.t) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                r70 r70Var2 = this.k;
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = r70.s;
                                if (atomicIntegerFieldUpdater2.get(r70Var2) == 1) {
                                    break;
                                }
                                q70 q70Var3 = this.c;
                                q70 q70Var4 = q70.f;
                                if (q70Var3 == q70Var4) {
                                    break;
                                }
                                h(q70.c);
                                Thread.interrupted();
                                if (this.e == 0) {
                                    j = 2097151;
                                    this.e = System.nanoTime() + this.k.c;
                                } else {
                                    j = 2097151;
                                }
                                LockSupport.parkNanos(this.k.c);
                                if (System.nanoTime() - this.e >= 0) {
                                    this.e = 0L;
                                    r70 r70Var3 = this.k;
                                    synchronized (r70Var3.j) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(r70Var3) == 1)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater = r70.n;
                                                if (((int) (atomicLongFieldUpdater.get(r70Var3) & j)) > r70Var3.a) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        f(0);
                                                        r70Var3.o(this, i, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(r70Var3) & j);
                                                        if (andDecrement != i) {
                                                            Object objB = r70Var3.j.b(andDecrement);
                                                            objB.getClass();
                                                            p70 p70Var = (p70) objB;
                                                            r70Var3.j.c(i, p70Var);
                                                            p70Var.f(i);
                                                            r70Var3.o(p70Var, andDecrement, i);
                                                        }
                                                        r70Var3.j.c(andDecrement, null);
                                                        this.c = q70Var4;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            throw th3;
                                        }
                                    }
                                }
                            }
                        } else {
                            r70 r70Var4 = this.k;
                            if (this.nextParkedWorker == py0Var) {
                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = r70.k;
                                while (true) {
                                    long j2 = atomicLongFieldUpdater2.get(r70Var4);
                                    int i2 = this.indexInArray;
                                    this.nextParkedWorker = r70Var4.j.b((int) (j2 & 2097151));
                                    r70 r70Var5 = r70Var4;
                                    if (r70.k.compareAndSet(r70Var5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i2))) {
                                        break;
                                    } else {
                                        r70Var4 = r70Var5;
                                    }
                                }
                            }
                        }
                    } else {
                        if (z) {
                            h(q70.c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f);
                            this.f = 0L;
                            break;
                        }
                        z = true;
                    }
                } else {
                    break loop0;
                }
            }
        }
        h(q70.f);
    }
}
