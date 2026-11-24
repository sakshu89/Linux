package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.PluralRules;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mz2 {
    public static final qs4 b;
    public static final List c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final List g;
    public static final qc1 h;
    public final List a;

    static {
        qs4 qs4Var = new qs4(19);
        b = qs4Var;
        c = nz.i("sonic", "sonik");
        d = new x42("[,!?;\"“”'’()\\[\\]]");
        e = new x42("\\.+(?=\\s|$)");
        f = new x42("\\s+");
        g = nz.i("please", "can you", "could you", "would you", "will you", "i want you to", "i need you to", "i want to", "i would like to", "let's", "lets", "kindly", "just", "now");
        qc1 qc1VarE = nz.e();
        qs4.c(qs4Var, qc1VarE, "band karo", "turn off");
        qs4.c(qs4Var, qc1VarE, "band kar do", "turn off");
        qs4.c(qs4Var, qc1VarE, "chalu karo", "turn on");
        qs4.c(qs4Var, qc1VarE, "chalu kar do", "turn on");
        qs4.c(qs4Var, qc1VarE, "on kar do", "turn on");
        qs4.c(qs4Var, qc1VarE, "off kar do", "turn off");
        qs4.c(qs4Var, qc1VarE, "on karo", "turn on");
        qs4.c(qs4Var, qc1VarE, "off karo", "turn off");
        qs4.c(qs4Var, qc1VarE, "call karo", "call");
        qs4.c(qs4Var, qc1VarE, "phone karo", "call");
        qs4.c(qs4Var, qc1VarE, "message bhejo", "message");
        qs4.c(qs4Var, qc1VarE, "message bhej do", "message");
        qs4.c(qs4Var, qc1VarE, "kitna hai", "what is");
        qs4.c(qs4Var, qc1VarE, "kitne baje", "what time");
        qs4.c(qs4Var, qc1VarE, "kholo", "open");
        qs4.c(qs4Var, qc1VarE, "khol", "open");
        qs4.c(qs4Var, qc1VarE, "khola", "open");
        qs4.c(qs4Var, qc1VarE, "kholah", "open");
        qs4.c(qs4Var, qc1VarE, "khulun", "open");
        qs4.c(qs4Var, qc1VarE, "kholiv", "open");
        qs4.c(qs4Var, qc1VarE, "bajao", "play");
        qs4.c(qs4Var, qc1VarE, "baja", "play");
        qs4.c(qs4Var, qc1VarE, "chalao", "play");
        qs4.c(qs4Var, qc1VarE, "bhejo", "send");
        qs4.c(qs4Var, qc1VarE, "bhej", "send");
        qs4.c(qs4Var, qc1VarE, "lagao", "set");
        qs4.c(qs4Var, qc1VarE, "batao", "tell");
        qs4.c(qs4Var, qc1VarE, "dikhao", "show");
        qs4.c(qs4Var, qc1VarE, "kar do", "");
        qs4.c(qs4Var, qc1VarE, "karo", "");
        qs4.c(qs4Var, qc1VarE, "kar", "");
        qs4.c(qs4Var, qc1VarE, "bandh", "off");
        qs4.c(qs4Var, qc1VarE, "chalu", "on");
        qs4.c(qs4Var, qc1VarE, "roko", "stop");
        qs4.c(qs4Var, qc1VarE, "ruko", "stop");
        qs4.c(qs4Var, qc1VarE, "aage", "next");
        qs4.c(qs4Var, qc1VarE, "peeche", "previous");
        qs4.c(qs4Var, qc1VarE, "badhao", "increase");
        qs4.c(qs4Var, qc1VarE, "ghatao", "decrease");
        qs4.c(qs4Var, qc1VarE, "awaaz", "volume");
        qs4.c(qs4Var, qc1VarE, "torch", "flashlight");
        for (Map.Entry entry : bh1.c(new wt1(PluralRules.KEYWORD_ZERO, "0"), new wt1(PluralRules.KEYWORD_TWO, "2"), new wt1("three", "3"), new wt1("four", "4"), new wt1("five", "5"), new wt1("six", "6"), new wt1("seven", "7"), new wt1("eight", "8"), new wt1("nine", "9"), new wt1("ten", "10"), new wt1("eleven", "11"), new wt1("twelve", "12"), new wt1("thirteen", "13"), new wt1("fourteen", "14"), new wt1("fifteen", "15"), new wt1("sixteen", "16"), new wt1("seventeen", "17"), new wt1("eighteen", "18"), new wt1("nineteen", "19"), new wt1("twenty", "20"), new wt1("thirty", "30"), new wt1("forty", "40"), new wt1("fifty", "50"), new wt1("sixty", "60"), new wt1("seventy", "70"), new wt1("eighty", "80"), new wt1("ninety", "90"), new wt1("hundred", "100")).entrySet()) {
            qs4.c(b, qc1VarE, (String) entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry entry2 : bh1.c(new wt1("ek", "1"), new wt1("teen", "3"), new wt1("char", "4"), new wt1("paanch", "5"), new wt1("panch", "5"), new wt1("chhe", "6"), new wt1("saat", "7"), new wt1("aath", "8"), new wt1("nau", "9"), new wt1("das", "10"), new wt1("pachas", "50"), new wt1("sau", "100")).entrySet()) {
            qs4.c(b, qc1VarE, (String) entry2.getKey(), (String) entry2.getValue());
        }
        qs4.c(b, qc1VarE, "sonics", "sonic");
        h = nz.c(qc1VarE);
    }

    public mz2(List list) {
        list.getClass();
        this.a = list;
    }

    public final b63 a(String str) {
        boolean z;
        CharSequence charSequenceSubSequence;
        CharSequence charSequenceSubSequence2;
        str.getClass();
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        String strO = qs4.o(cs2.V(lowerCase).toString());
        loop0: for (String str2 : this.a) {
            for (String str3 : nz.i(cq.j("hey ", str2), cq.j("ok ", str2), cq.j("hi ", str2), str2)) {
                if (js2.k(strO, str3, false)) {
                    String strG = cs2.G(strO, str3);
                    if (strG.length() == 0 || !Character.isLetterOrDigit(cs2.t(strG))) {
                        char[] cArr = {' ', ',', '.', '!', '?', ':'};
                        int length = strG.length();
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                charSequenceSubSequence2 = "";
                                break;
                            }
                            if (!qg.c(cArr, strG.charAt(i))) {
                                charSequenceSubSequence2 = strG.subSequence(i, strG.length());
                                break;
                            }
                            i++;
                        }
                        strO = charSequenceSubSequence2.toString();
                        break loop0;
                    }
                }
            }
        }
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            for (String str4 : g) {
                if (js2.k(strO, str4 + Padder.FALLBACK_PADDING_STRING, false)) {
                    String strG2 = cs2.G(strO, str4 + Padder.FALLBACK_PADDING_STRING);
                    int length2 = strG2.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            charSequenceSubSequence = "";
                            break;
                        }
                        if (!ph4.c(strG2.charAt(i2))) {
                            charSequenceSubSequence = strG2.subSequence(i2, strG2.length());
                            break;
                        }
                        i2++;
                    }
                    strO = charSequenceSubSequence.toString();
                    z = true;
                }
            }
        }
        String strF = e.f(d.f(cs2.V(cs2.I(strO, " please")).toString(), Padder.FALLBACK_PADDING_STRING), Padder.FALLBACK_PADDING_STRING);
        x42 x42Var = f;
        String string = cs2.V(x42Var.f(strF, Padder.FALLBACK_PADDING_STRING)).toString();
        ListIterator listIterator = h.listIterator(0);
        String strF2 = string;
        while (true) {
            nw0 nw0Var = (nw0) listIterator;
            if (!nw0Var.hasNext()) {
                break;
            }
            wt1 wt1Var = (wt1) nw0Var.next();
            strF2 = ((x42) wt1Var.a).f(strF2, (String) wt1Var.b);
        }
        String string2 = cs2.V(x42Var.f(strF2, Padder.FALLBACK_PADDING_STRING)).toString();
        return new b63(str, string, string2, string2.length() == 0 ? ii0.a : cs2.N(string2, new char[]{' '}, 6));
    }

    public /* synthetic */ mz2() {
        this(c);
    }
}
