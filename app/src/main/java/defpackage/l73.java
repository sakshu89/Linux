package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l73 implements d71 {
    public final fy2 a;
    public final int b;
    public final a23 c;
    public final fq0 d;

    public l73(fy2 fy2Var, int i, a23 a23Var, fq0 fq0Var) {
        this.a = fy2Var;
        this.b = i;
        this.c = a23Var;
        this.d = fq0Var;
    }

    @Override // defpackage.d71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(q40.a(j, 0, 0, 0, Integer.MAX_VALUE, 7));
        int iMin = Math.min(zw1VarE.b, q40.g(j));
        return qh1Var.j0(zw1VarE.a, iMin, ji0.a, new z32(this, zw1VarE, iMin));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l73) {
            l73 l73Var = (l73) obj;
            if (this.a == l73Var.a && this.b == l73Var.b && this.c.equals(l73Var.c) && g31.a(this.d, l73Var.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ky0.a(this.b, this.a.hashCode() * 31, 31)) * 31);
    }

    public final String toString() {
        return "VerticalScrollLayoutModifier(scrollerPosition=" + this.a + ", cursorOffset=" + this.b + ", transformedText=" + this.c + ", textLayoutResultProvider=" + this.d + ')';
    }
}
