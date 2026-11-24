package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sf4 {
    public static final Object a(xb0 xb0Var, fq0 fq0Var, y50 y50Var) {
        Object obj;
        co1 co1VarF;
        Object objC0;
        zn1 zn1Var;
        if (((dk1) xb0Var).a.w) {
            dk1 dk1Var = (dk1) xb0Var;
            if (!dk1Var.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var2 = dk1Var.a.f;
            n71 n71VarG = cm4.g(xb0Var);
            loop0: while (true) {
                obj = null;
                if (n71VarG == null) {
                    break;
                }
                if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_RESIZE) != 0) {
                    while (dk1Var2 != null) {
                        if ((dk1Var2.c & ArabicShaping.TASHKEEL_RESIZE) != 0) {
                            dk1 dk1VarB = dk1Var2;
                            pm1 pm1Var = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof sm) {
                                    obj = dk1VarB;
                                    break loop0;
                                }
                                if ((dk1VarB.c & ArabicShaping.TASHKEEL_RESIZE) != 0 && (dk1VarB instanceof zb0)) {
                                    int i = 0;
                                    for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                        if ((dk1Var3.c & ArabicShaping.TASHKEEL_RESIZE) != 0) {
                                            i++;
                                            if (i == 1) {
                                                dk1VarB = dk1Var3;
                                            } else {
                                                if (pm1Var == null) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var.b(dk1Var3);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var);
                            }
                        }
                        dk1Var2 = dk1Var2.f;
                    }
                }
                n71VarG = n71VarG.u();
                dk1Var2 = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
            }
            sm smVar = (sm) obj;
            if (smVar != null && (objC0 = smVar.c0((co1VarF = cm4.f(xb0Var)), new h7(2, fq0Var, co1VarF), y50Var)) == t70.a) {
                return objC0;
            }
        }
        return q43.a;
    }

    public abstract void b(boolean z);

    public abstract void c(boolean z);
}
