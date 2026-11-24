package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bm3 extends gu3 {
    private static final bm3 zbb;
    private int zbd;
    private yj3 zbe;
    private no3 zbf;
    private String zbg = "en";
    private int zbh = -1;
    private float zbi;
    private mu3 zbj;
    private mu3 zbk;
    private int zbl;
    private vv3 zbm;

    static {
        bm3 bm3Var = new bm3();
        zbb = bm3Var;
        gu3.d(bm3.class, bm3Var);
    }

    public bm3() {
        cv3 cv3Var = cv3.e;
        this.zbj = cv3Var;
        this.zbk = cv3Var;
        this.zbl = -1;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001ဉ\u0001\u0002ဈ\u0002\u0003င\u0003\u0004ခ\u0004\u0005\u001a\u0006\u001a\u0007င\u0005\bဉ\u0006\tဉ\u0000", new Object[]{"zbd", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbe"});
        }
        if (i2 == 3) {
            return new bm3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
