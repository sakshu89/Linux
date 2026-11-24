package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yr3 extends gu3 {
    private static final yr3 zbb;
    private boolean zbh;
    private boolean zbi;
    private mu3 zbm;
    private boolean zbn;
    private boolean zbo;
    private String zbp;
    private mu3 zbq;
    private uu3 zbd = uu3.b;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";
    private String zbj = "";
    private String zbk = "";
    private String zbl = "";

    static {
        yr3 yr3Var = new yr3();
        zbb = yr3Var;
        gu3.d(yr3.class, yr3Var);
    }

    public yr3() {
        cv3 cv3Var = cv3.e;
        this.zbm = cv3Var;
        this.zbp = "";
        this.zbq = cv3Var;
    }

    public static wr3 o() {
        return (wr3) zbb.k();
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u000e\u0000\u0000\u0001\u0010\u000e\u0001\u0002\u0000\u00012\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0007\tȈ\nȈ\u000bȚ\f\u0007\rȈ\u000e\u0007\u000fȈ\u0010Ț", new Object[]{"zbd", xr3.a, "zbi", "zbe", "zbf", "zbj", "zbh", "zbk", "zbl", "zbm", "zbn", "zbg", "zbo", "zbp", "zbq"});
        }
        if (i2 == 3) {
            return new yr3();
        }
        if (i2 == 4) {
            return new wr3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
