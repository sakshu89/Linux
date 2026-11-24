package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iw3 extends gu3 {
    private static final iw3 zbb;
    private int zbd;
    private boolean zbe;
    private int zbf;
    private int zbh;
    private int zbi;
    private int zbj;
    private int zbk;
    private boolean zbg = true;
    private String zbl = "";
    private String zbm = "";

    static {
        iw3 iw3Var = new iw3();
        zbb = iw3Var;
        gu3.d(iw3.class, iw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            jw3 jw3Var = jw3.c;
            xm3 xm3Var = xm3.E;
            jw3 jw3Var2 = jw3.b;
            return new dv3(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zbd", "zbe", "zbf", jw3Var, "zbg", "zbh", xm3Var, "zbi", jw3Var2, "zbj", jw3Var2, "zbk", jw3Var2, "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new iw3();
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
