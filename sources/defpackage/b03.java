package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b03 {
    public static final c03[] b = {new c03(0), new c03(4294967296L), new c03(8589934592L)};
    public static final long c = nc4.d(Float.NaN, 0);
    public final long a;

    public /* synthetic */ b03(long j) {
        this.a = j;
    }

    public static final boolean a(long j, long j2) {
        return j == j2;
    }

    public static final long b(long j) {
        return b[(int) ((j & 1095216660480L) >>> 32)].a;
    }

    public static final float c(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static String d(long j) {
        long jB = b(j);
        if (c03.a(jB, 0L)) {
            return "Unspecified";
        }
        if (c03.a(jB, 4294967296L)) {
            return c(j) + ".sp";
        }
        if (!c03.a(jB, 8589934592L)) {
            return "Invalid";
        }
        return c(j) + ".em";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b03) {
            return this.a == ((b03) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return d(this.a);
    }
}
