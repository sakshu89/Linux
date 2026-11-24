package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p43 implements na3 {
    public final na3 a;
    public final na3 b;

    public p43(na3 na3Var, na3 na3Var2) {
        this.a = na3Var;
        this.b = na3Var2;
    }

    @Override // defpackage.na3
    public final int a(qh1 qh1Var, z61 z61Var) {
        return Math.max(this.a.a(qh1Var, z61Var), this.b.a(qh1Var, z61Var));
    }

    @Override // defpackage.na3
    public final int b(qh1 qh1Var) {
        return Math.max(this.a.b(qh1Var), this.b.b(qh1Var));
    }

    @Override // defpackage.na3
    public final int c(qh1 qh1Var, z61 z61Var) {
        return Math.max(this.a.c(qh1Var, z61Var), this.b.c(qh1Var, z61Var));
    }

    @Override // defpackage.na3
    public final int d(qh1 qh1Var) {
        return Math.max(this.a.d(qh1Var), this.b.d(qh1Var));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p43)) {
            return false;
        }
        p43 p43Var = (p43) obj;
        return g31.a(p43Var.a, this.a) && g31.a(p43Var.b, this.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public final String toString() {
        return "(" + this.a + " ∪ " + this.b + ')';
    }
}
