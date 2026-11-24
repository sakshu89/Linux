package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fm1 {
    public final /* synthetic */ int a;
    public float b;
    public float c;
    public float d;
    public float e;

    public fm1() {
        this.a = 0;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
    }

    public float a() {
        return this.e;
    }

    public float b() {
        return this.c;
    }

    public float c() {
        return this.d;
    }

    public float d() {
        return this.b;
    }

    public void e(float f, float f2, float f3, float f4) {
        this.b = Math.max(f, this.b);
        this.c = Math.max(f2, this.c);
        this.d = Math.min(f3, this.d);
        this.e = Math.min(f4, this.e);
    }

    public boolean f() {
        return (this.b >= this.d) | (this.c >= this.e);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public void g() {
        float f = this.d;
        float f2 = this.c;
        float f3 = 1.0f;
        if (1.0f > f2 || 1.0f < f) {
            throw new IllegalArgumentException("Requested zoomRatio 1.0 is not within valid range [" + f + " , " + f2 + "]");
        }
        this.b = 1.0f;
        if (f2 == f) {
            f3 = 0.0f;
        } else if (1.0f != f2) {
            if (1.0f == f) {
                f3 = 0.0f;
            } else {
                float f4 = 1.0f / f;
                f3 = (1.0f - f4) / ((1.0f / f2) - f4);
            }
        }
        this.e = f3;
    }

    public void h(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        this.b += fIntBitsToFloat;
        this.c += fIntBitsToFloat2;
        this.d += fIntBitsToFloat;
        this.e += fIntBitsToFloat2;
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "MutableRect(" + do4.a(this.b) + ", " + do4.a(this.c) + ", " + do4.a(this.d) + ", " + do4.a(this.e) + ')';
            default:
                return super.toString();
        }
    }

    public fm1(float f, float f2) {
        this.a = 1;
        this.c = f;
        this.d = f2;
    }
}
