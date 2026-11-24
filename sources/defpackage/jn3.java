package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jn3 extends gu3 {
    private static final jn3 zbb;
    private int zbd;
    private String zbe = "";
    private mu3 zbf;
    private mu3 zbg;
    private mu3 zbh;
    private tk3 zbi;
    private nq3 zbj;

    static {
        jn3 jn3Var = new jn3();
        zbb = jn3Var;
        gu3.d(jn3.class, jn3Var);
    }

    public jn3() {
        cv3 cv3Var = cv3.e;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
        this.zbh = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဉ\u0001\u0004\u001a\u0005ဉ\u0002\u0006\u001a", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbj", "zbg"});
        }
        if (i2 == 3) {
            return new jn3();
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
