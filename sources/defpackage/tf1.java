package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class tf1 {
    public final int a;
    public final uf1 b;
    public final ak1 c;
    public int d;
    public int e;
    public int f;

    public tf1(int i) {
        this.a = i;
        if (i <= 0) {
            og.i("maxSize <= 0");
            throw null;
        }
        this.b = new uf1(28);
        this.c = new ak1(15);
    }

    public final Object a(Object obj) {
        synchronized (this.c) {
            uf1 uf1Var = this.b;
            uf1Var.getClass();
            Object obj2 = ((LinkedHashMap) uf1Var.b).get(obj);
            if (obj2 != null) {
                this.e++;
                return obj2;
            }
            this.f++;
            return null;
        }
    }

    public final Object b(Object obj, Object obj2) {
        Object objPut;
        obj.getClass();
        synchronized (this.c) {
            this.d++;
            uf1 uf1Var = this.b;
            uf1Var.getClass();
            objPut = ((LinkedHashMap) uf1Var.b).put(obj, obj2);
            if (objPut != null) {
                this.d--;
            }
        }
        int i = this.a;
        while (true) {
            synchronized (this.c) {
                try {
                    if (this.d < 0 || (((LinkedHashMap) this.b.b).isEmpty() && this.d != 0)) {
                        break;
                    }
                    if (this.d > i && !((LinkedHashMap) this.b.b).isEmpty()) {
                        Set setEntrySet = ((LinkedHashMap) this.b.b).entrySet();
                        setEntrySet.getClass();
                        Set set = setEntrySet;
                        Object next = null;
                        if (set instanceof List) {
                            List list = (List) set;
                            if (!list.isEmpty()) {
                                next = list.get(0);
                            }
                        } else {
                            Iterator it = set.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return objPut;
                        }
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        uf1 uf1Var2 = this.b;
                        uf1Var2.getClass();
                        key.getClass();
                        ((LinkedHashMap) uf1Var2.b).remove(key);
                        int i2 = this.d;
                        value.getClass();
                        this.d = i2 - 1;
                    }
                    return objPut;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public final String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.e;
                int i2 = this.f + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.e + ",misses=" + this.f + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
