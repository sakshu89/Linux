package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class se4 {
    public static final long a(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final void b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        og.o(cq.i("toIndex (", i, ") is greater than size (", i2, ")."));
    }
}
