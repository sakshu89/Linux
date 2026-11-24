package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jg3 extends gu3 {
    private static final jg3 zbb;
    private int zbd;
    private int zbe;
    private rt3 zbf = rt3.b;
    private float zbg;

    static {
        jg3 jg3Var = new jg3();
        zbb = jg3Var;
        gu3.d(jg3.class, jg3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new jg3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
