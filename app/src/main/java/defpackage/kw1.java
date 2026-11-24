package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kw1 extends l1 {
    public final /* synthetic */ int a;
    public final fw1 b;

    public /* synthetic */ kw1(int i, fw1 fw1Var) {
        this.a = i;
        this.b = fw1Var;
    }

    @Override // defpackage.l1
    public final int a() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                fw1 fw1Var = this.b;
                Object obj2 = fw1Var.get(key);
                if (obj2 != null) {
                    return obj2.equals(entry.getValue());
                }
                return entry.getValue() == null && fw1Var.containsKey(entry.getKey());
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new lw1(this.b);
            default:
                y23[] y23VarArr = new y23[8];
                for (int i = 0; i < 8; i++) {
                    y23VarArr[i] = new z23(1);
                }
                return new mw1(this.b, y23VarArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.b.remove(entry.getKey(), entry.getValue());
            default:
                fw1 fw1Var = this.b;
                if (!fw1Var.containsKey(obj)) {
                    return false;
                }
                fw1Var.remove(obj);
                return true;
        }
    }
}
