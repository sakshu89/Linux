package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pu1 extends iv1 {
    public final float c;
    public final float d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final float h;
    public final float i;

    public pu1(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        super(3);
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = z;
        this.g = z2;
        this.h = f4;
        this.i = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pu1)) {
            return false;
        }
        pu1 pu1Var = (pu1) obj;
        return Float.compare(this.c, pu1Var.c) == 0 && Float.compare(this.d, pu1Var.d) == 0 && Float.compare(this.e, pu1Var.e) == 0 && this.f == pu1Var.f && this.g == pu1Var.g && Float.compare(this.h, pu1Var.h) == 0 && Float.compare(this.i, pu1Var.i) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.i) + cq.b(ky0.e(ky0.e(cq.b(cq.b(Float.hashCode(this.c) * 31, this.d, 31), this.e, 31), 31, this.f), 31, this.g), this.h, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ArcTo(horizontalEllipseRadius=");
        sb.append(this.c);
        sb.append(", verticalEllipseRadius=");
        sb.append(this.d);
        sb.append(", theta=");
        sb.append(this.e);
        sb.append(", isMoreThanHalf=");
        sb.append(this.f);
        sb.append(", isPositiveArc=");
        sb.append(this.g);
        sb.append(", arcStartX=");
        sb.append(this.h);
        sb.append(", arcStartY=");
        return cq.m(sb, this.i, ')');
    }
}
