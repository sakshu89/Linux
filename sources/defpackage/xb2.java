package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xb2 {
    public final r2 a;
    public final Context b;

    public xb2(r2 r2Var, Context context) {
        r2Var.getClass();
        this.a = r2Var;
        this.b = context;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x006b A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:13:0x003d, B:17:0x0047, B:22:0x0065, B:24:0x006b, B:94:0x015b, B:90:0x0151, B:92:0x0157, B:93:0x015a, B:20:0x005f, B:28:0x0073, B:30:0x0079, B:32:0x007f, B:38:0x008f, B:40:0x0095, B:42:0x009b, B:46:0x00a8, B:48:0x00ae, B:50:0x00b4, B:55:0x00c5, B:58:0x00cc, B:62:0x00d6, B:64:0x00e0, B:69:0x00ed, B:71:0x00f7, B:77:0x0105, B:79:0x011b, B:83:0x0126, B:84:0x0132, B:86:0x0139, B:88:0x013f), top: B:110:0x003d, inners: #1 }] */
    public static final wc2 a(xb2 xb2Var) {
        int i;
        String string;
        String string2;
        String string3;
        AccessibilityNodeInfo accessibilityNodeInfoB = xb2Var.a.b();
        String str = null;
        if (accessibilityNodeInfoB == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        CharSequence packageName = accessibilityNodeInfoB.getPackageName();
        String string4 = packageName != null ? packageName.toString() : null;
        if (string4 == null) {
            string4 = "";
        }
        String strC = xb2Var.c(string4);
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new wt1(accessibilityNodeInfoB, 0));
        int i2 = 0;
        while (!arrayDeque.isEmpty() && i2 < 1000) {
            try {
                wt1 wt1Var = (wt1) arrayDeque.removeFirst();
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) wt1Var.a;
                int iIntValue = ((Number) wt1Var.b).intValue();
                i2++;
                if (iIntValue <= 40) {
                    try {
                        if (!accessibilityNodeInfo.isPassword()) {
                            CharSequence text = accessibilityNodeInfo.getText();
                            String string5 = (text == null || (string3 = text.toString()) == null) ? str : cs2.V(string3).toString();
                            if (string5 == null) {
                                string5 = "";
                            }
                            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                            String string6 = (contentDescription == null || (string2 = contentDescription.toString()) == null) ? str : cs2.V(string2).toString();
                            if (string6 == null) {
                                string6 = "";
                            }
                            CharSequence hintText = accessibilityNodeInfo.getHintText();
                            String string7 = (hintText == null || (string = hintText.toString()) == null) ? str : cs2.V(string).toString();
                            String str2 = string7 == null ? "" : string7;
                            if (cs2.A(string5)) {
                                string5 = string6;
                            }
                            String str3 = cs2.A(string5) ? str2 : string5;
                            boolean zIsClickable = accessibilityNodeInfo.isClickable();
                            boolean z = accessibilityNodeInfo.isEditable() || ie2.g(accessibilityNodeInfo);
                            boolean zIsScrollable = accessibilityNodeInfo.isScrollable();
                            if (accessibilityNodeInfo.isVisibleToUser() && (!cs2.A(str3) || zIsClickable || z)) {
                                Rect rect = new Rect();
                                accessibilityNodeInfo.getBoundsInScreen(rect);
                                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                                CharSequence className = accessibilityNodeInfo.getClassName();
                                String string8 = className != null ? className.toString() : str;
                                if (string8 == null) {
                                    string8 = "";
                                }
                                i = iIntValue;
                                arrayList.add(new ob2(str3, viewIdResourceName, string8, rect, zIsClickable, z, zIsScrollable, i, str2, accessibilityNodeInfo.isFocused()));
                            } else {
                                i = iIntValue;
                            }
                            int childCount = accessibilityNodeInfo.getChildCount();
                            for (int i3 = 0; i3 < childCount; i3++) {
                                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                                if (child != null) {
                                    arrayDeque.add(new wt1(child, Integer.valueOf(i + 1)));
                                }
                            }
                            if (!g31.a(accessibilityNodeInfo, accessibilityNodeInfoB)) {
                                accessibilityNodeInfo.recycle();
                            }
                        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoB)) {
                            accessibilityNodeInfo.recycle();
                        }
                    } catch (Throwable th) {
                        if (!g31.a(accessibilityNodeInfo, accessibilityNodeInfoB)) {
                            accessibilityNodeInfo.recycle();
                        }
                        throw th;
                    }
                } else if (!g31.a(accessibilityNodeInfo, accessibilityNodeInfoB)) {
                    accessibilityNodeInfo.recycle();
                }
                str = null;
            } catch (Throwable th2) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((AccessibilityNodeInfo) ((wt1) it.next()).a).recycle();
                }
                accessibilityNodeInfoB.recycle();
                throw th2;
            }
        }
        Iterator it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            ((AccessibilityNodeInfo) ((wt1) it2.next()).a).recycle();
        }
        accessibilityNodeInfoB.recycle();
        arrayList.size();
        return new wc2(string4, strC, arrayList, jCurrentTimeMillis);
    }

    public static String d(wc2 wc2Var) {
        List listK = mz.K(wc2Var.c, new i2(16, new lo0(26)));
        ArrayList arrayList = new ArrayList(nz.d(listK));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            String string = cs2.V(((ob2) it.next()).a).toString();
            Pattern patternCompile = Pattern.compile("\\s+");
            patternCompile.getClass();
            string.getClass();
            String strReplaceAll = patternCompile.matcher(string).replaceAll(Padder.FALLBACK_PADDING_STRING);
            strReplaceAll.getClass();
            arrayList.add(strReplaceAll);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (!cs2.A((String) obj)) {
                arrayList2.add(obj);
            }
        }
        String strT = cs2.T(1600, mz.C(mz.L(mz.t(arrayList2), 16), ". ", null, null, null, 62));
        return cq.l("You are on the ", wc2Var.b, " screen.", cs2.A(strT) ? " No readable text is exposed." : cq.v(Padder.FALLBACK_PADDING_STRING, strT, "."));
    }

    public final Object b(y50 y50Var) {
        return uf4.d(ld0.a, new wb2(this, null), y50Var);
    }

    public final String c(String str) {
        if (cs2.A(str)) {
            return "Unknown App";
        }
        try {
            PackageManager packageManager = this.b.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            applicationInfo.getClass();
            return packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (Exception unused) {
            String strS = cs2.S(str, '.');
            if (strS.length() <= 0) {
                return strS;
            }
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(strS.charAt(0));
            strValueOf.getClass();
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            sb.append((Object) upperCase);
            sb.append(strS.substring(1));
            return sb.toString();
        }
    }
}
