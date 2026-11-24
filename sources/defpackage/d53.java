package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class d53 extends ik1 {
    public final float a;
    public final float b;

    public d53(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        e53 e53Var = new e53();
        e53Var.x = this.a;
        e53Var.H = this.b;
        return e53Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d53)) {
            return false;
        }
        d53 d53Var = (d53) obj;
        return de0.b(this.a, d53Var.a) && de0.b(this.b, d53Var.b);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        e53 e53Var = (e53) dk1Var;
        e53Var.x = this.a;
        e53Var.H = this.b;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }
}
