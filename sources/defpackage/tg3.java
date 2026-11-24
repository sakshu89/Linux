package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tg3 extends gu3 {
    private static final tg3 zbb;
    private int zbd;
    private String zbe = "";
    private ju3 zbf;
    private ju3 zbg;
    private mu3 zbh;

    static {
        tg3 tg3Var = new tg3();
        zbb = tg3Var;
        gu3.d(tg3.class, tg3Var);
    }

    public tg3() {
        yt3 yt3Var = yt3.e;
        this.zbf = yt3Var;
        this.zbg = yt3Var;
        this.zbh = cv3.e;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001ဈ\u0000\u0002$\u0003$\u0004\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new tg3();
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
