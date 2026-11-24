package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class im implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ im(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
        this.i = obj5;
        this.j = obj6;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        char c;
        long j;
        float f;
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = 0;
        Object obj2 = this.j;
        Object obj3 = this.i;
        Object obj4 = this.f;
        Object obj5 = this.e;
        Object obj6 = this.c;
        Object obj7 = this.b;
        switch (i) {
            case 0:
                zw1[] zw1VarArr = (zw1[]) obj7;
                List list = (List) obj6;
                qh1 qh1Var = (qh1) obj5;
                r42 r42Var = (r42) obj4;
                r42 r42Var2 = (r42) obj3;
                jm jmVar = (jm) obj2;
                yw1 yw1Var = (yw1) obj;
                int length = zw1VarArr.length;
                int i3 = 0;
                while (i2 < length) {
                    zw1 zw1Var = zw1VarArr[i2];
                    zw1Var.getClass();
                    gm.b(yw1Var, zw1Var, (jh1) list.get(i3), qh1Var.getLayoutDirection(), r42Var.a, r42Var2.a, jmVar.a);
                    i2++;
                    i3++;
                }
                break;
            default:
                gr2 gr2Var = (gr2) obj6;
                gr2 gr2Var2 = (gr2) obj5;
                gr2 gr2Var3 = (gr2) obj4;
                gr2 gr2Var4 = (gr2) obj3;
                lp2 lp2Var = (lp2) obj2;
                rf0 rf0Var = (rf0) obj;
                rf0Var.getClass();
                float fFloatValue = ((Number) ((gr2) obj7).getValue()).floatValue();
                if (fFloatValue >= 0.005f) {
                    float fFloatValue2 = ((Number) gr2Var.getValue()).floatValue();
                    char c2 = ' ';
                    float fMin = Math.min(Float.intBitsToFloat((int) (rf0Var.c() >> 32)), Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)));
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rf0Var.c() >> 32)) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)) / 2.0f)) & 4294967295L);
                    float fFloatValue3 = ((((Number) gr2Var2.getValue()).floatValue() * 0.35f) + 0.65f) * fFloatValue;
                    float fB = ky3.b(0.0022f * fMin, 0.7f, 1.5f);
                    long j2 = ((sz) gr2Var3.getValue()).a;
                    long j3 = ((sz) gr2Var4.getValue()).a;
                    while (i2 < 28) {
                        float[] fArr = lp2Var.c;
                        float[] fArr2 = lp2Var.b;
                        float f2 = ((fArr[i2] * fFloatValue2) + fArr2[i2]) % 1.0f;
                        float fSin = (float) Math.sin(f2 * 3.1415927f);
                        float f3 = fSin * fSin * fFloatValue3 * lp2Var.e[i2];
                        if (f3 >= 0.015f) {
                            float fSin2 = (((float) Math.sin((fArr2[i2] * 6.2831855f) + (0.31f * fFloatValue2))) * 0.025f) + lp2Var.a[i2];
                            float f4 = (((0.28f * fFloatValue3) + 0.72f) * lp2Var.d[i2] * f2) + 0.412f;
                            float f5 = f4 - (0.024f * fSin);
                            float f6 = f5 >= 0.412f ? f5 : 0.412f;
                            int i4 = (int) (jFloatToRawIntBits >> c2);
                            c = c2;
                            rf0 rf0Var2 = rf0Var;
                            double d = fSin2;
                            float f7 = f6;
                            int i5 = (int) (jFloatToRawIntBits & 4294967295L);
                            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(((((float) Math.cos(d)) * f7) * fMin) + Float.intBitsToFloat(i4))) << c) | (((long) Float.floatToRawIntBits((((float) Math.sin(d)) * f7 * fMin) + Float.intBitsToFloat(i5))) & 4294967295L);
                            int i6 = 1;
                            while (i6 < 5) {
                                float f8 = i6 / 4.0f;
                                float f9 = ((f4 - f7) * f8) + f7;
                                long j4 = jFloatToRawIntBits2;
                                double dSin = (((float) Math.sin(f8 * 3.1415927f)) * lp2Var.f[i2] * fSin) + fSin2;
                                long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(((((float) Math.cos(dSin)) * f9) * fMin) + Float.intBitsToFloat(i4))) << c) | (((long) Float.floatToRawIntBits((((float) Math.sin(dSin)) * f9 * fMin) + Float.intBitsToFloat(i5))) & 4294967295L);
                                rf0Var2.f0(sz.b(((f8 * 0.45f) + 0.15f) * f3, j2), j4, jFloatToRawIntBits3, fB);
                                i6++;
                                j2 = j2;
                                jFloatToRawIntBits2 = jFloatToRawIntBits3;
                                fSin = fSin;
                                fSin2 = fSin2;
                                i4 = i4;
                            }
                            rf0Var = rf0Var2;
                            long j5 = jFloatToRawIntBits2;
                            j = j2;
                            f = fB;
                            rf0.P(rf0Var, sz.b(0.75f * f3, j3), f * 0.8f, j5, 0.0f, 120);
                        } else {
                            c = c2;
                            j = j2;
                            f = fB;
                        }
                        i2++;
                        c2 = c;
                        j2 = j;
                        fFloatValue2 = fFloatValue2;
                        fB = f;
                    }
                }
                break;
        }
        return q43Var;
    }
}
