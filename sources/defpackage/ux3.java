package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ux3 extends AbstractCollection implements List {
    public final Object a;
    public Collection b;
    public final ux3 c;
    public final Collection e;
    public final /* synthetic */ by3 f;
    public final /* synthetic */ by3 i;

    public ux3(by3 by3Var, Object obj, List list, ux3 ux3Var) {
        this.i = by3Var;
        this.f = by3Var;
        this.a = obj;
        this.b = list;
        this.c = ux3Var;
        this.e = ux3Var == null ? null : ux3Var.b;
    }

    public final void a() {
        ux3 ux3Var = this.c;
        if (ux3Var != null) {
            ux3Var.a();
            return;
        }
        this.f.c.put(this.a, this.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        boolean zIsEmpty = this.b.isEmpty();
        boolean zAdd = this.b.add(obj);
        if (!zAdd || !zIsEmpty) {
            return zAdd;
        }
        a();
        return true;
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.b).addAll(i, collection);
        if (zAddAll) {
            this.b.size();
            if (size == 0) {
                a();
                return true;
            }
        }
        return zAddAll;
    }

    public final void b() {
        ux3 ux3Var = this.c;
        if (ux3Var != null) {
            ux3Var.b();
            if (ux3Var.b == this.e) {
                return;
            }
            og.d();
            return;
        }
        if (this.b.isEmpty()) {
            Collection collection = (Collection) this.f.c.get(this.a);
            if (collection != null) {
                this.b = collection;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (size() == 0) {
            return;
        }
        this.b.clear();
        d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        b();
        return this.b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        b();
        return this.b.containsAll(collection);
    }

    public final void d() {
        ux3 ux3Var = this.c;
        if (ux3Var != null) {
            ux3Var.d();
        } else if (this.b.isEmpty()) {
            this.f.c.remove(this.a);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.b.equals(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        b();
        return ((List) this.b).get(i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        b();
        return this.b.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        b();
        return ((List) this.b).indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        b();
        return new dx3(this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        b();
        return ((List) this.b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        b();
        return new sx3(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        b();
        Object objRemove = ((List) this.b).remove(i);
        d();
        return objRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        size();
        boolean zRemoveAll = this.b.removeAll(collection);
        if (zRemoveAll) {
            this.b.size();
            d();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        size();
        boolean zRetainAll = this.b.retainAll(collection);
        if (zRetainAll) {
            this.b.size();
            d();
        }
        return zRetainAll;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        b();
        return ((List) this.b).set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        b();
        return this.b.size();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        b();
        List listSubList = ((List) this.b).subList(i, i2);
        ux3 ux3Var = this.c;
        if (ux3Var == null) {
            ux3Var = this;
        }
        boolean z = listSubList instanceof RandomAccess;
        Object obj = this.a;
        by3 by3Var = this.i;
        return z ? new nx3(by3Var, obj, listSubList, ux3Var) : new ux3(by3Var, obj, listSubList, ux3Var);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        b();
        return this.b.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        b();
        return new sx3(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        boolean zRemove = this.b.remove(obj);
        if (zRemove) {
            d();
        }
        return zRemove;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        b();
        boolean zIsEmpty = this.b.isEmpty();
        ((List) this.b).add(i, obj);
        if (zIsEmpty) {
            a();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.b.addAll(collection);
        if (zAddAll) {
            this.b.size();
            if (size == 0) {
                a();
                return true;
            }
        }
        return zAddAll;
    }
}
