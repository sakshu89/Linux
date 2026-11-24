package defpackage;

import android.view.View;
import android.view.Window;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h10 implements lb1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h10(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.lb1
    public final void j(ob1 ob1Var, db1 db1Var) {
        Window window;
        View viewPeekDecorView;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                n10 n10Var = (n10) obj;
                if (db1Var == db1.ON_STOP && (window = n10Var.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                n10 n10Var2 = (n10) obj;
                if (db1Var == db1.ON_DESTROY) {
                    n10Var2.b.b = null;
                    if (!n10Var2.isChangingConfigurations()) {
                        LinkedHashMap linkedHashMap = n10Var2.c().a;
                        Iterator it = linkedHashMap.values().iterator();
                        while (it.hasNext()) {
                            ((b83) it.next()).b();
                        }
                        linkedHashMap.clear();
                    }
                    l10 l10Var = n10Var2.i;
                    n10 n10Var3 = l10Var.e;
                    n10Var3.getWindow().getDecorView().removeCallbacks(l10Var);
                    n10Var3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(l10Var);
                }
                break;
            default:
                ma2 ma2Var = (ma2) obj;
                if (db1Var == db1.ON_START) {
                    ma2Var.h = true;
                } else if (db1Var == db1.ON_STOP) {
                    ma2Var.h = false;
                }
                break;
        }
    }
}
