package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zq3 extends gu3 {
    private static final zq3 zbb;
    private mu3 zbd = cv3.e;

    static {
        zq3 zq3Var = new zq3();
        zbb = zq3Var;
        gu3.d(zq3.class, zq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", yq3.class});
        }
        if (i2 == 3) {
            return new zq3();
        }
        if (i2 == 4) {
            return new sq3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
