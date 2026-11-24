package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lz3 extends nz3 {
    public final transient int i;
    public final transient int j;
    public final /* synthetic */ nz3 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz3(nz3 nz3Var, int i, int i2) {
        super(2);
        this.k = nz3Var;
        this.i = i;
        this.j = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        fi4.b(i, this.j);
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

    @Override // defpackage.nz3, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final nz3 subList(int i, int i2) {
        fi4.c(i, i2, this.j);
        int i3 = this.i;
        return this.k.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
