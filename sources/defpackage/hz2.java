package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hz2 {
    public final gz2 a;
    public y61 b = null;
    public y61 c;

    public hz2(gz2 gz2Var, y61 y61Var) {
        this.a = gz2Var;
        this.c = y61Var;
    }

    public final long a(long j) {
        l42 l42VarN;
        y61 y61Var = this.b;
        l42 l42Var = l42.e;
        if (y61Var != null) {
            if (y61Var.B()) {
                y61 y61Var2 = this.c;
                l42VarN = y61Var2 != null ? y61Var2.N(y61Var, true) : null;
            } else {
                l42VarN = l42Var;
            }
            if (l42VarN != null) {
                l42Var = l42VarN;
            }
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        float fIntBitsToFloat2 = l42Var.a;
        if (fIntBitsToFloat >= fIntBitsToFloat2) {
            float fIntBitsToFloat3 = Float.intBitsToFloat(i);
            fIntBitsToFloat2 = l42Var.c;
            if (fIntBitsToFloat3 <= fIntBitsToFloat2) {
                fIntBitsToFloat2 = Float.intBitsToFloat(i);
            }
        }
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat4 = Float.intBitsToFloat(i2);
        float fIntBitsToFloat5 = l42Var.b;
        if (fIntBitsToFloat4 >= fIntBitsToFloat5) {
            float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
            fIntBitsToFloat5 = l42Var.d;
            if (fIntBitsToFloat6 <= fIntBitsToFloat5) {
                fIntBitsToFloat5 = Float.intBitsToFloat(i2);
            }
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5)) & 4294967295L);
    }

    public final int b(long j, boolean z) {
        if (z) {
            j = a(j);
        }
        return this.a.b.g(d(j));
    }

    public final boolean c(long j) {
        long jD = d(a(j));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & jD));
        gz2 gz2Var = this.a;
        int iE = gz2Var.b.e(fIntBitsToFloat);
        int i = (int) (jD >> 32);
        return Float.intBitsToFloat(i) >= gz2Var.d(iE) && Float.intBitsToFloat(i) <= gz2Var.e(iE);
    }

    public final long d(long j) {
        y61 y61Var;
        y61 y61Var2 = this.b;
        if (y61Var2 != null) {
            if (!y61Var2.B()) {
                y61Var2 = null;
            }
            if (y61Var2 != null && (y61Var = this.c) != null) {
                y61 y61Var3 = y61Var.B() ? y61Var : null;
                if (y61Var3 != null) {
                    return y61Var2.u(y61Var3, j);
                }
            }
        }
        return j;
    }

    public final long e(long j) {
        y61 y61Var;
        y61 y61Var2 = this.b;
        if (y61Var2 != null) {
            if (!y61Var2.B()) {
                y61Var2 = null;
            }
            if (y61Var2 != null && (y61Var = this.c) != null) {
                y61 y61Var3 = y61Var.B() ? y61Var : null;
                if (y61Var3 != null) {
                    return y61Var3.u(y61Var2, j);
                }
            }
        }
        return j;
    }
}
