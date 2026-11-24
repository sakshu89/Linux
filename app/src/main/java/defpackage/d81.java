package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d81 extends ik1 {
    public final float a;
    public final boolean b;

    public d81(float f, boolean z) {
        this.a = f;
        this.b = z;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        e81 e81Var = new e81();
        e81Var.x = this.a;
        e81Var.H = this.b;
        return e81Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        d81 d81Var = obj instanceof d81 ? (d81) obj : null;
        return d81Var != null && this.a == d81Var.a && this.b == d81Var.b;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        e81 e81Var = (e81) dk1Var;
        e81Var.x = this.a;
        e81Var.H = this.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }
}
