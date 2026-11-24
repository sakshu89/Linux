package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kp3 extends gu3 {
    private static final kp3 zbb;
    private byte zbe = 2;
    private mu3 zbd = cv3.e;

    static {
        kp3 kp3Var = new kp3();
        zbb = kp3Var;
        gu3.d(kp3.class, kp3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", jp3.class});
        }
        if (i2 == 3) {
            return new kp3();
        }
        if (i2 == 4) {
            return new so3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbe = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
