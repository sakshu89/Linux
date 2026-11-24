package defpackage;

import android.view.ActionMode;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fc implements lx2 {
    public final View a;
    public final hq0 b;
    public final fq0 c;
    public final xm1 d = new xm1();
    public final wm2 e = new wm2(new xb(this, 0));
    public final xb f = new xb(this, 1);
    public final xb g = new xb(this, 2);
    public ActionMode h;
    public dc i;
    public Runnable j;

    public fc(View view, hq0 hq0Var, fq0 fq0Var) {
        this.a = view;
        this.b = hq0Var;
        this.c = fq0Var;
    }

    @Override // defpackage.lx2
    public final Object a(dx2 dx2Var, nu2 nu2Var) {
        x50 x50Var = null;
        ec ecVar = new ec(this, dx2Var, x50Var, 0);
        xm1 xm1Var = this.d;
        xm1Var.getClass();
        Object objC = tl4.c(new cd(xm1Var, ecVar, x50Var, 3), nu2Var);
        return objC == t70.a ? objC : q43.a;
    }
}
