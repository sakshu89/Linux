package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c32 implements d32 {
    public final String a;
    public final h52 b;

    public c32(String str, h52 h52Var) {
        this.a = str;
        this.b = h52Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c32)) {
            return false;
        }
        c32 c32Var = (c32) obj;
        return this.a.equals(c32Var.a) && g31.a(this.b, c32Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        h52 h52Var = this.b;
        return iHashCode + (h52Var == null ? 0 : h52Var.hashCode());
    }

    public final String toString() {
        return "Unavailable(reason=" + this.a + ", remedy=" + this.b + ")";
    }
}
