package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qn2 {
    public final long a;
    public final long b;
    public final long c;

    public qn2(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qn2)) {
            return false;
        }
        qn2 qn2Var = (qn2) obj;
        return sz.c(this.a, qn2Var.a) && sz.c(this.b, qn2Var.b) && sz.c(this.c, qn2Var.c);
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.c) + cq.c(Long.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        String strI = sz.i(this.a);
        String strI2 = sz.i(this.b);
        return cq.n(cq.q("SonicPalette(core=", strI, ", halo=", strI2, ", accent="), sz.i(this.c), ")");
    }
}
