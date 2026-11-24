package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xw3 extends gu3 {
    private static final xw3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private String zbg = "";

    static {
        xw3 xw3Var = new xw3();
        zbb = xw3Var;
        gu3.d(xw3.class, xw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", jw3.i, "zbg"});
        }
        if (i2 == 3) {
            return new xw3();
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
