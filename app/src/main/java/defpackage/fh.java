package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fh implements fp2 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ fh(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ym2 ym2Var = (ym2) obj;
                fh fhVar = (fh) this.c;
                ym2Var.i();
                try {
                    try {
                        fhVar.close();
                        if (ym2Var.j()) {
                            throw ym2Var.l(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!ym2Var.j()) {
                            throw e;
                        }
                        throw ym2Var.l(e);
                    }
                } catch (Throwable th) {
                    ym2Var.j();
                    throw th;
                }
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    @Override // defpackage.fp2
    public final u03 d() {
        switch (this.a) {
            case 0:
                return (ym2) this.b;
            default:
                return (u03) this.c;
        }
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ym2 ym2Var = (ym2) obj;
                fh fhVar = (fh) obj2;
                ym2Var.i();
                try {
                    try {
                        long jF = fhVar.f(8192L, lnVar);
                        if (ym2Var.j()) {
                            throw ym2Var.l(null);
                        }
                        return jF;
                    } catch (Throwable th) {
                        ym2Var.j();
                        throw th;
                    }
                } catch (IOException e) {
                    if (ym2Var.j()) {
                        throw ym2Var.l(e);
                    }
                    throw e;
                }
            default:
                try {
                    ((u03) obj2).f();
                    ze2 ze2VarY = lnVar.y(1);
                    int i2 = ((InputStream) obj).read(ze2VarY.a, ze2VarY.c, (int) Math.min(8192L, 8192 - ze2VarY.c));
                    if (i2 == -1) {
                        if (ze2VarY.b == ze2VarY.c) {
                            lnVar.a = ze2VarY.a();
                            cf2.a(ze2VarY);
                        }
                        return -1L;
                    }
                    ze2VarY.c += i2;
                    long j2 = i2;
                    lnVar.b += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (ur4.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
        }
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return "AsyncTimeout.source(" + ((fh) this.c) + ')';
            default:
                return "source(" + ((InputStream) this.b) + ')';
        }
    }
}
