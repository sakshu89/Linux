package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sw3 extends gu3 {
    private static final sw3 zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";
    private int zbh;
    private int zbi;
    private hw3 zbj;
    private boolean zbk;
    private int zbl;
    private boolean zbm;
    private boolean zbn;
    private boolean zbo;
    private long zbp;

    static {
        sw3 sw3Var = new sw3();
        zbb = sw3Var;
        gu3.d(sw3.class, sw3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", jw3.g, "zbi", "zbj", "zbk", "zbl", jw3.h, "zbm", "zbn", "zbo", "zbp"});
        }
        if (i2 == 3) {
            return new sw3();
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
