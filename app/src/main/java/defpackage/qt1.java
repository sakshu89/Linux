package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qt1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public qt1(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        if (!((f >= 0.0f) & (f2 >= 0.0f) & (f3 >= 0.0f)) || !(f4 >= 0.0f)) {
            x01.a("Padding must be non-negative");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof qt1)) {
            return false;
        }
        qt1 qt1Var = (qt1) obj;
        return de0.b(this.a, qt1Var.a) && de0.b(this.b, qt1Var.b) && de0.b(this.c, qt1Var.c) && de0.b(this.d, qt1Var.d);
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31);
    }

    public final String toString() {
        return "PaddingValues(start=" + ((Object) de0.c(this.a)) + ", top=" + ((Object) de0.c(this.b)) + ", end=" + ((Object) de0.c(this.c)) + ", bottom=" + ((Object) de0.c(this.d)) + ')';
    }
}
