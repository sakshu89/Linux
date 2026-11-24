package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class an1 extends sg2 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(an1.class, Object.class, "owner$volatile");
    public static final /* synthetic */ long j = zj.a.objectFieldOffset(an1.class.getDeclaredField("owner$volatile"));
    private volatile /* synthetic */ Object owner$volatile = q24.a;

    public final boolean d() {
        return Math.max(sg2.f.get(this), 0) == 0;
    }

    public final Object e(x50 x50Var) {
        boolean zF = f();
        q43 q43Var = q43.a;
        if (!zF) {
            yv yvVarA = zg4.a(fp4.b(x50Var));
            try {
                zm1 zm1Var = new zm1(this, yvVarA);
                while (true) {
                    int andDecrement = sg2.f.getAndDecrement(this);
                    if (andDecrement <= 1) {
                        if (andDecrement > 0) {
                            zm1Var.i(q43Var, this.a);
                            break;
                        }
                        if (a(zm1Var)) {
                            break;
                        }
                    }
                }
                Object objV = yvVarA.v();
                t70 t70Var = t70.a;
                if (objV != t70Var) {
                    objV = q43Var;
                }
                if (objV == t70Var) {
                    return objV;
                }
            } catch (Throwable th) {
                yvVarA.E();
                throw th;
            }
        }
        return q43Var;
    }

    public final boolean f() {
        int iG = g();
        if (iG == 0) {
            return true;
        }
        if (iG == 1) {
            return false;
        }
        if (iG != 2) {
            og.n("unexpected");
            return false;
        }
        kf2.e("This mutex is already locked by the specified owner: null");
        return false;
    }

    public final int g() {
        int i2;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = sg2.f;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 > 1) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 <= 1) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1));
            } else {
                if (i3 <= 0) {
                    return 1;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    i.getClass();
                    zj.a.putObjectVolatile(this, j, (Object) null);
                    return 0;
                }
            }
        }
    }

    public final void h(Object obj) {
        while (this.d()) {
            i.getClass();
            Unsafe unsafe = zj.a;
            long j2 = j;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            py0 py0Var = q24.a;
            if (objectVolatile != py0Var) {
                if (objectVolatile != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + objectVolatile + ", but " + obj + " is expected").toString());
                }
                while (true) {
                    Unsafe unsafe2 = zj.a;
                    an1 an1Var = this;
                    if (unsafe2.compareAndSwapObject(an1Var, j, objectVolatile, py0Var)) {
                        an1Var.b();
                        return;
                    } else {
                        if (unsafe2.getObjectVolatile(an1Var, j2) != objectVolatile) {
                            this = an1Var;
                            break;
                        }
                        this = an1Var;
                    }
                }
            }
        }
        og.n("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(ba0.c(this));
        sb.append("[isLocked=");
        sb.append(d());
        sb.append(",owner=");
        i.getClass();
        sb.append(zj.a.getObjectVolatile(this, j));
        sb.append(']');
        return sb.toString();
    }
}
