package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class om4 extends mn4 {
    public final transient int c;
    public final transient int e;
    public final /* synthetic */ mn4 f;

    public om4(mn4 mn4Var, int i, int i2) {
        this.f = mn4Var;
        this.c = i;
        this.e = i2;
    }

    @Override // defpackage.yh4
    public final int b() {
        return this.f.d() + this.c + this.e;
    }

    @Override // defpackage.yh4
    public final int d() {
        return this.f.d() + this.c;
    }

    @Override // defpackage.yh4
    public final Object[] f() {
        return this.f.f();
    }

    @Override // defpackage.mn4, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final mn4 subList(int i, int i2) {
        nh4.c(i, i2, this.e);
        int i3 = this.c;
        return this.f.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List
    public final Object get(int i) {
        nh4.b(i, this.e);
        return this.f.get(i + this.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
