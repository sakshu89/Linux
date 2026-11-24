package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class am4 {
    public static wp a(ArrayList arrayList, ch2 ch2Var, xv0 xv0Var) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(oz3.e(((ob0) obj).c()));
        }
        return hg4.a(new rw(hg4.a(new kr0(new uc1(new ArrayList(arrayList2), false, xg4.a()), xv0Var, 5000L, 0)), ch2Var, arrayList));
    }
}
