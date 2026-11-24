package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lp2 {
    public final float[] a;
    public final float[] b;
    public final float[] c;
    public final float[] d;
    public final float[] e;
    public final float[] f;

    public lp2() {
        float[] fArr = new float[28];
        for (int i = 0; i < 28; i++) {
            float f = i;
            fArr[i] = (((float) Math.sin(f * 2.7f)) * 0.06f) + ((6.2831855f * f) / 28.0f);
        }
        this.a = fArr;
        float[] fArr2 = new float[28];
        for (int i2 = 0; i2 < 28; i2++) {
            fArr2[i2] = (i2 * 0.618034f) % 1.0f;
        }
        this.b = fArr2;
        float[] fArr3 = new float[28];
        for (int i3 = 0; i3 < 28; i3++) {
            fArr3[i3] = ((i3 % 7) * 0.037f) + 0.42f;
        }
        this.c = fArr3;
        float[] fArr4 = new float[28];
        for (int i4 = 0; i4 < 28; i4++) {
            fArr4[i4] = ((i4 % 5) * 0.006f) + 0.05f;
        }
        this.d = fArr4;
        float[] fArr5 = new float[28];
        for (int i5 = 0; i5 < 28; i5++) {
            fArr5[i5] = ((i5 % 4) * 0.12f) + 0.55f;
        }
        this.e = fArr5;
        float[] fArr6 = new float[28];
        for (int i6 = 0; i6 < 28; i6++) {
            fArr6[i6] = ((float) Math.sin(i6 * 1.9f)) * 0.055f;
        }
        this.f = fArr6;
    }
}
