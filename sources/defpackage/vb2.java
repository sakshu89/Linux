package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vb2 {
    public static final Set a = wh2.c("conversations_row_contact_name", "contactpicker_row_name", "search_contact_name", "search_result_contact_name", "chat_name", "conversation_name", "video_title", "title_text", "title", "result_title", "search_result_title", "shorts_title", "reel_title", "headline");

    public static ew2 a(String str, ArrayList arrayList, IdentityHashMap identityHashMap, String str2, List list) {
        String strK;
        ArrayList arrayList2;
        int i;
        Iterator it;
        String str3;
        String str4;
        Iterator it2;
        Rect rect;
        int i2;
        int i3;
        Iterator it3;
        Collection collection;
        Integer num;
        AccessibilityNodeInfo accessibilityNodeInfo;
        Rect rect2;
        int i4;
        int i5;
        ArrayList arrayList3 = arrayList;
        List list2 = dc2.e;
        dc2 dc2VarB = yz3.b(str);
        if (dc2VarB != null) {
            Integer num2 = dc2VarB.b;
            if (dc2VarB.a(str2)) {
                Set set = bc2.a;
                cc2 cc2Var = dc2VarB.a;
                boolean zA = dc2VarB.a(str2);
                String str5 = "com.google.android.youtube";
                Collection collectionC = ii0.a;
                if (zA && ((!g31.a(dc2VarB.d, "com.google.android.googlequicksearchbox") || !bc2.h(arrayList, identityHashMap, str2).isEmpty()) && (cc2Var != cc2.c || str2.equals("com.google.android.youtube")))) {
                    cc2 cc2VarS = bc2.s(cc2Var, str2);
                    boolean zEquals = str2.equals("com.google.android.youtube");
                    cc2 cc2Var2 = cc2.e;
                    boolean z = zEquals && cc2Var == cc2Var2 && num2 == null;
                    collectionC = bc2.c(cc2VarS, arrayList3, identityHashMap, bc2.t(cc2VarS, arrayList3, identityHashMap, str2, z), cc2VarS != cc2Var2 || bc2.h(arrayList, identityHashMap, str2).isEmpty(), z);
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator it4 = collectionC.iterator();
                while (true) {
                    int i6 = 12;
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) next;
                    Rect rectG = cq.g(accessibilityNodeInfo2);
                    if (collectionC.isEmpty()) {
                        it3 = it4;
                        collection = collectionC;
                        num = num2;
                        arrayList4.add(next);
                    } else {
                        Iterator it5 = collectionC.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) it5.next();
                                if (accessibilityNodeInfo3 != accessibilityNodeInfo2) {
                                    Object obj = identityHashMap.get(accessibilityNodeInfo2);
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 < i6) {
                                            Object obj2 = (AccessibilityNodeInfo) obj;
                                            if (obj2 != null) {
                                                if (obj2 == accessibilityNodeInfo3) {
                                                    Rect rectG2 = cq.g(accessibilityNodeInfo3);
                                                    int i8 = rectG.right;
                                                    int i9 = rectG.left;
                                                    if (i8 > i9) {
                                                        it3 = it4;
                                                        int i10 = rectG.bottom;
                                                        collection = collectionC;
                                                        int i11 = rectG.top;
                                                        num = num2;
                                                        if (i10 > i11) {
                                                            int i12 = rectG2.right;
                                                            accessibilityNodeInfo = accessibilityNodeInfo2;
                                                            int i13 = rectG2.left;
                                                            rect2 = rectG;
                                                            if (i12 <= i13 || (i4 = rectG2.bottom) <= (i5 = rectG2.top) || i9 < i13 || i11 < i5 || i8 > i12 || i10 > i4) {
                                                            }
                                                        }
                                                    }
                                                    accessibilityNodeInfo = accessibilityNodeInfo2;
                                                    rect2 = rectG;
                                                } else {
                                                    i7++;
                                                    obj = identityHashMap.get(obj2);
                                                    it4 = it4;
                                                    collectionC = collectionC;
                                                    i6 = 12;
                                                }
                                            }
                                        }
                                        it3 = it4;
                                        collection = collectionC;
                                        num = num2;
                                        accessibilityNodeInfo = accessibilityNodeInfo2;
                                        rect2 = rectG;
                                    }
                                } else {
                                    it3 = it4;
                                    collection = collectionC;
                                    num = num2;
                                    accessibilityNodeInfo = accessibilityNodeInfo2;
                                    rect2 = rectG;
                                }
                                it4 = it3;
                                collectionC = collection;
                                num2 = num;
                                accessibilityNodeInfo2 = accessibilityNodeInfo;
                                rectG = rect2;
                                i6 = 12;
                            } else {
                                it3 = it4;
                                collection = collectionC;
                                num = num2;
                                arrayList4.add(next);
                            }
                        }
                    }
                    it4 = it3;
                    collectionC = collection;
                    num2 = num;
                }
                Integer num3 = num2;
                List listK = mz.K(arrayList4, new i2(14, new lo0(24)));
                ArrayList arrayList5 = new ArrayList(nz.d(listK));
                Iterator it6 = listK.iterator();
                while (true) {
                    String str6 = "";
                    if (!it6.hasNext()) {
                        break;
                    }
                    AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) it6.next();
                    Rect rectG3 = cq.g(accessibilityNodeInfo4);
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it7 = list.iterator();
                    while (it7.hasNext()) {
                        Object next2 = it7.next();
                        gp1 gp1Var = (gp1) next2;
                        if (cs2.A(gp1Var.a) || (i2 = (rect = gp1Var.b).right) <= (i3 = rect.left)) {
                            it = it6;
                            str3 = str6;
                        } else {
                            it = it6;
                            int i14 = rect.bottom;
                            int i15 = rect.top;
                            str3 = str6;
                            if (i14 > i15) {
                                int i16 = rectG3.right;
                                it2 = it7;
                                int i17 = rectG3.left;
                                if (i16 > i17) {
                                    int i18 = rectG3.bottom;
                                    str4 = str5;
                                    int i19 = rectG3.top;
                                    if (i18 > i19 && i3 >= i17 && i15 >= i19 && i2 <= i16 && i14 <= i18) {
                                        arrayList6.add(next2);
                                    }
                                } else {
                                    str4 = str5;
                                }
                            }
                            it6 = it;
                            str6 = str3;
                            it7 = it2;
                            str5 = str4;
                        }
                        str4 = str5;
                        it2 = it7;
                        it6 = it;
                        str6 = str3;
                        it7 = it2;
                        str5 = str4;
                    }
                    Iterator it8 = it6;
                    String str7 = str6;
                    String str8 = str5;
                    ArrayList arrayList7 = new ArrayList();
                    int size = arrayList3.size();
                    int i20 = 0;
                    while (i20 < size) {
                        Object obj3 = arrayList3.get(i20);
                        i20++;
                        AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj3;
                        Object obj4 = identityHashMap.get(accessibilityNodeInfo5);
                        for (int i21 = 0; i21 < 12; i21++) {
                            Object obj5 = (AccessibilityNodeInfo) obj4;
                            if (obj5 == null) {
                                break;
                            }
                            if (obj5 == accessibilityNodeInfo4) {
                                String viewIdResourceName = accessibilityNodeInfo5.getViewIdResourceName();
                                if (viewIdResourceName == null) {
                                    viewIdResourceName = str7;
                                }
                                if (!a.contains(cs2.S(viewIdResourceName, '/'))) {
                                    break;
                                }
                                arrayList7.add(obj3);
                                break;
                            }
                            obj4 = identityHashMap.get(obj5);
                        }
                    }
                    ArrayList arrayList8 = new ArrayList(nz.d(arrayList7));
                    int size2 = arrayList7.size();
                    int i22 = 0;
                    while (i22 < size2) {
                        Object obj6 = arrayList7.get(i22);
                        i22++;
                        Rect rect3 = new Rect();
                        ((AccessibilityNodeInfo) obj6).getBoundsInScreen(rect3);
                        arrayList8.add(rect3);
                    }
                    ArrayList arrayList9 = new ArrayList();
                    int size3 = arrayList6.size();
                    int i23 = 0;
                    while (i23 < size3) {
                        Object obj7 = arrayList6.get(i23);
                        i23++;
                        gp1 gp1Var2 = (gp1) obj7;
                        if (arrayList8.isEmpty()) {
                            arrayList2 = arrayList8;
                            i = size3;
                            break;
                        }
                        int size4 = arrayList8.size();
                        int i24 = 0;
                        while (true) {
                            if (i24 >= size4) {
                                arrayList2 = arrayList8;
                                i = size3;
                                break;
                                break;
                            }
                            Object obj8 = arrayList8.get(i24);
                            i24++;
                            Rect rect4 = (Rect) obj8;
                            Rect rect5 = gp1Var2.b;
                            rect4.getClass();
                            arrayList2 = arrayList8;
                            i = size3;
                            if (Math.min(rect4.right, rect5.right) > Math.max(rect4.left, rect5.left) && Math.min(rect4.bottom, rect5.bottom) > Math.max(rect4.top, rect5.top)) {
                                arrayList9.add(obj7);
                                break;
                            }
                            arrayList8 = arrayList2;
                            size3 = i;
                        }
                        arrayList8 = arrayList2;
                        size3 = i;
                    }
                    List listK2 = mz.K(arrayList9, new i2(15, new lo0(25)));
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList10 = new ArrayList();
                    for (Object obj9 : listK2) {
                        gp1 gp1Var3 = (gp1) obj9;
                        String str9 = gp1Var3.a;
                        Rect rect6 = gp1Var3.b;
                        if (hashSet.add(str9 + ":" + rect6.top + ":" + rect6.left)) {
                            arrayList10.add(obj9);
                        }
                    }
                    String strC = mz.C(arrayList10, Padder.FALLBACK_PADDING_STRING, null, null, new sa2(20), 30);
                    if (cs2.A(strC)) {
                        strC = null;
                    }
                    arrayList5.add(new ub2(accessibilityNodeInfo4, strC));
                    arrayList3 = arrayList;
                    it6 = it8;
                    str5 = str8;
                }
                String str10 = str5;
                if (num3 != null) {
                    ub2 ub2Var = (ub2) mz.z(num3.intValue() - 1, arrayList5);
                    if (ub2Var != null) {
                        AccessibilityNodeInfo accessibilityNodeInfo6 = ub2Var.a;
                        String str11 = ub2Var.b;
                        if (str11 == null) {
                            str11 = str;
                        }
                        return new bw2(accessibilityNodeInfo6, str11, 0.9f, true);
                    }
                } else {
                    String str12 = dc2VarB.c;
                    String string = cs2.V(str12 == null ? "" : str12).toString();
                    Locale locale = Locale.ROOT;
                    String strO = cq.o(locale, string, locale);
                    Pattern patternCompile = Pattern.compile("\\s+");
                    patternCompile.getClass();
                    String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
                    strReplaceAll.getClass();
                    ArrayList arrayList11 = new ArrayList();
                    int size5 = arrayList5.size();
                    int i25 = 0;
                    while (i25 < size5) {
                        Object obj10 = arrayList5.get(i25);
                        i25++;
                        String str13 = ((ub2) obj10).b;
                        if (str13 != null) {
                            String string2 = cs2.V(str13).toString();
                            Locale locale2 = Locale.ROOT;
                            String strO2 = cq.o(locale2, string2, locale2);
                            Pattern patternCompile2 = Pattern.compile("\\s+");
                            patternCompile2.getClass();
                            String strReplaceAll2 = patternCompile2.matcher(strO2).replaceAll(Padder.FALLBACK_PADDING_STRING);
                            strReplaceAll2.getClass();
                            if (strReplaceAll2.equals(strReplaceAll)) {
                                arrayList11.add(obj10);
                            }
                        }
                    }
                    int size6 = arrayList11.size();
                    if (size6 != 0) {
                        if (size6 == 1) {
                            AccessibilityNodeInfo accessibilityNodeInfo7 = ((ub2) mz.H(arrayList11)).a;
                            String str14 = ((ub2) mz.H(arrayList11)).b;
                            str14.getClass();
                            return new bw2(accessibilityNodeInfo7, str14, 0.9f, true);
                        }
                        ArrayList arrayList12 = new ArrayList(nz.d(arrayList11));
                        int size7 = arrayList11.size();
                        int i26 = 0;
                        while (i26 < size7) {
                            Object obj11 = arrayList11.get(i26);
                            i26++;
                            ub2 ub2Var2 = (ub2) obj11;
                            String str15 = str10;
                            if (str2.equals(str15)) {
                                String str16 = ub2Var2.b;
                                Set set2 = bc2.a;
                                strK = cq.k(str16, " — ", bc2.m(ub2Var2.a, identityHashMap) ? "Short" : "Video");
                            } else {
                                strK = ub2Var2.b;
                                strK.getClass();
                            }
                            arrayList12.add(strK);
                            str10 = str15;
                        }
                        ArrayList arrayList13 = new ArrayList(nz.d(arrayList11));
                        int size8 = arrayList11.size();
                        int i27 = 0;
                        while (i27 < size8) {
                            Object obj12 = arrayList11.get(i27);
                            i27++;
                            arrayList13.add(((ub2) obj12).a);
                        }
                        return new zv2(arrayList12, arrayList13);
                    }
                }
            }
        }
        return dw2.a;
    }
}
