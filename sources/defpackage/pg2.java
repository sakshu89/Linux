package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pg2 {
    public static final Comparator[] a;
    public static final jd b;

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i = 0;
        while (i < 2) {
            comparatorArr[i] = new i2(20, new i2(i == 0 ? lo0.f : lo0.c));
            i++;
        }
        a = comparatorArr;
        b = jd.n0;
    }

    public static final void a(gg2 gg2Var, ArrayList arrayList, h6 h6Var, h6 h6Var2, ml1 ml1Var) {
        cg2 cg2Var = gg2Var.d;
        Object objG = cg2Var.a.g(kg2.m);
        if (objG == null) {
            objG = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objG).booleanValue();
        if ((zBooleanValue || ((Boolean) h6Var2.j(gg2Var)).booleanValue()) && ((Boolean) h6Var.j(gg2Var)).booleanValue()) {
            arrayList.add(gg2Var);
        }
        if (zBooleanValue) {
            ml1Var.h(gg2Var.g, b(gg2Var, h6Var, h6Var2, gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0)));
            return;
        }
        List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        int size = listI.size();
        for (int i = 0; i < size; i++) {
            a((gg2) listI.get(i), arrayList, h6Var, h6Var2, ml1Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d8  */
    public static final ArrayList b(gg2 gg2Var, h6 h6Var, h6 h6Var2, List list) {
        int i;
        ml1 ml1Var = d21.a;
        ml1 ml1Var2 = new ml1();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((gg2) list.get(i2), arrayList, h6Var, h6Var2, ml1Var2);
        }
        int i3 = 1;
        char c = gg2Var.c.i0 == z61.b ? (char) 1 : (char) 0;
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int size2 = arrayList.size() - 1;
        if (size2 >= 0) {
            int i4 = 0;
            while (true) {
                gg2 gg2Var2 = (gg2) arrayList.get(i4);
                if (i4 == 0) {
                    i = i3;
                    arrayList2.add(new wt1(gg2Var2.h(), nz.k(gg2Var2)));
                    break;
                }
                float f = gg2Var2.h().b;
                float f2 = gg2Var2.h().d;
                int i5 = f >= f2 ? i3 : 0;
                int size3 = arrayList2.size() - i3;
                if (size3 >= 0) {
                    int i6 = 0;
                    while (true) {
                        l42 l42Var = (l42) ((wt1) arrayList2.get(i6)).a;
                        i = i3;
                        float f3 = l42Var.b;
                        float f4 = l42Var.d;
                        int i7 = f3 >= f4 ? i : 0;
                        if (i5 == 0 && i7 == 0 && Math.max(f, f3) < Math.min(f2, f4)) {
                            arrayList2.set(i6, new wt1(new l42(Math.max(l42Var.a, 0.0f), Math.max(l42Var.b, f), Math.min(l42Var.c, Float.POSITIVE_INFINITY), Math.min(f4, f2)), ((wt1) arrayList2.get(i6)).b));
                            ((List) ((wt1) arrayList2.get(i6)).b).add(gg2Var2);
                            break;
                        }
                        if (i6 != size3) {
                            i6++;
                            i3 = i;
                        }
                    }
                } else {
                    i = i3;
                }
                arrayList2.add(new wt1(gg2Var2.h(), nz.k(gg2Var2)));
                break;
                if (i4 == size2) {
                    break;
                }
                i4++;
                i3 = i;
            }
        }
        qz.p(arrayList2, lo0.i);
        ArrayList arrayList3 = new ArrayList();
        Comparator comparator = a[c ^ 1];
        int size4 = arrayList2.size();
        for (int i8 = 0; i8 < size4; i8++) {
            wt1 wt1Var = (wt1) arrayList2.get(i8);
            qz.p((List) wt1Var.b, comparator);
            arrayList3.addAll((Collection) wt1Var.b);
        }
        qz.p(arrayList3, new w00(2, b));
        int size5 = 0;
        while (size5 <= arrayList3.size() - 1) {
            List list2 = (List) ml1Var2.b(((gg2) arrayList3.get(size5)).g);
            if (list2 != null) {
                if (((Boolean) h6Var2.j(arrayList3.get(size5))).booleanValue()) {
                    size5++;
                } else {
                    arrayList3.remove(size5);
                }
                arrayList3.addAll(size5, list2);
                size5 += list2.size();
            } else {
                size5++;
            }
        }
        return arrayList3;
    }
}
