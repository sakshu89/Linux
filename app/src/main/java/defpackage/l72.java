package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l72 extends i41 {
    public final j41 k;

    public l72(j41 j41Var) {
        this.k = j41Var;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return false;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) {
        Object objU = p().U();
        boolean z = objU instanceof a10;
        j41 j41Var = this.k;
        if (z) {
            j41Var.h(bz3.f(((a10) objU).a));
        } else {
            j41Var.h(tz3.e(objU));
        }
    }
}
