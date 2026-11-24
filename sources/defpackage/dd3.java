package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.locale.LanguageTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dd3 {
    public static final x42 a = new x42("\\d+.*subscribers?", y42.IGNORE_CASE);

    public static ArrayList a(AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList arrayList = new ArrayList();
        hg hgVar = new hg();
        hgVar.addLast(accessibilityNodeInfo);
        while (!hgVar.isEmpty() && arrayList.size() < 600) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) hgVar.removeFirst();
            arrayList.add(accessibilityNodeInfo2);
            int childCount = accessibilityNodeInfo2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo2.getChild(i);
                if (child != null) {
                    hgVar.addLast(child);
                }
            }
        }
        return arrayList;
    }

    public static List b(ArrayList arrayList) {
        String strO;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String viewIdResourceName = ((AccessibilityNodeInfo) obj).getViewIdResourceName();
            if (viewIdResourceName != null) {
                Locale locale = Locale.ROOT;
                strO = cq.o(locale, viewIdResourceName, locale);
            } else {
                strO = null;
            }
            if (strO == null) {
                strO = "";
            }
            if (cs2.n(strO, "mini_player", false) || cs2.n(strO, "miniplayer", false) || cs2.n(strO, "watch_mini_player", false) || cs2.n(strO, "player_overlay", false)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
            if (!arrayList2.isEmpty()) {
                int size3 = arrayList2.size();
                int i3 = 0;
                while (i3 < size3) {
                    Object obj3 = arrayList2.get(i3);
                    i3++;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj3;
                    if (g(accessibilityNodeInfo2, accessibilityNodeInfo) || g(accessibilityNodeInfo, accessibilityNodeInfo2)) {
                        arrayList3.add(obj2);
                        break;
                    }
                }
            }
        }
        return arrayList3;
    }

    /* JADX WARN: Code duplicated, block: B:352:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:360:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:369:0x0517  */
    /* JADX WARN: Code duplicated, block: B:487:0x0531 A[EDGE_INSN: B:487:0x0531->B:379:0x0531 BREAK  A[LOOP:6: B:310:0x044d->B:377:0x052c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x052c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d4  */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x059d, code lost:
    
        if (r8 == null) goto L413;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.iv0 c(defpackage.ed3 r23, java.util.List r24) {
        /*
            Method dump skipped, instruction units count: 1481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd3.c(ed3, java.util.List):iv0");
    }

    public static iv0 d(List list) {
        Object obj;
        Object obj2;
        String strO;
        String strO2;
        String string;
        String strO3;
        String strO4;
        String strO5;
        String string2;
        String string3;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rz.q(a((AccessibilityNodeInfo) it.next()), arrayList);
        }
        ArrayList arrayList2 = (ArrayList) b(arrayList);
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            obj = null;
            if (i >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList2.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            if (viewIdResourceName != null) {
                Locale locale = Locale.ROOT;
                strO3 = cq.o(locale, viewIdResourceName, locale);
            } else {
                strO3 = null;
            }
            if (strO3 == null) {
                strO3 = "";
            }
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription == null || (string3 = contentDescription.toString()) == null) {
                strO4 = null;
            } else {
                Locale locale2 = Locale.ROOT;
                strO4 = cq.o(locale2, string3, locale2);
            }
            if (strO4 == null) {
                strO4 = "";
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null || (string2 = text.toString()) == null) {
                strO5 = null;
            } else {
                Locale locale3 = Locale.ROOT;
                strO5 = cq.o(locale3, string2, locale3);
            }
            if (strO5 == null) {
                strO5 = "";
            }
            boolean z = cs2.n(strO3, "close", false) || cs2.n(strO3, "dismiss", false) || cs2.n(strO4, "close", false) || cs2.n(strO4, "dismiss", false) || cs2.n(strO4, "cancel", false) || strO4.equals("close mini player") || strO4.equals("dismiss mini player") || strO5.equals(LanguageTag.PRIVATEUSE) || strO4.equals(LanguageTag.PRIVATEUSE);
            boolean z2 = cs2.n(strO3, "pause", false) && !cs2.n(strO3, "close", false);
            if (z && !z2 && accessibilityNodeInfo.isVisibleToUser()) {
                break;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
        if (accessibilityNodeInfo2 == null) {
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj3 = arrayList.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                String viewIdResourceName2 = accessibilityNodeInfo3.getViewIdResourceName();
                if (viewIdResourceName2 != null) {
                    Locale locale4 = Locale.ROOT;
                    strO = cq.o(locale4, viewIdResourceName2, locale4);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription2 = accessibilityNodeInfo3.getContentDescription();
                if (contentDescription2 == null || (string = contentDescription2.toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale5 = Locale.ROOT;
                    strO2 = cq.o(locale5, string, locale5);
                }
                if (strO2 == null) {
                    strO2 = "";
                }
                if (cs2.n(strO, "mini_player_close", false) || cs2.n(strO, "close_button", false) || cs2.n(strO2, "close player", false) || cs2.n(strO2, "close miniplayer", false)) {
                    if (accessibilityNodeInfo3.isVisibleToUser()) {
                        obj = obj3;
                        break;
                    }
                }
            }
            accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2 == null) {
                return hv0.a;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo2;
        return new gv0(new jv0(ed3.i, accessibilityNodeInfo4, cq.g(accessibilityNodeInfo4), false, "Closed mini-player."));
    }

    public static iv0 e(List list) {
        Object obj;
        Object obj2;
        String strO;
        String strO2;
        String string;
        String strO3;
        String strO4;
        String strO5;
        String string2;
        String string3;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rz.q(a((AccessibilityNodeInfo) it.next()), arrayList);
        }
        ArrayList arrayList2 = (ArrayList) b(arrayList);
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            obj = null;
            if (i >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList2.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            if (viewIdResourceName != null) {
                Locale locale = Locale.ROOT;
                strO3 = cq.o(locale, viewIdResourceName, locale);
            } else {
                strO3 = null;
            }
            if (strO3 == null) {
                strO3 = "";
            }
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription == null || (string3 = contentDescription.toString()) == null) {
                strO4 = null;
            } else {
                Locale locale2 = Locale.ROOT;
                strO4 = cq.o(locale2, string3, locale2);
            }
            if (strO4 == null) {
                strO4 = "";
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null || (string2 = text.toString()) == null) {
                strO5 = null;
            } else {
                Locale locale3 = Locale.ROOT;
                strO5 = cq.o(locale3, string2, locale3);
            }
            if (strO5 == null) {
                strO5 = "";
            }
            boolean z = true;
            boolean z2 = cs2.n(strO4, "pause", false) || cs2.n(strO4, "रोकें", false) || cs2.n(strO3, "play_pause", false) || cs2.n(strO3, "pause_button", false) || strO5.equals("pause");
            if (!cs2.n(strO3, "close", false) && !cs2.n(strO3, "dismiss", false) && !cs2.n(strO4, "close", false) && !cs2.n(strO4, "dismiss", false)) {
                z = false;
            }
            if (z2 && !z && accessibilityNodeInfo.isVisibleToUser()) {
                break;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
        if (accessibilityNodeInfo2 == null) {
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj3 = arrayList.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                String viewIdResourceName2 = accessibilityNodeInfo3.getViewIdResourceName();
                if (viewIdResourceName2 != null) {
                    Locale locale4 = Locale.ROOT;
                    strO = cq.o(locale4, viewIdResourceName2, locale4);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription2 = accessibilityNodeInfo3.getContentDescription();
                if (contentDescription2 == null || (string = contentDescription2.toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale5 = Locale.ROOT;
                    strO2 = cq.o(locale5, string, locale5);
                }
                if (strO2 == null) {
                    strO2 = "";
                }
                if (cs2.n(strO, "play_pause_button", false) || strO2.equals("pause video") || strO2.equals("pause")) {
                    if (accessibilityNodeInfo3.isVisibleToUser()) {
                        obj = obj3;
                        break;
                    }
                }
            }
            accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2 == null) {
                return hv0.a;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo2;
        return new gv0(new jv0(ed3.e, accessibilityNodeInfo4, cq.g(accessibilityNodeInfo4), false, "Paused video."));
    }

    public static iv0 f(List list) {
        Object obj;
        Object obj2;
        String strO;
        String strO2;
        String string;
        String strO3;
        String strO4;
        String strO5;
        String string2;
        String string3;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rz.q(a((AccessibilityNodeInfo) it.next()), arrayList);
        }
        ArrayList arrayList2 = (ArrayList) b(arrayList);
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            obj = null;
            if (i >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList2.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            if (viewIdResourceName != null) {
                Locale locale = Locale.ROOT;
                strO3 = cq.o(locale, viewIdResourceName, locale);
            } else {
                strO3 = null;
            }
            if (strO3 == null) {
                strO3 = "";
            }
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription == null || (string3 = contentDescription.toString()) == null) {
                strO4 = null;
            } else {
                Locale locale2 = Locale.ROOT;
                strO4 = cq.o(locale2, string3, locale2);
            }
            if (strO4 == null) {
                strO4 = "";
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null || (string2 = text.toString()) == null) {
                strO5 = null;
            } else {
                Locale locale3 = Locale.ROOT;
                strO5 = cq.o(locale3, string2, locale3);
            }
            if (strO5 == null) {
                strO5 = "";
            }
            boolean z = true;
            boolean z2 = cs2.n(strO4, "play", false) || cs2.n(strO4, "चलाएं", false) || cs2.n(strO3, "play_pause", false) || cs2.n(strO3, "play_button", false) || strO5.equals("play");
            if (!cs2.n(strO3, "close", false) && !cs2.n(strO3, "dismiss", false) && !cs2.n(strO4, "close", false)) {
                z = false;
            }
            if (z2 && !z && accessibilityNodeInfo.isVisibleToUser()) {
                break;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
        if (accessibilityNodeInfo2 == null) {
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj3 = arrayList.get(i2);
                i2++;
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                String viewIdResourceName2 = accessibilityNodeInfo3.getViewIdResourceName();
                if (viewIdResourceName2 != null) {
                    Locale locale4 = Locale.ROOT;
                    strO = cq.o(locale4, viewIdResourceName2, locale4);
                } else {
                    strO = null;
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription2 = accessibilityNodeInfo3.getContentDescription();
                if (contentDescription2 == null || (string = contentDescription2.toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale5 = Locale.ROOT;
                    strO2 = cq.o(locale5, string, locale5);
                }
                if (strO2 == null) {
                    strO2 = "";
                }
                if (cs2.n(strO, "play_pause_button", false) || strO2.equals("play video") || strO2.equals("play")) {
                    if (accessibilityNodeInfo3.isVisibleToUser()) {
                        obj = obj3;
                        break;
                    }
                }
            }
            accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2 == null) {
                return hv0.a;
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo2;
        return new gv0(new jv0(ed3.f, accessibilityNodeInfo4, cq.g(accessibilityNodeInfo4), false, "Resumed video."));
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        if (g31.a(accessibilityNodeInfo, accessibilityNodeInfo2)) {
            return true;
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        int i = 0;
        while (i < 6 && parent != null) {
            if (parent.equals(accessibilityNodeInfo2)) {
                parent.recycle();
                return true;
            }
            AccessibilityNodeInfo parent2 = parent.getParent();
            parent.recycle();
            i++;
            parent = parent2;
        }
        return false;
    }
}
