package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yg3 extends gu3 {
    private static final yg3 zbb;
    private int zbd;
    private mu3 zbe = cv3.e;
    private xg3 zbf;
    private float zbg;
    private int zbh;
    private boolean zbi;
    private boolean zbj;

    static {
        yg3 yg3Var = new yg3();
        zbb = yg3Var;
        gu3.d(yg3.class, yg3Var);
        wg3 wg3VarO = wg3.o();
        sv3 sv3Var = sv3.c;
        if (wg3VarO != null) {
            return;
        }
        og.i("Null containingTypeDefaultInstance");
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0003\u0003ဉ\u0000\u0004ခ\u0001\u0005ဇ\u0004\u0006᠌\u0002", new Object[]{"zbd", "zbe", xg3.class, "zbi", "zbf", "zbg", "zbj", "zbh", cf3.o});
        }
        if (i2 == 3) {
            return new yg3();
        }
        if (i2 == 4) {
            return new sg3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
