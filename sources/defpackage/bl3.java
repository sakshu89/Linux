package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bl3 extends gu3 {
    private static final bl3 zbb;
    private int zbd;
    private int zbe = -1;
    private float zbf = 0.3f;
    private int zbg = 5;
    private float zbh = 0.5f;
    private int zbi = 1;
    private boolean zbj = true;
    private float zbk = 0.85f;
    private boolean zbl = true;
    private float zbm;

    static {
        bl3 bl3Var = new bl3();
        zbb = bl3Var;
        gu3.d(bl3.class, bl3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\t\u0000\u0001\u0001\u0011\t\u0000\u0000\u0000\u0001င\u0000\u0005ခ\u0001\u0006င\u0002\u0007ခ\u0003\f᠌\u0004\u000eဇ\u0005\u000fခ\u0006\u0010ဇ\u0007\u0011ခ\b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", cf3.v, "zbj", "zbk", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new bl3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
