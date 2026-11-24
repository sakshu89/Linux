package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yb implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ fc b;
    public final /* synthetic */ dx2 c;

    public /* synthetic */ yb(fc fcVar, dx2 dx2Var, int i) {
        this.a = i;
        this.b = fcVar;
        this.c = dx2Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        int i2 = 0;
        dx2 dx2Var = this.c;
        fc fcVar = this.b;
        switch (i) {
            case 0:
                xb xbVar = fcVar.f;
                kb kbVar = new kb(1, dx2Var);
                t42 t42Var = new t42();
                fcVar.e.c("dataBuilder", xbVar, new zb(i2, t42Var, kbVar));
                Object obj = t42Var.a;
                if (obj != null) {
                    return (cx2) obj;
                }
                g31.f("result");
                throw null;
            case 1:
                xb xbVar2 = fcVar.g;
                yb ybVar = new yb(fcVar, dx2Var, 2);
                t42 t42Var2 = new t42();
                fcVar.e.c("positioner", xbVar2, new zb(i2, t42Var2, ybVar));
                Object obj2 = t42Var2.a;
                if (obj2 != null) {
                    return (l42) obj2;
                }
                g31.f("result");
                throw null;
            default:
                Object objA = fcVar.c.a();
                y61 y61Var = (y61) (((y61) objA).B() ? objA : null);
                return y61Var == null ? l42.e : dx2Var.m(y61Var).i(y61Var.U(0L));
        }
    }
}
