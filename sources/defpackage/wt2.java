package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wt2 {
    public static final m30 a = new m30(new tv1(13));

    public static final ek1 a(ek1 ek1Var, yj2 yj2Var, long j, yl ylVar, float f) {
        ek1 ek1VarB;
        ek1 xlVar = bk1.a;
        if (f > 0.0f) {
            long j2 = y13.a;
            long j3 = zu0.a;
            ek1VarB = pz3.b(xlVar, 1.0f, f, j2, yj2Var, false, j3, j3);
        } else {
            ek1VarB = xlVar;
        }
        ek1 ek1VarC = ek1Var.c(ek1VarB);
        if (ylVar != null) {
            xlVar = new xl(ylVar.a, ylVar.b, yj2Var);
        }
        return vh4.a(kg1.a(ek1VarC.c(xlVar), j, yj2Var), yj2Var);
    }

    public static final long b(long j, float f, x20 x20Var) {
        float f2;
        float f3;
        yz yzVar = (yz) x20Var.j(a00.a);
        boolean zBooleanValue = ((Boolean) x20Var.j(a00.b)).booleanValue();
        long j2 = yzVar.p;
        if (!sz.c(j, j2) || !zBooleanValue) {
            return j;
        }
        float f4 = 0.0f;
        if (de0.b(f, 0.0f)) {
            return j2;
        }
        long jA = sz.a(sz.b(((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f, yzVar.t), sz.f(j2));
        float fD = sz.d(j2);
        float fD2 = sz.d(jA);
        float f5 = 1.0f - fD2;
        float f6 = (fD * f5) + fD2;
        float fH = sz.h(jA);
        float fH2 = sz.h(j2);
        if (f6 == 0.0f) {
            f2 = 0.0f;
        } else {
            f2 = (((fH2 * fD) * f5) + (fH * fD2)) / f6;
        }
        float fG = sz.g(jA);
        float fG2 = sz.g(j2);
        if (f6 == 0.0f) {
            f3 = 0.0f;
        } else {
            f3 = (((fG2 * fD) * f5) + (fG * fD2)) / f6;
        }
        float fE = sz.e(jA);
        float fE2 = sz.e(j2);
        if (f6 != 0.0f) {
            f4 = (((fE2 * fD) * f5) + (fE * fD2)) / f6;
        }
        return ki4.e(f2, f3, f4, f6, sz.f(j2));
    }
}
