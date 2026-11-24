package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yg2 implements Iterator, x50, x41 {
    public int a;
    public Object b;
    public x50 c;

    public final RuntimeException a() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    public final void b(x50 x50Var, Object obj) {
        this.b = obj;
        this.a = 3;
        this.c = x50Var;
        x50Var.getClass();
    }

    @Override // defpackage.x50
    public final j70 f() {
        return gi0.a;
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        bz3.g(obj);
        this.a = 4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        while (true) {
            i = this.a;
            if (i != 0) {
                break;
            }
            this.a = 5;
            x50 x50Var = this.c;
            x50Var.getClass();
            this.c = null;
            x50Var.h(q43.a);
        }
        if (i == 1) {
            throw null;
        }
        if (i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            dk0.d();
            return null;
        }
        if (i == 2) {
            this.a = 1;
            throw null;
        }
        if (i != 3) {
            throw a();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
