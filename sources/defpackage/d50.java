package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d50 {
    public final int a;
    public final long b;
    public final e50 c;
    public final py0 d;

    public d50(int i, long j, e50 e50Var, py0 py0Var) {
        this.a = i;
        this.b = j;
        this.c = e50Var;
        this.d = py0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d50)) {
            return false;
        }
        d50 d50Var = (d50) obj;
        return this.a == d50Var.a && this.b == d50Var.b && this.c == d50Var.c && g31.a(this.d, d50Var.d);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + cq.c(Integer.hashCode(this.a) * 31, 31, this.b)) * 31;
        py0 py0Var = this.d;
        return iHashCode + (py0Var == null ? 0 : py0Var.hashCode());
    }

    public final String toString() {
        return "ContentCaptureEvent(id=" + this.a + ", timestamp=" + this.b + ", type=" + this.c + ", structureCompat=" + this.d + ')';
    }
}
