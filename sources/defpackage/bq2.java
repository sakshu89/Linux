package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bq2 implements AutoCloseable {
    public static final List H;
    public static final x42 X;
    public static final x42 Y;
    public static final x42 Z;
    public static final x42 c0;
    public static final x42 d0;
    public static final x42 e0;
    public static final Set i = wh2.c("title", "entity_title", "row_title", "item_title", "primary_text", "track_title", "track_name", "song_title");
    public static final Set j = wh2.c("track_row", "song_row", "track_title", "track_name", "song_title");
    public static final Set k = wh2.c("row_root", "result_row", "entity_row", "track_row", "song_row", "artist_row", "album_row", "single_row", "ep_row", "playlist_row", "podcast_row", "episode_row", "audiobook_row");
    public static final Set n = wh2.c("artist_row", "artist_title");
    public static final Set s = wh2.c("song", "track");
    public static final Set t;
    public static final LinkedHashSet u;
    public static final Set v;
    public static final Set w;
    public static final Set x;
    public final zp2 c;
    public boolean f;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final cv2 e = new cv2(new g7(0, this, bq2.class, "collectPlayableTargets", "collectPlayableTargets()Ljava/util/List;", 0, 0, 17));

    static {
        Set setC = wh2.c("album", "single", "ep", "playlist", "podcast", "episode", "audiobook");
        t = setC;
        LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(setC.size() + 1));
        linkedHashSet.addAll(setC);
        linkedHashSet.add("artist");
        u = linkedHashSet;
        v = wh2.c("ad", "advertisement", "sponsored", "promoted");
        w = wh2.c("home", "search", "your library", "premium", "more options", "options", "songs", "artists", "albums", "singles", "eps", "playlists", "podcasts", "top result", "now playing", "mini player", "back", "clear", "see all", "filter", "sort", "play", "pause", "resume", "next", "previous", "skip next", "skip previous");
        x = wh2.c("now playing", "mini player", "pause", "resume", "next", "previous", "skip next", "skip previous");
        H = nz.i("RecyclerView", "ListView", "ScrollView", "ViewPager");
        X = new x42("[,\\n•·|]");
        y42 y42Var = y42.IGNORE_CASE;
        Y = new x42("^play\\s+", y42Var);
        Z = new x42("\\b(?:ad|advertisement|sponsored|promoted)\\b", y42Var);
        c0 = new x42("(?:artist|subtitle|secondary|metadata|byline)");
        d0 = new x42("^(?:action_bar|context_menu_button|add_button|add_to_button|more_button|overflow|options)$");
        e0 = new x42("(?:^|_)(?:navigation|nav|tab|header|ad|ads|promoted|sponsored|artist_row|album_row|single_row|ep_row|playlist_row|podcast|episode|audiobook|overflow|options|context_menu|more_button)(?:_|$)|mini_player|now_playing|playback_bar");
    }

    public bq2(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.c = x(accessibilityNodeInfo, null);
    }

    public static ArrayList A(String str) {
        List listI = X.i(str);
        ArrayList arrayList = new ArrayList(nz.d(listI));
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(cs2.V((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (!cs2.A((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static String D(String str) {
        return cs2.V(Y.h(str)).toString();
    }

    public static String E(zp2 zp2Var) {
        String str = zp2Var.f;
        if (w(str) || !c0.a(str)) {
            String string = cs2.V(zp2Var.d).toString();
            if (cs2.A(string)) {
                string = null;
            }
            if (string == null) {
                return H(zp2Var.e);
            }
            if (!w(str)) {
                return H(string);
            }
            String strD = D(string);
            if (!cs2.A(strD)) {
                return strD;
            }
        }
        return null;
    }

    public static String H(String str) {
        String strC;
        ArrayList arrayListA = A(str);
        if (arrayListA.isEmpty() || v((String) mz.x(arrayListA))) {
            return null;
        }
        if (y(str) == null) {
            strC = cs2.V(str).toString();
        } else {
            ArrayList arrayList = new ArrayList();
            int size = arrayListA.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListA.get(i2);
                i2++;
                if (v((String) obj)) {
                    break;
                }
                arrayList.add(obj);
            }
            strC = mz.C(arrayList, ", ", null, null, null, 62);
        }
        String strD = D(strC);
        if (cs2.A(strD)) {
            return null;
        }
        return strD;
    }

    public static final int c(bq2 bq2Var, zp2 zp2Var) {
        bq2Var.getClass();
        String str = zp2Var.f;
        if (j.contains(str) || cs2.n(str, "track_", false) || cs2.n(str, "song_", false)) {
            return 0;
        }
        return i.contains(str) ? 1 : 2;
    }

    public static final void e(ArrayList arrayList, zp2 zp2Var, int i2) {
        if (i2 > 4 || arrayList.size() >= 40) {
            return;
        }
        arrayList.add(zp2Var);
        ArrayList arrayList2 = zp2Var.g;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            e(arrayList, (zp2) obj, i2 + 1);
        }
    }

    public static boolean v(String str) {
        String strL = cq2.l(str);
        return s.contains(strL) || u.contains(strL) || v.contains(strL) || cs2.A(strL);
    }

    public static boolean w(String str) {
        return i.contains(str) || cs2.n(str, "track_title", false) || cs2.n(str, "track_name", false) || cs2.n(str, "song_title", false);
    }

    public static String y(String str) {
        String str2;
        ArrayList arrayListA = A(str);
        int size = arrayListA.size();
        int i2 = 0;
        do {
            str2 = null;
            if (i2 >= size) {
                break;
            }
            Object obj = arrayListA.get(i2);
            i2++;
            String strL = cq2.l((String) obj);
            if (g31.a(strL, "song")) {
                str2 = "Song";
            } else if (g31.a(strL, "track")) {
                str2 = "Track";
            }
        } while (str2 == null);
        return str2;
    }

    public final boolean C(aq2 aq2Var) {
        ArrayList arrayList = aq2Var.b;
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            zp2 zp2Var = (zp2) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = zp2Var.a;
            if (accessibilityNodeInfo.refresh() && K(zp2Var)) {
                CharSequence text = accessibilityNodeInfo.getText();
                String string = text != null ? text.toString() : null;
                if (string == null) {
                    string = "";
                }
                if (string.equals(zp2Var.d)) {
                    CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                    String string2 = contentDescription != null ? contentDescription.toString() : null;
                    if ((string2 != null ? string2 : "").equals(zp2Var.e)) {
                        Rect rect = zp2Var.c;
                        Rect rectG = cq.g(accessibilityNodeInfo);
                        if (rect.left != rectG.left || rect.top != rectG.top || rect.right != rectG.right || rect.bottom != rectG.bottom) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean K(zp2 zp2Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = zp2Var.a;
        Rect rect = zp2Var.c;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (!g31.a(packageName != null ? packageName.toString() : null, "com.spotify.music") || !accessibilityNodeInfo.isVisibleToUser() || !accessibilityNodeInfo.isEnabled() || accessibilityNodeInfo.isPassword() || rect.right <= rect.left || rect.bottom <= rect.top) {
            return false;
        }
        zp2 zp2Var2 = this.c;
        if (zp2Var2.c.isEmpty()) {
            return true;
        }
        int i2 = rect.left;
        Rect rect2 = zp2Var2.c;
        return i2 >= rect2.left && rect.top >= rect2.top && rect.right <= rect2.right && rect.bottom <= rect2.bottom;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f) {
            return;
        }
        this.f = true;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((AccessibilityNodeInfo) obj).recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0219  */
    /* JADX WARN: Code duplicated, block: B:119:0x021c A[SYNTHETIC] */
    public final List j(String str, String str2) {
        Iterator it;
        int i2;
        int iD;
        String str3 = str;
        str3.getClass();
        if (cs2.A(str3)) {
            return mz.L(r(), 4);
        }
        List listR = r();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = listR.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            aq2 aq2Var = (aq2) next;
            Set set = cq2.a;
            String str4 = aq2Var.c;
            String str5 = aq2Var.d;
            str4.getClass();
            if (cq2.h(str3, str2, str4, str5)) {
                i2 = 10000;
            } else {
                int i3 = 1;
                if (!cs2.A(str4)) {
                    if (!cq2.o(str3, str4) || !cq2.a(str2, str5)) {
                        if (!cq2.o((str2 == 0 || cs2.A(str2) || cs2.n(str3, " by ", true)) ? str3 : cq.k(str3, " by ", str2), str4)) {
                            if ((str2 == 0 || cs2.A(str2)) && (iD = cs2.D(str3, 2, " by ")) > 0) {
                                String string = cs2.V(str3.substring(0, iD)).toString();
                                String string2 = cs2.V(str3.substring(iD + 4)).toString();
                                if (cs2.A(string) || cs2.A(string2) || !cq2.o(string, str4) || !cq2.a(string2, str5)) {
                                }
                                if (i2 >= 200) {
                                    arrayList.add(next);
                                }
                                str3 = str;
                                it2 = it;
                            }
                        }
                    }
                    i2 = 8000;
                }
                String strT = cs2.T(256, cq2.l(str3));
                String strT2 = cs2.T(256, cq2.l(str4));
                List listN = cs2.N(strT, new char[]{' '}, 6);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listN) {
                    if (!cs2.A((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                Set setQ = mz.Q(arrayList2);
                List listN2 = cs2.N(strT2, new char[]{' '}, 6);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : listN2) {
                    if (!cs2.A((String) obj2)) {
                        arrayList3.add(obj2);
                    }
                }
                Set set2 = setQ;
                Set setQ2 = mz.Q(arrayList3);
                Set setO = setQ2 instanceof Collection ? setQ2 : mz.O(setQ2);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (Object obj3 : set2) {
                    if (setO.contains(obj3)) {
                        linkedHashSet.add(obj3);
                    }
                }
                int size = linkedHashSet.size();
                int i4 = (js2.k(strT2, strT, false) || js2.k(strT, strT2, false)) ? 800 : 0;
                int i5 = (str2 == 0 || cs2.A(str2) || !cq2.a(str2, str5)) ? 0 : BreakIterator.WORD_IDEO_LIMIT;
                int length = strT2.length();
                int i6 = length + 1;
                int[] iArr = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr[i7] = i7;
                }
                int length2 = strT.length();
                int i8 = 0;
                while (i8 < length2) {
                    int i9 = iArr[0];
                    int i10 = i8 + 1;
                    iArr[0] = i10;
                    int i11 = i3;
                    int length3 = strT2.length();
                    int i12 = 0;
                    while (i12 < length3) {
                        int i13 = i12 + 1;
                        int i14 = iArr[i13];
                        Iterator it3 = it2;
                        int i15 = i5;
                        iArr[i13] = Math.min(i14 + 1, Math.min(iArr[i12] + 1, i9 + (strT.charAt(i8) == strT2.charAt(i12) ? 0 : i11)));
                        i12 = i13;
                        i9 = i14;
                        i5 = i15;
                        it2 = it3;
                    }
                    i8 = i10;
                    i3 = i11;
                }
                it = it2;
                int i16 = i5;
                int iMax = Math.max(strT.length(), Math.max(strT2.length(), i3));
                if (i6 == 0) {
                    kf2.g("Array is empty.");
                    return null;
                }
                int i17 = ((iMax - iArr[length]) * 1000) / iMax;
                i2 = (size * 1000) + i4 + i16 + (i17 < 0 ? 0 : i17);
                if (i2 >= 200) {
                    arrayList.add(next);
                }
                str3 = str;
                it2 = it;
            }
            it = it2;
            if (i2 >= 200) {
                arrayList.add(next);
            }
            str3 = str;
            it2 = it;
        }
        return arrayList.isEmpty() ? mz.L(r(), 4) : mz.L(arrayList, 4);
    }

    public final List o(int i2, String str, String str2, List list) {
        str.getClass();
        list.getClass();
        List<aq2> listR = r();
        ArrayList arrayList = new ArrayList(nz.d(listR));
        for (aq2 aq2Var : listR) {
            arrayList.add(new xv2(aq2Var.c, aq2Var.d, null));
        }
        Integer numD = cq2.d(list, i2, arrayList);
        if (numD != null) {
            return nz.h(r().get(numD.intValue()));
        }
        if (!cq2.i(str2)) {
            return q(str, str2);
        }
        List listR2 = r();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listR2) {
            Set set = cq2.a;
            if (cq2.e(str, ((aq2) obj).c)) {
                arrayList2.add(obj);
            }
        }
        aq2 aq2Var2 = (aq2) mz.I(arrayList2);
        if (aq2Var2 == null) {
            return ii0.a;
        }
        List listH = nz.h(aq2Var2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listH) {
            Set set2 = cq2.a;
            if (cq2.b(str2, ((aq2) obj2).d)) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    public final ArrayList q(String str, String str2) {
        str.getClass();
        List listR = r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            aq2 aq2Var = (aq2) obj;
            Set set = cq2.a;
            if (cq2.h(str, str2, aq2Var.c, aq2Var.d)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List r() {
        return (List) this.e.getValue();
    }

    public final zp2 x(AccessibilityNodeInfo accessibilityNodeInfo, zp2 zp2Var) {
        Rect rectG = cq.g(accessibilityNodeInfo);
        CharSequence text = accessibilityNodeInfo.getText();
        String strO = null;
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        String string2 = contentDescription != null ? contentDescription.toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (viewIdResourceName != null) {
            String strS = cs2.S(viewIdResourceName, '/');
            Locale locale = Locale.ROOT;
            strO = cq.o(locale, strS, locale);
        }
        zp2 zp2Var2 = new zp2(accessibilityNodeInfo, zp2Var, rectG, string, string2, strO == null ? "" : strO);
        ArrayList arrayList = this.a;
        arrayList.add(zp2Var2);
        if (!accessibilityNodeInfo.isPassword() && arrayList.size() < 800) {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i2 = 0; i2 < childCount && arrayList.size() < 800; i2++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
                if (child != null) {
                    this.b.add(child);
                    zp2Var2.g.add(x(child, zp2Var2));
                }
            }
        }
        return zp2Var2;
    }
}
