package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ly3 extends AbstractSet {
    public final /* synthetic */ int a;
    public final /* synthetic */ zy3 b;

    public /* synthetic */ ly3(zy3 zy3Var, int i) {
        this.a = i;
        this.b = zy3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.a;
        zy3 zy3Var = this.b;
        switch (i) {
            case 0:
                zy3Var.clear();
                break;
            default:
                zy3Var.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i = this.a;
        zy3 zy3Var = this.b;
        switch (i) {
            case 0:
                Map mapD = zy3Var.d();
                if (mapD != null) {
                    return mapD.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iH = zy3Var.h(entry.getKey());
                    if (iH != -1 && di4.b(zy3Var.c()[iH], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return zy3Var.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.a;
        zy3 zy3Var = this.b;
        switch (i) {
            case 0:
                Map mapD = zy3Var.d();
                return mapD != null ? mapD.entrySet().iterator() : new hy3(zy3Var, 1);
            default:
                Map mapD2 = zy3Var.d();
                return mapD2 != null ? mapD2.keySet().iterator() : new hy3(zy3Var, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i = this.a;
        zy3 zy3Var = this.b;
        switch (i) {
            case 0:
                Map mapD = zy3Var.d();
                if (mapD != null) {
                    return mapD.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!zy3Var.f()) {
                        int iG = zy3Var.g();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = zy3Var.a;
                        Objects.requireNonNull(obj2);
                        int iB = fh4.b(key, value, iG, obj2, zy3Var.a(), zy3Var.b(), zy3Var.c());
                        if (iB != -1) {
                            zy3Var.e(iB, iG);
                            zy3Var.i--;
                            zy3Var.f += 32;
                            return true;
                        }
                    }
                }
                return false;
            default:
                Map mapD2 = zy3Var.d();
                if (mapD2 != null) {
                    return mapD2.keySet().remove(obj);
                }
                return zy3Var.j(obj) != zy3.s;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.a;
        zy3 zy3Var = this.b;
        switch (i) {
            case 0:
                break;
        }
        return zy3Var.size();
    }
}
