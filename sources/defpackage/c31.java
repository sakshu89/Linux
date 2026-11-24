package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class c31 extends ik1 {
    @Override // defpackage.ik1
    public final dk1 e() {
        e31 e31Var = new e31();
        e31Var.x = b31.b;
        e31Var.H = true;
        return e31Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c31 ? (c31) obj : null) != null;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        e31 e31Var = (e31) dk1Var;
        e31Var.x = b31.b;
        e31Var.H = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (b31.b.hashCode() * 31);
    }
}
