package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zy3 extends AbstractMap implements Serializable {
    public static final Object s = new Object();
    public transient Object a;
    public transient int[] b;
    public transient Object[] c;
    public transient Object[] e;
    public transient int f = Math.min(Math.max(12, 1), 1073741823);
    public transient int i;
    public transient ly3 j;
    public transient ly3 k;
    public transient sy3 n;

    public final int[] a() {
        int[] iArr = this.b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] b() {
        Object[] objArr = this.c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] c() {
        Object[] objArr = this.e;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (f()) {
            return;
        }
        this.f += 32;
        Map mapD = d();
        if (mapD != null) {
            this.f = Math.min(Math.max(size(), 3), 1073741823);
            mapD.clear();
            this.a = null;
            this.i = 0;
            return;
        }
        Arrays.fill(b(), 0, this.i, (Object) null);
        Arrays.fill(c(), 0, this.i, (Object) null);
        Object obj = this.a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(a(), 0, this.i, 0);
        this.i = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapD = d();
        if (mapD != null) {
            return mapD.containsKey(obj);
        }
        return h(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapD = d();
        if (mapD != null) {
            return mapD.containsValue(obj);
        }
        for (int i = 0; i < this.i; i++) {
            if (di4.b(obj, c()[i])) {
                return true;
            }
        }
        return false;
    }

    public final Map d() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void e(int i, int i2) {
        Object obj = this.a;
        Objects.requireNonNull(obj);
        int[] iArrA = a();
        Object[] objArrB = b();
        Object[] objArrC = c();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrB[i] = null;
            objArrC[i] = null;
            iArrA[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj2 = objArrB[i3];
        objArrB[i] = obj2;
        objArrC[i] = objArrC[i3];
        objArrB[i3] = null;
        objArrC[i3] = null;
        iArrA[i] = iArrA[i3];
        iArrA[i3] = 0;
        int iB = hh4.b(obj2) & i2;
        int iC = fh4.c(iB, obj);
        if (iC == size) {
            fh4.e(iB, i4, obj);
            return;
        }
        while (true) {
            int i5 = iC - 1;
            int i6 = iArrA[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrA[i5] = ((~i2) & i6) | (i4 & i2);
                return;
            }
            iC = i7;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        ly3 ly3Var = this.k;
        if (ly3Var != null) {
            return ly3Var;
        }
        ly3 ly3Var2 = new ly3(this, 0);
        this.k = ly3Var2;
        return ly3Var2;
    }

    public final boolean f() {
        return this.a == null;
    }

    public final int g() {
        return (1 << (this.f & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapD = d();
        if (mapD != null) {
            return mapD.get(obj);
        }
        int iH = h(obj);
        if (iH == -1) {
            return null;
        }
        return c()[iH];
    }

    public final int h(Object obj) {
        if (f()) {
            return -1;
        }
        int iB = hh4.b(obj);
        int iG = g();
        Object obj2 = this.a;
        Objects.requireNonNull(obj2);
        int iC = fh4.c(iB & iG, obj2);
        if (iC != 0) {
            int i = ~iG;
            int i2 = iB & i;
            do {
                int i3 = iC - 1;
                int i4 = a()[i3];
                if ((i4 & i) == i2 && di4.b(obj, b()[i3])) {
                    return i3;
                }
                iC = i4 & iG;
            } while (iC != 0);
        }
        return -1;
    }

    public final int i(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objD = fh4.d(i2);
        if (i4 != 0) {
            fh4.e(i3 & i5, i4 + 1, objD);
        }
        Object obj = this.a;
        Objects.requireNonNull(obj);
        int[] iArrA = a();
        for (int i6 = 0; i6 <= i; i6++) {
            int iC = fh4.c(i6, obj);
            while (iC != 0) {
                int i7 = iC - 1;
                int i8 = iArrA[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iC2 = fh4.c(i10, objD);
                fh4.e(i10, iC, objD);
                iArrA[i7] = ((~i5) & i9) | (iC2 & i5);
                iC = i8 & i;
            }
        }
        this.a = objD;
        this.f = ((32 - Integer.numberOfLeadingZeros(i5)) & 31) | (this.f & (-32));
        return i5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object j(Object obj) {
        if (!f()) {
            int iG = g();
            Object obj2 = this.a;
            Objects.requireNonNull(obj2);
            int iB = fh4.b(obj, null, iG, obj2, a(), b(), null);
            if (iB != -1) {
                Object obj3 = c()[iB];
                e(iB, iG);
                this.i--;
                this.f += 32;
                return obj3;
            }
        }
        return s;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        ly3 ly3Var = this.j;
        if (ly3Var != null) {
            return ly3Var;
        }
        ly3 ly3Var2 = new ly3(this, 1);
        this.j = ly3Var2;
        return ly3Var2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i;
        int i2 = 32;
        if (f()) {
            if (!f()) {
                og.n("Arrays already allocated");
                return null;
            }
            int i3 = this.f;
            int iMax = Math.max(i3 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.a = fh4.d(iMax2);
            this.f = ((32 - Integer.numberOfLeadingZeros(iMax2 - 1)) & 31) | (this.f & (-32));
            this.b = new int[i3];
            this.c = new Object[i3];
            this.e = new Object[i3];
        }
        Map mapD = d();
        if (mapD != null) {
            return mapD.put(obj, obj2);
        }
        int[] iArrA = a();
        Object[] objArrB = b();
        Object[] objArrC = c();
        int i4 = this.i;
        int i5 = i4 + 1;
        int iB = hh4.b(obj);
        int iG = g();
        int i6 = iB & iG;
        Object obj3 = this.a;
        Objects.requireNonNull(obj3);
        int iC = fh4.c(i6, obj3);
        if (iC == 0) {
            if (i5 > iG) {
                iG = i(iG, (iG + 1) * (iG < 32 ? 4 : 2), iB, i4);
            } else {
                Object obj4 = this.a;
                Objects.requireNonNull(obj4);
                fh4.e(i6, i5, obj4);
            }
            i = 1;
        } else {
            int i7 = ~iG;
            int i8 = iB & i7;
            int i9 = 0;
            while (true) {
                int i10 = iC - 1;
                int i11 = iArrA[i10];
                i = 1;
                int i12 = i11 & i7;
                int i13 = i2;
                if (i12 == i8 && di4.b(obj, objArrB[i10])) {
                    Object obj5 = objArrC[i10];
                    objArrC[i10] = obj2;
                    return obj5;
                }
                int i14 = i11 & iG;
                int i15 = i9 + 1;
                if (i14 == 0) {
                    if (i15 < 9) {
                        if (i5 <= iG) {
                            iArrA[i10] = i12 | (i5 & iG);
                            break;
                        }
                        iG = i(iG, (iG + 1) * (iG < i13 ? 4 : 2), iB, i4);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(g() + 1, 1.0f);
                    int i16 = isEmpty() ? -1 : 0;
                    while (i16 >= 0) {
                        linkedHashMap.put(b()[i16], c()[i16]);
                        int i17 = i16 + 1;
                        i16 = i17 < this.i ? i17 : -1;
                    }
                    this.a = linkedHashMap;
                    this.b = null;
                    this.c = null;
                    this.e = null;
                    this.f += 32;
                    return linkedHashMap.put(obj, obj2);
                }
                iC = i14;
                i9 = i15;
                i2 = i13;
            }
        }
        int length = a().length;
        if (i5 > length) {
            int i18 = i;
            int iMin = Math.min(1073741823, (Math.max(i18, length >>> 1) + length) | i18);
            if (iMin != length) {
                this.b = Arrays.copyOf(a(), iMin);
                this.c = Arrays.copyOf(b(), iMin);
                this.e = Arrays.copyOf(c(), iMin);
            }
        }
        a()[i4] = (~iG) & iB;
        b()[i4] = obj;
        c()[i4] = obj2;
        this.i = i5;
        this.f += 32;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapD = d();
        if (mapD != null) {
            return mapD.remove(obj);
        }
        Object objJ = j(obj);
        if (objJ == s) {
            return null;
        }
        return objJ;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapD = d();
        return mapD != null ? mapD.size() : this.i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        sy3 sy3Var = this.n;
        if (sy3Var != null) {
            return sy3Var;
        }
        sy3 sy3Var2 = new sy3(this);
        this.n = sy3Var2;
        return sy3Var2;
    }
}
