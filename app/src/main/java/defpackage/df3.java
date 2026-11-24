package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class df3 extends gu3 {
    private static final df3 zbb;
    private int zbd;
    private mu3 zbe;
    private int zbf;
    private mu3 zbg;

    static {
        df3 df3Var = new df3();
        zbb = df3Var;
        gu3.d(df3.class, df3Var);
    }

    public df3() {
        cv3 cv3Var = cv3.e;
        this.zbe = cv3Var;
        this.zbg = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002င\u0000\u0003\u001a", new Object[]{"zbd", "zbe", dp3.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new df3();
        }
        if (i2 == 4) {
            return new cw3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
