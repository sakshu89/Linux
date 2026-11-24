package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qq3 extends gu3 {
    private static final qq3 zbb;
    private int zbd;
    private mu3 zbf;
    private mu3 zbg;
    private mu3 zbh;
    private mu3 zbi;
    private rq3 zbj;
    private byte zbk = 2;
    private String zbe = "";

    static {
        qq3 qq3Var = new qq3();
        zbb = qq3Var;
        gu3.d(qq3.class, qq3Var);
    }

    public qq3() {
        cv3 cv3Var = cv3.e;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
        this.zbh = cv3Var;
        this.zbi = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbj", "zbg", "zbi"});
        }
        if (i2 == 3) {
            return new qq3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbk = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
