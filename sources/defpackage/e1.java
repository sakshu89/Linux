package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class e1 implements Iterator, x41 {
    public final /* synthetic */ int a = 0;
    public int b;
    public final Object c;

    public e1(Object[] objArr) {
        objArr.getClass();
        this.c = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                return this.b < ((h1) this.c).a();
            default:
                return this.b < ((Object[]) this.c).length;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                if (!hasNext()) {
                    dk0.d();
                    return null;
                }
                h1 h1Var = (h1) this.c;
                int i = this.b;
                this.b = i + 1;
                return h1Var.get(i);
            default:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    kf2.g(e.getMessage());
                    return null;
                }
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

    public e1(h1 h1Var) {
        this.c = h1Var;
    }
}
