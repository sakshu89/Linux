package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zf2 {
    public static final sd a = new sd(Float.NaN, Float.NaN);
    public static final g33 b = new g33(new sa2(24), new sa2(25));
    public static final long c;
    public static final vq2 d;

    static {
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.01f)) << 32) | (((long) Float.floatToRawIntBits(0.01f)) & 4294967295L);
        c = jFloatToRawIntBits;
        d = new vq2(new jp1(jFloatToRawIntBits));
    }
}
