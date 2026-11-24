package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hn3 extends gu3 {
    private static final hn3 zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private mu3 zbg = cv3.e;

    static {
        hn3 hn3Var = new hn3();
        zbb = hn3Var;
        gu3.d(hn3.class, hn3Var);
    }

    public static hn3 p(byte[] bArr, ut3 ut3Var) {
        return (hn3) gu3.m(zbb, bArr, ut3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", kg3.class});
        }
        if (i2 == 3) {
            return new hn3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }

    public final int o() {
        return this.zbe;
    }

    public final String q() {
        return this.zbf;
    }

    public final mu3 r() {
        return this.zbg;
    }
}
