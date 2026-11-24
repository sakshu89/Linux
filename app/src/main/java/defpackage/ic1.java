package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ic1 extends kc1 {
    public final String a;
    public final jz2 b;

    public ic1(String str, jz2 jz2Var) {
        this.a = str;
        this.b = jz2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ic1)) {
            return false;
        }
        ic1 ic1Var = (ic1) obj;
        return this.a.equals(ic1Var.a) && g31.a(this.b, ic1Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        jz2 jz2Var = this.b;
        return (iHashCode + (jz2Var != null ? jz2Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return ky0.n(new StringBuilder("LinkAnnotation.Clickable(tag="), this.a, ')');
    }
}
