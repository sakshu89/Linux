package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a33 extends y23 {
    public final lw1 e;

    public a33(lw1 lw1Var) {
        this.e = lw1Var;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.c;
        this.c = i + 2;
        Object[] objArr = this.a;
        return new tl1(this.e, objArr[i], objArr[i + 1]);
    }
}
