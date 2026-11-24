package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ek3 extends gu3 {
    private static final ek3 zbb;
    private int zbd;
    private String zbe = "";
    private mu3 zbf;
    private mu3 zbg;
    private long zbh;

    static {
        ek3 ek3Var = new ek3();
        zbb = ek3Var;
        gu3.d(ek3.class, ek3Var);
    }

    public ek3() {
        cv3 cv3Var = cv3.e;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001a\u0003\u001b\u0004ဂ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg", gk3.class, "zbh"});
        }
        if (i2 == 3) {
            return new ek3();
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
