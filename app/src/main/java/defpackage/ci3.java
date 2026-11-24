package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ci3 extends gu3 {
    private static final ci3 zbb;
    private Object zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private int zbd = 0;
    private mu3 zbi = cv3.e;

    static {
        ci3 ci3Var = new ci3();
        zbb = ci3Var;
        gu3.d(ci3.class, ci3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\f\u0002<\u0000\u0003\u0004\u0004\u001b\u00057\u0000\u0006\u0004", new Object[]{"zbe", "zbd", "zbf", bi3.class, "zbg", "zbi", mt3.class, "zbh"});
        }
        if (i2 == 3) {
            return new ci3();
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
