package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eu1 implements xd {
    public final int a;
    public final int b;
    public final long c;
    public final wy2 d;
    public final nx1 e;
    public final bc1 f;
    public final int g;
    public final int h;
    public final lz2 i;

    public eu1(int i, int i2, long j, wy2 wy2Var, nx1 nx1Var, bc1 bc1Var, int i3, int i4, lz2 lz2Var) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = wy2Var;
        this.e = nx1Var;
        this.f = bc1Var;
        this.g = i3;
        this.h = i4;
        this.i = lz2Var;
        if (b03.a(j, b03.c) || b03.c(j) >= 0.0f) {
            return;
        }
        a11.b("lineHeight can't be negative (" + b03.c(j) + ')');
    }

    public final eu1 a(eu1 eu1Var) {
        return eu1Var == null ? this : fu1.a(this, eu1Var.a, eu1Var.b, eu1Var.c, eu1Var.d, eu1Var.e, eu1Var.f, eu1Var.g, eu1Var.h, eu1Var.i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eu1)) {
            return false;
        }
        eu1 eu1Var = (eu1) obj;
        return this.a == eu1Var.a && this.b == eu1Var.b && b03.a(this.c, eu1Var.c) && g31.a(this.d, eu1Var.d) && g31.a(this.e, eu1Var.e) && g31.a(this.f, eu1Var.f) && this.g == eu1Var.g && this.h == eu1Var.h && g31.a(this.i, eu1Var.i);
    }

    public final int hashCode() {
        int iA = ky0.a(this.b, Integer.hashCode(this.a) * 31, 31);
        c03[] c03VarArr = b03.b;
        int iC = cq.c(iA, 31, this.c);
        wy2 wy2Var = this.d;
        int iHashCode = (iC + (wy2Var != null ? wy2Var.hashCode() : 0)) * 31;
        nx1 nx1Var = this.e;
        int iHashCode2 = (iHashCode + (nx1Var != null ? nx1Var.hashCode() : 0)) * 31;
        bc1 bc1Var = this.f;
        int iA2 = ky0.a(this.h, ky0.a(this.g, (iHashCode2 + (bc1Var != null ? bc1Var.hashCode() : 0)) * 31, 31), 31);
        lz2 lz2Var = this.i;
        return iA2 + (lz2Var != null ? lz2Var.hashCode() : 0);
    }

    public final String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) vw2.a(this.a)) + ", textDirection=" + ((Object) vx2.a(this.b)) + ", lineHeight=" + ((Object) b03.d(this.c)) + ", textIndent=" + this.d + ", platformStyle=" + this.e + ", lineHeightStyle=" + this.f + ", lineBreak=" + ((Object) wb1.a(this.g)) + ", hyphens=" + ((Object) iy0.a(this.h)) + ", textMotion=" + this.i + ')';
    }
}
