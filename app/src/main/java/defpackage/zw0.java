package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.text.Bidi;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zw0 {
    public final i32 c;
    public int f;
    public int g;
    public int a = 4096;
    public final ArrayList b = new ArrayList();
    public dw0[] d = new dw0[8];
    public int e = 7;

    public zw0(vx0 vx0Var) {
        this.c = new i32(vx0Var);
    }

    public final int a(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.d.length;
            while (true) {
                length--;
                i2 = this.e;
                if (length < i2 || i <= 0) {
                    break;
                }
                dw0 dw0Var = this.d[length];
                dw0Var.getClass();
                int i4 = dw0Var.c;
                i -= i4;
                this.g -= i4;
                this.f--;
                i3++;
            }
            dw0[] dw0VarArr = this.d;
            System.arraycopy(dw0VarArr, i2 + 1, dw0VarArr, i2 + 1 + i3, this.f);
            this.e += i3;
        }
        return i3;
    }

    public final oo b(int i) throws IOException {
        if (i >= 0) {
            dw0[] dw0VarArr = bx0.a;
            if (i <= dw0VarArr.length - 1) {
                return dw0VarArr[i].a;
            }
        }
        int length = this.e + 1 + (i - bx0.a.length);
        if (length >= 0) {
            dw0[] dw0VarArr2 = this.d;
            if (length < dw0VarArr2.length) {
                dw0 dw0Var = dw0VarArr2[length];
                dw0Var.getClass();
                return dw0Var.a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(dw0 dw0Var) {
        this.b.add(dw0Var);
        int i = dw0Var.c;
        int i2 = this.a;
        if (i > i2) {
            dw0[] dw0VarArr = this.d;
            qg.l(0, dw0VarArr.length, null, dw0VarArr);
            this.e = this.d.length - 1;
            this.f = 0;
            this.g = 0;
            return;
        }
        a((this.g + i) - i2);
        int i3 = this.f + 1;
        dw0[] dw0VarArr2 = this.d;
        if (i3 > dw0VarArr2.length) {
            dw0[] dw0VarArr3 = new dw0[dw0VarArr2.length * 2];
            System.arraycopy(dw0VarArr2, 0, dw0VarArr3, dw0VarArr2.length, dw0VarArr2.length);
            this.e = this.d.length - 1;
            this.d = dw0VarArr3;
        }
        int i4 = this.e;
        this.e = i4 - 1;
        this.d[i4] = dw0Var;
        this.f++;
        this.g += i;
    }

    public final oo d() {
        i32 i32Var = this.c;
        byte b = i32Var.readByte();
        byte[] bArr = z53.a;
        int i = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        int i2 = 0;
        boolean z = (b & Bidi.LEVEL_OVERRIDE) == 128;
        long jE = e(i, 127);
        if (!z) {
            return i32Var.l(jE);
        }
        ln lnVar = new ln();
        int[] iArr = hy0.a;
        i32Var.getClass();
        gy0 gy0Var = hy0.c;
        gy0 gy0Var2 = gy0Var;
        int i3 = 0;
        for (long j = 0; j < jE; j++) {
            byte b2 = i32Var.readByte();
            byte[] bArr2 = z53.a;
            i2 = (i2 << 8) | (b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            i3 += 8;
            while (i3 >= 8) {
                gy0[] gy0VarArr = (gy0[]) gy0Var2.c;
                gy0VarArr.getClass();
                gy0Var2 = gy0VarArr[(i2 >>> (i3 - 8)) & 255];
                gy0Var2.getClass();
                if (((gy0[]) gy0Var2.c) == null) {
                    lnVar.E(gy0Var2.a);
                    i3 -= gy0Var2.b;
                    gy0Var2 = gy0Var;
                } else {
                    i3 -= 8;
                }
            }
        }
        while (i3 > 0) {
            gy0[] gy0VarArr2 = (gy0[]) gy0Var2.c;
            gy0VarArr2.getClass();
            gy0 gy0Var3 = gy0VarArr2[(i2 << (8 - i3)) & 255];
            gy0Var3.getClass();
            int i4 = gy0Var3.b;
            if (((gy0[]) gy0Var3.c) != null || i4 > i3) {
                break;
            }
            lnVar.E(gy0Var3.a);
            i3 -= i4;
            gy0Var2 = gy0Var;
        }
        return lnVar.l(lnVar.b);
    }

    public final int e(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            byte b = this.c.readByte();
            byte[] bArr = z53.a;
            int i5 = b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
            if ((b & Bidi.LEVEL_OVERRIDE) == 0) {
                return i2 + (i5 << i4);
            }
            i2 += (b & Bidi.LEVEL_DEFAULT_RTL) << i4;
            i4 += 7;
        }
    }
}
