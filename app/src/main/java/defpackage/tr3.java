package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tr3 extends gu3 {
    private static final tr3 zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private float zbi;
    private byte zbj = 2;

    static {
        tr3 tr3Var = new tr3();
        zbb = tr3Var;
        gu3.d(tr3.class, tr3Var);
    }

    public static tr3 t() {
        return zbb;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003\u0005ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new tr3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbj = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final float o() {
        return this.zbi;
    }

    public final int p() {
        return this.zbh;
    }

    public final int q() {
        return this.zbe;
    }

    public final int r() {
        return this.zbf;
    }

    public final int s() {
        return this.zbg;
    }
}
