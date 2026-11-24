package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wl1 implements List, y41 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ wl1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int i3 = this.a;
        Object obj2 = this.b;
        switch (i3) {
            case 0:
                yl1 yl1Var = (yl1) obj2;
                if (i < 0 || i > (i2 = yl1Var.b)) {
                    yl1Var.o(i);
                    throw null;
                }
                int i4 = i2 + 1;
                Object[] objArr = yl1Var.a;
                if (objArr.length < i4) {
                    yl1Var.m(i4, objArr);
                }
                Object[] objArr2 = yl1Var.a;
                int i5 = yl1Var.b;
                if (i != i5) {
                    qg.g(objArr2, i + 1, objArr2, i, i5);
                }
                objArr2[i] = obj;
                yl1Var.b++;
                return;
            default:
                ((pm1) obj2).a(i, obj);
                return;
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                collection.getClass();
                yl1 yl1Var = (yl1) obj;
                if (i < 0 || i > yl1Var.b) {
                    yl1Var.o(i);
                    throw null;
                }
                int i3 = 0;
                if (collection.isEmpty()) {
                    return false;
                }
                int size = collection.size() + yl1Var.b;
                Object[] objArr = yl1Var.a;
                if (objArr.length < size) {
                    yl1Var.m(size, objArr);
                }
                Object[] objArr2 = yl1Var.a;
                if (i != yl1Var.b) {
                    qg.g(objArr2, collection.size() + i, objArr2, i, yl1Var.b);
                }
                for (Object obj2 : collection) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        nz.n();
                        throw null;
                    }
                    objArr2[i3 + i] = obj2;
                    i3 = i4;
                }
                yl1Var.b = collection.size() + yl1Var.b;
                return true;
            default:
                return ((pm1) obj).f(i, collection);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((yl1) obj).d();
                break;
            default:
                ((pm1) obj).h();
                break;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((yl1) obj2).g(obj) >= 0;
            default:
                return ((pm1) obj2).i(obj);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                collection.getClass();
                yl1 yl1Var = (yl1) obj;
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (yl1Var.g(it.next()) < 0) {
                        return false;
                    }
                }
                return true;
            default:
                pm1 pm1Var = (pm1) obj;
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!pm1Var.i(it2.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                yo1.a(i, this);
                return ((yl1) obj).f(i);
            default:
                qm1.a(i, this);
                return ((pm1) obj).a[i];
        }
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((yl1) obj2).g(obj);
            default:
                return ((pm1) obj2).j(obj);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((yl1) obj).h();
            default:
                return ((pm1) obj).c == 0;
        }
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new vl1(this, 0, 0);
            default:
                return new vl1(this, 0, 1);
        }
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        int i2 = this.a;
        Object obj2 = this.b;
        switch (i2) {
            case 0:
                yl1 yl1Var = (yl1) obj2;
                Object[] objArr = yl1Var.a;
                int i3 = yl1Var.b;
                if (obj == null) {
                    i = i3 - 1;
                    while (-1 < i) {
                        if (objArr[i] != null) {
                            i--;
                        }
                    }
                    return -1;
                }
                i = i3 - 1;
                while (-1 < i) {
                    if (!obj.equals(objArr[i])) {
                        i--;
                    }
                }
                return -1;
                return i;
            default:
                pm1 pm1Var = (pm1) obj2;
                Object[] objArr2 = pm1Var.a;
                for (int i4 = pm1Var.c - 1; i4 >= 0; i4--) {
                    if (g31.a(obj, objArr2[i4])) {
                        return i4;
                    }
                }
                return -1;
        }
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        switch (this.a) {
            case 0:
                return new vl1(this, 0, 0);
            default:
                return new vl1(this, 0, 1);
        }
    }

    @Override // java.util.List
    public final Object remove(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                yo1.a(i, this);
                return ((yl1) obj).k(i);
            default:
                qm1.a(i, this);
                return ((pm1) obj).l(i);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                collection.getClass();
                yl1 yl1Var = (yl1) obj;
                int i2 = yl1Var.b;
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    yl1Var.j(it.next());
                }
                return i2 != yl1Var.b;
            default:
                pm1 pm1Var = (pm1) obj;
                if (!collection.isEmpty()) {
                    int i3 = pm1Var.c;
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        pm1Var.k(it2.next());
                    }
                    if (i3 != pm1Var.c) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                collection.getClass();
                yl1 yl1Var = (yl1) obj;
                int i2 = yl1Var.b;
                Object[] objArr = yl1Var.a;
                for (int i3 = i2 - 1; -1 < i3; i3--) {
                    if (!collection.contains(objArr[i3])) {
                        yl1Var.k(i3);
                    }
                }
                return i2 != yl1Var.b;
            default:
                pm1 pm1Var = (pm1) obj;
                int i4 = pm1Var.c;
                for (int i5 = i4 - 1; -1 < i5; i5--) {
                    if (!collection.contains(pm1Var.a[i5])) {
                        pm1Var.l(i5);
                    }
                }
                return i4 != pm1Var.c;
        }
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.a;
        Object obj2 = this.b;
        switch (i2) {
            case 0:
                yo1.a(i, this);
                yl1 yl1Var = (yl1) obj2;
                if (i < 0 || i >= yl1Var.b) {
                    yl1Var.n(i);
                    throw null;
                }
                Object[] objArr = yl1Var.a;
                Object obj3 = objArr[i];
                objArr[i] = obj;
                return obj3;
            default:
                qm1.a(i, this);
                Object[] objArr2 = ((pm1) obj2).a;
                Object obj4 = objArr2[i];
                objArr2[i] = obj;
                return obj4;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((yl1) obj).b;
            default:
                return ((pm1) obj).c;
        }
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        switch (this.a) {
            case 0:
                yo1.b(this, i, i2);
                return new xl1(this, i, i2, 0);
            default:
                qm1.b(this, i, i2);
                return new xl1(this, i, i2, 1);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.a) {
            case 0:
                objArr.getClass();
                break;
        }
        return zt3.c(this, objArr);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        switch (this.a) {
            case 0:
                break;
        }
        return zt3.b(this);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        switch (this.a) {
            case 0:
                return new vl1(this, i, 0);
            default:
                return new vl1(this, i, 1);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((yl1) obj2).j(obj);
            default:
                return ((pm1) obj2).k(obj);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((yl1) obj2).a(obj);
                break;
            default:
                ((pm1) obj2).b(obj);
                break;
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                collection.getClass();
                yl1 yl1Var = (yl1) obj;
                int i2 = yl1Var.b;
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    yl1Var.a(it.next());
                }
                return i2 != yl1Var.b;
            default:
                pm1 pm1Var = (pm1) obj;
                return pm1Var.f(pm1Var.c, collection);
        }
    }
}
