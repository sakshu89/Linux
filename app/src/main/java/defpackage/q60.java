package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q60 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ua1 b;

    public /* synthetic */ q60(ua1 ua1Var, int i) {
        this.a = i;
        this.b = ua1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        ua1 ua1Var = this.b;
        switch (i) {
            case 0:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                ua1Var.q.setValue(bool);
                return q43Var;
            case 1:
                y61 y61Var = (y61) obj;
                hz2 hz2VarD = ua1Var.d();
                if (hz2VarD != null) {
                    hz2VarD.c = y61Var;
                }
                return q43Var;
            case 2:
                ku1 ku1Var = ua1Var.t;
                ty2 ty2Var = (ty2) obj;
                String str = ty2Var.a.b;
                be beVar = ua1Var.j;
                if (!g31.a(str, beVar != null ? beVar.b : null)) {
                    ua1Var.k.setValue(rv0.a);
                    if (((Boolean) ku1Var.getValue()).booleanValue()) {
                        ku1Var.setValue(Boolean.FALSE);
                    } else {
                        ua1Var.s.setValue(Boolean.FALSE);
                    }
                }
                long j = oz2.b;
                ua1Var.f(j);
                ua1Var.e(j);
                ua1Var.u.j(ty2Var);
                a42 a42Var = ua1Var.b;
                g30 g30Var = a42Var.a;
                if (g30Var != null) {
                    g30Var.s(a42Var, null);
                }
                return q43Var;
            case 3:
                ua1Var.r.A(((jz0) obj).a);
                return q43Var;
            default:
                return Boolean.valueOf(ua1Var.r.A(((jz0) obj).a));
        }
    }
}
