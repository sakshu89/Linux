package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pp4 {
    public static final l42 a(y61 y61Var) {
        y61 y61VarM = y61Var.m();
        return y61VarM != null ? y61VarM.N(y61Var, true) : new l42(0.0f, 0.0f, (int) (y61Var.S() >> 32), (int) (y61Var.S() & 4294967295L));
    }

    public static final l42 b(y61 y61Var, boolean z) {
        y61 y61VarC = c(y61Var);
        float fS = (int) (y61VarC.S() >> 32);
        float fS2 = (int) (y61VarC.S() & 4294967295L);
        l42 l42VarN = y61VarC.N(y61Var, z);
        float f = l42VarN.a;
        if (z) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > fS) {
                f = fS;
            }
        }
        float f2 = l42VarN.b;
        if (z) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > fS2) {
                f2 = fS2;
            }
        }
        float f3 = l42VarN.c;
        if (z) {
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f3 <= fS) {
                fS = f3;
            }
            f3 = fS;
        }
        float f4 = l42VarN.d;
        if (z) {
            float f5 = f4 >= 0.0f ? f4 : 0.0f;
            if (f5 <= fS2) {
                fS2 = f5;
            }
            f4 = fS2;
        }
        if (f == f3 || f2 == f4) {
            return l42.e;
        }
        long jI = y61VarC.i((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        long jI2 = y61VarC.i((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        long jI3 = y61VarC.i((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
        long jI4 = y61VarC.i((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jI >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jI2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jI4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jI3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jI & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jI2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jI4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jI3 & 4294967295L));
        return new l42(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final y61 c(y61 y61Var) {
        y61 y61Var2;
        y61 y61VarM = y61Var.m();
        while (true) {
            y61 y61Var3 = y61VarM;
            y61Var2 = y61Var;
            y61Var = y61Var3;
            if (y61Var == null) {
                break;
            }
            y61VarM = y61Var.m();
        }
        co1 co1Var = y61Var2 instanceof co1 ? (co1) y61Var2 : null;
        if (co1Var == null) {
            return y61Var2;
        }
        co1 co1Var2 = co1Var.X;
        while (true) {
            co1 co1Var3 = co1Var2;
            co1 co1Var4 = co1Var;
            co1Var = co1Var3;
            if (co1Var == null) {
                return co1Var4;
            }
            co1Var2 = co1Var.X;
        }
    }
}
