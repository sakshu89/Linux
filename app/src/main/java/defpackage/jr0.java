package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class jr0 implements wc1 {
    public final wc1 a;
    public tp b;

    public jr0() {
        this.a = hg4.a(new uf1(21, this));
    }

    public static jr0 b(wc1 wc1Var) {
        return wc1Var instanceof jr0 ? (jr0) wc1Var : new jr0(wc1Var);
    }

    @Override // defpackage.wc1
    public final void a(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.a.get(j, timeUnit);
    }

    public jr0(wc1 wc1Var) {
        wc1Var.getClass();
        this.a = wc1Var;
    }
}
