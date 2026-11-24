package defpackage;

import android.graphics.Rect;
import com.ibm.icu.impl.number.Padder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class uz3 {
    public static String a(wc2 wc2Var) throws NoSuchAlgorithmException {
        if (wc2Var == null) {
            return "";
        }
        String strJ = ky0.j(wc2Var.a, mz.C(wc2Var.c, "|", null, null, new sa2(18), 30));
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = strJ.getBytes(px.a);
        bytes.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes);
        bArrDigest.getClass();
        return qg.r(bArrDigest, "", new sa2(19), 30);
    }

    public static wc2 b(wc2 wc2Var, List list, Rect rect, String str) {
        String str2;
        String strS;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        list.getClass();
        rect.getClass();
        str.getClass();
        List list2 = wc2Var != null ? wc2Var.c : null;
        if (list2 == null) {
            list2 = ii0.a;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            gp1 gp1Var = (gp1) obj;
            String str3 = gp1Var.a;
            Rect rect2 = gp1Var.b;
            if (!cs2.A(str3) && (i = rect2.right) > (i2 = rect2.left) && (i3 = rect2.bottom) > (i4 = rect2.top) && (i5 = rect.right) > (i6 = rect.left) && (i7 = rect.bottom) > (i8 = rect.top) && i2 >= i6 && i4 >= i8 && i <= i5 && i3 <= i7) {
                if (!list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ob2 ob2Var = (ob2) it.next();
                            if (e(ob2Var.a).equals(e(gp1Var.a))) {
                                Rect rect3 = ob2Var.d;
                                rect3.getClass();
                                if (Math.min(rect3.right, rect2.right) > Math.max(rect3.left, rect2.left) && Math.min(rect3.bottom, rect2.bottom) > Math.max(rect3.top, rect2.top)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                arrayList.add(obj);
                break;
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            gp1 gp1Var2 = (gp1) obj2;
            String str4 = gp1Var2.a;
            Rect rect4 = gp1Var2.b;
            if (hashSet.add(str4 + ":" + rect4.left + ":" + rect4.top + ":" + rect4.right + ":" + rect4.bottom)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(nz.d(arrayList2));
        int size2 = arrayList2.size();
        while (i9 < size2) {
            Object obj3 = arrayList2.get(i9);
            i9++;
            gp1 gp1Var3 = (gp1) obj3;
            arrayList3.add(new ob2(gp1Var3.a, "ocr.Text", gp1Var3.b));
        }
        if (wc2Var == null || (strS = wc2Var.b) == null) {
            str2 = str;
            strS = cs2.S(str2, '.');
        } else {
            str2 = str;
        }
        return new wc2(str2, strS, mz.K(mz.G(list2, arrayList3), new i2(13, new lo0(23))), System.currentTimeMillis());
    }

    public static final String c(ob2 ob2Var) {
        String str = ob2Var.b;
        if (str == null) {
            str = "";
        }
        String strS = cs2.S(str, '/');
        Locale locale = Locale.ROOT;
        return cq.o(locale, strS, locale);
    }

    public static final String d(cc2 cc2Var, boolean z, String str) {
        if (cc2Var == cc2.b || cc2Var == cc2.c) {
            return kd3.a(str);
        }
        str.getClass();
        if (!z) {
            return cs2.V(str).toString();
        }
        String string = cs2.V(str).toString();
        Pattern patternCompile = Pattern.compile("\\s*\\((?:you|आप)\\)$", 66);
        patternCompile.getClass();
        string.getClass();
        String strReplaceAll = patternCompile.matcher(string).replaceAll("");
        strReplaceAll.getClass();
        return cs2.V(strReplaceAll).toString();
    }

    public static String e(String str) {
        str.getClass();
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, string, locale);
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public static final ek1 f(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new j51(null, hq0Var));
    }

    public static String g(wc2 wc2Var) {
        if (wc2Var == null) {
            return null;
        }
        List list = wc2Var.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ob2 ob2Var = (ob2) obj;
            if (!g31.a(wc2Var.a, "com.google.android.youtube") || !g31.a(ob2Var.b, "com.google.android.youtube:id/search_query")) {
                if (ob2Var.f) {
                    String str = ob2Var.b;
                    if (str == null) {
                        str = "";
                    }
                    if (cs2.n(str, "search", true) || cs2.n(ob2Var.i, "search", true) || cs2.n(ob2Var.c, "Search", true)) {
                    }
                }
            }
            arrayList.add(obj);
        }
        ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((ob2) obj2).a);
        }
        return (String) mz.I(mz.t(arrayList2));
    }
}
