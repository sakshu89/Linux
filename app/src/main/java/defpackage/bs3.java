package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bs3 extends gu3 {
    private static final bs3 zbb;
    private int zbd;
    private int zbe;
    private int zbg;
    private boolean zbh;
    private int zbi;
    private boolean zbk;
    private vv3 zbl;
    private mu3 zbf = cv3.e;
    private int zbj = 1;

    static {
        bs3 bs3Var = new bs3();
        zbb = bs3Var;
        gu3.d(bs3.class, bs3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002\u001b\u0003င\u0001\u0004ဇ\u0002\u0005င\u0003\u0006င\u0004\u0007ဇ\u0005\bဉ\u0006", new Object[]{"zbd", "zbe", "zbf", as3.class, "zbg", "zbh", "zbi", "zbj", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new bs3();
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
