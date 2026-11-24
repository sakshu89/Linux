package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yj3 extends gu3 {
    private static final yj3 zbb;
    private int zbd;
    private no3 zbe;
    private vv3 zbf;

    static {
        yj3 yj3Var = new yj3();
        zbb = yj3Var;
        gu3.d(yj3.class, yj3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new yj3();
        }
        if (i2 == 4) {
            return new fj3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
