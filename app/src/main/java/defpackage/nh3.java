package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nh3 extends du3 {
    private static final nh3 zbd;
    private boolean zbA;
    private int zbe;
    private float zbi;
    private boolean zbl;
    private boolean zbm;
    private boolean zbn;
    private int zbo;
    private oh3 zbp;
    private dh3 zbq;
    private yf3 zbr;
    private kh3 zbs;
    private lh3 zbt;
    private vv3 zbv;
    private boolean zbw;
    private boolean zbx;
    private int zby;
    private int zbz;
    private byte zbB = 2;
    private String zbf = "";
    private int zbg = 10;
    private int zbh = 1;
    private float zbj = 0.3f;
    private mu3 zbk = cv3.e;
    private int zbu = 1;

    static {
        nh3 nh3Var = new nh3();
        zbd = nh3Var;
        gu3.d(nh3.class, nh3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbB);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a\u0007ဇ\u0005\bဇ\u0006\tဇ\u0007\nဋ\b\u000bဉ\t\fဉ\n\rဉ\f\u000fင\u000e\u0010ဉ\r\u0011ဉ\u000f\u0012ဇ\u0010\u0013ဇ\u0011\u0014င\u0012\u0015ဉ\u000b\u0016᠌\u0013\u0017ဇ\u0014", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbs", "zbu", "zbt", "zbv", "zbw", "zbx", "zby", "zbr", "zbz", cf3.r, "zbA"});
        }
        if (i2 == 3) {
            return new nh3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbB = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
