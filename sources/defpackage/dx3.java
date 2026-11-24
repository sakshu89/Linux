package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class dx3 implements Iterator {
    public final /* synthetic */ int a = 0;
    public final Iterator b;
    public Collection c;
    public final /* synthetic */ Object e;

    public dx3(ux3 ux3Var) {
        this.e = ux3Var;
        Collection collection = ux3Var.b;
        this.c = collection;
        this.b = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        ux3 ux3Var = (ux3) this.e;
        ux3Var.b();
        if (ux3Var.b == this.c) {
            return;
        }
        og.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                break;
            default:
                a();
                break;
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        Iterator it = this.b;
        switch (i) {
            case 0:
                Map.Entry entry = (Map.Entry) it.next();
                this.c = (Collection) entry.getValue();
                Object key = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                by3 by3Var = ((gx3) this.e).e;
                by3Var.getClass();
                List list = (List) collection;
                return new gz3(key, list instanceof RandomAccess ? new nx3(by3Var, key, list, null) : new ux3(by3Var, key, list, null));
            default:
                a();
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        Object obj = this.e;
        Iterator it = this.b;
        switch (i) {
            case 0:
                if (!(this.c != null)) {
                    og.n("no calls to next() since the last call to remove()");
                } else {
                    it.remove();
                    ((gx3) obj).e.getClass();
                    this.c.size();
                    this.c.clear();
                    this.c = null;
                }
                break;
            default:
                it.remove();
                ((ux3) obj).d();
                break;
        }
    }

    public dx3(gx3 gx3Var) {
        this.e = gx3Var;
        this.b = gx3Var.c.entrySet().iterator();
    }

    public dx3(ux3 ux3Var, ListIterator listIterator) {
        this.e = ux3Var;
        this.c = ux3Var.b;
        this.b = listIterator;
    }
}
