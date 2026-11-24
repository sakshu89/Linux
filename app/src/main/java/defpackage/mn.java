package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mn extends i1 {
    public final /* synthetic */ int c = 1;
    public final Object e;

    public mn(Object[] objArr, int i, int i2) {
        super(i, i2);
        this.e = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.c;
        Object obj = this.e;
        switch (i) {
            case 0:
                if (!hasNext()) {
                    dk0.d();
                    return null;
                }
                int i2 = this.a;
                this.a = i2 + 1;
                return ((Object[]) obj)[i2];
            default:
                if (hasNext()) {
                    this.a++;
                    return obj;
                }
                dk0.d();
                return null;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.c;
        Object obj = this.e;
        switch (i) {
            case 0:
                if (!hasPrevious()) {
                    dk0.d();
                    return null;
                }
                int i2 = this.a - 1;
                this.a = i2;
                return ((Object[]) obj)[i2];
            default:
                if (hasPrevious()) {
                    this.a--;
                    return obj;
                }
                dk0.d();
                return null;
        }
    }

    public mn(int i, Object obj) {
        super(i, 1);
        this.e = obj;
    }
}
