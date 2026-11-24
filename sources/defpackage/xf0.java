package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xf0 implements Iterator, x41 {
    public final /* synthetic */ int a;
    public int b;
    public final Iterator c;

    public xf0(yf0 yf0Var) {
        this.a = 0;
        this.c = yf0Var.a.iterator();
        this.b = yf0Var.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        Iterator it = this.c;
        switch (i) {
            case 0:
                break;
            default:
                return this.b > 0 && it.hasNext();
        }
        while (this.b > 0 && it.hasNext()) {
            it.next();
            this.b--;
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        Iterator it = this.c;
        switch (i) {
            case 0:
                break;
            default:
                int i2 = this.b;
                if (i2 != 0) {
                    this.b = i2 - 1;
                    return it.next();
                }
                dk0.d();
                return null;
        }
        while (this.b > 0 && it.hasNext()) {
            it.next();
            this.b--;
        }
        return it.next();
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

    public xf0(mv2 mv2Var) {
        this.a = 1;
        this.b = 2;
        this.c = mv2Var.a.iterator();
    }
}
