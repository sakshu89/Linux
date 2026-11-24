package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c82 implements Iterator, x41 {
    public final /* synthetic */ int a = 0;
    public int b;
    public int c;
    public int e;
    public Object f;
    public final Object i;

    public c82(d82 d82Var) {
        this.i = d82Var;
        this.c = d82Var.e;
        this.e = d82Var.c;
    }

    public boolean a() {
        this.b = 3;
        int i = this.c;
        if (i == 0) {
            this.b = 2;
        } else {
            d82 d82Var = (d82) this.i;
            Object[] objArr = d82Var.a;
            int i2 = this.e;
            this.f = objArr[i2];
            this.b = 1;
            this.e = (i2 + 1) % d82Var.b;
            this.c = i - 1;
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                int i = this.b;
                if (i == 0) {
                    return a();
                }
                if (i == 1) {
                    return true;
                }
                if (i != 2) {
                    og.i("hasNext called when the iterator is in the FAILED state.");
                }
                return false;
            default:
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                int i = this.b;
                if (i == 1) {
                    this.b = 0;
                    return this.f;
                }
                if (i == 2 || !a()) {
                    dk0.d();
                    return null;
                }
                this.b = 0;
                return this.f;
            default:
                throw null;
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

    public c82(ol2 ol2Var, int i, nv0 nv0Var, a54 a54Var) {
        this.f = ol2Var;
        this.b = i;
        this.i = a54Var;
        this.c = ol2Var.k;
    }
}
