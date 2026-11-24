package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie2 {
    public static final x42 a = new x42("(?:(?:youtube|whatsapp|spotify|the|app)\\s+)?(?:search(?:\\s+(?:bar|box|field|button|icon|input))?|ask meta ai or search)(?:\\s+(?:in|on|of)\\s+(?:the\\s+)?(?:youtube|whatsapp|spotify|app|application|screen))?");
    public static final Set b = wh2.c("search", "search bar", "search box", "search field", "search input", "search button", "search icon", "खोजें", "खोज", "ढूंढें", "शोधा", "शोध", "सर्च", "meta ai से पूछें या खोजें", "meta ai ला विचारा किंवा शोधा", "meta ai से पूछें या सर्च करें");
    public static final Set c = wh2.c("chats", "people", "messages", "चैट", "चैट्स", "चॅट", "चॅट्स", "लोग", "लोक", "मैसेज", "संदेश");
    public static final x42 d = new x42("search (?:youtube|whatsapp|spotify|here|this app|for .+|in .+|apps(?: (?:&|and) games)?|chats|messages|contacts|music|songs|videos|people|products|or type (?:a |the )?(?:url|web address)|or enter (?:a |the )?(?:url|website name))");
    public static final x42 e = new x42("(?:.*_)?search_(?:src_text|edit_text|edittext|input|field|query|box|bar|button|view|holder|button_container|text)(?:_.*)?");
    public static final Set f = wh2.c("search", "menuitem_search", "menu_search", "action_search", "toolbar_search", "search_query", "search_src_text", "search_edit_frame", "search_container", "search_box", "search_bar", "search_input", "search_edit_text");
    public static final x42 g = new x42("(?:^|_)(?:voice|mic|clear|close|back|history|suggestion|suggestions|result|results|refine|fab|new_chat|start_chat)(?:_|$)");

    /* JADX WARN: Code duplicated, block: B:218:0x0364 A[PHI: r16 r19
      0x0364: PHI (r16v2 android.view.accessibility.AccessibilityNodeInfo) = 
      (r16v1 android.view.accessibility.AccessibilityNodeInfo)
      (r16v4 android.view.accessibility.AccessibilityNodeInfo)
      (r16v4 android.view.accessibility.AccessibilityNodeInfo)
     binds: [B:26:0x0051, B:217:0x0362, B:242:0x03a6] A[DONT_GENERATE, DONT_INLINE]
      0x0364: PHI (r19v1 int) = (r19v0 int), (r19v4 int), (r19v4 int) binds: [B:26:0x0051, B:217:0x0362, B:242:0x03a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x0109  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.util.IdentityHashMap] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v50 */
    public static List a(ArrayList arrayList, IdentityHashMap identityHashMap, boolean z) {
        Integer num;
        int i;
        AccessibilityNodeInfo accessibilityNodeInfo;
        Object wt1Var;
        boolean z2;
        boolean z3;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        boolean z4;
        boolean z5;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        int i2;
        int i3;
        AccessibilityNodeInfo accessibilityNodeInfo4;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj;
            if (!accessibilityNodeInfo5.isVisibleToUser() || !accessibilityNodeInfo5.isEnabled() || accessibilityNodeInfo5.isPassword() || b(accessibilityNodeInfo5)) {
                i = size;
                accessibilityNodeInfo = null;
                wt1Var = accessibilityNodeInfo;
            } else {
                Object obj2 = identityHashMap.get(accessibilityNodeInfo5);
                int i5 = 0;
                while (true) {
                    if (i5 >= 6 || (accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj2) == null || identityHashMap.get(accessibilityNodeInfo4) == null || h(accessibilityNodeInfo4)) {
                        boolean zG = g(accessibilityNodeInfo5);
                        if (!z || zG) {
                            boolean zC = c(accessibilityNodeInfo5);
                            Object obj3 = identityHashMap.get(accessibilityNodeInfo5);
                            for (int i6 = 0; i6 < 3; i6++) {
                                AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj3;
                                if (!zG || accessibilityNodeInfo6 == null || d(accessibilityNodeInfo6) || b(accessibilityNodeInfo6)) {
                                    obj3 = null;
                                } else {
                                    boolean z6 = zC || c(accessibilityNodeInfo6);
                                    obj3 = identityHashMap.get(accessibilityNodeInfo6);
                                    zC = z6;
                                }
                            }
                            if (!zG || zC) {
                                i = size;
                                z2 = false;
                                accessibilityNodeInfo = null;
                            } else {
                                Object obj4 = identityHashMap.get(accessibilityNodeInfo5);
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= 2 || (accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj4) == null || identityHashMap.get(accessibilityNodeInfo3) == null || d(accessibilityNodeInfo3) || b(accessibilityNodeInfo3)) {
                                        i = size;
                                        accessibilityNodeInfo = null;
                                        z3 = true;
                                        Set setC = wh2.c("com.whatsapp", "com.whatsapp.w4b");
                                        CharSequence packageName = accessibilityNodeInfo5.getPackageName();
                                        if (!mz.s(packageName != null ? packageName.toString() : null, setC) || wh2.c("entry", "message_entry", "compose_text", "caption").contains(m(accessibilityNodeInfo5))) {
                                            z2 = false;
                                        } else {
                                            Object obj5 = identityHashMap.get(accessibilityNodeInfo5);
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 >= 4 || (accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj5) == null || d(accessibilityNodeInfo2)) {
                                                    z2 = false;
                                                } else if (h(accessibilityNodeInfo2)) {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    int size2 = arrayList.size();
                                                    int i9 = 0;
                                                    while (i9 < size2) {
                                                        Object obj6 = arrayList.get(i9);
                                                        i9++;
                                                        Object obj7 = identityHashMap.get((AccessibilityNodeInfo) obj6);
                                                        for (int i10 = 0; i10 < 6; i10++) {
                                                            AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj7;
                                                            if (accessibilityNodeInfo7 == null) {
                                                                break;
                                                            }
                                                            if (accessibilityNodeInfo7 == accessibilityNodeInfo2) {
                                                                arrayList3.add(obj6);
                                                                break;
                                                            }
                                                            obj7 = identityHashMap.get(accessibilityNodeInfo7);
                                                        }
                                                    }
                                                    ArrayList arrayList4 = new ArrayList();
                                                    int size3 = arrayList3.size();
                                                    int i11 = 0;
                                                    while (i11 < size3) {
                                                        Object obj8 = arrayList3.get(i11);
                                                        i11++;
                                                        if (g((AccessibilityNodeInfo) obj8)) {
                                                            arrayList4.add(obj8);
                                                        }
                                                    }
                                                    boolean z7 = mz.I(arrayList4) == accessibilityNodeInfo5;
                                                    if (arrayList.isEmpty()) {
                                                        z4 = false;
                                                        break;
                                                    }
                                                    int size4 = arrayList.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        if (i12 >= size4) {
                                                            z4 = false;
                                                            break;
                                                        }
                                                        Object obj9 = arrayList.get(i12);
                                                        i12++;
                                                        AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj9;
                                                        if (accessibilityNodeInfo8.isVisibleToUser() && !accessibilityNodeInfo8.isClickable() && !g(accessibilityNodeInfo8)) {
                                                            CharSequence text = accessibilityNodeInfo8.getText();
                                                            String string = text != null ? text.toString() : null;
                                                            if (string == null) {
                                                                string = "";
                                                            }
                                                            if (c.contains(k(string))) {
                                                                z4 = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (c(accessibilityNodeInfo2)) {
                                                        z2 = false;
                                                    } else {
                                                        z2 = false;
                                                        if (!cs2.n(m(accessibilityNodeInfo2), "search", false)) {
                                                            z5 = false;
                                                        }
                                                        if (z7 || (!z5 && !z4)) {
                                                        }
                                                    }
                                                    z5 = true;
                                                    if (z7) {
                                                    }
                                                } else {
                                                    obj5 = identityHashMap.get(accessibilityNodeInfo2);
                                                    i8++;
                                                }
                                            }
                                        }
                                        zC = z2;
                                    } else {
                                        accessibilityNodeInfo = null;
                                        ArrayList arrayList5 = new ArrayList();
                                        int size5 = arrayList.size();
                                        int i13 = 0;
                                        while (i13 < size5) {
                                            Object obj10 = arrayList.get(i13);
                                            i13++;
                                            AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) obj10;
                                            if (accessibilityNodeInfo9 == accessibilityNodeInfo3 || identityHashMap.get(accessibilityNodeInfo9) == accessibilityNodeInfo3) {
                                                arrayList5.add(obj10);
                                            } else {
                                                AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) identityHashMap.get(accessibilityNodeInfo9);
                                                if ((accessibilityNodeInfo10 != null ? (AccessibilityNodeInfo) identityHashMap.get(accessibilityNodeInfo10) : null) == accessibilityNodeInfo3) {
                                                    arrayList5.add(obj10);
                                                }
                                            }
                                        }
                                        if (arrayList5.size() > 12) {
                                            i2 = size;
                                        } else {
                                            if (arrayList5.isEmpty()) {
                                                i3 = 0;
                                            } else {
                                                int size6 = arrayList5.size();
                                                i3 = 0;
                                                int i14 = 0;
                                                while (i14 < size6) {
                                                    Object obj11 = arrayList5.get(i14);
                                                    i14++;
                                                    if (g((AccessibilityNodeInfo) obj11) && (i3 = i3 + 1) < 0) {
                                                        nz.m();
                                                        throw null;
                                                    }
                                                }
                                            }
                                            if (i3 == 1) {
                                                if (!arrayList5.isEmpty()) {
                                                    int size7 = arrayList5.size();
                                                    int i15 = 0;
                                                    while (true) {
                                                        if (i15 < size7) {
                                                            Object obj12 = arrayList5.get(i15);
                                                            i15++;
                                                            AccessibilityNodeInfo accessibilityNodeInfo11 = (AccessibilityNodeInfo) obj12;
                                                            if (accessibilityNodeInfo11 != accessibilityNodeInfo5 && accessibilityNodeInfo11.isVisibleToUser() && accessibilityNodeInfo11.isEnabled()) {
                                                                if (accessibilityNodeInfo11.isClickable()) {
                                                                    i = size;
                                                                } else {
                                                                    List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo11.getActionList();
                                                                    actionList.getClass();
                                                                    if (!actionList.isEmpty()) {
                                                                        Iterator it = actionList.iterator();
                                                                        while (true) {
                                                                            if (it.hasNext()) {
                                                                                i = size;
                                                                                if (((AccessibilityNodeInfo.AccessibilityAction) it.next()).getId() != 16) {
                                                                                    size = i;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    i = size;
                                                                }
                                                                if (wh2.c("search_close_btn", "clear_search", "clear_search_query", "search_clear_button").contains(m(accessibilityNodeInfo11))) {
                                                                    z3 = true;
                                                                } else {
                                                                    z3 = true;
                                                                    Iterator it2 = zg2.g(accessibilityNodeInfo11.getText(), accessibilityNodeInfo11.getContentDescription()).iterator();
                                                                    while (true) {
                                                                        if (it2.hasNext()) {
                                                                            CharSequence charSequence = (CharSequence) it2.next();
                                                                            Set setC2 = wh2.c("clear search", "clear search query", "clear search text");
                                                                            String string2 = charSequence != null ? charSequence.toString() : null;
                                                                            if (string2 == null) {
                                                                                string2 = "";
                                                                            }
                                                                            if (setC2.contains(k(string2))) {
                                                                            }
                                                                        } else {
                                                                            continue;
                                                                        }
                                                                    }
                                                                }
                                                                z2 = false;
                                                            } else {
                                                                i = size;
                                                            }
                                                            size = i;
                                                            size7 = size7;
                                                        }
                                                    }
                                                }
                                                i2 = size;
                                            } else {
                                                i2 = size;
                                            }
                                        }
                                        obj4 = identityHashMap.get(accessibilityNodeInfo3);
                                        i7++;
                                        size = i2;
                                    }
                                    zC = z3;
                                }
                            }
                            if (zC) {
                                if (!zG) {
                                    Object obj13 = accessibilityNodeInfo5;
                                    var r3 = z2;
                                    while (true) {
                                        if (r3 < 4) {
                                            AccessibilityNodeInfo accessibilityNodeInfo12 = (AccessibilityNodeInfo) obj13;
                                            if (accessibilityNodeInfo12 != null && !d(accessibilityNodeInfo12) && (accessibilityNodeInfo12 == accessibilityNodeInfo5 || identityHashMap.get(accessibilityNodeInfo12) != null)) {
                                                if (accessibilityNodeInfo12.isClickable() && accessibilityNodeInfo12.isVisibleToUser() && accessibilityNodeInfo12.isEnabled() && !b(accessibilityNodeInfo12)) {
                                                    accessibilityNodeInfo5 = accessibilityNodeInfo12;
                                                    break;
                                                }
                                                obj13 = identityHashMap.get(accessibilityNodeInfo12);
                                                r3++;
                                            }
                                        }
                                        accessibilityNodeInfo5 = accessibilityNodeInfo;
                                        break;
                                    }
                                    if (accessibilityNodeInfo5 == null) {
                                        wt1Var = accessibilityNodeInfo;
                                    }
                                }
                                wt1Var = new wt1(accessibilityNodeInfo5, Integer.valueOf(zG ? 100 : 80));
                            } else {
                                wt1Var = accessibilityNodeInfo;
                            }
                        } else {
                            i = size;
                            wt1Var = null;
                        }
                    } else if (b(accessibilityNodeInfo4)) {
                        i = size;
                        accessibilityNodeInfo = null;
                        wt1Var = accessibilityNodeInfo;
                    } else {
                        obj2 = identityHashMap.get(accessibilityNodeInfo4);
                        i5++;
                    }
                }
            }
            if (wt1Var != null) {
                arrayList2.add(wt1Var);
            }
            size = i;
        }
        Iterator it3 = arrayList2.iterator();
        if (it3.hasNext()) {
            Integer numValueOf = Integer.valueOf(((Number) ((wt1) it3.next()).b).intValue());
            loop17: while (true) {
                num = numValueOf;
                do {
                    if (!it3.hasNext()) {
                        break loop17;
                    }
                    numValueOf = Integer.valueOf(((Number) ((wt1) it3.next()).b).intValue());
                } while (num.compareTo(numValueOf) >= 0);
            }
        } else {
            num = null;
        }
        if (num == null) {
            return ii0.a;
        }
        int iIntValue = num.intValue();
        ArrayList arrayList6 = new ArrayList();
        int size8 = arrayList2.size();
        int i16 = 0;
        while (i16 < size8) {
            Object obj14 = arrayList2.get(i16);
            i16++;
            if (((Number) ((wt1) obj14).b).intValue() == iIntValue) {
                arrayList6.add(obj14);
            }
        }
        ArrayList arrayList7 = new ArrayList(nz.d(arrayList6));
        int size9 = arrayList6.size();
        int i17 = 0;
        while (i17 < size9) {
            Object obj15 = arrayList6.get(i17);
            i17++;
            arrayList7.add((AccessibilityNodeInfo) ((wt1) obj15).a);
        }
        return mz.t(arrayList7);
    }

    public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (g.a(m(accessibilityNodeInfo))) {
            return true;
        }
        for (CharSequence charSequence : n(accessibilityNodeInfo)) {
            String string = charSequence != null ? charSequence.toString() : null;
            if (string == null) {
                string = "";
            }
            String strK = k(string);
            if (cs2.n(strK, "voice search", false) || cs2.n(strK, "search by voice", false) || cs2.n(strK, "search history", false) || cs2.n(strK, "search results", false) || cs2.n(strK, "clear search", false) || cs2.n(strK, "close search", false)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strM = m(accessibilityNodeInfo);
        if (f.contains(strM) || e.e(strM)) {
            return true;
        }
        for (CharSequence charSequence : n(accessibilityNodeInfo)) {
            if (charSequence != null && e(charSequence.toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence className = accessibilityNodeInfo.getClassName();
        String string = className != null ? className.toString() : null;
        if (string == null) {
            string = "";
        }
        return accessibilityNodeInfo.isScrollable() || cs2.n(string, "RecyclerView", false) || cs2.n(string, "ListView", false) || cs2.n(string, "ScrollView", false) || cs2.n(string, "ViewPager", false);
    }

    public static boolean e(String str) {
        str.getClass();
        String strK = k(str);
        return b.contains(strK) || strK.equals("ask meta ai or search") || d.e(strK);
    }

    public static boolean f(String str) {
        str.getClass();
        return a.e(k(str));
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence className;
        String string;
        accessibilityNodeInfo.getClass();
        if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && !accessibilityNodeInfo.isPassword()) {
            if (!accessibilityNodeInfo.isEditable() && ((className = accessibilityNodeInfo.getClassName()) == null || (string = className.toString()) == null || !cs2.n(string, "EditText", false))) {
                List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
                actionList.getClass();
                if (!actionList.isEmpty()) {
                    Iterator<T> it = actionList.iterator();
                    while (it.hasNext()) {
                        if (((AccessibilityNodeInfo.AccessibilityAction) it.next()).getId() == 2097152) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence className = accessibilityNodeInfo.getClassName();
        return !(className == null || (string = className.toString()) == null || !js2.e(string, "Toolbar", false)) || wh2.c("toolbar", "search_toolbar", "search_action_bar", "action_bar").contains(m(accessibilityNodeInfo));
    }

    public static String i(AccessibilityNodeInfo accessibilityNodeInfo) {
        Object next;
        accessibilityNodeInfo.getClass();
        ul0 ul0Var = new ul0(zg2.f(zg2.g(accessibilityNodeInfo.getHintText(), accessibilityNodeInfo.getContentDescription(), accessibilityNodeInfo.getText()), new sa2(23)));
        do {
            if (!ul0Var.hasNext()) {
                next = null;
                break;
            }
            next = ul0Var.next();
        } while (!e((String) next));
        String str = (String) next;
        return str == null ? "Search" : str;
    }

    public static boolean j(String str, String str2) {
        if (str == null || str.equals(str2)) {
            return true;
        }
        return str.equals("com.whatsapp") && g31.a(str2, "com.whatsapp.w4b");
    }

    public static String k(String str) {
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        String strY = cs2.Y(cq.o(locale, string, locale), '.', 8230, '?');
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        strY.getClass();
        String strReplaceAll = patternCompile.matcher(strY).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public static String l(String str) {
        String strK = k(str);
        Pattern patternCompile = Pattern.compile("\\bwhatsapp\\b");
        patternCompile.getClass();
        if (patternCompile.matcher(strK).find()) {
            return "com.whatsapp";
        }
        Pattern patternCompile2 = Pattern.compile("\\byoutube\\b");
        patternCompile2.getClass();
        if (patternCompile2.matcher(strK).find()) {
            return "com.google.android.youtube";
        }
        Pattern patternCompile3 = Pattern.compile("\\bspotify\\b");
        patternCompile3.getClass();
        if (patternCompile3.matcher(strK).find()) {
            return "com.spotify.music";
        }
        return null;
    }

    public static String m(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strO;
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (viewIdResourceName != null) {
            String strS = cs2.S(viewIdResourceName, '/');
            Locale locale = Locale.ROOT;
            strO = cq.o(locale, strS, locale);
        } else {
            strO = null;
        }
        return strO == null ? "" : strO;
    }

    public static xg2 n(AccessibilityNodeInfo accessibilityNodeInfo) {
        return (!g(accessibilityNodeInfo) || accessibilityNodeInfo.isShowingHintText()) ? zg2.g(accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription(), accessibilityNodeInfo.getHintText()) : zg2.g(accessibilityNodeInfo.getHintText(), accessibilityNodeInfo.getContentDescription());
    }
}
