package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m41 extends i41 {
    public final gf2 k;
    public final /* synthetic */ p41 n;

    public m41(p41 p41Var, gf2 gf2Var) {
        this.n = p41Var;
        this.k = gf2Var;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return false;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        p41 p41Var = this.n;
        Object objU = p41Var.U();
        if (!(objU instanceof a10)) {
            objU = tz3.e(objU);
        }
        this.k.j(p41Var, objU);
    }
}
