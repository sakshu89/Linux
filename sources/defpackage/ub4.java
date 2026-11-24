package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ub4 {
    public static final l42 a(yw1 yw1Var, int i, a23 a23Var, gz2 gz2Var, boolean z, int i2) {
        l42 l42VarC = gz2Var != null ? gz2Var.c(a23Var.b.l(i)) : l42.e;
        float f = l42VarC.a;
        int iR = yw1Var.R(2.0f);
        return new l42(z ? (i2 - f) - iR : f, l42VarC.b, z ? i2 - f : iR + f, l42VarC.d);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    public static final int b(df2 df2Var, int i) {
        int i2;
        int[] iArr = df2Var.i;
        int i3 = i + 1;
        int length = df2Var.f.length;
        iArr.getClass();
        int i4 = length - 1;
        int i5 = 0;
        while (i5 <= i4) {
            i2 = (i5 + i4) >>> 1;
            int i6 = iArr[i2];
            if (i6 < i3) {
                i5 = i2 + 1;
            } else {
                if (i6 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                i4 = i2 - 1;
            }
        }
        i2 = (-i5) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }
}
