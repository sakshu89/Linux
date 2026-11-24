package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class q81 extends ik1 {
    public final t81 a;

    public q81(t81 t81Var) {
        this.a = t81Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        r81 r81Var = new r81();
        r81Var.x = this.a;
        return r81Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q81) && this.a == ((q81) obj).a;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        r81 r81Var = (r81) dk1Var;
        t81 t81Var = r81Var.x;
        t81 t81Var2 = this.a;
        if (g31.a(t81Var, t81Var2) || !r81Var.a.w) {
            return;
        }
        t81 t81Var3 = r81Var.x;
        t81Var3.c();
        t81Var3.b = null;
        r81Var.x = t81Var2;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DisplayingDisappearingItemsElement(animator=" + this.a + ')';
    }
}
