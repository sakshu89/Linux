package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zw3 extends du3 {
    private static final zw3 zbd;
    private int zbe;
    private double zbf;
    private int zbg;
    private int zbh;
    private double zbi;
    private double zbj;
    private byte zbk = 2;

    static {
        zw3 zw3Var = new zw3();
        zbd = zw3Var;
        gu3.d(zw3.class, zw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001က\u0000\u0002င\u0001\u0003င\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zw3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbk = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
