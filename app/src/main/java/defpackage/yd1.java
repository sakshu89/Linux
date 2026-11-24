package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yd1 {
    public final long a;
    public long b;

    public yd1(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yd1)) {
            return false;
        }
        yd1 yd1Var = (yd1) obj;
        return this.a == yd1Var.a && this.b == yd1Var.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Segment(sequence=" + this.a + ", frames=" + this.b + ")";
    }
}
