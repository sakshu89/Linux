package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y40 implements z40 {
    public final uw1 a;
    public final String b;

    public y40(uw1 uw1Var, String str) {
        this.a = uw1Var;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y40)) {
            return false;
        }
        y40 y40Var = (y40) obj;
        return this.a.equals(y40Var.a) && this.b.equals(y40Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Resolved(candidate=" + this.a + ", how=" + this.b + ")";
    }
}
