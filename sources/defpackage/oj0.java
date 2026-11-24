package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class oj0 extends jj0 implements vb0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(oj0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    public static final /* synthetic */ AtomicIntegerFieldUpdater n;
    public static final /* synthetic */ long s;
    public static final /* synthetic */ long t;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        Unsafe unsafe = zj.a;
        t = unsafe.objectFieldOffset(oj0.class.getDeclaredField("_queue$volatile"));
        k = AtomicReferenceFieldUpdater.newUpdater(oj0.class, Object.class, "_delayed$volatile");
        s = unsafe.objectFieldOffset(oj0.class.getDeclaredField("_delayed$volatile"));
        n = AtomicIntegerFieldUpdater.newUpdater(oj0.class, "_isCompleted$volatile");
    }

    public rd0 A(long j2, Runnable runnable, j70 j70Var) {
        return ia0.a.A(j2, runnable, j70Var);
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        W(runnable);
    }

    @Override // defpackage.jj0
    public final long S() {
        if (T()) {
            return 0L;
        }
        X();
        Runnable runnableV = V();
        if (runnableV == null) {
            return Z();
        }
        runnableV.run();
        return 0L;
    }

    public final void U() {
        oj0 oj0Var;
        Unsafe unsafe;
        while (true) {
            j.getClass();
            Unsafe unsafe2 = zj.a;
            long j2 = t;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            py0 py0Var = dz3.b;
            if (objectVolatile == null) {
                while (true) {
                    Unsafe unsafe3 = zj.a;
                    oj0 oj0Var2 = this;
                    oj0Var = oj0Var2;
                    if (unsafe3.compareAndSwapObject(oj0Var2, t, (Object) null, py0Var)) {
                        return;
                    }
                    if (unsafe3.getObjectVolatile(oj0Var, j2) != null) {
                        break;
                    } else {
                        this = oj0Var;
                    }
                }
            } else {
                oj0Var = this;
                if (objectVolatile instanceof ue1) {
                    ((ue1) objectVolatile).c();
                    return;
                }
                if (objectVolatile == py0Var) {
                    return;
                }
                ue1 ue1Var = new ue1(8, true);
                ue1Var.a((Runnable) objectVolatile);
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(oj0Var, t, objectVolatile, ue1Var)) {
                        return;
                    }
                } while (unsafe.getObjectVolatile(oj0Var, j2) == objectVolatile);
            }
            this = oj0Var;
        }
    }

    public final Runnable V() {
        oj0 oj0Var;
        Unsafe unsafe;
        while (true) {
            j.getClass();
            Unsafe unsafe2 = zj.a;
            long j2 = t;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            if (objectVolatile == null) {
                return null;
            }
            if (objectVolatile instanceof ue1) {
                ue1 ue1Var = (ue1) objectVolatile;
                Object objE = ue1Var.e();
                if (objE == ue1.g) {
                    ue1 ue1VarD = ue1Var.d();
                    while (true) {
                        Unsafe unsafe3 = zj.a;
                        oj0Var = this;
                        if (unsafe3.compareAndSwapObject(oj0Var, t, objectVolatile, ue1VarD) || unsafe3.getObjectVolatile(oj0Var, j2) != objectVolatile) {
                            break;
                        }
                        this = oj0Var;
                    }
                } else {
                    return (Runnable) objE;
                }
            } else {
                oj0Var = this;
                if (objectVolatile == dz3.b) {
                    return null;
                }
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(oj0Var, t, objectVolatile, (Object) null)) {
                        return (Runnable) objectVolatile;
                    }
                } while (unsafe.getObjectVolatile(oj0Var, j2) == objectVolatile);
            }
            this = oj0Var;
        }
    }

    public void W(Runnable runnable) {
        X();
        if (!Y(runnable)) {
            ha0.u.W(runnable);
            return;
        }
        Thread threadA0 = a0();
        if (Thread.currentThread() != threadA0) {
            LockSupport.unpark(threadA0);
        }
    }

    public final void X() {
        mj0 mj0VarB;
        k.getClass();
        nj0 nj0Var = (nj0) zj.a.getObjectVolatile(this, s);
        if (nj0Var == null || k03.b.get(nj0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (nj0Var) {
                try {
                    mj0[] mj0VarArr = nj0Var.a;
                    mj0VarB = null;
                    mj0 mj0Var = mj0VarArr != null ? mj0VarArr[0] : null;
                    if (mj0Var != null) {
                        mj0VarB = ((jNanoTime - mj0Var.a) > 0L ? 1 : ((jNanoTime - mj0Var.a) == 0L ? 0 : -1)) >= 0 ? Y(mj0Var) : false ? nj0Var.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (mj0VarB != null);
    }

    public final boolean Y(Runnable runnable) {
        Unsafe unsafe;
        Unsafe unsafe2;
        Unsafe unsafe3;
        while (true) {
            j.getClass();
            Unsafe unsafe4 = zj.a;
            long j2 = t;
            Object objectVolatile = unsafe4.getObjectVolatile(this, j2);
            if (n.get(this) == 1) {
                return false;
            }
            if (objectVolatile == null) {
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(this, t, (Object) null, runnable)) {
                        return true;
                    }
                } while (unsafe.getObjectVolatile(this, j2) == null);
            } else if (objectVolatile instanceof ue1) {
                ue1 ue1Var = (ue1) objectVolatile;
                int iA = ue1Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    ue1 ue1VarD = ue1Var.d();
                    do {
                        unsafe2 = zj.a;
                        if (unsafe2.compareAndSwapObject(this, t, objectVolatile, ue1VarD)) {
                            break;
                        }
                    } while (unsafe2.getObjectVolatile(this, j2) == objectVolatile);
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (objectVolatile == dz3.b) {
                    return false;
                }
                ue1 ue1Var2 = new ue1(8, true);
                ue1Var2.a((Runnable) objectVolatile);
                ue1Var2.a(runnable);
                do {
                    unsafe3 = zj.a;
                    if (unsafe3.compareAndSwapObject(this, t, objectVolatile, ue1Var2)) {
                        return true;
                    }
                } while (unsafe3.getObjectVolatile(this, j2) == objectVolatile);
            }
        }
    }

    public final long Z() {
        mj0 mj0Var;
        hg hgVar = this.f;
        if (((hgVar == null || hgVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
            j.getClass();
            Unsafe unsafe = zj.a;
            Object objectVolatile = unsafe.getObjectVolatile(this, t);
            if (objectVolatile != null) {
                if (objectVolatile instanceof ue1) {
                    long j2 = ue1.f.get((ue1) objectVolatile);
                    if (((int) (1073741823 & j2)) != ((int) ((j2 & 1152921503533105152L) >> 30))) {
                        return 0L;
                    }
                } else if (objectVolatile == dz3.b) {
                    return Long.MAX_VALUE;
                }
            }
            k.getClass();
            nj0 nj0Var = (nj0) unsafe.getObjectVolatile(this, s);
            if (nj0Var != null) {
                synchronized (nj0Var) {
                    mj0[] mj0VarArr = nj0Var.a;
                    mj0Var = mj0VarArr != null ? mj0VarArr[0] : null;
                }
                if (mj0Var != null) {
                    long jNanoTime = mj0Var.a - System.nanoTime();
                    if (jNanoTime >= 0) {
                        return jNanoTime;
                    }
                }
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public abstract Thread a0();

    public final boolean b0() {
        hg hgVar = this.f;
        if (hgVar != null ? hgVar.isEmpty() : true) {
            k.getClass();
            Unsafe unsafe = zj.a;
            nj0 nj0Var = (nj0) unsafe.getObjectVolatile(this, s);
            if (nj0Var != null && k03.b.get(nj0Var) != 0) {
                return false;
            }
            j.getClass();
            Object objectVolatile = unsafe.getObjectVolatile(this, t);
            if (objectVolatile != null) {
                if (objectVolatile instanceof ue1) {
                    long j2 = ue1.f.get((ue1) objectVolatile);
                    return ((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30));
                }
                if (objectVolatile == dz3.b) {
                }
            }
            return true;
        }
        return false;
    }

    public void c0(long j2, mj0 mj0Var) {
        ha0.u.f0(j2, mj0Var);
    }

    public final void d0() {
        mj0 mj0VarB;
        long jNanoTime = System.nanoTime();
        while (true) {
            k.getClass();
            nj0 nj0Var = (nj0) zj.a.getObjectVolatile(this, s);
            if (nj0Var == null) {
                return;
            }
            synchronized (nj0Var) {
                mj0VarB = k03.b.get(nj0Var) > 0 ? nj0Var.b(0) : null;
            }
            if (mj0VarB == null) {
                return;
            } else {
                c0(jNanoTime, mj0VarB);
            }
        }
    }

    public final void e0() {
        j.getClass();
        Unsafe unsafe = zj.a;
        unsafe.putObjectVolatile(this, t, (Object) null);
        k.getClass();
        unsafe.putObjectVolatile(this, s, (Object) null);
    }

    public final void f0(long j2, mj0 mj0Var) {
        Thread threadA0;
        int iG0 = g0(j2, mj0Var);
        if (iG0 == 0) {
            if (!h0(mj0Var) || Thread.currentThread() == (threadA0 = a0())) {
                return;
            }
            LockSupport.unpark(threadA0);
            return;
        }
        if (iG0 == 1) {
            c0(j2, mj0Var);
        } else {
            if (iG0 == 2) {
                return;
            }
            og.n("unexpected result");
        }
    }

    public final int g0(long j2, mj0 mj0Var) {
        oj0 oj0Var;
        Unsafe unsafe;
        if (n.get(this) == 1) {
            return 1;
        }
        k.getClass();
        Unsafe unsafe2 = zj.a;
        long j3 = s;
        nj0 nj0Var = (nj0) unsafe2.getObjectVolatile(this, j3);
        if (nj0Var == null) {
            nj0 nj0Var2 = new nj0();
            nj0Var2.c = j2;
            while (true) {
                unsafe = zj.a;
                oj0Var = this;
                if (unsafe.compareAndSwapObject(oj0Var, s, (Object) null, nj0Var2) || unsafe.getObjectVolatile(oj0Var, j3) != null) {
                    break;
                }
                this = oj0Var;
            }
            Object objectVolatile = unsafe.getObjectVolatile(oj0Var, j3);
            objectVolatile.getClass();
            nj0Var = (nj0) objectVolatile;
        } else {
            oj0Var = this;
        }
        return mj0Var.c(j2, nj0Var, oj0Var);
    }

    public final boolean h0(mj0 mj0Var) {
        k.getClass();
        nj0 nj0Var = (nj0) zj.a.getObjectVolatile(this, s);
        mj0 mj0Var2 = null;
        if (nj0Var != null) {
            synchronized (nj0Var) {
                mj0[] mj0VarArr = nj0Var.a;
                mj0Var2 = mj0VarArr != null ? mj0VarArr[0] : null;
            }
        }
        return mj0Var2 == mj0Var;
    }

    @Override // defpackage.vb0
    public final void o(long j2, yv yvVar) {
        long j3 = 0;
        if (j2 > 0) {
            j3 = j2 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j2;
        }
        if (j3 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            kj0 kj0Var = new kj0(this, j3 + jNanoTime, yvVar);
            f0(jNanoTime, kj0Var);
            yvVar.A(new rv(1, kj0Var));
        }
    }

    @Override // defpackage.jj0
    public void shutdown() {
        i03.a.set(null);
        n.set(this, 1);
        U();
        while (S() <= 0) {
        }
        d0();
    }
}
