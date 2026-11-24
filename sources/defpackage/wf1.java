package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wf1 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ xf1 b;

    public /* synthetic */ wf1(xf1 xf1Var, int i) {
        this.a = i;
        this.b = xf1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        xf1 xf1Var = this.b;
        switch (i) {
            case 0:
                xf1Var.K0();
                return q43.a;
            case 1:
                return new jp1(xf1Var.f0);
            default:
                y61 y61Var = (y61) xf1Var.d0.getValue();
                return new jp1(y61Var != null ? y61Var.U(0L) : 9205357640488583168L);
        }
    }
}
