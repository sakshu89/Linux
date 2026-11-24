package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uo3 extends gu3 {
    private static final uo3 zbb;
    private int zbd;
    private Object zbf;
    private int zbg;
    private int zbh;
    private int zbe = 0;
    private mu3 zbi = cv3.e;

    static {
        uo3 uo3Var = new uo3();
        zbb = uo3Var;
        gu3.d(uo3.class, uo3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001=\u0000\u0002င\u0000\u0003င\u0001\u0004<\u0000\u0005\u001b", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", to3.class, "zbi", qo3.class});
        }
        if (i2 == 3) {
            return new uo3();
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
