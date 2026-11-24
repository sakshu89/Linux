package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d70 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ f70 b;

    public /* synthetic */ d70(f70 f70Var, int i) {
        this.a = i;
        this.b = f70Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        q43 q43Var = q43.a;
        f70 f70Var = this.b;
        switch (i) {
            case 0:
                cm4.d(f70Var);
                return q43Var;
            case 1:
                f70Var.f0.h(true);
                break;
            case 2:
                f70Var.f0.d(true);
                break;
            case 3:
                f70Var.f0.f();
                break;
            case 4:
                cm4.d(f70Var);
                return q43Var;
            case 5:
                f70Var.f0.p();
                break;
            case 6:
                q60 q60Var = f70Var.Z.w;
                q60Var.b.r.A(f70Var.g0.e);
                break;
            default:
                ua1 ua1Var = f70Var.Z;
                fo0 fo0Var = f70Var.h0;
                if (ua1Var.b()) {
                    zm2 zm2Var = ua1Var.c;
                    if (zm2Var != null) {
                        ((ac0) zm2Var).b();
                    }
                } else {
                    fo0.a(fo0Var);
                }
                return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }
}
