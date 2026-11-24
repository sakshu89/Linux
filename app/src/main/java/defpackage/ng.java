package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ng extends pk2 implements Map {
    public ig e;
    public kg f;
    public mg i;

    @Override // java.util.Map
    public final Set entrySet() {
        ig igVar = this.e;
        if (igVar != null) {
            return igVar;
        }
        ig igVar2 = new ig(this, 0);
        this.e = igVar2;
        return igVar2;
    }

    public final boolean i(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(Collection collection) {
        int i = this.c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.c;
    }

    @Override // java.util.Map
    public final Set keySet() {
        kg kgVar = this.f;
        if (kgVar != null) {
            return kgVar;
        }
        kg kgVar2 = new kg(this);
        this.f = kgVar2;
        return kgVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.c;
        int i = this.c;
        int[] iArr = this.a;
        if (iArr.length < size) {
            this.a = Arrays.copyOf(iArr, size);
            this.b = Arrays.copyOf(this.b, size * 2);
        }
        if (this.c != i) {
            og.d();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        mg mgVar = this.i;
        if (mgVar != null) {
            return mgVar;
        }
        mg mgVar2 = new mg(this);
        this.i = mgVar2;
        return mgVar2;
    }
}
