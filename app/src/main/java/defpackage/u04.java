package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u04 extends rz3 {
    public final transient a14 i;
    public final transient Object[] j;
    public final transient int k;

    public u04(a14 a14Var, Object[] objArr) {
        super(2);
        this.i = a14Var;
        this.j = objArr;
        this.k = 1;
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
        nz3 s04Var = this.f;
        if (s04Var == null) {
            s04Var = new s04(this);
            this.f = s04Var;
        }
        return s04Var.g(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        nz3 s04Var = this.f;
        if (s04Var == null) {
            s04Var = new s04(this);
            this.f = s04Var;
        }
        return s04Var.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.k;
    }
}
