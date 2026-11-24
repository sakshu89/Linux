package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eh implements wk2 {
    public final /* synthetic */ int a = 1;
    public final ym2 b;
    public final Object c;

    public eh(OutputStream outputStream, ym2 ym2Var) {
        this.c = outputStream;
        this.b = ym2Var;
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                eh ehVar = (eh) obj;
                ym2 ym2Var = this.b;
                ym2Var.i();
                try {
                    try {
                        ehVar.close();
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
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // defpackage.wk2
    public final u03 d() {
        int i = this.a;
        return this.b;
    }

    @Override // defpackage.wk2, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                eh ehVar = (eh) obj;
                ym2 ym2Var = this.b;
                ym2Var.i();
                try {
                    try {
                        ehVar.flush();
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
                ((OutputStream) obj).flush();
                return;
        }
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                return "AsyncTimeout.sink(" + ((eh) obj) + ')';
            default:
                return "sink(" + ((OutputStream) obj) + ')';
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0094 A[LOOP:1: B:12:0x0061->B:25:0x0094, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0096 A[SYNTHETIC] */
    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) throws IOException {
        long j2;
        int i = this.a;
        Object obj = this.c;
        ym2 ym2Var = this.b;
        switch (i) {
            case 0:
                sg.a(lnVar.b, 0L, j);
                for (long j3 = j; j3 > 0; j3 -= j2) {
                    ze2 ze2Var = lnVar.a;
                    ze2Var.getClass();
                    j2 = 0;
                    try {
                        try {
                            while (j2 < 65536) {
                                j2 += (long) (ze2Var.c - ze2Var.b);
                                if (j2 >= j3) {
                                    j2 = j3;
                                    eh ehVar = (eh) obj;
                                    ym2Var.i();
                                    ehVar.u(j2, lnVar);
                                    if (!ym2Var.j()) {
                                        throw ym2Var.l(null);
                                    }
                                } else {
                                    ze2Var = ze2Var.f;
                                    ze2Var.getClass();
                                }
                            }
                            ehVar.u(j2, lnVar);
                            if (!ym2Var.j()) {
                                throw ym2Var.l(null);
                            }
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
                    eh ehVar2 = (eh) obj;
                    ym2Var.i();
                }
                return;
            default:
                sg.a(lnVar.b, 0L, j);
                long j4 = j;
                while (j4 > 0) {
                    ym2Var.f();
                    ze2 ze2Var2 = lnVar.a;
                    ze2Var2.getClass();
                    int iMin = (int) Math.min(j4, ze2Var2.c - ze2Var2.b);
                    ((OutputStream) obj).write(ze2Var2.a, ze2Var2.b, iMin);
                    int i2 = ze2Var2.b + iMin;
                    ze2Var2.b = i2;
                    long j5 = iMin;
                    j4 -= j5;
                    lnVar.b -= j5;
                    if (i2 == ze2Var2.c) {
                        lnVar.a = ze2Var2.a();
                        cf2.a(ze2Var2);
                    }
                }
                return;
        }
    }

    public eh(ym2 ym2Var, eh ehVar) {
        this.b = ym2Var;
        this.c = ehVar;
    }
}
