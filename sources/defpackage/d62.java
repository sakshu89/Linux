package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.PluralRules;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d62 {
    public static final x42 b = new x42("\\s+");
    public static final mz2 c = new mz2();
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;
    public static final List j;
    public static final Set k;
    public static final Set l;
    public static final Set m;
    public static final x42 n;
    public static final Set o;
    public static final rg1 p;
    public static final Set q;
    public final xv1 a;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        d = new x42("^(?:by|the\\s+artist\\s+is|artist(?:\\s+name)?\\s+is|it['’]?s\\s+by)\\s*", y42Var);
        e = new x42("\\s+please\\s*[.!?]*$", y42Var);
        f = new x42("^(?:(?:the\\s+)?message\\s+(?:is|should\\s+(?:be|say))|(?:it\\s+)?should\\s+say)\\s+", y42Var);
        g = new x42("^(?:play|search\\s+and\\s+play|find\\s+and\\s+play)\\s+.+$");
        h = new x42("^(?:(?:(?:play|go\\s+to)\\s+(?:the\\s+)?)?(?:next|previous)(?:\\s+(?:song|track|video|one))?|(?:pause|resume|unpause|continue|stop)(?:\\s+(?:the\\s+)?(?:music|song|track|video|playback|playing))?|(?:what\\s+is|whats|what\\s+s)\\s+playing)$");
        i = new x42("^(?:(?:(?:on|in|from|using)\\s+)?(?:spotify|youtube(?:\\s+music)?|google|apple\\s+music|amazon\\s+music)\\b.*|(?:play|search|find|look\\s+up|open|launch|start)\\b.*\\b(?:spotify|youtube(?:\\s+music)?|google|apple\\s+music|amazon\\s+music)\\b.*)$");
        j = nz.i(new x42("^(?:take|capture)\\s+(?:(?:a|the)\\s+)?(?:screenshot|screen\\s+shot|photo|picture)\\b"), new x42("^(?:read|describe|show)\\s+(?:(?:me|my|the)\\s+)*(?:screen|display)\\b"), new x42("^(?:open|launch|start)\\s+(?:the\\s+)?(?:youtube|spotify|whatsapp|camera|settings|gallery|browser|chrome|phone|messages|calculator|maps|gmail)\\b"), new x42("^(?:turn|switch)\\s+(?:on|off)\\b"), new x42("^(?:lock|unlock)\\s+(?:the\\s+)?(?:phone|device|screen)\\b"), new x42("^(?:call|dial|text|message)\\s+.+$"));
        k = wh2.c("yes", "yeah", "yep", "yup", "yes please", "sure", "ok", "okay", "k", "correct", "right", "that's right", "thats right", "confirm", "confirmed", "go ahead", "do it", "please do", "sounds good", "affirmative", "haan", "han", "ha", "ji", "ji haan", "haan ji", "bilkul", "sahi", "theek hai", "thik hai", "thk hai", "kar do", "karo", "kardo", "haan karo");
        l = wh2.c("no", "nope", "nah", "dont", "don't", "do not", "cancel", "stop", "abort", "negative", "nahi", "nahin", "nai", "ruko", "nako", "mat");
        m = wh2.c("never mind", "nevermind", "forget it", "leave it", "no thanks", "no thank you", "not now", "not right now", "mat karo", "chhod do", "chod do", "rehne do", "cancel that", "stop that", "cancel the request", "cancel the command", "cancel last command", "cancel the last command", "cancel this", "stop the command");
        n = new x42("^(?:cancel|stop|abort)\\s+(?:the\\s+)?(?:command|request|last\\s+command|action|message|draft|task|everything|that|this)\\b", y42Var);
        o = wh2.c("none of these", "none of them", "neither", "neither of them", "neither of these", "he is not in the options", "she is not in the options", "they are not in the options", "not in the options", "not in the list", "isme woh naam nahi hai", "inme se koi nahi", "inme se koi nahi hai", "inmein se koi nahi", "koi bhi nahi", "koi nahi", "none of these options", "none of those", "these are all wrong");
        rg1 rg1Var = new rg1();
        List listI = nz.i("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth");
        List listI2 = nz.i(PluralRules.KEYWORD_ONE, PluralRules.KEYWORD_TWO, "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen");
        int i2 = 0;
        int i3 = 0;
        for (Object obj : listI) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                nz.n();
                throw null;
            }
            rg1Var.put((String) obj, Integer.valueOf(i3));
            i3 = i4;
        }
        for (Object obj2 : listI2) {
            int i5 = i2 + 1;
            if (i2 < 0) {
                nz.n();
                throw null;
            }
            rg1Var.put((String) obj2, Integer.valueOf(i2));
            i2 = i5;
        }
        Iterator it = new h21(1, 16, 1).iterator();
        while (true) {
            g21 g21Var = (g21) it;
            if (!g21Var.c) {
                rg1Var.put("pehla", 0);
                rg1Var.put("pehle", 0);
                rg1Var.put("pehli", 0);
                rg1Var.put("pahla", 0);
                rg1Var.put("पहलो", 0);
                rg1Var.put("एक", 0);
                rg1Var.put("dusra", 1);
                rg1Var.put("dusre", 1);
                rg1Var.put("dusri", 1);
                rg1Var.put("doosra", 1);
                rg1Var.put("doosre", 1);
                rg1Var.put("doosri", 1);
                rg1Var.put("दूजो", 1);
                rg1Var.put("दो", 1);
                rg1Var.put("teesra", 2);
                rg1Var.put("teesre", 2);
                rg1Var.put("teesri", 2);
                rg1Var.put("tisra", 2);
                rg1Var.put("tisre", 2);
                rg1Var.put("tisri", 2);
                rg1Var.put("तीजो", 2);
                rg1Var.put("तीन", 2);
                rg1Var.put("chautha", 3);
                rg1Var.put("chauthe", 3);
                rg1Var.put("chauthi", 3);
                rg1Var.put("चौथो", 3);
                rg1Var.put("चार", 3);
                rg1Var.put("paanchwa", 4);
                rg1Var.put("paanchve", 4);
                rg1Var.put("paanchwi", 4);
                rg1Var.put("panchwa", 4);
                rg1Var.put("panchve", 4);
                rg1Var.put("पांच", 4);
                rg1Var.put("पाँच", 4);
                rg1Var.put("पहला", 0);
                rg1Var.put("पहले", 0);
                rg1Var.put("पहली", 0);
                rg1Var.put("दूसरा", 1);
                rg1Var.put("दूसरे", 1);
                rg1Var.put("दूसरी", 1);
                rg1Var.put("तीसरा", 2);
                rg1Var.put("तीसरे", 2);
                rg1Var.put("तीसरी", 2);
                rg1Var.put("चौथा", 3);
                rg1Var.put("चौथे", 3);
                rg1Var.put("पांचवा", 4);
                rg1Var.put("पांचवे", 4);
                rg1Var.put("पाँचवाँ", 4);
                rg1Var.put("पाँचवे", 4);
                rg1Var.put("पहिला", 0);
                rg1Var.put("पहिले", 0);
                rg1Var.put("पहिलं", 0);
                rg1Var.put("pahila", 0);
                rg1Var.put("pahile", 0);
                rg1Var.put("दुसरा", 1);
                rg1Var.put("दुसरे", 1);
                rg1Var.put("दुसरं", 1);
                rg1Var.put("दुसऱ्या", 1);
                rg1Var.put("dusऱ्या", 1);
                rg1Var.put("तिसरा", 2);
                rg1Var.put("तिसरे", 2);
                rg1Var.put("तिसरं", 2);
                rg1Var.put("तिसऱ्या", 2);
                rg1Var.put("ਪਹਿਲਾ", 0);
                rg1Var.put("ਪਹਿਲੇ", 0);
                rg1Var.put("pehlaa", 0);
                rg1Var.put("ਦੂਜਾ", 1);
                rg1Var.put("ਦੂਜੇ", 1);
                rg1Var.put("dooja", 1);
                rg1Var.put("duja", 1);
                rg1Var.put("ਤੀਜਾ", 2);
                rg1Var.put("ਤੀਜੇ", 2);
                rg1Var.put("teeja", 2);
                rg1Var.put("tija", 2);
                rg1Var.put("ਚੌਥਾ", 3);
                rg1Var.put("chauthaa", 3);
                rg1Var.put("પહેલું", 0);
                rg1Var.put("પહેલો", 0);
                rg1Var.put("પહેલા", 0);
                rg1Var.put("pehlung", 0);
                rg1Var.put("pehlo", 0);
                rg1Var.put("બીજું", 1);
                rg1Var.put("બીજો", 1);
                rg1Var.put("બીજા", 1);
                rg1Var.put("bijung", 1);
                rg1Var.put("bijo", 1);
                rg1Var.put("ત્રીજું", 2);
                rg1Var.put("ત્રીજો", 2);
                rg1Var.put("ત્રીજા", 2);
                rg1Var.put("trijung", 2);
                rg1Var.put("trijo", 2);
                rg1Var.put("ચોથું", 3);
                rg1Var.put("ચોથો", 3);
                rg1Var.put("chothung", 3);
                rg1Var.put("१", 0);
                rg1Var.put("२", 1);
                rg1Var.put("३", 2);
                rg1Var.put("४", 3);
                rg1Var.put("५", 4);
                rg1Var.put("६", 5);
                rg1Var.put("७", 6);
                rg1Var.put("८", 7);
                rg1Var.put("९", 8);
                rg1Var.put("१०", 9);
                rg1Var.put("१st", 0);
                rg1Var.put("२nd", 1);
                rg1Var.put("३rd", 2);
                rg1Var.put("४th", 3);
                rg1Var.put("५th", 4);
                rg1Var.put("మొదటి", 0);
                rg1Var.put("modati", 0);
                rg1Var.put("ఒకటి", 0);
                rg1Var.put("రెండో", 1);
                rg1Var.put("రెండవ", 1);
                rg1Var.put("రెండు", 1);
                rg1Var.put("rendo", 1);
                rg1Var.put("rendava", 1);
                rg1Var.put("మూడో", 2);
                rg1Var.put("మూడవ", 2);
                rg1Var.put("మూడు", 2);
                rg1Var.put("mudo", 2);
                rg1Var.put("mudava", 2);
                rg1Var.put("నాలుగో", 3);
                rg1Var.put("నాలుగవ", 3);
                rg1Var.put("నాలుగు", 3);
                rg1Var.put("nalugo", 3);
                rg1Var.put("முதல்", 0);
                rg1Var.put("mudhal", 0);
                rg1Var.put("ஒன்று", 0);
                rg1Var.put("இரண்டாவது", 1);
                rg1Var.put("irandavadhu", 1);
                rg1Var.put("இரண்டு", 1);
                rg1Var.put("மூன்றாவது", 2);
                rg1Var.put("moondravadhu", 2);
                rg1Var.put("மூன்று", 2);
                rg1Var.put("நான்காவது", 3);
                rg1Var.put("naangavadhu", 3);
                rg1Var.put("நான்கு", 3);
                rg1Var.put("ഒന്നാമത്തെ", 0);
                rg1Var.put("onnamathe", 0);
                rg1Var.put("ഒന്ന്", 0);
                rg1Var.put("രണ്ടാമത്തെ", 1);
                rg1Var.put("randamathe", 1);
                rg1Var.put("രണ്ട്", 1);
                rg1Var.put("മൂന്നാമത്തെ", 2);
                rg1Var.put("moonnamathe", 2);
                rg1Var.put("മൂന്ന്", 2);
                rg1Var.put("നാലാമത്തെ", 3);
                rg1Var.put("nalamathe", 3);
                rg1Var.put("നാല്", 3);
                rg1Var.put("ಮೊದಲ", 0);
                rg1Var.put("modala", 0);
                rg1Var.put("ಒಂದು", 0);
                rg1Var.put("ಎರಡನೇ", 1);
                rg1Var.put("eradane", 1);
                rg1Var.put("ಎರಡು", 1);
                rg1Var.put("ಮೂರನೇ", 2);
                rg1Var.put("moorane", 2);
                rg1Var.put("ಮೂರು", 2);
                rg1Var.put("ನಾಲ್ಕನೇ", 3);
                rg1Var.put("naalkane", 3);
                rg1Var.put("ನಾಲ್ಕು", 3);
                rg1Var.put("१", 0);
                rg1Var.put("२", 1);
                rg1Var.put("३", 2);
                rg1Var.put("४", 3);
                rg1Var.put("५", 4);
                rg1Var.put("६", 5);
                rg1Var.put("७", 6);
                rg1Var.put("८", 7);
                rg1Var.put("९", 8);
                rg1Var.put("१०", 9);
                rg1Var.put("૧", 0);
                rg1Var.put("૨", 1);
                rg1Var.put("૩", 2);
                rg1Var.put("૪", 3);
                rg1Var.put("૫", 4);
                rg1Var.put("੧", 0);
                rg1Var.put("੨", 1);
                rg1Var.put("੩", 2);
                rg1Var.put("੪", 3);
                rg1Var.put("੫", 4);
                rg1Var.put("౧", 0);
                rg1Var.put("౨", 1);
                rg1Var.put("౩", 2);
                rg1Var.put("౪", 3);
                rg1Var.put("౫", 4);
                rg1Var.put("௧", 0);
                rg1Var.put("௨", 1);
                rg1Var.put("௩", 2);
                rg1Var.put("௮", 3);
                rg1Var.put("௫", 4);
                rg1Var.put("೧", 0);
                rg1Var.put("೨", 1);
                rg1Var.put("೩", 2);
                rg1Var.put("೪", 3);
                rg1Var.put("೫", 4);
                p = rg1Var.b();
                q = wh2.c("last", "final", "aakhri", "akhri", "છેલ્લું", "છેલ્લો", "અંતિમ", "చివరి", "கடைசி", "അവസാനത്തെ", "ಕೊನೆಯ");
                return;
            }
            int iNextInt = g21Var.nextInt();
            int i6 = iNextInt % 100;
            String str = "th";
            if (11 > i6 || i6 >= 14) {
                int i7 = iNextInt % 10;
                if (i7 == 1) {
                    str = "st";
                } else if (i7 == 2) {
                    str = "nd";
                } else if (i7 == 3) {
                    str = "rd";
                }
            }
            rg1Var.put(iNextInt + str, Integer.valueOf(iNextInt - 1));
        }
    }

    public d62(xv1 xv1Var) {
        xv1Var.getClass();
        this.a = xv1Var;
    }

    public static String c(String str) {
        Locale locale = Locale.ROOT;
        return cs2.V(cs2.W(cs2.V(b.f(cq.o(locale, str, locale), Padder.FALLBACK_PADDING_STRING)).toString(), '.', '!', '?', ',', ';')).toString();
    }

    public final boolean a(String str, String str2) {
        b63 b63VarA = c.a(str);
        String str3 = b63VarA.c;
        boolean zA = g31.a(str2, "message_body");
        i60 i60Var = i60.i;
        if (!zA && new rp2(this.a).c(b63VarA, i60Var) != null) {
            return true;
        }
        Set setC = wh2.c(new w3("time.alarm.set"), new w3("time.timer.set"));
        f5 f5VarC = new r03().c(b63VarA, i60Var);
        String str4 = f5VarC != null ? f5VarC.a : null;
        if (mz.s(str4 != null ? new w3(str4) : null, setC)) {
            return true;
        }
        if (!g31.a(str2, "message_body") && (h.e(str3) || i.e(str3))) {
            return true;
        }
        if (g31.a(str2, "artist") && g.e(str3)) {
            return true;
        }
        List list = j;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((x42) it.next()).a(str3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2) {
        b63 b63VarA = c.a(str);
        if (new rp2(this.a).c(b63VarA, i60.i) != null) {
            return true;
        }
        String str3 = b63VarA.c;
        if (h.e(str3) || i.e(str3)) {
            return true;
        }
        return g31.a(str2, "artist") && g.e(str3);
    }
}
