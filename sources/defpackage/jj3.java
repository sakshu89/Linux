package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jj3 extends gu3 {
    private static final jj3 zbb;
    private int zbd = 0;
    private Object zbe;

    static {
        jj3 jj3Var = new jj3();
        zbb = jj3Var;
        gu3.d(jj3.class, jj3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zbe", "zbd", kj3.class, mj3.class});
        }
        if (i2 == 3) {
            return new jj3();
        }
        if (i2 == 4) {
            return new fj3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
