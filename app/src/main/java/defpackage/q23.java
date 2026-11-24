package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q23 {
    public final pj a;
    public final qi0 b;
    public final b23 c;
    public final r23 d;

    public q23(pj pjVar, qi0 qi0Var, b23 b23Var, r23 r23Var) {
        this.a = pjVar;
        this.b = qi0Var;
        this.c = b23Var;
        this.d = r23Var;
    }

    public final void a(gi giVar) {
        r23 r23Var = this.d;
        ya0 ya0Var = r23Var.c;
        v02 v02Var = giVar.b;
        pj pjVar = this.a;
        String str = pjVar.a;
        if (str == null) {
            dk0.n("Null backendName");
            return;
        }
        pj pjVar2 = new pj(str, pjVar.b, v02Var);
        lj1 lj1Var = new lj1(2);
        lj1Var.g = new HashMap();
        lj1Var.e = Long.valueOf(r23Var.a.h());
        lj1Var.f = Long.valueOf(r23Var.b.h());
        lj1Var.b = "FIREBASE_ML_SDK";
        lj1Var.d = new ni0(this.b, (byte[]) this.c.apply(giVar.a));
        lj1Var.c = null;
        ya0Var.b.execute(new wa0(ya0Var, pjVar2, lj1Var.c()));
    }
}
