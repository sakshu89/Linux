package defpackage;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.Transliterator;
import com.ibm.icu.text.UnicodeSet;
import java.net.IDN;
import java.net.URI;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n61 {
    public static final n61 a = new n61();
    public static final Object b = new Object();
    public static final cv2 c = new cv2(new e4(15));
    public static final cv2 d = new cv2(new e4(16));
    public static final cv2 e = new cv2(new e4(17));
    public static final cv2 f = new cv2(new e4(18));
    public static final x42 g = new x42("(?:https?://|www\\.)[^\\s<>\"']+|[\\p{L}\\p{M}\\p{N}._%+\\-]+@[\\p{L}\\p{M}\\p{N}.\\-]+\\.[\\p{L}\\p{M}]{2,}", y42.IGNORE_CASE);
    public static final Set h = wh2.c(10, 4, 15, 16, 36, 35, 21, 26, 31);
    public static final Set i = wh2.c(10, 15, 16);

    public static boolean a(int i2) {
        return wh2.c(6, 8, 7).contains(Integer.valueOf(UCharacter.getType(i2)));
    }

    public static boolean b(int i2) {
        int script = UScript.getScript(i2);
        return (UCharacter.isLetter(i2) && script != 25) || (a(i2) && ((1536 <= i2 && i2 < 1792) || !wh2.c(25, 0, 1).contains(Integer.valueOf(script))));
    }

    public static String c(String str) {
        return js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(js2.i(str, "ٳ", "اٟ"), "اٟ", "ü"), "ٲ", "ạ̄"), "ۄ", "ọ"), "ۆ", "ö"), "ؠ", DateFormat.YEAR), "ٟ", "ü"), "ٖ", "ī"), "ٗ", "ū"), "ں", "n");
    }

    /* JADX WARN: Code duplicated, block: B:214:0x032b  */
    /* JADX WARN: Code duplicated, block: B:215:0x032e  */
    /* JADX WARN: Code duplicated, block: B:219:0x034d A[Catch: all -> 0x0369, TryCatch #0 {all -> 0x0369, blocks: (B:217:0x0331, B:219:0x034d, B:222:0x036c), top: B:287:0x0331 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:237:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:240:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:242:0x041a  */
    /* JADX WARN: Code duplicated, block: B:247:0x0436  */
    /* JADX WARN: Code duplicated, block: B:249:0x0441  */
    /* JADX WARN: Code duplicated, block: B:251:0x0447  */
    /* JADX WARN: Code duplicated, block: B:253:0x046d  */
    /* JADX WARN: Code duplicated, block: B:259:0x0496  */
    /* JADX WARN: Code duplicated, block: B:260:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:287:0x0331 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String e(String str) {
        String str2;
        int i2;
        int i3;
        String string;
        String strTransliterate;
        String strTransliterate2;
        String strQ;
        int iCodePointBefore;
        int i4;
        String str3;
        int script;
        StringBuilder sb = new StringBuilder(str.length());
        int i5 = 0;
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!UCharacter.isDigit(iCodePointAt) || (48 <= iCodePointAt && iCodePointAt < 58)) {
                if (b(iCodePointAt)) {
                    int script2 = UScript.getScript(iCodePointAt);
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    while (true) {
                        i2 = 1;
                        if (iCharCount2 < str.length()) {
                            int iCodePointAt2 = str.codePointAt(iCharCount2);
                            int iCharCount3 = Character.charCount(iCodePointAt2) + iCharCount2;
                            int i6 = (wh2.c(8204, 8205).contains(Integer.valueOf(iCodePointAt2)) && iCharCount3 < str.length() && b(str.codePointAt(iCharCount3))) ? 1 : i5;
                            if ((b(iCodePointAt2) || a(iCodePointAt2) || i6 != 0) && !UCharacter.isDigit(iCodePointAt2) && ((script = UScript.getScript(iCodePointAt2)) == script2 || script == 1 || script == 0)) {
                                iCharCount2 = iCharCount3;
                            }
                        }
                    }
                    n61 n61Var = a;
                    String strSubstring = str.substring(iCharCount, iCharCount2);
                    int script3 = UScript.getScript(strSubstring.codePointAt(i5));
                    String[] strArr = wz0.a;
                    if (script3 != 109) {
                        if (script3 != 115) {
                            i3 = 1;
                            strTransliterate = null;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            int length = strSubstring.length();
                            int i7 = i5;
                            int length2 = i7;
                            int i8 = length2;
                            int length3 = -1;
                            while (i7 < length) {
                                char cCharAt = strSubstring.charAt(i7);
                                int i9 = i2;
                                if ((43968 > cCharAt || cCharAt >= 43995) && (43744 > cCharAt || cCharAt >= 43755)) {
                                    if (43995 <= cCharAt && cCharAt < 44003) {
                                        sb2.append(wz0.e[cCharAt - 43995]);
                                    } else if ((44003 <= cCharAt && cCharAt < 44010) || (43755 <= cCharAt && cCharAt < 43760)) {
                                        if (length3 < 0) {
                                            wz0.a();
                                            throw null;
                                        }
                                        sb2.deleteCharAt(length3);
                                        sb2.append((44003 > cCharAt || cCharAt >= 44010) ? wz0.h[cCharAt - 43755] : wz0.g[cCharAt - 44003]);
                                    } else if (cCharAt == 44013 || cCharAt == 43766) {
                                        if (length3 < 0) {
                                            wz0.a();
                                            throw null;
                                        }
                                        sb2.deleteCharAt(length3);
                                        i8 = i9;
                                    } else if (cCharAt == 44010 || cCharAt == 43765 || cCharAt == 44012) {
                                        if (sb2.length() == 0) {
                                            wz0.a();
                                            throw null;
                                        }
                                        sb2.append(cCharAt != 43765 ? cCharAt != 44010 ? "'" : "ng" : "h");
                                    } else if (cCharAt == 43762) {
                                        sb2.append("anji");
                                    } else if (cCharAt == 43763 || cCharAt == 43764) {
                                        if (sb2.length() == 0) {
                                            wz0.a();
                                            throw null;
                                        }
                                        String strSubstring2 = cCharAt == 43763 ? sb2.substring(length2) : sb2.toString();
                                        if (cCharAt == 43764) {
                                            sb2.append(' ');
                                        }
                                        sb2.append(strSubstring2);
                                    } else if (cCharAt != 8204 && cCharAt != 8205) {
                                        wz0.a();
                                        throw null;
                                    }
                                    length3 = -1;
                                } else {
                                    if (i8 == 0) {
                                        length2 = sb2.length();
                                    }
                                    if (cCharAt == 43744) {
                                        str3 = "e";
                                    } else if (cCharAt == 43745) {
                                        str3 = "o";
                                    } else {
                                        str3 = (43746 > cCharAt || cCharAt >= 43755) ? wz0.d[cCharAt - 43968] : wz0.f[cCharAt - 43746];
                                    }
                                    sb2.append(str3);
                                    if (wh2.c(43982, 43983, 43985, 43744, 43745).contains(Integer.valueOf(cCharAt))) {
                                        length3 = cCharAt == 43985 ? sb2.length() - 1 : -1;
                                    } else {
                                        length3 = sb2.length();
                                        sb2.append('a');
                                    }
                                    i8 = 0;
                                }
                                i7++;
                                i2 = i9;
                            }
                            i3 = i2;
                            string = sb2.toString();
                            if (string.length() == 0) {
                                wz0.a();
                                throw null;
                            }
                        }
                        if (strTransliterate == null) {
                            i5 = 0;
                        } else {
                            synchronized (b) {
                                try {
                                    strTransliterate2 = ((Transliterator) c.getValue()).transliterate(c(strSubstring));
                                    if (h.contains(Integer.valueOf(script3))) {
                                        strTransliterate2.getClass();
                                        strTransliterate2 = js2.i(js2.i(js2.i(strTransliterate2, "ś", "sh"), "ṣ", "sh"), "c", "ch");
                                    }
                                    strTransliterate2.getClass();
                                    strTransliterate = ((Transliterator) d.getValue()).transliterate(js2.i(js2.i(js2.i(strTransliterate2, "ʾ", "'"), "ʿ", "'"), "ʱ", "h"));
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i.contains(Integer.valueOf(script3))) {
                                iCodePointBefore = strSubstring.codePointBefore(strSubstring.length());
                                if (iCodePointBefore == 2364 && strSubstring.length() > (i4 = i3)) {
                                    iCodePointBefore = strSubstring.codePointBefore(strSubstring.length() - i4);
                                }
                                if (strSubstring.codePoints().filter(new te(2)).count() > 1 && ((UnicodeSet) e.getValue()).contains(iCodePointBefore)) {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'a')) {
                                        strTransliterate = cs2.q(strTransliterate);
                                    }
                                }
                            }
                            if (script3 == 10) {
                                if (wh2.c("झालं", "झाल", "झाला", "झाली", "झाले", "झाल्या", "माझा", "माझी", "माझे", "माझं", "माझ्या").contains(strSubstring)) {
                                    strTransliterate.getClass();
                                    strTransliterate = js2.i(strTransliterate, "jh", "zh");
                                }
                                i5 = 0;
                                if (!js2.e(strSubstring, "लं", false) || js2.e(strSubstring, "ळं", false)) {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'm')) {
                                        strQ = cs2.q(strTransliterate);
                                    } else if (wh2.c(2305, 2306).contains(Integer.valueOf(strSubstring.codePointBefore(strSubstring.length()))) && strSubstring.length() > 1 && ((UnicodeSet) f.getValue()).contains(strSubstring.codePointBefore(strSubstring.length() - 1))) {
                                        strTransliterate.getClass();
                                        if (cs2.s(strTransliterate, 'm')) {
                                            strQ = cs2.q(strTransliterate).concat("n");
                                        }
                                    }
                                    strTransliterate = strQ;
                                } else if (wh2.c(2305, 2306).contains(Integer.valueOf(strSubstring.codePointBefore(strSubstring.length())))) {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'm')) {
                                        strQ = cs2.q(strTransliterate).concat("n");
                                        strTransliterate = strQ;
                                    }
                                }
                            } else {
                                i5 = 0;
                            }
                            strTransliterate.getClass();
                            if (!cs2.A(strTransliterate) || strTransliterate.codePoints().anyMatch(new te(n61Var))) {
                                throw new g53("This script cannot be fully written in Latin letters. Please provide its Roman spelling.");
                            }
                        }
                        sb.append(strTransliterate);
                        iCharCount = iCharCount2;
                    } else {
                        i3 = 1;
                        Map map = wz0.c;
                        StringBuilder sb3 = new StringBuilder();
                        int length4 = strSubstring.length();
                        int length5 = -1;
                        for (int i10 = 0; i10 < length4; i10++) {
                            char cCharAt2 = strSubstring.charAt(i10);
                            if (7258 > cCharAt2 || cCharAt2 >= 7288) {
                                if (cCharAt2 == 7288 || cCharAt2 == 7290) {
                                    if (length5 < 0) {
                                        wz0.a();
                                        throw null;
                                    }
                                    sb3.append('n');
                                } else if (cCharAt2 == 7289) {
                                    if (length5 < 0) {
                                        wz0.a();
                                        throw null;
                                    }
                                } else if (cCharAt2 == 7291) {
                                    if (length5 < 0) {
                                        wz0.a();
                                        throw null;
                                    }
                                    sb3.insert(length5 + 1, sb3.charAt(length5));
                                } else if (cCharAt2 == 7292 || cCharAt2 == 7293) {
                                    Character chU = cs2.u(i10 - 1, strSubstring);
                                    if (!map.containsKey(chU != null ? Integer.valueOf(chU.charValue()) : null)) {
                                        wz0.a();
                                        throw null;
                                    }
                                } else if (cCharAt2 != 8204 && cCharAt2 != 8205) {
                                    wz0.a();
                                    throw null;
                                }
                            } else {
                                Character chU2 = cs2.u(i10 + 1, strSubstring);
                                Integer numValueOf = chU2 != null ? Integer.valueOf(chU2.charValue()) : null;
                                String str4 = (String) map.get(Integer.valueOf(cCharAt2));
                                if (str4 == null || (numValueOf != null && numValueOf.intValue() != 7292)) {
                                    str4 = wz0.a[cCharAt2 - 7258];
                                }
                                length5 = wz0.b.contains(Integer.valueOf(cCharAt2)) ? sb3.length() : -1;
                                sb3.append(str4);
                            }
                        }
                        string = sb3.toString();
                        if (string.length() == 0) {
                            wz0.a();
                            throw null;
                        }
                    }
                    strTransliterate = string;
                    if (strTransliterate == null) {
                        synchronized (b) {
                            strTransliterate2 = ((Transliterator) c.getValue()).transliterate(c(strSubstring));
                            if (h.contains(Integer.valueOf(script3))) {
                                strTransliterate2.getClass();
                                strTransliterate2 = js2.i(js2.i(js2.i(strTransliterate2, "ś", "sh"), "ṣ", "sh"), "c", "ch");
                            }
                            strTransliterate2.getClass();
                            strTransliterate = ((Transliterator) d.getValue()).transliterate(js2.i(js2.i(js2.i(strTransliterate2, "ʾ", "'"), "ʿ", "'"), "ʱ", "h"));
                            if (i.contains(Integer.valueOf(script3))) {
                                iCodePointBefore = strSubstring.codePointBefore(strSubstring.length());
                                if (iCodePointBefore == 2364) {
                                    iCodePointBefore = strSubstring.codePointBefore(strSubstring.length() - i4);
                                }
                                if (strSubstring.codePoints().filter(new te(2)).count() > 1) {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'a')) {
                                        strTransliterate = cs2.q(strTransliterate);
                                    }
                                }
                            }
                            if (script3 == 10) {
                                if (wh2.c("झालं", "झाल", "झाला", "झाली", "झाले", "झाल्या", "माझा", "माझी", "माझे", "माझं", "माझ्या").contains(strSubstring)) {
                                    strTransliterate.getClass();
                                    strTransliterate = js2.i(strTransliterate, "jh", "zh");
                                }
                                i5 = 0;
                                if (js2.e(strSubstring, "लं", false)) {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'm')) {
                                        strQ = cs2.q(strTransliterate);
                                    } else if (wh2.c(2305, 2306).contains(Integer.valueOf(strSubstring.codePointBefore(strSubstring.length())))) {
                                        strTransliterate.getClass();
                                        if (cs2.s(strTransliterate, 'm')) {
                                            strQ = cs2.q(strTransliterate).concat("n");
                                        }
                                    }
                                } else {
                                    strTransliterate.getClass();
                                    if (cs2.s(strTransliterate, 'm')) {
                                        strQ = cs2.q(strTransliterate);
                                    } else if (wh2.c(2305, 2306).contains(Integer.valueOf(strSubstring.codePointBefore(strSubstring.length())))) {
                                        strTransliterate.getClass();
                                        if (cs2.s(strTransliterate, 'm')) {
                                            strQ = cs2.q(strTransliterate).concat("n");
                                        }
                                    }
                                }
                                strTransliterate = strQ;
                            } else {
                                i5 = 0;
                            }
                            strTransliterate.getClass();
                            if (!cs2.A(strTransliterate)) {
                            }
                            throw new g53("This script cannot be fully written in Latin letters. Please provide its Roman spelling.");
                        }
                    }
                    i5 = 0;
                    sb.append(strTransliterate);
                    iCharCount = iCharCount2;
                } else {
                    switch (iCodePointAt) {
                        case 1548:
                        case 1644:
                            str2 = ",";
                            break;
                        case 1563:
                            str2 = ";";
                            break;
                        case 1567:
                        case 43761:
                            str2 = "?";
                            break;
                        case 1642:
                            str2 = "%";
                            break;
                        case 1643:
                        case 1748:
                        case 2404:
                        case 2405:
                        case 7294:
                        case 7295:
                        case 43760:
                        case 44011:
                            str2 = ".";
                            break;
                        default:
                            str2 = null;
                            break;
                    }
                    if (str2 == null) {
                        char[] chars = Character.toChars(iCodePointAt);
                        chars.getClass();
                        str2 = new String(chars);
                    }
                    sb.append(str2);
                }
                i5 = i5;
            } else {
                sb.append(UCharacter.digit(iCodePointAt));
            }
            iCharCount += Character.charCount(iCodePointAt);
            i5 = i5;
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    public final String d(String str) {
        Object r16;
        str.getClass();
        var r3 = 1;
        if (!str.codePoints().anyMatch(new te(1))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        zt0 zt0Var = new zt0(x42.c(g, str));
        int i2 = 0;
        while (zt0Var.hasNext()) {
            fh1 fh1Var = (fh1) zt0Var.next();
            sb.append(e(str.substring(i2, fh1Var.b().a)));
            String strC = fh1Var.c();
            if (strC.codePoints().anyMatch(new te((int) r3))) {
                try {
                    if (!cs2.o(strC, '@') || cs2.n(strC, "://", false) || js2.k(strC, "www.", r3)) {
                        boolean zK = js2.k(strC, "www.", r3);
                        if (zK) {
                            strC = "https://".concat(strC);
                        }
                        String rawAuthority = new URI(strC).getRawAuthority();
                        if (rawAuthority == null) {
                            throw new g53("This address needs its exact Latin spelling.");
                        }
                        r16 = r3;
                        int iC = cs2.C(rawAuthority, '@', 0, 6);
                        String strConcat = cs2.o(rawAuthority, '@') ? (iC == -1 ? "" : rawAuthority.substring(0, iC)).concat("@") : "";
                        String strS = cs2.S(rawAuthority, '@');
                        int iC2 = cs2.C(strS, ':', 0, 6);
                        Integer numValueOf = Integer.valueOf(iC2);
                        if (iC2 < 0 || cs2.Q(strS, '[')) {
                            numValueOf = null;
                        }
                        String strSubstring = numValueOf != null ? strS.substring(0, numValueOf.intValue()) : strS;
                        String strSubstring2 = numValueOf != null ? strS.substring(numValueOf.intValue()) : "";
                        if (!cs2.Q(strSubstring, '[')) {
                            strSubstring = IDN.toASCII(strSubstring);
                        }
                        int iY = cs2.y(strC, "://", 0, false, 6) + 3;
                        strC = new URI(cs2.K(strC, iY, strConcat + strSubstring + strSubstring2, rawAuthority.length() + iY).toString()).toASCIIString();
                        if (zK) {
                            strC.getClass();
                            strC = cs2.G(strC, "https://");
                        } else {
                            strC.getClass();
                        }
                    } else {
                        int iC3 = cs2.C(strC, '@', 0, 6);
                        String strSubstring3 = iC3 == -1 ? strC : strC.substring(0, iC3);
                        if (strSubstring3.codePoints().anyMatch(new te((int) r3))) {
                            throw new g53("This email address needs its exact Latin spelling.");
                        }
                        strC = strSubstring3 + "@" + IDN.toASCII(cs2.S(strC, '@'));
                        r16 = r3;
                    }
                } catch (g53 e2) {
                    throw e2;
                } catch (Exception unused) {
                    throw new g53("This address needs its exact Latin spelling.");
                }
            } else {
                r16 = r3;
            }
            sb.append(strC);
            i2 = fh1Var.b().b + 1;
            r3 = r16;
        }
        sb.append(e(str.substring(i2)));
        String string = sb.toString();
        if (string.codePoints().anyMatch(new te(this))) {
            throw new g53("This script cannot be fully written in Latin letters. Please provide its Roman spelling.");
        }
        return string;
    }
}
