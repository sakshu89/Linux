package defpackage;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rz2 {
    public static final a50 h = new a50(3);
    public static boolean i = true;
    public final a50 a;
    public final AtomicInteger b;
    public final AtomicBoolean c;
    public final xj4 d;
    public final ns4 e;
    public final cu2 f;
    public final qz2 g;

    public rz2(ns4 ns4Var, xj4 xj4Var, qz2 qz2Var) {
        qz2Var.getClass();
        this.b = new AtomicInteger(0);
        this.c = new AtomicBoolean(false);
        this.a = h;
        this.e = ns4Var;
        this.d = xj4Var;
        this.f = new cu2(tj1.c().b());
        this.g = qz2Var;
    }

    public final et4 a(final Executor executor, final Callable callable, final wj1 wj1Var) {
        if (this.b.get() <= 0) {
            throw new IllegalStateException();
        }
        if (((et4) wj1Var.b).b()) {
            et4 et4Var = new et4();
            et4Var.f();
            return et4Var;
        }
        final uf1 uf1Var = new uf1(10);
        final iw2 iw2Var = new iw2((wj1) uf1Var.b);
        Executor executor2 = new Executor() { // from class: wj4
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RuntimeException e) {
                    if (((et4) wj1Var.b).b()) {
                        uf1Var.l();
                    } else {
                        iw2Var.a.d(e);
                    }
                    throw e;
                }
            }
        };
        this.a.d(new Runnable() { // from class: ml4
            @Override // java.lang.Runnable
            public final void run() {
                rz2 rz2Var = this.a;
                wj1 wj1Var2 = wj1Var;
                uf1 uf1Var2 = uf1Var;
                Callable callable2 = callable;
                iw2 iw2Var2 = iw2Var;
                try {
                    if (((et4) wj1Var2.b).b()) {
                        uf1Var2.l();
                        return;
                    }
                    try {
                        if (!rz2Var.c.get()) {
                            synchronized (rz2Var) {
                                rz2Var.d.zzb();
                            }
                            rz2Var.c.set(true);
                        }
                        if (((et4) wj1Var2.b).b()) {
                            uf1Var2.l();
                            return;
                        }
                        Object objCall = callable2.call();
                        if (((et4) wj1Var2.b).b()) {
                            uf1Var2.l();
                        } else {
                            iw2Var2.a.e(objCall);
                        }
                    } catch (RuntimeException e) {
                        throw new uj1("Internal error has occurred when executing ML Kit tasks", e);
                    }
                } catch (Exception e2) {
                    if (((et4) wj1Var2.b).b()) {
                        uf1Var2.l();
                    } else {
                        iw2Var2.a.d(e2);
                    }
                }
            }
        }, executor2);
        return iw2Var.a;
    }

    public final uw2 b(k11 k11Var) {
        uw2 uw2VarA;
        synchronized (this) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                uw2VarA = this.d.a(k11Var);
                c(in4.NO_ERROR, jElapsedRealtime, k11Var);
                i = false;
            } catch (uj1 e) {
                c(e.a == 14 ? in4.MODEL_NOT_DOWNLOADED : in4.UNKNOWN_ERROR, jElapsedRealtime, k11Var);
                throw e;
            }
        }
        return uw2VarA;
    }

    public final void c(in4 in4Var, long j, k11 k11Var) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.e.b(new r32(this, jElapsedRealtime, in4Var, k11Var), jn4.ON_DEVICE_TEXT_DETECT);
        b13 b13Var = new b13();
        b13Var.a = in4Var;
        b13Var.b = Boolean.valueOf(i);
        wj1 wj1Var = new wj1(27, false);
        this.g.getClass();
        wj1Var.b = tq4.LATIN;
        b13Var.c = new uq4(wj1Var);
        final f54 f54Var = new f54(b13Var);
        final py0 py0Var = new py0(28, this);
        jn4 jn4Var = jn4.UNKNOWN_EVENT;
        aa4 aa4Var = aa4.a;
        final ns4 ns4Var = this.e;
        aa4Var.execute(new Runnable() { // from class: ls4
            {
                jn4 jn4Var2 = jn4.UNKNOWN_EVENT;
            }

            @Override // java.lang.Runnable
            public final void run() {
                jn4 jn4Var2 = jn4.AGGREGATED_ON_DEVICE_TEXT_DETECTION;
                ns4 ns4Var2 = ns4Var;
                HashMap map = ns4Var2.j;
                if (!map.containsKey(jn4Var2)) {
                    zy3 zy3Var = new zy3();
                    by3 by3Var = new by3();
                    if (!zy3Var.isEmpty()) {
                        dk0.v();
                        throw null;
                    }
                    by3Var.c = zy3Var;
                    map.put(jn4Var2, by3Var);
                }
                by3 by3Var2 = (by3) map.get(jn4Var2);
                Long lValueOf = Long.valueOf(jElapsedRealtime);
                zy3 zy3Var2 = by3Var2.c;
                f54 f54Var2 = f54Var;
                Collection collection = (Collection) zy3Var2.get(f54Var2);
                if (collection == null) {
                    ArrayList arrayList = new ArrayList(3);
                    if (!arrayList.add(lValueOf)) {
                        og.m("New Collection violated the Collection spec");
                        return;
                    }
                    zy3Var2.put(f54Var2, arrayList);
                } else {
                    collection.add(lValueOf);
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (ns4Var2.d(jn4Var2, jElapsedRealtime2)) {
                    ns4Var2.i.put(jn4Var2, Long.valueOf(jElapsedRealtime2));
                    aa4.a.execute(new or0(ns4Var2, py0Var));
                }
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - jElapsedRealtime;
        cu2 cu2Var = this.f;
        int i2 = this.g.a() ? 24317 : 24306;
        int i3 = in4Var.a;
        synchronized (cu2Var) {
            AtomicLong atomicLong = (AtomicLong) cu2Var.c;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (atomicLong.get() != -1 && jElapsedRealtime2 - ((AtomicLong) cu2Var.c).get() <= 1800000) {
                return;
            }
            et4 et4VarB = ((re3) cu2Var.b).b(new ow2(0, Arrays.asList(new mj1(i2, i3, 0, j2, jCurrentTimeMillis, null, null, 0, -1))));
            fw0 fw0Var = new fw0(jElapsedRealtime2, cu2Var);
            et4VarB.getClass();
            et4VarB.b.o(new xd4(jw2.a, fw0Var));
            et4VarB.i();
        }
    }
}
