package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q63 extends tt1 {
    public final ku1 e = o44.g(new xk2(0));
    public final ku1 f = o44.g(Boolean.FALSE);
    public final k63 g;
    public final ku1 h;
    public float i;
    public nl j;

    public q63(kv0 kv0Var) {
        k63 k63Var = new k63(kv0Var);
        k63Var.f = new ta(18, this);
        this.g = k63Var;
        this.h = new ku1(q43.a, el1.f);
        this.i = 1.0f;
    }

    @Override // defpackage.tt1
    public final void a(float f) {
        this.i = f;
    }

    @Override // defpackage.tt1
    public final void b(nl nlVar) {
        this.j = nlVar;
    }

    @Override // defpackage.tt1
    public final long d() {
        return ((xk2) this.e.getValue()).a;
    }

    @Override // defpackage.tt1
    public final void e(p71 p71Var) {
        ew ewVar = p71Var.a;
        nl nlVar = this.j;
        k63 k63Var = this.g;
        if (nlVar == null) {
            nlVar = (nl) k63Var.g.getValue();
        }
        if (((Boolean) this.f.getValue()).booleanValue() && p71Var.getLayoutDirection() == z61.b) {
            long jX = ewVar.X();
            kf kfVar = ewVar.b;
            long jR = kfVar.r();
            kfVar.m().m();
            try {
                ((q82) kfVar.b).H(-1.0f, 1.0f, jX);
                k63Var.e(p71Var, this.i, nlVar);
                cq.t(kfVar, jR);
            } catch (Throwable th) {
                cq.t(kfVar, jR);
                throw th;
            }
        } else {
            k63Var.e(p71Var, this.i, nlVar);
        }
        this.h.getValue();
    }
}
