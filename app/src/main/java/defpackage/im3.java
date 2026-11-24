package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class im3 extends gu3 {
    private static final im3 zbb;
    private int zbd;
    private fm3 zbe;
    private gm3 zbf;
    private no3 zbg;
    private no3 zbh;

    static {
        im3 im3Var = new im3();
        zbb = im3Var;
        gu3.d(im3.class, im3Var);
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
            return new im3();
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
