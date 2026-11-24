package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ey {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public ey(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            db1 db1Var = (db1) entry.getValue();
            List arrayList = (List) this.a.get(db1Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(db1Var, arrayList);
            }
            arrayList.add((fy) entry.getKey());
        }
    }

    public static void a(List list, ob1 ob1Var, db1 db1Var, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                fy fyVar = (fy) list.get(size);
                Method method = fyVar.b;
                try {
                    int i = fyVar.a;
                    if (i == 0) {
                        method.invoke(obj, null);
                    } else if (i == 1) {
                        method.invoke(obj, ob1Var);
                    } else if (i == 2) {
                        method.invoke(obj, ob1Var, db1Var);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
