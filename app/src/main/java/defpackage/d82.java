package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d82 extends h1 implements RandomAccess {
    public final Object[] a;
    public final int b;
    public int c;
    public int e;

    public d82(int i, Object[] objArr) {
        this.a = objArr;
        if (i < 0) {
            og.g(ky0.h(i, "ring buffer filled size should not be negative but it is "));
            throw null;
        }
        if (i <= objArr.length) {
            this.b = objArr.length;
            this.e = i;
        } else {
            StringBuilder sbP = ky0.p("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbP.append(objArr.length);
            throw new IllegalArgumentException(sbP.toString().toString());
        }
    }

    @Override // defpackage.y0
    public final int a() {
        return this.e;
    }

    public final void b() {
        if (2 > this.e) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = 2, size = " + this.e).toString());
        }
        int i = this.c;
        int i2 = this.b;
        int i3 = (i + 2) % i2;
        Object[] objArr = this.a;
        if (i > i3) {
            Arrays.fill(objArr, i, i2, (Object) null);
            Arrays.fill(objArr, 0, i3, (Object) null);
        } else {
            Arrays.fill(objArr, i, i3, (Object) null);
        }
        this.c = i3;
        this.e -= 2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return null;
        }
        return this.a[(this.c + i) % this.b];
    }

    @Override // defpackage.h1, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new c82(this);
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        objArr.getClass();
        int length = objArr.length;
        int i = this.e;
        if (length < i) {
            objArr = Arrays.copyOf(objArr, i);
        }
        int i2 = this.e;
        int i3 = this.c;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            objArr2 = this.a;
            if (i5 >= i2 || i3 >= this.b) {
                break;
            }
            objArr[i5] = objArr2[i3];
            i5++;
            i3++;
        }
        while (i5 < i2) {
            objArr[i5] = objArr2[i4];
            i5++;
            i4++;
        }
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }
}
