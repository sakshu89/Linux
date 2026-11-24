package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gt4 extends rq4 {
    public final transient a14 c;
    public final transient ht4 e;

    public gt4(a14 a14Var, ht4 ht4Var) {
        this.c = a14Var;
        this.e = ht4Var;
    }

    @Override // defpackage.yh4
    public final int a(Object[] objArr) {
        return this.e.a(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.c.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        this.c.getClass();
        return 1;
    }
}
