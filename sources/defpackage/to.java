package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class to implements v21 {
    public static final to b = new to(1);
    public final /* synthetic */ int a;

    public /* synthetic */ to(int i) {
        this.a = i;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:106:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:109:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:112:0x0207  */
    /* JADX WARN: Code duplicated, block: B:113:0x020a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0212  */
    /* JADX WARN: Code duplicated, block: B:116:0x0215  */
    /* JADX WARN: Code duplicated, block: B:118:0x021d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0220  */
    /* JADX WARN: Code duplicated, block: B:121:0x0228  */
    /* JADX WARN: Code duplicated, block: B:122:0x0230  */
    /* JADX WARN: Code duplicated, block: B:124:0x0238  */
    /* JADX WARN: Code duplicated, block: B:125:0x023e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0247  */
    /* JADX WARN: Code duplicated, block: B:128:0x024a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0252  */
    /* JADX WARN: Code duplicated, block: B:131:0x0256  */
    /* JADX WARN: Code duplicated, block: B:133:0x025e  */
    /* JADX WARN: Code duplicated, block: B:215:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:65:0x012d A[LOOP:2: B:61:0x011e->B:65:0x012d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d0  */
    @Override // defpackage.v21
    public final z62 a(s32 s32Var) throws IOException {
        l11 l11Var;
        l11 l11Var2;
        int i;
        int i2;
        int length;
        int length2;
        l11 l11Var3;
        String string;
        int i3;
        String string2;
        boolean z = true;
        Object obj = null;
        switch (this.a) {
            case 0:
                System.currentTimeMillis();
                lj1 lj1Var = s32Var.e;
                l11 l11Var4 = new l11(6, lj1Var, obj);
                qo qoVar = (qo) lj1Var.g;
                if (qoVar == null) {
                    int i4 = qo.n;
                    ew0 ew0Var = (ew0) lj1Var.d;
                    int size = ew0Var.size();
                    int i5 = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = false;
                    boolean z5 = false;
                    boolean z6 = false;
                    boolean z7 = false;
                    boolean z8 = false;
                    boolean z9 = false;
                    boolean z10 = true;
                    String str = null;
                    int iY = -1;
                    int iY2 = -1;
                    int iY3 = -1;
                    int iY4 = -1;
                    while (i5 < size) {
                        boolean z11 = z;
                        String strB = ew0Var.b(i5);
                        String strF = ew0Var.f(i5);
                        if (js2.f(strB, "Cache-Control")) {
                            if (str == null) {
                                str = strF;
                            }
                            i2 = 0;
                            while (i2 < strF.length()) {
                                length = strF.length();
                                length2 = i2;
                                while (true) {
                                    if (length2 < length) {
                                        l11Var3 = l11Var4;
                                        if (cs2.o("=,;", strF.charAt(length2))) {
                                            length2++;
                                            l11Var4 = l11Var3;
                                        }
                                    } else {
                                        l11Var3 = l11Var4;
                                        length2 = strF.length();
                                    }
                                }
                                string = cs2.V(strF.substring(i2, length2)).toString();
                                if (length2 != strF.length() || strF.charAt(length2) == ',' || strF.charAt(length2) == ';') {
                                    i3 = length2 + 1;
                                    string2 = null;
                                } else {
                                    int length3 = length2 + 1;
                                    byte[] bArr = z53.a;
                                    int length4 = strF.length();
                                    while (true) {
                                        if (length3 >= length4) {
                                            length3 = strF.length();
                                        } else {
                                            char cCharAt = strF.charAt(length3);
                                            if (cCharAt == ' ' || cCharAt == '\t') {
                                                length3++;
                                            }
                                        }
                                    }
                                    if (length3 >= strF.length() || strF.charAt(length3) != '\"') {
                                        int length5 = strF.length();
                                        int length6 = length3;
                                        while (true) {
                                            if (length6 < length5) {
                                                int i6 = length5;
                                                if (!cs2.o(",;", strF.charAt(length6))) {
                                                    length6++;
                                                    length5 = i6;
                                                }
                                            } else {
                                                length6 = strF.length();
                                            }
                                        }
                                        string2 = cs2.V(strF.substring(length3, length6)).toString();
                                        i3 = length6;
                                    } else {
                                        int i7 = length3 + 1;
                                        int iX = cs2.x(strF, '\"', i7, 4);
                                        String strSubstring = strF.substring(i7, iX);
                                        i3 = iX + 1;
                                        string2 = strSubstring;
                                    }
                                }
                                if ("no-cache".equalsIgnoreCase(string)) {
                                    z2 = z11;
                                } else if ("no-store".equalsIgnoreCase(string)) {
                                    z3 = z11;
                                } else if ("max-age".equalsIgnoreCase(string)) {
                                    iY = z53.y(-1, string2);
                                } else if ("s-maxage".equalsIgnoreCase(string)) {
                                    iY2 = z53.y(-1, string2);
                                } else if ("private".equalsIgnoreCase(string)) {
                                    z4 = z11;
                                } else if ("public".equalsIgnoreCase(string)) {
                                    z5 = z11;
                                } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                    z6 = z11;
                                } else if ("max-stale".equalsIgnoreCase(string)) {
                                    iY3 = z53.y(Integer.MAX_VALUE, string2);
                                } else if ("min-fresh".equalsIgnoreCase(string)) {
                                    iY4 = z53.y(-1, string2);
                                } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                    z7 = z11;
                                } else if ("no-transform".equalsIgnoreCase(string)) {
                                    z8 = z11;
                                } else if ("immutable".equalsIgnoreCase(string)) {
                                    z9 = z11;
                                }
                                i2 = i3;
                                l11Var4 = l11Var3;
                            }
                            i5++;
                            z = z11;
                            l11Var4 = l11Var4;
                        } else {
                            if (js2.f(strB, "Pragma")) {
                            }
                            i5++;
                            z = z11;
                            l11Var4 = l11Var4;
                        }
                        z10 = false;
                        i2 = 0;
                        while (i2 < strF.length()) {
                            length = strF.length();
                            length2 = i2;
                            while (true) {
                                if (length2 < length) {
                                    l11Var3 = l11Var4;
                                    if (cs2.o("=,;", strF.charAt(length2))) {
                                        length2++;
                                        l11Var4 = l11Var3;
                                    }
                                } else {
                                    l11Var3 = l11Var4;
                                    length2 = strF.length();
                                }
                            }
                            string = cs2.V(strF.substring(i2, length2)).toString();
                            if (length2 != strF.length()) {
                                i3 = length2 + 1;
                                string2 = null;
                            } else {
                                i3 = length2 + 1;
                                string2 = null;
                            }
                            if ("no-cache".equalsIgnoreCase(string)) {
                                z2 = z11;
                            } else if ("no-store".equalsIgnoreCase(string)) {
                                z3 = z11;
                            } else if ("max-age".equalsIgnoreCase(string)) {
                                iY = z53.y(-1, string2);
                            } else if ("s-maxage".equalsIgnoreCase(string)) {
                                iY2 = z53.y(-1, string2);
                            } else if ("private".equalsIgnoreCase(string)) {
                                z4 = z11;
                            } else if ("public".equalsIgnoreCase(string)) {
                                z5 = z11;
                            } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                z6 = z11;
                            } else if ("max-stale".equalsIgnoreCase(string)) {
                                iY3 = z53.y(Integer.MAX_VALUE, string2);
                            } else if ("min-fresh".equalsIgnoreCase(string)) {
                                iY4 = z53.y(-1, string2);
                            } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                z7 = z11;
                            } else if ("no-transform".equalsIgnoreCase(string)) {
                                z8 = z11;
                            } else if ("immutable".equalsIgnoreCase(string)) {
                                z9 = z11;
                            }
                            i2 = i3;
                            l11Var4 = l11Var3;
                        }
                        i5++;
                        z = z11;
                        l11Var4 = l11Var4;
                    }
                    l11Var = l11Var4;
                    qoVar = new qo(z2, z3, iY, iY2, z4, z5, z6, iY3, iY4, z7, z8, z9, !z10 ? null : str);
                    lj1Var.g = qoVar;
                } else {
                    l11Var = l11Var4;
                }
                if (qoVar.j) {
                    Object obj2 = null;
                    l11Var2 = new l11(6, obj2, obj2);
                } else {
                    l11Var2 = l11Var;
                }
                lj1 lj1Var2 = (lj1) l11Var2.b;
                z62 z62Var = (z62) l11Var2.c;
                if (lj1Var2 == null && z62Var == null) {
                    return new z62(lj1Var, y12.HTTP_1_1, "Unsatisfiable Request (only-if-cached)", 504, null, new ew0((String[]) new ArrayList(20).toArray(new String[0])), z53.c, null, null, null, -1L, System.currentTimeMillis(), null);
                }
                if (lj1Var2 == null) {
                    z62Var.getClass();
                    y62 y62VarE = z62Var.e();
                    z62 z62VarC = xy.c(z62Var);
                    y62.b(z62VarC, "cacheResponse");
                    y62VarE.i = z62VarC;
                    return y62VarE.a();
                }
                z62 z62VarB = s32Var.b(lj1Var2);
                if (z62Var != null) {
                    if (z62VarB.e == 304) {
                        y62 y62VarE2 = z62Var.e();
                        ew0 ew0Var2 = z62Var.i;
                        ew0 ew0Var3 = z62VarB.i;
                        ArrayList arrayList = new ArrayList(20);
                        int i8 = 0;
                        for (int size2 = ew0Var2.size(); i8 < size2; size2 = i) {
                            String strB2 = ew0Var2.b(i8);
                            String strF2 = ew0Var2.f(i8);
                            if ("Warning".equalsIgnoreCase(strB2)) {
                                i = size2;
                                if (js2.k(strF2, "1", false)) {
                                }
                                i8++;
                            } else {
                                i = size2;
                            }
                            if ("Content-Length".equalsIgnoreCase(strB2) || "Content-Encoding".equalsIgnoreCase(strB2) || "Content-Type".equalsIgnoreCase(strB2) || !xy.p(strB2) || ew0Var3.a(strB2) == null) {
                                strB2.getClass();
                                strF2.getClass();
                                arrayList.add(strB2);
                                arrayList.add(cs2.V(strF2).toString());
                            }
                            i8++;
                        }
                        int size3 = ew0Var3.size();
                        for (int i9 = 0; i9 < size3; i9++) {
                            String strB3 = ew0Var3.b(i9);
                            if (!"Content-Length".equalsIgnoreCase(strB3) && !"Content-Encoding".equalsIgnoreCase(strB3) && !"Content-Type".equalsIgnoreCase(strB3) && xy.p(strB3)) {
                                String strF3 = ew0Var3.f(i9);
                                strB3.getClass();
                                strF3.getClass();
                                arrayList.add(strB3);
                                arrayList.add(cs2.V(strF3).toString());
                            }
                        }
                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                        uf1 uf1Var = new uf1(22);
                        ArrayList arrayList2 = (ArrayList) uf1Var.b;
                        arrayList2.getClass();
                        strArr.getClass();
                        List listAsList = Arrays.asList(strArr);
                        listAsList.getClass();
                        arrayList2.addAll(listAsList);
                        y62VarE2.f = uf1Var;
                        y62VarE2.k = z62VarB.t;
                        y62VarE2.l = z62VarB.u;
                        z62 z62VarC2 = xy.c(z62Var);
                        y62.b(z62VarC2, "cacheResponse");
                        y62VarE2.i = z62VarC2;
                        z62 z62VarC3 = xy.c(z62VarB);
                        y62.b(z62VarC3, "networkResponse");
                        y62VarE2.h = z62VarC3;
                        y62VarE2.a();
                        b72 b72Var = z62VarB.j;
                        b72Var.getClass();
                        b72Var.close();
                        throw null;
                    }
                    b72 b72Var2 = z62Var.j;
                    if (b72Var2 != null) {
                        z53.d(b72Var2);
                    }
                }
                y62 y62VarE3 = z62VarB.e();
                z62 z62VarC4 = xy.c(z62Var);
                y62.b(z62VarC4, "cacheResponse");
                y62VarE3.i = z62VarC4;
                z62 z62VarC5 = xy.c(z62VarB);
                y62.b(z62VarC5, "networkResponse");
                y62VarE3.h = z62VarC5;
                return y62VarE3.a();
            default:
                m32 m32Var = s32Var.a;
                synchronized (m32Var) {
                    try {
                        if (!m32Var.w) {
                            throw new IllegalStateException("released");
                        }
                        if (m32Var.v) {
                            throw new IllegalStateException("Check failed.");
                        }
                        if (m32Var.u) {
                            throw new IllegalStateException("Check failed.");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                sj0 sj0Var = m32Var.k;
                sj0Var.getClass();
                rp1 rp1Var = m32Var.a;
                try {
                    rj0 rj0VarJ = sj0Var.a(s32Var.f, s32Var.g, s32Var.h, rp1Var.i0, rp1Var.i, !g31.a((String) s32Var.e.c, "GET")).j(rp1Var, s32Var);
                    sj0Var.getClass();
                    ux uxVar = new ux();
                    uxVar.b = m32Var;
                    uxVar.c = sj0Var;
                    uxVar.d = rj0VarJ;
                    uxVar.e = rj0VarJ.h();
                    m32Var.t = uxVar;
                    m32Var.H = uxVar;
                    synchronized (m32Var) {
                        m32Var.u = true;
                        m32Var.v = true;
                    }
                    if (!m32Var.x) {
                        return s32.a(s32Var, 0, uxVar, null, 61).b(s32Var.e);
                    }
                    dk0.h("Canceled");
                    return null;
                } catch (IOException e) {
                    sj0Var.b(e);
                    throw new w82(e);
                } catch (w82 e2) {
                    sj0Var.b(e2.b);
                    throw e2;
                }
        }
    }
}
