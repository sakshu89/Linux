package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ln implements yn, xn, Cloneable, ByteChannel {
    public ze2 a;
    public long b;

    public final void A(oo ooVar) {
        ooVar.getClass();
        ooVar.k(this, ooVar.c());
    }

    @Override // defpackage.yn
    public final int B(fs1 fs1Var) throws EOFException {
        fs1Var.getClass();
        int iB = b.b(this, fs1Var, false);
        if (iB == -1) {
            return -1;
        }
        skip(fs1Var.a[iB].c());
        return iB;
    }

    public final void C(byte[] bArr, int i) {
        bArr.getClass();
        long j = i;
        sg.a(bArr.length, 0L, j);
        int i2 = 0;
        while (i2 < i) {
            ze2 ze2VarY = y(1);
            int iMin = Math.min(i - i2, 8192 - ze2VarY.c);
            int i3 = i2 + iMin;
            qg.d(bArr, ze2VarY.c, ze2VarY.a, i2, i3);
            ze2VarY.c += iMin;
            i2 = i3;
        }
        this.b += j;
    }

    public final void D(fp2 fp2Var) {
        fp2Var.getClass();
        while (fp2Var.f(8192L, this) != -1) {
        }
    }

    public final void E(int i) {
        ze2 ze2VarY = y(1);
        byte[] bArr = ze2VarY.a;
        int i2 = ze2VarY.c;
        ze2VarY.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
    }

    @Override // defpackage.yn
    public final void F(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn G(String str) {
        N(str);
        return this;
    }

    public final void H(long j) {
        if (j == 0) {
            E(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        ze2 ze2VarY = y(i);
        byte[] bArr = ze2VarY.a;
        int i2 = ze2VarY.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = b.a[(int) (15 & j)];
            j >>>= 4;
        }
        ze2VarY.c += i;
        this.b += (long) i;
    }

    @Override // defpackage.yn
    public final long I() throws EOFException {
        int i;
        if (this.b == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            ze2 ze2Var = this.a;
            ze2Var.getClass();
            byte[] bArr = ze2Var.a;
            int i3 = ze2Var.b;
            int i4 = ze2Var.c;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        z = true;
                        if (i2 != 0) {
                            break;
                        }
                        char[] cArr = e8.a;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]})));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    ln lnVar = new ln();
                    lnVar.H(j);
                    lnVar.E(b);
                    throw new NumberFormatException("Number too large: ".concat(lnVar.w()));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.a = ze2Var.a();
                cf2.a(ze2Var);
            } else {
                ze2Var.b = i3;
            }
            if (z) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i2;
        return j;
    }

    @Override // defpackage.yn
    public final String J(Charset charset) {
        return v(this.b, charset);
    }

    public final void K(int i) {
        ze2 ze2VarY = y(4);
        byte[] bArr = ze2VarY.a;
        int i2 = ze2VarY.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        ze2VarY.c = i2 + 4;
        this.b += 4;
    }

    public final void L(int i) {
        ze2 ze2VarY = y(2);
        byte[] bArr = ze2VarY.a;
        int i2 = ze2VarY.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        ze2VarY.c = i2 + 2;
        this.b += 2;
    }

    public final void M(int i, int i2, String str) {
        char cCharAt;
        str.getClass();
        if (i < 0) {
            og.g(ky0.h(i, "beginIndex < 0: "));
            return;
        }
        if (i2 < i) {
            og.g(ky0.i("endIndex < beginIndex: ", i2, i, " < "));
            return;
        }
        if (i2 > str.length()) {
            StringBuilder sbP = ky0.p("endIndex > string.length: ", i2, " > ");
            sbP.append(str.length());
            throw new IllegalArgumentException(sbP.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                ze2 ze2VarY = y(1);
                byte[] bArr = ze2VarY.a;
                int i3 = ze2VarY.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = ze2VarY.c;
                int i6 = (i3 + i) - i5;
                ze2VarY.c = i5 + i6;
                this.b += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    ze2 ze2VarY2 = y(2);
                    byte[] bArr2 = ze2VarY2.a;
                    int i7 = ze2VarY2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    ze2VarY2.c = i7 + 2;
                    this.b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    ze2 ze2VarY3 = y(3);
                    byte[] bArr3 = ze2VarY3.a;
                    int i8 = ze2VarY3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    ze2VarY3.c = i8 + 3;
                    this.b += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        E(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        ze2 ze2VarY4 = y(4);
                        byte[] bArr4 = ze2VarY4.a;
                        int i11 = ze2VarY4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        ze2VarY4.c = i11 + 4;
                        this.b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void N(String str) {
        str.getClass();
        M(0, str.length(), str);
    }

    public final void O(int i) {
        String str;
        if (i < 128) {
            E(i);
            return;
        }
        if (i < 2048) {
            ze2 ze2VarY = y(2);
            byte[] bArr = ze2VarY.a;
            int i2 = ze2VarY.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            ze2VarY.c = i2 + 2;
            this.b += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            E(63);
            return;
        }
        if (i < 65536) {
            ze2 ze2VarY2 = y(3);
            byte[] bArr2 = ze2VarY2.a;
            int i3 = ze2VarY2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            ze2VarY2.c = i3 + 3;
            this.b += 3;
            return;
        }
        if (i <= 1114111) {
            ze2 ze2VarY3 = y(4);
            byte[] bArr3 = ze2VarY3.a;
            int i4 = ze2VarY3.c;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            ze2VarY3.c = i4 + 4;
            this.b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = e8.a;
            int i5 = 0;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            while (i5 < 8 && cArr2[i5] == '0') {
                i5++;
            }
            if (i5 < 0) {
                og.o(cq.h("startIndex: ", i5, ", endIndex: 8, size: 8"));
                return;
            } else {
                if (i5 > 8) {
                    og.i(cq.h("startIndex: ", i5, " > endIndex: 8"));
                    return;
                }
                str = new String(cArr2, i5, 8 - i5);
            }
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void c(ln lnVar, long j, long j2) {
        lnVar.getClass();
        long j3 = j;
        sg.a(this.b, j3, j2);
        if (j2 == 0) {
            return;
        }
        lnVar.b += j2;
        ze2 ze2Var = this.a;
        while (true) {
            ze2Var.getClass();
            long j4 = ze2Var.c - ze2Var.b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            ze2Var = ze2Var.f;
        }
        long j5 = j2;
        while (j5 > 0) {
            ze2Var.getClass();
            ze2 ze2VarC = ze2Var.c();
            int i = ze2VarC.b + ((int) j3);
            ze2VarC.b = i;
            ze2VarC.c = Math.min(i + ((int) j5), ze2VarC.c);
            ze2 ze2Var2 = lnVar.a;
            if (ze2Var2 == null) {
                ze2VarC.g = ze2VarC;
                ze2VarC.f = ze2VarC;
                lnVar.a = ze2VarC;
            } else {
                ze2 ze2Var3 = ze2Var2.g;
                ze2Var3.getClass();
                ze2Var3.b(ze2VarC);
            }
            j5 -= (long) (ze2VarC.c - ze2VarC.b);
            ze2Var = ze2Var.f;
            j3 = 0;
        }
    }

    public final Object clone() {
        ln lnVar = new ln();
        if (this.b == 0) {
            return lnVar;
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        ze2 ze2VarC = ze2Var.c();
        lnVar.a = ze2VarC;
        ze2VarC.g = ze2VarC;
        ze2VarC.f = ze2VarC;
        for (ze2 ze2Var2 = ze2Var.f; ze2Var2 != ze2Var; ze2Var2 = ze2Var2.f) {
            ze2 ze2Var3 = ze2VarC.g;
            ze2Var3.getClass();
            ze2Var2.getClass();
            ze2Var3.b(ze2Var2.c());
        }
        lnVar.b = this.b;
        return lnVar;
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return u03.d;
    }

    public final boolean e() {
        return this.b == 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ln)) {
            return false;
        }
        long j = this.b;
        ln lnVar = (ln) obj;
        if (j != lnVar.b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        ze2 ze2Var2 = lnVar.a;
        ze2Var2.getClass();
        int i = ze2Var.b;
        int i2 = ze2Var2.b;
        long j2 = 0;
        while (j2 < this.b) {
            long jMin = Math.min(ze2Var.c - i, ze2Var2.c - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (ze2Var.a[i] != ze2Var2.a[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == ze2Var.c) {
                ze2Var = ze2Var.f;
                ze2Var.getClass();
                i = ze2Var.b;
            }
            if (i2 == ze2Var2.c) {
                ze2Var2 = ze2Var2.f;
                ze2Var2.getClass();
                i2 = ze2Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) {
        lnVar.getClass();
        if (j < 0) {
            og.f(j, "byteCount < 0: ");
            return 0L;
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        lnVar.u(j, this);
        return j;
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn h(oo ooVar) {
        A(ooVar);
        return this;
    }

    public final int hashCode() {
        ze2 ze2Var = this.a;
        if (ze2Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ze2Var.c;
            for (int i3 = ze2Var.b; i3 < i2; i3++) {
                i = (i * 31) + ze2Var.a[i3];
            }
            ze2Var = ze2Var.f;
            ze2Var.getClass();
        } while (ze2Var != this.a);
        return i;
    }

    @Override // defpackage.yn
    public final void i(long j, ln lnVar) throws EOFException {
        long j2 = this.b;
        if (j2 >= j) {
            lnVar.u(j, this);
        } else {
            lnVar.u(j2, this);
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final byte j(long j) {
        sg.a(this.b, j, 1L);
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        long j2 = this.b;
        if (j2 - j < j) {
            while (j2 > j) {
                ze2Var = ze2Var.g;
                ze2Var.getClass();
                j2 -= (long) (ze2Var.c - ze2Var.b);
            }
            return ze2Var.a[(int) ((((long) ze2Var.b) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = ze2Var.c;
            int i2 = ze2Var.b;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return ze2Var.a[(int) ((((long) i2) + j) - j3)];
            }
            ze2Var = ze2Var.f;
            ze2Var.getClass();
            j3 = j4;
        }
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn k(long j) {
        H(j);
        return this;
    }

    @Override // defpackage.yn
    public final oo l(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            og.f(j, "byteCount: ");
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new oo(r(j));
        }
        oo ooVarX = x((int) j);
        skip(j);
        return ooVarX;
    }

    public final long o(byte b, long j, long j2) {
        ze2 ze2Var;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + this.b + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j4 = this.b;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (ze2Var = this.a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                ze2Var = ze2Var.g;
                ze2Var.getClass();
                j4 -= (long) (ze2Var.c - ze2Var.b);
            }
            while (j4 < j2) {
                byte[] bArr = ze2Var.a;
                int iMin = (int) Math.min(ze2Var.c, (((long) ze2Var.b) + j2) - j4);
                for (int i = (int) ((((long) ze2Var.b) + j) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - ze2Var.b)) + j4;
                    }
                }
                j4 += (long) (ze2Var.c - ze2Var.b);
                ze2Var = ze2Var.f;
                ze2Var.getClass();
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (ze2Var.c - ze2Var.b)) + j3;
            if (j5 > j) {
                break;
            }
            ze2Var = ze2Var.f;
            ze2Var.getClass();
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = ze2Var.a;
            int iMin2 = (int) Math.min(ze2Var.c, (((long) ze2Var.b) + j2) - j3);
            for (int i2 = (int) ((((long) ze2Var.b) + j) - j3); i2 < iMin2; i2++) {
                if (bArr2[i2] == b) {
                    return ((long) (i2 - ze2Var.b)) + j3;
                }
            }
            j3 += (long) (ze2Var.c - ze2Var.b);
            ze2Var = ze2Var.f;
            ze2Var.getClass();
            j = j3;
        }
        return -1L;
    }

    @Override // defpackage.yn
    public final String p() {
        return z(Long.MAX_VALUE);
    }

    public final kn q(kn knVar) {
        knVar.getClass();
        byte[] bArr = b.a;
        if (knVar == sg.a) {
            knVar = new kn();
        }
        if (knVar.a != null) {
            og.n("already attached to a buffer");
            return null;
        }
        knVar.a = this;
        knVar.b = true;
        return knVar;
    }

    public final byte[] r(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            og.f(j, "byteCount: ");
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        sg.a(bArr.length, i, i2);
        ze2 ze2Var = this.a;
        if (ze2Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, ze2Var.c - ze2Var.b);
        byte[] bArr2 = ze2Var.a;
        int i3 = ze2Var.b;
        qg.d(bArr2, i, bArr, i3, i3 + iMin);
        int i4 = ze2Var.b + iMin;
        ze2Var.b = i4;
        this.b -= (long) iMin;
        if (i4 == ze2Var.c) {
            this.a = ze2Var.a();
            cf2.a(ze2Var);
        }
        return iMin;
    }

    @Override // defpackage.yn
    public final byte readByte() {
        if (this.b == 0) {
            throw new EOFException();
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        int i = ze2Var.b;
        int i2 = ze2Var.c;
        int i3 = i + 1;
        byte b = ze2Var.a[i];
        this.b--;
        if (i3 != i2) {
            ze2Var.b = i3;
            return b;
        }
        this.a = ze2Var.a();
        cf2.a(ze2Var);
        return b;
    }

    @Override // defpackage.yn
    public final void readFully(byte[] bArr) throws EOFException {
        bArr.getClass();
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // defpackage.yn
    public final int readInt() throws EOFException {
        if (this.b < 4) {
            throw new EOFException();
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        int i = ze2Var.b;
        int i2 = ze2Var.c;
        if (i2 - i < 4) {
            return (readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | ((readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8);
        }
        byte[] bArr = ze2Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | ((bArr[i + 2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | i4;
        this.b -= 4;
        if (i5 != i2) {
            ze2Var.b = i5;
            return i6;
        }
        this.a = ze2Var.a();
        cf2.a(ze2Var);
        return i6;
    }

    @Override // defpackage.yn
    public final long readLong() throws EOFException {
        if (this.b < 8) {
            throw new EOFException();
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        int i = ze2Var.b;
        int i2 = ze2Var.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = ze2Var.a;
        int i3 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        this.b -= 8;
        if (i4 != i2) {
            ze2Var.b = i4;
            return j2;
        }
        this.a = ze2Var.a();
        cf2.a(ze2Var);
        return j2;
    }

    @Override // defpackage.yn
    public final short readShort() throws EOFException {
        if (this.b < 2) {
            throw new EOFException();
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        int i = ze2Var.b;
        int i2 = ze2Var.c;
        if (i2 - i < 2) {
            return (short) ((readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((readByte() & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8));
        }
        byte[] bArr = ze2Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | i4;
        this.b -= 2;
        if (i5 == i2) {
            this.a = ze2Var.a();
            cf2.a(ze2Var);
        } else {
            ze2Var.b = i5;
        }
        return (short) i6;
    }

    @Override // defpackage.yn
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            ze2 ze2Var = this.a;
            if (ze2Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, ze2Var.c - ze2Var.b);
            long j2 = iMin;
            this.b -= j2;
            j -= j2;
            int i = ze2Var.b + iMin;
            ze2Var.b = i;
            if (i == ze2Var.c) {
                this.a = ze2Var.a();
                cf2.a(ze2Var);
            }
        }
    }

    public final String toString() {
        long j = this.b;
        if (j <= 2147483647L) {
            return x((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.b).toString());
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) {
        ze2 ze2VarB;
        lnVar.getClass();
        if (lnVar == this) {
            og.i("source == this");
            return;
        }
        sg.a(lnVar.b, 0L, j);
        while (j > 0) {
            ze2 ze2Var = lnVar.a;
            ze2Var.getClass();
            int i = ze2Var.c;
            ze2 ze2Var2 = lnVar.a;
            ze2Var2.getClass();
            long j2 = i - ze2Var2.b;
            int i2 = 0;
            if (j < j2) {
                ze2 ze2Var3 = this.a;
                ze2 ze2Var4 = ze2Var3 != null ? ze2Var3.g : null;
                if (ze2Var4 != null && ze2Var4.e) {
                    if ((((long) ze2Var4.c) + j) - ((long) (ze2Var4.d ? 0 : ze2Var4.b)) <= 8192) {
                        ze2 ze2Var5 = lnVar.a;
                        ze2Var5.getClass();
                        ze2Var5.d(ze2Var4, (int) j);
                        lnVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                ze2 ze2Var6 = lnVar.a;
                ze2Var6.getClass();
                int i3 = (int) j;
                if (i3 <= 0 || i3 > ze2Var6.c - ze2Var6.b) {
                    og.i("byteCount out of range");
                    return;
                }
                if (i3 >= 1024) {
                    ze2VarB = ze2Var6.c();
                } else {
                    ze2VarB = cf2.b();
                    byte[] bArr = ze2Var6.a;
                    byte[] bArr2 = ze2VarB.a;
                    int i4 = ze2Var6.b;
                    qg.d(bArr, 0, bArr2, i4, i4 + i3);
                }
                ze2VarB.c = ze2VarB.b + i3;
                ze2Var6.b += i3;
                ze2 ze2Var7 = ze2Var6.g;
                ze2Var7.getClass();
                ze2Var7.b(ze2VarB);
                lnVar.a = ze2VarB;
            }
            ze2 ze2Var8 = lnVar.a;
            ze2Var8.getClass();
            long j3 = ze2Var8.c - ze2Var8.b;
            lnVar.a = ze2Var8.a();
            ze2 ze2Var9 = this.a;
            if (ze2Var9 == null) {
                this.a = ze2Var8;
                ze2Var8.g = ze2Var8;
                ze2Var8.f = ze2Var8;
            } else {
                ze2 ze2Var10 = ze2Var9.g;
                ze2Var10.getClass();
                ze2Var10.b(ze2Var8);
                ze2 ze2Var11 = ze2Var8.g;
                if (ze2Var11 == ze2Var8) {
                    og.n("cannot compact");
                    return;
                }
                ze2Var11.getClass();
                if (ze2Var11.e) {
                    int i5 = ze2Var8.c - ze2Var8.b;
                    ze2 ze2Var12 = ze2Var8.g;
                    ze2Var12.getClass();
                    int i6 = 8192 - ze2Var12.c;
                    ze2 ze2Var13 = ze2Var8.g;
                    ze2Var13.getClass();
                    if (!ze2Var13.d) {
                        ze2 ze2Var14 = ze2Var8.g;
                        ze2Var14.getClass();
                        i2 = ze2Var14.b;
                    }
                    if (i5 <= i6 + i2) {
                        ze2 ze2Var15 = ze2Var8.g;
                        ze2Var15.getClass();
                        ze2Var8.d(ze2Var15, i5);
                        ze2Var8.a();
                        cf2.a(ze2Var8);
                    }
                }
            }
            lnVar.b -= j3;
            this.b += j3;
            j -= j3;
        }
    }

    public final String v(long j, Charset charset) throws EOFException {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            og.f(j, "byteCount: ");
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        ze2 ze2Var = this.a;
        ze2Var.getClass();
        int i = ze2Var.b;
        if (((long) i) + j > ze2Var.c) {
            return new String(r(j), charset);
        }
        int i2 = (int) j;
        String str = new String(ze2Var.a, i, i2, charset);
        int i3 = ze2Var.b + i2;
        ze2Var.b = i3;
        this.b -= j;
        if (i3 == ze2Var.c) {
            this.a = ze2Var.a();
            cf2.a(ze2Var);
        }
        return str;
    }

    public final String w() {
        return v(this.b, px.a);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            ze2 ze2VarY = y(1);
            int iMin = Math.min(i, 8192 - ze2VarY.c);
            byteBuffer.get(ze2VarY.a, ze2VarY.c, iMin);
            i -= iMin;
            ze2VarY.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn writeByte(int i) {
        E(i);
        return this;
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn writeInt(int i) {
        K(i);
        return this;
    }

    @Override // defpackage.xn
    public final /* bridge */ /* synthetic */ xn writeShort(int i) {
        L(i);
        return this;
    }

    public final oo x(int i) {
        if (i == 0) {
            return oo.e;
        }
        sg.a(this.b, 0L, i);
        ze2 ze2Var = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            ze2Var.getClass();
            int i5 = ze2Var.c;
            int i6 = ze2Var.b;
            if (i5 == i6) {
                og.m("s.limit == s.pos");
                return null;
            }
            i3 += i5 - i6;
            i4++;
            ze2Var = ze2Var.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        ze2 ze2Var2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            ze2Var2.getClass();
            bArr[i7] = ze2Var2.a;
            i2 += ze2Var2.c - ze2Var2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = ze2Var2.b;
            ze2Var2.d = true;
            i7++;
            ze2Var2 = ze2Var2.f;
        }
        return new df2(bArr, iArr);
    }

    public final ze2 y(int i) {
        if (i < 1 || i > 8192) {
            og.i("unexpected capacity");
            return null;
        }
        ze2 ze2Var = this.a;
        if (ze2Var == null) {
            ze2 ze2VarB = cf2.b();
            this.a = ze2VarB;
            ze2VarB.g = ze2VarB;
            ze2VarB.f = ze2VarB;
            return ze2VarB;
        }
        ze2 ze2Var2 = ze2Var.g;
        ze2Var2.getClass();
        if (ze2Var2.c + i <= 8192 && ze2Var2.e) {
            return ze2Var2;
        }
        ze2 ze2VarB2 = cf2.b();
        ze2Var2.b(ze2VarB2);
        return ze2VarB2;
    }

    @Override // defpackage.yn
    public final String z(long j) throws EOFException {
        if (j < 0) {
            og.f(j, "limit < 0: ");
            return null;
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jO = o((byte) 10, 0L, j2);
        if (jO != -1) {
            return b.a(jO, this);
        }
        if (j2 < this.b && j(j2 - 1) == 13 && j(j2) == 10) {
            return b.a(j2, this);
        }
        ln lnVar = new ln();
        c(lnVar, 0L, Math.min(32L, this.b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b, j) + " content=" + lnVar.l(lnVar.b).d() + (char) 8230);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, defpackage.wk2
    public final void close() {
    }

    @Override // defpackage.xn, defpackage.wk2, java.io.Flushable
    public final void flush() {
    }

    @Override // defpackage.xn
    public final xn n() {
        return this;
    }

    @Override // defpackage.xn
    public final ln s() {
        return this;
    }

    @Override // defpackage.xn
    public final xn write(byte[] bArr) {
        C(bArr, bArr.length);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        ze2 ze2Var = this.a;
        if (ze2Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), ze2Var.c - ze2Var.b);
        byteBuffer.put(ze2Var.a, ze2Var.b, iMin);
        int i = ze2Var.b + iMin;
        ze2Var.b = i;
        this.b -= (long) iMin;
        if (i == ze2Var.c) {
            this.a = ze2Var.a();
            cf2.a(ze2Var);
        }
        return iMin;
    }
}
