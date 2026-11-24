package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wg {
    public final boolean a;
    public final long b;

    public wg(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wg)) {
            return false;
        }
        wg wgVar = (wg) obj;
        return this.a == wgVar.a && this.b == wgVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Invocation(fromWake=" + this.a + ", issuedAt=" + this.b + ")";
    }
}
