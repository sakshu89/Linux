package defpackage;

import android.app.job.JobParameters;
import android.graphics.Typeface;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class or0 implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public final Object c;

    public /* synthetic */ or0(ns4 ns4Var, py0 py0Var) {
        this.a = 18;
        jn4 jn4Var = jn4.UNKNOWN_EVENT;
        this.b = ns4Var;
        this.c = py0Var;
    }

    private final void a() {
        Exception exc;
        synchronized (((xd4) this.c).c) {
            eq1 eq1Var = (eq1) ((xd4) this.c).d;
            et4 et4Var = (et4) this.b;
            synchronized (et4Var.a) {
                exc = et4Var.f;
            }
            jg1.d(exc);
            eq1Var.q(exc);
        }
    }

    private final void b() {
        rz2 rz2Var = (rz2) this.b;
        iw2 iw2Var = (iw2) this.c;
        int iDecrementAndGet = rz2Var.b.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException();
        }
        if (iDecrementAndGet == 0) {
            synchronized (rz2Var) {
                rz2.i = true;
                rz2Var.d.b();
            }
            rz2Var.c.set(false);
        }
        kq4.a.clear();
        lr4.a.clear();
        iw2Var.a.e(null);
    }

    private final void c() {
        synchronized (((xd4) this.c).c) {
            ((kq1) ((xd4) this.c).d).c(((et4) this.b).a());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        Object h72Var;
        fl4 fl4Var;
        jy0 jy0Var;
        jy0 ft4Var;
        int i = 0;
        ux3 ux3Var = null;
        try {
            switch (this.a) {
                case 0:
                    ir0 ir0Var = (ir0) this.c;
                    try {
                        ir0Var.c(oz3.b((Future) this.b));
                        return;
                    } catch (Error e) {
                        e = e;
                        ir0Var.i(e);
                        return;
                    } catch (RuntimeException e2) {
                        e = e2;
                        ir0Var.i(e);
                        return;
                    } catch (ExecutionException e3) {
                        Throwable cause = e3.getCause();
                        if (cause == null) {
                            ir0Var.i(e3);
                            return;
                        } else {
                            ir0Var.i(cause);
                            return;
                        }
                    }
                case 1:
                    py0 py0Var = (py0) this.b;
                    Typeface typeface = (Typeface) this.c;
                    ye yeVar = (ye) py0Var.b;
                    if (yeVar != null) {
                        yeVar.k(typeface);
                        return;
                    }
                    return;
                case 2:
                    try {
                        h72Var = (y02) ((xw) this.c).get();
                        break;
                    } catch (Throwable th) {
                        h72Var = new h72(th);
                    }
                    q92 q92Var = (q92) this.b;
                    Throwable thA = i72.a(h72Var);
                    q92Var.h(thA == null ? (y02) h72Var : new h72(thA));
                    return;
                case 3:
                    try {
                        xw xwVar = (xw) this.c;
                        Object objC = oz3.c((wc1) this.b);
                        tp tpVar = xwVar.b;
                        if (tpVar != null) {
                            tpVar.a(objC);
                        }
                        break;
                    } catch (CancellationException unused) {
                        ((xw) this.c).cancel(false);
                    } catch (ExecutionException e4) {
                        xw xwVar2 = (xw) this.c;
                        Throwable cause2 = e4.getCause();
                        tp tpVar2 = xwVar2.b;
                        if (tpVar2 != null) {
                            tpVar2.b(cause2);
                        }
                    }
                    return;
                case 4:
                    es1 es1Var = (es1) this.b;
                    d22 d22Var = (d22) this.c;
                    if (es1Var.b != r10.c) {
                        og.n("provide() can be called only once.");
                        return;
                    }
                    synchronized (es1Var) {
                        fl4Var = es1Var.a;
                        es1Var.a = null;
                        es1Var.b = d22Var;
                        break;
                    }
                    fl4Var.getClass();
                    return;
                case 5:
                    ia1 ia1Var = (ia1) this.b;
                    d22 d22Var2 = (d22) this.c;
                    synchronized (ia1Var) {
                        try {
                            if (ia1Var.b == null) {
                                ia1Var.a.add(d22Var2);
                            } else {
                                ia1Var.b.add(d22Var2.get());
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                case 6:
                    JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.b;
                    JobParameters jobParameters = (JobParameters) this.c;
                    int i2 = JobInfoSchedulerService.a;
                    jobInfoSchedulerService.jobFinished(jobParameters, false);
                    return;
                case 7:
                    while (true) {
                        try {
                            ((Runnable) this.b).run();
                        } catch (Throwable th3) {
                            sl4.a(gi0.a, th3);
                        }
                        try {
                            Runnable runnableP = ((vb1) this.c).P();
                            if (runnableP == null) {
                                return;
                            }
                            this.b = runnableP;
                            i++;
                            if (i >= 16) {
                                vb1 vb1Var = (vb1) this.c;
                                if (ry3.d(vb1Var.e, vb1Var)) {
                                    vb1 vb1Var2 = (vb1) this.c;
                                    ry3.c(vb1Var2.e, vb1Var2, this);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            vb1 vb1Var3 = (vb1) this.c;
                            synchronized (vb1Var3.j) {
                                vb1.k.decrementAndGet(vb1Var3);
                                throw th4;
                            }
                        }
                        break;
                    }
                    break;
                case 8:
                    ((vg0) this.b).accept(this.c);
                    return;
                case 9:
                    x30 x30Var = (x30) this.b;
                    k02 k02Var = (k02) this.c;
                    je jeVar = (je) k02Var.c;
                    wd3 wd3Var = (wd3) ((qu0) k02Var.i).j.get((se) k02Var.a);
                    if (wd3Var == null) {
                        return;
                    }
                    if (x30Var.b != 0) {
                        wd3Var.o(x30Var, null);
                        return;
                    }
                    k02Var.b = true;
                    if (jeVar.j()) {
                        if (!k02Var.b || (jy0Var = (jy0) k02Var.e) == null) {
                            return;
                        }
                        jeVar.k(jy0Var, (Set) k02Var.f);
                        return;
                    }
                    try {
                        jeVar.k(null, jeVar.a());
                        return;
                    } catch (SecurityException e5) {
                        Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                        jeVar.b("Failed to get service from broker.");
                        wd3Var.o(new x30(10), null);
                        return;
                    }
                case 10:
                    ge3 ge3Var = (ge3) this.c;
                    qe3 qe3Var = (qe3) this.b;
                    x30 x30Var2 = qe3Var.b;
                    if (x30Var2.b == 0) {
                        xe3 xe3Var = qe3Var.c;
                        jg1.d(xe3Var);
                        x30 x30Var3 = xe3Var.c;
                        if (x30Var3.b != 0) {
                            Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(x30Var3)), new Exception());
                            ge3Var.h.b(x30Var3);
                            ge3Var.g.m();
                            return;
                        }
                        k02 k02Var2 = ge3Var.h;
                        IBinder iBinder = xe3Var.b;
                        if (iBinder == null) {
                            ft4Var = null;
                        } else {
                            int i3 = q3.b;
                            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            ft4Var = iInterfaceQueryLocalInterface instanceof jy0 ? (jy0) iInterfaceQueryLocalInterface : new ft4(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                        }
                        Set set = ge3Var.e;
                        k02Var2.getClass();
                        if (ft4Var == null || set == null) {
                            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                            k02Var2.b(new x30(4));
                        } else {
                            k02Var2.e = ft4Var;
                            k02Var2.f = set;
                            if (k02Var2.b) {
                                ((je) k02Var2.c).k(ft4Var, set);
                            }
                        }
                    } else {
                        ge3Var.h.b(x30Var2);
                    }
                    ge3Var.g.m();
                    return;
                case 11:
                    ReferenceQueue referenceQueue = (ReferenceQueue) this.b;
                    while (!((Set) this.c).isEmpty()) {
                        try {
                            z14 z14Var = (z14) referenceQueue.remove();
                            if (z14Var.a.remove(z14Var)) {
                                z14Var.clear();
                                z14Var.b.getClass();
                            }
                        } catch (InterruptedException unused2) {
                        }
                    }
                    return;
                case 12:
                    Callable callable = (Callable) this.b;
                    et4 et4Var = ((iw2) this.c).a;
                    try {
                        et4Var.e(callable.call());
                        return;
                    } catch (uj1 e6) {
                        et4Var.d(e6);
                        return;
                    } catch (Exception e7) {
                        et4Var.d(new uj1("Internal error has occurred when executing ML Kit tasks", e7));
                        return;
                    }
                case 13:
                    synchronized (((xd4) this.c).c) {
                        ((cq1) ((xd4) this.c).d).r((et4) this.b);
                        break;
                    }
                    return;
                case 14:
                    a();
                    return;
                case 15:
                    b();
                    return;
                case 16:
                    c();
                    return;
                case 17:
                    a50 a50Var = (a50) this.b;
                    AtomicReference atomicReference = (AtomicReference) a50Var.e;
                    if (((Thread) atomicReference.getAndSet(Thread.currentThread())) != null) {
                        throw new IllegalStateException();
                    }
                    try {
                        ((Runnable) this.c).run();
                        atomicReference.set(null);
                        a50Var.b();
                        return;
                    } catch (Throwable th5) {
                        try {
                            atomicReference.set(null);
                            a50Var.b();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                default:
                    ns4 ns4Var = (ns4) this.b;
                    jn4 jn4Var = jn4.AGGREGATED_ON_DEVICE_TEXT_DETECTION;
                    py0 py0Var2 = (py0) this.c;
                    HashMap map = ns4Var.j;
                    by3 by3Var = (by3) map.get(jn4Var);
                    if (by3Var != null) {
                        zy3 zy3Var = by3Var.c;
                        cx3 cx3Var = by3Var.a;
                        if (cx3Var == null) {
                            cx3Var = new cx3(by3Var, zy3Var);
                            by3Var.a = cx3Var;
                        }
                        for (Object obj : cx3Var) {
                            Object arrayList = (Collection) zy3Var.get(obj);
                            if (arrayList == null) {
                                arrayList = new ArrayList(3);
                            }
                            List list = (List) arrayList;
                            ArrayList arrayList2 = new ArrayList(list instanceof RandomAccess ? new nx3(by3Var, obj, list, ux3Var) : new ux3(by3Var, obj, list, ux3Var));
                            Collections.sort(arrayList2);
                            lj1 lj1Var = new lj1(7);
                            int size = arrayList2.size();
                            long jLongValue = 0;
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj2 = arrayList2.get(i4);
                                i4++;
                                jLongValue = ((Long) obj2).longValue() + jLongValue;
                            }
                            lj1Var.d = Long.valueOf((jLongValue / ((long) arrayList2.size())) & Long.MAX_VALUE);
                            lj1Var.b = Long.valueOf(ns4.a(arrayList2, 100.0d) & Long.MAX_VALUE);
                            lj1Var.g = Long.valueOf(ns4.a(arrayList2, 75.0d) & Long.MAX_VALUE);
                            lj1Var.f = Long.valueOf(ns4.a(arrayList2, 50.0d) & Long.MAX_VALUE);
                            lj1Var.e = Long.valueOf(ns4.a(arrayList2, 25.0d) & Long.MAX_VALUE);
                            lj1Var.c = Long.valueOf(Long.MAX_VALUE & ns4.a(arrayList2, 0.0d));
                            jm4 jm4Var = new jm4(lj1Var);
                            int size2 = arrayList2.size();
                            rz2 rz2Var = (rz2) py0Var2.b;
                            f54 f54Var = (f54) obj;
                            lj1 lj1Var2 = new lj1(8);
                            lj1Var2.d = rz2Var.g.a() ? hn4.TYPE_THICK : hn4.TYPE_THIN;
                            b13 b13Var = new b13();
                            b13Var.b = Integer.valueOf(size2 & Integer.MAX_VALUE);
                            b13Var.a = f54Var;
                            b13Var.c = jm4Var;
                            lj1Var2.g = new i54(b13Var);
                            aa4.a.execute(new qa3(ns4Var, new t9(lj1Var2, 0), jn4Var, ns4Var.c(), 1));
                            ux3Var = null;
                        }
                        map.remove(jn4Var);
                        return;
                    }
                    return;
            }
        } finally {
            ((xw) this.c).j = null;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return or0.class.getSimpleName() + "," + ((ir0) this.c);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ or0(int i, Object obj, Object obj2, boolean z) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public or0(tt ttVar, q92 q92Var, xw xwVar) {
        this.a = 2;
        this.b = q92Var;
        this.c = xwVar;
    }

    public /* synthetic */ or0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }
}
