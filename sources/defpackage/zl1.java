package defpackage;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zl1 extends gs1 {
    public static zl1 m() {
        return new zl1(new TreeMap(gs1.b));
    }

    public static zl1 o(s30 s30Var) {
        TreeMap treeMap = new TreeMap(gs1.b);
        for (bi biVar : s30Var.e()) {
            Set<r30> setG = s30Var.g(biVar);
            ArrayMap arrayMap = new ArrayMap();
            for (r30 r30Var : setG) {
                arrayMap.put(r30Var, s30Var.h(biVar, r30Var));
            }
            treeMap.put(biVar, arrayMap);
        }
        return new zl1(treeMap);
    }

    public final void u(bi biVar, r30 r30Var, Object obj) {
        r30 r30Var2;
        TreeMap treeMap = this.a;
        Map map = (Map) treeMap.get(biVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            treeMap.put(biVar, arrayMap);
            arrayMap.put(r30Var, obj);
            return;
        }
        r30 r30Var3 = (r30) Collections.min(map.keySet());
        if (Objects.equals(map.get(r30Var3), obj) || r30Var3 != (r30Var2 = r30.b) || r30Var != r30Var2) {
            map.put(r30Var, obj);
            return;
        }
        StringBuilder sb = new StringBuilder("Option values conflicts: ");
        sb.append(biVar.a);
        sb.append(", existing value (");
        sb.append(r30Var3);
        Object obj2 = map.get(r30Var3);
        sb.append(")=");
        sb.append(obj2);
        sb.append(", conflicting (");
        sb.append(r30Var);
        sb.append(")=");
        sb.append(obj);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void v(bi biVar, Object obj) {
        u(biVar, r30.c, obj);
    }
}
