package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mi3 extends gu3 {
    private static final mi3 zbb;
    private int zbd = 0;
    private Object zbe;
    private float zbf;

    static {
        mi3 mi3Var = new mi3();
        zbb = mi3Var;
        gu3.d(mi3.class, mi3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001?\u0000\u0002Ȼ\u0000\u0003\u0001\u0004<\u0000", new Object[]{"zbe", "zbd", "zbf", ni3.class});
        }
        if (i2 == 3) {
            return new mi3();
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
