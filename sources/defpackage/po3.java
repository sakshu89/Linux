package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class po3 extends gu3 {
    private static final po3 zbb;
    private int zbd;
    private Object zbf;
    private boolean zbg;
    private long zbi;
    private float zbm;
    private float zbn;
    private float zbo;
    private int zbe = 0;
    private byte zbp = 2;
    private mu3 zbh = cv3.e;
    private boolean zbj = true;
    private ju3 zbk = yt3.e;
    private float zbl = 0.15f;

    static {
        po3 po3Var = new po3();
        zbb = po3Var;
        gu3.d(po3.class, po3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbp);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0001\u0001\u0002\r\n\u0000\u0002\u0001\u0002м\u0000\u0003ဇ\u0000\u0004\u001b\u0005\u0013\u0006ခ\u0003\u0007ခ\u0004\bခ\u0005\u000bခ\u0006\fဂ\u0001\rဇ\u0002", new Object[]{"zbf", "zbe", "zbd", yo3.class, "zbg", "zbh", mo3.class, "zbk", "zbl", "zbm", "zbn", "zbo", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new po3();
        }
        if (i2 == 4) {
            return new kn3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbp = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
