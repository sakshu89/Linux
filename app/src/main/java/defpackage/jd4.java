package defpackage;

import com.ibm.icu.text.ArabicShaping;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd4 {
    public static final void a(fl1 fl1Var, cw cwVar, hn hnVar, float f, vj2 vj2Var, sx2 sx2Var, wm4 wm4Var) {
        ArrayList arrayList = fl1Var.h;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            au1 au1Var = (au1) arrayList.get(i);
            au1Var.a.g(cwVar, hnVar, f, vj2Var, sx2Var, wm4Var);
            cwVar.g(0.0f, au1Var.a.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [hq0] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static final void b(xb0 xb0Var, Object obj, hq0 hq0Var) {
        zn1 zn1Var;
        if (!((dk1) xb0Var).a.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var = ((dk1) xb0Var).a.f;
        n71 n71VarG = cm4.g(xb0Var);
        while (n71VarG != null) {
            if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                while (dk1Var != null) {
                    if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                        ?? B = dk1Var;
                        ?? pm1Var = 0;
                        while (B != 0) {
                            if (B instanceof t23) {
                                t23 t23Var = (t23) B;
                                if (!(obj.equals(t23Var.p()) ? ((Boolean) hq0Var.j(t23Var)).booleanValue() : true)) {
                                    return;
                                }
                            } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                dk1 dk1Var2 = ((zb0) B).H;
                                int i = 0;
                                B = B;
                                pm1Var = pm1Var;
                                while (dk1Var2 != null) {
                                    if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                        i++;
                                        pm1Var = pm1Var;
                                        if (i == 1) {
                                            B = dk1Var2;
                                        } else {
                                            if (pm1Var == 0) {
                                                pm1Var = new pm1(new dk1[16]);
                                            }
                                            if (B != 0) {
                                                pm1Var.b(B);
                                                B = 0;
                                            }
                                            pm1Var.b(dk1Var2);
                                        }
                                    }
                                    dk1Var2 = dk1Var2.i;
                                    B = B;
                                    pm1Var = pm1Var;
                                }
                                if (i == 1) {
                                }
                            }
                            B = cm4.b(pm1Var);
                        }
                    }
                    dk1Var = dk1Var.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, t23, xb0] */
    /* JADX WARN: Type inference failed for: r11v0, types: [hq0] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [dk1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static final void c(t23 t23Var, hq0 hq0Var) {
        zn1 zn1Var;
        dk1 dk1Var = (dk1) t23Var;
        if (!dk1Var.a.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var2 = dk1Var.a.f;
        n71 n71VarG = cm4.g(t23Var);
        while (n71VarG != null) {
            if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                while (dk1Var2 != null) {
                    if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                        ?? B = dk1Var2;
                        ?? pm1Var = 0;
                        while (B != 0) {
                            boolean zBooleanValue = true;
                            if (B instanceof t23) {
                                t23 t23Var2 = (t23) B;
                                if (g31.a(t23Var.p(), t23Var2.p()) && t23Var.getClass() == t23Var2.getClass()) {
                                    zBooleanValue = ((Boolean) hq0Var.j(t23Var2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                dk1 dk1Var3 = ((zb0) B).H;
                                int i = 0;
                                B = B;
                                pm1Var = pm1Var;
                                while (dk1Var3 != null) {
                                    if ((dk1Var3.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                        i++;
                                        pm1Var = pm1Var;
                                        if (i == 1) {
                                            B = dk1Var3;
                                        } else {
                                            if (pm1Var == 0) {
                                                pm1Var = new pm1(new dk1[16]);
                                            }
                                            if (B != 0) {
                                                pm1Var.b(B);
                                                B = 0;
                                            }
                                            pm1Var.b(dk1Var3);
                                        }
                                    }
                                    dk1Var3 = dk1Var3.i;
                                    B = B;
                                    pm1Var = pm1Var;
                                }
                                if (i == 1) {
                                }
                            }
                            B = cm4.b(pm1Var);
                        }
                    }
                    dk1Var2 = dk1Var2.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var2 = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [hq0] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static final void d(xb0 xb0Var, String str, hq0 hq0Var) {
        if (!((dk1) xb0Var).a.w) {
            z01.b("visitSubtreeIf called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var = ((dk1) xb0Var).a;
        dk1 dk1Var2 = dk1Var.i;
        if (dk1Var2 == null) {
            cm4.a(pm1Var, dk1Var);
        } else {
            pm1Var.b(dk1Var2);
        }
        while (true) {
            int i = pm1Var.c;
            if (i == 0) {
                return;
            }
            dk1 dk1Var3 = (dk1) pm1Var.l(i - 1);
            if ((dk1Var3.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                dk1 dk1Var4 = dk1Var3;
                while (true) {
                    if (dk1Var4 != null && dk1Var4.w) {
                        if ((dk1Var4.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            ?? B = dk1Var4;
                            ?? pm1Var2 = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    t23 t23Var = (t23) B;
                                    s23 s23Var = str.equals(t23Var.p()) ? (s23) hq0Var.j(t23Var) : s23.a;
                                    if (s23Var != s23.c) {
                                        if (s23Var == s23.b) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var5 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var2 = pm1Var2;
                                    while (dk1Var5 != null) {
                                        if ((dk1Var5.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                            i2++;
                                            pm1Var2 = pm1Var2;
                                            if (i2 == 1) {
                                                B = dk1Var5;
                                            } else {
                                                if (pm1Var2 == 0) {
                                                    pm1Var2 = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var2.b(B);
                                                    B = 0;
                                                }
                                                pm1Var2.b(dk1Var5);
                                            }
                                        }
                                        dk1Var5 = dk1Var5.i;
                                        B = B;
                                        pm1Var2 = pm1Var2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var2);
                            }
                        }
                        dk1Var4 = dk1Var4.i;
                    }
                }
            }
            cm4.a(pm1Var, dk1Var3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, t23] */
    /* JADX WARN: Type inference failed for: r13v0, types: [hq0] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void e(t23 t23Var, hq0 hq0Var) {
        dk1 dk1Var = (dk1) t23Var;
        if (!dk1Var.a.w) {
            z01.b("visitSubtreeIf called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var2 = dk1Var.a;
        dk1 dk1Var3 = dk1Var2.i;
        if (dk1Var3 == null) {
            cm4.a(pm1Var, dk1Var2);
        } else {
            pm1Var.b(dk1Var3);
        }
        while (true) {
            int i = pm1Var.c;
            if (i == 0) {
                return;
            }
            dk1 dk1Var4 = (dk1) pm1Var.l(i - 1);
            if ((dk1Var4.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                dk1 dk1Var5 = dk1Var4;
                while (true) {
                    if (dk1Var5 != null && dk1Var5.w) {
                        if ((dk1Var5.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            ?? B = dk1Var5;
                            ?? pm1Var2 = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    t23 t23Var2 = (t23) B;
                                    s23 s23Var = (g31.a(t23Var.p(), t23Var2.p()) && t23Var.getClass() == t23Var2.getClass()) ? (s23) hq0Var.j(t23Var2) : s23.a;
                                    if (s23Var != s23.c) {
                                        if (s23Var == s23.b) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var6 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var2 = pm1Var2;
                                    while (dk1Var6 != null) {
                                        if ((dk1Var6.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                            i2++;
                                            pm1Var2 = pm1Var2;
                                            if (i2 == 1) {
                                                B = dk1Var6;
                                            } else {
                                                if (pm1Var2 == 0) {
                                                    pm1Var2 = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var2.b(B);
                                                    B = 0;
                                                }
                                                pm1Var2.b(dk1Var6);
                                            }
                                        }
                                        dk1Var6 = dk1Var6.i;
                                        B = B;
                                        pm1Var2 = pm1Var2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var2);
                            }
                        }
                        dk1Var5 = dk1Var5.i;
                    }
                }
            }
            cm4.a(pm1Var, dk1Var4);
        }
    }
}
