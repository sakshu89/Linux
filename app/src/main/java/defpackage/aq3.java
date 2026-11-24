package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aq3 extends wp3 {
    public static final aq3 k = new aq3(0, new Object[0]);
    public final transient Object[] i;
    public final transient int j;

    public aq3(int i, Object[] objArr) {
        super(0);
        this.i = objArr;
        this.j = i;
    }

    @Override // defpackage.wp3, defpackage.sp3
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.i;
        int i = this.j;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // defpackage.sp3
    public final int b() {
        return this.j;
    }

    @Override // defpackage.sp3
    public final int d() {
        return 0;
    }

    @Override // defpackage.sp3
    public final Object[] f() {
        return this.i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        pg4.c(i, this.j);
        Object obj = this.i[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
