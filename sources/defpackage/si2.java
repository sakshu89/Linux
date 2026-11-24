package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class si2 {
    public static final Set d = wh2.c("switch_widget", "switch", "main_switch", "switch_bar_switch", "switchbar_switch");
    public static final Set e = wh2.c("switch_bar", "switchbar", "main_switch_bar", "main_switch_container", "settingslib_main_switch_bar");
    public static final Set f = wh2.c("content", "list", "recycler_view", "recycler", "settings_main_prefs");
    public static final Set g = wh2.c("on", "off", "switch", "on switch", "off switch");
    public static final Set h = wh2.c("scanning", "scan always", "automatically", "wakeup", "hotspot", "tether", "calling", "notification", "auto connect");
    public final Context a;
    public final r2 b;
    public final an1 c;

    public si2(r2 r2Var, Context context) {
        r2Var.getClass();
        this.a = context;
        this.b = r2Var;
        this.c = new an1();
    }

    public static ArrayList a(oi2 oi2Var) {
        oi2 oi2Var2;
        ArrayList arrayList = new ArrayList();
        oi2 oi2Var3 = oi2Var.b;
        int i = 0;
        while (i < 3 && oi2Var3 != null && (oi2Var2 = oi2Var3.b) != null) {
            if (f.contains(o(oi2Var3.a))) {
                break;
            }
            arrayList.add(oi2Var3);
            i++;
            oi2Var3 = oi2Var2;
        }
        return arrayList;
    }

    public static ArrayList c(AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        ArrayDeque<oi2> arrayDeque = new ArrayDeque();
        arrayDeque.add(new oi2(accessibilityNodeInfo, null));
        while (!arrayDeque.isEmpty() && arrayList2.size() < 600) {
            oi2 oi2Var = (oi2) arrayDeque.removeFirst();
            arrayList2.add(oi2Var);
            AccessibilityNodeInfo accessibilityNodeInfo2 = oi2Var.a;
            if (!accessibilityNodeInfo2.isPassword()) {
                int childCount = accessibilityNodeInfo2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo2.getChild(i);
                    if (child != null) {
                        oi2 oi2Var2 = new oi2(child, oi2Var);
                        oi2Var.c.add(oi2Var2);
                        arrayDeque.add(oi2Var2);
                    }
                }
            }
        }
        for (oi2 oi2Var3 : arrayDeque) {
            oi2 oi2Var4 = oi2Var3.b;
            if (oi2Var4 != null && (arrayList = oi2Var4.c) != null) {
                arrayList.remove(oi2Var3);
            }
            oi2Var3.a.recycle();
        }
        return arrayList2;
    }

    public static ArrayList e(oi2 oi2Var) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(oi2Var);
        while (!arrayDeque.isEmpty() && arrayList.size() < 80) {
            oi2 oi2Var2 = (oi2) arrayDeque.removeFirst();
            AccessibilityNodeInfo accessibilityNodeInfo = oi2Var2.a;
            if (accessibilityNodeInfo.isVisibleToUser() && !accessibilityNodeInfo.isPassword()) {
                arrayList.add(oi2Var2);
            }
            if (!accessibilityNodeInfo.isPassword()) {
                arrayDeque.addAll(oi2Var2.c);
            }
        }
        return arrayList;
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<CharSequence> listI = nz.i(accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription());
        if (!listI.isEmpty()) {
            for (CharSequence charSequence : listI) {
                String string = charSequence != null ? charSequence.toString() : null;
                if (string == null) {
                    string = "";
                }
                if (j(m(string), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        return wh2.c(ky0.j(str, "_switch"), cq.j("switch_", str), ky0.j(str, "_toggle"), cq.j("toggle_", str), cq.j("use_", str)).contains(js2.i(o(accessibilityNodeInfo), "wi_fi", "wifi"));
    }

    public static boolean i(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strM = m(mz.C(nz.i(accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription(), o(accessibilityNodeInfo)), Padder.FALLBACK_PADDING_STRING, null, null, null, 62));
        Set set = h;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (cs2.n(strM, (String) it.next(), false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(String str, String str2) {
        Pattern patternCompile = Pattern.compile("(?: (?:on|off|switch))+$");
        patternCompile.getClass();
        str.getClass();
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        Set<String> setC = g31.a(str2, "wifi") ? wh2.c("wifi", "wi fi", "wlan", "वाईफाई", "वाई फाई", "वायफाय") : wh2.c("bluetooth", "blue tooth", "ब्लूटूथ");
        if ((setC instanceof Collection) && setC.isEmpty()) {
            return false;
        }
        for (String str3 : setC) {
            if (strReplaceAll.equals(str3)) {
                return true;
            }
            if (strReplaceAll.equals("use " + str3)) {
                return true;
            }
            if (strReplaceAll.equals("turn on " + str3)) {
                return true;
            }
            if (strReplaceAll.equals("turn off " + str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(String str, String str2) {
        if (str2 == null || cs2.A(str2)) {
            return str.equals("com.android.settings") || str.equals("com.google.android.settings") || str.equals("com.samsung.android.settings");
        }
        return str.equals(str2);
    }

    public static boolean l(p22 p22Var, boolean z) {
        return p22Var == (z ? p22.a : p22.b);
    }

    public static String m(String str) {
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        Pattern patternCompile = Pattern.compile("[\\p{Pd}_,:]+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("\\s+");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll2.getClass();
        return cs2.V(strReplaceAll2).toString();
    }

    /* JADX WARN: Code duplicated, block: B:124:0x021c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0228  */
    /* JADX WARN: Code duplicated, block: B:129:0x0230  */
    /* JADX WARN: Code duplicated, block: B:131:0x0246  */
    /* JADX WARN: Code duplicated, block: B:133:0x024a  */
    /* JADX WARN: Code duplicated, block: B:136:0x024f  */
    /* JADX WARN: Code duplicated, block: B:138:0x0253  */
    /* JADX WARN: Code duplicated, block: B:139:0x0258  */
    /* JADX WARN: Code duplicated, block: B:143:0x0263  */
    /* JADX WARN: Code duplicated, block: B:146:0x026d  */
    /* JADX WARN: Code duplicated, block: B:149:0x027d  */
    /* JADX WARN: Code duplicated, block: B:152:0x0284  */
    /* JADX WARN: Code duplicated, block: B:155:0x028e  */
    /* JADX WARN: Code duplicated, block: B:161:0x02be  */
    /* JADX WARN: Code duplicated, block: B:163:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:164:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:166:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:220:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:? A[LOOP:11: B:128:0x022e->B:221:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x02ef A[EDGE_INSN: B:223:0x02ef->B:176:0x02ef BREAK  A[LOOP:9: B:111:0x01d7->B:175:0x02eb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:? A[LOOP:12: B:144:0x0267->B:224:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x02b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x02db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x02b8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static oi2 n(String str, ArrayList arrayList) {
        Set set;
        oi2 oi2Var;
        oi2 oi2Var2;
        Collection<oi2> collectionH;
        List<CharSequence> listI;
        String string;
        String strM;
        Iterator it;
        ArrayList arrayListA;
        int size;
        int i;
        Object obj;
        ArrayList arrayList2;
        int i2;
        ArrayList arrayList3;
        int i3;
        CharSequence className;
        String string2;
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            set = d;
            if (i5 >= size2) {
                break;
            }
            Object obj2 = arrayList.get(i5);
            i5++;
            AccessibilityNodeInfo accessibilityNodeInfo = ((oi2) obj2).a;
            if (accessibilityNodeInfo.isCheckable() || (accessibilityNodeInfo.getChildCount() == 0 && (((className = accessibilityNodeInfo.getClassName()) != null && (string2 = className.toString()) != null && (cs2.n(string2, "Switch", false) || cs2.n(string2, "ToggleButton", false))) || set.contains(o(accessibilityNodeInfo)) || h(accessibilityNodeInfo, "wifi") || h(accessibilityNodeInfo, "bluetooth")))) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        int size3 = arrayList4.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj3 = arrayList4.get(i6);
            i6++;
            oi2 oi2Var3 = (oi2) obj3;
            if (arrayList4.isEmpty()) {
                i3 = i4;
                arrayList5.add(obj3);
            } else {
                int size4 = arrayList4.size();
                int i7 = i4;
                while (true) {
                    if (i7 < size4) {
                        Object obj4 = arrayList4.get(i7);
                        i7++;
                        oi2 oi2Var4 = (oi2) obj4;
                        if (oi2Var4 != oi2Var3) {
                            i3 = i4;
                            Iterator it2 = zg2.c(oi2Var4.b, new sa2(27)).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    continue;
                                } else if (((oi2) it2.next()) == oi2Var3) {
                                }
                            }
                        } else {
                            i3 = i4;
                        }
                        i4 = i3;
                    } else {
                        i3 = i4;
                        arrayList5.add(obj3);
                    }
                }
            }
            i4 = i3;
        }
        int i8 = i4;
        String str2 = g31.a(str, "wifi") ? "bluetooth" : "wifi";
        ArrayList arrayList6 = new ArrayList();
        int size5 = arrayList5.size();
        int i9 = i8;
        while (i9 < size5) {
            Object obj5 = arrayList5.get(i9);
            i9++;
            oi2 oi2Var5 = (oi2) obj5;
            AccessibilityNodeInfo accessibilityNodeInfo2 = oi2Var5.a;
            if (i(accessibilityNodeInfo2)) {
                arrayList2 = arrayList5;
            } else {
                if (!g(accessibilityNodeInfo2, str) && !h(accessibilityNodeInfo2, str)) {
                    ArrayList arrayListA2 = a(oi2Var5);
                    if (!arrayListA2.isEmpty()) {
                        int size6 = arrayListA2.size();
                        int i10 = i8;
                        while (true) {
                            if (i10 < size6) {
                                Object obj6 = arrayListA2.get(i10);
                                i10++;
                                ArrayList arrayListE = e((oi2) obj6);
                                if (arrayListE.isEmpty()) {
                                    i2 = i8;
                                } else {
                                    int size7 = arrayListE.size();
                                    int i11 = i8;
                                    int i12 = i11;
                                    while (i11 < size7) {
                                        Object obj7 = arrayListE.get(i11);
                                        i11++;
                                        if (arrayList5.contains((oi2) obj7) && (i12 = i12 + 1) < 0) {
                                            nz.m();
                                            throw null;
                                        }
                                    }
                                    i2 = i12;
                                }
                                if (i2 != 1 || arrayListE.isEmpty()) {
                                    arrayList3 = arrayList5;
                                } else {
                                    int size8 = arrayListE.size();
                                    int i13 = i8;
                                    while (true) {
                                        if (i13 < size8) {
                                            Object obj8 = arrayListE.get(i13);
                                            i13++;
                                            if (g(((oi2) obj8).a, str)) {
                                                if (!arrayListE.isEmpty()) {
                                                    int size9 = arrayListE.size();
                                                    int i14 = i8;
                                                    while (true) {
                                                        if (i14 < size9) {
                                                            Object obj9 = arrayListE.get(i14);
                                                            i14++;
                                                            oi2 oi2Var6 = (oi2) obj9;
                                                            arrayList3 = arrayList5;
                                                            if (!g(oi2Var6.a, str2) && !i(oi2Var6.a)) {
                                                                arrayList5 = arrayList3;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            arrayList3 = arrayList5;
                                        }
                                    }
                                }
                                arrayList5 = arrayList3;
                            }
                        }
                    }
                    arrayList2 = arrayList5;
                }
                arrayList2 = arrayList5;
                arrayList6.add(obj5);
            }
            arrayList5 = arrayList2;
        }
        ArrayList arrayList7 = arrayList5;
        if (arrayList6.size() == 1) {
            return (oi2) mz.H(arrayList6);
        }
        if (arrayList6.isEmpty() && arrayList7.size() == 1 && !arrayList.isEmpty()) {
            int size10 = arrayList.size();
            int i15 = i8;
            while (i15 < size10) {
                Object obj10 = arrayList.get(i15);
                i15++;
                if (g(((oi2) obj10).a, str)) {
                    if (arrayList.isEmpty()) {
                        oi2Var = (oi2) mz.H(arrayList7);
                        if (set.contains(o(oi2Var.a))) {
                            arrayListA = a(oi2Var);
                            if (arrayListA.isEmpty()) {
                                size = arrayListA.size();
                                i = i8;
                                while (i < size) {
                                    obj = arrayListA.get(i);
                                    i++;
                                    if (e.contains(o(((oi2) obj).a))) {
                                        oi2Var2 = oi2Var.b;
                                        if (oi2Var2 == null) {
                                            collectionH = nz.h(oi2Var);
                                        } else {
                                            if (oi2Var2.b == null) {
                                                oi2Var2 = null;
                                            }
                                            if (oi2Var2 != null) {
                                                collectionH = e(oi2Var2);
                                            } else {
                                                collectionH = nz.h(oi2Var);
                                            }
                                        }
                                        if (collectionH.isEmpty()) {
                                            if (!collectionH.isEmpty()) {
                                                for (oi2 oi2Var7 : collectionH) {
                                                    CharSequence text = oi2Var7.a.getText();
                                                    CharSequence contentDescription = oi2Var7.a.getContentDescription();
                                                    CharSequence[] charSequenceArr = new CharSequence[2];
                                                    charSequenceArr[i8] = text;
                                                    charSequenceArr[1] = contentDescription;
                                                    listI = nz.i(charSequenceArr);
                                                    if (listI.isEmpty()) {
                                                        for (CharSequence charSequence : listI) {
                                                            if (charSequence != null) {
                                                                string = charSequence.toString();
                                                            } else {
                                                                string = null;
                                                            }
                                                            if (string == null) {
                                                                string = "";
                                                            }
                                                            strM = m(string);
                                                            if (cs2.A(strM) && !g.contains(strM) && !j(strM, str)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            return oi2Var;
                                        }
                                        it = collectionH.iterator();
                                        while (it.hasNext()) {
                                            if (i(((oi2) it.next()).a)) {
                                                break;
                                            }
                                        }
                                        if (!collectionH.isEmpty()) {
                                            while (r2.hasNext()) {
                                                CharSequence text2 = oi2Var7.a.getText();
                                                CharSequence contentDescription2 = oi2Var7.a.getContentDescription();
                                                CharSequence[] charSequenceArr2 = new CharSequence[2];
                                                charSequenceArr2[i8] = text2;
                                                charSequenceArr2[1] = contentDescription2;
                                                listI = nz.i(charSequenceArr2);
                                                if (listI.isEmpty()) {
                                                    while (r3.hasNext()) {
                                                        if (charSequence != null) {
                                                            string = charSequence.toString();
                                                        } else {
                                                            string = null;
                                                        }
                                                        if (string == null) {
                                                            string = "";
                                                        }
                                                        strM = m(string);
                                                        if (cs2.A(strM)) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        return oi2Var;
                                    }
                                }
                                break;
                            }
                            break;
                        }
                        oi2Var2 = oi2Var.b;
                        if (oi2Var2 == null) {
                            collectionH = nz.h(oi2Var);
                        } else {
                            if (oi2Var2.b == null) {
                                oi2Var2 = null;
                            }
                            if (oi2Var2 != null) {
                                collectionH = e(oi2Var2);
                            } else {
                                collectionH = nz.h(oi2Var);
                            }
                        }
                        if (collectionH.isEmpty()) {
                            if (!collectionH.isEmpty()) {
                                while (r2.hasNext()) {
                                    CharSequence text3 = oi2Var7.a.getText();
                                    CharSequence contentDescription3 = oi2Var7.a.getContentDescription();
                                    CharSequence[] charSequenceArr3 = new CharSequence[2];
                                    charSequenceArr3[i8] = text3;
                                    charSequenceArr3[1] = contentDescription3;
                                    listI = nz.i(charSequenceArr3);
                                    if (listI.isEmpty()) {
                                        while (r3.hasNext()) {
                                            if (charSequence != null) {
                                                string = charSequence.toString();
                                            } else {
                                                string = null;
                                            }
                                            if (string == null) {
                                                string = "";
                                            }
                                            strM = m(string);
                                            if (cs2.A(strM)) {
                                            }
                                        }
                                    }
                                }
                            }
                            return oi2Var;
                        }
                        it = collectionH.iterator();
                        while (it.hasNext()) {
                            if (i(((oi2) it.next()).a)) {
                                break;
                                break;
                            }
                        }
                        if (!collectionH.isEmpty()) {
                            while (r2.hasNext()) {
                                CharSequence text4 = oi2Var7.a.getText();
                                CharSequence contentDescription4 = oi2Var7.a.getContentDescription();
                                CharSequence[] charSequenceArr4 = new CharSequence[2];
                                charSequenceArr4[i8] = text4;
                                charSequenceArr4[1] = contentDescription4;
                                listI = nz.i(charSequenceArr4);
                                if (listI.isEmpty()) {
                                    while (r3.hasNext()) {
                                        if (charSequence != null) {
                                            string = charSequence.toString();
                                        } else {
                                            string = null;
                                        }
                                        if (string == null) {
                                            string = "";
                                        }
                                        strM = m(string);
                                        if (cs2.A(strM)) {
                                        }
                                    }
                                }
                            }
                        }
                        return oi2Var;
                    }
                    int size11 = arrayList.size();
                    int i16 = i8;
                    while (i16 < size11) {
                        Object obj11 = arrayList.get(i16);
                        i16++;
                        if (g(((oi2) obj11).a, str2)) {
                            break;
                        }
                    }
                    oi2Var = (oi2) mz.H(arrayList7);
                    if (set.contains(o(oi2Var.a))) {
                        oi2Var2 = oi2Var.b;
                        if (oi2Var2 == null) {
                            collectionH = nz.h(oi2Var);
                        } else {
                            if (oi2Var2.b == null) {
                                oi2Var2 = null;
                            }
                            if (oi2Var2 != null) {
                                collectionH = e(oi2Var2);
                            } else {
                                collectionH = nz.h(oi2Var);
                            }
                        }
                        if (collectionH.isEmpty()) {
                            if (!collectionH.isEmpty()) {
                                while (r2.hasNext()) {
                                    CharSequence text5 = oi2Var7.a.getText();
                                    CharSequence contentDescription5 = oi2Var7.a.getContentDescription();
                                    CharSequence[] charSequenceArr5 = new CharSequence[2];
                                    charSequenceArr5[i8] = text5;
                                    charSequenceArr5[1] = contentDescription5;
                                    listI = nz.i(charSequenceArr5);
                                    if (listI.isEmpty()) {
                                        while (r3.hasNext()) {
                                            if (charSequence != null) {
                                                string = charSequence.toString();
                                            } else {
                                                string = null;
                                            }
                                            if (string == null) {
                                                string = "";
                                            }
                                            strM = m(string);
                                            if (cs2.A(strM)) {
                                            }
                                        }
                                    }
                                }
                            }
                            return oi2Var;
                        }
                        it = collectionH.iterator();
                        while (it.hasNext()) {
                            if (i(((oi2) it.next()).a)) {
                                break;
                                break;
                            }
                        }
                        if (!collectionH.isEmpty()) {
                            while (r2.hasNext()) {
                                CharSequence text6 = oi2Var7.a.getText();
                                CharSequence contentDescription6 = oi2Var7.a.getContentDescription();
                                CharSequence[] charSequenceArr6 = new CharSequence[2];
                                charSequenceArr6[i8] = text6;
                                charSequenceArr6[1] = contentDescription6;
                                listI = nz.i(charSequenceArr6);
                                if (listI.isEmpty()) {
                                    while (r3.hasNext()) {
                                        if (charSequence != null) {
                                            string = charSequence.toString();
                                        } else {
                                            string = null;
                                        }
                                        if (string == null) {
                                            string = "";
                                        }
                                        strM = m(string);
                                        if (cs2.A(strM)) {
                                        }
                                    }
                                }
                            }
                        }
                        return oi2Var;
                    }
                    arrayListA = a(oi2Var);
                    if (arrayListA.isEmpty()) {
                        break;
                    }
                    size = arrayListA.size();
                    i = i8;
                    while (i < size) {
                        obj = arrayListA.get(i);
                        i++;
                        if (e.contains(o(((oi2) obj).a))) {
                            oi2Var2 = oi2Var.b;
                            if (oi2Var2 == null) {
                                collectionH = nz.h(oi2Var);
                            } else {
                                if (oi2Var2.b == null) {
                                    oi2Var2 = null;
                                }
                                if (oi2Var2 != null) {
                                    collectionH = e(oi2Var2);
                                } else {
                                    collectionH = nz.h(oi2Var);
                                }
                            }
                            if (collectionH.isEmpty()) {
                                if (!collectionH.isEmpty()) {
                                    while (r2.hasNext()) {
                                        CharSequence text7 = oi2Var7.a.getText();
                                        CharSequence contentDescription7 = oi2Var7.a.getContentDescription();
                                        CharSequence[] charSequenceArr7 = new CharSequence[2];
                                        charSequenceArr7[i8] = text7;
                                        charSequenceArr7[1] = contentDescription7;
                                        listI = nz.i(charSequenceArr7);
                                        if (listI.isEmpty()) {
                                            while (r3.hasNext()) {
                                                if (charSequence != null) {
                                                    string = charSequence.toString();
                                                } else {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    string = "";
                                                }
                                                strM = m(string);
                                                if (cs2.A(strM)) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return oi2Var;
                            }
                            it = collectionH.iterator();
                            while (it.hasNext()) {
                                if (i(((oi2) it.next()).a)) {
                                    break;
                                    break;
                                }
                            }
                            if (!collectionH.isEmpty()) {
                                while (r2.hasNext()) {
                                    CharSequence text8 = oi2Var7.a.getText();
                                    CharSequence contentDescription8 = oi2Var7.a.getContentDescription();
                                    CharSequence[] charSequenceArr8 = new CharSequence[2];
                                    charSequenceArr8[i8] = text8;
                                    charSequenceArr8[1] = contentDescription8;
                                    listI = nz.i(charSequenceArr8);
                                    if (listI.isEmpty()) {
                                        while (r3.hasNext()) {
                                            if (charSequence != null) {
                                                string = charSequence.toString();
                                            } else {
                                                string = null;
                                            }
                                            if (string == null) {
                                                string = "";
                                            }
                                            strM = m(string);
                                            if (cs2.A(strM)) {
                                            }
                                        }
                                    }
                                }
                            }
                            return oi2Var;
                        }
                    }
                    break;
                    break;
                }
            }
        }
        return null;
    }

    public static String o(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    public static fj2 p(String str, p22 p22Var) {
        int iOrdinal = p22Var.ordinal();
        if (iOrdinal != 5) {
            if (iOrdinal != 6) {
                return null;
            }
            return yi2.a;
        }
        if (str.equals("bluetooth")) {
            return null;
        }
        return new xi2();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0079  */
    /* JADX WARN: Code duplicated, block: B:23:0x0083 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0084  */
    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    /* JADX WARN: Code duplicated, block: B:69:0x0133  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:87:0x017f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x01a1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x01a1 -> B:92:0x01a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(java.lang.String r18, boolean r19, java.lang.String r20, defpackage.y50 r21) {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.si2.b(java.lang.String, boolean, java.lang.String, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(y50 y50Var) {
        qi2 qi2Var;
        if (y50Var instanceof qi2) {
            qi2Var = (qi2) y50Var;
            int i = qi2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                qi2Var.i = i - Integer.MIN_VALUE;
            } else {
                qi2Var = new qi2(this, y50Var);
            }
        } else {
            qi2Var = new qi2(this, y50Var);
        }
        Object objE = qi2Var.e;
        int i2 = qi2Var.i;
        r2 r2Var = this.b;
        if (i2 == 0) {
            bz3.g(objE);
            if (!r2Var.j()) {
                if (dc4.b(r2Var.a)) {
                    qi2Var.i = 1;
                    objE = r2Var.e(2000L, qi2Var);
                    t70 t70Var = t70.a;
                    if (objE == t70Var) {
                        return t70Var;
                    }
                }
                return ui2.a;
            }
            return null;
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(objE);
        if (!((Boolean) objE).booleanValue()) {
            if (dc4.b(r2Var.a)) {
                return ti2.a;
            }
            return ui2.a;
        }
        return null;
    }

    public final p22 f(String str) {
        Integer numValueOf;
        str.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        boolean zEquals = strO.equals("wifi");
        p22 p22Var = p22.i;
        p22 p22Var2 = p22.e;
        p22 p22Var3 = p22.c;
        p22 p22Var4 = p22.b;
        p22 p22Var5 = p22.a;
        p22 p22Var6 = p22.j;
        p22 p22Var7 = p22.f;
        try {
            if (zEquals) {
                Object systemService = this.a.getSystemService("wifi");
                WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
                numValueOf = wifiManager != null ? Integer.valueOf(wifiManager.getWifiState()) : null;
                if (numValueOf != null) {
                    if (numValueOf.intValue() != 3) {
                        if (numValueOf.intValue() != 1) {
                            if (numValueOf.intValue() != 2) {
                                if (numValueOf.intValue() == 0) {
                                    return p22Var2;
                                }
                                return p22Var7;
                            }
                            return p22Var3;
                        }
                        return p22Var4;
                    }
                    return p22Var5;
                }
                return p22Var6;
            }
            if (!strO.equals("bluetooth")) {
                return p22Var6;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            numValueOf = defaultAdapter != null ? Integer.valueOf(defaultAdapter.getState()) : null;
            if (numValueOf == null) {
                return p22Var6;
            }
            if (numValueOf.intValue() == 12) {
                return p22Var5;
            }
            if (numValueOf.intValue() == 10) {
                return p22Var4;
            }
            if (numValueOf.intValue() == 11) {
                return p22Var3;
            }
            if (numValueOf.intValue() == 13) {
                return p22Var2;
            }
            return p22Var7;
        } catch (SecurityException unused) {
            return p22Var;
        } catch (Exception unused2) {
            p22Var = p22Var7;
            return p22Var;
        }
    }

    /* JADX WARN: Code duplicated, block: B:144:0x02dc A[Catch: all -> 0x0248, TryCatch #4 {all -> 0x0248, blocks: (B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:302:0x023d, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0315 A[Catch: all -> 0x0248, TryCatch #4 {all -> 0x0248, blocks: (B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:302:0x023d, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0318 A[Catch: all -> 0x0248, TRY_LEAVE, TryCatch #4 {all -> 0x0248, blocks: (B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:302:0x023d, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0324 A[Catch: all -> 0x0127, LOOP:2: B:161:0x0322->B:162:0x0324, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x0127, blocks: (B:92:0x0209, B:95:0x020f, B:103:0x0229, B:107:0x0237, B:123:0x026a, B:125:0x0271, B:160:0x031d, B:162:0x0324, B:186:0x037d, B:188:0x0384, B:189:0x0392, B:191:0x0399, B:196:0x03b4, B:198:0x03bb, B:205:0x03d8, B:207:0x03df, B:219:0x0414, B:221:0x041b, B:225:0x042f, B:227:0x0436, B:249:0x04ae, B:251:0x04b5, B:253:0x04c5, B:264:0x0504, B:266:0x050b, B:268:0x0522, B:270:0x0529, B:272:0x053b, B:274:0x0542, B:275:0x0550, B:57:0x0154, B:60:0x015a, B:63:0x0161, B:43:0x0104, B:45:0x011a, B:50:0x0129, B:53:0x0131, B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:301:0x0104, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x03d2 A[Catch: all -> 0x0248, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0248, blocks: (B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:302:0x023d, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0529 A[Catch: all -> 0x0127, LOOP:14: B:269:0x0527->B:270:0x0529, LOOP_END, TryCatch #3 {all -> 0x0127, blocks: (B:92:0x0209, B:95:0x020f, B:103:0x0229, B:107:0x0237, B:123:0x026a, B:125:0x0271, B:160:0x031d, B:162:0x0324, B:186:0x037d, B:188:0x0384, B:189:0x0392, B:191:0x0399, B:196:0x03b4, B:198:0x03bb, B:205:0x03d8, B:207:0x03df, B:219:0x0414, B:221:0x041b, B:225:0x042f, B:227:0x0436, B:249:0x04ae, B:251:0x04b5, B:253:0x04c5, B:264:0x0504, B:266:0x050b, B:268:0x0522, B:270:0x0529, B:272:0x053b, B:274:0x0542, B:275:0x0550, B:57:0x0154, B:60:0x015a, B:63:0x0161, B:43:0x0104, B:45:0x011a, B:50:0x0129, B:53:0x0131, B:108:0x023d, B:110:0x0243, B:116:0x0251, B:119:0x025d, B:122:0x0265, B:128:0x028b, B:130:0x029b, B:132:0x02b2, B:134:0x02ba, B:136:0x02c4, B:139:0x02ce, B:147:0x02ed, B:156:0x030f, B:158:0x0315, B:159:0x0318, B:150:0x02f4, B:152:0x02fb, B:142:0x02d5, B:144:0x02dc, B:165:0x033b, B:167:0x0343, B:172:0x034e, B:174:0x0358, B:176:0x035e, B:181:0x0367, B:183:0x0371, B:185:0x0376, B:202:0x03d2, B:209:0x03ed, B:211:0x03f3, B:213:0x03f9, B:216:0x0405, B:218:0x040f, B:223:0x0429, B:233:0x0454, B:235:0x0467, B:237:0x0477, B:239:0x047d, B:241:0x0483, B:246:0x0490), top: B:301:0x0104, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:320:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:? A[LOOP:4: B:143:0x02da->B:322:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x01ff -> B:92:0x0209). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object q(java.lang.String r27, boolean r28, java.lang.String r29, defpackage.y50 r30) {
        /*
            Method dump skipped, instruction units count: 1420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.si2.q(java.lang.String, boolean, java.lang.String, y50):java.lang.Object");
    }
}
