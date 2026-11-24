package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ii {
    public static final ii f = new ii(10485760, 200, 10000, 604800000, 81920);
    public final long a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public ii(long j, int i, int i2, long j2, int i3) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = j2;
        this.e = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ii) {
            ii iiVar = (ii) obj;
            if (this.a == iiVar.a && this.b == iiVar.b && this.c == iiVar.c && this.d == iiVar.d && this.e == iiVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003;
        long j2 = this.d;
        return this.e ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.a + ", loadBatchSize=" + this.b + ", criticalSectionEnterTimeoutMs=" + this.c + ", eventCleanUpAge=" + this.d + ", maxBlobByteSizePerRow=" + this.e + "}";
    }
}
