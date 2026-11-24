package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ul0 implements Iterator, x41 {
    public final Iterator b;
    public Object e;
    public final /* synthetic */ xg2 f;
    public final /* synthetic */ int a = 1;
    public int c = -1;

    public ul0(au0 au0Var) {
        this.f = au0Var;
        this.b = ((xg2) au0Var.b).iterator();
    }

    public void a() {
        Object next;
        vl0 vl0Var = (vl0) this.f;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) vl0Var.c.j(next)).booleanValue() != vl0Var.b);
        this.e = next;
        this.c = 1;
    }

    public void b() {
        Iterator it = this.b;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) ((x0) ((au0) this.f).c).j(next)).booleanValue()) {
                this.c = 1;
                this.e = next;
                return;
            }
        }
        this.c = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                return this.c == 1;
            default:
                if (this.c == -1) {
                    b();
                }
                return this.c == 1;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 0) {
                    dk0.d();
                    return null;
                }
                Object obj = this.e;
                this.e = null;
                this.c = -1;
                return obj;
            default:
                if (this.c == -1) {
                    b();
                }
                if (this.c == 0) {
                    dk0.d();
                    return null;
                }
                Object obj2 = this.e;
                this.e = null;
                this.c = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ul0(vl0 vl0Var) {
        this.f = vl0Var;
        this.b = vl0Var.a.iterator();
    }
}
