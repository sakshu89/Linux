package defpackage;

import java.util.Arrays;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qw1 extends n1 {
    public final Object[] a;
    public final Object[] b;
    public final int c;
    public final int e;

    public qw1(Object[] objArr, Object[] objArr2, int i, int i2) {
        this.a = objArr;
        this.b = objArr2;
        this.c = i;
        this.e = i2;
        if (!(a() > 32)) {
            dz1.a("Trie-based persistent vector should have at least 33 elements, got " + a());
        }
        int length = objArr2.length;
    }

    public static Object[] k(Object[] objArr, int i, int i2, Object obj, c4 c4Var) {
        int iB = rd3.b(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iB == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            qg.g(objArr, iB + 1, objArrCopyOf, iB, 31);
            c4Var.a = objArr[31];
            objArrCopyOf[iB] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        Object obj2 = objArr[iB];
        obj2.getClass();
        objArrCopyOf2[iB] = k((Object[]) obj2, i3, i2, obj, c4Var);
        while (true) {
            iB++;
            if (iB >= 32 || objArrCopyOf2[iB] == null) {
                break;
            }
            Object obj3 = objArr[iB];
            obj3.getClass();
            objArrCopyOf2[iB] = k((Object[]) obj3, i3, 0, c4Var.a, c4Var);
        }
        return objArrCopyOf2;
    }

    public static Object[] m(Object[] objArr, int i, int i2, c4 c4Var) {
        Object[] objArrM;
        int iB = rd3.b(i2, i);
        if (i == 5) {
            c4Var.a = objArr[iB];
            objArrM = null;
        } else {
            Object obj = objArr[iB];
            obj.getClass();
            objArrM = m((Object[]) obj, i - 5, i2, c4Var);
        }
        if (objArrM == null && iB == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        objArrCopyOf[iB] = objArrM;
        return objArrCopyOf;
    }

    public static Object[] s(int i, int i2, Object obj, Object[] objArr) {
        int iB = rd3.b(i2, i);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        if (i == 0) {
            objArrCopyOf[iB] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iB];
        obj2.getClass();
        objArrCopyOf[iB] = s(i - 5, i2, obj, (Object[]) obj2);
        return objArrCopyOf;
    }

    @Override // defpackage.y0
    public final int a() {
        return this.c;
    }

    @Override // defpackage.n1
    public final n1 b(int i, Object obj) {
        int i2 = this.c;
        nq4.b(i, i2);
        if (i == i2) {
            return d(obj);
        }
        int iR = r();
        Object[] objArr = this.a;
        if (i >= iR) {
            return l(i - iR, obj, objArr);
        }
        c4 c4Var = new c4(null);
        return l(0, c4Var.a, k(objArr, this.e, i, obj, c4Var));
    }

    @Override // defpackage.n1
    public final n1 d(Object obj) {
        int iR = r();
        int i = this.c;
        int i2 = i - iR;
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        if (i2 < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            objArrCopyOf[i2] = obj;
            return new qw1(objArr, objArrCopyOf, i + 1, this.e);
        }
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj;
        return n(objArr, objArr2, objArr3);
    }

    @Override // defpackage.n1
    public final rw1 g() {
        return new rw1(this, this.a, this.b, this.e);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr;
        nq4.a(i, a());
        if (r() <= i) {
            objArr = this.b;
        } else {
            Object[] objArr2 = this.a;
            for (int i2 = this.e; i2 > 0; i2 -= 5) {
                Object[] objArr3 = objArr2[rd3.b(i, i2)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    @Override // defpackage.n1
    public final n1 h(m1 m1Var) {
        rw1 rw1Var = new rw1(this, this.a, this.b, this.e);
        rw1Var.A(m1Var);
        return rw1Var.d();
    }

    @Override // defpackage.n1
    public final n1 i(int i) {
        nq4.a(i, a());
        int iR = r();
        int i2 = this.e;
        Object[] objArr = this.a;
        return i >= iR ? q(objArr, iR, i2, i - iR) : q(p(objArr, i2, i, new c4(this.b[0])), iR, i2, 0);
    }

    @Override // defpackage.n1
    public final n1 j(int i, Object obj) {
        int i2 = this.c;
        nq4.a(i, i2);
        int iR = r();
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        int i3 = this.e;
        if (iR > i) {
            return new qw1(s(i3, i, obj, objArr), objArr2, i2, i3);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        objArrCopyOf[i & 31] = obj;
        return new qw1(objArr, objArrCopyOf, i2, i3);
    }

    public final qw1 l(int i, Object obj, Object[] objArr) {
        int iR = r();
        int i2 = this.c;
        int i3 = i2 - iR;
        Object[] objArr2 = this.b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        if (i3 < 32) {
            qg.g(objArr2, i + 1, objArrCopyOf, i, i3);
            objArrCopyOf[i] = obj;
            return new qw1(objArr, objArrCopyOf, i2 + 1, this.e);
        }
        Object obj2 = objArr2[31];
        qg.g(objArr2, i + 1, objArrCopyOf, i, i3 - 1);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return n(objArr, objArrCopyOf, objArr3);
    }

    @Override // defpackage.h1, java.util.List
    public final ListIterator listIterator(int i) {
        nq4.b(i, this.c);
        return new sw1(this.a, i, this.b, this.c, (this.e / 5) + 1);
    }

    public final qw1 n(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.c;
        int i2 = i >> 5;
        int i3 = this.e;
        if (i2 <= (1 << i3)) {
            return new qw1(o(i3, objArr, objArr2), objArr3, i + 1, i3);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i4 = i3 + 5;
        return new qw1(o(i4, objArr4, objArr2), objArr3, i + 1, i4);
    }

    public final Object[] o(int i, Object[] objArr, Object[] objArr2) {
        int iB = rd3.b(a() - 1, i);
        Object[] objArrCopyOf = objArr != null ? Arrays.copyOf(objArr, 32) : new Object[32];
        if (i == 5) {
            objArrCopyOf[iB] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iB] = o(i - 5, (Object[]) objArrCopyOf[iB], objArr2);
        return objArrCopyOf;
    }

    public final Object[] p(Object[] objArr, int i, int i2, c4 c4Var) {
        int iB = rd3.b(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iB == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            qg.g(objArr, iB, objArrCopyOf, iB + 1, 32);
            objArrCopyOf[31] = c4Var.a;
            c4Var.a = objArr[iB];
            return objArrCopyOf;
        }
        int iB2 = objArr[31] == null ? rd3.b(r() - 1, i) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        int i4 = iB + 1;
        if (i4 <= iB2) {
            while (true) {
                Object obj = objArrCopyOf2[iB2];
                obj.getClass();
                objArrCopyOf2[iB2] = p((Object[]) obj, i3, 0, c4Var);
                if (iB2 == i4) {
                    break;
                }
                iB2--;
            }
        }
        Object obj2 = objArrCopyOf2[iB];
        obj2.getClass();
        objArrCopyOf2[iB] = p((Object[]) obj2, i3, i2, c4Var);
        return objArrCopyOf2;
    }

    public final n1 q(Object[] objArr, int i, int i2, int i3) {
        int i4 = this.c - i;
        if (i4 != 1) {
            Object[] objArr2 = this.b;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            int i5 = i4 - 1;
            if (i3 < i5) {
                qg.g(objArr2, i3, objArrCopyOf, i3 + 1, i4);
            }
            objArrCopyOf[i5] = null;
            return new qw1(objArr, objArrCopyOf, (i + i4) - 1, i2);
        }
        if (i2 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
            }
            return new sl2(objArr);
        }
        c4 c4Var = new c4(null);
        Object[] objArrM = m(objArr, i2, i - 1, c4Var);
        objArrM.getClass();
        Object obj = c4Var.a;
        obj.getClass();
        Object[] objArr3 = (Object[]) obj;
        if (objArrM[1] != null) {
            return new qw1(objArrM, objArr3, i, i2);
        }
        Object obj2 = objArrM[0];
        obj2.getClass();
        return new qw1((Object[]) obj2, objArr3, i, i2 - 5);
    }

    public final int r() {
        return (this.c - 1) & (-32);
    }
}
