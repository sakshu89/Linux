package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {
    public final String a;
    public final h52 b;

    public g(String str, h52 h52Var) {
        this.a = str;
        this.b = h52Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.a) && g31.a(this.b, gVar.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        h52 h52Var = this.b;
        return iHashCode + (h52Var == null ? 0 : h52Var.hashCode());
    }

    public final String toString() {
        return "Unavailable(spoken=" + this.a + ", remedy=" + this.b + ")";
    }
}
