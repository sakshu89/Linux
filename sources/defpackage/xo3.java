package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xo3 extends gu3 {
    private static final xo3 zbb;
    private int zbd;
    private wo3 zbf;
    private no3 zbg;
    private yj3 zbh;
    private vv3 zbk;
    private String zbe = "";
    private String zbi = "en";
    private int zbj = 1;
    private int zbl = -1;
    private String zbm = "";

    static {
        xo3 xo3Var = new xo3();
        zbb = xo3Var;
        gu3.d(xo3.class, xo3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003᠌\u0005\u0004ဉ\u0006\u0005ဉ\u0002\u0006ဈ\u0004\u0007င\u0007\bဉ\u0003\tဈ\b", new Object[]{"zbd", "zbe", "zbf", "zbj", xm3.g, "zbk", "zbg", "zbi", "zbl", "zbh", "zbm"});
        }
        if (i2 == 3) {
            return new xo3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
