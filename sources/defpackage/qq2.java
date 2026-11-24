package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qq2 {
    public static final Set e = wh2.c("row_root", "result_row", "entity_row", "track_row", "song_row", "search_content_recyclerview");
    public final r2 a;
    public final ii1 b;
    public final j5 c;
    public final an1 d;

    public qq2(r2 r2Var, ii1 ii1Var, j5 j5Var) {
        r2Var.getClass();
        ii1Var.getClass();
        j5Var.getClass();
        this.a = r2Var;
        this.b = ii1Var;
        this.c = j5Var;
        this.d = new an1();
    }

    public static final List a(qq2 qq2Var, nq2 nq2Var, String str) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        String string;
        ArrayList arrayList = nq2Var.b;
        IdentityHashMap identityHashMap = nq2Var.c;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            AccessibilityNodeInfo accessibilityNodeInfo3 = null;
            if (e(accessibilityNodeInfo2, nq2Var)) {
                for (CharSequence charSequence : zg2.g(accessibilityNodeInfo2.getText(), accessibilityNodeInfo2.getContentDescription())) {
                    if (g31.a((charSequence == null || (string = charSequence.toString()) == null) ? null : cq2.l(string), str)) {
                        AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo2;
                        while (true) {
                            Set set = e;
                            if (accessibilityNodeInfo4 == null) {
                                int i2 = 0;
                                Object obj2 = accessibilityNodeInfo2;
                                while (i2 < 3 && (accessibilityNodeInfo = (AccessibilityNodeInfo) obj2) != null && identityHashMap.get(accessibilityNodeInfo) != null && e(accessibilityNodeInfo, nq2Var) && !accessibilityNodeInfo.isScrollable() && !set.contains(g(accessibilityNodeInfo))) {
                                    if (accessibilityNodeInfo.isClickable()) {
                                        accessibilityNodeInfo3 = accessibilityNodeInfo;
                                        break;
                                    }
                                    i2++;
                                    obj2 = identityHashMap.get(accessibilityNodeInfo);
                                }
                                break;
                            }
                            if (set.contains(g(accessibilityNodeInfo4))) {
                                break;
                            }
                            accessibilityNodeInfo4 = (AccessibilityNodeInfo) identityHashMap.get(accessibilityNodeInfo4);
                        }
                    }
                }
            }
            if (accessibilityNodeInfo3 != null) {
                arrayList2.add(accessibilityNodeInfo3);
            }
        }
        return mz.t(arrayList2);
    }

    public static final List b(qq2 qq2Var, AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rectG = cq.g(accessibilityNodeInfo);
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        CharSequence text = accessibilityNodeInfo.getText();
        String string = text != null ? text.toString() : null;
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        return nz.i(viewIdResourceName, string, contentDescription != null ? contentDescription.toString() : null, Integer.valueOf(rectG.left), Integer.valueOf(rectG.top), Integer.valueOf(rectG.right), Integer.valueOf(rectG.bottom));
    }

    public static final ArrayList c(qq2 qq2Var, nq2 nq2Var, String str) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        String string;
        ArrayList arrayList = nq2Var.b;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (g(accessibilityNodeInfo2).equals("now_playing_bar_layout") && accessibilityNodeInfo2.isClickable() && e(accessibilityNodeInfo2, nq2Var) && !arrayList.isEmpty()) {
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj2;
                    if (g(accessibilityNodeInfo3).equals("track_info_view_title") && e(accessibilityNodeInfo3, nq2Var)) {
                        Set set = cq2.a;
                        CharSequence text = accessibilityNodeInfo3.getText();
                        String string2 = null;
                        if (text != null && (string = text.toString()) != null) {
                            if (cs2.A(string)) {
                                CharSequence contentDescription = accessibilityNodeInfo3.getContentDescription();
                                string2 = contentDescription != null ? contentDescription.toString() : null;
                                if (string2 == null) {
                                    string2 = "";
                                }
                            } else {
                                string2 = string;
                            }
                        }
                        if (cq2.e(str, string2)) {
                            IdentityHashMap identityHashMap = nq2Var.c;
                            Object obj3 = identityHashMap.get(accessibilityNodeInfo3);
                            for (int i3 = 0; i3 < 6 && (accessibilityNodeInfo = (AccessibilityNodeInfo) obj3) != null; i3++) {
                                if (accessibilityNodeInfo == accessibilityNodeInfo2) {
                                    arrayList2.add(obj);
                                    break;
                                }
                                obj3 = identityHashMap.get(accessibilityNodeInfo);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object d(qq2 qq2Var, String str, String str2, y50 y50Var) {
        pq2 pq2Var;
        ii1 ii1Var = qq2Var.b;
        r2 r2Var = qq2Var.a;
        if (y50Var instanceof pq2) {
            pq2Var = (pq2) y50Var;
            int i = pq2Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                pq2Var.k = i - Integer.MIN_VALUE;
            } else {
                pq2Var = new pq2(qq2Var, y50Var);
            }
        } else {
            pq2Var = new pq2(qq2Var, y50Var);
        }
        Object objC = pq2Var.i;
        int i2 = pq2Var.k;
        boolean z = true;
        if (i2 == 0) {
            bz3.g(objC);
            j5 j5Var = qq2Var.c;
            pq2Var.e = str;
            pq2Var.f = str2;
            pq2Var.k = 1;
            objC = rn4.c(j5Var.b, pq2Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = pq2Var.f;
            str = pq2Var.e;
            bz3.g(objC);
        }
        if (!((g5) objC).i) {
            return new kq2("Enable SONIC screen reading to select Spotify's video mode");
        }
        if (!r2Var.j()) {
            return new kq2("SONIC accessibility is not connected");
        }
        if (r2Var.l()) {
            return new kq2("The phone is locked");
        }
        if (!ii1Var.b.a()) {
            return new kq2("Notification access is needed to verify the requested Spotify track");
        }
        ro1 ro1VarE = ii1Var.e("com.spotify.music");
        if (g31.a(ro1VarE != null ? ro1VarE.a : null, "com.spotify.music")) {
            Set set = cq2.a;
            if (cq2.h(str, str2, ro1VarE.c, ro1VarE.d)) {
                AccessibilityNodeInfo accessibilityNodeInfoB = r2Var.b();
                if (accessibilityNodeInfoB == null) {
                    return new kq2("Spotify's foreground window is unavailable");
                }
                CharSequence packageName = accessibilityNodeInfoB.getPackageName();
                if (!g31.a(packageName != null ? packageName.toString() : null, "com.spotify.music")) {
                    accessibilityNodeInfoB.recycle();
                    return new kq2("Spotify is no longer in the foreground");
                }
                Rect rectG = cq.g(accessibilityNodeInfoB);
                jq2 jq2Var = new jq2(accessibilityNodeInfoB.getWindowId(), rectG.left, rectG.top, rectG.right, rectG.bottom);
                ArrayList arrayList = new ArrayList();
                IdentityHashMap identityHashMap = new IdentityHashMap();
                IdentityHashMap identityHashMap2 = new IdentityHashMap();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(accessibilityNodeInfoB);
                identityHashMap2.put(accessibilityNodeInfoB, Boolean.TRUE);
                while (!arrayDeque.isEmpty()) {
                    AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) arrayDeque.removeFirst();
                    arrayList.add(accessibilityNodeInfo);
                    if (!accessibilityNodeInfo.isPassword()) {
                        int childCount = accessibilityNodeInfo.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            if (identityHashMap2.size() >= 600) {
                                z = false;
                                break;
                            }
                            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                            if (child != null && identityHashMap2.put(child, Boolean.TRUE) == null) {
                                identityHashMap.put(child, accessibilityNodeInfo);
                                arrayDeque.add(child);
                            }
                        }
                    }
                }
                nq2 nq2Var = new nq2(jq2Var, arrayList, identityHashMap, ro1VarE);
                if (z && rectG.right > rectG.left && rectG.bottom > rectG.top) {
                    return new lq2(nq2Var);
                }
                nq2Var.close();
                return new kq2("Spotify's player window is incomplete");
            }
        }
        return new kq2("Spotify is no longer on the selected track");
    }

    public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo, nq2 nq2Var) {
        Rect rectG;
        int i;
        int i2;
        int i3;
        int i4;
        if (!accessibilityNodeInfo.isVisibleToUser() || !accessibilityNodeInfo.isEnabled() || accessibilityNodeInfo.isPassword() || accessibilityNodeInfo.isEditable()) {
            return false;
        }
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (!g31.a(packageName != null ? packageName.toString() : null, "com.spotify.music") || accessibilityNodeInfo.getWindowId() != nq2Var.a.a || (i = (rectG = cq.g(accessibilityNodeInfo)).right) <= (i2 = rectG.left) || (i3 = rectG.bottom) <= (i4 = rectG.top)) {
            return false;
        }
        jq2 jq2Var = nq2Var.a;
        return i2 >= jq2Var.b && i4 >= jq2Var.c && i <= jq2Var.d && i3 <= jq2Var.e;
    }

    public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        String strS = viewIdResourceName != null ? cs2.S(viewIdResourceName, '/') : null;
        return strS == null ? "" : strS;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0129  */
    /* JADX WARN: Code duplicated, block: B:48:0x013b A[Catch: all -> 0x01d3, TryCatch #1 {all -> 0x01d3, blocks: (B:44:0x0131, B:48:0x013b, B:50:0x013f), top: B:101:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x013f A[Catch: all -> 0x01d3, TRY_LEAVE, TryCatch #1 {all -> 0x01d3, blocks: (B:44:0x0131, B:48:0x013b, B:50:0x013f), top: B:101:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0179  */
    /* JADX WARN: Code duplicated, block: B:57:0x0197 A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x019f A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01a3 A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01ab A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01b6 A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b9 A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ca A[Catch: all -> 0x007a, TryCatch #4 {all -> 0x007a, blocks: (B:54:0x0186, B:56:0x018c, B:57:0x0197, B:59:0x019f, B:60:0x01a3, B:62:0x01ab, B:64:0x01b6, B:65:0x01b9, B:68:0x01ca, B:69:0x01cf, B:22:0x006f), top: B:107:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:85:0x0225  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0217 -> B:82:0x0218). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object f(java.lang.String r21, java.lang.String r22, defpackage.y50 r23) {
        /*
            Method dump skipped, instruction units count: 595
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qq2.f(java.lang.String, java.lang.String, y50):java.lang.Object");
    }
}
