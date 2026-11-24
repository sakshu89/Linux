package defpackage;

import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yz3 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r1.equals("short") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r1.equals("chat") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        return defpackage.cc2.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r1.equals("short video") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r1.equals("shorts") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return defpackage.cc2.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r1.equals("contact") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r1.equals("conversation") != false) goto L22;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.cc2 a(java.lang.String r1) {
        /*
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r1 = defpackage.cq.o(r0, r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -903148681: goto L4a;
                case -501063721: goto L41;
                case 3052376: goto L35;
                case 109413500: goto L2c;
                case 112202875: goto L20;
                case 740154499: goto L17;
                case 951526432: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L52
        Le:
            java.lang.String r0 = "contact"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L3e
            goto L52
        L17:
            java.lang.String r0 = "conversation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L52
            goto L3e
        L20:
            java.lang.String r0 = "video"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L29
            goto L52
        L29:
            cc2 r1 = defpackage.cc2.b
            return r1
        L2c:
            java.lang.String r0 = "short"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L55
            goto L52
        L35:
            java.lang.String r0 = "chat"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L3e
            goto L52
        L3e:
            cc2 r1 = defpackage.cc2.a
            return r1
        L41:
            java.lang.String r0 = "short video"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L55
            goto L52
        L4a:
            java.lang.String r0 = "shorts"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L55
        L52:
            cc2 r1 = defpackage.cc2.e
            return r1
        L55:
            cc2 r1 = defpackage.cc2.c
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yz3.a(java.lang.String):cc2");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006d  */
    public static dc2 b(String str) {
        String str2;
        String str3;
        String str4;
        str.getClass();
        String strG = cs2.G(cs2.Y(cs2.V(str).toString(), '.', '!', '?'), "the ");
        fh1 fh1VarB = x42.b(dc2.h, strG);
        if (fh1VarB == null || (str3 = (String) ((dh1) fh1VarB.a()).get(1)) == null) {
            str2 = null;
        } else {
            Locale locale = Locale.ROOT;
            String strO = cq.o(locale, str3, locale);
            int iHashCode = strO.hashCode();
            if (iHashCode != -1240244679) {
                if (iHashCode != -991745245) {
                    if (iHashCode == 1934780818 && strO.equals("whatsapp")) {
                        str4 = "com.whatsapp";
                    } else {
                        str4 = null;
                    }
                } else if (strO.equals("youtube")) {
                    str4 = "com.google.android.youtube";
                } else {
                    str4 = null;
                }
            } else if (strO.equals("google")) {
                str4 = "com.google.android.googlequicksearchbox";
            } else {
                str4 = null;
            }
            str2 = str4;
        }
        if (fh1VarB != null) {
            strG = cs2.V(strG.substring(0, fh1VarB.b().a)).toString();
        }
        fh1 fh1VarD = dc2.i.d(strG);
        if (fh1VarD != null) {
            Integer numC = c((String) ((dh1) fh1VarD.a()).get(1));
            if (numC != null) {
                return new dc2(a((String) ((dh1) fh1VarD.a()).get(2)), numC, null, str2, 4);
            }
        } else {
            fh1 fh1VarD2 = dc2.j.d(strG);
            if (fh1VarD2 != null) {
                Integer numC2 = c((String) ((dh1) fh1VarD2.a()).get(2));
                if (numC2 != null) {
                    return new dc2(a((String) ((dh1) fh1VarD2.a()).get(1)), numC2, null, str2, 4);
                }
            } else {
                fh1 fh1VarD3 = dc2.k.d(strG);
                if (fh1VarD3 == null) {
                    fh1 fh1VarD4 = dc2.m.d(strG);
                    if (fh1VarD4 != null) {
                        String string = cs2.V((String) ((dh1) fh1VarD4.a()).get(1)).toString();
                        Set set = dc2.f;
                        Locale locale2 = Locale.ROOT;
                        locale2.getClass();
                        String lowerCase = string.toLowerCase(locale2);
                        lowerCase.getClass();
                        if (!set.contains(lowerCase)) {
                            return new dc2(a((String) ((dh1) fh1VarD4.a()).get(2)), null, string, str2, 2);
                        }
                    }
                } else if (str2 != null || !dc2.l.e(strG)) {
                    return new dc2(a((String) ((dh1) fh1VarD3.a()).get(1)), null, cs2.V((String) ((dh1) fh1VarD3.a()).get(2)).toString(), str2, 2);
                }
            }
        }
        return null;
    }

    public static Integer c(String str) {
        Integer numL;
        int iIntValue;
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        if (wh2.c("top", "topmost").contains(strO)) {
            numL = 1;
        } else {
            int iIndexOf = dc2.e.indexOf(strO);
            Integer numValueOf = Integer.valueOf(iIndexOf);
            if (iIndexOf < 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                numL = Integer.valueOf(numValueOf.intValue() + 1);
            } else {
                Pattern patternCompile = Pattern.compile("(?:st|nd|rd|th)$");
                patternCompile.getClass();
                String strReplaceAll = patternCompile.matcher(strO).replaceAll("");
                strReplaceAll.getClass();
                numL = js2.l(10, strReplaceAll);
            }
        }
        if (numL == null || 1 > (iIntValue = numL.intValue()) || iIntValue >= 101) {
            return null;
        }
        return numL;
    }
}
