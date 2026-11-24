package defpackage;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mw2 {
    public static final mw2 h = new mw2(new wj1(new y53(cq.n(new StringBuilder(), z53.g, " TaskRunner"), true)));
    public static final Logger i;
    public final wj1 a;
    public boolean c;
    public long d;
    public int b = 10000;
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final o7 g = new o7(8, this);

    static {
        Logger logger = Logger.getLogger(mw2.class.getName());
        logger.getClass();
        i = logger;
    }

    public mw2(wj1 wj1Var) {
        this.a = wj1Var;
    }

    public static final void a(mw2 mw2Var, gw2 gw2Var) {
        byte[] bArr = z53.a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(gw2Var.a);
        try {
            long jA = gw2Var.a();
            synchronized (mw2Var) {
                mw2Var.b(gw2Var, jA);
            }
        } finally {
            synchronized (mw2Var) {
                mw2Var.b(gw2Var, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void b(gw2 gw2Var, long j) {
        byte[] bArr = z53.a;
        lw2 lw2Var = gw2Var.c;
        lw2Var.getClass();
        if (lw2Var.d != gw2Var) {
            og.n("Check failed.");
            return;
        }
        boolean z = lw2Var.f;
        lw2Var.f = false;
        lw2Var.d = null;
        this.e.remove(lw2Var);
        if (j != -1 && !z && !lw2Var.c) {
            lw2Var.d(gw2Var, j, true);
        }
        if (lw2Var.e.isEmpty()) {
            return;
        }
        this.f.add(lw2Var);
    }

    public final gw2 c() {
        long j;
        gw2 gw2Var;
        boolean z;
        byte[] bArr = z53.a;
        while (true) {
            ArrayList arrayList = this.f;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i2 = 0;
            gw2 gw2Var2 = null;
            while (true) {
                if (i2 >= size) {
                    j = jNanoTime;
                    gw2Var = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                gw2 gw2Var3 = (gw2) ((lw2) obj).e.get(0);
                j = jNanoTime;
                gw2Var = null;
                long jMax = Math.max(0L, gw2Var3.d - j);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (gw2Var2 != null) {
                        z = true;
                        break;
                    }
                    gw2Var2 = gw2Var3;
                }
                jNanoTime = j;
            }
            ArrayList arrayList2 = this.e;
            if (gw2Var2 != null) {
                byte[] bArr2 = z53.a;
                gw2Var2.d = -1L;
                lw2 lw2Var = gw2Var2.c;
                lw2Var.getClass();
                lw2Var.e.remove(gw2Var2);
                arrayList.remove(lw2Var);
                lw2Var.d = gw2Var2;
                arrayList2.add(lw2Var);
                if (z || (!this.c && !arrayList.isEmpty())) {
                    o7 o7Var = this.g;
                    o7Var.getClass();
                    ((ThreadPoolExecutor) this.a.b).execute(o7Var);
                }
                return gw2Var2;
            }
            if (this.c) {
                if (jMin >= this.d - j) {
                    return gw2Var;
                }
                notify();
                return gw2Var;
            }
            this.c = true;
            this.d = j + jMin;
            try {
                try {
                    long j2 = jMin / 1000000;
                    long j3 = jMin - (1000000 * j2);
                    if (j2 > 0 || jMin > 0) {
                        wait(j2, (int) j3);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((lw2) arrayList2.get(size2)).b();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        lw2 lw2Var2 = (lw2) arrayList.get(size3);
                        lw2Var2.b();
                        if (lw2Var2.e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
                this.c = false;
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
    }

    public final void d(lw2 lw2Var) {
        lw2Var.getClass();
        byte[] bArr = z53.a;
        if (lw2Var.d == null) {
            boolean zIsEmpty = lw2Var.e.isEmpty();
            ArrayList arrayList = this.f;
            if (zIsEmpty) {
                arrayList.remove(lw2Var);
            } else {
                arrayList.getClass();
                if (!arrayList.contains(lw2Var)) {
                    arrayList.add(lw2Var);
                }
            }
        }
        if (this.c) {
            notify();
            return;
        }
        o7 o7Var = this.g;
        o7Var.getClass();
        ((ThreadPoolExecutor) this.a.b).execute(o7Var);
    }

    public final lw2 e() {
        int i2;
        synchronized (this) {
            i2 = this.b;
            this.b = i2 + 1;
        }
        return new lw2(this, ky0.h(i2, "Q"));
    }
}
