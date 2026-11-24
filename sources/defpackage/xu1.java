package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xu1 extends iv1 {
    public final float c;
    public final float d;

    public xu1(float f, float f2) {
        super(1);
        this.c = f;
        this.d = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xu1)) {
            return false;
        }
        xu1 xu1Var = (xu1) obj;
        return Float.compare(this.c, xu1Var.c) == 0 && Float.compare(this.d, xu1Var.d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + (Float.hashCode(this.c) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReflectiveQuadTo(x=");
        sb.append(this.c);
        sb.append(", y=");
        return cq.m(sb, this.d, ')');
    }
}
