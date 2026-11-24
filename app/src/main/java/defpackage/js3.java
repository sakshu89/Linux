package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class js3 extends gu3 {
    private static final js3 zbb;
    private ju3 zbA;
    private ku3 zbB;
    private float zbC;
    private int zbD;
    private int zbE;
    private byte zbF = 2;
    private int zbd;
    private cs3 zbe;
    private float zbf;
    private rt3 zbg;
    private rt3 zbh;
    private cs3 zbi;
    private int zbj;
    private mu3 zbk;
    private boolean zbl;
    private boolean zbm;
    private mu3 zbn;
    private String zbo;
    private String zbp;
    private mu3 zbq;
    private mu3 zbr;
    private int zbs;
    private int zbt;
    private float zbu;
    private float zbv;
    private float zbw;
    private int zbx;
    private rs3 zby;
    private mu3 zbz;

    static {
        js3 js3Var = new js3();
        zbb = js3Var;
        gu3.d(js3.class, js3Var);
    }

    public js3() {
        qt3 qt3Var = rt3.b;
        this.zbg = qt3Var;
        this.zbh = qt3Var;
        cv3 cv3Var = cv3.e;
        this.zbk = cv3Var;
        this.zbn = cv3Var;
        this.zbo = "";
        this.zbp = "";
        this.zbq = cv3Var;
        this.zbr = cv3Var;
        this.zbt = 1;
        this.zbz = cv3Var;
        this.zbA = yt3.e;
        this.zbB = hu3.e;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbF);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u001b\u0000\u0001\u0001d\u001b\u0000\u0007\u0007\u0001ᔉ\u0000\u0002ခ\u0001\u0003ည\u0002\u0004ည\u0003\u0005င\u0005\u0006ᐉ\u0004\u0007Л\bဇ\u0006\tဇ\u0007\nЛ\u000bဈ\b\fЛ\rЛ\u000eင\n\u000f᠌\u000b\u0010ခ\u000e\u0011ဈ\t\u0012င\u000f\u0013ဉ\u0010\u0014Л\u0015\u0013\u0016\u0016\u0017ခ\f\u0018ခ\r\u0019ခ\u0011\u001aင\u0012dင\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbj", "zbi", "zbk", ks3.class, "zbl", "zbm", "zbn", ht3.class, "zbo", "zbq", cs3.class, "zbr", fs3.class, "zbs", "zbt", xm3.t, "zbw", "zbp", "zbx", "zby", "zbz", cs3.class, "zbA", "zbB", "zbu", "zbv", "zbC", "zbD", "zbE"});
        }
        if (i2 == 3) {
            return new js3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbF = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
