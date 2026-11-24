package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class as3 extends gu3 {
    private static final as3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private String zbh = "";

    static {
        as3 as3Var = new as3();
        zbb = as3Var;
        gu3.d(as3.class, as3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဏ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", xm3.r, "zbf", xm3.q, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new as3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
