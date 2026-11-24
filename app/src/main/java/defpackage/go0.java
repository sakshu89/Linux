package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class go0 extends ik1 {
    public final fo0 a;

    public go0(fo0 fo0Var) {
        this.a = fo0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        io0 io0Var = new io0();
        io0Var.x = this.a;
        return io0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof go0) && g31.a(this.a, ((go0) obj).a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        io0 io0Var = (io0) dk1Var;
        io0Var.x.a.k(io0Var);
        fo0 fo0Var = this.a;
        io0Var.x = fo0Var;
        fo0Var.a.b(io0Var);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "FocusRequesterElement(focusRequester=" + this.a + ')';
    }
}
