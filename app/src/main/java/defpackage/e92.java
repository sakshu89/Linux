package defpackage;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e92 implements oh1, b92 {
    public final dg a;
    public final kl b;

    public e92(dg dgVar, kl klVar) {
        this.a = dgVar;
        this.b = klVar;
    }

    @Override // defpackage.oh1
    public final int a(z21 z21Var, List list, int i) {
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
                int iMin2 = Math.min(jh1Var.c0(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, jh1Var.f(iMin2));
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
                iMax = Math.max(iMax, jh1Var2.f(iRound != Integer.MAX_VALUE ? Math.round(iRound * fB2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // defpackage.b92
    public final void b(int i, qh1 qh1Var, int[] iArr, int[] iArr2) {
        this.a.h(qh1Var, i, iArr, qh1Var.getLayoutDirection(), iArr2);
    }

    @Override // defpackage.oh1
    public final int c(z21 z21Var, List list, int i) {
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
            int iC0 = jh1Var.c0(i);
            if (fB == 0.0f) {
                i2 += iC0;
            } else if (fB > 0.0f) {
                f += fB;
                iMax = Math.max(iMax, Math.round(iC0 / fB));
            }
        }
        return ((list.size() - 1) * iR) + Math.round(iMax * f) + i2;
    }

    @Override // defpackage.b92
    public final long d(int i, int i2, int i3, boolean z) {
        return !z ? r40.a(i, i2, 0, i3) : wk4.b(i, i2, 0, i3);
    }

    @Override // defpackage.b92
    public final int e(zw1 zw1Var) {
        return zw1Var.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e92)) {
            return false;
        }
        e92 e92Var = (e92) obj;
        return this.a.equals(e92Var.a) && g31.a(this.b, e92Var.b);
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        return hz3.a(this, q40.j(j), q40.i(j), q40.h(j), q40.g(j), qh1Var.R(this.a.a()), qh1Var, list, new zw1[list.size()], 0, list.size(), null, 0);
    }

    @Override // defpackage.oh1
    public final int g(z21 z21Var, List list, int i) {
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
                int iMin2 = Math.min(jh1Var.c0(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, jh1Var.e0(iMin2));
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
                iMax = Math.max(iMax, jh1Var2.e0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fB2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // defpackage.b92
    public final int h(zw1 zw1Var) {
        return zw1Var.a;
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
        int size = list.size();
        int iMax = 0;
        int i2 = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            jh1 jh1Var = (jh1) list.get(i3);
            float fB = fz3.b(fz3.a(jh1Var));
            int iV = jh1Var.V(i);
            if (fB == 0.0f) {
                i2 += iV;
            } else if (fB > 0.0f) {
                f += fB;
                iMax = Math.max(iMax, Math.round(iV / fB));
            }
        }
        return ((list.size() - 1) * iR) + Math.round(iMax * f) + i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.b92
    public final ph1 j(zw1[] zw1VarArr, qh1 qh1Var, int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5) {
        return qh1Var.j0(i, i2, ji0.a, new h2((Object) zw1VarArr, (Object) this, i2, (Serializable) iArr, 3));
    }

    public final String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.a + ", verticalAlignment=" + this.b + ')';
    }
}
