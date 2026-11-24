package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class am3 extends du3 {
    private static final am3 zbd;
    private pw3 zbA;
    private kp3 zbC;
    private zo3 zbD;
    private ep3 zbE;
    private yw3 zbF;
    private uf3 zbG;
    private pt3 zbH;
    private zq3 zbJ;
    private es3 zbK;
    private pi3 zbL;
    private pi3 zbM;
    private pi3 zbN;
    private int zbe;
    private int zbf;
    private long zbg;
    private do3 zbh;
    private kp3 zbi;
    private zo3 zbj;
    private vo3 zbk;
    private int zbl;
    private gg3 zbm;
    private at3 zbn;
    private ng3 zbo;
    private hp3 zbp;
    private en3 zbq;
    private yl3 zbr;
    private ol3 zbs;
    private yi3 zbt;
    private qm3 zbu;
    private boolean zbv;
    private ik3 zbw;
    private vh3 zbx;
    private ch3 zby;
    private xk3 zbz;
    private byte zbO = 2;
    private mu3 zbB = cv3.e;
    private String zbI = "";

    static {
        am3 am3Var = new am3();
        zbd = am3Var;
        gu3.d(am3.class, am3Var);
    }

    public static am3 o() {
        return zbd;
    }

    public static am3 p(byte[] bArr, ut3 ut3Var) {
        return (am3) gu3.m(zbd, bArr, ut3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbO);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\"\u0000\u0002\u0001'\"\u0000\u0001\t\u0001ဂ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006᠌\u0005\u0007ᐉ\u0006\bᐉ\u0007\tᐉ\b\nဉ\t\u000bᐉ\n\fဉ\u000e\rဉ\u000b\u000eဉ\r\u0010ဇ\u000f\u0011ဉ\u0010\u0012ဉ\f\u0013ᐉ\u0011\u0014ဉ\u0012\u0015ᐉ\u0013\u0016ဉ\u0014\u0018\u001b\u0019ဉ\u0017\u001aဉ\u0018\u001bᐉ\u0015\u001eဉ\u0016\u001fᐉ\u0019!ဉ\u001a\"ဈ\u001b#ဉ\u001c$ဉ\u001d%ဉ\u001e&ဉ\u001f'ဉ ", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", cf3.E, "zbm", "zbn", "zbo", "zbp", "zbq", "zbu", "zbr", "zbt", "zbv", "zbw", "zbs", "zbx", "zby", "zbz", "zbA", "zbB", hm3.class, "zbE", "zbF", "zbC", "zbD", "zbG", "zbH", "zbI", "zbJ", "zbK", "zbL", "zbM", "zbN"});
        }
        if (i2 == 3) {
            return new am3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbO = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final uf3 q() {
        uf3 uf3Var = this.zbG;
        return uf3Var == null ? uf3.o() : uf3Var;
    }
}
