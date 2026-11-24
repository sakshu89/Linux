package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c70 extends ik1 {
    public final a23 a;
    public final ty2 b;
    public final ua1 c;
    public final boolean d;
    public final boolean e;
    public final mp1 f;
    public final ny2 g;
    public final kz0 h;
    public final fo0 i;

    public c70(a23 a23Var, ty2 ty2Var, ua1 ua1Var, boolean z, boolean z2, mp1 mp1Var, ny2 ny2Var, kz0 kz0Var, fo0 fo0Var) {
        this.a = a23Var;
        this.b = ty2Var;
        this.c = ua1Var;
        this.d = z;
        this.e = z2;
        this.f = mp1Var;
        this.g = ny2Var;
        this.h = kz0Var;
        this.i = fo0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        f70 f70Var = new f70();
        f70Var.X = this.a;
        f70Var.Y = this.b;
        f70Var.Z = this.c;
        f70Var.c0 = this.d;
        f70Var.d0 = this.e;
        f70Var.e0 = this.f;
        ny2 ny2Var = this.g;
        f70Var.f0 = ny2Var;
        f70Var.g0 = this.h;
        f70Var.h0 = this.i;
        ny2Var.g = new d70(f70Var, 4);
        return f70Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c70) {
            c70 c70Var = (c70) obj;
            if (this.a.equals(c70Var.a) && this.b.equals(c70Var.b) && this.c == c70Var.c && this.d == c70Var.d && this.e == c70Var.e && g31.a(this.f, c70Var.f) && this.g == c70Var.g && g31.a(this.h, c70Var.h) && g31.a(this.i, c70Var.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        f70 f70Var = (f70) dk1Var;
        boolean z = f70Var.c0;
        boolean z2 = f70Var.d0;
        kz0 kz0Var = f70Var.g0;
        ny2 ny2Var = f70Var.f0;
        f70Var.X = this.a;
        ty2 ty2Var = this.b;
        f70Var.Y = ty2Var;
        f70Var.Z = this.c;
        boolean z3 = this.d;
        f70Var.c0 = z3;
        f70Var.e0 = this.f;
        ny2 ny2Var2 = this.g;
        f70Var.f0 = ny2Var2;
        kz0 kz0Var2 = this.h;
        f70Var.g0 = kz0Var2;
        f70Var.h0 = this.i;
        if (z3 != z || z3 != z || !g31.a(kz0Var2, kz0Var) || this.e != z2 || !oz2.c(ty2Var.b)) {
            a34.a(f70Var);
        }
        if (ny2Var2 != ny2Var) {
            ny2Var2.g = new d70(f70Var, 0);
        }
    }

    public final int hashCode() {
        return this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + ky0.e(ky0.e(ky0.e((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31, 31, false), 31, this.d), 31, this.e)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.a + ", value=" + this.b + ", state=" + this.c + ", readOnly=false, enabled=" + this.d + ", isPassword=" + this.e + ", offsetMapping=" + this.f + ", manager=" + this.g + ", imeOptions=" + this.h + ", focusRequester=" + this.i + ')';
    }
}
