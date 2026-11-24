package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ce {
    public static final be a = new be("");

    public static final List a(be beVar, int i, int i2, j jVar) {
        List list;
        if (i == i2 || (list = beVar.a) == null) {
            return null;
        }
        int i3 = 0;
        if (i == 0 && i2 >= beVar.b.length()) {
            if (jVar == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            while (i3 < size) {
                Object obj = list.get(i3);
                if (((Boolean) jVar.j(((ae) obj).a)).booleanValue()) {
                    arrayList.add(obj);
                }
                i3++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        while (i3 < size2) {
            ae aeVar = (ae) list.get(i3);
            if (jVar != null ? ((Boolean) jVar.j(aeVar.a)).booleanValue() : true) {
                int i4 = aeVar.b;
                int i5 = aeVar.c;
                if (b(i, i2, i4, i5)) {
                    arrayList2.add(new ae((xd) aeVar.a, ky3.c(aeVar.b, i, i2) - i, ky3.c(i5, i, i2) - i, aeVar.d));
                }
            }
            i3++;
        }
        return arrayList2;
    }

    public static final boolean b(int i, int i2, int i3, int i4) {
        return ((i < i4) & (i3 < i2)) | (((i == i2) | (i3 == i4)) & (i == i3));
    }
}
