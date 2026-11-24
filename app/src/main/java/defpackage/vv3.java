package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vv3 extends gu3 {
    private static final vv3 zbb;
    private int zbd;
    private int zbe;
    private ww3 zbf;
    private nw3 zbg;
    private ow3 zbh;

    static {
        vv3 vv3Var = new vv3();
        zbb = vv3Var;
        gu3.d(vv3.class, vv3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zbd", "zbe", xm3.D, "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new vv3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
