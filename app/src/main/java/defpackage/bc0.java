package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bc0 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ cc0 b;

    public /* synthetic */ bc0(cc0 cc0Var, int i) {
        this.a = i;
        this.b = cc0Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        cc0 cc0Var = this.b;
        switch (i) {
            case 0:
                f82 f82Var = (f82) ij4.a(cc0Var, i82.a);
                lb lbVar = cc0Var.d0;
                if (f82Var == null) {
                    if (lbVar != null) {
                        cc0Var.J0(lbVar);
                    }
                    cc0Var.d0 = null;
                } else if (lbVar == null) {
                    q82 q82Var = new q82(cc0Var);
                    bc0 bc0Var = new bc0(cc0Var, 1);
                    ol1 ol1Var = cc0Var.X;
                    boolean z = cc0Var.Y;
                    float f = cc0Var.Z;
                    f33 f33Var = j82.a;
                    lb lbVar2 = new lb(ol1Var, z, f, q82Var, bc0Var);
                    cc0Var.I0(lbVar2);
                    cc0Var.d0 = lbVar2;
                }
                return q43.a;
            default:
                return a44.a;
        }
    }
}
