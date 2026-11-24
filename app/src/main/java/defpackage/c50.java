package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class c50 {
    public static final x42 a = new x42("\\p{M}+");
    public static final x42 b = new x42("[^a-z0-9\\s]");
    public static final x42 c = new x42("([a-z])\\1+");
    public static final x42 d = new x42("\\s+");
    public static final Map e = bh1.c(new wt1((char) 2325, "k"), new wt1((char) 2326, "kh"), new wt1((char) 2327, "g"), new wt1((char) 2328, "gh"), new wt1((char) 2329, "ng"), new wt1((char) 2330, "ch"), new wt1((char) 2331, "chh"), new wt1((char) 2332, DateFormat.HOUR), new wt1((char) 2333, "jh"), new wt1((char) 2334, "ny"), new wt1((char) 2335, "t"), new wt1((char) 2336, "th"), new wt1((char) 2337, DateFormat.DAY), new wt1((char) 2338, "dh"), new wt1((char) 2339, "n"), new wt1((char) 2340, "t"), new wt1((char) 2341, "th"), new wt1((char) 2342, DateFormat.DAY), new wt1((char) 2343, "dh"), new wt1((char) 2344, "n"), new wt1((char) 2346, "p"), new wt1((char) 2347, "ph"), new wt1((char) 2348, "b"), new wt1((char) 2349, "bh"), new wt1((char) 2350, DateFormat.MINUTE), new wt1((char) 2351, DateFormat.YEAR), new wt1((char) 2352, "r"), new wt1((char) 2354, "l"), new wt1((char) 2357, DateFormat.ABBR_GENERIC_TZ), new wt1((char) 2358, "sh"), new wt1((char) 2359, "sh"), new wt1((char) 2360, DateFormat.SECOND), new wt1((char) 2361, "h"), new wt1((char) 2355, "l"), new wt1((char) 2392, "q"), new wt1((char) 2393, "kh"), new wt1((char) 2394, "g"), new wt1((char) 2395, DateFormat.ABBR_SPECIFIC_TZ), new wt1((char) 2396, DateFormat.DAY), new wt1((char) 2397, "dh"), new wt1((char) 2398, "f"));
    public static final Map f = bh1.c(new wt1((char) 2309, "a"), new wt1((char) 2310, "aa"), new wt1((char) 2311, "i"), new wt1((char) 2312, "ee"), new wt1((char) 2313, "u"), new wt1((char) 2314, "oo"), new wt1((char) 2319, "e"), new wt1((char) 2320, "ai"), new wt1((char) 2323, "o"), new wt1((char) 2324, "au"), new wt1((char) 2315, "ri"), new wt1((char) 2321, "o"), new wt1((char) 2366, "aa"), new wt1((char) 2367, "i"), new wt1((char) 2368, "ee"), new wt1((char) 2369, "u"), new wt1((char) 2370, "oo"), new wt1((char) 2375, "e"), new wt1((char) 2376, "ai"), new wt1((char) 2379, "o"), new wt1((char) 2380, "au"), new wt1((char) 2371, "ri"), new wt1((char) 2377, "o"), new wt1((char) 2373, "a"));

    public static String a(String str) {
        char cCharValue;
        str.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            String strValueOf = "";
            if (i >= strO.length()) {
                String strNormalize = Normalizer.normalize(sb.toString(), Normalizer.Form.NFD);
                strNormalize.getClass();
                String strReplace = b.f(a.f(strNormalize, ""), Padder.FALLBACK_PADDING_STRING).replace('v', 'w');
                strReplace.getClass();
                return cs2.V(d.f(c.f(js2.i(js2.i(js2.i(strReplace, "aa", "a"), "ee", "i"), "oo", "u"), "$1"), Padder.FALLBACK_PADDING_STRING)).toString();
            }
            char cCharAt = strO.charAt(i);
            String str2 = (String) e.get(Character.valueOf(cCharAt));
            Map map = f;
            if (str2 != null) {
                sb.append(str2);
                int i2 = i + 1;
                Character chU = cs2.u(i2, strO);
                if (chU != null && chU.charValue() == 2364) {
                    i2 = i + 2;
                }
                Character chU2 = cs2.u(i2, strO);
                if (chU2 != null && chU2.charValue() == 2381) {
                    i2++;
                } else {
                    Character chU3 = cs2.u(i2, strO);
                    if (chU3 == null || !map.containsKey(chU3)) {
                        Character chU4 = cs2.u(i2, strO);
                        if (chU4 != null && 2304 <= (cCharValue = chU4.charValue()) && cCharValue < 2432) {
                            sb.append('a');
                        }
                    } else {
                        sb.append((String) bh1.a(Character.valueOf(strO.charAt(i2)), map));
                        i2++;
                    }
                }
                i = i2;
            } else {
                String str3 = (String) map.get(Character.valueOf(cCharAt));
                if (str3 != null) {
                    strValueOf = str3;
                } else if (cCharAt != 2364 && cCharAt != 2381) {
                    switch (cCharAt) {
                        case 2305:
                        case 2306:
                            strValueOf = "n";
                            break;
                        case 2307:
                            strValueOf = "h";
                            break;
                        default:
                            strValueOf = String.valueOf(cCharAt);
                            break;
                    }
                }
                sb.append(strValueOf);
                i++;
            }
        }
    }
}
