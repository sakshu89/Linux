package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class za3 extends db3 {
    public final WindowInsets.Builder c;

    public za3(pb3 pb3Var) {
        super(pb3Var);
        WindowInsets windowInsetsA = pb3Var.a();
        this.c = windowInsetsA != null ? k33.h(windowInsetsA) : k33.g();
    }

    @Override // defpackage.db3
    public pb3 b() {
        a();
        pb3 pb3VarB = pb3.b(this.c.build(), null);
        pb3VarB.a.p(this.b);
        return pb3VarB;
    }

    @Override // defpackage.db3
    public void d(q11 q11Var) {
        this.c.setMandatorySystemGestureInsets(q11Var.d());
    }

    @Override // defpackage.db3
    public void e(q11 q11Var) {
        this.c.setSystemGestureInsets(q11Var.d());
    }

    @Override // defpackage.db3
    public void f(q11 q11Var) {
        this.c.setSystemWindowInsets(q11Var.d());
    }

    @Override // defpackage.db3
    public void g(q11 q11Var) {
        this.c.setTappableElementInsets(q11Var.d());
    }

    public za3() {
        this.c = k33.g();
    }
}
