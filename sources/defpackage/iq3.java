package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iq3 extends gu3 {
    private static final iq3 zbb;
    private String zbd = "";
    private boolean zbe;

    static {
        iq3 iq3Var = new iq3();
        zbb = iq3Var;
        gu3.d(iq3.class, iq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new iq3();
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
