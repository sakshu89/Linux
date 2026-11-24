package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fg3 extends du3 {
    private static final fg3 zbd;
    private int zbe;
    private bg3 zbf;
    private mu3 zbg;
    private float zbh;
    private float zbi;
    private float zbj;
    private float zbk;
    private float zbl;
    private mu3 zbm;
    private mu3 zbn;
    private long zbo;
    private long zbp;
    private long zbq;
    private float zbr;
    private dg3 zbs;
    private byte zbt = 2;

    static {
        fg3 fg3Var = new fg3();
        zbd = fg3Var;
        gu3.d(fg3.class, fg3Var);
    }

    public fg3() {
        cv3 cv3Var = cv3.e;
        this.zbg = cv3Var;
        this.zbm = cv3Var;
        this.zbn = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbt);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005\u000eဉ\n", new Object[]{"zbe", "zbf", "zbg", eg3.class, "zbh", "zbi", "zbj", "zbk", "zbm", cg3.class, "zbn", zf3.class, "zbp", "zbr", "zbq", "zbo", "zbl", "zbs"});
        }
        if (i2 == 3) {
            return new fg3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbt = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
