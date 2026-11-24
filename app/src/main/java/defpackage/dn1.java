package defpackage;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dn1 extends lm1 {
    public final lm1 o;
    public boolean p;

    public dn1(long j, gm2 gm2Var, hq0 hq0Var, hq0 hq0Var2, lm1 lm1Var) {
        super(j, gm2Var, hq0Var, hq0Var2);
        this.o = lm1Var;
        lm1Var.k();
    }

    @Override // defpackage.lm1, defpackage.bm2
    public final void c() {
        if (this.c) {
            return;
        }
        super.c();
        if (this.p) {
            return;
        }
        this.p = true;
        this.o.l();
    }

    @Override // defpackage.lm1
    public final k44 w() {
        dn1 dn1Var;
        lm1 lm1Var = this.o;
        if (lm1Var.m || lm1Var.c) {
            return new cm2(this);
        }
        hm1 hm1Var = this.h;
        long j = this.b;
        HashMap mapB = hm1Var != null ? im2.b(lm1Var.g(), this, this.o.d()) : null;
        Object obj = im2.c;
        synchronized (obj) {
            try {
                im2.c(this);
                if (hm1Var == null || hm1Var.d == 0) {
                    dn1Var = this;
                    dn1Var.a();
                } else {
                    dn1Var = this;
                    k44 k44VarZ = dn1Var.z(this.o.g(), hm1Var, mapB, this.o.d());
                    if (!k44VarZ.equals(dm2.a)) {
                        return k44VarZ;
                    }
                    hm1 hm1VarX = dn1Var.o.x();
                    if (hm1VarX != null) {
                        hm1VarX.j(hm1Var);
                    } else {
                        dn1Var.o.B(hm1Var);
                        dn1Var.h = null;
                    }
                }
                if (g31.c(dn1Var.o.g(), j) < 0) {
                    dn1Var.o.v();
                }
                lm1 lm1Var2 = dn1Var.o;
                lm1Var2.r(lm1Var2.d().b(j).a(dn1Var.j));
                dn1Var.o.A(j);
                lm1 lm1Var3 = dn1Var.o;
                int i = dn1Var.d;
                dn1Var.d = -1;
                if (i >= 0) {
                    int[] iArr = lm1Var3.k;
                    iArr.getClass();
                    int length = iArr.length;
                    int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
                    iArrCopyOf[length] = i;
                    lm1Var3.k = iArrCopyOf;
                } else {
                    lm1Var3.getClass();
                }
                lm1 lm1Var4 = dn1Var.o;
                gm2 gm2Var = dn1Var.j;
                lm1Var4.getClass();
                synchronized (obj) {
                    lm1Var4.j = lm1Var4.j.f(gm2Var);
                    lm1 lm1Var5 = dn1Var.o;
                    int[] iArr2 = dn1Var.k;
                    lm1Var5.getClass();
                    if (iArr2.length != 0) {
                        int[] iArr3 = lm1Var5.k;
                        if (iArr3.length != 0) {
                            int length2 = iArr3.length;
                            int length3 = iArr2.length;
                            int[] iArrCopyOf2 = Arrays.copyOf(iArr3, length2 + length3);
                            System.arraycopy(iArr2, 0, iArrCopyOf2, length2, length3);
                            iArr2 = iArrCopyOf2;
                        }
                        lm1Var5.k = iArr2;
                    }
                }
                dn1Var.m = true;
                if (!dn1Var.p) {
                    dn1Var.p = true;
                    dn1Var.o.l();
                }
                return dm2.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
