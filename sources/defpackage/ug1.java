package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ug1 extends AbstractCollection implements Collection, y41 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ ug1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.a) {
            case 0:
                collection.getClass();
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.a) {
            case 0:
                ((rg1) this.b).clear();
                break;
            default:
                ((fw1) this.b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                return ((rg1) this.b).containsValue(obj);
            default:
                return ((fw1) this.b).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.a) {
            case 0:
                return ((rg1) this.b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                rg1 rg1Var = (rg1) obj;
                rg1Var.getClass();
                return new og1(rg1Var, 2);
            default:
                fw1 fw1Var = (fw1) obj;
                y23[] y23VarArr = new y23[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    y23VarArr[i2] = new z23(2);
                }
                return new mw1(fw1Var, y23VarArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.a) {
            case 0:
                rg1 rg1Var = (rg1) this.b;
                rg1Var.c();
                int iH = rg1Var.h(obj);
                if (iH < 0) {
                    return false;
                }
                rg1Var.k(iH);
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.a) {
            case 0:
                collection.getClass();
                ((rg1) this.b).c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.a) {
            case 0:
                collection.getClass();
                ((rg1) this.b).c();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.a) {
            case 0:
                return ((rg1) this.b).n;
            default:
                return ((fw1) this.b).f;
        }
    }
}
