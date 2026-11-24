package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class os3 extends gu3 {
    private static final os3 zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private ku3 zbg = hu3.e;

    static {
        os3 os3Var = new os3();
        zbb = os3Var;
        gu3.d(os3.class, os3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0001\u0002င\u0000\u0003ࠞ", new Object[]{"zbd", "zbf", "zbe", "zbg", xm3.u});
        }
        if (i2 == 3) {
            return new os3();
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
