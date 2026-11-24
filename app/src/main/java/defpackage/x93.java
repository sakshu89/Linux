package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x93 implements Closeable {
    public final xn a;
    public final Random b;
    public final boolean c;
    public final boolean e;
    public final long f;
    public final ln i;
    public final ln j;
    public boolean k;
    public mi1 n;
    public final byte[] s;
    public final kn t;

    public x93(xn xnVar, Random random, boolean z, boolean z2, long j) {
        xnVar.getClass();
        this.a = xnVar;
        this.b = random;
        this.c = z;
        this.e = z2;
        this.f = j;
        this.i = new ln();
        this.j = xnVar.s();
        this.s = new byte[4];
        this.t = new kn();
    }

    public final void c(int i, oo ooVar) {
        if (this.k) {
            dk0.h("closed");
            return;
        }
        int iC = ooVar.c();
        if (iC > 125) {
            og.i("Payload size must be less than or equal to 125");
            return;
        }
        ln lnVar = this.j;
        lnVar.E(i | 128);
        lnVar.E(iC | 128);
        byte[] bArr = this.s;
        bArr.getClass();
        this.b.nextBytes(bArr);
        lnVar.C(bArr, bArr.length);
        if (iC > 0) {
            long j = lnVar.b;
            lnVar.A(ooVar);
            kn knVar = this.t;
            knVar.getClass();
            lnVar.q(knVar);
            knVar.e(j);
            kf4.a(knVar, bArr);
            knVar.close();
        }
        this.a.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        mi1 mi1Var = this.n;
        if (mi1Var != null) {
            mi1Var.close();
        }
    }

    public final void e(oo ooVar) throws IllegalAccessException, IOException, InvocationTargetException {
        int i;
        if (this.k) {
            dk0.h("closed");
            return;
        }
        ln lnVar = this.i;
        lnVar.A(ooVar);
        if (!this.c || ooVar.a.length < this.f) {
            i = 129;
        } else {
            mi1 mi1Var = this.n;
            if (mi1Var == null) {
                mi1Var = new mi1(this.e, 0);
                this.n = mi1Var;
            }
            ub0 ub0Var = (ub0) mi1Var.f;
            ln lnVar2 = mi1Var.c;
            if (lnVar2.b != 0) {
                og.i("Failed requirement.");
                return;
            }
            if (mi1Var.b) {
                ((Deflater) mi1Var.e).reset();
            }
            ub0Var.u(lnVar.b, lnVar);
            ub0Var.flush();
            oo ooVar2 = ni1.a;
            long j = lnVar2.b;
            byte[] bArr = ooVar2.a;
            long length = j - ((long) bArr.length);
            int length2 = bArr.length;
            if (length < 0 || length2 < 0 || j - length < length2 || bArr.length < length2) {
                lnVar2.E(0);
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    long j2 = lnVar2.b - 4;
                    kn knVarQ = lnVar2.q(sg.a);
                    try {
                        knVarQ.c(j2);
                        knVarQ.close();
                        break;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            fi4.a(knVarQ, th);
                            throw th2;
                        }
                    }
                }
                if (lnVar2.j(((long) i2) + length) != ooVar2.a[i2]) {
                    lnVar2.E(0);
                    break;
                }
                i2++;
            }
            lnVar.u(lnVar2.b, lnVar2);
            i = 193;
        }
        long j3 = lnVar.b;
        ln lnVar3 = this.j;
        lnVar3.E(i);
        if (j3 <= 125) {
            lnVar3.E(((int) j3) | 128);
        } else if (j3 <= 65535) {
            lnVar3.E(254);
            lnVar3.L((int) j3);
        } else {
            lnVar3.E(255);
            ze2 ze2VarY = lnVar3.y(8);
            byte[] bArr2 = ze2VarY.a;
            int i3 = ze2VarY.c;
            bArr2[i3] = (byte) ((j3 >>> 56) & 255);
            bArr2[i3 + 1] = (byte) ((j3 >>> 48) & 255);
            bArr2[i3 + 2] = (byte) ((j3 >>> 40) & 255);
            bArr2[i3 + 3] = (byte) ((j3 >>> 32) & 255);
            bArr2[i3 + 4] = (byte) ((j3 >>> 24) & 255);
            bArr2[i3 + 5] = (byte) ((j3 >>> 16) & 255);
            bArr2[i3 + 6] = (byte) ((j3 >>> 8) & 255);
            bArr2[i3 + 7] = (byte) (j3 & 255);
            ze2VarY.c = i3 + 8;
            lnVar3.b += 8;
        }
        byte[] bArr3 = this.s;
        bArr3.getClass();
        this.b.nextBytes(bArr3);
        lnVar3.C(bArr3, bArr3.length);
        if (j3 > 0) {
            kn knVar = this.t;
            knVar.getClass();
            lnVar.q(knVar);
            knVar.e(0L);
            kf4.a(knVar, bArr3);
            knVar.close();
        }
        lnVar3.u(j3, lnVar);
        this.a.n();
    }
}
