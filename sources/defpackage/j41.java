package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j41 extends yv {
    public final x00 t;

    public j41(x50 x50Var, x00 x00Var) {
        super(1, x50Var);
        this.t = x00Var;
    }

    @Override // defpackage.yv
    public final String D() {
        return "AwaitContinuation";
    }

    @Override // defpackage.yv
    public final Throwable s(p41 p41Var) {
        Throwable thD;
        Object objU = this.t.U();
        if (!(objU instanceof l41) || (thD = ((l41) objU).d()) == null) {
            return objU instanceof a10 ? ((a10) objU).a : p41Var.x();
        }
        return thD;
    }
}
