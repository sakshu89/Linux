package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jp0 {
    public static final float[] a = {8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
    public static volatile mp2 b = new mp2(0);
    public static final Object[] c;

    static {
        Object[] objArr = new Object[0];
        c = objArr;
        synchronized (objArr) {
            b.c(115, new kp0(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            b.c(130, new kp0(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            b.c(150, new kp0(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            b.c(180, new kp0(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            b.c(200, new kp0(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
        }
        if ((b.a[0] / 100.0f) - 0.01f > 1.03f) {
            return;
        }
        b11.b("You should only apply non-linear scaling to font scales > 1");
    }

    public static ip0 a(float f) {
        float f2;
        ip0 kp0Var;
        float[] fArr = a;
        if (f < 1.03f) {
            return null;
        }
        int i = (int) (f * 100.0f);
        ip0 ip0Var = (ip0) b.b(i);
        if (ip0Var != null) {
            return ip0Var;
        }
        mp2 mp2Var = b;
        int iA = ny3.a(mp2Var.a, mp2Var.c, i);
        if (iA >= 0) {
            return (ip0) b.d(iA);
        }
        int i2 = -(iA + 1);
        int i3 = i2 - 1;
        if (i2 >= b.c) {
            kp0 kp0Var2 = new kp0(new float[]{1.0f}, new float[]{f});
            b(f, kp0Var2);
            return kp0Var2;
        }
        if (i3 < 0) {
            kp0Var = new kp0(fArr, fArr);
            f2 = 1.0f;
        } else {
            f2 = b.a[i3] / 100.0f;
            kp0Var = (ip0) b.d(i3);
        }
        float f3 = b.a[i2] / 100.0f;
        float fMax = (Math.max(0.0f, Math.min(1.0f, f2 == f3 ? 0.0f : (f - f2) / (f3 - f2))) * 1.0f) + 0.0f;
        ip0 ip0Var2 = (ip0) b.d(i2);
        float[] fArr2 = new float[9];
        for (int i4 = 0; i4 < 9; i4++) {
            float f4 = fArr[i4];
            float fB = kp0Var.b(f4);
            fArr2[i4] = ((ip0Var2.b(f4) - fB) * fMax) + fB;
        }
        kp0 kp0Var3 = new kp0(fArr, fArr2);
        b(f, kp0Var3);
        return kp0Var3;
    }

    public static void b(float f, kp0 kp0Var) {
        synchronized (c) {
            mp2 mp2VarA = b.clone();
            mp2VarA.c((int) (f * 100.0f), kp0Var);
            b = mp2VarA;
        }
    }
}
