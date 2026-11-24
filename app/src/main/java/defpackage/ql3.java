package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ql3 extends gu3 {
    private static final ql3 zbb;
    private int zbd;
    private Object zbf;
    private int zbe = 0;
    private String zbg = "";

    static {
        ql3 ql3Var = new ql3();
        zbb = ql3Var;
        gu3.d(ql3.class, ql3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u00025\u0000\u0003<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", pl3.class});
        }
        if (i2 == 3) {
            return new ql3();
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
