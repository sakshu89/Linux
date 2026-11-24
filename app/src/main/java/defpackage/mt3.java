package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mt3 extends gu3 {
    private static final mt3 zbb;
    private String zbd = "";
    private rt3 zbe = rt3.b;

    static {
        mt3 mt3Var = new mt3();
        zbb = mt3Var;
        gu3.d(mt3.class, mt3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new mt3();
        }
        if (i2 == 4) {
            return new ps3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
