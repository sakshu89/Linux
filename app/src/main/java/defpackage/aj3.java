package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aj3 extends gu3 {
    private static final aj3 zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";
    private int zbh;

    static {
        aj3 aj3Var = new aj3();
        zbb = aj3Var;
        gu3.d(aj3.class, aj3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", cf3.s});
        }
        if (i2 == 3) {
            return new aj3();
        }
        if (i2 == 4) {
            return new zh3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
