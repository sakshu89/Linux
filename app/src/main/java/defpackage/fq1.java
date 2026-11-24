package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class fq1 extends ik1 {
    public final hq0 a;

    public fq1(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        gq1 gq1Var = new gq1();
        gq1Var.x = this.a;
        return gq1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fq1) {
            return this.a == ((fq1) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((gq1) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
