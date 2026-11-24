package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n63 extends p63 implements Iterable, x41 {
    public final String a;
    public final float b;
    public final float c;
    public final float e;
    public final float f;
    public final float i;
    public final float j;
    public final float k;
    public final List n;
    public final List s;

    public n63(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, ArrayList arrayList) {
        this.a = str;
        this.b = f;
        this.c = f2;
        this.e = f3;
        this.f = f4;
        this.i = f5;
        this.j = f6;
        this.k = f7;
        this.n = list;
        this.s = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof n63)) {
            n63 n63Var = (n63) obj;
            return g31.a(this.a, n63Var.a) && this.b == n63Var.b && this.c == n63Var.c && this.e == n63Var.e && this.f == n63Var.f && this.i == n63Var.i && this.j == n63Var.j && this.k == n63Var.k && g31.a(this.n, n63Var.n) && g31.a(this.s, n63Var.s);
        }
        return false;
    }

    public final int hashCode() {
        return this.s.hashCode() + ((this.n.hashCode() + cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(cq.b(this.a.hashCode() * 31, this.b, 31), this.c, 31), this.e, 31), this.f, 31), this.i, 31), this.j, 31), this.k, 31)) * 31);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new lw1(this);
    }
}
