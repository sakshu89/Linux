package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cr3 extends gu3 {
    private static final cr3 zbb;
    private int zbd;
    private mu3 zbe = cv3.e;
    private int zbf;
    private int zbg;

    static {
        cr3 cr3Var = new cr3();
        zbb = cr3Var;
        gu3.d(cr3.class, cr3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002᠌\u0000\u0003᠌\u0001", new Object[]{"zbd", "zbe", br3.class, "zbf", xm3.m, "zbg", xm3.l});
        }
        if (i2 == 3) {
            return new cr3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
