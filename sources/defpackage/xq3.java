package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xq3 extends gu3 {
    private static final xq3 zbb;
    private int zbd;
    private kq3 zbg;
    private byte zbh = 2;
    private String zbe = "InOrderOutputStreamHandler";
    private mu3 zbf = cv3.e;

    static {
        xq3 xq3Var = new xq3();
        zbb = xq3Var;
        gu3.d(xq3.class, xq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new xq3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
