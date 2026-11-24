package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uf3 extends du3 {
    private static final uf3 zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private nf3 zbh;
    private int zbj;
    private int zbk;
    private mu3 zbl;
    private pf3 zbm;
    private String zbn;
    private mu3 zbo;
    private long zbp;
    private byte zbq = 2;
    private String zbi = "";

    static {
        uf3 uf3Var = new uf3();
        zbd = uf3Var;
        gu3.d(uf3.class, uf3Var);
    }

    public uf3() {
        cv3 cv3Var = cv3.e;
        this.zbl = cv3Var;
        this.zbn = "";
        this.zbo = cv3Var;
    }

    public static uf3 o() {
        return zbd;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbq);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0003\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007Л\bᐉ\u0006\tဈ\u0007\n\u001a\u000bဂ\b", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", tf3.class, "zbm", "zbn", "zbo", "zbp"});
        }
        if (i2 == 3) {
            return new uf3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbq = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final mu3 p() {
        return this.zbl;
    }
}
