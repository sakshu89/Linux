package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class n1 extends h1 {
    public abstract n1 b(int i, Object obj);

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
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

    public abstract n1 d(Object obj);

    public n1 f(Collection collection) {
        rw1 rw1VarG = g();
        rw1VarG.addAll(collection);
        return rw1VarG.d();
    }

    public abstract rw1 g();

    public abstract n1 h(m1 m1Var);

    public abstract n1 i(int i);

    @Override // defpackage.h1, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public abstract n1 j(int i, Object obj);

    @Override // defpackage.h1, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // defpackage.h1, java.util.List
    public final List subList(int i, int i2) {
        return new pz0(this, i, i2);
    }
}
