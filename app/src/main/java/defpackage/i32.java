package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i32 implements yn {
    public final fp2 a;
    public final ln b;
    public boolean c;

    public i32(fp2 fp2Var) {
        fp2Var.getClass();
        this.a = fp2Var;
        this.b = new ln();
    }

    @Override // defpackage.yn
    public final int B(fs1 fs1Var) throws EOFException {
        ln lnVar;
        fs1Var.getClass();
        if (this.c) {
            og.n("closed");
            return 0;
        }
        do {
            lnVar = this.b;
            int iB = b.b(lnVar, fs1Var, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                lnVar.skip(fs1Var.a[iB].c());
                return iB;
            }
        } while (this.a.f(8192L, lnVar) != -1);
        return -1;
    }

    @Override // defpackage.yn
    public final void F(long j) throws EOFException {
        if (!o(j)) {
            throw new EOFException();
        }
    }

    @Override // defpackage.yn
    public final long I() throws EOFException {
        ln lnVar;
        F(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean zO = o(i2);
            lnVar = this.b;
            if (!zO) {
                break;
            }
            byte bJ = lnVar.j(i);
            if ((bJ < 48 || bJ > 57) && ((bJ < 97 || bJ > 102) && (bJ < 65 || bJ > 70))) {
                if (i != 0) {
                    break;
                }
                ph4.a(16);
                ph4.a(16);
                String string = Integer.toString(bJ, 16);
                string.getClass();
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i = i2;
        }
        return lnVar.I();
    }

    @Override // defpackage.yn
    public final String J(Charset charset) {
        fp2 fp2Var = this.a;
        ln lnVar = this.b;
        lnVar.D(fp2Var);
        return lnVar.v(lnVar.b, charset);
    }

    public final boolean c() {
        if (this.c) {
            og.n("closed");
            return false;
        }
        ln lnVar = this.b;
        return lnVar.e() && this.a.f(8192L, lnVar) == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.close();
        ln lnVar = this.b;
        lnVar.skip(lnVar.b);
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.a.d();
    }

    public final long e(byte b, long j, long j2) {
        if (this.c) {
            og.n("closed");
            return 0L;
        }
        if (0 > j2) {
            og.f(j2, "fromIndex=0 toIndex=");
            return 0L;
        }
        long jMax = 0;
        while (jMax < j2) {
            ln lnVar = this.b;
            byte b2 = b;
            long j3 = j2;
            long jO = lnVar.o(b2, jMax, j3);
            if (jO != -1) {
                return jO;
            }
            long j4 = lnVar.b;
            if (j4 >= j3 || this.a.f(8192L, lnVar) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) {
        lnVar.getClass();
        if (j < 0) {
            og.f(j, "byteCount < 0: ");
            return 0L;
        }
        if (this.c) {
            og.n("closed");
            return 0L;
        }
        ln lnVar2 = this.b;
        if (lnVar2.b == 0 && this.a.f(8192L, lnVar2) == -1) {
            return -1L;
        }
        return lnVar2.f(Math.min(j, lnVar2.b), lnVar);
    }

    @Override // defpackage.yn
    public final void i(long j, ln lnVar) throws EOFException {
        ln lnVar2 = this.b;
        try {
            F(j);
            lnVar2.i(j, lnVar);
        } catch (EOFException e) {
            lnVar.D(lnVar2);
            throw e;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    public final int j() throws EOFException {
        F(4L);
        int i = this.b.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // defpackage.yn
    public final oo l(long j) throws EOFException {
        F(j);
        return this.b.l(j);
    }

    public final boolean o(long j) {
        ln lnVar;
        if (j < 0) {
            og.f(j, "byteCount < 0: ");
            return false;
        }
        if (this.c) {
            og.n("closed");
            return false;
        }
        do {
            lnVar = this.b;
            if (lnVar.b >= j) {
                return true;
            }
        } while (this.a.f(8192L, lnVar) != -1);
        return false;
    }

    @Override // defpackage.yn
    public final String p() {
        return z(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        ln lnVar = this.b;
        if (lnVar.b == 0 && this.a.f(8192L, lnVar) == -1) {
            return -1;
        }
        return lnVar.read(byteBuffer);
    }

    @Override // defpackage.yn
    public final byte readByte() throws EOFException {
        F(1L);
        return this.b.readByte();
    }

    @Override // defpackage.yn
    public final void readFully(byte[] bArr) throws EOFException {
        ln lnVar = this.b;
        bArr.getClass();
        try {
            F(bArr.length);
            lnVar.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                long j = lnVar.b;
                if (j <= 0) {
                    throw e;
                }
                int i2 = lnVar.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // defpackage.yn
    public final int readInt() throws EOFException {
        F(4L);
        return this.b.readInt();
    }

    @Override // defpackage.yn
    public final long readLong() throws EOFException {
        F(8L);
        return this.b.readLong();
    }

    @Override // defpackage.yn
    public final short readShort() throws EOFException {
        F(2L);
        return this.b.readShort();
    }

    @Override // defpackage.yn
    public final void skip(long j) throws EOFException {
        if (this.c) {
            og.n("closed");
            return;
        }
        while (j > 0) {
            ln lnVar = this.b;
            if (lnVar.b == 0 && this.a.f(8192L, lnVar) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, lnVar.b);
            lnVar.skip(jMin);
            j -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // defpackage.yn
    public final String z(long j) throws EOFException {
        if (j < 0) {
            og.f(j, "limit < 0: ");
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jE = e((byte) 10, 0L, j2);
        ln lnVar = this.b;
        if (jE != -1) {
            return b.a(jE, lnVar);
        }
        if (j2 < Long.MAX_VALUE && o(j2) && lnVar.j(j2 - 1) == 13 && o(j2 + 1) && lnVar.j(j2) == 10) {
            return b.a(j2, lnVar);
        }
        ln lnVar2 = new ln();
        lnVar.c(lnVar2, 0L, Math.min(32L, lnVar.b));
        throw new EOFException("\\n not found: limit=" + Math.min(lnVar.b, j) + " content=" + lnVar2.l(lnVar2.b).d() + (char) 8230);
    }
}
