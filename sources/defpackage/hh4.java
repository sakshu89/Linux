package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hh4 {
    public static void a(es esVar, ArrayList arrayList) {
        if (!(esVar instanceof fs)) {
            if (esVar instanceof kw) {
                arrayList.add(((kw) esVar).a);
                return;
            } else {
                arrayList.add(new cr(esVar));
                return;
            }
        }
        ArrayList arrayList2 = ((fs) esVar).a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            a((es) obj, arrayList);
        }
    }

    public static int b(Object obj) {
        return (int) (((long) Integer.rotateLeft((int) (((long) (obj == null ? 0 : obj.hashCode())) * (-862048943)), 15)) * 461845907);
    }
}
