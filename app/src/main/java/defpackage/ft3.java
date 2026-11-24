package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ft3 extends gu3 {
    private static final ft3 zbb;
    private int zbd;
    private mu3 zbe;
    private mu3 zbf;
    private int zbg;

    static {
        ft3 ft3Var = new ft3();
        zbb = ft3Var;
        gu3.d(ft3.class, ft3Var);
    }

    public ft3() {
        cv3 cv3Var = cv3.e;
        this.zbe = cv3Var;
        this.zbf = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003င\u0000", new Object[]{"zbd", "zbe", gt3.class, "zbf", dt3.class, "zbg"});
        }
        if (i2 == 3) {
            return new ft3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
