package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fy1 {
    public final float[] a = new float[380];
    public final float[] b = new float[380];
    public final float[] c = new float[380];
    public final float[] d = new float[380];
    public final float[] e = new float[380];
    public final float[] f = new float[380];
    public final float[] g = new float[380];
    public final float[] h = new float[380];

    public fy1() {
        float fSqrt = (3.0f - ((float) Math.sqrt(5.0d))) * 3.1415927f;
        for (int i = 0; i < 380; i++) {
            float f = i;
            float f2 = 1.0f - (((0.5f + f) * 2.0f) / 380.0f);
            float f3 = 1.0f - (f2 * f2);
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            float fSqrt2 = (float) Math.sqrt(f3);
            double d = f * fSqrt;
            this.a[i] = ((float) Math.cos(d)) * fSqrt2;
            this.b[i] = f2;
            this.c[i] = ((float) Math.sin(d)) * fSqrt2;
        }
    }
}
