package defpackage;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t72 implements ListIterator, x41 {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final /* synthetic */ Object c;

    public t72(dh1 dh1Var, int i) {
        this.c = dh1Var;
        List list = (List) dh1Var.b;
        if (i >= 0 && i <= dh1Var.a()) {
            this.b = list.listIterator(dh1Var.a() - i);
            return;
        }
        StringBuilder sbP = ky0.p("Position index ", i, " must be in range [");
        sbP.append(new h21(0, dh1Var.a(), 1));
        sbP.append("].");
        throw new IndexOutOfBoundsException(sbP.toString());
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((ListIterator) obj).hasPrevious();
            default:
                return ((r42) obj).a < ((qs2) this.c).e - 1;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((ListIterator) obj).hasNext();
            default:
                return ((r42) obj).a >= 0;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((ListIterator) obj).previous();
            default:
                r42 r42Var = (r42) obj;
                int i2 = r42Var.a + 1;
                qs2 qs2Var = (qs2) this.c;
                y44.a(i2, qs2Var.e);
                r42Var.a = i2;
                return qs2Var.get(i2);
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return (((dh1) this.c).size() - 1) - ((ListIterator) obj).previousIndex();
            default:
                return ((r42) obj).a + 1;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((ListIterator) obj).next();
            default:
                r42 r42Var = (r42) obj;
                int i2 = r42Var.a;
                qs2 qs2Var = (qs2) this.c;
                y44.a(i2, qs2Var.e);
                r42Var.a = i2 - 1;
                return qs2Var.get(i2);
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return (((dh1) this.c).size() - 1) - ((ListIterator) obj).nextIndex();
            default:
                return ((r42) obj).a;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    public t72(r42 r42Var, qs2 qs2Var) {
        this.b = r42Var;
        this.c = qs2Var;
    }
}
