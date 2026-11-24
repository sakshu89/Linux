package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gf2 implements sv, j93 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(gf2.class, Object.class, "state$volatile");
    public static final /* synthetic */ long j = zj.a.objectFieldOffset(gf2.class.getDeclaredField("state$volatile"));
    public final j70 a;
    public Object c;
    private volatile /* synthetic */ Object state$volatile = m44.a;
    public ArrayList b = new ArrayList(2);
    public int e = -1;
    public Object f = m44.d;

    public gf2(j70 j70Var) {
        this.a = j70Var;
    }

    @Override // defpackage.j93
    public final void a(af2 af2Var, int i2) {
        this.c = af2Var;
        this.e = i2;
    }

    @Override // defpackage.sv
    public final void b(Throwable th) {
        gf2 gf2Var;
        while (true) {
            i.getClass();
            Unsafe unsafe = zj.a;
            long j2 = j;
            Object objectVolatile = unsafe.getObjectVolatile(this, j2);
            if (objectVolatile == m44.b) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = zj.a;
                gf2Var = this;
                if (unsafe2.compareAndSwapObject(gf2Var, j, objectVolatile, m44.c)) {
                    ArrayList arrayList = gf2Var.b;
                    if (arrayList == null) {
                        return;
                    }
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((ef2) obj).a();
                    }
                    gf2Var.f = m44.d;
                    gf2Var.b = null;
                    return;
                }
                if (unsafe2.getObjectVolatile(gf2Var, j2) != objectVolatile) {
                    break;
                } else {
                    this = gf2Var;
                }
            }
            this = gf2Var;
        }
    }

    public final void c(ef2 ef2Var) {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ef2 ef2Var2 = (ef2) obj;
            if (ef2Var2 != ef2Var) {
                ef2Var2.a();
            }
        }
        i.getClass();
        zj.a.putObjectVolatile(this, j, m44.b);
        this.f = m44.d;
        this.b = null;
    }

    public final Object d(y50 y50Var) {
        i.getClass();
        Object objectVolatile = zj.a.getObjectVolatile(this, j);
        objectVolatile.getClass();
        ef2 ef2Var = (ef2) objectVolatile;
        Object obj = this.f;
        c(ef2Var);
        wq0 wq0Var = ef2Var.c;
        Object obj2 = ef2Var.a;
        Object obj3 = ef2Var.d;
        Object objC = wq0Var.c(obj2, obj3, obj);
        rq0 rq0Var = ef2Var.e;
        return obj3 == m44.e ? ((hq0) rq0Var).j(y50Var) : ((vq0) rq0Var).e(objC, y50Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(y50 y50Var) {
        ff2 ff2Var;
        if (y50Var instanceof ff2) {
            ff2Var = (ff2) y50Var;
            int i2 = ff2Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ff2Var.j = i2 - Integer.MIN_VALUE;
            } else {
                ff2Var = new ff2(this, y50Var);
            }
        } else {
            ff2Var = new ff2(this, y50Var);
        }
        Object obj = ff2Var.f;
        int i3 = ff2Var.j;
        t70 t70Var = t70.a;
        if (i3 == 0) {
            bz3.g(obj);
            ff2Var.e = this;
            ff2Var.j = 1;
            if (k(ff2Var) != t70Var) {
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                bz3.g(obj);
                return obj;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = ff2Var.e;
        bz3.g(obj);
        ff2Var.e = null;
        ff2Var.j = 2;
        Object objD = this.d(ff2Var);
        return objD == t70Var ? t70Var : objD;
    }

    public final ef2 f(Object obj) {
        ArrayList arrayList = this.b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj3 = arrayList.get(i2);
            i2++;
            if (((ef2) obj3).a == obj) {
                obj2 = obj3;
                break;
            }
        }
        ef2 ef2Var = (ef2) obj2;
        if (ef2Var != null) {
            return ef2Var;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(p6 p6Var, vq0 vq0Var) {
        i(new ef2(this, p6Var.a, (wq0) p6Var.b, (wq0) p6Var.c, null, (nu2) vq0Var, (wq0) p6Var.e), false);
    }

    public final boolean h() {
        i.getClass();
        return zj.a.getObjectVolatile(this, j) instanceof ef2;
    }

    public final void i(ef2 ef2Var, boolean z) {
        Object obj = ef2Var.a;
        i.getClass();
        Unsafe unsafe = zj.a;
        long j2 = j;
        if (unsafe.getObjectVolatile(this, j2) instanceof ef2) {
            return;
        }
        if (!z) {
            ArrayList arrayList = this.b;
            arrayList.getClass();
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (((ef2) obj2).a == obj) {
                        dk0.u(obj, "Cannot use select clauses on the same object: ");
                        return;
                    }
                }
            }
        }
        ef2Var.b.c(obj, this, ef2Var.d);
        if (this.f != m44.d) {
            zj.a.putObjectVolatile(this, j2, ef2Var);
            return;
        }
        if (!z) {
            ArrayList arrayList2 = this.b;
            arrayList2.getClass();
            arrayList2.add(ef2Var);
        }
        ef2Var.g = this.c;
        ef2Var.h = this.e;
        this.c = null;
        this.e = -1;
    }

    public final int j(Object obj, Object obj2) {
        gf2 gf2Var;
        Unsafe unsafe;
        Unsafe unsafe2;
        while (true) {
            i.getClass();
            Unsafe unsafe3 = zj.a;
            long j2 = j;
            Object objectVolatile = unsafe3.getObjectVolatile(this, j2);
            if (objectVolatile instanceof wv) {
                ef2 ef2VarF = this.f(obj);
                if (ef2VarF != null) {
                    wq0 wq0Var = ef2VarF.f;
                    wq0 wq0Var2 = wq0Var != null ? (wq0) wq0Var.c(this, ef2VarF.d, obj2) : null;
                    while (true) {
                        Unsafe unsafe4 = zj.a;
                        gf2Var = this;
                        if (unsafe4.compareAndSwapObject(gf2Var, j, objectVolatile, ef2VarF)) {
                            wv wvVar = (wv) objectVolatile;
                            gf2Var.f = obj2;
                            py0 py0VarK = wvVar.k(q43.a, wq0Var2);
                            if (py0VarK == null) {
                                gf2Var.f = m44.d;
                                return 2;
                            }
                            wvVar.u(py0VarK);
                            return 0;
                        }
                        if (unsafe4.getObjectVolatile(gf2Var, j2) != objectVolatile) {
                            break;
                        }
                        this = gf2Var;
                    }
                } else {
                    continue;
                }
            } else {
                gf2Var = this;
                if (g31.a(objectVolatile, m44.b) || (objectVolatile instanceof ef2)) {
                    return 3;
                }
                if (g31.a(objectVolatile, m44.c)) {
                    return 2;
                }
                if (g31.a(objectVolatile, m44.a)) {
                    List listH = nz.h(obj);
                    do {
                        unsafe2 = zj.a;
                        if (unsafe2.compareAndSwapObject(gf2Var, j, objectVolatile, listH)) {
                            return 1;
                        }
                    } while (unsafe2.getObjectVolatile(gf2Var, j2) == objectVolatile);
                } else {
                    if (!(objectVolatile instanceof List)) {
                        og.h(objectVolatile, "Unexpected state: ");
                        return 0;
                    }
                    ArrayList arrayListF = mz.F((Collection) objectVolatile, obj);
                    do {
                        unsafe = zj.a;
                        if (unsafe.compareAndSwapObject(gf2Var, j, objectVolatile, arrayListF)) {
                            return 1;
                        }
                    } while (unsafe.getObjectVolatile(gf2Var, j2) == objectVolatile);
                }
            }
            this = gf2Var;
        }
    }

    public final Object k(ff2 ff2Var) {
        q43 q43Var;
        yv yvVar;
        Unsafe unsafe;
        yv yvVar2 = new yv(1, fp4.b(ff2Var));
        yvVar2.x();
        loop0: while (true) {
            i.getClass();
            Unsafe unsafe2 = zj.a;
            long j2 = j;
            Object objectVolatile = unsafe2.getObjectVolatile(this, j2);
            q43Var = q43.a;
            yv yvVar3 = yvVar2;
            py0 py0Var = m44.a;
            if (objectVolatile == py0Var) {
                yv yvVar4 = yvVar3;
                while (true) {
                    Unsafe unsafe3 = zj.a;
                    yvVar = yvVar4;
                    if (unsafe3.compareAndSwapObject(this, j, objectVolatile, yvVar4)) {
                        yvVar.A(this);
                        break loop0;
                    }
                    if (unsafe3.getObjectVolatile(this, j2) != objectVolatile) {
                        break;
                    }
                    yvVar4 = yvVar;
                }
                yvVar2 = yvVar;
            } else {
                yvVar = yvVar3;
                if (!(objectVolatile instanceof List)) {
                    if (!(objectVolatile instanceof ef2)) {
                        og.h(objectVolatile, "unexpected state: ");
                        return null;
                    }
                    ef2 ef2Var = (ef2) objectVolatile;
                    Object obj = this.f;
                    wq0 wq0Var = ef2Var.f;
                    yvVar.i(q43Var, wq0Var != null ? (wq0) wq0Var.c(this, ef2Var.d, obj) : null);
                    break;
                }
                do {
                    unsafe = zj.a;
                    if (unsafe.compareAndSwapObject(this, j, objectVolatile, py0Var)) {
                        Iterator it = ((Iterable) objectVolatile).iterator();
                        while (it.hasNext()) {
                            ef2 ef2VarF = f(it.next());
                            ef2VarF.getClass();
                            ef2VarF.g = null;
                            ef2VarF.h = -1;
                            i(ef2VarF, true);
                        }
                        break;
                    }
                } while (unsafe.getObjectVolatile(this, j2) == objectVolatile);
                yvVar2 = yvVar;
            }
        }
        Object objV = yvVar.v();
        return objV == t70.a ? objV : q43Var;
    }
}
