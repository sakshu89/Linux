package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dn3 extends gu3 {
    private static final dn3 zbb;
    private int zbd;
    private int zbe;
    private nh3 zbf;
    private fp3 zbg;
    private tm3 zbh;
    private uv3 zbi;
    private byte zbj = 2;

    static {
        dn3 dn3Var = new dn3();
        zbb = dn3Var;
        gu3.d(dn3.class, dn3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ဉ\u0002\u0002ဉ\u0003\u0003᠌\u0000\u0004ဉ\u0004\u0005ᐉ\u0001", new Object[]{"zbd", "zbg", "zbh", "zbe", xm3.c, "zbi", "zbf"});
        }
        if (i2 == 3) {
            return new dn3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbj = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
