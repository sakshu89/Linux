package defpackage;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sy3 extends AbstractCollection {
    public final /* synthetic */ int a = 1;
    public final AbstractMap b;

    public sy3(gx3 gx3Var) {
        this.b = gx3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i = this.a;
        AbstractMap abstractMap = this.b;
        switch (i) {
            case 0:
                ((zy3) abstractMap).clear();
                break;
            default:
                ((gx3) abstractMap).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.a) {
            case 1:
                return ((gx3) this.b).containsValue(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.a) {
            case 1:
                return ((gx3) this.b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i = this.a;
        AbstractMap abstractMap = this.b;
        switch (i) {
            case 0:
                zy3 zy3Var = (zy3) abstractMap;
                Map mapD = zy3Var.d();
                return mapD != null ? mapD.values().iterator() : new hy3(zy3Var, 2);
            default:
                return new c04(((gx3) abstractMap).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.a) {
            case 1:
                gx3 gx3Var = (gx3) this.b;
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry entry : gx3Var.entrySet()) {
                        if (di4.b(obj, entry.getValue())) {
                            gx3Var.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.a) {
            case 1:
                gx3 gx3Var = (gx3) this.b;
                try {
                    if (collection != null) {
                        return super.removeAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : gx3Var.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return gx3Var.e.b().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.a) {
            case 1:
                gx3 gx3Var = (gx3) this.b;
                try {
                    if (collection != null) {
                        return super.retainAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : gx3Var.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return gx3Var.e.b().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i = this.a;
        AbstractMap abstractMap = this.b;
        switch (i) {
            case 0:
                return ((zy3) abstractMap).size();
            default:
                return ((gx3) abstractMap).c.size();
        }
    }

    public sy3(zy3 zy3Var) {
        this.b = zy3Var;
    }
}
