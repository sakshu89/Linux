package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ol3 extends gu3 {
    private static final ol3 zbb;
    private int zbd;
    private gl3 zbe;
    private ju3 zbf = yt3.e;

    static {
        ol3 ol3Var = new ol3();
        zbb = ol3Var;
        gu3.d(ol3.class, ol3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0013", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new ol3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
