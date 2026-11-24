package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class nt1 extends ik1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public nt1(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        boolean z = true;
        boolean z2 = (f >= 0.0f || Float.isNaN(f)) & (f2 >= 0.0f || Float.isNaN(f2)) & (f3 >= 0.0f || Float.isNaN(f3));
        if (f4 < 0.0f && !Float.isNaN(f4)) {
            z = false;
        }
        if (!z2 || !z) {
            x01.a("Padding must be non-negative");
        }
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        ot1 ot1Var = new ot1();
        ot1Var.x = this.a;
        ot1Var.H = this.b;
        ot1Var.X = this.c;
        ot1Var.Y = this.d;
        ot1Var.Z = true;
        return ot1Var;
    }

    public final boolean equals(Object obj) {
        nt1 nt1Var = obj instanceof nt1 ? (nt1) obj : null;
        return nt1Var != null && de0.b(this.a, nt1Var.a) && de0.b(this.b, nt1Var.b) && de0.b(this.c, nt1Var.c) && de0.b(this.d, nt1Var.d);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ot1 ot1Var = (ot1) dk1Var;
        ot1Var.x = this.a;
        ot1Var.H = this.b;
        ot1Var.X = this.c;
        ot1Var.Y = this.d;
        ot1Var.Z = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + cq.b(cq.b(cq.b(Float.hashCode(this.a) * 31, this.b, 31), this.c, 31), this.d, 31);
    }
}
