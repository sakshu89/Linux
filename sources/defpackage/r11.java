package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r11 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ gv2 b;

    public /* synthetic */ r11(gv2 gv2Var, int i) {
        this.a = i;
        this.b = gv2Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        gv2 gv2Var = this.b;
        t23 t23Var = (t23) obj;
        switch (i) {
            case 0:
                t23Var.getClass();
                gv2 gv2Var2 = (gv2) t23Var;
                na3 na3Var = gv2Var.H;
                if (!g31.a(gv2Var2.x, na3Var)) {
                    gv2Var2.x = na3Var;
                    gv2Var2.I0();
                }
                return s23.b;
            default:
                t23Var.getClass();
                gv2Var.x = ((gv2) t23Var).H;
                return Boolean.FALSE;
        }
    }
}
