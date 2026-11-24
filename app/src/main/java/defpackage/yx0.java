package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yx0 implements fp2 {
    public final long a;
    public boolean b;
    public final ln c = new ln();
    public final ln e = new ln();
    public boolean f;
    public final /* synthetic */ ay0 i;

    public yx0(ay0 ay0Var, long j, boolean z) {
        this.i = ay0Var;
        this.a = j;
        this.b = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j;
        ay0 ay0Var = this.i;
        synchronized (ay0Var) {
            this.f = true;
            ln lnVar = this.e;
            j = lnVar.b;
            lnVar.skip(j);
            ay0Var.notifyAll();
        }
        if (j > 0) {
            ay0 ay0Var2 = this.i;
            byte[] bArr = z53.a;
            ay0Var2.b.q(j);
        }
        this.i.a();
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.i.k;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x002f A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x003c A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006b A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:5:0x0008, B:7:0x000b, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:15:0x0019, B:17:0x001c, B:19:0x001f, B:23:0x0027, B:26:0x002a, B:27:0x002b, B:29:0x002f, B:31:0x003c, B:33:0x0050, B:35:0x005f, B:36:0x006b, B:39:0x0071, B:42:0x0077, B:43:0x0083, B:56:0x0099, B:57:0x00a0, B:60:0x00a3, B:6:0x0009, B:16:0x001a), top: B:67:0x0008, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0099 A[SYNTHETIC] */
    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws Throwable {
        int i;
        Throwable th;
        ln lnVar2;
        long j2;
        boolean z;
        long jF;
        long j3;
        do {
            ay0 ay0Var = this.i;
            synchronized (ay0Var) {
                ay0Var.k.i();
                try {
                    synchronized (ay0Var) {
                        i = ay0Var.m;
                    }
                } catch (Throwable th2) {
                    ay0Var.k.l();
                    throw th2;
                }
            }
            th = null;
            if (i != 0 && !this.b) {
                Throwable wr2Var = ay0Var.n;
                if (wr2Var == null) {
                    synchronized (ay0Var) {
                        int i2 = ay0Var.m;
                        if (i2 == 0) {
                            throw null;
                        }
                        wr2Var = new wr2(i2);
                    }
                }
                th = wr2Var;
                if (!this.f) {
                    throw new IOException("stream closed");
                }
                lnVar2 = this.e;
                j2 = lnVar2.b;
                z = false;
                if (j2 > 0) {
                    jF = lnVar2.f(Math.min(8192L, j2), lnVar);
                    long j4 = ay0Var.c + jF;
                    ay0Var.c = j4;
                    j3 = j4 - ay0Var.d;
                    if (th == null) {
                        ay0Var.b.w(ay0Var.a, j3);
                        ay0Var.d = ay0Var.c;
                    }
                } else {
                    if (!this.b) {
                        ay0Var.wait();
                        z = true;
                    }
                    jF = -1;
                }
                ay0Var.k.l();
            } else {
                if (!this.f) {
                    throw new IOException("stream closed");
                }
                lnVar2 = this.e;
                j2 = lnVar2.b;
                z = false;
                if (j2 > 0) {
                    jF = lnVar2.f(Math.min(8192L, j2), lnVar);
                    long j5 = ay0Var.c + jF;
                    ay0Var.c = j5;
                    j3 = j5 - ay0Var.d;
                    if (th == null && j3 >= ay0Var.b.X.a() / 2) {
                        ay0Var.b.w(ay0Var.a, j3);
                        ay0Var.d = ay0Var.c;
                    }
                } else {
                    if (!this.b && th == null) {
                        try {
                            ay0Var.wait();
                            z = true;
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    jF = -1;
                }
                ay0Var.k.l();
            }
            throw th;
        } while (z);
        if (jF != -1) {
            return jF;
        }
        if (th == null) {
            return -1L;
        }
        throw th;
    }
}
