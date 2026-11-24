package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bt3 extends gu3 {
    private static final bt3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private float zbg;
    private float zbh;
    private int zbi;
    private int zbj;
    private int zbk;
    private int zbl;
    private int zbm;
    private float zbo;
    private float zbq;
    private mu3 zbr;
    private ju3 zbs;
    private ju3 zbt;
    private mu3 zbu;
    private ju3 zbv;
    private ju3 zbw;
    private String zbn = "";
    private String zbp = "";

    static {
        bt3 bt3Var = new bt3();
        zbb = bt3Var;
        gu3.d(bt3.class, bt3Var);
    }

    public bt3() {
        cv3 cv3Var = cv3.e;
        this.zbr = cv3Var;
        yt3 yt3Var = yt3.e;
        this.zbs = yt3Var;
        this.zbt = yt3Var;
        this.zbu = cv3Var;
        this.zbv = yt3Var;
        this.zbw = yt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0006\u0000\u0001င\u0000\u0002င\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nဈ\u000b\u000b\u001a\fဈ\t\rခ\n\u000eခ\f\u000f$\u0010$\u0011\u001a\u0012$\u0013$", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbp", "zbr", "zbn", "zbo", "zbq", "zbs", "zbt", "zbu", "zbv", "zbw"});
        }
        if (i2 == 3) {
            return new bt3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
