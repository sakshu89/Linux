package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yb4 {
    public static void a(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            dk0.f(i3, cq.p("fromIndex: ", i, ", toIndex: ", i2, ", size: "));
        } else {
            if (i <= i2) {
                return;
            }
            og.i(ky0.i("fromIndex: ", i, i2, " > toIndex: "));
        }
    }

    public static final boolean b(ny2 ny2Var, boolean z) {
        y61 y61VarC;
        ua1 ua1Var = ny2Var.d;
        if (ua1Var == null || (y61VarC = ua1Var.c()) == null) {
            return false;
        }
        l42 l42VarB = w24.b(y61VarC);
        long jL = ny2Var.l(z);
        float f = l42VarB.a;
        float f2 = l42VarB.c;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jL >> 32));
        if (f > fIntBitsToFloat || fIntBitsToFloat > f2) {
            return false;
        }
        float f3 = l42VarB.b;
        float f4 = l42VarB.d;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jL & 4294967295L));
        return f3 <= fIntBitsToFloat2 && fIntBitsToFloat2 <= f4;
    }
}
