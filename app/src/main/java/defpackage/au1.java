package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class au1 {
    public final ia a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;

    public au1(ia iaVar, int i, int i2, int i3, int i4, float f, float f2) {
        this.a = iaVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = f;
        this.g = f2;
    }

    public final l42 a(l42 l42Var) {
        return l42Var.i((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(this.f)) & 4294967295L));
    }

    public final long b(long j, boolean z) {
        if (z) {
            long j2 = oz2.b;
            if (oz2.b(j, j2)) {
                return j2;
            }
        }
        int i = oz2.c;
        int i2 = this.b;
        return hc4.a(((int) (j >> 32)) + i2, ((int) (j & 4294967295L)) + i2);
    }

    public final l42 c(l42 l42Var) {
        float f = -this.f;
        return l42Var.i((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    public final int d(int i) {
        int i2 = this.c;
        int i3 = this.b;
        return ky3.c(i, i3, i2) - i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof au1) {
            au1 au1Var = (au1) obj;
            if (this.a == au1Var.a && this.b == au1Var.b && this.c == au1Var.c && this.d == au1Var.d && this.e == au1Var.e && Float.compare(this.f, au1Var.f) == 0 && Float.compare(this.g, au1Var.g) == 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.g) + cq.b(ky0.a(this.e, ky0.a(this.d, ky0.a(this.c, ky0.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), this.f, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo(paragraph=");
        sb.append(this.a);
        sb.append(", startIndex=");
        sb.append(this.b);
        sb.append(", endIndex=");
        sb.append(this.c);
        sb.append(", startLineIndex=");
        sb.append(this.d);
        sb.append(", endLineIndex=");
        sb.append(this.e);
        sb.append(", top=");
        sb.append(this.f);
        sb.append(", bottom=");
        return cq.m(sb, this.g, ')');
    }
}
