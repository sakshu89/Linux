package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.project.sonic.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ye4 {
    public static final void a(boolean z, fq0 fq0Var, x20 x20Var, int i) {
        x20Var.X(-361453782);
        int i2 = 2;
        int i3 = (x20Var.g(z) ? 4 : 2) | i | (x20Var.h(fq0Var) ? 32 : 16);
        int i4 = 0;
        if ((i3 & 19) == 18 && x20Var.A()) {
            x20Var.R();
        } else {
            mm1 mm1VarH = o44.h(fq0Var, x20Var);
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = new jk(z, mm1VarH);
                x20Var.g0(objL);
            }
            jk jkVar = (jk) objL;
            boolean zH = ((i3 & 14) == 4) | x20Var.h(jkVar);
            Object objL2 = x20Var.L();
            if (zH || objL2 == xyVar) {
                objL2 = new hk(jkVar, z, i4);
                x20Var.g0(objL2);
            }
            bz3.d((fq0) objL2, x20Var);
            n10 n10Var = (n10) x20Var.j(je1.a);
            Context context = null;
            if (n10Var == null) {
                x20Var.W(1208426157);
                View view = (View) x20Var.j(AndroidCompositionLocals_androidKt.f);
                view.getClass();
                while (true) {
                    if (view == null) {
                        n10Var = null;
                        break;
                    }
                    Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                    n10 n10Var2 = tag instanceof n10 ? (n10) tag : null;
                    if (n10Var2 != null) {
                        n10Var = n10Var2;
                        break;
                    } else {
                        Object objB = b(view);
                        view = objB instanceof View ? (View) objB : null;
                    }
                }
                x20Var.p(false);
            } else {
                x20Var.W(1208423708);
                x20Var.p(false);
            }
            if (n10Var == null) {
                x20Var.W(1208428160);
                for (Context baseContext = (Context) x20Var.j(AndroidCompositionLocals_androidKt.b); baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
                    if (baseContext instanceof n10) {
                        context = baseContext;
                        break;
                    }
                }
                n10Var = (n10) context;
                x20Var.p(false);
            } else {
                x20Var.W(1208423789);
                x20Var.p(false);
            }
            if (n10Var == null) {
                og.n("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
                return;
            }
            bq1 bq1VarG = n10Var.g();
            ob1 ob1Var = (ob1) x20Var.j(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean zH2 = x20Var.h(bq1VarG) | x20Var.h(ob1Var) | x20Var.h(jkVar);
            Object objL3 = x20Var.L();
            if (zH2 || objL3 == xyVar) {
                objL3 = new e2(bq1VarG, ob1Var, jkVar, i2);
                x20Var.g0(objL3);
            }
            bz3.b(ob1Var, bq1VarG, (hq0) objL3, x20Var);
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ik(z, fq0Var, i, i4);
        }
    }

    public static final ViewParent b(View view) {
        view.getClass();
        ViewParent parent = view.getParent();
        if (parent != null) {
            return parent;
        }
        Object tag = view.getTag(R.id.view_tree_disjoint_parent);
        if (tag instanceof ViewParent) {
            return (ViewParent) tag;
        }
        return null;
    }
}
