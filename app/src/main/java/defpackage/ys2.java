package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ys2 implements Collection, x41 {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public ys2() {
        int i = is1.a;
        this.b = new am1(6);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                return ((am1) this.b).a(obj);
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.a) {
            case 0:
                ((am1) this.b).b();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                return ((am1) this.b).c(obj);
            default:
                return ((gm1) this.b).d(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!((am1) obj).c(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                collection.getClass();
                Collection collection2 = collection;
                if (!collection2.isEmpty()) {
                    Iterator it2 = collection2.iterator();
                    while (it2.hasNext()) {
                        if (!((gm1) obj).d(it2.next())) {
                            return false;
                        }
                    }
                }
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.a) {
            case 0:
                return ((am1) this.b).g == 0;
            default:
                return ((gm1) this.b).i();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                am1 am1Var = (am1) this.b;
                am1Var.getClass();
                return new zt0(new cm1(am1Var));
            default:
                return ah2.a(new dj0(this, null, 3));
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.a) {
            case 0:
                return ((am1) this.b).g(obj);
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.a) {
            case 0:
                return ((am1) this.b).g(collection);
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate predicate) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.a) {
            case 0:
                return ((am1) this.b).i(collection);
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.a) {
            case 0:
                return ((am1) this.b).g;
            default:
                return ((gm1) this.b).e;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.a) {
            case 0:
                break;
            default:
                objArr.getClass();
                break;
        }
        return zt3.c(this, objArr);
    }

    public ys2(gm1 gm1Var) {
        gm1Var.getClass();
        this.b = gm1Var;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.a) {
            case 0:
                break;
        }
        return zt3.b(this);
    }
}
