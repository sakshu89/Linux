package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class no3 extends gu3 {
    private static final no3 zbb;
    private int zbd;
    private rt3 zbe = rt3.b;
    private String zbf = "";
    private oo3 zbg;

    static {
        no3 no3Var = new no3();
        zbb = no3Var;
        gu3.d(no3.class, no3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဈ\u0001\u0002ည\u0000\u0004ဉ\u0002", new Object[]{"zbd", "zbf", "zbe", "zbg"});
        }
        if (i2 == 3) {
            return new no3();
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
