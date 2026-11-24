package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class fb3 extends eb3 {
    public q11 n;

    public fb3(pb3 pb3Var, WindowInsets windowInsets) {
        super(pb3Var, windowInsets);
        this.n = null;
    }

    @Override // defpackage.lb3
    public pb3 b() {
        return pb3.b(this.c.consumeStableInsets(), null);
    }

    @Override // defpackage.lb3
    public pb3 c() {
        return pb3.b(this.c.consumeSystemWindowInsets(), null);
    }

    @Override // defpackage.lb3
    public final q11 i() {
        if (this.n == null) {
            WindowInsets windowInsets = this.c;
            this.n = q11.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.n;
    }

    @Override // defpackage.lb3
    public boolean m() {
        return this.c.isConsumed();
    }

    @Override // defpackage.lb3
    public void r(q11 q11Var) {
        this.n = q11Var;
    }
}
