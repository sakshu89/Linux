package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class js4 extends mn4 {
    public static final js4 f = new js4(0, new Object[0]);
    public final transient Object[] c;
    public final transient int e;

    public js4(int i, Object[] objArr) {
        this.c = objArr;
        this.e = i;
    }

    @Override // defpackage.mn4, defpackage.yh4
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.c;
        int i = this.e;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.yh4
    public final int b() {
        return this.e;
    }

    @Override // defpackage.yh4
    public final int d() {
        return 0;
    }

    @Override // defpackage.yh4
    public final Object[] f() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        nh4.b(i, this.e);
        Object obj = this.c[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
