package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rr3 extends gu3 {
    private static final rr3 zbb;
    private int zbd;
    private qr3 zbe;
    private double zbf;
    private boolean zbg;
    private tr3 zbh;
    private byte zbi = 2;

    static {
        rr3 rr3Var = new rr3();
        zbb = rr3Var;
        gu3.d(rr3.class, rr3Var);
    }

    public static rr3 o() {
        return zbb;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002\u0004ᐉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new rr3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final tr3 p() {
        tr3 tr3Var = this.zbh;
        return tr3Var == null ? tr3.t() : tr3Var;
    }
}
