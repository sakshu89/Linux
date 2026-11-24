package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class r4 extends ik1 {
    public final km a;

    public r4(km kmVar) {
        this.a = kmVar;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        s4 s4Var = new s4();
        s4Var.X = this.a;
        x0 x0Var = new x0(3, s4Var);
        q4 q4Var = new q4();
        q4Var.x = x0Var;
        s4Var.I0(q4Var);
        return s4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r4) {
            return this.a == ((r4) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((s4) dk1Var).X = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
