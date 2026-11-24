package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ui3 extends gu3 {
    private static final ui3 zbb;
    private int zbd;
    private int zbe;
    private boolean zbh;
    private int zbf = 100;
    private int zbg = -100;
    private float zbi = 40.0f;

    static {
        ui3 ui3Var = new ui3();
        zbb = ui3Var;
        gu3.d(ui3.class, ui3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new ui3();
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
