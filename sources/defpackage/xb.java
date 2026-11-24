package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xb implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ fc b;

    public /* synthetic */ xb(fc fcVar, int i) {
        this.a = i;
        this.b = fcVar;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        fc fcVar = this.b;
        switch (i) {
            case 0:
                fq0 fq0Var = (fq0) obj;
                View view = fcVar.a;
                Handler handler = view.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    fq0Var.a();
                } else {
                    Handler handler2 = view.getHandler();
                    if (handler2 != null) {
                        handler2.post(new m4(fq0Var, 2));
                    }
                }
                return q43Var;
            case 1:
                ActionMode actionMode = fcVar.h;
                if (actionMode != null) {
                    actionMode.invalidate();
                }
                return q43Var;
            case 2:
                ActionMode actionMode2 = fcVar.h;
                if (actionMode2 != null) {
                    actionMode2.invalidateContentRect();
                }
                return q43Var;
            default:
                fcVar.e.d();
                return new g8(2, fcVar);
        }
    }
}
