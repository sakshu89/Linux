package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gm3 extends gu3 {
    private static final gm3 zbb;
    private int zbd;
    private int zbe = -1;
    private float zbf = 1.0f;
    private int zbg;

    static {
        gm3 gm3Var = new gm3();
        zbb = gm3Var;
        gu3.d(gm3.class, gm3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003င\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new gm3();
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
