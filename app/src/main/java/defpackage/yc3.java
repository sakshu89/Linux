package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yc3 {
    public static final x42 a = new x42("^(?:(?:click|tap|press)\\s+(?:on\\s+)?(?:the\\s+)?)?(?:(?:close|dismiss|hide|remove|cancel)\\s+(?:(?:the|this|a|an)\\s+)?(?:ad|ads|advertisement|sponsor|sponsored(?:\\s+ad)?)(?:\\s+(?:panel|card|overlay|banner|popup|pop-up))?|(?:x|cross|close\\s+button)\\s+(?:on|in|for)\\s+(?:the\\s+)?(?:ad|ads|advertisement|sponsor|sponsored(?:\\s+ad)?)(?:\\s+(?:panel|card|overlay|banner|popup|pop-up))?)(?:\\s+button)?(?:\\s+(?:on|in)\\s+youtube)?[.!?]?$");
    public static final x42 b = new x42("^(?:(?:youtube|यूट्यूब)\\s+(?:par|pe|पर|में)\\s+)?(?:(?:ye|yeh|is|यह|ये|इस)\\s+)?(?:(?:ad|ads|advertisement|sponsor|sponsored(?:\\s+ad)?)(?:\\s+(?:panel|card|overlay|banner|popup|pop-up))?|विज्ञापन|स्पॉन्सर|स्पॉन्सर्ड|स्पॉन्सर्ड एड|एड)(?:\\s+(?:ko|को))?\\s+(?:(?:band|bandh|बंद|close)\\s+(?:karo|kar\\s+do|kar|kijiye|करो|कर\\s+दो|करें|कीजिए)|hatao|हटाओ|हटाएं)[.!?।]?$");
    public static final Set c = wh2.c("ad_close_button", "close_ad_button", "ad_dismiss_button", "dismiss_ad_button", "ad_overlay_close_button", "companion_ad_close_button", "ad_panel_close_button", "close_ad_panel_button");
    public static final sh2 d;
    public static final Set e;
    public static final Set f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;

    static {
        sh2 sh2Var = new sh2();
        for (String str : nz.i("close", "dismiss", "hide")) {
            for (String str2 : nz.i("ad", "advertisement", "sponsor", "sponsored ad")) {
                Iterator it = nz.i("", " panel", " overlay", " banner", " card").iterator();
                while (it.hasNext()) {
                    sh2Var.add(str + Padder.FALLBACK_PADDING_STRING + str2 + ((String) it.next()));
                }
            }
        }
        sh2Var.addAll(nz.i("विज्ञापन बंद करें", "विज्ञापन पैनल बंद करें", "विज्ञापन का पैनल बंद करें"));
        rg1 rg1Var = sh2Var.a;
        rg1Var.b();
        if (rg1Var.n <= 0) {
            sh2Var = sh2.b;
        }
        d = sh2Var;
        e = wh2.c("close", "dismiss", "hide", "cancel", LanguageTag.PRIVATEUSE, "×", "✕", "बंद करें");
        f = wh2.c("ad", "ads", "advertisement", "sponsored", "sponsored ad", "विज्ञापन");
        g = new x42("(?:close|dismiss|hide|cancel)(?:_button|_icon)?|x");
        h = new x42("(?:^|_)(?:ad_card|ad_overlay|ad_container|ad_renderer|companion_ad|promoted|sponsored)(?:_|$)");
        i = new x42("(?:mini_?player|floaty_bar|(?:^|_)(?:skip|next)(?:_(?:ad|video))?(?:_(?:button|icon|control|text))*(?:$)|subscribe|channel|avatar|logo|brand|install|advertiser|settings|(?:^|_)(?:menu|mute|volume|sound|audio|fullscreen|cast|share)(?:_|$)|play_pause|pause_button|play_button|overflow|more_options|video_title|title_text|video_renderer|video_card|video_result|video_item|shorts|reel|(?:^|_)title(?:_|$)|thumbnail|headline)");
    }

    public static ArrayList a(ArrayList arrayList, IdentityHashMap identityHashMap, List list) {
        Set set;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i8 = 0;
        while (true) {
            set = f;
            if (i8 >= size) {
                break;
            }
            Object obj = arrayList2.get(i8);
            i8++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (g(accessibilityNodeInfo) && !h(accessibilityNodeInfo, identityHashMap)) {
                ArrayList arrayListN = n(accessibilityNodeInfo);
                if (!arrayListN.isEmpty()) {
                    int size2 = arrayListN.size();
                    int i9 = 0;
                    while (i9 < size2) {
                        Object obj2 = arrayListN.get(i9);
                        i9++;
                        if (set.contains((String) obj2)) {
                            arrayList3.add(obj);
                            break;
                        }
                    }
                }
            }
        }
        ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
        int size3 = arrayList3.size();
        int i10 = 0;
        while (i10 < size3) {
            Object obj3 = arrayList3.get(i10);
            i10++;
            arrayList4.add(b((AccessibilityNodeInfo) obj3));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj4 : list) {
            gp1 gp1Var = (gp1) obj4;
            String str = gp1Var.a;
            Rect rect = gp1Var.b;
            if (set.contains(o(str)) && u(rect)) {
                if (arrayList2.isEmpty()) {
                    arrayList5.add(obj4);
                    break;
                }
                int size4 = arrayList2.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size4) {
                        arrayList5.add(obj4);
                        break;
                        break;
                    }
                    Object obj5 = arrayList2.get(i11);
                    i11++;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj5;
                    if (g(accessibilityNodeInfo2) && i.a(l(accessibilityNodeInfo2))) {
                        Rect rectB = b(accessibilityNodeInfo2);
                        int i12 = rect.right;
                        int i13 = rect.left;
                        if (i12 > i13 && (i2 = rect.bottom) > (i3 = rect.top) && (i4 = rectB.right) > (i5 = rectB.left) && (i6 = rectB.bottom) > (i7 = rectB.top) && i13 >= i5 && i3 >= i7 && i12 <= i4 && i2 <= i6) {
                            break;
                        }
                    }
                    arrayList2 = arrayList;
                }
            }
            arrayList2 = arrayList;
        }
        ArrayList arrayList6 = new ArrayList(nz.d(arrayList5));
        int size5 = arrayList5.size();
        int i14 = 0;
        while (i14 < size5) {
            Object obj6 = arrayList5.get(i14);
            i14++;
            arrayList6.add(((gp1) obj6).b);
        }
        return mz.G(arrayList4, arrayList6);
    }

    public static Rect b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return cq.g(accessibilityNodeInfo);
    }

    public static boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        if (accessibilityNodeInfo.isScrollable()) {
            return true;
        }
        CharSequence className = accessibilityNodeInfo.getClassName();
        return (className == null || (string = className.toString()) == null || (!cs2.n(string, "RecyclerView", false) && !cs2.n(string, "ScrollView", false) && !cs2.n(string, "ListView", false))) ? false : true;
    }

    public static boolean d(Rect rect, Rect rect2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        return u(rect) && u(rect2) && (i2 = rect.right) > (i3 = rect.left) && (i4 = rect.bottom) > (i5 = rect.top) && (i6 = rect2.right) > (i7 = rect2.left) && (i8 = rect2.bottom) > (i9 = rect2.top) && i3 >= i7 && i5 >= i9 && i2 <= i6 && i4 <= i8 && 8 <= (i10 = i2 - i3) && i10 < 513 && 8 <= (i11 = i4 - i5) && i11 < 513 && i10 <= i11 * 2 && i11 <= i10 * 2 && i10 * 4 <= i6 - i7 && i11 * 4 <= i8 - i9;
    }

    public static String e(ob2 ob2Var) {
        String str = ob2Var.b;
        if (str == null) {
            str = "";
        }
        String strS = cs2.S(str, '/');
        Locale locale = Locale.ROOT;
        return cq.o(locale, strS, locale);
    }

    public static String f(ob2 ob2Var) {
        String strO = o(ob2Var.a);
        if (!f.contains(strO) && !e.contains(strO) && !d.a.containsKey(strO)) {
            strO = null;
        }
        if (strO == null) {
            strO = "";
        }
        String strE = e(ob2Var);
        Rect rect = ob2Var.d;
        return strE + ":" + strO + ":" + rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rectG = cq.g(accessibilityNodeInfo);
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        return g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube") && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && !accessibilityNodeInfo.isPassword() && !accessibilityNodeInfo.isEditable() && rectG.right > rectG.left && rectG.bottom > rectG.top;
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        List<AccessibilityNodeInfo> listQ = q(accessibilityNodeInfo, identityHashMap);
        if (!listQ.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listQ) {
                if (i.a(l(accessibilityNodeInfo2))) {
                    return true;
                }
                ArrayList arrayListN = n(accessibilityNodeInfo2);
                if (!arrayListN.isEmpty()) {
                    int size = arrayListN.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayListN.get(i2);
                        i2++;
                        if (wh2.c("skip", "skip ad", "next", "next video", "subscribe", "close player", "close mini player", "install", "learn more", "visit advertiser", "more options", "settings", "ad settings", "about this ad").contains((String) obj)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean i(wc2 wc2Var) {
        boolean z;
        List<ob2> list = wc2Var.c;
        if (list.isEmpty()) {
            z = false;
        } else {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    ob2 ob2Var = (ob2) it.next();
                    if (!f.contains(o(ob2Var.a))) {
                        String str = ob2Var.b;
                        if (str == null) {
                            str = "";
                        }
                        if (h.a(cs2.S(str, '/'))) {
                        }
                    }
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (!list.isEmpty()) {
            for (ob2 ob2Var2 : list) {
                String str2 = ob2Var2.b;
                String str3 = ob2Var2.a;
                if (str2 == null) {
                    str2 = "";
                }
                String strS = cs2.S(str2, '/');
                Locale locale = Locale.ROOT;
                String strO = cq.o(locale, strS, locale);
                if (!i.a(strO)) {
                    if (!c.contains(strO)) {
                        if (d.a.containsKey(o(str3)) || (z && (e.contains(o(str3)) || g.e(strO)))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(wc2 wc2Var) {
        if (g31.a(wc2Var.a, "com.google.android.youtube")) {
            List<ob2> list = wc2Var.c;
            if (!list.isEmpty()) {
                for (ob2 ob2Var : list) {
                    String strE = e(ob2Var);
                    if (cs2.n(strE, "player", false) || wh2.c("watch_panel", "video_view", "video_title", "title_text", "subscribe_button").contains(strE) || cs2.n(ob2Var.c, "SurfaceView", false) || wh2.c("subscribe", "subscribed").contains(o(ob2Var.a))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean k(Rect rect, Rect rect2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        rect2.getClass();
        rect.getClass();
        int i8 = rect.right;
        int i9 = rect.left;
        return i8 > i9 && (i2 = rect.bottom) > (i3 = rect.top) && (i4 = rect2.right) > (i5 = rect2.left) && (i6 = rect2.bottom) > (i7 = rect2.top) && i9 >= i5 && i3 >= i7 && i8 <= i4 && i2 <= i6 && i4 - i5 >= (i8 - i9) * 3 && ((i3 + i2) / 2) - i7 <= (i2 - i3) * 2;
    }

    public static String l(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    public static boolean m(String str) {
        str.getClass();
        String strO = o(str);
        return a.e(strO) || b.e(strO);
    }

    public static ArrayList n(AccessibilityNodeInfo accessibilityNodeInfo) {
        List<CharSequence> listI = nz.i(accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription());
        ArrayList arrayList = new ArrayList(nz.d(listI));
        for (CharSequence charSequence : listI) {
            String string = charSequence != null ? charSequence.toString() : null;
            if (string == null) {
                string = "";
            }
            arrayList.add(o(string));
        }
        return arrayList;
    }

    public static String o(String str) {
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, string, locale);
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        return cs2.W(strReplaceAll, ' ', '.', ':', 183, 8226);
    }

    public static Rect p(Bitmap bitmap, Rect rect) {
        Rect rect2 = new Rect();
        rect2.left = Math.max(0, rect.left - 2);
        rect2.top = Math.max(0, rect.top - 2);
        rect2.right = Math.min(bitmap != null ? bitmap.getWidth() : Integer.MAX_VALUE, rect.right + 2);
        rect2.bottom = Math.min(bitmap != null ? bitmap.getHeight() : Integer.MAX_VALUE, rect.bottom + 2);
        return rect2;
    }

    public static List q(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        Object obj = accessibilityNodeInfo;
        while (i2 < 40 && (accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj) != null) {
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    if (((AccessibilityNodeInfo) obj2) == accessibilityNodeInfo2) {
                        return ii0.a;
                    }
                }
            }
            arrayList.add(accessibilityNodeInfo2);
            i2++;
            obj = identityHashMap.get(accessibilityNodeInfo2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:126:0x0240  */
    /* JADX WARN: Code duplicated, block: B:128:0x0246  */
    /* JADX WARN: Code duplicated, block: B:130:0x0256  */
    /* JADX WARN: Code duplicated, block: B:134:0x0263  */
    /* JADX WARN: Code duplicated, block: B:224:0x0413  */
    /* JADX WARN: Code duplicated, block: B:232:0x0430  */
    /* JADX WARN: Code duplicated, block: B:233:0x0435  */
    /* JADX WARN: Code duplicated, block: B:30:0x0089  */
    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b2 A[PHI: r19 r20
      0x00b2: PHI (r19v29 int) = (r19v30 int), (r19v33 int), (r19v33 int), (r19v33 int), (r19v33 int), (r19v33 int), (r19v33 int), (r19v33 int) binds: [B:40:0x00b0, B:129:0x0254, B:131:0x025e, B:124:0x023c, B:78:0x0160, B:80:0x016e, B:83:0x017a, B:545:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x00b2: PHI (r20v20 int) = (r20v21 int), (r20v23 int), (r20v23 int), (r20v23 int), (r20v29 int), (r20v29 int), (r20v29 int), (r20v29 int) binds: [B:40:0x00b0, B:129:0x0254, B:131:0x025e, B:124:0x023c, B:78:0x0160, B:80:0x016e, B:83:0x017a, B:545:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1 A[PHI: r5 r7 r14
      0x00c1: PHI (r5v53 java.util.List) = (r5v42 java.util.List), (r5v43 java.util.List) binds: [B:44:0x00bf, B:560:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00c1: PHI (r7v76 int) = (r7v68 int), (r7v73 int) binds: [B:44:0x00bf, B:560:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00c1: PHI (r14v46 boolean) = (r14v42 boolean), (r14v43 boolean) binds: [B:44:0x00bf, B:560:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:466:0x0988 A[PHI: r6 r7
      0x0988: PHI (r6v16 int) = (r6v9 int), (r6v13 int) binds: [B:465:0x0986, B:685:0x0988] A[DONT_GENERATE, DONT_INLINE]
      0x0988: PHI (r7v20 int) = (r7v15 int), (r7v17 int) binds: [B:465:0x0986, B:685:0x0988] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:467:0x098d  */
    /* JADX WARN: Code duplicated, block: B:469:0x0994  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:471:0x09a2  */
    /* JADX WARN: Code duplicated, block: B:484:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:489:0x09ed  */
    /* JADX WARN: Code duplicated, block: B:491:0x09f4  */
    /* JADX WARN: Code duplicated, block: B:494:0x0a03  */
    /* JADX WARN: Code duplicated, block: B:497:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:499:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:501:0x0a26  */
    /* JADX WARN: Code duplicated, block: B:513:0x0a55  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:540:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:? A[LOOP:1: B:34:0x0095->B:543:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x01f1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:560:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x011e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:59:0x0110 A[LOOP:6: B:55:0x00fb->B:59:0x0110, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x0113 A[PHI: r17 r18
      0x0113: PHI (r17v4 java.util.List) = (r17v1 java.util.List), (r17v6 java.util.List), (r17v7 java.util.List) binds: [B:64:0x012a, B:568:0x0113, B:53:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r18v33 java.util.Iterator) = (r18v30 java.util.Iterator), (r18v34 java.util.Iterator), (r18v35 java.util.Iterator) binds: [B:64:0x012a, B:568:0x0113, B:53:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x011a  */
    /* JADX WARN: Code duplicated, block: B:65:0x012c  */
    /* JADX WARN: Code duplicated, block: B:674:0x0a45 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0a03 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0a42 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:? A[LOOP:33: B:490:0x09f2->B:677:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0134  */
    /* JADX WARN: Code duplicated, block: B:685:0x0988 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0162  */
    /* JADX WARN: Code duplicated, block: B:82:0x0172  */
    /* JADX WARN: Code duplicated, block: B:85:0x017e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0185  */
    /* JADX WARN: Code duplicated, block: B:89:0x0197  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r6v31, types: [java.util.ArrayList] */
    public static ew2 r(ArrayList arrayList, IdentityHashMap identityHashMap, List list, String str, Bitmap bitmap) {
        Set set;
        x42 x42Var;
        x42 x42Var2;
        Set set2;
        sh2 sh2Var;
        Object obj;
        Set set3;
        sh2 sh2Var2;
        ArrayList arrayList2;
        int i2;
        int i3;
        int size;
        int i4;
        AccessibilityNodeInfo accessibilityNodeInfo;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ArrayList arrayListA;
        int size2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int size3;
        int i20;
        Object obj2;
        ArrayList arrayList3;
        int i21;
        int i22;
        Object arrayList4;
        int i23;
        Rect rect;
        x42 x42Var3;
        int i24;
        int i25;
        ArrayList arrayList5;
        int i26;
        int i27;
        int i28;
        int i29;
        ArrayList arrayList6;
        int i30;
        int i31;
        int i32;
        int i33;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        int i34;
        int i35;
        int i36;
        int i37;
        Set set4;
        sh2 sh2Var3;
        Set set5;
        x42 x42Var4;
        int i38;
        int i39;
        Set set6;
        CharSequence className;
        AccessibilityNodeInfo accessibilityNodeInfo3;
        int i40;
        int i41;
        String string;
        int i42;
        int i43;
        AccessibilityNodeInfo accessibilityNodeInfo4;
        boolean z;
        boolean z2;
        AccessibilityNodeInfo accessibilityNodeInfo5;
        List listQ;
        Iterator it;
        AccessibilityNodeInfo accessibilityNodeInfo6;
        List list2;
        Iterator it2;
        Rect rectB;
        Rect rectB2;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        Set set7;
        int i50;
        int i51;
        ArrayList arrayListN;
        int size4;
        int i52;
        Object obj3;
        int i53;
        AccessibilityNodeInfo accessibilityNodeInfo7;
        ArrayList arrayListA2;
        int size5;
        int i54;
        Rect rect2;
        ArrayList arrayList7;
        int i55;
        int i56;
        Rect rect3;
        int i57;
        int i58;
        int size6;
        int i59;
        Object obj4;
        ArrayList arrayList8 = arrayList;
        IdentityHashMap identityHashMap2 = identityHashMap;
        List list3 = list;
        if (str.equals("com.google.android.youtube")) {
            ArrayList arrayList9 = new ArrayList();
            int size7 = arrayList8.size();
            int i60 = 0;
            while (true) {
                set = f;
                x42Var = h;
                x42Var2 = g;
                set2 = e;
                sh2Var = d;
                if (i60 >= size7) {
                    break;
                }
                Object obj5 = arrayList8.get(i60);
                int i61 = i60 + 1;
                AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj5;
                if (!g(accessibilityNodeInfo8) || c(accessibilityNodeInfo8) || h(accessibilityNodeInfo8, identityHashMap2)) {
                    i42 = size7;
                } else {
                    ArrayList arrayListN2 = n(accessibilityNodeInfo8);
                    if (c.contains(l(accessibilityNodeInfo8))) {
                        i42 = size7;
                    } else {
                        if (!arrayListN2.isEmpty()) {
                            int size8 = arrayListN2.size();
                            int i62 = 0;
                            while (true) {
                                if (i62 < size8) {
                                    Object obj6 = arrayListN2.get(i62);
                                    i62++;
                                    i42 = size7;
                                    String str2 = (String) obj6;
                                    int i63 = size8;
                                    if (!sh2Var.a.containsKey(str2)) {
                                        size8 = i63;
                                        size7 = i42;
                                    }
                                }
                            }
                        }
                        i42 = size7;
                        z = false;
                        if (!z) {
                            if (arrayListN2.isEmpty()) {
                                if (!x42Var2.e(l(accessibilityNodeInfo8))) {
                                }
                                accessibilityNodeInfo4 = null;
                                if (accessibilityNodeInfo4 != null) {
                                    arrayList9.add(accessibilityNodeInfo4);
                                }
                                size7 = i42;
                                i60 = i43;
                            } else {
                                size6 = arrayListN2.size();
                                i59 = 0;
                                while (true) {
                                    if (i59 < size6) {
                                        obj4 = arrayListN2.get(i59);
                                        i59++;
                                        if (set2.contains((String) obj4)) {
                                        }
                                    } else {
                                        if (!x42Var2.e(l(accessibilityNodeInfo8))) {
                                        }
                                        accessibilityNodeInfo4 = null;
                                        if (accessibilityNodeInfo4 != null) {
                                            arrayList9.add(accessibilityNodeInfo4);
                                        }
                                        size7 = i42;
                                        i60 = i43;
                                    }
                                }
                            }
                        }
                        if (z) {
                            i43 = i61;
                            z2 = z;
                        } else {
                            listQ = q(accessibilityNodeInfo8, identityHashMap2);
                            if (listQ.isEmpty()) {
                                List list4 = listQ;
                                i43 = i61;
                                z2 = z;
                                accessibilityNodeInfo7 = (AccessibilityNodeInfo) mz.E(list4);
                                if (accessibilityNodeInfo7 != null) {
                                    if (d(b(accessibilityNodeInfo8), b(accessibilityNodeInfo7))) {
                                        arrayListA2 = a(arrayList, identityHashMap, list);
                                        if (!arrayListA2.isEmpty()) {
                                            size5 = arrayListA2.size();
                                            i54 = 0;
                                            while (true) {
                                                if (i54 < size5) {
                                                    Object obj7 = arrayListA2.get(i54);
                                                    int i64 = i54 + 1;
                                                    rect2 = (Rect) obj7;
                                                    if (!s(b(accessibilityNodeInfo8), rect2) && !list4.isEmpty()) {
                                                        Iterator it3 = list4.iterator();
                                                        while (true) {
                                                            if (it3.hasNext()) {
                                                                Rect rectB3 = b((AccessibilityNodeInfo) it3.next());
                                                                rect2.getClass();
                                                                int i65 = rect2.right;
                                                                int i66 = rect2.left;
                                                                if (i65 > i66) {
                                                                    int i67 = rect2.bottom;
                                                                    arrayList7 = arrayListA2;
                                                                    int i68 = rect2.top;
                                                                    i55 = size5;
                                                                    if (i67 > i68) {
                                                                        int i69 = rectB3.right;
                                                                        i56 = i64;
                                                                        int i70 = rectB3.left;
                                                                        rect3 = rect2;
                                                                        if (i69 <= i70 || (i57 = rectB3.bottom) <= (i58 = rectB3.top) || i66 < i70 || i68 < i58 || i65 > i69 || i67 > i57) {
                                                                        }
                                                                    }
                                                                    arrayListA2 = arrayList7;
                                                                    size5 = i55;
                                                                    i64 = i56;
                                                                    rect2 = rect3;
                                                                } else {
                                                                    arrayList7 = arrayListA2;
                                                                    i55 = size5;
                                                                }
                                                                i56 = i64;
                                                                rect3 = rect2;
                                                                arrayListA2 = arrayList7;
                                                                size5 = i55;
                                                                i64 = i56;
                                                                rect2 = rect3;
                                                            } else {
                                                                continue;
                                                            }
                                                        }
                                                    }
                                                    arrayListA2 = arrayListA2;
                                                    size5 = size5;
                                                    i54 = i64;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                it = listQ.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        accessibilityNodeInfo6 = (AccessibilityNodeInfo) it.next();
                                        if (x42Var.a(l(accessibilityNodeInfo6))) {
                                            list2 = listQ;
                                            it2 = it;
                                        } else {
                                            arrayListN = n(accessibilityNodeInfo6);
                                            if (arrayListN.isEmpty()) {
                                                list2 = listQ;
                                                it2 = it;
                                            } else {
                                                list2 = listQ;
                                                size4 = arrayListN.size();
                                                it2 = it;
                                                i52 = 0;
                                                while (true) {
                                                    if (i52 < size4) {
                                                        obj3 = arrayListN.get(i52);
                                                        i52++;
                                                        i53 = size4;
                                                        if (set.contains((String) obj3)) {
                                                            size4 = i53;
                                                        }
                                                    }
                                                }
                                            }
                                            i43 = i61;
                                            set7 = set;
                                            z2 = z;
                                            listQ = list2;
                                            it = it2;
                                            i61 = i43;
                                            z = z2;
                                            set = set7;
                                        }
                                        rectB = b(accessibilityNodeInfo6);
                                        rectB2 = b(accessibilityNodeInfo8);
                                        i44 = rectB2.right;
                                        i45 = rectB2.left;
                                        if (i44 > i45) {
                                            i43 = i61;
                                            i46 = rectB2.bottom;
                                            i47 = rectB2.top;
                                            if (i46 > i47) {
                                                z2 = z;
                                                i48 = rectB.right;
                                                i49 = rectB.left;
                                                set7 = set;
                                                if (i48 <= i49 || (i50 = rectB.bottom) <= (i51 = rectB.top) || i45 < i49 || i47 < i51 || i44 > i48 || i46 > i50) {
                                                }
                                            }
                                            listQ = list2;
                                            it = it2;
                                            i61 = i43;
                                            z = z2;
                                            set = set7;
                                        } else {
                                            i43 = i61;
                                        }
                                        set7 = set;
                                        z2 = z;
                                        listQ = list2;
                                        it = it2;
                                        i61 = i43;
                                        z = z2;
                                        set = set7;
                                    } else {
                                        List list5 = listQ;
                                        i43 = i61;
                                        z2 = z;
                                        accessibilityNodeInfo7 = (AccessibilityNodeInfo) mz.E(list5);
                                        if (accessibilityNodeInfo7 != null) {
                                            if (d(b(accessibilityNodeInfo8), b(accessibilityNodeInfo7))) {
                                                arrayListA2 = a(arrayList, identityHashMap, list);
                                                if (!arrayListA2.isEmpty()) {
                                                    size5 = arrayListA2.size();
                                                    i54 = 0;
                                                    while (true) {
                                                        if (i54 < size5) {
                                                            Object obj8 = arrayListA2.get(i54);
                                                            int i610 = i54 + 1;
                                                            rect2 = (Rect) obj8;
                                                            if (!s(b(accessibilityNodeInfo8), rect2)) {
                                                            }
                                                            arrayListA2 = arrayListA2;
                                                            size5 = size5;
                                                            i54 = i610;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            accessibilityNodeInfo4 = null;
                            if (accessibilityNodeInfo4 != null) {
                                arrayList9.add(accessibilityNodeInfo4);
                            }
                            size7 = i42;
                            i60 = i43;
                        }
                        if (!z2 || x42Var2.e(l(accessibilityNodeInfo8)) || arrayListN2.isEmpty()) {
                            if (!accessibilityNodeInfo8.isClickable()) {
                                Rect rectB4 = b(accessibilityNodeInfo8);
                                accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.E(q(accessibilityNodeInfo8, identityHashMap2));
                                if (accessibilityNodeInfo5 != null || !d(rectB4, b(accessibilityNodeInfo5))) {
                                    accessibilityNodeInfo4 = null;
                                }
                            }
                            accessibilityNodeInfo4 = accessibilityNodeInfo8;
                        } else {
                            int size9 = arrayListN2.size();
                            int i71 = 0;
                            while (true) {
                                if (i71 < size9) {
                                    Object obj9 = arrayListN2.get(i71);
                                    i71++;
                                    if (wh2.c(LanguageTag.PRIVATEUSE, "×", "✕").contains((String) obj9)) {
                                        if (!w(accessibilityNodeInfo8, arrayList8, identityHashMap2, list3)) {
                                            accessibilityNodeInfo4 = null;
                                        }
                                    }
                                }
                                if (!accessibilityNodeInfo8.isClickable()) {
                                    Rect rectB5 = b(accessibilityNodeInfo8);
                                    accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.E(q(accessibilityNodeInfo8, identityHashMap2));
                                    if (accessibilityNodeInfo5 != null) {
                                    }
                                    accessibilityNodeInfo4 = null;
                                }
                                accessibilityNodeInfo4 = accessibilityNodeInfo8;
                            }
                        }
                        if (accessibilityNodeInfo4 != null) {
                            arrayList9.add(accessibilityNodeInfo4);
                        }
                        size7 = i42;
                        i60 = i43;
                    }
                    z = true;
                    if (!z) {
                        if (arrayListN2.isEmpty()) {
                            if (!x42Var2.e(l(accessibilityNodeInfo8))) {
                            }
                            accessibilityNodeInfo4 = null;
                            if (accessibilityNodeInfo4 != null) {
                                arrayList9.add(accessibilityNodeInfo4);
                            }
                            size7 = i42;
                            i60 = i43;
                        } else {
                            size6 = arrayListN2.size();
                            i59 = 0;
                            while (true) {
                                if (i59 < size6) {
                                    obj4 = arrayListN2.get(i59);
                                    i59++;
                                    if (set2.contains((String) obj4)) {
                                    }
                                } else {
                                    if (!x42Var2.e(l(accessibilityNodeInfo8))) {
                                    }
                                    accessibilityNodeInfo4 = null;
                                    if (accessibilityNodeInfo4 != null) {
                                        arrayList9.add(accessibilityNodeInfo4);
                                    }
                                    size7 = i42;
                                    i60 = i43;
                                }
                            }
                        }
                    }
                    if (z) {
                        listQ = q(accessibilityNodeInfo8, identityHashMap2);
                        if (listQ.isEmpty()) {
                            List list6 = listQ;
                            i43 = i61;
                            z2 = z;
                            accessibilityNodeInfo7 = (AccessibilityNodeInfo) mz.E(list6);
                            if (accessibilityNodeInfo7 != null) {
                                if (d(b(accessibilityNodeInfo8), b(accessibilityNodeInfo7))) {
                                    arrayListA2 = a(arrayList, identityHashMap, list);
                                    if (!arrayListA2.isEmpty()) {
                                        size5 = arrayListA2.size();
                                        i54 = 0;
                                        while (true) {
                                            if (i54 < size5) {
                                                Object obj10 = arrayListA2.get(i54);
                                                int i611 = i54 + 1;
                                                rect2 = (Rect) obj10;
                                                if (!s(b(accessibilityNodeInfo8), rect2)) {
                                                }
                                                arrayListA2 = arrayListA2;
                                                size5 = size5;
                                                i54 = i611;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            it = listQ.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    accessibilityNodeInfo6 = (AccessibilityNodeInfo) it.next();
                                    if (x42Var.a(l(accessibilityNodeInfo6))) {
                                        arrayListN = n(accessibilityNodeInfo6);
                                        if (arrayListN.isEmpty()) {
                                            list2 = listQ;
                                            it2 = it;
                                        } else {
                                            list2 = listQ;
                                            size4 = arrayListN.size();
                                            it2 = it;
                                            i52 = 0;
                                            while (true) {
                                                if (i52 < size4) {
                                                    obj3 = arrayListN.get(i52);
                                                    i52++;
                                                    i53 = size4;
                                                    if (set.contains((String) obj3)) {
                                                        size4 = i53;
                                                    }
                                                }
                                            }
                                        }
                                        i43 = i61;
                                        set7 = set;
                                        z2 = z;
                                        listQ = list2;
                                        it = it2;
                                        i61 = i43;
                                        z = z2;
                                        set = set7;
                                    } else {
                                        list2 = listQ;
                                        it2 = it;
                                    }
                                    rectB = b(accessibilityNodeInfo6);
                                    rectB2 = b(accessibilityNodeInfo8);
                                    i44 = rectB2.right;
                                    i45 = rectB2.left;
                                    if (i44 > i45) {
                                        i43 = i61;
                                        i46 = rectB2.bottom;
                                        i47 = rectB2.top;
                                        if (i46 > i47) {
                                            z2 = z;
                                            i48 = rectB.right;
                                            i49 = rectB.left;
                                            set7 = set;
                                            if (i48 <= i49) {
                                                continue;
                                            }
                                        }
                                        listQ = list2;
                                        it = it2;
                                        i61 = i43;
                                        z = z2;
                                        set = set7;
                                    } else {
                                        i43 = i61;
                                    }
                                    set7 = set;
                                    z2 = z;
                                    listQ = list2;
                                    it = it2;
                                    i61 = i43;
                                    z = z2;
                                    set = set7;
                                } else {
                                    List list7 = listQ;
                                    i43 = i61;
                                    z2 = z;
                                    accessibilityNodeInfo7 = (AccessibilityNodeInfo) mz.E(list7);
                                    if (accessibilityNodeInfo7 != null) {
                                        if (d(b(accessibilityNodeInfo8), b(accessibilityNodeInfo7))) {
                                            arrayListA2 = a(arrayList, identityHashMap, list);
                                            if (!arrayListA2.isEmpty()) {
                                                size5 = arrayListA2.size();
                                                i54 = 0;
                                                while (true) {
                                                    if (i54 < size5) {
                                                        Object obj11 = arrayListA2.get(i54);
                                                        int i612 = i54 + 1;
                                                        rect2 = (Rect) obj11;
                                                        if (!s(b(accessibilityNodeInfo8), rect2)) {
                                                        }
                                                        arrayListA2 = arrayListA2;
                                                        size5 = size5;
                                                        i54 = i612;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        accessibilityNodeInfo4 = null;
                        if (accessibilityNodeInfo4 != null) {
                            arrayList9.add(accessibilityNodeInfo4);
                        }
                        size7 = i42;
                        i60 = i43;
                    } else {
                        i43 = i61;
                        z2 = z;
                    }
                    if (z2) {
                        if (!accessibilityNodeInfo8.isClickable()) {
                            Rect rectB6 = b(accessibilityNodeInfo8);
                            accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.E(q(accessibilityNodeInfo8, identityHashMap2));
                            if (accessibilityNodeInfo5 != null) {
                            }
                            accessibilityNodeInfo4 = null;
                        }
                        accessibilityNodeInfo4 = accessibilityNodeInfo8;
                    } else {
                        if (!accessibilityNodeInfo8.isClickable()) {
                            Rect rectB7 = b(accessibilityNodeInfo8);
                            accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.E(q(accessibilityNodeInfo8, identityHashMap2));
                            if (accessibilityNodeInfo5 != null) {
                            }
                            accessibilityNodeInfo4 = null;
                        }
                        accessibilityNodeInfo4 = accessibilityNodeInfo8;
                    }
                    if (accessibilityNodeInfo4 != null) {
                        arrayList9.add(accessibilityNodeInfo4);
                    }
                    size7 = i42;
                    i60 = i43;
                }
                i43 = i61;
                accessibilityNodeInfo4 = null;
                if (accessibilityNodeInfo4 != null) {
                    arrayList9.add(accessibilityNodeInfo4);
                }
                size7 = i42;
                i60 = i43;
            }
            Set set8 = set;
            List<AccessibilityNodeInfo> listT = mz.t(arrayList9);
            String str3 = "Close ad";
            if (!listT.isEmpty()) {
                if (listT.size() == 1) {
                    return new bw2((AccessibilityNodeInfo) mz.H(listT), "Close ad", 0.97f, false);
                }
                ArrayList arrayList10 = new ArrayList(nz.d(listT));
                for (AccessibilityNodeInfo accessibilityNodeInfo9 : listT) {
                    arrayList10.add("Close ad overlay");
                }
                return new zv2(arrayList10, listT);
            }
            ArrayList arrayList11 = new ArrayList();
            for (Object obj12 : list3) {
                if (wh2.a(set2, sh2Var).contains(o(((gp1) obj12).a))) {
                    arrayList11.add(obj12);
                }
            }
            ArrayList arrayList12 = new ArrayList();
            int size10 = arrayList8.size();
            int i72 = 0;
            while (i72 < size10) {
                Object obj13 = arrayList8.get(i72);
                int i73 = i72 + 1;
                AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) obj13;
                if (!g(accessibilityNodeInfo10) || !accessibilityNodeInfo10.isClickable() || c(accessibilityNodeInfo10) || identityHashMap2.get(accessibilityNodeInfo10) == null || x42Var.a(l(accessibilityNodeInfo10))) {
                    str3 = str3;
                    i36 = size10;
                    i37 = i73;
                } else {
                    ArrayList arrayListN3 = n(accessibilityNodeInfo10);
                    if (arrayListN3.isEmpty()) {
                        i36 = size10;
                    } else {
                        int size11 = arrayListN3.size();
                        i36 = size10;
                        int i74 = 0;
                        while (true) {
                            if (i74 < size11) {
                                Object obj14 = arrayListN3.get(i74);
                                int i75 = i74 + 1;
                                String str4 = (String) obj14;
                                if (cs2.A(str4) || set2.contains(str4)) {
                                    i37 = i73;
                                } else {
                                    i37 = i73;
                                    if (sh2Var.a.containsKey(str4)) {
                                    }
                                }
                                i73 = i37;
                                i74 = i75;
                            }
                            str3 = str3;
                        }
                    }
                    i37 = i73;
                    if (!arrayList11.isEmpty()) {
                        int size12 = arrayList11.size();
                        int i76 = 0;
                        while (true) {
                            if (i76 < size12) {
                                Object obj15 = arrayList11.get(i76);
                                int i77 = i76 + 1;
                                Rect rectG = cq.g(accessibilityNodeInfo10);
                                Rect rect4 = ((gp1) obj15).b;
                                int i78 = size12;
                                int i79 = rect4.right;
                                int i80 = rect4.left;
                                if (i79 > i80) {
                                    set4 = set2;
                                    int i81 = rect4.bottom;
                                    int i82 = rect4.top;
                                    if (i81 > i82) {
                                        sh2Var3 = sh2Var;
                                        int i83 = rectG.right;
                                        x42Var = x42Var;
                                        int i84 = rectG.left;
                                        str3 = str3;
                                        if (i83 > i84 && (i38 = rectG.bottom) > (i39 = rectG.top) && i80 >= i84 && i82 >= i39 && i79 <= i83 && i81 <= i38) {
                                            if (h(accessibilityNodeInfo10, identityHashMap2) || !w(accessibilityNodeInfo10, arrayList8, identityHashMap2, list3)) {
                                                set5 = set8;
                                                x42Var4 = x42Var2;
                                            } else if (arrayList8.isEmpty()) {
                                                set6 = set8;
                                                if (x42Var2.e(l(accessibilityNodeInfo10))) {
                                                    x42Var4 = x42Var2;
                                                    set5 = set6;
                                                    arrayList12.add(obj13);
                                                } else {
                                                    className = accessibilityNodeInfo10.getClassName();
                                                    if (className == null && (string = className.toString()) != null) {
                                                        if (js2.e(string, "Button", false) || js2.e(string, "ImageView", false)) {
                                                            x42Var4 = x42Var2;
                                                            set5 = set6;
                                                        }
                                                        arrayList12.add(obj13);
                                                    }
                                                    accessibilityNodeInfo3 = (AccessibilityNodeInfo) identityHashMap2.get(accessibilityNodeInfo10);
                                                    if (accessibilityNodeInfo3 == null || identityHashMap2.get(accessibilityNodeInfo3) == null) {
                                                        x42Var4 = x42Var2;
                                                        set5 = set6;
                                                    } else {
                                                        Rect rectG2 = cq.g(accessibilityNodeInfo10);
                                                        Rect rectG3 = cq.g(accessibilityNodeInfo3);
                                                        i40 = rectG2.right;
                                                        i41 = rectG2.left;
                                                        int i85 = rectG2.bottom;
                                                        int i86 = rectG2.top;
                                                        long j = ((long) (i85 - i86)) * ((long) (i40 - i41));
                                                        int i87 = rectG3.right;
                                                        x42Var4 = x42Var2;
                                                        int i88 = rectG3.left;
                                                        int i89 = rectG3.bottom;
                                                        int i90 = rectG3.top;
                                                        set5 = set6;
                                                        long j2 = ((long) (i89 - i90)) * ((long) (i87 - i88));
                                                        if (i40 <= i41 && i85 > i86 && i87 > i88 && i89 > i90 && i41 >= i88 && i86 >= i90 && i40 <= i87 && i85 <= i89 && j > 0 && 3 * j < j2) {
                                                            arrayList12.add(obj13);
                                                        }
                                                    }
                                                }
                                            } else {
                                                int size13 = arrayList8.size();
                                                int i91 = 0;
                                                while (true) {
                                                    if (i91 < size13) {
                                                        Object obj16 = arrayList8.get(i91);
                                                        i91++;
                                                        AccessibilityNodeInfo accessibilityNodeInfo11 = (AccessibilityNodeInfo) obj16;
                                                        if (identityHashMap2.get(accessibilityNodeInfo11) == accessibilityNodeInfo10) {
                                                            ArrayList arrayListN4 = n(accessibilityNodeInfo11);
                                                            if (arrayListN4.isEmpty()) {
                                                                continue;
                                                            } else {
                                                                int size14 = arrayListN4.size();
                                                                int i92 = 0;
                                                                while (true) {
                                                                    if (i92 < size14) {
                                                                        Object obj17 = arrayListN4.get(i92);
                                                                        i92++;
                                                                        set6 = set8;
                                                                        if (!set6.contains((String) obj17)) {
                                                                            set8 = set6;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        set8 = set8;
                                                    } else {
                                                        set6 = set8;
                                                        if (x42Var2.e(l(accessibilityNodeInfo10))) {
                                                            x42Var4 = x42Var2;
                                                            set5 = set6;
                                                            arrayList12.add(obj13);
                                                        } else {
                                                            className = accessibilityNodeInfo10.getClassName();
                                                            if (className == null) {
                                                            }
                                                            accessibilityNodeInfo3 = (AccessibilityNodeInfo) identityHashMap2.get(accessibilityNodeInfo10);
                                                            if (accessibilityNodeInfo3 == null) {
                                                                Rect rectG4 = cq.g(accessibilityNodeInfo10);
                                                                Rect rectG5 = cq.g(accessibilityNodeInfo3);
                                                                i40 = rectG4.right;
                                                                i41 = rectG4.left;
                                                                int i810 = rectG4.bottom;
                                                                int i811 = rectG4.top;
                                                                long j3 = ((long) (i810 - i811)) * ((long) (i40 - i41));
                                                                int i812 = rectG5.right;
                                                                x42Var4 = x42Var2;
                                                                int i813 = rectG5.left;
                                                                int i814 = rectG5.bottom;
                                                                int i93 = rectG5.top;
                                                                set5 = set6;
                                                                long j4 = ((long) (i814 - i93)) * ((long) (i812 - i813));
                                                                if (i40 <= i41) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    x42Var4 = x42Var2;
                                                    set5 = set6;
                                                }
                                            }
                                        }
                                    }
                                    size12 = i78;
                                    i76 = i77;
                                    x42Var2 = x42Var2;
                                    set2 = set4;
                                    sh2Var = sh2Var3;
                                    x42Var = x42Var;
                                    str3 = str3;
                                    set8 = set8;
                                } else {
                                    set4 = set2;
                                }
                                sh2Var3 = sh2Var;
                                size12 = i78;
                                i76 = i77;
                                x42Var2 = x42Var2;
                                set2 = set4;
                                sh2Var = sh2Var3;
                                x42Var = x42Var;
                                str3 = str3;
                                set8 = set8;
                            }
                            size10 = i36;
                            i72 = i37;
                            x42Var2 = x42Var4;
                            set2 = set4;
                            sh2Var = sh2Var3;
                            x42Var = x42Var;
                            str3 = str3;
                            set8 = set5;
                        }
                    }
                    str3 = str3;
                }
                x42Var = x42Var;
                set4 = set2;
                sh2Var3 = sh2Var;
                set5 = set8;
                x42Var4 = x42Var2;
                size10 = i36;
                i72 = i37;
                x42Var2 = x42Var4;
                set2 = set4;
                sh2Var = sh2Var3;
                x42Var = x42Var;
                str3 = str3;
                set8 = set5;
            }
            String str5 = str3;
            x42 x42Var5 = x42Var;
            Set set9 = set2;
            sh2 sh2Var4 = sh2Var;
            ArrayList arrayList13 = new ArrayList();
            int size15 = arrayList12.size();
            int i94 = 0;
            while (i94 < size15) {
                Object obj18 = arrayList12.get(i94);
                int i95 = i94 + 1;
                AccessibilityNodeInfo accessibilityNodeInfo12 = (AccessibilityNodeInfo) obj18;
                if (arrayList8.isEmpty()) {
                    arrayList6 = arrayList12;
                    i30 = size15;
                    i31 = i95;
                    arrayList13.add(obj18);
                } else {
                    int size16 = arrayList8.size();
                    int i96 = 0;
                    while (true) {
                        if (i96 < size16) {
                            Object obj19 = arrayList8.get(i96);
                            int i97 = i96 + 1;
                            AccessibilityNodeInfo accessibilityNodeInfo13 = (AccessibilityNodeInfo) obj19;
                            if (accessibilityNodeInfo13 != accessibilityNodeInfo12 && g(accessibilityNodeInfo13) && accessibilityNodeInfo13.isClickable()) {
                                List listQ2 = q(accessibilityNodeInfo13, identityHashMap2);
                                if (listQ2.isEmpty()) {
                                    continue;
                                } else {
                                    Iterator it4 = listQ2.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            continue;
                                        } else if (((AccessibilityNodeInfo) it4.next()) == accessibilityNodeInfo12) {
                                            if (arrayList11.isEmpty()) {
                                                continue;
                                            } else {
                                                int size17 = arrayList11.size();
                                                int i98 = 0;
                                                while (true) {
                                                    if (i98 < size17) {
                                                        Object obj20 = arrayList11.get(i98);
                                                        i98++;
                                                        arrayList6 = arrayList12;
                                                        Rect rectG6 = cq.g(accessibilityNodeInfo13);
                                                        Rect rect5 = ((gp1) obj20).b;
                                                        i30 = size15;
                                                        int i99 = rect5.right;
                                                        i31 = i95;
                                                        int i100 = rect5.left;
                                                        AccessibilityNodeInfo accessibilityNodeInfo14 = accessibilityNodeInfo12;
                                                        if (i99 > i100) {
                                                            int i101 = rect5.bottom;
                                                            int i102 = rect5.top;
                                                            i32 = size16;
                                                            if (i101 > i102) {
                                                                int i103 = rectG6.right;
                                                                i33 = i97;
                                                                int i104 = rectG6.left;
                                                                accessibilityNodeInfo2 = accessibilityNodeInfo13;
                                                                if (i103 <= i104 || (i34 = rectG6.bottom) <= (i35 = rectG6.top) || i100 < i104 || i102 < i35 || i99 > i103 || i101 > i34) {
                                                                }
                                                            }
                                                            arrayList12 = arrayList6;
                                                            size15 = i30;
                                                            i95 = i31;
                                                            accessibilityNodeInfo12 = accessibilityNodeInfo14;
                                                            size16 = i32;
                                                            i97 = i33;
                                                            accessibilityNodeInfo13 = accessibilityNodeInfo2;
                                                        } else {
                                                            i32 = size16;
                                                        }
                                                        i33 = i97;
                                                        accessibilityNodeInfo2 = accessibilityNodeInfo13;
                                                        arrayList12 = arrayList6;
                                                        size15 = i30;
                                                        i95 = i31;
                                                        accessibilityNodeInfo12 = accessibilityNodeInfo14;
                                                        size16 = i32;
                                                        i97 = i33;
                                                        accessibilityNodeInfo13 = accessibilityNodeInfo2;
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            arrayList12 = arrayList12;
                            size15 = size15;
                            i95 = i95;
                            accessibilityNodeInfo12 = accessibilityNodeInfo12;
                            size16 = size16;
                            i96 = i97;
                        } else {
                            arrayList6 = arrayList12;
                            i30 = size15;
                            i31 = i95;
                            arrayList13.add(obj18);
                        }
                    }
                }
                arrayList12 = arrayList6;
                size15 = i30;
                i94 = i31;
            }
            String str6 = "multiple close glyphs";
            String str7 = "close ad";
            if (!arrayList13.isEmpty()) {
                ArrayList arrayList14 = new ArrayList();
                int size18 = arrayList11.size();
                int i105 = 0;
                while (i105 < size18) {
                    Object obj21 = arrayList11.get(i105);
                    int i106 = i105 + 1;
                    gp1 gp1Var = (gp1) obj21;
                    if (arrayList13.isEmpty()) {
                        i24 = size18;
                        i25 = i106;
                        arrayList5 = arrayList11;
                        break;
                    }
                    int size19 = arrayList13.size();
                    int i107 = 0;
                    while (true) {
                        if (i107 >= size19) {
                            i24 = size18;
                            i25 = i106;
                            arrayList5 = arrayList11;
                            break;
                            break;
                        }
                        Object obj22 = arrayList13.get(i107);
                        i107++;
                        Rect rectB8 = b((AccessibilityNodeInfo) obj22);
                        Rect rect6 = gp1Var.b;
                        int i108 = rect6.right;
                        int i109 = rect6.left;
                        if (i108 > i109 && (i26 = rect6.bottom) > (i27 = rect6.top)) {
                            i24 = size18;
                            int i110 = rectB8.right;
                            i25 = i106;
                            int i111 = rectB8.left;
                            arrayList5 = arrayList11;
                            if (i110 > i111 && (i28 = rectB8.bottom) > (i29 = rectB8.top) && i109 >= i111 && i27 >= i29 && i108 <= i110 && i26 <= i28) {
                                arrayList14.add(obj21);
                                break;
                            }
                        } else {
                            i24 = size18;
                            i25 = i106;
                            arrayList5 = arrayList11;
                        }
                        size18 = i24;
                        i106 = i25;
                        arrayList11 = arrayList5;
                    }
                    size18 = i24;
                    i105 = i25;
                    arrayList11 = arrayList5;
                }
                ArrayList arrayList15 = new ArrayList(nz.d(arrayList14));
                int size20 = arrayList14.size();
                int i112 = 0;
                while (i112 < size20) {
                    Object obj23 = arrayList14.get(i112);
                    i112++;
                    arrayList15.add(((gp1) obj23).b);
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList16 = new ArrayList();
                int size21 = arrayList15.size();
                int i113 = 0;
                while (i113 < size21) {
                    Object obj24 = arrayList15.get(i113);
                    i113++;
                    Rect rect7 = (Rect) obj24;
                    if (hashSet.add(rect7.left + "," + rect7.top + "," + rect7.right + "," + rect7.bottom)) {
                        arrayList16.add(obj24);
                    }
                }
                return arrayList16.size() == 1 ? new aw2(p(bitmap, (Rect) mz.H(arrayList16)), str5, 0.96f) : new cw2("close ad", "multiple close glyphs");
            }
            String str8 = str5;
            if (bitmap != null && !bitmap.isRecycled()) {
                ArrayList arrayList17 = new ArrayList();
                int size22 = arrayList8.size();
                int i114 = 0;
                while (i114 < size22) {
                    Object obj25 = arrayList8.get(i114);
                    i114++;
                    AccessibilityNodeInfo accessibilityNodeInfo15 = (AccessibilityNodeInfo) obj25;
                    if (g(accessibilityNodeInfo15) && accessibilityNodeInfo15.isClickable() && !c(accessibilityNodeInfo15) && identityHashMap2.get(accessibilityNodeInfo15) != null) {
                        ArrayList arrayListN5 = n(accessibilityNodeInfo15);
                        if (!arrayListN5.isEmpty()) {
                            int size23 = arrayListN5.size();
                            int i115 = 0;
                            while (true) {
                                if (i115 < size23) {
                                    Object obj26 = arrayListN5.get(i115);
                                    i115++;
                                    if (!cs2.A((String) obj26)) {
                                        x42Var3 = x42Var5;
                                    }
                                }
                            }
                        }
                        x42Var3 = x42Var5;
                        if (!x42Var3.a(l(accessibilityNodeInfo15)) && !h(accessibilityNodeInfo15, identityHashMap2) && w(accessibilityNodeInfo15, arrayList8, identityHashMap2, list3)) {
                            if (arrayList8.isEmpty()) {
                                arrayList17.add(obj25);
                                break;
                            }
                            int size24 = arrayList8.size();
                            int i116 = 0;
                            while (true) {
                                if (i116 >= size24) {
                                    arrayList17.add(obj25);
                                    break;
                                    break;
                                }
                                Object obj27 = arrayList8.get(i116);
                                i116++;
                                AccessibilityNodeInfo accessibilityNodeInfo16 = (AccessibilityNodeInfo) obj27;
                                if (accessibilityNodeInfo16 != accessibilityNodeInfo15 && g(accessibilityNodeInfo16) && accessibilityNodeInfo16.isClickable()) {
                                    List listQ3 = q(accessibilityNodeInfo16, identityHashMap2);
                                    if (!listQ3.isEmpty()) {
                                        Iterator it5 = listQ3.iterator();
                                        while (it5.hasNext()) {
                                            if (((AccessibilityNodeInfo) it5.next()) == accessibilityNodeInfo15) {
                                                break;
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    } else {
                        x42Var3 = x42Var5;
                    }
                    list3 = list;
                    x42Var5 = x42Var3;
                }
                if (arrayList17.size() <= 8) {
                    int size25 = arrayList8.size();
                    int i117 = 0;
                    do {
                        if (i117 >= size25) {
                            obj = null;
                            break;
                        }
                        obj = arrayList8.get(i117);
                        i117++;
                    } while (identityHashMap2.get((AccessibilityNodeInfo) obj) != null);
                    AccessibilityNodeInfo accessibilityNodeInfo17 = (AccessibilityNodeInfo) obj;
                    if (accessibilityNodeInfo17 != null) {
                        Rect rectB9 = b(accessibilityNodeInfo17);
                        ArrayList arrayList18 = new ArrayList(nz.d(arrayList17));
                        int size26 = arrayList17.size();
                        int i118 = 0;
                        while (i118 < size26) {
                            Object obj28 = arrayList17.get(i118);
                            i118++;
                            arrayList18.add(b((AccessibilityNodeInfo) obj28));
                        }
                        ArrayList arrayListA3 = a(arrayList, identityHashMap, list);
                        ArrayList arrayList19 = new ArrayList();
                        int size27 = arrayListA3.size();
                        int i119 = 0;
                        while (i119 < size27) {
                            Object obj29 = arrayListA3.get(i119);
                            int i120 = i119 + 1;
                            Rect rect8 = (Rect) obj29;
                            rect8.getClass();
                            int i121 = rect8.right;
                            int i122 = rect8.left;
                            ii0 ii0Var = ii0.a;
                            if (i121 > i122) {
                                arrayList3 = arrayListA3;
                                int i123 = rect8.bottom;
                                i21 = size27;
                                int i124 = rect8.top;
                                if (i123 > i124) {
                                    i22 = i120;
                                    int i125 = rectB9.right;
                                    str8 = str8;
                                    int i126 = rectB9.left;
                                    str6 = str6;
                                    if (i125 > i126) {
                                        int i127 = rectB9.bottom;
                                        str7 = str7;
                                        int i128 = rectB9.top;
                                        if (i127 > i128 && i122 >= i126 && i124 >= i128 && i121 <= i125 && i123 <= i127 && 5 <= (i23 = i123 - i124) && i23 < 129) {
                                            List<wt1> listI = nz.i(new wt1(Integer.valueOf(i126), Integer.valueOf(rect8.left)), new wt1(Integer.valueOf(rect8.right), Integer.valueOf(rectB9.right)));
                                            arrayList4 = new ArrayList();
                                            for (wt1 wt1Var : listI) {
                                                int iIntValue = ((Number) wt1Var.a).intValue();
                                                int iIntValue2 = ((Number) wt1Var.b).intValue();
                                                if (iIntValue2 - iIntValue < i23) {
                                                    rect = null;
                                                } else {
                                                    rect = new Rect();
                                                    rect.left = iIntValue;
                                                    rect.right = iIntValue2;
                                                    int i129 = i23 * 2;
                                                    rect.top = Math.max(rectB9.top, rect8.top - i129);
                                                    rect.bottom = Math.min(rectB9.bottom, rect8.bottom + i129);
                                                }
                                                if (rect != null) {
                                                    arrayList4.add(rect);
                                                }
                                            }
                                        }
                                    } else {
                                        str7 = str7;
                                    }
                                    arrayList4 = ii0Var;
                                }
                                rz.q(arrayList4, arrayList19);
                                arrayListA3 = arrayList3;
                                size27 = i21;
                                i119 = i22;
                                str6 = str6;
                                str7 = str7;
                                str8 = str8;
                            } else {
                                arrayList3 = arrayListA3;
                                i21 = size27;
                            }
                            i22 = i120;
                            arrayList4 = ii0Var;
                            rz.q(arrayList4, arrayList19);
                            arrayListA3 = arrayList3;
                            size27 = i21;
                            i119 = i22;
                            str6 = str6;
                            str7 = str7;
                            str8 = str8;
                        }
                        String str9 = str8;
                        String str10 = str6;
                        String str11 = str7;
                        ArrayList arrayListG = mz.G(arrayList18, arrayList19);
                        ArrayList arrayList20 = new ArrayList();
                        int size28 = arrayListG.size();
                        int i130 = 0;
                        while (i130 < size28) {
                            Object obj30 = arrayListG.get(i130);
                            i130++;
                            rz.q(ul4.b(bitmap, (Rect) obj30), arrayList20);
                        }
                        ArrayList arrayList21 = new ArrayList();
                        int size29 = arrayList20.size();
                        int i131 = 0;
                        while (i131 < size29) {
                            Object obj31 = arrayList20.get(i131);
                            int i132 = i131 + 1;
                            Rect rect9 = (Rect) obj31;
                            if (!list.isEmpty()) {
                                Iterator it6 = list.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        arrayList2 = arrayList20;
                                        set3 = set9;
                                        sh2Var2 = sh2Var4;
                                        if (arrayList8.isEmpty()) {
                                            size = arrayList8.size();
                                            i4 = 0;
                                            while (true) {
                                                if (i4 < size) {
                                                    i2 = size29;
                                                    i3 = i132;
                                                    arrayListA = a(arrayList, identityHashMap, list);
                                                    if (arrayListA.isEmpty()) {
                                                        size3 = arrayListA.size();
                                                        i20 = 0;
                                                        while (true) {
                                                            if (i20 < size3) {
                                                                obj2 = arrayListA.get(i20);
                                                                i20++;
                                                                if (s(rect9, (Rect) obj2)) {
                                                                }
                                                            } else if (arrayList17.isEmpty()) {
                                                                size2 = arrayList17.size();
                                                                i12 = 0;
                                                                while (i12 < size2) {
                                                                    Object obj32 = arrayList17.get(i12);
                                                                    i12++;
                                                                    Rect rectB10 = b((AccessibilityNodeInfo) obj32);
                                                                    rect9.getClass();
                                                                    i13 = rect9.right;
                                                                    i14 = rect9.left;
                                                                    if (i13 <= i14) {
                                                                        i15 = size2;
                                                                    } else {
                                                                        i15 = size2;
                                                                    }
                                                                    size2 = i15;
                                                                }
                                                            }
                                                            arrayList21.add(obj31);
                                                            break;
                                                            break;
                                                        }
                                                    } else if (arrayList17.isEmpty()) {
                                                        size2 = arrayList17.size();
                                                        i12 = 0;
                                                        while (i12 < size2) {
                                                            Object obj33 = arrayList17.get(i12);
                                                            i12++;
                                                            Rect rectB11 = b((AccessibilityNodeInfo) obj33);
                                                            rect9.getClass();
                                                            i13 = rect9.right;
                                                            i14 = rect9.left;
                                                            if (i13 <= i14) {
                                                                i15 = size2;
                                                            } else {
                                                                i15 = size2;
                                                            }
                                                            size2 = i15;
                                                        }
                                                    }
                                                } else {
                                                    Object obj34 = arrayList8.get(i4);
                                                    i4++;
                                                    accessibilityNodeInfo = (AccessibilityNodeInfo) obj34;
                                                    if (h(accessibilityNodeInfo, identityHashMap2)) {
                                                        Rect rectB12 = b(accessibilityNodeInfo);
                                                        rect9.getClass();
                                                        i6 = rect9.right;
                                                        i7 = rect9.left;
                                                        if (i6 > i7) {
                                                            i5 = size;
                                                            i2 = size29;
                                                            i3 = i132;
                                                        } else {
                                                            i5 = size;
                                                            i2 = size29;
                                                            i3 = i132;
                                                        }
                                                    } else {
                                                        i5 = size;
                                                        i2 = size29;
                                                        i3 = i132;
                                                    }
                                                    arrayList8 = arrayList;
                                                    identityHashMap2 = identityHashMap;
                                                    size = i5;
                                                    size29 = i2;
                                                    i132 = i3;
                                                }
                                            }
                                        } else {
                                            i2 = size29;
                                            i3 = i132;
                                            arrayListA = a(arrayList, identityHashMap, list);
                                            if (arrayListA.isEmpty()) {
                                                size3 = arrayListA.size();
                                                i20 = 0;
                                                while (true) {
                                                    if (i20 < size3) {
                                                        obj2 = arrayListA.get(i20);
                                                        i20++;
                                                        if (s(rect9, (Rect) obj2)) {
                                                        }
                                                    } else if (arrayList17.isEmpty()) {
                                                        size2 = arrayList17.size();
                                                        i12 = 0;
                                                        while (i12 < size2) {
                                                            Object obj35 = arrayList17.get(i12);
                                                            i12++;
                                                            Rect rectB13 = b((AccessibilityNodeInfo) obj35);
                                                            rect9.getClass();
                                                            i13 = rect9.right;
                                                            i14 = rect9.left;
                                                            if (i13 <= i14) {
                                                                i15 = size2;
                                                            } else {
                                                                i15 = size2;
                                                            }
                                                            size2 = i15;
                                                        }
                                                    }
                                                    arrayList21.add(obj31);
                                                    break;
                                                    break;
                                                }
                                            } else if (arrayList17.isEmpty()) {
                                                size2 = arrayList17.size();
                                                i12 = 0;
                                                while (i12 < size2) {
                                                    Object obj36 = arrayList17.get(i12);
                                                    i12++;
                                                    Rect rectB14 = b((AccessibilityNodeInfo) obj36);
                                                    rect9.getClass();
                                                    i13 = rect9.right;
                                                    i14 = rect9.left;
                                                    if (i13 <= i14) {
                                                        i15 = size2;
                                                    } else {
                                                        i15 = size2;
                                                    }
                                                    size2 = i15;
                                                }
                                            }
                                        }
                                    } else {
                                        gp1 gp1Var2 = (gp1) it6.next();
                                        set3 = set9;
                                        sh2Var2 = sh2Var4;
                                        if (wh2.a(set3, sh2Var2).contains(o(gp1Var2.a))) {
                                            arrayList2 = arrayList20;
                                        } else {
                                            Rect rect10 = gp1Var2.b;
                                            rect9.getClass();
                                            arrayList2 = arrayList20;
                                            if (Math.min(rect10.right, rect9.right) > Math.max(rect10.left, rect9.left) && Math.min(rect10.bottom, rect9.bottom) > Math.max(rect10.top, rect9.top)) {
                                                i2 = size29;
                                                i3 = i132;
                                            }
                                        }
                                        arrayList20 = arrayList2;
                                        set9 = set3;
                                        sh2Var4 = sh2Var2;
                                    }
                                }
                            } else {
                                arrayList2 = arrayList20;
                                set3 = set9;
                                sh2Var2 = sh2Var4;
                                if (arrayList8.isEmpty()) {
                                    size = arrayList8.size();
                                    i4 = 0;
                                    while (true) {
                                        if (i4 < size) {
                                            i2 = size29;
                                            i3 = i132;
                                            arrayListA = a(arrayList, identityHashMap, list);
                                            if (arrayListA.isEmpty()) {
                                                size3 = arrayListA.size();
                                                i20 = 0;
                                                while (true) {
                                                    if (i20 < size3) {
                                                        obj2 = arrayListA.get(i20);
                                                        i20++;
                                                        if (s(rect9, (Rect) obj2)) {
                                                        }
                                                    } else if (arrayList17.isEmpty()) {
                                                        size2 = arrayList17.size();
                                                        i12 = 0;
                                                        while (i12 < size2) {
                                                            Object obj37 = arrayList17.get(i12);
                                                            i12++;
                                                            Rect rectB15 = b((AccessibilityNodeInfo) obj37);
                                                            rect9.getClass();
                                                            i13 = rect9.right;
                                                            i14 = rect9.left;
                                                            if (i13 <= i14) {
                                                                i15 = size2;
                                                            } else {
                                                                i15 = size2;
                                                            }
                                                            size2 = i15;
                                                        }
                                                    }
                                                    arrayList21.add(obj31);
                                                    break;
                                                    break;
                                                }
                                            } else if (arrayList17.isEmpty()) {
                                                size2 = arrayList17.size();
                                                i12 = 0;
                                                while (i12 < size2) {
                                                    Object obj38 = arrayList17.get(i12);
                                                    i12++;
                                                    Rect rectB16 = b((AccessibilityNodeInfo) obj38);
                                                    rect9.getClass();
                                                    i13 = rect9.right;
                                                    i14 = rect9.left;
                                                    if (i13 <= i14) {
                                                        i15 = size2;
                                                    } else {
                                                        i15 = size2;
                                                    }
                                                    size2 = i15;
                                                }
                                            }
                                        } else {
                                            Object obj39 = arrayList8.get(i4);
                                            i4++;
                                            accessibilityNodeInfo = (AccessibilityNodeInfo) obj39;
                                            if (h(accessibilityNodeInfo, identityHashMap2)) {
                                                Rect rectB17 = b(accessibilityNodeInfo);
                                                rect9.getClass();
                                                i6 = rect9.right;
                                                i7 = rect9.left;
                                                if (i6 > i7 || (i8 = rect9.bottom) <= (i9 = rect9.top)) {
                                                    i5 = size;
                                                    i2 = size29;
                                                    i3 = i132;
                                                } else {
                                                    i5 = size;
                                                    int i133 = rectB17.right;
                                                    i2 = size29;
                                                    int i134 = rectB17.left;
                                                    i3 = i132;
                                                    if (i133 <= i134 || (i10 = rectB17.bottom) <= (i11 = rectB17.top) || i7 < i134 || i9 < i11 || i6 > i133 || i8 > i10) {
                                                    }
                                                }
                                            } else {
                                                i5 = size;
                                                i2 = size29;
                                                i3 = i132;
                                            }
                                            arrayList8 = arrayList;
                                            identityHashMap2 = identityHashMap;
                                            size = i5;
                                            size29 = i2;
                                            i132 = i3;
                                        }
                                    }
                                } else {
                                    i2 = size29;
                                    i3 = i132;
                                    arrayListA = a(arrayList, identityHashMap, list);
                                    if (arrayListA.isEmpty()) {
                                        size3 = arrayListA.size();
                                        i20 = 0;
                                        while (true) {
                                            if (i20 < size3) {
                                                obj2 = arrayListA.get(i20);
                                                i20++;
                                                if (s(rect9, (Rect) obj2)) {
                                                }
                                            } else if (arrayList17.isEmpty()) {
                                                size2 = arrayList17.size();
                                                i12 = 0;
                                                while (i12 < size2) {
                                                    Object obj310 = arrayList17.get(i12);
                                                    i12++;
                                                    Rect rectB18 = b((AccessibilityNodeInfo) obj310);
                                                    rect9.getClass();
                                                    i13 = rect9.right;
                                                    i14 = rect9.left;
                                                    if (i13 <= i14) {
                                                        i15 = size2;
                                                    } else {
                                                        i15 = size2;
                                                    }
                                                    size2 = i15;
                                                }
                                            }
                                            arrayList21.add(obj31);
                                            break;
                                            break;
                                        }
                                    } else if (arrayList17.isEmpty()) {
                                        size2 = arrayList17.size();
                                        i12 = 0;
                                        while (i12 < size2) {
                                            Object obj311 = arrayList17.get(i12);
                                            i12++;
                                            Rect rectB19 = b((AccessibilityNodeInfo) obj311);
                                            rect9.getClass();
                                            i13 = rect9.right;
                                            i14 = rect9.left;
                                            if (i13 <= i14 && (i16 = rect9.bottom) > (i17 = rect9.top) && (i18 = rectB19.right) > (i19 = rectB19.left)) {
                                                i15 = size2;
                                                int i135 = rectB19.bottom;
                                                int i136 = rectB19.top;
                                                if (i135 > i136 && i14 >= i19 && i17 >= i136 && i13 <= i18 && i16 <= i135) {
                                                    arrayList21.add(obj31);
                                                    break;
                                                }
                                            } else {
                                                i15 = size2;
                                            }
                                            size2 = i15;
                                        }
                                    }
                                }
                            }
                            arrayList8 = arrayList;
                            identityHashMap2 = identityHashMap;
                            arrayList20 = arrayList2;
                            set9 = set3;
                            sh2Var4 = sh2Var2;
                            size29 = i2;
                            i131 = i3;
                        }
                        ArrayList arrayList22 = new ArrayList();
                        int size30 = arrayList21.size();
                        int i137 = 0;
                        while (i137 < size30) {
                            Object obj40 = arrayList21.get(i137);
                            i137++;
                            Rect rect11 = (Rect) obj40;
                            if (!arrayList22.isEmpty()) {
                                int size31 = arrayList22.size();
                                int i138 = 0;
                                while (true) {
                                    if (i138 < size31) {
                                        Object obj41 = arrayList22.get(i138);
                                        i138++;
                                        Rect rect12 = (Rect) obj41;
                                        rect12.getClass();
                                        rect11.getClass();
                                        if (Math.min(rect12.right, rect11.right) > Math.max(rect12.left, rect11.left) && Math.min(rect12.bottom, rect11.bottom) > Math.max(rect12.top, rect11.top)) {
                                            break;
                                        }
                                    }
                                }
                            }
                            arrayList22.add(rect11);
                        }
                        int size32 = arrayList22.size();
                        if (size32 != 0) {
                            return size32 != 1 ? new cw2(str11, str10) : new aw2(p(bitmap, (Rect) mz.H(arrayList22)), str9, 0.94f);
                        }
                    }
                }
            }
        }
        return dw2.a;
    }

    public static boolean s(Rect rect, Rect rect2) {
        if (!u(rect) || !u(rect2) || (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top)) * 2 < Math.min(rect.bottom - rect.top, rect2.bottom - rect2.top)) {
            return false;
        }
        int i2 = rect2.right;
        int i3 = rect.left;
        int i4 = rect.right;
        int i5 = (i4 - i3) / 5;
        return i2 <= i3 + i5 || i4 - i5 <= rect2.left;
    }

    public static String t(wc2 wc2Var) {
        Set set;
        x42 x42Var;
        int i2;
        wc2Var.getClass();
        List<ob2> list = wc2Var.c;
        if (!g31.a(wc2Var.a, "com.google.android.youtube")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            set = f;
            x42Var = i;
            if (!zHasNext) {
                break;
            }
            Object next = it.next();
            ob2 ob2Var = (ob2) next;
            if (u(ob2Var.d) && !ob2Var.f && !x42Var.a(e(ob2Var)) && (set.contains(o(ob2Var.a)) || h.a(e(ob2Var)))) {
                arrayList.add(next);
            }
        }
        Rect rect = new Rect();
        for (ob2 ob2Var2 : list) {
            if (u(ob2Var2.d)) {
                rect.union(ob2Var2.d);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list.iterator();
        while (true) {
            i2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            ob2 ob2Var3 = (ob2) next2;
            String strE = e(ob2Var3);
            Rect rect2 = ob2Var3.d;
            String strO = o(ob2Var3.a);
            if (ob2Var3.e && !ob2Var3.f && !ob2Var3.g && u(rect2) && !x42Var.a(strE)) {
                if (!c.contains(strE) && !d.a.containsKey(strO)) {
                    if (d(rect2, rect) && (cs2.A(strO) || e.contains(strO) || g.e(strE))) {
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            while (i2 < size) {
                                Object obj = arrayList.get(i2);
                                i2++;
                                ob2 ob2Var4 = (ob2) obj;
                                String str = ob2Var4.a;
                                Rect rect3 = ob2Var4.d;
                                if (set.contains(o(str)) ? s(rect2, rect3) : k(rect2, rect3)) {
                                }
                            }
                        }
                    }
                }
                arrayList2.add(next2);
                break;
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return null;
        }
        ArrayList arrayListG = mz.G(arrayList, arrayList2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayListG.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayListG.get(i3);
            i3++;
            if (hashSet.add(f((ob2) obj2))) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
        int size3 = arrayList3.size();
        while (i2 < size3) {
            Object obj3 = arrayList3.get(i2);
            i2++;
            arrayList4.add(f((ob2) obj3));
        }
        return mz.C(mz.J(arrayList4), "|", null, null, null, 62);
    }

    public static boolean u(Rect rect) {
        return rect.right > rect.left && rect.bottom > rect.top;
    }

    public static List v(wc2 wc2Var, Rect rect) {
        wc2Var.getClass();
        rect.getClass();
        if (g31.a(wc2Var.a, "com.google.android.youtube")) {
            List list = wc2Var.c;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                ob2 ob2Var = (ob2) obj;
                if (f.contains(o(ob2Var.a)) && s(rect, ob2Var.d)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    arrayList2.add(((ob2) obj2).d);
                }
                return mz.F(arrayList2, rect);
            }
        }
        return ii0.a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static boolean w(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, IdentityHashMap identityHashMap, List list) {
        int i2;
        int i3;
        int i4;
        int i5;
        List<AccessibilityNodeInfo> listU;
        List listQ = q(accessibilityNodeInfo, identityHashMap);
        Rect rectB = b(accessibilityNodeInfo);
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) mz.E(listQ);
        if (accessibilityNodeInfo2 == null || !d(rectB, b(accessibilityNodeInfo2))) {
            return false;
        }
        ArrayList arrayListA = a(arrayList, identityHashMap, list);
        if (arrayListA.isEmpty()) {
            listU = mz.u(1, listQ);
            if (listU.isEmpty()) {
                return false;
            }
            for (AccessibilityNodeInfo accessibilityNodeInfo3 : listU) {
                if (h.a(l(accessibilityNodeInfo3)) || !k(rectB, b(accessibilityNodeInfo3))) {
                }
            }
            return false;
        }
        int size = arrayListA.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayListA.get(i6);
            i6++;
            Rect rect = (Rect) obj;
            if (s(rectB, rect) && !listQ.isEmpty()) {
                Iterator it = listQ.iterator();
                while (it.hasNext()) {
                    Rect rectB2 = b((AccessibilityNodeInfo) it.next());
                    rect.getClass();
                    int i7 = rect.right;
                    int i8 = rect.left;
                    if (i7 > i8 && (i2 = rect.bottom) > (i3 = rect.top) && (i4 = rectB2.right) > (i5 = rectB2.left)) {
                        int i9 = rectB2.bottom;
                        int i10 = rectB2.top;
                        if (i9 <= i10 || i8 < i5 || i3 < i10 || i7 > i4 || i2 > i9) {
                        }
                    }
                }
            }
        }
        listU = mz.u(1, listQ);
        if (listU.isEmpty()) {
            return false;
        }
        while (r1.hasNext()) {
            if (h.a(l(accessibilityNodeInfo3))) {
            }
        }
        return false;
        return true;
    }
}
