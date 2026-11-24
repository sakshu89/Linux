package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class u23 extends ik1 {
    public final f91 a;

    public u23(f91 f91Var) {
        this.a = f91Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        v23 v23Var = new v23();
        v23Var.x = this.a;
        return v23Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u23) && g31.a(this.a, ((u23) obj).a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((v23) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.a + ')';
    }
}
