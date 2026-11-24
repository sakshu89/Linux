package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wp implements wc1 {
    public final WeakReference a;
    public final vp b = new vp(this);

    public wp(tp tpVar) {
        this.a = new WeakReference(tpVar);
    }

    @Override // defpackage.wc1
    public final void a(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }

    public final boolean b(Throwable th) {
        return this.b.i(th);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        tp tpVar = (tp) this.a.get();
        boolean zCancel = this.b.cancel(z);
        if (zCancel && tpVar != null) {
            tpVar.a = null;
            tpVar.b = null;
            tpVar.c.j(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b.a instanceof p1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.isDone();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.b.get(j, timeUnit);
    }
}
