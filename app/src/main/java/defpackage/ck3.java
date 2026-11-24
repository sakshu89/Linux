package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ck3 extends gu3 {
    private static final ck3 zbb;
    private int zbd;
    private Object zbf;
    private boolean zbg;
    private dp3 zbh;
    private boolean zbi;
    private lo3 zbj;
    private float zbk;
    private boolean zbl;
    private boolean zbm;
    private boolean zbo;
    private float zbp;
    private int zbq;
    private al3 zbr;
    private int zbe = 0;
    private byte zbs = 2;
    private int zbn = -1;

    static {
        ck3 ck3Var = new ck3();
        zbb = ck3Var;
        gu3.d(ck3.class, ck3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbs);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u000e\u0001\u0001\u0001\u000e\u000e\u0000\u0000\u0001\u0001м\u0000\u0002ဉ\u0001\u0003ဉ\u0003\u0004ဇ\u0006\u0005င\u0007\u0006ဇ\b\u0007ဇ\u0000\bခ\t\tင\n\nဇ\u0002\u000bဉ\u000b\fခ\u0004\rဇ\u0005\u000e<\u0000", new Object[]{"zbf", "zbe", "zbd", nh3.class, "zbh", "zbj", "zbm", "zbn", "zbo", "zbg", "zbp", "zbq", "zbi", "zbr", "zbk", "zbl", bm3.class});
        }
        if (i2 == 3) {
            return new ck3();
        }
        if (i2 == 4) {
            return new fj3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbs = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
