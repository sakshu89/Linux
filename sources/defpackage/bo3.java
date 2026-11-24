package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bo3 extends gu3 {
    private static final bo3 zbb;
    private int zbd;
    private Object zbf;
    private int zbg;
    private long zbj;
    private int zbl;
    private int zbe = 0;
    private String zbh = "";
    private mu3 zbi = cv3.e;
    private String zbk = "";

    static {
        bo3 bo3Var = new bo3();
        zbb = bo3Var;
        gu3.d(bo3.class, bo3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u000b\u0001\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဈ\u0003\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\nဂ\u0002\u000b᠌\u0004", new Object[]{"zbf", "zbe", "zbd", "zbg", xm3.e, "zbh", "zbi", ao3.class, "zbk", ml3.class, aj3.class, jl3.class, fk3.class, sl3.class, "zbj", "zbl", xm3.d});
        }
        if (i2 == 3) {
            return new bo3();
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
