package defpackage;

import android.media.session.MediaController;
import android.speech.tts.Voice;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lo0 implements Comparator {
    public static final lo0 b = new lo0(0);
    public static final lo0 c = new lo0(1);
    public static final lo0 e = new lo0(2);
    public static final lo0 f = new lo0(3);
    public static final lo0 i = new lo0(4);
    public static final /* synthetic */ lo0 j = new lo0(5);
    public final /* synthetic */ int a;

    public lo0(ii1 ii1Var) {
        this.a = 18;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean z = false;
        switch (this.a) {
            case 0:
                ko0 ko0Var = (ko0) obj;
                ko0 ko0Var2 = (ko0) obj2;
                if (xn4.d(ko0Var) && xn4.d(ko0Var2)) {
                    n71 n71VarG = cm4.g(ko0Var);
                    n71 n71VarG2 = cm4.g(ko0Var2);
                    if (!g31.a(n71VarG, n71VarG2)) {
                        Object[] objArr = new n71[16];
                        int i2 = 0;
                        while (n71VarG != null) {
                            int i3 = i2 + 1;
                            if (objArr.length < i3) {
                                int length = objArr.length;
                                Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                System.arraycopy(objArr, 0, objArr2, 0, length);
                                objArr = objArr2;
                            }
                            if (i2 != 0) {
                                System.arraycopy(objArr, 0, objArr, 0 + 1, i2 + 0);
                            }
                            objArr[0] = n71VarG;
                            i2++;
                            n71VarG = n71VarG.u();
                        }
                        Object[] objArr3 = new n71[16];
                        int i4 = 0;
                        while (n71VarG2 != null) {
                            int i5 = i4 + 1;
                            if (objArr3.length < i5) {
                                int length2 = objArr3.length;
                                Object[] objArr4 = new Object[Math.max(i5, length2 * 2)];
                                System.arraycopy(objArr3, 0, objArr4, 0, length2);
                                objArr3 = objArr4;
                            }
                            if (i4 != 0) {
                                System.arraycopy(objArr3, 0, objArr3, 0 + 1, i4 + 0);
                            }
                            objArr3[0] = n71VarG2;
                            i4++;
                            n71VarG2 = n71VarG2.u();
                        }
                        int iMin = Math.min(i2 - 1, i4 - 1);
                        if (iMin >= 0) {
                            int i6 = 0;
                            while (g31.a(objArr[i6], objArr3[i6])) {
                                if (i6 != iMin) {
                                    i6++;
                                }
                            }
                            return g31.b(((n71) objArr[i6]).v(), ((n71) objArr3[i6]).v());
                        }
                        og.n("Could not find a common ancestor between the two FocusModifiers.");
                    }
                } else {
                    if (xn4.d(ko0Var)) {
                        return -1;
                    }
                    if (xn4.d(ko0Var2)) {
                        return 1;
                    }
                }
                return 0;
            case 1:
                l42 l42VarH = ((gg2) obj).h();
                l42 l42VarH2 = ((gg2) obj2).h();
                int iCompare = Float.compare(l42VarH.a, l42VarH2.a);
                if (iCompare != 0) {
                    return iCompare;
                }
                int iCompare2 = Float.compare(l42VarH.b, l42VarH2.b);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompare3 = Float.compare(l42VarH.d, l42VarH2.d);
                return iCompare3 != 0 ? iCompare3 : Float.compare(l42VarH.c, l42VarH2.c);
            case 2:
                n71 n71Var = (n71) obj;
                n71 n71Var2 = (n71) obj2;
                int iB = g31.b(n71Var2.H, n71Var.H);
                return iB != 0 ? iB : g31.b(n71Var.hashCode(), n71Var2.hashCode());
            case 3:
                l42 l42VarH3 = ((gg2) obj).h();
                l42 l42VarH4 = ((gg2) obj2).h();
                int iCompare4 = Float.compare(l42VarH4.c, l42VarH3.c);
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                int iCompare5 = Float.compare(l42VarH3.b, l42VarH4.b);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                int iCompare6 = Float.compare(l42VarH3.d, l42VarH4.d);
                return iCompare6 != 0 ? iCompare6 : Float.compare(l42VarH4.a, l42VarH3.a);
            case 4:
                wt1 wt1Var = (wt1) obj;
                wt1 wt1Var2 = (wt1) obj2;
                int iCompare7 = Float.compare(((l42) wt1Var.a).b, ((l42) wt1Var2.a).b);
                return iCompare7 != 0 ? iCompare7 : Float.compare(((l42) wt1Var.a).d, ((l42) wt1Var2.a).d);
            case 5:
                el0 el0Var = (el0) obj;
                el0 el0Var2 = (el0) obj2;
                return !el0Var.a.equals(el0Var2.a) ? el0Var.a.compareTo(el0Var2.a) : (el0Var.a() > el0Var2.a() ? 1 : (el0Var.a() == el0Var2.a() ? 0 : -1));
            case 6:
                return si4.a(Boolean.valueOf(((AccessibilityWindowInfo) obj2).isFocused()), Boolean.valueOf(((AccessibilityWindowInfo) obj).isFocused()));
            case 7:
                return si4.a(Boolean.valueOf(((AccessibilityWindowInfo) obj2).isFocused()), Boolean.valueOf(((AccessibilityWindowInfo) obj).isFocused()));
            case 8:
                return si4.a(Integer.valueOf(((ae) obj).b), Integer.valueOf(((ae) obj2).b));
            case 9:
                return si4.a(Integer.valueOf(((ae) obj).b), Integer.valueOf(((ae) obj2).b));
            case 10:
                String str = ((x11) obj).b;
                Locale locale = Locale.ROOT;
                String strO = cq.o(locale, str, locale);
                String lowerCase = ((x11) obj2).b.toLowerCase(locale);
                lowerCase.getClass();
                return si4.a(strO, lowerCase);
            case 11:
                return si4.a(Integer.valueOf(((Number) ((wt1) obj).b).intValue()), Integer.valueOf(((Number) ((wt1) obj2).b).intValue()));
            case 12:
                String str2 = (String) obj;
                String str3 = (String) obj2;
                str2.getClass();
                str3.getClass();
                int iMin2 = Math.min(str2.length(), str3.length());
                for (int i7 = 4; i7 < iMin2; i7++) {
                    char cCharAt = str2.charAt(i7);
                    char cCharAt2 = str3.charAt(i7);
                    if (cCharAt != cCharAt2) {
                        if (g31.b(cCharAt, cCharAt2) < 0) {
                            return -1;
                        }
                        return 1;
                    }
                }
                int length3 = str2.length();
                int length4 = str3.length();
                if (length3 == length4) {
                    return 0;
                }
                if (length3 < length4) {
                    return -1;
                }
                return 1;
            case 13:
                return si4.a((Float) ((wt1) obj2).b, (Float) ((wt1) obj).b);
            case 14:
                return si4.a((Comparable) ((wt1) obj2).b, (Comparable) ((wt1) obj).b);
            case 15:
                n71 n71Var3 = (n71) obj;
                n71 n71Var4 = (n71) obj2;
                int iB2 = g31.b(n71Var3.H, n71Var4.H);
                return iB2 != 0 ? iB2 : g31.b(n71Var3.hashCode(), n71Var4.hashCode());
            case 16:
                String str4 = (String) obj2;
                x42 x42Var = od1.a;
                Boolean boolValueOf = Boolean.valueOf((cs2.n(str4, "preview", true) || cs2.n(str4, "-exp", true)) ? false : true);
                String str5 = (String) obj;
                if (!cs2.n(str5, "preview", true) && !cs2.n(str5, "-exp", true)) {
                    z = true;
                }
                return si4.a(boolValueOf, Boolean.valueOf(z));
            case 17:
                return si4.a(Integer.valueOf(((o21) obj2).a()), Integer.valueOf(((o21) obj).a()));
            case 18:
                MediaController mediaController = (MediaController) obj2;
                mediaController.getClass();
                Boolean boolValueOf2 = Boolean.valueOf(ii1.d(mediaController));
                MediaController mediaController2 = (MediaController) obj;
                mediaController2.getClass();
                return si4.a(boolValueOf2, Boolean.valueOf(ii1.d(mediaController2)));
            case 19:
                Integer num = 1;
                String name = ((Voice) obj).getName();
                name.getClass();
                Locale locale2 = Locale.ROOT;
                String strO2 = cq.o(locale2, name, locale2);
                Integer num2 = (cs2.n(strO2, "female", false) || cs2.n(strO2, "af_", false) || cs2.n(strO2, "hf_", false) || cs2.n(strO2, "bf_", false)) ? num : 0;
                String name2 = ((Voice) obj2).getName();
                name2.getClass();
                String lowerCase2 = name2.toLowerCase(locale2);
                lowerCase2.getClass();
                if (!cs2.n(lowerCase2, "female", false) && !cs2.n(lowerCase2, "af_", false) && !cs2.n(lowerCase2, "hf_", false) && !cs2.n(lowerCase2, "bf_", false)) {
                    num = 0;
                }
                return si4.a(num2, num);
            case 20:
                return si4.a(Integer.valueOf(!((AccessibilityNodeInfo) obj).isClickable() ? 1 : 0), Integer.valueOf(!((AccessibilityNodeInfo) obj2).isClickable() ? 1 : 0));
            case 21:
                return si4.a(Integer.valueOf(!((AccessibilityNodeInfo) obj).isClickable() ? 1 : 0), Integer.valueOf(!((AccessibilityNodeInfo) obj2).isClickable() ? 1 : 0));
            case 22:
                return si4.a(Integer.valueOf(((mb2) obj).c.top), Integer.valueOf(((mb2) obj2).c.top));
            case 23:
                return si4.a(Integer.valueOf(((ob2) obj).d.top), Integer.valueOf(((ob2) obj2).d.top));
            case 24:
                return si4.a(Integer.valueOf(cq.g((AccessibilityNodeInfo) obj).top), Integer.valueOf(cq.g((AccessibilityNodeInfo) obj2).top));
            case 25:
                return si4.a(Integer.valueOf(((gp1) obj).b.top), Integer.valueOf(((gp1) obj2).b.top));
            case 26:
                return si4.a(Integer.valueOf(((ob2) obj).d.top), Integer.valueOf(((ob2) obj2).d.top));
            case 27:
                return si4.a(Integer.valueOf(cq.g((AccessibilityNodeInfo) obj).top), Integer.valueOf(cq.g((AccessibilityNodeInfo) obj2).top));
            case 28:
                return si4.a(Integer.valueOf(((zb2) obj).d.top), Integer.valueOf(((zb2) obj2).d.top));
            default:
                return si4.a(((bl2) obj).d(), ((bl2) obj2).d());
        }
    }

    public /* synthetic */ lo0(int i2) {
        this.a = i2;
    }
}
