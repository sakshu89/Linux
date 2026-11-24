package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yk3 extends gu3 {
    private static final yk3 zbb;
    private int zbd;
    private float zbh;
    private byte zbi = 2;
    private String zbe = "";
    private String zbf = "";
    private mu3 zbg = cv3.e;

    static {
        yk3 yk3Var = new yk3();
        zbb = yk3Var;
        gu3.d(yk3.class, yk3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003Л\u0004ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", vs3.class, "zbh"});
        }
        if (i2 == 3) {
            return new yk3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
