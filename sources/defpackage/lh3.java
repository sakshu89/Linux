package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lh3 extends gu3 {
    private static final lh3 zbb;
    private int zbd;
    private String zbe = "";
    private rt3 zbf;
    private mh3 zbg;
    private String zbh;
    private rt3 zbi;
    private mh3 zbj;
    private String zbk;
    private rt3 zbl;
    private mh3 zbm;
    private String zbn;
    private String zbo;
    private mh3 zbp;

    static {
        lh3 lh3Var = new lh3();
        zbb = lh3Var;
        gu3.d(lh3.class, lh3Var);
    }

    public lh3() {
        qt3 qt3Var = rt3.b;
        this.zbf = qt3Var;
        this.zbh = "";
        this.zbi = qt3Var;
        this.zbk = "";
        this.zbl = qt3Var;
        this.zbn = "";
        this.zbo = "";
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ည\u0004\u0004ဈ\u0003\u0005ဈ\u0006\u0006ည\u0007\u0007ဈ\t\bဈ\n\tဉ\u0002\nဉ\u0005\u000bဉ\b\fဉ\u000b", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbk", "zbl", "zbn", "zbo", "zbg", "zbj", "zbm", "zbp"});
        }
        if (i2 == 3) {
            return new lh3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
