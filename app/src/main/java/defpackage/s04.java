package defpackage;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s04 extends nz3 {
    public final /* synthetic */ u04 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s04(u04 u04Var) {
        super(2);
        this.i = u04Var;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        u04 u04Var = this.i;
        fi4.b(i, u04Var.k);
        Object[] objArr = u04Var.j;
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
