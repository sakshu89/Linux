package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gg2 {
    public final dk1 a;
    public final boolean b;
    public final n71 c;
    public final cg2 d;
    public boolean e;
    public gg2 f;
    public final int g;

    public gg2(dk1 dk1Var, boolean z, n71 n71Var, cg2 cg2Var) {
        this.a = dk1Var;
        this.b = z;
        this.c = n71Var;
        this.d = cg2Var;
        this.g = n71Var.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
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
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final l42 a(co1 co1Var) {
        ?? B;
        gg2 gg2VarL = l();
        if (gg2VarL == null) {
            return l42.e;
        }
        dk1 dk1Var = gg2VarL.c.o0.f;
        if ((dk1Var.e & 8) == 0) {
            B = 0;
            break;
        }
        loop0: while (true) {
            if (dk1Var != null) {
                if ((dk1Var.c & 8) != 0) {
                    B = dk1Var;
                    ?? pm1Var = 0;
                    while (B != 0) {
                        if (B instanceof eg2) {
                            if (((eg2) B).h()) {
                                break loop0;
                            }
                        } else if ((B.c & 8) != 0 && (B instanceof zb0)) {
                            dk1 dk1Var2 = ((zb0) B).H;
                            int i = 0;
                            B = B;
                            pm1Var = pm1Var;
                            while (dk1Var2 != null) {
                                if ((dk1Var2.c & 8) != 0) {
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
                if ((dk1Var.e & 8) != 0) {
                    dk1Var = dk1Var.i;
                }
            }
            B = 0;
            break;
        }
        eg2 eg2Var = (eg2) B;
        co1 co1VarE = eg2Var != null ? cm4.e(eg2Var, 8) : null;
        return co1VarE == null ? gg2VarL.a(co1Var) : co1VarE.N(co1Var, true);
    }

    public final gg2 b(m82 m82Var, hq0 hq0Var) {
        cg2 cg2Var = new cg2();
        cg2Var.c = false;
        cg2Var.e = false;
        hq0Var.j(cg2Var);
        gg2 gg2Var = new gg2(new fg2(hq0Var), false, new n71(true, this.g + (m82Var != null ? 1000000000 : 2000000000)), cg2Var);
        gg2Var.e = true;
        gg2Var.f = this;
        return gg2Var;
    }

    public final void c(n71 n71Var, ArrayList arrayList) {
        pm1 pm1VarX = n71Var.x();
        Object[] objArr = pm1VarX.a;
        int i = pm1VarX.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (n71Var2.H() && !n71Var2.x0) {
                if (n71Var2.o0.d(8)) {
                    arrayList.add(c34.b(n71Var2, this.b));
                } else {
                    c(n71Var2, arrayList);
                }
            }
        }
    }

    public final co1 d() {
        if (!this.e) {
            eg2 eg2VarF = f();
            return eg2VarF != null ? cm4.e(eg2VarF, 8) : this.c.o0.c;
        }
        gg2 gg2VarL = l();
        if (gg2VarL != null) {
            return gg2VarL.d();
        }
        return null;
    }

    public final void e(ArrayList arrayList, ArrayList arrayList2) {
        o(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            gg2 gg2Var = (gg2) arrayList.get(size2);
            if (gg2Var.m()) {
                arrayList2.add(gg2Var);
            } else if (!gg2Var.d.e) {
                gg2Var.e(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v10 */
    public final eg2 f() {
        ?? B;
        boolean z = this.d.c;
        ?? r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        n71 n71Var = this.c;
        if (!z) {
            dk1 dk1Var = n71Var.o0.f;
            if ((dk1Var.e & 8) != 0) {
                loop3: while (dk1Var != null) {
                    if ((dk1Var.c & 8) != 0) {
                        B = dk1Var;
                        ?? pm1Var = 0;
                        while (true) {
                            if (B != 0) {
                                if (B instanceof eg2) {
                                    if (((eg2) B).h()) {
                                        r4 = B;
                                    }
                                } else if ((B.c & 8) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & 8) != 0) {
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
                    }
                    if ((dk1Var.e & 8) == 0) {
                        break;
                    }
                    dk1Var = dk1Var.i;
                }
            }
        } else {
            dk1 dk1Var3 = n71Var.o0.f;
            if ((dk1Var3.e & 8) != 0) {
                B = 0;
                while (dk1Var3 != null) {
                    if ((dk1Var3.c & 8) != 0) {
                        ?? B2 = dk1Var3;
                        ?? pm1Var2 = 0;
                        while (B2 != 0) {
                            if (B2 instanceof eg2) {
                                eg2 eg2Var = (eg2) B2;
                                if (eg2Var.h()) {
                                    if (eg2Var.k0()) {
                                        return eg2Var;
                                    }
                                    if (B == 0) {
                                        B = eg2Var;
                                    }
                                }
                            } else if ((B2.c & 8) != 0 && (B2 instanceof zb0)) {
                                dk1 dk1Var4 = ((zb0) B2).H;
                                int i2 = 0;
                                B2 = B2;
                                pm1Var2 = pm1Var2;
                                while (dk1Var4 != null) {
                                    if ((dk1Var4.c & 8) != 0) {
                                        i2++;
                                        pm1Var2 = pm1Var2;
                                        if (i2 == 1) {
                                            B2 = dk1Var4;
                                        } else {
                                            if (pm1Var2 == 0) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (B2 != 0) {
                                                pm1Var2.b(B2);
                                                B2 = 0;
                                            }
                                            pm1Var2.b(dk1Var4);
                                        }
                                    }
                                    dk1Var4 = dk1Var4.i;
                                    B2 = B2;
                                    pm1Var2 = pm1Var2;
                                }
                                if (i2 == 1) {
                                }
                            }
                            B2 = cm4.b(pm1Var2);
                        }
                    }
                    if ((dk1Var3.e & 8) == 0) {
                        break;
                    }
                    dk1Var3 = dk1Var3.i;
                    B = B;
                }
                r4 = B;
            }
        }
        return (eg2) r4;
    }

    public final l42 g() {
        co1 co1VarD = d();
        if (co1VarD != null) {
            if (!co1VarD.V0().w) {
                co1VarD = null;
            }
            if (co1VarD != null) {
                return pp4.c(co1VarD).N(co1VarD, true);
            }
        }
        return l42.e;
    }

    public final l42 h() {
        co1 co1VarD = d();
        if (co1VarD != null) {
            if (!co1VarD.V0().w) {
                co1VarD = null;
            }
            if (co1VarD != null) {
                return pp4.b(co1VarD, true);
            }
        }
        return l42.e;
    }

    public final List i(boolean z, boolean z2) {
        if (!z && this.d.e) {
            return ii0.a;
        }
        ArrayList arrayList = new ArrayList();
        if (!m()) {
            return o(arrayList, z2);
        }
        ArrayList arrayList2 = new ArrayList();
        e(arrayList, arrayList2);
        return arrayList2;
    }

    public final cg2 k() {
        boolean zM = m();
        cg2 cg2Var = this.d;
        if (!zM) {
            return cg2Var;
        }
        cg2 cg2VarB = cg2Var.b();
        n(new ArrayList(), cg2VarB);
        return cg2VarB;
    }

    public final gg2 l() {
        n71 n71VarU;
        gg2 gg2Var = this.f;
        if (gg2Var != null) {
            return gg2Var;
        }
        n71 n71Var = this.c;
        boolean z = this.b;
        if (!z) {
            n71VarU = null;
            break;
        }
        n71VarU = n71Var.u();
        while (true) {
            if (n71VarU == null) {
                n71VarU = null;
                break;
            }
            cg2 cg2VarW = n71VarU.w();
            if (cg2VarW != null && cg2VarW.c) {
                break;
            }
            n71VarU = n71VarU.u();
        }
        if (n71VarU == null) {
            for (n71 n71VarU2 = n71Var.u(); n71VarU2 != null; n71VarU2 = n71VarU2.u()) {
                if (n71VarU2.o0.d(8)) {
                    n71VarU = n71VarU2;
                }
            }
            n71VarU = null;
        }
        if (n71VarU == null) {
            return null;
        }
        return c34.b(n71VarU, z);
    }

    public final boolean m() {
        return this.b && this.d.c;
    }

    public final void n(ArrayList arrayList, cg2 cg2Var) {
        if (this.d.e) {
            return;
        }
        o(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            gg2 gg2Var = (gg2) arrayList.get(size2);
            if (!gg2Var.m()) {
                cg2Var.f(gg2Var.d);
                gg2Var.n(arrayList, cg2Var);
            }
        }
    }

    public final List o(ArrayList arrayList, boolean z) {
        if (this.e) {
            return ii0.a;
        }
        c(this.c, arrayList);
        if (z) {
            cg2 cg2Var = this.d;
            gm1 gm1Var = cg2Var.a;
            Object objG = gm1Var.g(kg2.x);
            if (objG == null) {
                objG = null;
            }
            m82 m82Var = (m82) objG;
            if (m82Var != null && cg2Var.c && !arrayList.isEmpty()) {
                arrayList.add(b(m82Var, new kt1(19, m82Var)));
            }
            ng2 ng2Var = kg2.a;
            if (gm1Var.c(ng2Var) && !arrayList.isEmpty() && cg2Var.c) {
                Object objG2 = gm1Var.g(ng2Var);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                String str = list != null ? (String) mz.y(list) : null;
                if (str != null) {
                    arrayList.add(0, b(null, new h6(20, str)));
                }
            }
        }
        return arrayList;
    }
}
