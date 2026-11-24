package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pg3 extends du3 {
    private static final pg3 zbd;
    private int zbe;
    private Object zbg;
    private Object zbi;
    private rt3 zbl;
    private vv3 zbm;
    private int zbn;
    private int zbo;
    private boolean zbp;
    private int zbq;
    private rt3 zbr;
    private int zbf = 0;
    private int zbh = 0;
    private byte zbs = 2;
    private String zbj = "FaceAttributesClientBrainEmbedder";
    private String zbk = "";

    static {
        pg3 pg3Var = new pg3();
        zbd = pg3Var;
        gu3.d(pg3.class, pg3Var);
    }

    public pg3() {
        qt3 qt3Var = rt3.b;
        this.zbl = qt3Var;
        this.zbp = true;
        this.zbq = 1;
        this.zbr = qt3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbs);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0004\r\u0002\u0001\u0002\u0010\r\u0000\u0000\u0001\u0002<\u0000\u0003;\u0000\u0004ဇ\u0006\u0005᠌\u0007\u0007м\u0001\b;\u0001\tဈ\u0000\nဈ\u0001\fင\u0004\rဉ\u0003\u000eည\b\u000fည\u0002\u0010င\u0005", new Object[]{"zbg", "zbf", "zbi", "zbh", "zbe", wf3.class, "zbp", "zbq", cf3.n, wg3.class, "zbj", "zbk", "zbn", "zbm", "zbr", "zbl", "zbo"});
        }
        if (i2 == 3) {
            return new pg3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbs = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
