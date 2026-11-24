package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ii3 extends gu3 {
    private static final ii3 zbb;
    private int zbd;
    private Object zbf;
    private ei3 zbg;
    private mu3 zbk;
    private mu3 zbl;
    private mu3 zbn;
    private int zbe = 0;
    private uu3 zbm = uu3.b;
    private String zbh = "";
    private String zbi = "";
    private String zbj = "";

    static {
        ii3 ii3Var = new ii3();
        zbb = ii3Var;
        gu3.d(ii3.class, ii3Var);
    }

    public ii3() {
        cv3 cv3Var = cv3.e;
        this.zbk = cv3Var;
        this.zbl = cv3Var;
        this.zbn = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\t\u0001\u0001\u0001\u000b\t\u0001\u0003\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u001b\u0004\u001b\u0005<\u0000\b2\t\u001b\nȈ\u000bȈ", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbk", gi3.class, "zbl", hi3.class, di3.class, "zbm", fi3.a, "zbn", mt3.class, "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new ii3();
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
