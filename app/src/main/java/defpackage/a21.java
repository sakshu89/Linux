package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a21 {
    public final long a;

    public static long a(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a21) {
            return this.a == ((a21) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        long j = this.a;
        sb.append((int) (j >> 32));
        sb.append(", ");
        return ky0.m(sb, (int) (j & 4294967295L), ')');
    }
}
