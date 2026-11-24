package defpackage;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ub0 implements wk2 {
    public final /* synthetic */ int a = 1;
    public boolean b;
    public final Object c;
    public final Object e;

    public ub0(hx0 hx0Var) {
        this.e = hx0Var;
        this.c = new xp0(((xn) hx0Var.e).d());
    }

    public void c(boolean z) throws IOException {
        ze2 ze2VarY;
        int iDeflate;
        Deflater deflater = (Deflater) this.e;
        h32 h32Var = (h32) this.c;
        ln lnVar = h32Var.b;
        while (true) {
            ze2VarY = lnVar.y(1);
            byte[] bArr = ze2VarY.a;
            int i = ze2VarY.c;
            if (z) {
                try {
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                iDeflate = deflater.deflate(bArr, i, 8192 - i);
            }
            if (iDeflate > 0) {
                ze2VarY.c += iDeflate;
                lnVar.b += (long) iDeflate;
                h32Var.c();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (ze2VarY.b == ze2VarY.c) {
            lnVar.a = ze2VarY.a();
            cf2.a(ze2VarY);
        }
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.e;
        switch (i) {
            case 0:
                Deflater deflater = (Deflater) obj2;
                if (this.b) {
                    return;
                }
                deflater.finish();
                c(false);
                th = null;
                try {
                    deflater.end();
                    break;
                } catch (Throwable th) {
                    if (th == null) {
                        th = th;
                    }
                }
                try {
                    ((h32) obj).close();
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                this.b = true;
                if (th != null) {
                    throw th;
                }
                return;
            default:
                hx0 hx0Var = (hx0) obj2;
                if (this.b) {
                    return;
                }
                this.b = true;
                xp0 xp0Var = (xp0) obj;
                u03 u03Var = xp0Var.e;
                xp0Var.e = u03.d;
                u03Var.a();
                u03Var.b();
                hx0Var.a = 3;
                return;
        }
    }

    @Override // defpackage.wk2
    public final u03 d() {
        switch (this.a) {
            case 0:
                return ((h32) this.c).a.d();
            default:
                return (xp0) this.c;
        }
    }

    @Override // defpackage.wk2, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.a) {
            case 0:
                c(true);
                ((h32) this.c).flush();
                break;
            default:
                if (!this.b) {
                    ((xn) ((hx0) this.e).e).flush();
                    break;
                }
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "DeflaterSink(" + ((h32) this.c) + ')';
            default:
                return super.toString();
        }
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) throws IOException {
        int i = this.a;
        Object obj = this.e;
        switch (i) {
            case 0:
                sg.a(lnVar.b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    ze2 ze2Var = lnVar.a;
                    ze2Var.getClass();
                    int iMin = (int) Math.min(j2, ze2Var.c - ze2Var.b);
                    ((Deflater) obj).setInput(ze2Var.a, ze2Var.b, iMin);
                    c(false);
                    long j3 = iMin;
                    lnVar.b -= j3;
                    int i2 = ze2Var.b + iMin;
                    ze2Var.b = i2;
                    if (i2 == ze2Var.c) {
                        lnVar.a = ze2Var.a();
                        cf2.a(ze2Var);
                    }
                    j2 -= j3;
                }
                break;
            default:
                if (!this.b) {
                    z53.c(lnVar.b, 0L, j);
                    ((xn) ((hx0) obj).e).u(j, lnVar);
                } else {
                    og.n("closed");
                }
                break;
        }
    }

    public ub0(ln lnVar, Deflater deflater) {
        this.c = new h32(lnVar);
        this.e = deflater;
    }
}
