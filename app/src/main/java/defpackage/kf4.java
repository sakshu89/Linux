package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class kf4 {
    public static void a(kn knVar, byte[] bArr) {
        long j;
        knVar.getClass();
        bArr.getClass();
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = knVar.f;
            int i2 = knVar.i;
            int i3 = knVar.j;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = knVar.e;
            ln lnVar = knVar.a;
            lnVar.getClass();
            if (j2 == lnVar.b) {
                og.n("no more bytes");
                return;
            }
            j = knVar.e;
        } while (knVar.e(j == -1 ? 0L : j + ((long) (knVar.j - knVar.i))) != -1);
    }

    public static final int b(float f, float[] fArr, int i) {
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (Math.abs(f2 - f) > 1.05E-6f) {
            f2 = Float.NaN;
        }
        fArr[i] = f2;
        return !Float.isNaN(f2) ? 1 : 0;
    }
}
