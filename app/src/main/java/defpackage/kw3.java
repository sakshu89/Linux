package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kw3 extends gu3 {
    private static final kw3 zbb;
    private int zbd;
    private boolean zbf;
    private int zbg;
    private boolean zbj;
    private int zbm;
    private int zbn;
    private boolean zbo;
    private int zbe = -1;
    private rt3 zbh = rt3.b;
    private String zbi = "";
    private boolean zbk = true;
    private boolean zbl = true;

    static {
        kw3 kw3Var = new kw3();
        zbb = kw3Var;
        gu3.d(kw3.class, kw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            jw3 jw3Var = jw3.d;
            jw3 jw3Var2 = jw3.e;
            return new dv3(zbb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zbd", "zbe", "zbf", "zbg", jw3Var, "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", jw3Var2, "zbn", jw3Var2, "zbo"});
        }
        if (i2 == 3) {
            return new kw3();
        }
        if (i2 == 4) {
            return new cw3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
