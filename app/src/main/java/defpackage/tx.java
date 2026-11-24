package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tx extends i41 implements sx {
    public final p41 k;

    public tx(p41 p41Var) {
        this.k = p41Var;
    }

    @Override // defpackage.sx
    public final boolean b(Throwable th) {
        return p().I(th);
    }

    @Override // defpackage.i41
    public final boolean q() {
        return true;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        this.k.A(p());
    }
}
