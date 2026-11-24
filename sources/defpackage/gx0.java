package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gx0 extends cx0 {
    public boolean e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.b) {
            return;
        }
        if (!this.e) {
            c();
        }
        this.b = true;
    }

    @Override // defpackage.cx0, defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        if (this.b) {
            og.n("closed");
            return 0L;
        }
        if (this.e) {
            return -1L;
        }
        long jF = super.f(8192L, lnVar);
        if (jF != -1) {
            return jF;
        }
        this.e = true;
        c();
        return -1L;
    }
}
