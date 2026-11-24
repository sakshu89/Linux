package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rw1 extends k1 implements Collection, y41 {
    public n1 a;
    public Object[] b;
    public Object[] c;
    public int e;
    public y74 f = new y74(15);
    public Object[] i;
    public Object[] j;
    public int k;

    public rw1(n1 n1Var, Object[] objArr, Object[] objArr2, int i) {
        this.a = n1Var;
        this.b = objArr;
        this.c = objArr2;
        this.e = i;
        this.i = objArr;
        this.j = objArr2;
        this.k = n1Var.a();
    }

    public static void f(Object[] objArr, int i, Iterator it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    public final boolean A(hq0 hq0Var) {
        int i;
        hq0 hq0Var2 = hq0Var;
        int iG = G();
        Object[] objArrQ = null;
        c4 c4Var = new c4(null);
        boolean z = false;
        if (this.i != null) {
            i1 i1VarL = l(0);
            int iY = 32;
            while (iY == 32 && i1VarL.hasNext()) {
                iY = y(hq0Var2, (Object[]) i1VarL.next(), 32, c4Var);
            }
            if (iY == 32) {
                int iZ = z(hq0Var2, iG, c4Var);
                if (iZ == 0) {
                    s(this.i, this.k, this.e);
                }
                if (iZ != iG) {
                }
            } else {
                int i2 = (i1VarL.a - 1) << 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int iX = iY;
                while (i1VarL.hasNext()) {
                    iX = x(hq0Var2, (Object[]) i1VarL.next(), 32, iX, c4Var, arrayList2, arrayList);
                    hq0Var2 = hq0Var;
                }
                int iX2 = x(hq0Var, this.j, iG, iX, c4Var, arrayList2, arrayList);
                Object obj = c4Var.a;
                obj.getClass();
                Object[] objArr = (Object[]) obj;
                Arrays.fill(objArr, iX2, 32, (Object) null);
                boolean zIsEmpty = arrayList.isEmpty();
                Object[] objArrT = this.i;
                if (zIsEmpty) {
                    objArrT.getClass();
                } else {
                    objArrT = t(objArrT, i2, this.e, arrayList.iterator());
                }
                int size = i2 + (arrayList.size() << 5);
                if ((size & 31) != 0) {
                    dz1.a("invalid size");
                }
                if (size == 0) {
                    this.e = 0;
                } else {
                    int i3 = size - 1;
                    while (true) {
                        i = this.e;
                        if ((i3 >> i) != 0) {
                            break;
                        }
                        this.e = i - 5;
                        Object[] objArr2 = objArrT[0];
                        objArr2.getClass();
                        objArrT = objArr2;
                    }
                    objArrQ = q(objArrT, i3, i);
                }
                this.i = objArrQ;
                this.j = objArr;
                this.k = size + iX2;
            }
            z = true;
        } else if (z(hq0Var2, iG, c4Var) != iG) {
            z = true;
        }
        if (z) {
            ((AbstractList) this).modCount++;
        }
        return z;
    }

    public final Object[] B(Object[] objArr, int i, int i2, c4 c4Var) {
        int iB = rd3.b(i2, i);
        if (i == 0) {
            Object obj = objArr[iB];
            Object[] objArrM = m(objArr);
            qg.g(objArr, iB, objArrM, iB + 1, 32);
            objArrM[31] = c4Var.a;
            c4Var.a = obj;
            return objArrM;
        }
        int iB2 = objArr[31] == null ? rd3.b(D() - 1, i) : 31;
        Object[] objArrM2 = m(objArr);
        int i3 = i - 5;
        int i4 = iB + 1;
        if (i4 <= iB2) {
            while (true) {
                Object obj2 = objArrM2[iB2];
                obj2.getClass();
                objArrM2[iB2] = B((Object[]) obj2, i3, 0, c4Var);
                if (iB2 == i4) {
                    break;
                }
                iB2--;
            }
        }
        Object obj3 = objArrM2[iB];
        obj3.getClass();
        objArrM2[iB] = B((Object[]) obj3, i3, i2, c4Var);
        return objArrM2;
    }

    public final Object C(Object[] objArr, int i, int i2, int i3) {
        int i4 = this.k - i;
        Object[] objArr2 = this.j;
        if (i4 == 1) {
            Object obj = objArr2[0];
            s(objArr, i, i2);
            return obj;
        }
        Object obj2 = objArr2[i3];
        Object[] objArrM = m(objArr2);
        qg.g(objArr2, i3, objArrM, i3 + 1, i4);
        objArrM[i4 - 1] = null;
        this.i = objArr;
        this.j = objArrM;
        this.k = (i + i4) - 1;
        this.e = i2;
        return obj2;
    }

    public final int D() {
        int i = this.k;
        if (i <= 32) {
            return 0;
        }
        return (i - 1) & (-32);
    }

    public final Object[] E(Object[] objArr, int i, int i2, Object obj, c4 c4Var) {
        int iB = rd3.b(i2, i);
        Object[] objArrM = m(objArr);
        if (i != 0) {
            Object obj2 = objArrM[iB];
            obj2.getClass();
            objArrM[iB] = E((Object[]) obj2, i - 5, i2, obj, c4Var);
            return objArrM;
        }
        if (objArrM != objArr) {
            ((AbstractList) this).modCount++;
        }
        c4Var.a = objArrM[iB];
        objArrM[iB] = obj;
        return objArrM;
    }

    public final void F(Collection collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] objArrO;
        if (i3 < 1) {
            dz1.a("requires at least one nullBuffer");
        }
        Object[] objArrM = m(objArr);
        objArr2[0] = objArrM;
        int i4 = i & 31;
        int size = ((collection.size() + i) - 1) & 31;
        int i5 = (i2 - i4) + size;
        if (i5 < 32) {
            qg.g(objArrM, size + 1, objArr3, i4, i2);
        } else {
            int i6 = i5 - 31;
            if (i3 == 1) {
                objArrO = objArrM;
            } else {
                objArrO = o();
                i3--;
                objArr2[i3] = objArrO;
            }
            int i7 = i2 - i6;
            qg.g(objArrM, 0, objArr3, i7, i2);
            qg.g(objArrM, size + 1, objArrO, i4, i7);
            objArr3 = objArrO;
        }
        Iterator it = collection.iterator();
        f(objArrM, i4, it);
        for (int i8 = 1; i8 < i3; i8++) {
            Object[] objArrO2 = o();
            f(objArrO2, 0, it);
            objArr2[i8] = objArrO2;
        }
        f(objArr3, 0, it);
    }

    public final int G() {
        int i = this.k;
        return i <= 32 ? i : i - ((i - 1) & (-32));
    }

    @Override // defpackage.k1
    public final int a() {
        return this.k;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        nq4.b(i, a());
        if (i == a()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iD = D();
        if (i >= iD) {
            j(i - iD, obj, this.i);
            return;
        }
        c4 c4Var = new c4(null);
        Object[] objArr = this.i;
        objArr.getClass();
        j(0, c4Var.a, i(objArr, this.e, i, obj, c4Var));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        Collection collection2;
        Object[] objArrO;
        nq4.b(i, this.k);
        if (i == this.k) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i2 = (i >> 5) << 5;
        int size = ((collection.size() + (this.k - i2)) - 1) / 32;
        if (size == 0) {
            int i3 = i & 31;
            int size2 = ((collection.size() + i) - 1) & 31;
            Object[] objArr = this.j;
            Object[] objArrM = m(objArr);
            qg.g(objArr, size2 + 1, objArrM, i3, G());
            f(objArrM, i3, collection.iterator());
            this.j = objArrM;
            this.k = collection.size() + this.k;
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iG = G();
        int size3 = collection.size() + this.k;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (i >= D()) {
            objArrO = o();
            collection2 = collection;
            F(collection2, i, this.j, iG, objArr2, size, objArrO);
            objArr2 = objArr2;
        } else {
            collection2 = collection;
            Object[] objArr3 = this.j;
            if (size3 > iG) {
                int i4 = size3 - iG;
                Object[] objArrN = n(i4, objArr3);
                h(collection2, i, i4, objArr2, size, objArrN);
                objArr2 = objArr2;
                objArrO = objArrN;
            } else {
                objArrO = o();
                int i5 = iG - size3;
                qg.g(objArr3, 0, objArrO, i5, iG);
                int i6 = 32 - i5;
                Object[] objArrN2 = n(i6, this.j);
                int i7 = size - 1;
                objArr2[i7] = objArrN2;
                h(collection2, i, i6, objArr2, i7, objArrN2);
                collection2 = collection2;
            }
        }
        this.i = u(this.i, i2, objArr2);
        this.j = objArrO;
        this.k = collection2.size() + this.k;
        return true;
    }

    @Override // defpackage.k1
    public final Object b(int i) {
        nq4.a(i, a());
        ((AbstractList) this).modCount++;
        int iD = D();
        if (i >= iD) {
            return C(this.i, iD, this.e, i - iD);
        }
        c4 c4Var = new c4(this.j[0]);
        Object[] objArr = this.i;
        objArr.getClass();
        C(B(objArr, this.e, i, c4Var), iD, this.e, 0);
        return c4Var.a;
    }

    public final n1 d() {
        n1 qw1Var;
        Object[] objArr = this.i;
        if (objArr == this.b && this.j == this.c) {
            qw1Var = this.a;
        } else {
            this.f = new y74(15);
            this.b = objArr;
            Object[] objArr2 = this.j;
            this.c = objArr2;
            if (objArr == null) {
                qw1Var = objArr2.length == 0 ? sl2.b : new sl2(Arrays.copyOf(objArr2, this.k));
            } else {
                qw1Var = new qw1(objArr, objArr2, this.k, this.e);
            }
        }
        this.a = qw1Var;
        return qw1Var;
    }

    public final int g() {
        return ((AbstractList) this).modCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object[] objArr;
        nq4.a(i, a());
        if (D() <= i) {
            objArr = this.j;
        } else {
            Object[] objArr2 = this.i;
            objArr2.getClass();
            for (int i2 = this.e; i2 > 0; i2 -= 5) {
                Object[] objArr3 = objArr2[rd3.b(i, i2)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    public final void h(Collection collection, int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.i == null) {
            og.n("root is null");
            return;
        }
        int i4 = i >> 5;
        i1 i1VarL = l(D() >> 5);
        int i5 = i3;
        Object[] objArrN = objArr2;
        while (i1VarL.a - 1 != i4) {
            Object[] objArr3 = (Object[]) i1VarL.previous();
            qg.g(objArr3, 0, objArrN, 32 - i2, 32);
            objArrN = n(i2, objArr3);
            i5--;
            objArr[i5] = objArrN;
        }
        Object[] objArr4 = (Object[]) i1VarL.previous();
        int iD = i3 - (((D() >> 5) - 1) - i4);
        if (iD < i3) {
            objArr2 = objArr[iD];
            objArr2.getClass();
        }
        F(collection, i, objArr4, 32, objArr, iD, objArr2);
    }

    public final Object[] i(Object[] objArr, int i, int i2, Object obj, c4 c4Var) {
        Object obj2;
        int iB = rd3.b(i2, i);
        if (i == 0) {
            c4Var.a = objArr[31];
            Object[] objArrM = m(objArr);
            qg.g(objArr, iB + 1, objArrM, iB, 31);
            objArrM[iB] = obj;
            return objArrM;
        }
        Object[] objArrM2 = m(objArr);
        int i3 = i - 5;
        Object obj3 = objArrM2[iB];
        obj3.getClass();
        objArrM2[iB] = i((Object[]) obj3, i3, i2, obj, c4Var);
        while (true) {
            iB++;
            if (iB >= 32 || (obj2 = objArrM2[iB]) == null) {
                break;
            }
            objArrM2[iB] = i((Object[]) obj2, i3, 0, c4Var.a, c4Var);
        }
        return objArrM2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, Object obj, Object[] objArr) {
        int iG = G();
        Object[] objArrM = m(this.j);
        Object[] objArr2 = this.j;
        if (iG >= 32) {
            Object obj2 = objArr2[31];
            qg.g(objArr2, i + 1, objArrM, i, 31);
            objArrM[i] = obj;
            v(objArr, objArrM, p(obj2));
            return;
        }
        qg.g(objArr2, i + 1, objArrM, i, iG);
        objArrM[i] = obj;
        this.i = objArr;
        this.j = objArrM;
        this.k++;
    }

    public final boolean k(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f;
    }

    public final i1 l(int i) {
        Object[] objArr = this.i;
        if (objArr == null) {
            og.n("Invalid root");
            return null;
        }
        int iD = D() >> 5;
        nq4.b(i, iD);
        int i2 = this.e;
        return i2 == 0 ? new mn(i, objArr) : new w23(objArr, i, iD, i2 / 5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        nq4.b(i, this.k);
        return new tw1(this, i);
    }

    public final Object[] m(Object[] objArr) {
        if (objArr == null) {
            return o();
        }
        if (k(objArr)) {
            return objArr;
        }
        Object[] objArrO = o();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        qg.i(objArr, 0, objArrO, length, 6);
        return objArrO;
    }

    public final Object[] n(int i, Object[] objArr) {
        if (k(objArr)) {
            qg.g(objArr, i, objArr, 0, 32 - i);
            return objArr;
        }
        Object[] objArrO = o();
        qg.g(objArr, i, objArrO, 0, 32 - i);
        return objArrO;
    }

    public final Object[] o() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f;
        return objArr;
    }

    public final Object[] p(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f;
        return objArr;
    }

    public final Object[] q(Object[] objArr, int i, int i2) {
        if (i2 < 0) {
            dz1.a("shift should be positive");
        }
        if (i2 == 0) {
            return objArr;
        }
        int iB = rd3.b(i, i2);
        Object obj = objArr[iB];
        obj.getClass();
        Object objQ = q((Object[]) obj, i, i2 - 5);
        if (iB < 31) {
            int i3 = iB + 1;
            if (objArr[i3] != null) {
                if (k(objArr)) {
                    Arrays.fill(objArr, i3, 32, (Object) null);
                }
                Object[] objArrO = o();
                qg.g(objArr, 0, objArrO, 0, i3);
                objArr = objArrO;
            }
        }
        if (objQ == objArr[iB]) {
            return objArr;
        }
        Object[] objArrM = m(objArr);
        objArrM[iB] = objQ;
        return objArrM;
    }

    public final Object[] r(Object[] objArr, int i, int i2, c4 c4Var) {
        Object[] objArrR;
        int iB = rd3.b(i2 - 1, i);
        if (i == 5) {
            c4Var.a = objArr[iB];
            objArrR = null;
        } else {
            Object obj = objArr[iB];
            obj.getClass();
            objArrR = r((Object[]) obj, i - 5, i2, c4Var);
        }
        if (objArrR == null && iB == 0) {
            return null;
        }
        Object[] objArrM = m(objArr);
        objArrM[iB] = objArrR;
        return objArrM;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        return A(new m1(1, collection));
    }

    public final void s(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            this.i = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.j = objArr;
            this.k = i;
            this.e = i2;
            return;
        }
        c4 c4Var = new c4(null);
        objArr.getClass();
        Object[] objArrR = r(objArr, i2, i, c4Var);
        objArrR.getClass();
        Object obj = c4Var.a;
        obj.getClass();
        this.j = (Object[]) obj;
        this.k = i;
        if (objArrR[1] == null) {
            this.i = (Object[]) objArrR[0];
            this.e = i2 - 5;
        } else {
            this.i = objArrR;
            this.e = i2;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        nq4.a(i, a());
        if (D() > i) {
            c4 c4Var = new c4(null);
            Object[] objArr = this.i;
            objArr.getClass();
            this.i = E(objArr, this.e, i, obj, c4Var);
            return c4Var.a;
        }
        Object[] objArrM = m(this.j);
        if (objArrM != this.j) {
            ((AbstractList) this).modCount++;
        }
        int i2 = i & 31;
        Object obj2 = objArrM[i2];
        objArrM[i2] = obj;
        this.j = objArrM;
        return obj2;
    }

    public final Object[] t(Object[] objArr, int i, int i2, Iterator it) {
        if (!it.hasNext()) {
            dz1.a("invalid buffersIterator");
        }
        if (!(i2 >= 0)) {
            dz1.a("negative shift");
        }
        if (i2 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrM = m(objArr);
        int iB = rd3.b(i, i2);
        int i3 = i2 - 5;
        objArrM[iB] = t((Object[]) objArrM[iB], i, i3, it);
        while (true) {
            iB++;
            if (iB >= 32 || !it.hasNext()) {
                break;
            }
            objArrM[iB] = t((Object[]) objArrM[iB], 0, i3, it);
        }
        return objArrM;
    }

    public final Object[] u(Object[] objArr, int i, Object[][] objArr2) {
        e1 e1Var = new e1(objArr2);
        int i2 = i >> 5;
        int i3 = this.e;
        Object[] objArrT = i2 < (1 << i3) ? t(objArr, i, i3, e1Var) : m(objArr);
        while (e1Var.hasNext()) {
            this.e += 5;
            objArrT = p(objArrT);
            int i4 = this.e;
            t(objArrT, 1 << i4, i4, e1Var);
        }
        return objArrT;
    }

    public final void v(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.k;
        int i2 = i >> 5;
        int i3 = this.e;
        if (i2 > (1 << i3)) {
            this.i = w(this.e + 5, p(objArr), objArr2);
            this.j = objArr3;
            this.e += 5;
            this.k++;
            return;
        }
        if (objArr == null) {
            this.i = objArr2;
            this.j = objArr3;
            this.k = i + 1;
        } else {
            this.i = w(i3, objArr, objArr2);
            this.j = objArr3;
            this.k++;
        }
    }

    public final Object[] w(int i, Object[] objArr, Object[] objArr2) {
        int iB = rd3.b(a() - 1, i);
        Object[] objArrM = m(objArr);
        if (i == 5) {
            objArrM[iB] = objArr2;
            return objArrM;
        }
        objArrM[iB] = w(i - 5, (Object[]) objArrM[iB], objArr2);
        return objArrM;
    }

    public final int x(hq0 hq0Var, Object[] objArr, int i, int i2, c4 c4Var, ArrayList arrayList, ArrayList arrayList2) {
        if (k(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = c4Var.a;
        obj.getClass();
        Object[] objArr2 = (Object[]) obj;
        Object[] objArrO = objArr2;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj2 = objArr[i3];
            if (!((Boolean) hq0Var.j(obj2)).booleanValue()) {
                if (i2 == 32) {
                    objArrO = !arrayList.isEmpty() ? (Object[]) arrayList.remove(arrayList.size() - 1) : o();
                    i2 = 0;
                }
                objArrO[i2] = obj2;
                i2++;
            }
        }
        c4Var.a = objArrO;
        if (objArr2 != objArrO) {
            arrayList2.add(objArr2);
        }
        return i2;
    }

    public final int y(hq0 hq0Var, Object[] objArr, int i, c4 c4Var) {
        Object[] objArrM = objArr;
        int i2 = i;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (((Boolean) hq0Var.j(obj)).booleanValue()) {
                if (!z) {
                    objArrM = m(objArr);
                    z = true;
                    i2 = i3;
                }
            } else if (z) {
                objArrM[i2] = obj;
                i2++;
            }
        }
        c4Var.a = objArrM;
        return i2;
    }

    public final int z(hq0 hq0Var, int i, c4 c4Var) {
        int iY = y(hq0Var, this.j, i, c4Var);
        Object obj = c4Var.a;
        if (iY == i) {
            return i;
        }
        obj.getClass();
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, iY, i, (Object) null);
        this.j = objArr;
        this.k -= i - iY;
        return iY;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iG = G();
        if (iG < 32) {
            Object[] objArrM = m(this.j);
            objArrM[iG] = obj;
            this.j = objArrM;
            this.k = a() + 1;
        } else {
            v(this.i, this.j, p(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iG = G();
        Iterator it = collection.iterator();
        if (32 - iG >= collection.size()) {
            Object[] objArrM = m(this.j);
            f(objArrM, iG, it);
            this.j = objArrM;
            this.k = collection.size() + this.k;
            return true;
        }
        int size = ((collection.size() + iG) - 1) / 32;
        Object[][] objArr = new Object[size][];
        Object[] objArrM2 = m(this.j);
        f(objArrM2, iG, it);
        objArr[0] = objArrM2;
        for (int i = 1; i < size; i++) {
            Object[] objArrO = o();
            f(objArrO, 0, it);
            objArr[i] = objArrO;
        }
        this.i = u(this.i, D(), objArr);
        Object[] objArrO2 = o();
        f(objArrO2, 0, it);
        this.j = objArrO2;
        this.k = collection.size() + this.k;
        return true;
    }
}
