package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class u03 {
    public static final t03 d = new t03();
    public boolean a;
    public long b;
    public long c;

    public u03 a() {
        this.a = false;
        return this;
    }

    public u03 b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        og.n("No deadline");
        return 0L;
    }

    public u03 d(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u03 g(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j >= 0) {
            this.c = timeUnit.toNanos(j);
            return this;
        }
        og.f(j, "timeout < 0: ");
        return null;
    }

    public long h() {
        return this.c;
    }
}
