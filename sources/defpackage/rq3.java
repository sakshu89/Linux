package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rq3 extends du3 {
    private static final rq3 zbd;
    private int zbe;
    private byte zbg = 2;
    private boolean zbf = true;

    static {
        rq3 rq3Var = new rq3();
        zbd = rq3Var;
        gu3.d(rq3.class, rq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zbe", "zbf"});
        }
        if (i2 == 3) {
            return new rq3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbg = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
