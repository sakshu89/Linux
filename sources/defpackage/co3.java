package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class co3 extends gu3 {
    private static final co3 zbb;
    private int zbd;
    private float zbf;
    private boolean zbg;
    private vv3 zbi;
    private boolean zbj;
    private boolean zbk;
    private ku3 zbe = hu3.e;
    private int zbh = 1;

    static {
        co3 co3Var = new co3();
        zbb = co3Var;
        gu3.d(co3.class, co3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0000\u0001ࠞ\u0002ခ\u0000\u0003ဇ\u0001\u0004᠌\u0002\u0005ဉ\u0003\u0007ဇ\u0004\bဇ\u0005", new Object[]{"zbd", "zbe", xm3.e, "zbf", "zbg", "zbh", xm3.f, "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new co3();
        }
        if (i2 == 4) {
            return new kn3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
