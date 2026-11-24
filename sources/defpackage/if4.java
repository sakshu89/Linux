package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class if4 {
    public static String a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (cs2.o("\"'“”‘’«»", str.charAt(i))) {
                return null;
            }
        }
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        Pattern patternCompile = Pattern.compile("[,!.?:;—-]+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        String string = cs2.V(strReplaceAll).toString();
        Pattern patternCompile2 = Pattern.compile("\\s+");
        patternCompile2.getClass();
        string.getClass();
        String strReplaceAll2 = patternCompile2.matcher(string).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll2.getClass();
        return strReplaceAll2;
    }

    public static boolean b(String str) {
        str.getClass();
        String strA = a(str);
        if (strA == null) {
            return false;
        }
        return strA.equals("wake up sonic") || strA.equals("sonic wake up");
    }

    public static final Object c(ko0 ko0Var, int i, hq0 hq0Var) {
        int i2;
        int i3;
        Object objJ;
        dk1 dk1VarB;
        p81 p81VarM0;
        int i4;
        zn1 zn1Var;
        if (!ko0Var.a.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var = ko0Var.a.f;
        n71 n71VarG = cm4.g(ko0Var);
        loop0: while (true) {
            i2 = 0;
            i3 = 1;
            objJ = null;
            if (n71VarG == null) {
                dk1VarB = null;
                break;
            }
            if ((n71VarG.o0.f.e & 1024) != 0) {
                while (dk1Var != null) {
                    if ((dk1Var.c & 1024) != 0) {
                        dk1VarB = dk1Var;
                        pm1 pm1Var = null;
                        while (dk1VarB != null) {
                            if (dk1VarB instanceof ko0) {
                                break loop0;
                            }
                            if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                int i5 = 0;
                                for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                    if ((dk1Var2.c & 1024) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            dk1VarB = dk1Var2;
                                        } else {
                                            if (pm1Var == null) {
                                                pm1Var = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB != null) {
                                                pm1Var.b(dk1VarB);
                                                dk1VarB = null;
                                            }
                                            pm1Var.b(dk1Var2);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            dk1VarB = cm4.b(pm1Var);
                        }
                    }
                    dk1Var = dk1Var.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
        ko0 ko0Var2 = (ko0) dk1VarB;
        if ((ko0Var2 == null || !g31.a(ko0Var2.M0(), ko0Var.M0())) && (p81VarM0 = ko0Var.M0()) != null) {
            int i6 = 5;
            if (i != 5) {
                i6 = 6;
                if (i != 6) {
                    i6 = 3;
                    if (i != 3) {
                        i6 = 4;
                        if (i != 4) {
                            if (i == 1) {
                                i6 = 2;
                            } else if (i == 2) {
                                i6 = 1;
                            } else {
                                og.n("Unsupported direction for beyond bounds layout");
                            }
                        }
                    }
                }
            }
            if (p81VarM0.x.a.i().n <= 0 || p81VarM0.x.a.i().k.isEmpty() || !p81VarM0.w) {
                return hq0Var.j(p81.Y);
            }
            boolean zJ0 = p81VarM0.J0(i6);
            p91 p91Var = p81VarM0.x;
            int iMin = zJ0 ? Math.min(p91Var.a.i().n - 1, ((y91) mz.D(p91Var.a.i().k)).a) : Math.max(0, p91Var.a.g());
            t42 t42Var = new t42();
            tm tmVar = p81VarM0.H;
            tmVar.getClass();
            l81 l81Var = new l81(iMin, iMin);
            tmVar.a.b(l81Var);
            t42Var.a = l81Var;
            ea1 ea1Var = p81VarM0.x.a;
            if (ea1Var.i().k.isEmpty()) {
                i3 = 0;
            } else {
                x91 x91VarI = ea1Var.i();
                int iG = (int) (x91VarI.o == js1.a ? x91VarI.g() & 4294967295L : x91VarI.g() >> 32);
                int iA = fq4.a(ea1Var.i());
                if (iA != 0 && (i4 = iG / iA) >= 1) {
                    i3 = i4;
                }
            }
            int i7 = i3 * 2;
            int i8 = p81VarM0.x.a.i().n;
            if (i7 > i8) {
                i7 = i8;
            }
            while (objJ == null && p81VarM0.I0((l81) t42Var.a, i6) && i2 < i7) {
                l81 l81Var2 = (l81) t42Var.a;
                int i9 = l81Var2.a;
                int i10 = l81Var2.b;
                if (p81VarM0.J0(i6)) {
                    i10++;
                } else {
                    i9--;
                }
                tm tmVar2 = p81VarM0.H;
                tmVar2.getClass();
                l81 l81Var3 = new l81(i9, i10);
                tmVar2.a.b(l81Var3);
                p81VarM0.H.a.k((l81) t42Var.a);
                t42Var.a = l81Var3;
                i2++;
                cm4.g(p81VarM0).k();
                objJ = hq0Var.j(new o81(p81VarM0, t42Var, i6));
            }
            p81VarM0.H.a.k((l81) t42Var.a);
            cm4.g(p81VarM0).k();
            return objJ;
        }
        return null;
    }
}
