package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class um3 extends gu3 {
    private static final um3 zbb;
    private int zbd;
    private wk3 zbe;
    private dp3 zbf;
    private nh3 zbg;
    private dp3 zbh;
    private byte zbi = 2;

    static {
        um3 um3Var = new um3();
        zbb = um3Var;
        gu3.d(um3.class, um3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new um3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
