package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hy3 implements Iterator {
    public int a;
    public int b;
    public int c;
    public final /* synthetic */ zy3 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ zy3 i;

    public hy3(zy3 zy3Var, int i) {
        this.f = i;
        this.i = zy3Var;
        this.e = zy3Var;
        this.a = zy3Var.f;
        this.b = zy3Var.isEmpty() ? -1 : 0;
        this.c = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object qy3Var;
        zy3 zy3Var = this.e;
        if (zy3Var.f != this.a) {
            og.d();
            return null;
        }
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        int i = this.b;
        this.c = i;
        int i2 = this.f;
        zy3 zy3Var2 = this.i;
        switch (i2) {
            case 0:
                Object obj = zy3.s;
                qy3Var = zy3Var2.b()[i];
                break;
            case 1:
                qy3Var = new qy3(zy3Var2, i);
                break;
            default:
                Object obj2 = zy3.s;
                qy3Var = zy3Var2.c()[i];
                break;
        }
        int i3 = this.b + 1;
        if (i3 >= zy3Var.i) {
            i3 = -1;
        }
        this.b = i3;
        return qy3Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zy3 zy3Var = this.e;
        int i = zy3Var.f;
        int i2 = this.a;
        if (i != i2) {
            og.d();
            return;
        }
        int i3 = this.c;
        if (!(i3 >= 0)) {
            og.n("no calls to next() since the last call to remove()");
            return;
        }
        this.a = i2 + 32;
        zy3Var.remove(zy3Var.b()[i3]);
        this.b--;
        this.c = -1;
    }
}
