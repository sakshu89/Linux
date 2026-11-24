package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class il4 {
    public static final boolean a(long j, long j2) {
        return j == j2;
    }

    public static String b(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            return "CornerRadius.circular(" + do4.a(Float.intBitsToFloat(i)) + ')';
        }
        return "CornerRadius.elliptical(" + do4.a(Float.intBitsToFloat(i)) + ", " + do4.a(Float.intBitsToFloat(i2)) + ')';
    }
}
