package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yl1 {
    public Object[] a;
    public int b;
    public wl1 c;

    public yl1(int i) {
        this.a = i == 0 ? yo1.a : new Object[i];
    }

    public final void a(Object obj) {
        int i = this.b + 1;
        Object[] objArr = this.a;
        if (objArr.length < i) {
            m(i, objArr);
        }
        Object[] objArr2 = this.a;
        int i2 = this.b;
        objArr2[i2] = obj;
        this.b = i2 + 1;
    }

    public final void b(yl1 yl1Var) {
        yl1Var.getClass();
        if (yl1Var.h()) {
            return;
        }
        int i = this.b + yl1Var.b;
        Object[] objArr = this.a;
        if (objArr.length < i) {
            m(i, objArr);
        }
        qg.g(yl1Var.a, this.b, this.a, 0, yl1Var.b);
        this.b += yl1Var.b;
    }

    public final void c(List list) {
        if (list.isEmpty()) {
            return;
        }
        int i = this.b;
        int size = list.size() + i;
        Object[] objArr = this.a;
        if (objArr.length < size) {
            m(size, objArr);
        }
        Object[] objArr2 = this.a;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            objArr2[i2 + i] = list.get(i2);
        }
        this.b = list.size() + this.b;
    }

    public final void d() {
        qg.l(0, this.b, null, this.a);
        this.b = 0;
    }

    public final Object e() {
        if (!h()) {
            return this.a[0];
        }
        kf2.g("ObjectList is empty.");
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof yl1) {
            yl1 yl1Var = (yl1) obj;
            int i = yl1Var.b;
            int i2 = this.b;
            if (i == i2) {
                Object[] objArr = this.a;
                Object[] objArr2 = yl1Var.a;
                h21 h21VarF = ky3.f(0, i2);
                int i3 = h21VarF.a;
                int i4 = h21VarF.b;
                if (i3 > i4) {
                    return true;
                }
                while (g31.a(objArr[i3], objArr2[i3])) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final Object f(int i) {
        if (i >= 0 && i < this.b) {
            return this.a[i];
        }
        n(i);
        throw null;
    }

    public final int g(Object obj) {
        Object[] objArr = this.a;
        int i = 0;
        if (obj == null) {
            int i2 = this.b;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.b;
        while (i < i3) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final boolean h() {
        return this.b == 0;
    }

    public final int hashCode() {
        Object[] objArr = this.a;
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final boolean i() {
        return this.b != 0;
    }

    public final boolean j(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return false;
        }
        k(iG);
        return true;
    }

    public final Object k(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.b)) {
            n(i);
            throw null;
        }
        Object[] objArr = this.a;
        Object obj = objArr[i];
        if (i != i2 - 1) {
            qg.g(objArr, i, objArr, i + 1, i2);
        }
        int i3 = this.b - 1;
        this.b = i3;
        objArr[i3] = null;
        return obj;
    }

    public final void l(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this.b) || i2 < 0 || i2 > i3) {
            dk0.f(this.b, cq.p("Start (", i, ") and end (", i2, ") must be in 0.."));
            return;
        }
        if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + ')');
        }
        if (i2 != i) {
            if (i2 < i3) {
                Object[] objArr = this.a;
                qg.g(objArr, i, objArr, i2, i3);
            }
            int i4 = this.b;
            int i5 = i4 - (i2 - i);
            qg.l(i5, i4, null, this.a);
            this.b = i5;
        }
    }

    public final void m(int i, Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, (length * 3) / 2)];
        qg.g(objArr, 0, objArr2, 0, length);
        this.a = objArr2;
    }

    public final void n(int i) {
        StringBuilder sbP = ky0.p("Index ", i, " must be in 0..");
        sbP.append(this.b - 1);
        throw new IndexOutOfBoundsException(sbP.toString());
    }

    public final void o(int i) {
        StringBuilder sbP = ky0.p("Index ", i, " must be in 0..");
        sbP.append(this.b);
        throw new IndexOutOfBoundsException(sbP.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        Object[] objArr = this.a;
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) (obj == this ? "(this)" : String.valueOf(obj)));
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    public /* synthetic */ yl1() {
        this(16);
    }
}
