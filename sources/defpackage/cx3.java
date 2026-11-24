package defpackage;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cx3 extends AbstractSet {
    public final /* synthetic */ int a = 1;
    public final Map b;

    public cx3(by3 by3Var, Map map) {
        map.getClass();
        this.b = map;
    }

    public final boolean a(Collection collection) {
        return lh4.b(this, collection);
    }

    public final boolean b(Collection collection) {
        collection.getClass();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.a) {
            case 0:
                ((gx3) this.b).clear();
                break;
            default:
                Iterator it = iterator();
                while (true) {
                    ix3 ix3Var = (ix3) it;
                    if (ix3Var.hasNext()) {
                        ix3Var.next();
                        ix3Var.remove();
                    }
                    break;
                }
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                Set setEntrySet = ((gx3) map).c.entrySet();
                setEntrySet.getClass();
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            default:
                return map.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.a) {
            case 1:
                return this.b.keySet().containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        switch (this.a) {
            case 1:
                return this == obj || this.b.keySet().equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        switch (this.a) {
            case 1:
                return this.b.keySet().hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                return ((gx3) map).isEmpty();
            default:
                return map.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                return new dx3((gx3) map);
            default:
                return new ix3(this, map.entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object objRemove;
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                Object key = entry.getKey();
                zy3 zy3Var = ((gx3) map).e.c;
                zy3Var.getClass();
                try {
                    objRemove = zy3Var.remove(key);
                    break;
                } catch (ClassCastException | NullPointerException unused) {
                    objRemove = null;
                }
                Collection collection = (Collection) objRemove;
                if (collection != null) {
                    collection.size();
                    collection.clear();
                }
                return true;
            default:
                Collection collection2 = (Collection) map.remove(obj);
                if (collection2 == null) {
                    return false;
                }
                int size = collection2.size();
                collection2.clear();
                return size > 0;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.a) {
            case 0:
                try {
                    if (collection != null) {
                        return lh4.b(this, collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    Iterator it = collection.iterator();
                    boolean zRemove = false;
                    while (it.hasNext()) {
                        zRemove |= remove(it.next());
                    }
                    return zRemove;
                }
            default:
                return a(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        int iCeil;
        switch (this.a) {
            case 0:
                try {
                    if (collection != null) {
                        return b(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    int size = collection.size();
                    if (size >= 3) {
                        iCeil = size < 1073741824 ? (int) Math.ceil(((double) size) / 0.75d) : Integer.MAX_VALUE;
                    } else {
                        if (size < 0) {
                            og.i(ky0.h(size, "expectedSize cannot be negative but was: "));
                            return false;
                        }
                        iCeil = size + 1;
                    }
                    HashSet hashSet = new HashSet(iCeil);
                    for (Object obj : collection) {
                        if (contains(obj) && (obj instanceof Map.Entry)) {
                            hashSet.add(((Map.Entry) obj).getKey());
                        }
                    }
                    by3 by3Var = ((gx3) this.b).e;
                    cx3 cx3Var = by3Var.a;
                    if (cx3Var == null) {
                        cx3Var = new cx3(by3Var, by3Var.c);
                        by3Var.a = cx3Var;
                    }
                    return cx3Var.retainAll(hashSet);
                }
            default:
                return b(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                return ((gx3) map).c.size();
            default:
                return map.size();
        }
    }

    public cx3(gx3 gx3Var) {
        this.b = gx3Var;
    }
}
