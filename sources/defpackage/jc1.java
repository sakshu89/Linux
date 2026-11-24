package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jc1 extends kc1 {
    public final String a;
    public final jz2 b;

    public jc1(String str, jz2 jz2Var) {
        this.a = str;
        this.b = jz2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jc1)) {
            return false;
        }
        jc1 jc1Var = (jc1) obj;
        return this.a.equals(jc1Var.a) && g31.a(this.b, jc1Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        jz2 jz2Var = this.b;
        return (iHashCode + (jz2Var != null ? jz2Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return ky0.n(new StringBuilder("LinkAnnotation.Url(url="), this.a, ')');
    }
}
