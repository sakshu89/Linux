package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ht3 extends gu3 {
    private static final ht3 zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private boolean zbl;
    private float zbm;
    private float zbn;
    private byte zbo = 2;
    private String zbh = "";
    private int zbi = -1;
    private float zbj = -1.0f;
    private float zbk = -1.0f;

    static {
        ht3 ht3Var = new ht3();
        zbb = ht3Var;
        gu3.d(ht3.class, ht3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0001\u0001ᔁ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဈ\u0003\u0005င\u0004\u0007ခ\u0005\bခ\u0006\tဇ\u0007\nခ\b\u000bခ\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn"});
        }
        if (i2 == 3) {
            return new ht3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbo = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
