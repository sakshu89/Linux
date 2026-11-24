package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tf3 extends du3 {
    private static final tf3 zbd;
    private int zbD;
    private mf3 zbE;
    private ff3 zbF;
    private int zbG;
    private int zbe;
    private jf3 zbh;
    private nf3 zbi;
    private int zbk;
    private sr3 zbl;
    private float zbm;
    private float zbn;
    private float zbo;
    private float zbp;
    private float zbq;
    private pf3 zbs;
    private kf3 zbu;
    private rf3 zbv;
    private sf3 zbw;
    private int zbx;
    private long zby;
    private mt3 zbz;
    private byte zbH = 2;
    private int zbf = -1;
    private ku3 zbg = hu3.e;
    private int zbj = 2;
    private String zbr = "";
    private String zbt = "";
    private String zbA = "";
    private mu3 zbB = cv3.e;
    private ju3 zbC = yt3.e;

    static {
        tf3 tf3Var = new tf3();
        zbd = tf3Var;
        gu3.d(tf3.class, tf3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbH);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u001c\u0000\u0001\u0001 \u001c\u0000\u0003\u0005\u0001င\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဉ\u0005\u0007ခ\t\bဈ\u000b\rᐉ\f\u000eခ\u0006\u000fဈ\r\u0010ᐉ\u000e\u0011ဉ\u000f\u0012ဉ\u0010\u0013င\u0011\u0014ဂ\u0012\u0015ဉ\u0013\u0016ခ\b\u0017ဈ\u0014\u0018\u001a\u0019\u0013\u001aင\u0015\u001bခ\u0007\u001cဉ\u0016\u001d'\u001eᐉ\u0017\u001fခ\n င\u0018", new Object[]{"zbe", "zbf", "zbh", "zbi", "zbj", cf3.g, "zbk", cf3.f, "zbl", "zbp", "zbr", "zbs", "zbm", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbz", "zbo", "zbA", "zbB", "zbC", "zbD", "zbn", "zbE", "zbg", "zbF", "zbq", "zbG"});
        }
        if (i2 == 3) {
            return new tf3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbH = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String o() {
        return this.zbt;
    }

    public final int p() {
        int iC = dg4.c(this.zbj);
        if (iC == 0) {
            return 3;
        }
        return iC;
    }

    public final float q() {
        return this.zbp;
    }

    public final int r() {
        return this.zbf;
    }

    public final jf3 s() {
        jf3 jf3Var = this.zbh;
        return jf3Var == null ? jf3.s() : jf3Var;
    }

    public final pf3 t() {
        pf3 pf3Var = this.zbs;
        return pf3Var == null ? pf3.o() : pf3Var;
    }
}
