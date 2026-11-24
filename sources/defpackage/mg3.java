package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mg3 extends du3 {
    private static final mg3 zbd;
    private int zbe;
    private ig3 zbf;
    private mu3 zbg;
    private float zbh;
    private float zbi;
    private mu3 zbj;
    private rt3 zbk;
    private ig3 zbl;
    private fg3 zbm;
    private mu3 zbn;
    private byte zbo = 2;

    static {
        mg3 mg3Var = new mg3();
        zbd = mg3Var;
        gu3.d(mg3.class, mg3Var);
    }

    public mg3() {
        cv3 cv3Var = cv3.e;
        this.zbg = cv3Var;
        this.zbj = cv3Var;
        this.zbk = rt3.b;
        this.zbn = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0003\u0001\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004\u001b\u0005ᐉ\u0005\u0006\u001b\u0007ည\u0003\bဉ\u0004\tခ\u0002", new Object[]{"zbe", "zbf", "zbg", lg3.class, "zbh", "zbj", jg3.class, "zbm", "zbn", hg3.class, "zbk", "zbl", "zbi"});
        }
        if (i2 == 3) {
            return new mg3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbo = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
