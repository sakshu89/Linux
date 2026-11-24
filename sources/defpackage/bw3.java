package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bw3 extends gu3 {
    private static final bw3 zbb;
    private int zbd;
    private String zbe = "";
    private int zbf = 1;
    private boolean zbg;
    private int zbh;

    static {
        bw3 bw3Var = new bw3();
        zbb = bw3Var;
        gu3.d(bw3.class, bw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", xm3.v, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new bw3();
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
