package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kk3 extends gu3 {
    private static final kk3 zbb;
    private int zbd;
    private int zbe;

    static {
        kk3 kk3Var = new kk3();
        zbb = kk3Var;
        gu3.d(kk3.class, kk3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new kk3();
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
