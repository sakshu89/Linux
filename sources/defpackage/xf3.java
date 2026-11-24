package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xf3 extends gu3 {
    private static final xf3 zbb;
    private int zbd;
    private ju3 zbe;
    private ju3 zbf;
    private int zbg;
    private int zbh;
    private int zbi;
    private int zbj;

    static {
        xf3 xf3Var = new xf3();
        zbb = xf3Var;
        gu3.d(xf3.class, xf3Var);
    }

    public xf3() {
        yt3 yt3Var = yt3.e;
        this.zbe = yt3Var;
        this.zbf = yt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new xf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
