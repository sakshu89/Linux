package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ax0 {
    public final ln a;
    public boolean c;
    public int g;
    public int h;
    public int b = Integer.MAX_VALUE;
    public int d = 4096;
    public dw0[] e = new dw0[8];
    public int f = 7;

    public ax0(ln lnVar) {
        this.a = lnVar;
    }

    public final void a(int i) {
        int i2;
        if (i > 0) {
            int length = this.e.length - 1;
            int i3 = 0;
            while (true) {
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                dw0 dw0Var = this.e[length];
                dw0Var.getClass();
                i -= dw0Var.c;
                int i4 = this.h;
                dw0 dw0Var2 = this.e[length];
                dw0Var2.getClass();
                this.h = i4 - dw0Var2.c;
                this.g--;
                i3++;
                length--;
            }
            dw0[] dw0VarArr = this.e;
            int i5 = i2 + 1;
            System.arraycopy(dw0VarArr, i5, dw0VarArr, i5 + i3, this.g);
            dw0[] dw0VarArr2 = this.e;
            int i6 = this.f + 1;
            Arrays.fill(dw0VarArr2, i6, i6 + i3, (Object) null);
            this.f += i3;
        }
    }

    public final void b(dw0 dw0Var) {
        int i = dw0Var.c;
        int i2 = this.d;
        if (i > i2) {
            dw0[] dw0VarArr = this.e;
            qg.l(0, dw0VarArr.length, null, dw0VarArr);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i2);
        int i3 = this.g + 1;
        dw0[] dw0VarArr2 = this.e;
        if (i3 > dw0VarArr2.length) {
            dw0[] dw0VarArr3 = new dw0[dw0VarArr2.length * 2];
            System.arraycopy(dw0VarArr2, 0, dw0VarArr3, dw0VarArr2.length, dw0VarArr2.length);
            this.f = this.e.length - 1;
            this.e = dw0VarArr3;
        }
        int i4 = this.f;
        this.f = i4 - 1;
        this.e[i4] = dw0Var;
        this.g++;
        this.h += i;
    }

    public final void c(oo ooVar) throws EOFException {
        ooVar.getClass();
        int[] iArr = hy0.a;
        int iC = ooVar.c();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < iC; i++) {
            byte bF = ooVar.f(i);
            byte[] bArr = z53.a;
            j2 += (long) hy0.b[bF & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED];
        }
        int i2 = (int) ((j2 + 7) >> 3);
        int iC2 = ooVar.c();
        ln lnVar = this.a;
        if (i2 >= iC2) {
            e(ooVar.c(), 127, 0);
            lnVar.A(ooVar);
            return;
        }
        ln lnVar2 = new ln();
        int[] iArr2 = hy0.a;
        int iC3 = ooVar.c();
        int i3 = 0;
        for (int i4 = 0; i4 < iC3; i4++) {
            byte bF2 = ooVar.f(i4);
            byte[] bArr2 = z53.a;
            int i5 = bF2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            int i6 = hy0.a[i5];
            byte b = hy0.b[i5];
            j = (j << b) | ((long) i6);
            i3 += b;
            while (i3 >= 8) {
                i3 -= 8;
                lnVar2.E((int) (j >> i3));
            }
        }
        if (i3 > 0) {
            lnVar2.E((int) ((j << (8 - i3)) | (255 >>> i3)));
        }
        oo ooVarL = lnVar2.l(lnVar2.b);
        e(ooVarL.c(), 127, 128);
        lnVar.A(ooVarL);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public final void d(ArrayList arrayList) throws EOFException {
        int length;
        int length2;
        if (this.c) {
            int i = this.b;
            if (i < this.d) {
                e(i, 31, 32);
            }
            this.c = false;
            this.b = Integer.MAX_VALUE;
            e(this.d, 31, 32);
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            dw0 dw0Var = (dw0) arrayList.get(i2);
            oo ooVarI = dw0Var.a.i();
            oo ooVar = dw0Var.b;
            Integer num = (Integer) bx0.b.get(ooVarI);
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (2 > length2 || length2 >= 8) {
                    length = length2;
                    length2 = -1;
                } else {
                    dw0[] dw0VarArr = bx0.a;
                    if (g31.a(dw0VarArr[iIntValue].b, ooVar)) {
                        length = length2;
                    } else if (g31.a(dw0VarArr[length2].b, ooVar)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length2 == -1) {
                int length3 = this.e.length;
                for (int i3 = this.f + 1; i3 < length3; i3++) {
                    dw0 dw0Var2 = this.e[i3];
                    dw0Var2.getClass();
                    if (g31.a(dw0Var2.a, ooVarI)) {
                        dw0 dw0Var3 = this.e[i3];
                        dw0Var3.getClass();
                        if (g31.a(dw0Var3.b, ooVar)) {
                            length2 = bx0.a.length + (i3 - this.f);
                            break;
                        } else if (length == -1) {
                            length = (i3 - this.f) + bx0.a.length;
                        }
                    }
                }
            }
            if (length2 != -1) {
                e(length2, 127, 128);
            } else if (length == -1) {
                this.a.E(64);
                c(ooVarI);
                c(ooVar);
                b(dw0Var);
            } else {
                oo ooVar2 = dw0.d;
                ooVarI.getClass();
                ooVar2.getClass();
                if (!ooVarI.g(ooVar2.c(), ooVar2) || g31.a(dw0.i, ooVarI)) {
                    e(length, 63, 64);
                    c(ooVar);
                    b(dw0Var);
                } else {
                    e(length, 15, 0);
                    c(ooVar);
                }
            }
        }
    }

    public final void e(int i, int i2, int i3) {
        ln lnVar = this.a;
        if (i < i2) {
            lnVar.E(i | i3);
            return;
        }
        lnVar.E(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            lnVar.E(128 | (i4 & 127));
            i4 >>>= 7;
        }
        lnVar.E(i4);
    }
}
