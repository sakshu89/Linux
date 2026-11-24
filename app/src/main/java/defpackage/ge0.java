package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ge0 {
    public final long a;

    public final boolean equals(Object obj) {
        if (obj instanceof ge0) {
            return this.a == ((ge0) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        long j = this.a;
        if (j == 9205357640488583168L) {
            return "DpSize.Unspecified";
        }
        return ((Object) de0.c(Float.intBitsToFloat((int) (j >> 32)))) + " x " + ((Object) de0.c(Float.intBitsToFloat((int) (4294967295L & j))));
    }
}
