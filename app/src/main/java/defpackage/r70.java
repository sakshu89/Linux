package defpackage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r70 implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(r70.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(r70.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater s = AtomicIntegerFieldUpdater.newUpdater(r70.class, "_isTerminated$volatile");
    public static final py0 t = new py0(16, "NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int a;
    public final int b;
    public final long c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String e;
    public final eu0 f;
    public final eu0 i;
    public final k62 j;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public r70(int i, int i2, long j, String str) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.e = str;
        if (i < 1) {
            og.g(cq.h("Core pool size ", i, " should be at least 1"));
            throw null;
        }
        if (i2 < i) {
            og.g(ky0.i("Max pool size ", i2, i, " should be greater than or equals to core pool size "));
            throw null;
        }
        if (i2 > 2097150) {
            og.g(cq.h("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f = new eu0();
        this.i = new eu0();
        this.j = new k62((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
    }

    public static /* synthetic */ void j(r70 r70Var, Runnable runnable, int i) {
        r70Var.e(runnable, false, (i & 4) == 0);
    }

    public final int c() {
        synchronized (this.j) {
            try {
                if (s.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = n;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.a) {
                    return 0;
                }
                if (i >= this.b) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.j.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                p70 p70Var = new p70(this, i3);
                this.j.c(i3, p70Var);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                p70Var.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        hw2 hw2VarA;
        if (s.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            p70 p70Var = null;
            p70 p70Var2 = threadCurrentThread instanceof p70 ? (p70) threadCurrentThread : null;
            if (p70Var2 != null && p70Var2.k == this) {
                p70Var = p70Var2;
            }
            synchronized (this.j) {
                i = (int) (n.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object objB = this.j.b(i2);
                    objB.getClass();
                    p70 p70Var3 = (p70) objB;
                    if (p70Var3 != p70Var) {
                        while (p70Var3.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(p70Var3);
                            p70Var3.join(10000L);
                        }
                        p70Var3.a.d(this.i);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.i.b();
            this.f.b();
            while (true) {
                if (p70Var != null) {
                    hw2VarA = p70Var.a(true);
                    if (hw2VarA == null) {
                        hw2VarA = (hw2) this.f.d();
                        if (hw2VarA == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    hw2VarA = (hw2) this.f.d();
                    if (hw2VarA == null && (hw2VarA = (hw2) this.i.d()) == null) {
                        break;
                    }
                }
                try {
                    hw2VarA.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (p70Var != null) {
                p70Var.h(q70.f);
            }
            k.set(this, 0L);
            n.set(this, 0L);
        }
    }

    public final void e(Runnable runnable, boolean z, boolean z2) {
        hw2 kw2Var;
        q70 q70Var;
        nw2.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof hw2) {
            kw2Var = (hw2) runnable;
            kw2Var.a = jNanoTime;
            kw2Var.b = z;
        } else {
            kw2Var = new kw2(runnable, jNanoTime, z);
        }
        boolean z3 = kw2Var.b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = n;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        p70 p70Var = null;
        p70 p70Var2 = threadCurrentThread instanceof p70 ? (p70) threadCurrentThread : null;
        if (p70Var2 != null && p70Var2.k == this) {
            p70Var = p70Var2;
        }
        if (p70Var != null && (q70Var = p70Var.c) != q70.f && (kw2Var.b || q70Var != q70.b)) {
            p70Var.j = true;
            kw2Var = p70Var.a.a(kw2Var, z2);
        }
        if (kw2Var != null) {
            if (!(kw2Var.b ? this.i.a(kw2Var) : this.f.a(kw2Var))) {
                throw new RejectedExecutionException(cq.n(new StringBuilder(), this.e, " was terminated"));
            }
        }
        if (z3) {
            if (r() || q(jAddAndGet)) {
                return;
            }
            r();
            return;
        }
        if (r() || q(atomicLongFieldUpdater.get(this))) {
            return;
        }
        r();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        j(this, runnable, 6);
    }

    public final void o(p70 p70Var, int i, int i2) {
        while (true) {
            long j = k.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object objC = p70Var.c();
                    while (true) {
                        if (objC == t) {
                            i3 = -1;
                            break;
                        }
                        if (objC == null) {
                            i3 = 0;
                            break;
                        }
                        p70 p70Var2 = (p70) objC;
                        int iB = p70Var2.b();
                        if (iB != 0) {
                            i3 = iB;
                            break;
                        }
                        objC = p70Var2.c();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                r70 r70Var = this;
                if (k.compareAndSet(r70Var, j, ((long) i3) | j2)) {
                    return;
                } else {
                    this = r70Var;
                }
            }
        }
    }

    public final boolean q(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.a;
        if (i < i2) {
            int iC = c();
            if (iC == 1 && i2 > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        r70 r70Var;
        py0 py0Var;
        int iB;
        while (true) {
            long j = k.get(this);
            p70 p70Var = (p70) this.j.b((int) (2097151 & j));
            if (p70Var == null) {
                p70Var = null;
                r70Var = this;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objC = p70Var.c();
                while (true) {
                    py0Var = t;
                    if (objC == py0Var) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    p70 p70Var2 = (p70) objC;
                    iB = p70Var2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = p70Var2.c();
                    j = j;
                }
                if (iB >= 0) {
                    r70 r70Var2 = this;
                    boolean zCompareAndSet = k.compareAndSet(r70Var2, j, ((long) iB) | j2);
                    r70Var = r70Var2;
                    if (zCompareAndSet) {
                        p70Var.g(py0Var);
                    }
                    this = r70Var;
                } else {
                    continue;
                }
            }
            if (p70Var == null) {
                return false;
            }
            if (p70.n.compareAndSet(p70Var, -1, 0)) {
                LockSupport.unpark(p70Var);
                return true;
            }
            this = r70Var;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        k62 k62Var = this.j;
        int iA = k62Var.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            p70 p70Var = (p70) k62Var.b(i6);
            if (p70Var != null) {
                int iC = p70Var.a.c();
                int iOrdinal = p70Var.c.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iC);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iC);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (iC > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iC);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        dk0.l();
                        return null;
                    }
                    i5++;
                }
            }
        }
        long j = n.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.e);
        sb4.append('@');
        sb4.append(ba0.c(this));
        sb4.append("[Pool Size {core = ");
        int i7 = this.a;
        sb4.append(i7);
        sb4.append(", max = ");
        sb4.append(this.b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.i.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i7 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
