package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fx0 extends cx0 {
    public long e;
    public final /* synthetic */ hx0 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx0(hx0 hx0Var, long j) {
        super(hx0Var);
        this.f = hx0Var;
        this.e = j;
        if (j == 0) {
            c();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.b) {
            return;
        }
        if (this.e != 0) {
            byte[] bArr = z53.a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = z53.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((q32) this.f.c).k();
                c();
            }
        }
        this.b = true;
    }

    @Override // defpackage.cx0, defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        if (this.b) {
            og.n("closed");
            return 0L;
        }
        long j2 = this.e;
        if (j2 == 0) {
            return -1L;
        }
        long jF = super.f(Math.min(j2, 8192L), lnVar);
        if (jF == -1) {
            ((q32) this.f.c).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c();
            throw protocolException;
        }
        long j3 = this.e - jF;
        this.e = j3;
        if (j3 == 0) {
            c();
        }
        return jF;
    }
}
