package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sr3 extends gu3 {
    private static final sr3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg = 2;
    private float zbh;
    private boolean zbi;

    static {
        sr3 sr3Var = new sr3();
        zbb = sr3Var;
        gu3.d(sr3.class, sr3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zbd", "zbe", xm3.n, "zbf", xm3.p, "zbg", xm3.o, "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new sr3();
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
