package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class if3 extends gu3 {
    private static final if3 zbb;
    private int zbd;
    private tr3 zbf;
    private byte zbg = 2;
    private mu3 zbe = cv3.e;

    static {
        if3 if3Var = new if3();
        zbb = if3Var;
        gu3.d(if3.class, if3Var);
    }

    public static if3 p() {
        return zbb;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000", new Object[]{"zbd", "zbe", hf3.class, "zbf"});
        }
        if (i2 == 3) {
            return new if3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final tr3 o() {
        tr3 tr3Var = this.zbf;
        return tr3Var == null ? tr3.t() : tr3Var;
    }
}
