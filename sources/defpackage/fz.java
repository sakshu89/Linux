package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.Bidi;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fz extends hz {
    public final byte[] c;
    public int e;
    public int f;
    public int i;
    public final int j;
    public int k;
    public int n = Integer.MAX_VALUE;

    public fz(byte[] bArr, int i, int i2, boolean z) {
        this.c = bArr;
        this.e = i2 + i;
        this.i = i;
        this.j = i;
    }

    @Override // defpackage.hz
    public final int A() {
        return G();
    }

    @Override // defpackage.hz
    public final long B() {
        return H();
    }

    @Override // defpackage.hz
    public final boolean C(int i) throws o31 {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                K(8);
                return true;
            }
            if (i2 == 2) {
                K(G());
                return true;
            }
            if (i2 == 3) {
                D();
                b(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw o31.b();
            }
            K(4);
            return true;
        }
        int i4 = this.e - this.i;
        byte[] bArr = this.c;
        if (i4 >= 10) {
            while (i3 < 10) {
                int i5 = this.i;
                this.i = i5 + 1;
                if (bArr[i5] < 0) {
                    i3++;
                }
            }
            throw o31.c();
        }
        while (i3 < 10) {
            int i6 = this.i;
            if (i6 == this.e) {
                throw o31.e();
            }
            this.i = i6 + 1;
            if (bArr[i6] < 0) {
                i3++;
            }
        }
        throw o31.c();
        return true;
    }

    public final int E() throws o31 {
        int i = this.i;
        if (this.e - i < 4) {
            throw o31.e();
        }
        this.i = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | (bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) | ((bArr[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | ((bArr[i + 2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16);
    }

    public final long F() throws o31 {
        int i = this.i;
        if (this.e - i < 8) {
            throw o31.e();
        }
        this.i = i + 8;
        byte[] bArr = this.c;
        return ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final int G() {
        int i;
        int i2 = this.i;
        int i3 = this.e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i2];
            if (b >= 0) {
                this.i = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.i = i5;
                return i;
            }
        }
        return (int) I();
    }

    public final long H() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.i;
        int i2 = this.e;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.i = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i8]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i10 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i10;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j4 = j2 ^ j7;
                            }
                            j = j3 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.i = i4;
                return j;
            }
        }
        return I();
    }

    public final long I() throws o31 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.i;
            if (i2 == this.e) {
                throw o31.e();
            }
            this.i = i2 + 1;
            byte b = this.c[i2];
            j |= ((long) (b & Bidi.LEVEL_DEFAULT_RTL)) << i;
            if ((b & Bidi.LEVEL_OVERRIDE) == 0) {
                return j;
            }
        }
        throw o31.c();
    }

    public final void J() {
        int i = this.e + this.f;
        this.e = i;
        int i2 = i - this.j;
        int i3 = this.n;
        if (i2 <= i3) {
            this.f = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f = i4;
        this.e = i - i4;
    }

    public final void K(int i) throws o31 {
        if (i >= 0) {
            int i2 = this.e;
            int i3 = this.i;
            if (i <= i2 - i3) {
                this.i = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw o31.e();
        }
        throw o31.d();
    }

    @Override // defpackage.hz
    public final void b(int i) throws o31 {
        if (this.k != i) {
            throw new o31("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // defpackage.hz
    public final int c() {
        return this.i - this.j;
    }

    @Override // defpackage.hz
    public final boolean d() {
        return this.i == this.e;
    }

    @Override // defpackage.hz
    public final void i(int i) {
        this.n = i;
        J();
    }

    @Override // defpackage.hz
    public final int j(int i) {
        if (i < 0) {
            throw o31.d();
        }
        int iC = c() + i;
        if (iC < 0) {
            throw new o31("Failed to parse the message.");
        }
        int i2 = this.n;
        if (iC > i2) {
            throw o31.e();
        }
        this.n = iC;
        J();
        return i2;
    }

    @Override // defpackage.hz
    public final boolean k() {
        return H() != 0;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    @Override // defpackage.hz
    public final no l() throws o31 {
        byte[] bArrCopyOfRange;
        int iG = G();
        byte[] bArr = this.c;
        if (iG > 0) {
            int i = this.e;
            int i2 = this.i;
            if (iG <= i - i2) {
                no noVarD = no.d(i2, bArr, iG);
                this.i += iG;
                return noVarD;
            }
        }
        if (iG == 0) {
            return no.c;
        }
        if (iG > 0) {
            int i3 = this.e;
            int i4 = this.i;
            if (iG <= i3 - i4) {
                int i5 = iG + i4;
                this.i = i5;
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i4, i5);
            } else {
                if (iG <= 0) {
                    throw o31.e();
                }
                if (iG == 0) {
                    throw o31.d();
                }
                bArrCopyOfRange = x21.b;
            }
        } else {
            if (iG <= 0) {
                throw o31.e();
            }
            if (iG == 0) {
                throw o31.d();
            }
            bArrCopyOfRange = x21.b;
        }
        no noVar = no.c;
        return new no(bArrCopyOfRange);
    }

    @Override // defpackage.hz
    public final double m() {
        return Double.longBitsToDouble(F());
    }

    @Override // defpackage.hz
    public final int n() {
        return G();
    }

    @Override // defpackage.hz
    public final int o() {
        return E();
    }

    @Override // defpackage.hz
    public final long p() {
        return F();
    }

    @Override // defpackage.hz
    public final float q() {
        return Float.intBitsToFloat(E());
    }

    @Override // defpackage.hz
    public final int r() {
        return G();
    }

    @Override // defpackage.hz
    public final long s() {
        return H();
    }

    @Override // defpackage.hz
    public final int t() {
        return E();
    }

    @Override // defpackage.hz
    public final long u() {
        return F();
    }

    @Override // defpackage.hz
    public final int v() {
        int iG = G();
        return (-(iG & 1)) ^ (iG >>> 1);
    }

    @Override // defpackage.hz
    public final long w() {
        long jH = H();
        return (-(jH & 1)) ^ (jH >>> 1);
    }

    @Override // defpackage.hz
    public final String x() throws o31 {
        int iG = G();
        if (iG > 0) {
            int i = this.e;
            int i2 = this.i;
            if (iG <= i - i2) {
                String str = new String(this.c, i2, iG, x21.a);
                this.i += iG;
                return str;
            }
        }
        if (iG == 0) {
            return "";
        }
        if (iG < 0) {
            throw o31.d();
        }
        throw o31.e();
    }

    @Override // defpackage.hz
    public final String y() throws o31 {
        int iG = G();
        if (iG > 0) {
            int i = this.e;
            int i2 = this.i;
            if (iG <= i - i2) {
                String strB = x53.a.b(i2, this.c, iG);
                this.i += iG;
                return strB;
            }
        }
        if (iG == 0) {
            return "";
        }
        if (iG <= 0) {
            throw o31.d();
        }
        throw o31.e();
    }

    @Override // defpackage.hz
    public final int z() throws o31 {
        if (d()) {
            this.k = 0;
            return 0;
        }
        int iG = G();
        this.k = iG;
        if ((iG >>> 3) != 0) {
            return iG;
        }
        throw new o31("Protocol message contained an invalid tag (zero).");
    }
}
