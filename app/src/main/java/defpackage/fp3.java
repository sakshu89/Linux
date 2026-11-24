package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fp3 extends gu3 {
    private static final fp3 zbb;
    private int zbd;
    private no3 zbg;
    private no3 zbh;
    private boolean zbi;
    private boolean zbj;
    private boolean zbk;
    private vv3 zbm;
    private String zbe = "";
    private String zbf = "";
    private int zbl = 1;

    static {
        fp3 fp3Var = new fp3();
        zbb = fp3Var;
        gu3.d(fp3.class, fp3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0005\u0003ဇ\u0006\u0004ဉ\u0002\u0006ဇ\u0004\u0007င\u0007\bဉ\b\tဉ\u0003\nဈ\u0001", new Object[]{"zbd", "zbe", "zbj", "zbk", "zbg", "zbi", "zbl", "zbm", "zbh", "zbf"});
        }
        if (i2 == 3) {
            return new fp3();
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
