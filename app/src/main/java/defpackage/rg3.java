package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rg3 extends gu3 {
    private static final rg3 zbb;
    private int zbd;
    private mu3 zbe = cv3.e;
    private String zbf = "";

    static {
        rg3 rg3Var = new rg3();
        zbb = rg3Var;
        gu3.d(rg3.class, rg3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new rg3();
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
