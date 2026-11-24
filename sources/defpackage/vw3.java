package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vw3 extends gu3 {
    private static final vw3 zbb;
    private int zbd;
    private int zbf;
    private boolean zbh;
    private mu3 zbj;
    private mu3 zbk;
    private mu3 zbl;
    private int zbm;
    private String zbe = "";
    private String zbg = "";
    private String zbi = "";

    static {
        vw3 vw3Var = new vw3();
        zbb = vw3Var;
        gu3.d(vw3.class, vw3Var);
    }

    public vw3() {
        cv3 cv3Var = cv3.e;
        this.zbj = cv3Var;
        this.zbk = cv3Var;
        this.zbl = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0003\u0000\u0001ဈ\u0000\u0002င\u0001\u0003\u001a\u0004\u001b\u0006ဈ\u0002\u0007ဇ\u0003\bဈ\u0004\t\u001a\nင\u0005", new Object[]{"zbd", "zbe", "zbf", "zbj", "zbk", tw3.class, "zbg", "zbh", "zbi", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new vw3();
        }
        if (i2 == 4) {
            return new cw3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
