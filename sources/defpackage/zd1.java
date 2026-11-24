package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zd1 {
    public final LinkedHashMap a;
    public final LinkedHashSet b;
    public final LinkedHashSet c;
    public long d;
    public final Object e;
    public final Object f;

    public zd1() {
        this.a = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.b = new LinkedHashSet();
        this.c = new LinkedHashSet();
        this.f = new LinkedHashMap();
    }

    public boolean a(long j) {
        return ((Number) ((LinkedHashMap) this.f).getOrDefault(Long.valueOf(j), 0)).intValue() < 2;
    }

    public void b(long j) {
        Long lValueOf = Long.valueOf(j);
        LinkedHashSet linkedHashSet = this.b;
        if (linkedHashSet.contains(lValueOf)) {
            Long lValueOf2 = Long.valueOf(j);
            LinkedHashSet linkedHashSet2 = this.c;
            if (linkedHashSet2.contains(lValueOf2)) {
                Long lValueOf3 = Long.valueOf(j);
                LinkedHashMap linkedHashMap = this.a;
                if (((Number) linkedHashMap.getOrDefault(lValueOf3, 0L)).longValue() == 0) {
                    linkedHashSet.remove(Long.valueOf(j));
                    linkedHashSet2.remove(Long.valueOf(j));
                    linkedHashMap.remove(Long.valueOf(j));
                    ((hq0) this.e).j(Long.valueOf(j));
                }
            }
        }
    }

    public synchronized void c(hq0 hq0Var) {
        try {
            Collection collectionValues = this.a.values();
            collectionValues.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (((Boolean) hq0Var.j(((ae1) obj).d)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                arrayList2.add(Long.valueOf(((ae1) obj2).a));
            }
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj3 = arrayList2.get(i);
                i++;
                g(((Number) obj3).longValue());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ae1 d(String str, String str2, JSONObject jSONObject) {
        str2.getClass();
        ae1 ae1Var = (ae1) ((LinkedHashMap) this.e).get(str);
        if (ae1Var != null) {
            return ae1Var;
        }
        long j = this.d + 1;
        this.d = j;
        ae1 ae1Var2 = new ae1(j, str, str2, jSONObject);
        ((LinkedHashMap) this.e).put(str, ae1Var2);
        this.a.put(Long.valueOf(j), ae1Var2);
        while (((LinkedHashMap) this.e).size() > 128) {
            Set setKeySet = ((LinkedHashMap) this.e).keySet();
            setKeySet.getClass();
            Object objW = mz.w(setKeySet);
            objW.getClass();
            ae1 ae1Var3 = (ae1) ((LinkedHashMap) this.e).remove((String) objW);
            if (ae1Var3 != null) {
                this.a.remove(Long.valueOf(ae1Var3.a));
                this.b.remove(Long.valueOf(ae1Var3.a));
                this.c.remove(Long.valueOf(ae1Var3.a));
            }
        }
        return ae1Var2;
    }

    public synchronized boolean e(long j) {
        return (!this.a.containsKey(Long.valueOf(j)) || a(j) || this.b.contains(Long.valueOf(j)) || this.c.contains(Long.valueOf(j))) ? false : true;
    }

    public synchronized ae1 f() {
        Object next;
        Collection collectionValues = this.a.values();
        collectionValues.getClass();
        Collection collection = collectionValues;
        next = null;
        if (collection instanceof List) {
            List list = (List) collection;
            if (!list.isEmpty()) {
                next = list.get(list.size() - 1);
            }
        } else {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                next = it.next();
                while (it.hasNext()) {
                    next = it.next();
                }
            }
        }
        return (ae1) next;
    }

    public synchronized boolean g(long j) {
        boolean z;
        z = this.a.remove(Long.valueOf(j)) != null;
        this.b.remove(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
        ((LinkedHashMap) this.f).remove(Long.valueOf(j));
        return z;
    }

    public void h(int i, long j) {
        if (i <= 0) {
            return;
        }
        long j2 = i;
        ((hg) this.f).addLast(new yd1(j, j2));
        if (j != 0) {
            this.c.add(Long.valueOf(j));
            Long lValueOf = Long.valueOf(j);
            Long lValueOf2 = Long.valueOf(j);
            LinkedHashMap linkedHashMap = this.a;
            linkedHashMap.put(lValueOf, Long.valueOf(((Number) linkedHashMap.getOrDefault(lValueOf2, 0L)).longValue() + j2));
        }
    }

    public zd1(hq0 hq0Var) {
        this.e = hq0Var;
        this.f = new hg();
        this.a = new LinkedHashMap();
        this.b = new LinkedHashSet();
        this.c = new LinkedHashSet();
    }
}
