package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u01 implements fp2 {
    public final i32 a;
    public final Inflater b;
    public int c;
    public boolean e;

    public u01(i32 i32Var, Inflater inflater) {
        this.a = i32Var;
        this.b = inflater;
    }

    public final long c(long j, ln lnVar) throws IOException {
        Inflater inflater = this.b;
        lnVar.getClass();
        if (j < 0) {
            og.f(j, "byteCount < 0: ");
            return 0L;
        }
        if (this.e) {
            og.n("closed");
            return 0L;
        }
        if (j != 0) {
            try {
                ze2 ze2VarY = lnVar.y(1);
                int iMin = (int) Math.min(j, 8192 - ze2VarY.c);
                boolean zNeedsInput = inflater.needsInput();
                i32 i32Var = this.a;
                if (zNeedsInput && !i32Var.c()) {
                    ze2 ze2Var = i32Var.b.a;
                    ze2Var.getClass();
                    int i = ze2Var.c;
                    int i2 = ze2Var.b;
                    int i3 = i - i2;
                    this.c = i3;
                    inflater.setInput(ze2Var.a, i2, i3);
                }
                int iInflate = inflater.inflate(ze2VarY.a, ze2VarY.c, iMin);
                int i4 = this.c;
                if (i4 != 0) {
                    int remaining = i4 - inflater.getRemaining();
                    this.c -= remaining;
                    i32Var.skip(remaining);
                }
                if (iInflate > 0) {
                    ze2VarY.c += iInflate;
                    long j2 = iInflate;
                    lnVar.b += j2;
                    return j2;
                }
                if (ze2VarY.b == ze2VarY.c) {
                    lnVar.a = ze2VarY.a();
                    cf2.a(ze2VarY);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        this.b.end();
        this.e = true;
        this.a.close();
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.a.a.d();
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        lnVar.getClass();
        do {
            long jC = c(8192L, lnVar);
            if (jC > 0) {
                return jC;
            }
            Inflater inflater = this.b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.c());
        throw new EOFException("source exhausted prematurely");
    }
}
