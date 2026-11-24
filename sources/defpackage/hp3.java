package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hp3 extends gu3 {
    private static final hp3 zbb;
    private int zbd;
    private mu3 zbe = cv3.e;
    private String zbf = "";

    static {
        hp3 hp3Var = new hp3();
        zbb = hp3Var;
        gu3.d(hp3.class, hp3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zbd", "zbe", gp3.class, "zbf"});
        }
        if (i2 == 3) {
            return new hp3();
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
