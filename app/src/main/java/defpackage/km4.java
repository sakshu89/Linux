package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class km4 {
    public static final boolean a(le0 le0Var, long j) {
        if (!le0Var.a.w) {
            return false;
        }
        f11 f11Var = cm4.g(le0Var).o0.c;
        if (!f11Var.A0.w) {
            return false;
        }
        long jU = f11Var.U(0L);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jU >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jU & 4294967295L));
        long j2 = le0Var.X;
        float f = ((int) (j2 >> 32)) + fIntBitsToFloat;
        float f2 = ((int) (j2 & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        if (fIntBitsToFloat > fIntBitsToFloat3 || fIntBitsToFloat3 > f) {
            return false;
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        return fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= f2;
    }
}
