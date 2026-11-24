package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface oh1 {
    default int a(z21 z21Var, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new pa0((jh1) list.get(i3), a31.b, d31.b, i2));
        }
        return f(new m31(z21Var, z21Var.getLayoutDirection()), arrayList, r40.b(i, 0, 13)).a();
    }

    default int c(z21 z21Var, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new pa0((jh1) list.get(i3), a31.b, d31.a, i2));
        }
        return f(new m31(z21Var, z21Var.getLayoutDirection()), arrayList, r40.b(0, i, 7)).b();
    }

    ph1 f(qh1 qh1Var, List list, long j);

    default int g(z21 z21Var, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new pa0((jh1) list.get(i3), a31.a, d31.b, i2));
        }
        return f(new m31(z21Var, z21Var.getLayoutDirection()), arrayList, r40.b(i, 0, 13)).a();
    }

    default int i(z21 z21Var, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new pa0((jh1) list.get(i3), a31.a, d31.a, i2));
        }
        return f(new m31(z21Var, z21Var.getLayoutDirection()), arrayList, r40.b(0, i, 7)).b();
    }
}
