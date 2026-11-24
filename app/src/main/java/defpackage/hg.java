package defpackage;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hg extends k1 {
    public static final Object[] e = new Object[0];
    public int a;
    public Object[] b;
    public int c;

    public hg(int i) {
        this.b = new Object[2];
    }

    @Override // defpackage.k1
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i2 = this.c;
        if (i < 0 || i > i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return;
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        l();
        f(this.c + 1);
        int iK = k(this.a + i);
        int i3 = this.c;
        if (i < ((i3 + 1) >> 1)) {
            if (iK == 0) {
                Object[] objArr = this.b;
                objArr.getClass();
                length = objArr.length - 1;
            } else {
                length = iK - 1;
            }
            int length2 = this.a;
            if (length2 == 0) {
                Object[] objArr2 = this.b;
                objArr2.getClass();
                length2 = objArr2.length;
            }
            int i4 = length2 - 1;
            int i5 = this.a;
            Object[] objArr3 = this.b;
            if (length >= i5) {
                objArr3[i4] = objArr3[i5];
                qg.g(objArr3, i5, objArr3, i5 + 1, length + 1);
            } else {
                qg.g(objArr3, i5 - 1, objArr3, i5, objArr3.length);
                Object[] objArr4 = this.b;
                objArr4[objArr4.length - 1] = objArr4[0];
                qg.g(objArr4, 0, objArr4, 1, length + 1);
            }
            this.b[length] = obj;
            this.a = i4;
        } else {
            int iK2 = k(i3 + this.a);
            Object[] objArr5 = this.b;
            if (iK < iK2) {
                qg.g(objArr5, iK + 1, objArr5, iK, iK2);
            } else {
                qg.g(objArr5, 1, objArr5, 0, iK2);
                Object[] objArr6 = this.b;
                objArr6[0] = objArr6[objArr6.length - 1];
                qg.g(objArr6, iK + 1, objArr6, iK, objArr6.length - 1);
            }
            this.b[iK] = obj;
        }
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        int i2 = this.c;
        if (i < 0 || i > i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return false;
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.c) {
            return addAll(collection);
        }
        l();
        f(collection.size() + this.c);
        int iK = k(this.c + this.a);
        int iK2 = k(this.a + i);
        int size = collection.size();
        if (i >= ((this.c + 1) >> 1)) {
            int i3 = iK2 + size;
            Object[] objArr = this.b;
            if (iK2 < iK) {
                int i4 = size + iK;
                if (i4 <= objArr.length) {
                    qg.g(objArr, i3, objArr, iK2, iK);
                } else if (i3 >= objArr.length) {
                    qg.g(objArr, i3 - objArr.length, objArr, iK2, iK);
                } else {
                    int length = iK - (i4 - objArr.length);
                    qg.g(objArr, 0, objArr, length, iK);
                    Object[] objArr2 = this.b;
                    qg.g(objArr2, i3, objArr2, iK2, length);
                }
            } else {
                qg.g(objArr, size, objArr, 0, iK);
                Object[] objArr3 = this.b;
                if (i3 >= objArr3.length) {
                    qg.g(objArr3, i3 - objArr3.length, objArr3, iK2, objArr3.length);
                } else {
                    qg.g(objArr3, 0, objArr3, objArr3.length - size, objArr3.length);
                    Object[] objArr4 = this.b;
                    qg.g(objArr4, i3, objArr4, iK2, objArr4.length - size);
                }
            }
            d(iK2, collection);
            return true;
        }
        int i5 = this.a;
        int length2 = i5 - size;
        Object[] objArr5 = this.b;
        if (iK2 < i5) {
            qg.g(objArr5, length2, objArr5, i5, objArr5.length);
            Object[] objArr6 = this.b;
            if (size >= iK2) {
                qg.g(objArr6, objArr6.length - size, objArr6, 0, iK2);
            } else {
                qg.g(objArr6, objArr6.length - size, objArr6, 0, size);
                Object[] objArr7 = this.b;
                qg.g(objArr7, 0, objArr7, size, iK2);
            }
        } else if (length2 >= 0) {
            qg.g(objArr5, length2, objArr5, i5, iK2);
        } else {
            length2 += objArr5.length;
            int i6 = iK2 - i5;
            int length3 = objArr5.length - length2;
            if (length3 >= i6) {
                qg.g(objArr5, length2, objArr5, i5, iK2);
            } else {
                qg.g(objArr5, length2, objArr5, i5, i5 + length3);
                Object[] objArr8 = this.b;
                qg.g(objArr8, 0, objArr8, this.a + length3, iK2);
            }
        }
        this.a = length2;
        d(i(iK2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        l();
        f(this.c + 1);
        int length = this.a;
        if (length == 0) {
            Object[] objArr = this.b;
            objArr.getClass();
            length = objArr.length;
        }
        int i = length - 1;
        this.a = i;
        this.b[i] = obj;
        this.c++;
    }

    public final void addLast(Object obj) {
        l();
        f(a() + 1);
        this.b[k(a() + this.a)] = obj;
        this.c = a() + 1;
    }

    @Override // defpackage.k1
    public final Object b(int i) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            og.o(ky0.i("index: ", i, i2, ", size: "));
            return null;
        }
        if (i == a() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        l();
        int iK = k(this.a + i);
        Object[] objArr = this.b;
        Object obj = objArr[iK];
        int i3 = this.c >> 1;
        int i4 = this.a;
        if (i < i3) {
            if (iK >= i4) {
                qg.g(objArr, i4 + 1, objArr, i4, iK);
            } else {
                qg.g(objArr, 1, objArr, 0, iK);
                Object[] objArr2 = this.b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.a;
                qg.g(objArr2, i5 + 1, objArr2, i5, objArr2.length - 1);
            }
            Object[] objArr3 = this.b;
            int i6 = this.a;
            objArr3[i6] = null;
            this.a = g(i6);
        } else {
            int iK2 = k((a() - 1) + i4);
            Object[] objArr4 = this.b;
            if (iK <= iK2) {
                qg.g(objArr4, iK, objArr4, iK + 1, iK2 + 1);
            } else {
                qg.g(objArr4, iK, objArr4, iK + 1, objArr4.length);
                Object[] objArr5 = this.b;
                objArr5[objArr5.length - 1] = objArr5[0];
                qg.g(objArr5, 0, objArr5, 1, iK2 + 1);
            }
            this.b[iK2] = null;
        }
        this.c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            l();
            j(this.a, k(a() + this.a));
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = collection.size() + this.c;
    }

    public final void f(int i) {
        if (i < 0) {
            og.n("Deque is too big.");
            return;
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            if (i < 10) {
                i = 10;
            }
            this.b = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        qg.g(objArr, 0, objArr2, this.a, objArr.length);
        Object[] objArr3 = this.b;
        int length2 = objArr3.length;
        int i3 = this.a;
        qg.g(objArr3, length2 - i3, objArr2, 0, i3);
        this.a = 0;
        this.b = objArr2;
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.b[this.a];
        }
        kf2.g("ArrayDeque is empty.");
        return null;
    }

    public final int g(int i) {
        Object[] objArr = this.b;
        objArr.getClass();
        if (i == objArr.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i >= 0 && i < iA) {
            return this.b[k(this.a + i)];
        }
        og.o(ky0.i("index: ", i, iA, ", size: "));
        return null;
    }

    public final Object h() {
        if (isEmpty()) {
            return null;
        }
        return this.b[k((size() - 1) + this.a)];
    }

    public final int i(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iK = k(a() + this.a);
        int length = this.a;
        if (length < iK) {
            while (length < iK) {
                if (g31.a(obj, this.b[length])) {
                    i = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (isEmpty() || (length = this.a) < iK) {
            return -1;
        }
        int length2 = this.b.length;
        while (length < length2) {
            if (g31.a(obj, this.b[length])) {
                i = this.a;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iK; i2++) {
            if (g31.a(obj, this.b[i2])) {
                length = i2 + this.b.length;
                i = this.a;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final void j(int i, int i2) {
        Object[] objArr = this.b;
        if (i < i2) {
            qg.l(i, i2, null, objArr);
        } else {
            qg.l(i, objArr.length, null, objArr);
            qg.l(0, i2, null, this.b);
        }
    }

    public final int k(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void l() {
        ((AbstractList) this).modCount++;
    }

    public final Object last() {
        if (isEmpty()) {
            kf2.g("ArrayDeque is empty.");
            return null;
        }
        return this.b[k((size() - 1) + this.a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr;
        int length;
        int i;
        int iK = k(this.c + this.a);
        int i2 = this.a;
        if (i2 < iK) {
            length = iK - 1;
            if (i2 <= length) {
                while (!g31.a(obj, this.b[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.a;
                return length - i;
            }
            return -1;
        }
        if (!isEmpty() && this.a >= iK) {
            do {
                iK--;
                objArr = this.b;
                if (-1 >= iK) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i3 = this.a;
                    if (i3 <= length) {
                        while (!g31.a(obj, this.b[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        i = this.a;
                    }
                }
                return length - i;
            } while (!g31.a(obj, objArr[iK]));
            length = iK + this.b.length;
            i = this.a;
            return length - i;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iK;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iK2 = k(a() + this.a);
            int i = this.a;
            if (i < iK2) {
                iK = i;
                while (true) {
                    objArr = this.b;
                    if (i >= iK2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[iK] = obj;
                        iK++;
                    }
                    i++;
                }
                qg.l(iK, iK2, null, objArr);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iK = k(i2);
                for (int i3 = 0; i3 < iK2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.b[iK] = obj3;
                        iK = g(iK);
                    }
                }
                z = z2;
            }
            if (z) {
                l();
                this.c = i(iK - this.a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            kf2.g("ArrayDeque is empty.");
            return null;
        }
        l();
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = g(i);
        this.c = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            kf2.g("ArrayDeque is empty.");
            return null;
        }
        l();
        int iK = k((size() - 1) + this.a);
        Object[] objArr = this.b;
        Object obj = objArr[iK];
        objArr[iK] = null;
        this.c = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        yb4.a(i, i2, this.c);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.c) {
            clear();
            return;
        }
        if (i3 == 1) {
            b(i);
            return;
        }
        l();
        int i4 = this.c - i2;
        int i5 = this.a;
        if (i < i4) {
            int iK = k((i - 1) + i5);
            int iK2 = k(this.a + (i2 - 1));
            while (i > 0) {
                int i6 = iK + 1;
                int iMin = Math.min(i, Math.min(i6, iK2 + 1));
                Object[] objArr = this.b;
                int i7 = iK2 - iMin;
                int i8 = iK - iMin;
                qg.g(objArr, i7 + 1, objArr, i8 + 1, i6);
                iK = i(i8);
                iK2 = i(i7);
                i -= iMin;
            }
            int iK3 = k(this.a + i3);
            j(this.a, iK3);
            this.a = iK3;
        } else {
            int iK4 = k(i5 + i2);
            int iK5 = k(this.a + i);
            int i9 = this.c;
            while (true) {
                i9 -= i2;
                if (i9 <= 0) {
                    break;
                }
                Object[] objArr2 = this.b;
                i2 = Math.min(i9, Math.min(objArr2.length - iK4, objArr2.length - iK5));
                Object[] objArr3 = this.b;
                int i10 = iK4 + i2;
                qg.g(objArr3, iK5, objArr3, iK4, i10);
                iK4 = k(i10);
                iK5 = k(iK5 + i2);
            }
            int iK6 = k(this.c + this.a);
            j(i(iK6 - i3), iK6);
        }
        this.c -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iK;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iK2 = k(a() + this.a);
            int i = this.a;
            if (i < iK2) {
                iK = i;
                while (true) {
                    objArr = this.b;
                    if (i >= iK2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.b[iK] = obj;
                        iK++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                qg.l(iK, iK2, null, objArr);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iK = k(i2);
                for (int i3 = 0; i3 < iK2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.b[iK] = obj3;
                        iK = g(iK);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                l();
                this.c = i(iK - this.a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            og.o(ky0.i("index: ", i, iA, ", size: "));
            return null;
        }
        int iK = k(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iK];
        objArr[iK] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.c;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        int iK = k(this.c + this.a);
        int i2 = this.a;
        if (i2 < iK) {
            qg.i(this.b, i2, objArr, iK, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            qg.g(objArr2, 0, objArr, this.a, objArr2.length);
            Object[] objArr3 = this.b;
            qg.g(objArr3, objArr3.length - this.a, objArr, 0, iK);
        }
        int i3 = this.c;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    public hg() {
        this.b = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        l();
        f(collection.size() + a());
        d(k(a() + this.a), collection);
        return true;
    }
}
