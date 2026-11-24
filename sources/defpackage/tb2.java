package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tb2 implements o21 {
    public static final x42 a;
    public static final List b;
    public static final List c;
    public static final List d;
    public static final List e;
    public static final x42 f;
    public static final List g;
    public static final List h;
    public static final List i;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("^(?:open|focus|activate|find|locate)\\s+(?:the\\s+)?(.+)$", y42Var);
        b = nz.i(new x42("\\b(deep\\s+analy[sz]e|analy[sz]e\\s+(?:the\\s+)?screen\\s+deeply|deep\\s+inspect)\\b", y42Var), new x42("^deep\\s+analy[sz]e(?:\\s+(?:the|this)\\s+screen)?$", y42Var));
        c = nz.i(new x42("\\b(read (?:(?:the|my) )?screen|what'?s on (?:(?:the|my) )?screen|what s on (?:(?:the|my) )?screen|whats on (?:(?:the|my) )?screen|what is on (?:(?:the|my) )?screen|what do you see|read this)\\b"), new x42("^read\\s+(?:the\\s+)?screen$"));
        d = nz.i(new x42("^(?:play|open)\\s+(?:the\\s+)?((?:first|second|third|fourth|fifth|[1-9])\\s+(?:youtube\\s+)?(?:video|result))(?:\\s+on\\s+youtube)?$"), new x42("^(?:click|tap|press|select|choose)\\s+(?:on\\s+)?(?:the\\s+)?(.+)$"), new x42("^click\\s+on\\s+(.+)$"), new x42("^tap\\s+(.+)$"), new x42("^press\\s+the\\s+(.+)\\s+button$"));
        e = nz.h(new x42("^(?:type|enter|write|input)\\s+(.+)$"));
        f = new x42("\\b(swipe|slide|go|left|right|up|down|uupar|upar|neeche|niche|baayein|bayen|daayein|dayen)\\b", y42Var);
        g = nz.h(new x42("\\b(scroll down|scroll up|page down|page up)\\b"));
        h = nz.h(new x42("\\b(go back|press back|tap back|navigate back)\\b"));
        i = nz.h(new x42("\\b(go home|go to (?:the )?home screen|open (?:the )?home screen|take me to (?:the )?launcher|home screen)\\b"));
    }

    public static String d(String str) {
        String string = cs2.V(str).toString();
        for (String str2 : nz.i("on the ", "on that ", "on this ", "on ", "the ", "that ", "this ")) {
            if (js2.k(string, str2, false)) {
                string = cs2.V(cs2.G(string, str2)).toString();
                break;
            }
        }
        for (String str3 : nz.i(" button", " option", " icon", " link")) {
            if (js2.e(string, str3, false)) {
                string = cs2.V(cs2.I(string, str3)).toString();
            }
        }
        return cs2.V(string).toString();
    }

    @Override // defpackage.o21
    public final int a() {
        return 300;
    }

    @Override // defpackage.o21
    public final String b() {
        return "screen";
    }

    /* JADX WARN: Code duplicated, block: B:192:0x03dc  */
    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        String str;
        f5 f5VarD;
        String str2;
        String string;
        String str3;
        String strB;
        fh1 fh1VarA;
        i60Var.getClass();
        String str4 = b63Var.c;
        x42 x42Var = je2.a;
        f5 f5VarA = k24.a(b63Var);
        if (f5VarA != null) {
            return f5VarA;
        }
        x42 x42Var2 = yb2.a;
        f5 f5VarB = xz3.b(b63Var);
        if (f5VarB != null) {
            return f5VarB;
        }
        x42 x42Var3 = bi1.a;
        f5 f5VarA2 = fr4.a(b63Var);
        if (f5VarA2 != null) {
            return f5VarA2;
        }
        if (yc3.m(str4)) {
            Map mapSingletonMap = Collections.singletonMap("target", "close ad");
            mapSingletonMap.getClass();
            return dp4.d(b63Var, "screen.click", mapSingletonMap, 0.99f, 8);
        }
        String str5 = b63Var.a;
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str5.toLowerCase(locale);
        lowerCase.getClass();
        String string2 = cs2.V(lowerCase).toString();
        boolean z = cs2.n(string2, "?", false) || js2.k(string2, "do you", false) || js2.k(string2, "did you", false) || js2.k(string2, "can you tell me", false);
        boolean z2 = cs2.n(string2, "don't", false) || cs2.n(string2, "dont", false) || cs2.n(string2, "do not", false);
        if (!z && !z2 && (fh1VarA = b63Var.a(a)) != null) {
            x42 x42Var4 = ie2.a;
            if (ie2.f((String) ((dh1) fh1VarA.a()).get(1))) {
                Map mapSingletonMap2 = Collections.singletonMap("target", cs2.V((String) ((dh1) fh1VarA.a()).get(1)).toString());
                mapSingletonMap2.getClass();
                return dp4.d(b63Var, "screen.click", mapSingletonMap2, 0.0f, 12);
            }
        }
        if (!z && !z2) {
            if (wh2.c("skip ad", "skip the ad", "click skip ad", "click skip the ad", "click on skip ad", "click on skip the ad", "ad skip", "skip ads").contains(string2) || (cs2.n(string2, "skip", false) && cs2.n(string2, "ad", false) && !cs2.n(string2, "video", false))) {
                Map mapSingletonMap3 = Collections.singletonMap("target", "Skip ad");
                mapSingletonMap3.getClass();
                return dp4.d(b63Var, "youtube.skip_ad", mapSingletonMap3, 0.99f, 8);
            }
            boolean z3 = cs2.n(string2, "subscribe", false) && !cs2.n(string2, "unsubscribe", false);
            boolean z4 = cs2.n(string2, "dislike", false) || cs2.n(string2, "naapasand", false) || cs2.n(string2, "na pasand", false);
            boolean z5 = ((!cs2.n(string2, "like", false) && !cs2.n(string2, "thumbs up", false) && !cs2.n(string2, "pasand", false)) || z4 || z3) ? false : true;
            if (z3 && (cs2.n(string2, "channel", false) || cs2.n(string2, "subscribe", false) || cs2.n(string2, "karo", false) || cs2.n(string2, "do", false))) {
                Map mapSingletonMap4 = Collections.singletonMap("target", "Subscribe");
                mapSingletonMap4.getClass();
                return dp4.d(b63Var, "youtube.subscribe", mapSingletonMap4, 0.99f, 8);
            }
            if (z4) {
                Map mapSingletonMap5 = Collections.singletonMap("target", "Dislike");
                mapSingletonMap5.getClass();
                return dp4.d(b63Var, "youtube.dislike", mapSingletonMap5, 0.99f, 8);
            }
            if (z5 && (cs2.n(string2, "video", false) || cs2.n(string2, "button", false) || cs2.n(string2, "icon", false) || cs2.n(string2, "like", false) || cs2.n(string2, "kar", false))) {
                Map mapSingletonMap6 = Collections.singletonMap("target", "Like");
                mapSingletonMap6.getClass();
                return dp4.d(b63Var, "youtube.like", mapSingletonMap6, 0.99f, 8);
            }
        }
        Pattern patternCompile = Pattern.compile("^(?:deep\\s+analy[sz]e|analy[sz]e\\s+(?:the\\s+)?screen\\s+deeply)\\s+(?:and\\s+)?(.+)$", 66);
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str4);
        matcher.getClass();
        fh1 fh1Var = !matcher.matches() ? null : new fh1(matcher, str4);
        if (fh1Var != null && yc3.m((String) ((dh1) fh1Var.a()).get(1))) {
            Map mapSingletonMap7 = Collections.singletonMap("target", "close ad");
            mapSingletonMap7.getClass();
            return dp4.d(b63Var, "screen.deep_analyze", mapSingletonMap7, 0.99f, 8);
        }
        Pattern patternCompile2 = Pattern.compile("^(?:deep\\s+analy[sz]e|analy[sz]e\\s+(?:the\\s+)?screen\\s+deeply)\\s+(?:and\\s+)?(?:click|tap|press|select)\\s+(.+)$", 66);
        patternCompile2.getClass();
        Matcher matcher2 = patternCompile2.matcher(str4);
        matcher2.getClass();
        fh1 fh1VarA2 = ty3.a(matcher2, 0, str4);
        if (fh1VarA2 != null) {
            Map mapSingletonMap8 = Collections.singletonMap("target", d(dp4.b((String) ((dh1) fh1VarA2.a()).get(1))));
            mapSingletonMap8.getClass();
            return dp4.d(b63Var, "screen.deep_analyze", mapSingletonMap8, 0.99f, 8);
        }
        Pattern patternCompile3 = Pattern.compile("^(?:deep\\s+analy[sz]e|analy[sz]e\\s+(?:the\\s+)?screen\\s+deeply)\\s+(.+)$", 66);
        patternCompile3.getClass();
        Matcher matcher3 = patternCompile3.matcher(str4);
        matcher3.getClass();
        fh1 fh1Var2 = !matcher3.matches() ? null : new fh1(matcher3, str4);
        if (fh1Var2 != null) {
            List list = dc2.e;
            if (yz3.b((String) ((dh1) fh1Var2.a()).get(1)) != null) {
                Map mapSingletonMap9 = Collections.singletonMap("target", ((dh1) fh1Var2.a()).get(1));
                mapSingletonMap9.getClass();
                return dp4.d(b63Var, "screen.deep_analyze", mapSingletonMap9, 0.0f, 12);
            }
        }
        List list2 = b;
        if (list2 == null || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((x42) it.next()).a(str4)) {
                    return dp4.d(b63Var, "screen.deep_analyze", null, 0.99f, 10);
                }
            }
        }
        Pattern patternCompile4 = Pattern.compile("^(?:read|check|look at)\\s+(?:the\\s+)?screen\\s+and\\s+(?:click|tap|press|select)\\s+(.+)$");
        patternCompile4.getClass();
        Matcher matcher4 = patternCompile4.matcher(str4);
        matcher4.getClass();
        fh1 fh1VarA3 = ty3.a(matcher4, 0, str4);
        if (fh1VarA3 != null) {
            return dp4.d(b63Var, "screen.click", bh1.c(new wt1("target", d((String) ((dh1) fh1VarA3.a()).get(1))), new wt1("summarise_first", "true")), 0.9f, 8);
        }
        List list3 = c;
        if (list3 == null || !list3.isEmpty()) {
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                if (((x42) it2.next()).a(str4)) {
                    return dp4.d(b63Var, "screen.read", null, 0.99f, 10);
                }
            }
        }
        Iterator it3 = d.iterator();
        while (it3.hasNext()) {
            fh1 fh1VarA4 = b63Var.a((x42) it3.next());
            if (fh1VarA4 != null && (str3 = (String) mz.z(1, fh1VarA4.a())) != null && (strB = dp4.b(str3)) != null) {
                String strD = d(strB);
                if (!cs2.A(strD)) {
                    Map mapSingletonMap10 = Collections.singletonMap("target", strD);
                    mapSingletonMap10.getClass();
                    return dp4.d(b63Var, "screen.click", mapSingletonMap10, 0.9f, 8);
                }
            }
        }
        Iterator it4 = e.iterator();
        while (it4.hasNext()) {
            fh1 fh1VarA5 = b63Var.a((x42) it4.next());
            if (fh1VarA5 != null && (str2 = (String) mz.z(1, fh1VarA5.a())) != null && (string = cs2.V(str2).toString()) != null && !cs2.A(string)) {
                Map mapSingletonMap11 = Collections.singletonMap("text", string);
                mapSingletonMap11.getClass();
                return dp4.d(b63Var, "screen.type", mapSingletonMap11, 0.9f, 8);
            }
        }
        if (f.a(str4)) {
            if (cs2.n(str4, "up", false) || cs2.n(str4, "uupar", false) || cs2.n(str4, "upar", false)) {
                str = "UP";
            } else if (cs2.n(str4, "down", false) || cs2.n(str4, "neeche", false) || cs2.n(str4, "niche", false)) {
                str = "DOWN";
            } else if (cs2.n(str4, "left", false) || cs2.n(str4, "baayein", false) || cs2.n(str4, "bayen", false) || cs2.n(str4, "baye", false)) {
                str = "LEFT";
            } else if (cs2.n(str4, "right", false) || cs2.n(str4, "daayein", false) || cs2.n(str4, "dayen", false) || cs2.n(str4, "daye", false)) {
                str = "RIGHT";
            } else {
                f5VarD = null;
            }
            Map mapSingletonMap12 = Collections.singletonMap("direction", str);
            mapSingletonMap12.getClass();
            f5VarD = dp4.d(b63Var, "screen.swipe", mapSingletonMap12, 0.99f, 8);
        } else {
            f5VarD = null;
        }
        if (f5VarD != null) {
            return f5VarD;
        }
        Iterator it5 = g.iterator();
        while (it5.hasNext()) {
            if (b63Var.a((x42) it5.next()) != null) {
                Map mapSingletonMap13 = Collections.singletonMap("direction", cs2.n(str4, "up", false) ? "UP" : "DOWN");
                mapSingletonMap13.getClass();
                return dp4.d(b63Var, "screen.scroll", mapSingletonMap13, 0.99f, 8);
            }
        }
        List list4 = h;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it6 = list4.iterator();
            while (it6.hasNext()) {
                if (((x42) it6.next()).a(str4)) {
                    return dp4.d(b63Var, "screen.back", null, 0.99f, 10);
                }
            }
        }
        List list5 = i;
        if (list5 == null || !list5.isEmpty()) {
            Iterator it7 = list5.iterator();
            while (it7.hasNext()) {
                if (((x42) it7.next()).a(str4)) {
                    return dp4.d(b63Var, "screen.home", null, 0.99f, 10);
                }
            }
        }
        return null;
    }
}
