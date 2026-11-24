package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mc3 {
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(mc3.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ long f = zj.a.objectFieldOffset(mc3.class.getDeclaredField("lastScheduledTask$volatile"));
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(mc3.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(mc3.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(mc3.class, "blockingTasksInBuffer$volatile");

    public final hw2 a(hw2 hw2Var, boolean z) {
        if (z) {
            return b(hw2Var);
        }
        b.getClass();
        hw2 hw2Var2 = (hw2) zj.a.getAndSetObject(this, f, hw2Var);
        if (hw2Var2 == null) {
            return null;
        }
        return b(hw2Var2);
    }

    public final hw2 b(hw2 hw2Var) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
        if (atomicIntegerFieldUpdater.get(this) - d.get(this) == 127) {
            return hw2Var;
        }
        if (hw2Var.b) {
            e.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            if (atomicReferenceArray.get(i) == null) {
                atomicReferenceArray.lazySet(i, hw2Var);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final int c() {
        b.getClass();
        Object objectVolatile = zj.a.getObjectVolatile(this, f);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = c;
        return objectVolatile != null ? (atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this)) + 1 : atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this);
    }

    public final void d(eu0 eu0Var) {
        b.getClass();
        hw2 hw2Var = (hw2) zj.a.getAndSetObject(this, f, (Object) null);
        if (hw2Var != null) {
            eu0Var.a(hw2Var);
        }
        while (true) {
            hw2 hw2VarF = f();
            if (hw2VarF == null) {
                return;
            } else {
                eu0Var.a(hw2VarF);
            }
        }
    }

    public final hw2 e() {
        b.getClass();
        hw2 hw2Var = (hw2) zj.a.getAndSetObject(this, f, (Object) null);
        return hw2Var == null ? f() : hw2Var;
    }

    public final hw2 f() {
        hw2 hw2Var;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (hw2Var = (hw2) this.a.getAndSet(i2, null)) != null) {
                if (hw2Var.b) {
                    e.decrementAndGet(this);
                }
                return hw2Var;
            }
        }
    }

    public final hw2 g() {
        mc3 mc3Var;
        while (true) {
            b.getClass();
            Unsafe unsafe = zj.a;
            long j = f;
            hw2 hw2Var = (hw2) unsafe.getObjectVolatile(this, j);
            if (hw2Var == null || !hw2Var.b) {
                break;
            }
            while (true) {
                Unsafe unsafe2 = zj.a;
                mc3Var = this;
                if (unsafe2.compareAndSwapObject(mc3Var, f, hw2Var, (Object) null)) {
                    return hw2Var;
                }
                if (unsafe2.getObjectVolatile(mc3Var, j) != hw2Var) {
                    break;
                }
                this = mc3Var;
            }
            this = mc3Var;
        }
        mc3 mc3Var2 = this;
        int i = d.get(mc3Var2);
        int i2 = c.get(mc3Var2);
        while (i != i2 && e.get(mc3Var2) != 0) {
            i2--;
            hw2 hw2VarH = mc3Var2.h(i2, true);
            if (hw2VarH != null) {
                return hw2VarH;
            }
        }
        return null;
    }

    public final hw2 h(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.a;
        hw2 hw2Var = (hw2) atomicReferenceArray.get(i2);
        if (hw2Var != null && hw2Var.b == z) {
            while (!atomicReferenceArray.compareAndSet(i2, hw2Var, null)) {
                if (atomicReferenceArray.get(i2) != hw2Var) {
                }
            }
            if (z) {
                e.decrementAndGet(this);
            }
            return hw2Var;
        }
        return null;
    }

    public final long i(int i, t42 t42Var) {
        mc3 mc3Var;
        while (true) {
            b.getClass();
            Unsafe unsafe = zj.a;
            long j = f;
            hw2 hw2Var = (hw2) unsafe.getObjectVolatile(this, j);
            if (hw2Var == null) {
                return -2L;
            }
            if (((hw2Var.b ? 1 : 2) & i) == 0) {
                return -2L;
            }
            nw2.f.getClass();
            long jNanoTime = System.nanoTime() - hw2Var.a;
            long j2 = nw2.b;
            if (jNanoTime < j2) {
                return j2 - jNanoTime;
            }
            while (true) {
                Unsafe unsafe2 = zj.a;
                mc3Var = this;
                if (unsafe2.compareAndSwapObject(mc3Var, f, hw2Var, (Object) null)) {
                    t42Var.a = hw2Var;
                    return -1L;
                }
                if (unsafe2.getObjectVolatile(mc3Var, j) != hw2Var) {
                    break;
                }
                this = mc3Var;
            }
            this = mc3Var;
        }
    }
}
