package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class el2 implements jl2 {
    public final String a;
    public final d32 b;
    public final h52 c;

    public el2(String str, d32 d32Var, h52 h52Var) {
        this.a = str;
        this.b = d32Var;
        this.c = h52Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof el2)) {
            return false;
        }
        el2 el2Var = (el2) obj;
        return this.a.equals(el2Var.a) && this.b.equals(el2Var.b) && this.c.equals(el2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Blocked(spoken=" + this.a + ", readiness=" + this.b + ", remedy=" + this.c + ")";
    }
}
