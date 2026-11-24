package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class si3 extends gu3 {
    private static final si3 zbb;
    private int zbd;
    private boolean zbg;
    private boolean zbo;
    private float zbe = 0.05f;
    private float zbf = 0.5f;
    private int zbh = 10;
    private int zbi = 200;
    private float zbj = 0.8f;
    private int zbk = 4;
    private int zbl = 10;
    private float zbm = 0.2f;
    private float zbn = 0.1f;

    static {
        si3 si3Var = new si3();
        zbb = si3Var;
        gu3.d(si3.class, si3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0006\u0006င\u0007\u0007ခ\b\bခ\t\tဇ\n\nခ\u0005\u000bဇ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbi", "zbk", "zbl", "zbm", "zbn", "zbo", "zbj", "zbg"});
        }
        if (i2 == 3) {
            return new si3();
        }
        if (i2 == 4) {
            return new zh3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
