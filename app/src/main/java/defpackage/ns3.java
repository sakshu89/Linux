package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ns3 extends du3 {
    private static final ns3 zbd;
    private int zbA;
    private float zbB;
    private boolean zbC;
    private int zbD;
    private byte zbE = 2;
    private int zbe;
    private mu3 zbf;
    private cs3 zbg;
    private cs3 zbh;
    private cs3 zbi;
    private String zbj;
    private float zbk;
    private mu3 zbl;
    private mu3 zbm;
    private float zbn;
    private String zbo;
    private boolean zbp;
    private mu3 zbq;
    private int zbr;
    private int zbs;
    private boolean zbt;
    private js3 zbu;
    private boolean zbv;
    private int zbw;
    private int zbx;
    private int zby;
    private ft3 zbz;

    static {
        ns3 ns3Var = new ns3();
        zbd = ns3Var;
        gu3.d(ns3.class, ns3Var);
    }

    public ns3() {
        cv3 cv3Var = cv3.e;
        this.zbf = cv3Var;
        this.zbj = "";
        this.zbl = cv3Var;
        this.zbm = cv3Var;
        this.zbo = "";
        this.zbq = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbE);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0019\u0000\u0001\u0001d\u0019\u0000\u0004\u0006\u0001Л\u0002ᐉ\u0000\u0003ᐉ\u0001\u0004ဈ\u0003\u0005ခ\u0004\u0006\u001b\u0007ခ\u0005\bဈ\u0006\tЛ\nဇ\u0007\u000b\u001b\fင\b\rင\t\u000eဇ\n\u000fᐉ\u000b\u0010ဇ\f\u0011င\r\u0012င\u000e\u0013ᐉ\u0002\u0014င\u000f\u0015ဉ\u0010\u0016᠌\u0011\u0017ခ\u0012\u0018ဇ\u0013dင\u0014", new Object[]{"zbe", "zbf", ct3.class, "zbg", "zbh", "zbj", "zbk", "zbm", ds3.class, "zbn", "zbo", "zbl", fs3.class, "zbp", "zbq", us3.class, "zbr", "zbs", "zbt", "zbu", "zbv", "zbw", "zbx", "zbi", "zby", "zbz", "zbA", cf3.f, "zbB", "zbC", "zbD"});
        }
        if (i2 == 3) {
            return new ns3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbE = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
