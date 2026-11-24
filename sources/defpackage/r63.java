package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r63 extends p63 {
    public final String a;
    public final List b;
    public final int c;
    public final hn e;
    public final float f;
    public final hn i;
    public final float j;
    public final float k;
    public final int n;
    public final int s;
    public final float t;
    public final float u;
    public final float v;
    public final float w;

    public r63(String str, List list, int i, hn hnVar, float f, hn hnVar2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7) {
        this.a = str;
        this.b = list;
        this.c = i;
        this.e = hnVar;
        this.f = f;
        this.i = hnVar2;
        this.j = f2;
        this.k = f3;
        this.n = i2;
        this.s = i3;
        this.t = f4;
        this.u = f5;
        this.v = f6;
        this.w = f7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r63.class != obj.getClass()) {
            return false;
        }
        r63 r63Var = (r63) obj;
        return this.a.equals(r63Var.a) && g31.a(this.e, r63Var.e) && this.f == r63Var.f && g31.a(this.i, r63Var.i) && this.j == r63Var.j && this.k == r63Var.k && this.n == r63Var.n && this.s == r63Var.s && this.t == r63Var.t && this.u == r63Var.u && this.v == r63Var.v && this.w == r63Var.w && this.c == r63Var.c && g31.a(this.b, r63Var.b);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        hn hnVar = this.e;
        int iB = cq.b((iHashCode + (hnVar != null ? hnVar.hashCode() : 0)) * 31, this.f, 31);
        hn hnVar2 = this.i;
        return Integer.hashCode(this.c) + cq.b(cq.b(cq.b(cq.b(ky0.a(this.s, ky0.a(this.n, cq.b(cq.b((iB + (hnVar2 != null ? hnVar2.hashCode() : 0)) * 31, this.j, 31), this.k, 31), 31), 31), this.t, 31), this.u, 31), this.v, 31), this.w, 31);
    }
}
