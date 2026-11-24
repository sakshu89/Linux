package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class no0 extends zb0 implements eg2, du0, h30, ep1, t23 {
    public static final fl4 f0 = new fl4(12);
    public ol1 X;
    public final hq0 Y;
    public sn0 Z;
    public a91 c0;
    public co1 d0;
    public final ko0 e0;

    public no0(ol1 ol1Var, int i, q0 q0Var) {
        this.X = ol1Var;
        this.Y = q0Var;
        ko0 ko0Var = new ko0(i, new d80(2, this, no0.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0, 0, 1), 10);
        I0(ko0Var);
        this.e0 = ko0Var;
    }

    @Override // defpackage.dk1
    public final void C0() {
        a91 a91Var = this.c0;
        if (a91Var != null) {
            a91Var.b();
        }
        this.c0 = null;
    }

    @Override // defpackage.ep1
    public final void J() {
        t42 t42Var = new t42();
        tr4.a(this, new zb(7, t42Var, this));
        a91 a91Var = (a91) t42Var.a;
        if (this.e0.N0().a()) {
            a91 a91Var2 = this.c0;
            if (a91Var2 != null) {
                a91Var2.b();
            }
            if (a91Var != null) {
                a91Var.a();
            } else {
                a91Var = null;
            }
            this.c0 = a91Var;
        }
    }

    public final void L0(ol1 ol1Var, r21 r21Var) {
        if (!this.w) {
            ol1Var.b(r21Var);
            return;
        }
        f41 f41Var = (f41) ((w50) w0()).a.v(nr4.k);
        uf4.b(w0(), null, new r0(ol1Var, r21Var, f41Var != null ? f41Var.C(new o0(7, ol1Var, r21Var)) : null, null, 9), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
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
    /* JADX WARN: Type inference failed for: r5v5 */
    public final void M0() {
        zn1 zn1Var;
        if (this.w) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            while (n71VarG != null) {
                if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            var B = dk1Var;
                            var pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    if (oo0.x == ((t23) B).p()) {
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
    }

    public final void N0(ol1 ol1Var) {
        sn0 sn0Var;
        if (g31.a(this.X, ol1Var)) {
            return;
        }
        ol1 ol1Var2 = this.X;
        if (ol1Var2 != null && (sn0Var = this.Z) != null) {
            ol1Var2.b(new tn0(sn0Var));
        }
        this.Z = null;
        this.X = ol1Var;
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        boolean zA = this.e0.N0().a();
        c51[] c51VarArr = mg2.a;
        ng2 ng2Var = kg2.k;
        c51 c51Var = mg2.a[4];
        og2Var.a(ng2Var, Boolean.valueOf(zA));
        og2Var.a(bg2.w, new b2(null, new g7(0, this, no0.class, "requestFocus", "requestFocus()Z", 0, 0, 3)));
    }

    @Override // defpackage.t23
    public final Object p() {
        return f0;
    }

    @Override // defpackage.du0
    public final void u(co1 co1Var) {
        this.d0 = co1Var;
        if (this.e0.N0().a()) {
            if (!co1Var.V0().w) {
                M0();
                return;
            }
            co1 co1Var2 = this.d0;
            if (co1Var2 == null || !co1Var2.V0().w) {
                return;
            }
            M0();
        }
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
