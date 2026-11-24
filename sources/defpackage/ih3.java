package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ih3 extends gu3 {
    private static final ih3 zbb;
    private int zbd;
    private int zbf;
    private String zbe = "";
    private ju3 zbg = yt3.e;
    private String zbh = "";
    private mu3 zbi = cv3.e;

    static {
        ih3 ih3Var = new ih3();
        zbb = ih3Var;
        gu3.d(ih3.class, ih3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003$\u0004ဈ\u0002\u0005\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new ih3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
