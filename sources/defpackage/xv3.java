package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xv3 extends gu3 {
    private static final xv3 zbb;
    private int zbd;
    private nw3 zbe;
    private mu3 zbf;
    private mu3 zbg;

    static {
        xv3 xv3Var = new xv3();
        zbb = xv3Var;
        gu3.d(xv3.class, xv3Var);
    }

    public xv3() {
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
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", vw3.class, "zbg", vv3.class});
        }
        if (i2 == 3) {
            return new xv3();
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
