package defpackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class gh extends u03 {
    public static final ReentrantLock h;
    public static final Condition i;
    public static final long j;
    public static final long k;
    public static gh l;
    public boolean e;
    public gh f;
    public long g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        i = conditionNewCondition;
        j = 60000L;
        k = 60000000000L;
    }

    public final void i() {
        gh ghVar;
        long j2 = this.c;
        boolean z = this.a;
        if (j2 != 0 || z) {
            ReentrantLock reentrantLock = h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.e = true;
                if (l == null) {
                    l = new gh();
                    dh dhVar = new dh("Okio Watchdog");
                    dhVar.setDaemon(true);
                    dhVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j2 != 0 && z) {
                    this.g = Math.min(j2, c() - jNanoTime) + jNanoTime;
                } else if (j2 != 0) {
                    this.g = j2 + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    this.g = c();
                }
                long j3 = this.g - jNanoTime;
                gh ghVar2 = l;
                ghVar2.getClass();
                while (true) {
                    ghVar = ghVar2.f;
                    if (ghVar == null || j3 < ghVar.g - jNanoTime) {
                        break;
                        break;
                    }
                    ghVar2 = ghVar;
                }
                this.f = ghVar;
                ghVar2.f = this;
                if (ghVar2 == l) {
                    i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = h;
        reentrantLock.lock();
        try {
            if (!this.e) {
                return false;
            }
            this.e = false;
            gh ghVar = l;
            while (ghVar != null) {
                gh ghVar2 = ghVar.f;
                if (ghVar2 == this) {
                    ghVar.f = this.f;
                    this.f = null;
                    return false;
                }
                ghVar = ghVar2;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void k() {
    }
}
