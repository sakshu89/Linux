package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class iq1 extends ik1 {
    public final hq0 a;

    public iq1(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        jq1 jq1Var = new jq1();
        jq1Var.x = this.a;
        jq1Var.H = -9223372034707292160L;
        return jq1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof iq1) {
            return this.a == ((iq1) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        jq1 jq1Var = (jq1) dk1Var;
        jq1Var.x = this.a;
        jq1Var.H = -9223372034707292160L;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
