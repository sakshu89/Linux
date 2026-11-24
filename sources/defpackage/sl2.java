package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sl2 extends n1 {
    public static final sl2 b = new sl2(new Object[0]);
    public final Object[] a;

    public sl2(Object[] objArr) {
        this.a = objArr;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.a.length;
    }

    @Override // defpackage.n1
    public final n1 b(int i, Object obj) {
        Object[] objArr = this.a;
        nq4.b(i, objArr.length);
        if (i == objArr.length) {
            return d(obj);
        }
        if (objArr.length < 32) {
            Object[] objArr2 = new Object[objArr.length + 1];
            qg.i(objArr, 0, objArr2, i, 6);
            qg.g(objArr, i + 1, objArr2, i, objArr.length);
            objArr2[i] = obj;
            return new sl2(objArr2);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        qg.g(objArr, i + 1, objArrCopyOf, i, objArr.length - 1);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = objArr[31];
        return new qw1(objArrCopyOf, objArr3, objArr.length + 1, 0);
    }

    @Override // defpackage.n1
    public final n1 d(Object obj) {
        Object[] objArr = this.a;
        if (objArr.length < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
            objArrCopyOf[objArr.length] = obj;
            return new sl2(objArrCopyOf);
        }
        Object[] objArr2 = new Object[32];
        objArr2[0] = obj;
        return new qw1(objArr, objArr2, objArr.length + 1, 0);
    }

    @Override // defpackage.n1
    public final n1 f(Collection collection) {
        Object[] objArr = this.a;
        if (collection.size() + objArr.length > 32) {
            rw1 rw1VarG = g();
            rw1VarG.addAll(collection);
            return rw1VarG.d();
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, collection.size() + objArr.length);
        int length = objArr.length;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[length] = it.next();
            length++;
        }
        return new sl2(objArrCopyOf);
    }

    @Override // defpackage.n1
    public final rw1 g() {
        return new rw1(this, null, this.a, 0);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr = this.a;
        nq4.a(i, objArr.length);
        return objArr[i];
    }

    @Override // defpackage.n1
    public final n1 h(m1 m1Var) {
        Object[] objArr = this.a;
        int length = objArr.length;
        int length2 = objArr.length;
        Object[] objArrCopyOf = objArr;
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            Object obj = objArr[i];
            if (((Boolean) m1Var.j(obj)).booleanValue()) {
                if (!z) {
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    z = true;
                    length = i;
                }
            } else if (z) {
                objArrCopyOf[length] = obj;
                length++;
            }
        }
        if (length == objArr.length) {
            return this;
        }
        return length == 0 ? b : new sl2(qg.k(objArrCopyOf, 0, length));
    }

    @Override // defpackage.n1
    public final n1 i(int i) {
        Object[] objArr = this.a;
        nq4.a(i, objArr.length);
        if (objArr.length == 1) {
            return b;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length - 1);
        qg.g(objArr, i, objArrCopyOf, i + 1, objArr.length);
        return new sl2(objArrCopyOf);
    }

    @Override // defpackage.h1, java.util.List
    public final int indexOf(Object obj) {
        return qg.q(this.a, obj);
    }

    @Override // defpackage.n1
    public final n1 j(int i, Object obj) {
        Object[] objArr = this.a;
        nq4.a(i, objArr.length);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        objArrCopyOf[i] = obj;
        return new sl2(objArrCopyOf);
    }

    @Override // defpackage.h1, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr = this.a;
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i >= 0) {
                        length = i;
                    }
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (obj.equals(objArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    @Override // defpackage.h1, java.util.List
    public final ListIterator listIterator(int i) {
        Object[] objArr = this.a;
        nq4.b(i, objArr.length);
        return new mn(objArr, i, objArr.length);
    }
}
