package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lc0 implements jc0 {
    public final float a;
    public final float b;
    public final ip0 c;

    public lc0(float f, float f2, ip0 ip0Var) {
        this.a = f;
        this.b = f2;
        this.c = ip0Var;
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        if (c03.a(b03.b(j), 4294967296L)) {
            return this.c.b(b03.c(j));
        }
        og.n("Only Sp can convert to Px");
        return 0.0f;
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lc0)) {
            return false;
        }
        lc0 lc0Var = (lc0) obj;
        return Float.compare(this.a, lc0Var.a) == 0 && Float.compare(this.b, lc0Var.b) == 0 && this.c.equals(lc0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + cq.b(Float.hashCode(this.a) * 31, this.b, 31);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.b;
    }

    public final String toString() {
        return "DensityWithConverter(density=" + this.a + ", fontScale=" + this.b + ", converter=" + this.c + ')';
    }

    @Override // defpackage.jc0
    public final long v(float f) {
        return nc4.d(this.c.a(f), 4294967296L);
    }
}
