package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tq3 extends gu3 {
    private static final tq3 zbb;
    private int zbd;
    private mu3 zbf;
    private mu3 zbg;
    private kq3 zbh;
    private byte zbi = 2;
    private String zbe = "";

    static {
        tq3 tq3Var = new tq3();
        zbb = tq3Var;
        gu3.d(tq3.class, tq3Var);
    }

    public tq3() {
        cv3 cv3Var = cv3.e;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0002\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001Ϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new tq3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
