package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fh3 extends gu3 {
    private static final fh3 zbb;
    private ju3 zbd;
    private ju3 zbe;
    private ju3 zbf;
    private ju3 zbg;
    private ju3 zbh;
    private ju3 zbi;

    static {
        fh3 fh3Var = new fh3();
        zbb = fh3Var;
        gu3.d(fh3.class, fh3Var);
    }

    public fh3() {
        yt3 yt3Var = yt3.e;
        this.zbd = yt3Var;
        this.zbe = yt3Var;
        this.zbf = yt3Var;
        this.zbg = yt3Var;
        this.zbh = yt3Var;
        this.zbi = yt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0006\u0000\u0001\u0013\u0002\u0013\u0003\u0013\u0004\u0013\u0005\u0013\u0006\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new fh3();
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
