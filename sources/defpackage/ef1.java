package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ef1 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ wx2 b;

    public /* synthetic */ ef1(wx2 wx2Var, int i) {
        this.a = i;
        this.b = wx2Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        wx2 wx2Var = this.b;
        switch (i) {
            case 0:
                wx2Var.b(((jp1) obj).a, xy.Y);
                break;
            case 1:
                ny1 ny1Var = (ny1) obj;
                wx2Var.e(y11.f(ny1Var, false));
                ny1Var.a();
                break;
            default:
                ny1 ny1Var2 = (ny1) obj;
                wx2Var.e(y11.f(ny1Var2, false));
                ny1Var2.a();
                break;
        }
        return q43Var;
    }
}
