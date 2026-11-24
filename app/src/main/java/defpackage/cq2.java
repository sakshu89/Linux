package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cq2 {
    public static final Set a = wh2.c("live", "remix", "acoustic", "cover", "karaoke", "instrumental", "version", "edit", "deluxe", "remastered", "rerecorded", "demo", "extended");
    public static final x42 b;
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        b = new x42("\\s*(?:[,;]|\\s&\\s|\\s(?:feat\\.?|featuring)\\s)\\s*", y42Var);
        c = new x42("\\b(?:by|from)\\b", y42Var);
        d = new x42("(?:…|\\.{2,})\\s*$");
        e = new x42("\\s*(?:[\\[(]\\s*from\\s+[^\\])]+[\\])]|[-–—]\\s*from\\s+.*)\\s*$", y42Var);
    }

    public static boolean a(String str, String str2) {
        if (str == null || cs2.A(str)) {
            return true;
        }
        if (str2 != null && !cs2.A(str2)) {
            String strL = l(str);
            if (!cs2.A(strL)) {
                if (strL.equals(l(str2))) {
                    return true;
                }
                List listI = b.i(str2);
                ArrayList arrayList = new ArrayList(nz.d(listI));
                Iterator it = listI.iterator();
                while (it.hasNext()) {
                    arrayList.add(l((String) it.next()));
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (!cs2.A((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        if (g31.a((String) obj2, strL)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        if (!i(str)) {
            return a(str, str2);
        }
        if (str2 != null && !cs2.A(str2)) {
            str.getClass();
            String strL = l(d.f(str, ""));
            int i = 0;
            for (int i2 = 0; i2 < strL.length(); i2++) {
                if (Character.isLetterOrDigit(strL.charAt(i2))) {
                    i++;
                }
            }
            if (i >= 6) {
                String strL2 = l(str2);
                if (g31.a(strL2, strL)) {
                    return true;
                }
                if (!i(str2) && js2.k(strL2, strL, false) && strL2.length() > strL.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(String str, String str2) {
        str.getClass();
        if (!j(str)) {
            return e(str, str2);
        }
        if (str2 != null && !cs2.A(str2)) {
            x42 x42Var = d;
            String strL = l(x42Var.f(str, ""));
            int i = 0;
            for (int i2 = 0; i2 < strL.length(); i2++) {
                if (Character.isLetterOrDigit(strL.charAt(i2))) {
                    i++;
                }
            }
            if (i >= 6) {
                String strL2 = l(x42Var.f(str2, ""));
                if (g31.a(strL2, strL)) {
                    return true;
                }
                if (!j(str2) && js2.k(strL2, strL, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer d(List list, int i, ArrayList arrayList) {
        int i2;
        list.getClass();
        int i3 = i - 1;
        if (i3 >= 0 && i3 < list.size()) {
            xv2 xv2Var = (xv2) list.get(i3);
            if (i3 >= 0 && i3 < arrayList.size()) {
                xv2 xv2Var2 = (xv2) arrayList.get(i3);
                String str = xv2Var.a;
                String str2 = xv2Var.b;
                if ((!j(str) || j(xv2Var2.a)) && c(str, xv2Var2.a) && b(str2, xv2Var2.b)) {
                    if (j(str) || i(str2)) {
                        i2 = 0;
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj = arrayList.get(i4);
                                i4++;
                                xv2 xv2Var3 = (xv2) obj;
                                if (!j(str) || j(xv2Var3.a)) {
                                    if (c(str, xv2Var3.a) && b(str2, xv2Var3.b) && (i2 = i2 + 1) < 0) {
                                        nz.m();
                                        throw null;
                                    }
                                }
                            }
                        }
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 1) {
                        return Integer.valueOf(i3);
                    }
                }
            }
            h21 h21VarF = nz.f(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = h21VarF.iterator();
            while (true) {
                g21 g21Var = (g21) it;
                if (!g21Var.c) {
                    break;
                }
                Object next = g21Var.next();
                int iIntValue = ((Number) next).intValue();
                if (!j(xv2Var.a) || j(((xv2) arrayList.get(iIntValue)).a)) {
                    if (c(xv2Var.a, ((xv2) arrayList.get(iIntValue)).a) && b(xv2Var.b, ((xv2) arrayList.get(iIntValue)).b)) {
                        arrayList2.add(next);
                    }
                }
            }
            if (arrayList2.size() == 1) {
                return (Integer) mz.H(arrayList2);
            }
        }
        return null;
    }

    public static boolean e(String str, String str2) {
        str.getClass();
        if (str2 == null || cs2.A(str2)) {
            return false;
        }
        x42 x42Var = d;
        return (x42Var.a(str) || x42Var.a(str2) || cs2.A(l(str)) || !g31.a(l(str), l(str2))) ? false : true;
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        List listI = b.i(str);
        if (listI.isEmpty()) {
            return false;
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            if (i((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(String str, String str2) {
        if (str == null || cs2.A(str)) {
            return true;
        }
        return (f(str) || f(str2) || !a(str, str2)) ? false : true;
    }

    public static boolean h(String str, String str2, String str3, String str4) {
        int iD;
        str.getClass();
        if (str3 != null && !cs2.A(str3) && !cs2.A(l(str))) {
            if (n(str, str3) && g(str2, str4)) {
                return true;
            }
            if ((str2 == null || cs2.A(str2)) && (iD = cs2.D(str, 2, " by ")) > 0 && n(str.substring(0, iD), str3) && g(cs2.V(str.substring(iD + 4)).toString(), str4)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(String str) {
        return (str == null || cs2.A(str) || !d.a(str)) ? false : true;
    }

    public static boolean j(String str) {
        return (str == null || cs2.A(str) || !d.a(str)) ? false : true;
    }

    public static boolean k(ro1 ro1Var, String str, String str2) {
        str.getClass();
        if (ro1Var != null && ro1Var.a.equals("com.spotify.music") && ro1Var.f) {
            return h(str, str2, ro1Var.c, ro1Var.d);
        }
        return false;
    }

    public static String l(String str) {
        str.getClass();
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        strNormalize.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, strNormalize, locale);
        Pattern patternCompile = Pattern.compile("['’‘\"“”]");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll("");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("[^\\p{L}\\p{M}\\p{N}]+");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll2.getClass();
        return cs2.V(strReplaceAll2).toString();
    }

    public static String m(String str) {
        str.getClass();
        return cs2.V(cs2.G(cs2.G(cs2.G(l(str), "the "), "a "), "an ")).toString();
    }

    public static boolean n(String str, String str2) {
        str.getClass();
        String string = cs2.V(cs2.I(cs2.I(cs2.V(str).toString(), " song"), " track")).toString();
        if (e(string, str2) || e(str, str2)) {
            return true;
        }
        if (str2 != null && !cs2.A(str2) && !j(str) && !cs2.o(str2, (char) 8230) && !cs2.n(str2, "..", false)) {
            String string2 = cs2.V(e.f(str2, "")).toString();
            if (!g31.a(string2, cs2.V(str2).toString()) && (e(string, string2) || e(str, string2))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:50:0x0106  */
    /* JADX WARN: Code duplicated, block: B:52:0x0118  */
    public static boolean o(String str, String str2) {
        x42 x42Var;
        String strF;
        int size;
        int i;
        String str3;
        str.getClass();
        if (str2 != null && !cs2.A(str2)) {
            CharSequence charSequenceM = m(str);
            String strM = m(str2);
            if (!cs2.A(charSequenceM) && !cs2.A(strM)) {
                if (!charSequenceM.equals(strM) && !g31.a(cs2.V(cs2.G(cs2.G(cs2.G(l(str), "the "), "a "), "an ")).toString(), cs2.V(cs2.G(cs2.G(cs2.G(l(str2), "the "), "a "), "an ")).toString())) {
                    List listN = cs2.N(charSequenceM, new char[]{' '}, 6);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listN) {
                        if (!cs2.A((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    List listN2 = cs2.N(strM, new char[]{' '}, 6);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : listN2) {
                        if (!cs2.A((String) obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    boolean zIsEmpty = arrayList2.isEmpty();
                    Set set = a;
                    if (!zIsEmpty) {
                        int size2 = arrayList2.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj3 = arrayList2.get(i2);
                            i2++;
                            String str4 = (String) obj3;
                            if (!set.contains(str4) || arrayList.contains(str4)) {
                            }
                        }
                        if (arrayList.isEmpty()) {
                            x42Var = c;
                            strF = x42Var.f(charSequenceM, "source");
                            if (strF.equals(x42Var.f(strM, "source"))) {
                            }
                        } else {
                            size = arrayList.size();
                            i = 0;
                            while (i < size) {
                                Object obj4 = arrayList.get(i);
                                i++;
                                str3 = (String) obj4;
                                if (set.contains(str3)) {
                                }
                            }
                            x42Var = c;
                            strF = x42Var.f(charSequenceM, "source");
                            if (strF.equals(x42Var.f(strM, "source"))) {
                            }
                        }
                    } else if (arrayList.isEmpty()) {
                        x42Var = c;
                        strF = x42Var.f(charSequenceM, "source");
                        if (strF.equals(x42Var.f(strM, "source")) || strF.equals(charSequenceM)) {
                        }
                    } else {
                        size = arrayList.size();
                        i = 0;
                        while (i < size) {
                            Object obj5 = arrayList.get(i);
                            i++;
                            str3 = (String) obj5;
                            if (set.contains(str3) || arrayList2.contains(str3)) {
                            }
                        }
                        x42Var = c;
                        strF = x42Var.f(charSequenceM, "source");
                        if (strF.equals(x42Var.f(strM, "source"))) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
