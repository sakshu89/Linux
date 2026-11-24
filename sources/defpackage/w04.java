package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w04 extends rz3 {
    public final transient a14 i;
    public final transient y04 j;

    public w04(a14 a14Var, y04 y04Var) {
        super(2);
        this.i = a14Var;
        this.j = y04Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.i.get(obj) != null;
    }

    @Override // defpackage.sp3
    public final int g(Object[] objArr) {
        return this.j.g(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.j.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }
}
