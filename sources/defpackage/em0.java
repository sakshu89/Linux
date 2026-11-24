package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class em0 {
    public final float a;
    public final float b;

    public em0(float f, jc0 jc0Var) {
        this.a = f;
        float fB = jc0Var.b();
        float f2 = fm0.a;
        this.b = fB * 386.0878f * 160.0f * 0.84f;
    }

    public final dm0 a(float f) {
        double dB = b(f);
        double d = fm0.a;
        double d2 = d - 1.0d;
        return new dm0(f, (float) (Math.exp((d / d2) * dB) * ((double) (this.a * this.b))), (long) (Math.exp(dB / d2) * 1000.0d));
    }

    public final double b(float f) {
        float[] fArr = k9.a;
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) (this.a * this.b)));
    }
}
