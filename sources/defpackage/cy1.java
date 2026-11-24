package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cy1 {
    public final nx1 a;

    public cy1(nx1 nx1Var) {
        this.a = nx1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cy1) {
            return g31.a(this.a, ((cy1) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        nx1 nx1Var = this.a;
        if (nx1Var != null) {
            return nx1Var.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PlatformTextStyle(spanStyle=null, paragraphSyle=" + this.a + ')';
    }
}
