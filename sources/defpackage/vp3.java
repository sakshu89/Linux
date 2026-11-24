package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vp3 extends wp3 {
    public final transient int i;
    public final transient int j;
    public final /* synthetic */ wp3 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vp3(wp3 wp3Var, int i, int i2) {
        super(0);
        this.k = wp3Var;
        this.i = i;
        this.j = i2;
    }

    @Override // defpackage.sp3
    public final int b() {
        return this.k.d() + this.i + this.j;
    }

    @Override // defpackage.sp3
    public final int d() {
        return this.k.d() + this.i;
    }

    @Override // defpackage.sp3
    public final Object[] f() {
        return this.k.f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        pg4.c(i, this.j);
        return this.k.get(i + this.i);
    }

    @Override // defpackage.wp3, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final wp3 subList(int i, int i2) {
        pg4.d(i, i2, this.j);
        int i3 = this.i;
        return this.k.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
