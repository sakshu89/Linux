package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cy0 {
    static {
        oo ooVar = oo.e;
        nr4.m("\"\\");
        nr4.m("\t ,=");
    }

    public static final boolean a(z62 z62Var) {
        if (g31.a((String) z62Var.a.c, "HEAD")) {
            return false;
        }
        int i = z62Var.e;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && z53.k(z62Var) == -1 && !"chunked".equalsIgnoreCase(z62.c(z62Var, "Transfer-Encoding"))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0202  */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    public static final void b(su0 su0Var, ey0 ey0Var, ew0 ew0Var) {
        int i;
        List list;
        j60 j60Var;
        long j;
        j60 j60Var2;
        String strSubstring;
        su0Var.getClass();
        ey0Var.getClass();
        ew0Var.getClass();
        if (su0Var == su0.e) {
            return;
        }
        Pattern pattern = j60.j;
        int size = ew0Var.size();
        int i2 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i2 >= size) {
                break;
            }
            if ("Set-Cookie".equalsIgnoreCase(ew0Var.b(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(ew0Var.f(i2));
            }
            i2++;
        }
        List listUnmodifiableList = ii0.a;
        if (arrayList != null) {
            List listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
            listUnmodifiableList2.getClass();
            list = listUnmodifiableList2;
        } else {
            list = listUnmodifiableList;
        }
        int size2 = list.size();
        int i3 = 0;
        ArrayList arrayList2 = null;
        while (i3 < size2) {
            String str = (String) list.get(i3);
            str.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            char c = ';';
            int iH = z53.h(str, ';', 0, 0, 6);
            char c2 = '=';
            int iH2 = z53.h(str, '=', 0, iH, i);
            if (iH2 == iH) {
                j60Var = null;
            } else {
                int iN = z53.n(0, iH2, str);
                String strSubstring2 = str.substring(iN, z53.o(iN, iH2, str));
                if (strSubstring2.length() != 0 && z53.m(strSubstring2) == -1) {
                    int iN2 = z53.n(iH2 + 1, iH, str);
                    String strSubstring3 = str.substring(iN2, z53.o(iN2, iH, str));
                    if (z53.m(strSubstring3) == -1) {
                        int i4 = iH + 1;
                        int length = str.length();
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        long j2 = -1;
                        long jB = 253402300799999L;
                        String strSubstring4 = null;
                        String str2 = null;
                        boolean z4 = true;
                        while (true) {
                            if (i4 >= length) {
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    long j3 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * 1000 : Long.MAX_VALUE);
                                    j = (j3 < jCurrentTimeMillis || j3 > 253402300799999L) ? 253402300799999L : j3;
                                } else {
                                    j = jB;
                                }
                                String str3 = ey0Var.d;
                                if (str2 != null) {
                                    if (!g31.a(str3, str2) && (!js2.e(str3, str2, false) || str3.charAt((str3.length() - str2.length()) - 1) != '.' || z53.f.e(str3))) {
                                        j60Var2 = null;
                                    }
                                    j60Var = j60Var2;
                                    break;
                                }
                                str2 = str3;
                                if (str3.length() == str2.length() || PublicSuffixDatabase.g.a(str2) != null) {
                                    if (strSubstring4 == null || !js2.k(strSubstring4, "/", false)) {
                                        String strB = ey0Var.b();
                                        int iC = cs2.C(strB, '/', 0, 6);
                                        strSubstring4 = iC != 0 ? strB.substring(0, iC) : "/";
                                    }
                                    j60Var2 = new j60(strSubstring2, strSubstring3, j, str2, strSubstring4, z3, z, z2, z4);
                                } else {
                                    j60Var2 = null;
                                }
                                j60Var = j60Var2;
                                break;
                            }
                            int iF = z53.f(str, c, i4, length);
                            int iF2 = z53.f(str, c2, i4, iF);
                            int iN3 = z53.n(i4, iF2, str);
                            String strSubstring5 = str.substring(iN3, z53.o(iN3, iF2, str));
                            if (iF2 < iF) {
                                int iN4 = z53.n(iF2 + 1, iF, str);
                                strSubstring = str.substring(iN4, z53.o(iN4, iF, str));
                            } else {
                                strSubstring = "";
                            }
                            if (strSubstring5.equalsIgnoreCase("expires")) {
                                try {
                                    jB = gl4.b(strSubstring.length(), strSubstring);
                                    z2 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (strSubstring5.equalsIgnoreCase("max-age")) {
                                try {
                                    j2 = Long.parseLong(strSubstring);
                                    if (j2 <= 0) {
                                        j2 = Long.MIN_VALUE;
                                    }
                                } catch (NumberFormatException e) {
                                    Pattern patternCompile = Pattern.compile("-?\\d+");
                                    patternCompile.getClass();
                                    if (!patternCompile.matcher(strSubstring).matches()) {
                                        throw e;
                                    }
                                    j2 = js2.k(strSubstring, LanguageTag.SEP, false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                }
                                z2 = true;
                            } else if (strSubstring5.equalsIgnoreCase("domain")) {
                                if (js2.e(strSubstring, ".", false)) {
                                    throw new IllegalArgumentException("Failed requirement.");
                                }
                                String strB2 = no4.b(cs2.G(strSubstring, "."));
                                if (strB2 == null) {
                                    throw new IllegalArgumentException();
                                }
                                str2 = strB2;
                                z4 = false;
                            } else if (strSubstring5.equalsIgnoreCase("path")) {
                                strSubstring4 = strSubstring;
                            } else if (strSubstring5.equalsIgnoreCase("secure")) {
                                z3 = true;
                            } else if (strSubstring5.equalsIgnoreCase("httponly")) {
                                z = true;
                            }
                            i4 = iF + 1;
                            c = ';';
                            c2 = '=';
                        }
                    } else {
                        j60Var = null;
                    }
                } else {
                    j60Var = null;
                }
            }
            if (j60Var != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(j60Var);
            }
            i3++;
            i = 2;
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            listUnmodifiableList.getClass();
        }
        listUnmodifiableList.isEmpty();
    }
}
