package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kq3 extends du3 {
    private static final kq3 zbd;
    private byte zbe = 2;

    static {
        kq3 kq3Var = new kq3();
        zbd = kq3Var;
        gu3.d(kq3.class, kq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return new dv3(zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new kq3();
        }
        if (i2 == 4) {
            return new ef3(zbd);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbe = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
