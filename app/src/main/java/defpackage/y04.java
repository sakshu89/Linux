package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y04 extends nz3 {
    public final transient Object[] i;
    public final transient int j;
    public final transient int k;

    public y04(int i, Object[] objArr) {
        super(2);
        this.i = objArr;
        this.j = i;
        this.k = 1;
    }

    @Override // java.util.List
    public final Object get(int i) {
        fi4.b(i, this.k);
        Object obj = this.i[i + i + this.j];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.k;
    }
}
