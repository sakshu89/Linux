package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uh3 extends gu3 {
    private static final uh3 zbb;
    private int zbd;
    private int zbe;
    private int zbg;
    private boolean zbh;
    private byte zbi = 2;
    private mu3 zbf = cv3.e;

    static {
        uh3 uh3Var = new uh3();
        zbb = uh3Var;
        gu3.d(uh3.class, uh3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0004\u0000\u0001\u0003\u0006\u0004\u0000\u0001\u0002\u0003ᔄ\u0000\u0004Л\u0005င\u0001\u0006ဇ\u0002", new Object[]{"zbd", "zbe", "zbf", wh3.class, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new uh3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
