package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kf3 extends gu3 {
    private static final kf3 zbb;
    private int zbd;
    private tr3 zbf;
    private float zbg;
    private byte zbh = 2;
    private int zbe = 2;

    static {
        kf3 kf3Var = new kf3();
        zbb = kf3Var;
        gu3.d(kf3.class, kf3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0007\u0003\u0000\u0000\u0001\u0001᠌\u0000\u0002ᐉ\u0001\u0007ခ\u0002", new Object[]{"zbd", "zbe", cf3.d, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new kf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
