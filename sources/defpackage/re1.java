package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class re1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(re1.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b;
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ long e;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long i;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Unsafe unsafe = zj.a;
        e = unsafe.objectFieldOffset(re1.class.getDeclaredField("_next$volatile"));
        b = AtomicReferenceFieldUpdater.newUpdater(re1.class, Object.class, "_prev$volatile");
        f = unsafe.objectFieldOffset(re1.class.getDeclaredField("_prev$volatile"));
        c = AtomicReferenceFieldUpdater.newUpdater(re1.class, Object.class, "_removedRef$volatile");
        i = unsafe.objectFieldOffset(re1.class.getDeclaredField("_removedRef$volatile"));
    }

    public static re1 h(re1 re1Var) {
        while (re1Var.m()) {
            b.getClass();
            re1Var = (re1) zj.a.getObjectVolatile(re1Var, f);
        }
        return re1Var;
    }

    public final boolean d(re1 re1Var, int i2) {
        re1 re1VarL;
        do {
            re1VarL = l();
            if (re1VarL instanceof rc1) {
                return (((rc1) re1VarL).j & i2) == 0 && re1VarL.d(re1Var, i2);
            }
        } while (!re1VarL.e(re1Var, this));
        return true;
    }

    public final boolean e(re1 re1Var, re1 re1Var2) {
        b.getClass();
        Unsafe unsafe = zj.a;
        unsafe.putObjectVolatile(re1Var, f, this);
        a.getClass();
        long j = e;
        unsafe.putObjectVolatile(re1Var, j, re1Var2);
        while (true) {
            Unsafe unsafe2 = zj.a;
            re1 re1Var3 = this;
            re1 re1Var4 = re1Var;
            re1 re1Var5 = re1Var2;
            if (unsafe2.compareAndSwapObject(re1Var3, e, re1Var5, re1Var4)) {
                re1Var4.i(re1Var5);
                return true;
            }
            if (unsafe2.getObjectVolatile(re1Var3, j) != re1Var5) {
                return false;
            }
            this = re1Var3;
            re1Var2 = re1Var5;
            re1Var = re1Var4;
        }
    }

    public final void f(eo1 eo1Var) {
        re1 re1Var;
        eo1 eo1Var2;
        b.getClass();
        Unsafe unsafe = zj.a;
        unsafe.putObjectVolatile(eo1Var, f, this);
        a.getClass();
        long j = e;
        unsafe.putObjectVolatile(eo1Var, j, this);
        while (this.j() == this) {
            while (true) {
                Unsafe unsafe2 = zj.a;
                re1Var = this;
                eo1Var2 = eo1Var;
                if (unsafe2.compareAndSwapObject(re1Var, e, this, eo1Var2)) {
                    eo1Var2.i(re1Var);
                    return;
                } else {
                    if (unsafe2.getObjectVolatile(re1Var, j) != re1Var) {
                        break;
                    }
                    this = re1Var;
                    eo1Var = eo1Var2;
                }
            }
            this = re1Var;
            eo1Var = eo1Var2;
        }
    }

    public final re1 g() {
        while (true) {
            b.getClass();
            Unsafe unsafe = zj.a;
            long j = f;
            re1 re1Var = (re1) unsafe.getObjectVolatile(this, j);
            re1 re1Var2 = null;
            re1 re1Var3 = re1Var;
            while (true) {
                a.getClass();
                if (re1Var3 == null) {
                    dk0.t();
                    return null;
                }
                Unsafe unsafe2 = zj.a;
                long j2 = e;
                Object objectVolatile = unsafe2.getObjectVolatile(re1Var3, j2);
                if (objectVolatile == this) {
                    if (re1Var != re1Var3) {
                        while (true) {
                            Unsafe unsafe3 = zj.a;
                            re1 re1Var4 = this;
                            boolean zCompareAndSwapObject = unsafe3.compareAndSwapObject(re1Var4, f, re1Var, re1Var3);
                            re1 re1Var5 = re1Var;
                            this = re1Var4;
                            if (!zCompareAndSwapObject) {
                                if (unsafe3.getObjectVolatile(this, j) != re1Var5) {
                                    break;
                                }
                                this = this;
                                re1Var = re1Var5;
                            }
                        }
                    }
                    return re1Var3;
                }
                re1Var = re1Var;
                this = this;
                if (this.m()) {
                    return null;
                }
                if (!(objectVolatile instanceof r52)) {
                    objectVolatile.getClass();
                    re1Var2 = re1Var3;
                    re1Var3 = (re1) objectVolatile;
                } else if (re1Var2 != null) {
                    re1 re1Var6 = ((r52) objectVolatile).a;
                    while (true) {
                        re1 re1Var7 = re1Var3;
                        Unsafe unsafe4 = zj.a;
                        boolean zCompareAndSwapObject2 = unsafe4.compareAndSwapObject(re1Var2, e, re1Var7, re1Var6);
                        re1Var3 = re1Var7;
                        if (zCompareAndSwapObject2) {
                            re1Var3 = re1Var2;
                            re1Var2 = null;
                            break;
                        }
                        if (unsafe4.getObjectVolatile(re1Var2, j2) != re1Var3) {
                            break;
                        }
                    }
                } else {
                    if (re1Var3 == null) {
                        dk0.t();
                        return null;
                    }
                    re1Var3 = (re1) unsafe2.getObjectVolatile(re1Var3, j);
                }
            }
            this = this;
        }
    }

    public final void i(re1 re1Var) {
        re1 re1Var2;
        while (true) {
            b.getClass();
            if (re1Var == null) {
                dk0.t();
                return;
            }
            Unsafe unsafe = zj.a;
            long j = f;
            re1 re1Var3 = (re1) unsafe.getObjectVolatile(re1Var, j);
            if (this.j() != re1Var) {
                return;
            }
            while (true) {
                if (re1Var == null) {
                    dk0.t();
                    return;
                }
                Unsafe unsafe2 = zj.a;
                re1Var2 = this;
                re1 re1Var4 = re1Var;
                if (unsafe2.compareAndSwapObject(re1Var4, f, re1Var3, re1Var2)) {
                    if (re1Var2.m()) {
                        re1Var4.g();
                        return;
                    }
                    return;
                } else {
                    if (re1Var4 == null) {
                        dk0.t();
                        return;
                    }
                    re1Var = re1Var4;
                    if (unsafe2.getObjectVolatile(re1Var4, j) != re1Var3) {
                        break;
                    } else {
                        this = re1Var2;
                    }
                }
            }
            this = re1Var2;
        }
    }

    public final Object j() {
        a.getClass();
        return zj.a.getObjectVolatile(this, e);
    }

    public final re1 k() {
        Object objJ = j();
        r52 r52Var = objJ instanceof r52 ? (r52) objJ : null;
        if (r52Var != null) {
            return r52Var.a;
        }
        objJ.getClass();
        return (re1) objJ;
    }

    public final re1 l() {
        re1 re1VarG = g();
        if (re1VarG != null) {
            return re1VarG;
        }
        b.getClass();
        return h((re1) zj.a.getObjectVolatile(this, f));
    }

    public boolean m() {
        return j() instanceof r52;
    }

    public final re1 n() {
        re1 re1Var;
        while (true) {
            Object objJ = this.j();
            if (objJ instanceof r52) {
                return ((r52) objJ).a;
            }
            if (objJ == this) {
                return (re1) objJ;
            }
            objJ.getClass();
            re1 re1Var2 = (re1) objJ;
            r52 r52VarO = re1Var2.o();
            while (true) {
                a.getClass();
                Unsafe unsafe = zj.a;
                long j = e;
                re1Var = this;
                if (unsafe.compareAndSwapObject(re1Var, j, objJ, r52VarO)) {
                    re1Var2.g();
                    return null;
                }
                if (unsafe.getObjectVolatile(re1Var, j) != objJ) {
                    break;
                }
                this = re1Var;
            }
            this = re1Var;
        }
    }

    public final r52 o() {
        c.getClass();
        Unsafe unsafe = zj.a;
        long j = i;
        r52 r52Var = (r52) unsafe.getObjectVolatile(this, j);
        if (r52Var != null) {
            return r52Var;
        }
        r52 r52Var2 = new r52(this);
        unsafe.putObjectVolatile(this, j, r52Var2);
        return r52Var2;
    }

    public String toString() {
        return new u91(1, 1, ba0.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + ba0.c(this);
    }
}
