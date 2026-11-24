package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class j51 extends ik1 {
    public final hq0 a;
    public final hq0 b;

    public j51(hq0 hq0Var, hq0 hq0Var2) {
        this.a = hq0Var;
        this.b = hq0Var2;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        l51 l51Var = new l51();
        l51Var.x = this.a;
        l51Var.H = this.b;
        return l51Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j51)) {
            return false;
        }
        j51 j51Var = (j51) obj;
        return this.a == j51Var.a && this.b == j51Var.b;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        l51 l51Var = (l51) dk1Var;
        l51Var.x = this.a;
        l51Var.H = this.b;
    }

    public final int hashCode() {
        hq0 hq0Var = this.a;
        int iHashCode = (hq0Var != null ? hq0Var.hashCode() : 0) * 31;
        hq0 hq0Var2 = this.b;
        return iHashCode + (hq0Var2 != null ? hq0Var2.hashCode() : 0);
    }
}
