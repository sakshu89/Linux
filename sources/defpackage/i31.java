package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i31 extends y50 {
    public int e;
    public final /* synthetic */ vq0 f;
    public final /* synthetic */ x50 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i31(x50 x50Var, j70 j70Var, vq0 vq0Var, x50 x50Var2) {
        super(x50Var, j70Var);
        this.f = vq0Var;
        this.i = x50Var2;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                og.n("This coroutine had already completed");
                return null;
            }
            this.e = 2;
            bz3.g(obj);
            return obj;
        }
        this.e = 1;
        bz3.g(obj);
        vq0 vq0Var = this.f;
        vq0Var.getClass();
        h33.c(2, vq0Var);
        return vq0Var.e(this.i, this);
    }
}
