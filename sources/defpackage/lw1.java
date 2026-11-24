package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lw1 implements Iterator, x41 {
    public final /* synthetic */ int a = 0;
    public final Iterator b;

    public lw1(fw1 fw1Var) {
        y23[] y23VarArr = new y23[8];
        for (int i = 0; i < 8; i++) {
            y23VarArr[i] = new a33(this);
        }
        this.b = new jw1(fw1Var, y23VarArr);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                return ((jw1) this.b).c;
            default:
                return this.b.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                return (Map.Entry) ((jw1) this.b).next();
            default:
                return (p63) this.b.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                ((jw1) this.b).remove();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public lw1(n63 n63Var) {
        this.b = n63Var.s.iterator();
    }
}
