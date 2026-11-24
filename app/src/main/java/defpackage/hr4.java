package defpackage;

import com.ibm.icu.text.PluralRules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hr4 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static List a(String str) {
        Object h72Var;
        List listH;
        str.getClass();
        String string = cs2.V(str).toString();
        int i = 0;
        if (js2.k(string, "[", false)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                h21 h21VarF = ky3.f(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(nz.d(h21VarF));
                Iterator it = h21VarF.iterator();
                while (((g21) it).c) {
                    String string2 = jSONArray.getString(((g21) it).nextInt());
                    string2.getClass();
                    arrayList.add(cs2.V(string2).toString());
                }
                h72Var = new ArrayList();
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (!cs2.A((String) obj)) {
                        h72Var.add(obj);
                    }
                }
            } catch (Throwable th) {
                h72Var = new h72(th);
            }
            boolean z = h72Var instanceof h72;
            var r5 = h72Var;
            if (z) {
                r5 = ii0.a;
            }
            return (List) r5;
        }
        String strW = cs2.W(string, '.', '!', '?');
        Pattern patternCompile = Pattern.compile("\\s*(?:[,;]|\\band\\b|\\baur\\b)\\s*", (2 & 2) != 0 ? 2 | 64 : 2);
        patternCompile.getClass();
        strW.getClass();
        cs2.L(0);
        Matcher matcher = patternCompile.matcher(strW);
        if (matcher.find()) {
            ArrayList arrayList2 = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList2.add(strW.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList2.add(strW.subSequence(iEnd, strW.length()).toString());
            listH = arrayList2;
        } else {
            listH = nz.h(strW.toString());
        }
        ArrayList arrayList3 = new ArrayList(nz.d(listH));
        Iterator it2 = listH.iterator();
        while (it2.hasNext()) {
            arrayList3.add(cs2.V((String) it2.next()).toString());
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList3.size();
        while (i < size2) {
            Object obj2 = arrayList3.get(i);
            i++;
            if (!cs2.A((String) obj2)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public static Map b(String str) {
        str.getClass();
        String string = cs2.V(str).toString();
        string.getClass();
        Pattern patternCompile = Pattern.compile("^(one|two|three|four|five|six|seven|eight|nine|[1-9]\\d?)\\s+(?:people|persons|contacts|friends)$", 66);
        patternCompile.getClass();
        String strW = cs2.W(cs2.V(string).toString(), '.', '!', '?');
        strW.getClass();
        Matcher matcher = patternCompile.matcher(strW);
        matcher.getClass();
        Integer numValueOf = null;
        fh1 fh1Var = !matcher.matches() ? null : new fh1(matcher, strW);
        if (fh1Var != null) {
            String lowerCase = ((String) ((dh1) fh1Var.a()).get(1)).toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Integer numL = js2.l(10, lowerCase);
            numValueOf = Integer.valueOf(numL != null ? numL.intValue() : nz.i(PluralRules.KEYWORD_ONE, PluralRules.KEYWORD_TWO, "three", "four", "five", "six", "seven", "eight", "nine").indexOf(lowerCase) + 1);
        }
        if (numValueOf != null) {
            Map mapSingletonMap = Collections.singletonMap("recipient_count", String.valueOf(numValueOf.intValue()));
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        if (!js2.k(string, "[", false)) {
            List listA = a(string);
            if (listA.size() <= 1) {
                Map mapSingletonMap2 = Collections.singletonMap("contact_name", string);
                mapSingletonMap2.getClass();
                return mapSingletonMap2;
            }
            wt1 wt1Var = new wt1("contact_name", string);
            String string2 = new JSONArray((Collection) listA).toString();
            string2.getClass();
            return bh1.c(wt1Var, new wt1("recipients", string2));
        }
        List listA2 = a(string);
        if (listA2.size() > 1) {
            String string3 = new JSONArray((Collection) listA2).toString();
            string3.getClass();
            Map mapSingletonMap3 = Collections.singletonMap("recipients", string3);
            mapSingletonMap3.getClass();
            return mapSingletonMap3;
        }
        if (listA2.isEmpty()) {
            Map mapSingletonMap4 = Collections.singletonMap("contact_name", string);
            mapSingletonMap4.getClass();
            return mapSingletonMap4;
        }
        Map mapSingletonMap5 = Collections.singletonMap("contact_name", mz.H(listA2));
        mapSingletonMap5.getClass();
        return mapSingletonMap5;
    }
}
