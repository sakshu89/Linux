package defpackage;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.project.sonic.R;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oc3 extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ pc3 c;
    public final /* synthetic */ vq0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ oc3(pc3 pc3Var, vq0 vq0Var, int i) {
        super(2);
        this.b = i;
        this.c = pc3Var;
        this.e = vq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        vq0 vq0Var = this.e;
        pc3 pc3Var = this.c;
        int i2 = 1;
        int i3 = 0;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    AndroidCompositionLocals_androidKt.a(pc3Var.a, vq0Var, x20Var, 0);
                }
                break;
            default:
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var2.R();
                } else {
                    r7 r7Var = pc3Var.a;
                    Object tag = r7Var.getTag(R.id.inspection_slot_table_set);
                    x50 x50Var = null;
                    Set set = (!(tag instanceof Set) || ((tag instanceof x41) && !(tag instanceof a51))) ? null : (Set) tag;
                    if (set == null) {
                        Object parent = r7Var.getParent();
                        View view = parent instanceof View ? (View) parent : null;
                        Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                        set = (!(tag2 instanceof Set) || ((tag2 instanceof x41) && !(tag2 instanceof a51))) ? null : (Set) tag2;
                    }
                    if (set != null) {
                        set.add(x20Var2.w());
                        x20Var2.q = true;
                        x20Var2.C = true;
                        x20Var2.c.b();
                        x20Var2.H.b();
                        rl2 rl2Var = x20Var2.I;
                        ol2 ol2Var = rl2Var.a;
                        rl2Var.e = ol2Var.s;
                        rl2Var.f = ol2Var.t;
                    }
                    boolean zH = x20Var2.h(pc3Var);
                    Object objL = x20Var2.L();
                    xy xyVar = r20.a;
                    if (zH || objL == xyVar) {
                        objL = new nc3(pc3Var, x50Var, i3);
                        x20Var2.g0(objL);
                    }
                    bz3.c(x20Var2, (vq0) objL, r7Var);
                    boolean zH2 = x20Var2.h(pc3Var);
                    Object objL2 = x20Var2.L();
                    if (zH2 || objL2 == xyVar) {
                        objL2 = new nc3(pc3Var, x50Var, i2);
                        x20Var2.g0(objL2);
                    }
                    bz3.c(x20Var2, (vq0) objL2, r7Var);
                    kj4.a(w11.a.a(set), yi4.b(-280240369, new oc3(pc3Var, vq0Var, i3), x20Var2), x20Var2, 56);
                }
                break;
        }
        return q43Var;
    }
}
