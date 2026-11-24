package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l42 {
    public static final l42 e = new l42(0.0f, 0.0f, 0.0f, 0.0f);
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public l42(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final boolean a(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat >= this.a) & (fIntBitsToFloat < this.c) & (fIntBitsToFloat2 >= this.b) & (fIntBitsToFloat2 < this.d);
    }

    public final long b() {
        float f = this.c;
        float f2 = this.a;
        float f3 = ((f - f2) / 2.0f) + f2;
        float f4 = this.d;
        float f5 = this.b;
        return (((long) Float.floatToRawIntBits(((f4 - f5) / 2.0f) + f5)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32);
    }

    public final long c() {
        float f = this.c - this.a;
        return (((long) Float.floatToRawIntBits(this.d - this.b)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public final long d() {
        return (((long) Float.floatToRawIntBits(this.a)) << 32) | (((long) Float.floatToRawIntBits(this.b)) & 4294967295L);
    }

    public final l42 e(l42 l42Var) {
        return new l42(Math.max(this.a, l42Var.a), Math.max(this.b, l42Var.b), Math.min(this.c, l42Var.c), Math.min(this.d, l42Var.d));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l42)) {
            return false;
        }
        l42 l42Var = (l42) obj;
        return Float.compare(this.a, l42Var.a) == 0 && Float.compare(this.b, l42Var.b) == 0 && Float.compare(this.c, l42Var.c) == 0 && Float.compare(this.d, l42Var.d) == 0;
    }

    public final boolean f() {
        return (this.a >= this.c) | (this.b >= this.d);
    }

    public final boolean g(l42 l42Var) {
        return (this.a < l42Var.c) & (l42Var.a < this.c) & (this.b < l42Var.d) & (l42Var.b < this.d);
    }

    public final l42 h(float f, float f2) {
        return new l42(this.a + f, this.b + f2, this.c + f, this.d + f2);
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31);
    }

    public final l42 i(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new l42(Float.intBitsToFloat(i) + this.a, Float.intBitsToFloat(i2) + this.b, Float.intBitsToFloat(i) + this.c, Float.intBitsToFloat(i2) + this.d);
    }

    public final String toString() {
        return "Rect.fromLTRB(" + do4.a(this.a) + ", " + do4.a(this.b) + ", " + do4.a(this.c) + ", " + do4.a(this.d) + ')';
    }
}
