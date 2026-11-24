package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l41 implements rz0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(l41.class, "_isCompleting$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(l41.class, Object.class, "_rootCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long i;
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;
    public final eo1 a;

    static {
        Unsafe unsafe = zj.a;
        i = unsafe.objectFieldOffset(l41.class.getDeclaredField("_rootCause$volatile"));
        e = AtomicReferenceFieldUpdater.newUpdater(l41.class, Object.class, "_exceptionsHolder$volatile");
        f = unsafe.objectFieldOffset(l41.class.getDeclaredField("_exceptionsHolder$volatile"));
    }

    public l41(eo1 eo1Var, Throwable th) {
        this.a = eo1Var;
        this._rootCause$volatile = th;
    }

    public final void a(Throwable th) {
        Throwable thD = d();
        if (thD == null) {
            h(th);
            return;
        }
        if (th == thD) {
            return;
        }
        Object objB = b();
        if (objB == null) {
            g(th);
            return;
        }
        if (!(objB instanceof Throwable)) {
            if (objB instanceof ArrayList) {
                ((ArrayList) objB).add(th);
                return;
            } else {
                og.h(objB, "State is ");
                return;
            }
        }
        if (th == objB) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(objB);
        arrayList.add(th);
        g(arrayList);
    }

    public final Object b() {
        e.getClass();
        return zj.a.getObjectVolatile(this, f);
    }

    @Override // defpackage.rz0
    public final boolean c() {
        return d() == null;
    }

    public final Throwable d() {
        c.getClass();
        return (Throwable) zj.a.getObjectVolatile(this, i);
    }

    public final boolean e() {
        return d() != null;
    }

    public final ArrayList f(Throwable th) {
        ArrayList arrayList;
        Object objB = b();
        if (objB == null) {
            arrayList = new ArrayList(4);
        } else if (objB instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(objB);
            arrayList = arrayList2;
        } else {
            if (!(objB instanceof ArrayList)) {
                og.h(objB, "State is ");
                return null;
            }
            arrayList = (ArrayList) objB;
        }
        Throwable thD = d();
        if (thD != null) {
            arrayList.add(0, thD);
        }
        if (th != null && !th.equals(thD)) {
            arrayList.add(th);
        }
        g(tz3.e);
        return arrayList;
    }

    public final void g(Object obj) {
        e.getClass();
        zj.a.putObjectVolatile(this, f, obj);
    }

    @Override // defpackage.rz0
    public final eo1 getList() {
        return this.a;
    }

    public final void h(Throwable th) {
        c.getClass();
        zj.a.putObjectVolatile(this, i, th);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(e());
        sb.append(", completing=");
        sb.append(b.get(this) == 1);
        sb.append(", rootCause=");
        sb.append(d());
        sb.append(", exceptions=");
        sb.append(b());
        sb.append(", list=");
        sb.append(this.a);
        sb.append(']');
        return sb.toString();
    }
}
