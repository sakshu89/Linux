package defpackage;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hv3 extends AbstractMap {
    public static final /* synthetic */ int j = 0;
    public Object[] a;
    public int b;
    public Map c;
    public boolean e;
    public volatile ig f;
    public Map i;

    public hv3() {
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.i = map;
    }

    public final Set a() {
        return this.c.isEmpty() ? Collections.EMPTY_SET : this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int iD = d(comparable);
        if (iD >= 0) {
            return ((iv3) this.a[iD]).setValue(obj);
        }
        g();
        if (this.a == null) {
            this.a = new Object[16];
        }
        int i = -(iD + 1);
        if (i >= 16) {
            return f().put(comparable, obj);
        }
        if (this.b == 16) {
            iv3 iv3Var = (iv3) this.a[15];
            this.b = 15;
            f().put(iv3Var.a, iv3Var.b);
        }
        Object[] objArr = this.a;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.a[i] = new iv3(this, comparable, obj);
        this.b++;
        return null;
    }

    public final iv3 c(int i) {
        if (i < this.b) {
            return (iv3) this.a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.b != 0) {
            this.a = null;
            this.b = 0;
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return d(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final int d(Comparable comparable) {
        int i = this.b;
        int i2 = i - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((iv3) this.a[i2]).a);
            if (iCompareTo > 0) {
                return -(i + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((iv3) this.a[i4]).a);
            if (iCompareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    public final Object e(int i) {
        g();
        Object[] objArr = this.a;
        Object obj = ((iv3) objArr[i]).b;
        System.arraycopy(objArr, i + 1, objArr, i, (this.b - i) - 1);
        this.b--;
        if (!this.c.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            Object[] objArr2 = this.a;
            int i2 = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new iv3(this, (Comparable) entry.getKey(), entry.getValue());
            this.b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f == null) {
            this.f = new ig(this, 2);
        }
        return this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hv3)) {
            return super.equals(obj);
        }
        hv3 hv3Var = (hv3) obj;
        int size = size();
        if (size == hv3Var.size()) {
            int i = this.b;
            if (i != hv3Var.b) {
                return entrySet().equals(hv3Var.entrySet());
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (c(i2).equals(hv3Var.c(i2))) {
                }
            }
            if (i != size) {
                return this.c.equals(hv3Var.c);
            }
            return true;
        }
        return false;
    }

    public final SortedMap f() {
        g();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.i = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    public final void g() {
        if (this.e) {
            dk0.p();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iD = d(comparable);
        return iD >= 0 ? ((iv3) this.a[iD]).b : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.a[i2].hashCode();
        }
        return this.c.size() > 0 ? this.c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iD = d(comparable);
        if (iD >= 0) {
            return e(iD);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size() + this.b;
    }
}
