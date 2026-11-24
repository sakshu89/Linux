package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fz2 {
    public final be a;
    public final yz2 b;
    public final List c;
    public final int d;
    public final boolean e;
    public final int f;
    public final jc0 g;
    public final z61 h;
    public final qo0 i;
    public final long j;

    public fz2(be beVar, yz2 yz2Var, List list, int i, boolean z, int i2, jc0 jc0Var, z61 z61Var, qo0 qo0Var, long j) {
        this.a = beVar;
        this.b = yz2Var;
        this.c = list;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = jc0Var;
        this.h = z61Var;
        this.i = qo0Var;
        this.j = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fz2)) {
            return false;
        }
        fz2 fz2Var = (fz2) obj;
        return g31.a(this.a, fz2Var.a) && g31.a(this.b, fz2Var.b) && g31.a(this.c, fz2Var.c) && this.d == fz2Var.d && this.e == fz2Var.e && this.f == fz2Var.f && g31.a(this.g, fz2Var.g) && this.h == fz2Var.h && g31.a(this.i, fz2Var.i) && q40.b(this.j, fz2Var.j);
    }

    public final int hashCode() {
        return Long.hashCode(this.j) + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + ky0.a(this.f, ky0.e((((this.c.hashCode() + ky0.c(this.a.hashCode() * 31, 31, this.b)) * 31) + this.d) * 31, 31, this.e), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TextLayoutInput(text=");
        sb.append((Object) this.a);
        sb.append(", style=");
        sb.append(this.b);
        sb.append(", placeholders=");
        sb.append(this.c);
        sb.append(", maxLines=");
        sb.append(this.d);
        sb.append(", softWrap=");
        sb.append(this.e);
        sb.append(", overflow=");
        int i = this.f;
        if (i == 1) {
            str = "Clip";
        } else if (i == 2) {
            str = "Ellipsis";
        } else if (i == 5) {
            str = "MiddleEllipsis";
        } else if (i == 3) {
            str = "Visible";
        } else {
            str = i == 4 ? "StartEllipsis" : "Invalid";
        }
        sb.append((Object) str);
        sb.append(", density=");
        sb.append(this.g);
        sb.append(", layoutDirection=");
        sb.append(this.h);
        sb.append(", fontFamilyResolver=");
        sb.append(this.i);
        sb.append(", constraints=");
        sb.append((Object) q40.k(this.j));
        sb.append(')');
        return sb.toString();
    }
}
