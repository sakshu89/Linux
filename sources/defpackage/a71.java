package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class a71 extends ik1 {
    public final wq0 a;

    public a71(wq0 wq0Var) {
        this.a = wq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        e71 e71Var = new e71();
        e71Var.x = this.a;
        return e71Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a71) {
            return this.a == ((a71) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((e71) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
