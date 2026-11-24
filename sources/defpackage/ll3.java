package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ll3 extends gu3 {
    private static final ll3 zbb;
    private int zbd;
    private float zbf;
    private int zbi;
    private float zbj;
    private mu3 zbe = cv3.e;
    private boolean zbg = true;
    private float zbh = 0.8f;

    static {
        ll3 ll3Var = new ll3();
        zbb = ll3Var;
        gu3.d(ll3.class, ll3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001a\u0002ခ\u0000\u0003ဇ\u0001\u0004ခ\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new ll3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
