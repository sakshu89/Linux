package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xi {
    public final long a;
    public final pj b;
    public final hi c;

    public xi(long j, pj pjVar, hi hiVar) {
        this.a = j;
        this.b = pjVar;
        this.c = hiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xi)) {
            return false;
        }
        xi xiVar = (xi) obj;
        return this.a == xiVar.a && this.b.equals(xiVar.b) && this.c.equals(xiVar.c);
    }

    public final int hashCode() {
        long j = this.a;
        return this.c.hashCode() ^ ((((((int) ((j >>> 32) ^ j)) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}
