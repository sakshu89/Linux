package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wh3 extends gu3 {
    private static final wh3 zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private float zbh;
    private xh3 zbi;
    private float zbj;
    private qh3 zbk;
    private float zbl;
    private rt3 zbm;
    private rt3 zbn;
    private byte zbo = 2;

    static {
        wh3 wh3Var = new wh3();
        zbb = wh3Var;
        gu3.d(wh3.class, wh3Var);
    }

    public wh3() {
        qt3 qt3Var = rt3.b;
        this.zbm = qt3Var;
        this.zbn = qt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ခ\u0003\u0005ခ\u0007\u0006ည\b\u0007ခ\u0005\bဉ\u0006\tᐉ\u0004\nည\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbl", "zbm", "zbj", "zbk", "zbi", "zbn"});
        }
        if (i2 == 3) {
            return new wh3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbo = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
