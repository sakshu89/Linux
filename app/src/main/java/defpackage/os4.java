package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class os4 implements hs4 {
    public final g81 a;
    public final gs4 b;

    public os4(Context context, gs4 gs4Var) {
        this.b = gs4Var;
        po poVar = po.e;
        r23.b(context);
        b13 b13VarC = r23.a().c(poVar);
        if (po.d.contains(new qi0("json"))) {
            new g81(new rk4(2, b13VarC));
        }
        this.a = new g81(new rk4(3, b13VarC));
    }

    @Override // defpackage.hs4
    public final void a(t9 t9Var) {
        this.b.getClass();
        ((q23) this.a.get()).a(t9Var.b != 0 ? new gi(t9Var.j(), v02.a) : new gi(t9Var.j(), v02.b));
    }
}
