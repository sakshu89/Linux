package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ln3 extends gu3 {
    private static final ln3 zbb;
    private int zbd;
    private boolean zbe;
    private float zbf = 0.2f;
    private mu3 zbg = cv3.e;

    static {
        ln3 ln3Var = new ln3();
        zbb = ln3Var;
        gu3.d(ln3.class, ln3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0004\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", on3.class});
        }
        if (i2 == 3) {
            return new ln3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
