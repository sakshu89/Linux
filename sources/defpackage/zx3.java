package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zx3 extends rx3 {
    public final transient gy3 i;
    public final transient Object[] j;
    public final transient int k;

    public zx3(gy3 gy3Var, Object[] objArr, int i) {
        super(1);
        this.i = gy3Var;
        this.j = objArr;
        this.k = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.i.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.sp3
    public final int g(Object[] objArr) {
        lx3 xx3Var = this.f;
        if (xx3Var == null) {
            xx3Var = new xx3(this);
            this.f = xx3Var;
        }
        return xx3Var.g(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        lx3 xx3Var = this.f;
        if (xx3Var == null) {
            xx3Var = new xx3(this);
            this.f = xx3Var;
        }
        return xx3Var.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.k;
    }
}
