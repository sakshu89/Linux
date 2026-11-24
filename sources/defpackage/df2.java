package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class df2 extends oo {
    public final transient byte[][] f;
    public final transient int[] i;

    public df2(byte[][] bArr, int[] iArr) {
        super(oo.e.a);
        this.f = bArr;
        this.i = iArr;
    }

    @Override // defpackage.oo
    public final String a() {
        throw null;
    }

    @Override // defpackage.oo
    public final oo b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.i;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new oo(bArrDigest);
    }

    @Override // defpackage.oo
    public final int c() {
        return this.i[this.f.length - 1];
    }

    @Override // defpackage.oo
    public final String d() {
        return new oo(l()).d();
    }

    @Override // defpackage.oo
    public final byte[] e() {
        return l();
    }

    @Override // defpackage.oo
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oo)) {
            return false;
        }
        oo ooVar = (oo) obj;
        return ooVar.c() == c() && g(c(), ooVar);
    }

    @Override // defpackage.oo
    public final byte f(int i) {
        byte[][] bArr = this.f;
        int length = bArr.length - 1;
        int[] iArr = this.i;
        sg.a(iArr[length], i, 1L);
        int iB = ub4.b(this, i);
        return bArr[iB][(i - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // defpackage.oo
    public final boolean g(int i, oo ooVar) {
        ooVar.getClass();
        if (c() - i >= 0) {
            int iB = ub4.b(this, 0);
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int[] iArr = this.i;
                int i4 = iB == 0 ? 0 : iArr[iB - 1];
                int i5 = iArr[iB] - i4;
                byte[][] bArr = this.f;
                int i6 = iArr[bArr.length + iB];
                int iMin = Math.min(i, i5 + i4) - i2;
                if (ooVar.h(bArr[iB], i3, (i2 - i4) + i6, iMin)) {
                    i3 += iMin;
                    i2 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.oo
    public final boolean h(byte[] bArr, int i, int i2, int i3) {
        bArr.getClass();
        if (i >= 0 && i <= c() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int i4 = i3 + i;
            int iB = ub4.b(this, i);
            while (i < i4) {
                int[] iArr = this.i;
                int i5 = iB == 0 ? 0 : iArr[iB - 1];
                int i6 = iArr[iB] - i5;
                byte[][] bArr2 = this.f;
                int i7 = iArr[bArr2.length + iB];
                int iMin = Math.min(i4, i6 + i5) - i;
                int i8 = (i - i5) + i7;
                byte[] bArr3 = bArr2[iB];
                bArr3.getClass();
                for (int i9 = 0; i9 < iMin; i9++) {
                    if (bArr3[i9 + i8] == bArr[i9 + i2]) {
                    }
                }
                i2 += iMin;
                i += iMin;
                iB++;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.oo
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.f;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.i;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.b = i3;
        return i3;
    }

    @Override // defpackage.oo
    public final oo i() {
        return new oo(l()).i();
    }

    @Override // defpackage.oo
    public final void k(ln lnVar, int i) {
        int iB = ub4.b(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.i;
            int i3 = iB == 0 ? 0 : iArr[iB - 1];
            int i4 = iArr[iB] - i3;
            byte[][] bArr = this.f;
            int i5 = iArr[bArr.length + iB];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            ze2 ze2Var = new ze2(bArr[iB], i6, i6 + iMin, true, false);
            ze2 ze2Var2 = lnVar.a;
            if (ze2Var2 == null) {
                ze2Var.g = ze2Var;
                ze2Var.f = ze2Var;
                lnVar.a = ze2Var;
            } else {
                ze2 ze2Var3 = ze2Var2.g;
                ze2Var3.getClass();
                ze2Var3.b(ze2Var);
            }
            i2 += iMin;
            iB++;
        }
        lnVar.b += (long) i;
    }

    public final byte[] l() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.i;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            qg.d(bArr2[i], i3, bArr, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // defpackage.oo
    public final String toString() {
        return new oo(l()).toString();
    }
}
