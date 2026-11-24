package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class w24 {
    public static final ek1 a(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new fq1(hq0Var));
    }

    public static final l42 b(y61 y61Var) {
        l42 l42VarB = pp4.b(y61Var, true);
        long jH = y61Var.h(l42VarB.d());
        float f = l42VarB.c;
        float f2 = l42VarB.d;
        long jH2 = y61Var.h((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        return new l42(Float.intBitsToFloat((int) (jH >> 32)), Float.intBitsToFloat((int) (jH & 4294967295L)), Float.intBitsToFloat((int) (jH2 >> 32)), Float.intBitsToFloat((int) (jH2 & 4294967295L)));
    }
}
