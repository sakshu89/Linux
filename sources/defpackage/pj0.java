package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pj0 implements wk2 {
    public final wk2 a;
    public final long b;
    public boolean c;
    public long e;
    public boolean f;
    public final /* synthetic */ ux i;

    public pj0(ux uxVar, wk2 wk2Var, long j) {
        wk2Var.getClass();
        this.i = uxVar;
        this.a = wk2Var;
        this.b = j;
    }

    public final void c() {
        this.a.close();
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f) {
            return;
        }
        this.f = true;
        long j = this.b;
        if (j != -1 && this.e != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            c();
            e(null);
        } catch (IOException e) {
            throw e(e);
        }
    }

    @Override // defpackage.wk2
    public final u03 d() {
        return this.a.d();
    }

    public final IOException e(IOException iOException) {
        if (this.c) {
            return iOException;
        }
        this.c = true;
        return this.i.a(false, true, iOException);
    }

    @Override // defpackage.wk2, java.io.Flushable
    public final void flush() throws IOException {
        try {
            j();
        } catch (IOException e) {
            throw e(e);
        }
    }

    public final void j() {
        this.a.flush();
    }

    public final String toString() {
        return pj0.class.getSimpleName() + '(' + this.a + ')';
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) throws IOException {
        if (this.f) {
            og.n("closed");
            return;
        }
        long j2 = this.b;
        if (j2 == -1 || this.e + j <= j2) {
            try {
                this.a.u(j, lnVar);
                this.e += j;
                return;
            } catch (IOException e) {
                throw e(e);
            }
        }
        throw new ProtocolException("expected " + j2 + " bytes but received " + (this.e + j));
    }
}
