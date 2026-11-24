package defpackage;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends e1 implements ListIterator {
    public final /* synthetic */ h1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(h1 h1Var, int i) {
        super(h1Var);
        this.e = h1Var;
        int iA = h1Var.a();
        if (i < 0 || i > iA) {
            og.o(ky0.i("index: ", i, iA, ", size: "));
            throw null;
        }
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            dk0.d();
            return null;
        }
        int i = this.b - 1;
        this.b = i;
        return this.e.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
