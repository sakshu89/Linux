package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ip3 extends gu3 {
    private static final ip3 zbb;
    private int zbd;
    private ju3 zbe = yt3.e;
    private rt3 zbf = rt3.b;

    static {
        ip3 ip3Var = new ip3();
        zbb = ip3Var;
        gu3.d(ip3.class, ip3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001$\u0002ည\u0000", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new ip3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
