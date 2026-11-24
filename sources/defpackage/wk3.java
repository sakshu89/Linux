package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wk3 extends gu3 {
    private static final wk3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private boolean zbh;
    private int zbi;
    private boolean zbj;
    private int zbk;

    static {
        wk3 wk3Var = new wk3();
        zbb = wk3Var;
        gu3.d(wk3.class, wk3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005င\u0004\u0006ဇ\u0005\u0007င\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new wk3();
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
