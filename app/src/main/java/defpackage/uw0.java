package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uw0 implements d71 {
    public final fy2 a;
    public final int b;
    public final a23 c;
    public final fq0 d;

    public uw0(fy2 fy2Var, int i, a23 a23Var, fq0 fq0Var) {
        this.a = fy2Var;
        this.b = i;
        this.c = a23Var;
        this.d = fq0Var;
    }

    @Override // defpackage.d71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        long j2;
        if (jh1Var.c0(q40.g(j)) < q40.h(j)) {
            j2 = j;
        } else {
            j2 = j;
            j = q40.a(j2, 0, Integer.MAX_VALUE, 0, 0, 13);
        }
        zw1 zw1VarE = jh1Var.e(j);
        int iMin = Math.min(zw1VarE.a, q40.h(j2));
        return qh1Var.j0(iMin, zw1VarE.b, ji0.a, new h2(this, qh1Var, zw1VarE, iMin, 2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof uw0) {
            uw0 uw0Var = (uw0) obj;
            if (this.a == uw0Var.a && this.b == uw0Var.b && this.c.equals(uw0Var.c) && g31.a(this.d, uw0Var.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ky0.a(this.b, this.a.hashCode() * 31, 31)) * 31);
    }

    public final String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.a + ", cursorOffset=" + this.b + ", transformedText=" + this.c + ", textLayoutResultProvider=" + this.d + ')';
    }
}
