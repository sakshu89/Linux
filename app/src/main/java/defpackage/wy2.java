package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wy2 {
    public static final wy2 c = new wy2(nc4.c(0), nc4.c(0));
    public final long a;
    public final long b;

    public wy2(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wy2)) {
            return false;
        }
        wy2 wy2Var = (wy2) obj;
        return b03.a(this.a, wy2Var.a) && b03.a(this.b, wy2Var.b);
    }

    public final int hashCode() {
        c03[] c03VarArr = b03.b;
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) b03.d(this.a)) + ", restLine=" + ((Object) b03.d(this.b)) + ')';
    }
}
