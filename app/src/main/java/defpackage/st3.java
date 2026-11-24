package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class st3 {
    public static final Logger e = Logger.getLogger(st3.class.getName());
    public static final boolean f = pv3.e;
    public py0 a;
    public final byte[] b;
    public final int c;
    public int d;

    public st3(byte[] bArr, int i) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i)));
        }
        this.b = bArr;
        this.d = 0;
        this.c = i;
    }

    public static int a(String str) {
        int length;
        try {
            length = rv3.c(str);
        } catch (qv3 unused) {
            length = str.getBytes(nu3.a).length;
        }
        return b(length) + length;
    }

    public static int b(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int c(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void d(byte b) throws jz {
        try {
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e2) {
            throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void e(byte[] bArr, int i) throws jz {
        try {
            System.arraycopy(bArr, 0, this.b, this.d, i);
            this.d += i;
        } catch (IndexOutOfBoundsException e2) {
            throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(i)), e2);
        }
    }

    public final void f(rt3 rt3Var) throws jz {
        p(rt3Var.d());
        qt3 qt3Var = (qt3) rt3Var;
        e(qt3Var.c, qt3Var.d());
    }

    public final void g(int i, int i2) throws jz {
        p((i << 3) | 5);
        h(i2);
    }

    public final void h(int i) throws jz {
        try {
            byte[] bArr = this.b;
            int i2 = this.d;
            int i3 = i2 + 1;
            this.d = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.d = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.d = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.d = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void i(int i, long j) throws jz {
        p((i << 3) | 1);
        j(j);
    }

    public final void j(long j) throws jz {
        try {
            byte[] bArr = this.b;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.d = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.d = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.d = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.d = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.d = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.d = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.d = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void k(int i, int i2) throws jz {
        p(i << 3);
        l(i2);
    }

    public final void l(int i) throws jz {
        if (i >= 0) {
            p(i);
        } else {
            r(i);
        }
    }

    public final void m(String str) throws jz {
        int i = this.d;
        try {
            int iB = b(str.length() * 3);
            int iB2 = b(str.length());
            int i2 = this.c;
            byte[] bArr = this.b;
            if (iB2 != iB) {
                p(rv3.c(str));
                int i3 = this.d;
                this.d = rv3.b(str, bArr, i3, i2 - i3);
            } else {
                int i4 = i + iB2;
                this.d = i4;
                int iB3 = rv3.b(str, bArr, i4, i2 - i4);
                this.d = i;
                p((iB3 - i) - iB2);
                this.d = iB3;
            }
        } catch (IndexOutOfBoundsException e2) {
            throw new jz(e2);
        } catch (qv3 e3) {
            this.d = i;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(nu3.a);
            try {
                int length = bytes.length;
                p(length);
                e(bytes, length);
            } catch (IndexOutOfBoundsException e4) {
                throw new jz(e4);
            }
        }
    }

    public final void n(int i, int i2) {
        p((i << 3) | i2);
    }

    public final void o(int i, int i2) {
        p(i << 3);
        p(i2);
    }

    public final void p(int i) {
        while (true) {
            int i2 = i & (-128);
            int i3 = this.d;
            byte[] bArr = this.b;
            if (i2 == 0) {
                this.d = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    this.d = i3 + 1;
                    bArr[i3] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
                }
            }
            throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void q(int i, long j) throws jz {
        p(i << 3);
        r(j);
    }

    public final void r(long j) throws jz {
        boolean z = f;
        byte[] bArr = this.b;
        int i = this.c;
        if (!z || i - this.d < 10) {
            while (true) {
                long j2 = j & (-128);
                int i2 = this.d;
                if (j2 == 0) {
                    this.d = i2 + 1;
                    bArr[i2] = (byte) j;
                    return;
                } else {
                    try {
                        this.d = i2 + 1;
                        bArr[i2] = (byte) ((((int) j) | 128) & 255);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(i), 1), e2);
                    }
                }
                throw new jz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(i), 1), e2);
            }
        }
        while (true) {
            long j3 = j & (-128);
            int i3 = (int) j;
            int i4 = this.d;
            if (j3 == 0) {
                this.d = i4 + 1;
                pv3.c.i(bArr, pv3.f + ((long) i4), (byte) i3);
                return;
            }
            this.d = i4 + 1;
            pv3.c.i(bArr, pv3.f + ((long) i4), (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }
}
