package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qj0 implements fp2 {
    public final fp2 a;
    public final long b;
    public long c;
    public boolean e;
    public boolean f;
    public boolean i;
    public final /* synthetic */ ux j;

    public qj0(ux uxVar, fp2 fp2Var, long j) {
        fp2Var.getClass();
        this.j = uxVar;
        this.a = fp2Var;
        this.b = j;
        this.e = true;
        if (j == 0) {
            e(null);
        }
    }

    public final void c() throws IOException {
        this.a.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.i) {
            return;
        }
        this.i = true;
        try {
            c();
            e(null);
        } catch (IOException e) {
            throw e(e);
        }
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.a.d();
    }

    public final IOException e(IOException iOException) {
        if (this.f) {
            return iOException;
        }
        this.f = true;
        if (iOException == null && this.e) {
            this.e = false;
        }
        return this.j.a(true, false, iOException);
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        if (this.i) {
            og.n("closed");
            return 0L;
        }
        try {
            long jF = this.a.f(8192L, lnVar);
            if (this.e) {
                this.e = false;
            }
            if (jF == -1) {
                e(null);
                return -1L;
            }
            long j2 = this.c + jF;
            long j3 = this.b;
            if (j3 == -1 || j2 <= j3) {
                this.c = j2;
                if (j2 == j3) {
                    e(null);
                }
                return jF;
            }
            throw new ProtocolException("expected " + j3 + " bytes but received " + j2);
        } catch (IOException e) {
            throw e(e);
        }
    }

    public final String toString() {
        return qj0.class.getSimpleName() + '(' + this.a + ')';
    }
}
