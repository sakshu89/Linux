package defpackage;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class w02 {
    public static final SparseArray a = new SparseArray();
    public static final HashMap b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put(v02.a, 0);
        map.put(v02.b, 1);
        map.put(v02.c, 2);
        for (v02 v02Var : map.keySet()) {
            a.append(((Integer) b.get(v02Var)).intValue(), v02Var);
        }
    }

    public static int a(v02 v02Var) {
        Integer num = (Integer) b.get(v02Var);
        if (num != null) {
            return num.intValue();
        }
        dk0.q(v02Var, "PriorityMapping is missing known Priority value ");
        return 0;
    }

    public static v02 b(int i) {
        v02 v02Var = (v02) a.get(i);
        if (v02Var != null) {
            return v02Var;
        }
        og.i(ky0.h(i, "Unknown Priority for value "));
        return null;
    }
}
