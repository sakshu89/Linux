package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class sg2 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(sg2.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d;
    public static final /* synthetic */ AtomicLongFieldUpdater e;
    public static final /* synthetic */ AtomicIntegerFieldUpdater f;
    public static final /* synthetic */ long g;
    public static final /* synthetic */ long h;
    private volatile /* synthetic */ int _availablePermits$volatile;
    public final xv a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        Unsafe unsafe = zj.a;
        g = unsafe.objectFieldOffset(sg2.class.getDeclaredField("head$volatile"));
        c = AtomicLongFieldUpdater.newUpdater(sg2.class, "deqIdx$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(sg2.class, Object.class, "tail$volatile");
        h = unsafe.objectFieldOffset(sg2.class.getDeclaredField("tail$volatile"));
        e = AtomicLongFieldUpdater.newUpdater(sg2.class, "enqIdx$volatile");
        f = AtomicIntegerFieldUpdater.newUpdater(sg2.class, "_availablePermits$volatile");
    }

    public sg2() {
        ug2 ug2Var = new ug2(0L, null, 2);
        this.head$volatile = ug2Var;
        this.tail$volatile = ug2Var;
        this._availablePermits$volatile = 1;
        this.a = new xv(5, this);
    }

    public final boolean a(zm1 zm1Var) {
        Object objB;
        Unsafe unsafe;
        sg2 sg2Var = this;
        d.getClass();
        Unsafe unsafe2 = zj.a;
        long j = h;
        ug2 ug2Var = (ug2) unsafe2.getObjectVolatile(sg2Var, j);
        long andIncrement = e.getAndIncrement(sg2Var);
        qg2 qg2Var = qg2.k;
        long j2 = andIncrement / ((long) tg2.f);
        loop0: while (true) {
            objB = my3.b(ug2Var, j2, qg2Var);
            if (m24.b(objB)) {
                break;
            }
            af2 af2VarA = m24.a(objB);
            while (true) {
                af2 af2Var = (af2) zj.a.getObjectVolatile(sg2Var, j);
                if (af2Var.f >= af2VarA.f) {
                    sg2Var = this;
                    break loop0;
                }
                if (!af2VarA.o()) {
                    break;
                }
                do {
                    unsafe = zj.a;
                    sg2Var = this;
                    if (unsafe.compareAndSwapObject(sg2Var, h, af2Var, af2VarA)) {
                        if (!af2Var.k()) {
                            break loop0;
                        }
                        af2Var.i();
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(sg2Var, j) == af2Var);
                if (af2VarA.k()) {
                    af2VarA.i();
                }
            }
            sg2Var = this;
        }
        ug2 ug2Var2 = (ug2) m24.a(objB);
        AtomicReferenceArray atomicReferenceArray = ug2Var2.j;
        int i = (int) (andIncrement % ((long) tg2.f));
        while (!atomicReferenceArray.compareAndSet(i, null, zm1Var)) {
            if (atomicReferenceArray.get(i) != null) {
                py0 py0Var = tg2.b;
                py0 py0Var2 = tg2.c;
                while (!atomicReferenceArray.compareAndSet(i, py0Var, py0Var2)) {
                    if (atomicReferenceArray.get(i) != py0Var) {
                        return false;
                    }
                }
                zm1Var.i(q43.a, sg2Var.a);
                return true;
            }
        }
        zm1Var.a(ug2Var2, i);
        return true;
    }

    public final void b() {
        int i;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            if (andIncrement >= 1) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= 1) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
                kf2.e("The number of released permits cannot be greater than 1");
                return;
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!c());
    }

    public final boolean c() {
        Object objB;
        Unsafe unsafe;
        b.getClass();
        Unsafe unsafe2 = zj.a;
        long j = g;
        ug2 ug2Var = (ug2) unsafe2.getObjectVolatile(this, j);
        long andIncrement = c.getAndIncrement(this);
        long j2 = andIncrement / ((long) tg2.f);
        rg2 rg2Var = rg2.k;
        loop0: while (true) {
            objB = my3.b(ug2Var, j2, rg2Var);
            if (m24.b(objB)) {
                break;
            }
            af2 af2VarA = m24.a(objB);
            while (true) {
                af2 af2Var = (af2) zj.a.getObjectVolatile(this, j);
                if (af2Var.f >= af2VarA.f) {
                    break loop0;
                }
                if (!af2VarA.o()) {
                    break;
                }
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(this, g, af2Var, af2VarA)) {
                        if (!af2Var.k()) {
                            break loop0;
                        }
                        af2Var.i();
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(this, j) == af2Var);
                if (af2VarA.k()) {
                    af2VarA.i();
                }
            }
        }
        ug2 ug2Var2 = (ug2) m24.a(objB);
        AtomicReferenceArray atomicReferenceArray = ug2Var2.j;
        ug2Var2.a();
        boolean z = false;
        if (ug2Var2.f <= j2) {
            int i = (int) (andIncrement % ((long) tg2.f));
            Object andSet = atomicReferenceArray.getAndSet(i, tg2.b);
            if (andSet == null) {
                int i2 = tg2.a;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (atomicReferenceArray.get(i) == tg2.c) {
                        return true;
                    }
                }
                py0 py0Var = tg2.b;
                py0 py0Var2 = tg2.d;
                while (!atomicReferenceArray.compareAndSet(i, py0Var, py0Var2)) {
                    if (atomicReferenceArray.get(i) != py0Var) {
                        return !z;
                    }
                }
                z = true;
                return !z;
            }
            if (andSet != tg2.e) {
                boolean z2 = andSet instanceof wv;
                q43 q43Var = q43.a;
                if (!z2) {
                    if (andSet instanceof gf2) {
                        return ((gf2) andSet).j(this, q43Var) == 0;
                    }
                    og.h(andSet, "unexpected: ");
                    return false;
                }
                wv wvVar = (wv) andSet;
                py0 py0VarK = wvVar.k(q43Var, this.a);
                if (py0VarK != null) {
                    wvVar.u(py0VarK);
                    return true;
                }
            }
        }
        return false;
    }
}
