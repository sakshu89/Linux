package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tk3 extends gu3 {
    private static final tk3 zbb;
    private int zbA;
    private boolean zbB;
    private sk3 zbC;
    private int zbd;
    private boolean zbg;
    private vr3 zbh;
    private boolean zbi;
    private int zbj;
    private int zbk;
    private boolean zbl;
    private boolean zbm;
    private float zbn;
    private float zbo;
    private boolean zbp;
    private boolean zbq;
    private boolean zbt;
    private int zbu;
    private boolean zbv;
    private boolean zbx;
    private bs3 zby;
    private boolean zbz;
    private String zbe = "";
    private String zbf = "";
    private boolean zbr = true;
    private boolean zbs = true;
    private float zbw = 0.75f;

    static {
        tk3 tk3Var = new tk3();
        zbb = tk3Var;
        gu3.d(tk3.class, tk3Var);
    }

    public static qk3 o() {
        return (qk3) zbb.k();
    }

    public static /* synthetic */ void p(tk3 tk3Var, String str) {
        tk3Var.zbd |= 1;
        tk3Var.zbe = str;
    }

    public static /* synthetic */ void q(tk3 tk3Var, String str) {
        tk3Var.zbd |= 2;
        tk3Var.zbf = str;
    }

    public static /* synthetic */ void r(tk3 tk3Var) {
        tk3Var.zbd |= 4;
        tk3Var.zbg = true;
    }

    public static /* synthetic */ void s(tk3 tk3Var, vr3 vr3Var) {
        tk3Var.zbh = vr3Var;
        tk3Var.zbd |= 8;
    }

    public static /* synthetic */ void t(tk3 tk3Var) {
        tk3Var.zbd |= 16;
        tk3Var.zbi = true;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0019\u0000\u0001\u0001\u001b\u0019\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ခ\t\u0004ဇ\u0007\u0005ခ\n\u0006ဇ\b\bင\u0016\tင\u0006\nဇ\u000b\u000bဇ\f\fဇ\r\rဇ\u000e\u000eဇ\u000f\u000fင\u0010\u0010ဇ\u0011\u0011ခ\u0012\u0012ဇ\u0013\u0013ဉ\u0014\u0014ဇ\u0002\u0015ဉ\u0018\u0016ဇ\u0017\u0017ဉ\u0003\u0018ဇ\u0004\u0019ဇ\u0015\u001bင\u0005", new Object[]{"zbd", "zbe", "zbf", "zbn", "zbl", "zbo", "zbm", "zbA", "zbk", "zbp", "zbq", "zbr", "zbs", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbg", "zbC", "zbB", "zbh", "zbi", "zbz", "zbj"});
        }
        if (i2 == 3) {
            return new tk3();
        }
        if (i2 == 4) {
            return new qk3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
