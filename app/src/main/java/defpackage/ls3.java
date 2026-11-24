package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ls3 extends gu3 {
    private static final ls3 zbb;
    private int zbd;
    private rt3 zbe;
    private rt3 zbf;
    private rt3 zbg;
    private cs3 zbh;
    private String zbi;
    private byte zbj = 2;

    static {
        ls3 ls3Var = new ls3();
        zbb = ls3Var;
        gu3.d(ls3.class, ls3Var);
    }

    public ls3() {
        qt3 qt3Var = rt3.b;
        this.zbe = qt3Var;
        this.zbf = qt3Var;
        this.zbg = qt3Var;
        this.zbi = "";
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0002\u0001ᔊ\u0000\u0002ည\u0001\u0003ည\u0002\u0004ᐉ\u0003\u0005ဈ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new ls3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbj = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
