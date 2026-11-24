package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pm3 extends gu3 {
    private static final pm3 zbb;
    private int zbd;
    private String zbe = "";
    private int zbf;
    private float zbg;
    private long zbh;
    private boolean zbi;
    private float zbj;
    private float zbk;
    private long zbl;
    private int zbm;
    private long zbn;

    static {
        pm3 pm3Var = new pm3();
        zbb = pm3Var;
        gu3.d(pm3.class, pm3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ခ\u0002\u0004ဂ\u0003\u0005ဇ\u0004\u0006ခ\u0005\u0007ခ\u0006\bဂ\u0007\tင\b\nဂ\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn"});
        }
        if (i2 == 3) {
            return new pm3();
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
