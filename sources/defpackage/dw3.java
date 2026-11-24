package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dw3 extends gu3 {
    private static final dw3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh = 2;

    static {
        dw3 dw3Var = new dw3();
        zbb = dw3Var;
        gu3.d(dw3.class, dw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", xm3.w, "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new dw3();
        }
        if (i2 == 4) {
            return new cw3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
