package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e34 {
    public static final gz2 a(cg2 cg2Var) {
        hq0 hq0Var;
        ArrayList arrayList = new ArrayList();
        Object objG = cg2Var.a.g(bg2.a);
        if (objG == null) {
            objG = null;
        }
        b2 b2Var = (b2) objG;
        if (b2Var == null || (hq0Var = (hq0) b2Var.b) == null || !((Boolean) hq0Var.j(arrayList)).booleanValue()) {
            return null;
        }
        return (gz2) arrayList.get(0);
    }

    public static final void b(xc xcVar, int i) {
        Object next;
        Iterator<T> it = xcVar.getLayoutNodeToHolder().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((n71) ((Map.Entry) next).getKey()).b != i);
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || entry.getValue() == null) {
            return;
        }
        dk0.t();
    }
}
