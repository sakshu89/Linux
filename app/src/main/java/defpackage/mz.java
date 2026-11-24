package defpackage;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class mz extends rz {
    public static final void A(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, hq0 hq0Var) {
        iterable.getClass();
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            ds2.a(sb, obj, hq0Var);
        }
        sb.append(charSequence3);
    }

    public static /* synthetic */ void B(List list, StringBuilder sb, x0 x0Var, int i) {
        if ((i & 64) != 0) {
            x0Var = null;
        }
        A(list, sb, "\n", "", "", "...", x0Var);
    }

    public static String C(Iterable iterable, String str, String str2, String str3, hq0 hq0Var, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            hq0Var = null;
        }
        iterable.getClass();
        StringBuilder sb = new StringBuilder();
        A(iterable, sb, str4, str5, str6, "...", hq0Var);
        return sb.toString();
    }

    public static Object D(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        kf2.g("List is empty.");
        return null;
    }

    public static Object E(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static ArrayList F(Collection collection, Object obj) {
        collection.getClass();
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static ArrayList G(Collection collection, List list) {
        collection.getClass();
        list.getClass();
        ArrayList arrayList = new ArrayList(list.size() + collection.size());
        arrayList.addAll(collection);
        arrayList.addAll(list);
        return arrayList;
    }

    public static Object H(List list) {
        list.getClass();
        int size = list.size();
        if (size == 0) {
            kf2.g("List is empty.");
            return null;
        }
        if (size == 1) {
            return list.get(0);
        }
        og.i("List has more than one element.");
        return null;
    }

    public static Object I(List list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List J(ArrayList arrayList) {
        if (arrayList.size() <= 1) {
            return O(arrayList);
        }
        Object[] array = arrayList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List K(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listP = P(iterable);
            qz.p(listP, comparator);
            return listP;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return O(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List L(Iterable iterable, int i) {
        iterable.getClass();
        if (i < 0) {
            og.g(cq.h("Requested element count ", i, " is less than zero."));
            return null;
        }
        if (i == 0) {
            return ii0.a;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return O(iterable);
            }
            if (i == 1) {
                return nz.h(w(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return nz.l(arrayList);
    }

    public static List M(int i, List list) {
        if (i < 0) {
            og.g(cq.h("Requested element count ", i, " is less than zero."));
            return null;
        }
        if (i == 0) {
            return ii0.a;
        }
        int size = list.size();
        if (i >= size) {
            return O(list);
        }
        if (i == 1) {
            return nz.h(D(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final void N(Iterable iterable, AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List O(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return nz.l(P(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return ii0.a;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return nz.h(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List P(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        N(iterable, arrayList);
        return arrayList;
    }

    public static Set Q(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return wh2.b(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(collection.size()));
                N(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            N(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : wh2.b(linkedHashSet2.iterator().next());
            }
        }
        return mi0.a;
    }

    public static double r(ArrayList arrayList) {
        int size = arrayList.size();
        double dFloatValue = 0.0d;
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            dFloatValue += (double) ((Number) obj).floatValue();
            i++;
            if (i < 0) {
                nz.m();
                throw null;
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i);
    }

    public static boolean s(Object obj, Iterable iterable) {
        int iIndexOf;
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (iterable instanceof List) {
            iIndexOf = ((List) iterable).indexOf(obj);
        } else {
            int i = 0;
            for (Object obj2 : iterable) {
                if (i < 0) {
                    nz.n();
                    throw null;
                }
                if (g31.a(obj, obj2)) {
                    iIndexOf = i;
                } else {
                    i++;
                }
            }
            iIndexOf = -1;
        }
        return iIndexOf >= 0;
    }

    public static List t(List list) {
        list.getClass();
        return O(new LinkedHashSet(list));
    }

    public static List u(int i, List list) {
        list.getClass();
        if (i < 0) {
            og.g(cq.h("Requested element count ", i, " is less than zero."));
            return null;
        }
        if (i == 0) {
            return O(list);
        }
        int size = list.size() - i;
        if (size <= 0) {
            return ii0.a;
        }
        if (size == 1) {
            return nz.h(D(list));
        }
        ArrayList arrayList = new ArrayList(size);
        if (list instanceof RandomAccess) {
            int size2 = list.size();
            while (i < size2) {
                arrayList.add(list.get(i));
                i++;
            }
        } else {
            ListIterator listIterator = list.listIterator(i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static List v(List list) {
        int size = list.size() - 1;
        if (size < 0) {
            size = 0;
        }
        return L(list, size);
    }

    public static Object w(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return x((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        kf2.g("Collection is empty.");
        return null;
    }

    public static Object x(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        kf2.g("List is empty.");
        return null;
    }

    public static Object y(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object z(int i, List list) {
        list.getClass();
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }
}
