package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class q30 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(q30.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b;
    public static final /* synthetic */ long c;
    public static final /* synthetic */ long e;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Unsafe unsafe = zj.a;
        c = unsafe.objectFieldOffset(q30.class.getDeclaredField("_next$volatile"));
        b = AtomicReferenceFieldUpdater.newUpdater(q30.class, Object.class, "_prev$volatile");
        e = unsafe.objectFieldOffset(q30.class.getDeclaredField("_prev$volatile"));
    }

    public q30(af2 af2Var) {
        this._prev$volatile = af2Var;
    }

    public final void a() {
        b.getClass();
        zj.a.putObjectVolatile(this, e, (Object) null);
    }

    public final q30 c() {
        q30 q30VarF = f();
        while (q30VarF != null && q30VarF.g()) {
            b.getClass();
            q30VarF = (q30) zj.a.getObjectVolatile(q30VarF, e);
        }
        return q30VarF;
    }

    public final q30 d() {
        Object objE = e();
        if (objE == my3.a) {
            return null;
        }
        return (q30) objE;
    }

    public final Object e() {
        a.getClass();
        return zj.a.getObjectVolatile(this, c);
    }

    public final q30 f() {
        b.getClass();
        return (q30) zj.a.getObjectVolatile(this, e);
    }

    public abstract boolean g();

    public final boolean h() {
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = c;
            q30 q30Var = this;
            if (unsafe.compareAndSwapObject(q30Var, j, (Object) null, my3.a)) {
                return true;
            }
            if (unsafe.getObjectVolatile(q30Var, j) != null) {
                return false;
            }
            this = q30Var;
        }
    }

    public final void i() {
        q30 q30Var;
        Unsafe unsafe;
        if (d() == null) {
            return;
        }
        while (true) {
            q30 q30VarC = c();
            q30 q30VarD = d();
            q30VarD.getClass();
            do {
                q30Var = q30VarD;
                if (!q30Var.g()) {
                    break;
                } else {
                    q30VarD = q30Var.d();
                }
            } while (q30VarD != null);
            while (true) {
                b.getClass();
                Unsafe unsafe2 = zj.a;
                long j = e;
                Object objectVolatile = unsafe2.getObjectVolatile(q30Var, j);
                q30 q30Var2 = ((q30) objectVolatile) == null ? null : q30VarC;
                while (true) {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(q30Var, e, objectVolatile, q30Var2)) {
                        break;
                    } else if (unsafe.getObjectVolatile(q30Var, j) != objectVolatile) {
                    }
                }
            }
            if (q30VarC != null) {
                a.getClass();
                unsafe.putObjectVolatile(q30VarC, c, q30Var);
            }
            if (!q30Var.g() || q30Var.d() == null) {
                if (q30VarC == null || !q30VarC.g()) {
                    return;
                }
            }
        }
    }

    public final boolean j(af2 af2Var) {
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = c;
            q30 q30Var = this;
            af2 af2Var2 = af2Var;
            if (unsafe.compareAndSwapObject(q30Var, j, (Object) null, af2Var2)) {
                return true;
            }
            if (unsafe.getObjectVolatile(q30Var, j) != null) {
                return false;
            }
            this = q30Var;
            af2Var = af2Var2;
        }
    }
}
