package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vq3 extends gu3 {
    private static final vq3 zbb;
    private int zbd;
    private String zbe = "";
    private float zbf;
    private mu3 zbg;
    private mu3 zbh;

    static {
        vq3 vq3Var = new vq3();
        zbb = vq3Var;
        gu3.d(vq3.class, vq3Var);
    }

    public vq3() {
        cv3 cv3Var = cv3.e;
        this.zbg = cv3Var;
        this.zbh = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0004\u0005\u0000\u0000\u0001\u007f\u0005\u0000\u0002\u0000\u0001\f\u0002Ȉ\u0003\u0001\u0004Ț\u007fȚ", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new vq3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
