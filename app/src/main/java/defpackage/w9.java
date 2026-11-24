package defpackage;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w9 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;

    public /* synthetic */ w9(k80 k80Var, mp1 mp1Var, ty2 ty2Var, ua1 ua1Var, cn2 cn2Var) {
        this.a = 4;
        this.c = k80Var;
        this.e = mp1Var;
        this.b = ty2Var;
        this.f = ua1Var;
        this.i = cn2Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        Object value;
        ee1 ee1Var;
        String str;
        float f;
        rn2 rn2Var;
        long j = 4294967295L;
        int i = 0;
        switch (this.a) {
            case 0:
                ty2 ty2Var = (ty2) this.b;
                ba baVar = (ba) this.c;
                kz0 kz0Var = (kz0) this.e;
                e2 e2Var = (e2) this.f;
                hq0 hq0Var = (hq0) this.i;
                wa1 wa1Var = (wa1) obj;
                pa1 pa1Var = baVar.a;
                wa1Var.h = ty2Var;
                wa1Var.i = kz0Var;
                wa1Var.c = e2Var;
                wa1Var.d = hq0Var;
                wa1Var.e = pa1Var != null ? pa1Var.H : null;
                wa1Var.f = pa1Var != null ? pa1Var.X : null;
                wa1Var.g = pa1Var != null ? (w73) ij4.a(pa1Var, l30.s) : null;
                return q43.a;
            case 1:
                mt0 mt0Var = (mt0) this.b;
                zc1 zc1Var = (zc1) this.c;
                s70 s70Var = (s70) this.e;
                x00 x00Var = (x00) this.f;
                hd1 hd1Var = (hd1) this.i;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                jr2 jr2Var = mt0Var.k;
                do {
                    value = jr2Var.getValue();
                    ee1Var = (ee1) value;
                } while (!jr2Var.h(value, ee1.a(ee1Var, zBooleanValue, null, null, (zBooleanValue && (str = ee1Var.e) != null && cs2.n(str, "interrupted", false)) ? null : ee1Var.e, 45)));
                if (!zBooleanValue) {
                    mt0Var.j.c(zc1Var);
                    mt0Var.H = false;
                    uf4.b(s70Var, null, new ws0(mt0Var, x00Var, hd1Var, s70Var, null, 0), 3);
                }
                return q43.a;
            case 2:
                sc0 sc0Var = (sc0) this.b;
                t42 t42Var = (t42) this.c;
                q42 q42Var = (q42) this.e;
                he2 he2Var = (he2) this.f;
                o42 o42Var = (o42) this.i;
                float fFloatValue = ((Float) obj).floatValue();
                vk1 vk1VarG = sc0.g((un) sc0Var.f);
                if (vk1VarG != null) {
                    sc0Var.h(vk1VarG);
                    vk1 vk1VarA = ((vk1) t42Var.a).a(vk1VarG);
                    t42Var.a = vk1VarA;
                    float fI = he2Var.i(he2Var.e(vk1VarA.a));
                    q42Var.a = fI;
                    o42Var.a = !pr4.a(fI - fFloatValue);
                }
                return Boolean.valueOf(vk1VarG != null);
            case 3:
                Bitmap bitmap = (Bitmap) this.b;
                gr2 gr2Var = (gr2) this.c;
                ar2 ar2Var = (ar2) this.e;
                Paint paint = (Paint) this.f;
                Bitmap bitmap2 = (Bitmap) this.i;
                so soVar = (so) obj;
                soVar.getClass();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (soVar.a.c() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (soVar.a.c() & 4294967295L));
                float fB = ky3.b(0.6f, 0.45f, 0.72f) * fIntBitsToFloat2;
                qq1 qq1Var = new qq1(fIntBitsToFloat, fB, fIntBitsToFloat2);
                z72 z72Var = new z72(fIntBitsToFloat, fB);
                float height = (bitmap.getHeight() * fIntBitsToFloat) / bitmap.getWidth();
                Float fValueOf = Float.valueOf(0.0f);
                Float fValueOf2 = Float.valueOf(1.0f);
                RectF rectF = new RectF(0.0f, fB - height, fIntBitsToFloat, fB + 1.0f);
                ec1 ec1VarY = y74.y(new wt1[]{new wt1(fValueOf, new sz(ki4.c(4278256394L))), new wt1(Float.valueOf(0.3f), new sz(ki4.c(4278323483L))), new wt1(Float.valueOf(0.6f), new sz(ki4.c(4278201177L))), new wt1(Float.valueOf(0.68f), new sz(ki4.c(4278324255L))), new wt1(fValueOf2, new sz(ki4.c(4278256394L)))}, 0.0f, 14);
                wt1 wt1Var = new wt1(fValueOf, new sz(ki4.c(3662405887L)));
                wt1 wt1Var2 = new wt1(Float.valueOf(0.12f), new sz(ki4.c(3257183984L)));
                wt1 wt1Var3 = new wt1(Float.valueOf(0.38f), new sz(ki4.c(2315807446L)));
                wt1 wt1Var4 = new wt1(Float.valueOf(0.7f), new sz(ki4.b(687879811)));
                long j2 = sz.f;
                return soVar.a(new h6(6, new cp2(gr2Var, ec1VarY, y74.x(new wt1[]{wt1Var, wt1Var2, wt1Var3, wt1Var4, new wt1(fValueOf2, new sz(j2))}, (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.5f)) << 32) | (((long) Float.floatToRawIntBits(fB)) & 4294967295L), 0.92f * fIntBitsToFloat), ar2Var, fIntBitsToFloat, fB, qq1Var, y74.v((wt1[]) Arrays.copyOf(new wt1[]{new wt1(fValueOf, new sz(j2)), new wt1(Float.valueOf(0.42f), new sz(ki4.b(67275519))), new wt1(Float.valueOf(0.49f), new sz(ki4.c(2315688447L))), new wt1(Float.valueOf(0.5f), new sz(ki4.c(3582062335L))), new wt1(Float.valueOf(0.51f), new sz(ki4.c(2315688447L))), new wt1(Float.valueOf(0.58f), new sz(ki4.b(67275519))), new wt1(fValueOf2, new sz(j2))}, 7), (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.38f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L), (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.62f)) << 32)), z72Var, y74.y(new wt1[]{new wt1(fValueOf, new sz(ki4.c(4278256394L))), new wt1(Float.valueOf(0.14f), new sz(ki4.c(2936079114L))), new wt1(Float.valueOf(0.36f), new sz(j2)), new wt1(fValueOf2, new sz(j2))}, fB, 10), y74.y(new wt1[]{new wt1(fValueOf, new sz(j2)), new wt1(Float.valueOf(0.74f), new sz(j2)), new wt1(Float.valueOf(0.91f), new sz(ki4.b(2046886666))), new wt1(fValueOf2, new sz(ki4.c(4278256394L)))}, 0.0f, 14), bitmap, rectF, paint, fIntBitsToFloat2, bitmap2)));
            case 4:
                k80 k80Var = (k80) this.c;
                mp1 mp1Var = (mp1) this.e;
                ty2 ty2Var2 = (ty2) this.b;
                ua1 ua1Var = (ua1) this.f;
                cn2 cn2Var = (cn2) this.i;
                p71 p71Var = (p71) obj;
                p71Var.a();
                ew ewVar = p71Var.a;
                float fG = k80Var.c.g();
                if (fG != 0.0f) {
                    long j3 = ty2Var2.b;
                    int i2 = oz2.c;
                    int iL = mp1Var.l((int) (j3 >> 32));
                    hz2 hz2VarD = ua1Var.d();
                    l42 l42VarC = hz2VarD != null ? hz2VarD.a.c(iL) : new l42(0.0f, 0.0f, 0.0f, 0.0f);
                    float fFloor = (float) Math.floor(p71Var.x(2.0f));
                    if (fFloor < 1.0f) {
                        fFloor = 1.0f;
                    }
                    float f2 = fFloor / 2.0f;
                    float f3 = l42VarC.a + f2;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (ewVar.c() >> 32)) - f2;
                    if (f3 > fIntBitsToFloat3) {
                        f3 = fIntBitsToFloat3;
                    }
                    if (f3 >= f2) {
                        f2 = f3;
                    }
                    float fFloor2 = ((int) fFloor) % 2 == 1 ? ((float) Math.floor(f2)) + 0.5f : (float) Math.rint(f2);
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(l42VarC.b)) & 4294967295L);
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(l42VarC.d)) & 4294967295L);
                    cw cwVar = ewVar.a.c;
                    fa faVarA = ewVar.e;
                    if (faVarA == null) {
                        faVarA = ld4.a();
                        faVarA.l(1);
                        ewVar.e = faVarA;
                    }
                    Paint paint2 = faVarA.a;
                    cn2Var.a(fG, ewVar.c(), faVarA);
                    if (!g31.a(faVarA.d, null)) {
                        faVarA.f(null);
                    }
                    if (faVarA.b != 3) {
                        faVarA.d(3);
                    }
                    if (paint2.getStrokeWidth() != fFloor) {
                        faVarA.k(fFloor);
                    }
                    if (paint2.getStrokeMiter() != 4.0f) {
                        paint2.setStrokeMiter(4.0f);
                    }
                    if (faVarA.a() != 0) {
                        faVarA.i(0);
                    }
                    if (faVarA.b() != 0) {
                        faVarA.j(0);
                    }
                    if (!paint2.isFilterBitmap()) {
                        faVarA.g(1);
                    }
                    cwVar.n(jFloatToRawIntBits, jFloatToRawIntBits2, faVarA);
                }
                return q43.a;
            default:
                rn2 rn2Var2 = rn2.c;
                gr2 gr2Var2 = (gr2) this.b;
                rn2 rn2Var3 = (rn2) this.c;
                gr2 gr2Var3 = (gr2) this.e;
                gr2 gr2Var4 = (gr2) this.f;
                gr2 gr2Var5 = (gr2) this.i;
                rf0 rf0Var = (rf0) obj;
                rf0Var.getClass();
                float fFloatValue2 = ((Number) gr2Var2.getValue()).floatValue();
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (rf0Var.c() >> 32)) / 29.0f;
                float fIntBitsToFloat5 = Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)) / 2.0f;
                float f4 = 0.25f * fIntBitsToFloat4;
                if (f4 < 1.3f) {
                    f4 = 1.3f;
                }
                float fFloatValue3 = rn2Var3 == rn2Var2 ? ((Number) gr2Var3.getValue()).floatValue() : 0.0f;
                float fFloatValue4 = ((Number) gr2Var4.getValue()).floatValue();
                float f5 = 0.3f;
                float f6 = f4;
                long j4 = ((sz) gr2Var5.getValue()).a;
                while (i < 29) {
                    float f7 = i;
                    float f8 = f5;
                    float f9 = (f7 - 14.0f) / 14.0f;
                    long j5 = j;
                    float fExp = (float) Math.exp((-f9) * f9 * 5.8f);
                    float fSin = (((float) Math.sin((0.53f * f7) + (1.8f * fFloatValue2))) * 0.27f) + 0.73f;
                    float f10 = fFloatValue2;
                    float fAbs = Math.abs((((float) Math.sin((11.1f * fFloatValue2) - (0.29f * f7))) * 0.37f) + (((float) Math.sin((0.61f * f7) + (7.3f * fFloatValue2))) * 0.63f));
                    float f11 = fSin * 0.46f;
                    rn2Var3 = rn2Var3;
                    if (rn2Var3 == rn2Var2) {
                        f = f7;
                        rn2Var = rn2Var2;
                        float fAbs2 = (0.48f * fFloatValue3) + (Math.abs((((float) Math.sin((7.9f * f10) - (f * 0.27f))) * 0.38f) + (((float) Math.sin((0.43f * f7) + (4.8f * f10))) * 0.62f)) * f8) + f8;
                        f11 = fAbs2 > 0.94f ? 0.94f : fAbs2;
                    } else {
                        f = f7;
                        rn2Var = rn2Var2;
                    }
                    float f12 = fIntBitsToFloat5 * fExp * ((((fAbs * 0.58f) + 0.36f) * fFloatValue4) + ((1.0f - fFloatValue4) * f11));
                    float f13 = 0.55f * f6;
                    if (f12 < f13) {
                        f12 = f13;
                    }
                    float f14 = (f + 0.5f) * fIntBitsToFloat4;
                    float fAbs3 = ((1.0f - Math.abs(f9)) * 0.35f) + 0.65f;
                    long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(f14)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5 - f12)) & j5);
                    long jFloatToRawIntBits4 = (((long) Float.floatToRawIntBits(f14)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5 + f12)) & j5);
                    rf0Var.f0(sz.b(0.07f, j4), jFloatToRawIntBits3, jFloatToRawIntBits4, f6 * 5.5f);
                    rf0Var.f0(sz.b(0.18f, j4), jFloatToRawIntBits3, jFloatToRawIntBits4, f6 * 2.4f);
                    float f15 = f6;
                    rf0Var.f0(sz.b(fAbs3, j4), jFloatToRawIntBits3, jFloatToRawIntBits4, f15);
                    if (fExp > 0.7f) {
                        rf0Var.f0(sz.b(0.45f, ki4.c(4291754751L)), jFloatToRawIntBits3, jFloatToRawIntBits4, f15 * 0.34f);
                    }
                    i++;
                    rn2Var2 = rn2Var;
                    f6 = f15;
                    fFloatValue2 = f10;
                    f5 = f8;
                    j = j5;
                }
                return q43.a;
        }
    }

    public /* synthetic */ w9(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
        this.i = obj5;
    }
}
