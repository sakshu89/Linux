package defpackage;

import android.view.View;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cf4 {
    public static final void a(ek1 ek1Var, z12 z12Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-714464401);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(z12Var) ? 32 : 16;
        }
        int i3 = i & CollationFastLatin.LATIN_LIMIT;
        w10 w10Var2 = fy3.a;
        if (i3 == 0) {
            i2 |= x20Var.h(w10Var2) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.h(w10Var) ? 2048 : 1024;
        }
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            Object objL = x20Var.L();
            if (objL == r20.a) {
                Object ku1Var = new ku1(null, el1.f);
                x20Var.g0(ku1Var);
                objL = ku1Var;
            }
            wk wkVarB = b(w10Var2, x20Var, (i2 >> 6) & 14);
            kj4.a(z12Var.a(wkVarB), yi4.b(274270255, new xk(ek1Var, (mm1) objL, w10Var, wkVarB, 0), x20Var), x20Var, 56);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(ek1Var, z12Var, w10Var, i, 1);
        }
    }

    public static final wk b(w10 w10Var, x20 x20Var, int i) {
        boolean z = (((i & 14) ^ 6) > 4 && x20Var.f(w10Var)) || (i & 6) == 4;
        Object objL = x20Var.L();
        Object obj = r20.a;
        if (z || objL == obj) {
            objL = new wk(w10Var);
            x20Var.g0(objL);
        }
        wk wkVar = (wk) objL;
        boolean zF = x20Var.f(wkVar);
        Object objL2 = x20Var.L();
        if (zF || objL2 == obj) {
            objL2 = new x0(5, wkVar);
            x20Var.g0(objL2);
        }
        bz3.a(wkVar, (hq0) objL2, x20Var);
        return wkVar;
    }

    public static final na2 c(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            na2 na2Var = tag instanceof na2 ? (na2) tag : null;
            if (na2Var != null) {
                return na2Var;
            }
            Object objB = ye4.b(view);
            view = objB instanceof View ? (View) objB : null;
        }
        return null;
    }
}
