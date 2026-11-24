package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tg1 extends l1 {
    public final /* synthetic */ int a;
    public final rg1 b;

    public /* synthetic */ tg1(rg1 rg1Var, int i) {
        this.a = i;
        this.b = rg1Var;
    }

    @Override // defpackage.l1
    public final int a() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i = this.a;
        collection.getClass();
        switch (i) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i = this.a;
        rg1 rg1Var = this.b;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                rg1Var.getClass();
                int iG = rg1Var.g(entry.getKey());
                if (iG < 0) {
                    return false;
                }
                Object[] objArr = rg1Var.b;
                objArr.getClass();
                return g31.a(objArr[iG], entry.getValue());
            default:
                return rg1Var.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.a) {
            case 0:
                collection.getClass();
                return this.b.e(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.a;
        rg1 rg1Var = this.b;
        switch (i) {
            case 0:
                rg1Var.getClass();
                return new og1(rg1Var, 0);
            default:
                rg1Var.getClass();
                return new og1(rg1Var, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i = this.a;
        rg1 rg1Var = this.b;
        switch (i) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    rg1Var.getClass();
                    rg1Var.c();
                    int iG = rg1Var.g(entry.getKey());
                    if (iG >= 0) {
                        Object[] objArr = rg1Var.b;
                        objArr.getClass();
                        if (g31.a(objArr[iG], entry.getValue())) {
                            rg1Var.k(iG);
                            return true;
                        }
                    }
                }
                return false;
            default:
                rg1Var.c();
                int iG2 = rg1Var.g(obj);
                if (iG2 < 0) {
                    return false;
                }
                rg1Var.k(iG2);
                return true;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i = this.a;
        rg1 rg1Var = this.b;
        collection.getClass();
        switch (i) {
            case 0:
                rg1Var.c();
                break;
            default:
                rg1Var.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i = this.a;
        rg1 rg1Var = this.b;
        collection.getClass();
        switch (i) {
            case 0:
                rg1Var.c();
                break;
            default:
                rg1Var.c();
                break;
        }
        return super.retainAll(collection);
    }
}
