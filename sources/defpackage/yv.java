package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class yv extends jd0 implements wv, u70, j93 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(yv.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(yv.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    public static final /* synthetic */ long n;
    public static final /* synthetic */ long s;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final x50 e;
    public final j70 f;

    static {
        Unsafe unsafe = zj.a;
        s = unsafe.objectFieldOffset(yv.class.getDeclaredField("_state$volatile"));
        k = AtomicReferenceFieldUpdater.newUpdater(yv.class, Object.class, "_parentHandle$volatile");
        n = unsafe.objectFieldOffset(yv.class.getDeclaredField("_parentHandle$volatile"));
    }

    public yv(int i2, x50 x50Var) {
        super(i2);
        this.e = x50Var;
        this.f = x50Var.f();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = x3.a;
    }

    public static void C(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object I(mo1 mo1Var, Object obj, int i2, wq0 wq0Var) {
        if (obj instanceof a10) {
            return obj;
        }
        if (i2 != 1 && i2 != 2) {
            return obj;
        }
        if (wq0Var != null || (mo1Var instanceof sv)) {
            return new y00(obj, mo1Var instanceof sv ? (sv) mo1Var : null, wq0Var, (Throwable) null, 16);
        }
        return obj;
    }

    public final void A(mo1 mo1Var) {
        yv yvVar;
        Unsafe unsafe;
        yv yvVar2;
        while (true) {
            j.getClass();
            Unsafe unsafe2 = zj.a;
            long j2 = s;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            if (objectVolatile instanceof x3) {
                while (true) {
                    Unsafe unsafe3 = zj.a;
                    yvVar = this;
                    if (unsafe3.compareAndSwapObject(yvVar, s, objectVolatile, mo1Var)) {
                        return;
                    }
                    if (unsafe3.getObjectVolatile(yvVar, j2) != objectVolatile) {
                        break;
                    } else {
                        this = yvVar;
                    }
                }
            } else {
                yvVar = this;
                if ((objectVolatile instanceof sv) || (objectVolatile instanceof af2)) {
                    C(mo1Var, objectVolatile);
                    throw null;
                }
                if (objectVolatile instanceof a10) {
                    a10 a10Var = (a10) objectVolatile;
                    if (!a10.b.compareAndSet(a10Var, 0, 1)) {
                        C(mo1Var, objectVolatile);
                        throw null;
                    }
                    if (objectVolatile instanceof aw) {
                        Throwable th = a10Var.a;
                        if (mo1Var instanceof sv) {
                            yvVar.n((sv) mo1Var, th);
                            return;
                        } else {
                            mo1Var.getClass();
                            yvVar.p((af2) mo1Var, th);
                            return;
                        }
                    }
                    return;
                }
                if (objectVolatile instanceof y00) {
                    y00 y00Var = (y00) objectVolatile;
                    if (y00Var.b != null) {
                        C(mo1Var, objectVolatile);
                        throw null;
                    }
                    if (mo1Var instanceof af2) {
                        return;
                    }
                    mo1Var.getClass();
                    sv svVar = (sv) mo1Var;
                    Throwable th2 = y00Var.e;
                    if (th2 != null) {
                        yvVar.n(svVar, th2);
                        return;
                    }
                    y00 y00VarA = y00.a(y00Var, svVar, null, 29);
                    do {
                        unsafe = zj.a;
                        yvVar2 = yvVar;
                        if (unsafe.compareAndSwapObject(yvVar, s, objectVolatile, y00VarA)) {
                            return;
                        } else {
                            yvVar = yvVar2;
                        }
                    } while (unsafe.getObjectVolatile(yvVar2, j2) == objectVolatile);
                } else {
                    yv yvVar3 = yvVar;
                    if (mo1Var instanceof af2) {
                        return;
                    }
                    mo1Var.getClass();
                    y00 y00Var2 = new y00(objectVolatile, (sv) mo1Var, (wq0) null, (Throwable) null, 28);
                    while (true) {
                        y00 y00Var3 = y00Var2;
                        Unsafe unsafe4 = zj.a;
                        yvVar = yvVar3;
                        boolean zCompareAndSwapObject = unsafe4.compareAndSwapObject(yvVar, s, objectVolatile, y00Var3);
                        y00Var2 = y00Var3;
                        if (zCompareAndSwapObject) {
                            return;
                        }
                        if (unsafe4.getObjectVolatile(yvVar, j2) != objectVolatile) {
                            break;
                        } else {
                            yvVar3 = yvVar;
                        }
                    }
                }
            }
            this = yvVar;
        }
    }

    public final boolean B() {
        return this.c == 2 && ((hd0) this.e).q();
    }

    public String D() {
        return "CancellableContinuation";
    }

    public final void E() {
        Throwable thS;
        x50 x50Var = this.e;
        hd0 hd0Var = x50Var instanceof hd0 ? (hd0) x50Var : null;
        if (hd0Var == null || (thS = hd0Var.s(this)) == null) {
            return;
        }
        q();
        m(thS);
    }

    public final boolean F() {
        j.getClass();
        Unsafe unsafe = zj.a;
        long j2 = s;
        Object objectVolatile = unsafe.getObjectVolatile(this, j2);
        if ((objectVolatile instanceof y00) && ((y00) objectVolatile).d != null) {
            q();
            return false;
        }
        i.set(this, 536870911);
        unsafe.putObjectVolatile(this, j2, x3.a);
        return true;
    }

    public final void G(Object obj, int i2, wq0 wq0Var) {
        yv yvVar;
        while (true) {
            j.getClass();
            Unsafe unsafe = zj.a;
            long j2 = s;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            if (!(objectVolatile instanceof mo1)) {
                yv yvVar2 = this;
                if (objectVolatile instanceof aw) {
                    aw awVar = (aw) objectVolatile;
                    if (aw.c.compareAndSet(awVar, 0, 1)) {
                        if (wq0Var != null) {
                            yvVar2.o(wq0Var, awVar.a, obj);
                            return;
                        }
                        return;
                    }
                }
                og.h(obj, "Already resumed, but proposed with update ");
                return;
            }
            Object objI = I((mo1) objectVolatile, obj, i2, wq0Var);
            while (true) {
                Unsafe unsafe2 = zj.a;
                yvVar = this;
                if (unsafe2.compareAndSwapObject(yvVar, s, objectVolatile, objI)) {
                    if (!yvVar.B()) {
                        yvVar.q();
                    }
                    yvVar.r(i2);
                    return;
                } else if (unsafe2.getObjectVolatile(yvVar, j2) != objectVolatile) {
                    break;
                } else {
                    this = yvVar;
                }
            }
            this = yvVar;
        }
    }

    public final void H(l70 l70Var) {
        x50 x50Var = this.e;
        hd0 hd0Var = x50Var instanceof hd0 ? (hd0) x50Var : null;
        G(q43.a, (hd0Var != null ? hd0Var.e : null) == l70Var ? 4 : this.c, null);
    }

    public final py0 J(Object obj, wq0 wq0Var) {
        yv yvVar;
        while (true) {
            j.getClass();
            Unsafe unsafe = zj.a;
            long j2 = s;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            if (!(objectVolatile instanceof mo1)) {
                return null;
            }
            Object objI = I((mo1) objectVolatile, obj, this.c, wq0Var);
            while (true) {
                Unsafe unsafe2 = zj.a;
                yvVar = this;
                if (unsafe2.compareAndSwapObject(yvVar, s, objectVolatile, objI)) {
                    boolean zB = yvVar.B();
                    py0 py0Var = h33.a;
                    if (!zB) {
                        yvVar.q();
                    }
                    return py0Var;
                }
                if (unsafe2.getObjectVolatile(yvVar, j2) != objectVolatile) {
                    break;
                }
                this = yvVar;
            }
            this = yvVar;
        }
    }

    @Override // defpackage.j93
    public final void a(af2 af2Var, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = i;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                og.n("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        A(af2Var);
    }

    @Override // defpackage.jd0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        yv yvVar;
        while (true) {
            j.getClass();
            Unsafe unsafe = zj.a;
            long j2 = s;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            if (objectVolatile instanceof mo1) {
                og.n("Not completed");
                return;
            }
            if (objectVolatile instanceof a10) {
                return;
            }
            if (objectVolatile instanceof y00) {
                y00 y00Var = (y00) objectVolatile;
                if (y00Var.e != null) {
                    og.n("Must be called at most once");
                    return;
                }
                y00 y00VarA = y00.a(y00Var, null, cancellationException, 15);
                while (true) {
                    Unsafe unsafe2 = zj.a;
                    yv yvVar2 = this;
                    if (unsafe2.compareAndSwapObject(yvVar2, s, objectVolatile, y00VarA)) {
                        sv svVar = y00Var.b;
                        if (svVar != null) {
                            yvVar2.n(svVar, cancellationException);
                        }
                        wq0 wq0Var = y00Var.c;
                        if (wq0Var != null) {
                            yvVar2.o(wq0Var, cancellationException, y00Var.a);
                            return;
                        }
                        return;
                    }
                    if (unsafe2.getObjectVolatile(yvVar2, j2) != objectVolatile) {
                        cancellationException2 = cancellationException;
                        yvVar = yvVar2;
                        break;
                    }
                    this = yvVar2;
                }
            } else {
                yv yvVar3 = this;
                CancellationException cancellationException3 = cancellationException;
                y00 y00Var2 = new y00(objectVolatile, (sv) null, (wq0) null, cancellationException3, 14);
                cancellationException2 = cancellationException3;
                while (true) {
                    y00 y00Var3 = y00Var2;
                    Unsafe unsafe3 = zj.a;
                    yvVar = yvVar3;
                    boolean zCompareAndSwapObject = unsafe3.compareAndSwapObject(yvVar, s, objectVolatile, y00Var3);
                    y00Var2 = y00Var3;
                    if (zCompareAndSwapObject) {
                        return;
                    }
                    if (unsafe3.getObjectVolatile(yvVar, j2) != objectVolatile) {
                        break;
                    } else {
                        yvVar3 = yvVar;
                    }
                }
            }
            cancellationException = cancellationException2;
            this = yvVar;
        }
    }

    @Override // defpackage.jd0
    public final x50 c() {
        return this.e;
    }

    @Override // defpackage.u70
    public final u70 d() {
        x50 x50Var = this.e;
        if (x50Var instanceof u70) {
            return (u70) x50Var;
        }
        return null;
    }

    @Override // defpackage.jd0
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.f;
    }

    @Override // defpackage.jd0
    public final Object g(Object obj) {
        return obj instanceof y00 ? ((y00) obj).a : obj;
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        Throwable thA = i72.a(obj);
        if (thA != null) {
            obj = new a10(thA, false);
        }
        G(obj, this.c, null);
    }

    @Override // defpackage.wv
    public final void i(Object obj, wq0 wq0Var) {
        G(obj, this.c, wq0Var);
    }

    @Override // defpackage.wv
    public final py0 k(Object obj, wq0 wq0Var) {
        return J(obj, wq0Var);
    }

    @Override // defpackage.jd0
    public final Object l() {
        return w();
    }

    @Override // defpackage.wv
    public final boolean m(Throwable th) {
        Throwable cancellationException;
        yv yvVar;
        while (true) {
            j.getClass();
            Unsafe unsafe = zj.a;
            long j2 = s;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            if (!(objectVolatile instanceof mo1)) {
                return false;
            }
            boolean z = (objectVolatile instanceof sv) || (objectVolatile instanceof af2);
            if (th == null) {
                cancellationException = new CancellationException("Continuation " + this + " was cancelled normally");
            } else {
                cancellationException = th;
            }
            aw awVar = new aw(cancellationException, z);
            while (true) {
                Unsafe unsafe2 = zj.a;
                yvVar = this;
                if (unsafe2.compareAndSwapObject(yvVar, s, objectVolatile, awVar)) {
                    mo1 mo1Var = (mo1) objectVolatile;
                    if (mo1Var instanceof sv) {
                        yvVar.n((sv) objectVolatile, th);
                    } else if (mo1Var instanceof af2) {
                        yvVar.p((af2) objectVolatile, th);
                    }
                    if (!yvVar.B()) {
                        yvVar.q();
                    }
                    yvVar.r(yvVar.c);
                    return true;
                }
                if (unsafe2.getObjectVolatile(yvVar, j2) != objectVolatile) {
                    break;
                }
                this = yvVar;
            }
            this = yvVar;
        }
    }

    public final void n(sv svVar, Throwable th) {
        try {
            svVar.b(th);
        } catch (Throwable th2) {
            sl4.a(this.f, new b10("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(wq0 wq0Var, Throwable th, Object obj) {
        j70 j70Var = this.f;
        try {
            wq0Var.c(th, obj, j70Var);
        } catch (Throwable th2) {
            sl4.a(j70Var, new b10("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void p(af2 af2Var, Throwable th) {
        j70 j70Var = this.f;
        int i2 = i.get(this) & 536870911;
        if (i2 == 536870911) {
            og.n("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            af2Var.m(i2, j70Var);
        } catch (Throwable th2) {
            sl4.a(j70Var, new b10("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void q() {
        rd0 rd0VarT = t();
        if (rd0VarT == null) {
            return;
        }
        rd0VarT.a();
        k.getClass();
        zj.a.putObjectVolatile(this, n, jo1.a);
    }

    public final void r(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = i;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 != 1) {
                    og.n("Already resumed");
                    return;
                }
                boolean z = i2 == 4;
                x50 x50Var = this.e;
                if (!z && (x50Var instanceof hd0)) {
                    boolean z2 = i2 == 1 || i2 == 2;
                    int i5 = this.c;
                    if (z2 == (i5 == 1 || i5 == 2)) {
                        hd0 hd0Var = (hd0) x50Var;
                        l70 l70Var = hd0Var.e;
                        j70 j70VarF = hd0Var.f.f();
                        if (ry3.d(l70Var, j70VarF)) {
                            ry3.c(l70Var, j70VarF, this);
                            return;
                        }
                        jj0 jj0VarA = i03.a();
                        if (jj0VarA.c >= 4294967296L) {
                            jj0VarA.Q(this);
                            return;
                        }
                        jj0VarA.R(true);
                        try {
                            gm4.a(this, x50Var, true);
                            do {
                            } while (jj0VarA.T());
                        } catch (Throwable th) {
                            try {
                                j(th);
                            } finally {
                                jj0VarA.P(true);
                            }
                        }
                        return;
                    }
                }
                gm4.a(this, x50Var, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable s(p41 p41Var) {
        return p41Var.x();
    }

    public final rd0 t() {
        k.getClass();
        return (rd0) zj.a.getObjectVolatile(this, n);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(D());
        sb.append('(');
        sb.append(ba0.d(this.e));
        sb.append("){");
        Object objW = w();
        if (objW instanceof mo1) {
            str = "Active";
        } else {
            str = objW instanceof aw ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(ba0.c(this));
        return sb.toString();
    }

    @Override // defpackage.wv
    public final void u(Object obj) {
        r(this.c);
    }

    public final Object v() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        f41 f41Var;
        boolean zB = B();
        do {
            atomicIntegerFieldUpdater = i;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    og.n("Already suspended");
                    return null;
                }
                if (zB) {
                    E();
                }
                Object objW = w();
                if (objW instanceof a10) {
                    throw ((a10) objW).a;
                }
                int i4 = this.c;
                if ((i4 != 1 && i4 != 2) || (f41Var = (f41) this.f.v(nr4.k)) == null || f41Var.c()) {
                    return g(objW);
                }
                CancellationException cancellationExceptionX = f41Var.x();
                b(cancellationExceptionX);
                throw cancellationExceptionX;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (t() == null) {
            y();
        }
        if (zB) {
            E();
        }
        return t70.a;
    }

    public final Object w() {
        j.getClass();
        return zj.a.getObjectVolatile(this, s);
    }

    public final void x() {
        rd0 rd0VarY = y();
        if (rd0VarY == null || (w() instanceof mo1)) {
            return;
        }
        rd0VarY.a();
        k.getClass();
        zj.a.putObjectVolatile(this, n, jo1.a);
    }

    public final rd0 y() {
        f41 f41Var = (f41) this.f.v(nr4.k);
        if (f41Var == null) {
            return null;
        }
        rd0 rd0VarD = hp4.d(f41Var, true, new rx(this));
        while (true) {
            k.getClass();
            Unsafe unsafe = zj.a;
            long j2 = n;
            yv yvVar = this;
            if (unsafe.compareAndSwapObject(yvVar, j2, (Object) null, rd0VarD) || unsafe.getObjectVolatile(yvVar, j2) != null) {
                break;
            }
            this = yvVar;
        }
        return rd0VarD;
    }

    public final void z(hq0 hq0Var) {
        A(new rv(0, hq0Var));
    }
}
