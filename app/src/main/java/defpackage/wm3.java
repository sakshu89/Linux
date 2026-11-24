package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wm3 extends gu3 {
    private static final wm3 zbb;
    private int zbd;
    private tk3 zbe;
    private wk3 zbf;
    private um3 zbg;
    private boolean zbh;
    private byte zbi = 2;

    static {
        wm3 wm3Var = new wm3();
        zbb = wm3Var;
        gu3.d(wm3.class, wm3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဇ\u0003\u0003ᐉ\u0002\u0004ဉ\u0001", new Object[]{"zbd", "zbe", "zbh", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new wm3();
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
