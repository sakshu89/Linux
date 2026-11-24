package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class cs2 extends js2 {
    public static boolean A(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!ph4.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char B(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(charSequence.length() - 1);
        }
        kf2.g("Char sequence is empty.");
        return (char) 0;
    }

    public static int C(String str, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            str.getClass();
            i = str.length() - 1;
        }
        str.getClass();
        return str.lastIndexOf(c, i);
    }

    public static int D(String str, int i, String str2) {
        int length;
        if ((i & 2) != 0) {
            str.getClass();
            length = str.length() - 1;
        } else {
            length = 0;
        }
        boolean z = (i & 4) == 0;
        str.getClass();
        str2.getClass();
        return !z ? str.lastIndexOf(str2, length) : w(str, str2, length, 0, z, true);
    }

    public static final List E(String str) {
        hc1 hc1Var = new hc1(str);
        if (!hc1Var.hasNext()) {
            return ii0.a;
        }
        Object next = hc1Var.next();
        if (!hc1Var.hasNext()) {
            return nz.h(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (hc1Var.hasNext()) {
            arrayList.add(hc1Var.next());
        }
        return arrayList;
    }

    public static final boolean F(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!ph4.b(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String G(String str, String str2) {
        str.getClass();
        str2.getClass();
        return P(str2, str) ? str.substring(str2.length()) : str;
    }

    public static CharSequence H(String str, h21 h21Var) {
        str.getClass();
        h21Var.getClass();
        int i = h21Var.a;
        int i2 = h21Var.b + 1;
        if (i2 < i) {
            og.o(cq.i("End index (", i2, ") is less than start index (", i, ")."));
            return null;
        }
        if (i2 == i) {
            return str.subSequence(0, str.length());
        }
        StringBuilder sb = new StringBuilder(str.length() - (i2 - i));
        sb.append((CharSequence) str, 0, i);
        sb.append((CharSequence) str, i2, str.length());
        return sb;
    }

    public static String I(String str, String str2) {
        str.getClass();
        str2.getClass();
        return r(str, str2) ? str.substring(0, str.length() - str2.length()) : str;
    }

    public static String J(String str, String str2, String str3) {
        str.getClass();
        return (str.length() >= str3.length() + str2.length() && P(str2, str) && r(str, str3)) ? str.substring(str2.length(), str.length() - str3.length()) : str;
    }

    public static StringBuilder K(CharSequence charSequence, int i, CharSequence charSequence2, int i2) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < i) {
            og.o(cq.i("End index (", i2, ") is less than start index (", i, ")."));
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i);
        sb.append(charSequence2);
        sb.append(charSequence, i2, charSequence.length());
        return sb;
    }

    public static final void L(int i) {
        if (i >= 0) {
            return;
        }
        og.g(ky0.h(i, "Limit must be non-negative, but was "));
    }

    public static final List M(CharSequence charSequence, String str, int i) {
        L(i);
        int iV = v(charSequence, str, 0, false);
        if (iV == -1 || i == 1) {
            return nz.h(charSequence.toString());
        }
        boolean z = i > 0;
        int i2 = 10;
        if (z && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iV).toString());
            length = str.length() + iV;
            if (z && arrayList.size() == i - 1) {
                break;
            }
            iV = v(charSequence, str, length, false);
        } while (iV != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List N(CharSequence charSequence, char[] cArr, int i) {
        int i2 = (i & 4) != 0 ? 0 : 2;
        charSequence.getClass();
        if (cArr.length == 1) {
            return M(charSequence, String.valueOf(cArr[0]), i2);
        }
        L(i2);
        bh2 bh2Var = new bh2(new hc0(charSequence, i2, new ha(15, cArr)));
        ArrayList arrayList = new ArrayList(nz.d(bh2Var));
        Iterator it = bh2Var.iterator();
        while (true) {
            gc0 gc0Var = (gc0) it;
            if (!gc0Var.hasNext()) {
                return arrayList;
            }
            h21 h21Var = (h21) gc0Var.next();
            h21Var.getClass();
            arrayList.add(charSequence.subSequence(h21Var.a, h21Var.b + 1).toString());
        }
    }

    public static List O(String str, String[] strArr) {
        str.getClass();
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return M(str, str2, 0);
            }
        }
        L(0);
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        bh2 bh2Var = new bh2(new hc0(str, 0, new ha(16, listAsList)));
        ArrayList arrayList = new ArrayList(nz.d(bh2Var));
        Iterator it = bh2Var.iterator();
        while (true) {
            gc0 gc0Var = (gc0) it;
            if (!gc0Var.hasNext()) {
                return arrayList;
            }
            h21 h21Var = (h21) gc0Var.next();
            h21Var.getClass();
            arrayList.add(str.subSequence(h21Var.a, h21Var.b + 1).toString());
        }
    }

    public static boolean P(CharSequence charSequence, String str) {
        str.getClass();
        charSequence.getClass();
        return charSequence instanceof String ? js2.k(str, (String) charSequence, false) : F(str, 0, charSequence, 0, charSequence.length(), false);
    }

    public static boolean Q(String str, char c) {
        str.getClass();
        return str.length() > 0 && ph4.b(str.charAt(0), c, false);
    }

    public static String R(String str, String str2) {
        int iY = y(str, str2, 0, false, 6);
        return iY == -1 ? str : str.substring(str2.length() + iY, str.length());
    }

    public static String S(String str, char c) {
        str.getClass();
        str.getClass();
        int iC = C(str, c, 0, 6);
        return iC == -1 ? str : str.substring(iC + 1, str.length());
    }

    public static String T(int i, String str) {
        str.getClass();
        if (i < 0) {
            og.g(cq.h("Requested character count ", i, " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(0, i);
    }

    public static String U(int i, String str) {
        str.getClass();
        if (i < 0) {
            og.g(cq.h("Requested character count ", i, " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(length - i);
    }

    public static CharSequence V(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = ph4.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static String W(String str, char... cArr) {
        str.getClass();
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = qg.c(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static CharSequence X(String str) {
        str.getClass();
        int length = str.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i = length - 1;
            if (!ph4.c(str.charAt(length))) {
                return str.subSequence(0, length + 1);
            }
            if (i < 0) {
                return "";
            }
            length = i;
        }
    }

    public static String Y(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i = length - 1;
            if (!qg.c(cArr, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i;
        }
        return charSequenceSubSequence.toString();
    }

    public static boolean n(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (y(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (w(charSequence, charSequence2, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean o(CharSequence charSequence, char c) {
        charSequence.getClass();
        return x(charSequence, c, 0, 2) >= 0;
    }

    public static String p(int i, String str) {
        str.getClass();
        if (i < 0) {
            og.g(cq.h("Requested character count ", i, " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(i);
    }

    public static String q(String str) {
        int length = str.length() - 1;
        if (length < 0) {
            length = 0;
        }
        return T(length, str);
    }

    public static boolean r(CharSequence charSequence, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? js2.e((String) charSequence, (String) charSequence2, false) : F(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), false);
    }

    public static boolean s(String str, char c) {
        str.getClass();
        return str.length() > 0 && ph4.b(str.charAt(str.length() - 1), c, false);
    }

    public static char t(String str) {
        if (str.length() != 0) {
            return str.charAt(0);
        }
        kf2.g("Char sequence is empty.");
        return (char) 0;
    }

    public static Character u(int i, String str) {
        if (i < 0 || i >= str.length()) {
            return null;
        }
        return Character.valueOf(str.charAt(i));
    }

    public static final int v(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? w(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int w(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        f21 f21Var;
        if (z2) {
            charSequence.getClass();
            int length = charSequence.length() - 1;
            if (i > length) {
                i = length;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            f21Var = new f21(i, i2, -1);
        } else {
            if (i < 0) {
                i = 0;
            }
            int length2 = charSequence.length();
            if (i2 > length2) {
                i2 = length2;
            }
            f21Var = new h21(i, i2, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = f21Var.c;
        int i4 = f21Var.b;
        int i5 = f21Var.a;
        if (!z3 || !(charSequence2 instanceof String)) {
            boolean z4 = z;
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z5 = z4;
                    z4 = z5;
                    if (F(charSequence4, 0, charSequence3, i5, charSequence2.length(), z5)) {
                        return i5;
                    }
                    if (i5 != i4) {
                        i5 += i3;
                        charSequence2 = charSequence4;
                        charSequence = charSequence3;
                    }
                }
            }
        } else if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            int i6 = i5;
            while (true) {
                String str = (String) charSequence2;
                boolean z6 = z;
                if (js2.g(0, i6, str.length(), str, (String) charSequence, z6)) {
                    return i6;
                }
                if (i6 != i4) {
                    i6 += i3;
                    z = z6;
                }
            }
        }
        return -1;
    }

    public static int x(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? z(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int y(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return v(charSequence, str, i, z);
    }

    public static final int z(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        char c = 0;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                kf2.g("Array is empty.");
            } else if (length == 1) {
                c = cArr[0];
            } else {
                og.i("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(c, i);
        }
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length() - 1;
        if (i > length2) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c2 : cArr) {
                if (ph4.b(c2, cCharAt, z)) {
                    return i;
                }
            }
            if (i == length2) {
                return -1;
            }
            i++;
        }
    }
}
