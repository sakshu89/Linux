package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cp2 implements hq0 {
    public final /* synthetic */ Bitmap H;
    public final /* synthetic */ gr2 a;
    public final /* synthetic */ ec1 b;
    public final /* synthetic */ o22 c;
    public final /* synthetic */ ar2 e;
    public final /* synthetic */ float f;
    public final /* synthetic */ float i;
    public final /* synthetic */ qq1 j;
    public final /* synthetic */ ec1 k;
    public final /* synthetic */ z72 n;
    public final /* synthetic */ ec1 s;
    public final /* synthetic */ ec1 t;
    public final /* synthetic */ Bitmap u;
    public final /* synthetic */ RectF v;
    public final /* synthetic */ Paint w;
    public final /* synthetic */ float x;

    public /* synthetic */ cp2(gr2 gr2Var, ec1 ec1Var, o22 o22Var, ar2 ar2Var, float f, float f2, qq1 qq1Var, ec1 ec1Var2, z72 z72Var, ec1 ec1Var3, ec1 ec1Var4, Bitmap bitmap, RectF rectF, Paint paint, float f3, Bitmap bitmap2) {
        this.a = gr2Var;
        this.b = ec1Var;
        this.c = o22Var;
        this.e = ar2Var;
        this.f = f;
        this.i = f2;
        this.j = qq1Var;
        this.k = ec1Var2;
        this.n = z72Var;
        this.s = ec1Var3;
        this.t = ec1Var4;
        this.u = bitmap;
        this.v = rectF;
        this.w = paint;
        this.x = f3;
        this.H = bitmap2;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        float f;
        float f2;
        kf kfVar;
        long j;
        long j2;
        qq1 qq1Var = this.j;
        int[] iArr = qq1Var.b;
        float[] fArr = (float[]) qq1Var.c;
        rf0 rf0Var = (rf0) obj;
        rf0Var.getClass();
        float fFloatValue = ((Number) this.a.getValue()).floatValue();
        rf0.W(rf0Var, this.b, 0L, 0L, 0.0f, null, 126);
        rf0.W(rf0Var, this.c, 0L, 0L, 0.0f, null, 126);
        int i = 0;
        while (true) {
            f = this.f;
            f2 = this.i;
            if (i >= 145) {
                break;
            }
            ar2 ar2Var = this.e;
            long jB = sz.b(ar2Var.d[i] * ((((float) Math.sin((ar2Var.e[i] * fFloatValue) + i)) * 0.3f) + 0.7f), dp2.a);
            float f3 = (ar2Var.c[i] * f) / 720.0f;
            float f4 = ar2Var.a[i] * f;
            rf0.P(rf0Var, jB, f3, (((long) Float.floatToRawIntBits(ar2Var.b[i] * f2)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32), 0.0f, 120);
            i++;
        }
        float f5 = 3.6f * fFloatValue;
        double d = f5;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        double d2 = 2.0f * f5;
        float fSin2 = (float) Math.sin(d2);
        float fCos2 = (float) Math.cos(d2);
        double d3 = f5 * 3.0f;
        float fSin3 = (float) Math.sin(d3);
        float fCos3 = (float) Math.cos(d3);
        int i2 = qq1Var.a;
        int i3 = 0;
        while (i3 < i2) {
            float[] fArr2 = (float[]) qq1Var.k;
            float f6 = fArr2[i3] * fCos;
            float f7 = fSin3;
            float[] fArr3 = (float[]) qq1Var.n;
            float f8 = f6 - (fArr3[i3] * fSin);
            float f9 = (((float[]) qq1Var.s)[i3] * fCos2) - (((float[]) qq1Var.t)[i3] * fSin2);
            float f10 = (((float[]) qq1Var.u)[i3] * fCos3) - (((float[]) qq1Var.v)[i3] * f7);
            int i4 = i3 * 2;
            float f11 = ((float[]) qq1Var.e)[i3];
            float f12 = 0.2f * f9;
            float[] fArr4 = (float[]) qq1Var.i;
            fArr[i4] = ((f12 + (0.8f * f8)) * fArr4[i3] * 0.16f) + f11;
            fArr[i4 + 1] = (((0.03f * f10) + (f9 * 0.13f) + (f8 * 0.84f)) * fArr4[i3]) + ((float[]) qq1Var.f)[i3];
            int iC = ky3.c(hh1.f((1.0f - (((((fArr2[i3] * fSin) + (fArr3[i3] * fCos)) * 0.5f) + 0.5f) * ((float[]) qq1Var.j)[i3])) * 255.0f), 0, 255);
            iArr[i3] = iC | (iC << 16) | (-16777216) | (iC << 8);
            i3++;
            qq1Var = qq1Var;
            fSin3 = f7;
        }
        Canvas canvasA = v6.a(rf0Var.C().m());
        Bitmap bitmap = this.u;
        RectF rectF = this.v;
        Paint paint = this.w;
        canvasA.drawBitmap(bitmap, (Rect) null, rectF, paint);
        canvasA.save();
        canvasA.clipRect(0.0f, f2, f, this.x);
        canvasA.drawBitmapMesh(this.H, 40, 32, fArr, 0, iArr, 0, paint);
        canvasA.restore();
        z72 z72Var = this.n;
        long j3 = z72Var.b;
        int i5 = (int) (j3 & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat(i5);
        rf0.W(rf0Var, this.k, 0L, (Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L), 0.0f, null, 122);
        rf0.W(rf0Var, this.s, 0L, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i5))) & 4294967295L), 0.0f, null, 122);
        float[] fArr5 = z72Var.g;
        na naVar = z72Var.f;
        float f13 = z72Var.a;
        float fSin4 = (((float) Math.sin(13.0f * fFloatValue)) * 0.04f) + (((float) Math.sin(fFloatValue * 5.0f)) * 0.1f) + 0.86f;
        kf kfVarC = rf0Var.C();
        long jR = kfVarC.r();
        kfVarC.m().m();
        try {
            ((q82) kfVarC.b).H(1.0f, 0.34f, j3);
            float f14 = f13;
            kfVar = kfVarC;
            try {
                try {
                    float[] fArr6 = fArr5;
                    j = jR;
                    try {
                        rf0.Z(rf0Var, z72Var.d, z72Var.c, z72Var.b, fSin4, 112);
                        kfVar.m().j();
                        kfVar.G(j);
                        kf kfVarC2 = rf0Var.C();
                        long jR2 = kfVarC2.r();
                        kfVarC2.m().m();
                        try {
                            ((q82) kfVarC2.b).H(0.54f, 1.0f, j3);
                            try {
                                try {
                                    j2 = jR2;
                                    try {
                                        rf0.Z(rf0Var, z72Var.e, 31.0f * f14, z72Var.b, fSin4, 112);
                                        float f15 = 5.0f;
                                        kfVarC2.m().j();
                                        kfVarC2.G(j2);
                                        double d4 = 6.0f * fFloatValue;
                                        float fSin5 = (float) Math.sin(d4);
                                        float fCos4 = (float) Math.cos(d4);
                                        int i6 = 0;
                                        while (i6 < 3) {
                                            float f16 = ((i6 / 3.0f) + (0.78f * fFloatValue)) % 1.0f;
                                            float fSin6 = (1.0f - f16) * ((float) Math.sin(3.1415927f * f16)) * 0.92f;
                                            float f17 = ((48.0f * f16) + 9.0f) * f14;
                                            Path path = naVar.a;
                                            Path path2 = naVar.a;
                                            path.rewind();
                                            float[] fArr7 = fArr6;
                                            int length = fArr7.length;
                                            int i7 = 0;
                                            while (i7 < length) {
                                                float f18 = f15;
                                                float f19 = f14;
                                                float f20 = ((((z72Var.i[i7] * fCos4) - (z72Var.j[i7] * fSin5)) * 0.065f) + 1.0f) * f17;
                                                float f21 = fCos4;
                                                int i8 = i6;
                                                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((fArr7[i7] * f20) + Float.intBitsToFloat((int) (j3 >> 32)))) << 32) | (((long) Float.floatToRawIntBits((((z72Var.h[i7] * f20) * 0.2f) + Float.intBitsToFloat(i5)) - ((1.5f * f16) * f19))) & 4294967295L);
                                                if (i7 == 0) {
                                                    path2.moveTo(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                                                } else {
                                                    naVar.d(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                                                }
                                                i7++;
                                                f15 = f18;
                                                f14 = f19;
                                                i6 = i8;
                                                fCos4 = f21;
                                            }
                                            float f22 = f14;
                                            path2.close();
                                            rf0.g0(rf0Var, naVar, z72Var.l, fSin6 * 0.24f, new ks2(f22 * f15, 0.0f, 0, 0, 30), 48);
                                            rf0.g0(rf0Var, naVar, z72Var.l, fSin6, new ks2(f22 * 1.15f, 0.0f, 0, 0, 30), 48);
                                            i6++;
                                            fCos4 = fCos4;
                                            fArr6 = fArr7;
                                            f14 = f22;
                                        }
                                        float f23 = f14;
                                        rf0Var.p0(z72Var.k, jp1.d(j3, (((long) Float.floatToRawIntBits(2.6f * f23)) & 4294967295L) | (Float.floatToRawIntBits(7.0f * f23) << 32)), (((long) Float.floatToRawIntBits(14.0f * f23)) << 32) | (((long) Float.floatToRawIntBits(5.2f * f23)) & 4294967295L), fSin4, ql0.a);
                                        rf0.W(rf0Var, this.t, 0L, 0L, 0.0f, null, 126);
                                        return q43.a;
                                    } catch (Throwable th) {
                                        th = th;
                                        cq.t(kfVarC2, j2);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    j2 = jR2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                j2 = jR2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            j2 = jR2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        kfVar = kfVar;
                        cq.t(kfVar, j);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    j = jR;
                }
            } catch (Throwable th7) {
                th = th7;
                j = jR;
                cq.t(kfVar, j);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            kfVar = kfVarC;
        }
    }
}
