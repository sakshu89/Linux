package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class qx2 extends ik1 {
    public final cu2 a;
    public final n90 b;
    public final hy2 c;
    public final v60 d;

    public qx2(cu2 cu2Var, n90 n90Var, hy2 hy2Var, v60 v60Var) {
        this.a = cu2Var;
        this.b = n90Var;
        this.c = hy2Var;
        this.d = v60Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new rx2(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qx2)) {
            return false;
        }
        qx2 qx2Var = (qx2) obj;
        return this.a == qx2Var.a && this.b == qx2Var.b && this.c == qx2Var.c && this.d == qx2Var.d;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        rx2 rx2Var = (rx2) dk1Var;
        rx2Var.X.b = null;
        cu2 cu2Var = this.a;
        rx2Var.X = cu2Var;
        cu2Var.b = rx2Var;
        cu2Var.c = rx2Var.w ? e13.c : e13.b;
        rx2Var.Y = this.b;
        rx2Var.Z = this.c;
        rx2Var.c0 = this.d;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }
}
