package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rd1 {
    public final long a;
    public final long b;

    public rd1(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rd1)) {
            return false;
        }
        rd1 rd1Var = (rd1) obj;
        return this.a == rd1Var.a && this.b == rd1Var.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "AudibleReply(sequence=" + this.a + ", firstFrame=" + this.b + ")";
    }
}
