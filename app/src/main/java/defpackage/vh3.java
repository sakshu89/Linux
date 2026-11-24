package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vh3 extends gu3 {
    private static final vh3 zbb;
    private int zbd;
    private long zbe;
    private int zbh;
    private int zbi;
    private mu3 zbj;
    private String zbk;
    private sh3 zbl;
    private rt3 zbm;
    private ai3 zbn;
    private String zbo;
    private mu3 zbp;
    private mu3 zbq;
    private rt3 zbr;
    private String zbs;
    private byte zbt = 2;
    private String zbf = "";
    private String zbg = "";

    static {
        vh3 vh3Var = new vh3();
        zbb = vh3Var;
        gu3.d(vh3.class, vh3Var);
    }

    public vh3() {
        cv3 cv3Var = cv3.e;
        this.zbj = cv3Var;
        this.zbk = "";
        qt3 qt3Var = rt3.b;
        this.zbm = qt3Var;
        this.zbo = "";
        this.zbp = cv3Var;
        this.zbq = cv3Var;
        this.zbr = qt3Var;
        this.zbs = "";
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbt);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u000f\u0000\u0001\u0001\u001c\u000f\u0000\u0003\u0004\u0001ᔂ\u0000\u0002б\u0010ဈ\u0001\u0011ဈ\u0002\u0012င\u0003\u0013င\u0004\u0014\u001a\u0015ဈ\u0005\u0016ည\u0007\u0017ᐉ\b\u0018ᐉ\u0006\u0019ည\n\u001aဈ\t\u001bဈ\u000b\u001c\u001b", new Object[]{"zbd", "zbe", "zbp", uh3.class, "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbl", "zbr", "zbo", "zbs", "zbq", th3.class});
        }
        if (i2 == 3) {
            return new vh3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbt = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
