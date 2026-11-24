package defpackage;

import java.util.AbstractList;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nw0 implements ListIterator, x41 {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public int e;
    public final Object f;

    public nw0(um2 um2Var, int i) {
        this.a = 3;
        this.f = um2Var;
        this.b = i - 1;
        this.c = -1;
        this.e = y44.d(um2Var);
    }

    public void a() {
        if (((AbstractList) ((pc1) this.f).f).modCount == this.e) {
            return;
        }
        og.d();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.a;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                a();
                pc1 pc1Var = (pc1) obj2;
                int i2 = this.b;
                this.b = i2 + 1;
                pc1Var.add(i2, obj);
                this.c = -1;
                this.e = ((AbstractList) pc1Var).modCount;
                return;
            case 2:
                b();
                qc1 qc1Var = (qc1) obj2;
                int i3 = this.b;
                this.b = i3 + 1;
                qc1Var.add(i3, obj);
                this.c = -1;
                this.e = ((AbstractList) qc1Var).modCount;
                return;
            default:
                c();
                um2 um2Var = (um2) obj2;
                um2Var.add(this.b + 1, obj);
                this.c = -1;
                this.b++;
                this.e = y44.d(um2Var);
                return;
        }
    }

    public void b() {
        if (((AbstractList) ((qc1) this.f)).modCount == this.e) {
            return;
        }
        og.d();
    }

    public void c() {
        if (y44.d((um2) this.f) == this.e) {
            return;
        }
        og.d();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                return this.b < this.e;
            case 1:
                return this.b < ((pc1) obj).c;
            case 2:
                return this.b < ((qc1) obj).b;
            default:
                return this.b < ((um2) obj).size() - 1;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.a) {
            case 0:
                return this.b > this.c;
            case 1:
                return this.b > 0;
            case 2:
                return this.b > 0;
            default:
                return this.b >= 0;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                yl1 yl1Var = ((pw0) obj).a;
                int i2 = this.b;
                this.b = i2 + 1;
                Object objF = yl1Var.f(i2);
                objF.getClass();
                return (dk1) objF;
            case 1:
                a();
                int i3 = this.b;
                pc1 pc1Var = (pc1) obj;
                if (i3 >= pc1Var.c) {
                    dk0.d();
                    return null;
                }
                this.b = i3 + 1;
                this.c = i3;
                return pc1Var.a[pc1Var.b + i3];
            case 2:
                b();
                int i4 = this.b;
                qc1 qc1Var = (qc1) obj;
                if (i4 >= qc1Var.b) {
                    dk0.d();
                    return null;
                }
                this.b = i4 + 1;
                this.c = i4;
                return qc1Var.a[i4];
            default:
                c();
                int i5 = this.b + 1;
                this.c = i5;
                um2 um2Var = (um2) obj;
                y44.a(i5, um2Var.size());
                Object obj2 = um2Var.get(i5);
                this.b = i5;
                return obj2;
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.a) {
            case 0:
                return this.b - this.c;
            case 1:
                return this.b;
            case 2:
                return this.b;
            default:
                return this.b + 1;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                yl1 yl1Var = ((pw0) obj).a;
                int i2 = this.b - 1;
                this.b = i2;
                Object objF = yl1Var.f(i2);
                objF.getClass();
                return (dk1) objF;
            case 1:
                a();
                int i3 = this.b;
                if (i3 <= 0) {
                    dk0.d();
                    return null;
                }
                int i4 = i3 - 1;
                this.b = i4;
                this.c = i4;
                pc1 pc1Var = (pc1) obj;
                return pc1Var.a[pc1Var.b + i4];
            case 2:
                b();
                int i5 = this.b;
                if (i5 <= 0) {
                    dk0.d();
                    return null;
                }
                int i6 = i5 - 1;
                this.b = i6;
                this.c = i6;
                return ((qc1) obj).a[i6];
            default:
                c();
                um2 um2Var = (um2) obj;
                y44.a(this.b, um2Var.size());
                int i7 = this.b;
                this.c = i7;
                Object obj2 = um2Var.get(i7);
                this.b--;
                return obj2;
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.a) {
            case 0:
                return (this.b - this.c) - 1;
            case 1:
                i = this.b;
                break;
            case 2:
                i = this.b;
                break;
            default:
                return this.b;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                pc1 pc1Var = (pc1) obj;
                a();
                int i2 = this.c;
                if (i2 == -1) {
                    og.n("Call next() or previous() before removing element from the iterator.");
                    return;
                }
                pc1Var.b(i2);
                this.b = this.c;
                this.c = -1;
                this.e = ((AbstractList) pc1Var).modCount;
                return;
            case 2:
                qc1 qc1Var = (qc1) obj;
                b();
                int i3 = this.c;
                if (i3 == -1) {
                    og.n("Call next() or previous() before removing element from the iterator.");
                    return;
                }
                qc1Var.b(i3);
                this.b = this.c;
                this.c = -1;
                this.e = ((AbstractList) qc1Var).modCount;
                return;
            default:
                c();
                um2 um2Var = (um2) obj;
                um2Var.remove(this.c);
                this.b--;
                this.c = -1;
                this.e = y44.d(um2Var);
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i = this.a;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                a();
                int i2 = this.c;
                if (i2 != -1) {
                    ((pc1) obj2).set(i2, obj);
                    return;
                } else {
                    og.n("Call next() or previous() before replacing element from the iterator.");
                    return;
                }
            case 2:
                b();
                int i3 = this.c;
                if (i3 != -1) {
                    ((qc1) obj2).set(i3, obj);
                    return;
                } else {
                    og.n("Call next() or previous() before replacing element from the iterator.");
                    return;
                }
            default:
                um2 um2Var = (um2) obj2;
                c();
                int i4 = this.c;
                if (i4 < 0) {
                    og.n("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
                    return;
                } else {
                    um2Var.set(i4, obj);
                    this.e = y44.d(um2Var);
                    return;
                }
        }
    }

    public nw0(qc1 qc1Var, int i) {
        this.a = 2;
        this.f = qc1Var;
        this.b = i;
        this.c = -1;
        this.e = ((AbstractList) qc1Var).modCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public nw0(pw0 pw0Var, int i, int i2) {
        this(pw0Var, (i2 & 1) != 0 ? 0 : i, 0, pw0Var.a.b);
        this.a = 0;
    }

    public nw0(pw0 pw0Var, int i, int i2, int i3) {
        this.a = 0;
        this.f = pw0Var;
        this.b = i;
        this.c = i2;
        this.e = i3;
    }

    public nw0(pc1 pc1Var, int i) {
        this.a = 1;
        this.f = pc1Var;
        this.b = i;
        this.c = -1;
        this.e = ((AbstractList) pc1Var).modCount;
    }
}
