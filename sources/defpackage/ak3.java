package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ak3 extends gu3 {
    private static final ak3 zbb;
    private int zbd;
    private String zbe = "en";
    private int zbf = -1;
    private float zbg;
    private mu3 zbh;
    private mu3 zbi;

    static {
        ak3 ak3Var = new ak3();
        zbb = ak3Var;
        gu3.d(ak3.class, ak3Var);
    }

    public ak3() {
        cv3 cv3Var = cv3.e;
        this.zbh = cv3Var;
        this.zbi = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ခ\u0002\u0004\u001a\u0005\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new ak3();
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
