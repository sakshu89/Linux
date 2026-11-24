package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jx3 extends lx3 {
    public final transient int i;
    public final transient int j;
    public final /* synthetic */ lx3 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jx3(lx3 lx3Var, int i, int i2) {
        super(1);
        this.k = lx3Var;
        this.i = i;
        this.j = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        rh4.b(i, this.j);
        return this.k.get(i + this.i);
    }

    @Override // defpackage.sp3
    public final int h() {
        return this.k.i() + this.i + this.j;
    }

    @Override // defpackage.sp3
    public final int i() {
        return this.k.i() + this.i;
    }

    @Override // defpackage.sp3
    public final Object[] j() {
        return this.k.j();
    }

    @Override // defpackage.lx3, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final lx3 subList(int i, int i2) {
        rh4.d(i, i2, this.j);
        int i3 = this.i;
        return this.k.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
