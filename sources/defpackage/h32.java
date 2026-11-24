package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h32 implements xn {
    public final wk2 a;
    public final ln b;
    public boolean c;

    public h32(wk2 wk2Var) {
        wk2Var.getClass();
        this.a = wk2Var;
        this.b = new ln();
    }

    @Override // defpackage.xn
    public final xn G(String str) {
        str.getClass();
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.N(str);
        c();
        return this;
    }

    public final xn c() {
        if (this.c) {
            og.n("closed");
            return null;
        }
        ln lnVar = this.b;
        long j = lnVar.b;
        if (j == 0) {
            j = 0;
        } else {
            ze2 ze2Var = lnVar.a;
            ze2Var.getClass();
            ze2 ze2Var2 = ze2Var.g;
            ze2Var2.getClass();
            int i = ze2Var2.c;
            if (i < 8192 && ze2Var2.e) {
                j -= (long) (i - ze2Var2.b);
            }
        }
        if (j > 0) {
            this.a.u(j, lnVar);
        }
        return this;
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        wk2 wk2Var = this.a;
        if (this.c) {
            return;
        }
        ln lnVar = this.b;
        long j = lnVar.b;
        if (j > 0) {
            wk2Var.u(j, lnVar);
        }
        th = null;
        try {
            wk2Var.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.wk2
    public final u03 d() {
        return this.a.d();
    }

    @Override // defpackage.xn, defpackage.wk2, java.io.Flushable
    public final void flush() {
        if (this.c) {
            og.n("closed");
            return;
        }
        ln lnVar = this.b;
        long j = lnVar.b;
        wk2 wk2Var = this.a;
        if (j > 0) {
            wk2Var.u(j, lnVar);
        }
        wk2Var.flush();
    }

    @Override // defpackage.xn
    public final xn h(oo ooVar) {
        ooVar.getClass();
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.A(ooVar);
        c();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.xn
    public final xn k(long j) {
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.H(j);
        c();
        return this;
    }

    @Override // defpackage.xn
    public final xn n() {
        if (this.c) {
            og.n("closed");
            return null;
        }
        ln lnVar = this.b;
        long j = lnVar.b;
        if (j > 0) {
            this.a.u(j, lnVar);
        }
        return this;
    }

    @Override // defpackage.xn
    public final ln s() {
        return this.b;
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) {
        lnVar.getClass();
        if (this.c) {
            og.n("closed");
        } else {
            this.b.u(j, lnVar);
            c();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.c) {
            og.n("closed");
            return 0;
        }
        int iWrite = this.b.write(byteBuffer);
        c();
        return iWrite;
    }

    @Override // defpackage.xn
    public final xn writeByte(int i) {
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.E(i);
        c();
        return this;
    }

    @Override // defpackage.xn
    public final xn writeInt(int i) {
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.K(i);
        c();
        return this;
    }

    @Override // defpackage.xn
    public final xn writeShort(int i) {
        if (this.c) {
            og.n("closed");
            return null;
        }
        this.b.L(i);
        c();
        return this;
    }

    @Override // defpackage.xn
    public final xn write(byte[] bArr) {
        if (!this.c) {
            this.b.C(bArr, bArr.length);
            c();
            return this;
        }
        og.n("closed");
        return null;
    }
}
