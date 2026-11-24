package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class rl0 extends ik1 {
    public final ed0 a;
    public final float b;

    public rl0(ed0 ed0Var, float f) {
        this.a = ed0Var;
        this.b = f;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        tl0 tl0Var = new tl0();
        tl0Var.x = this.a;
        tl0Var.H = this.b;
        return tl0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rl0)) {
            return false;
        }
        rl0 rl0Var = (rl0) obj;
        return this.a == rl0Var.a && this.b == rl0Var.b;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        tl0 tl0Var = (tl0) dk1Var;
        tl0Var.x = this.a;
        tl0Var.H = this.b;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (this.a.hashCode() * 31);
    }
}
