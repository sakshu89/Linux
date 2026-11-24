package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tn3 extends gu3 {
    private static final tn3 zbb;
    private int zbd;
    private boolean zbe;
    private String zbf = "";
    private String zbg = "";

    static {
        tn3 tn3Var = new tn3();
        zbb = tn3Var;
        gu3.d(tn3.class, tn3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new tn3();
        }
        if (i2 == 4) {
            return new kn3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
