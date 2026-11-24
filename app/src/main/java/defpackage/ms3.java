package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ms3 extends gu3 {
    private static final ms3 zbb;
    private int zbd;
    private float zbe = 1.5f;
    private float zbf = 3.0f;
    private float zbg = 3.0f;
    private float zbh = 2.0f;
    private float zbi = 0.5f;
    private float zbj = 1.5f;
    private float zbk = 1.7f;
    private float zbl = 2.0f;
    private boolean zbm;

    static {
        ms3 ms3Var = new ms3();
        zbb = ms3Var;
        gu3.d(ms3.class, ms3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new ms3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
