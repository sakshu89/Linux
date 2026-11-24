package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hy2 extends nu2 implements hq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ny2 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hy2(ny2 ny2Var, x50 x50Var, int i) {
        super(1, x50Var);
        this.f = i;
        this.i = ny2Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        ny2 ny2Var = this.i;
        x50 x50Var = (x50) obj;
        switch (i) {
            case 0:
                new hy2(ny2Var, x50Var, 0).s(q43Var);
                break;
            case 1:
                new hy2(ny2Var, x50Var, 1).s(q43Var);
                break;
            case 2:
                new hy2(ny2Var, x50Var, 2).s(q43Var);
                break;
            default:
                new hy2(ny2Var, x50Var, 3).s(q43Var);
                break;
        }
        return q43Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.f;
        q43 q43Var = q43.a;
        ny2 ny2Var = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                ny2Var.B = false;
                break;
            case 1:
                bz3.g(obj);
                ny2Var.f();
                break;
            case 2:
                bz3.g(obj);
                ny2Var.d(ny2Var.B);
                break;
            default:
                bz3.g(obj);
                ny2Var.p();
                break;
        }
        return q43Var;
    }
}
