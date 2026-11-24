package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dp4 {
    public static final Integer a(fh1 fh1Var) {
        Object next;
        Iterator it = mz.u(1, fh1Var.a()).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((String) next).length() <= 0);
        String str = (String) next;
        if (str != null) {
            return js2.l(10, str);
        }
        return null;
    }

    public static final String b(String str) {
        str.getClass();
        String strY = cs2.Y(cs2.V(str).toString(), '.', ',', '!', '?', ':', ';');
        for (String str2 : nz.i("the ", "a ", "an ", "my ")) {
            if (js2.k(strY, str2, false)) {
                strY = cs2.G(strY, str2);
                break;
            }
        }
        for (String str3 : nz.i(" please", " for me", " right now", " now")) {
            if (js2.e(strY, str3, false)) {
                strY = cs2.I(strY, str3);
            }
        }
        return cs2.V(strY).toString();
    }

    public static final f5 c(b63 b63Var, String str, Map map, float f, q21 q21Var) {
        b63Var.getClass();
        map.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(bh1.b(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), cs2.V((String) entry.getValue()).toString());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!cs2.A((String) entry2.getValue())) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return new f5(str, linkedHashMap2, f, q21Var, b63Var.a);
    }

    public static /* synthetic */ f5 d(b63 b63Var, String str, Map map, float f, int i) {
        if ((i & 2) != 0) {
            map = ji0.a;
        }
        if ((i & 4) != 0) {
            f = 0.9f;
        }
        return c(b63Var, str, map, f, q21.a);
    }
}
