package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ck2 {
    public final t82 a;
    public final t82 b;
    public final t82 c;
    public final t82 d;
    public final t82 e;
    public final t82 f;
    public final t82 g;
    public final t82 h;

    public ck2() {
        t82 t82Var = zj2.a;
        t82 t82Var2 = zj2.b;
        t82 t82Var3 = zj2.c;
        t82 t82Var4 = zj2.d;
        t82 t82Var5 = zj2.f;
        t82 t82Var6 = zj2.e;
        t82 t82Var7 = zj2.g;
        t82 t82Var8 = zj2.h;
        this.a = t82Var;
        this.b = t82Var2;
        this.c = t82Var3;
        this.d = t82Var4;
        this.e = t82Var5;
        this.f = t82Var6;
        this.g = t82Var7;
        this.h = t82Var8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ck2)) {
            return false;
        }
        ck2 ck2Var = (ck2) obj;
        return g31.a(this.a, ck2Var.a) && g31.a(this.b, ck2Var.b) && g31.a(this.c, ck2Var.c) && g31.a(this.d, ck2Var.d) && g31.a(this.e, ck2Var.e) && g31.a(this.f, ck2Var.f) && g31.a(this.g, ck2Var.g) && g31.a(this.h, ck2Var.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Shapes(extraSmall=" + this.a + ", small=" + this.b + ", medium=" + this.c + ", large=" + this.d + ", largeIncreased=" + this.f + ", extraLarge=" + this.e + ", extralargeIncreased=" + this.g + ", extraExtraLarge=" + this.h + ')';
    }
}
