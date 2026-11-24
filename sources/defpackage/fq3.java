package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fq3 extends gu3 {
    private static final fq3 zbb;
    private int zbd;
    private mu3 zbg;
    private mu3 zbh;
    private mu3 zbi;
    private mu3 zbj;
    private eq3 zbk;
    private mu3 zbl;
    private int zbm;
    private int zbn;
    private wq3 zbo;
    private xq3 zbp;
    private mu3 zbq;
    private String zbr;
    private jq3 zbs;
    private int zbt;
    private mu3 zbu;
    private mu3 zbv;
    private byte zbw = 2;
    private String zbe = "";
    private String zbf = "";

    static {
        fq3 fq3Var = new fq3();
        zbb = fq3Var;
        gu3.d(fq3.class, fq3Var);
    }

    public fq3() {
        cv3 cv3Var = cv3.e;
        this.zbg = cv3Var;
        this.zbh = cv3Var;
        this.zbi = cv3Var;
        this.zbj = cv3Var;
        this.zbl = cv3Var;
        this.zbq = cv3Var;
        this.zbr = "";
        this.zbu = cv3Var;
        this.zbv = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbw);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0012\u0000\u0001\u0001ϭ\u0012\u0000\b\u0003\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ț\u0005Ț\u0006Ț\u0007ᐉ\u0000\b\u001b\t\u0004\n\u0004\u000bᐉ\u0001\fᐉ\u0002\r\u001b\u000eȈ\u000fဉ\u0003\u0010\u0004\u0011ȚϭȚ", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", mt3.class, "zbm", "zbn", "zbo", "zbp", "zbq", iq3.class, "zbr", "zbs", "zbt", "zbu", "zbv"});
        }
        if (i2 == 3) {
            return new fq3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbw = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
