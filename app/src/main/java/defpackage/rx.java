package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rx extends i41 {
    public final yv k;

    public rx(yv yvVar) {
        this.k = yvVar;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return true;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        p41 p41VarP = p();
        yv yvVar = this.k;
        Throwable thS = yvVar.s(p41VarP);
        if (!yvVar.B() ? false : ((hd0) yvVar.e).r(thS)) {
            return;
        }
        yvVar.m(thS);
        if (yvVar.B()) {
            return;
        }
        yvVar.q();
    }
}
