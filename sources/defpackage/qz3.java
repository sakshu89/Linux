package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qz3 {
    public static final ka3 a = new ka3(0.31006f, 0.31616f);
    public static final ka3 b = new ka3(0.34567f, 0.3585f);
    public static final ka3 c = new ka3(0.32168f, 0.33767f);
    public static final ka3 d = new ka3(0.31271f, 0.32902f);
    public static final float[] e = {0.964212f, 1.0f, 0.825188f};

    public static final long a(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) * Float.intBitsToFloat((int) (j >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) * Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }
}
