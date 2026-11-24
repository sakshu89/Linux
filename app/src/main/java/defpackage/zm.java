package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zm extends dk1 implements sm, w61 {
    public boolean H;
    public k50 x;

    public static final l42 I0(zm zmVar, co1 co1Var, h7 h7Var) {
        l42 l42Var;
        if (zmVar.w && zmVar.H) {
            co1 co1VarF = cm4.f(zmVar);
            if (!co1Var.V0().w) {
                co1Var = null;
            }
            if (co1Var != null && (l42Var = (l42) h7Var.a()) != null) {
                return l42Var.i(co1VarF.N(co1Var, false).d());
            }
        }
        return null;
    }

    @Override // defpackage.sm
    public final Object c0(co1 co1Var, h7 h7Var, y50 y50Var) {
        Object objC = tl4.c(new p(this, co1Var, h7Var, new ek(this, co1Var, h7Var, 1), null, 1), y50Var);
        return objC == t70.a ? objC : q43.a;
    }

    @Override // defpackage.w61
    public final void o(y61 y61Var) {
        this.H = true;
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
