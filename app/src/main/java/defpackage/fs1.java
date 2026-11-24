package defpackage;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fs1 extends h1 implements RandomAccess {
    public final oo[] a;
    public final int[] b;

    public fs1(oo[] ooVarArr, int[] iArr) {
        this.a = ooVarArr;
        this.b = iArr;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.a.length;
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof oo) {
            return super.contains((oo) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.a[i];
    }

    @Override // defpackage.h1, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof oo) {
            return super.indexOf((oo) obj);
        }
        return -1;
    }

    @Override // defpackage.h1, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof oo) {
            return super.lastIndexOf((oo) obj);
        }
        return -1;
    }
}
