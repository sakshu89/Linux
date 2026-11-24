package defpackage;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends h1 implements RandomAccess {
    public final h1 a;
    public final int b;
    public final int c;

    public g1(h1 h1Var, int i, int i2) {
        this.a = h1Var;
        this.b = i;
        yb4.a(i, i2, h1Var.a());
        this.c = i2 - i;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return null;
        }
        return this.a.get(this.b + i);
    }

    @Override // defpackage.h1, java.util.List
    public final List subList(int i, int i2) {
        yb4.a(i, i2, this.c);
        int i3 = this.b;
        return new g1(this.a, i + i3, i3 + i2);
    }
}
