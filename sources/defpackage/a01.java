package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class a01 extends ik1 {
    public final ol1 a;
    public final c01 b;

    public a01(ol1 ol1Var, c01 c01Var) {
        this.a = ol1Var;
        this.b = c01Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        xb0 xb0VarA = this.b.a(this.a);
        b01 b01Var = new b01();
        b01Var.X = xb0VarA;
        b01Var.I0(xb0VarA);
        return b01Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a01)) {
            return false;
        }
        a01 a01Var = (a01) obj;
        return g31.a(this.a, a01Var.a) && g31.a(this.b, a01Var.b);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        b01 b01Var = (b01) dk1Var;
        xb0 xb0VarA = this.b.a(this.a);
        b01Var.J0(b01Var.X);
        b01Var.X = xb0VarA;
        b01Var.I0(xb0VarA);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
