package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t01 implements fq0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ t01(gj2 gj2Var, zm2 zm2Var, hq0 hq0Var, mm1 mm1Var) {
        this.b = gj2Var;
        this.c = zm2Var;
        this.e = hq0Var;
        this.f = mm1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj = this.f;
        Object obj2 = this.e;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i) {
            case 0:
                Float f = (Float) obj4;
                q01 q01Var = (q01) obj2;
                Float f2 = (Float) obj3;
                p01 p01Var = (p01) obj;
                if (!f.equals(q01Var.a) || !f2.equals(q01Var.b)) {
                    q01Var.a = f;
                    q01Var.b = f2;
                    q01Var.e = new wv2(p01Var, eb4.a, f, f2, null);
                    q01Var.k.b.setValue(Boolean.TRUE);
                    q01Var.f = false;
                    q01Var.i = true;
                }
                break;
            default:
                gj2 gj2Var = (gj2) obj4;
                zm2 zm2Var = (zm2) obj3;
                hq0 hq0Var = (hq0) obj2;
                mm1 mm1Var = (mm1) obj;
                if (!cs2.A((String) mm1Var.getValue()) && !(gj2Var.f instanceof q51)) {
                    if (zm2Var != null) {
                        ((ac0) zm2Var).a();
                    }
                    hq0Var.j((String) mm1Var.getValue());
                    mm1Var.setValue("");
                }
                break;
        }
        return q43Var;
    }

    public /* synthetic */ t01(Float f, q01 q01Var, Float f2, p01 p01Var) {
        this.b = f;
        this.e = q01Var;
        this.c = f2;
        this.f = p01Var;
    }
}
