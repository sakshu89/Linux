package defpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ex0 extends cx0 {
    public final ey0 e;
    public long f;
    public boolean i;
    public final /* synthetic */ hx0 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex0(hx0 hx0Var, ey0 ey0Var) {
        super(hx0Var);
        ey0Var.getClass();
        this.j = hx0Var;
        this.e = ey0Var;
        this.f = -1L;
        this.i = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.b) {
            return;
        }
        if (this.i) {
            byte[] bArr = z53.a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = z53.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((q32) this.j.c).k();
                c();
            }
        }
        this.b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (r9.i == false) goto L25;
     */
    @Override // defpackage.cx0, defpackage.fp2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(long r10, defpackage.ln r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex0.f(long, ln):long");
    }
}
