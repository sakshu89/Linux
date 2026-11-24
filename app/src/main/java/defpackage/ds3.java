package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ds3 extends gu3 {
    private static final ds3 zbb;
    private int zbd;
    private int zbe = -1;
    private int zbf = -1;
    private ju3 zbg;
    private ku3 zbh;
    private ju3 zbi;

    static {
        ds3 ds3Var = new ds3();
        zbb = ds3Var;
        gu3.d(ds3.class, ds3Var);
    }

    public ds3() {
        yt3 yt3Var = yt3.e;
        this.zbg = yt3Var;
        this.zbh = hu3.e;
        this.zbi = yt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001င\u0000\u0002င\u0001\u0003\u0013\u0004\u0016\u0006\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new ds3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
