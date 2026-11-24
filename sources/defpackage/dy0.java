package defpackage;

import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.lang.UCharacter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dy0 {
    public String a;
    public String d;
    public final ArrayList f;
    public ArrayList g;
    public String h;
    public String b = "";
    public String c = "";
    public int e = -1;

    public dy0() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final void a(String str, String str2) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        ArrayList arrayList = this.g;
        arrayList.getClass();
        arrayList.add(fl4.c(0, 0, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false));
        ArrayList arrayList2 = this.g;
        arrayList2.getClass();
        arrayList2.add(str2 != null ? fl4.c(0, 0, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false) : null);
    }

    public final ey0 b() {
        ArrayList arrayList;
        String str = this.a;
        if (str == null) {
            og.n("scheme == null");
            return null;
        }
        String strE = fl4.e(0, 0, 7, this.b);
        String strE2 = fl4.e(0, 0, 7, this.c);
        String str2 = this.d;
        if (str2 == null) {
            og.n("host == null");
            return null;
        }
        int iC = c();
        ArrayList arrayList2 = this.f;
        ArrayList arrayList3 = new ArrayList(nz.d(arrayList2));
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList3.add(fl4.e(0, 0, 7, (String) obj));
        }
        ArrayList arrayList4 = this.g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(nz.d(arrayList4));
            int size2 = arrayList4.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList4.get(i2);
                i2++;
                String str3 = (String) obj2;
                arrayList.add(str3 != null ? fl4.e(0, 0, 3, str3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.h;
        return new ey0(str, strE, strE2, str2, iC, arrayList3, arrayList, str4 != null ? fl4.e(0, 0, 7, str4) : null, toString());
    }

    public final int c() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        String str = this.a;
        str.getClass();
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    public final void d(ey0 ey0Var, String str) {
        int i;
        int i2;
        ArrayList arrayList;
        int i3;
        int i4;
        ArrayList arrayList2;
        char cCharAt;
        dy0 dy0Var = this;
        String str2 = str;
        byte[] bArr = z53.a;
        int iN = z53.n(0, str2.length(), str2);
        int iO = z53.o(iN, str2.length(), str2);
        int i5 = -1;
        if (iO - iN >= 2) {
            char cCharAt2 = str2.charAt(iN);
            if ((g31.b(cCharAt2, 97) >= 0 && g31.b(cCharAt2, 122) <= 0) || (g31.b(cCharAt2, 65) >= 0 && g31.b(cCharAt2, 90) <= 0)) {
                i = iN + 1;
                while (true) {
                    if (i < iO) {
                        char cCharAt3 = str2.charAt(i);
                        if (('a' > cCharAt3 || cCharAt3 >= '{') && (('A' > cCharAt3 || cCharAt3 >= '[') && !(('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                            if (cCharAt3 == ':') {
                                break;
                            } else {
                                break;
                            }
                        }
                        i++;
                    }
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
        } else {
            i = -1;
            break;
        }
        int i6 = 1;
        if (i != -1) {
            if (js2.j(str2, "https:", iN, true)) {
                dy0Var.a = "https";
                iN += 6;
            } else {
                if (!js2.j(str2, "http:", iN, true)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, i) + PatternTokenizer.SINGLE_QUOTE);
                }
                dy0Var.a = "http";
                iN += 5;
            }
        } else {
            if (ey0Var == null) {
                og.i("Expected URL scheme 'http' or 'https' but no scheme was found for ".concat(str2.length() > 6 ? cs2.T(6, str2).concat("...") : str2));
                return;
            }
            dy0Var.a = ey0Var.a;
        }
        int i7 = iN;
        int i8 = 0;
        while (true) {
            i2 = i6;
            if (i7 >= iO || !((cCharAt = str2.charAt(i7)) == '\\' || cCharAt == '/')) {
                break;
            }
            i8++;
            i7++;
            i6 = i2;
        }
        char c = '?';
        ArrayList arrayList3 = dy0Var.f;
        char c2 = '#';
        if (i8 >= 2 || ey0Var == null || !g31.a(ey0Var.a, dy0Var.a)) {
            int i9 = iN + i8;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                iN = z53.g(str2, i9, iO, "@/\\?#");
                byte bCharAt = iN != iO ? str2.charAt(iN) : (byte) -1;
                if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                    break;
                }
                if (bCharAt == 64) {
                    if (i10 == 0) {
                        int iF = z53.f(str2, ':', i9, iN);
                        arrayList2 = arrayList3;
                        String strC = fl4.c(i9, iF, 240, str2, " \"':;<=>@[]^`{}|/\\?#", true);
                        if (i11 != 0) {
                            strC = dy0Var.b + "%40" + strC;
                        }
                        dy0Var.b = strC;
                        if (iF != iN) {
                            int i12 = iF + 1;
                            iN = iN;
                            dy0Var.c = fl4.c(i12, iN, 240, str, " \"':;<=>@[]^`{}|/\\?#", true);
                            i10 = i2;
                        } else {
                            iN = iN;
                        }
                        str2 = str;
                        i11 = i2;
                    } else {
                        arrayList2 = arrayList3;
                        StringBuilder sb = new StringBuilder();
                        sb.append(dy0Var.c);
                        sb.append("%40");
                        str2 = str;
                        sb.append(fl4.c(i9, iN, 240, str2, " \"':;<=>@[]^`{}|/\\?#", true));
                        dy0Var.c = sb.toString();
                    }
                    i9 = iN + 1;
                    arrayList3 = arrayList2;
                    c2 = '#';
                    c = '?';
                }
            }
            int i13 = i9;
            arrayList = arrayList3;
            int i14 = i13;
            while (true) {
                if (i14 >= iN) {
                    i3 = iN;
                    break;
                }
                char cCharAt4 = str2.charAt(i14);
                if (cCharAt4 == '[') {
                    do {
                        i14++;
                        if (i14 >= iN) {
                            break;
                        }
                    } while (str2.charAt(i14) != ']');
                } else if (cCharAt4 == ':') {
                    i3 = i14;
                    break;
                }
                i14++;
            }
            int i15 = i3 + 1;
            if (i15 < iN) {
                dy0Var.d = no4.b(fl4.e(i13, i3, 4, str2));
                try {
                    i4 = Integer.parseInt(fl4.c(i15, iN, UCharacter.UnicodeBlock.SIDDHAM_ID, str2, "", false));
                    if (i2 > i4 || i4 >= 65536) {
                        i4 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                dy0Var.e = i4;
                if (i4 == -1) {
                    dk0.m(str2.substring(i15, iN), "Invalid URL port: \"");
                    return;
                }
            } else {
                dy0Var.d = no4.b(fl4.e(i13, i3, 4, str2));
                String str3 = dy0Var.a;
                str3.getClass();
                if (str3.equals("http")) {
                    i5 = 80;
                } else if (str3.equals("https")) {
                    i5 = 443;
                }
                dy0Var.e = i5;
            }
            if (dy0Var.d == null) {
                dk0.m(str2.substring(i13, i3), "Invalid URL host: \"");
                return;
            }
        } else {
            dy0Var.b = ey0Var.e();
            dy0Var.c = ey0Var.a();
            dy0Var.d = ey0Var.d;
            dy0Var.e = ey0Var.e;
            arrayList3.clear();
            arrayList3.addAll(ey0Var.c());
            if (iN == iO || str2.charAt(iN) == '#') {
                String strD = ey0Var.d();
                dy0Var.g = strD != null ? fl4.j(fl4.c(0, 0, 211, strD, " \"'<>#", true)) : null;
            }
            arrayList = arrayList3;
        }
        int iG = z53.g(str2, iN, iO, "?#");
        if (iN != iG) {
            char cCharAt5 = str2.charAt(iN);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                ArrayList arrayList4 = arrayList;
                arrayList4.clear();
                arrayList4.add("");
                iN++;
            } else {
                arrayList.set(arrayList.size() - 1, "");
            }
            while (iN < iG) {
                int iG2 = z53.g(str2, iN, iG, "/\\");
                boolean z = iG2 < iG;
                String str4 = str2;
                dy0Var.e(str4, iN, iG2, z, true);
                dy0 dy0Var2 = dy0Var;
                str2 = str4;
                iN = z ? iG2 + 1 : iG2;
                dy0Var = dy0Var2;
            }
        }
        dy0 dy0Var3 = dy0Var;
        if (iG < iO && str2.charAt(iG) == '?') {
            int iF2 = z53.f(str2, '#', iG, iO);
            str2 = str;
            dy0Var3.g = fl4.j(fl4.c(iG + 1, iF2, 208, str, " \"'<>#", true));
            iG = iF2;
        }
        if (iG >= iO || str2.charAt(iG) != '#') {
            return;
        }
        dy0Var3.h = fl4.c(iG + 1, iO, 176, str, "", true);
    }

    public final void e(String str, int i, int i2, boolean z, boolean z2) {
        String strC = fl4.c(i, i2, 240, str, " \"<>^`{}|/\\?#", z2);
        if (strC.equals(".") || strC.equalsIgnoreCase("%2e")) {
            return;
        }
        boolean zEquals = strC.equals("..");
        ArrayList arrayList = this.f;
        if (zEquals || strC.equalsIgnoreCase("%2e.") || strC.equalsIgnoreCase(".%2e") || strC.equalsIgnoreCase("%2e%2e")) {
            if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                arrayList.add("");
                return;
            } else {
                arrayList.set(arrayList.size() - 1, "");
                return;
            }
        }
        if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
            arrayList.set(arrayList.size() - 1, strC);
        } else {
            arrayList.add(strC);
        }
        if (z) {
            arrayList.add("");
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (this.b.length() > 0 || this.c.length() > 0) {
            sb.append(this.b);
            if (this.c.length() > 0) {
                sb.append(':');
                sb.append(this.c);
            }
            sb.append('@');
        }
        String str2 = this.d;
        if (str2 != null) {
            if (cs2.o(str2, ':')) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
        }
        int i = -1;
        if (this.e != -1 || this.a != null) {
            int iC = c();
            String str3 = this.a;
            if (str3 == null) {
                sb.append(':');
                sb.append(iC);
            } else {
                if (str3.equals("http")) {
                    i = 80;
                } else if (str3.equals("https")) {
                    i = 443;
                }
                if (iC != i) {
                    sb.append(':');
                    sb.append(iC);
                }
            }
        }
        ArrayList arrayList = this.f;
        arrayList.getClass();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append((String) arrayList.get(i2));
        }
        if (this.g != null) {
            sb.append('?');
            ArrayList arrayList2 = this.g;
            arrayList2.getClass();
            f21 f21VarE = ky3.e(ky3.f(0, arrayList2.size()), 2);
            int i3 = f21VarE.a;
            int i4 = f21VarE.b;
            int i5 = f21VarE.c;
            if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                while (true) {
                    String str4 = (String) arrayList2.get(i3);
                    String str5 = (String) arrayList2.get(i3 + 1);
                    if (i3 > 0) {
                        sb.append('&');
                    }
                    sb.append(str4);
                    if (str5 != null) {
                        sb.append('=');
                        sb.append(str5);
                    }
                    if (i3 == i4) {
                        break;
                    }
                    i3 += i5;
                }
            }
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
