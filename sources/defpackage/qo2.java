package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qo2 implements nm0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ t42 b;
    public final /* synthetic */ so2 c;

    public qo2(t42 t42Var, so2 so2Var) {
        this.b = t42Var;
        this.c = so2Var;
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        Object value;
        int i = this.a;
        q43 q43Var = q43.a;
        so2 so2Var = this.c;
        t42 t42Var = this.b;
        switch (i) {
            case 0:
                z83 z83Var = (z83) obj;
                jr2 jr2Var = so2Var.o;
                if (z83Var instanceof u83) {
                    Float f = new Float(((u83) z83Var).a);
                    jr2Var.getClass();
                    jr2Var.j(null, f);
                } else if (!g31.a(z83Var, v83.a)) {
                    if (!g31.a(z83Var, r83.a)) {
                        t42Var.a = z83Var;
                    } else {
                        Float f2 = new Float(0.0f);
                        jr2Var.getClass();
                        jr2Var.j(null, f2);
                        jr2 jr2Var2 = so2Var.n;
                        do {
                            value = jr2Var2.getValue();
                        } while (!jr2Var2.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32511)));
                    }
                }
                break;
            default:
                e5 e5Var = (e5) obj;
                if (!(e5Var instanceof z4)) {
                    so2Var.t(e5Var);
                } else {
                    t42Var.a = e5Var;
                }
                break;
        }
        return q43Var;
    }

    public qo2(so2 so2Var, t42 t42Var) {
        this.c = so2Var;
        this.b = t42Var;
    }
}
