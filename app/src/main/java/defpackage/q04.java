package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q04 extends nz3 {
    public static final q04 k = new q04(0, new Object[0]);
    public final transient Object[] i;
    public final transient int j;

    public q04(int i, Object[] objArr) {
        super(2);
        this.i = objArr;
        this.j = i;
    }

    @Override // defpackage.nz3, defpackage.sp3
    public final int g(Object[] objArr) {
        Object[] objArr2 = this.i;
        int i = this.j;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        fi4.b(i, this.j);
        Object obj = this.i[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // defpackage.sp3
    public final int h() {
        return this.j;
    }

    @Override // defpackage.sp3
    public final int i() {
        return 0;
    }

    @Override // defpackage.sp3
    public final Object[] j() {
        return this.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
