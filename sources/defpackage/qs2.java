package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qs2 implements List, y41 {
    public final um2 a;
    public final int b;
    public int c;
    public int e;

    public qs2(um2 um2Var, int i, int i2) {
        this.a = um2Var;
        this.b = i;
        this.c = y44.d(um2Var);
        this.e = i2 - i;
    }

    public final void a() {
        if (y44.d(this.a) == this.c) {
            return;
        }
        og.d();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        a();
        int i = this.b + this.e;
        um2 um2Var = this.a;
        um2Var.add(i, obj);
        this.e++;
        this.c = y44.d(um2Var);
        return true;
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        int i2 = i + this.b;
        um2 um2Var = this.a;
        boolean zAddAll = um2Var.addAll(i2, collection);
        if (zAddAll) {
            this.e = collection.size() + this.e;
            this.c = y44.d(um2Var);
        }
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.e > 0) {
            a();
            int i = this.e;
            int i2 = this.b;
            um2 um2Var = this.a;
            um2Var.f(i2, i + i2);
            this.e = 0;
            this.c = y44.d(um2Var);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        a();
        y44.a(i, this.e);
        return this.a.get(this.b + i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int iNextInt;
        a();
        int i = this.e;
        int i2 = this.b;
        Iterator it = ky3.f(i2, i + i2).iterator();
        do {
            g21 g21Var = (g21) it;
            if (!g21Var.c) {
                return -1;
            }
            iNextInt = g21Var.nextInt();
        } while (!g31.a(obj, this.a.get(iNextInt)));
        return iNextInt - i2;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.e == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        a();
        int i = this.e;
        int i2 = this.b;
        for (int i3 = (i + i2) - 1; i3 >= i2; i3--) {
            if (g31.a(obj, this.a.get(i3))) {
                return i3 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        a();
        r42 r42Var = new r42();
        r42Var.a = i - 1;
        return new t72(r42Var, this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        a();
        int i2 = this.b + i;
        um2 um2Var = this.a;
        Object objRemove = um2Var.remove(i2);
        this.e--;
        this.c = y44.d(um2Var);
        return objRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        a();
        um2 um2Var = this.a;
        int i2 = this.b;
        int i3 = this.e + i2;
        int size = um2Var.size();
        do {
            synchronized (y44.a) {
                mr2 mr2Var = um2Var.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            rw1 rw1VarG = n1Var.g();
            rw1VarG.subList(i2, i3).retainAll(collection);
            n1 n1VarD = rw1VarG.d();
            if (g31.a(n1VarD, n1Var)) {
                break;
            }
            mr2 mr2Var3 = um2Var.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, um2Var, bm2VarJ), i, n1VarD, true);
            }
            im2.n(bm2VarJ, um2Var);
        } while (!zB);
        int size2 = size - um2Var.size();
        if (size2 > 0) {
            this.c = y44.d(this.a);
            this.e -= size2;
        }
        return size2 > 0;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        y44.a(i, this.e);
        a();
        int i2 = i + this.b;
        um2 um2Var = this.a;
        Object obj2 = um2Var.set(i2, obj);
        this.c = y44.d(um2Var);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.e;
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.e) {
            dz1.a("fromIndex or toIndex are out of bounds");
        }
        a();
        int i3 = this.b;
        return new qs2(this.a, i + i3, i2 + i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return zt3.b(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return zt3.c(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        a();
        int i2 = this.b + i;
        um2 um2Var = this.a;
        um2Var.add(i2, obj);
        this.e++;
        this.c = y44.d(um2Var);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(this.e, collection);
    }
}
