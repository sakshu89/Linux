package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ht4 extends mn4 {
    public final transient Object[] c;
    public final transient int e;
    public final transient int f = 1;

    public ht4(int i, Object[] objArr) {
        this.c = objArr;
        this.e = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        nh4.b(i, this.f);
        Object obj = this.c[i + i + this.e];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f;
    }
}
