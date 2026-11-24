package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pl2 implements c30, Iterable, x41 {
    public final ol2 a;
    public final int b;
    public final int c;

    public pl2(ol2 ol2Var, int i, int i2) {
        this.a = ol2Var;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pl2)) {
            return false;
        }
        pl2 pl2Var = (pl2) obj;
        return pl2Var.b == this.b && pl2Var.c == this.c && pl2Var.a == this.a;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ol2 ol2Var = this.a;
        if (ol2Var.k != this.c) {
            ql2.e();
        }
        int i = this.b;
        ol2Var.h(i);
        return new mv0(ol2Var, i + 1, ol2Var.a[(i * 5) + 3] + i);
    }
}
