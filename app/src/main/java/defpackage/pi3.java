package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pi3 extends gu3 {
    private static final pi3 zbb;
    private mu3 zbd;
    private mu3 zbe;
    private mu3 zbf;
    private mu3 zbg;

    static {
        pi3 pi3Var = new pi3();
        zbb = pi3Var;
        gu3.d(pi3.class, pi3Var);
    }

    public pi3() {
        cv3 cv3Var = cv3.e;
        this.zbd = cv3Var;
        this.zbe = cv3Var;
        this.zbf = cv3Var;
        this.zbg = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zbd", ii3.class, "zbe", ci3.class, "zbf", ri3.class, "zbg", oi3.class});
        }
        if (i2 == 3) {
            return new pi3();
        }
        if (i2 == 4) {
            return new zh3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
