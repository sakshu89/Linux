package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oi3 extends gu3 {
    private static final oi3 zbb;
    private int zbd;
    private mu3 zbe;
    private mu3 zbf;
    private mu3 zbg;
    private long zbh;
    private String zbi;
    private mu3 zbj;
    private String zbk;
    private ki3 zbl;
    private ei3 zbm;
    private lu3 zbn;
    private int zbo;

    static {
        oi3 oi3Var = new oi3();
        zbb = oi3Var;
        gu3.d(oi3.class, oi3Var);
    }

    public oi3() {
        cv3 cv3Var = cv3.e;
        this.zbe = cv3Var;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
        this.zbi = "";
        this.zbj = cv3Var;
        this.zbk = "";
        this.zbn = su3.e;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u0002\u0004Ȉ\u0005Ț\u0006Ȉ\u0007ဉ\u0001\b%\t\u0004\n\u001b\u000bဉ\u0000", new Object[]{"zbd", "zbe", li3.class, "zbf", mi3.class, "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbo", "zbg", ji3.class, "zbl"});
        }
        if (i2 == 3) {
            return new oi3();
        }
        if (i2 == 4) {
            return new zh3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
