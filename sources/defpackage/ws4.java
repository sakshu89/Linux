package defpackage;

import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ws4 extends mn4 {
    public final /* synthetic */ dt4 c;

    public ws4(dt4 dt4Var) {
        this.c = dt4Var;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        dt4 dt4Var = this.c;
        nh4.b(i, dt4Var.f);
        Object[] objArr = dt4Var.e;
        int i2 = i + i;
        Object obj = objArr[i2];
        obj.getClass();
        Object obj2 = objArr[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.f;
    }
}
