package defpackage;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xx0 implements wk2 {
    public final boolean a;
    public final ln b = new ln();
    public boolean c;
    public final /* synthetic */ ay0 e;

    public xx0(ay0 ay0Var, boolean z) {
        this.e = ay0Var;
        this.a = z;
    }

    public final void c(boolean z) {
        long jMin;
        boolean z2;
        ay0 ay0Var = this.e;
        synchronized (ay0Var) {
            ay0Var.l.i();
            while (ay0Var.e >= ay0Var.f && !this.a && !this.c) {
                try {
                    synchronized (ay0Var) {
                        int i = ay0Var.m;
                        if (i != 0) {
                            break;
                        }
                        try {
                            ay0Var.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    ay0Var.l.l();
                    throw th;
                }
            }
            ay0Var.l.l();
            ay0Var.b();
            jMin = Math.min(ay0Var.f - ay0Var.e, this.b.b);
            ay0Var.e += jMin;
            z2 = z && jMin == this.b.b;
        }
        this.e.l.i();
        try {
            ay0 ay0Var2 = this.e;
            ay0Var2.b.r(ay0Var2.a, z2, this.b, jMin);
        } finally {
            this.e.l.l();
        }
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z;
        ay0 ay0Var = this.e;
        byte[] bArr = z53.a;
        synchronized (ay0Var) {
            if (this.c) {
                return;
            }
            synchronized (ay0Var) {
                z = ay0Var.m == 0;
            }
            ay0 ay0Var2 = this.e;
            if (!ay0Var2.j.a) {
                if (this.b.b > 0) {
                    while (this.b.b > 0) {
                        c(true);
                    }
                } else if (z) {
                    ay0Var2.b.r(ay0Var2.a, true, null, 0L);
                }
            }
            synchronized (this.e) {
                this.c = true;
            }
            this.e.b.flush();
            this.e.a();
        }
    }

    @Override // defpackage.wk2
    public final u03 d() {
        return this.e.l;
    }

    @Override // defpackage.wk2, java.io.Flushable
    public final void flush() {
        ay0 ay0Var = this.e;
        byte[] bArr = z53.a;
        synchronized (ay0Var) {
            ay0Var.b();
        }
        while (this.b.b > 0) {
            c(false);
            this.e.b.flush();
        }
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) {
        byte[] bArr = z53.a;
        ln lnVar2 = this.b;
        lnVar2.u(j, lnVar);
        while (lnVar2.b >= 16384) {
            c(false);
        }
    }
}
