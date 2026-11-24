package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xc2 {
    public static final Set a = wh2.c("conversations_row_contact_name", "contact_name", "conversation_contact_name");

    public static AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, IdentityHashMap identityHashMap) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        Object obj = accessibilityNodeInfo;
        for (int i = 0; i < 5 && (accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj) != null; i++) {
            CharSequence className = accessibilityNodeInfo2.getClassName();
            String string = className != null ? className.toString() : null;
            if (string == null) {
                string = "";
            }
            if (accessibilityNodeInfo2.isScrollable() || cs2.n(string, "RecyclerView", false) || cs2.n(string, "ListView", false) || cs2.n(string, "ScrollView", false) || cs2.n(string, "ViewPager", false) || (accessibilityNodeInfo2 != accessibilityNodeInfo && identityHashMap.get(accessibilityNodeInfo2) == null)) {
                break;
            }
            if (accessibilityNodeInfo2.isClickable() && accessibilityNodeInfo2.isEnabled() && accessibilityNodeInfo2.isVisibleToUser()) {
                return accessibilityNodeInfo2;
            }
            obj = identityHashMap.get(accessibilityNodeInfo2);
        }
        return null;
    }

    public static void b(ew2 ew2Var, List list) {
        list.getClass();
        for (AccessibilityNodeInfo accessibilityNodeInfo : l(ew2Var)) {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (((AccessibilityNodeInfo) it.next()) != accessibilityNodeInfo);
            }
            accessibilityNodeInfo.recycle();
        }
    }

    public static ew2 c(String str, List list, List list2, boolean z, Bitmap bitmap) {
        int i;
        fw2 fw2Var;
        ew2 ew2VarR;
        ew2 ew2VarA;
        ew2 ew2VarJ;
        String string = cs2.V(str).toString();
        boolean zA = cs2.A(string);
        dw2 dw2Var = dw2.a;
        if (!zA && !list.isEmpty()) {
            if (ie2.f(string)) {
                String strL = ie2.l(string);
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) it.next();
                        x42 x42Var = ie2.a;
                        CharSequence packageName = accessibilityNodeInfo.getPackageName();
                        if (ie2.j(strL, packageName != null ? packageName.toString() : null)) {
                        }
                    }
                }
            }
            IdentityHashMap identityHashMap = new IdentityHashMap();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (true) {
                i = 0;
                if (!it2.hasNext()) {
                    break;
                }
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) it2.next();
                ArrayList arrayList2 = new ArrayList();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(accessibilityNodeInfo2);
                int i2 = 0;
                while (!arrayDeque.isEmpty()) {
                    int i3 = i2 + 1;
                    if (i2 >= 600) {
                        break;
                    }
                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) arrayDeque.removeFirst();
                    accessibilityNodeInfo3.getClass();
                    arrayList2.add(accessibilityNodeInfo3);
                    if (!accessibilityNodeInfo3.isPassword()) {
                        int childCount = accessibilityNodeInfo3.getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            AccessibilityNodeInfo child = accessibilityNodeInfo3.getChild(i4);
                            if (child != null) {
                                identityHashMap.put(child, accessibilityNodeInfo3);
                                arrayDeque.add(child);
                            }
                        }
                    }
                    i2 = i3;
                }
                Iterator it3 = arrayDeque.iterator();
                while (it3.hasNext()) {
                    ((AccessibilityNodeInfo) it3.next()).recycle();
                }
                rz.q(arrayList2, arrayList);
            }
            Locale locale = Locale.ROOT;
            String strO = cq.o(locale, string, locale);
            boolean zM = yc3.m(strO);
            fw2 fw2Var2 = fw2.j;
            if (zM) {
                fw2Var = fw2.c;
            } else if (strO.equals("communities") || strO.equals("communities tab")) {
                fw2Var = fw2.b;
            } else if (ie2.f(strO)) {
                fw2Var = fw2.a;
            } else if (cs2.n(strO, "mini player", false) || cs2.n(strO, "miniplayer", false)) {
                fw2Var = fw2.e;
            } else if (strO.equals("cancel button") || strO.equals("cancel")) {
                fw2Var = fw2.f;
            } else {
                fw2Var = g24.a(strO) ? fw2.i : fw2Var2;
            }
            String str2 = "";
            if (z || fw2Var != fw2Var2) {
                ew2VarR = null;
            } else {
                try {
                    Set set = bc2.a;
                    CharSequence packageName2 = ((AccessibilityNodeInfo) mz.x(list)).getPackageName();
                    String string2 = packageName2 != null ? packageName2.toString() : null;
                    if (string2 == null) {
                        string2 = "";
                    }
                    ew2VarR = bc2.r(string, arrayList, identityHashMap, string2);
                } catch (Throwable th) {
                    List listL = l(dw2Var);
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj;
                        if (!list.isEmpty()) {
                            Iterator it4 = list.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    if (((AccessibilityNodeInfo) it4.next()) == accessibilityNodeInfo4) {
                                    }
                                }
                            }
                        }
                        if (!listL.isEmpty()) {
                            Iterator it5 = listL.iterator();
                            do {
                                if (it5.hasNext()) {
                                }
                            } while (((AccessibilityNodeInfo) it5.next()) != accessibilityNodeInfo4);
                        }
                        accessibilityNodeInfo4.recycle();
                    }
                    throw th;
                }
            }
            if (ew2VarR == null) {
                switch (fw2Var.ordinal()) {
                    case 0:
                        ew2VarJ = j(arrayList, list2, string, identityHashMap, z);
                        break;
                    case 1:
                        ew2VarJ = g(arrayList);
                        break;
                    case 2:
                        CharSequence packageName3 = ((AccessibilityNodeInfo) mz.x(list)).getPackageName();
                        String string3 = packageName3 != null ? packageName3.toString() : null;
                        if (string3 == null) {
                            string3 = "";
                        }
                        ew2VarJ = yc3.r(arrayList, identityHashMap, list2, string3, bitmap);
                        break;
                    case 3:
                        ew2VarJ = i(arrayList);
                        break;
                    case 4:
                        ew2VarJ = e(string, arrayList);
                        break;
                    case 5:
                        ew2VarJ = d(arrayList);
                        break;
                    case 6:
                        ew2VarJ = f(arrayList, (AccessibilityNodeInfo) mz.x(list));
                        break;
                    case 7:
                        ew2VarJ = h(arrayList, list2, string, identityHashMap);
                        break;
                    default:
                        throw new b10();
                }
                ew2VarA = ew2VarJ;
            } else {
                ew2VarA = ew2VarR;
            }
            if ((ew2VarA instanceof dw2) && !list2.isEmpty()) {
                List list3 = dc2.e;
                if (yz3.b(string) != null) {
                    Set set2 = vb2.a;
                    CharSequence packageName4 = ((AccessibilityNodeInfo) mz.x(list)).getPackageName();
                    String string4 = packageName4 != null ? packageName4.toString() : null;
                    if (string4 != null) {
                        str2 = string4;
                    }
                    ew2VarA = vb2.a(string, arrayList, identityHashMap, str2, list2);
                }
            }
            List listL2 = l(ew2VarA);
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj2;
                if (!list.isEmpty()) {
                    Iterator it6 = list.iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            if (((AccessibilityNodeInfo) it6.next()) == accessibilityNodeInfo5) {
                            }
                        }
                    }
                }
                if (!listL2.isEmpty()) {
                    Iterator it7 = listL2.iterator();
                    do {
                        if (it7.hasNext()) {
                        }
                    } while (((AccessibilityNodeInfo) it7.next()) != accessibilityNodeInfo5);
                }
                accessibilityNodeInfo5.recycle();
            }
            return ew2VarA;
        }
        return dw2Var;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00a4  */
    public static ew2 d(ArrayList arrayList) {
        Object obj;
        String str;
        String string;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String string2;
        String string3;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo.isVisibleToUser()) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (text == null || (string3 = text.toString()) == null) {
                    lowerCase = null;
                } else {
                    lowerCase = string3.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                }
                if (lowerCase == null) {
                    lowerCase = "";
                }
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription == null || (string2 = contentDescription.toString()) == null) {
                    lowerCase2 = null;
                } else {
                    lowerCase2 = string2.toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                }
                if (lowerCase2 == null) {
                    lowerCase2 = "";
                }
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase3 = cs2.S(viewIdResourceName, '/').toLowerCase(Locale.ROOT);
                    lowerCase3.getClass();
                } else {
                    lowerCase3 = null;
                }
                String str2 = lowerCase3 != null ? lowerCase3 : "";
                if (lowerCase.equals("cancel") || lowerCase2.equals("cancel") || str2.equals("cancel") || str2.equals("cancel_button")) {
                    break;
                }
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
        if (accessibilityNodeInfo2 == null) {
            return dw2.a;
        }
        CharSequence text2 = accessibilityNodeInfo2.getText();
        if (text2 == null || (string = text2.toString()) == null) {
            str = "Cancel";
        } else {
            str = cs2.A(string) ? null : string;
            if (str == null) {
                str = "Cancel";
            }
        }
        return new bw2(accessibilityNodeInfo2, str, 0.95f, true);
    }

    public static ew2 e(String str, ArrayList arrayList) {
        String lowerCase;
        String string;
        String string2;
        String strO;
        String strO2;
        String string3;
        String string4;
        String string5;
        String string6;
        Locale locale = Locale.ROOT;
        String strO3 = cq.o(locale, str, locale);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            lowerCase = null;
            if (i2 >= size) {
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo.isVisibleToUser()) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (text == null || (string5 = text.toString()) == null || (string6 = cs2.V(string5).toString()) == null) {
                    strO = null;
                } else {
                    Locale locale2 = Locale.ROOT;
                    strO = cq.o(locale2, string6, locale2);
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription == null || (string3 = contentDescription.toString()) == null || (string4 = cs2.V(string3).toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale3 = Locale.ROOT;
                    strO2 = cq.o(locale3, string4, locale3);
                }
                if (strO2 == null) {
                    strO2 = "";
                }
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase = cs2.S(viewIdResourceName, '/').toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                }
                String str2 = lowerCase != null ? lowerCase : "";
                boolean z2 = a.contains(str2) || cs2.n(str2, "contact_name", false) || cs2.n(str2, "conversations_row", false) || accessibilityNodeInfo.isClickable();
                if (!strO.equals(strO3) && !strO2.equals(strO3)) {
                    z = false;
                }
                if (z2 && z) {
                    arrayList2.add(obj);
                }
            }
        }
        if (arrayList2.size() == 1) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) mz.H(arrayList2);
            CharSequence text2 = accessibilityNodeInfo2.getText();
            if (text2 != null && (string2 = text2.toString()) != null) {
                lowerCase = cs2.A(string2) ? null : string2;
                if (lowerCase != null) {
                    str = lowerCase;
                }
            }
            return new bw2(accessibilityNodeInfo2, str, 0.95f, true);
        }
        if (arrayList2.size() <= 1) {
            return dw2.a;
        }
        ArrayList arrayList3 = new ArrayList(nz.d(arrayList2));
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            CharSequence text3 = ((AccessibilityNodeInfo) obj2).getText();
            if (text3 == null || (string = text3.toString()) == null) {
                string = str;
            }
            arrayList3.add(string);
        }
        return new zv2(arrayList3, arrayList2);
    }

    /* JADX WARN: Code duplicated, block: B:67:0x011c  */
    /* JADX WARN: Code duplicated, block: B:74:0x013b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static ew2 f(ArrayList arrayList, AccessibilityNodeInfo accessibilityNodeInfo) {
        String strO;
        CharSequence contentDescription;
        String strO2;
        String string;
        String string2;
        boolean z;
        boolean z2;
        String string3;
        String strO3;
        String string4;
        String string5;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        ?? r2 = 0;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && !accessibilityNodeInfo2.isEditable() && !accessibilityNodeInfo2.isPassword() && !accessibilityNodeInfo2.isScrollable()) {
                CharSequence packageName = accessibilityNodeInfo2.getPackageName();
                String string6 = packageName != null ? packageName.toString() : null;
                CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                if (g31.a(string6, packageName2 != null ? packageName2.toString() : null)) {
                    String viewIdResourceName = accessibilityNodeInfo2.getViewIdResourceName();
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
                    CharSequence text = accessibilityNodeInfo2.getText();
                    CharSequence contentDescription2 = accessibilityNodeInfo2.getContentDescription();
                    CharSequence[] charSequenceArr = new CharSequence[2];
                    charSequenceArr[r2] = text;
                    charSequenceArr[1] = contentDescription2;
                    List<CharSequence> listI = nz.i(charSequenceArr);
                    ArrayList arrayList3 = new ArrayList(nz.d(listI));
                    for (CharSequence charSequence : listI) {
                        if (charSequence == null || (string4 = charSequence.toString()) == null || (string5 = cs2.V(string4).toString()) == null) {
                            strO3 = null;
                        } else {
                            Locale locale2 = Locale.ROOT;
                            strO3 = cq.o(locale2, string5, locale2);
                        }
                        if (strO3 == null) {
                            strO3 = "";
                        }
                        arrayList3.add(strO3);
                    }
                    Pattern patternCompile = Pattern.compile("(?:^|_)(?:close|dismiss)(?:_button|_icon)?$");
                    patternCompile.getClass();
                    boolean zFind = patternCompile.matcher(strO).find();
                    CharSequence className = accessibilityNodeInfo2.getClassName();
                    ?? r11 = (className == null || (string3 = className.toString()) == null || !js2.e(string3, "Button", r2)) ? r2 : 1;
                    Set setC = wh2.c("close", "dismiss", "close button", "dismiss button", "बंद करें");
                    if (r11 != 0 && !arrayList3.isEmpty()) {
                        int size2 = arrayList3.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                Object obj2 = arrayList3.get(i2);
                                i2++;
                                if (setC.contains((String) obj2)) {
                                }
                            } else if (accessibilityNodeInfo2.isClickable()) {
                                Set set = setC;
                                contentDescription = accessibilityNodeInfo2.getContentDescription();
                                if (contentDescription != null) {
                                    strO2 = null;
                                } else {
                                    strO2 = null;
                                }
                                if (mz.s(strO2, set)) {
                                }
                            }
                        }
                    } else if (accessibilityNodeInfo2.isClickable()) {
                        Set set2 = setC;
                        contentDescription = accessibilityNodeInfo2.getContentDescription();
                        if (contentDescription != null || (string = contentDescription.toString()) == null || (string2 = cs2.V(string).toString()) == null) {
                            strO2 = null;
                        } else {
                            Locale locale3 = Locale.ROOT;
                            strO2 = cq.o(locale3, string2, locale3);
                        }
                        z = mz.s(strO2, set2);
                    }
                    if (r11 != 0 && !arrayList3.isEmpty()) {
                        int size3 = arrayList3.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                z2 = false;
                                break;
                            }
                            Object obj3 = arrayList3.get(i3);
                            i3++;
                            if (wh2.c(LanguageTag.PRIVATEUSE, "×", "✕", "cross").contains((String) obj3)) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (zFind || z || z2) {
                        Pattern patternCompile2 = Pattern.compile("(?:title|headline|thumbnail|advertiser|logo|brand|text_input|search_src)");
                        patternCompile2.getClass();
                        if (!patternCompile2.matcher(strO).find()) {
                            arrayList2.add(obj);
                        }
                    }
                }
            }
            r2 = 0;
        }
        int size4 = arrayList2.size();
        if (size4 == 0) {
            return dw2.a;
        }
        if (size4 == 1) {
            return new bw2((AccessibilityNodeInfo) mz.H(arrayList2), "Close", 0.97f, false);
        }
        ArrayList arrayList4 = new ArrayList(nz.d(arrayList2));
        int size5 = arrayList2.size();
        int i4 = 0;
        while (i4 < size5) {
            Object obj4 = arrayList2.get(i4);
            i4++;
            arrayList4.add("Close control");
        }
        return new zv2(arrayList4, arrayList2);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c5  */
    public static ew2 g(ArrayList arrayList) {
        String str;
        Object obj;
        CharSequence contentDescription;
        String string;
        String string2;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String string3;
        String string4;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            str = null;
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo.isVisibleToUser()) {
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase = cs2.S(viewIdResourceName, '/').toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = null;
                }
                if (lowerCase == null) {
                    lowerCase = "";
                }
                CharSequence text = accessibilityNodeInfo.getText();
                if (text == null || (string4 = text.toString()) == null) {
                    lowerCase2 = null;
                } else {
                    lowerCase2 = string4.toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                }
                if (lowerCase2 == null) {
                    lowerCase2 = "";
                }
                CharSequence contentDescription2 = accessibilityNodeInfo.getContentDescription();
                if (contentDescription2 == null || (string3 = contentDescription2.toString()) == null) {
                    lowerCase3 = null;
                } else {
                    lowerCase3 = string3.toLowerCase(Locale.ROOT);
                    lowerCase3.getClass();
                }
                String str2 = lowerCase3 != null ? lowerCase3 : "";
                if (cs2.n(lowerCase, "tab_communities", false) || cs2.n(lowerCase, "communities", false) || cs2.n(lowerCase2, "communities", false) || cs2.n(str2, "communities", false)) {
                    if (!cs2.n(lowerCase, "header", false)) {
                        break;
                    }
                }
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
        if (accessibilityNodeInfo2 == null) {
            return dw2.a;
        }
        CharSequence text2 = accessibilityNodeInfo2.getText();
        if (text2 == null || (string = text2.toString()) == null) {
            contentDescription = accessibilityNodeInfo2.getContentDescription();
            if (contentDescription != null && (string2 = contentDescription.toString()) != null && !cs2.A(string2)) {
                str = string2;
            }
            if (str == null) {
                string = "Communities";
            } else {
                string = str;
            }
        } else {
            if (cs2.A(string)) {
                string = null;
            }
            if (string == null) {
                contentDescription = accessibilityNodeInfo2.getContentDescription();
                if (contentDescription != null) {
                    str = string2;
                }
                if (str == null) {
                    string = "Communities";
                } else {
                    string = str;
                }
            }
        }
        return new bw2(accessibilityNodeInfo2, string, 0.95f, true);
    }

    /* JADX WARN: Code duplicated, block: B:192:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:77:0x0121  */
    /* JADX WARN: Code duplicated, block: B:85:0x0136  */
    /* JADX WARN: Code duplicated, block: B:88:0x013a  */
    public static ew2 h(ArrayList arrayList, List list, String str, IdentityHashMap identityHashMap) {
        Object next;
        ArrayList arrayList2;
        int i;
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        int i2;
        int i3;
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList3;
        Iterator it;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        String string;
        CharSequence contentDescription;
        String str5;
        String string2;
        String string3;
        Object obj;
        String strO;
        String strO2;
        String string4;
        String string5;
        String string6;
        String string7;
        ArrayList arrayList4 = arrayList;
        String str6 = str;
        IdentityHashMap identityHashMap2 = identityHashMap;
        Locale locale = Locale.ROOT;
        String strO3 = cq.o(locale, str6, locale);
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList4.size();
        int i14 = 0;
        while (i14 < size) {
            Object obj2 = arrayList4.get(i14);
            i14++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
            if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && !accessibilityNodeInfo.isPassword() && !ie2.g(accessibilityNodeInfo)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (text == null || (string6 = text.toString()) == null || (string7 = cs2.V(string6).toString()) == null) {
                    strO = null;
                } else {
                    Locale locale2 = Locale.ROOT;
                    strO = cq.o(locale2, string7, locale2);
                }
                if (strO == null) {
                    strO = "";
                }
                CharSequence contentDescription2 = accessibilityNodeInfo.getContentDescription();
                if (contentDescription2 == null || (string4 = contentDescription2.toString()) == null || (string5 = cs2.V(string4).toString()) == null) {
                    strO2 = null;
                } else {
                    Locale locale3 = Locale.ROOT;
                    strO2 = cq.o(locale3, string5, locale3);
                }
                String str7 = strO2 != null ? strO2 : "";
                if (strO.equals(strO3) || str7.equals(strO3)) {
                    arrayList5.add(obj2);
                }
            }
        }
        ArrayList arrayList6 = new ArrayList();
        int size2 = arrayList5.size();
        int i15 = 0;
        while (i15 < size2) {
            Object obj3 = arrayList5.get(i15);
            i15++;
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj3;
            if (!accessibilityNodeInfo2.isEditable() && a(accessibilityNodeInfo2, identityHashMap2) != null) {
                arrayList6.add(obj3);
            }
        }
        if (!arrayList6.isEmpty()) {
            arrayList5 = arrayList6;
        }
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        int size3 = arrayList5.size();
        int i16 = 0;
        while (i16 < size3) {
            Object obj4 = arrayList5.get(i16);
            i16++;
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj4;
            AccessibilityNodeInfo accessibilityNodeInfoA = a(accessibilityNodeInfo3, identityHashMap2);
            if (accessibilityNodeInfoA == null) {
                accessibilityNodeInfoA = accessibilityNodeInfo3;
            }
            if (!arrayList8.isEmpty()) {
                int size4 = arrayList8.size();
                int i17 = 0;
                do {
                    if (i17 < size4) {
                        obj = arrayList8.get(i17);
                        i17++;
                    }
                } while (((AccessibilityNodeInfo) obj) != accessibilityNodeInfoA);
            }
            arrayList8.add(accessibilityNodeInfoA);
            arrayList7.add(accessibilityNodeInfo3);
        }
        if (arrayList7.size() == 1) {
            AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) mz.H(arrayList7);
            CharSequence text2 = accessibilityNodeInfo4.getText();
            if (text2 == null || (string3 = text2.toString()) == null) {
                contentDescription = accessibilityNodeInfo4.getContentDescription();
                if (contentDescription != null || (string2 = contentDescription.toString()) == null || cs2.A(string2)) {
                    str5 = null;
                } else {
                    str5 = string2;
                }
                if (str5 != null) {
                    str6 = str5;
                }
            } else {
                if (cs2.A(string3)) {
                    string3 = null;
                }
                if (string3 == null) {
                    contentDescription = accessibilityNodeInfo4.getContentDescription();
                    if (contentDescription != null) {
                        str5 = null;
                    } else {
                        str5 = null;
                    }
                    if (str5 != null) {
                        str6 = str5;
                    }
                } else {
                    str6 = string3;
                }
            }
            return new bw2(accessibilityNodeInfo4, str6, 0.95f, true);
        }
        if (arrayList7.size() > 1) {
            ArrayList arrayList9 = new ArrayList(nz.d(arrayList7));
            int size5 = arrayList7.size();
            int i18 = 0;
            while (i18 < size5) {
                Object obj5 = arrayList7.get(i18);
                i18++;
                CharSequence text3 = ((AccessibilityNodeInfo) obj5).getText();
                if (text3 == null || (string = text3.toString()) == null) {
                    string = str6;
                }
                arrayList9.add(string);
            }
            return new zv2(arrayList9, arrayList7);
        }
        Set set = vb2.a;
        String string8 = cs2.V(str6).toString();
        Locale locale4 = Locale.ROOT;
        String strO4 = cq.o(locale4, string8, locale4);
        String str8 = "\\s+";
        Pattern patternCompile = Pattern.compile("\\s+");
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(strO4);
        String str9 = Padder.FALLBACK_PADDING_STRING;
        String strReplaceAll = matcher.replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        ArrayList arrayList10 = new ArrayList();
        int size6 = arrayList4.size();
        int i19 = 0;
        while (i19 < size6) {
            Object obj6 = arrayList4.get(i19);
            i19++;
            if (identityHashMap2.get((AccessibilityNodeInfo) obj6) == null) {
                arrayList10.add(obj6);
            }
        }
        ArrayList arrayList11 = new ArrayList(nz.d(arrayList10));
        int size7 = arrayList10.size();
        int i20 = 0;
        while (i20 < size7) {
            Object obj7 = arrayList10.get(i20);
            i20++;
            Rect rect = new Rect();
            ((AccessibilityNodeInfo) obj7).getBoundsInScreen(rect);
            arrayList11.add(rect);
        }
        ArrayList arrayList12 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            gp1 gp1Var = (gp1) next2;
            String str10 = gp1Var.a;
            Rect rect2 = gp1Var.b;
            String string9 = cs2.V(str10).toString();
            Locale locale5 = Locale.ROOT;
            String strO5 = cq.o(locale5, string9, locale5);
            Pattern patternCompile2 = Pattern.compile(str8);
            patternCompile2.getClass();
            String strReplaceAll2 = patternCompile2.matcher(strO5).replaceAll(str9);
            strReplaceAll2.getClass();
            if (!strReplaceAll2.equals(strReplaceAll) || arrayList11.isEmpty()) {
                str2 = strReplaceAll;
                str3 = str8;
                str4 = str9;
                arrayList3 = arrayList11;
                it = it2;
                break;
            }
            int size8 = arrayList11.size();
            int i21 = 0;
            while (true) {
                if (i21 >= size8) {
                    str2 = strReplaceAll;
                    str3 = str8;
                    str4 = str9;
                    arrayList3 = arrayList11;
                    it = it2;
                    break;
                    break;
                }
                Object obj8 = arrayList11.get(i21);
                i21++;
                Rect rect3 = (Rect) obj8;
                rect3.getClass();
                int i22 = rect2.right;
                int i23 = rect2.left;
                str2 = strReplaceAll;
                if (i22 > i23) {
                    int i24 = rect2.bottom;
                    str3 = str8;
                    int i25 = rect2.top;
                    str4 = str9;
                    if (i24 > i25) {
                        int i26 = rect3.right;
                        arrayList3 = arrayList11;
                        int i27 = rect3.left;
                        it = it2;
                        if (i26 > i27 && (i6 = rect3.bottom) > (i7 = rect3.top) && i23 >= i27 && i25 >= i7 && i22 <= i26 && i24 <= i6) {
                            if (arrayList4.isEmpty()) {
                                arrayList12.add(next2);
                                break;
                            }
                            int size9 = arrayList4.size();
                            int i28 = 0;
                            while (true) {
                                if (i28 >= size9) {
                                    arrayList12.add(next2);
                                    break;
                                    break;
                                }
                                Object obj9 = arrayList4.get(i28);
                                i28++;
                                AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj9;
                                if (ie2.g(accessibilityNodeInfo5)) {
                                    Rect rectG = cq.g(accessibilityNodeInfo5);
                                    int i29 = rect2.right;
                                    int i30 = rect2.left;
                                    if (i29 > i30 && (i8 = rect2.bottom) > (i9 = rect2.top) && (i10 = rectG.right) > (i11 = rectG.left) && (i12 = rectG.bottom) > (i13 = rectG.top) && i30 >= i11 && i9 >= i13 && i29 <= i10 && i8 <= i12) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    it2 = it;
                    strReplaceAll = str2;
                    str8 = str3;
                    str9 = str4;
                    arrayList11 = arrayList3;
                } else {
                    str3 = str8;
                    str4 = str9;
                }
                arrayList3 = arrayList11;
                it = it2;
                it2 = it;
                strReplaceAll = str2;
                str8 = str3;
                str9 = str4;
                arrayList11 = arrayList3;
            }
            it2 = it;
            strReplaceAll = str2;
            str8 = str3;
            str9 = str4;
            arrayList11 = arrayList3;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList13 = new ArrayList();
        int size10 = arrayList12.size();
        int i31 = 0;
        while (i31 < size10) {
            Object obj10 = arrayList12.get(i31);
            i31++;
            Rect rect4 = ((gp1) obj10).b;
            if (hashSet.add(rect4.left + ":" + rect4.top + ":" + rect4.right + ":" + rect4.bottom)) {
                arrayList13.add(obj10);
            }
        }
        if (arrayList13.isEmpty()) {
            return new cw2(str6, null);
        }
        ArrayList arrayList14 = new ArrayList(nz.d(arrayList13));
        int size11 = arrayList13.size();
        int i32 = 0;
        while (i32 < size11) {
            Object obj11 = arrayList13.get(i32);
            i32++;
            gp1 gp1Var2 = (gp1) obj11;
            ArrayList arrayList15 = new ArrayList();
            int size12 = arrayList4.size();
            int i33 = 0;
            while (i33 < size12) {
                Object obj12 = arrayList4.get(i33);
                i33++;
                AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj12;
                if (!accessibilityNodeInfo6.isClickable() || !accessibilityNodeInfo6.isVisibleToUser() || !accessibilityNodeInfo6.isEnabled() || accessibilityNodeInfo6.isPassword() || accessibilityNodeInfo6.isEditable() || accessibilityNodeInfo6.isScrollable() || identityHashMap2.get(accessibilityNodeInfo6) == null || (((collectionInfo = accessibilityNodeInfo6.getCollectionInfo()) != null && (collectionInfo.getRowCount() > 0 || collectionInfo.getColumnCount() > 0)) || cs2.n(accessibilityNodeInfo6.getClassName().toString(), "RecyclerView", false) || cs2.n(accessibilityNodeInfo6.getClassName().toString(), "ListView", false))) {
                    arrayList2 = arrayList13;
                    i = size11;
                } else {
                    Rect rectG2 = cq.g(accessibilityNodeInfo6);
                    Rect rect5 = gp1Var2.b;
                    int i34 = rect5.right;
                    int i35 = rect5.left;
                    if (i34 <= i35 || (i2 = rect5.bottom) <= (i3 = rect5.top)) {
                        arrayList2 = arrayList13;
                        i = size11;
                    } else {
                        int i36 = rectG2.right;
                        arrayList2 = arrayList13;
                        int i37 = rectG2.left;
                        i = size11;
                        if (i36 > i37 && (i4 = rectG2.bottom) > (i5 = rectG2.top) && i35 >= i37 && i3 >= i5 && i34 <= i36 && i2 <= i4) {
                            arrayList15.add(obj12);
                        }
                    }
                }
                arrayList4 = arrayList;
                arrayList13 = arrayList2;
                identityHashMap2 = identityHashMap;
                size11 = i;
            }
            ArrayList arrayList16 = arrayList13;
            int i38 = size11;
            Iterator it3 = arrayList15.iterator();
            if (it3.hasNext()) {
                next = it3.next();
                if (it3.hasNext()) {
                    Rect rectG3 = cq.g((AccessibilityNodeInfo) next);
                    long j = ((long) (rectG3.right - rectG3.left)) * ((long) (rectG3.bottom - rectG3.top));
                    do {
                        Object next3 = it3.next();
                        Rect rectG4 = cq.g((AccessibilityNodeInfo) next3);
                        long j2 = ((long) (rectG4.right - rectG4.left)) * ((long) (rectG4.bottom - rectG4.top));
                        if (j > j2) {
                            next = next3;
                            j = j2;
                        }
                    } while (it3.hasNext());
                }
            } else {
                next = null;
            }
            arrayList14.add((AccessibilityNodeInfo) next);
            arrayList4 = arrayList;
            arrayList13 = arrayList16;
            identityHashMap2 = identityHashMap;
            size11 = i38;
        }
        ArrayList arrayList17 = arrayList13;
        ArrayList arrayList18 = new ArrayList();
        int size13 = arrayList14.size();
        int i39 = 0;
        while (i39 < size13) {
            Object obj13 = arrayList14.get(i39);
            i39++;
            if (obj13 != null) {
                arrayList18.add(obj13);
            }
        }
        List<AccessibilityNodeInfo> listT = mz.t(arrayList18);
        if (!arrayList14.isEmpty()) {
            int size14 = arrayList14.size();
            int i40 = 0;
            while (i40 < size14) {
                Object obj14 = arrayList14.get(i40);
                i40++;
                if (((AccessibilityNodeInfo) obj14) == null) {
                    return arrayList17.size() == 1 ? new aw2(((gp1) mz.H(arrayList17)).b, ((gp1) mz.H(arrayList17)).a, 0.85f) : new cw2(str6, "multiple visible matches");
                }
            }
        }
        if (listT.size() == 1) {
            return new bw2((AccessibilityNodeInfo) mz.H(listT), ((gp1) mz.x(arrayList17)).a, 0.9f, true);
        }
        ArrayList arrayList19 = new ArrayList(nz.d(listT));
        for (AccessibilityNodeInfo accessibilityNodeInfo7 : listT) {
            arrayList19.add(str6);
        }
        return new zv2(arrayList19, listT);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0097  */
    public static ew2 i(ArrayList arrayList) {
        Object obj;
        String str;
        String string;
        String lowerCase;
        String lowerCase2;
        String string2;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo.isVisibleToUser()) {
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName != null) {
                    lowerCase = cs2.S(viewIdResourceName, '/').toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = null;
                }
                if (lowerCase == null) {
                    lowerCase = "";
                }
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription == null || (string2 = contentDescription.toString()) == null) {
                    lowerCase2 = null;
                } else {
                    lowerCase2 = string2.toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                }
                String str2 = lowerCase2 != null ? lowerCase2 : "";
                if (cs2.n(lowerCase, "mini_player_close", false) || cs2.n(lowerCase, "miniplayer_close", false) || cs2.n(str2, "close mini player", false) || cs2.n(str2, "dismiss mini player", false) || cs2.n(str2, "close player", false)) {
                    break;
                }
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
        if (accessibilityNodeInfo2 == null) {
            return dw2.a;
        }
        CharSequence contentDescription2 = accessibilityNodeInfo2.getContentDescription();
        if (contentDescription2 == null || (string = contentDescription2.toString()) == null) {
            str = "Close mini-player";
        } else {
            str = cs2.A(string) ? null : string;
            if (str == null) {
                str = "Close mini-player";
            }
        }
        return new bw2(accessibilityNodeInfo2, str, 0.95f, true);
    }

    public static ew2 j(ArrayList arrayList, List list, String str, IdentityHashMap identityHashMap, boolean z) {
        List listA = ie2.a(arrayList, identityHashMap, z);
        if (listA.size() == 1) {
            return new bw2((AccessibilityNodeInfo) mz.H(listA), ie2.i((AccessibilityNodeInfo) mz.H(listA)), 0.95f, true);
        }
        if (listA.size() > 1) {
            ArrayList arrayList2 = new ArrayList(nz.d(listA));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList2.add(ie2.i((AccessibilityNodeInfo) it.next()));
            }
            return new zv2(arrayList2, listA);
        }
        if (!z) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : list) {
                gp1 gp1Var = (gp1) obj;
                x42 x42Var = ie2.a;
                if (ie2.e(gp1Var.a) && !gp1Var.b.isEmpty()) {
                    arrayList3.add(obj);
                }
            }
            if (arrayList3.size() == 1) {
                return new aw2(((gp1) mz.H(arrayList3)).b, "Search", 0.85f);
            }
            if (arrayList3.size() > 1) {
                return new cw2(str, "multiple search controls");
            }
        }
        return dw2.a;
    }

    public static ew2 k(xc2 xc2Var, String str, List list) {
        xc2Var.getClass();
        return c(str, list, ii0.a, false, null);
    }

    public static List l(ew2 ew2Var) {
        if (ew2Var instanceof bw2) {
            return nz.h(((bw2) ew2Var).a);
        }
        return ew2Var instanceof zv2 ? ((zv2) ew2Var).b : ii0.a;
    }
}
