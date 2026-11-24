package defpackage;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xx3 extends lx3 {
    public final /* synthetic */ zx3 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx3(zx3 zx3Var) {
        super(1);
        this.i = zx3Var;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zx3 zx3Var = this.i;
        rh4.b(i, zx3Var.k);
        Object[] objArr = zx3Var.j;
        int i2 = i + i;
        Object obj = objArr[i2];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.i.k;
    }
}
