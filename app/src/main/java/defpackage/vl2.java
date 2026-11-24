package defpackage;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vl2 implements Iterator {
    public final /* synthetic */ int a;
    public int b = -1;
    public boolean c;
    public Iterator e;
    public final /* synthetic */ AbstractMap f;

    public /* synthetic */ vl2(AbstractMap abstractMap, int i) {
        this.a = i;
        this.f = abstractMap;
    }

    public Iterator a() {
        if (this.e == null) {
            this.e = ((tl2) this.f).b.entrySet().iterator();
        }
        return this.e;
    }

    public Iterator b() {
        if (this.e == null) {
            this.e = ((hv3) this.f).c.entrySet().iterator();
        }
        return this.e;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        AbstractMap abstractMap = this.f;
        switch (i) {
            case 0:
                tl2 tl2Var = (tl2) abstractMap;
                if (this.b + 1 >= tl2Var.a.size()) {
                    return !tl2Var.b.isEmpty() && a().hasNext();
                }
                return true;
            default:
                hv3 hv3Var = (hv3) abstractMap;
                if (this.b + 1 >= hv3Var.b) {
                    return !hv3Var.c.isEmpty() && b().hasNext();
                }
                return true;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        AbstractMap abstractMap = this.f;
        switch (i) {
            case 0:
                this.c = true;
                int i2 = this.b + 1;
                this.b = i2;
                tl2 tl2Var = (tl2) abstractMap;
                return i2 < tl2Var.a.size() ? (Map.Entry) tl2Var.a.get(this.b) : (Map.Entry) a().next();
            default:
                this.c = true;
                int i3 = this.b + 1;
                this.b = i3;
                hv3 hv3Var = (hv3) abstractMap;
                return i3 < hv3Var.b ? (iv3) hv3Var.a[i3] : (Map.Entry) b().next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        AbstractMap abstractMap = this.f;
        switch (i) {
            case 0:
                tl2 tl2Var = (tl2) abstractMap;
                if (!this.c) {
                    og.n("remove() was called before next()");
                } else {
                    this.c = false;
                    int i2 = tl2.i;
                    tl2Var.b();
                    if (this.b >= tl2Var.a.size()) {
                        a().remove();
                    } else {
                        int i3 = this.b;
                        this.b = i3 - 1;
                        tl2Var.h(i3);
                    }
                }
                break;
            default:
                hv3 hv3Var = (hv3) abstractMap;
                if (!this.c) {
                    og.n("remove() was called before next()");
                } else {
                    this.c = false;
                    int i4 = hv3.j;
                    hv3Var.g();
                    int i5 = this.b;
                    if (i5 >= hv3Var.b) {
                        b().remove();
                    } else {
                        this.b = i5 - 1;
                        hv3Var.e(i5);
                    }
                }
                break;
        }
    }
}
