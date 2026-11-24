package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aw1 {
    public final zv1 a;
    public final LinkedHashSet b;

    public aw1(zv1 zv1Var) {
        zv1Var.getClass();
        this.a = zv1Var;
        this.b = new LinkedHashSet();
    }

    public final ew1 a(String str, List list) {
        list.getClass();
        if (!list.isEmpty()) {
            zv1 zv1Var = this.a;
            zv1Var.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!zv1Var.c((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (!this.b.contains((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                return arrayList2.isEmpty() ? new cw1(arrayList) : new bw1(str, arrayList2);
            }
        }
        return dw1.a;
    }
}
