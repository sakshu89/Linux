package defpackage;

import android.os.Build;
import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t11 extends hz implements Runnable, up1, View.OnAttachStateChangeListener {
    public final tb3 c;
    public boolean e;
    public boolean f;
    public pb3 i;

    public t11(tb3 tb3Var) {
        super(!tb3Var.s ? 1 : 0);
        this.c = tb3Var;
    }

    @Override // defpackage.up1
    public final pb3 a(View view, pb3 pb3Var) {
        this.i = pb3Var;
        tb3 tb3Var = this.c;
        i63 i63Var = tb3Var.q;
        lb3 lb3Var = pb3Var.a;
        i63Var.f(uf4.c(lb3Var.f(8)));
        if (this.e) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.f) {
            tb3Var.r.f(uf4.c(lb3Var.f(8)));
            tb3.a(tb3Var, pb3Var);
        }
        return tb3Var.s ? pb3.b : pb3Var;
    }

    @Override // defpackage.hz
    public final void e(xa3 xa3Var) {
        this.e = false;
        this.f = false;
        pb3 pb3Var = this.i;
        if (xa3Var.a.b() > 0 && pb3Var != null) {
            lb3 lb3Var = pb3Var.a;
            tb3 tb3Var = this.c;
            tb3Var.r.f(uf4.c(lb3Var.f(8)));
            tb3Var.q.f(uf4.c(lb3Var.f(8)));
            tb3.a(tb3Var, pb3Var);
        }
        this.i = null;
    }

    @Override // defpackage.hz
    public final void f() {
        this.e = true;
        this.f = true;
    }

    @Override // defpackage.hz
    public final pb3 g(pb3 pb3Var, List list) {
        tb3 tb3Var = this.c;
        tb3.a(tb3Var, pb3Var);
        return tb3Var.s ? pb3.b : pb3Var;
    }

    @Override // defpackage.hz
    public final cu2 h(xa3 xa3Var, cu2 cu2Var) {
        this.e = false;
        return cu2Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e) {
            this.e = false;
            this.f = false;
            pb3 pb3Var = this.i;
            if (pb3Var != null) {
                tb3 tb3Var = this.c;
                tb3Var.r.f(uf4.c(pb3Var.a.f(8)));
                tb3.a(tb3Var, pb3Var);
                this.i = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
