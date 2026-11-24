package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class od1 {
    public static final x42 a;
    public static final x42 b;
    public static final List c;

    static {
        wh2.b("auto");
        a = new x42("^gemini-[a-zA-Z0-9][a-zA-Z0-9._-]{0,120}$");
        b = new x42("^gemini-(\\d+)(?:\\.(\\d+))?(?:-|$)");
        c = nz.i("extended-thinking", "transcrib", "translat", "embedding", "robotics", "tts", "image");
    }

    public static final wt1 a(String str) {
        fh1 fh1VarB = x42.b(b, str);
        if (fh1VarB == null) {
            return new wt1(0, 0);
        }
        Integer numM = js2.m((String) ((dh1) fh1VarB.a()).get(1));
        Integer numValueOf = Integer.valueOf(numM != null ? numM.intValue() : 0);
        Integer numM2 = js2.m((String) ((dh1) fh1VarB.a()).get(2));
        return new wt1(numValueOf, Integer.valueOf(numM2 != null ? numM2.intValue() : 0));
    }

    public static List b(List list) {
        list.getClass();
        List listT = mz.t(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listT) {
            if (a.e((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            String str = (String) obj2;
            List list2 = c;
            if (list2 == null || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!cs2.n(str, (String) it.next(), true));
            }
            arrayList2.add(obj2);
        }
        return mz.K(arrayList2, new i2(6, new i2(5, new i2(8, new i2(7, new lo0(16))))));
    }
}
