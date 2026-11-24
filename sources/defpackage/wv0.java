package defpackage;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wv0 implements RunnableScheduledFuture {
    public final AtomicReference a = new AtomicReference(null);
    public final long b;
    public final Callable c;
    public final wp e;

    public wv0(Handler handler, long j, Callable callable) {
        this.b = j;
        this.c = callable;
        this.e = hg4.a(new kf(this, handler, callable, 13, false));
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.e.cancel(z);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.e.b.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.e.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.e.b.isDone();
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public final boolean isPeriodic() {
        return false;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        tp tpVar = (tp) this.a.getAndSet(null);
        if (tpVar != null) {
            try {
                tpVar.a(this.c.call());
            } catch (Exception e) {
                tpVar.b(e);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.e.b.get(j, timeUnit);
    }
}
