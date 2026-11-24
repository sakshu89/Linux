package defpackage;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jo4 {
    public static final int a(ua1 ua1Var, long j, w73 w73Var) {
        long jA;
        int iE;
        hz2 hz2VarD = ua1Var.d();
        if (hz2VarD != null) {
            fl1 fl1Var = hz2VarD.a.b;
            y61 y61VarC = ua1Var.c();
            if (y61VarC != null && (iE = e(fl1Var, (jA = y61VarC.A(j)), w73Var)) != -1) {
                return fl1Var.g(jp1.a(jA, (fl1Var.b(iE) + fl1Var.f(iE)) / 2.0f, 1));
            }
        }
        return -1;
    }

    public static final long b(ua1 ua1Var, l42 l42Var, l42 l42Var2, int i) {
        long jF = f(ua1Var, l42Var, i);
        if (oz2.c(jF)) {
            return oz2.b;
        }
        long jF2 = f(ua1Var, l42Var2, i);
        if (oz2.c(jF2)) {
            return oz2.b;
        }
        int i2 = (int) (jF >> 32);
        int i3 = (int) (jF2 & 4294967295L);
        return hc4.a(Math.min(i2, i2), Math.max(i3, i3));
    }

    public static final boolean c(gz2 gz2Var, int i) {
        fl1 fl1Var = gz2Var.b;
        int iD = fl1Var.d(i);
        return i == gz2Var.f(iD) || i == fl1Var.c(iD, false) ? gz2Var.g(i) != gz2Var.a(i) : gz2Var.a(i) != gz2Var.a(i - 1);
    }

    public static final long d(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
    }

    public static final int e(fl1 fl1Var, long j, w73 w73Var) {
        float f = w73Var != null ? w73Var.f() : 0.0f;
        int i = (int) (4294967295L & j);
        int iE = fl1Var.e(Float.intBitsToFloat(i));
        if (Float.intBitsToFloat(i) < fl1Var.f(iE) - f || Float.intBitsToFloat(i) > fl1Var.b(iE) + f) {
            return -1;
        }
        int i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) < (-f) || Float.intBitsToFloat(i2) > fl1Var.d + f) {
            return -1;
        }
        return iE;
    }

    public static final long f(ua1 ua1Var, l42 l42Var, int i) {
        kf2 kf2Var = y74.k;
        hz2 hz2VarD = ua1Var.d();
        fl1 fl1Var = hz2VarD != null ? hz2VarD.a.b : null;
        y61 y61VarC = ua1Var.c();
        return (fl1Var == null || y61VarC == null) ? oz2.b : fl1Var.h(l42Var.i(y61VarC.A(0L)), i, kf2Var);
    }

    public static final boolean g(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    public static final boolean h(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    public static final boolean i(int i) {
        int type;
        return (!h(i) || (type = Character.getType(i)) == 14 || type == 13 || i == 10) ? false : true;
    }
}
