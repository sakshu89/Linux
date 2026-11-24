package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wl4 {
    public static void a(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            d10 d10Var = (d10) obj;
            o80 o80Var = new o80(d10Var);
            for (Class cls : d10Var.a) {
                boolean z = d10Var.c == 0;
                p80 p80Var = new p80(cls, !z);
                if (!map.containsKey(p80Var)) {
                    map.put(p80Var, new HashSet());
                }
                Set set = (Set) map.get(p80Var);
                if (!set.isEmpty() && z) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set.add(o80Var);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (o80 o80Var2 : (Set) it.next()) {
                for (mc0 mc0Var : o80Var2.a.b) {
                    if (mc0Var.c == 0) {
                        Set<o80> set2 = (Set) map.get(new p80(mc0Var.a, mc0Var.b == 2));
                        if (set2 != null) {
                            for (o80 o80Var3 : set2) {
                                o80Var2.b.add(o80Var3);
                                o80Var3.c.add(o80Var2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<o80> hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        for (o80 o80Var4 : hashSet) {
            if (o80Var4.c.isEmpty()) {
                hashSet2.add(o80Var4);
            }
        }
        while (!hashSet2.isEmpty()) {
            o80 o80Var5 = (o80) hashSet2.iterator().next();
            hashSet2.remove(o80Var5);
            i++;
            for (o80 o80Var6 : o80Var5.b) {
                o80Var6.c.remove(o80Var5);
                if (o80Var6.c.isEmpty()) {
                    hashSet2.add(o80Var6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (o80 o80Var7 : hashSet) {
            if (!o80Var7.c.isEmpty() && !o80Var7.b.isEmpty()) {
                arrayList2.add(o80Var7.a);
            }
        }
        throw new nc0("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }
}
