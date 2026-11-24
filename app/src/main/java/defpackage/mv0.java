package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mv0 implements Iterator, x41 {
    public final ol2 a;
    public final int b;
    public int c;
    public final int e;

    public mv0(ol2 ol2Var, int i, int i2) {
        this.a = ol2Var;
        this.b = i2;
        this.c = i;
        this.e = ol2Var.k;
        if (ol2Var.j) {
            ql2.e();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        ol2 ol2Var = this.a;
        int i = ol2Var.k;
        int i2 = this.e;
        if (i != i2) {
            ql2.e();
        }
        int i3 = this.c;
        this.c = ol2Var.a[(i3 * 5) + 3] + i3;
        return new pl2(ol2Var, i3, i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
