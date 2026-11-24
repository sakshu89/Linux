package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ct3 extends gu3 {
    private static final ct3 zbb;
    private int zbA;
    private float zbB;
    private int zbC;
    private float zbD;
    private int zbE;
    private byte zbF = 2;
    private int zbd;
    private mu3 zbe;
    private cs3 zbf;
    private cs3 zbg;
    private String zbh;
    private float zbi;
    private mu3 zbj;
    private mu3 zbk;
    private boolean zbl;
    private String zbm;
    private boolean zbn;
    private mu3 zbo;
    private boolean zbp;
    private boolean zbq;
    private boolean zbr;
    private int zbs;
    private int zbt;
    private int zbu;
    private int zbv;
    private int zbw;
    private int zbx;
    private String zby;
    private float zbz;

    static {
        ct3 ct3Var = new ct3();
        zbb = ct3Var;
        gu3.d(ct3.class, ct3Var);
    }

    public ct3() {
        cv3 cv3Var = cv3.e;
        this.zbe = cv3Var;
        this.zbh = "";
        this.zbj = cv3Var;
        this.zbk = cv3Var;
        this.zbm = "";
        this.zbo = cv3Var;
        this.zbp = true;
        this.zby = "";
        this.zbC = 1;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbF);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u001b\u0000\u0001\u0001\u001b\u001b\u0000\u0004\u0004\u0001Л\u0002ᔉ\u0000\u0003ᐉ\u0001\u0004ဈ\u0002\u0005ခ\u0003\u0006\u001b\u0007ဇ\u0004\bဈ\u0005\tЛ\nဇ\u0006\u000b\u001b\fဇ\u0007\rဇ\b\u000eဇ\t\u000fင\u000b\u0010င\f\u0011င\r\u0012င\u000e\u0013င\u000f\u0014ဈ\u0010\u0015ခ\u0011\u0016᠌\u0012\u0017᠌\u0014\u0018ခ\u0013\u0019ခ\u0015\u001aင\u0016\u001bင\n", new Object[]{"zbd", "zbe", vs3.class, "zbf", "zbg", "zbh", "zbi", "zbk", ds3.class, "zbl", "zbm", "zbj", fs3.class, "zbn", "zbo", us3.class, "zbp", "zbq", "zbr", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbz", "zbA", cf3.f, "zbC", xm3.t, "zbB", "zbD", "zbE", "zbs"});
        }
        if (i2 == 3) {
            return new ct3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbF = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
