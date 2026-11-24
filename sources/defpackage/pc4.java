package defpackage;

import android.content.res.Resources;
import com.project.sonic.R;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pc4 {
    public static Thread a;

    public static final boolean a(gg2 gg2Var) {
        return !gg2Var.k().a.c(kg2.i);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    public static final boolean b(gg2 gg2Var, Resources resources) {
        boolean z;
        Object objG = gg2Var.d.a.g(kg2.a);
        n71 n71Var = null;
        if (objG == null) {
            objG = null;
        }
        List list = (List) objG;
        boolean z2 = ((list != null ? (String) mz.y(list) : null) == null && e(gg2Var) == null && d(gg2Var, resources) == null && !c(gg2Var)) ? false : true;
        if (!o44.e(gg2Var)) {
            if (!gg2Var.d.c) {
                if (gg2Var.e || !gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0).isEmpty()) {
                    z = false;
                } else {
                    for (n71 n71VarU = gg2Var.c.u(); n71VarU != null; n71VarU = n71VarU.u()) {
                        cg2 cg2VarW = n71VarU.w();
                        if (cg2VarW != null && cg2VarW.c) {
                            n71Var = n71VarU;
                            break;
                        }
                    }
                    if (n71Var == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z || !z2) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean c(gg2 gg2Var) {
        Object objG = gg2Var.d.a.g(kg2.I);
        if (objG == null) {
            objG = null;
        }
        d13 d13Var = (d13) objG;
        gm1 gm1Var = gg2Var.d.a;
        Object objG2 = gm1Var.g(kg2.x);
        if (objG2 == null) {
            objG2 = null;
        }
        boolean z = d13Var != null;
        Object objG3 = gm1Var.g(kg2.H);
        if (((Boolean) (objG3 != null ? objG3 : null)) != null) {
            return true;
        }
        return z;
    }

    public static final String d(gg2 gg2Var, Resources resources) {
        int iOrdinal;
        cg2 cg2Var = gg2Var.d;
        cg2 cg2Var2 = gg2Var.d;
        Object objG = cg2Var.a.g(kg2.b);
        String string = null;
        if (objG == null) {
            objG = null;
        }
        gm1 gm1Var = cg2Var2.a;
        Object objG2 = gm1Var.g(kg2.I);
        if (objG2 == null) {
            objG2 = null;
        }
        d13 d13Var = (d13) objG2;
        Object objG3 = gm1Var.g(kg2.x);
        if (objG3 == null) {
            objG3 = null;
        }
        if (d13Var != null && (iOrdinal = d13Var.ordinal()) != 0 && iOrdinal != 1) {
            if (iOrdinal != 2) {
                dk0.l();
                return null;
            }
            if (objG == null) {
                objG = resources.getString(R.string.indeterminate);
            }
        }
        Object objG4 = gm1Var.g(kg2.H);
        if (objG4 == null) {
            objG4 = null;
        }
        Boolean bool = (Boolean) objG4;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (objG == null) {
                objG = zBooleanValue ? resources.getString(R.string.selected) : resources.getString(R.string.not_selected);
            }
        }
        Object objG5 = gm1Var.g(kg2.c);
        if (objG5 == null) {
            objG5 = null;
        }
        q12 q12Var = (q12) objG5;
        if (q12Var != null) {
            if (q12Var != q12.b) {
                if (objG == null) {
                    objG = resources.getString(R.string.template_percent, 0);
                }
            } else if (objG == null) {
                objG = resources.getString(R.string.in_progress);
            }
        }
        ng2 ng2Var = kg2.E;
        if (gm1Var.c(ng2Var)) {
            gm1 gm1Var2 = new gg2(gg2Var.a, true, gg2Var.c, cg2Var2).k().a;
            Object objG6 = gm1Var2.g(kg2.a);
            if (objG6 == null) {
                objG6 = null;
            }
            Collection collection = (Collection) objG6;
            if (collection == null || collection.isEmpty()) {
                Object objG7 = gm1Var2.g(kg2.A);
                if (objG7 == null) {
                    objG7 = null;
                }
                Collection collection2 = (Collection) objG7;
                if (collection2 == null || collection2.isEmpty()) {
                    Object objG8 = gm1Var2.g(ng2Var);
                    if (objG8 == null) {
                        objG8 = null;
                    }
                    CharSequence charSequence = (CharSequence) objG8;
                    if (charSequence == null || charSequence.length() == 0) {
                        string = resources.getString(R.string.state_empty);
                    }
                }
            }
            objG = string;
        }
        return (String) objG;
    }

    public static final be e(gg2 gg2Var) {
        Object objG = gg2Var.d.a.g(kg2.E);
        if (objG == null) {
            objG = null;
        }
        be beVar = (be) objG;
        Object objG2 = gg2Var.d.a.g(kg2.A);
        if (objG2 == null) {
            objG2 = null;
        }
        List list = (List) objG2;
        return beVar == null ? list != null ? (be) mz.y(list) : null : beVar;
    }
}
