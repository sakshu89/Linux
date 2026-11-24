package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class br2 implements pd {
    public final pd a;
    public final long b;

    public br2(yl0 yl0Var, long j) {
        this.a = yl0Var;
        this.b = j;
    }

    @Override // defpackage.pd
    public final s63 a(g33 g33Var) {
        return new cr2(this.a.a(g33Var), this.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof br2)) {
            return false;
        }
        br2 br2Var = (br2) obj;
        return br2Var.b == this.b && g31.a(br2Var.a, this.a);
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }
}
