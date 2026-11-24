package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ig extends AbstractSet {
    public final /* synthetic */ int a;
    public final /* synthetic */ Map b;

    public /* synthetic */ ig(Map map, int i) {
        this.a = i;
        this.b = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((tl2) map).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            case 2:
                Map.Entry entry2 = (Map.Entry) obj;
                if (contains(entry2)) {
                    return false;
                }
                ((hv3) map).put((Comparable) entry2.getKey(), entry2.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 1:
                ((tl2) map).clear();
                break;
            case 2:
                ((hv3) map).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((tl2) map).get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 != value) {
                    return obj2 != null && obj2.equals(value);
                }
                return true;
            case 2:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj3 = ((hv3) map).get(entry2.getKey());
                Object value2 = entry2.getValue();
                if (obj3 != value2) {
                    return obj3 != null && obj3.equals(value2);
                }
                return true;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                return new lg((ng) map);
            case 1:
                return new vl2((tl2) map, 0);
            default:
                return new vl2((hv3) map, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    return false;
                }
                ((tl2) map).remove(entry.getKey());
                return true;
            case 2:
                Map.Entry entry2 = (Map.Entry) obj;
                if (!contains(entry2)) {
                    return false;
                }
                ((hv3) map).remove(entry2.getKey());
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.a;
        Map map = this.b;
        switch (i) {
            case 0:
                return ((ng) map).c;
            case 1:
                return ((tl2) map).size();
            default:
                return ((hv3) map).size();
        }
    }
}
