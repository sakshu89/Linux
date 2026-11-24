package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class nz {
    public static ArrayList a(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new gg(objArr, true));
    }

    public static int b(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        arrayList.getClass();
        int size2 = arrayList.size();
        int i = 0;
        if (size < 0) {
            og.i(cq.i("fromIndex (", 0, ") is greater than toIndex (", size, ")."));
            return 0;
        }
        if (size > size2) {
            og.o(cq.i("toIndex (", size, ") is greater than size (", size2, ")."));
            return 0;
        }
        int i2 = size - 1;
        while (i <= i2) {
            int i3 = (i + i2) >>> 1;
            int iA = si4.a((Comparable) arrayList.get(i3), comparable);
            if (iA < 0) {
                i = i3 + 1;
            } else {
                if (iA <= 0) {
                    return i3;
                }
                i2 = i3 - 1;
            }
        }
        return -(i + 1);
    }

    public static qc1 c(qc1 qc1Var) {
        qc1Var.h();
        qc1Var.c = true;
        return qc1Var.b > 0 ? qc1Var : qc1.e;
    }

    public static int d(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static qc1 e() {
        return new qc1(10);
    }

    public static h21 f(Collection collection) {
        return new h21(0, collection.size() - 1, 1);
    }

    public static int g(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List h(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static List i(Object... objArr) {
        if (objArr.length <= 0) {
            return ii0.a;
        }
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    public static List j(Object obj) {
        return obj != null ? h(obj) : ii0.a;
    }

    public static ArrayList k(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new gg(objArr, true));
    }

    public static final List l(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : h(list.get(0));
        }
        return ii0.a;
    }

    public static void m() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static int o(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }
}
