package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gp2 implements c30, Iterable, x41 {
    public final ol2 a;
    public final int b;
    public final a52 c;

    public gp2(ol2 ol2Var, int i, nv0 nv0Var, a52 a52Var) {
        this.a = ol2Var;
        this.b = i;
        this.c = a52Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof gp2)) {
            return false;
        }
        gp2 gp2Var = (gp2) obj;
        return gp2Var.b == this.b && gp2Var.a == this.a && gp2Var.c.equals(this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.a.hashCode() + (this.b * 31)) * 31);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c82(this.a, this.b, null, this.c);
    }
}
