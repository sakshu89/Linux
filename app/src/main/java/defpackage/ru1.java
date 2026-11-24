package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ru1 extends iv1 {
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;

    public ru1(float f, float f2, float f3, float f4, float f5, float f6) {
        super(2);
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.g = f5;
        this.h = f6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ru1)) {
            return false;
        }
        ru1 ru1Var = (ru1) obj;
        return Float.compare(this.c, ru1Var.c) == 0 && Float.compare(this.d, ru1Var.d) == 0 && Float.compare(this.e, ru1Var.e) == 0 && Float.compare(this.f, ru1Var.f) == 0 && Float.compare(this.g, ru1Var.g) == 0 && Float.compare(this.h, ru1Var.h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.h) + cq.b(cq.b(cq.b(cq.b(Float.hashCode(this.c) * 31, this.d, 31), this.e, 31), this.f, 31), this.g, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CurveTo(x1=");
        sb.append(this.c);
        sb.append(", y1=");
        sb.append(this.d);
        sb.append(", x2=");
        sb.append(this.e);
        sb.append(", y2=");
        sb.append(this.f);
        sb.append(", x3=");
        sb.append(this.g);
        sb.append(", y3=");
        return cq.m(sb, this.h, ')');
    }
}
