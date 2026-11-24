package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ks3 extends gu3 {
    private static final ks3 zbb;
    private int zbd;
    private ls3 zbe;
    private float zbf;
    private byte zbh = 2;
    private ju3 zbg = yt3.e;

    static {
        ks3 ks3Var = new ks3();
        zbb = ks3Var;
        gu3.d(ks3.class, ks3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ခ\u0001\u0003\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new ks3();
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
