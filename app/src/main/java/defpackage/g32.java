package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g32 implements hr2, mm0, hr0 {
    public final /* synthetic */ hr2 a;

    public g32(jr2 jr2Var) {
        this.a = jr2Var;
    }

    @Override // defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) {
        return this.a.a(nm0Var, x50Var);
    }

    @Override // defpackage.hr0
    public final mm0 b(j70 j70Var, int i, nn nnVar) {
        return (((i < 0 || i >= 2) && i != -2) || nnVar != nn.b) ? s44.d(this, j70Var, i, nnVar) : this;
    }

    @Override // defpackage.hr2
    public final Object getValue() {
        return this.a.getValue();
    }
}
