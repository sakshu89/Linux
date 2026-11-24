package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yp3 extends AbstractList implements RandomAccess, Serializable {
    public final /* synthetic */ int a = 1;
    public final List b;
    public final Object c;

    public yp3(List list, op3 op3Var) {
        list.getClass();
        this.b = list;
        this.c = op3Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.a;
        Object obj = this.c;
        List list = this.b;
        switch (i2) {
            case 0:
                return ((op3) obj).h(list.get(i));
            default:
                return ((ks4) obj).f(list.get(i));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                break;
        }
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        switch (this.a) {
            case 0:
                return new xp3(this, this.b.listIterator(i), 0);
            default:
                return new vz3(this, this.b.listIterator(i), 0);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2 = this.a;
        Object obj = this.c;
        List list = this.b;
        switch (i2) {
            case 0:
                return ((op3) obj).h(list.remove(i));
            default:
                return ((ks4) obj).f(list.remove(i));
        }
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        switch (this.a) {
            case 0:
                this.b.subList(i, i2).clear();
                break;
            default:
                this.b.subList(i, i2).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.size();
    }

    public yp3(List list, ks4 ks4Var) {
        list.getClass();
        this.b = list;
        this.c = ks4Var;
    }
}
