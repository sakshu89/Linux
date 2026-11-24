package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z4 implements e5 {
    public final l5 a;
    public final rv1 b;

    public z4(l5 l5Var, rv1 rv1Var) {
        this.a = l5Var;
        this.b = rv1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z4)) {
            return false;
        }
        z4 z4Var = (z4) obj;
        return this.a.equals(z4Var.a) && g31.a(this.b, z4Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        rv1 rv1Var = this.b;
        return iHashCode + (rv1Var == null ? 0 : rv1Var.hashCode());
    }

    public final String toString() {
        return "Finished(turn=" + this.a + ", pending=" + this.b + ")";
    }
}
