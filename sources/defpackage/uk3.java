package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uk3 extends gu3 {
    private static final uk3 zbb;
    private int zbd;
    private si3 zbg;
    private lp3 zbh;
    private boolean zbk;
    private boolean zbe = true;
    private boolean zbf = true;
    private float zbi = 0.7f;
    private float zbj = 0.8f;

    static {
        uk3 uk3Var = new uk3();
        zbb = uk3Var;
        gu3.d(uk3.class, uk3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဉ\u0002\u0003ဉ\u0003\u0004ဇ\u0001\u0005ခ\u0004\u0006ခ\u0005\u0007ဇ\u0006", new Object[]{"zbd", "zbe", "zbg", "zbh", "zbf", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new uk3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
