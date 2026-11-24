package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class et4 {
    public final Object a = new Object();
    public final s9 b = new s9();
    public boolean c;
    public volatile boolean d;
    public Object e;
    public Exception f;

    public final Object a() {
        Object obj;
        synchronized (this.a) {
            try {
                jg1.f("Task is not yet complete", this.c);
                if (this.d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new b10(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.c && !this.d && this.f == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void d(Exception exc) {
        jg1.e(exc, "Exception must not be null");
        synchronized (this.a) {
            h();
            this.c = true;
            this.f = exc;
        }
        this.b.q(this);
    }

    public final void e(Object obj) {
        synchronized (this.a) {
            h();
            this.c = true;
            this.e = obj;
        }
        this.b.q(this);
    }

    public final void f() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                this.d = true;
                this.b.q(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g(Object obj) {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.e = obj;
                this.b.q(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        Exception exc;
        String strConcat;
        if (this.c) {
            if (!b()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.a) {
                exc = this.f;
            }
            if (exc != null) {
                strConcat = "failure";
            } else if (c()) {
                strConcat = "result ".concat(String.valueOf(a()));
            } else {
                strConcat = this.d ? "cancellation" : "unknown issue";
            }
        }
    }

    public final void i() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    this.b.q(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
