package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z72 {
    public final float a;
    public final long b;
    public final float c;
    public final o22 d;
    public final o22 e;
    public final na f;
    public final float[] g;
    public final float[] h;
    public final float[] i;
    public final float[] j;
    public final long k;
    public final long l;

    public z72(float f, float f2) {
        float f3 = f / 720.0f;
        this.a = f3;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2 - (23.0f * f3))) & 4294967295L) | (Float.floatToRawIntBits(f * 0.5f) << 32);
        this.b = jFloatToRawIntBits;
        float f4 = 62.0f * f3;
        this.c = f4;
        Float fValueOf = Float.valueOf(0.0f);
        wt1 wt1Var = new wt1(fValueOf, new sz(ki4.c(4292738559L)));
        wt1 wt1Var2 = new wt1(Float.valueOf(0.08f), new sz(ki4.c(4238538239L)));
        wt1 wt1Var3 = new wt1(Float.valueOf(0.24f), new sz(ki4.c(3306871039L)));
        Float fValueOf2 = Float.valueOf(0.55f);
        wt1 wt1Var4 = new wt1(fValueOf2, new sz(ki4.b(1493938175)));
        Float fValueOf3 = Float.valueOf(1.0f);
        long j = sz.f;
        this.d = y74.x(new wt1[]{wt1Var, wt1Var2, wt1Var3, wt1Var4, new wt1(fValueOf3, new sz(j))}, jFloatToRawIntBits, f4);
        this.e = y74.x(new wt1[]{new wt1(fValueOf, new sz(ki4.c(3939433471L))), new wt1(Float.valueOf(0.22f), new sz(ki4.c(2972902399L))), new wt1(fValueOf2, new sz(ki4.b(1057667071))), new wt1(fValueOf3, new sz(j))}, jFloatToRawIntBits, f3 * 31.0f);
        this.f = pa.a();
        float[] fArr = new float[41];
        for (int i = 0; i < 41; i++) {
            fArr[i] = (float) Math.cos(((i * 2.0f) * 3.1415927f) / 40.0f);
        }
        this.g = fArr;
        float[] fArr2 = new float[41];
        for (int i2 = 0; i2 < 41; i2++) {
            fArr2[i2] = (float) Math.sin(((i2 * 2.0f) * 3.1415927f) / 40.0f);
        }
        this.h = fArr2;
        float[] fArr3 = new float[41];
        for (int i3 = 0; i3 < 41; i3++) {
            fArr3[i3] = (float) Math.sin(((i3 * 8.0f) * 3.1415927f) / 40.0f);
        }
        this.i = fArr3;
        float[] fArr4 = new float[41];
        for (int i4 = 0; i4 < 41; i4++) {
            fArr4[i4] = (float) Math.cos(((i4 * 8.0f) * 3.1415927f) / 40.0f);
        }
        this.j = fArr4;
        this.k = ki4.c(4294049535L);
        this.l = ki4.c(4284869119L);
    }
}
