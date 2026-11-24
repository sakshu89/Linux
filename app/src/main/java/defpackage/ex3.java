package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ex3 extends bq3 implements ListIterator {
    public final int b;
    public int c;
    public final lx3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex3(lx3 lx3Var, int i) {
        super(2);
        int size = lx3Var.size();
        rh4.c(i, size);
        this.b = size;
        this.c = i;
        this.e = lx3Var;
    }

    public final Object a(int i) {
        return this.e.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        int i = this.c;
        this.c = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            dk0.d();
            return null;
        }
        int i = this.c - 1;
        this.c = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.c - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
