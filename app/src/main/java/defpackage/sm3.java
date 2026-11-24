package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sm3 extends gu3 {
    private static final sm3 zbb;
    private int zbd;
    private rl3 zbe;
    private hk3 zbf;
    private rh3 zbg;
    private nn3 zbh;
    private boolean zbi;
    private kk3 zbj;
    private tl3 zbk;
    private kl3 zbl;

    static {
        sm3 sm3Var = new sm3();
        zbb = sm3Var;
        gu3.d(sm3.class, sm3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001ဉ\u0001\u0003ဉ\u0005\u0004ဉ\u0000\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဇ\u0004\bဉ\u0006\tဉ\u0007", new Object[]{"zbd", "zbf", "zbj", "zbe", "zbg", "zbh", "zbi", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new sm3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
