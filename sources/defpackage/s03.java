package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.PluralRules;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class s03 {
    public static final x42 a = new x42("(?<![\\d:.+-])\\b(\\d{1,2})(?:(?:[:.]\\s*|\\s+)(\\d{1,2}))?\\s*([ap])\\.?\\s*m\\b\\.?");
    public static final x42 b = new x42("(?<![\\d:.+-])\\b(\\d{1,2})(?:(?:[:.]\\s*|\\s+)(\\d{1,2}))?\\b(?![:.]\\d)");
    public static final x42 c = new x42("(?<![\\d.+-])(\\d+(?:\\.\\d+)?)\\s*(?:-\\s*)?(seconds?|secs?|minutes?|mins?|hours?|hrs?|ghante?|ghanta)\\b");
    public static final x42 d = new x42("\\b(morning|subah|sunrise|sakali|sakaali)\\b");
    public static final x42 e = new x42("\\b(evening|night|tonight|shaam|sham|raat|ratri|afternoon|sandhyakali|sayankali)\\b");
    public static final x42 f = new x42("\\b(night|tonight|raat|ratri)\\b");
    public static final Map g = bh1.c(new wt1("सोनिक", "sonic"), new wt1("सॉनिक", "sonic"), new wt1("अलार्म", "alarm"), new wt1("अलारम", "alarm"), new wt1("टाइमर", "timer"), new wt1("टायमर", "timer"), new wt1("सुबह", "morning"), new wt1("सकाळी", "morning"), new wt1("सकाळचा", "morning"), new wt1("सकाळच्या", "morning"), new wt1("संध्याकाळी", "evening"), new wt1("सायंकाळी", "evening"), new wt1("शाम", "evening"), new wt1("रात", "night"), new wt1("रात्री", "night"), new wt1("दोपहर", "afternoon"), new wt1("दुपारी", "afternoon"), new wt1("दुपारच्या", "afternoon"), new wt1("बजकर", "bajkar"), new wt1("वाजून", "vajun"), new wt1("बजे", "oclock"), new wt1("वाजता", "oclock"), new wt1("वाजताचा", "oclock"), new wt1("मिनट", "minutes"), new wt1("मिनिटे", "minutes"), new wt1("मिनिट", "minutes"), new wt1("सेकंड", "seconds"), new wt1("सेकंद", "seconds"), new wt1("घंटे", "hours"), new wt1("घंटा", "hour"), new wt1("तास", "hours"), new wt1("लगाओ", "set"), new wt1("लगा", "set"), new wt1("लगाना", "set"), new wt1("लाव", "set"), new wt1("लावा", "set"), new wt1("लावून", "set"), new wt1("सेट", "set"), new wt1("lagao", "set"), new wt1("laga", "set"), new wt1("lav", "set"), new wt1("lava", "set"), new wt1("laav", "set"), new wt1("lawa", "set"), new wt1("मुझे", "me"), new wt1("मला", "me"), new wt1("मेरे", "my"), new wt1("माझ्या", "my"), new wt1("एक", PluralRules.KEYWORD_ONE), new wt1("को", "ko"), new wt1("का", "ka"), new wt1("की", "ki"), new wt1("के", "ke"), new wt1("चा", "cha"), new wt1("ची", "chi"), new wt1("चे", "che"), new wt1("करो", "karo"), new wt1("कर", "kar"), new wt1("दो", "do"), new wt1("दे", "do"), new wt1("देना", "do"), new wt1("दीजिए", "do"), new wt1("कृपया", "please"), new wt1("बंद", "cancel"), new wt1("रद्द", "cancel"), new wt1("नहीं", "not"), new wt1("नाही", "not"), new wt1("नको", "not"), new wt1("नका", "not"), new wt1("मत", "not"), new wt1("साढ़े", "saadhe"), new wt1("साढे", "saadhe"), new wt1("साडे", "saadhe"), new wt1("सवा", "sava"), new wt1("पौने", "paune"), new wt1("पावणे", "paune"));
    public static final Map h = bh1.c(new wt1(PluralRules.KEYWORD_ZERO, 0), new wt1(PluralRules.KEYWORD_ONE, 1), new wt1(PluralRules.KEYWORD_TWO, 2), new wt1("three", 3), new wt1("four", 4), new wt1("five", 5), new wt1("six", 6), new wt1("seven", 7), new wt1("eight", 8), new wt1("nine", 9), new wt1("ten", 10), new wt1("eleven", 11), new wt1("twelve", 12), new wt1("thirteen", 13), new wt1("fourteen", 14), new wt1("fifteen", 15), new wt1("sixteen", 16), new wt1("seventeen", 17), new wt1("eighteen", 18), new wt1("nineteen", 19), new wt1("twenty", 20), new wt1("thirty", 30), new wt1("forty", 40), new wt1("fifty", 50), new wt1("sixty", 60), new wt1("seventy", 70), new wt1("eighty", 80), new wt1("ninety", 90), new wt1("ek", 1), new wt1("teen", 3), new wt1("char", 4), new wt1("paanch", 5), new wt1("panch", 5), new wt1("chhe", 6), new wt1("saat", 7), new wt1("sat", 7), new wt1("aath", 8), new wt1("nau", 9), new wt1("das", 10), new wt1("एक", 1), new wt1("दोन", 2), new wt1("तीन", 3), new wt1("चार", 4), new wt1("पांच", 5), new wt1("पाँच", 5), new wt1("पाच", 5), new wt1("छह", 6), new wt1("सहा", 6), new wt1("सात", 7), new wt1("आठ", 8), new wt1("नौ", 9), new wt1("नऊ", 9), new wt1("दस", 10), new wt1("दहा", 10), new wt1("ग्यारह", 11), new wt1("अकरा", 11), new wt1("बारह", 12), new wt1("बारा", 12), new wt1("पंद्रह", 15), new wt1("पंधरा", 15), new wt1("बीस", 20), new wt1("वीस", 20), new wt1("तीस", 30), new wt1("पैंतालीस", 45), new wt1("पंचेचाळीस", 45));

    public static String a(String str) {
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        ArrayList arrayList = new ArrayList(strO.length());
        for (int i = 0; i < strO.length(); i++) {
            char cCharAt = strO.charAt(i);
            int iDigit = Character.digit(cCharAt, 10);
            if (iDigit >= 0) {
                cCharAt = (char) (iDigit + 48);
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        String strC = mz.C(arrayList, "", null, null, null, 62);
        Pattern patternCompile = Pattern.compile("(साडे|साढ़े|साढे|सवा|पौने|पावणे)(?=[\\p{L}\\p{M}])");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strC).replaceAll("$1 ");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("\\bo['’]?\\s*clock\\b");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("oclock");
        strReplaceAll2.getClass();
        for (Map.Entry entry : g.entrySet()) {
            strReplaceAll2 = d((String) entry.getKey()).f(strReplaceAll2, (String) entry.getValue());
        }
        for (Map.Entry entry2 : h.entrySet()) {
            strReplaceAll2 = d((String) entry2.getKey()).f(strReplaceAll2, String.valueOf(((Number) entry2.getValue()).intValue()));
        }
        Pattern patternCompile3 = Pattern.compile("\\bdo(?=\\s+(?:seconds?|minutes?|hours?|ghante?|oclock|baje|bajkar|vajun|[ap]\\.?\\s*m)\\b)");
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("2");
        strReplaceAll3.getClass();
        String strG = new x42("\\b(20|30|40|50|60|70|80|90)[ -]+([1-9])\\b").g(g31.a(cs2.V(strReplaceAll3).toString(), "do") ? "2" : strReplaceAll3, new xn2(15));
        Pattern patternCompile4 = Pattern.compile("\\b(\\d{1,2})\\s+(?:bajkar|vajun)\\s+(\\d{1,2})(?:\\s+minutes?)?\\b");
        patternCompile4.getClass();
        strG.getClass();
        String strReplaceAll4 = patternCompile4.matcher(strG).replaceAll("$1:$2");
        strReplaceAll4.getClass();
        Pattern patternCompile5 = Pattern.compile("\\b(?:saadhe|sadhe|sade)\\s*(\\d{1,2})\\b");
        patternCompile5.getClass();
        String strReplaceAll5 = patternCompile5.matcher(strReplaceAll4).replaceAll("$1:30");
        strReplaceAll5.getClass();
        Pattern patternCompile6 = Pattern.compile("\\b(?:sava|sawa)\\s*(\\d{1,2})\\b");
        patternCompile6.getClass();
        String strReplaceAll6 = patternCompile6.matcher(strReplaceAll5).replaceAll("$1:15");
        strReplaceAll6.getClass();
        String strG2 = new x42("\\b(?:paune|paavne|pavne)\\s*(\\d{1,2})\\b").g(strReplaceAll6, new xn2(16));
        Pattern patternCompile7 = Pattern.compile("\\s+");
        patternCompile7.getClass();
        strG2.getClass();
        String strReplaceAll7 = patternCompile7.matcher(strG2).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll7.getClass();
        return cs2.V(strReplaceAll7).toString();
    }

    public static String b(String str) {
        fh1 fh1VarB;
        int iIntValue;
        Boolean boolValueOf;
        str.getClass();
        String strA = a(str);
        Pattern patternCompile = Pattern.compile("\\b1\\s+alarm\\b");
        patternCompile.getClass();
        strA.getClass();
        String strReplaceAll = patternCompile.matcher(strA).replaceAll("alarm");
        strReplaceAll.getClass();
        if (!c.a(strReplaceAll)) {
            Pattern patternCompile2 = Pattern.compile("\\bmidnight\\b");
            patternCompile2.getClass();
            boolean zFind = patternCompile2.matcher(strReplaceAll).find();
            Pattern patternCompile3 = Pattern.compile("\\bnoon\\b");
            patternCompile3.getClass();
            boolean zFind2 = patternCompile3.matcher(strReplaceAll).find();
            x42 x42Var = b;
            if (!zFind && !zFind2) {
                x42 x42Var2 = a;
                xg2 xg2VarC = x42.c(x42Var2, strReplaceAll);
                Iterator it = (xg2VarC instanceof zf0 ? ((zf0) xg2VarC).take() : new mv2(xg2VarC)).iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    i++;
                    if (i < 0) {
                        nz.m();
                        throw null;
                    }
                }
                if (i <= 1) {
                    fh1 fh1VarB2 = x42.b(x42Var2, strReplaceAll);
                    if (fh1VarB2 == null) {
                        fh1VarB = x42.b(x42Var, strReplaceAll);
                        if (fh1VarB != null) {
                        }
                    } else {
                        fh1VarB = fh1VarB2;
                    }
                    String string = cs2.H(strReplaceAll, fh1VarB.b()).toString();
                    for (int i2 = 0; i2 < string.length(); i2++) {
                        if (!Character.isDigit(string.charAt(i2))) {
                        }
                    }
                    Integer numM = js2.m((String) ((dh1) fh1VarB.a()).get(1));
                    if (numM != null && (iIntValue = numM.intValue()) <= 24 && (fh1VarB2 == null || (1 <= iIntValue && iIntValue < 13))) {
                        Integer numM2 = js2.m((String) ((dh1) fh1VarB.a()).get(2));
                        int iIntValue2 = numM2 != null ? numM2.intValue() : 0;
                        if (iIntValue2 <= 59 && (iIntValue != 24 || iIntValue2 == 0)) {
                            if (fh1VarB2 != null) {
                                boolValueOf = Boolean.valueOf(g31.a(((dh1) fh1VarB.a()).get(3), "p"));
                            } else if (f.a(strReplaceAll)) {
                                boolValueOf = Boolean.valueOf((iIntValue < 0 || iIntValue >= 6) && iIntValue != 12);
                            } else if (e.a(strReplaceAll)) {
                                boolValueOf = Boolean.TRUE;
                            } else {
                                boolValueOf = d.a(strReplaceAll) ? Boolean.FALSE : null;
                            }
                            if (g31.a(boolValueOf, Boolean.TRUE)) {
                                if (1 <= iIntValue && iIntValue < 12) {
                                    iIntValue += 12;
                                }
                            } else if (g31.a(boolValueOf, Boolean.FALSE)) {
                                if (iIntValue == 12) {
                                    iIntValue = 0;
                                }
                            } else if (boolValueOf != null) {
                                dk0.l();
                                return null;
                            }
                            int i3 = iIntValue != 24 ? iIntValue : 0;
                            if (i3 <= 23) {
                                return String.format(Locale.ROOT, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(iIntValue2)}, 2));
                            }
                        }
                    }
                }
            } else if (zFind != zFind2 && !x42Var.a(strReplaceAll)) {
                return zFind ? "00:00" : "12:00";
            }
        }
        return null;
    }

    public static Integer c(String str) {
        Double dValueOf;
        str.getClass();
        String strG = new x42("\\b(\\d+)\\s+and\\s+(?:a\\s+)?half\\s+(hours?|minutes?|seconds?)\\b").g(a(str), new xn2(17));
        Pattern patternCompile = Pattern.compile("\\bhalf\\s+(?:(?:an?|of\\s+an?)\\s+)?(hour|minute|second)s?\\b");
        patternCompile.getClass();
        strG.getClass();
        String strReplaceAll = patternCompile.matcher(strG).replaceAll("0.5 $1");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("\\bquarter\\s+(?:(?:an?|of\\s+an?)\\s+)?(hour|minute)s?\\b");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("0.25 $1");
        strReplaceAll2.getClass();
        Pattern patternCompile3 = Pattern.compile("\\b(?:an?|one)\\s+(hours?|minutes?|seconds?)\\b");
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("1 $1");
        strReplaceAll3.getClass();
        x42 x42Var = c;
        List<fh1> listH = zg2.h(x42.c(x42Var, strReplaceAll3));
        String strF = x42Var.f(strReplaceAll3, Padder.FALLBACK_PADDING_STRING);
        for (int i = 0; i < strF.length(); i++) {
            if (Character.isDigit(strF.charAt(i))) {
                return null;
            }
        }
        Pattern patternCompile4 = Pattern.compile("\\b(?:half|quarter|or)\\b");
        patternCompile4.getClass();
        if (!patternCompile4.matcher(strF).find()) {
            boolean z = false;
            long j = 0;
            for (fh1 fh1Var : listH) {
                String str2 = (String) ((dh1) fh1Var.a()).get(1);
                str2.getClass();
                try {
                    dValueOf = is2.d(str2) ? Double.valueOf(Double.parseDouble(str2)) : null;
                } catch (NumberFormatException unused) {
                }
                if (dValueOf != null) {
                    double dDoubleValue = dValueOf.doubleValue();
                    String str3 = (String) ((dh1) fh1Var.a()).get(2);
                    double d2 = dDoubleValue * (js2.k(str3, DateFormat.SECOND, false) ? 1L : js2.k(str3, DateFormat.MINUTE, false) ? 60L : 3600L);
                    if (Math.abs(d2) <= Double.MAX_VALUE && d2 >= 0.0d && d2 <= 86400.0d && d2 % 1.0d == 0.0d) {
                        j += (long) d2;
                        z = true;
                    }
                }
            }
            if (z && j > 0 && j <= 86400) {
                return Integer.valueOf((int) j);
            }
        }
        return null;
    }

    public static x42 d(String str) {
        str.getClass();
        String strQuote = Pattern.quote(str);
        strQuote.getClass();
        return new x42("(?<![\\p{L}\\p{M}])" + strQuote + "(?![\\p{L}\\p{M}])");
    }
}
