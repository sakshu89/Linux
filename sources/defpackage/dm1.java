package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dm1 {
    public final LinkedHashMap a;
    public final uf1 b;

    public dm1(LinkedHashMap linkedHashMap, boolean z) {
        this.a = linkedHashMap;
        this.b = new uf1(z);
    }

    public final Map a() {
        wt1 wt1Var;
        Set<Map.Entry> setEntrySet = this.a.entrySet();
        int iB = bh1.b(nz.d(setEntrySet));
        if (iB < 16) {
            iB = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iB);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                wt1Var = new wt1(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                wt1Var = new wt1(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(wt1Var.a, wt1Var.b);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (((AtomicBoolean) this.b.b).get()) {
            og.n("Do mutate preferences once returned to DataStore.");
        }
    }

    public final Object c(iz1 iz1Var) {
        iz1Var.getClass();
        Object obj = this.a.get(iz1Var);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final void d(iz1 iz1Var) {
        iz1Var.getClass();
        b();
        this.a.remove(iz1Var);
    }

    public final void e(iz1 iz1Var, Object obj) {
        iz1Var.getClass();
        f(iz1Var, obj);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    public final boolean equals(Object obj) {
        boolean zA;
        if (obj instanceof dm1) {
            LinkedHashMap linkedHashMap = ((dm1) obj).a;
            LinkedHashMap linkedHashMap2 = this.a;
            if (linkedHashMap != linkedHashMap2) {
                if (linkedHashMap.size() == linkedHashMap2.size()) {
                    if (!linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            Object obj2 = linkedHashMap2.get(entry.getKey());
                            if (obj2 != null) {
                                Object value = entry.getValue();
                                if (!(value instanceof byte[])) {
                                    zA = g31.a(value, obj2);
                                } else if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2)) {
                                    zA = true;
                                } else {
                                    zA = false;
                                }
                            } else {
                                zA = false;
                            }
                            if (!zA) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void f(iz1 iz1Var, Object obj) {
        iz1Var.getClass();
        b();
        if (obj == null) {
            d(iz1Var);
            return;
        }
        boolean z = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.a;
        if (z) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(mz.Q((Set) obj));
            setUnmodifiableSet.getClass();
            linkedHashMap.put(iz1Var, setUnmodifiableSet);
        } else if (!(obj instanceof byte[])) {
            linkedHashMap.put(iz1Var, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            linkedHashMap.put(iz1Var, Arrays.copyOf(bArr, bArr.length));
        }
    }

    public final int hashCode() {
        Iterator it = this.a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return mz.C(this.a.entrySet(), ",\n", "{\n", "\n}", j7.k0, 24);
    }

    public /* synthetic */ dm1(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
