package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ao {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public ao(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public final ao a(long j, long j2, long j3, long j4) {
        return new ao(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ao)) {
            return false;
        }
        ao aoVar = (ao) obj;
        return sz.c(this.a, aoVar.a) && sz.c(this.b, aoVar.b) && sz.c(this.c, aoVar.c) && sz.c(this.d, aoVar.d);
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.d) + cq.c(cq.c(Long.hashCode(this.a) * 31, 31, this.b), 31, this.c);
    }
}
