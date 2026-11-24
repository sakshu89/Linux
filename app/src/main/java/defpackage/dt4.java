package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dt4 extends rq4 {
    public final transient a14 c;
    public final transient Object[] e;
    public final transient int f = 1;

    public dt4(a14 a14Var, Object[] objArr) {
        this.c = a14Var;
        this.e = objArr;
    }

    @Override // defpackage.yh4
    public final int a(Object[] objArr) {
        mn4 ws4Var = this.b;
        if (ws4Var == null) {
            ws4Var = new ws4(this);
            this.b = ws4Var;
        }
        return ws4Var.a(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        mn4 ws4Var = this.b;
        if (ws4Var == null) {
            ws4Var = new ws4(this);
            this.b = ws4Var;
        }
        return ws4Var.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f;
    }
}
