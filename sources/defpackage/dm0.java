package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dm0 {
    public final float a;
    public final float b;
    public final long c;

    public dm0(float f, float f2, long j) {
        this.a = f;
        this.b = f2;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dm0)) {
            return false;
        }
        dm0 dm0Var = (dm0) obj;
        return Float.compare(this.a, dm0Var.a) == 0 && Float.compare(this.b, dm0Var.b) == 0 && this.c == dm0Var.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + cq.b(Float.hashCode(this.a) * 31, this.b, 31);
    }

    public final String toString() {
        return "FlingInfo(initialVelocity=" + this.a + ", distance=" + this.b + ", duration=" + this.c + ')';
    }
}
