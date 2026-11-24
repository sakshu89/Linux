package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bc2 {
    public static final Set a = wh2.c("conversations_row_contact_name", "contactpicker_row_name", "search_contact_name", "search_result_contact_name", "chat_name", "conversation_name");
    public static final Set b = wh2.c("chats", "people", "चैट", "चैट्स", "चॅट", "चॅट्स", "लोग", "लोक");
    public static final Set c = wh2.c("messages", "media", "photos", "videos", "links", "documents", "संदेश", "मैसेज", "मीडिया", "फोटो", "वीडियो", "व्हिडिओ", "दस्तावेज़", "कागदपत्रे");
    public static final x42 d = new x42("(?:conversations?_row|contact_row_container|contactpicker_row|contact_picker_row|chat_row|search_contact|search_result_conversation)");
    public static final x42 e = new x42("(?:search_message|search_result_message|message_search|fts_message|message_row|message_bubble)");
    public static final x42 f = new x42("(?:^|_)(?:filter|filters|chip|chips|tab|tabs|toolbar|fab|suggestion|suggestions|history|new_chat|start_chat|navigation)(?:_|$)");
    public static final x42 g = new x42("(?:playlist|channel_renderer|promoted|sponsored|ad_container|ad_renderer|reel_watch|shorts_player)");
    public static final x42 h = new x42("(?:floaty_bar_(?:time_bar_view|controls_view)|modern_miniplayer(?:_.*)?|watch_player|player_overlays)");
    public static final x42 i = new x42("(?:video_renderer|video_card|video_result|video_item)");
    public static final x42 j = new x42("(?:shorts_(?:card|item|renderer)|reel_item_renderer|reel_video_renderer)");
    public static final x42 k = new x42("(?:^|_)(?:shorts|reel)(?:_|$)");
    public static final x42 l;
    public static final x42 m;
    public static final x42 n;
    public static final Set o;
    public static final Set p;
    public static final Set q;
    public static final x42 r;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        l = new x42("(?:^|[–—-]\\s*|\\.\\s+)play\\s+short(?:s)?[.!]?\\s*$", y42Var);
        m = new x42("(?:search_result_(?:row|item|title)|result_(?:row|item|title)|search_result$)");
        n = new x42("\\b(?:\\d+(?::\\d{2}){1,2}|\\d+\\s+(?:minutes?|seconds?|hours?))\\b", y42Var);
        o = wh2.c("google.com", "www.google.com", "google.co.in", "www.google.co.in", "google.co.uk", "www.google.co.uk", "google.ca", "www.google.ca", "google.com.au", "www.google.com.au");
        p = wh2.c("all", "images", "videos", "news", "maps", "shopping", "books", "flights", "finance", "more", "next", "previous", "sign in", "settings", "tools");
        q = wh2.c("ad", "ads", "sponsored", "advertisement", "people also ask", "people also search for", "related searches", "related results", "more to ask", "ai overview");
        r = new x42("(?:^|_)(?:ads|ad|sponsored|related|navigation|people_also_ask)(?:_|$)");
    }

    public static ArrayList a(AccessibilityNodeInfo accessibilityNodeInfo, Map map) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ArrayList arrayList = new ArrayList();
        Object obj = map.get(accessibilityNodeInfo);
        for (int i2 = 0; i2 < 8 && (accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj) != null && map.get(accessibilityNodeInfo2) != null; i2++) {
            arrayList.add(accessibilityNodeInfo2);
            obj = map.get(accessibilityNodeInfo2);
        }
        return arrayList;
    }

    public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence className = accessibilityNodeInfo.getClassName();
        String string = className != null ? className.toString() : null;
        if (string == null) {
            string = "";
        }
        AccessibilityNodeInfo.CollectionInfo collectionInfo = accessibilityNodeInfo.getCollectionInfo();
        if (accessibilityNodeInfo.isScrollable()) {
            return true;
        }
        return (collectionInfo != null && (collectionInfo.getRowCount() > 0 || collectionInfo.getColumnCount() > 0)) || cs2.n(string, "RecyclerView", false) || cs2.n(string, "ListView", false) || cs2.n(string, "ScrollView", false) || cs2.n(string, "ViewPager", false);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    public static List c(cc2 cc2Var, ArrayList arrayList, IdentityHashMap identityHashMap, ArrayList arrayList2, boolean z, boolean z2) {
        Collection collection;
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                if (identityHashMap.get(accessibilityNodeInfo) != null && f(accessibilityNodeInfo) && accessibilityNodeInfo.isClickable()) {
                    boolean zA = true;
                    boolean z3 = cc2Var == cc2.a;
                    cc2 cc2Var2 = cc2.c;
                    if (g(accessibilityNodeInfo, identityHashMap, z3, cc2Var == cc2Var2 || z2)) {
                        continue;
                    } else {
                        int iOrdinal = cc2Var.ordinal();
                        if (iOrdinal != 0) {
                            x42 x42Var = j;
                            if (iOrdinal != 1) {
                                if (iOrdinal == 2) {
                                    zA = x42Var.a(k(accessibilityNodeInfo));
                                } else {
                                    if (iOrdinal != 3) {
                                        dk0.l();
                                        return null;
                                    }
                                    if (!m.a(k(accessibilityNodeInfo)) && !l(accessibilityNodeInfo) && !n(accessibilityNodeInfo, identityHashMap)) {
                                        zA = false;
                                    }
                                }
                            } else if ((!i.a(k(accessibilityNodeInfo)) || m(accessibilityNodeInfo, identityHashMap)) && (!z2 || !x42Var.a(k(accessibilityNodeInfo)))) {
                                zA = false;
                            }
                        } else {
                            zA = d.a(k(accessibilityNodeInfo));
                        }
                        if (zA && (!wh2.c(cc2.b, cc2Var2).contains(cc2Var) || !j(accessibilityNodeInfo, arrayList, identityHashMap))) {
                            arrayList3.add(obj);
                        }
                    }
                }
            }
            collection = arrayList3;
        } else {
            collection = ii0.a;
        }
        ArrayList arrayList4 = new ArrayList(nz.d(arrayList2));
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            arrayList4.add(((zb2) obj2).b);
        }
        List listT = mz.t(mz.G(collection, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : listT) {
            Rect rect = new Rect();
            ((AccessibilityNodeInfo) obj3).getBoundsInScreen(rect);
            if (i(rect)) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        int size3 = arrayList5.size();
        int i4 = 0;
        while (i4 < size3) {
            Object obj4 = arrayList5.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj4;
            if (!arrayList5.isEmpty()) {
                int size4 = arrayList5.size();
                int i5 = 0;
                while (true) {
                    if (i5 < size4) {
                        Object obj5 = arrayList5.get(i5);
                        i5++;
                        AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj5;
                        if (accessibilityNodeInfo3 != accessibilityNodeInfo2 && d(accessibilityNodeInfo3, accessibilityNodeInfo2, identityHashMap)) {
                            break;
                        }
                    }
                }
            }
            arrayList6.add(obj4);
        }
        return mz.K(arrayList6, new i2(17, new lo0(27)));
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, IdentityHashMap identityHashMap) {
        ArrayList arrayListA = a(accessibilityNodeInfo2, identityHashMap);
        if (!arrayListA.isEmpty()) {
            int size = arrayListA.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListA.get(i2);
                i2++;
                if (((AccessibilityNodeInfo) obj) == accessibilityNodeInfo) {
                    Rect rectG = cq.g(accessibilityNodeInfo);
                    Rect rectG2 = cq.g(accessibilityNodeInfo2);
                    if (rectG.left > rectG2.left || rectG.top > rectG2.top || rectG.right < rectG2.right || rectG.bottom < rectG2.bottom) {
                        break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static AccessibilityNodeInfo e(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        Object obj;
        ArrayList arrayListG = mz.G(nz.h(accessibilityNodeInfo), a(accessibilityNodeInfo, identityHashMap));
        ArrayList arrayList = new ArrayList();
        int size = arrayListG.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayListG.get(i3);
            i3++;
            if (b((AccessibilityNodeInfo) obj2)) {
                break;
            }
            arrayList.add(obj2);
        }
        int size2 = arrayList.size();
        while (i2 < size2) {
            obj = arrayList.get(i2);
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (!b(accessibilityNodeInfo2) && identityHashMap.get(accessibilityNodeInfo2) != null && accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && accessibilityNodeInfo2.isClickable()) {
                return (AccessibilityNodeInfo) obj;
            }
        }
        obj = null;
        return (AccessibilityNodeInfo) obj;
    }

    public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return (!accessibilityNodeInfo.isVisibleToUser() || !accessibilityNodeInfo.isEnabled() || accessibilityNodeInfo.isPassword() || ie2.g(accessibilityNodeInfo) || b(accessibilityNodeInfo)) ? false : true;
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap, boolean z, boolean z2) {
        ArrayList arrayListG = mz.G(nz.h(accessibilityNodeInfo), a(accessibilityNodeInfo, identityHashMap));
        ArrayList arrayList = new ArrayList();
        int size = arrayListG.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayListG.get(i2);
            i2++;
            if (b((AccessibilityNodeInfo) obj)) {
                break;
            }
            arrayList.add(obj);
        }
        if (!arrayList.isEmpty()) {
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                String strK = k(accessibilityNodeInfo2);
                CharSequence className = accessibilityNodeInfo2.getClassName();
                String string = className != null ? className.toString() : null;
                if (string == null) {
                    string = "";
                }
                if (f.a(strK) || wh2.c("header", "section_header", "results_header", "list_header").contains(strK) || js2.e(string, "Chip", false) || js2.e(string, "TabView", false) || cs2.n(string, "TabLayout", false)) {
                    return true;
                }
                if (z && e.a(strK)) {
                    return true;
                }
                if (!z) {
                    if (g.a(strK)) {
                        return true;
                    }
                    if (!z2) {
                        if (k.a(strK)) {
                            return true;
                        }
                        CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                        String string2 = contentDescription != null ? contentDescription.toString() : null;
                        if (string2 == null) {
                            string2 = "";
                        }
                        if (l.a(string2)) {
                            return true;
                        }
                    }
                    if (h.e(strK) || js2.e(string, "SeekBar", false)) {
                        return true;
                    }
                    Pattern patternCompile = Pattern.compile("\\b(?:sponsored|advertisement)\\b", 66);
                    patternCompile.getClass();
                    CharSequence text = accessibilityNodeInfo2.getText();
                    String string3 = text != null ? text.toString() : null;
                    if (string3 == null) {
                        string3 = "";
                    }
                    CharSequence contentDescription2 = accessibilityNodeInfo2.getContentDescription();
                    String string4 = contentDescription2 != null ? contentDescription2.toString() : null;
                    if (patternCompile.matcher(string3 + Padder.FALLBACK_PADDING_STRING + (string4 != null ? string4 : "")).find()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x011c  */
    public static Set h(ArrayList arrayList, IdentityHashMap identityHashMap, String str) {
        Object h72Var;
        if (!dc2.g.contains(str)) {
            return mi0.a;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled()) {
                CharSequence packageName = accessibilityNodeInfo.getPackageName();
                String lowerCase = null;
                if (g31.a(packageName != null ? packageName.toString() : null, str) && g31.a(accessibilityNodeInfo.getViewIdResourceName(), str.concat(":id/url_bar"))) {
                    List listP = p(accessibilityNodeInfo, identityHashMap);
                    if (!listP.isEmpty()) {
                        Iterator it = listP.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (o((AccessibilityNodeInfo) it.next())) {
                                }
                            }
                        }
                    }
                    CharSequence text = accessibilityNodeInfo.getText();
                    String string = text != null ? text.toString() : null;
                    String str2 = "";
                    if (string == null) {
                        string = "";
                    }
                    try {
                        String string2 = cs2.V(string).toString();
                        boolean z = true;
                        if (!js2.k(string2, "https://", true)) {
                            string2 = "https://".concat(string2);
                        }
                        URI uri = new URI(string2);
                        if (!js2.f(uri.getScheme(), "https") || uri.getUserInfo() != null || uri.getPort() != -1) {
                            z = false;
                            break;
                        }
                        Set set = o;
                        String host = uri.getHost();
                        if (host != null) {
                            Locale locale = Locale.ROOT;
                            locale.getClass();
                            lowerCase = host.toLowerCase(locale);
                            lowerCase.getClass();
                        }
                        if (!mz.s(lowerCase, set) || !g31.a(uri.getPath(), "/search")) {
                            z = false;
                            break;
                        }
                        String rawQuery = uri.getRawQuery();
                        if (rawQuery != null) {
                            str2 = rawQuery;
                        }
                        List listN = cs2.N(str2, new char[]{'&'}, 6);
                        if (!listN.isEmpty()) {
                            Iterator it2 = listN.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    String str3 = (String) it2.next();
                                    if (js2.k(str3, "q=", false) && str3.length() > 2) {
                                        break;
                                    }
                                }
                            }
                        }
                        z = false;
                        break;
                        h72Var = Boolean.valueOf(z);
                    } catch (Throwable th) {
                        h72Var = new h72(th);
                    }
                    Object obj2 = Boolean.FALSE;
                    if (h72Var instanceof h72) {
                        h72Var = obj2;
                    }
                    if (((Boolean) h72Var).booleanValue()) {
                        arrayList2.add(obj);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        while (i2 < size2) {
            Object obj3 = arrayList2.get(i2);
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) mz.E(p((AccessibilityNodeInfo) obj3, identityHashMap));
            if (accessibilityNodeInfo2 != null) {
                arrayList3.add(accessibilityNodeInfo2);
            }
        }
        return mz.Q(arrayList3);
    }

    public static boolean i(Rect rect) {
        return rect.right > rect.left && rect.bottom > rect.top;
    }

    public static boolean j(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, IdentityHashMap identityHashMap) {
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                ArrayList arrayListA = a(accessibilityNodeInfo2, identityHashMap);
                if (!arrayListA.isEmpty()) {
                    int size2 = arrayListA.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        Object obj2 = arrayListA.get(i3);
                        i3++;
                        if (((AccessibilityNodeInfo) obj2) == accessibilityNodeInfo) {
                            Set setC = wh2.c("ad", "sponsored", "advertisement");
                            CharSequence text = accessibilityNodeInfo2.getText();
                            String string = text != null ? text.toString() : null;
                            if (string == null) {
                                string = "";
                            }
                            if (!setC.contains(q(string))) {
                                break;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String k(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    public static boolean l(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = accessibilityNodeInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return collectionItemInfo.getRowSpan() > 0 || collectionItemInfo.getColumnSpan() > 0;
        }
        return false;
    }

    public static boolean m(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        ArrayList arrayListG = mz.G(nz.h(accessibilityNodeInfo), a(accessibilityNodeInfo, identityHashMap));
        if (!arrayListG.isEmpty()) {
            int size = arrayListG.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListG.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                if (k.a(k(accessibilityNodeInfo2))) {
                    return true;
                }
                CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                String string = contentDescription != null ? contentDescription.toString() : null;
                if (string == null) {
                    string = "";
                }
                if (l.a(string)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        if (g31.a(accessibilityNodeInfo.getViewIdResourceName(), "com.spotify.music:id/row_root")) {
            ArrayList arrayListA = a(accessibilityNodeInfo, identityHashMap);
            if (!arrayListA.isEmpty()) {
                int size = arrayListA.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayListA.get(i2);
                    i2++;
                    if (g31.a(((AccessibilityNodeInfo) obj).getViewIdResourceName(), "com.spotify.music:id/search_content_recyclerview")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean o(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence className = accessibilityNodeInfo.getClassName();
        return g31.a(className != null ? className.toString() : null, "android.webkit.WebView");
    }

    public static List p(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        Object obj = accessibilityNodeInfo;
        loop0: while (i2 < 40) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2 == null) {
                return arrayList;
            }
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (((AccessibilityNodeInfo) obj2) == accessibilityNodeInfo2) {
                        break loop0;
                    }
                }
            }
            arrayList.add(accessibilityNodeInfo2);
            i2++;
            obj = identityHashMap.get(accessibilityNodeInfo2);
        }
        return ii0.a;
    }

    public static String q(String str) {
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        return cq.o(locale, string, locale);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0206, code lost:
    
        if (r1 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if (r16.equals("com.whatsapp") == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        if (r16.equals("com.whatsapp.w4b") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        r3 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.ew2 r(java.lang.String r13, java.util.ArrayList r14, java.util.IdentityHashMap r15, java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bc2.r(java.lang.String, java.util.ArrayList, java.util.IdentityHashMap, java.lang.String):ew2");
    }

    public static cc2 s(cc2 cc2Var, String str) {
        cc2 cc2Var2 = cc2.e;
        if (cc2Var != cc2Var2) {
            return cc2Var;
        }
        if (js2.k(str, "com.whatsapp", false)) {
            return cc2.a;
        }
        return str.equals("com.google.android.youtube") ? cc2.b : cc2Var2;
    }

    /* JADX WARN: Code duplicated, block: B:190:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:272:0x047f A[PHI: r7 r17 r18 r25 r26
      0x047f: PHI (r7v36 char) = (r7v35 char), (r7v46 char), (r7v48 char), (r7v53 char) binds: [B:275:0x0494, B:187:0x02eb, B:271:0x047d, B:464:0x047f] A[DONT_GENERATE, DONT_INLINE]
      0x047f: PHI (r17v5 int) = (r7v34 int), (r17v9 int), (r17v10 int), (r17v10 int) binds: [B:275:0x0494, B:187:0x02eb, B:271:0x047d, B:464:0x047f] A[DONT_GENERATE, DONT_INLINE]
      0x047f: PHI (r18v2 boolean) = (r18v1 boolean), (r18v5 boolean), (r18v5 boolean), (r18v5 boolean) binds: [B:275:0x0494, B:187:0x02eb, B:271:0x047d, B:464:0x047f] A[DONT_GENERATE, DONT_INLINE]
      0x047f: PHI (r25v2 java.util.ArrayList) = (r4v8 java.util.ArrayList), (r25v5 java.util.ArrayList), (r25v7 java.util.ArrayList), (r25v8 java.util.ArrayList) binds: [B:275:0x0494, B:187:0x02eb, B:271:0x047d, B:464:0x047f] A[DONT_GENERATE, DONT_INLINE]
      0x047f: PHI (r26v4 java.lang.String) = (r6v8 java.lang.String), (r26v7 java.lang.String), (r26v9 java.lang.String), (r26v10 java.lang.String) binds: [B:275:0x0494, B:187:0x02eb, B:271:0x047d, B:464:0x047f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:273:0x0482  */
    /* JADX WARN: Code duplicated, block: B:298:0x051d  */
    /* JADX WARN: Code duplicated, block: B:311:0x054e  */
    /* JADX WARN: Code duplicated, block: B:393:0x0685  */
    /* JADX WARN: Code duplicated, block: B:465:0x030e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v129 */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v90, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r29v0, types: [java.util.IdentityHashMap, java.util.Map] */
    public static ArrayList t(cc2 cc2Var, ArrayList arrayList, IdentityHashMap identityHashMap, String str, boolean z) {
        ArrayList arrayListG;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        zb2 zb2Var;
        boolean z2;
        AccessibilityNodeInfo accessibilityNodeInfoE;
        String string;
        zb2 zb2Var2;
        Object obj;
        boolean z3;
        boolean z4;
        AccessibilityNodeInfo accessibilityNodeInfoE2;
        String string2;
        String string3;
        boolean z5;
        char c2;
        zb2 zb2Var3;
        Object obj2;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        int size;
        int i2;
        Rect rectG;
        AccessibilityNodeInfo accessibilityNodeInfo4;
        ArrayList arrayList2;
        String str2;
        String string4;
        String string5;
        Object h72Var;
        Object h72Var2;
        Object BooleanValue;
        String string6;
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        Object h72Var3;
        boolean zIsHeading;
        int iOrdinal = cc2Var.ordinal();
        String str3 = "";
        int i3 = 0;
        boolean z6 = true;
        if (iOrdinal == 0) {
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj3 = arrayList.get(i4);
                i4++;
                AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj3;
                if (!f(accessibilityNodeInfo5) || g(accessibilityNodeInfo5, identityHashMap, true, false)) {
                    zb2Var = null;
                } else {
                    String strK = k(accessibilityNodeInfo5);
                    ArrayList arrayListA = a(accessibilityNodeInfo5, identityHashMap);
                    boolean z7 = a.contains(strK) || js2.e(strK, "conversations_row_contact_name", false);
                    if (arrayListA.isEmpty()) {
                        z2 = false;
                        break;
                    }
                    int size3 = arrayListA.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size3) {
                            z2 = false;
                            break;
                        }
                        Object obj4 = arrayListA.get(i5);
                        i5++;
                        if (d.a(k((AccessibilityNodeInfo) obj4))) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z7 || (wh2.c("name", "title", "contact_name", "display_name").contains(strK) && z2)) {
                        CharSequence text = accessibilityNodeInfo5.getText();
                        String string7 = (text == null || (string = text.toString()) == null) ? null : cs2.V(string).toString();
                        String str4 = string7 == null ? "" : string7;
                        if (cs2.A(str4) || (accessibilityNodeInfoE = e(accessibilityNodeInfo5, identityHashMap)) == null) {
                            zb2Var = null;
                        } else {
                            Rect rectG2 = cq.g(accessibilityNodeInfo5);
                            if (i(rectG2)) {
                                zb2Var = new zb2(accessibilityNodeInfo5, accessibilityNodeInfoE, str4, rectG2, null);
                            } else {
                                zb2Var = null;
                            }
                        }
                    } else {
                        zb2Var = null;
                    }
                }
                if (zb2Var != null) {
                    arrayList3.add(zb2Var);
                }
            }
            List listV = v(arrayList, identityHashMap);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj5 : listV) {
                zb2 zb2Var4 = (zb2) obj5;
                if (!arrayList3.isEmpty()) {
                    int size4 = arrayList3.size();
                    int i6 = 0;
                    do {
                        if (i6 < size4) {
                            Object obj6 = arrayList3.get(i6);
                            i6++;
                            accessibilityNodeInfo = ((zb2) obj6).b;
                            accessibilityNodeInfo2 = zb2Var4.b;
                            if (accessibilityNodeInfo != accessibilityNodeInfo2) {
                            }
                        }
                    } while (!d(accessibilityNodeInfo2, accessibilityNodeInfo, identityHashMap));
                }
                arrayList4.add(obj5);
            }
            arrayListG = mz.G(arrayList3, arrayList4);
        } else if (iOrdinal != 1) {
            char c3 = 2;
            if (iOrdinal == 2) {
                arrayListG = u(arrayList, identityHashMap, true);
            } else {
                if (iOrdinal != 3) {
                    dk0.l();
                    return null;
                }
                Set setH = h(arrayList, identityHashMap, str);
                if (setH.isEmpty()) {
                    boolean z8 = false;
                    boolean zIsEmpty = ie2.a(arrayList, identityHashMap, true).isEmpty();
                    arrayListG = new ArrayList();
                    int size5 = arrayList.size();
                    int i7 = 0;
                    while (i7 < size5) {
                        Object obj7 = arrayList.get(i7);
                        i7++;
                        AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj7;
                        if (f(accessibilityNodeInfo6)) {
                            boolean z9 = z8;
                            if (g(accessibilityNodeInfo6, identityHashMap, z9, z9)) {
                                zb2Var2 = null;
                            } else {
                                String strK2 = k(accessibilityNodeInfo6);
                                ArrayList arrayListA2 = a(accessibilityNodeInfo6, identityHashMap);
                                ArrayList arrayListG2 = mz.G(nz.h(accessibilityNodeInfo6), arrayListA2);
                                int size6 = arrayListG2.size();
                                int i8 = 0;
                                do {
                                    if (i8 >= size6) {
                                        obj = null;
                                        break;
                                    }
                                    obj = arrayListG2.get(i8);
                                    i8++;
                                } while (!n((AccessibilityNodeInfo) obj, identityHashMap));
                                AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj;
                                if (accessibilityNodeInfo7 == null || strK2.equals("title")) {
                                    if (accessibilityNodeInfo7 == null) {
                                        x42 x42Var = m;
                                        if (x42Var.a(strK2)) {
                                            z3 = true;
                                        } else {
                                            if (!arrayListA2.isEmpty()) {
                                                int size7 = arrayListA2.size();
                                                int i9 = 0;
                                                while (true) {
                                                    if (i9 < size7) {
                                                        Object obj8 = arrayListA2.get(i9);
                                                        i9++;
                                                        if (x42Var.a(k((AccessibilityNodeInfo) obj8))) {
                                                            z3 = true;
                                                        }
                                                    }
                                                }
                                            }
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (l(accessibilityNodeInfo6)) {
                                        z4 = true;
                                    } else {
                                        if (!arrayListA2.isEmpty()) {
                                            int size8 = arrayListA2.size();
                                            int i10 = 0;
                                            while (true) {
                                                if (i10 < size8) {
                                                    Object obj9 = arrayListA2.get(i10);
                                                    i10++;
                                                    if (l((AccessibilityNodeInfo) obj9)) {
                                                        z4 = true;
                                                    }
                                                }
                                            }
                                        }
                                        z4 = false;
                                    }
                                    if (z3 || (!zIsEmpty && z4)) {
                                        CharSequence text2 = accessibilityNodeInfo6.getText();
                                        String string8 = (text2 == null || (string3 = text2.toString()) == null) ? null : cs2.V(string3).toString();
                                        if (string8 == null) {
                                            string8 = "";
                                        }
                                        if (cs2.A(string8)) {
                                            CharSequence contentDescription = accessibilityNodeInfo6.getContentDescription();
                                            string8 = (contentDescription == null || (string2 = contentDescription.toString()) == null) ? null : cs2.V(string2).toString();
                                            if (string8 == null) {
                                                string8 = "";
                                            }
                                        }
                                        String str5 = string8;
                                        if (cs2.A(str5) || (accessibilityNodeInfoE2 = e(accessibilityNodeInfo6, identityHashMap)) == null) {
                                            zb2Var2 = null;
                                        } else {
                                            Rect rectG3 = cq.g(accessibilityNodeInfo6);
                                            if (i(rectG3)) {
                                                zb2Var2 = new zb2(accessibilityNodeInfo6, accessibilityNodeInfoE2, str5, rectG3, null);
                                            } else {
                                                zb2Var2 = null;
                                            }
                                        }
                                    } else {
                                        zb2Var2 = null;
                                    }
                                } else {
                                    zb2Var2 = null;
                                }
                            }
                        } else {
                            zb2Var2 = null;
                        }
                        if (zb2Var2 != null) {
                            arrayListG.add(zb2Var2);
                        }
                        z8 = false;
                    }
                } else {
                    ArrayList arrayList5 = new ArrayList();
                    int size9 = arrayList.size();
                    int i11 = 0;
                    while (i11 < size9) {
                        Object obj10 = arrayList.get(i11);
                        int i12 = i11 + 1;
                        AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj10;
                        if (f(accessibilityNodeInfo8)) {
                            CharSequence packageName = accessibilityNodeInfo8.getPackageName();
                            if (g31.a(packageName != null ? packageName.toString() : null, str)) {
                                int i13 = Build.VERSION.SDK_INT;
                                if ((i13 < 28 || !accessibilityNodeInfo8.isHeading()) && ((collectionItemInfo = accessibilityNodeInfo8.getCollectionItemInfo()) == null || !collectionItemInfo.isHeading())) {
                                    if (i13 >= 28) {
                                        try {
                                            zIsHeading = accessibilityNodeInfo8.isHeading();
                                        } catch (Throwable th) {
                                            h72Var3 = new h72(th);
                                        }
                                    } else {
                                        Bundle extras = accessibilityNodeInfo8.getExtras();
                                        if (extras == null || (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 2) != 2) {
                                            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo2 = accessibilityNodeInfo8.getCollectionItemInfo();
                                            uf1 uf1Var = collectionItemInfo2 != null ? new uf1(2, collectionItemInfo2) : null;
                                            zIsHeading = uf1Var != null && ((AccessibilityNodeInfo.CollectionItemInfo) uf1Var.b).isHeading();
                                        }
                                    }
                                    h72Var3 = Boolean.valueOf(zIsHeading);
                                    Boolean bool = Boolean.FALSE;
                                    boolean z10 = h72Var3 instanceof h72;
                                    Object obj11 = h72Var3;
                                    if (z10) {
                                        obj11 = bool;
                                    }
                                    if (((Boolean) obj11).booleanValue()) {
                                        arrayList5.add(obj10);
                                    }
                                } else {
                                    arrayList5.add(obj10);
                                }
                            }
                            i11 = i12;
                        }
                        i11 = i12;
                    }
                    arrayListG = new ArrayList();
                    int size10 = arrayList5.size();
                    int i14 = 0;
                    while (i14 < size10) {
                        int i15 = i14 + 1;
                        AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) arrayList5.get(i14);
                        List listP = p(accessibilityNodeInfo9, identityHashMap);
                        if (!mz.s(mz.E(listP), setH) || listP.isEmpty()) {
                            z5 = z6 ? 1 : 0;
                            c2 = c3;
                            zb2Var3 = null;
                        } else {
                            Iterator it = listP.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z5 = z6 ? 1 : 0;
                                    c2 = c3;
                                    zb2Var3 = null;
                                } else if (o((AccessibilityNodeInfo) it.next())) {
                                    ArrayList arrayList6 = new ArrayList();
                                    for (Object obj12 : listP) {
                                        AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) obj12;
                                        if (o(accessibilityNodeInfo10) || b(accessibilityNodeInfo10)) {
                                            break;
                                        }
                                        arrayList6.add(obj12);
                                    }
                                    int size11 = arrayList6.size();
                                    int i16 = i3;
                                    while (true) {
                                        if (i16 >= size11) {
                                            z5 = z6;
                                            obj2 = null;
                                            break;
                                        }
                                        obj2 = arrayList6.get(i16);
                                        int i17 = i16 + 1;
                                        AccessibilityNodeInfo accessibilityNodeInfo11 = (AccessibilityNodeInfo) obj2;
                                        if (f(accessibilityNodeInfo11) && accessibilityNodeInfo11.isClickable()) {
                                            try {
                                                CharSequence charSequence = accessibilityNodeInfo11.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
                                                h72Var = charSequence != null ? charSequence.toString() : null;
                                            } catch (Throwable th2) {
                                                h72Var = new h72(th2);
                                            }
                                            boolean z11 = h72Var instanceof h72;
                                            Object obj13 = h72Var;
                                            if (z11) {
                                                obj13 = null;
                                            }
                                            String str6 = (String) obj13;
                                            if (str6 == null || (string6 = cs2.V(str6).toString()) == null || string6.equalsIgnoreCase("link") != z6) {
                                                CharSequence text3 = accessibilityNodeInfo11.getText();
                                                Spanned spanned = text3 instanceof Spanned ? (Spanned) text3 : null;
                                                if (spanned == null) {
                                                    BooleanValue = i3;
                                                    z5 = z6;
                                                } else {
                                                    try {
                                                        z5 = z6;
                                                        try {
                                                            Object[] spans = spanned.getSpans(i3, spanned.length(), URLSpan.class);
                                                            spans.getClass();
                                                            h72Var2 = Boolean.valueOf((boolean) ((spans.length == 0 ? z5 ? 1 : 0 : i3) ^ 1));
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            h72Var2 = new h72(th);
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        z5 = z6;
                                                    }
                                                    Boolean bool2 = Boolean.FALSE;
                                                    boolean z12 = h72Var2 instanceof h72;
                                                    Object obj14 = h72Var2;
                                                    if (z12) {
                                                        obj14 = bool2;
                                                    }
                                                    BooleanValue = ((Boolean) obj14).booleanValue();
                                                }
                                            } else {
                                                boolean z13 = z6;
                                                z5 = z13 ? 1 : 0;
                                                BooleanValue = z13;
                                            }
                                            if (BooleanValue != 0) {
                                                break;
                                            }
                                        } else {
                                            z5 = z6;
                                        }
                                        i16 = i17;
                                        z6 = z5;
                                    }
                                    AccessibilityNodeInfo accessibilityNodeInfo12 = (AccessibilityNodeInfo) obj2;
                                    if (accessibilityNodeInfo12 == null) {
                                        zb2Var3 = null;
                                        arrayList5 = arrayList5;
                                        str3 = str3;
                                        i3 = i3;
                                        c2 = c3;
                                    } else {
                                        CharSequence text4 = accessibilityNodeInfo9.getText();
                                        String string9 = (text4 == null || (string5 = text4.toString()) == null) ? null : cs2.V(string5).toString();
                                        if (string9 == null) {
                                            string9 = str3;
                                        }
                                        if (cs2.A(string9)) {
                                            CharSequence contentDescription2 = accessibilityNodeInfo9.getContentDescription();
                                            string9 = (contentDescription2 == null || (string4 = contentDescription2.toString()) == null) ? null : cs2.V(string4).toString();
                                            if (string9 == null) {
                                                string9 = str3;
                                            }
                                        }
                                        String str7 = string9;
                                        if (p.contains(q(str7))) {
                                            c2 = c3;
                                            zb2Var3 = null;
                                        } else {
                                            List listP2 = p(accessibilityNodeInfo12, identityHashMap);
                                            ArrayList arrayList7 = new ArrayList();
                                            for (Object obj15 : listP2) {
                                                if (o((AccessibilityNodeInfo) obj15)) {
                                                    break;
                                                }
                                                arrayList7.add(obj15);
                                            }
                                            boolean zIsEmpty2 = arrayList7.isEmpty();
                                            Set set = q;
                                            if (zIsEmpty2) {
                                                accessibilityNodeInfo3 = accessibilityNodeInfo12;
                                                i3 = i3;
                                                size = arrayList7.size();
                                                i2 = i3;
                                                while (true) {
                                                    if (i2 < size) {
                                                        Object obj16 = arrayList7.get(i2);
                                                        int i18 = i2 + 1;
                                                        accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj16;
                                                        if (identityHashMap.get(accessibilityNodeInfo4) == null && !b(accessibilityNodeInfo4)) {
                                                            ArrayList arrayList8 = new ArrayList();
                                                            int size12 = arrayList.size();
                                                            int i19 = size;
                                                            int i20 = i3;
                                                            while (i20 < size12) {
                                                                int i21 = i18;
                                                                Object obj17 = arrayList.get(i20);
                                                                int i22 = i20 + 1;
                                                                AccessibilityNodeInfo accessibilityNodeInfo13 = (AccessibilityNodeInfo) obj17;
                                                                if (accessibilityNodeInfo13.isVisibleToUser()) {
                                                                    List listP3 = p(accessibilityNodeInfo13, identityHashMap);
                                                                    if (!listP3.isEmpty()) {
                                                                        Iterator it2 = listP3.iterator();
                                                                        while (it2.hasNext()) {
                                                                            Iterator it3 = it2;
                                                                            if (((AccessibilityNodeInfo) it2.next()) == accessibilityNodeInfo4) {
                                                                                arrayList8.add(obj17);
                                                                                break;
                                                                            }
                                                                            it2 = it3;
                                                                        }
                                                                    }
                                                                }
                                                                i18 = i21;
                                                                i20 = i22;
                                                            }
                                                            int i23 = i18;
                                                            if (!arrayList8.isEmpty()) {
                                                                int size13 = arrayList8.size();
                                                                int i24 = i3;
                                                                while (true) {
                                                                    if (i24 < size13) {
                                                                        Object obj18 = arrayList8.get(i24);
                                                                        i24++;
                                                                        AccessibilityNodeInfo accessibilityNodeInfo14 = (AccessibilityNodeInfo) obj18;
                                                                        int i25 = size13;
                                                                        if (identityHashMap.get(accessibilityNodeInfo14) == accessibilityNodeInfo4 && accessibilityNodeInfo14.getChildCount() == 0 && !accessibilityNodeInfo14.isClickable()) {
                                                                            CharSequence text5 = accessibilityNodeInfo14.getText();
                                                                            String string10 = text5 != null ? text5.toString() : null;
                                                                            if (string10 == null) {
                                                                                string10 = str3;
                                                                            }
                                                                            if (set.contains(q(string10))) {
                                                                                arrayList5 = arrayList5;
                                                                                str3 = str3;
                                                                                c2 = 2;
                                                                            }
                                                                        }
                                                                        size13 = i25;
                                                                    }
                                                                }
                                                            }
                                                            ArrayList arrayList9 = new ArrayList();
                                                            int size14 = arrayList5.size();
                                                            int i26 = i3;
                                                            while (i26 < size14) {
                                                                Object obj19 = arrayList5.get(i26);
                                                                i26++;
                                                                int i27 = size14;
                                                                AccessibilityNodeInfo accessibilityNodeInfo15 = (AccessibilityNodeInfo) obj19;
                                                                if (arrayList8.isEmpty()) {
                                                                    arrayList2 = arrayList5;
                                                                    str2 = str3;
                                                                } else {
                                                                    arrayList2 = arrayList5;
                                                                    int size15 = arrayList8.size();
                                                                    str2 = str3;
                                                                    int i28 = i3;
                                                                    while (i28 < size15) {
                                                                        Object obj20 = arrayList8.get(i28);
                                                                        i28++;
                                                                        int i29 = size15;
                                                                        if (((AccessibilityNodeInfo) obj20) == accessibilityNodeInfo15) {
                                                                            arrayList9.add(obj19);
                                                                            break;
                                                                        }
                                                                        size15 = i29;
                                                                    }
                                                                }
                                                                size14 = i27;
                                                                arrayList5 = arrayList2;
                                                                str3 = str2;
                                                            }
                                                            arrayList5 = arrayList5;
                                                            str3 = str3;
                                                            if (!arrayList9.isEmpty()) {
                                                                int size16 = arrayList9.size();
                                                                int i30 = i3;
                                                                while (true) {
                                                                    if (i30 < size16) {
                                                                        Object obj21 = arrayList9.get(i30);
                                                                        i30++;
                                                                        if (((AccessibilityNodeInfo) obj21) != accessibilityNodeInfo9) {
                                                                            c2 = 2;
                                                                            rectG = cq.g(accessibilityNodeInfo3);
                                                                            if (i(rectG)) {
                                                                                zb2Var3 = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str7, rectG, null);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!arrayList8.isEmpty()) {
                                                                int size17 = arrayList8.size();
                                                                int i31 = i3;
                                                                while (true) {
                                                                    if (i31 < size17) {
                                                                        Object obj22 = arrayList8.get(i31);
                                                                        i31++;
                                                                        AccessibilityNodeInfo accessibilityNodeInfo16 = (AccessibilityNodeInfo) obj22;
                                                                        CharSequence text6 = accessibilityNodeInfo16.getText();
                                                                        CharSequence contentDescription3 = accessibilityNodeInfo16.getContentDescription();
                                                                        c2 = 2;
                                                                        CharSequence[] charSequenceArr = new CharSequence[2];
                                                                        charSequenceArr[i3] = text6;
                                                                        charSequenceArr[z5 ? 1 : 0] = contentDescription3;
                                                                        Iterator it4 = zg2.g(charSequenceArr).iterator();
                                                                        while (true) {
                                                                            if (it4.hasNext()) {
                                                                                CharSequence charSequence2 = (CharSequence) it4.next();
                                                                                String string11 = charSequence2 != null ? charSequence2.toString() : null;
                                                                                if (string11 == null) {
                                                                                    string11 = str3;
                                                                                }
                                                                                if (set.contains(q(string11))) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            size = i19;
                                                            i2 = i23;
                                                            arrayList5 = arrayList5;
                                                            str3 = str3;
                                                        }
                                                        zb2Var3 = null;
                                                    }
                                                    arrayList5 = arrayList5;
                                                    str3 = str3;
                                                    c2 = 2;
                                                    rectG = cq.g(accessibilityNodeInfo3);
                                                    if (i(rectG)) {
                                                        zb2Var3 = null;
                                                    } else {
                                                        zb2Var3 = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str7, rectG, null);
                                                    }
                                                }
                                            } else {
                                                int size18 = arrayList7.size();
                                                int i32 = i3;
                                                while (true) {
                                                    if (i32 < size18) {
                                                        Object obj23 = arrayList7.get(i32);
                                                        i32++;
                                                        AccessibilityNodeInfo accessibilityNodeInfo17 = (AccessibilityNodeInfo) obj23;
                                                        i3 = i3;
                                                        if (!f.a(k(accessibilityNodeInfo17)) && !r.a(k(accessibilityNodeInfo17))) {
                                                            CharSequence text7 = accessibilityNodeInfo17.getText();
                                                            CharSequence contentDescription4 = accessibilityNodeInfo17.getContentDescription();
                                                            AccessibilityNodeInfo accessibilityNodeInfo18 = accessibilityNodeInfo12;
                                                            int i33 = size18;
                                                            CharSequence[] charSequenceArr2 = new CharSequence[2];
                                                            charSequenceArr2[i3] = text7;
                                                            charSequenceArr2[z5 ? 1 : 0] = contentDescription4;
                                                            Iterator it5 = zg2.g(charSequenceArr2).iterator();
                                                            while (true) {
                                                                if (it5.hasNext()) {
                                                                    CharSequence charSequence3 = (CharSequence) it5.next();
                                                                    String string12 = charSequence3 != null ? charSequence3.toString() : null;
                                                                    if (string12 == null) {
                                                                        string12 = str3;
                                                                    }
                                                                    if (set.contains(q(string12))) {
                                                                    }
                                                                } else {
                                                                    size18 = i33;
                                                                    i3 = i3;
                                                                    accessibilityNodeInfo12 = accessibilityNodeInfo18;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        accessibilityNodeInfo3 = accessibilityNodeInfo12;
                                                        i3 = i3;
                                                        size = arrayList7.size();
                                                        i2 = i3;
                                                        while (true) {
                                                            if (i2 < size) {
                                                                Object obj110 = arrayList7.get(i2);
                                                                int i110 = i2 + 1;
                                                                accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj110;
                                                                if (identityHashMap.get(accessibilityNodeInfo4) == null) {
                                                                }
                                                            }
                                                            arrayList5 = arrayList5;
                                                            str3 = str3;
                                                            c2 = 2;
                                                            rectG = cq.g(accessibilityNodeInfo3);
                                                            if (i(rectG)) {
                                                                zb2Var3 = null;
                                                            } else {
                                                                zb2Var3 = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str7, rectG, null);
                                                            }
                                                            size = i19;
                                                            i2 = i23;
                                                            arrayList5 = arrayList5;
                                                            str3 = str3;
                                                        }
                                                    }
                                                    arrayList5 = arrayList5;
                                                    str3 = str3;
                                                    c2 = 2;
                                                    zb2Var3 = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (zb2Var3 != null) {
                            arrayListG.add(zb2Var3);
                        }
                        c3 = c2;
                        i14 = i15;
                        i3 = i3;
                        z6 = z5;
                        arrayList5 = arrayList5;
                        str3 = str3;
                    }
                }
            }
        } else {
            arrayListG = mz.G(u(arrayList, identityHashMap, false), z ? u(arrayList, identityHashMap, true) : ii0.a);
        }
        List listK = mz.K(arrayListG, new i2(18, new lo0(28)));
        HashSet hashSet = new HashSet();
        ArrayList arrayList10 = new ArrayList();
        for (Object obj24 : listK) {
            if (hashSet.add(((zb2) obj24).b)) {
                arrayList10.add(obj24);
            }
        }
        return arrayList10;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0172  */
    /* JADX WARN: Code duplicated, block: B:74:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21, types: [int] */
    /* JADX WARN: Type inference failed for: r5v22, types: [int] */
    public static ArrayList u(ArrayList arrayList, IdentityHashMap identityHashMap, boolean z) {
        zb2 zb2Var;
        boolean z2;
        boolean z3;
        String str;
        AccessibilityNodeInfo accessibilityNodeInfoE;
        Rect rectG;
        String str2;
        String string;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        var r5 = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (f(accessibilityNodeInfo) && m(accessibilityNodeInfo, identityHashMap) == z && !g(accessibilityNodeInfo, identityHashMap, r5, z)) {
                String strK = k(accessibilityNodeInfo);
                var A = a(accessibilityNodeInfo, identityHashMap);
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                String string2 = contentDescription != null ? contentDescription.toString() : null;
                String strA = "";
                if (string2 == null) {
                    string2 = "";
                }
                x42 x42Var = n;
                if (z) {
                    z2 = true;
                } else {
                    if (!A.isEmpty()) {
                        int size2 = A.size();
                        while (true) {
                            if (r5 < size2) {
                                Object obj2 = A.get(r5);
                                r5++;
                                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                                if (!i.a(k(accessibilityNodeInfo2))) {
                                    CharSequence contentDescription2 = accessibilityNodeInfo2.getContentDescription();
                                    String string3 = contentDescription2 != null ? contentDescription2.toString() : null;
                                    if (string3 == null) {
                                        string3 = "";
                                    }
                                    if (x42Var.a(string3)) {
                                    }
                                }
                                z2 = true;
                            }
                        }
                    }
                    z2 = false;
                }
                boolean z4 = wh2.c("video_title", "title_text").contains(strK) || (wh2.c("title", "shorts_title", "reel_title", "headline").contains(strK) && z2);
                if (accessibilityNodeInfo.isClickable() && (x42Var.a(string2) || (z && l.a(string2)))) {
                    if (!arrayList.isEmpty()) {
                        int size3 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 < size3) {
                                Object obj3 = arrayList.get(i3);
                                i3++;
                                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                                if (accessibilityNodeInfo3 != accessibilityNodeInfo && wh2.c("video_title", "title_text", "title", "shorts_title", "reel_title", "headline").contains(k(accessibilityNodeInfo3))) {
                                    ArrayList arrayListA = a(accessibilityNodeInfo3, identityHashMap);
                                    if (arrayListA.isEmpty()) {
                                        continue;
                                    } else {
                                        int size4 = arrayListA.size();
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 < size4) {
                                                Object obj4 = arrayListA.get(i4);
                                                i4++;
                                                if (((AccessibilityNodeInfo) obj4) == accessibilityNodeInfo) {
                                                    z3 = false;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 || z3) {
                    if (z4) {
                        CharSequence text = accessibilityNodeInfo.getText();
                        String string4 = (text == null || (string = text.toString()) == null) ? null : cs2.V(string).toString();
                        if (string4 != null) {
                            str = string4;
                        }
                        if (!cs2.A(str) || (accessibilityNodeInfoE = e(accessibilityNodeInfo, identityHashMap)) == null || j(accessibilityNodeInfoE, arrayList, identityHashMap)) {
                            zb2Var = null;
                        } else {
                            rectG = cq.g(accessibilityNodeInfo);
                            if (i(rectG)) {
                                if (z) {
                                    str2 = "Short";
                                } else {
                                    str2 = "Video";
                                }
                                zb2Var = new zb2(accessibilityNodeInfo, accessibilityNodeInfoE, str, rectG, str2);
                            } else {
                                zb2Var = null;
                            }
                        }
                    } else {
                        strA = kd3.a(string2);
                    }
                    str = strA;
                    if (!cs2.A(str)) {
                        zb2Var = null;
                    } else {
                        rectG = cq.g(accessibilityNodeInfo);
                        if (i(rectG)) {
                            zb2Var = null;
                        } else {
                            if (z) {
                                str2 = "Short";
                            } else {
                                str2 = "Video";
                            }
                            zb2Var = new zb2(accessibilityNodeInfo, accessibilityNodeInfoE, str, rectG, str2);
                        }
                    }
                } else {
                    zb2Var = null;
                }
            } else {
                zb2Var = null;
            }
            if (zb2Var != null) {
                arrayList2.add(zb2Var);
            }
            r5 = 0;
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:112:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:129:0x0240  */
    /* JADX WARN: Code duplicated, block: B:132:0x0251  */
    /* JADX WARN: Code duplicated, block: B:134:0x025f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0276  */
    /* JADX WARN: Code duplicated, block: B:146:0x0289  */
    /* JADX WARN: Code duplicated, block: B:148:0x028d  */
    /* JADX WARN: Code duplicated, block: B:150:0x0298 A[LOOP:9: B:97:0x01a5->B:150:0x0298, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:176:0x017f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x024f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x01ba A[EDGE_INSN: B:191:0x01ba->B:102:0x01ba BREAK  A[LOOP:9: B:97:0x01a5->B:150:0x0298], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x0144  */
    /* JADX WARN: Code duplicated, block: B:80:0x014e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0153  */
    /* JADX WARN: Code duplicated, block: B:84:0x015f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0174  */
    /* JADX WARN: Code duplicated, block: B:92:0x0191  */
    /* JADX WARN: Code duplicated, block: B:93:0x0193  */
    /* JADX WARN: Code duplicated, block: B:96:0x019e  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList] */
    public static List v(ArrayList arrayList, IdentityHashMap identityHashMap) {
        Set set;
        Object r18;
        zb2 zb2Var;
        Object r19;
        Rect rectG;
        int size;
        Object r2;
        Object r4;
        Object r110;
        Iterator it;
        Object next;
        int i2;
        Object next2;
        int i3;
        ac2 ac2Var;
        ArrayList arrayList2;
        int size2;
        int i4;
        ArrayList arrayList3;
        int size3;
        int i5;
        String str;
        String str2;
        CharSequence text;
        String string;
        String string2;
        int i6;
        AccessibilityNodeInfo accessibilityNodeInfo;
        int i7;
        int i8;
        ac2 ac2Var2;
        ac2 ac2Var3;
        ArrayList arrayList4 = arrayList;
        if (!arrayList4.isEmpty()) {
            int size4 = arrayList4.size();
            boolean z = false;
            int i9 = 0;
            while (i9 < size4) {
                Object obj = arrayList4.get(i9);
                i9++;
                Set setC = wh2.c("com.whatsapp", "com.whatsapp.w4b");
                CharSequence packageName = ((AccessibilityNodeInfo) obj).getPackageName();
                if (mz.s(packageName != null ? packageName.toString() : null, setC)) {
                    boolean z2 = true;
                    if (!ie2.a(arrayList4, identityHashMap, true).isEmpty()) {
                        ArrayList arrayList5 = new ArrayList();
                        int size5 = arrayList4.size();
                        int i10 = 0;
                        while (true) {
                            set = b;
                            if (i10 >= size5) {
                                break;
                            }
                            Object obj2 = arrayList4.get(i10);
                            i10++;
                            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                            CharSequence text2 = accessibilityNodeInfo2.getText();
                            String string3 = text2 != null ? text2.toString() : null;
                            String strQ = q(string3 != null ? string3 : "");
                            if (!accessibilityNodeInfo2.isVisibleToUser() || accessibilityNodeInfo2.isClickable() || ie2.g(accessibilityNodeInfo2) || !wh2.a(set, c).contains(strQ)) {
                                ac2Var3 = null;
                            } else {
                                List listW = w(accessibilityNodeInfo2, identityHashMap);
                                if (listW.isEmpty()) {
                                    ac2Var3 = null;
                                } else {
                                    List listV = mz.v(listW);
                                    if (!listV.isEmpty()) {
                                        Iterator it2 = listV.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                if (((AccessibilityNodeInfo) it2.next()).isClickable()) {
                                                    ac2Var3 = null;
                                                }
                                            }
                                        }
                                    }
                                    ac2Var3 = new ac2((AccessibilityNodeInfo) mz.D(listW), strQ, cq.g(accessibilityNodeInfo2));
                                }
                            }
                            if (ac2Var3 != null) {
                                arrayList5.add(ac2Var3);
                            }
                        }
                        if (arrayList5.isEmpty()) {
                            break;
                        }
                        ArrayList arrayList6 = new ArrayList();
                        int size6 = arrayList4.size();
                        int i11 = 0;
                        var r5 = arrayList5;
                        while (i11 < size6) {
                            Object obj3 = arrayList4.get(i11);
                            i11++;
                            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                            if (f(accessibilityNodeInfo3) && accessibilityNodeInfo3.isClickable() && !g(accessibilityNodeInfo3, identityHashMap, z2, z)) {
                                List listW2 = w(accessibilityNodeInfo3, identityHashMap);
                                if (listW2.isEmpty()) {
                                    r18 = r5;
                                    zb2Var = null;
                                    r19 = r18;
                                } else {
                                    List listV2 = mz.v(listW2);
                                    if (!listV2.isEmpty()) {
                                        Iterator it3 = listV2.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                if (((AccessibilityNodeInfo) it3.next()).isClickable()) {
                                                }
                                            } else if (l(accessibilityNodeInfo3)) {
                                                rectG = cq.g(accessibilityNodeInfo3);
                                                if (i(rectG)) {
                                                    ArrayList arrayList7 = new ArrayList();
                                                    size = r5.size();
                                                    r2 = z;
                                                    r4 = r5;
                                                    while (r2 < size) {
                                                        Object obj4 = r4.get(r2);
                                                        int i12 = r2 + 1;
                                                        ac2Var2 = (ac2) obj4;
                                                        var r111 = r4;
                                                        if (ac2Var2.a != mz.D(listW2)) {
                                                        }
                                                        r2 = i12;
                                                        r4 = r111;
                                                    }
                                                    r110 = r4;
                                                    it = arrayList7.iterator();
                                                    if (it.hasNext()) {
                                                        next = it.next();
                                                        if (it.hasNext()) {
                                                            i2 = ((ac2) next).c.top;
                                                            while (true) {
                                                                next2 = it.next();
                                                                i3 = ((ac2) next2).c.top;
                                                                if (i2 < i3) {
                                                                    next = next2;
                                                                    i2 = i3;
                                                                }
                                                                if (!it.hasNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                arrayList4 = arrayList;
                                                            }
                                                        }
                                                    } else {
                                                        next = null;
                                                    }
                                                    ac2Var = (ac2) next;
                                                    r18 = r110;
                                                    if (ac2Var != null) {
                                                        r18 = r110;
                                                        if (set.contains(ac2Var.b)) {
                                                            arrayList2 = new ArrayList();
                                                            size2 = arrayList4.size();
                                                            for (i4 = 0; i4 < size2; i4 = i8) {
                                                                Object obj5 = arrayList4.get(i4);
                                                                i6 = i4 + 1;
                                                                accessibilityNodeInfo = (AccessibilityNodeInfo) obj5;
                                                                if (accessibilityNodeInfo.isVisibleToUser()) {
                                                                    i7 = size2;
                                                                    i8 = i6;
                                                                } else {
                                                                    i7 = size2;
                                                                    i8 = i6;
                                                                }
                                                                arrayList4 = arrayList;
                                                                size2 = i7;
                                                            }
                                                            arrayList3 = new ArrayList();
                                                            size3 = arrayList2.size();
                                                            i5 = 0;
                                                            while (i5 < size3) {
                                                                Object obj6 = arrayList2.get(i5);
                                                                i5++;
                                                                text = ((AccessibilityNodeInfo) obj6).getText();
                                                                if (text != null) {
                                                                    string = null;
                                                                } else {
                                                                    string = null;
                                                                }
                                                                if (string != null) {
                                                                    arrayList3.add(string);
                                                                }
                                                            }
                                                            str = (String) mz.I(mz.t(arrayList3));
                                                            if (str == null) {
                                                                str2 = "";
                                                            } else {
                                                                str2 = str;
                                                            }
                                                            zb2Var = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str2, rectG, null);
                                                            r19 = r110;
                                                        }
                                                    }
                                                }
                                                zb2Var = null;
                                                r19 = r18;
                                            } else {
                                                rectG = cq.g(accessibilityNodeInfo3);
                                                if (i(rectG)) {
                                                    ArrayList arrayList8 = new ArrayList();
                                                    size = r5.size();
                                                    r2 = z;
                                                    r4 = r5;
                                                    while (r2 < size) {
                                                        Object obj7 = r4.get(r2);
                                                        int i13 = r2 + 1;
                                                        ac2Var2 = (ac2) obj7;
                                                        var r112 = r4;
                                                        if (ac2Var2.a != mz.D(listW2)) {
                                                        }
                                                        r2 = i13;
                                                        r4 = r112;
                                                    }
                                                    r110 = r4;
                                                    it = arrayList8.iterator();
                                                    if (it.hasNext()) {
                                                        next = null;
                                                    } else {
                                                        next = it.next();
                                                        if (it.hasNext()) {
                                                            i2 = ((ac2) next).c.top;
                                                            while (true) {
                                                                next2 = it.next();
                                                                i3 = ((ac2) next2).c.top;
                                                                if (i2 < i3) {
                                                                    next = next2;
                                                                    i2 = i3;
                                                                }
                                                                if (!it.hasNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                arrayList4 = arrayList;
                                                            }
                                                        }
                                                    }
                                                    ac2Var = (ac2) next;
                                                    r18 = r110;
                                                    if (ac2Var != null) {
                                                        r18 = r110;
                                                        if (set.contains(ac2Var.b)) {
                                                            arrayList2 = new ArrayList();
                                                            size2 = arrayList4.size();
                                                            while (i4 < size2) {
                                                                Object obj8 = arrayList4.get(i4);
                                                                i6 = i4 + 1;
                                                                accessibilityNodeInfo = (AccessibilityNodeInfo) obj8;
                                                                if (accessibilityNodeInfo.isVisibleToUser()) {
                                                                    i7 = size2;
                                                                    i8 = i6;
                                                                } else {
                                                                    i7 = size2;
                                                                    i8 = i6;
                                                                }
                                                                arrayList4 = arrayList;
                                                                size2 = i7;
                                                            }
                                                            arrayList3 = new ArrayList();
                                                            size3 = arrayList2.size();
                                                            i5 = 0;
                                                            while (i5 < size3) {
                                                                Object obj9 = arrayList2.get(i5);
                                                                i5++;
                                                                text = ((AccessibilityNodeInfo) obj9).getText();
                                                                if (text != null) {
                                                                    string = null;
                                                                } else {
                                                                    string = null;
                                                                }
                                                                if (string != null) {
                                                                    arrayList3.add(string);
                                                                }
                                                            }
                                                            str = (String) mz.I(mz.t(arrayList3));
                                                            if (str == null) {
                                                                str2 = "";
                                                            } else {
                                                                str2 = str;
                                                            }
                                                            zb2Var = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str2, rectG, null);
                                                            r19 = r110;
                                                        }
                                                    }
                                                }
                                                zb2Var = null;
                                                r19 = r18;
                                            }
                                            r18 = r5;
                                            zb2Var = null;
                                            r19 = r18;
                                        }
                                    } else if (l(accessibilityNodeInfo3) || listW2.size() <= 2) {
                                        rectG = cq.g(accessibilityNodeInfo3);
                                        if (i(rectG)) {
                                            ArrayList arrayList9 = new ArrayList();
                                            size = r5.size();
                                            r2 = z;
                                            r4 = r5;
                                            while (r2 < size) {
                                                Object obj10 = r4.get(r2);
                                                int i14 = r2 + 1;
                                                ac2Var2 = (ac2) obj10;
                                                var r113 = r4;
                                                if (ac2Var2.a != mz.D(listW2) && ac2Var2.c.bottom <= rectG.top) {
                                                    arrayList9.add(obj10);
                                                }
                                                r2 = i14;
                                                r4 = r113;
                                            }
                                            r110 = r4;
                                            it = arrayList9.iterator();
                                            if (it.hasNext()) {
                                                next = null;
                                            } else {
                                                next = it.next();
                                                if (it.hasNext()) {
                                                    i2 = ((ac2) next).c.top;
                                                    while (true) {
                                                        next2 = it.next();
                                                        i3 = ((ac2) next2).c.top;
                                                        if (i2 < i3) {
                                                            next = next2;
                                                            i2 = i3;
                                                        }
                                                        if (!it.hasNext()) {
                                                            break;
                                                        }
                                                        arrayList4 = arrayList;
                                                    }
                                                }
                                            }
                                            ac2Var = (ac2) next;
                                            r18 = r110;
                                            if (ac2Var != null) {
                                                r18 = r110;
                                                if (set.contains(ac2Var.b)) {
                                                    arrayList2 = new ArrayList();
                                                    size2 = arrayList4.size();
                                                    while (i4 < size2) {
                                                        Object obj11 = arrayList4.get(i4);
                                                        i6 = i4 + 1;
                                                        accessibilityNodeInfo = (AccessibilityNodeInfo) obj11;
                                                        if (accessibilityNodeInfo.isVisibleToUser() || ie2.g(accessibilityNodeInfo)) {
                                                            i7 = size2;
                                                            i8 = i6;
                                                        } else {
                                                            if (a.contains(k(accessibilityNodeInfo))) {
                                                                i7 = size2;
                                                                i8 = i6;
                                                            } else {
                                                                i7 = size2;
                                                                i8 = i6;
                                                                if (wh2.c("name", "title", "text1", "display_name", "contact_name").contains(k(accessibilityNodeInfo))) {
                                                                }
                                                            }
                                                            ArrayList arrayListA = a(accessibilityNodeInfo, identityHashMap);
                                                            if (!arrayListA.isEmpty()) {
                                                                int size7 = arrayListA.size();
                                                                int i15 = 0;
                                                                while (i15 < size7) {
                                                                    Object obj12 = arrayListA.get(i15);
                                                                    i15++;
                                                                    if (((AccessibilityNodeInfo) obj12) == accessibilityNodeInfo3) {
                                                                        arrayList2.add(obj11);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        arrayList4 = arrayList;
                                                        size2 = i7;
                                                    }
                                                    arrayList3 = new ArrayList();
                                                    size3 = arrayList2.size();
                                                    i5 = 0;
                                                    while (i5 < size3) {
                                                        Object obj13 = arrayList2.get(i5);
                                                        i5++;
                                                        text = ((AccessibilityNodeInfo) obj13).getText();
                                                        if (text != null || (string2 = text.toString()) == null || (string = cs2.V(string2).toString()) == null || cs2.A(string)) {
                                                            string = null;
                                                        }
                                                        if (string != null) {
                                                            arrayList3.add(string);
                                                        }
                                                    }
                                                    str = (String) mz.I(mz.t(arrayList3));
                                                    if (str == null) {
                                                        str2 = "";
                                                    } else {
                                                        str2 = str;
                                                    }
                                                    zb2Var = new zb2(accessibilityNodeInfo3, accessibilityNodeInfo3, str2, rectG, null);
                                                    r19 = r110;
                                                }
                                            }
                                        } else {
                                            r18 = r5;
                                        }
                                        zb2Var = null;
                                        r19 = r18;
                                    } else {
                                        r18 = r5;
                                        zb2Var = null;
                                        r19 = r18;
                                    }
                                }
                            } else {
                                r18 = r5;
                                zb2Var = null;
                                r19 = r18;
                            }
                            if (zb2Var != null) {
                                arrayList6.add(zb2Var);
                            }
                            arrayList4 = arrayList;
                            r5 = r19;
                            z2 = true;
                            z = false;
                        }
                        return arrayList6;
                    }
                    break;
                }
                arrayList4 = arrayList;
            }
        }
        return ii0.a;
    }

    public static final List w(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        ArrayList arrayList = new ArrayList();
        Object obj = identityHashMap.get(accessibilityNodeInfo);
        for (int i2 = 0; i2 < 8 && (accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj) != null; i2++) {
            arrayList.add(accessibilityNodeInfo2);
            CharSequence className = accessibilityNodeInfo2.getClassName();
            String string = className != null ? className.toString() : null;
            if (string == null) {
                string = "";
            }
            if (accessibilityNodeInfo2.isScrollable() || cs2.n(string, "RecyclerView", false) || cs2.n(string, "ListView", false) || ((collectionInfo = accessibilityNodeInfo2.getCollectionInfo()) != null && collectionInfo.getRowCount() > 0)) {
                return arrayList;
            }
            obj = identityHashMap.get(accessibilityNodeInfo2);
        }
        return ii0.a;
    }
}
