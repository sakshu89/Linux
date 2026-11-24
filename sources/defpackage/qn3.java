package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qn3 extends gu3 {
    private static final qn3 zbb;
    private int zbd;
    private int zbe = 1;
    private boolean zbf;

    static {
        qn3 qn3Var = new qn3();
        zbb = qn3Var;
        gu3.d(qn3.class, qn3Var);
    }

    public static pn3 o() {
        return (pn3) zbb.k();
    }

    public static /* synthetic */ void p(qn3 qn3Var) {
        qn3Var.zbe = 1;
        qn3Var.zbd = 1 | qn3Var.zbd;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zbd", "zbe", xm3.j, "zbf"});
        }
        if (i2 == 3) {
            return new qn3();
        }
        if (i2 == 4) {
            return new pn3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
