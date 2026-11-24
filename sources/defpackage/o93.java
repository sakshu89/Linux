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
public final class o93 implements o21 {
    public static final x42 a = new x42("\\b((?:https?://)?(?:www\\.)?[a-z0-9][a-z0-9-]*(?:\\.[a-z0-9-]+)*\\.(?:com|net|org|in|io|co|dev|me|app|gov|edu|ai|tv|info|xyz|uk|us|de|jp)(?:/[^\\s]*)?)\\b", y42.IGNORE_CASE);
    public static final List b = nz.i(new x42("^(?:search|find|look\\s+up|show\\s+me)\\s+(?:for\\s+)?(.+?)\\s+on\\s+youtube$"), new x42("^(?:search|open)\\s+youtube\\s+(?:for\\s+)?(.+)$"), new x42("^youtube\\s+(?:search\\s+)?(.+)$"), new x42("^(?:find|show)\\s+(?:me\\s+)?(?:a\\s+)?(?:youtube\\s+)?video\\s+(?:of|about|on)\\s+(.+)$"));
    public static final List c = nz.i(new x42("^(?:search|find)\\s+(?:for\\s+)?(.+?)\\s+on\\s+youtube\\s+and\\s+(?:click|play|open)\\s+(?:on\\s+)?(?:the\\s+)?first\\s+(?:video|result)$"), new x42("^play\\s+(.+?)\\s+on\\s+youtube$"), new x42("^play\\s+(?:the\\s+)?(.+?)\\s+video$"), new x42("^open\\s+(.+?)\\s+channel\\s+on\\s+youtube$"), new x42("^(?:open\\s+youtube\\s+)?search\\s+for\\s+(.+?)\\s+and\\s+play(?:\\s+the\\s+first\\s+video)?$"), new x42("^(?:open\\s+youtube\\s+)?play\\s+(?:the\\s+)?first\\s+video\\s+of\\s+(.+)$"), new x42("(?:youtube|yu tube)\\s+(?:par|pe)\\s+(.+?)\\s+(?:chalao|dikhao|play\\s+karo)$"));
    public static final List d = nz.i(new x42("^(?:search|google|look\\s+up)\\s+(?:for\\s+)?(.+?)\\s+on\\s+(?:google|the\\s+web|the\\s+internet|internet)$"), new x42("^google\\s+(.+)$"), new x42("^(?:search|look\\s+up)\\s+(?:for\\s+)?(.+)$"), new x42("^(?:search\\s+)?the\\s+web\\s+for\\s+(.+)$"));

    @Override // defpackage.o21
    public final int a() {
        return 200;
    }

    @Override // defpackage.o21
    public final String b() {
        return "web";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        String str;
        String strB;
        String str2;
        String strB2;
        String str3;
        String strB3;
        i60Var.getClass();
        x42 x42Var = yb2.a;
        if (xz3.b(b63Var) == null) {
            x42 x42Var2 = nk0.a;
            f5 f5VarW = y74.w(b63Var);
            if (f5VarW != null) {
                return f5VarW;
            }
            String str4 = b63Var.c;
            Pattern patternCompile = Pattern.compile("^(?:now\\s+)?(?:search|find)\\s+(?:for\\s+)?(.+?)\\s+on\\s+youtube\\s+and\\s+(?:click|play|open)\\s+(?:on\\s+)?(?:the\\s+)?(first|second|third|fourth|fifth|[1-9])(?:\\s+(?:video|result))?$");
            patternCompile.getClass();
            str4.getClass();
            Matcher matcher = patternCompile.matcher(str4);
            matcher.getClass();
            fh1 fh1Var = !matcher.matches() ? null : new fh1(matcher, str4);
            Map mapSingletonMap = ji0.a;
            if (fh1Var != null) {
                String str5 = (String) ((dh1) fh1Var.a()).get(2);
                Integer numM = js2.m(str5);
                int iIntValue = numM != null ? numM.intValue() : nz.i("first", "second", "third", "fourth", "fifth").indexOf(str5) + 1;
                Map mapC = bh1.c(new wt1("query", ((dh1) fh1Var.a()).get(1)), new wt1("video_position", String.valueOf(iIntValue)));
                if (iIntValue == 1) {
                    mapSingletonMap = Collections.singletonMap("select_first_result", "true");
                    mapSingletonMap.getClass();
                }
                return dp4.d(b63Var, "youtube.play", bh1.e(mapC, mapSingletonMap), 0.9f, 8);
            }
            fh1 fh1VarB = x42.b(a, b63Var.a);
            if (fh1VarB != null) {
                Map mapSingletonMap2 = Collections.singletonMap("url", (String) ((dh1) fh1VarB.a()).get(1));
                mapSingletonMap2.getClass();
                return dp4.d(b63Var, "web.open", mapSingletonMap2, 0.99f, 8);
            }
            Iterator it = c.iterator();
            while (it.hasNext()) {
                fh1 fh1VarA = b63Var.a((x42) it.next());
                if (fh1VarA != null && (str3 = (String) ((dh1) fh1VarA.a()).get(1)) != null && (strB3 = dp4.b(str3)) != null && !cs2.A(strB3)) {
                    Map mapSingletonMap3 = Collections.singletonMap("query", strB3);
                    mapSingletonMap3.getClass();
                    if (cs2.n(str4, "first video", false) || cs2.n(str4, "first result", false) || js2.e(str4, "the first", false)) {
                        mapSingletonMap = Collections.singletonMap("select_first_result", "true");
                        mapSingletonMap.getClass();
                    }
                    return dp4.d(b63Var, "youtube.play", bh1.e(mapSingletonMap3, mapSingletonMap), 0.9f, 8);
                }
            }
            Iterator it2 = b.iterator();
            while (it2.hasNext()) {
                fh1 fh1VarA2 = b63Var.a((x42) it2.next());
                if (fh1VarA2 != null && (str2 = (String) ((dh1) fh1VarA2.a()).get(1)) != null && (strB2 = dp4.b(str2)) != null && !cs2.A(strB2)) {
                    String string = cs2.V(strB2).toString();
                    Locale locale = Locale.ROOT;
                    if (!wh2.c("open", "open kar", "open karo", "open kar do", "kholo", "khol", "chalu", "chalu kar", "chalu karo", "launch", "open app", "app open").contains(cq.o(locale, string, locale))) {
                        Map mapSingletonMap4 = Collections.singletonMap("query", strB2);
                        mapSingletonMap4.getClass();
                        return dp4.d(b63Var, "youtube.search", mapSingletonMap4, 0.9f, 8);
                    }
                }
            }
            Iterator it3 = d.iterator();
            while (it3.hasNext()) {
                fh1 fh1VarA3 = b63Var.a((x42) it3.next());
                if (fh1VarA3 != null && (str = (String) ((dh1) fh1VarA3.a()).get(1)) != null && (strB = dp4.b(str)) != null && !cs2.A(strB)) {
                    Map mapSingletonMap5 = Collections.singletonMap("query", strB);
                    mapSingletonMap5.getClass();
                    return dp4.d(b63Var, "web.search", mapSingletonMap5, 0.9f, 8);
                }
            }
        }
        return null;
    }
}
