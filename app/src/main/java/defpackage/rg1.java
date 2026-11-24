package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rg1 implements Map, Serializable, z41 {
    public static final rg1 w;
    public Object[] a;
    public Object[] b;
    public int[] c;
    public int[] e;
    public int f;
    public int i;
    public int j;
    public int k;
    public int n;
    public tg1 s;
    public ug1 t;
    public tg1 u;
    public boolean v;

    static {
        rg1 rg1Var = new rg1(0);
        rg1Var.v = true;
        w = rg1Var;
    }

    public rg1(int i) {
        if (i < 0) {
            og.i("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.a = objArr;
        this.b = null;
        this.c = iArr;
        this.e = new int[iHighestOneBit];
        this.f = 2;
        this.i = 0;
        this.j = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int i = i(obj);
            int i2 = this.f * 2;
            int length = this.e.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.e;
                int i4 = iArr[i];
                if (i4 == 0) {
                    int i5 = this.i;
                    Object[] objArr = this.a;
                    if (i5 >= objArr.length) {
                        f(1);
                        break;
                    }
                    int i6 = i5 + 1;
                    this.i = i6;
                    objArr[i5] = obj;
                    this.c[i5] = i;
                    iArr[i] = i6;
                    this.n++;
                    this.k++;
                    if (i3 > this.f) {
                        this.f = i3;
                    }
                    return i5;
                }
                if (g31.a(this.a[i4 - 1], obj)) {
                    return -i4;
                }
                i3++;
                if (i3 > i2) {
                    j(this.e.length * 2);
                    break;
                }
                i = i == 0 ? this.e.length - 1 : i - 1;
            }
        }
    }

    public final rg1 b() {
        c();
        this.v = true;
        if (this.n > 0) {
            return this;
        }
        rg1 rg1Var = w;
        rg1Var.getClass();
        return rg1Var;
    }

    public final void c() {
        if (this.v) {
            dk0.p();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i = this.i - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.c;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.e[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        mq4.b(this.a, 0, this.i);
        Object[] objArr = this.b;
        if (objArr != null) {
            mq4.b(objArr, 0, this.i);
        }
        this.n = 0;
        this.i = 0;
        this.k++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final void d(boolean z) {
        int i;
        Object[] objArr = this.b;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.i;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.c;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.a;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.e[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        mq4.b(this.a, i3, i);
        if (objArr != null) {
            mq4.b(objArr, i3, this.i);
        }
        this.i = i3;
    }

    public final boolean e(Collection collection) {
        boolean zA;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iG = g(entry.getKey());
                    if (iG < 0) {
                        zA = false;
                    } else {
                        Object[] objArr = this.b;
                        objArr.getClass();
                        zA = g31.a(objArr[iG], entry.getValue());
                    }
                    if (!zA) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        tg1 tg1Var = this.u;
        if (tg1Var != null) {
            return tg1Var;
        }
        tg1 tg1Var2 = new tg1(this, 0);
        this.u = tg1Var2;
        return tg1Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.n == map.size() && e(map.entrySet());
    }

    public final void f(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        int i2 = this.i;
        int i3 = length - i2;
        int i4 = i2 - this.n;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.a = Arrays.copyOf(objArr, i6);
            Object[] objArr2 = this.b;
            this.b = objArr2 != null ? Arrays.copyOf(objArr2, i6) : null;
            this.c = Arrays.copyOf(this.c, i6);
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.e.length) {
                j(iHighestOneBit);
            }
        }
    }

    public final int g(Object obj) {
        int i = i(obj);
        int i2 = this.f;
        while (true) {
            int i3 = this.e[i];
            if (i3 == 0) {
                return -1;
            }
            int i4 = i3 - 1;
            if (g31.a(this.a[i4], obj)) {
                return i4;
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            i = i == 0 ? this.e.length - 1 : i - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.b;
        objArr.getClass();
        return objArr[iG];
    }

    public final int h(Object obj) {
        int i = this.i;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                objArr.getClass();
                if (g31.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        og1 og1Var = new og1(this, 0);
        int i = 0;
        while (og1Var.hasNext()) {
            int i2 = og1Var.a;
            rg1 rg1Var = (rg1) og1Var.e;
            if (i2 >= rg1Var.i) {
                dk0.d();
                return 0;
            }
            og1Var.a = i2 + 1;
            og1Var.b = i2;
            Object obj = rg1Var.a[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = rg1Var.b;
            objArr.getClass();
            Object obj2 = objArr[og1Var.b];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            og1Var.c();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.j;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.n == 0;
    }

    public final void j(int i) {
        int[] iArr;
        this.k++;
        int i2 = 0;
        if (this.i > this.n) {
            d(false);
        }
        this.e = new int[i];
        this.j = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.i) {
            int i3 = i2 + 1;
            int i4 = i(this.a[i2]);
            int i5 = this.f;
            while (true) {
                iArr = this.e;
                if (iArr[i4] == 0) {
                    break;
                }
                i5--;
                if (i5 < 0) {
                    og.n("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                    return;
                }
                i4 = i4 == 0 ? iArr.length - 1 : i4 - 1;
            }
            iArr[i4] = i3;
            this.c[i2] = i4;
            i2 = i3;
        }
    }

    public final void k(int i) {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        Object[] objArr = this.a;
        objArr.getClass();
        objArr[i] = null;
        Object[] objArr2 = this.b;
        if (objArr2 != null) {
            objArr2[i] = null;
        }
        int length = this.c[i];
        loop0: while (true) {
            int i5 = length;
            int i6 = 0;
            do {
                length = length == 0 ? this.e.length - 1 : length - 1;
                int[] iArr2 = this.e;
                i2 = iArr2[length];
                i6++;
                if (i6 > this.f) {
                    iArr2[i5] = 0;
                    break loop0;
                } else if (i2 == 0) {
                    iArr2[i5] = 0;
                    break loop0;
                } else {
                    i3 = i2 - 1;
                    i4 = i(this.a[i3]) - length;
                    iArr = this.e;
                }
            } while ((i4 & (iArr.length - 1)) < i6);
            iArr[i5] = i2;
            this.c[i3] = i5;
        }
        this.c[i] = -1;
        this.n--;
        this.k++;
    }

    @Override // java.util.Map
    public final Set keySet() {
        tg1 tg1Var = this.s;
        if (tg1Var != null) {
            return tg1Var;
        }
        tg1 tg1Var2 = new tg1(this, 1);
        this.s = tg1Var2;
        return tg1Var2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.b;
        if (objArr == null) {
            int length = this.a.length;
            if (length < 0) {
                og.i("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.b;
            if (objArr == null) {
                int length = this.a.length;
                if (length < 0) {
                    og.i("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.b = objArr;
                }
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!g31.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.b;
        objArr.getClass();
        Object obj2 = objArr[iG];
        k(iG);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.n;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.n * 3) + 2);
        sb.append("{");
        int i = 0;
        og1 og1Var = new og1(this, 0);
        while (og1Var.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = og1Var.a;
            rg1 rg1Var = (rg1) og1Var.e;
            if (i2 >= rg1Var.i) {
                dk0.d();
                return null;
            }
            og1Var.a = i2 + 1;
            og1Var.b = i2;
            Object obj = rg1Var.a[i2];
            if (obj == rg1Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = rg1Var.b;
            objArr.getClass();
            Object obj2 = objArr[og1Var.b];
            if (obj2 == rg1Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            og1Var.c();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        ug1 ug1Var = this.t;
        if (ug1Var != null) {
            return ug1Var;
        }
        ug1 ug1Var2 = new ug1(0, this);
        this.t = ug1Var2;
        return ug1Var2;
    }

    public rg1() {
        this(8);
    }
}
