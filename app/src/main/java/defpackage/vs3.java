package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vs3 extends gu3 {
    private static final vs3 zbb;
    private int zbd;
    private int zbe;
    private cs3 zbg;
    private cs3 zbh;
    private float zbj;
    private cs3 zbl;
    private cs3 zbm;
    private ls3 zbn;
    private xs3 zbp;
    private byte zbq = 2;
    private ku3 zbf = hu3.e;
    private String zbi = "";
    private mu3 zbk = cv3.e;
    private boolean zbo = true;

    static {
        vs3 vs3Var = new vs3();
        zbb = vs3Var;
        gu3.d(vs3.class, vs3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbq);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0002\b\u0001ᔄ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005ခ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bᐉ\u0007\tဇ\b\nᐉ\t\u000bЛ\f\u0016", new Object[]{"zbd", "zbe", "zbg", "zbh", "zbi", "zbj", "zbl", "zbm", "zbn", "zbo", "zbp", "zbk", fs3.class, "zbf"});
        }
        if (i2 == 3) {
            return new vs3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbq = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
