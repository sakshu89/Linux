package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ws3 extends gu3 {
    private static final ws3 zbb;
    private int zbd;
    private int zbe;
    private float zbg;
    private byte zbh = 2;
    private ku3 zbf = hu3.e;

    static {
        ws3 ws3Var = new ws3();
        zbb = ws3Var;
        gu3.d(ws3.class, ws3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ᔄ\u0000\u0002ᔁ\u0001\u0003\u0016", new Object[]{"zbd", "zbe", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new ws3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
