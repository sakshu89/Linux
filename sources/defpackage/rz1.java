package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rz1 extends yt0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final rz1 DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile mu1 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        rz1 rz1Var = new rz1();
        DEFAULT_INSTANCE = rz1Var;
        yt0.j(rz1.class, rz1Var);
    }

    public static qz1 D() {
        return (qz1) ((wt0) DEFAULT_INSTANCE.c(5));
    }

    public static void l(rz1 rz1Var, long j) {
        rz1Var.valueCase_ = 4;
        rz1Var.value_ = Long.valueOf(j);
    }

    public static void m(rz1 rz1Var, String str) {
        rz1Var.getClass();
        rz1Var.valueCase_ = 5;
        rz1Var.value_ = str;
    }

    public static void n(rz1 rz1Var, pz1 pz1Var) {
        rz1Var.getClass();
        rz1Var.value_ = pz1Var;
        rz1Var.valueCase_ = 6;
    }

    public static void o(rz1 rz1Var, double d) {
        rz1Var.valueCase_ = 7;
        rz1Var.value_ = Double.valueOf(d);
    }

    public static void p(rz1 rz1Var, no noVar) {
        rz1Var.getClass();
        rz1Var.valueCase_ = 8;
        rz1Var.value_ = noVar;
    }

    public static void q(rz1 rz1Var, boolean z) {
        rz1Var.valueCase_ = 1;
        rz1Var.value_ = Boolean.valueOf(z);
    }

    public static void r(rz1 rz1Var, float f) {
        rz1Var.valueCase_ = 2;
        rz1Var.value_ = Float.valueOf(f);
    }

    public static void s(rz1 rz1Var, int i) {
        rz1Var.valueCase_ = 3;
        rz1Var.value_ = Integer.valueOf(i);
    }

    public static rz1 v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public final pz1 B() {
        return this.valueCase_ == 6 ? (pz1) this.value_ : pz1.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    @Override // defpackage.yt0
    public final Object c(int i) {
        mu1 xt0Var;
        switch (cq.x(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new v22(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", pz1.class});
            case 3:
                return new rz1();
            case 4:
                return new qz1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                mu1 mu1Var = PARSER;
                if (mu1Var != null) {
                    return mu1Var;
                }
                synchronized (rz1.class) {
                    try {
                        xt0Var = PARSER;
                        if (xt0Var == null) {
                            xt0Var = new xt0();
                            PARSER = xt0Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return xt0Var;
            default:
                dk0.p();
                return null;
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final no u() {
        return this.valueCase_ == 8 ? (no) this.value_ : no.c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
