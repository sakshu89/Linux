package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xl extends ik1 {
    public final float a;
    public final cn2 b;
    public final yj2 c;

    public xl(float f, cn2 cn2Var, yj2 yj2Var) {
        this.a = f;
        this.b = cn2Var;
        this.c = yj2Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new wl(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xl)) {
            return false;
        }
        xl xlVar = (xl) obj;
        return de0.b(this.a, xlVar.a) && this.b.equals(xlVar.b) && g31.a(this.c, xlVar.c);
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        wl wlVar = (wl) dk1Var;
        float f = wlVar.Y;
        ro roVar = wlVar.d0;
        float f2 = this.a;
        if (!de0.b(f, f2)) {
            wlVar.Y = f2;
            roVar.I0();
        }
        cn2 cn2Var = wlVar.Z;
        cn2 cn2Var2 = this.b;
        if (!g31.a(cn2Var, cn2Var2)) {
            wlVar.Z = cn2Var2;
            roVar.I0();
        }
        yj2 yj2Var = wlVar.c0;
        yj2 yj2Var2 = this.c;
        if (g31.a(yj2Var, yj2Var2)) {
            return;
        }
        wlVar.c0 = yj2Var2;
        roVar.I0();
        a34.a(wlVar);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (Float.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) de0.c(this.a)) + ", brush=" + this.b + ", shape=" + this.c + ')';
    }
}
