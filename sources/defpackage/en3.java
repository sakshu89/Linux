package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class en3 extends gu3 {
    private static final en3 zbb;
    private int zbd;
    private xn3 zbe;
    private ar3 zbf;
    private yk3 zbg;
    private un3 zbh;
    private in3 zbi;
    private gn3 zbj;
    private sn3 zbk;
    private byte zbl = 2;

    static {
        en3 en3Var = new en3();
        zbb = en3Var;
        gu3.d(en3.class, en3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbl);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new en3();
        }
        if (i2 == 4) {
            return new zl3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbl = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
