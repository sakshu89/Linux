package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class ti0 extends ik1 {
    public final j23 a;
    public final f23 b;
    public final f23 c;
    public final cj0 d;
    public final mk0 e;
    public final fq0 f;
    public final ui0 g;

    public ti0(j23 j23Var, f23 f23Var, f23 f23Var2, cj0 cj0Var, mk0 mk0Var, fq0 fq0Var, ui0 ui0Var) {
        this.a = j23Var;
        this.b = f23Var;
        this.c = f23Var2;
        this.d = cj0Var;
        this.e = mk0Var;
        this.f = fq0Var;
        this.g = ui0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new bj0(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ti0)) {
            return false;
        }
        ti0 ti0Var = (ti0) obj;
        return ti0Var.a == this.a && g31.a(ti0Var.b, this.b) && g31.a(ti0Var.c, this.c) && ti0Var.d.equals(this.d) && ti0Var.e.equals(this.e) && ti0Var.f == this.f && g31.a(ti0Var.g, this.g);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        bj0 bj0Var = (bj0) dk1Var;
        bj0Var.x = this.a;
        bj0Var.H = this.b;
        bj0Var.X = this.c;
        bj0Var.Y = this.d;
        bj0Var.Z = this.e;
        bj0Var.c0 = this.f;
        bj0Var.d0 = this.g;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        f23 f23Var = this.b;
        int iHashCode2 = (iHashCode + (f23Var != null ? f23Var.hashCode() : 0)) * 31;
        f23 f23Var2 = this.c;
        return this.g.hashCode() + ((this.f.hashCode() + ((this.e.a.hashCode() + ((this.d.a.hashCode() + ((iHashCode2 + (f23Var2 != null ? f23Var2.hashCode() : 0)) * 961)) * 31)) * 31)) * 31);
    }
}
