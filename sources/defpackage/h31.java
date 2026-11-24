package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h31 extends f72 {
    public int b;
    public final /* synthetic */ vq0 c;
    public final /* synthetic */ x50 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h31(x50 x50Var, x50 x50Var2, vq0 vq0Var) {
        super(x50Var);
        this.c = vq0Var;
        this.e = x50Var2;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                og.n("This coroutine had already completed");
                return null;
            }
            this.b = 2;
            bz3.g(obj);
            return obj;
        }
        this.b = 1;
        bz3.g(obj);
        vq0 vq0Var = this.c;
        vq0Var.getClass();
        h33.c(2, vq0Var);
        return vq0Var.e(this.e, this);
    }
}
