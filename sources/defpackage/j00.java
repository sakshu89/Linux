package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j00 implements oh1, b92 {
    public final fg a;
    public final jl b;

    public j00(fg fgVar, jl jlVar) {
        this.a = fgVar;
        this.b = jlVar;
    }

    @Override // defpackage.oh1
    public final int a(z21 z21Var, List list, int i) {
        int iR = z21Var.R(this.a.a());
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i2 = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            jh1 jh1Var = (jh1) list.get(i3);
            float fB = fz3.b(fz3.a(jh1Var));
            int iF = jh1Var.f(i);
            if (fB == 0.0f) {
                i2 += iF;
            } else if (fB > 0.0f) {
                f += fB;
                iMax = Math.max(iMax, Math.round(iF / fB));
            }
        }
        return ((list.size() - 1) * iR) + Math.round(iMax * f) + i2;
    }

    @Override // defpackage.b92
    public final void b(int i, qh1 qh1Var, int[] iArr, int[] iArr2) {
        this.a.i(i, qh1Var, iArr, iArr2);
    }

    @Override // defpackage.oh1
    public final int c(z21 z21Var, List list, int i) {
        int iR = z21Var.R(this.a.a());
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * iR, i);
        int size = list.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            jh1 jh1Var = (jh1) list.get(i2);
            float fB = fz3.b(fz3.a(jh1Var));
            if (fB == 0.0f) {
                int iMin2 = Math.min(jh1Var.f(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, jh1Var.c0(iMin2));
            } else if (fB > 0.0f) {
                f += fB;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            jh1 jh1Var2 = (jh1) list.get(i3);
            float fB2 = fz3.b(fz3.a(jh1Var2));
            if (fB2 > 0.0f) {
                iMax = Math.max(iMax, jh1Var2.c0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fB2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // defpackage.b92
    public final long d(int i, int i2, int i3, boolean z) {
        return !z ? r40.a(0, i3, i, i2) : wk4.a(0, i3, i, i2);
    }

    @Override // defpackage.b92
    public final int e(zw1 zw1Var) {
        return zw1Var.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j00)) {
            return false;
        }
        j00 j00Var = (j00) obj;
        return this.a.equals(j00Var.a) && this.b.equals(j00Var.b);
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        return hz3.a(this, q40.i(j), q40.j(j), q40.g(j), q40.h(j), qh1Var.R(this.a.a()), qh1Var, list, new zw1[list.size()], 0, list.size(), null, 0);
    }

    @Override // defpackage.oh1
    public final int g(z21 z21Var, List list, int i) {
        int iR = z21Var.R(this.a.a());
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i2 = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            jh1 jh1Var = (jh1) list.get(i3);
            float fB = fz3.b(fz3.a(jh1Var));
            int iE0 = jh1Var.e0(i);
            if (fB == 0.0f) {
                i2 += iE0;
            } else if (fB > 0.0f) {
                f += fB;
                iMax = Math.max(iMax, Math.round(iE0 / fB));
            }
        }
        return ((list.size() - 1) * iR) + Math.round(iMax * f) + i2;
    }

    @Override // defpackage.b92
    public final int h(zw1 zw1Var) {
        return zw1Var.b;
    }

    public final int hashCode() {
        return Float.hashCode(this.b.a) + (this.a.hashCode() * 31);
    }

    @Override // defpackage.oh1
    public final int i(z21 z21Var, List list, int i) {
        int iR = z21Var.R(this.a.a());
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * iR, i);
        int size = list.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            jh1 jh1Var = (jh1) list.get(i2);
            float fB = fz3.b(fz3.a(jh1Var));
            if (fB == 0.0f) {
                int iMin2 = Math.min(jh1Var.f(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, jh1Var.V(iMin2));
            } else if (fB > 0.0f) {
                f += fB;
            }
        }
        int iRound = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            jh1 jh1Var2 = (jh1) list.get(i3);
            float fB2 = fz3.b(fz3.a(jh1Var2));
            if (fB2 > 0.0f) {
                iMax = Math.max(iMax, jh1Var2.V(iRound != Integer.MAX_VALUE ? Math.round(iRound * fB2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // defpackage.b92
    public final ph1 j(final zw1[] zw1VarArr, final qh1 qh1Var, final int[] iArr, int i, final int i2, int[] iArr2, int i3, int i4, int i5) {
        return qh1Var.j0(i2, i, ji0.a, new hq0() { // from class: i00
            @Override // defpackage.hq0
            public final Object j(Object obj) {
                yw1 yw1Var = (yw1) obj;
                zw1[] zw1VarArr2 = zw1VarArr;
                int length = zw1VarArr2.length;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    zw1 zw1Var = zw1VarArr2[i6];
                    zw1Var.getClass();
                    zw1Var.k();
                    yw1.h(yw1Var, zw1Var, this.b.a(zw1Var.a, i2, qh1Var.getLayoutDirection()), iArr[i7]);
                    i6++;
                    i7++;
                }
                return q43.a;
            }
        });
    }

    public final String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.a + ", horizontalAlignment=" + this.b + ')';
    }
}
