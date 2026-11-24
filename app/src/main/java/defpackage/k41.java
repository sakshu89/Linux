package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k41 extends i41 {
    public final p41 k;
    public final l41 n;
    public final tx s;
    public final Object t;

    public k41(p41 p41Var, l41 l41Var, tx txVar, Object obj) {
        this.k = p41Var;
        this.n = l41Var;
        this.s = txVar;
        this.t = obj;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return false;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        tx txVar = this.s;
        tx txVarE0 = p41.e0(txVar);
        p41 p41Var = this.k;
        l41 l41Var = this.n;
        Object obj = this.t;
        if (txVarE0 == null || !p41Var.r0(l41Var, txVarE0, obj)) {
            l41Var.a.d(new rc1(2), 2);
            tx txVarE1 = p41.e0(txVar);
            if (txVarE1 == null || !p41Var.r0(l41Var, txVarE1, obj)) {
                p41Var.t(p41Var.M(l41Var, obj));
            }
        }
    }
}
