package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pg1 implements Map.Entry, x41 {
    public final rg1 a;
    public final int b;
    public final int c;

    public pg1(rg1 rg1Var, int i) {
        rg1Var.getClass();
        this.a = rg1Var;
        this.b = i;
        this.c = rg1Var.k;
    }

    public final void a() {
        if (this.a.k != this.c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return g31.a(entry.getKey(), getKey()) && g31.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.a.a[this.b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.a.b;
        objArr.getClass();
        return objArr[this.b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        rg1 rg1Var = this.a;
        rg1Var.c();
        Object[] objArr = rg1Var.b;
        if (objArr == null) {
            int length = rg1Var.a.length;
            if (length < 0) {
                og.i("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            rg1Var.b = objArr;
        }
        int i = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
