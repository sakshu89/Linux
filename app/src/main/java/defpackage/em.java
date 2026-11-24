package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class em extends ik1 {
    public final ll a;

    public em(ll llVar) {
        this.a = llVar;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        fm fmVar = new fm();
        fmVar.x = this.a;
        return fmVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        em emVar = obj instanceof em ? (em) obj : null;
        return emVar != null && this.a.equals(emVar.a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((fm) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.a.hashCode() * 31);
    }
}
