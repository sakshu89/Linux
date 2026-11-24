package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yz0 {
    public static final x42 a;
    public static final x42 b;
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;
    public static final x42 j;
    public static final x42 k;
    public static final x42 l;
    public static final x42 m;
    public static final x42 n;
    public static final x42 o;
    public static final x42 p;
    public static final x42 q;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("^(?:(?:hey\\s+)?(?:sonic|सोनिक|सॉनिक|सोनीक)[,\\s:]+|(?:please|कृपया|जरा|ज़रा|प्लीज)\\s+|(?:एक\\s+काम\\s+करो?|ek\\s+kaam\\s+kar(?:o)?)\\s+)+", y42Var);
        b = new x42("(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)", y42Var);
        c = new x42("^(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:पर|पे|में|वर|मध्ये|pe|par|var|madhe|on)\\s+", y42Var);
        d = new x42("^(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:पर|पे|में|वर|मध्ये|pe|par|var|madhe|on)?\\s+(.+?)(?:\\s+(?:ko|la)|\\s*(?:को|ला))\\s+(.+)$", y42Var);
        e = new x42("^(.+?)(?:\\s+(?:ko|la)|\\s*(?:को|ला))\\s+(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:पर|पे|में|वर|मध्ये|pe|par|var|madhe|on)\\s+(.+)$", y42Var);
        f = new x42("^(.+?)(?:\\s+(?:ko|la)|\\s*(?:को|ला))\\s+(.+)$", y42Var);
        g = new x42("^(.+?)\\s+((?:भेजो|भेजें|भेजिए|भेज\\s+(?:दो|देना|दें)|डाल(?:ो|ें)?(?:\\s+(?:दो|दे|देना))?|पाठव|पाठवा|पाठवून\\s+दे|bhejo|bhej\\s+(?:do|dena)|daal(?:o)?(?:\\s+(?:do|de|dena))?|send\\s+kar(?:o|\\s+do)?|message\\s+kar(?:o)?|msg\\s+kar(?:o)?|pathav|pathva|pathava))\\s+(.+?)(?:\\s+(?:ko|la)|\\s*(?:को|ला))[.!?।]*$", y42Var);
        h = new x42("(?:^|\\s+)(?:भेजो|भेजें|भेजिए|भेज\\s+(?:दो|देना|दें)|डाल(?:ो|ें)?(?:\\s+(?:दो|दे|देना))?|पाठव|पाठवा|पाठवून\\s+दे|bhejo|bhej\\s+(?:do|dena)|daal(?:o)?(?:\\s+(?:do|de|dena))?|send\\s+kar(?:o|\\s+do)?|message\\s+kar(?:o)?|msg\\s+kar(?:o)?|pathav|pathva|pathava)(?:\\s+(?:please|कृपया))?[.!?।]*$", y42Var);
        i = new x42("(?:मैसेज|मेसेज|संदेश|message|msg)", y42Var);
        j = new x42("(?:^|\\s+)(?:(?:का|के|की)\\s+)?(?:मैसेज|मेसेज|संदेश|message|msg)$", y42Var);
        k = new x42("\\s+(?:असा|अशी|ऐसा)$");
        l = new x42("^(?:मैसेज|मेसेज|संदेश|message|msg)\\s+(?:(?:भेजो|भेजें|भेजिए|भेज\\s+(?:दो|देना|दें)|डाल(?:ो|ें)?(?:\\s+(?:दो|दे|देना))?|पाठव|पाठवा|पाठवून\\s+दे|bhejo|bhej\\s+(?:do|dena)|daal(?:o)?(?:\\s+(?:do|de|dena))?|send\\s+kar(?:o|\\s+do)?|message\\s+kar(?:o)?|msg\\s+kar(?:o)?|pathav|pathva|pathava)\\s+)?(?:कि|की|की,|म्हणून|ki|saying|ke|karke|kar\\s+ke|bolke|bol\\s+ke|puchke|puch\\s+ke|करके|कर\\s+के|बोलके|बोल\\s+के|पूछके|पूछ\\s+के)\\s+(.+)$", y42Var);
        m = new x42("(?:^|\\s)(?:मत|नको|नका|नहीं|नाही|mat|nahi|dont|don't|do not)\\s+(?:भेजो|भेजें|भेजिए|भेज\\s+(?:दो|देना|दें)|डाल(?:ो|ें)?(?:\\s+(?:दो|दे|देना))?|पाठव|पाठवा|पाठवून\\s+दे|bhejo|bhej\\s+(?:do|dena)|daal(?:o)?(?:\\s+(?:do|de|dena))?|send\\s+kar(?:o|\\s+do)?|message\\s+kar(?:o)?|msg\\s+kar(?:o)?|pathav|pathva|pathava)[.!?।]*$", y42Var);
        n = new x42("^(?:(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:के|का|की|चा|च्या|मधील|वरील|वर|पर|pe|par)?\\s*)?(?:सर्च|शोध|खोज|search)(?:\\s*(?:बार|बॉक्स|फील्ड|bar|box|field))?\\s*(?:में|मध्ये|मधे|मे|mein|me|madhe|in)\\s+(.+?)\\s+(?:लिखो|लिखें|लिही|लिहा|टाइप\\s+करो|टाईप\\s+कर|टाइप\\s+कर|type\\s+kar|type\\s+karo|liha|likho)$", y42Var);
        o = new x42("^(.+?)\\s+(?:(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:के|का|की|चा|च्या|मधील|वरील|वर|पर|pe|par)?\\s*)?(?:सर्च|शोध|खोज|search)(?:\\s*(?:बार|बॉक्स|फील्ड|bar|box|field))?\\s*(?:में|मध्ये|मधे|मे|mein|me|madhe|in)\\s+(?:लिखो|लिखें|लिही|लिहा|टाइप\\s+करो|टाईप\\s+कर|टाइप\\s+कर|type\\s+kar|type\\s+karo|liha|likho)$", y42Var);
        p = new x42("^(?:(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:के|का|की|चा|च्या|मधील|वरील|वर|पर|pe|par)?\\s*)?(?:सर्च|शोध|खोज|search)(?:\\s*(?:बार|बॉक्स|फील्ड|bar|box|field))?(?:\\s*(?:पर|पे|वर|pe|par))?\\s+(?:खोलो|खोलें|उघड|उघडा|open\\s+kar|open\\s+karo|(?:क्लिक|टॅप|टैप|click|tap)\\s*(?:करो|करा|कर|karo|kar))$", y42Var);
        q = new x42("^(?:(?:whats\\s*app|व्हॉट्सअॅप|व्हॉट्सअप|व्हाट्सअॅप|व्हाट्सऐप|व्हाट्सएप्प|व्हाट्सएप|व्हाट्सअप|वॉट्सअॅप|वॉट्सअप|वाट्सऐप|वाट्सएप)\\s*(?:के|का|की|चा|च्या|मधील|वरील|वर|पर|pe|par)?\\s*)?((?:पहला|पहली|पहले|पहिली|पहिल्या|पहिलं|पहिले|दूसरा|दूसरी|दुसरा|दुसरी|दुसऱ्या|तीसरा|तीसरी|तिसरा|तिसरी|pehla|pehli|pahila|pahili|dusra|dusri|doosra|tisra|teesra|[1-3१-३]))\\s+(?:चैट|चॅट|chat|संपर्क|कॉन्टैक्ट)(?:\\s*(?:पर|पे|वर|pe|par))?\\s+(?:खोलो|खोलें|उघड|उघडा|open\\s+kar|open\\s+karo|(?:क्लिक|टॅप|टैप|click|tap)\\s*(?:करो|करा|कर|karo|kar))$", y42Var);
    }

    public static String a(String str, boolean z) {
        String string = cs2.V(a.f(cs2.V(str).toString(), "")).toString();
        return z ? string : cs2.Y(string, '.', 2404, '!', '?');
    }

    public static f5 b(b63 b63Var) {
        fh1 fh1VarB;
        String str;
        String str2;
        String string;
        String strA = a(b63Var.a, true);
        fh1 fh1VarD = d.d(strA);
        if (fh1VarD == null) {
            fh1VarD = e.d(strA);
        }
        if (fh1VarD == null) {
            fh1VarD = f.d(strA);
        }
        fh1 fh1VarD2 = (fh1VarD == null || (str2 = (String) ((dh1) fh1VarD.a()).get(2)) == null || (string = cs2.V(str2).toString()) == null) ? null : l.d(string);
        if (fh1VarD == null || fh1VarD2 == null) {
            x42 x42Var = c;
            x42.b(x42Var, strA);
            fh1 fh1VarD3 = g.d(cs2.V(x42Var.f(strA, "")).toString());
            x42 x42Var2 = i;
            x42 x42Var3 = k;
            x42 x42Var4 = j;
            x42 x42Var5 = m;
            if (fh1VarD3 != null) {
                String string2 = cs2.V((String) ((dh1) fh1VarD3.a()).get(3)).toString();
                String string3 = cs2.V((String) ((dh1) fh1VarD3.a()).get(1)).toString();
                String str3 = (String) ((dh1) fh1VarD3.a()).get(2);
                if (d(string2)) {
                    if (!x42Var5.a(string3 + Padder.FALLBACK_PADDING_STRING + str3)) {
                        String string4 = cs2.V(x42Var3.f(cs2.V(x42Var4.f(string3, "")).toString(), "")).toString();
                        str = x42Var2.e(string4) ? null : string4;
                        return c(b63Var, string2, str != null ? str : "");
                    }
                }
            } else if (fh1VarD != null) {
                String string5 = cs2.V((String) ((dh1) fh1VarD.a()).get(1)).toString();
                String string6 = cs2.V((String) ((dh1) fh1VarD.a()).get(2)).toString();
                if (d(string5) && !x42Var5.a(string6) && (fh1VarB = x42.b(h, string6)) != null) {
                    String string7 = cs2.V(x42Var3.f(cs2.V(x42Var4.f(cs2.V(string6.substring(0, fh1VarB.b().a)).toString(), "")).toString(), "")).toString();
                    str = x42Var2.e(string7) ? null : string7;
                    return c(b63Var, string5, str != null ? str : "");
                }
            }
        } else {
            String string8 = cs2.V((String) ((dh1) fh1VarD.a()).get(1)).toString();
            if (d(string8)) {
                return c(b63Var, string8, cs2.V((String) ((dh1) fh1VarD2.a()).get(1)).toString());
            }
        }
        return null;
    }

    public static f5 c(b63 b63Var, String str, String str2) {
        Pattern patternCompile = Pattern.compile("\\b(?:draft|compose|type|write)\\b", 66);
        patternCompile.getClass();
        String str3 = b63Var.a;
        str3.getClass();
        boolean zFind = patternCompile.matcher(str3).find();
        String string = cs2.V(str2).toString();
        Pattern patternCompile2 = Pattern.compile("^(?:(?:मैसेज|मेसेज|संदेश|message|msg)\\s+)?(?:kar\\s+ke|karke|kar\\s+karo|kar|karo|bhejo|daal|send)?\\s*(?:ki|ki,|saying|ke|karke|kar\\s+ke|bolke|bol\\s+ke|puchke|puch\\s+ke|म्हणून|कि|की|की,|करके|कर\\s+के|बोलके|बोल\\s+के|पूछके|पूछ\\s+के)\\s+", 66);
        patternCompile2.getClass();
        string.getClass();
        String strReplaceAll = patternCompile2.matcher(string).replaceAll("");
        strReplaceAll.getClass();
        Pattern patternCompile3 = Pattern.compile("^(?:whats\\s*app|wa)\\s*(?:pe|par|var|madhe|on|in|mein)?\\s+", 66);
        patternCompile3.getClass();
        String strReplaceAll2 = patternCompile3.matcher(strReplaceAll).replaceAll("");
        strReplaceAll2.getClass();
        Pattern patternCompile4 = Pattern.compile("\\s+(?:whats\\s*app|wa)\\s*(?:pe|par|var|madhe|on|in|mein)?$", 66);
        patternCompile4.getClass();
        String strReplaceAll3 = patternCompile4.matcher(strReplaceAll2).replaceAll("");
        strReplaceAll3.getClass();
        Pattern patternCompile5 = Pattern.compile("\\s+(?:message|msg)\\s+kar$", 66);
        patternCompile5.getClass();
        String strReplaceAll4 = patternCompile5.matcher(strReplaceAll3).replaceAll("");
        strReplaceAll4.getClass();
        Pattern patternCompile6 = Pattern.compile("\\s+(?:message|msg)\\s+karo$", 66);
        patternCompile6.getClass();
        String strReplaceAll5 = patternCompile6.matcher(strReplaceAll4).replaceAll("");
        strReplaceAll5.getClass();
        String string2 = cs2.V(strReplaceAll5).toString();
        Map mapB = hr4.b(str);
        rg1 rg1Var = new rg1();
        rg1Var.put("message_channel", "whatsapp");
        if (cs2.A(string2)) {
            string2 = null;
        }
        if (string2 != null) {
            rg1Var.put("message_body", string2);
            if (!zFind) {
                rg1Var.put("send_requested", "true");
            }
        }
        return dp4.d(b63Var, "message.whatsapp.draft", bh1.e(mapB, rg1Var.b()), 0.0f, 12);
    }

    public static boolean d(String str) {
        List listH;
        if (!cs2.A(str)) {
            Pattern patternCompile = Pattern.compile("\\s+");
            patternCompile.getClass();
            cs2.L(0);
            Matcher matcher = patternCompile.matcher(str);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(str.subSequence(iEnd, str.length()).toString());
                listH = arrayList;
            } else {
                listH = nz.h(str.toString());
            }
            if (listH.size() <= 8) {
                return true;
            }
        }
        return false;
    }
}
