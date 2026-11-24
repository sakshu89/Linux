package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dj3 extends gu3 {
    private static final dj3 zbb;
    private String zbd = "";
    private String zbe = "";
    private double zbf;

    static {
        dj3 dj3Var = new dj3();
        zbb = dj3Var;
        gu3.d(dj3.class, dj3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0000\u0003Ȉ", new Object[]{"zbd", "zbf", "zbe"});
        }
        if (i2 == 3) {
            return new dj3();
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
