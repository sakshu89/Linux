package defpackage;

import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jg2 {
    public final n71 a;
    public final ki0 b;
    public final c21 c;
    public final yl1 d = new yl1(2);

    public jg2(n71 n71Var, ki0 ki0Var, ml1 ml1Var) {
        this.a = n71Var;
        this.b = ki0Var;
        this.c = ml1Var;
    }

    public final gg2 a() {
        return new gg2(this.b, false, this.a, new cg2());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    public final void b(n71 n71Var, cg2 cg2Var) {
        String str;
        String str2;
        d13 d13Var;
        d13 d13Var2;
        i9 i9Var;
        i9 i9Var2;
        yl1 yl1Var = this.d;
        Object[] objArr = yl1Var.a;
        int i = yl1Var.b;
        for (int i2 = 0; i2 < i; i2++) {
            s6 s6Var = (s6) objArr[i2];
            wj1 wj1Var = s6Var.a;
            AutofillManager autofillManager = (AutofillManager) wj1Var.b;
            r7 r7Var = s6Var.c;
            cg2 cg2VarW = n71Var.w();
            int i3 = n71Var.b;
            if (cg2Var != null) {
                Object objG = cg2Var.a.g(kg2.D);
                if (objG == null) {
                    objG = null;
                }
                be beVar = (be) objG;
                if (beVar != null) {
                    str = beVar.b;
                } else {
                    str = null;
                }
            } else {
                str = null;
            }
            if (cg2VarW != null) {
                Object objG2 = cg2VarW.a.g(kg2.D);
                if (objG2 == null) {
                    objG2 = null;
                }
                be beVar2 = (be) objG2;
                if (beVar2 != null) {
                    str2 = beVar2.b;
                } else {
                    str2 = null;
                }
            } else {
                str2 = null;
            }
            if (str != str2) {
                if (str == null) {
                    wj1Var.n(r7Var, i3, true);
                } else if (str2 == null) {
                    wj1Var.n(r7Var, i3, false);
                } else if (g31.a((r8) y24.a(cg2VarW, kg2.r), nr4.c)) {
                    autofillManager.notifyValueChanged(r7Var, i3, AutofillValue.forText(str2));
                }
            }
            if (cg2Var != null) {
                Object objG3 = cg2Var.a.g(kg2.I);
                if (objG3 == null) {
                    objG3 = null;
                }
                d13Var = (d13) objG3;
            } else {
                d13Var = null;
            }
            if (cg2VarW != null) {
                Object objG4 = cg2VarW.a.g(kg2.I);
                if (objG4 == null) {
                    objG4 = null;
                }
                d13Var2 = (d13) objG4;
            } else {
                d13Var2 = null;
            }
            if (d13Var != d13Var2) {
                if (d13Var == null) {
                    wj1Var.n(r7Var, i3, true);
                } else if (d13Var2 == null) {
                    wj1Var.n(r7Var, i3, false);
                } else if (g31.a((r8) y24.a(cg2VarW, kg2.r), nr4.e)) {
                    int iOrdinal = d13Var2.ordinal();
                    Boolean bool = iOrdinal != 0 ? iOrdinal != 1 ? null : Boolean.FALSE : Boolean.TRUE;
                    if (bool != null) {
                        autofillManager.notifyValueChanged(r7Var, i3, AutofillValue.forToggle(bool.booleanValue()));
                    }
                }
            }
            if (cg2Var != null) {
                Object objG5 = cg2Var.a.g(kg2.s);
                if (objG5 == null) {
                    objG5 = null;
                }
                i9Var = (i9) objG5;
            } else {
                i9Var = null;
            }
            if (cg2VarW != null) {
                Object objG6 = cg2VarW.a.g(kg2.s);
                if (objG6 == null) {
                    objG6 = null;
                }
                i9Var2 = (i9) objG6;
            } else {
                i9Var2 = null;
            }
            if (!g31.a(i9Var, i9Var2)) {
                if (i9Var == null) {
                    wj1Var.n(r7Var, i3, true);
                } else if (i9Var2 == null) {
                    wj1Var.n(r7Var, i3, false);
                } else {
                    autofillManager.notifyValueChanged(r7Var, i3, i9Var2.a);
                }
            }
            boolean z = cg2Var != null && cg2Var.a.b(kg2.q);
            boolean z2 = cg2VarW != null && cg2VarW.a.b(kg2.q);
            if (z != z2) {
                nl1 nl1Var = s6Var.k;
                if (z2) {
                    nl1Var.a(i3);
                } else {
                    nl1Var.e(i3);
                }
            }
        }
    }
}
