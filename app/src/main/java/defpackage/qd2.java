package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class qd2 extends ik1 {
    public final be2 a;
    public final js1 b;
    public final boolean c;
    public final boolean d;

    public qd2(be2 be2Var, js1 js1Var, boolean z, boolean z2) {
        this.a = be2Var;
        this.b = js1Var;
        this.c = z;
        this.d = z2;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new ae2(null, null, null, this.b, this.a, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qd2)) {
            return false;
        }
        qd2 qd2Var = (qd2) obj;
        return g31.a(this.a, qd2Var.a) && this.b == qd2Var.b && this.c == qd2Var.c && this.d == qd2Var.d;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((ae2) dk1Var).Z0(null, null, null, this.b, this.a, this.c, this.d);
    }

    public final int hashCode() {
        return ky0.e(ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 961, 31, this.c), 29791, this.d);
    }
}
