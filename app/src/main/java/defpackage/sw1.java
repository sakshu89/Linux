package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sw1 extends i1 {
    public final Object[] c;
    public final w23 e;

    public sw1(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        super(i, i2);
        this.c = objArr2;
        int i4 = (i2 - 1) & (-32);
        this.e = new w23(objArr, i > i4 ? i4 : i, i4, i3);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        w23 w23Var = this.e;
        if (w23Var.hasNext()) {
            this.a++;
            return w23Var.next();
        }
        int i = this.a;
        this.a = i + 1;
        return this.c[i - w23Var.b];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            dk0.d();
            return null;
        }
        int i = this.a;
        w23 w23Var = this.e;
        int i2 = w23Var.b;
        if (i <= i2) {
            this.a = i - 1;
            return w23Var.previous();
        }
        int i3 = i - 1;
        this.a = i3;
        return this.c[i3 - i2];
    }
}
