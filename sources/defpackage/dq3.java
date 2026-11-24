package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dq3 extends gu3 {
    private static final dq3 zbb;
    private mu3 zbd = cv3.e;

    static {
        dq3 dq3Var = new dq3();
        zbb = dq3Var;
        gu3.d(dq3.class, dq3Var);
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", cq3.class});
        }
        if (i2 == 3) {
            return new dq3();
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
