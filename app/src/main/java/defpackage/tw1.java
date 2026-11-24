package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tw1 extends i1 {
    public final rw1 c;
    public int e;
    public w23 f;
    public int i;

    public tw1(rw1 rw1Var, int i) {
        super(i, rw1Var.k);
        this.c = rw1Var;
        this.e = rw1Var.g();
        this.i = -1;
        b();
    }

    public final void a() {
        if (this.e == this.c.g()) {
            return;
        }
        og.d();
    }

    @Override // defpackage.i1, java.util.ListIterator
    public final void add(Object obj) {
        a();
        int i = this.a;
        rw1 rw1Var = this.c;
        rw1Var.add(i, obj);
        this.a++;
        this.b = rw1Var.a();
        this.e = rw1Var.g();
        this.i = -1;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void b() {
        rw1 rw1Var = this.c;
        Object[] objArr = rw1Var.i;
        if (objArr == null) {
            this.f = null;
            return;
        }
        int i = (rw1Var.k - 1) & (-32);
        int i2 = this.a;
        if (i2 > i) {
            i2 = i;
        }
        int i3 = (rw1Var.e / 5) + 1;
        w23 w23Var = this.f;
        if (w23Var == null) {
            this.f = new w23(objArr, i2, i, i3);
            return;
        }
        w23Var.a = i2;
        w23Var.b = i;
        w23Var.c = i3;
        if (w23Var.e.length < i3) {
            w23Var.e = new Object[i3];
        }
        w23Var.e[0] = objArr;
        var r0 = i2 == i ? 1 : 0;
        w23Var.f = r0;
        w23Var.b(i2 - r0, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        a();
        if (!hasNext()) {
            dk0.d();
            return null;
        }
        int i = this.a;
        this.i = i;
        w23 w23Var = this.f;
        rw1 rw1Var = this.c;
        if (w23Var == null) {
            Object[] objArr = rw1Var.j;
            this.a = i + 1;
            return objArr[i];
        }
        if (w23Var.hasNext()) {
            this.a++;
            return w23Var.next();
        }
        Object[] objArr2 = rw1Var.j;
        int i2 = this.a;
        this.a = i2 + 1;
        return objArr2[i2 - w23Var.b];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        if (!hasPrevious()) {
            dk0.d();
            return null;
        }
        int i = this.a;
        this.i = i - 1;
        w23 w23Var = this.f;
        rw1 rw1Var = this.c;
        if (w23Var == null) {
            Object[] objArr = rw1Var.j;
            int i2 = i - 1;
            this.a = i2;
            return objArr[i2];
        }
        int i3 = w23Var.b;
        if (i <= i3) {
            this.a = i - 1;
            return w23Var.previous();
        }
        Object[] objArr2 = rw1Var.j;
        int i4 = i - 1;
        this.a = i4;
        return objArr2[i4 - i3];
    }

    @Override // defpackage.i1, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        int i = this.i;
        if (i == -1) {
            throw new IllegalStateException();
        }
        rw1 rw1Var = this.c;
        rw1Var.b(i);
        int i2 = this.i;
        if (i2 < this.a) {
            this.a = i2;
        }
        this.b = rw1Var.a();
        this.e = rw1Var.g();
        this.i = -1;
        b();
    }

    @Override // defpackage.i1, java.util.ListIterator
    public final void set(Object obj) {
        a();
        int i = this.i;
        if (i == -1) {
            throw new IllegalStateException();
        }
        rw1 rw1Var = this.c;
        rw1Var.set(i, obj);
        this.e = rw1Var.g();
        b();
    }
}
