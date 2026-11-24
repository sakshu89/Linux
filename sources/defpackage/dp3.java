package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dp3 extends gu3 {
    private static final dp3 zbb;
    private int zbd;
    private cp3 zbg;
    private no3 zbh;
    private no3 zbi;
    private yj3 zbj;
    private float zbm;
    private mu3 zbn;
    private mu3 zbo;
    private boolean zbp;
    private vv3 zbq;
    private int zbr;
    private String zbe = "";
    private String zbf = "";
    private String zbk = "en";
    private int zbl = -1;

    static {
        dp3 dp3Var = new dp3();
        zbb = dp3Var;
        gu3.d(dp3.class, dp3Var);
    }

    public dp3() {
        cv3 cv3Var = cv3.e;
        this.zbn = cv3Var;
        this.zbo = cv3Var;
        this.zbr = -1;
    }

    public static bp3 o() {
        return (bp3) zbb.k();
    }

    public static /* synthetic */ void p(dp3 dp3Var) {
        dp3Var.zbd |= 1;
        dp3Var.zbe = "PassThroughCoarseClassifier";
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0007\u0003ခ\b\u0004\u001a\u0005\u001a\u0006ဉ\u0002\bဇ\t\tဉ\n\nဉ\u0003\u000bဈ\u0006\fဉ\u0004\rင\u000b\u000eဉ\u0005\u000fဈ\u0001", new Object[]{"zbd", "zbe", "zbl", "zbm", "zbn", "zbo", "zbg", "zbp", "zbq", "zbh", "zbk", "zbi", "zbr", "zbj", "zbf"});
        }
        if (i2 == 3) {
            return new dp3();
        }
        if (i2 == 4) {
            return new bp3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
