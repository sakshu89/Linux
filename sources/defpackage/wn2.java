package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wn2 implements hq0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ wn2(List list, boolean z) {
        this.c = list;
        this.b = z;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        int i2 = 0;
        boolean z = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                gr2 gr2Var = (gr2) obj2;
                rf0 rf0Var = (rf0) obj;
                rf0Var.getClass();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (rf0Var.c() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L));
                float f = fIntBitsToFloat * 0.1f;
                na naVarA = pa.a();
                float f2 = 0.04f * fIntBitsToFloat;
                float f3 = 0.36f * fIntBitsToFloat2;
                Path path = naVarA.a;
                path.moveTo(f2, f3);
                float f4 = 0.26f * fIntBitsToFloat;
                naVarA.d(f4, f3);
                float f5 = fIntBitsToFloat * 0.5f;
                naVarA.d(f5, 0.1f * fIntBitsToFloat2);
                naVarA.d(f5, 0.9f * fIntBitsToFloat2);
                float f6 = 0.64f * fIntBitsToFloat2;
                naVarA.d(f4, f6);
                naVarA.d(f2, f6);
                path.close();
                rf0.g0(rf0Var, naVarA, ((sz) gr2Var.getValue()).a, 0.0f, null, 60);
                if (!z) {
                    while (i2 < 2) {
                        float f7 = i2;
                        float f8 = ((0.15f * f7) + 0.2f) * fIntBitsToFloat;
                        long jB = sz.b(0.95f - (f7 * 0.38f), ((sz) gr2Var.getValue()).a);
                        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((0.56f * fIntBitsToFloat) - f8)) << 32) | (((long) Float.floatToRawIntBits((fIntBitsToFloat2 * 0.5f) - f8)) & 4294967295L);
                        float f9 = f8 * 2.0f;
                        float f10 = f;
                        rf0Var.j(jB, -45.0f, 90.0f, jFloatToRawIntBits, (((long) Float.floatToRawIntBits(f9)) << 32) | (((long) Float.floatToRawIntBits(f9)) & 4294967295L), new ks2(f10, 0.0f, 1, 0, 26));
                        i2++;
                        f = f10;
                    }
                } else {
                    float f11 = 0.62f * fIntBitsToFloat;
                    float f12 = 0.3f * fIntBitsToFloat2;
                    float f13 = fIntBitsToFloat * 0.96f;
                    float f14 = fIntBitsToFloat2 * 0.7f;
                    rf0Var.f0(((sz) gr2Var.getValue()).a, (((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f12)) & 4294967295L), (((long) Float.floatToRawIntBits(f13)) << 32) | (((long) Float.floatToRawIntBits(f14)) & 4294967295L), f);
                    rf0Var.f0(((sz) gr2Var.getValue()).a, (((long) Float.floatToRawIntBits(f13)) << 32) | (((long) Float.floatToRawIntBits(f12)) & 4294967295L), (((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f14)) & 4294967295L), f);
                }
                break;
            default:
                List list = (List) obj2;
                r91 r91Var = (r91) obj;
                r91Var.getClass();
                int size = list.size();
                gn gnVar = new gn(3, list);
                w10 w10Var = new w10(802480018, true, new w13(list, z));
                t9 t9Var = r91Var.a;
                q91 q91Var = new q91(0, gnVar, w10Var);
                t9Var.getClass();
                if (size < 0) {
                    c11.a("size should be >=0");
                }
                if (size != 0) {
                    y21 y21Var = new y21(t9Var.b, size, q91Var);
                    t9Var.b += size;
                    ((pm1) t9Var.c).b(y21Var);
                }
                break;
        }
        return q43Var;
    }

    public /* synthetic */ wn2(boolean z, gr2 gr2Var) {
        this.b = z;
        this.c = gr2Var;
    }
}
