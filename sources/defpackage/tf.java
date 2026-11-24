package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tf implements o21 {
    public static final x42 a = new x42("\\b(list (?:my )?apps|what apps (?:do i have|are installed)|installed apps|show (?:me )?(?:my )?apps|which apps)\\b");
    public static final List b = nz.i(new x42("^uninstall\\s+(.+)$"), new x42("^(?:remove|delete)\\s+(.+?)\\s+app$"), new x42("^(?:remove|delete)\\s+the\\s+app\\s+(.+)$"));
    public static final x42 c = new x42("^\\s*[\"“'].*[\"”']\\s*[.!?]?\\s*$", y42.DOT_MATCHES_ALL);
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
    public static final List p;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        d = new x42("^(?:(?:please|kindly|kripya|kripaya|zara|jara|कृपया|ज़रा|जरा|सोनिक|aap|आप|kya\\s+aap|क्या\\s+आप|ek\\s+kaa?m\\s+kar(?:o)?|1\\s+kaa?m\\s+kar(?:o)?|एक\\s+काम\\s+कर(?:ो)?|ਕਿਰਪਾ\\s+ਕਰਕੇ|ਕਿਰਪਾ|ਸੋਨਿਕ|કૃપા\\s+કરીને|કૃપા|સોનિક|దయచేసి|dayachesi|தயவுசெய்து|dayavuseythu|ദയവായി|dayavayi|ದಯವಿಟ್ಟು|dayavittu)\\s+)+", y42Var);
        e = new x42("(?:\\s+(?:please|प्लीज|प्लीज़|for\\s+me|right\\s+now|now|ਕਰਕੇ|કરીને|ਜੀ|जी))+$", y42Var);
        f = new x42("^(?:this|that|it|यह|वह|इसे)(?:\\s|$)");
        g = new x42("(?:file|document|picture|image|video|link|url|website|webpage|tab|page|folder|chat|message|email|door|window|eyes|mind|फाइल|फ़ाइल|लिंक)");
        h = new x42("(?:my|your|our|his|her|their)\\s+(?:eyes|mind|door|window|file|document|picture|image|video|link|tab|page|folder|chat|message|email)");
        i = new x42("(?:^|\\s)(?:then|saying|says|said|not|dont|don|never|mat|nahi|नहीं|मत)(?:\\s|$)");
        j = new x42("^\\w+\\s+(?:and|or|aur|और)\\s+\\w+$", y42Var);
        k = new x42("(?:^|\\s)(?:to|for|in|on)\\s+(?:search|find|send|write|type|message|play|read|watch)(?:\\s|$)");
        l = new x42("^(?:karo|kar|kara|maadi|chey|pannu)(?:\\s|$)");
        m = new x42("^(?:say|tell|write|type|message|email|chat|send|search|find|explain|translate|keep|leave|how|why|what|when|if|karo|kar)(?:\\s|$)");
        n = new x42("(?:^|\\s)(?:is|are|was|were|already|should|would|could|can)(?:\\s|$)");
        o = new x42("[:/\\\\]|\\p{Alnum}\\.\\p{Alnum}");
        p = nz.i(new sf(new x42("^(?:open|launch|खोल|खोलो|खोला|खोलह|खोलिए|খুলুন|খোল|খুলো|খোলক|ଖୋଲନ୍ତު|ଖୋଲ|खोल्नुहोस्|खोल्नु|کھول|کھولِیو|ਖੋਲ੍ਹੋ|ਖੋਲੋ|ખોલો|ખોલ|उघड|उघडा|తెరువు|తెరవండి|திற|திறக்கவும்|തുറക്കുക|തുറക്കൂ|ತೆರೆಯಿರಿ|ತೆರೆ)\\s+(?:the\\s+)?(?:(?:app|application|ऐप|ਐਪ|ਏਪ|యాప్|ஆப்|ആപ്പ്|ಆಪ್)\\s+)?(.+?)(?:\\s+(?:app|application|ऐप|ਐਪ|ਏਪ|యాప్|ஆப்|ആപ്പ്|ಆಪ್))?$", y42Var), 0.9f, false), new sf(new x42("^(.+?)(?:\\s+(?:app|application|ऐप|ਐਪ|ਏਪ|యాప్|ஆப்|ആപ്പ്|ಆಪ್))?(?:\\s+(?:ko|को|ਨੂੰ|ਨੇ|ને|ను|కి|కు|க்கு|ക്ക്|ಗೆ))?\\s+(?:open(?:\\s+(?:karo|kar(?:\\s+(?:do|dijiye|deejiye|दीजिए|दीजिये|दें|देवो|આપો|sakte\\s+(?:ho|hain)|सकते\\s+(?:हो|हैं)))?|kijiye|कीजिए|ਕਰੋ|ਕરો|करा|చేయి|చేయండి|చెయ్|చేయ్|పண்ணு|பண்ணுங்க|செய்யുക|ಮಾಡಿ|ಮಾಡೋ|ചെയ്യുക|chey|cheyyandi|cheyyi|pannu|pannunga|maadi|cheyyuka))?|(?:kholo|khol|khola|kholah|khulun|kholiv|kholiye|kholie|kholिए|kholिये|kholें|kholho|khoolo|khol\\s+do|khool|खोल|खोलो|खोला|खोलह|खोलऽ|खोलिए|खोलिये|खोलें|খুলুন|খোল|খুলো|کھول|کھولِیو|ਖੋਲ੍ਹੋ|ਖੋਲੋ|ਖੋਲ੍ਹ|ખોલો|ખોલ|उघड|उघडा|ughad|ughada|teruvu|teravandi|తెరువు|తెరవండి|thira|thirakkavum|திற|திறக்கவும்|thurakkoo|thurakkuka|തുറക്ക|തുറക്കുക|tereyiri|tere|ತೆರೆಯಿರಿ|ತೆರೆ)(?:\\s+(?:do|dijiye|deejiye|दीजिए|दीजिये|दें|देवो|આપો|sakte\\s+(?:ho|hain)|सकते\\s+(?:हो|हैं)))?|(?:chalu|চালੂ|ચાલુ|चालू)\\s+(?:karo|kar|kijiye|ਕਰੋ|ਕરો|करा))$", y42Var), 0.9f, true), new sf(new x42("^(?:start|run|fire\\s+up|go\\s+to)\\s+(?:the\\s+)?(.+?)\\s+(?:app|application|ऐप|ਐਪ|ਏਪ|యాప్|ஆப்|ആപ്പ്|ಆಪ್)$", y42Var), 0.9f, false), new sf(new x42("^(?:start|run|fire\\s+up)\\s+(?:the\\s+)?(.+)$", y42Var), 0.75f, false), new sf(new x42("^go\\s+to\\s+(.+)$", y42Var), 0.75f, false));
    }

    @Override // defpackage.o21
    public final int a() {
        return 100;
    }

    @Override // defpackage.o21
    public final String b() {
        return "apps";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        String str;
        String string;
        String str2;
        String strB;
        i60Var.getClass();
        String str3 = b63Var.c;
        if (a.a(str3)) {
            return dp4.d(b63Var, "app.list", null, 0.9f, 10);
        }
        Iterator it = b.iterator();
        while (it.hasNext()) {
            fh1 fh1VarA = b63Var.a((x42) it.next());
            if (fh1VarA != null && (str2 = (String) ((dh1) fh1VarA.a()).get(1)) != null && (strB = dp4.b(str2)) != null && !cs2.A(strB)) {
                Map mapSingletonMap = Collections.singletonMap("app_name", strB);
                mapSingletonMap.getClass();
                return dp4.d(b63Var, "app.uninstall", mapSingletonMap, 0.9f, 8);
            }
        }
        if (!c.e(b63Var.a)) {
            Iterator it2 = mz.t(nz.i(b63Var.b, str3)).iterator();
            while (it2.hasNext()) {
                String string2 = cs2.V(e.f(d.f((String) it2.next(), ""), "")).toString();
                for (sf sfVar : p) {
                    fh1 fh1VarD = sfVar.a.d(string2);
                    if (fh1VarD != null && (str = (String) ((dh1) fh1VarD.a()).get(1)) != null && (string = cs2.V(str).toString()) != null) {
                        if (!js2.k(string, "my ", false)) {
                            string = dp4.b(string);
                        }
                        boolean z = sfVar.c;
                        if (!cs2.A(string) && cs2.N(string, new char[]{' '}, 6).size() <= 8 && !f.a(string) && !g.e(string) && !h.e(string) && !i.a(string) && !k.a(string) && !j.e(cs2.V(string).toString()) && !l.a(string) && (!z || (!m.a(string) && !n.a(string)))) {
                            if (!o.a(string)) {
                                Map mapSingletonMap2 = Collections.singletonMap("app_name", string);
                                mapSingletonMap2.getClass();
                                return dp4.d(b63Var, "app.open", mapSingletonMap2, sfVar.b, 8);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
