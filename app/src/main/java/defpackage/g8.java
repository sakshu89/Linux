package defpackage;

import android.view.ActionMode;
import com.project.sonic.R;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g8 implements pd0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g8(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.pd0
    public final void a() throws IllegalAccessException, InvocationTargetException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((sd0) obj).b.a();
                break;
            case 1:
                yy1 yy1Var = (yy1) obj;
                pc3 pc3Var = yy1Var.c;
                if (pc3Var != null) {
                    pc3Var.a();
                }
                yy1Var.c = null;
                yy1Var.requestLayout();
                yy1Var.setTag(R.id.view_tree_lifecycle_owner, null);
                yy1Var.x.removeViewImmediate(yy1Var);
                break;
            case 2:
                fc fcVar = (fc) obj;
                wm2 wm2Var = fcVar.e;
                zq zqVar = wm2Var.h;
                if (zqVar != null) {
                    zqVar.a();
                }
                wm2Var.a();
                ActionMode actionMode = fcVar.h;
                if (actionMode != null) {
                    actionMode.finish();
                }
                fcVar.h = null;
                break;
            case 3:
                Iterator it = ((jk) obj).b.iterator();
                while (it.hasNext()) {
                    ((vv) it.next()).cancel();
                }
                break;
            case 4:
                vk vkVar = (vk) ((wk) obj).c.getValue();
                if (vkVar != null) {
                    vkVar.close();
                }
                break;
            case 5:
                ((ny2) obj).o();
                break;
            case 6:
                ((u81) obj).d = null;
                break;
            case 7:
                f91 f91Var = (f91) obj;
                a50 a50Var = f91Var.c;
                if (a50Var != null) {
                    a50Var.b = false;
                }
                f91Var.c = null;
                break;
            case 8:
                ((a91) obj).f = true;
                break;
            case 9:
                mm1 mm1Var = (mm1) obj;
                if (((b02) mm1Var.getValue()) != null) {
                    mm1Var.setValue(null);
                }
                break;
            default:
                ((j23) obj).i();
                break;
        }
    }
}
