package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class un implements bx {
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(un.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(un.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(un.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(un.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(un.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater j;
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    public static final /* synthetic */ AtomicReferenceFieldUpdater n;
    public static final /* synthetic */ AtomicReferenceFieldUpdater s;
    public static final /* synthetic */ long t;
    public static final /* synthetic */ long u;
    public static final /* synthetic */ long v;
    public static final /* synthetic */ long w;
    public static final /* synthetic */ long x;
    private volatile /* synthetic */ Object _closeCause$volatile;
    public final int a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    static {
        Unsafe unsafe = zj.a;
        x = unsafe.objectFieldOffset(un.class.getDeclaredField("sendSegment$volatile"));
        j = AtomicReferenceFieldUpdater.newUpdater(un.class, Object.class, "receiveSegment$volatile");
        w = unsafe.objectFieldOffset(un.class.getDeclaredField("receiveSegment$volatile"));
        k = AtomicReferenceFieldUpdater.newUpdater(un.class, Object.class, "bufferEndSegment$volatile");
        u = unsafe.objectFieldOffset(un.class.getDeclaredField("bufferEndSegment$volatile"));
        n = AtomicReferenceFieldUpdater.newUpdater(un.class, Object.class, "_closeCause$volatile");
        t = unsafe.objectFieldOffset(un.class.getDeclaredField("_closeCause$volatile"));
        s = AtomicReferenceFieldUpdater.newUpdater(un.class, Object.class, "closeHandler$volatile");
        v = unsafe.objectFieldOffset(un.class.getDeclaredField("closeHandler$volatile"));
    }

    public un(int i2) {
        this.a = i2;
        if (i2 < 0) {
            og.g(cq.h("Invalid channel capacity: ", i2, ", should be >=0"));
            throw null;
        }
        nx nxVar = wn.a;
        this.bufferEnd$volatile = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = e.get(this);
        nx nxVar2 = new nx(0L, null, this, 3);
        this.sendSegment$volatile = nxVar2;
        this.receiveSegment$volatile = nxVar2;
        if (F()) {
            nxVar2 = wn.a;
            nxVar2.getClass();
        }
        this.bufferEndSegment$volatile = nxVar2;
        this._closeCause$volatile = wn.s;
    }

    public static Object I(un unVar, nu2 nu2Var) throws Throwable {
        nx nxVar;
        Throwable th;
        nx nxVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.getClass();
        if (unVar == null) {
            dk0.t();
            return null;
        }
        nx nxVar3 = (nx) zj.a.getObjectVolatile(unVar, w);
        while (!unVar.C()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(unVar);
            long j2 = wn.b;
            long j3 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (nxVar3.f != j3) {
                nx nxVarQ = unVar.q(j3, nxVar3);
                if (nxVarQ == null) {
                    continue;
                } else {
                    nxVar = nxVarQ;
                }
            } else {
                nxVar = nxVar3;
            }
            un unVar2 = unVar;
            Object objR = unVar2.R(nxVar, i2, andIncrement, null);
            py0 py0Var = wn.m;
            if (objR == py0Var) {
                og.n("unexpected");
                return null;
            }
            py0 py0Var2 = wn.o;
            if (objR == py0Var2) {
                if (andIncrement < unVar2.w()) {
                    nxVar.a();
                }
                unVar = unVar2;
                nxVar3 = nxVar;
            } else {
                if (objR != wn.n) {
                    nxVar.a();
                    return objR;
                }
                yv yvVarA = zg4.a(fp4.b(nu2Var));
                try {
                    Object objR2 = unVar2.R(nxVar, i2, andIncrement, yvVarA);
                    if (objR2 != py0Var) {
                        if (objR2 == py0Var2) {
                            if (andIncrement < unVar2.w()) {
                                nxVar.a();
                            }
                            nx nxVar4 = (nx) atomicReferenceFieldUpdater.get(unVar2);
                            while (true) {
                                if (unVar2.C()) {
                                    yvVarA.h(new h72(unVar2.u()));
                                    break;
                                }
                                yv yvVar = yvVarA;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(unVar2);
                                    long j4 = wn.b;
                                    long j5 = andIncrement2 / j4;
                                    int i3 = (int) (andIncrement2 % j4);
                                    if (nxVar4.f != j5) {
                                        try {
                                            nx nxVarQ2 = unVar2.q(j5, nxVar4);
                                            if (nxVarQ2 == null) {
                                                yvVarA = yvVar;
                                            } else {
                                                nxVar2 = nxVarQ2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            yvVarA = yvVar;
                                            yvVarA.E();
                                            throw th;
                                        }
                                    } else {
                                        nxVar2 = nxVar4;
                                    }
                                    un unVar3 = unVar2;
                                    objR2 = unVar3.R(nxVar2, i3, andIncrement2, yvVar);
                                    unVar2 = unVar3;
                                    nx nxVar5 = nxVar2;
                                    yvVarA = yvVar;
                                    if (objR2 == wn.m) {
                                        yvVarA.a(nxVar5, i3);
                                        break;
                                    }
                                    if (objR2 == wn.o) {
                                        if (andIncrement2 < unVar2.w()) {
                                            nxVar5.a();
                                        }
                                        nxVar4 = nxVar5;
                                    } else {
                                        if (objR2 == wn.n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        nxVar5.a();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    yvVarA = yvVar;
                                    th = th;
                                    yvVarA.E();
                                    throw th;
                                }
                            }
                        } else {
                            nxVar.a();
                        }
                        yvVarA.i(objR2, null);
                        break;
                    }
                    yvVarA.a(nxVar, i2);
                    return yvVarA.v();
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thU = unVar.u();
        int i4 = xq2.a;
        throw thU;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static Object J(un unVar, y50 y50Var) {
        sn snVar;
        nx nxVar;
        if (y50Var instanceof sn) {
            snVar = (sn) y50Var;
            int i2 = snVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                snVar.i = i2 - Integer.MIN_VALUE;
            } else {
                snVar = new sn(unVar, y50Var);
            }
        } else {
            snVar = new sn(unVar, y50Var);
        }
        sn snVar2 = snVar;
        Object obj = snVar2.e;
        int i3 = snVar2.i;
        if (i3 != 0) {
            if (i3 == 1) {
                bz3.g(obj);
                return ((mx) obj).a;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        j.getClass();
        nx nxVar2 = (nx) zj.a.getObjectVolatile(unVar, w);
        while (!unVar.C()) {
            long andIncrement = c.getAndIncrement(unVar);
            long j2 = wn.b;
            long j3 = andIncrement / j2;
            int i4 = (int) (andIncrement % j2);
            if (nxVar2.f != j3) {
                nx nxVarQ = unVar.q(j3, nxVar2);
                if (nxVarQ == null) {
                    continue;
                } else {
                    nxVar = nxVarQ;
                }
            } else {
                nxVar = nxVar2;
            }
            un unVar2 = unVar;
            Object objR = unVar2.R(nxVar, i4, andIncrement, null);
            if (objR == wn.m) {
                og.n("unexpected");
                return null;
            }
            if (objR != wn.o) {
                if (objR != wn.n) {
                    nxVar.a();
                    return objR;
                }
                snVar2.i = 1;
                Object objK = unVar2.K(nxVar, i4, andIncrement, snVar2);
                t70 t70Var = t70.a;
                return objK == t70Var ? t70Var : objK;
            }
            if (andIncrement < unVar2.w()) {
                nxVar.a();
            }
            unVar = unVar2;
            nxVar2 = nxVar;
        }
        return new kx(unVar.t());
    }

    /* JADX WARN: Code duplicated, block: B:87:0x0155  */
    /* JADX WARN: Code duplicated, block: B:89:0x0158 A[RETURN] */
    public static Object N(un unVar, Object obj, x50 x50Var) {
        q43 q43Var;
        Object objV;
        t70 t70Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        atomicReferenceFieldUpdater.getClass();
        nx nxVar = (nx) zj.a.getObjectVolatile(unVar, x);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(unVar);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zB = unVar.B(andIncrement, false);
            int i2 = wn.b;
            long j3 = i2;
            long j4 = j2 / j3;
            int i3 = (int) (j2 % j3);
            long j5 = nxVar.f;
            t70 t70Var2 = t70.a;
            q43Var = q43.a;
            if (j5 != j4) {
                nx nxVarR = unVar.r(j4, nxVar);
                if (nxVarR != null) {
                    nxVar = nxVarR;
                } else if (zB) {
                    Object objH = unVar.H(x50Var, obj);
                    if (objH == t70Var2) {
                        return objH;
                    }
                }
            }
            int iD = d(unVar, nxVar, i3, obj, j2, null, zB);
            if (iD == 0) {
                nxVar.a();
                return q43Var;
            }
            if (iD != 1) {
                if (iD == 2) {
                    if (!zB) {
                        break;
                    }
                    nxVar.n();
                    Object objH2 = unVar.H(x50Var, obj);
                    if (objH2 == t70Var2) {
                        return objH2;
                    }
                } else {
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = c;
                    if (iD == 3) {
                        yv yvVarA = zg4.a(fp4.b(x50Var));
                        try {
                            int iD2 = d(unVar, nxVar, i3, obj, j2, yvVarA, false);
                            if (iD2 != 0) {
                                if (iD2 == 1) {
                                    t70Var2 = t70Var2;
                                    yvVarA.h(q43Var);
                                } else if (iD2 != 2) {
                                    if (iD2 == 4) {
                                        t70Var2 = t70Var2;
                                        if (j2 < atomicLongFieldUpdater2.get(unVar)) {
                                            nxVar.a();
                                        }
                                    } else {
                                        if (iD2 != 5) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        nxVar.a();
                                        nx nxVar2 = (nx) atomicReferenceFieldUpdater.get(unVar);
                                        while (true) {
                                            long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(unVar);
                                            long j6 = andIncrement2 & 1152921504606846975L;
                                            boolean zB2 = unVar.B(andIncrement2, false);
                                            int i4 = wn.b;
                                            long j7 = i4;
                                            atomicLongFieldUpdater = atomicLongFieldUpdater;
                                            long j8 = j6 / j7;
                                            int i5 = (int) (j6 % j7);
                                            t70Var2 = t70Var2;
                                            if (nxVar2.f != j8) {
                                                nx nxVarR2 = unVar.r(j8, nxVar2);
                                                if (nxVarR2 != null) {
                                                    nxVar2 = nxVarR2;
                                                } else if (zB2) {
                                                }
                                            }
                                            int iD3 = d(unVar, nxVar2, i5, obj, j6, yvVarA, zB2);
                                            if (iD3 == 0) {
                                                nxVar2.a();
                                            } else if (iD3 != 1) {
                                                if (iD3 == 2) {
                                                    if (!zB2) {
                                                        yvVarA.a(nxVar2, i5 + i4);
                                                        break;
                                                    }
                                                    nxVar2.n();
                                                } else {
                                                    if (iD3 == 3) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    if (iD3 != 4) {
                                                        if (iD3 == 5) {
                                                            nxVar2.a();
                                                        }
                                                    } else if (j6 < atomicLongFieldUpdater2.get(unVar)) {
                                                        nxVar2.a();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    c(unVar, obj, yvVarA);
                                    break;
                                } else {
                                    t70Var2 = t70Var2;
                                    yvVarA.a(nxVar, i3 + i2);
                                }
                                objV = yvVarA.v();
                                t70Var = t70Var2;
                                if (objV != t70Var) {
                                    objV = q43Var;
                                }
                                if (objV == t70Var) {
                                    return objV;
                                }
                            } else {
                                t70Var2 = t70Var2;
                                nxVar.a();
                            }
                            yvVarA.h(q43Var);
                            objV = yvVarA.v();
                            t70Var = t70Var2;
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
                    } else if (iD == 4) {
                        if (j2 < atomicLongFieldUpdater2.get(unVar)) {
                            nxVar.a();
                        }
                        Object objH3 = unVar.H(x50Var, obj);
                        if (objH3 == t70Var2) {
                            return objH3;
                        }
                    } else if (iD == 5) {
                        nxVar.a();
                    }
                }
            } else {
                break;
            }
        }
        return q43Var;
    }

    public static final void c(un unVar, Object obj, yv yvVar) {
        yvVar.h(new h72(unVar.v()));
    }

    public static final int d(un unVar, nx nxVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        nxVar.s(i2, obj);
        if (z) {
            return unVar.S(nxVar, i2, obj, j2, obj2, z);
        }
        Object objQ = nxVar.q(i2);
        if (objQ == null) {
            if (unVar.f(j2)) {
                if (nxVar.p(i2, null, wn.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (nxVar.p(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objQ instanceof j93) {
            nxVar.s(i2, null);
            if (unVar.O(objQ, obj)) {
                nxVar.t(i2, wn.i);
                return 0;
            }
            py0 py0Var = wn.k;
            if (nxVar.k.getAndSet((i2 * 2) + 1, py0Var) == py0Var) {
                return 5;
            }
            nxVar.r(i2, true);
            return 5;
        }
        return unVar.S(nxVar, i2, obj, j2, obj2, z);
    }

    public static void y(un unVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        if ((atomicLongFieldUpdater.addAndGet(unVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(unVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void A(gn gnVar) {
        Unsafe unsafe;
        while (true) {
            s.getClass();
            Unsafe unsafe2 = zj.a;
            un unVar = this;
            if (unsafe2.compareAndSwapObject(unVar, v, (Object) null, gnVar)) {
                return;
            }
            long j2 = v;
            if (unsafe2.getObjectVolatile(unVar, j2) != null) {
                while (true) {
                    Object objectVolatile = zj.a.getObjectVolatile(unVar, j2);
                    py0 py0Var = wn.q;
                    if (objectVolatile != py0Var) {
                        if (objectVolatile == wn.r) {
                            og.n("Another handler was already registered and successfully invoked");
                            return;
                        } else {
                            og.h(objectVolatile, "Another handler is already registered: ");
                            return;
                        }
                    }
                    py0 py0Var2 = wn.r;
                    do {
                        un unVar2 = unVar;
                        unsafe = zj.a;
                        boolean zCompareAndSwapObject = unsafe.compareAndSwapObject(unVar2, v, py0Var, py0Var2);
                        unVar = unVar2;
                        if (zCompareAndSwapObject) {
                            gnVar.j(unVar.t());
                            return;
                        }
                    } while (unsafe.getObjectVolatile(unVar, j2) == py0Var);
                }
            } else {
                this = unVar;
            }
        }
    }

    public final boolean B(long j2, boolean z) {
        int i2 = (int) (j2 >> 60);
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2) {
                j(j2 & 1152921504606846975L);
                if (!z || !x()) {
                }
            } else {
                if (i2 != 3) {
                    kf2.e(ky0.h(i2, "unexpected close status: "));
                    return false;
                }
                nx nxVarJ = j(j2 & 1152921504606846975L);
                Object objA = null;
                loop0: do {
                    for (int i3 = wn.b - 1; -1 < i3; i3--) {
                        long j3 = (nxVarJ.f * ((long) wn.b)) + ((long) i3);
                        while (true) {
                            Object objQ = nxVarJ.q(i3);
                            if (objQ == wn.i) {
                                break loop0;
                            }
                            py0 py0Var = wn.d;
                            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
                            if (objQ != py0Var) {
                                if (objQ != wn.e && objQ != null) {
                                    if (!(objQ instanceof j93) && !(objQ instanceof k93)) {
                                        py0 py0Var2 = wn.g;
                                        if (objQ == py0Var2 || objQ == wn.f) {
                                            break loop0;
                                        }
                                        if (objQ != py0Var2) {
                                            break;
                                        }
                                    } else {
                                        if (j3 < atomicLongFieldUpdater.get(this)) {
                                            break loop0;
                                        }
                                        j93 j93Var = objQ instanceof k93 ? ((k93) objQ).a : (j93) objQ;
                                        if (nxVarJ.p(i3, objQ, wn.l)) {
                                            objA = yo4.a(objA, j93Var);
                                            nxVarJ.s(i3, null);
                                            nxVarJ.n();
                                            break;
                                        }
                                    }
                                } else {
                                    if (nxVarJ.p(i3, objQ, wn.l)) {
                                        nxVarJ.n();
                                        break;
                                    }
                                }
                            } else {
                                if (j3 < atomicLongFieldUpdater.get(this)) {
                                    break loop0;
                                }
                                if (nxVarJ.p(i3, objQ, wn.l)) {
                                    nxVarJ.s(i3, null);
                                    nxVarJ.n();
                                    break;
                                }
                            }
                        }
                    }
                    nxVarJ = (nx) nxVarJ.f();
                } while (nxVarJ != null);
                if (objA != null) {
                    if (objA instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objA;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            M((j93) arrayList.get(size), false);
                        }
                    } else {
                        M((j93) objA, false);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean C() {
        return B(b.get(this), true);
    }

    public final boolean D() {
        return B(b.get(this), false);
    }

    public boolean E() {
        return false;
    }

    public final boolean F() {
        long j2 = e.get(this);
        return j2 == 0 || j2 == Long.MAX_VALUE;
    }

    public final void G(long j2, nx nxVar) {
        un unVar;
        nx nxVar2;
        nx nxVar3;
        while (nxVar.f < j2 && (nxVar3 = (nx) nxVar.d()) != null) {
            nxVar = nxVar3;
        }
        while (true) {
            nx nxVar4 = nxVar;
            while (nxVar4.g() && (nxVar2 = (nx) nxVar4.d()) != null) {
                nxVar4 = nxVar2;
            }
            while (true) {
                k.getClass();
                Unsafe unsafe = zj.a;
                long j3 = u;
                af2 af2Var = (af2) unsafe.getObjectVolatile(this, j3);
                if (af2Var.f >= nxVar4.f) {
                    return;
                }
                if (!nxVar4.o()) {
                    break;
                }
                while (true) {
                    Unsafe unsafe2 = zj.a;
                    unVar = this;
                    if (unsafe2.compareAndSwapObject(unVar, u, af2Var, nxVar4)) {
                        if (af2Var.k()) {
                            af2Var.i();
                            return;
                        }
                        return;
                    } else if (unsafe2.getObjectVolatile(unVar, j3) != af2Var) {
                        break;
                    } else {
                        this = unVar;
                    }
                }
                if (nxVar4.k()) {
                    nxVar4.i();
                }
                this = unVar;
            }
            nxVar = nxVar4;
        }
    }

    public final Object H(x50 x50Var, Object obj) {
        yv yvVar = new yv(1, fp4.b(x50Var));
        yvVar.x();
        yvVar.h(new h72(v()));
        Object objV = yvVar.v();
        return objV == t70.a ? objV : q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K(nx nxVar, int i2, long j2, y50 y50Var) {
        tn tnVar;
        mx mxVar;
        nx nxVar2;
        if (y50Var instanceof tn) {
            tnVar = (tn) y50Var;
            int i3 = tnVar.i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                tnVar.i = i3 - Integer.MIN_VALUE;
            } else {
                tnVar = new tn(this, y50Var);
            }
        } else {
            tnVar = new tn(this, y50Var);
        }
        Object objV = tnVar.e;
        int i4 = tnVar.i;
        if (i4 == 0) {
            bz3.g(objV);
            tnVar.i = 1;
            yv yvVarA = zg4.a(fp4.b(tnVar));
            try {
                y32 y32Var = new y32(yvVarA);
                Object objR = R(nxVar, i2, j2, y32Var);
                if (objR != wn.m) {
                    if (objR == wn.o) {
                        if (j2 < w()) {
                            nxVar.a();
                        }
                        nx nxVar3 = (nx) j.get(this);
                        while (true) {
                            if (C()) {
                                yvVarA.h(new mx(new kx(t())));
                                break;
                            }
                            long andIncrement = c.getAndIncrement(this);
                            long j3 = wn.b;
                            long j4 = andIncrement / j3;
                            int i5 = (int) (andIncrement % j3);
                            if (nxVar3.f != j4) {
                                nx nxVarQ = q(j4, nxVar3);
                                if (nxVarQ != null) {
                                    nxVar2 = nxVarQ;
                                }
                            } else {
                                nxVar2 = nxVar3;
                            }
                            Object objR2 = R(nxVar2, i5, andIncrement, y32Var);
                            nx nxVar4 = nxVar2;
                            if (objR2 == wn.m) {
                                y32Var.a(nxVar4, i5);
                                break;
                            }
                            if (objR2 == wn.o) {
                                if (andIncrement < w()) {
                                    nxVar4.a();
                                }
                                nxVar3 = nxVar4;
                            } else {
                                if (objR2 == wn.n) {
                                    throw new IllegalStateException("unexpected");
                                }
                                nxVar4.a();
                                mxVar = new mx(objR2);
                            }
                        }
                    } else {
                        nxVar.a();
                        mxVar = new mx(objR);
                    }
                    yvVarA.i(mxVar, null);
                    break;
                }
                y32Var.a(nxVar, i2);
                objV = yvVarA.v();
                t70 t70Var = t70.a;
                if (objV == t70Var) {
                    return t70Var;
                }
            } catch (Throwable th) {
                yvVarA.E();
                throw th;
            }
        } else {
            if (i4 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objV);
        }
        return ((mx) objV).a;
    }

    public final void L(gf2 gf2Var) {
        nx nxVar;
        j.getClass();
        nx nxVar2 = (nx) zj.a.getObjectVolatile(this, w);
        while (!this.C()) {
            long andIncrement = c.getAndIncrement(this);
            long j2 = wn.b;
            long j3 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (nxVar2.f != j3) {
                nx nxVarQ = this.q(j3, nxVar2);
                if (nxVarQ == null) {
                    continue;
                } else {
                    nxVar = nxVarQ;
                }
            } else {
                nxVar = nxVar2;
            }
            Object objR = this.R(nxVar, i2, andIncrement, gf2Var);
            nxVar2 = nxVar;
            if (objR == wn.m) {
                gf2 gf2Var2 = gf2Var != 0 ? gf2Var : null;
                if (gf2Var2 != null) {
                    gf2Var2.c = nxVar2;
                    gf2Var2.e = i2;
                    return;
                }
                return;
            }
            if (objR != wn.o) {
                if (objR == wn.n) {
                    og.n("unexpected");
                    return;
                } else {
                    nxVar2.a();
                    gf2Var.f = objR;
                    return;
                }
            }
            if (andIncrement < this.w()) {
                nxVar2.a();
            }
            this = this;
            gf2Var = gf2Var;
        }
        gf2Var.f = wn.l;
    }

    public final void M(j93 j93Var, boolean z) {
        if (j93Var instanceof wv) {
            ((x50) j93Var).h(new h72(z ? u() : v()));
            return;
        }
        if (j93Var instanceof y32) {
            ((y32) j93Var).a.h(new mx(new kx(t())));
            return;
        }
        if (!(j93Var instanceof pn)) {
            if (j93Var instanceof gf2) {
                ((gf2) j93Var).j(this, wn.l);
                return;
            } else {
                og.h(j93Var, "Unexpected waiter: ");
                return;
            }
        }
        pn pnVar = (pn) j93Var;
        yv yvVar = pnVar.b;
        yvVar.getClass();
        pnVar.b = null;
        pnVar.a = wn.l;
        Throwable thT = pnVar.c.t();
        if (thT == null) {
            yvVar.h(Boolean.FALSE);
        } else {
            yvVar.h(new h72(thT));
        }
    }

    public final boolean O(Object obj, Object obj2) {
        if (obj instanceof gf2) {
            return ((gf2) obj).j(this, obj2) == 0;
        }
        if (obj instanceof y32) {
            return wn.a(((y32) obj).a, new mx(obj2), null);
        }
        if (!(obj instanceof pn)) {
            if (obj instanceof wv) {
                return wn.a((wv) obj, obj2, null);
            }
            og.h(obj, "Unexpected receiver type: ");
            return false;
        }
        pn pnVar = (pn) obj;
        yv yvVar = pnVar.b;
        yvVar.getClass();
        pnVar.b = null;
        pnVar.a = obj2;
        Boolean bool = Boolean.TRUE;
        pnVar.c.getClass();
        return wn.a(yvVar, bool, null);
    }

    public final boolean P(Object obj, nx nxVar, int i2) {
        d33 d33Var;
        boolean z = obj instanceof wv;
        q43 q43Var = q43.a;
        if (z) {
            return wn.a((wv) obj, q43Var, null);
        }
        if (!(obj instanceof gf2)) {
            og.h(obj, "Unexpected waiter: ");
            return false;
        }
        int iJ = ((gf2) obj).j(this, q43Var);
        d33 d33Var2 = d33.a;
        d33 d33Var3 = d33.b;
        if (iJ == 0) {
            d33Var = d33Var2;
        } else if (iJ == 1) {
            d33Var = d33Var3;
        } else if (iJ == 2) {
            d33Var = d33.c;
        } else {
            if (iJ != 3) {
                throw new IllegalStateException(("Unexpected internal result: " + iJ).toString());
            }
            d33Var = d33.e;
        }
        if (d33Var == d33Var3) {
            nxVar.s(i2, null);
        }
        return d33Var == d33Var2;
    }

    public final Object Q(Object obj) {
        nx nxVarR;
        f02 f02Var = wn.d;
        i.getClass();
        nx nxVar = (nx) zj.a.getObjectVolatile(this, x);
        while (true) {
            long andIncrement = b.getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zB = this.B(andIncrement, false);
            int i2 = wn.b;
            long j3 = i2;
            long j4 = j2 / j3;
            int i3 = (int) (j2 % j3);
            if (nxVar.f != j4) {
                nxVarR = this.r(j4, nxVar);
                if (nxVarR == null) {
                    if (zB) {
                        return new kx(this.v());
                    }
                }
            } else {
                nxVarR = nxVar;
            }
            Object obj2 = obj;
            int iD = d(this, nxVarR, i3, obj2, j2, f02Var, zB);
            un unVar = this;
            nxVar = nxVarR;
            q43 q43Var = q43.a;
            if (iD == 0) {
                nxVar.a();
                return q43Var;
            }
            if (iD != 1) {
                if (iD != 2) {
                    if (iD == 3) {
                        og.n("unexpected");
                        return null;
                    }
                    if (iD == 4) {
                        if (j2 < c.get(unVar)) {
                            nxVar.a();
                        }
                        return new kx(unVar.v());
                    }
                    if (iD == 5) {
                        nxVar.a();
                    }
                    this = unVar;
                    obj = obj2;
                } else {
                    if (zB) {
                        nxVar.n();
                        return new kx(unVar.v());
                    }
                    j93 j93Var = f02Var instanceof j93 ? (j93) f02Var : null;
                    if (j93Var != null) {
                        j93Var.a(nxVar, i3 + i2);
                    }
                    unVar.k((nxVar.f * j3) + ((long) i3));
                }
            }
            return q43Var;
        }
    }

    public final Object R(nx nxVar, int i2, long j2, Object obj) {
        Object objQ = nxVar.q(i2);
        AtomicReferenceArray atomicReferenceArray = nxVar.k;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (objQ == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return wn.n;
                }
                if (nxVar.p(i2, objQ, obj)) {
                    m();
                    return wn.m;
                }
            }
        } else if (objQ == wn.d && nxVar.p(i2, objQ, wn.i)) {
            m();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            nxVar.s(i2, null);
            return obj2;
        }
        while (true) {
            Object objQ2 = nxVar.q(i2);
            if (objQ2 == null || objQ2 == wn.e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (nxVar.p(i2, objQ2, wn.h)) {
                        m();
                        return wn.o;
                    }
                } else {
                    if (obj == null) {
                        return wn.n;
                    }
                    if (nxVar.p(i2, objQ2, obj)) {
                        m();
                        return wn.m;
                    }
                }
            } else if (objQ2 != wn.d) {
                py0 py0Var = wn.j;
                if (objQ2 == py0Var) {
                    return wn.o;
                }
                if (objQ2 == wn.h) {
                    return wn.o;
                }
                if (objQ2 == wn.l) {
                    m();
                    return wn.o;
                }
                if (objQ2 != wn.g && nxVar.p(i2, objQ2, wn.f)) {
                    boolean z = objQ2 instanceof k93;
                    if (z) {
                        objQ2 = ((k93) objQ2).a;
                    }
                    if (P(objQ2, nxVar, i2)) {
                        nxVar.t(i2, wn.i);
                        m();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        nxVar.s(i2, null);
                        return obj3;
                    }
                    nxVar.t(i2, py0Var);
                    nxVar.n();
                    if (z) {
                        m();
                    }
                    return wn.o;
                }
            } else if (nxVar.p(i2, objQ2, wn.i)) {
                m();
                Object obj4 = atomicReferenceArray.get(i2 * 2);
                nxVar.s(i2, null);
                return obj4;
            }
        }
    }

    public final int S(nx nxVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object objQ = nxVar.q(i2);
            if (objQ == null) {
                if (!f(j2) || z) {
                    if (z) {
                        if (nxVar.p(i2, null, wn.j)) {
                            nxVar.n();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (nxVar.p(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (nxVar.p(i2, null, wn.d)) {
                    break;
                }
            } else {
                if (objQ != wn.e) {
                    py0 py0Var = wn.k;
                    if (objQ == py0Var) {
                        nxVar.s(i2, null);
                        return 5;
                    }
                    if (objQ == wn.h) {
                        nxVar.s(i2, null);
                        return 5;
                    }
                    if (objQ == wn.l) {
                        nxVar.s(i2, null);
                        D();
                        return 4;
                    }
                    nxVar.s(i2, null);
                    if (objQ instanceof k93) {
                        objQ = ((k93) objQ).a;
                    }
                    if (O(objQ, obj)) {
                        nxVar.t(i2, wn.i);
                        return 0;
                    }
                    if (nxVar.k.getAndSet((i2 * 2) + 1, py0Var) != py0Var) {
                        nxVar.r(i2, true);
                    }
                    return 5;
                }
                if (nxVar.p(i2, objQ, wn.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void T(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        un unVar = this;
        if (unVar.F()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = e;
            if (atomicLongFieldUpdater.get(unVar) > j2) {
                break;
            } else {
                unVar = this;
            }
        }
        int i2 = wn.c;
        int i3 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f;
            if (i3 < i2) {
                long j3 = atomicLongFieldUpdater.get(unVar);
                if (j3 == (4611686018427387903L & atomicLongFieldUpdater2.get(unVar)) && j3 == atomicLongFieldUpdater.get(unVar)) {
                    return;
                } else {
                    i3++;
                }
            } else {
                while (true) {
                    long j4 = atomicLongFieldUpdater2.get(unVar);
                    if (atomicLongFieldUpdater2.compareAndSet(unVar, j4, (j4 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        unVar = this;
                    }
                }
                while (true) {
                    long j5 = atomicLongFieldUpdater.get(unVar);
                    long j6 = atomicLongFieldUpdater2.get(unVar);
                    long j7 = j6 & 4611686018427387903L;
                    boolean z = (j6 & 4611686018427387904L) != 0;
                    if (j5 == j7 && j5 == atomicLongFieldUpdater.get(unVar)) {
                        break;
                    }
                    if (z) {
                        unVar = this;
                    } else {
                        unVar = this;
                        atomicLongFieldUpdater2.compareAndSet(unVar, j6, 4611686018427387904L + j7);
                    }
                }
                while (true) {
                    long j8 = atomicLongFieldUpdater2.get(unVar);
                    if (atomicLongFieldUpdater2.compareAndSet(unVar, j8, j8 & 4611686018427387903L)) {
                        return;
                    } else {
                        unVar = this;
                    }
                }
            }
        }
    }

    @Override // defpackage.vg2
    public Object a(x50 x50Var, Object obj) {
        return N(this, obj, x50Var);
    }

    @Override // defpackage.vg2
    public final boolean b(Throwable th) {
        return i(th, false);
    }

    @Override // defpackage.bx
    public final void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        i(cancellationException, true);
    }

    public final boolean f(long j2) {
        return j2 < e.get(this) || j2 < c.get(this) + ((long) this.a);
    }

    @Override // defpackage.bx
    public final Object g(y50 y50Var) {
        return J(this, y50Var);
    }

    public final nx h() {
        k.getClass();
        Unsafe unsafe = zj.a;
        Object objectVolatile = unsafe.getObjectVolatile(this, u);
        i.getClass();
        nx nxVar = (nx) unsafe.getObjectVolatile(this, x);
        if (nxVar.f > ((nx) objectVolatile).f) {
            objectVolatile = nxVar;
        }
        j.getClass();
        nx nxVar2 = (nx) unsafe.getObjectVolatile(this, w);
        if (nxVar2.f > ((nx) objectVolatile).f) {
            objectVolatile = nxVar2;
        }
        q30 q30Var = (q30) objectVolatile;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q30.a;
            Object objE = q30Var.e();
            if (objE == my3.a) {
                break;
            }
            q30 q30Var2 = (q30) objE;
            if (q30Var2 != null) {
                q30Var = q30Var2;
            } else if (q30Var.h()) {
                break;
            }
        }
        return (nx) q30Var;
    }

    public final boolean i(Throwable th, boolean z) {
        un unVar;
        boolean z2;
        long j2;
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (!z) {
            unVar = this;
            break;
        }
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                unVar = this;
                break;
            }
            nx nxVar = wn.a;
            unVar = this;
            if (atomicLongFieldUpdater.compareAndSet(unVar, j5, (j5 & 1152921504606846975L) + 1152921504606846976L)) {
                break;
            }
            this = unVar;
        }
        py0 py0Var = wn.s;
        while (true) {
            n.getClass();
            un unVar2 = unVar;
            Unsafe unsafe = zj.a;
            long j6 = t;
            Throwable th2 = th;
            boolean zCompareAndSwapObject = unsafe.compareAndSwapObject(unVar2, j6, py0Var, th2);
            unVar = unVar2;
            if (zCompareAndSwapObject) {
                z2 = true;
                break;
            }
            if (unsafe.getObjectVolatile(unVar, j6) != py0Var) {
                z2 = false;
                break;
            }
            th = th2;
        }
        if (z) {
            do {
                j4 = atomicLongFieldUpdater.get(unVar);
            } while (!atomicLongFieldUpdater.compareAndSet(unVar, j4, 3458764513820540928L + (j4 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(unVar);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j3 = (j2 & 1152921504606846975L) + 2305843009213693952L;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j3 = (j2 & 1152921504606846975L) + 3458764513820540928L;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(unVar, j2, j3));
        }
        unVar.D();
        if (z2) {
            unVar.z();
        }
        return z2;
    }

    @Override // defpackage.bx
    public final pn iterator() {
        return new pn(this);
    }

    public final nx j(long j2) {
        long j3;
        nx nxVarH = h();
        if (E()) {
            nx nxVar = nxVarH;
            loop0: while (true) {
                int i2 = wn.b - 1;
                while (true) {
                    if (-1 < i2) {
                        j3 = (nxVar.f * ((long) wn.b)) + ((long) i2);
                        if (j3 >= c.get(this)) {
                            while (true) {
                                Object objQ = nxVar.q(i2);
                                if (objQ != null && objQ != wn.e) {
                                    if (objQ != wn.d) {
                                        break;
                                    }
                                    break loop0;
                                }
                                if (nxVar.p(i2, objQ, wn.l)) {
                                    nxVar.n();
                                    break;
                                }
                            }
                            i2--;
                        }
                    } else {
                        nxVar = (nx) nxVar.f();
                        if (nxVar == null) {
                        }
                    }
                    j3 = -1;
                    break loop0;
                }
            }
            if (j3 != -1) {
                k(j3);
            }
        }
        Object objA = null;
        loop3: for (nx nxVar2 = nxVarH; nxVar2 != null; nxVar2 = (nx) nxVar2.f()) {
            for (int i3 = wn.b - 1; -1 < i3; i3--) {
                if ((nxVar2.f * ((long) wn.b)) + ((long) i3) < j2) {
                    break loop3;
                }
                while (true) {
                    Object objQ2 = nxVar2.q(i3);
                    if (objQ2 != null && objQ2 != wn.e) {
                        if (!(objQ2 instanceof k93)) {
                            if (!(objQ2 instanceof j93)) {
                                break;
                            }
                            if (nxVar2.p(i3, objQ2, wn.l)) {
                                objA = yo4.a(objA, objQ2);
                                nxVar2.r(i3, true);
                                break;
                            }
                        } else {
                            if (nxVar2.p(i3, objQ2, wn.l)) {
                                objA = yo4.a(objA, ((k93) objQ2).a);
                                nxVar2.r(i3, true);
                                break;
                            }
                        }
                    } else {
                        if (nxVar2.p(i3, objQ2, wn.l)) {
                            nxVar2.n();
                            break;
                        }
                    }
                }
            }
        }
        if (objA != null) {
            if (!(objA instanceof ArrayList)) {
                M((j93) objA, true);
                return nxVarH;
            }
            ArrayList arrayList = (ArrayList) objA;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                M((j93) arrayList.get(size), true);
            }
        }
        return nxVarH;
    }

    public final void k(long j2) {
        j.getClass();
        nx nxVar = (nx) zj.a.getObjectVolatile(this, w);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(((long) this.a) + j3, e.get(this))) {
                return;
            }
            this = this;
            if (atomicLongFieldUpdater.compareAndSet(this, j3, 1 + j3)) {
                long j4 = wn.b;
                long j5 = j3 / j4;
                int i2 = (int) (j3 % j4);
                if (nxVar.f != j5) {
                    nx nxVarQ = this.q(j5, nxVar);
                    if (nxVarQ != null) {
                        nxVar = nxVarQ;
                    }
                }
                nx nxVar2 = nxVar;
                if (this.R(nxVar2, i2, j3, null) != wn.o || j3 < this.w()) {
                    nxVar2.a();
                }
                nxVar = nxVar2;
            }
        }
    }

    @Override // defpackage.bx
    public final p6 l() {
        qn qnVar = qn.k;
        h33.c(3, qnVar);
        rn rnVar = rn.k;
        h33.c(3, rnVar);
        return new p6(this, qnVar, rnVar, null);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b3 A[EDGE_INSN: B:43:0x00b3->B:46:0x00c0 BREAK  A[LOOP:1: B:31:0x0080->B:92:0x0080]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00f1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00c0 A[EDGE_INSN: B:89:0x00c0->B:46:0x00c0 BREAK  A[LOOP:1: B:31:0x0080->B:92:0x0080], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[SYNTHETIC] */
    public final void m() {
        int i2;
        boolean z;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        Object objQ;
        if (F()) {
            return;
        }
        k.getClass();
        nx nxVar = (nx) zj.a.getObjectVolatile(this, u);
        while (true) {
            long andIncrement = e.getAndIncrement(this);
            long j2 = wn.b;
            long j3 = andIncrement / j2;
            if (this.w() <= andIncrement) {
                if (nxVar.f < j3 && nxVar.d() != null) {
                    this.G(j3, nxVar);
                }
                y(this);
                return;
            }
            un unVar = this;
            if (nxVar.f == j3) {
                i2 = (int) (andIncrement % j2);
                Object objQ2 = nxVar.q(i2);
                z = objQ2 instanceof j93;
                atomicLongFieldUpdater = c;
                if (z || andIncrement < atomicLongFieldUpdater.get(unVar) || !nxVar.p(i2, objQ2, wn.g)) {
                    while (true) {
                        objQ = nxVar.q(i2);
                        if (objQ instanceof j93) {
                            if (andIncrement < atomicLongFieldUpdater.get(unVar)) {
                                if (nxVar.p(i2, objQ, new k93((j93) objQ))) {
                                    y(unVar);
                                    return;
                                }
                            } else if (nxVar.p(i2, objQ, wn.g)) {
                                if (!unVar.P(objQ, nxVar, i2)) {
                                    nxVar.t(i2, wn.j);
                                    nxVar.n();
                                    break;
                                } else {
                                    nxVar.t(i2, wn.d);
                                    y(unVar);
                                    return;
                                }
                            }
                        } else {
                            if (objQ == wn.j) {
                                break;
                            }
                            if (objQ == null) {
                                if (nxVar.p(i2, objQ, wn.e)) {
                                    y(unVar);
                                    return;
                                }
                            } else if (objQ != wn.d || objQ == wn.h || objQ == wn.i || objQ == wn.k || objQ == wn.l) {
                                y(unVar);
                                return;
                            } else if (objQ != wn.f) {
                                og.h(objQ, "Unexpected cell state: ");
                                return;
                            }
                        }
                    }
                    y(unVar);
                } else if (unVar.P(objQ2, nxVar, i2)) {
                    nxVar.t(i2, wn.d);
                    y(unVar);
                    return;
                } else {
                    nxVar.t(i2, wn.j);
                    nxVar.n();
                    y(unVar);
                }
            } else {
                nx nxVarO = unVar.o(j3, nxVar, andIncrement);
                if (nxVarO == null) {
                    continue;
                } else {
                    nxVar = nxVarO;
                    i2 = (int) (andIncrement % j2);
                    Object objQ3 = nxVar.q(i2);
                    z = objQ3 instanceof j93;
                    atomicLongFieldUpdater = c;
                    if (z) {
                        while (true) {
                            objQ = nxVar.q(i2);
                            if (objQ instanceof j93) {
                                if (andIncrement < atomicLongFieldUpdater.get(unVar)) {
                                    if (nxVar.p(i2, objQ, new k93((j93) objQ))) {
                                        y(unVar);
                                        return;
                                    }
                                } else if (nxVar.p(i2, objQ, wn.g)) {
                                    if (!unVar.P(objQ, nxVar, i2)) {
                                        nxVar.t(i2, wn.j);
                                        nxVar.n();
                                        break;
                                    } else {
                                        nxVar.t(i2, wn.d);
                                        y(unVar);
                                        return;
                                    }
                                }
                            } else {
                                if (objQ == wn.j) {
                                    break;
                                    break;
                                }
                                if (objQ == null) {
                                    if (objQ != wn.d) {
                                        if (objQ != wn.f) {
                                            og.h(objQ, "Unexpected cell state: ");
                                            return;
                                        }
                                    }
                                    y(unVar);
                                    return;
                                }
                                if (nxVar.p(i2, objQ, wn.e)) {
                                    y(unVar);
                                    return;
                                }
                            }
                        }
                        y(unVar);
                    } else {
                        while (true) {
                            objQ = nxVar.q(i2);
                            if (objQ instanceof j93) {
                                if (andIncrement < atomicLongFieldUpdater.get(unVar)) {
                                    if (nxVar.p(i2, objQ, new k93((j93) objQ))) {
                                        y(unVar);
                                        return;
                                    }
                                } else if (nxVar.p(i2, objQ, wn.g)) {
                                    if (!unVar.P(objQ, nxVar, i2)) {
                                        nxVar.t(i2, wn.j);
                                        nxVar.n();
                                        break;
                                    } else {
                                        nxVar.t(i2, wn.d);
                                        y(unVar);
                                        return;
                                    }
                                }
                            } else {
                                if (objQ == wn.j) {
                                    break;
                                    break;
                                }
                                if (objQ == null) {
                                    if (objQ != wn.d) {
                                        if (objQ != wn.f) {
                                            og.h(objQ, "Unexpected cell state: ");
                                            return;
                                        }
                                    }
                                    y(unVar);
                                    return;
                                }
                                if (nxVar.p(i2, objQ, wn.e)) {
                                    y(unVar);
                                    return;
                                }
                            }
                        }
                        y(unVar);
                    }
                }
            }
            this = unVar;
        }
    }

    @Override // defpackage.bx
    public final Object n(nu2 nu2Var) {
        return I(this, nu2Var);
    }

    public final nx o(long j2, nx nxVar, long j3) {
        Object objB;
        Unsafe unsafe;
        nx nxVar2 = wn.a;
        vn vnVar = vn.k;
        loop0: while (true) {
            objB = my3.b(nxVar, j2, vnVar);
            if (!m24.b(objB)) {
                af2 af2VarA = m24.a(objB);
                while (true) {
                    k.getClass();
                    Unsafe unsafe2 = zj.a;
                    long j4 = u;
                    af2 af2Var = (af2) unsafe2.getObjectVolatile(this, j4);
                    if (af2Var.f >= af2VarA.f) {
                        break loop0;
                    }
                    if (!af2VarA.o()) {
                        break;
                    }
                    do {
                        unsafe = zj.a;
                        if (unsafe.compareAndSwapObject(this, u, af2Var, af2VarA)) {
                            if (!af2Var.k()) {
                                break loop0;
                            }
                            af2Var.i();
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(this, j4) == af2Var);
                    if (af2VarA.k()) {
                        af2VarA.i();
                    }
                }
            } else {
                break;
            }
        }
        if (m24.b(objB)) {
            D();
            G(j2, nxVar);
            y(this);
            return null;
        }
        nx nxVar3 = (nx) m24.a(objB);
        long j5 = nxVar3.f;
        if (j5 <= j2) {
            return nxVar3;
        }
        long j6 = j5 * ((long) wn.b);
        if (!e.compareAndSet(this, j3 + 1, j6)) {
            y(this);
            return null;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        if ((atomicLongFieldUpdater.addAndGet(this, j6 - j3) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
            }
        }
        return null;
    }

    @Override // defpackage.bx
    public final Object p() {
        nx nxVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        long j2 = atomicLongFieldUpdater.get(this);
        long j3 = b.get(this);
        if (B(j3, true)) {
            return new kx(t());
        }
        long j4 = j3 & 1152921504606846975L;
        lx lxVar = mx.b;
        if (j2 >= j4) {
            return lxVar;
        }
        Object obj = wn.k;
        j.getClass();
        nx nxVar2 = (nx) zj.a.getObjectVolatile(this, w);
        while (!this.C()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j5 = wn.b;
            long j6 = andIncrement / j5;
            int i2 = (int) (andIncrement % j5);
            if (nxVar2.f != j6) {
                nx nxVarQ = this.q(j6, nxVar2);
                if (nxVarQ == null) {
                    continue;
                } else {
                    nxVar = nxVarQ;
                }
            } else {
                nxVar = nxVar2;
            }
            un unVar = this;
            Object objR = unVar.R(nxVar, i2, andIncrement, obj);
            nxVar2 = nxVar;
            if (objR == wn.m) {
                j93 j93Var = obj instanceof j93 ? (j93) obj : null;
                if (j93Var != null) {
                    j93Var.a(nxVar2, i2);
                }
                unVar.T(andIncrement);
                nxVar2.n();
                return lxVar;
            }
            if (objR != wn.o) {
                if (objR != wn.n) {
                    nxVar2.a();
                    return objR;
                }
                og.n("unexpected");
                return null;
            }
            if (andIncrement < unVar.w()) {
                nxVar2.a();
            }
            this = unVar;
        }
        return new kx(this.t());
    }

    public final nx q(long j2, nx nxVar) {
        Object objB;
        nx nxVar2;
        long j3;
        Unsafe unsafe;
        nx nxVar3 = wn.a;
        vn vnVar = vn.k;
        loop0: while (true) {
            objB = my3.b(nxVar, j2, vnVar);
            if (!m24.b(objB)) {
                af2 af2VarA = m24.a(objB);
                while (true) {
                    j.getClass();
                    Unsafe unsafe2 = zj.a;
                    long j4 = w;
                    af2 af2Var = (af2) unsafe2.getObjectVolatile(this, j4);
                    if (af2Var.f >= af2VarA.f) {
                        break loop0;
                    }
                    if (!af2VarA.o()) {
                        break;
                    }
                    do {
                        unsafe = zj.a;
                        if (unsafe.compareAndSwapObject(this, w, af2Var, af2VarA)) {
                            if (!af2Var.k()) {
                                break loop0;
                            }
                            af2Var.i();
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(this, j4) == af2Var);
                    if (af2VarA.k()) {
                        af2VarA.i();
                    }
                }
            } else {
                break;
            }
        }
        if (m24.b(objB)) {
            D();
            if (nxVar.f * ((long) wn.b) < w()) {
                nxVar.a();
                return null;
            }
        } else {
            nx nxVar4 = (nx) m24.a(objB);
            long j5 = nxVar4.f;
            if (F() || j2 > e.get(this) / ((long) wn.b)) {
                nxVar2 = nxVar4;
                break;
            }
            loop3: while (true) {
                k.getClass();
                Unsafe unsafe3 = zj.a;
                long j6 = u;
                af2 af2Var2 = (af2) unsafe3.getObjectVolatile(this, j6);
                if (af2Var2.f >= j5 || !nxVar4.o()) {
                    nxVar2 = nxVar4;
                    break;
                }
                while (true) {
                    Unsafe unsafe4 = zj.a;
                    nxVar2 = nxVar4;
                    if (unsafe4.compareAndSwapObject(this, u, af2Var2, nxVar4)) {
                        if (!af2Var2.k()) {
                            break loop3;
                        }
                        af2Var2.i();
                        break loop3;
                    }
                    if (unsafe4.getObjectVolatile(this, j6) != af2Var2) {
                        break;
                    }
                    nxVar4 = nxVar2;
                }
                if (nxVar2.k()) {
                    nxVar2.i();
                }
                nxVar4 = nxVar2;
            }
            if (j5 <= j2) {
                return nxVar2;
            }
            long j7 = j5 * ((long) wn.b);
            do {
                j3 = c.get(this);
                if (j3 >= j7) {
                    break;
                }
            } while (!c.compareAndSet(this, j3, j7));
            if (j5 * ((long) wn.b) < w()) {
                nxVar2.a();
            }
        }
        return null;
    }

    public final nx r(long j2, nx nxVar) {
        Object objB;
        long j3;
        long j4;
        Unsafe unsafe;
        nx nxVar2 = wn.a;
        vn vnVar = vn.k;
        loop0: while (true) {
            objB = my3.b(nxVar, j2, vnVar);
            if (!m24.b(objB)) {
                af2 af2VarA = m24.a(objB);
                while (true) {
                    i.getClass();
                    Unsafe unsafe2 = zj.a;
                    long j5 = x;
                    af2 af2Var = (af2) unsafe2.getObjectVolatile(this, j5);
                    if (af2Var.f >= af2VarA.f) {
                        break loop0;
                    }
                    if (!af2VarA.o()) {
                        break;
                    }
                    do {
                        unsafe = zj.a;
                        if (unsafe.compareAndSwapObject(this, x, af2Var, af2VarA)) {
                            if (!af2Var.k()) {
                                break loop0;
                            }
                            af2Var.i();
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(this, j5) == af2Var);
                    if (af2VarA.k()) {
                        af2VarA.i();
                    }
                }
            } else {
                break;
            }
        }
        boolean zB = m24.b(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        if (zB) {
            D();
            if (nxVar.f * ((long) wn.b) < atomicLongFieldUpdater.get(this)) {
                nxVar.a();
                return null;
            }
        } else {
            nx nxVar3 = (nx) m24.a(objB);
            long j6 = nxVar3.f;
            if (j6 <= j2) {
                return nxVar3;
            }
            long j7 = j6 * ((long) wn.b);
            do {
                j3 = b.get(this);
                j4 = 1152921504606846975L & j3;
                if (j4 >= j7) {
                    break;
                }
            } while (!b.compareAndSet(this, j3, j4 + (((long) ((int) (j3 >> 60))) << 60)));
            if (j6 * ((long) wn.b) < atomicLongFieldUpdater.get(this)) {
                nxVar3.a();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0080  */
    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x009c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0072, please report this as an issue */
    @Override // defpackage.vg2
    public Object s(Object obj) {
        int iD;
        q43 q43Var;
        j93 j93Var;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        long j2 = atomicLongFieldUpdater.get(this);
        boolean z = false;
        long j3 = 1152921504606846975L;
        boolean z2 = B(j2, false) ? false : !f(j2 & 1152921504606846975L);
        lx lxVar = mx.b;
        if (z2) {
            return lxVar;
        }
        f02 f02Var = wn.j;
        i.getClass();
        nx nxVar = (nx) zj.a.getObjectVolatile(this, x);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = andIncrement & j3;
            boolean zB = B(andIncrement, z);
            int i2 = wn.b;
            long j5 = i2;
            long j6 = j4 / j5;
            int i3 = (int) (j4 % j5);
            if (nxVar.f == j6) {
                iD = d(this, nxVar, i3, obj, j4, f02Var, zB);
                q43Var = q43.a;
                if (iD != 0) {
                    nxVar.a();
                    return q43Var;
                }
                if (iD != 1) {
                    return q43Var;
                }
                if (iD != 2) {
                    if (zB) {
                        nxVar.n();
                        return new kx(v());
                    }
                    j93Var = f02Var instanceof j93 ? (j93) f02Var : null;
                    if (j93Var != null) {
                        j93Var.a(nxVar, i3 + i2);
                    }
                    nxVar.n();
                    return lxVar;
                }
                if (iD != 3) {
                    og.n("unexpected");
                    return null;
                }
                if (iD != 4) {
                    if (j4 < c.get(this)) {
                        nxVar.a();
                    }
                    return new kx(v());
                }
                if (iD == 5) {
                    nxVar.a();
                }
                z = false;
            } else {
                nx nxVarR = r(j6, nxVar);
                if (nxVarR != null) {
                    nxVar = nxVarR;
                    iD = d(this, nxVar, i3, obj, j4, f02Var, zB);
                    q43Var = q43.a;
                    if (iD != 0) {
                        nxVar.a();
                        return q43Var;
                    }
                    if (iD != 1) {
                        return q43Var;
                    }
                    if (iD != 2) {
                        if (zB) {
                            nxVar.n();
                            return new kx(v());
                        }
                        if (f02Var instanceof j93) {
                        }
                        if (j93Var != null) {
                            j93Var.a(nxVar, i3 + i2);
                        }
                        nxVar.n();
                        return lxVar;
                    }
                    if (iD != 3) {
                        og.n("unexpected");
                        return null;
                    }
                    if (iD != 4) {
                        if (j4 < c.get(this)) {
                            nxVar.a();
                        }
                        return new kx(v());
                    }
                    if (iD == 5) {
                        nxVar.a();
                    }
                    z = false;
                } else {
                    if (zB) {
                        return new kx(v());
                    }
                    z = false;
                }
            }
            j3 = 1152921504606846975L;
        }
    }

    public final Throwable t() {
        n.getClass();
        return (Throwable) zj.a.getObjectVolatile(this, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        int i2;
        String string;
        StringBuilder sb = new StringBuilder();
        int i3 = (int) (b.get(this) >> 60);
        if (i3 == 2) {
            sb.append("closed,");
        } else if (i3 == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.a + ',');
        sb.append("data=[");
        j.getClass();
        Unsafe unsafe = zj.a;
        int i4 = 0;
        i.getClass();
        Object objectVolatile = unsafe.getObjectVolatile(this, x);
        int i5 = 1;
        k.getClass();
        List listI = nz.i(unsafe.getObjectVolatile(this, w), objectVolatile, unsafe.getObjectVolatile(this, u));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (((nx) obj) != wn.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            dk0.d();
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j2 = ((nx) next).f;
            do {
                Object next2 = it.next();
                long j3 = ((nx) next2).f;
                if (j2 > j3) {
                    next = next2;
                    j2 = j3;
                }
            } while (it.hasNext());
        }
        nx nxVar = (nx) next;
        long j4 = c.get(this);
        long jW = w();
        loop2: while (true) {
            int i6 = wn.b;
            int i7 = i4;
            while (i7 < i6) {
                i2 = i5;
                long j5 = (nxVar.f * ((long) wn.b)) + ((long) i7);
                if (j5 >= jW && j5 >= j4) {
                    break loop2;
                }
                Object objQ = nxVar.q(i7);
                Object obj2 = nxVar.k.get(i7 * 2);
                if (objQ instanceof wv) {
                    string = (j5 >= j4 || j5 < jW) ? (j5 >= jW || j5 < j4) ? "cont" : "send" : "receive";
                } else if (objQ instanceof gf2) {
                    string = (j5 >= j4 || j5 < jW) ? (j5 >= jW || j5 < j4) ? "select" : "onSend" : "onReceive";
                } else if (objQ instanceof y32) {
                    string = "receiveCatching";
                } else if (objQ instanceof k93) {
                    string = "EB(" + objQ + ')';
                } else if (g31.a(objQ, wn.f) || g31.a(objQ, wn.g)) {
                    string = "resuming_sender";
                } else {
                    if (objQ != null && !objQ.equals(wn.e) && !objQ.equals(wn.i) && !objQ.equals(wn.h) && !objQ.equals(wn.k) && !objQ.equals(wn.j) && !objQ.equals(wn.l)) {
                        string = objQ.toString();
                    }
                    i7++;
                    i5 = i2;
                }
                if (obj2 != null) {
                    sb.append("(" + string + ',' + obj2 + "),");
                } else {
                    sb.append(string + ',');
                }
                i7++;
                i5 = i2;
            }
            i2 = i5;
            nxVar = (nx) nxVar.d();
            if (nxVar == null) {
                break;
            }
            i5 = i2;
            i4 = 0;
        }
        if (cs2.B(sb) == ',') {
            sb.deleteCharAt(sb.length() - i2).getClass();
        }
        sb.append("]");
        return sb.toString();
    }

    public final Throwable u() {
        Throwable thT = t();
        return thT == null ? new cz("Channel was closed") : thT;
    }

    public final Throwable v() {
        Throwable thT = t();
        return thT == null ? new dz("Channel was closed") : thT;
    }

    public final long w() {
        return b.get(this) & 1152921504606846975L;
    }

    public final boolean x() {
        while (true) {
            j.getClass();
            Unsafe unsafe = zj.a;
            long j2 = w;
            nx nxVarQ = (nx) unsafe.getObjectVolatile(this, j2);
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j3 = atomicLongFieldUpdater.get(this);
            if (w() <= j3) {
                return false;
            }
            long j4 = wn.b;
            long j5 = j3 / j4;
            if (nxVarQ.f == j5 || (nxVarQ = q(j5, nxVarQ)) != null) {
                nxVarQ.a();
                int i2 = (int) (j3 % j4);
                while (true) {
                    Object objQ = nxVarQ.q(i2);
                    if (objQ != null && objQ != wn.e) {
                        if (objQ != wn.d) {
                            if (objQ != wn.j && objQ != wn.l && objQ != wn.i && objQ != wn.h) {
                                if (objQ != wn.g) {
                                    if (objQ == wn.f || j3 != atomicLongFieldUpdater.get(this)) {
                                        break;
                                        break;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            break;
                            break;
                            break;
                            break;
                        }
                        return true;
                    }
                    if (nxVarQ.p(i2, objQ, wn.h)) {
                        m();
                        break;
                    }
                }
                c.compareAndSet(this, j3, j3 + 1);
            } else if (((nx) unsafe.getObjectVolatile(this, j2)).f < j5) {
                return false;
            }
        }
    }

    public final void z() {
        Object objectVolatile;
        un unVar;
        loop0: while (true) {
            s.getClass();
            Unsafe unsafe = zj.a;
            long j2 = v;
            objectVolatile = unsafe.getObjectVolatile(this, j2);
            py0 py0Var = objectVolatile == null ? wn.q : wn.r;
            while (true) {
                Unsafe unsafe2 = zj.a;
                unVar = this;
                if (unsafe2.compareAndSwapObject(unVar, v, objectVolatile, py0Var)) {
                    break loop0;
                } else if (unsafe2.getObjectVolatile(unVar, j2) != objectVolatile) {
                    break;
                } else {
                    this = unVar;
                }
            }
            this = unVar;
        }
        if (objectVolatile == null) {
            return;
        }
        h33.c(1, objectVolatile);
        ((hq0) objectVolatile).j(unVar.t());
    }
}
