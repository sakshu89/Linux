package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class at3 extends gu3 {
    private static final at3 zbb;
    private int zbd;
    private int zbf;
    private int zbg;
    private mu3 zbi;
    private bt3 zbj;
    private mu3 zbk;
    private qs3 zbl;
    private os3 zbm;
    private mu3 zbn;
    private byte zbo = 2;
    private rt3 zbe = rt3.b;
    private String zbh = "";

    static {
        at3 at3Var = new at3();
        zbb = at3Var;
        gu3.d(at3.class, at3Var);
    }

    public at3() {
        cv3 cv3Var = cv3.e;
        this.zbi = cv3Var;
        this.zbk = cv3Var;
        this.zbn = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0003\u0004\u0001ᔊ\u0000\u0002ဈ\u0003\u0003Л\u0004ဉ\u0004\u0005Л\u0006ဉ\u0005\u0007ဉ\u0006\bЛ\tင\u0001\nင\u0002", new Object[]{"zbd", "zbe", "zbh", "zbi", ns3.class, "zbj", "zbk", zs3.class, "zbl", "zbm", "zbn", ys3.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new at3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbo = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
