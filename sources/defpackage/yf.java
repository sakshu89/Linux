package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yf {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public float h;
    public float i;
    public final float[] j;
    public final float k;
    public final float l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final float q;
    public final float r;

    public yf(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        int i2;
        float[] fArr;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        int i3 = 1;
        boolean z2 = i == 1 || (i == 4 ? f8 > 0.0f : !(i != 5 || f8 >= 0.0f));
        float f9 = z2 ? -1.0f : 1.0f;
        this.m = f9;
        float f10 = 1.0f / (f2 - f);
        this.k = f10;
        float[] fArr2 = new float[101];
        this.j = fArr2;
        boolean z3 = i == 3;
        if (z3 || Math.abs(f7) < 0.001f || Math.abs(f8) < 0.001f) {
            float fHypot = (float) Math.hypot(f8, f7);
            this.g = fHypot;
            this.l = fHypot * f10;
            this.q = f7 * f10;
            this.r = f8 * f10;
            this.n = Float.NaN;
            this.o = Float.NaN;
            z = true;
        } else {
            this.n = f7 * f9;
            this.o = f8 * (-f9);
            this.q = z2 ? f5 : f3;
            this.r = z2 ? f4 : f6;
            float f11 = f5 - f3;
            float f12 = f4 - f6;
            float f13 = f12;
            float fHypot2 = 0.0f;
            float f14 = 0.0f;
            int i4 = 1;
            while (true) {
                double radians = (float) Math.toRadians((((double) i4) * 90.0d) / 90.0d);
                i2 = i3;
                float fSin = ((float) Math.sin(radians)) * f11;
                float fCos = ((float) Math.cos(radians)) * f12;
                fHypot2 += (float) Math.hypot(fSin - f14, fCos - f13);
                fArr = g31.a;
                fArr[i4] = fHypot2;
                if (i4 == 90) {
                    break;
                }
                i4++;
                f14 = fSin;
                f13 = fCos;
                i3 = i2;
            }
            this.g = fHypot2;
            int i5 = i2;
            while (true) {
                fArr[i5] = fArr[i5] / fHypot2;
                if (i5 == 90) {
                    break;
                } else {
                    i5++;
                }
            }
            int length = fArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                float f15 = i6 / 100.0f;
                int iBinarySearch = Arrays.binarySearch(fArr, 0, 91, f15);
                if (iBinarySearch >= 0) {
                    fArr2[i6] = iBinarySearch / 90.0f;
                } else if (iBinarySearch == -1) {
                    fArr2[i6] = 0.0f;
                } else {
                    int i7 = -iBinarySearch;
                    int i8 = i7 - 2;
                    float f16 = i8;
                    float f17 = fArr[i8];
                    fArr2[i6] = (((f15 - f17) / (fArr[i7 - i2] - f17)) + f16) / 90.0f;
                }
            }
            this.l = this.g * this.k;
            z = z3;
        }
        this.p = z;
    }

    public final float a() {
        float f = this.n * this.i;
        return f * this.m * (this.l / ((float) Math.hypot(f, (-this.o) * this.h)));
    }

    public final float b() {
        float f = this.n * this.i;
        float f2 = (-this.o) * this.h;
        return f2 * this.m * (this.l / ((float) Math.hypot(f, f2)));
    }

    public final void c(float f) {
        float f2 = (this.m == -1.0f ? this.b - f : f - this.a) * this.k;
        float f3 = 0.0f;
        if (f2 > 0.0f) {
            f3 = 1.0f;
            if (f2 < 1.0f) {
                float f4 = f2 * 100.0f;
                int i = (int) f4;
                float[] fArr = this.j;
                float f5 = fArr[i];
                f3 = ((fArr[i + 1] - f5) * (f4 - i)) + f5;
            }
        }
        double d = f3 * 1.5707964f;
        this.h = (float) Math.sin(d);
        this.i = (float) Math.cos(d);
    }
}
