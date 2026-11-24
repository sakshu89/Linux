package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ev1 extends iv1 {
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public ev1(float f, float f2, float f3, float f4) {
        super(2);
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ev1)) {
            return false;
        }
        ev1 ev1Var = (ev1) obj;
        return Float.compare(this.c, ev1Var.c) == 0 && Float.compare(this.d, ev1Var.d) == 0 && Float.compare(this.e, ev1Var.e) == 0 && Float.compare(this.f, ev1Var.f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f) + cq.b(cq.b(Float.hashCode(this.c) * 31, this.d, 31), this.e, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RelativeReflectiveCurveTo(dx1=");
        sb.append(this.c);
        sb.append(", dy1=");
        sb.append(this.d);
        sb.append(", dx2=");
        sb.append(this.e);
        sb.append(", dy2=");
        return cq.m(sb, this.f, ')');
    }
}
