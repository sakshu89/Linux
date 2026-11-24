package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mn0 implements b92 {
    public final dg a;
    public final fg b;
    public final float c;
    public final c80 d;
    public final float e;
    public final kn0 f;

    public mn0(dg dgVar, fg fgVar, float f, c80 c80Var, float f2, kn0 kn0Var) {
        this.a = dgVar;
        this.b = fgVar;
        this.c = f;
        this.d = c80Var;
        this.e = f2;
        this.f = kn0Var;
    }

    public static int a(List list, int i, int i2, int i3, kn0 kn0Var) {
        long jA = a21.a(0, 0);
        if (!list.isEmpty()) {
            int i4 = Integer.MAX_VALUE;
            en0 en0Var = new en0(kn0Var, r40.a(0, i, 0, Integer.MAX_VALUE), i2, i3);
            jh1 jh1Var = (jh1) mz.z(0, list);
            int iE0 = jh1Var != null ? jh1Var.e0(i) : 0;
            int iV = jh1Var != null ? jh1Var.V(iE0) : 0;
            boolean z = true;
            if (list.size() <= 1) {
                z = false;
            }
            int i5 = 0;
            if (en0Var.b(z, 0, a21.a(i, Integer.MAX_VALUE), jh1Var == null ? null : new a21(a21.a(iV, iE0)), 0, 0, 0, false, false).b) {
                kn0Var.getClass();
                jA = jA;
            } else {
                int size = list.size();
                int i6 = i;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i9 < size) {
                    int i12 = i6 - iV;
                    i9++;
                    int iMax = Math.max(i8, iE0);
                    jh1 jh1Var2 = (jh1) mz.z(i9, list);
                    iE0 = jh1Var2 != null ? jh1Var2.e0(i) : 0;
                    int iV2 = jh1Var2 != null ? jh1Var2.V(iE0) + i2 : 0;
                    int i13 = i9 - i11;
                    int i14 = i7;
                    int i15 = iV2;
                    ph phVarB = en0Var.b(i9 + 2 < list.size() ? z : false, i13, a21.a(i12, i4), jh1Var2 == null ? null : new a21(a21.a(iV2, iE0)), i14, i5, iMax, false, false);
                    if (phVarB.a) {
                        int i16 = iMax + i3 + i5;
                        en0Var.a(phVarB, jh1Var2 != null, i14, i16, i12, i13);
                        int i17 = i15 - i2;
                        i7 = i14 + 1;
                        if (phVarB.b) {
                            i10 = i9;
                            i5 = i16;
                            break;
                        }
                        i6 = i;
                        i11 = i9;
                        iV = i17;
                        i5 = i16;
                        i8 = 0;
                    } else {
                        iV = i15;
                        i6 = i12;
                        i7 = i14;
                        i8 = iMax;
                    }
                    i10 = i9;
                    i4 = Integer.MAX_VALUE;
                    z = true;
                }
                jA = a21.a(i5 - i3, i10);
            }
        }
        return (int) (jA >> 32);
    }

    @Override // defpackage.b92
    public final void b(int i, qh1 qh1Var, int[] iArr, int[] iArr2) {
        this.a.h(qh1Var, i, iArr, qh1Var.getLayoutDirection(), iArr2);
    }

    @Override // defpackage.b92
    public final long d(int i, int i2, int i3, boolean z) {
        e92 e92Var = d92.a;
        return !z ? r40.a(i, i2, 0, i3) : wk4.b(i, i2, 0, i3);
    }

    @Override // defpackage.b92
    public final int e(zw1 zw1Var) {
        return zw1Var.h0();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mn0)) {
            return false;
        }
        mn0 mn0Var = (mn0) obj;
        return this.a.equals(mn0Var.a) && this.b.equals(mn0Var.b) && de0.b(this.c, mn0Var.c) && this.d.equals(mn0Var.d) && de0.b(this.e, mn0Var.e) && g31.a(this.f, mn0Var.f);
    }

    @Override // defpackage.b92
    public final int h(zw1 zw1Var) {
        return zw1Var.i0();
    }

    public final int hashCode() {
        return this.f.hashCode() + ky0.a(Integer.MAX_VALUE, ky0.a(Integer.MAX_VALUE, cq.b(cq.b(cq.b((this.b.hashCode() + ((this.a.hashCode() + (Boolean.hashCode(true) * 31)) * 31)) * 31, this.c, 31), -1.0f, 31), this.e, 31), 31), 31);
    }

    @Override // defpackage.b92
    public final ph1 j(final zw1[] zw1VarArr, qh1 qh1Var, final int[] iArr, int i, final int i2, final int[] iArr2, final int i3, final int i4, final int i5) {
        final z61 z61Var = z61.a;
        return qh1Var.j0(i, i2, ji0.a, new hq0() { // from class: ln0
            @Override // defpackage.hq0
            public final Object j(Object obj) {
                yw1 yw1Var = (yw1) obj;
                int[] iArr3 = iArr2;
                int i6 = iArr3 != null ? iArr3[i3] : 0;
                int i7 = i4;
                for (int i8 = i7; i8 < i5; i8++) {
                    zw1 zw1Var = zw1VarArr[i8];
                    zw1Var.getClass();
                    zw1Var.k();
                    c80 c80Var = this.d;
                    yw1.h(yw1Var, zw1Var, iArr[i8 - i7], Math.round((1.0f - 1.0f) * ((i2 - zw1Var.h0()) / 2.0f)) + i6);
                }
                return q43.a;
            }
        });
    }

    public final String toString() {
        return "FlowMeasurePolicy(isHorizontal=true, horizontalArrangement=" + this.a + ", verticalArrangement=" + this.b + ", mainAxisSpacing=" + ((Object) de0.c(this.c)) + ", crossAxisAlignment=" + this.d + ", crossAxisArrangementSpacing=" + ((Object) de0.c(this.e)) + ", maxItemsInMainAxis=2147483647, maxLines=2147483647, overflow=" + this.f + ')';
    }
}
