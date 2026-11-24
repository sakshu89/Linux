package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hf3 extends gu3 {
    private static final hf3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private byte zbg = 2;

    static {
        hf3 hf3Var = new hf3();
        zbb = hf3Var;
        gu3.d(hf3.class, hf3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new hf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
