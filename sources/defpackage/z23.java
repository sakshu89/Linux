package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z23 extends y23 {
    public final /* synthetic */ int e;

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.e) {
            case 0:
                int i = this.c;
                this.c = i + 2;
                Object[] objArr = this.a;
                return new vg1(0, objArr[i], objArr[i + 1]);
            case 1:
                int i2 = this.c;
                this.c = i2 + 2;
                return this.a[i2];
            default:
                int i3 = this.c;
                this.c = i3 + 2;
                return this.a[i3 + 1];
        }
    }
}
