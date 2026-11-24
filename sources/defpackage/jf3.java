package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jf3 extends gu3 {
    private static final jf3 zbb;
    private Object zbe;
    private int zbd = 0;
    private byte zbf = 2;

    static {
        jf3 jf3Var = new jf3();
        zbb = jf3Var;
        gu3.d(jf3.class, jf3Var);
    }

    public static jf3 s() {
        return zbb;
    }

    @Override // defpackage.gu3
    public final Object i(int i, gu3 gu3Var) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbf);
        }
        if (i2 == 2) {
            return new dv3(zbb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0003\u0001м\u0000\u0002м\u0000\u0003м\u0000", new Object[]{"zbe", "zbd", if3.class, tr3.class, rr3.class});
        }
        if (i2 == 3) {
            return new jf3();
        }
        if (i2 == 4) {
            return new gf3(zbb);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbf = gu3Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final boolean o() {
        return this.zbd == 1;
    }

    public final rr3 p() {
        return this.zbd == 3 ? (rr3) this.zbe : rr3.o();
    }

    public final tr3 q() {
        return this.zbd == 2 ? (tr3) this.zbe : tr3.t();
    }

    public final if3 r() {
        return this.zbd == 1 ? (if3) this.zbe : if3.p();
    }

    public final boolean t() {
        return this.zbd == 3;
    }
}
