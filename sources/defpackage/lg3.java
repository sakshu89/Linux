package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lg3 extends gu3 {
    private static final lg3 zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private float zbh;
    private float zbi;
    private float zbj;
    private ig3 zbk;
    private int zbl;
    private int zbm;
    private float zbn;

    static {
        lg3 lg3Var = new lg3();
        zbb = lg3Var;
        gu3.d(lg3.class, lg3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004᠌\u0007\u0005᠌\b\u0006ခ\t\u0007ဉ\u0006\tခ\u0003\nခ\u0004\u000bခ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbl", cf3.k, "zbm", cf3.l, "zbn", "zbk", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new lg3();
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
