package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jm implements oh1 {
    public final ll a;
    public final boolean b;

    public jm(ll llVar, boolean z) {
        this.a = llVar;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) obj;
        return this.a.equals(jmVar.a) && this.b == jmVar.b;
    }

    @Override // defpackage.oh1
    public final ph1 f(final qh1 qh1Var, List list, long j) {
        boolean zIsEmpty = list.isEmpty();
        ji0 ji0Var = ji0.a;
        if (zIsEmpty) {
            return qh1Var.j0(q40.j(j), q40.i(j), ji0Var, new j(7));
        }
        long j2 = this.b ? j : j & (-8589934589L);
        if (list.size() == 1) {
            final jh1 jh1Var = (jh1) list.get(0);
            jh1Var.k();
            final zw1 zw1VarE = jh1Var.e(j2);
            final int iMax = Math.max(q40.j(j), zw1VarE.a);
            final int iMax2 = Math.max(q40.i(j), zw1VarE.b);
            return qh1Var.j0(iMax, iMax2, ji0Var, new hq0() { // from class: hm
                @Override // defpackage.hq0
                public final Object j(Object obj) {
                    gm.b((yw1) obj, zw1VarE, jh1Var, qh1Var.getLayoutDirection(), iMax, iMax2, this.a);
                    return q43.a;
                }
            });
        }
        zw1[] zw1VarArr = new zw1[list.size()];
        r42 r42Var = new r42();
        r42Var.a = q40.j(j);
        r42 r42Var2 = new r42();
        r42Var2.a = q40.i(j);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jh1 jh1Var2 = (jh1) list.get(i);
            jh1Var2.k();
            zw1 zw1VarE2 = jh1Var2.e(j2);
            zw1VarArr[i] = zw1VarE2;
            r42Var.a = Math.max(r42Var.a, zw1VarE2.a);
            r42Var2.a = Math.max(r42Var2.a, zw1VarE2.b);
        }
        return qh1Var.j0(r42Var.a, r42Var2.a, ji0Var, new im(zw1VarArr, list, qh1Var, r42Var, r42Var2, this, 0));
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxMeasurePolicy(alignment=" + this.a + ", propagateMinConstraints=" + this.b + ')';
    }
}
