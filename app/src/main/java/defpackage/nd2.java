package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class nd2 extends ik1 {
    public final be2 a;
    public final js1 b;
    public final boolean c;
    public final ka0 d;
    public final ol1 e;
    public final boolean f;
    public final f9 g;

    public nd2(f9 f9Var, ka0 ka0Var, ol1 ol1Var, js1 js1Var, be2 be2Var, boolean z, boolean z2) {
        this.a = be2Var;
        this.b = js1Var;
        this.c = z;
        this.d = ka0Var;
        this.e = ol1Var;
        this.f = z2;
        this.g = f9Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        od2 od2Var = new od2();
        od2Var.X = this.a;
        od2Var.Y = this.b;
        od2Var.Z = this.c;
        od2Var.c0 = this.d;
        od2Var.d0 = this.e;
        od2Var.e0 = this.f;
        od2Var.f0 = this.g;
        return od2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || nd2.class != obj.getClass()) {
            return false;
        }
        nd2 nd2Var = (nd2) obj;
        return g31.a(this.a, nd2Var.a) && this.b == nd2Var.b && this.c == nd2Var.c && g31.a(this.d, nd2Var.d) && g31.a(this.e, nd2Var.e) && this.f == nd2Var.f && g31.a(this.g, nd2Var.g);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((od2) dk1Var).N0(this.g, this.d, this.e, this.b, this.a, this.f, this.c);
    }

    public final int hashCode() {
        int iE = ky0.e(ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c), 31, false);
        ka0 ka0Var = this.d;
        int iHashCode = (iE + (ka0Var != null ? ka0Var.hashCode() : 0)) * 31;
        ol1 ol1Var = this.e;
        int iE2 = ky0.e((iHashCode + (ol1Var != null ? ol1Var.hashCode() : 0)) * 961, 31, this.f);
        f9 f9Var = this.g;
        return iE2 + (f9Var != null ? f9Var.hashCode() : 0);
    }
}
