package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sl0 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ zw1 b;

    public /* synthetic */ sl0(zw1 zw1Var, int i) {
        this.a = i;
        this.b = zw1Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        zw1 zw1Var = this.b;
        yw1 yw1Var = (yw1) obj;
        switch (i) {
            case 0:
                yw1.k(yw1Var, zw1Var, 0, 0);
                break;
            case 1:
                if (yw1Var.e() == z61.a || yw1Var.f() == 0) {
                    yw1.a(yw1Var, zw1Var);
                    zw1Var.n0(e21.c(0L, zw1Var.f), 0.0f, null);
                } else {
                    long jF = ((long) (yw1Var.f() - zw1Var.a)) << 32;
                    yw1.a(yw1Var, zw1Var);
                    zw1Var.n0(e21.c(jF, zw1Var.f), 0.0f, null);
                }
                break;
            case 2:
                yw1.h(yw1Var, zw1Var, 0, 0);
                break;
            case 3:
                yw1.k(yw1Var, zw1Var, 0, 0);
                break;
            case 4:
                yw1.k(yw1Var, zw1Var, 0, 0);
                break;
            case 5:
                yw1.h(yw1Var, zw1Var, 0, 0);
                break;
            default:
                yw1.k(yw1Var, zw1Var, 0, 0);
                break;
        }
        return q43Var;
    }
}
