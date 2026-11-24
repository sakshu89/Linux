package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vf2 {
    public final pv0 a;
    public final long b;
    public final uf2 c;
    public final boolean d;

    public vf2(pv0 pv0Var, long j, uf2 uf2Var, boolean z) {
        this.a = pv0Var;
        this.b = j;
        this.c = uf2Var;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vf2)) {
            return false;
        }
        vf2 vf2Var = (vf2) obj;
        return this.a == vf2Var.a && jp1.b(this.b, vf2Var.b) && this.c == vf2Var.c && this.d == vf2Var.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ((this.c.hashCode() + cq.c(this.a.hashCode() * 31, 31, this.b)) * 31);
    }

    public final String toString() {
        return "SelectionHandleInfo(handle=" + this.a + ", position=" + ((Object) jp1.g(this.b)) + ", anchor=" + this.c + ", visible=" + this.d + ')';
    }
}
