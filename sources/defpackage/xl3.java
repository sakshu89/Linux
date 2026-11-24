package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xl3 extends gu3 {
    private static final xl3 zbb;
    private int zbd;
    private int zbe;
    private int zbf = 2;
    private String zbg = "";

    static {
        xl3 xl3Var = new xl3();
        zbb = xl3Var;
        gu3.d(xl3.class, xl3Var);
    }

    public static vl3 o() {
        return (vl3) zbb.k();
    }

    public static /* synthetic */ void p(xl3 xl3Var, int i) {
        xl3Var.zbe = i - 1;
        xl3Var.zbd |= 1;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", cf3.x, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new xl3();
        }
        if (i2 == 4) {
            return new vl3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
