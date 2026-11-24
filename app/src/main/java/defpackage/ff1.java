package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ff1 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ wx2 b;

    public /* synthetic */ ff1(wx2 wx2Var, int i) {
        this.a = i;
        this.b = wx2Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        q43 q43Var = q43.a;
        wx2 wx2Var = this.b;
        switch (i) {
            case 0:
                wx2Var.a();
                break;
            default:
                wx2Var.onCancel();
                break;
        }
        return q43Var;
    }
}
