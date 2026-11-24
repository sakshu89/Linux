package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gl2 implements jl2 {
    public final String a;
    public final yx b;

    public gl2(String str, yx yxVar) {
        this.a = str;
        this.b = yxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gl2)) {
            return false;
        }
        gl2 gl2Var = (gl2) obj;
        return this.a.equals(gl2Var.a) && this.b.equals(gl2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "NeedsClarification(spoken=" + this.a + ", clarification=" + this.b + ")";
    }
}
