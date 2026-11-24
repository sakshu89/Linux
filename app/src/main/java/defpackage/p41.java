package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class p41 implements f41 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p41.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b;
    public static final /* synthetic */ long c;
    public static final /* synthetic */ long e;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        Unsafe unsafe = zj.a;
        e = unsafe.objectFieldOffset(p41.class.getDeclaredField("_state$volatile"));
        b = AtomicReferenceFieldUpdater.newUpdater(p41.class, Object.class, "_parentHandle$volatile");
        c = unsafe.objectFieldOffset(p41.class.getDeclaredField("_parentHandle$volatile"));
    }

    public p41(boolean z) {
        this._state$volatile = z ? tz3.g : tz3.f;
    }

    public static tx e0(re1 re1Var) {
        while (re1Var.m()) {
            re1Var = re1Var.l();
        }
        while (true) {
            re1Var = re1Var.k();
            if (!re1Var.m()) {
                if (re1Var instanceof tx) {
                    return (tx) re1Var;
                }
                if (re1Var instanceof eo1) {
                    return null;
                }
            }
        }
    }

    public static String n0(Object obj) {
        if (!(obj instanceof l41)) {
            if (obj instanceof rz0) {
                return ((rz0) obj).c() ? "Active" : "New";
            }
            return obj instanceof a10 ? "Cancelled" : "Completed";
        }
        l41 l41Var = (l41) obj;
        if (l41Var.e()) {
            return "Cancelling";
        }
        return l41.b.get(l41Var) == 1 ? "Completing" : "Active";
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c A[PHI: r0
      0x003c: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v9 java.lang.Object) binds: [B:3:0x0008, B:16:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x004b, B:26:0x0056, B:31:0x005e, B:33:0x0067, B:34:0x006b), top: B:71:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:31:0x005e A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x004b, B:26:0x0056, B:31:0x005e, B:33:0x0067, B:34:0x006b), top: B:71:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0067 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:24:0x004b, B:26:0x0056, B:31:0x005e, B:33:0x0067, B:34:0x006b), top: B:71:0x004b }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0040, please report this as an issue */
    public final boolean A(Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thL;
        Object objU;
        Throwable thD;
        py0 py0Var;
        rz0 rz0Var;
        Object objQ0;
        Object objQ1 = tz3.a;
        if (R()) {
            do {
                Object objU2 = U();
                if (objU2 instanceof rz0) {
                    if (objU2 instanceof l41) {
                        if (l41.b.get((l41) objU2) == 1) {
                        }
                    }
                    objQ1 = q0(objU2, new a10(L(obj), false));
                }
                objQ1 = tz3.a;
                break;
            } while (objQ1 == tz3.c);
            if (objQ1 != tz3.b) {
                if (objQ1 == tz3.a) {
                    thL = null;
                    while (true) {
                        objU = U();
                        if (objU instanceof l41) {
                            synchronized (objU) {
                                if (((l41) objU).b() == tz3.e) {
                                    py0Var = tz3.d;
                                } else {
                                    boolean zE = ((l41) objU).e();
                                    if (thL == null) {
                                        thL = L(obj);
                                    }
                                    ((l41) objU).a(thL);
                                    thD = zE ? null : ((l41) objU).d();
                                    if (thD != null) {
                                        f0(((l41) objU).a, thD);
                                    }
                                    py0Var = tz3.a;
                                }
                            }
                        } else if (objU instanceof rz0) {
                            if (thL == null) {
                                thL = L(obj);
                            }
                            rz0Var = (rz0) objU;
                            if (rz0Var.c()) {
                                objQ0 = q0(objU, new a10(thL, false));
                                if (objQ0 != tz3.a) {
                                    og.h(objU, "Cannot happen in ");
                                    return false;
                                }
                                if (objQ0 != tz3.c) {
                                    objQ1 = objQ0;
                                    break;
                                }
                            } else if (p0(rz0Var, thL)) {
                                py0Var = tz3.a;
                            }
                        } else {
                            py0Var = tz3.d;
                        }
                        objQ1 = py0Var;
                        break;
                    }
                }
                if (objQ1 != tz3.a && objQ1 != tz3.b) {
                    if (objQ1 == tz3.d) {
                        return false;
                    }
                    t(objQ1);
                    return true;
                }
            }
        } else {
            if (objQ1 == tz3.a) {
                thL = null;
                while (true) {
                    objU = U();
                    if (objU instanceof l41) {
                        synchronized (objU) {
                            if (((l41) objU).b() == tz3.e) {
                                py0Var = tz3.d;
                            } else {
                                boolean zE2 = ((l41) objU).e();
                                if (thL == null) {
                                    thL = L(obj);
                                }
                                ((l41) objU).a(thL);
                                if (zE2) {
                                }
                                if (thD != null) {
                                    f0(((l41) objU).a, thD);
                                }
                                py0Var = tz3.a;
                            }
                        }
                    } else if (objU instanceof rz0) {
                        if (thL == null) {
                            thL = L(obj);
                        }
                        rz0Var = (rz0) objU;
                        if (rz0Var.c()) {
                            objQ0 = q0(objU, new a10(thL, false));
                            if (objQ0 != tz3.a) {
                                og.h(objU, "Cannot happen in ");
                                return false;
                            }
                            if (objQ0 != tz3.c) {
                                objQ1 = objQ0;
                                break;
                            }
                        } else if (p0(rz0Var, thL)) {
                            py0Var = tz3.a;
                        }
                    } else {
                        py0Var = tz3.d;
                    }
                    objQ1 = py0Var;
                    break;
                }
            }
            if (objQ1 != tz3.a) {
                if (objQ1 == tz3.d) {
                    return false;
                }
                t(objQ1);
                return true;
            }
        }
        return true;
    }

    public void B(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        A(cancellationException);
    }

    @Override // defpackage.f41
    public final rd0 C(hq0 hq0Var) {
        return Y(true, new u31(hq0Var));
    }

    @Override // defpackage.j70
    public final j70 D(i70 i70Var) {
        return pl4.b(this, i70Var);
    }

    public final boolean F(Throwable th) {
        if (a0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        sx sxVarT = T();
        if (sxVarT == null || sxVarT == jo1.a) {
            return z;
        }
        return sxVarT.b(th) || z;
    }

    public String G() {
        return "Job was cancelled";
    }

    @Override // defpackage.f41
    public final Object H(y50 y50Var) {
        Object objU;
        q43 q43Var;
        do {
            objU = U();
            boolean z = objU instanceof rz0;
            q43Var = q43.a;
            if (!z) {
                hp4.b(y50Var.f());
                return q43Var;
            }
        } while (m0(objU) < 0);
        yv yvVar = new yv(1, fp4.b(y50Var));
        yvVar.x();
        yvVar.A(new rv(1, hp4.d(this, true, new m72(yvVar))));
        Object objV = yvVar.v();
        t70 t70Var = t70.a;
        if (objV != t70Var) {
            objV = q43Var;
        }
        return objV == t70Var ? objV : q43Var;
    }

    public boolean I(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return A(th) && P();
    }

    public final void J(rz0 rz0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        sx sxVarT = T();
        if (sxVarT != null) {
            sxVarT.a();
            l0(jo1.a);
        }
        b10 b10Var = null;
        a10 a10Var = obj instanceof a10 ? (a10) obj : null;
        Throwable th = a10Var != null ? a10Var.a : null;
        if (rz0Var instanceof i41) {
            try {
                ((i41) rz0Var).r(th);
                return;
            } catch (Throwable th2) {
                W(new b10("Exception in completion handler " + rz0Var + " for " + this, th2));
                return;
            }
        }
        eo1 list = rz0Var.getList();
        if (list != null) {
            list.d(new rc1(1), 1);
            Object objJ = list.j();
            objJ.getClass();
            for (re1 re1VarK = (re1) objJ; !re1VarK.equals(list); re1VarK = re1VarK.k()) {
                if (re1VarK instanceof i41) {
                    try {
                        ((i41) re1VarK).r(th);
                    } catch (Throwable th3) {
                        if (b10Var != null) {
                            gn4.a(b10Var, th3);
                        } else {
                            b10Var = new b10("Exception in completion handler " + re1VarK + " for " + this, th3);
                        }
                    }
                }
            }
            if (b10Var != null) {
                W(b10Var);
            }
        }
    }

    @Override // defpackage.f41
    public final rd0 K(boolean z, boolean z2, q0 q0Var) {
        return Y(z2, z ? new t31(q0Var) : new u31(q0Var));
    }

    public final Throwable L(Object obj) {
        Throwable thD;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        p41 p41Var = (p41) obj;
        Object objU = p41Var.U();
        if (objU instanceof l41) {
            thD = ((l41) objU).d();
        } else if (objU instanceof a10) {
            thD = ((a10) objU).a;
        } else {
            if (objU instanceof rz0) {
                og.h(objU, "Cannot be cancelling child in this state: ");
                return null;
            }
            thD = null;
        }
        CancellationException cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        return cancellationException == null ? new g41("Parent job is ".concat(n0(objU)), thD, p41Var) : cancellationException;
    }

    public final Object M(l41 l41Var, Object obj) throws Throwable {
        Throwable th;
        p41 p41Var;
        l41 l41Var2;
        a10 a10Var = obj instanceof a10 ? (a10) obj : null;
        Throwable th2 = a10Var != null ? a10Var.a : null;
        synchronized (l41Var) {
            try {
                l41Var.e();
                ArrayList arrayListF = l41Var.f(th2);
                Throwable thO = O(l41Var, arrayListF);
                if (thO != null) {
                    try {
                        if (arrayListF.size() > 1) {
                            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                            int size = arrayListF.size();
                            int i = 0;
                            while (i < size) {
                                Object obj2 = arrayListF.get(i);
                                i++;
                                Throwable th3 = (Throwable) obj2;
                                if (th3 != thO && th3 != thO && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                                    gn4.a(thO, th3);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
                if (thO != null && thO != th2) {
                    obj = new a10(thO, false);
                }
                if (thO != null && (F(thO) || V(thO))) {
                    obj.getClass();
                    a10.b.compareAndSet((a10) obj, 0, 1);
                }
                g0(obj);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                Object sz0Var = obj instanceof rz0 ? new sz0((rz0) obj) : obj;
                while (true) {
                    atomicReferenceFieldUpdater.getClass();
                    Unsafe unsafe = zj.a;
                    long j = e;
                    p41Var = this;
                    l41Var2 = l41Var;
                    if (unsafe.compareAndSwapObject(p41Var, j, l41Var2, sz0Var) || unsafe.getObjectVolatile(p41Var, j) != l41Var2) {
                        break;
                    }
                    this = p41Var;
                    l41Var = l41Var2;
                }
                p41Var.J(l41Var2, obj);
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public final Object N() throws Throwable {
        Object objU = U();
        if (objU instanceof rz0) {
            og.n("This job has not completed yet");
            return null;
        }
        if (objU instanceof a10) {
            throw ((a10) objU).a;
        }
        return tz3.e(objU);
    }

    public final Throwable O(l41 l41Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (l41Var.e()) {
                return new g41(G(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        do {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i2);
            i2++;
        } while (((Throwable) obj) instanceof CancellationException);
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof v03) {
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof v03)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean P() {
        return true;
    }

    public final p6 Q() {
        n41 n41Var = n41.k;
        h33.c(3, n41Var);
        o41 o41Var = o41.k;
        h33.c(3, o41Var);
        return new p6(this, n41Var, o41Var, null);
    }

    public boolean R() {
        return this instanceof x00;
    }

    public final eo1 S(rz0 rz0Var) {
        eo1 list = rz0Var.getList();
        if (list != null) {
            return list;
        }
        if (rz0Var instanceof di0) {
            return new eo1();
        }
        if (rz0Var instanceof i41) {
            j0((i41) rz0Var);
            return null;
        }
        og.h(rz0Var, "State should have list: ");
        return null;
    }

    public final sx T() {
        b.getClass();
        return (sx) zj.a.getObjectVolatile(this, c);
    }

    public final Object U() {
        a.getClass();
        return zj.a.getObjectVolatile(this, e);
    }

    public boolean V(Throwable th) {
        return false;
    }

    public final void X(f41 f41Var) {
        jo1 jo1Var = jo1.a;
        if (f41Var == null) {
            l0(jo1Var);
            return;
        }
        f41Var.start();
        sx sxVarQ = f41Var.q(this);
        l0(sxVarQ);
        if (Z()) {
            sxVarQ.a();
            l0(jo1Var);
        }
    }

    public final rd0 Y(boolean z, i41 i41Var) {
        p41 p41Var;
        i41 i41Var2;
        boolean zD;
        i41Var.j = this;
        loop0: while (true) {
            Object objU = this.U();
            if (!(objU instanceof di0)) {
                p41Var = this;
                i41Var2 = i41Var;
                boolean z2 = objU instanceof rz0;
                jo1 jo1Var = jo1.a;
                if (z2) {
                    rz0 rz0Var = (rz0) objU;
                    eo1 list = rz0Var.getList();
                    if (list == null) {
                        p41Var.j0((i41) objU);
                    } else {
                        if (i41Var2.q()) {
                            l41 l41Var = rz0Var instanceof l41 ? (l41) rz0Var : null;
                            Throwable thD = l41Var != null ? l41Var.d() : null;
                            if (thD == null) {
                                zD = list.d(i41Var2, 5);
                            } else if (z) {
                                i41Var2.r(thD);
                                return jo1Var;
                            }
                        } else {
                            zD = list.d(i41Var2, 1);
                        }
                        if (zD) {
                            break;
                        }
                    }
                    this = p41Var;
                    i41Var = i41Var2;
                } else if (z) {
                    Object objU2 = p41Var.U();
                    a10 a10Var = objU2 instanceof a10 ? (a10) objU2 : null;
                    i41Var2.r(a10Var != null ? a10Var.a : null);
                }
                return jo1Var;
            }
            di0 di0Var = (di0) objU;
            if (di0Var.a) {
                while (true) {
                    a.getClass();
                    Unsafe unsafe = zj.a;
                    long j = e;
                    p41Var = this;
                    i41Var2 = i41Var;
                    if (unsafe.compareAndSwapObject(p41Var, j, objU, i41Var2)) {
                        break loop0;
                    }
                    if (unsafe.getObjectVolatile(p41Var, j) != objU) {
                        break;
                    }
                    this = p41Var;
                    i41Var = i41Var2;
                }
            } else {
                p41Var = this;
                i41Var2 = i41Var;
                p41Var.i0(di0Var);
            }
            this = p41Var;
            i41Var = i41Var2;
        }
        return i41Var2;
    }

    public final boolean Z() {
        return !(U() instanceof rz0);
    }

    public boolean a0() {
        return this instanceof ql;
    }

    public final boolean b0(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objQ0;
        do {
            objQ0 = q0(U(), obj);
            if (objQ0 == tz3.a) {
                return false;
            }
            if (objQ0 == tz3.b) {
                return true;
            }
        } while (objQ0 == tz3.c);
        t(objQ0);
        return true;
    }

    @Override // defpackage.f41
    public boolean c() {
        Object objU = U();
        return (objU instanceof rz0) && ((rz0) objU).c();
    }

    public final Object c0(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objQ0;
        do {
            objQ0 = q0(U(), obj);
            if (objQ0 == tz3.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                a10 a10Var = obj instanceof a10 ? (a10) obj : null;
                throw new IllegalStateException(str, a10Var != null ? a10Var.a : null);
            }
        } while (objQ0 == tz3.c);
        return objQ0;
    }

    public String d0() {
        return getClass().getSimpleName();
    }

    @Override // defpackage.f41
    public void e(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        if (cancellationException == null) {
            cancellationException = new g41(G(), null, this);
        }
        B(cancellationException);
    }

    public final void f0(eo1 eo1Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        eo1Var.d(new rc1(4), 4);
        Object objJ = eo1Var.j();
        objJ.getClass();
        b10 b10Var = null;
        for (re1 re1VarK = (re1) objJ; !re1VarK.equals(eo1Var); re1VarK = re1VarK.k()) {
            if ((re1VarK instanceof i41) && ((i41) re1VarK).q()) {
                try {
                    ((i41) re1VarK).r(th);
                } catch (Throwable th2) {
                    if (b10Var != null) {
                        gn4.a(b10Var, th2);
                    } else {
                        b10Var = new b10("Exception in completion handler " + re1VarK + " for " + this, th2);
                    }
                }
            }
        }
        if (b10Var != null) {
            W(b10Var);
        }
        F(th);
    }

    @Override // defpackage.h70
    public final i70 getKey() {
        return nr4.k;
    }

    public final void i0(di0 di0Var) {
        eo1 eo1Var = new eo1();
        Object qz0Var = di0Var.a ? eo1Var : new qz0(eo1Var);
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = e;
            p41 p41Var = this;
            di0 di0Var2 = di0Var;
            if (unsafe.compareAndSwapObject(p41Var, j, di0Var2, qz0Var) || unsafe.getObjectVolatile(p41Var, j) != di0Var2) {
                return;
            }
            this = p41Var;
            di0Var = di0Var2;
        }
    }

    public Object j() {
        return N();
    }

    public final void j0(i41 i41Var) {
        i41Var.f(new eo1());
        re1 re1VarK = i41Var.k();
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = e;
            p41 p41Var = this;
            i41 i41Var2 = i41Var;
            if (unsafe.compareAndSwapObject(p41Var, j, i41Var2, re1VarK) || unsafe.getObjectVolatile(p41Var, j) != i41Var2) {
                return;
            }
            this = p41Var;
            i41Var = i41Var2;
        }
    }

    public final void k0(i41 i41Var) {
        p41 p41Var;
        while (true) {
            Object objU = this.U();
            if (!(objU instanceof i41)) {
                if (!(objU instanceof rz0) || ((rz0) objU).getList() == null) {
                    return;
                }
                i41Var.n();
                return;
            }
            if (objU != i41Var) {
                return;
            }
            while (true) {
                a.getClass();
                Unsafe unsafe = zj.a;
                long j = e;
                p41Var = this;
                if (unsafe.compareAndSwapObject(p41Var, j, objU, tz3.g)) {
                    return;
                }
                if (unsafe.getObjectVolatile(p41Var, j) != objU) {
                    break;
                } else {
                    this = p41Var;
                }
            }
            this = p41Var;
        }
    }

    public final void l0(sx sxVar) {
        b.getClass();
        zj.a.putObjectVolatile(this, c, sxVar);
    }

    public final int m0(Object obj) {
        Unsafe unsafe;
        boolean z = obj instanceof di0;
        long j = e;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        if (!z) {
            p41 p41Var = this;
            Object obj2 = obj;
            if (!(obj2 instanceof qz0)) {
                return 0;
            }
            eo1 eo1Var = ((qz0) obj2).a;
            do {
                atomicReferenceFieldUpdater.getClass();
                p41 p41Var2 = p41Var;
                unsafe = zj.a;
                Object obj3 = obj2;
                boolean zCompareAndSwapObject = unsafe.compareAndSwapObject(p41Var2, e, obj3, eo1Var);
                p41Var = p41Var2;
                obj2 = obj3;
                if (zCompareAndSwapObject) {
                    p41Var.h0();
                    return 1;
                }
            } while (unsafe.getObjectVolatile(p41Var, j) == obj2);
            return -1;
        }
        if (((di0) obj).a) {
            return 0;
        }
        while (true) {
            atomicReferenceFieldUpdater.getClass();
            Unsafe unsafe2 = zj.a;
            p41 p41Var3 = this;
            Object obj4 = obj;
            if (unsafe2.compareAndSwapObject(p41Var3, e, obj4, tz3.g)) {
                p41Var3.h0();
                return 1;
            }
            if (unsafe2.getObjectVolatile(p41Var3, j) != obj4) {
                return -1;
            }
            this = p41Var3;
            obj = obj4;
        }
    }

    public final boolean o0(rz0 rz0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object sz0Var = obj instanceof rz0 ? new sz0((rz0) obj) : obj;
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = e;
            p41 p41Var = this;
            rz0 rz0Var2 = rz0Var;
            if (unsafe.compareAndSwapObject(p41Var, j, rz0Var2, sz0Var)) {
                p41Var.g0(obj);
                p41Var.J(rz0Var2, obj);
                return true;
            }
            if (unsafe.getObjectVolatile(p41Var, j) != rz0Var2) {
                return false;
            }
            this = p41Var;
            rz0Var = rz0Var2;
        }
    }

    public final boolean p0(rz0 rz0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        eo1 eo1VarS = S(rz0Var);
        if (eo1VarS == null) {
            return false;
        }
        l41 l41Var = new l41(eo1VarS, th);
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = e;
            p41 p41Var = this;
            rz0 rz0Var2 = rz0Var;
            if (unsafe.compareAndSwapObject(p41Var, j, rz0Var2, l41Var)) {
                p41Var.f0(eo1VarS, th);
                return true;
            }
            if (unsafe.getObjectVolatile(p41Var, j) != rz0Var2) {
                return false;
            }
            this = p41Var;
            rz0Var = rz0Var2;
        }
    }

    @Override // defpackage.f41
    public final sx q(p41 p41Var) {
        p41 p41Var2;
        tx txVar = new tx(p41Var);
        txVar.j = this;
        loop0: while (true) {
            Object objU = this.U();
            if (objU instanceof di0) {
                di0 di0Var = (di0) objU;
                if (di0Var.a) {
                    while (true) {
                        a.getClass();
                        Unsafe unsafe = zj.a;
                        long j = e;
                        p41Var2 = this;
                        if (unsafe.compareAndSwapObject(p41Var2, j, objU, txVar)) {
                            break loop0;
                        }
                        if (unsafe.getObjectVolatile(p41Var2, j) != objU) {
                            break;
                        }
                        this = p41Var2;
                    }
                } else {
                    p41Var2 = this;
                    p41Var2.i0(di0Var);
                }
                this = p41Var2;
            } else {
                p41Var2 = this;
                boolean z = objU instanceof rz0;
                jo1 jo1Var = jo1.a;
                Throwable thD = null;
                if (!z) {
                    Object objU2 = p41Var2.U();
                    a10 a10Var = objU2 instanceof a10 ? (a10) objU2 : null;
                    txVar.r(a10Var != null ? a10Var.a : null);
                    return jo1Var;
                }
                eo1 list = ((rz0) objU).getList();
                if (list != null) {
                    if (list.d(txVar, 7)) {
                        break;
                    }
                    boolean zD = list.d(txVar, 3);
                    Object objU3 = p41Var2.U();
                    if (objU3 instanceof l41) {
                        thD = ((l41) objU3).d();
                    } else {
                        a10 a10Var2 = objU3 instanceof a10 ? (a10) objU3 : null;
                        if (a10Var2 != null) {
                            thD = a10Var2.a;
                        }
                    }
                    txVar.r(thD);
                    if (zD) {
                        break;
                    }
                    return jo1Var;
                }
                p41Var2.j0((i41) objU);
                this = p41Var2;
            }
        }
        return txVar;
    }

    public final Object q0(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (!(obj instanceof rz0)) {
            return tz3.a;
        }
        if (((obj instanceof di0) || (obj instanceof i41)) && !(obj instanceof tx) && !(obj2 instanceof a10)) {
            return o0((rz0) obj, obj2) ? obj2 : tz3.c;
        }
        rz0 rz0Var = (rz0) obj;
        eo1 eo1VarS = S(rz0Var);
        if (eo1VarS == null) {
            return tz3.c;
        }
        l41 l41Var = rz0Var instanceof l41 ? (l41) rz0Var : null;
        if (l41Var == null) {
            l41Var = new l41(eo1VarS, null);
        }
        synchronized (l41Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = l41.b;
            if (atomicIntegerFieldUpdater.get(l41Var) == 1) {
                return tz3.a;
            }
            atomicIntegerFieldUpdater.set(l41Var, 1);
            if (l41Var != rz0Var) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, rz0Var, l41Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != rz0Var) {
                        return tz3.c;
                    }
                }
            }
            boolean zE = l41Var.e();
            a10 a10Var = obj2 instanceof a10 ? (a10) obj2 : null;
            if (a10Var != null) {
                l41Var.a(a10Var.a);
            }
            Throwable thD = zE ? null : l41Var.d();
            if (thD != null) {
                f0(eo1VarS, thD);
            }
            tx txVarE0 = e0(eo1VarS);
            if (txVarE0 != null && r0(l41Var, txVarE0, obj2)) {
                return tz3.b;
            }
            eo1VarS.d(new rc1(2), 2);
            tx txVarE1 = e0(eo1VarS);
            return (txVarE1 == null || !r0(l41Var, txVarE1, obj2)) ? M(l41Var, obj2) : tz3.b;
        }
    }

    @Override // defpackage.j70
    public final j70 r(j70 j70Var) {
        return pl4.c(this, j70Var);
    }

    public final boolean r0(l41 l41Var, tx txVar, Object obj) {
        while (hp4.d(txVar.k, false, new k41(this, l41Var, txVar, obj)) == jo1.a) {
            txVar = e0(txVar);
            if (txVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.f41
    public final boolean start() {
        int iM0;
        do {
            iM0 = m0(U());
            if (iM0 == 0) {
                return false;
            }
        } while (iM0 != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(d0() + '{' + n0(U()) + '}');
        sb.append('@');
        sb.append(ba0.c(this));
        return sb.toString();
    }

    @Override // defpackage.j70
    public final h70 v(i70 i70Var) {
        return pl4.a(this, i70Var);
    }

    @Override // defpackage.f41
    public final CancellationException x() {
        CancellationException cancellationException;
        Object objU = U();
        if (objU instanceof l41) {
            Throwable thD = ((l41) objU).d();
            if (thD == null) {
                og.h(this, "Job is still new or active: ");
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
            return cancellationException == null ? new g41(strConcat, thD, this) : cancellationException;
        }
        if (objU instanceof rz0) {
            og.h(this, "Job is still new or active: ");
            return null;
        }
        if (!(objU instanceof a10)) {
            return new g41(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((a10) objU).a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new g41(G(), th, this) : cancellationException;
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        return vq0Var.e(obj, this);
    }

    public void z(Object obj) {
        t(obj);
    }

    public void h0() {
    }

    public void W(b10 b10Var) {
        throw b10Var;
    }

    public void g0(Object obj) {
    }

    public void t(Object obj) {
    }
}
