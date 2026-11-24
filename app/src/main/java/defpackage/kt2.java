package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kt2 {
    public final ArrayList a = new ArrayList();

    public static void b(ArrayList arrayList, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            arrayList.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    b(arrayList, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public final void a(hj hjVar) {
        this.a.add(hjVar);
    }

    public final List c(List list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        int size = list.size();
        ArrayList arrayList = this.a;
        if (size != arrayList.size()) {
            return null;
        }
        int size2 = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        b(arrayList2, size2, new int[size2], 0);
        hj[] hjVarArr = new hj[list.size()];
        int size3 = arrayList2.size();
        int i = 0;
        while (i < size3) {
            Object obj = arrayList2.get(i);
            i++;
            int[] iArr = (int[]) obj;
            boolean z = true;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (iArr[i2] < list.size()) {
                    hj hjVar = (hj) arrayList.get(i2);
                    hj hjVar2 = (hj) list.get(iArr[i2]);
                    hjVar.getClass();
                    z &= hjVar2.b.a <= hjVar.b.a && hjVar2.a == hjVar.a;
                    if (!z) {
                        break;
                    }
                    hjVarArr[iArr[i2]] = (hj) arrayList.get(i2);
                }
            }
            if (z) {
                return Arrays.asList(hjVarArr);
            }
        }
        return null;
    }
}
