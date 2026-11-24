package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ds2 {
    public static void a(StringBuilder sb, Object obj, hq0 hq0Var) {
        if (hq0Var != null) {
            sb.append((CharSequence) hq0Var.j(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static String b(String str) {
        Comparable comparable;
        List listE = cs2.E(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listE) {
            if (!cs2.A((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!ph4.c(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listE.size();
        int size2 = listE.size() - 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listE) {
            int i3 = i + 1;
            if (i < 0) {
                nz.n();
                throw null;
            }
            String str3 = (String) obj3;
            String strP = ((i == 0 || i == size2) && cs2.A(str3)) ? null : cs2.p(iIntValue, str3);
            if (strP != null) {
                arrayList3.add(strP);
            }
            i = i3;
        }
        StringBuilder sb = new StringBuilder(length3);
        mz.B(arrayList3, sb, null, 124);
        return sb.toString();
    }

    public static String c(String str) {
        if (cs2.A("|")) {
            og.i("marginPrefix must be non-blank string.");
            return null;
        }
        List listE = cs2.E(str);
        int length = str.length();
        listE.size();
        int size = listE.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listE) {
            int i2 = i + 1;
            if (i < 0) {
                nz.n();
                throw null;
            }
            String str2 = (String) obj;
            if ((i == 0 || i == size) && cs2.A(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!ph4.c(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                String strSubstring = (i3 != -1 && js2.j(str2, "|", i3, false)) ? str2.substring("|".length() + i3) : null;
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        mz.B(arrayList, sb, null, 124);
        return sb.toString();
    }
}
