package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pz0 extends h1 {
    public final n1 a;
    public final int b;
    public final int c;

    public pz0(n1 n1Var, int i, int i2) {
        this.a = n1Var;
        this.b = i;
        nq4.c(i, i2, n1Var.a());
        this.c = i2 - i;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        nq4.a(i, this.c);
        return this.a.get(this.b + i);
    }

    @Override // defpackage.h1, java.util.List
    public final List subList(int i, int i2) {
        nq4.c(i, i2, this.c);
        int i3 = this.b;
        return new pz0(this.a, i + i3, i3 + i2);
    }
}
