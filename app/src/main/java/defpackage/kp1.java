package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class kp1 extends ik1 {
    public final float a;

    public kp1(float f) {
        this.a = f;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        np1 np1Var = new np1();
        np1Var.x = this.a;
        np1Var.H = true;
        return np1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        kp1 kp1Var = obj instanceof kp1 ? (kp1) obj : null;
        return kp1Var != null && de0.b(0.0f, 0.0f) && de0.b(this.a, kp1Var.a);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        np1 np1Var = (np1) dk1Var;
        np1Var.getClass();
        boolean zB = de0.b(0.0f, 0.0f);
        float f = this.a;
        if (!zB || !de0.b(np1Var.x, f) || !np1Var.H) {
            cm4.g(np1Var).U(false);
        }
        np1Var.x = f;
        np1Var.H = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + cq.b(Float.hashCode(0.0f) * 31, this.a, 31);
    }

    public final String toString() {
        return "OffsetModifierElement(x=" + ((Object) de0.c(0.0f)) + ", y=" + ((Object) de0.c(this.a)) + ", rtlAware=true)";
    }
}
