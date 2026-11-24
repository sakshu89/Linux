package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hh3 extends gu3 {
    private static final hh3 zbb;
    private int zbd;
    private float zbe = 10.0f;
    private float zbf = 10.0f;
    private float zbg = 5.0f;
    private float zbh = 5.0f;
    private float zbi = 10.0f;
    private float zbj = 10.0f;

    static {
        hh3 hh3Var = new hh3();
        zbb = hh3Var;
        gu3.d(hh3.class, hh3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new hh3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
