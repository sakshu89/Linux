package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rf3 extends gu3 {
    private static final rf3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private int zbi;
    private mu3 zbj;
    private mu3 zbk;

    static {
        rf3 rf3Var = new rf3();
        zbb = rf3Var;
        gu3.d(rf3.class, rf3Var);
    }

    public rf3() {
        cv3 cv3Var = cv3.e;
        this.zbj = cv3Var;
        this.zbk = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006\u001b\u0007\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", qf3.class, "zbk", qf3.class});
        }
        if (i2 == 3) {
            return new rf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
