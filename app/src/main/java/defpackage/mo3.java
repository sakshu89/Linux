package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mo3 extends gu3 {
    private static final mo3 zbb;
    private int zbd;
    private Object zbf;
    private float zbg;
    private boolean zbi;
    private int zbe = 0;
    private String zbh = "";

    static {
        mo3 mo3Var = new mo3();
        zbb = mo3Var;
        gu3.d(mo3.class, mo3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002ခ\u0000\u0003;\u0000\u0004ဈ\u0001\u0005ဇ\u0002", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new mo3();
        }
        if (i2 == 4) {
            return new kn3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
