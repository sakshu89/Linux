package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lq3 extends gu3 {
    private static final lq3 zbb;
    private Object zbe;
    private int zbd = 0;
    private mu3 zbf = cv3.e;

    static {
        lq3 lq3Var = new lq3();
        zbb = lq3Var;
        gu3.d(lq3.class, lq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001;\u0000\u00023\u0000\u0003<\u0000\u0004\u001b", new Object[]{"zbe", "zbd", nq3.class, "zbf", lq3.class});
        }
        if (i2 == 3) {
            return new lq3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
