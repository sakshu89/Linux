package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qb4 {
    public static final Object a = new Object();
    public static boolean b;
    public static int c;

    public static void a(ty2 ty2Var, ux2 ux2Var, gz2 gz2Var, y61 y61Var, bz2 bz2Var, boolean z, mp1 mp1Var) {
        l42 l42VarB;
        if (z) {
            int iL = mp1Var.l(oz2.e(ty2Var.b));
            String str = xx2.a;
            if (iL < gz2Var.a.a.b.length()) {
                l42VarB = gz2Var.b(iL);
            } else {
                l42VarB = iL != 0 ? gz2Var.b(iL - 1) : new l42(0.0f, 0.0f, 1.0f, (int) (xx2.a(ux2Var.b, ux2Var.g, ux2Var.h, xx2.a, 1) & 4294967295L));
            }
            float f = l42VarB.b;
            float f2 = l42VarB.a;
            long jU = y61Var.U((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
            l42 l42VarA = ry3.a((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jU & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jU >> 32)))) << 32), (((long) Float.floatToRawIntBits(l42VarB.c - f2)) << 32) | (((long) Float.floatToRawIntBits(l42VarB.d - f)) & 4294967295L));
            if (g31.a((bz2) bz2Var.a.b.get(), bz2Var)) {
                bz2Var.b.g(l42VarA);
            }
        }
    }
}
