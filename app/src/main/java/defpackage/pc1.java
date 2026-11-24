package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pc1 extends k1 implements RandomAccess, Serializable {
    public Object[] a;
    public final int b;
    public int c;
    public final pc1 e;
    public final qc1 f;

    public pc1(Object[] objArr, int i, int i2, pc1 pc1Var, qc1 qc1Var) {
        objArr.getClass();
        qc1Var.getClass();
        this.a = objArr;
        this.b = i;
        this.c = i2;
        this.e = pc1Var;
        this.f = qc1Var;
        ((AbstractList) this).modCount = ((AbstractList) qc1Var).modCount;
    }

    @Override // defpackage.k1
    public final int a() {
        h();
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        i();
        h();
        int i2 = this.c;
        if (i < 0 || i > i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
        } else {
            g(this.b + i, obj);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        i();
        h();
        int i2 = this.c;
        if (i < 0 || i > i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return false;
        }
        int size = collection.size();
        f(this.b + i, collection, size);
        return size > 0;
    }

    @Override // defpackage.k1
    public final Object b(int i) {
        i();
        h();
        int i2 = this.c;
        if (i >= 0 && i < i2) {
            return j(this.b + i);
        }
        og.o(ky0.i("index: ", i, i2, ", size: "));
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        i();
        h();
        k(this.b, this.c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        h();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.a;
            int i = this.c;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (g31.a(objArr[this.b + i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        qc1 qc1Var = this.f;
        pc1 pc1Var = this.e;
        if (pc1Var != null) {
            pc1Var.f(i, collection, i2);
        } else {
            qc1 qc1Var2 = qc1.e;
            qc1Var.f(i, collection, i2);
        }
        this.a = qc1Var.a;
        this.c += i2;
    }

    public final void g(int i, Object obj) {
        ((AbstractList) this).modCount++;
        qc1 qc1Var = this.f;
        pc1 pc1Var = this.e;
        if (pc1Var != null) {
            pc1Var.g(i, obj);
        } else {
            qc1 qc1Var2 = qc1.e;
            qc1Var.g(i, obj);
        }
        this.a = qc1Var.a;
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h();
        int i2 = this.c;
        if (i >= 0 && i < i2) {
            return this.a[this.b + i];
        }
        og.o(ky0.i("index: ", i, i2, ", size: "));
        return null;
    }

    public final void h() {
        if (((AbstractList) this.f).modCount == ((AbstractList) this).modCount) {
            return;
        }
        og.d();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        h();
        Object[] objArr = this.a;
        int i = this.c;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.b + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (this.f.c) {
            dk0.p();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        h();
        for (int i = 0; i < this.c; i++) {
            if (g31.a(this.a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        h();
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final Object j(int i) {
        Object objJ;
        ((AbstractList) this).modCount++;
        pc1 pc1Var = this.e;
        if (pc1Var != null) {
            objJ = pc1Var.j(i);
        } else {
            qc1 qc1Var = qc1.e;
            objJ = this.f.j(i);
        }
        this.c--;
        return objJ;
    }

    public final void k(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        pc1 pc1Var = this.e;
        if (pc1Var != null) {
            pc1Var.k(i, i2);
        } else {
            qc1 qc1Var = qc1.e;
            this.f.k(i, i2);
        }
        this.c -= i2;
    }

    public final int l(int i, int i2, Collection collection, boolean z) {
        int iL;
        pc1 pc1Var = this.e;
        if (pc1Var != null) {
            iL = pc1Var.l(i, i2, collection, z);
        } else {
            qc1 qc1Var = qc1.e;
            iL = this.f.l(i, i2, collection, z);
        }
        if (iL > 0) {
            ((AbstractList) this).modCount++;
        }
        this.c -= iL;
        return iL;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        h();
        for (int i = this.c - 1; i >= 0; i--) {
            if (g31.a(this.a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        h();
        int i2 = this.c;
        if (i >= 0 && i <= i2) {
            return new nw0(this, i);
        }
        og.o(ky0.i("index: ", i, i2, ", size: "));
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        i();
        h();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        i();
        h();
        return l(this.b, this.c, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        i();
        h();
        return l(this.b, this.c, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        i();
        h();
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return null;
        }
        Object[] objArr = this.a;
        int i3 = this.b;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        yb4.a(i, i2, this.c);
        return new pc1(this.a, this.b + i, i2 - i, this, this.f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        h();
        int length = objArr.length;
        int i = this.c;
        Object[] objArr2 = this.a;
        int i2 = this.b;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i2, i + i2, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        qg.g(objArr2, 0, objArr, i2, i + i2);
        int i3 = this.c;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        h();
        return mq4.a(this.a, this.b, this.c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        i();
        h();
        g(this.b + this.c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        h();
        Object[] objArr = this.a;
        int i = this.c;
        int i2 = this.b;
        return qg.k(objArr, i2, i + i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        i();
        h();
        int size = collection.size();
        f(this.b + this.c, collection, size);
        return size > 0;
    }
}
