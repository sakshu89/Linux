package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hd0 extends jd0 implements u70, x50 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(hd0.class, Object.class, "_reusableCancellableContinuation$volatile");
    public static final /* synthetic */ long n = zj.a.objectFieldOffset(hd0.class.getDeclaredField("_reusableCancellableContinuation$volatile"));
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final l70 e;
    public final y50 f;
    public Object i;
    public final Object j;

    public hd0(l70 l70Var, y50 y50Var) {
        super(-1);
        this.e = l70Var;
        this.f = y50Var;
        this.i = ry3.a;
        this.j = ab4.d(y50Var.f());
    }

    @Override // defpackage.u70
    public final u70 d() {
        return this.f;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.f.f();
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        Throwable thA = i72.a(obj);
        Object a10Var = thA == null ? obj : new a10(thA, false);
        y50 y50Var = this.f;
        j70 j70VarF = y50Var.f();
        l70 l70Var = this.e;
        if (ry3.d(l70Var, j70VarF)) {
            this.i = a10Var;
            this.c = 0;
            ry3.c(l70Var, y50Var.f(), this);
            return;
        }
        jj0 jj0VarA = i03.a();
        if (jj0VarA.c >= 4294967296L) {
            this.i = a10Var;
            this.c = 0;
            jj0VarA.Q(this);
            return;
        }
        jj0VarA.R(true);
        try {
            j70 j70VarF2 = y50Var.f();
            Object objE = ab4.e(j70VarF2, this.j);
            try {
                y50Var.h(obj);
                ab4.a(j70VarF2, objE);
                while (jj0VarA.T()) {
                }
            } catch (Throwable th) {
                ab4.a(j70VarF2, objE);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                j(th2);
            } finally {
                jj0VarA.P(true);
            }
        }
    }

    @Override // defpackage.jd0
    public final Object l() {
        Object obj = this.i;
        this.i = ry3.a;
        return obj;
    }

    public final void n() {
        do {
            k.getClass();
        } while (zj.a.getObjectVolatile(this, n) == ry3.b);
    }

    public final yv o() {
        hd0 hd0Var;
        while (true) {
            k.getClass();
            Unsafe unsafe = zj.a;
            long j = n;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            py0 py0Var = ry3.b;
            if (objectVolatile == null) {
                unsafe.putObjectVolatile(this, j, py0Var);
                return null;
            }
            if (objectVolatile instanceof yv) {
                while (true) {
                    Unsafe unsafe2 = zj.a;
                    hd0Var = this;
                    if (unsafe2.compareAndSwapObject(hd0Var, n, objectVolatile, py0Var)) {
                        return (yv) objectVolatile;
                    }
                    if (unsafe2.getObjectVolatile(hd0Var, j) != objectVolatile) {
                        break;
                    }
                    this = hd0Var;
                }
            } else {
                hd0Var = this;
                if (objectVolatile != py0Var && !(objectVolatile instanceof Throwable)) {
                    og.h(objectVolatile, "Inconsistent state ");
                    return null;
                }
            }
            this = hd0Var;
        }
    }

    public final yv p() {
        k.getClass();
        Object objectVolatile = zj.a.getObjectVolatile(this, n);
        if (objectVolatile instanceof yv) {
            return (yv) objectVolatile;
        }
        return null;
    }

    public final boolean q() {
        k.getClass();
        return zj.a.getObjectVolatile(this, n) != null;
    }

    public final boolean r(Throwable th) {
        hd0 hd0Var;
        Throwable th2;
        Unsafe unsafe;
        while (true) {
            k.getClass();
            Unsafe unsafe2 = zj.a;
            long j = n;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j);
            py0 py0Var = ry3.b;
            if (g31.a(objectVolatile, py0Var)) {
                while (true) {
                    Unsafe unsafe3 = zj.a;
                    hd0 hd0Var2 = this;
                    th2 = th;
                    hd0Var = hd0Var2;
                    if (unsafe3.compareAndSwapObject(hd0Var2, n, py0Var, th2)) {
                        return true;
                    }
                    if (unsafe3.getObjectVolatile(hd0Var, j) != py0Var) {
                        break;
                    }
                    this = hd0Var;
                    th = th2;
                }
            } else {
                hd0Var = this;
                th2 = th;
                if (objectVolatile instanceof Throwable) {
                    return true;
                }
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(hd0Var, n, objectVolatile, (Object) null)) {
                        return false;
                    }
                } while (unsafe.getObjectVolatile(hd0Var, j) == objectVolatile);
            }
            this = hd0Var;
            th = th2;
        }
    }

    public final Throwable s(yv yvVar) {
        Unsafe unsafe;
        hd0 hd0Var;
        yv yvVar2;
        while (true) {
            k.getClass();
            Unsafe unsafe2 = zj.a;
            long j = n;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j);
            py0 py0Var = ry3.b;
            if (objectVolatile != py0Var) {
                hd0 hd0Var2 = this;
                if (!(objectVolatile instanceof Throwable)) {
                    og.h(objectVolatile, "Inconsistent state ");
                    return null;
                }
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(hd0Var2, n, objectVolatile, (Object) null)) {
                        return (Throwable) objectVolatile;
                    }
                } while (unsafe.getObjectVolatile(hd0Var2, j) == objectVolatile);
                og.i("Failed requirement.");
                return null;
            }
            while (true) {
                Unsafe unsafe3 = zj.a;
                hd0Var = this;
                yvVar2 = yvVar;
                if (unsafe3.compareAndSwapObject(hd0Var, n, py0Var, yvVar2)) {
                    return null;
                }
                if (unsafe3.getObjectVolatile(hd0Var, j) != py0Var) {
                    break;
                }
                this = hd0Var;
                yvVar = yvVar2;
            }
            this = hd0Var;
            yvVar = yvVar2;
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.e + ", " + ba0.d(this.f) + ']';
    }

    @Override // defpackage.jd0
    public final x50 c() {
        return this;
    }
}
