package defpackage;

import android.graphics.Rect;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xp2 {
    public static final x42 a = new x42("[,\\n•·|]");
    public static final x42 b = new x42("\\b(?:sponsored|advertisement|promoted|ad)\\b", y42.IGNORE_CASE);
    public static final Set c = wh2.c("album", "single", "ep", "artist", "playlist", "podcast", "episode", "audiobook");
    public static final Set d = wh2.c("home", "search", "your library", "premium", "more options", "options", "songs", "artists", "albums", "playlists", "podcasts", "top result", "back", "clear", "see all", "filter", "sort", "play", "pause", "resume", "next", "previous", "skip next", "skip previous");
    public static final Set e = wh2.c("now playing", "mini player", "pause", "resume", "next", "previous", "skip next", "skip previous");

    public static hp1 a(String str, String str2, List list) {
        str.getClass();
        if (cs2.A(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            hp1 hp1Var = (hp1) obj;
            Set set = cq2.a;
            if (cq2.h(str, str2, hp1Var.a, hp1Var.b)) {
                arrayList.add(obj);
            }
        }
        return (hp1) mz.I(arrayList);
    }

    public static hp1 b(List list, String str, String str2, List list2, int i) {
        str.getClass();
        list2.getClass();
        ArrayList arrayList = new ArrayList(nz.d(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hp1 hp1Var = (hp1) it.next();
            arrayList.add(new xv2(hp1Var.a, hp1Var.b, null));
        }
        Integer numD = cq2.d(list2, i, arrayList);
        if (numD != null) {
            return (hp1) list.get(numD.intValue());
        }
        if (!cq2.i(str2)) {
            return a(str, str2, list);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            Set set = cq2.a;
            if (cq2.e(str, ((hp1) obj).a)) {
                arrayList2.add(obj);
            }
        }
        hp1 hp1Var2 = (hp1) mz.I(arrayList2);
        if (hp1Var2 != null) {
            Set set2 = cq2.a;
            if (cq2.b(str2, hp1Var2.b)) {
                return hp1Var2;
            }
        }
        return null;
    }

    public static boolean c(String str) {
        ArrayList arrayListF = f(str);
        if (!arrayListF.isEmpty()) {
            int size = arrayListF.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListF.get(i);
                i++;
                if (c.contains(cq2.l((String) obj))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0309  */
    /* JADX WARN: Code duplicated, block: B:81:0x021a  */
    public static List d(List list, int i, int i2) {
        int i3;
        List list2;
        Iterator it;
        int i4;
        int i5;
        hp1 hp1Var;
        Set set;
        String string;
        int i6;
        vp2 vp2Var;
        vp2 vp2Var2;
        String str;
        String str2;
        String string2;
        int i7;
        Object obj;
        Rect rect;
        int i8;
        int i9;
        int i10;
        int i11;
        if (!list.isEmpty() && i > 0 && i2 > 0) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                gp1 gp1Var = (gp1) obj2;
                if (!cs2.A(gp1Var.a) && (i8 = (rect = gp1Var.b).right) > (i9 = rect.left) && (i10 = rect.bottom) > (i11 = rect.top) && i8 > 0 && i9 < i && i10 > 0 && i11 < i2) {
                    arrayList.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj3 = arrayList.get(i12);
                    i12++;
                    Rect rect2 = ((gp1) obj3).b;
                    arrayList2.add(Integer.valueOf(Math.max(1, rect2.bottom - rect2.top)));
                }
                List listJ = mz.J(arrayList2);
                int i13 = 2;
                int iIntValue = ((Number) listJ.get(listJ.size() / 2)).intValue();
                ArrayList arrayList3 = new ArrayList();
                for (gp1 gp1Var2 : mz.K(arrayList, new i2(21, new wp2(0)))) {
                    ListIterator listIterator = arrayList3.listIterator(arrayList3.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            obj = null;
                            break;
                        }
                        Object objPrevious = listIterator.previous();
                        List list3 = (List) objPrevious;
                        if (list3 == null || !list3.isEmpty()) {
                            Iterator it2 = list3.iterator();
                            while (it2.hasNext()) {
                                Rect rect3 = ((gp1) it2.next()).b;
                                Rect rect4 = gp1Var2.b;
                                int iMin = Math.min(rect3.bottom, rect4.bottom) - Math.max(rect3.top, rect4.top);
                                int iMax = Math.max(1, Math.min(rect3.bottom - rect3.top, rect4.bottom - rect4.top));
                                int i14 = rect3.top;
                                int i15 = ((rect3.bottom - i14) / 2) + i14;
                                int i16 = rect4.top;
                                boolean z = Math.abs(i15 - (((rect4.bottom - i16) / 2) + i16)) <= Math.max(4, (int) (((float) iIntValue) * 0.45f));
                                if (iMin >= ((int) (iMax * 0.45f)) || z) {
                                    obj = objPrevious;
                                    break;
                                }
                            }
                        }
                    }
                    List list4 = (List) obj;
                    if (list4 == null) {
                        arrayList3.add(nz.k(gp1Var2));
                    } else {
                        list4.add(gp1Var2);
                    }
                }
                ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
                int size2 = arrayList3.size();
                int i17 = 0;
                while (i17 < size2) {
                    Object obj4 = arrayList3.get(i17);
                    i17++;
                    List listK = mz.K((List) obj4, new wp2(2));
                    String string3 = cs2.V(mz.C(listK, Padder.FALLBACK_PADDING_STRING, null, null, new xn2(3), 30)).toString();
                    ArrayList arrayList5 = new ArrayList(nz.d(listK));
                    Iterator it3 = listK.iterator();
                    while (it3.hasNext()) {
                        arrayList5.add(((gp1) it3.next()).b);
                    }
                    arrayList4.add(new vp2(string3, g(arrayList5), listK));
                }
                List listK2 = mz.K(arrayList4, new i2(22, new wp2(1)));
                if (!listK2.isEmpty()) {
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it4 = listK2.iterator();
                    int i18 = 0;
                    while (true) {
                        int i19 = 24;
                        if (!it4.hasNext()) {
                            int i20 = 0;
                            HashSet hashSet = new HashSet();
                            ArrayList arrayList7 = new ArrayList();
                            int size3 = arrayList6.size();
                            while (i20 < size3) {
                                Object obj5 = arrayList6.get(i20);
                                i20++;
                                hp1 hp1Var2 = (hp1) obj5;
                                Set set2 = cq2.a;
                                if (hashSet.add(new wt1(cq2.l(hp1Var2.a), Integer.valueOf(hp1Var2.d.top)))) {
                                    arrayList7.add(obj5);
                                }
                            }
                            return mz.K(arrayList7, new i2(i19, new wp2(4)));
                        }
                        Object next = it4.next();
                        int i21 = i18 + 1;
                        if (i18 < 0) {
                            nz.n();
                            throw null;
                        }
                        vp2 vp2Var3 = (vp2) next;
                        String str3 = vp2Var3.a;
                        String strE = e(str3);
                        if (strE == null) {
                            hp1Var = null;
                            i3 = iIntValue;
                            list2 = listK2;
                            it = it4;
                            i4 = i13;
                            i5 = i21;
                        } else if (c(str3)) {
                            i3 = iIntValue;
                            list2 = listK2;
                            it = it4;
                            i4 = i13;
                            i5 = i21;
                            hp1Var = null;
                        } else {
                            x42 x42Var = b;
                            if (x42Var.a(str3)) {
                                i3 = iIntValue;
                                list2 = listK2;
                                it = it4;
                                i4 = i13;
                                i5 = i21;
                            } else {
                                int iMax2 = Math.max(24, (int) (iIntValue * 3.6f));
                                List listSubList = listK2.subList(0, i18);
                                listSubList.getClass();
                                dh1 dh1Var = new dh1(listSubList);
                                ArrayList arrayList8 = new ArrayList();
                                Iterator it5 = dh1Var.iterator();
                                while (true) {
                                    ListIterator listIterator2 = (ListIterator) ((t72) it5).b;
                                    boolean zHasPrevious = listIterator2.hasPrevious();
                                    set = d;
                                    if (!zHasPrevious) {
                                        break;
                                    }
                                    Object objPrevious2 = listIterator2.previous();
                                    vp2 vp2Var4 = (vp2) objPrevious2;
                                    Rect rect5 = vp2Var3.b;
                                    List list5 = listK2;
                                    int i22 = rect5.top;
                                    Rect rect6 = vp2Var4.b;
                                    String str4 = vp2Var4.a;
                                    Iterator it6 = it4;
                                    int i23 = i22 - rect6.bottom;
                                    int i24 = i21;
                                    if ((-iIntValue) > i23 || i23 > iMax2) {
                                        i7 = iIntValue;
                                    } else {
                                        i7 = iIntValue;
                                        int iMin2 = Math.min(rect6.right, rect5.right) - Math.max(rect6.left, rect5.left);
                                        boolean z2 = Math.abs(rect6.left - rect5.left) <= Math.max(i7 * 3, 48);
                                        if ((iMin2 > 0 || z2) && e(str4) == null && !c(str4) && !x42Var.a(str4) && !set.contains(cq2.l(str4))) {
                                            arrayList8.add(objPrevious2);
                                        }
                                    }
                                    listK2 = list5;
                                    it4 = it6;
                                    i21 = i24;
                                    iIntValue = i7;
                                    i13 = 2;
                                }
                                i3 = iIntValue;
                                list2 = listK2;
                                it = it4;
                                i5 = i21;
                                List listL = mz.L(arrayList8, i13);
                                ArrayList arrayListF = f(str3);
                                int size4 = arrayListF.size();
                                int i25 = 0;
                                int i26 = 0;
                                while (true) {
                                    if (i25 >= size4) {
                                        i26 = -1;
                                        break;
                                    }
                                    Object obj6 = arrayListF.get(i25);
                                    i25++;
                                    String str5 = (String) obj6;
                                    if (js2.f(str5, "song") || js2.f(str5, "track")) {
                                        break;
                                    }
                                    i26++;
                                }
                                if (i26 < 0) {
                                    string = null;
                                } else {
                                    ArrayList arrayList9 = new ArrayList();
                                    int size5 = arrayListF.size();
                                    int i27 = 0;
                                    int i28 = 0;
                                    while (i28 < size5) {
                                        Object obj7 = arrayListF.get(i28);
                                        i28++;
                                        int i29 = i27 + 1;
                                        if (i27 < 0) {
                                            nz.n();
                                            throw null;
                                        }
                                        String str6 = (String) obj7;
                                        if (i27 != i26 && !c(str6) && !x42Var.a(str6) && !set.contains(cq2.l(str6))) {
                                            arrayList9.add(obj7);
                                        }
                                        i27 = i29;
                                    }
                                    string = cs2.V(cs2.G(cs2.G(mz.C(arrayList9, ", ", null, null, null, 62), "by "), "By ")).toString();
                                    if (cs2.A(string)) {
                                        string = null;
                                    }
                                }
                                if (string == null || cs2.A(string)) {
                                    i4 = 2;
                                    if (listL.size() >= 2) {
                                        i6 = 0;
                                        vp2Var2 = (vp2) listL.get(0);
                                        vp2Var = (vp2) listL.get(1);
                                        str = vp2Var2.a;
                                        if (set.contains(cq2.l(str))) {
                                            str = null;
                                        }
                                    } else {
                                        i6 = 0;
                                        vp2Var = (vp2) mz.y(listL);
                                        if (vp2Var != null) {
                                            vp2Var2 = null;
                                            str = null;
                                        }
                                    }
                                } else {
                                    vp2Var = (vp2) mz.y(listL);
                                    if (vp2Var == null) {
                                        hp1Var = null;
                                        i4 = 2;
                                    } else {
                                        vp2Var2 = null;
                                        str = string;
                                        i6 = 0;
                                        i4 = 2;
                                    }
                                }
                                String str7 = vp2Var.a;
                                if (!cs2.A(str7) && !set.contains(cq2.l(str7)) && !x42Var.a(str7)) {
                                    List listO = qg.o(new vp2[]{vp2Var, vp2Var2, vp2Var3});
                                    HashSet hashSet2 = new HashSet();
                                    ArrayList arrayList10 = new ArrayList();
                                    ArrayList arrayList11 = (ArrayList) listO;
                                    int size6 = arrayList11.size();
                                    int i30 = i6;
                                    while (i30 < size6) {
                                        Object obj8 = arrayList11.get(i30);
                                        i30++;
                                        vp2 vp2Var5 = (vp2) obj8;
                                        if (hashSet2.add(new wt1(vp2Var5.b, vp2Var5.a))) {
                                            arrayList10.add(obj8);
                                        }
                                    }
                                    ArrayList arrayList12 = new ArrayList(nz.d(arrayList10));
                                    int size7 = arrayList10.size();
                                    int i31 = i6;
                                    while (i31 < size7) {
                                        Object obj9 = arrayList10.get(i31);
                                        i31++;
                                        arrayList12.add(((vp2) obj9).b);
                                    }
                                    Rect rectG = g(arrayList12);
                                    int iMax3 = Math.max(20, i3 * 2);
                                    if (!list2.isEmpty()) {
                                        Iterator it7 = list2.iterator();
                                        while (true) {
                                            if (it7.hasNext()) {
                                                vp2 vp2Var6 = (vp2) it7.next();
                                                Set set3 = cq2.a;
                                                if (e.contains(cq2.l(vp2Var6.a))) {
                                                    Rect rect7 = vp2Var6.b;
                                                    if (rect7.bottom < rectG.top - iMax3 || rect7.top > rectG.bottom + iMax3) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    ArrayList arrayList13 = new ArrayList();
                                    int size8 = arrayList10.size();
                                    int i32 = i6;
                                    while (i32 < size8) {
                                        Object obj10 = arrayList10.get(i32);
                                        i32++;
                                        rz.q(((vp2) obj10).c, arrayList13);
                                    }
                                    ArrayList arrayList14 = new ArrayList(nz.d(arrayList13));
                                    int size9 = arrayList13.size();
                                    int i33 = i6;
                                    while (i33 < size9) {
                                        Object obj11 = arrayList13.get(i33);
                                        i33++;
                                        arrayList14.add(((gp1) obj11).b);
                                    }
                                    Rect rectG2 = g(arrayList14);
                                    String string4 = cs2.V(str7).toString();
                                    if (str == null || (string2 = cs2.V(str).toString()) == null) {
                                        str2 = null;
                                    } else {
                                        if (cs2.A(string2)) {
                                            string2 = null;
                                        }
                                        str2 = string2;
                                    }
                                    hp1Var = new hp1(string4, str2, strE, rectG2, arrayList13);
                                }
                            }
                            hp1Var = null;
                        }
                        if (hp1Var != null) {
                            arrayList6.add(hp1Var);
                        }
                        i13 = i4;
                        listK2 = list2;
                        it4 = it;
                        i18 = i5;
                        iIntValue = i3;
                    }
                }
            }
        }
        return ii0.a;
    }

    public static String e(String str) {
        ArrayList arrayListF = f(str);
        int i = 0;
        if (!arrayListF.isEmpty()) {
            int size = arrayListF.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListF.get(i2);
                i2++;
                if (js2.f((String) obj, "song")) {
                    return "Song";
                }
            }
        }
        if (arrayListF.isEmpty()) {
            return null;
        }
        int size2 = arrayListF.size();
        while (i < size2) {
            Object obj2 = arrayListF.get(i);
            i++;
            if (js2.f((String) obj2, "track")) {
                return "Track";
            }
        }
        return null;
    }

    public static ArrayList f(String str) {
        List listI = a.i(str);
        ArrayList arrayList = new ArrayList(nz.d(listI));
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(cs2.V((String) it.next()).toString());
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
        return arrayList2;
    }

    public static Rect g(ArrayList arrayList) {
        Rect rect = new Rect();
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            dk0.d();
            return null;
        }
        Integer numValueOf = Integer.valueOf(((Rect) it.next()).left);
        while (it.hasNext()) {
            Integer numValueOf2 = Integer.valueOf(((Rect) it.next()).left);
            if (numValueOf.compareTo(numValueOf2) > 0) {
                numValueOf = numValueOf2;
            }
        }
        rect.left = numValueOf.intValue();
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            dk0.d();
            return null;
        }
        Integer numValueOf3 = Integer.valueOf(((Rect) it2.next()).top);
        while (it2.hasNext()) {
            Integer numValueOf4 = Integer.valueOf(((Rect) it2.next()).top);
            if (numValueOf3.compareTo(numValueOf4) > 0) {
                numValueOf3 = numValueOf4;
            }
        }
        rect.top = numValueOf3.intValue();
        Iterator it3 = arrayList.iterator();
        if (!it3.hasNext()) {
            dk0.d();
            return null;
        }
        Integer numValueOf5 = Integer.valueOf(((Rect) it3.next()).right);
        while (it3.hasNext()) {
            Integer numValueOf6 = Integer.valueOf(((Rect) it3.next()).right);
            if (numValueOf5.compareTo(numValueOf6) < 0) {
                numValueOf5 = numValueOf6;
            }
        }
        rect.right = numValueOf5.intValue();
        Iterator it4 = arrayList.iterator();
        if (!it4.hasNext()) {
            dk0.d();
            return null;
        }
        Integer numValueOf7 = Integer.valueOf(((Rect) it4.next()).bottom);
        while (it4.hasNext()) {
            Integer numValueOf8 = Integer.valueOf(((Rect) it4.next()).bottom);
            if (numValueOf7.compareTo(numValueOf8) < 0) {
                numValueOf7 = numValueOf8;
            }
        }
        rect.bottom = numValueOf7.intValue();
        return rect;
    }
}
