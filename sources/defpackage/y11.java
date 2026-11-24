package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class y11 {
    public static Context a;
    public static Boolean b;
    public static final rd c = new rd(Float.POSITIVE_INFINITY);
    public static final sd d = new sd(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final td e = new td(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final ud f = new ud(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final rd g = new rd(Float.NEGATIVE_INFINITY);
    public static final sd h = new sd(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final td i = new td(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final ud j = new ud(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final boolean a(ny1 ny1Var) {
        return (ny1Var.b() || ny1Var.h || !ny1Var.d) ? false : true;
    }

    public static final boolean b(ny1 ny1Var) {
        return !ny1Var.h && ny1Var.d;
    }

    public static final boolean c(ny1 ny1Var) {
        return (ny1Var.b() || !ny1Var.h || ny1Var.d) ? false : true;
    }

    public static final boolean d(ny1 ny1Var) {
        return ny1Var.h && !ny1Var.d;
    }

    public static final boolean e(ny1 ny1Var, long j2, long j3) {
        int i2 = ny1Var.i == 1 ? 1 : 0;
        long j4 = ny1Var.c;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L));
        float f2 = i2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j3 >> 32)) * f2;
        float f3 = ((int) (j2 >> 32)) + fIntBitsToFloat3;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * f2;
        return (fIntBitsToFloat > f3) | (fIntBitsToFloat < (-fIntBitsToFloat3)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j2 & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long f(ny1 ny1Var, boolean z) {
        long jD = jp1.d(ny1Var.c, ny1Var.g);
        if (z || !ny1Var.b()) {
            return jD;
        }
        return 0L;
    }
}
