package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gq3 extends gu3 {
    private static final gq3 zbb;
    private int zbd;
    private mu3 zbe;
    private mu3 zbf;
    private mu3 zbg;
    private int zbh;
    private mu3 zbi;
    private mu3 zbj;
    private mu3 zbk;
    private mu3 zbl;
    private mu3 zbm;
    private int zbn;
    private boolean zbo;
    private wq3 zbp;
    private xq3 zbq;
    private mu3 zbr;
    private jq3 zbs;
    private String zbt;
    private String zbu;
    private kq3 zbv;
    private mu3 zbw;
    private byte zbx = 2;

    static {
        gq3 gq3Var = new gq3();
        zbb = gq3Var;
        gu3.d(gq3.class, gq3Var);
    }

    public gq3() {
        cv3 cv3Var = cv3.e;
        this.zbe = cv3Var;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
        this.zbi = cv3Var;
        this.zbj = cv3Var;
        this.zbk = cv3Var;
        this.zbl = cv3Var;
        this.zbm = cv3Var;
        this.zbr = cv3Var;
        this.zbt = "";
        this.zbu = "";
        this.zbw = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbx);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0013\u0000\u0001\u0001Ϫ\u0013\u0000\n\b\u0001Л\u0006Л\u0007Л\b\u0004\tЛ\nȚ\u000b\u0004\fᐉ\u0000\rᐉ\u0001\u000eЛ\u000fȚ\u0010Ț\u0011Ț\u0012ဉ\u0002\u0013Ȉ\u0014Ȉ\u0015\u0007ϩᐉ\u0003Ϫ\u001b", new Object[]{"zbd", "zbe", fq3.class, "zbf", oq3.class, "zbg", qq3.class, "zbh", "zbi", tq3.class, "zbj", "zbn", "zbp", "zbq", "zbr", hq3.class, "zbk", "zbl", "zbm", "zbs", "zbt", "zbu", "zbo", "zbv", "zbw", mt3.class});
        }
        if (i2 == 3) {
            return new gq3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbx = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
