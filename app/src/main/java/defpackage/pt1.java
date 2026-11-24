package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class pt1 extends ik1 {
    public final qt1 a;

    public pt1(qt1 qt1Var) {
        this.a = qt1Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        rt1 rt1Var = new rt1();
        rt1Var.x = this.a;
        return rt1Var;
    }

    public final boolean equals(Object obj) {
        pt1 pt1Var = obj instanceof pt1 ? (pt1) obj : null;
        if (pt1Var == null) {
            return false;
        }
        return g31.a(this.a, pt1Var.a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((rt1) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
