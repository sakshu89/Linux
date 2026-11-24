package defpackage;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class u34 {
    public static final byte[] a = {48, 49, 53, 0};
    public static final byte[] b = {48, 49, 48, 0};
    public static final byte[] c = {48, 48, 57, 0};
    public static final byte[] d = {48, 48, 53, 0};
    public static final byte[] e = {48, 48, 49, 0};
    public static final byte[] f = {48, 48, 49, 0};
    public static final byte[] g = {48, 48, 50, 0};

    public static final boolean a(float f2, float f3, na naVar) {
        float f4 = f2 - 0.005f;
        float f5 = f3 - 0.005f;
        float f6 = f2 + 0.005f;
        float f7 = f3 + 0.005f;
        na naVarA = pa.a();
        if (Float.isNaN(f4) || Float.isNaN(f5) || Float.isNaN(f6) || Float.isNaN(f7)) {
            pa.b("Invalid rectangle, make sure no value is NaN");
        }
        if (naVarA.b == null) {
            naVarA.b = new RectF();
        }
        RectF rectF = naVarA.b;
        rectF.getClass();
        rectF.set(f4, f5, f6, f7);
        Path path = naVarA.a;
        RectF rectF2 = naVarA.b;
        rectF2.getClass();
        path.addRect(rectF2, Path.Direction.CCW);
        na naVarA2 = pa.a();
        naVarA2.e(naVar, naVarA, 1);
        boolean zIsEmpty = naVarA2.a.isEmpty();
        naVarA2.f();
        naVarA.f();
        return !zIsEmpty;
    }

    public static final boolean b(float f2, float f3, float f4, float f5, long j) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return ((f7 * f7) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f6 * f6) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }
}
