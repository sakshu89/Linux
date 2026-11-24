package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class il3 extends gu3 {
    private static final il3 zbb;
    private int zbd;
    private Object zbf;
    private nm3 zbg;
    private boolean zbh;
    private zn3 zbi;
    private qn3 zbj;
    private dm3 zbk;
    private int zbl;
    private int zbe = 0;
    private byte zbm = 2;

    static {
        il3 il3Var = new il3();
        zbb = il3Var;
        gu3.d(il3.class, il3Var);
    }

    public static fl3 p() {
        return (fl3) zbb.k();
    }

    public static /* synthetic */ void q(il3 il3Var, qn3 qn3Var) {
        il3Var.zbj = qn3Var;
        il3Var.zbd |= 8;
    }

    public static /* synthetic */ void r(il3 il3Var, nm3 nm3Var) {
        il3Var.zbg = nm3Var;
        il3Var.zbd |= 1;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbm);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\b\u0001\u0001\u0001\b\b\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဉ\u0002\u0005:\u0000\u0006:\u0000\u0007ဉ\u0004\bင\u0005", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbj", "zbi", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new il3();
        }
        if (i2 == 4) {
            return new fl3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbm = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int o() {
        return this.zbl;
    }

    public final boolean s() {
        if (this.zbe == 6) {
            return ((Boolean) this.zbf).booleanValue();
        }
        return false;
    }

    public final boolean t() {
        if (this.zbe == 5) {
            return ((Boolean) this.zbf).booleanValue();
        }
        return false;
    }

    public final boolean u() {
        return (this.zbd & 32) != 0;
    }
}
