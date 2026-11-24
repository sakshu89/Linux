package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ix3 implements Iterator {
    public Map.Entry a;
    public final /* synthetic */ Iterator b;

    public ix3(cx3 cx3Var, Iterator it) {
        this.b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.b.next();
        this.a = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Map.Entry entry = this.a;
        if (!(entry != null)) {
            og.n("no calls to next() since the last call to remove()");
            return;
        }
        Collection collection = (Collection) entry.getValue();
        this.b.remove();
        collection.size();
        collection.clear();
        this.a = null;
    }
}
