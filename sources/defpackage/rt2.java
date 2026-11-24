package defpackage;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rt2 extends ob0 {
    public final wp o;
    public final tp p;
    public ob0 q;
    public xt2 r;

    public rt2(Size size, int i) {
        super(size, i);
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.p = tpVar;
            tpVar.a = "SettableFuture hashCode: " + hashCode();
        } catch (Exception e) {
            wpVar.b(e);
        }
        this.o = wpVar;
    }

    @Override // defpackage.ob0
    public final void a() {
        super.a();
        vc4.d(new nt2(this, 2));
    }

    @Override // defpackage.ob0
    public final wc1 f() {
        return this.o;
    }

    public final boolean g(ob0 ob0Var, Runnable runnable) {
        boolean z;
        Size size = this.h;
        vc4.b();
        ob0Var.getClass();
        int i = ob0Var.i;
        Size size2 = ob0Var.h;
        ob0 ob0Var2 = this.q;
        if (ob0Var2 == ob0Var) {
            return false;
        }
        hh1.e("A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider", ob0Var2 == null);
        hh1.a("The provider's size(" + size + ") must match the parent(" + size2 + ")", size.equals(size2));
        int i2 = this.i;
        hh1.a(cq.i("The provider's format(", i2, ") must match the parent(", i, ")"), i2 == i);
        synchronized (this.a) {
            z = this.c;
        }
        hh1.e("The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.", !z);
        this.q = ob0Var;
        oz3.f(true, ob0Var.c(), this.p, xg4.a());
        ob0Var.d();
        oz3.e(this.e).a(new ot2(ob0Var, 1), xg4.a());
        oz3.e(ob0Var.g).a(runnable, xg4.c());
        return true;
    }
}
