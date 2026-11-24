package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s82 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    static {
        ez3.a(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public s82(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s82)) {
            return false;
        }
        s82 s82Var = (s82) obj;
        return Float.compare(this.a, s82Var.a) == 0 && Float.compare(this.b, s82Var.b) == 0 && Float.compare(this.c, s82Var.c) == 0 && Float.compare(this.d, s82Var.d) == 0 && il4.a(this.e, s82Var.e) && il4.a(this.f, s82Var.f) && il4.a(this.g, s82Var.g) && il4.a(this.h, s82Var.h);
    }

    public final int hashCode() {
        return Long.hashCode(this.h) + cq.c(cq.c(cq.c(cq.b(cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31), this.d, 31), 31, this.e), 31, this.f), 31, this.g);
    }

    public final String toString() {
        String str = do4.a(this.a) + ", " + do4.a(this.b) + ", " + do4.a(this.c) + ", " + do4.a(this.d);
        long j = this.e;
        long j2 = this.f;
        boolean zA = il4.a(j, j2);
        long j3 = this.g;
        long j4 = this.h;
        if (!zA || !il4.a(j2, j3) || !il4.a(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) il4.b(j)) + ", topRight=" + ((Object) il4.b(j2)) + ", bottomRight=" + ((Object) il4.b(j3)) + ", bottomLeft=" + ((Object) il4.b(j4)) + ')';
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            return "RoundRect(rect=" + str + ", radius=" + do4.a(Float.intBitsToFloat(i)) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + do4.a(Float.intBitsToFloat(i)) + ", y=" + do4.a(Float.intBitsToFloat(i2)) + ')';
    }
}
