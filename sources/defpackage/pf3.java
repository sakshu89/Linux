package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pf3 extends gu3 {
    private static final pf3 zbb;
    private byte zbe = 2;
    private mu3 zbd = cv3.e;

    static {
        pf3 pf3Var = new pf3();
        zbb = pf3Var;
        gu3.d(pf3.class, pf3Var);
    }

    public static pf3 o() {
        return zbb;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", of3.class});
        }
        if (i2 == 3) {
            return new pf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbe = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final mu3 p() {
        return this.zbd;
    }
}
