package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class k91 extends ik1 {
    public final fq0 a;
    public final j91 b;
    public final js1 c;
    public final boolean d;

    public k91(fq0 fq0Var, j91 j91Var, js1 js1Var, boolean z) {
        this.a = fq0Var;
        this.b = j91Var;
        this.c = js1Var;
        this.d = z;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new o91(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k91)) {
            return false;
        }
        k91 k91Var = (k91) obj;
        return this.a == k91Var.a && g31.a(this.b, k91Var.b) && this.c == k91Var.c && this.d == k91Var.d;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        o91 o91Var = (o91) dk1Var;
        o91Var.x = this.a;
        o91Var.H = this.b;
        js1 js1Var = o91Var.X;
        js1 js1Var2 = this.c;
        if (js1Var != js1Var2) {
            o91Var.X = js1Var2;
            a34.a(o91Var);
        }
        boolean z = o91Var.Y;
        boolean z2 = this.d;
        if (z == z2) {
            return;
        }
        o91Var.Y = z2;
        o91Var.I0();
        a34.a(o91Var);
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + ky0.e((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31, 31, this.d);
    }
}
