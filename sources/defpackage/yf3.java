package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yf3 extends gu3 {
    private static final yf3 zbb;
    private mu3 zbd;
    private mu3 zbe;

    static {
        yf3 yf3Var = new yf3();
        zbb = yf3Var;
        gu3.d(yf3.class, yf3Var);
    }

    public yf3() {
        cv3 cv3Var = cv3.e;
        this.zbd = cv3Var;
        this.zbe = cv3Var;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zbd", xf3.class, "zbe", og3.class});
        }
        if (i2 == 3) {
            return new yf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
