package defpackage;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xp3 implements ListIterator, Iterator {
    public final ListIterator a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AbstractList c;

    public xp3(AbstractList abstractList, ListIterator listIterator, int i) {
        this.b = i;
        this.c = abstractList;
        listIterator.getClass();
        this.a = listIterator;
    }

    public final Object a(Object obj) {
        int i = this.b;
        AbstractList abstractList = this.c;
        switch (i) {
            case 0:
                return ((op3) ((yp3) abstractList).c).h(obj);
            default:
                return ((op3) ((zp3) abstractList).c).h(obj);
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return a(this.a.next());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return a(this.a.previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.a.remove();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
