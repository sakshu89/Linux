package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jp3 extends du3 {
    private static final jp3 zbd;
    private int zbe;
    private long zbf;
    private eo3 zbg;
    private ho3 zbh;
    private byte zbj = 2;
    private mu3 zbi = cv3.e;

    static {
        jp3 jp3Var = new jp3();
        zbd = jp3Var;
        gu3.d(jp3.class, jp3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zbe", "zbf", "zbg", "zbi", io3.class, "zbh"});
        }
        if (i2 == 3) {
            return new jp3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbj = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
