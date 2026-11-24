package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bh1 {
    public static Object a(Object obj, Map map) {
        map.getClass();
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int b(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map c(wt1... wt1VarArr) {
        if (wt1VarArr.length <= 0) {
            return ji0.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b(wt1VarArr.length));
        f(linkedHashMap, wt1VarArr);
        return linkedHashMap;
    }

    public static Map d(String str, Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.remove(str);
        int size = linkedHashMap.size();
        if (size == 0) {
            return ji0.a;
        }
        if (size != 1) {
            return linkedHashMap;
        }
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }

    public static LinkedHashMap e(Map map, Map map2) {
        map.getClass();
        map2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void f(HashMap map, wt1[] wt1VarArr) {
        for (wt1 wt1Var : wt1VarArr) {
            map.put(wt1Var.a, wt1Var.b);
        }
    }

    public static Map g(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return ji0.a;
        }
        int i = 0;
        if (size == 1) {
            wt1 wt1Var = (wt1) arrayList.get(0);
            wt1Var.getClass();
            Map mapSingletonMap = Collections.singletonMap(wt1Var.a, wt1Var.b);
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b(arrayList.size()));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            wt1 wt1Var2 = (wt1) obj;
            linkedHashMap.put(wt1Var2.a, wt1Var2.b);
        }
        return linkedHashMap;
    }

    public static Map h(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return ji0.a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}
