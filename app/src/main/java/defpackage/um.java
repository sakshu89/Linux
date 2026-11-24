package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class um extends ik1 {
    public final wm a;

    public um(wm wmVar) {
        this.a = wmVar;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        xm xmVar = new xm();
        xmVar.x = this.a;
        return xmVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof um) {
            return g31.a(this.a, ((um) obj).a);
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        xm xmVar = (xm) dk1Var;
        wm wmVar = xmVar.x;
        if (wmVar != null) {
            wmVar.a.k(xmVar);
        }
        wm wmVar2 = this.a;
        if (wmVar2 != null) {
            wmVar2.a.b(xmVar);
        }
        xmVar.x = wmVar2;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
