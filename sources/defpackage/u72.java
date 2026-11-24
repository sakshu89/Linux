package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u72 implements ae0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ y72 b;

    public /* synthetic */ u72(y72 y72Var, int i) {
        this.a = i;
        this.b = y72Var;
    }

    @Override // defpackage.ae0
    public final double c(double d) {
        int i = this.a;
        y72 y72Var = this.b;
        switch (i) {
            case 0:
                return ky3.a(y72Var.k.c(d), y72Var.e, y72Var.f);
            default:
                return y72Var.n.c(ky3.a(d, y72Var.e, y72Var.f));
        }
    }
}
