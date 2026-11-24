package defpackage;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e7 extends dk1 implements sm, eg2, k51, f71, t23 {
    public final /* synthetic */ r7 H;
    public final h6 x = new h6(2, this);

    public e7(r7 r7Var) {
        this.H = r7Var;
    }

    @Override // defpackage.k51
    public final boolean U(KeyEvent keyEvent) {
        qn0 qn0Var;
        int[] iArr = un0.a;
        long jA = h51.a(keyEvent);
        Integer num = null;
        if (d51.a(jA, d51.b)) {
            qn0Var = new qn0(2);
        } else if (d51.a(jA, d51.c)) {
            qn0Var = new qn0(1);
        } else if (d51.a(jA, d51.p)) {
            qn0Var = new qn0(keyEvent.isShiftPressed() ? 2 : 1);
        } else if (d51.a(jA, d51.g)) {
            qn0Var = new qn0(4);
        } else if (d51.a(jA, d51.f)) {
            qn0Var = new qn0(3);
        } else if (d51.a(jA, d51.d) || d51.a(jA, d51.C)) {
            qn0Var = new qn0(5);
        } else if (d51.a(jA, d51.e) || d51.a(jA, d51.D)) {
            qn0Var = new qn0(6);
        } else if (d51.a(jA, d51.h) || d51.a(jA, d51.r) || d51.a(jA, d51.E)) {
            qn0Var = new qn0(7);
        } else {
            qn0Var = (d51.a(jA, d51.a) || d51.a(jA, d51.u)) ? new qn0(8) : null;
        }
        if (qn0Var != null) {
            int i = qn0Var.a;
            if (h51.b(keyEvent) == 2) {
                r7 r7Var = this.H;
                ((do0) r7Var.getFocusOwner()).getClass();
                Boolean boolE = ((do0) r7Var.getFocusOwner()).e(i, r7Var.getEmbeddedViewFocusRect(), new h6(1, qn0Var));
                if (boolE != null ? boolE.booleanValue() : true) {
                    return true;
                }
                if (i == 1 || i == 2) {
                    if (i == 5) {
                        num = 33;
                    } else if (i == 6) {
                        num = 130;
                    } else if (i == 3) {
                        num = 17;
                    } else if (i == 4) {
                        num = 66;
                    } else if (i == 1) {
                        num = 2;
                    } else if (i == 2) {
                        num = 1;
                    }
                    int iIntValue = num != null ? num.intValue() : 2;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    View rootView = r7Var.getRootView();
                    rootView.getClass();
                    View viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, r7Var.getView(), iIntValue);
                    if (viewFindNextFocus == null || viewFindNextFocus.equals(r7Var)) {
                        return ((do0) r7Var.getFocusOwner()).h(i);
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.sm
    public final Object c0(co1 co1Var, h7 h7Var, y50 y50Var) {
        long jU = co1Var.U(0L);
        l42 l42Var = (l42) h7Var.a();
        l42 l42VarI = l42Var != null ? l42Var.i(jU) : null;
        if (l42VarI != null) {
            this.H.requestRectangleOnScreen(new Rect((int) l42VarI.a, (int) l42VarI.b, (int) l42VarI.c, (int) l42VarI.d), false);
        }
        return q43.a;
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(j);
        return qh1Var.O(zw1VarE.a, zw1VarE.b, ji0.a, this.x, new d7(zw1VarE, 0));
    }

    @Override // defpackage.k51
    public final boolean k(KeyEvent keyEvent) {
        return false;
    }

    @Override // defpackage.t23
    public final Object p() {
        return "androidx.compose.ui.layout.WindowInsetsRulers";
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
    }
}
