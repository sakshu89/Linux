package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nb2 {
    public final r2 a;
    public final Context b;
    public final dd3 c;
    public final LinkedHashMap d;
    public final LinkedHashSet e;
    public long f;
    public final xc2 g;
    public final Set h;
    public final Set i;
    public final Set j;
    public final x42 k;
    public final x42 l;
    public final x42 m;
    public final Set n;

    public nb2(r2 r2Var, Context context, dd3 dd3Var) {
        r2Var.getClass();
        dd3Var.getClass();
        this.a = r2Var;
        this.b = context;
        this.c = dd3Var;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashSet();
        this.g = new xc2();
        this.h = wh2.c("skip", "skip ad", "skip the ad", "skip ads", "skip advertisement", "skip advertisements");
        this.i = wh2.c("skip", "skip ad", "skip ads", "skip advertisement", "skip advertisements", "विज्ञापन छोड़ें", "विज्ञापन छोड़ें");
        this.j = wh2.c("skip_ad_button", "ad_skip_button", "skip_ad", "skip_ads_button", "skip_ad_button_container", "skip_ad_button_text", "ad_skip_button_text", "video_ad_skip_button");
        this.k = new x42("(?:^|_)(?:title|headline|thumbnail|video_renderer|video_card|channel_name|channel_header|avatar)(?:_|$)");
        this.l = new x42("(?:^|_)(?:ad_overlay|ad_container|ad_player|instream_ad|video_ads)(?:_|$)");
        this.m = new x42("\\b(?:\\d+(?::\\d{2}){1,2}|\\d+\\s+(?:minutes?|seconds?|hours?))\\b", y42.IGNORE_CASE);
        this.n = wh2.c("menuitem_search", "action_search", "toolbar_search", "search_button", "menu_search", "search_holder", "search_src_text", "search_view", "search_button_container");
    }

    public static boolean C(AccessibilityService accessibilityService, Rect rect) {
        if (rect.right <= rect.left || rect.bottom <= rect.top) {
            return false;
        }
        Path path = new Path();
        path.moveTo((rect.left + rect.right) / 2.0f, (rect.top + rect.bottom) / 2.0f);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), null, null);
    }

    public static final boolean f(String str, AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rectG = cq.g(accessibilityNodeInfo2);
        if (cs2.A(str)) {
            return false;
        }
        CharSequence packageName = accessibilityNodeInfo2.getPackageName();
        return g31.a(packageName != null ? packageName.toString() : null, str) && accessibilityNodeInfo2.getWindowId() == accessibilityNodeInfo.getWindowId() && accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && !accessibilityNodeInfo2.isPassword() && m(rect, rectG);
    }

    public static String k(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        int i = 0;
        while (i < 4) {
            if (parent == null) {
                return null;
            }
            try {
                if (t(parent)) {
                    parent.recycle();
                    return null;
                }
                if (parent.isClickable()) {
                    String strX = x(parent);
                    parent.recycle();
                    return strX;
                }
                AccessibilityNodeInfo parent2 = parent.getParent();
                parent.recycle();
                i++;
                parent = parent2;
            } catch (Throwable th) {
                parent.recycle();
                throw th;
            }
        }
        if (parent != null) {
            parent.recycle();
        }
        return null;
    }

    public static ArrayList l(AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(accessibilityNodeInfo);
        int i = 0;
        while (!arrayDeque.isEmpty()) {
            int i2 = i + 1;
            if (i >= 1000) {
                break;
            }
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayDeque.removeFirst();
            if (!accessibilityNodeInfo2.isPassword()) {
                if (accessibilityNodeInfo2.isVisibleToUser()) {
                    arrayList.add(accessibilityNodeInfo2);
                }
                int childCount = accessibilityNodeInfo2.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo2.getChild(i3);
                    if (child != null) {
                        arrayDeque.add(child);
                    }
                }
                if (!accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2 != accessibilityNodeInfo) {
                    accessibilityNodeInfo2.recycle();
                }
            } else if (accessibilityNodeInfo2 != accessibilityNodeInfo) {
                accessibilityNodeInfo2.recycle();
            }
            i = i2;
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((AccessibilityNodeInfo) it.next()).recycle();
        }
        return arrayList;
    }

    public static boolean m(Rect rect, Rect rect2) {
        int i;
        int i2;
        int i3 = rect2.right;
        int i4 = rect2.left;
        return i3 > i4 && (i = rect2.bottom) > (i2 = rect2.top) && rect.left <= i4 && rect.top <= i2 && rect.right >= i3 && rect.bottom >= i;
    }

    public static List n(ArrayList arrayList) {
        String strK;
        if (arrayList.size() <= 1) {
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (hashSet.add((accessibilityNodeInfo.isClickable() || (strK = k(accessibilityNodeInfo)) == null) ? x(accessibilityNodeInfo) : strK)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    public static List p(List list) {
        CharSequence contentDescription;
        String string;
        String string2;
        String string3;
        String string4;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) it.next();
            CharSequence text = accessibilityNodeInfo.getText();
            String str = null;
            if (text == null || (string3 = text.toString()) == null || (string4 = cs2.V(string3).toString()) == null) {
                contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription != null && (string = contentDescription.toString()) != null && (string2 = cs2.V(string).toString()) != null && !cs2.A(string2)) {
                    str = string2;
                }
            } else {
                if (cs2.A(string4)) {
                    string4 = null;
                }
                if (string4 == null) {
                    contentDescription = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription != null) {
                        str = string2;
                    }
                } else {
                    str = string4;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return mz.L(mz.t(arrayList), 6);
    }

    public static boolean r(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int i = 0;
        if (cs2.A(str)) {
            return false;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.google.android.youtube:id/search_query");
        if (listFindAccessibilityNodeInfosByViewId == null) {
            listFindAccessibilityNodeInfosByViewId = ii0.a;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listFindAccessibilityNodeInfosByViewId.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) next;
                if (accessibilityNodeInfo2.refresh() && g31.a(accessibilityNodeInfo2.getViewIdResourceName(), "com.google.android.youtube:id/search_query")) {
                    CharSequence packageName = accessibilityNodeInfo2.getPackageName();
                    if (g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube") && accessibilityNodeInfo2.getWindowId() == accessibilityNodeInfo.getWindowId() && accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && !accessibilityNodeInfo2.isPassword() && !ie2.g(accessibilityNodeInfo2)) {
                        arrayList.add(next);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                CharSequence text = ((AccessibilityNodeInfo) obj).getText();
                String string = text != null ? text.toString() : null;
                if (string == null) {
                    string = "";
                }
                String string2 = cs2.V(string).toString();
                Locale locale = Locale.ROOT;
                locale.getClass();
                String lowerCase = string2.toLowerCase(locale);
                lowerCase.getClass();
                Pattern patternCompile = Pattern.compile("\\s+");
                patternCompile.getClass();
                String strReplaceAll = patternCompile.matcher(lowerCase).replaceAll(Padder.FALLBACK_PADDING_STRING);
                strReplaceAll.getClass();
                arrayList2.add(strReplaceAll);
            }
            Object objI = mz.I(mz.t(arrayList2));
            String string3 = cs2.V(str).toString();
            Locale locale2 = Locale.ROOT;
            locale2.getClass();
            String lowerCase2 = string3.toLowerCase(locale2);
            lowerCase2.getClass();
            Pattern patternCompile2 = Pattern.compile("\\s+");
            patternCompile2.getClass();
            String strReplaceAll2 = patternCompile2.matcher(lowerCase2).replaceAll(Padder.FALLBACK_PADDING_STRING);
            strReplaceAll2.getClass();
            return g31.a(objI, strReplaceAll2);
        } finally {
            for (AccessibilityNodeInfo accessibilityNodeInfo3 : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo3 != accessibilityNodeInfo) {
                    accessibilityNodeInfo3.recycle();
                }
            }
        }
    }

    public static boolean t(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence className = accessibilityNodeInfo.getClassName();
        String string = className != null ? className.toString() : null;
        if (string == null) {
            string = "";
        }
        return accessibilityNodeInfo.isScrollable() || cs2.n(string, "RecyclerView", false) || cs2.n(string, "ListView", false) || cs2.n(string, "ScrollView", false) || cs2.n(string, "ViewPager", false);
    }

    public static boolean u(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence text = accessibilityNodeInfo.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        String string2 = contentDescription != null ? contentDescription.toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        String strK = cq.k(string, Padder.FALLBACK_PADDING_STRING, string2);
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        String lowerCase = (viewIdResourceName != null ? viewIdResourceName : "").toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        Pattern patternCompile = Pattern.compile("\\b(?:sponsored|advertisement|ad|playlist|shorts)\\b", 66);
        patternCompile.getClass();
        return patternCompile.matcher(strK).find() || cs2.n(lowerCase, "shorts", false) || cs2.n(lowerCase, "playlist", false) || cs2.n(lowerCase, "channel_renderer", false);
    }

    public static boolean w(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strO;
        String strO2;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        String strO3 = null;
        if (g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube") && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && !accessibilityNodeInfo.isPassword()) {
            Rect rectG = cq.g(accessibilityNodeInfo);
            if (rectG.right > rectG.left && rectG.bottom > rectG.top) {
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    String strS = cs2.S(viewIdResourceName, '/');
                    Locale locale = Locale.ROOT;
                    strO = cq.o(locale, strS, locale);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription == null || (string4 = contentDescription.toString()) == null || (string5 = cs2.V(string4).toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale2 = Locale.ROOT;
                    strO2 = cq.o(locale2, string5, locale2);
                }
                if (strO2 == null) {
                    strO2 = "";
                }
                CharSequence text = accessibilityNodeInfo.getText();
                if (text != null && (string2 = text.toString()) != null && (string3 = cs2.V(string2).toString()) != null) {
                    Locale locale3 = Locale.ROOT;
                    strO3 = cq.o(locale3, string3, locale3);
                }
                String str = strO3 != null ? strO3 : "";
                if (!cs2.n(strO, "skip", false) && !cs2.n(strO2, "skip ad", false) && !cs2.n(str, "skip ad", false)) {
                    boolean zContains = wh2.c("next", "next_button", "player_next_button", "player_control_next_button", "next_video_button", "exo_next").contains(strO);
                    CharSequence className = accessibilityNodeInfo.getClassName();
                    boolean z = (className == null || (string = className.toString()) == null || !cs2.n(string, "Button", false)) ? false : true;
                    boolean z2 = wh2.c("next video", "next", "अगला वीडियो").contains(strO2) || wh2.c("next video", "next", "अगला वीडियो").contains(str);
                    if (zContains || (z && z2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String x(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rectG = cq.g(accessibilityNodeInfo);
        return mz.C(nz.i(accessibilityNodeInfo.getPackageName(), Integer.valueOf(accessibilityNodeInfo.getWindowId()), accessibilityNodeInfo.getViewIdResourceName(), accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription(), Integer.valueOf(rectG.left), Integer.valueOf(rectG.top), Integer.valueOf(rectG.right), Integer.valueOf(rectG.bottom)), "|", null, null, null, 62);
    }

    public static boolean y(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        int i = 0;
        while (true) {
            if (i >= 4) {
                if (parent != null) {
                    parent.recycle();
                }
                Rect rectG = cq.g(accessibilityNodeInfo);
                if (rectG.isEmpty() || rectG.width() <= 0 || rectG.height() <= 0) {
                    return false;
                }
                Path path = new Path();
                path.moveTo(rectG.exactCenterX(), rectG.exactCenterY());
                return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 100L)).build(), null, null);
            }
            if (parent != null) {
                try {
                    CharSequence className = parent.getClassName();
                    String string = className != null ? className.toString() : null;
                    if (string == null) {
                        string = "";
                    }
                    boolean z = cs2.n(string, "RecyclerView", false) || cs2.n(string, "AbsListView", false) || cs2.n(string, "ScrollView", false) || cs2.n(string, "ViewPager", false) || parent.getChildCount() > 4;
                    if (parent.isClickable() && !z) {
                        boolean zPerformAction = parent.performAction(16);
                        parent.recycle();
                        return zPerformAction;
                    }
                    AccessibilityNodeInfo parent2 = parent.getParent();
                    parent.recycle();
                    parent = parent2;
                } catch (Throwable th) {
                    parent.recycle();
                    throw th;
                }
            }
            i++;
        }
    }

    public static boolean z(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        String lowerCase;
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        if (parent != null) {
            try {
                String viewIdResourceName = parent.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    Locale locale = Locale.ROOT;
                    locale.getClass();
                    lowerCase = viewIdResourceName.toLowerCase(locale);
                    lowerCase.getClass();
                } else {
                    lowerCase = null;
                }
                if (lowerCase == null) {
                    lowerCase = "";
                }
                Rect rect2 = new Rect();
                parent.getBoundsInScreen(rect2);
                boolean z = (rect2.width() > rect.width() + 100 || rect2.height() > rect.height() + 50 || cs2.n(lowerCase, "avatar", false) || cs2.n(lowerCase, "logo", false) || cs2.n(lowerCase, "header", false) || cs2.n(lowerCase, "channel", false)) ? false : true;
                if (parent.isClickable() && z) {
                    boolean zPerformAction = parent.performAction(16);
                    parent.recycle();
                    return zPerformAction;
                }
                parent.recycle();
            } catch (Throwable th) {
                parent.recycle();
                throw th;
            }
        }
        if (rect.isEmpty() || rect.width() <= 0 || rect.height() <= 0) {
            return false;
        }
        Path path = new Path();
        path.moveTo(rect.exactCenterX(), rect.exactCenterY());
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), null, null);
    }

    public final void A(AccessibilityService accessibilityService, String str) {
        Object obj;
        String lowerCase;
        String str2;
        AccessibilityNodeInfo accessibilityNodeInfoC = this.a.c();
        if (accessibilityNodeInfoC == null) {
            return;
        }
        if (str != null) {
            CharSequence packageName = accessibilityNodeInfoC.getPackageName();
            if (!g31.a(packageName != null ? packageName.toString() : null, str)) {
                accessibilityNodeInfoC.recycle();
                return;
            }
        }
        Rect rect = new Rect();
        try {
            ArrayList arrayListL = l(accessibilityNodeInfoC);
            int size = arrayListL.size();
            int i = 0;
            int i2 = 0;
            do {
                if (i2 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayListL.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = null;
                }
                str2 = "";
                if (lowerCase == null) {
                    lowerCase = "";
                }
                CharSequence className = accessibilityNodeInfo.getClassName();
                String string = className != null ? className.toString() : null;
                if (string != null) {
                    str2 = string;
                }
                if (cs2.n(lowerCase, "player", false) || cs2.n(lowerCase, "video", false) || cs2.n(str2, "SurfaceView", false)) {
                    break;
                }
            } while (!cs2.n(str2, "Player", false));
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2 != null) {
                accessibilityNodeInfo2.getBoundsInScreen(rect);
            } else {
                accessibilityNodeInfoC.getBoundsInScreen(rect);
            }
            int size2 = arrayListL.size();
            while (i < size2) {
                Object obj2 = arrayListL.get(i);
                i++;
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj2;
                if (!g31.a(accessibilityNodeInfo3, accessibilityNodeInfoC)) {
                    accessibilityNodeInfo3.recycle();
                }
            }
            accessibilityNodeInfoC.recycle();
            if (rect.isEmpty() || rect.width() <= 0 || rect.height() <= 0) {
                return;
            }
            Path path = new Path();
            path.moveTo(rect.centerX(), rect.centerY());
            accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), null, null);
            try {
                Thread.sleep(200L);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            accessibilityNodeInfoC.recycle();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:104:0x01bc A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #1 {all -> 0x01c1, blocks: (B:99:0x01a5, B:102:0x01ad, B:104:0x01bc), top: B:250:0x01a5 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:177:0x029d  */
    /* JADX WARN: Code duplicated, block: B:250:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:268:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x0202 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x01a2 A[DONT_INVERT] */
    public final lb2 B(String str, ArrayList arrayList) throws Throwable {
        int i;
        Integer numValueOf;
        String str2;
        mb2 mb2Var;
        int i2;
        int i3;
        String str3;
        boolean z;
        Object obj;
        CharSequence text;
        CharSequence text2;
        mb2 mb2Var2;
        AccessibilityNodeInfo parent;
        int i4;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        String viewIdResourceName;
        String lowerCase;
        CharSequence contentDescription;
        String string;
        int i5;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList2.get(i6);
            int i7 = i6 + 1;
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj2;
            String viewIdResourceName2 = accessibilityNodeInfo3.getViewIdResourceName();
            String strS = viewIdResourceName2 != null ? cs2.S(viewIdResourceName2, '/') : null;
            String str4 = "";
            if (strS == null) {
                strS = "";
            }
            CharSequence contentDescription2 = accessibilityNodeInfo3.getContentDescription();
            String string2 = contentDescription2 != null ? contentDescription2.toString() : null;
            if (string2 == null) {
                string2 = "";
            }
            CharSequence text3 = accessibilityNodeInfo3.getText();
            String string3 = text3 != null ? text3.toString() : null;
            if (string3 == null) {
                string3 = "";
            }
            boolean zContains = wh2.c("title", "video_title", "title_text").contains(strS);
            x42 x42Var = this.m;
            if (zContains || (accessibilityNodeInfo3.isClickable() && x42Var.a(string2))) {
                Rect rectG = cq.g(accessibilityNodeInfo3);
                i2 = size;
                i3 = i7;
                if (rectG.right > rectG.left && rectG.bottom > rectG.top) {
                    AccessibilityNodeInfo parent2 = accessibilityNodeInfo3.getParent();
                    int i8 = 0;
                    while (true) {
                        AccessibilityNodeInfo accessibilityNodeInfo4 = parent2;
                        if (i8 >= 6) {
                            str3 = str4;
                            if (accessibilityNodeInfo4 != null) {
                                accessibilityNodeInfo4.recycle();
                            }
                        } else if (accessibilityNodeInfo4 == null) {
                            str3 = str4;
                        } else {
                            try {
                                String viewIdResourceName3 = accessibilityNodeInfo4.getViewIdResourceName();
                                if (viewIdResourceName3 == null) {
                                    viewIdResourceName3 = str4;
                                }
                                int i9 = i8;
                                String lowerCase2 = viewIdResourceName3.toLowerCase(Locale.ROOT);
                                lowerCase2.getClass();
                                String str5 = str4;
                                if (!cs2.n(lowerCase2, "promoted", false) && !cs2.n(lowerCase2, "ad_container", false) && !cs2.n(lowerCase2, "ad_renderer", false) && !u(accessibilityNodeInfo4)) {
                                    parent2 = accessibilityNodeInfo4.getParent();
                                    accessibilityNodeInfo4.recycle();
                                    i8 = i9 + 1;
                                    str4 = str5;
                                }
                                accessibilityNodeInfo4.recycle();
                            } catch (Throwable th) {
                                accessibilityNodeInfo4.recycle();
                                throw th;
                            }
                        }
                        if (!u(accessibilityNodeInfo3)) {
                            String strC = mz.C(nz.i(string3, string2), Padder.FALLBACK_PADDING_STRING, null, null, null, 62);
                            ArrayList arrayList4 = new ArrayList();
                            int size2 = arrayList2.size();
                            String str6 = string2;
                            int i10 = 0;
                            while (i10 < size2) {
                                int i11 = size2;
                                Object obj3 = arrayList2.get(i10);
                                int i12 = i10 + 1;
                                Rect rect = new Rect();
                                ((AccessibilityNodeInfo) obj3).getBoundsInScreen(rect);
                                if (m(rectG, rect)) {
                                    arrayList4.add(obj3);
                                }
                                arrayList2 = arrayList;
                                size2 = i11;
                                i10 = i12;
                            }
                            if (x42Var.a(strC)) {
                                z = true;
                            } else if (arrayList4.isEmpty()) {
                                parent = accessibilityNodeInfo3.getParent();
                                i4 = 0;
                                while (true) {
                                    if (i4 < 5) {
                                        accessibilityNodeInfo = parent;
                                        if (accessibilityNodeInfo != null) {
                                            accessibilityNodeInfo.recycle();
                                        }
                                    } else if (parent == null) {
                                        try {
                                            viewIdResourceName = parent.getViewIdResourceName();
                                            if (viewIdResourceName == null) {
                                                viewIdResourceName = str3;
                                            }
                                            lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                                            lowerCase.getClass();
                                            contentDescription = parent.getContentDescription();
                                            if (contentDescription != null) {
                                                string = contentDescription.toString();
                                            } else {
                                                string = null;
                                            }
                                            if (string == null) {
                                                string = str3;
                                            }
                                            accessibilityNodeInfo2 = parent;
                                            try {
                                                i5 = i4;
                                                if (!cs2.n(lowerCase, "video_renderer", false) && !cs2.n(lowerCase, "video_card", false) && !x42Var.a(string)) {
                                                    parent = accessibilityNodeInfo2.getParent();
                                                    accessibilityNodeInfo2.recycle();
                                                    i4 = i5 + 1;
                                                }
                                                accessibilityNodeInfo2.recycle();
                                                z = true;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                accessibilityNodeInfo2.recycle();
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            accessibilityNodeInfo2 = parent;
                                        }
                                    }
                                    z = false;
                                }
                            } else {
                                int size3 = arrayList4.size();
                                int i13 = 0;
                                while (true) {
                                    if (i13 < size3) {
                                        Object obj4 = arrayList4.get(i13);
                                        i13++;
                                        AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj4;
                                        CharSequence text4 = accessibilityNodeInfo5.getText();
                                        String string4 = text4 != null ? text4.toString() : null;
                                        if (string4 == null) {
                                            string4 = str3;
                                        }
                                        CharSequence contentDescription3 = accessibilityNodeInfo5.getContentDescription();
                                        String string5 = contentDescription3 != null ? contentDescription3.toString() : null;
                                        if (string5 == null) {
                                            string5 = str3;
                                        }
                                        int i14 = size3;
                                        if (!x42Var.a(string4 + Padder.FALLBACK_PADDING_STRING + string5)) {
                                            size3 = i14;
                                        }
                                    } else {
                                        parent = accessibilityNodeInfo3.getParent();
                                        i4 = 0;
                                        while (true) {
                                            if (i4 < 5) {
                                                accessibilityNodeInfo = parent;
                                                if (accessibilityNodeInfo != null) {
                                                    accessibilityNodeInfo.recycle();
                                                }
                                            } else if (parent == null) {
                                                viewIdResourceName = parent.getViewIdResourceName();
                                                if (viewIdResourceName == null) {
                                                    viewIdResourceName = str3;
                                                }
                                                lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                                                lowerCase.getClass();
                                                contentDescription = parent.getContentDescription();
                                                if (contentDescription != null) {
                                                    string = contentDescription.toString();
                                                } else {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    string = str3;
                                                }
                                                accessibilityNodeInfo2 = parent;
                                                i5 = i4;
                                                if (!cs2.n(lowerCase, "video_renderer", false)) {
                                                    parent = accessibilityNodeInfo2.getParent();
                                                    accessibilityNodeInfo2.recycle();
                                                    i4 = i5 + 1;
                                                }
                                                accessibilityNodeInfo2.recycle();
                                            }
                                            z = false;
                                        }
                                    }
                                    z = true;
                                }
                            }
                            boolean z2 = wh2.c("video_title", "title_text").contains(strS) || (strS.equals("title") && z);
                            if (z2 || (accessibilityNodeInfo3.isClickable() && z && !cs2.A(str6))) {
                                if (!z2 || cs2.A(string3)) {
                                    int size4 = arrayList4.size();
                                    int i15 = 0;
                                    while (true) {
                                        if (i15 >= size4) {
                                            obj = null;
                                            break;
                                        }
                                        obj = arrayList4.get(i15);
                                        i15++;
                                        AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj;
                                        Set setC = wh2.c("title", "video_title", "title_text");
                                        String viewIdResourceName4 = accessibilityNodeInfo6.getViewIdResourceName();
                                        if (mz.s(viewIdResourceName4 != null ? cs2.S(viewIdResourceName4, '/') : null, setC) && (text2 = accessibilityNodeInfo6.getText()) != null && !cs2.A(text2)) {
                                            break;
                                        }
                                    }
                                    AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj;
                                    if (accessibilityNodeInfo7 == null || (text = accessibilityNodeInfo7.getText()) == null || (string3 = text.toString()) == null) {
                                        string3 = kd3.a(str6);
                                    }
                                }
                                if (!cs2.A(string3)) {
                                    mb2Var2 = new mb2(accessibilityNodeInfo3, string3, rectG);
                                }
                            }
                        }
                    }
                }
                if (mb2Var2 != null) {
                    arrayList3.add(mb2Var2);
                }
                arrayList2 = arrayList;
                size = i2;
                i6 = i3;
            } else {
                i2 = size;
                i3 = i7;
            }
            mb2Var2 = null;
            if (mb2Var2 != null) {
                arrayList3.add(mb2Var2);
            }
            arrayList2 = arrayList;
            size = i2;
            i6 = i3;
        }
        List<mb2> listK = mz.K(arrayList3, new i2(12, new i2(11, new lo0(22))));
        ArrayList arrayList5 = new ArrayList();
        for (mb2 mb2Var3 : listK) {
            if (!arrayList5.isEmpty()) {
                int size5 = arrayList5.size();
                int i16 = 0;
                do {
                    if (i16 < size5) {
                        Object obj5 = arrayList5.get(i16);
                        i16++;
                        mb2Var = (mb2) obj5;
                        if (!m(mb2Var.c, mb2Var3.c)) {
                        }
                    }
                } while (!m(mb2Var3.c, mb2Var.c));
            }
            arrayList5.add(mb2Var3);
        }
        Pattern patternCompile = Pattern.compile("^(?:the\\s+)?(first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|[1-9])\\s+(?:youtube\\s+)?(?:video|result)(?:\\s+on\\s+youtube)?$", 66);
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str);
        matcher.getClass();
        fh1 fh1Var = !matcher.matches() ? null : new fh1(matcher, str);
        if (fh1Var == null || (str2 = (String) ((dh1) fh1Var.a()).get(1)) == null) {
            Pattern patternCompile2 = Pattern.compile("^(?:video|result)\\s+([1-9])$", 66);
            patternCompile2.getClass();
            Matcher matcher2 = patternCompile2.matcher(str);
            matcher2.getClass();
            fh1 fh1Var2 = !matcher2.matches() ? null : new fh1(matcher2, str);
            if (fh1Var2 != null) {
                i = 1;
                String str7 = (String) ((dh1) fh1Var2.a()).get(1);
                if (str7 != null) {
                    numValueOf = Integer.valueOf(Integer.parseInt(str7));
                }
            } else {
                i = 1;
            }
            numValueOf = null;
        } else {
            String lowerCase3 = str2.toLowerCase(Locale.ROOT);
            lowerCase3.getClass();
            Integer numL = js2.l(10, lowerCase3);
            numValueOf = Integer.valueOf(numL != null ? numL.intValue() : nz.i("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth").indexOf(lowerCase3) + 1);
            i = 1;
        }
        if (numValueOf != null) {
            mb2 mb2Var4 = (mb2) mz.z(numValueOf.intValue() - i, arrayList5);
            if (mb2Var4 != null) {
                return new jb2(mb2Var4.a, mb2Var4.b);
            }
        } else {
            String lowerCase4 = cs2.V(cs2.I(str, " video")).toString().toLowerCase(Locale.ROOT);
            lowerCase4.getClass();
            ArrayList arrayList6 = new ArrayList();
            int size6 = arrayList5.size();
            int i17 = 0;
            while (i17 < size6) {
                Object obj6 = arrayList5.get(i17);
                i17++;
                String lowerCase5 = ((mb2) obj6).b.toLowerCase(Locale.ROOT);
                lowerCase5.getClass();
                if (lowerCase5.equals(lowerCase4)) {
                    arrayList6.add(obj6);
                }
            }
            if (arrayList6.isEmpty()) {
                arrayList6 = new ArrayList();
                int size7 = arrayList5.size();
                int i18 = 0;
                while (i18 < size7) {
                    Object obj7 = arrayList5.get(i18);
                    i18++;
                    String lowerCase6 = ((mb2) obj7).b.toLowerCase(Locale.ROOT);
                    lowerCase6.getClass();
                    if (cs2.n(lowerCase6, lowerCase4, false)) {
                        arrayList6.add(obj7);
                    }
                }
            }
            int i19 = 0;
            if (arrayList6.size() == 1) {
                return new jb2(((mb2) mz.H(arrayList6)).a, ((mb2) mz.H(arrayList6)).b);
            }
            if (arrayList6.size() > 1) {
                ArrayList arrayList7 = new ArrayList(nz.d(arrayList6));
                int size8 = arrayList6.size();
                while (i19 < size8) {
                    Object obj8 = arrayList6.get(i19);
                    i19++;
                    arrayList7.add(((mb2) obj8).a);
                }
                return a(arrayList7);
            }
            if (!js2.e(str, " video", true)) {
                return null;
            }
        }
        return kb2.a;
    }

    /* JADX WARN: Code duplicated, block: B:219:0x034a  */
    /* JADX WARN: Code duplicated, block: B:224:0x035c  */
    /* JADX WARN: Code duplicated, block: B:236:0x0386 A[Catch: all -> 0x00c8, TryCatch #1 {all -> 0x00c8, blocks: (B:56:0x00bb, B:58:0x00bf, B:156:0x026a, B:158:0x0270, B:160:0x0276, B:162:0x027c, B:164:0x0282, B:166:0x0288, B:168:0x028e, B:171:0x029a, B:173:0x02ac, B:175:0x02b2, B:177:0x02b8, B:179:0x02c2, B:181:0x02c8, B:183:0x02d6, B:184:0x02dc, B:187:0x02e3, B:189:0x02e9, B:191:0x02f3, B:193:0x02f9, B:195:0x02ff, B:197:0x0305, B:199:0x030b, B:201:0x0311, B:221:0x034d, B:223:0x0359, B:227:0x0361, B:204:0x0318, B:206:0x0320, B:208:0x0326, B:210:0x032c, B:212:0x0332, B:214:0x0338, B:216:0x033e, B:228:0x0371, B:230:0x0377, B:232:0x037d, B:248:0x03a2, B:249:0x03a8, B:253:0x03ae, B:236:0x0386, B:238:0x038c, B:240:0x0392, B:262:0x03dd, B:266:0x03e3, B:61:0x00cc, B:66:0x00d5, B:75:0x0103, B:79:0x010a), top: B:284:0x00bb }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0398  */
    /* JADX WARN: Code duplicated, block: B:244:0x039b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:245:0x039d  */
    /* JADX WARN: Code duplicated, block: B:246:0x039f  */
    public final v3 D(String str, String str2) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoB;
        AccessibilityNodeInfo accessibilityNodeInfo;
        ew2 ew2VarC;
        CharSequence contentDescription;
        String string;
        v3 t3Var;
        boolean z;
        ClipboardManager clipboardManager;
        xc2 xc2Var = this.g;
        str.getClass();
        r2 r2Var = this.a;
        if (r2Var.i() == null || (accessibilityNodeInfoB = r2Var.b()) == null) {
            return u3.a;
        }
        boolean z2 = str2 != null && ie2.f(str2);
        List list = ii0.a;
        List<AccessibilityNodeInfo> listL = z2 ? list : l(accessibilityNodeInfoB);
        ew2 ew2Var = null;
        try {
            x42 x42Var = ie2.a;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listL) {
                if (ie2.g((AccessibilityNodeInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            String str3 = "input field";
            if (z2) {
                x42 x42Var2 = ie2.a;
                String str4 = "";
                String strL = ie2.l(str2 == null ? "" : str2);
                CharSequence packageName = accessibilityNodeInfoB.getPackageName();
                if (!ie2.j(strL, packageName != null ? packageName.toString() : null)) {
                    if (str2 != null) {
                        str4 = str2;
                    }
                    t3 t3Var2 = new t3(str4, list);
                    List listH = nz.h(accessibilityNodeInfoB);
                    xc2Var.getClass();
                    xc2.b(null, listH);
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : listL) {
                        if (!g31.a(accessibilityNodeInfo2, accessibilityNodeInfoB)) {
                            accessibilityNodeInfo2.recycle();
                        }
                    }
                    accessibilityNodeInfoB.recycle();
                    return t3Var2;
                }
                List listH2 = nz.h(accessibilityNodeInfoB);
                xc2Var.getClass();
                ew2VarC = xc2.c("search", listH2, list, true, null);
                try {
                    if (!(ew2VarC instanceof bw2)) {
                        if (ew2VarC instanceof zv2) {
                            if (str2 != null) {
                                str4 = str2;
                            }
                            r3 r3VarQ = q(str4, ((zv2) ew2VarC).b, list);
                            xc2.b(ew2VarC, nz.h(accessibilityNodeInfoB));
                            for (AccessibilityNodeInfo accessibilityNodeInfo3 : listL) {
                                if (!g31.a(accessibilityNodeInfo3, accessibilityNodeInfoB)) {
                                    accessibilityNodeInfo3.recycle();
                                }
                            }
                            accessibilityNodeInfoB.recycle();
                            return r3VarQ;
                        }
                        if (str2 != null) {
                            str4 = str2;
                        }
                        t3 t3Var3 = new t3(str4, list);
                        xc2.b(ew2VarC, nz.h(accessibilityNodeInfoB));
                        for (AccessibilityNodeInfo accessibilityNodeInfo4 : listL) {
                            if (!g31.a(accessibilityNodeInfo4, accessibilityNodeInfoB)) {
                                accessibilityNodeInfo4.recycle();
                            }
                        }
                        accessibilityNodeInfoB.recycle();
                        return t3Var3;
                    }
                    accessibilityNodeInfo = ((bw2) ew2VarC).a;
                    str2 = str2;
                } catch (Throwable th) {
                    th = th;
                    ew2Var = ew2VarC;
                    List listH3 = nz.h(accessibilityNodeInfoB);
                    xc2Var.getClass();
                    xc2.b(ew2Var, listH3);
                    for (AccessibilityNodeInfo accessibilityNodeInfo5 : listL) {
                        if (!g31.a(accessibilityNodeInfo5, accessibilityNodeInfoB)) {
                            accessibilityNodeInfo5.recycle();
                        }
                    }
                    accessibilityNodeInfoB.recycle();
                    throw th;
                }
            } else {
                if (str2 == null || cs2.A(str2)) {
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        if (((AccessibilityNodeInfo) obj2).isFocused()) {
                            arrayList2.add(obj2);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        arrayList = arrayList2;
                    }
                    if (arrayList.size() > 1) {
                        r3 r3VarQ2 = q("input field", arrayList, list);
                        List listH4 = nz.h(accessibilityNodeInfoB);
                        xc2Var.getClass();
                        xc2.b(null, listH4);
                        for (AccessibilityNodeInfo accessibilityNodeInfo6 : listL) {
                            if (!g31.a(accessibilityNodeInfo6, accessibilityNodeInfoB)) {
                                accessibilityNodeInfo6.recycle();
                            }
                        }
                        accessibilityNodeInfoB.recycle();
                        return r3VarQ2;
                    }
                    accessibilityNodeInfo = (AccessibilityNodeInfo) mz.I(arrayList);
                } else {
                    lb2 lb2VarO = o(cs2.V(str2).toString(), arrayList);
                    if (!(lb2VarO instanceof jb2)) {
                        if (lb2VarO instanceof ib2) {
                            r3 r3Var = new r3(str2, ((ib2) lb2VarO).a, ((ib2) lb2VarO).b, null, 8);
                            List listH5 = nz.h(accessibilityNodeInfoB);
                            xc2Var.getClass();
                            xc2.b(null, listH5);
                            for (AccessibilityNodeInfo accessibilityNodeInfo7 : listL) {
                                if (!g31.a(accessibilityNodeInfo7, accessibilityNodeInfoB)) {
                                    accessibilityNodeInfo7.recycle();
                                }
                            }
                            accessibilityNodeInfoB.recycle();
                            return r3Var;
                        }
                        if (!(lb2VarO instanceof kb2)) {
                            throw new b10();
                        }
                        t3 t3Var4 = new t3(str2, p(arrayList));
                        List listH6 = nz.h(accessibilityNodeInfoB);
                        xc2Var.getClass();
                        xc2.b(null, listH6);
                        for (AccessibilityNodeInfo accessibilityNodeInfo8 : listL) {
                            if (!g31.a(accessibilityNodeInfo8, accessibilityNodeInfoB)) {
                                accessibilityNodeInfo8.recycle();
                            }
                        }
                        accessibilityNodeInfoB.recycle();
                        return t3Var4;
                    }
                    accessibilityNodeInfo = ((jb2) lb2VarO).a;
                }
                if (accessibilityNodeInfo == null) {
                    if (str2 != 0) {
                        str3 = str2;
                    }
                    t3 t3Var5 = new t3(str3, p(listL));
                    List listH7 = nz.h(accessibilityNodeInfoB);
                    xc2Var.getClass();
                    xc2.b(null, listH7);
                    for (AccessibilityNodeInfo accessibilityNodeInfo9 : listL) {
                        if (!g31.a(accessibilityNodeInfo9, accessibilityNodeInfoB)) {
                            accessibilityNodeInfo9.recycle();
                        }
                    }
                    accessibilityNodeInfoB.recycle();
                    return t3Var5;
                }
                ew2VarC = null;
            }
            if (ie2.g(accessibilityNodeInfo)) {
                CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                String string2 = packageName2 != null ? packageName2.toString() : null;
                CharSequence packageName3 = accessibilityNodeInfoB.getPackageName();
                if (g31.a(string2, packageName3 != null ? packageName3.toString() : null) && accessibilityNodeInfo.getWindowId() == accessibilityNodeInfoB.getWindowId()) {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
                    boolean zPerformAction = accessibilityNodeInfo.performAction(ArabicShaping.SEEN_TWOCELL_NEAR, bundle);
                    if (!zPerformAction && (accessibilityNodeInfo.isFocused() || accessibilityNodeInfo.performAction(1))) {
                        boolean zRefresh = accessibilityNodeInfo.refresh();
                        CharSequence text = accessibilityNodeInfo.getText();
                        String string3 = text != null ? text.toString() : null;
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("ACTION_ARGUMENT_SELECTION_START_INT", 0);
                        bundle2.putInt("ACTION_ARGUMENT_SELECTION_END_INT", string3 != null ? string3.length() : 0);
                        if (zRefresh && string3 != null && ie2.g(accessibilityNodeInfo) && accessibilityNodeInfo.getWindowId() == accessibilityNodeInfoB.getWindowId()) {
                            CharSequence packageName4 = accessibilityNodeInfo.getPackageName();
                            String string4 = packageName4 != null ? packageName4.toString() : null;
                            CharSequence packageName5 = accessibilityNodeInfoB.getPackageName();
                            if (g31.a(string4, packageName5 != null ? packageName5.toString() : null)) {
                                if (string3.length() != 0) {
                                    if (accessibilityNodeInfo.performAction(Normalizer.INPUT_IS_FCD, bundle2) && accessibilityNodeInfo.refresh()) {
                                        CharSequence text2 = accessibilityNodeInfo.getText();
                                        if (!g31.a(text2 != null ? text2.toString() : null, string3) || accessibilityNodeInfo.getTextSelectionStart() != 0 || accessibilityNodeInfo.getTextSelectionEnd() != string3.length()) {
                                        }
                                    }
                                    z = false;
                                }
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            Object systemService = this.b.getSystemService("clipboard");
                            if (systemService instanceof ClipboardManager) {
                                clipboardManager = (ClipboardManager) systemService;
                            } else {
                                clipboardManager = null;
                            }
                        } else {
                            clipboardManager = null;
                        }
                        if (z && clipboardManager != null) {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("sonic", str));
                            zPerformAction = accessibilityNodeInfo.performAction(32768);
                        }
                    }
                    CharSequence text3 = accessibilityNodeInfo.getText();
                    if (text3 == null || (string = text3.toString()) == null) {
                        contentDescription = accessibilityNodeInfo.getContentDescription();
                        if (contentDescription != null || (string = contentDescription.toString()) == null || cs2.A(string)) {
                            string = null;
                        }
                        if (string == null) {
                            if (str2 == null) {
                                string = "input field";
                            } else {
                                string = str2;
                            }
                        }
                    } else {
                        if (cs2.A(string)) {
                            string = null;
                        }
                        if (string == null) {
                            contentDescription = accessibilityNodeInfo.getContentDescription();
                            if (contentDescription != null) {
                                string = null;
                            } else {
                                string = null;
                            }
                            if (string == null) {
                                if (str2 == null) {
                                    string = "input field";
                                } else {
                                    string = str2;
                                }
                            }
                        }
                    }
                    if (zPerformAction) {
                        t3Var = new s3(string, null, null);
                    } else {
                        if (str2 != null) {
                            str3 = str2;
                        }
                        t3Var = new t3(str3, p(listL));
                    }
                    List listH8 = nz.h(accessibilityNodeInfoB);
                    xc2Var.getClass();
                    xc2.b(ew2VarC, listH8);
                    for (AccessibilityNodeInfo accessibilityNodeInfo10 : listL) {
                        if (!g31.a(accessibilityNodeInfo10, accessibilityNodeInfoB)) {
                            accessibilityNodeInfo10.recycle();
                        }
                    }
                    accessibilityNodeInfoB.recycle();
                    return t3Var;
                }
            }
            if (str2 != null) {
                str3 = str2;
            }
            t3 t3Var6 = new t3(str3, list);
            List listH9 = nz.h(accessibilityNodeInfoB);
            xc2Var.getClass();
            xc2.b(ew2VarC, listH9);
            for (AccessibilityNodeInfo accessibilityNodeInfo11 : listL) {
                if (!g31.a(accessibilityNodeInfo11, accessibilityNodeInfoB)) {
                    accessibilityNodeInfo11.recycle();
                }
            }
            accessibilityNodeInfoB.recycle();
            return t3Var6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean E(String str, String str2) {
        str2.getClass();
        if (s(str)) {
            return true;
        }
        if (str2.equals("com.google.android.youtube") && !js2.k(str, "sonic-node:", false)) {
            Locale locale = Locale.ROOT;
            String strO = cq.o(locale, str, locale);
            if ((cs2.n(strO, "subscribe", false) && !cs2.n(strO, "unsubscribe", false)) || cs2.n(strO, "like", false) || cs2.n(strO, "thumbs", false) || js2.e(strO, " video", false)) {
                return true;
            }
            Pattern patternCompile = Pattern.compile("\\b(?:video|result)\\s+[1-9]$|\\b(?:first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|[1-9])\\s+(?:youtube\\s+)?(?:video|result)\\b");
            patternCompile.getClass();
            if (patternCompile.matcher(strO).find()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    public final ib2 a(List list) {
        CharSequence contentDescription;
        String string;
        String string2;
        LinkedHashMap linkedHashMap = this.d;
        linkedHashMap.clear();
        this.e.clear();
        List<AccessibilityNodeInfo> listL = mz.L(list, 4);
        ArrayList arrayList = new ArrayList(nz.d(listL));
        for (AccessibilityNodeInfo accessibilityNodeInfo : listL) {
            long j = this.f + 1;
            this.f = j;
            String str = "sonic-node:" + j;
            linkedHashMap.put(str, x(accessibilityNodeInfo));
            arrayList.add(str);
        }
        ArrayList arrayList2 = new ArrayList(nz.d(listL));
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : listL) {
            CharSequence text = accessibilityNodeInfo2.getText();
            String str2 = null;
            if (text == null || (string = text.toString()) == null) {
                contentDescription = accessibilityNodeInfo2.getContentDescription();
                if (contentDescription != null && (string2 = contentDescription.toString()) != null && !cs2.A(string2)) {
                    str2 = string2;
                }
                if (str2 == null) {
                    string = "element";
                } else {
                    string = str2;
                }
            } else {
                if (cs2.A(string)) {
                    string = null;
                }
                if (string == null) {
                    contentDescription = accessibilityNodeInfo2.getContentDescription();
                    if (contentDescription != null) {
                        str2 = string2;
                    }
                    if (str2 == null) {
                        string = "element";
                    } else {
                        string = str2;
                    }
                }
            }
            arrayList2.add(string);
        }
        return new ib2(arrayList2, arrayList);
    }

    public final v3 b(String str) throws Throwable {
        Throwable th;
        v3 v3VarQ;
        boolean z;
        v3 t3Var;
        boolean zY;
        ed3 ed3Var;
        v3 t3Var2;
        v3 t3Var3;
        xc2 xc2Var = this.g;
        str.getClass();
        if (s(str)) {
            return i();
        }
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI == null) {
            return u3.a;
        }
        List listJ = nz.j(r2Var.b());
        boolean zIsEmpty = listJ.isEmpty();
        ii0 ii0Var = ii0.a;
        if (zIsEmpty) {
            return new t3(str, ii0Var);
        }
        String string = cs2.V(str).toString();
        if (cs2.A(string)) {
            Iterator it = listJ.iterator();
            while (it.hasNext()) {
                ((AccessibilityNodeInfo) it.next()).recycle();
            }
            return new t3(str, ii0Var);
        }
        int i = 0;
        ew2 ew2Var = null;
        if (!ie2.f(string)) {
            List list = dc2.e;
            if (yz3.b(string) == null && !yc3.m(string)) {
                Set set = xc2.a;
                if (!g24.a(string)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = listJ.iterator();
                    while (it2.hasNext()) {
                        rz.q(l((AccessibilityNodeInfo) it2.next()), arrayList);
                    }
                    try {
                        if (!listJ.isEmpty()) {
                            Iterator it3 = listJ.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z = false;
                                    break;
                                }
                                CharSequence packageName = ((AccessibilityNodeInfo) it3.next()).getPackageName();
                                if (g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube")) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            z = false;
                            break;
                        }
                        if (z && !js2.k(string, "sonic-node:", false)) {
                            Locale locale = Locale.ROOT;
                            locale.getClass();
                            String lowerCase = string.toLowerCase(locale);
                            lowerCase.getClass();
                            boolean zN = cs2.n(lowerCase, "subscribe", false);
                            ed3 ed3Var2 = ed3.c;
                            if (zN && !cs2.n(lowerCase, "unsubscribe", false)) {
                                ed3Var = ed3Var2;
                            } else if (cs2.n(lowerCase, "dislike", false) || cs2.n(lowerCase, "thumbs down", false)) {
                                ed3Var = ed3.b;
                            } else {
                                ed3Var = (cs2.n(lowerCase, "like", false) || cs2.n(lowerCase, "thumbs up", false)) ? ed3.a : null;
                            }
                            if (ed3Var == ed3Var2) {
                                v3 v3VarJ = j();
                                int size = arrayList.size();
                                while (i < size) {
                                    Object obj = arrayList.get(i);
                                    i++;
                                    AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                                    if (!listJ.isEmpty()) {
                                        Iterator it4 = listJ.iterator();
                                        do {
                                            if (it4.hasNext()) {
                                            }
                                        } while (!g31.a((AccessibilityNodeInfo) it4.next(), accessibilityNodeInfo));
                                    }
                                    accessibilityNodeInfo.recycle();
                                }
                                Iterator it5 = listJ.iterator();
                                while (it5.hasNext()) {
                                    ((AccessibilityNodeInfo) it5.next()).recycle();
                                }
                                return v3VarJ;
                            }
                            if (ed3Var != null) {
                                this.c.getClass();
                                iv0 iv0VarC = dd3.c(ed3Var, listJ);
                                if (iv0VarC instanceof fv0) {
                                    t3Var3 = new s3(((fv0) iv0VarC).a, null, null);
                                } else if (iv0VarC instanceof gv0) {
                                    jv0 jv0Var = ((gv0) iv0VarC).a;
                                    t3Var3 = y(accessibilityServiceI, jv0Var.b) ? new s3(jv0Var.e, null, null) : new t3(string, ii0Var);
                                } else {
                                    if (!iv0VarC.equals(hv0.a)) {
                                        throw new b10();
                                    }
                                    t3Var3 = new t3(string, p(arrayList));
                                }
                                int size2 = arrayList.size();
                                while (i < size2) {
                                    Object obj2 = arrayList.get(i);
                                    i++;
                                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                                    if (!listJ.isEmpty()) {
                                        Iterator it6 = listJ.iterator();
                                        do {
                                            if (it6.hasNext()) {
                                            }
                                        } while (!g31.a((AccessibilityNodeInfo) it6.next(), accessibilityNodeInfo2));
                                    }
                                    accessibilityNodeInfo2.recycle();
                                }
                                Iterator it7 = listJ.iterator();
                                while (it7.hasNext()) {
                                    ((AccessibilityNodeInfo) it7.next()).recycle();
                                }
                                return t3Var3;
                            }
                            lb2 lb2VarB = B(string, arrayList);
                            if (lb2VarB != null) {
                                if (lb2VarB instanceof jb2) {
                                    t3Var2 = y(accessibilityServiceI, ((jb2) lb2VarB).a) ? new s3(((jb2) lb2VarB).b, null, null) : new t3(string, ii0Var);
                                } else if (lb2VarB instanceof ib2) {
                                    t3Var2 = new r3(string, ((ib2) lb2VarB).a, ((ib2) lb2VarB).b, null, 8);
                                } else {
                                    if (!lb2VarB.equals(kb2.a)) {
                                        throw new b10();
                                    }
                                    t3Var2 = new t3(string, p(arrayList));
                                }
                                int size3 = arrayList.size();
                                while (i < size3) {
                                    Object obj3 = arrayList.get(i);
                                    i++;
                                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                                    if (!listJ.isEmpty()) {
                                        Iterator it8 = listJ.iterator();
                                        do {
                                            if (it8.hasNext()) {
                                            }
                                        } while (!g31.a((AccessibilityNodeInfo) it8.next(), accessibilityNodeInfo3));
                                    }
                                    accessibilityNodeInfo3.recycle();
                                }
                                Iterator it9 = listJ.iterator();
                                while (it9.hasNext()) {
                                    ((AccessibilityNodeInfo) it9.next()).recycle();
                                }
                                return t3Var2;
                            }
                        }
                        lb2 lb2VarO = o(string, arrayList);
                        if ((lb2VarO instanceof kb2) && z && !js2.k(string, "sonic-node:", false)) {
                            A(accessibilityServiceI, null);
                            List listJ2 = nz.j(r2Var.b());
                            if (!listJ2.isEmpty()) {
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it10 = listJ2.iterator();
                                while (it10.hasNext()) {
                                    rz.q(l((AccessibilityNodeInfo) it10.next()), arrayList2);
                                }
                                lb2 lb2VarO2 = o(string, arrayList2);
                                if (lb2VarO2 instanceof jb2) {
                                    boolean zY2 = y(accessibilityServiceI, ((jb2) lb2VarO2).a);
                                    List listP = p(arrayList2);
                                    int size4 = arrayList2.size();
                                    int i2 = 0;
                                    while (i2 < size4) {
                                        Object obj4 = arrayList2.get(i2);
                                        i2++;
                                        AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj4;
                                        if (!listJ2.isEmpty()) {
                                            Iterator it11 = listJ2.iterator();
                                            do {
                                                if (it11.hasNext()) {
                                                }
                                            } while (!g31.a((AccessibilityNodeInfo) it11.next(), accessibilityNodeInfo4));
                                        }
                                        accessibilityNodeInfo4.recycle();
                                    }
                                    Iterator it12 = listJ2.iterator();
                                    while (it12.hasNext()) {
                                        ((AccessibilityNodeInfo) it12.next()).recycle();
                                    }
                                    v3 s3Var = zY2 ? new s3(((jb2) lb2VarO2).b, null, null) : new t3(string, listP);
                                    int size5 = arrayList.size();
                                    while (i < size5) {
                                        Object obj5 = arrayList.get(i);
                                        i++;
                                        AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj5;
                                        if (!listJ.isEmpty()) {
                                            Iterator it13 = listJ.iterator();
                                            do {
                                                if (it13.hasNext()) {
                                                }
                                            } while (!g31.a((AccessibilityNodeInfo) it13.next(), accessibilityNodeInfo5));
                                        }
                                        accessibilityNodeInfo5.recycle();
                                    }
                                    Iterator it14 = listJ.iterator();
                                    while (it14.hasNext()) {
                                        ((AccessibilityNodeInfo) it14.next()).recycle();
                                    }
                                    return s3Var;
                                }
                                int size6 = arrayList2.size();
                                int i3 = 0;
                                while (i3 < size6) {
                                    Object obj6 = arrayList2.get(i3);
                                    i3++;
                                    AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj6;
                                    if (!listJ2.isEmpty()) {
                                        Iterator it15 = listJ2.iterator();
                                        do {
                                            if (it15.hasNext()) {
                                            }
                                        } while (!g31.a((AccessibilityNodeInfo) it15.next(), accessibilityNodeInfo6));
                                    }
                                    accessibilityNodeInfo6.recycle();
                                }
                                Iterator it16 = listJ2.iterator();
                                while (it16.hasNext()) {
                                    ((AccessibilityNodeInfo) it16.next()).recycle();
                                }
                                lb2VarO = lb2VarO2;
                            }
                        }
                        if (lb2VarO instanceof jb2) {
                            String str2 = ((jb2) lb2VarO).b;
                            AccessibilityNodeInfo accessibilityNodeInfo7 = ((jb2) lb2VarO).a;
                            if (this.e.contains(string)) {
                                accessibilityNodeInfo7.getClass();
                                str2.getClass();
                                zY = e(accessibilityNodeInfo7, str2, false, null) instanceof s3;
                            } else {
                                zY = z ? y(accessibilityServiceI, accessibilityNodeInfo7) : d(accessibilityNodeInfo7, str2) instanceof s3;
                            }
                            t3Var = zY ? new s3(str2, null, null) : new t3(string, p(arrayList));
                        } else if (lb2VarO instanceof ib2) {
                            t3Var = new r3(string, ((ib2) lb2VarO).a, ((ib2) lb2VarO).b, null, 8);
                        } else {
                            if (!(lb2VarO instanceof kb2)) {
                                throw new b10();
                            }
                            t3Var = new t3(string, p(arrayList));
                        }
                        int size7 = arrayList.size();
                        while (i < size7) {
                            Object obj7 = arrayList.get(i);
                            i++;
                            AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj7;
                            if (!listJ.isEmpty()) {
                                Iterator it17 = listJ.iterator();
                                do {
                                    if (it17.hasNext()) {
                                    }
                                } while (!g31.a((AccessibilityNodeInfo) it17.next(), accessibilityNodeInfo8));
                            }
                            accessibilityNodeInfo8.recycle();
                        }
                        Iterator it18 = listJ.iterator();
                        while (it18.hasNext()) {
                            ((AccessibilityNodeInfo) it18.next()).recycle();
                        }
                        return t3Var;
                    } catch (Throwable th2) {
                        int size8 = arrayList.size();
                        while (i < size8) {
                            Object obj8 = arrayList.get(i);
                            i++;
                            AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) obj8;
                            if (!listJ.isEmpty()) {
                                Iterator it19 = listJ.iterator();
                                do {
                                    if (it19.hasNext()) {
                                    }
                                } while (!g31.a((AccessibilityNodeInfo) it19.next(), accessibilityNodeInfo9));
                            }
                            accessibilityNodeInfo9.recycle();
                        }
                        Iterator it20 = listJ.iterator();
                        while (it20.hasNext()) {
                            ((AccessibilityNodeInfo) it20.next()).recycle();
                        }
                        throw th2;
                    }
                }
            }
        }
        try {
            ew2 ew2VarK = xc2.k(xc2Var, string, listJ);
            try {
                if (ew2VarK instanceof bw2) {
                    if (((bw2) ew2VarK).d) {
                        v3VarQ = d(((bw2) ew2VarK).a, ((bw2) ew2VarK).b);
                    } else {
                        AccessibilityNodeInfo accessibilityNodeInfo10 = ((bw2) ew2VarK).a;
                        String str3 = ((bw2) ew2VarK).b;
                        accessibilityNodeInfo10.getClass();
                        str3.getClass();
                        v3VarQ = e(accessibilityNodeInfo10, str3, false, null);
                    }
                } else if (ew2VarK instanceof aw2) {
                    Rect rect = ((aw2) ew2VarK).a;
                    String str4 = ((aw2) ew2VarK).b;
                    CharSequence packageName2 = ((AccessibilityNodeInfo) mz.x(listJ)).getPackageName();
                    String string2 = packageName2 != null ? packageName2.toString() : null;
                    if (string2 == null) {
                        string2 = "";
                    }
                    v3VarQ = c(rect, str4, string2, ((AccessibilityNodeInfo) mz.x(listJ)).getWindowId());
                } else {
                    v3VarQ = ew2VarK instanceof zv2 ? q(string, ((zv2) ew2VarK).b, ((zv2) ew2VarK).a) : new t3(string, ii0Var);
                }
                xc2Var.getClass();
                xc2.b(ew2VarK, listJ);
                Iterator it21 = listJ.iterator();
                while (it21.hasNext()) {
                    ((AccessibilityNodeInfo) it21.next()).recycle();
                }
                return v3VarQ;
            } catch (Throwable th3) {
                th = th3;
                ew2Var = ew2VarK;
                xc2Var.getClass();
                xc2.b(ew2Var, listJ);
                Iterator it22 = listJ.iterator();
                while (it22.hasNext()) {
                    ((AccessibilityNodeInfo) it22.next()).recycle();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final v3 c(Rect rect, String str, String str2, int i) {
        rect.getClass();
        str.getClass();
        str2.getClass();
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI == null) {
            return u3.a;
        }
        AccessibilityNodeInfo accessibilityNodeInfoB = r2Var.b();
        ii0 ii0Var = ii0.a;
        if (accessibilityNodeInfoB == null) {
            return new t3(str, ii0Var);
        }
        try {
            Rect rect2 = new Rect();
            accessibilityNodeInfoB.getBoundsInScreen(rect2);
            CharSequence packageName = accessibilityNodeInfoB.getPackageName();
            v3 t3Var = (g31.a(packageName != null ? packageName.toString() : null, str2) && accessibilityNodeInfoB.getWindowId() == i && m(rect2, rect) && C(accessibilityServiceI, rect)) ? new s3(str, null, null) : new t3(str, ii0Var);
            return t3Var;
        } finally {
            accessibilityNodeInfoB.recycle();
        }
    }

    public final v3 d(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.getClass();
        str.getClass();
        return e(accessibilityNodeInfo, str, true, null);
    }

    public final v3 e(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z, z32 z32Var) {
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI == null) {
            return u3.a;
        }
        String strX = x(accessibilityNodeInfo);
        boolean zRefresh = accessibilityNodeInfo.refresh();
        ii0 ii0Var = ii0.a;
        if (!zRefresh || !x(accessibilityNodeInfo).equals(strX)) {
            return new t3(str, ii0Var);
        }
        AccessibilityNodeInfo accessibilityNodeInfoB = r2Var.b();
        if (accessibilityNodeInfoB == null) {
            return new t3(str, ii0Var);
        }
        try {
            Rect rect = new Rect();
            accessibilityNodeInfoB.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect2);
            CharSequence packageName = accessibilityNodeInfoB.getPackageName();
            String string = packageName != null ? packageName.toString() : null;
            if (string == null) {
                string = "";
            }
            if (!f(string, accessibilityNodeInfoB, rect, accessibilityNodeInfo)) {
                t3 t3Var = new t3(str, ii0Var);
                accessibilityNodeInfoB.recycle();
                return t3Var;
            }
            if (accessibilityNodeInfo.isClickable()) {
                if (z32Var != null && !((Boolean) z32Var.j(accessibilityNodeInfoB)).booleanValue()) {
                    t3 t3Var2 = new t3(str, ii0Var);
                    accessibilityNodeInfoB.recycle();
                    return t3Var2;
                }
                if (accessibilityNodeInfo.performAction(16)) {
                    s3 s3Var = new s3(str, null, null);
                    accessibilityNodeInfoB.recycle();
                    return s3Var;
                }
            }
            if (ie2.g(accessibilityNodeInfo) && (accessibilityNodeInfo.isFocused() || accessibilityNodeInfo.performAction(1))) {
                s3 s3Var2 = new s3(str, null, null);
                accessibilityNodeInfoB.recycle();
                return s3Var2;
            }
            if (!z) {
                int i = rect2.right - rect2.left;
                int i2 = rect2.bottom - rect2.top;
                v3 t3Var3 = (i <= 0 || i2 <= 0 || i > i2 * 2 || i2 > i * 2 || i * 3 >= rect.right - rect.left || !C(accessibilityServiceI, rect2)) ? new t3(str, ii0Var) : new s3(str, null, null);
                accessibilityNodeInfoB.recycle();
                return t3Var3;
            }
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            int i3 = 0;
            while (i3 < 8) {
                if (parent == null) {
                    t3 t3Var4 = new t3(str, ii0Var);
                    accessibilityNodeInfoB.recycle();
                    return t3Var4;
                }
                try {
                    if (!parent.equals(accessibilityNodeInfoB) && !t(parent) && f(string, accessibilityNodeInfoB, rect, parent)) {
                        Rect rect3 = new Rect();
                        parent.getBoundsInScreen(rect3);
                        if (!m(rect3, rect2)) {
                            t3 t3Var5 = new t3(str, ii0Var);
                            parent.recycle();
                            accessibilityNodeInfoB.recycle();
                            return t3Var5;
                        }
                        if (parent.isClickable()) {
                            if (z32Var != null && !((Boolean) z32Var.j(accessibilityNodeInfoB)).booleanValue()) {
                                t3 t3Var6 = new t3(str, ii0Var);
                                parent.recycle();
                                accessibilityNodeInfoB.recycle();
                                return t3Var6;
                            }
                            if (parent.performAction(16)) {
                                s3 s3Var3 = new s3(str, null, null);
                                parent.recycle();
                                accessibilityNodeInfoB.recycle();
                                return s3Var3;
                            }
                        }
                        AccessibilityNodeInfo parent2 = parent.getParent();
                        parent.recycle();
                        i3++;
                        parent = parent2;
                    }
                    t3 t3Var7 = new t3(str, ii0Var);
                    parent.recycle();
                    accessibilityNodeInfoB.recycle();
                    return t3Var7;
                } catch (Throwable th) {
                    parent.recycle();
                    throw th;
                }
            }
            if (parent != null) {
                parent.recycle();
            }
            t3 t3Var8 = new t3(str, ii0Var);
            accessibilityNodeInfoB.recycle();
            return t3Var8;
        } catch (Throwable th2) {
            accessibilityNodeInfoB.recycle();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0147 A[Catch: all -> 0x009f, TryCatch #2 {all -> 0x009f, blocks: (B:44:0x009a, B:54:0x00c1, B:56:0x00c7, B:73:0x0147, B:75:0x014f, B:77:0x0156, B:79:0x015e, B:82:0x0165, B:84:0x016d, B:93:0x018a, B:87:0x0176, B:89:0x017c, B:91:0x0182, B:94:0x0198, B:95:0x019e, B:60:0x00de, B:62:0x00e5, B:64:0x00ef, B:65:0x00fc, B:67:0x0102, B:68:0x0110, B:69:0x011d, B:71:0x0123, B:72:0x013f, B:48:0x00a5, B:52:0x00b6, B:53:0x00bd), top: B:116:0x0096, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x014f A[Catch: all -> 0x009f, TryCatch #2 {all -> 0x009f, blocks: (B:44:0x009a, B:54:0x00c1, B:56:0x00c7, B:73:0x0147, B:75:0x014f, B:77:0x0156, B:79:0x015e, B:82:0x0165, B:84:0x016d, B:93:0x018a, B:87:0x0176, B:89:0x017c, B:91:0x0182, B:94:0x0198, B:95:0x019e, B:60:0x00de, B:62:0x00e5, B:64:0x00ef, B:65:0x00fc, B:67:0x0102, B:68:0x0110, B:69:0x011d, B:71:0x0123, B:72:0x013f, B:48:0x00a5, B:52:0x00b6, B:53:0x00bd), top: B:116:0x0096, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0156 A[Catch: all -> 0x009f, TryCatch #2 {all -> 0x009f, blocks: (B:44:0x009a, B:54:0x00c1, B:56:0x00c7, B:73:0x0147, B:75:0x014f, B:77:0x0156, B:79:0x015e, B:82:0x0165, B:84:0x016d, B:93:0x018a, B:87:0x0176, B:89:0x017c, B:91:0x0182, B:94:0x0198, B:95:0x019e, B:60:0x00de, B:62:0x00e5, B:64:0x00ef, B:65:0x00fc, B:67:0x0102, B:68:0x0110, B:69:0x011d, B:71:0x0123, B:72:0x013f, B:48:0x00a5, B:52:0x00b6, B:53:0x00bd), top: B:116:0x0096, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x019e A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #2 {all -> 0x009f, blocks: (B:44:0x009a, B:54:0x00c1, B:56:0x00c7, B:73:0x0147, B:75:0x014f, B:77:0x0156, B:79:0x015e, B:82:0x0165, B:84:0x016d, B:93:0x018a, B:87:0x0176, B:89:0x017c, B:91:0x0182, B:94:0x0198, B:95:0x019e, B:60:0x00de, B:62:0x00e5, B:64:0x00ef, B:65:0x00fc, B:67:0x0102, B:68:0x0110, B:69:0x011d, B:71:0x0123, B:72:0x013f, B:48:0x00a5, B:52:0x00b6, B:53:0x00bd), top: B:116:0x0096, outer: #0 }] */
    public final v3 g(String str, String str2, int i, boolean z, List list) {
        Object next;
        List listQ;
        v3 r3Var;
        aq2 aq2Var;
        t3 t3Var;
        CharSequence packageName;
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI == null) {
            return u3.a;
        }
        List listJ = nz.j(r2Var.b());
        try {
            Iterator it = listJ.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                packageName = ((AccessibilityNodeInfo) next).getPackageName();
            } while (!g31.a(packageName != null ? packageName.toString() : null, "com.spotify.music"));
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) next;
            ii0 ii0Var = ii0.a;
            if (accessibilityNodeInfo == null) {
                t3 t3Var2 = new t3("Spotify song", ii0Var);
                Iterator it2 = listJ.iterator();
                while (it2.hasNext()) {
                    ((AccessibilityNodeInfo) it2.next()).recycle();
                }
                return t3Var2;
            }
            if (str == null) {
                str = "";
            }
            String string = cs2.V(str).toString();
            if (cs2.A(string) && i <= 0) {
                t3 t3Var3 = new t3("Spotify song", ii0Var);
                Iterator it3 = listJ.iterator();
                while (it3.hasNext()) {
                    ((AccessibilityNodeInfo) it3.next()).recycle();
                }
                return t3Var3;
            }
            bq2 bq2Var = new bq2(accessibilityNodeInfo);
            try {
                if (z) {
                    listQ = bq2Var.o(i, string, str2, list);
                } else if (i > 0) {
                    Object objZ = mz.z(i - 1, bq2Var.r());
                    if (i <= 0) {
                        objZ = null;
                    }
                    listQ = nz.j((aq2) objZ);
                } else {
                    listQ = bq2Var.q(string, str2);
                }
                String str3 = cs2.A(string) ? "Spotify result " + i : string;
                if ((z || i <= 0) && listQ.size() != 1) {
                    List<aq2> listJ2 = bq2Var.j(string, str2);
                    if (listJ2.isEmpty()) {
                        aq2Var = (aq2) mz.I(listQ);
                        if (aq2Var == null) {
                            t3Var = new t3(str3, ii0Var);
                        } else {
                            zp2 zp2Var = aq2Var.a;
                            if (r2Var.k("com.spotify.music") || !bq2Var.C(aq2Var)) {
                                t3Var = new t3(str3, ii0Var);
                            } else {
                                AccessibilityNodeInfo accessibilityNodeInfo2 = zp2Var.a;
                                if ((accessibilityNodeInfo2.isClickable() && accessibilityNodeInfo2.performAction(16)) || (r2Var.k("com.spotify.music") && bq2Var.C(aq2Var) && C(accessibilityServiceI, zp2Var.c))) {
                                    r3Var = new s3(aq2Var.a(), aq2Var.c, aq2Var.d);
                                } else {
                                    t3Var = new t3(str3, ii0Var);
                                }
                            }
                        }
                        r3Var = t3Var;
                    } else {
                        ArrayList arrayList = new ArrayList(nz.d(listJ2));
                        Iterator it4 = listJ2.iterator();
                        while (it4.hasNext()) {
                            arrayList.add(((aq2) it4.next()).a());
                        }
                        ArrayList arrayList2 = new ArrayList(nz.d(listJ2));
                        for (aq2 aq2Var2 : listJ2) {
                            arrayList2.add(new xv2(aq2Var2.c, aq2Var2.d, new Rect(aq2Var2.a.c)));
                        }
                        r3Var = new r3(str3, arrayList, null, arrayList2, 4);
                    }
                } else {
                    aq2Var = (aq2) mz.I(listQ);
                    if (aq2Var == null) {
                        t3Var = new t3(str3, ii0Var);
                    } else {
                        zp2 zp2Var2 = aq2Var.a;
                        if (r2Var.k("com.spotify.music")) {
                            t3Var = new t3(str3, ii0Var);
                        } else {
                            t3Var = new t3(str3, ii0Var);
                        }
                    }
                    r3Var = t3Var;
                }
                we4.a(bq2Var, null);
                Iterator it5 = listJ.iterator();
                while (it5.hasNext()) {
                    ((AccessibilityNodeInfo) it5.next()).recycle();
                }
                return r3Var;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    we4.a(bq2Var, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Iterator it6 = listJ.iterator();
            while (it6.hasNext()) {
                ((AccessibilityNodeInfo) it6.next()).recycle();
            }
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01fd A[Catch: all -> 0x01fb, TRY_LEAVE, TryCatch #0 {all -> 0x01fb, blocks: (B:108:0x01ea, B:110:0x01f0, B:112:0x01f6, B:115:0x01fd), top: B:176:0x01ea, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x020d A[Catch: all -> 0x002b, TRY_ENTER, TryCatch #1 {all -> 0x002b, blocks: (B:7:0x0019, B:9:0x0026, B:13:0x002f, B:16:0x0039, B:34:0x0083, B:36:0x0096, B:38:0x00a5, B:39:0x00a9, B:40:0x00bd, B:42:0x00c3, B:52:0x00fc, B:45:0x00d8, B:47:0x00df, B:49:0x00f5, B:53:0x0100, B:56:0x0109, B:58:0x011b, B:59:0x0127, B:77:0x0176, B:96:0x01c3, B:98:0x01c9, B:100:0x01cf, B:103:0x01d7, B:105:0x01df, B:119:0x0212, B:120:0x0218, B:106:0x01e4, B:117:0x020d, B:139:0x0264, B:140:0x0267, B:141:0x0268, B:108:0x01ea, B:110:0x01f0, B:112:0x01f6, B:115:0x01fd), top: B:178:0x0019, inners: #0 }] */
    public final v3 h(AccessibilityService accessibilityService) {
        boolean zPerformAction;
        Rect rect;
        r2 r2Var = this.a;
        List listD = r2Var.d();
        if (listD.isEmpty()) {
            return u3.a;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        try {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) mz.x(listD);
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            boolean zA = g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube");
            ii0 ii0Var = ii0.a;
            if (!zA) {
                t3 t3Var = new t3("next video button", ii0Var);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                    if (!listD.isEmpty()) {
                        Iterator it = listD.iterator();
                        do {
                            if (it.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it.next(), accessibilityNodeInfo2));
                    }
                    accessibilityNodeInfo2.recycle();
                }
                Iterator it2 = listD.iterator();
                while (it2.hasNext()) {
                    ((AccessibilityNodeInfo) it2.next()).recycle();
                }
                return t3Var;
            }
            rz.q(l(accessibilityNodeInfo), arrayList);
            ArrayList arrayList2 = new ArrayList();
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                if (w((AccessibilityNodeInfo) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            List<AccessibilityNodeInfo> listK = mz.K(arrayList2, new lo0(20));
            ArrayList arrayList3 = new ArrayList();
            for (AccessibilityNodeInfo accessibilityNodeInfo3 : listK) {
                Rect rect2 = new Rect();
                accessibilityNodeInfo3.getBoundsInScreen(rect2);
                if (!arrayList3.isEmpty()) {
                    int size3 = arrayList3.size();
                    int i3 = 0;
                    do {
                        if (i3 < size3) {
                            Object obj3 = arrayList3.get(i3);
                            i3++;
                            rect = new Rect();
                            ((AccessibilityNodeInfo) obj3).getBoundsInScreen(rect);
                            if (m(rect2, rect)) {
                                break;
                            }
                        }
                    } while (!m(rect, rect2));
                }
                arrayList3.add(accessibilityNodeInfo3);
            }
            if (arrayList3.size() > 1) {
                ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
                int size4 = arrayList3.size();
                int i4 = 0;
                while (i4 < size4) {
                    Object obj4 = arrayList3.get(i4);
                    i4++;
                    arrayList4.add("Next video");
                }
                r3 r3Var = new r3("next video button", arrayList4, null, null, 12);
                int size5 = arrayList.size();
                while (i < size5) {
                    Object obj5 = arrayList.get(i);
                    i++;
                    AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj5;
                    if (!listD.isEmpty()) {
                        Iterator it3 = listD.iterator();
                        do {
                            if (it3.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it3.next(), accessibilityNodeInfo4));
                    }
                    accessibilityNodeInfo4.recycle();
                }
                Iterator it4 = listD.iterator();
                while (it4.hasNext()) {
                    ((AccessibilityNodeInfo) it4.next()).recycle();
                }
                return r3Var;
            }
            AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.I(arrayList3);
            if (accessibilityNodeInfo5 == null) {
                int size6 = arrayList.size();
                while (i < size6) {
                    Object obj6 = arrayList.get(i);
                    i++;
                    AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj6;
                    if (!listD.isEmpty()) {
                        Iterator it5 = listD.iterator();
                        do {
                            if (it5.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it5.next(), accessibilityNodeInfo6));
                    }
                    accessibilityNodeInfo6.recycle();
                }
                Iterator it6 = listD.iterator();
                while (it6.hasNext()) {
                    ((AccessibilityNodeInfo) it6.next()).recycle();
                }
                return null;
            }
            if (r2Var.k("com.google.android.youtube") && accessibilityNodeInfo5.refresh() && w(accessibilityNodeInfo5)) {
                if (accessibilityNodeInfo5.isClickable()) {
                    zPerformAction = accessibilityNodeInfo5.performAction(16);
                } else {
                    AccessibilityNodeInfo parent = accessibilityNodeInfo5.getParent();
                    if (parent != null) {
                        try {
                            if (w(parent) && parent.isClickable()) {
                                zPerformAction = parent.performAction(16);
                            } else {
                                Rect rect3 = new Rect();
                                accessibilityNodeInfo5.getBoundsInScreen(rect3);
                                zPerformAction = C(accessibilityService, rect3);
                            }
                            if (parent != null) {
                                parent.recycle();
                            }
                        } catch (Throwable th) {
                            if (parent != null) {
                                parent.recycle();
                            }
                            throw th;
                        }
                    } else {
                        Rect rect4 = new Rect();
                        accessibilityNodeInfo5.getBoundsInScreen(rect4);
                        zPerformAction = C(accessibilityService, rect4);
                        if (parent != null) {
                            parent.recycle();
                        }
                    }
                }
                v3 s3Var = zPerformAction ? new s3("Next video", null, null) : new t3("next video button", ii0Var);
                int size7 = arrayList.size();
                while (i < size7) {
                    Object obj7 = arrayList.get(i);
                    i++;
                    AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj7;
                    if (!listD.isEmpty()) {
                        Iterator it7 = listD.iterator();
                        do {
                            if (it7.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it7.next(), accessibilityNodeInfo7));
                    }
                    accessibilityNodeInfo7.recycle();
                }
                Iterator it8 = listD.iterator();
                while (it8.hasNext()) {
                    ((AccessibilityNodeInfo) it8.next()).recycle();
                }
                return s3Var;
            }
            t3 t3Var2 = new t3("next video button", ii0Var);
            int size8 = arrayList.size();
            while (i < size8) {
                Object obj8 = arrayList.get(i);
                i++;
                AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj8;
                if (!listD.isEmpty()) {
                    Iterator it9 = listD.iterator();
                    do {
                        if (it9.hasNext()) {
                        }
                    } while (!g31.a((AccessibilityNodeInfo) it9.next(), accessibilityNodeInfo8));
                }
                accessibilityNodeInfo8.recycle();
            }
            Iterator it10 = listD.iterator();
            while (it10.hasNext()) {
                ((AccessibilityNodeInfo) it10.next()).recycle();
            }
            return t3Var2;
        } catch (Throwable th2) {
            int size9 = arrayList.size();
            while (i < size9) {
                Object obj9 = arrayList.get(i);
                i++;
                AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) obj9;
                if (!listD.isEmpty()) {
                    Iterator it11 = listD.iterator();
                    do {
                        if (it11.hasNext()) {
                        }
                    } while (!g31.a((AccessibilityNodeInfo) it11.next(), accessibilityNodeInfo9));
                }
                accessibilityNodeInfo9.recycle();
            }
            Iterator it12 = listD.iterator();
            while (it12.hasNext()) {
                ((AccessibilityNodeInfo) it12.next()).recycle();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:140:0x0267  */
    /* JADX WARN: Code duplicated, block: B:148:0x027c A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #1 {all -> 0x0073, blocks: (B:7:0x001c, B:10:0x0028, B:30:0x0076, B:32:0x007c, B:34:0x0082, B:36:0x0088, B:54:0x00d3, B:56:0x00e6, B:58:0x00f5, B:59:0x00f9, B:60:0x010d, B:62:0x0113, B:72:0x014e, B:65:0x0128, B:67:0x012f, B:69:0x0147, B:73:0x0152, B:76:0x015b, B:78:0x016d, B:79:0x0179, B:97:0x01cc, B:99:0x01d4, B:117:0x021f, B:119:0x0225, B:121:0x022b, B:124:0x0233, B:126:0x023b, B:148:0x027c, B:128:0x0241, B:142:0x026a, B:144:0x026f, B:147:0x0276, B:138:0x0263, B:139:0x0266, B:166:0x02c8, B:130:0x024f, B:132:0x0255, B:134:0x025b), top: B:203:0x001c, inners: #0 }] */
    public final v3 i() {
        boolean z;
        v3 t3Var;
        Rect rect;
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI == null) {
            return u3.a;
        }
        List listJ = nz.j(r2Var.b());
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) mz.y(listJ);
            ii0 ii0Var = ii0.a;
            if (accessibilityNodeInfo == null) {
                t3 t3Var2 = new t3("Skip ad button", ii0Var);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                    if (!listJ.isEmpty()) {
                        Iterator it = listJ.iterator();
                        do {
                            if (it.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it.next(), accessibilityNodeInfo2));
                    }
                    accessibilityNodeInfo2.recycle();
                }
                Iterator it2 = listJ.iterator();
                while (it2.hasNext()) {
                    ((AccessibilityNodeInfo) it2.next()).recycle();
                }
                return t3Var2;
            }
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (!g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube")) {
                t3 t3Var3 = new t3("Skip ad button", ii0Var);
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj2;
                    if (!listJ.isEmpty()) {
                        Iterator it3 = listJ.iterator();
                        do {
                            if (it3.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it3.next(), accessibilityNodeInfo3));
                    }
                    accessibilityNodeInfo3.recycle();
                }
                Iterator it4 = listJ.iterator();
                while (it4.hasNext()) {
                    ((AccessibilityNodeInfo) it4.next()).recycle();
                }
                return t3Var3;
            }
            rz.q(l(accessibilityNodeInfo), arrayList);
            ArrayList arrayList2 = new ArrayList();
            int size3 = arrayList.size();
            int i3 = 0;
            while (i3 < size3) {
                Object obj3 = arrayList.get(i3);
                i3++;
                if (v((AccessibilityNodeInfo) obj3)) {
                    arrayList2.add(obj3);
                }
            }
            List<AccessibilityNodeInfo> listK = mz.K(arrayList2, new lo0(21));
            ArrayList arrayList3 = new ArrayList();
            for (AccessibilityNodeInfo accessibilityNodeInfo4 : listK) {
                Rect rect2 = new Rect();
                accessibilityNodeInfo4.getBoundsInScreen(rect2);
                if (!arrayList3.isEmpty()) {
                    int size4 = arrayList3.size();
                    int i4 = 0;
                    do {
                        if (i4 < size4) {
                            Object obj4 = arrayList3.get(i4);
                            i4++;
                            rect = new Rect();
                            ((AccessibilityNodeInfo) obj4).getBoundsInScreen(rect);
                            if (m(rect2, rect)) {
                                break;
                            }
                        }
                    } while (!m(rect, rect2));
                }
                arrayList3.add(accessibilityNodeInfo4);
            }
            if (arrayList3.size() > 1) {
                ArrayList arrayList4 = new ArrayList(nz.d(arrayList3));
                int size5 = arrayList3.size();
                int i5 = 0;
                while (i5 < size5) {
                    Object obj5 = arrayList3.get(i5);
                    i5++;
                    arrayList4.add("Skip ad");
                }
                r3 r3Var = new r3("Skip ad button", arrayList4, null, null, 12);
                int size6 = arrayList.size();
                int i6 = 0;
                while (i6 < size6) {
                    Object obj6 = arrayList.get(i6);
                    i6++;
                    AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj6;
                    if (!listJ.isEmpty()) {
                        Iterator it5 = listJ.iterator();
                        do {
                            if (it5.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it5.next(), accessibilityNodeInfo5));
                    }
                    accessibilityNodeInfo5.recycle();
                }
                Iterator it6 = listJ.iterator();
                while (it6.hasNext()) {
                    ((AccessibilityNodeInfo) it6.next()).recycle();
                }
                return r3Var;
            }
            AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) mz.I(arrayList3);
            if (accessibilityNodeInfo6 == null) {
                t3 t3Var4 = new t3("Skip ad button", ii0Var);
                int size7 = arrayList.size();
                int i7 = 0;
                while (i7 < size7) {
                    Object obj7 = arrayList.get(i7);
                    i7++;
                    AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj7;
                    if (!listJ.isEmpty()) {
                        Iterator it7 = listJ.iterator();
                        do {
                            if (it7.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it7.next(), accessibilityNodeInfo7));
                    }
                    accessibilityNodeInfo7.recycle();
                }
                Iterator it8 = listJ.iterator();
                while (it8.hasNext()) {
                    ((AccessibilityNodeInfo) it8.next()).recycle();
                }
                return t3Var4;
            }
            if (r2Var.k("com.google.android.youtube") && accessibilityNodeInfo6.refresh() && v(accessibilityNodeInfo6)) {
                if (accessibilityNodeInfo6.isClickable() && accessibilityNodeInfo6.performAction(16)) {
                    t3Var = new s3("Skip ad", null, null);
                } else {
                    Rect rect3 = new Rect();
                    accessibilityNodeInfo6.getBoundsInScreen(rect3);
                    AccessibilityNodeInfo parent = accessibilityNodeInfo6.getParent();
                    if (parent != null) {
                        try {
                            z = v(parent) && parent.isClickable() && parent.performAction(16);
                        } catch (Throwable th) {
                            parent.recycle();
                            throw th;
                        }
                    }
                    if (parent != null) {
                        parent.recycle();
                    }
                    if (z || C(accessibilityServiceI, rect3)) {
                        t3Var = new s3("Skip ad", null, null);
                    } else {
                        t3Var = new t3("Skip ad button", ii0Var);
                    }
                }
                int size8 = arrayList.size();
                int i8 = 0;
                while (i8 < size8) {
                    Object obj8 = arrayList.get(i8);
                    i8++;
                    AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) obj8;
                    if (!listJ.isEmpty()) {
                        Iterator it9 = listJ.iterator();
                        do {
                            if (it9.hasNext()) {
                            }
                        } while (!g31.a((AccessibilityNodeInfo) it9.next(), accessibilityNodeInfo8));
                    }
                    accessibilityNodeInfo8.recycle();
                }
                Iterator it10 = listJ.iterator();
                while (it10.hasNext()) {
                    ((AccessibilityNodeInfo) it10.next()).recycle();
                }
                return t3Var;
            }
            t3 t3Var5 = new t3("Skip ad button", ii0Var);
            int size9 = arrayList.size();
            int i9 = 0;
            while (i9 < size9) {
                Object obj9 = arrayList.get(i9);
                i9++;
                AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) obj9;
                if (!listJ.isEmpty()) {
                    Iterator it11 = listJ.iterator();
                    do {
                        if (it11.hasNext()) {
                        }
                    } while (!g31.a((AccessibilityNodeInfo) it11.next(), accessibilityNodeInfo9));
                }
                accessibilityNodeInfo9.recycle();
            }
            Iterator it12 = listJ.iterator();
            while (it12.hasNext()) {
                ((AccessibilityNodeInfo) it12.next()).recycle();
            }
            return t3Var5;
        } catch (Throwable th2) {
            int size10 = arrayList.size();
            int i10 = 0;
            while (i10 < size10) {
                Object obj10 = arrayList.get(i10);
                i10++;
                AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) obj10;
                if (!listJ.isEmpty()) {
                    Iterator it13 = listJ.iterator();
                    do {
                        if (it13.hasNext()) {
                        }
                    } while (!g31.a((AccessibilityNodeInfo) it13.next(), accessibilityNodeInfo10));
                }
                accessibilityNodeInfo10.recycle();
            }
            Iterator it14 = listJ.iterator();
            while (it14.hasNext()) {
                ((AccessibilityNodeInfo) it14.next()).recycle();
            }
            throw th2;
        }
    }

    public final v3 j() {
        v3 t3Var;
        r2 r2Var = this.a;
        AccessibilityService accessibilityServiceI = r2Var.i();
        if (accessibilityServiceI != null) {
            List listD = r2Var.d();
            if (!listD.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = listD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    CharSequence packageName = ((AccessibilityNodeInfo) next).getPackageName();
                    if (g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube")) {
                        arrayList.add(next);
                    }
                }
                boolean zIsEmpty = arrayList.isEmpty();
                ii0 ii0Var = ii0.a;
                if (zIsEmpty) {
                    Iterator it2 = listD.iterator();
                    while (it2.hasNext()) {
                        ((AccessibilityNodeInfo) it2.next()).recycle();
                    }
                    return new t3("Subscribe button", ii0Var);
                }
                try {
                    dd3 dd3Var = this.c;
                    ed3 ed3Var = ed3.c;
                    dd3Var.getClass();
                    iv0 iv0VarC = dd3.c(ed3Var, arrayList);
                    if (iv0VarC instanceof fv0) {
                        t3Var = new s3(((fv0) iv0VarC).a, null, null);
                    } else if (iv0VarC instanceof gv0) {
                        jv0 jv0Var = ((gv0) iv0VarC).a;
                        t3Var = z(accessibilityServiceI, jv0Var.b, jv0Var.c) ? new s3(jv0Var.e, null, null) : new t3("Subscribe button", ii0Var);
                    } else {
                        if (!iv0VarC.equals(hv0.a)) {
                            throw new b10();
                        }
                        t3Var = new t3("Subscribe button", ii0Var);
                    }
                    Iterator it3 = listD.iterator();
                    while (it3.hasNext()) {
                        ((AccessibilityNodeInfo) it3.next()).recycle();
                    }
                    return t3Var;
                } catch (Throwable th) {
                    Iterator it4 = listD.iterator();
                    while (it4.hasNext()) {
                        ((AccessibilityNodeInfo) it4.next()).recycle();
                    }
                    throw th;
                }
            }
        }
        return u3.a;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:200:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:208:0x030e  */
    /* JADX WARN: Code duplicated, block: B:211:0x0312  */
    /* JADX WARN: Code duplicated, block: B:272:0x041b  */
    /* JADX WARN: Code duplicated, block: B:280:0x0430  */
    /* JADX WARN: Code duplicated, block: B:283:0x0434  */
    /* JADX WARN: Code duplicated, block: B:302:0x0479  */
    /* JADX WARN: Code duplicated, block: B:310:0x0495  */
    /* JADX WARN: Code duplicated, block: B:312:0x0498  */
    /* JADX WARN: Code duplicated, block: B:314:0x04a1 A[PHI: r10
      0x04a1: PHI (r10v23 java.lang.String) = (r10v19 java.lang.String), (r10v27 java.lang.String) binds: [B:311:0x0496, B:301:0x0477] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:316:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:317:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:320:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:322:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:325:0x04db A[LOOP:10: B:324:0x04d9->B:325:0x04db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:328:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:331:0x04f6 A[LOOP:11: B:329:0x04f0->B:331:0x04f6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:334:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:337:0x0507 A[LOOP:12: B:335:0x0501->B:337:0x0507, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:340:0x0510  */
    /* JADX WARN: Code duplicated, block: B:343:0x0517  */
    /* JADX WARN: Code duplicated, block: B:346:0x052c  */
    /* JADX WARN: Code duplicated, block: B:347:0x052f  */
    /* JADX WARN: Code duplicated, block: B:350:0x0551 A[LOOP:14: B:344:0x051a->B:350:0x0551, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:351:0x055c  */
    /* JADX WARN: Code duplicated, block: B:353:0x0564 A[LOOP:13: B:341:0x0511->B:353:0x0564, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:354:0x056f  */
    /* JADX WARN: Code duplicated, block: B:358:0x0599  */
    /* JADX WARN: Code duplicated, block: B:360:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:375:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:383:0x060e  */
    /* JADX WARN: Code duplicated, block: B:385:0x0611  */
    /* JADX WARN: Code duplicated, block: B:386:0x0614  */
    /* JADX WARN: Code duplicated, block: B:481:0x05a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:483:0x04f9 A[EDGE_INSN: B:483:0x04f9->B:332:0x04f9 BREAK  A[LOOP:11: B:329:0x04f0->B:331:0x04f6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:484:0x050a A[EDGE_INSN: B:484:0x050a->B:338:0x050a BREAK  A[LOOP:12: B:335:0x0501->B:337:0x0507], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:485:0x0575 A[EDGE_INSN: B:485:0x0575->B:355:0x0575 BREAK  A[LOOP:13: B:341:0x0511->B:353:0x0564], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:486:0x0562 A[EDGE_INSN: B:486:0x0562->B:352:0x0562 BREAK  A[LOOP:14: B:344:0x051a->B:350:0x0551], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x018d  */
    public final lb2 o(String str, ArrayList arrayList) {
        ArrayList arrayList2;
        int i;
        Object obj;
        Object obj2;
        CharSequence contentDescription;
        String str2;
        String string;
        String string2;
        CharSequence contentDescription2;
        String string3;
        int i2;
        int i3;
        int i4;
        String string4;
        wt1 wt1Var;
        String lowerCase;
        float fMax;
        int length;
        int[][] iArr;
        int length2;
        int length3;
        int length4;
        float f;
        int i5;
        int length5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String string5;
        CharSequence contentDescription3;
        String str3;
        String string6;
        String string7;
        String lowerCase2;
        String lowerCase3;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        CharSequence contentDescription4;
        String str4;
        String string14;
        String string15;
        String lowerCase4;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        CharSequence contentDescription5;
        String str5;
        String string24;
        String string25;
        CharSequence contentDescription6;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String str6 = str;
        ArrayList arrayList3 = arrayList;
        String lowerCase5 = str6.toLowerCase(Locale.ROOT);
        lowerCase5.getClass();
        int i12 = 0;
        if (!cs2.n(lowerCase5, "like", false) || cs2.n(lowerCase5, "dislike", false)) {
            arrayList2 = arrayList3;
        } else {
            arrayList2 = new ArrayList();
            int size = arrayList3.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj3 = arrayList3.get(i13);
                i13++;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj3;
                CharSequence text = accessibilityNodeInfo.getText();
                String string31 = text != null ? text.toString() : null;
                if (string31 == null) {
                    string31 = "";
                }
                CharSequence contentDescription7 = accessibilityNodeInfo.getContentDescription();
                String string32 = contentDescription7 != null ? contentDescription7.toString() : null;
                if (string32 == null) {
                    string32 = "";
                }
                String lowerCase6 = cq.k(string31, Padder.FALLBACK_PADDING_STRING, string32).toLowerCase(Locale.ROOT);
                lowerCase6.getClass();
                if (!cs2.n(lowerCase6, "dislike", false) && !cs2.n(lowerCase6, "naapasand", false) && !cs2.n(lowerCase6, "नापसंद", false)) {
                    arrayList2.add(obj3);
                }
            }
        }
        if (js2.k(str6, "sonic-node:", false)) {
            String str7 = (String) this.d.get(str6);
            if (str7 != null) {
                ArrayList arrayList4 = new ArrayList();
                int size2 = arrayList2.size();
                while (i12 < size2) {
                    Object obj4 = arrayList2.get(i12);
                    i12++;
                    if (x((AccessibilityNodeInfo) obj4).equals(str7)) {
                        arrayList4.add(obj4);
                    }
                }
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) mz.I(arrayList4);
                if (accessibilityNodeInfo2 != null) {
                    CharSequence text2 = accessibilityNodeInfo2.getText();
                    if (text2 == null || (string30 = text2.toString()) == null) {
                        CharSequence contentDescription8 = accessibilityNodeInfo2.getContentDescription();
                        string30 = contentDescription8 != null ? contentDescription8.toString() : "selected element";
                    }
                    return new jb2(accessibilityNodeInfo2, string30);
                }
            }
        } else {
            ArrayList arrayList5 = new ArrayList();
            int size3 = arrayList2.size();
            int i14 = 0;
            while (true) {
                i = 1;
                if (i14 >= size3) {
                    break;
                }
                Object obj5 = arrayList2.get(i14);
                i14++;
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj5;
                CharSequence text3 = accessibilityNodeInfo3.getText();
                if ((text3 != null && (string28 = text3.toString()) != null && (string29 = cs2.V(string28).toString()) != null && string29.equalsIgnoreCase(lowerCase5)) || ((contentDescription6 = accessibilityNodeInfo3.getContentDescription()) != null && (string26 = contentDescription6.toString()) != null && (string27 = cs2.V(string26).toString()) != null && string27.equalsIgnoreCase(lowerCase5))) {
                    arrayList5.add(obj5);
                }
            }
            ArrayList arrayList6 = new ArrayList();
            int size4 = arrayList5.size();
            int i15 = 0;
            while (i15 < size4) {
                Object obj6 = arrayList5.get(i15);
                i15++;
                AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj6;
                if (!accessibilityNodeInfo4.isEditable() && (accessibilityNodeInfo4.isClickable() || k(accessibilityNodeInfo4) != null)) {
                    arrayList6.add(obj6);
                }
            }
            if (!arrayList6.isEmpty()) {
                arrayList5 = arrayList6;
            }
            List listN = n(arrayList5);
            if (listN.size() == 1) {
                AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) mz.H(listN);
                CharSequence text4 = accessibilityNodeInfo5.getText();
                if (text4 == null || (string25 = text4.toString()) == null) {
                    contentDescription5 = accessibilityNodeInfo5.getContentDescription();
                    if (contentDescription5 != null || (string24 = contentDescription5.toString()) == null || cs2.A(string24)) {
                        str5 = null;
                    } else {
                        str5 = string24;
                    }
                    if (str5 != null) {
                        str6 = str5;
                    }
                } else {
                    if (cs2.A(string25)) {
                        string25 = null;
                    }
                    if (string25 == null) {
                        contentDescription5 = accessibilityNodeInfo5.getContentDescription();
                        if (contentDescription5 != null) {
                            str5 = null;
                        } else {
                            str5 = null;
                        }
                        if (str5 != null) {
                            str6 = str5;
                        }
                    } else {
                        str6 = string25;
                    }
                }
                return new jb2(accessibilityNodeInfo5, str6);
            }
            if (listN.size() > 1) {
                return a(listN);
            }
            int size5 = arrayList2.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size5) {
                    obj = null;
                    break;
                }
                obj = arrayList2.get(i16);
                i16++;
                CharSequence text5 = ((AccessibilityNodeInfo) obj).getText();
                if (text5 != null && (string22 = text5.toString()) != null && (string23 = cs2.V(string22).toString()) != null && string23.equalsIgnoreCase(lowerCase5)) {
                    break;
                }
            }
            AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo6 != null) {
                CharSequence text6 = accessibilityNodeInfo6.getText();
                if (text6 != null && (string20 = text6.toString()) != null && (string21 = cs2.V(string20).toString()) != null) {
                    str6 = string21;
                }
                return new jb2(accessibilityNodeInfo6, str6);
            }
            int size6 = arrayList2.size();
            int i17 = 0;
            while (true) {
                if (i17 >= size6) {
                    obj2 = null;
                    break;
                }
                obj2 = arrayList2.get(i17);
                i17++;
                CharSequence contentDescription9 = ((AccessibilityNodeInfo) obj2).getContentDescription();
                if (contentDescription9 != null && (string18 = contentDescription9.toString()) != null && (string19 = cs2.V(string18).toString()) != null && string19.equalsIgnoreCase(lowerCase5)) {
                    break;
                }
            }
            AccessibilityNodeInfo accessibilityNodeInfo7 = (AccessibilityNodeInfo) obj2;
            if (accessibilityNodeInfo7 != null) {
                CharSequence contentDescription10 = accessibilityNodeInfo7.getContentDescription();
                if (contentDescription10 != null && (string16 = contentDescription10.toString()) != null && (string17 = cs2.V(string16).toString()) != null) {
                    str6 = string17;
                }
                return new jb2(accessibilityNodeInfo7, str6);
            }
            ArrayList arrayList7 = new ArrayList();
            int size7 = arrayList2.size();
            int i18 = 0;
            while (i18 < size7) {
                Object obj7 = arrayList2.get(i18);
                i18++;
                String viewIdResourceName = ((AccessibilityNodeInfo) obj7).getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase4 = cs2.S(viewIdResourceName, '/').toLowerCase(Locale.ROOT);
                    lowerCase4.getClass();
                } else {
                    lowerCase4 = null;
                }
                if (lowerCase4 == null) {
                    lowerCase4 = "";
                }
                if (!cs2.A(lowerCase4)) {
                    List listN2 = cs2.N(lowerCase4, new char[]{'_', '-', ':'}, 6);
                    if (js2.e(lowerCase4, ":".concat(lowerCase5), false) || js2.e(lowerCase4, ":id/".concat(lowerCase5), false) || lowerCase4.equals(lowerCase5) || listN2.contains(lowerCase5) || (lowerCase5.equals("search") && this.n.contains(lowerCase4))) {
                        arrayList7.add(obj7);
                    }
                }
            }
            List listN3 = n(arrayList7);
            if (listN3.size() == 1) {
                AccessibilityNodeInfo accessibilityNodeInfo8 = (AccessibilityNodeInfo) mz.H(listN3);
                CharSequence text7 = accessibilityNodeInfo8.getText();
                if (text7 == null || (string15 = text7.toString()) == null) {
                    contentDescription4 = accessibilityNodeInfo8.getContentDescription();
                    if (contentDescription4 != null || (string14 = contentDescription4.toString()) == null || cs2.A(string14)) {
                        str4 = null;
                    } else {
                        str4 = string14;
                    }
                    if (str4 != null) {
                        str6 = str4;
                    }
                } else {
                    if (cs2.A(string15)) {
                        string15 = null;
                    }
                    if (string15 == null) {
                        contentDescription4 = accessibilityNodeInfo8.getContentDescription();
                        if (contentDescription4 != null) {
                            str4 = null;
                        } else {
                            str4 = null;
                        }
                        if (str4 != null) {
                            str6 = str4;
                        }
                    } else {
                        str6 = string15;
                    }
                }
                return new jb2(accessibilityNodeInfo8, str6);
            }
            if (listN3.size() > 1) {
                return a(listN3);
            }
            ArrayList arrayList8 = new ArrayList();
            int size8 = arrayList2.size();
            int i19 = 0;
            while (i19 < size8) {
                Object obj8 = arrayList2.get(i19);
                i19++;
                CharSequence text8 = ((AccessibilityNodeInfo) obj8).getText();
                if (text8 != null && (string12 = text8.toString()) != null && (string13 = cs2.V(string12).toString()) != null) {
                    String lowerCase7 = string13.toLowerCase(Locale.ROOT);
                    lowerCase7.getClass();
                    if (js2.k(lowerCase7, lowerCase5, false)) {
                        arrayList8.add(obj8);
                    }
                }
            }
            List listN4 = n(arrayList8);
            if (listN4.size() == 1) {
                return new jb2((AccessibilityNodeInfo) mz.H(listN4), ((AccessibilityNodeInfo) mz.H(listN4)).getText().toString());
            }
            ArrayList arrayList9 = new ArrayList();
            int size9 = arrayList2.size();
            int i20 = 0;
            while (i20 < size9) {
                Object obj9 = arrayList2.get(i20);
                i20++;
                AccessibilityNodeInfo accessibilityNodeInfo9 = (AccessibilityNodeInfo) obj9;
                CharSequence text9 = accessibilityNodeInfo9.getText();
                if (text9 == null || (string10 = text9.toString()) == null || (string11 = cs2.V(string10).toString()) == null) {
                    lowerCase2 = null;
                } else {
                    lowerCase2 = string11.toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                }
                if (lowerCase2 == null) {
                    lowerCase2 = "";
                }
                CharSequence contentDescription11 = accessibilityNodeInfo9.getContentDescription();
                if (contentDescription11 == null || (string8 = contentDescription11.toString()) == null || (string9 = cs2.V(string8).toString()) == null) {
                    lowerCase3 = null;
                } else {
                    lowerCase3 = string9.toLowerCase(Locale.ROOT);
                    lowerCase3.getClass();
                }
                if (lowerCase3 == null) {
                    lowerCase3 = "";
                }
                if (cs2.n(lowerCase2, lowerCase5, false) || cs2.n(lowerCase3, lowerCase5, false)) {
                    arrayList9.add(obj9);
                }
            }
            List listN5 = n(arrayList9);
            if (listN5.size() == 1) {
                AccessibilityNodeInfo accessibilityNodeInfo10 = (AccessibilityNodeInfo) mz.H(listN5);
                CharSequence text10 = accessibilityNodeInfo10.getText();
                if (text10 == null || (string7 = text10.toString()) == null) {
                    contentDescription3 = accessibilityNodeInfo10.getContentDescription();
                    if (contentDescription3 != null || (string6 = contentDescription3.toString()) == null || cs2.A(string6)) {
                        str3 = null;
                    } else {
                        str3 = string6;
                    }
                    if (str3 != null) {
                        str6 = str3;
                    }
                } else {
                    if (cs2.A(string7)) {
                        string7 = null;
                    }
                    if (string7 == null) {
                        contentDescription3 = accessibilityNodeInfo10.getContentDescription();
                        if (contentDescription3 != null) {
                            str3 = null;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            str6 = str3;
                        }
                    } else {
                        str6 = string7;
                    }
                }
                return new jb2(accessibilityNodeInfo10, str6);
            }
            if (listN5.size() > 1) {
                return a(listN5);
            }
            ArrayList arrayList10 = new ArrayList();
            int size10 = arrayList3.size();
            int i21 = 0;
            while (i21 < size10) {
                Object obj10 = arrayList3.get(i21);
                i21++;
                AccessibilityNodeInfo accessibilityNodeInfo11 = (AccessibilityNodeInfo) obj10;
                CharSequence text11 = accessibilityNodeInfo11.getText();
                if (text11 == null || (string5 = text11.toString()) == null || (string3 = cs2.V(string5).toString()) == null) {
                    contentDescription2 = accessibilityNodeInfo11.getContentDescription();
                    if (contentDescription2 != null || (string4 = contentDescription2.toString()) == null || (string3 = cs2.V(string4).toString()) == null || cs2.A(string3)) {
                        string3 = null;
                    }
                    if (string3 == null) {
                        i2 = i12;
                        i3 = size10;
                        i4 = i;
                    } else {
                        lowerCase = string3.toLowerCase(Locale.ROOT);
                        lowerCase.getClass();
                        if (lowerCase.equals(lowerCase5)) {
                            i2 = i12;
                            i3 = size10;
                            i4 = i;
                            fMax = 1.0f;
                        } else if (lowerCase.length() == 0 && lowerCase5.length() != 0) {
                            length = lowerCase.length() + i;
                            iArr = new int[length][];
                            i2 = i12;
                            while (i12 < length) {
                                iArr[i12] = new int[lowerCase5.length() + 1];
                                i12++;
                            }
                            length2 = lowerCase.length();
                            if (length2 >= 0) {
                                i11 = i2;
                                while (true) {
                                    iArr[i11][i2] = i11;
                                    if (i11 == length2) {
                                        break;
                                    }
                                    i11++;
                                }
                            }
                            length3 = lowerCase5.length();
                            if (length3 >= 0) {
                                i10 = i2;
                                while (true) {
                                    iArr[i2][i10] = i10;
                                    if (i10 == length3) {
                                        break;
                                    }
                                    i10++;
                                }
                            }
                            length4 = lowerCase.length();
                            if (i <= length4) {
                                i5 = i;
                                while (true) {
                                    length5 = lowerCase5.length();
                                    if (i <= length5) {
                                        i6 = i;
                                        f = 1.0f;
                                        while (true) {
                                            i4 = i;
                                            i7 = i5 - 1;
                                            i8 = i6 - 1;
                                            i3 = size10;
                                            if (lowerCase.charAt(i7) == lowerCase5.charAt(i8)) {
                                                i9 = i2;
                                            } else {
                                                i9 = i4;
                                            }
                                            int[] iArr2 = iArr[i5];
                                            int[] iArr3 = iArr[i7];
                                            iArr2[i6] = Math.min(iArr3[i6] + 1, Math.min(iArr2[i8] + 1, iArr3[i8] + i9));
                                            if (i6 == length5) {
                                                break;
                                            }
                                            i6++;
                                            i = i4;
                                            size10 = i3;
                                        }
                                    } else {
                                        i3 = size10;
                                        i4 = i;
                                        f = 1.0f;
                                    }
                                    if (i5 == length4) {
                                        break;
                                    }
                                    i5++;
                                    i = i4;
                                    size10 = i3;
                                }
                            } else {
                                i3 = size10;
                                i4 = i;
                                f = 1.0f;
                            }
                            fMax = f - (iArr[lowerCase.length()][lowerCase5.length()] / Math.max(lowerCase.length(), lowerCase5.length()));
                        } else {
                            fMax = 0.0f;
                            i2 = i12;
                            i3 = size10;
                            i4 = i;
                        }
                        wt1Var = fMax >= 0.8f ? new wt1(accessibilityNodeInfo11, string3) : null;
                        if (wt1Var != null) {
                            arrayList10.add(wt1Var);
                        }
                        arrayList3 = arrayList;
                        i12 = i2;
                        i = i4;
                        size10 = i3;
                    }
                } else {
                    if (cs2.A(string3)) {
                        string3 = null;
                    }
                    if (string3 == null) {
                        contentDescription2 = accessibilityNodeInfo11.getContentDescription();
                        if (contentDescription2 != null) {
                            string3 = null;
                        } else {
                            string3 = null;
                        }
                        if (string3 == null) {
                            i2 = i12;
                            i3 = size10;
                            i4 = i;
                        } else {
                            lowerCase = string3.toLowerCase(Locale.ROOT);
                            lowerCase.getClass();
                            if (lowerCase.equals(lowerCase5)) {
                                i2 = i12;
                                i3 = size10;
                                i4 = i;
                                fMax = 1.0f;
                            } else if (lowerCase.length() == 0) {
                                fMax = 0.0f;
                                i2 = i12;
                                i3 = size10;
                                i4 = i;
                            } else {
                                length = lowerCase.length() + i;
                                iArr = new int[length][];
                                i2 = i12;
                                while (i12 < length) {
                                    iArr[i12] = new int[lowerCase5.length() + 1];
                                    i12++;
                                }
                                length2 = lowerCase.length();
                                if (length2 >= 0) {
                                    i11 = i2;
                                    while (true) {
                                        iArr[i11][i2] = i11;
                                        if (i11 == length2) {
                                            break;
                                            break;
                                        }
                                        i11++;
                                    }
                                }
                                length3 = lowerCase5.length();
                                if (length3 >= 0) {
                                    i10 = i2;
                                    while (true) {
                                        iArr[i2][i10] = i10;
                                        if (i10 == length3) {
                                            break;
                                            break;
                                        }
                                        i10++;
                                    }
                                }
                                length4 = lowerCase.length();
                                if (i <= length4) {
                                    i5 = i;
                                    while (true) {
                                        length5 = lowerCase5.length();
                                        if (i <= length5) {
                                            i6 = i;
                                            f = 1.0f;
                                            while (true) {
                                                i4 = i;
                                                i7 = i5 - 1;
                                                i8 = i6 - 1;
                                                i3 = size10;
                                                if (lowerCase.charAt(i7) == lowerCase5.charAt(i8)) {
                                                    i9 = i2;
                                                } else {
                                                    i9 = i4;
                                                }
                                                int[] iArr4 = iArr[i5];
                                                int[] iArr5 = iArr[i7];
                                                iArr4[i6] = Math.min(iArr5[i6] + 1, Math.min(iArr4[i8] + 1, iArr5[i8] + i9));
                                                if (i6 == length5) {
                                                    break;
                                                    break;
                                                }
                                                i6++;
                                                i = i4;
                                                size10 = i3;
                                            }
                                        } else {
                                            i3 = size10;
                                            i4 = i;
                                            f = 1.0f;
                                        }
                                        if (i5 == length4) {
                                            break;
                                            break;
                                        }
                                        i5++;
                                        i = i4;
                                        size10 = i3;
                                    }
                                } else {
                                    i3 = size10;
                                    i4 = i;
                                    f = 1.0f;
                                }
                                fMax = f - (iArr[lowerCase.length()][lowerCase5.length()] / Math.max(lowerCase.length(), lowerCase5.length()));
                            }
                            if (fMax >= 0.8f) {
                            }
                        }
                    } else {
                        lowerCase = string3.toLowerCase(Locale.ROOT);
                        lowerCase.getClass();
                        if (lowerCase.equals(lowerCase5)) {
                            i2 = i12;
                            i3 = size10;
                            i4 = i;
                            fMax = 1.0f;
                        } else if (lowerCase.length() == 0) {
                            fMax = 0.0f;
                            i2 = i12;
                            i3 = size10;
                            i4 = i;
                        } else {
                            length = lowerCase.length() + i;
                            iArr = new int[length][];
                            i2 = i12;
                            while (i12 < length) {
                                iArr[i12] = new int[lowerCase5.length() + 1];
                                i12++;
                            }
                            length2 = lowerCase.length();
                            if (length2 >= 0) {
                                i11 = i2;
                                while (true) {
                                    iArr[i11][i2] = i11;
                                    if (i11 == length2) {
                                        break;
                                        break;
                                    }
                                    i11++;
                                }
                            }
                            length3 = lowerCase5.length();
                            if (length3 >= 0) {
                                i10 = i2;
                                while (true) {
                                    iArr[i2][i10] = i10;
                                    if (i10 == length3) {
                                        break;
                                        break;
                                    }
                                    i10++;
                                }
                            }
                            length4 = lowerCase.length();
                            if (i <= length4) {
                                i5 = i;
                                while (true) {
                                    length5 = lowerCase5.length();
                                    if (i <= length5) {
                                        i6 = i;
                                        f = 1.0f;
                                        while (true) {
                                            i4 = i;
                                            i7 = i5 - 1;
                                            i8 = i6 - 1;
                                            i3 = size10;
                                            if (lowerCase.charAt(i7) == lowerCase5.charAt(i8)) {
                                                i9 = i2;
                                            } else {
                                                i9 = i4;
                                            }
                                            int[] iArr6 = iArr[i5];
                                            int[] iArr7 = iArr[i7];
                                            iArr6[i6] = Math.min(iArr7[i6] + 1, Math.min(iArr6[i8] + 1, iArr7[i8] + i9));
                                            if (i6 == length5) {
                                                break;
                                                break;
                                            }
                                            i6++;
                                            i = i4;
                                            size10 = i3;
                                        }
                                    } else {
                                        i3 = size10;
                                        i4 = i;
                                        f = 1.0f;
                                    }
                                    if (i5 == length4) {
                                        break;
                                        break;
                                    }
                                    i5++;
                                    i = i4;
                                    size10 = i3;
                                }
                            } else {
                                i3 = size10;
                                i4 = i;
                                f = 1.0f;
                            }
                            fMax = f - (iArr[lowerCase.length()][lowerCase5.length()] / Math.max(lowerCase.length(), lowerCase5.length()));
                        }
                        if (fMax >= 0.8f) {
                        }
                    }
                    if (wt1Var != null) {
                        arrayList10.add(wt1Var);
                    }
                    arrayList3 = arrayList;
                    i12 = i2;
                    i = i4;
                    size10 = i3;
                }
                if (wt1Var != null) {
                    arrayList10.add(wt1Var);
                }
                arrayList3 = arrayList;
                i12 = i2;
                i = i4;
                size10 = i3;
            }
            int i22 = i;
            ArrayList arrayList11 = new ArrayList(nz.d(arrayList10));
            int size11 = arrayList10.size();
            while (i12 < size11) {
                Object obj11 = arrayList10.get(i12);
                i12++;
                arrayList11.add((AccessibilityNodeInfo) ((wt1) obj11).a);
            }
            List listN6 = n(arrayList11);
            if (listN6.size() == i22) {
                AccessibilityNodeInfo accessibilityNodeInfo12 = (AccessibilityNodeInfo) mz.H(listN6);
                CharSequence text12 = accessibilityNodeInfo12.getText();
                if (text12 == null || (string = text12.toString()) == null) {
                    contentDescription = accessibilityNodeInfo12.getContentDescription();
                    if (contentDescription != null || (string2 = contentDescription.toString()) == null || cs2.A(string2)) {
                        str2 = null;
                    } else {
                        str2 = string2;
                    }
                    if (str2 == null) {
                        string = str;
                    } else {
                        string = str2;
                    }
                } else {
                    if (cs2.A(string)) {
                        string = null;
                    }
                    if (string == null) {
                        contentDescription = accessibilityNodeInfo12.getContentDescription();
                        if (contentDescription != null) {
                            str2 = null;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            string = str;
                        } else {
                            string = str2;
                        }
                    }
                }
                return new jb2(accessibilityNodeInfo12, string);
            }
            if (listN6.size() > 1) {
                return a(listN6);
            }
        }
        return kb2.a;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001d  */
    public final r3 q(String str, List list, List list2) {
        str.getClass();
        list.getClass();
        list2.getClass();
        ib2 ib2VarA = a(list);
        ArrayList arrayList = ib2VarA.b;
        if (yc3.m(str)) {
            this.e.addAll(arrayList);
        } else {
            Set set = xc2.a;
            if (g24.a(str)) {
                this.e.addAll(arrayList);
            }
        }
        return new r3(str, list2.size() == list.size() ? mz.L(list2, arrayList.size()) : ib2VarA.a, arrayList, null, 8);
    }

    public final boolean s(String str) {
        str.getClass();
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, string, locale);
        Pattern patternCompile = Pattern.compile("^(?:click|tap|press)\\s+(?:on\\s+)?");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll("");
        strReplaceAll.getClass();
        return this.h.contains(cs2.V(cs2.I(cs2.G(strReplaceAll, "the "), " button")).toString());
    }

    /* JADX WARN: Code duplicated, block: B:104:0x019b  */
    /* JADX WARN: Code duplicated, block: B:120:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:125:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:? A[LOOP:2: B:60:0x010e->B:136:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0101  */
    /* JADX WARN: Code duplicated, block: B:59:0x0109  */
    /* JADX WARN: Code duplicated, block: B:61:0x0110  */
    /* JADX WARN: Code duplicated, block: B:66:0x012a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0146  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0153  */
    /* JADX WARN: Code duplicated, block: B:85:0x015d A[Catch: all -> 0x016e, TryCatch #2 {all -> 0x016e, blocks: (B:83:0x0157, B:85:0x015d, B:91:0x0174, B:93:0x017a, B:95:0x0180, B:97:0x0186, B:100:0x018d, B:102:0x0193, B:105:0x019c), top: B:125:0x0157, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0170  */
    /* JADX WARN: Code duplicated, block: B:90:0x0173  */
    /* JADX WARN: Code duplicated, block: B:93:0x017a A[Catch: all -> 0x016e, TryCatch #2 {all -> 0x016e, blocks: (B:83:0x0157, B:85:0x015d, B:91:0x0174, B:93:0x017a, B:95:0x0180, B:97:0x0186, B:100:0x018d, B:102:0x0193, B:105:0x019c), top: B:125:0x0157, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x017f  */
    public final boolean v(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        String strO;
        Set set;
        int size;
        int i;
        Object obj;
        x42 x42Var;
        boolean z;
        AccessibilityNodeInfo parent;
        int i2;
        String viewIdResourceName;
        String lowerCase;
        CharSequence packageName;
        String string;
        AccessibilityNodeInfo parent2;
        CharSequence className;
        String string2;
        String strO2;
        String string3;
        String string4;
        CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (g31.a(packageName2 != null ? packageName2.toString() : null, "com.google.android.youtube") && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && !accessibilityNodeInfo.isPassword()) {
            Rect rectG = cq.g(accessibilityNodeInfo);
            if (rectG.right > rectG.left && rectG.bottom > rectG.top) {
                String viewIdResourceName2 = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName2 != null) {
                    String strS = cs2.S(viewIdResourceName2, '/');
                    Locale locale = Locale.ROOT;
                    strO = cq.o(locale, strS, locale);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                List<CharSequence> listI = nz.i(accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription());
                ArrayList arrayList = new ArrayList(nz.d(listI));
                for (CharSequence charSequence : listI) {
                    if (charSequence == null || (string3 = charSequence.toString()) == null || (string4 = cs2.V(string3).toString()) == null) {
                        strO2 = null;
                    } else {
                        Locale locale2 = Locale.ROOT;
                        strO2 = cq.o(locale2, string4, locale2);
                    }
                    if (strO2 == null) {
                        strO2 = "";
                    }
                    Pattern patternCompile = Pattern.compile("[⏭▶►»›|]+");
                    patternCompile.getClass();
                    String strReplaceAll = patternCompile.matcher(strO2).replaceAll("");
                    strReplaceAll.getClass();
                    arrayList.add(cs2.V(strReplaceAll).toString());
                }
                if (!cs2.n(strO, "next", false)) {
                    if (arrayList.isEmpty()) {
                        set = this.j;
                        if (set.contains(strO)) {
                            return true;
                        }
                        if (!arrayList.isEmpty()) {
                            size = arrayList.size();
                            i = 0;
                            while (i < size) {
                                obj = arrayList.get(i);
                                i++;
                                if (this.i.contains((String) obj)) {
                                    x42Var = this.k;
                                    if (!x42Var.a(strO)) {
                                        break;
                                    }
                                    if (accessibilityNodeInfo.isClickable() || (className = accessibilityNodeInfo.getClassName()) == null || (string2 = className.toString()) == null || !js2.e(string2, "Button", false)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    parent = accessibilityNodeInfo.getParent();
                                    i2 = 0;
                                    while (i2 < 5) {
                                        if (parent == null) {
                                            if (parent != null) {
                                                parent.recycle();
                                                return z;
                                            }
                                            return z;
                                        }
                                        try {
                                            try {
                                                viewIdResourceName = parent.getViewIdResourceName();
                                                if (viewIdResourceName != null) {
                                                    String strS2 = cs2.S(viewIdResourceName, '/');
                                                    Locale locale3 = Locale.ROOT;
                                                    locale3.getClass();
                                                    lowerCase = strS2.toLowerCase(locale3);
                                                    lowerCase.getClass();
                                                } else {
                                                    lowerCase = null;
                                                }
                                                if (lowerCase == null) {
                                                    lowerCase = "";
                                                }
                                                packageName = parent.getPackageName();
                                                if (packageName != null) {
                                                    string = packageName.toString();
                                                } else {
                                                    string = null;
                                                }
                                                if (g31.a(string, "com.google.android.youtube") && !x42Var.a(lowerCase)) {
                                                    if (set.contains(lowerCase) || this.l.a(lowerCase)) {
                                                        z = true;
                                                    }
                                                    parent2 = parent.getParent();
                                                    try {
                                                        parent.recycle();
                                                        i2++;
                                                        parent = parent2;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        accessibilityNodeInfo2 = parent2;
                                                        if (accessibilityNodeInfo2 != null) {
                                                            accessibilityNodeInfo2.recycle();
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                parent.recycle();
                                                return false;
                                            } catch (Throwable th2) {
                                                parent.recycle();
                                                throw th2;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                    if (parent != null) {
                                        parent.recycle();
                                    }
                                    return z;
                                }
                            }
                        }
                    } else {
                        int size2 = arrayList.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj2 = arrayList.get(i3);
                            i3++;
                            String str = (String) obj2;
                            if (!cs2.n(str, "next", false)) {
                                Pattern patternCompile2 = Pattern.compile("\\b(?:in\\s+\\d+|\\d+\\s*(?:seconds?|s))\\b");
                                patternCompile2.getClass();
                                if (patternCompile2.matcher(str).find()) {
                                }
                            }
                        }
                        set = this.j;
                        if (set.contains(strO)) {
                            return true;
                        }
                        if (!arrayList.isEmpty()) {
                            size = arrayList.size();
                            i = 0;
                            while (i < size) {
                                obj = arrayList.get(i);
                                i++;
                                if (this.i.contains((String) obj)) {
                                    x42Var = this.k;
                                    if (!x42Var.a(strO)) {
                                        break;
                                    }
                                    if (accessibilityNodeInfo.isClickable()) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    parent = accessibilityNodeInfo.getParent();
                                    i2 = 0;
                                    while (i2 < 5) {
                                        if (parent == null) {
                                            if (parent != null) {
                                                parent.recycle();
                                                return z;
                                            }
                                            return z;
                                        }
                                        viewIdResourceName = parent.getViewIdResourceName();
                                        if (viewIdResourceName != null) {
                                            String strS3 = cs2.S(viewIdResourceName, '/');
                                            Locale locale4 = Locale.ROOT;
                                            locale4.getClass();
                                            lowerCase = strS3.toLowerCase(locale4);
                                            lowerCase.getClass();
                                        } else {
                                            lowerCase = null;
                                        }
                                        if (lowerCase == null) {
                                            lowerCase = "";
                                        }
                                        packageName = parent.getPackageName();
                                        if (packageName != null) {
                                            string = packageName.toString();
                                        } else {
                                            string = null;
                                        }
                                        if (g31.a(string, "com.google.android.youtube")) {
                                            if (set.contains(lowerCase)) {
                                                z = true;
                                            } else {
                                                z = true;
                                            }
                                            parent2 = parent.getParent();
                                            parent.recycle();
                                            i2++;
                                            parent = parent2;
                                        }
                                        parent.recycle();
                                        return false;
                                    }
                                    if (parent != null) {
                                        parent.recycle();
                                    }
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
