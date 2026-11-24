package defpackage;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kn implements Closeable {
    public ln a;
    public boolean b;
    public ze2 c;
    public byte[] f;
    public long e = -1;
    public int i = -1;
    public int j = -1;

    public final void c(long j) {
        ln lnVar = this.a;
        if (lnVar == null) {
            og.n("not attached to a buffer");
            return;
        }
        if (!this.b) {
            og.n("resizeBuffer() only permitted for read/write buffers");
            return;
        }
        long j2 = lnVar.b;
        if (j <= j2) {
            if (j < 0) {
                og.f(j, "newSize < 0: ");
                return;
            }
            long j3 = j2 - j;
            while (j3 > 0) {
                ze2 ze2Var = lnVar.a;
                ze2Var.getClass();
                ze2 ze2Var2 = ze2Var.g;
                ze2Var2.getClass();
                int i = ze2Var2.c;
                long j4 = i - ze2Var2.b;
                if (j4 > j3) {
                    ze2Var2.c = i - ((int) j3);
                    break;
                } else {
                    lnVar.a = ze2Var2.a();
                    cf2.a(ze2Var2);
                    j3 -= j4;
                }
            }
            this.c = null;
            this.e = j;
            this.f = null;
            this.i = -1;
            this.j = -1;
        } else if (j > j2) {
            long j5 = j - j2;
            int i2 = 1;
            boolean z = true;
            for (long j6 = 0; j5 > j6; j6 = 0) {
                ze2 ze2VarY = lnVar.y(i2);
                int iMin = (int) Math.min(j5, 8192 - ze2VarY.c);
                int i3 = ze2VarY.c + iMin;
                ze2VarY.c = i3;
                j5 -= (long) iMin;
                if (z) {
                    this.c = ze2VarY;
                    this.e = j2;
                    this.f = ze2VarY.a;
                    this.i = i3 - iMin;
                    this.j = i3;
                    z = false;
                }
                i2 = 1;
            }
        }
        lnVar.b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a == null) {
            og.n("not attached to a buffer");
            return;
        }
        this.a = null;
        this.c = null;
        this.e = -1L;
        this.f = null;
        this.i = -1;
        this.j = -1;
    }

    public final int e(long j) {
        ln lnVar = this.a;
        if (lnVar == null) {
            og.n("not attached to a buffer");
            return 0;
        }
        if (j >= -1) {
            long j2 = lnVar.b;
            if (j <= j2) {
                if (j == -1 || j == j2) {
                    this.c = null;
                    this.e = j;
                    this.f = null;
                    this.i = -1;
                    this.j = -1;
                    return -1;
                }
                ze2 ze2Var = lnVar.a;
                ze2 ze2Var2 = this.c;
                long j3 = 0;
                if (ze2Var2 != null) {
                    long j4 = this.e - ((long) (this.i - ze2Var2.b));
                    if (j4 > j) {
                        ze2Var2 = ze2Var;
                        ze2Var = ze2Var2;
                        j2 = j4;
                    } else {
                        j3 = j4;
                    }
                } else {
                    ze2Var2 = ze2Var;
                }
                if (j2 - j > j - j3) {
                    while (true) {
                        ze2Var2.getClass();
                        long j5 = ((long) (ze2Var2.c - ze2Var2.b)) + j3;
                        if (j < j5) {
                            break;
                        }
                        ze2Var2 = ze2Var2.f;
                        j3 = j5;
                    }
                } else {
                    while (j2 > j) {
                        ze2Var.getClass();
                        ze2Var = ze2Var.g;
                        ze2Var.getClass();
                        j2 -= (long) (ze2Var.c - ze2Var.b);
                    }
                    ze2Var2 = ze2Var;
                    j3 = j2;
                }
                if (this.b) {
                    ze2Var2.getClass();
                    if (ze2Var2.d) {
                        byte[] bArr = ze2Var2.a;
                        ze2 ze2Var3 = new ze2(Arrays.copyOf(bArr, bArr.length), ze2Var2.b, ze2Var2.c, false, true);
                        if (lnVar.a == ze2Var2) {
                            lnVar.a = ze2Var3;
                        }
                        ze2Var2.b(ze2Var3);
                        ze2 ze2Var4 = ze2Var3.g;
                        ze2Var4.getClass();
                        ze2Var4.a();
                        ze2Var2 = ze2Var3;
                    }
                }
                this.c = ze2Var2;
                this.e = j;
                ze2Var2.getClass();
                this.f = ze2Var2.a;
                int i = ze2Var2.b + ((int) (j - j3));
                this.i = i;
                int i2 = ze2Var2.c;
                this.j = i2;
                return i2 - i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + lnVar.b);
    }
}
