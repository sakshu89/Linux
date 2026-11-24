package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l60 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public l60(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l60)) {
            return false;
        }
        l60 l60Var = (l60) obj;
        return Float.compare(this.a, l60Var.a) == 0 && Float.compare(this.b, l60Var.b) == 0 && Float.compare(this.c, l60Var.c) == 0 && Float.compare(this.d, l60Var.d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31);
    }

    public final String toString() {
        return "CoreMotion(swell=" + this.a + ", churn=" + this.b + ", spin=" + this.c + ", glow=" + this.d + ")";
    }
}
