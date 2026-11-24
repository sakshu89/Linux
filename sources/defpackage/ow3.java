package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ow3 extends gu3 {
    private static final ow3 zbb;
    private int zbd;
    private mu3 zbe = cv3.e;
    private qw3 zbf;
    private yv3 zbg;

    static {
        ow3 ow3Var = new ow3();
        zbb = ow3Var;
        gu3.d(ow3.class, ow3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zbd", "zbe", ww3.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new ow3();
        }
        if (i2 == 4) {
            return new cw3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
