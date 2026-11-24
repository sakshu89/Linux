package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tm3 extends gu3 {
    private static final tm3 zbb;
    private int zbd;
    private km3 zbe;
    private om3 zbf;
    private mm3 zbg;
    private rm3 zbh;

    static {
        tm3 tm3Var = new tm3();
        zbb = tm3Var;
        gu3.d(tm3.class, tm3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new tm3();
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
