package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mk3 extends gu3 {
    private static final mk3 zbb;
    private Object zbe;
    private int zbd = 0;
    private byte zbg = 2;
    private mu3 zbf = cv3.e;

    static {
        mk3 mk3Var = new mk3();
        zbb = mk3Var;
        gu3.d(mk3.class, mk3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0001\u0001:\u0000\u0003Л", new Object[]{"zbe", "zbd", "zbf", pg3.class});
        }
        if (i2 == 3) {
            return new mk3();
        }
        if (i2 == 4) {
            return new jk3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
